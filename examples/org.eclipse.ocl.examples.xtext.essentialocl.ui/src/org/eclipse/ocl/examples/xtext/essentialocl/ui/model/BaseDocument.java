/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.ui.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.plugin.OCLExamplesCommonPlugin;
import org.eclipse.ocl.examples.pivot.context.EInvocationContext;
import org.eclipse.ocl.examples.pivot.context.EObjectContext;
import org.eclipse.ocl.examples.pivot.manager.AbstractMetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.attributes.RootCSAttribution;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

public class BaseDocument extends XtextDocument implements ConsoleContext
{
	@Inject
	public BaseDocument(DocumentTokenSource tokenSource, ITextEditComposer composer) {
		super(tokenSource, composer);
	}

	private @Nullable EObject context;
    private @Nullable Map<String, EClassifier> parameters;

	/**
	 * @since 3.5
	 */
	protected void checkForErrors(Resource resource) throws CoreException {
		List<Resource.Diagnostic> errors = resource.getErrors();
		if (errors.size() > 0) {
			StringBuilder s = new StringBuilder();
			for (Resource.Diagnostic diagnostic : errors) {
				s.append("\n");
				if (diagnostic instanceof XtextSyntaxDiagnostic) {
					s.append("Syntax error: ");
					String location = diagnostic.getLocation();
					if (location != null) {
						s.append(location);
						s.append(":");
					}
					s.append(diagnostic.getLine());
					s.append(" ");
					s.append(diagnostic.getMessage());
				}
				else {
					s.append(diagnostic.toString());
				}
			}
			throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, s.toString()));
		}
	}

	@Override
	public void disposeInput() {
		MetaModelManager metaModelManager = readOnly(new IUnitOfWork<MetaModelManager, XtextResource>()
			{
				public MetaModelManager exec(@Nullable XtextResource resource) throws Exception {
					if (resource != null) {
						AbstractMetaModelManagerResourceAdapter<?> adapter = MetaModelManagerResourceAdapter.findAdapter(resource);
						if (adapter != null) {
							return adapter.getMetaModelManager();
						}
					}
					return null;
				}
			});
		if (metaModelManager != null) {
			metaModelManager.dispose();
		}
		super.disposeInput();
	}

	protected RootCSAttribution getDocumentAttribution() {
		return readOnly(new IUnitOfWork<RootCSAttribution, XtextResource>()
			{
				public RootCSAttribution exec(@Nullable XtextResource resource) throws Exception {
					if ((resource != null) && !resource.getContents().isEmpty()) {
						ElementCS csElement = (ElementCS) resource.getContents().get(0);
						if (csElement != null) {
							@SuppressWarnings("unused")
							Attribution attribution = PivotUtil.getAttribution(csElement);
//							if (attribution != null) {
								return ElementUtil.getDocumentAttribution(csElement);
//							}
						}
					}
					return null;
				}
			});
	}

    public @Nullable EObject getOCLContext() {
        return context;
    }

    public @Nullable Map<String, EClassifier> getOCLParameters() {
		return parameters;
	}

	/**
	 * @since 3.5
	 */
	public @Nullable ASResource getPivotResource() throws CoreException {
		return readOnly(new IUnitOfWork<ASResource, XtextResource>()
			{
				public ASResource exec(@Nullable XtextResource resource) throws Exception {
					if (!(resource instanceof BaseCSResource)) {
						return null;
					}
					BaseCSResource csResource = (BaseCSResource)resource;
					CS2PivotResourceAdapter adapter = csResource.findCS2ASAdapter();
					if (adapter == null) {
						return null;
					}
					ASResource asResource = adapter.getASResource(csResource);
					checkForErrors(asResource);
					return asResource;
				}
			});
	}

	public @Nullable ResourceSet getResourceSet() {
		return readOnly(new IUnitOfWork<ResourceSet, XtextResource>()
			{
				public ResourceSet exec(@Nullable XtextResource resource) throws Exception {
					return resource != null ? resource.getResourceSet() : null;
				}
			});
	}

