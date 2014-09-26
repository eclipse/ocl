/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.ui.delegate;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
//import org.eclipse.core.filesystem.EFS;
//import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ocl.examples.debug.launching.OCLLaunchConstants;
import org.eclipse.ocl.examples.debug.ui.OCLDebugUIPlugin;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.delegate.OCLSettingDelegate;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2ASResourceAdapter;
import org.eclipse.ocl.examples.xtext.base.utilities.CSI2ASMapping;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;

/**
 * An implementation of a setting delegate that computes OCL derived features.
 */
public class OCLDebugSettingDelegate extends OCLSettingDelegate
{
    /**
     * The DebugStarter sequences the start up of the debugger off the thread.
     */
    protected static class DebugStarter implements IRunnableWithProgress
	{
		protected final @NonNull Display display;
    	protected final @NonNull MetaModelManager metaModelManager;
    	protected final @Nullable Object contextObject;
    	protected final @NonNull ExpressionInOCL constraint;
    	private @Nullable ILaunch launch = null;

		public DebugStarter(@NonNull Display display, @NonNull MetaModelManager metaModelManager, @Nullable Object contextObject, @NonNull ExpressionInOCL constraint) {
			this.display = display;
			this.metaModelManager = metaModelManager;
			this.contextObject = contextObject;
			this.constraint = constraint;
		}
		
		public ILaunch getLaunch() {
			return launch;
		}

		/**
		 * Create and launch an internal launch configuration to debug expressionInOCL applied to contextObject.
		 */
		protected ILaunch launchDebugger(IProgressMonitor monitor, @Nullable Object contextObject, @NonNull ExpressionInOCL expressionInOCL) throws CoreException {
			ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(OCLLaunchConstants.LAUNCH_CONFIGURATION_TYPE_ID);
			ILaunchConfigurationWorkingCopy launchConfiguration = launchConfigurationType.newInstance(null, "test" /*constraint.getName()*/);
			Map<String,Object> attributes = new HashMap<String,Object>();
			attributes.put(OCLLaunchConstants.EXPRESSION_OBJECT, expressionInOCL);
			attributes.put(OCLLaunchConstants.CONTEXT_OBJECT, contextObject);
			launchConfiguration.setAttributes(attributes);
			return launchConfiguration.launch(ILaunchManager.DEBUG_MODE, monitor);
		}

		protected void openError(final String message, final @NonNull Exception e) {
			display.asyncExec(new Runnable()
			{
				@Override
				public void run() {
					IStatus status = new Status(IStatus.ERROR, OCLDebugUIPlugin.PLUGIN_ID, e.getLocalizedMessage(), e);
					ErrorDialog.openError(display.getActiveShell(), "ConsoleMessages.Debug_Starter", message, status);
				}
			});
		}

		@Override
		public void run(IProgressMonitor monitor) {
			String expression = constraint.toString();
			monitor.beginTask(NLS.bind("ConsoleMessages.Debug_Starter", expression), 1);
			try {
				monitor.subTask("ConsoleMessages.Debug_ProgressLoad");
				try {
					launch = launchDebugger(monitor, contextObject, constraint);
				} catch (CoreException e) {
					openError("ConsoleMessages.Debug_FailLaunch", e);
				}
				monitor.worked(1);
			}
			finally {
				monitor.done();
			}
		}
	}
    
	public OCLDebugSettingDelegate(@NonNull OCLDelegateDomain delegateDomain, @NonNull EStructuralFeature structuralFeature) {
		super(delegateDomain, structuralFeature);
	}