/*	@Override
	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		if (myStateAccess.isWriteLocked()) {
//			CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".readOnly skip " + work.getClass().getName(), false, 0);
			Class<?> workClass = work.getClass();
			String workClassName = workClass.getName();
			if (workClassName.startsWith("org.eclipse.xtext.ui.editor.hover.AbstractEObjectHover")) {
				return null;
			}
			if (workClassName.startsWith("org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode")) {
				return null;
			}
			if (workClassName.startsWith("org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider")) {
				throw new OperationCanceledException();
			}
			if (workClassName.equals("org.eclipse.xtext.ui.editor.contentassist.CompletionProposalComputer")) {
				throw new OperationCanceledException();
			}
			if (workClassName.startsWith("org.eclipse.xtext.ui.editor.validation.ValidationJob")) {
				throw new OperationCanceledException();
			}
			return null;
		}
//		CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".readOnly start " + work.getClass().getName(), false, +1);
		try {
  			System.out.println(Thread.currentThread().getName() + " readOnly "  + work.getClass().getName() + " start for " + PivotUtil.debugSimpleName(lastInput));
			return super.readOnly(work);
		}
		finally {
			System.out.println(Thread.currentThread().getName() + " readOnly "  + work.getClass().getName() + " end for " + PivotUtil.debugSimpleName(lastInput));
//			CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".readOnly end " + work.getClass().getName(), false, -1);
		} 
	} */

/*	@Override
	public <T> T modify(IUnitOfWork<T, XtextResource> work) {
		CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".modify start " + work.getClass().getName(), false, +1);
		try {
			return super.modify(work);
		}
		finally {
			CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".modify end " + work.getClass().getName(), false, -1);
		}
	} */

/*	@Override
	public <T> T internalModify(IUnitOfWork<T, XtextResource> work) {
		if (myStateAccess.isWriteLocked()) {
			CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".internalModify skip " + work.getClass().getName(), false, 0);
			Class<?> workClass = work.getClass();
			String workClassName = workClass.getName();
			if (workClassName.equals("org.eclipse.xtext.ui.editor.reconciler.XtextReconcilerUnitOfWork")) {
//				throw new OperationCanceledException();
			}
//			return null;
		}
		CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".internalModify start " + work.getClass().getName(), false, +1);
		try {
			System.out.println(Thread.currentThread().getName() + " internalModify "  + work.getClass().getName() + " start for " + PivotUtil.debugSimpleName(lastInput));
			return super.internalModify(work);
		}
		finally {
			System.out.println(Thread.currentThread().getName() + " internalModify "  + work.getClass().getName() + " end for " + PivotUtil.debugSimpleName(lastInput));
//			CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".internalModify end " + work.getClass().getName(), false, -1);
		}
	} */

	/**
	 * Write the XMI representation of the Pivot to be saved.
	 * @since 3.5
	 */
	public void saveAsPivot(@NonNull StringWriter writer) throws CoreException, IOException {
		XMLResource asResource = getPivotResource();
		if (asResource != null) {
			asResource.save(writer, null);
		}
	}

	public void setContext(final @NonNull EClassifier ecoreContext, final @Nullable Map<String, EClassifier> ecoreParameters) {
		modify(new IUnitOfWork<Object, XtextResource>()
		{
			public Object exec(@Nullable XtextResource resource) throws Exception {
				if (resource instanceof EssentialOCLCSResource) {
					return setContext((EssentialOCLCSResource) resource, ecoreContext, ecoreParameters);
				}
				else {
					return null;
				}
			}
		});

        this.context = ecoreContext;
        this.parameters = ecoreParameters;
    }

	@Deprecated
	public @Nullable Object setContext(@NonNull EssentialOCLCSResource resource, @Nullable EClassifier ecoreContext, @Nullable Map<String, EClassifier> ecoreParameters) {
		CS2PivotResourceAdapter csAdapter = resource.getCS2ASAdapter(null);
		MetaModelManager metaModelManager = csAdapter.getMetaModelManager();
		resource.setParserContext(new EInvocationContext(metaModelManager, resource.getURI(), ecoreContext, ecoreParameters));
		return null;
	}

	public @Nullable Object setContext(@NonNull EssentialOCLCSResource resource, @Nullable EObject eObject) {
		CS2PivotResourceAdapter csAdapter = resource.getCS2ASAdapter(null);
		MetaModelManager metaModelManager = csAdapter.getMetaModelManager();
		resource.setParserContext(new EObjectContext(metaModelManager, resource.getURI(), eObject));
		return null;
	}
}