	/**
	 * Create a test Complete OCL document that wraps the required OCL text up as the body of a test operation.
	 * Returns its URI.
	 */
	protected @NonNull URI createDocument(@NonNull ASResource asResource, @Nullable IProgressMonitor monitor) throws IOException, CoreException {
		MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(asResource);
		URI ecoreURI = asResource.getURI().trimFileExtension();	// Lose .ecore.oclas
		URI csURI = ecoreURI.trimFileExtension().appendFileExtension("oclinecore");
		BaseCSResource csResource = (BaseCSResource) metaModelManager.getExternalResourceSet().createResource(csURI, OCLinEcoreCSPackage.eCONTENT_TYPE);
		csResource.setURI(ecoreURI);
		csResource.updateFrom((ASResource)asResource, metaModelManager);
		CSI2ASMapping cs2asMapping = CSI2ASMapping.getAdapter(metaModelManager);
		Map<BaseCSResource, ASResource> map = new HashMap<BaseCSResource, ASResource>();
		map.put(csResource, asResource);
		cs2asMapping.add(map);
		
		IPath documentPath = OCLDebugUIPlugin.getDefault().getStateLocation().append("debug" + EcoreUtil.generateUUID() + ".oclinecore");
		IFileStore documentStore = EFS.getLocalFileSystem().getStore(documentPath);
		OutputStream documentStream = documentStore.openOutputStream(0, monitor);
		Map<?,?> options = new HashMap<Object, Object>();
		csResource.save(documentStream, options);
		documentStream.close();
		
		java.net.URI documentURI1 = documentStore.toURI();
		@SuppressWarnings("null")@NonNull URI documentURI2 = URI.createURI(documentURI1.toString());
		csResource.setURI(documentURI2);
//		csResource.unload();
		CS2ASResourceAdapter adapter = csResource.getCS2ASAdapter(metaModelManager);
		CS2AS converter = adapter.getConverter();
		converter.update(new ListBasedDiagnosticConsumer());
		return documentURI2;
		
		
/*		csResource.updateFrom((ASResource)asResource, metaModelManager);
		CSI2ASMapping cs2asMapping = CSI2ASMapping.getAdapter(metaModelManager);
		Map<BaseCSResource, ASResource> map = new HashMap<BaseCSResource, ASResource>();
		map.put(csResource, asResource);
		cs2asMapping.add(map);
		
		
		
		
		
		
		PivotIdResolver idResolver = metaModelManager.getIdResolver();
		DomainClass staticType = idResolver.getStaticTypeOf(contextObject);
		org.eclipse.ocl.examples.pivot.Class contextType = metaModelManager.getType(staticType);
//		if (contextType instanceof Metaclass) {
//			contextType = (org.eclipse.ocl.examples.pivot.Class)((Metaclass<?>)contextType).getInstanceType();	// FIXME cast
//		}
		org.eclipse.ocl.examples.pivot.Package contextPackage = contextType.getOwningPackage();
		OutputStream documentStream = documentStore.openOutputStream(0, monitor);
		PrettyPrintOptions.Global printOptions = PrettyPrinter.createOptions(null);
		printOptions.addReservedNames(PrettyPrinter.restrictedNameList);
		Writer s = new OutputStreamWriter(documentStream);
		String externalURI = null;
		if (contextPackage != null) {
			Model containingRoot = PivotUtil.getContainingRoot(contextPackage);
			if (containingRoot == null) {
				externalURI = contextPackage.getURI();
			}
			else if (containingRoot != PivotUtil.getContainingRoot(metaModelManager.getStandardLibrary().getOclAnyType())) {
				externalURI = containingRoot.getExternalURI();
				if (PivotUtil.isASURI(externalURI)) {
					@SuppressWarnings("null")
					@NonNull URI uri = URI.createURI(externalURI);
					externalURI = PivotUtil.getNonASURI(uri).toString();
				}
			}
			if (externalURI != null) {
				s.append("import '" + externalURI + "'\n\n");
			}
		}
		s.append("context ");
		if (externalURI == null) {
			s.append("ocl::");			// FIXME use printOptions, FIXME support UML non-OCL classes
		}
		s.append(PrettyPrinter.printName(contextType, printOptions) + "\n");
		s.append("def: oclDebuggerExpression() : OclAny = \n\t");
		s.append(expression.replace("\n", "\n\t"));
		s.append("\n");
		s.close();
		java.net.URI documentURI1 = documentStore.toURI();
		@SuppressWarnings("null")@NonNull URI documentURI2 = URI.createURI(documentURI1.toString());
		return documentURI2; */
	}

	@Override
	protected @Nullable Object evaluate(@NonNull OCL ocl, @NonNull ExpressionInOCL query, @Nullable Object contextObject) {
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		@SuppressWarnings("null")@NonNull Display display = Display.getCurrent();
		DebugStarter runnable = new DebugStarter(display, metaModelManager, contextObject, query);
		runnable.run(new NullProgressMonitor());
		ILaunch launch = runnable.getLaunch();
		if (launch != null) {
			try {
				waitForLaunchToTerminate(launch);
//				launch.
			} catch (DebugException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return launch != null;
	}

	public static void flushEvents() {
		for (int i = 0; i < 10; i++) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			while (workbench.getDisplay().readAndDispatch());
		}
	}
	
	@Override
	protected Object get(InternalEObject owner, boolean resolve, boolean coreType) {
		Property property2 = getProperty();
		Resource eResource = property2.eResource();
		if (eResource instanceof ASResource) {
			ASResource asResource = (ASResource) eResource;
			ResourceSet resourceSet = asResource.getResourceSet();
			if (resourceSet != null) {
				CS2AS cs2as = CS2AS.findAdapter(resourceSet);
				if (cs2as == null) {
					try {
						createDocument(asResource, null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
/*					MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(asResource);
					URI ecoreURI = asResource.getURI().trimFileExtension();	// Lose .ecore.oclas
					URI csURI = ecoreURI.trimFileExtension().appendFileExtension("oclinecore");
					BaseCSResource csResource = (BaseCSResource) resourceSet.createResource(csURI, OCLinEcoreCSPackage.eCONTENT_TYPE);
					csResource.setURI(ecoreURI);
					csResource.updateFrom((ASResource)asResource, metaModelManager);
					CSI2ASMapping cs2asMapping = CSI2ASMapping.getAdapter(metaModelManager);
					Map<BaseCSResource, ASResource> map = new HashMap<BaseCSResource, ASResource>();
					map.put(csResource, asResource);
					cs2asMapping.add(map); */
				}
			}
		}
		return super.get(owner, resolve, coreType);
	}

	protected void waitForLaunchToTerminate(@NonNull ILaunch launch) throws InterruptedException, DebugException {
		while (true) {
			for (int i = 0; i < 10; i++){
				flushEvents();
				Thread.sleep(100);
			}
			boolean allDead = true;
			for (IDebugTarget debugTarget : launch.getDebugTargets()) {
				IProcess process = debugTarget.getProcess();
				if (!process.isTerminated()) {
					allDead = false;
				}
				for (IThread debugThread : debugTarget.getThreads()) {
					if (!debugThread.isTerminated()) {
						allDead = false;
					}
				}
			}
			if (allDead) {
				break;
			}
		}
	}
}
