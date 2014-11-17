/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.oclinecore.ui.model;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.examples.common.plugin.OCLExamplesCommonPlugin;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.IProjectDescriptor;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.MapToFirstConflictHandlerWithLog;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.delegate.DelegateInstaller;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerListener;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.resource.OCLASResourceFactory;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.OCLinEcoreUiPluginHelper;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator.InvalidConcreteSyntaxException;

/**
 * OCLinEcoreDocumentProvider orchestrates the load and saving of optional XMI content
 * externally while maintaining the serialised human friendly form internally. 
 */
public class OCLinEcoreDocumentProvider extends XtextDocumentProvider implements MetaModelManagerListener
{
	private static final Logger log = Logger.getLogger(OCLinEcoreDocumentProvider.class);
	
	public static final String PERSIST_AS_ECORE = "as-ecore";
	public static final String PERSIST_IN_ECORE = "in-ecore";
	public static final String PERSIST_AS_PIVOT = "pivot";
	public static final String PERSIST_AS_OCLINECORE = "oclinecore";
	public static final String PERSIST_AS_UML = "uml";

	/**
	 * Representation used when loaded.
	 */
	private Map<IDocument,String> loadedAsMap = new HashMap<IDocument,String>();
	/**
	 * Delegate URI to be used when exporting, null for default.
	 */
	private Map<IDocument,String> exportDelegateURIMap = new HashMap<IDocument,String>();
	/**
	 * Representation to be used when saved.
	 */
	private Map<IDocument,String> saveAsMap = new HashMap<IDocument,String>();

	private Map<IDocument, URI> uriMap = new HashMap<IDocument, URI>();		// Helper for setDocumentContent
	
	private MetaModelManager metaModelManager = null;

	public static InputStream createResettableInputStream(InputStream inputStream) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			byte[] buffer = new byte[4096];
			int len;
			while ((len = inputStream.read(buffer, 0, buffer.length)) > 0) {
				outputStream.write(buffer, 0, len);
			}
		return new ByteArrayInputStream(outputStream.toByteArray());
		}
		finally {
			outputStream.close();
		}
	}

	protected void diagnoseErrors(XtextResource xtextResource, Exception e) throws CoreException {
		List<Diagnostic> diagnostics = xtextResource.validateConcreteSyntax();
		if (diagnostics.size() > 0) {
			StringBuilder s = new StringBuilder();
			s.append("Concrete Syntax validation failed");
			for (Diagnostic diagnostic : diagnostics) {
				s.append("\n");
				s.append(diagnostic.toString());
			}
			throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, s.toString(), e));
		}
		else {
			throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, "Failed to load", e));
		}
	}

	private void diagnoseErrors(Resource resource) throws CoreException {
		List<Resource.Diagnostic> errors = resource.getErrors();
		if (errors.size() > 0) {
			String formattedMessage = PivotUtil.formatResourceDiagnostics(errors, "Failed to load", "\n");
			throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, formattedMessage));
		}
	}

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
		String saveAs = saveAsMap.get(document);
		if ((element instanceof IFileEditorInput) && (document instanceof OCLinEcoreDocument) && !PERSIST_AS_OCLINECORE.equals(saveAs)) {
			StringWriter xmlWriter = new StringWriter();
			try {
				ASResource asResource = ((OCLinEcoreDocument) document).getPivotResource();
				URI savedURI = asResource != null ? asResource.getURI() : null;
				try {
					URI uri = EditUIUtil.getURI((IFileEditorInput)element);
					if (asResource != null) {
						EcoreUtil.resolveAll(asResource);
						asResource.setURI(uri);
					}
					if (uri == null) {
						log.warn("No URI");
					}
					else if (PERSIST_AS_ECORE.equals(saveAs)) {
						((OCLinEcoreDocument) document).saveAsEcore(xmlWriter, uri, exportDelegateURIMap.get(document));
					}
					else if (PERSIST_IN_ECORE.equals(saveAs)) {
						((OCLinEcoreDocument) document).saveInEcore(xmlWriter, uri, exportDelegateURIMap.get(document));
					}
					else if (PERSIST_AS_PIVOT.equals(saveAs)) {
						((OCLinEcoreDocument) document).saveAsPivot(xmlWriter);
					}
					else if (PERSIST_AS_UML.equals(saveAs)) {
						((OCLinEcoreDocument) document).saveAsUML(xmlWriter, uri);
					}
					else {
						log.warn("Unknown saveAs '" + saveAs + "'");
					}
				}
				finally {
					if ((asResource != null) && (savedURI != null)) {
						asResource.setURI(savedURI);;
					}
				}
				IDocument saveDocument = new Document();
				saveDocument.set(xmlWriter.toString());
				super.doSaveDocument(monitor, element, saveDocument, overwrite);
				loadedAsMap.put(document, saveAs);
			} catch (Exception e) {
				OCLinEcoreUiPluginHelper helper = OCLinEcoreUiPluginHelper.INSTANCE;
				String title = helper.getString("_UI_SaveFailure_title", true);
				String message = helper.getString("_UI_SaveFailure_message", true);
				ErrorDialog.openError(null, title, message, helper.createErrorStatus(e));
				monitor.setCanceled(true);				// Still dirty
			}
		}
		else {
			super.doSaveDocument(monitor, element, document, overwrite);
		}
	}
	
	@SuppressWarnings("null")
	protected @NonNull MetaModelManager getMetaModelManager() {
		if (metaModelManager == null) {
			metaModelManager = new MetaModelManager();
			metaModelManager.addListener(this);
		}
		return metaModelManager;
	}

//	@Deprecated
//	public ResourceSet getResourceSet() {
//		return ((OCLinEcoreResourceForEditorInputFactory) getResourceForEditorInputFactory()).getResourceSet();
//	}
	@Override
	protected void handleElementContentChanged(IFileEditorInput fileEditorInput) {
		FileInfo info= (FileInfo) getElementInfo(fileEditorInput);
		if (info == null)
			return;
		if (info.fDocument == null) {
			super.handleElementContentChanged(fileEditorInput);
		}
		IDocument document = info.fDocument;
		String oldContent= document.get();
		IStatus status= null;

		try {

			try {
				refreshFile(fileEditorInput.getFile());
			} catch (CoreException x) {
				handleCoreException(x, "FileDocumentProvider.handleElementContentChanged"); //$NON-NLS-1$
			}

			cacheEncodingState(fileEditorInput);
			setDocumentContent(document, fileEditorInput, info.fEncoding);

		} catch (CoreException x) {
			status= x.getStatus();
		}

		String newContent= document.get();

		if ( !newContent.equals(oldContent)) {

			// set the new content and fire content related events
			fireElementContentAboutToBeReplaced(fileEditorInput);

			removeUnchangedElementListeners(fileEditorInput, info);

			info.fDocument.removeDocumentListener(info);
			info.fDocument.set(newContent);
			info.fCanBeSaved= false;
			info.fModificationStamp= computeModificationStamp(fileEditorInput.getFile());
			info.fStatus= status;

			addUnchangedElementListeners(fileEditorInput, info);

			fireElementContentReplaced(fileEditorInput);

		} else {

			removeUnchangedElementListeners(fileEditorInput, info);

			// fires only the dirty state related event
			info.fCanBeSaved= false;
			info.fModificationStamp= computeModificationStamp(fileEditorInput.getFile());
			info.fStatus= status;

			addUnchangedElementListeners(fileEditorInput, info);

			fireElementDirtyStateChanged(fileEditorInput, false);
		}
	}

	@Override
	public boolean isDeleted(Object element) {
		IDocument document = getDocument(element);
		String loadIsEcore = loadedAsMap.get(document);
		String saveIsEcore = saveAsMap.get(document);
		if ((loadIsEcore != null) && !loadIsEcore.equals(saveIsEcore)) {
			return true;		// Causes Save to do SaveAs
		}
		return super.isDeleted(element);
	}

	protected boolean isXML(InputStream inputStream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		try {
			String line = reader.readLine();
			inputStream.reset();
			return (line != null) && line.startsWith("<?xml");
		}
		finally {
			reader.close();
		}
	}

	@Override
	protected void loadResource(XtextResource resource, String document, String encoding) throws CoreException {
		assert resource != null;
		MetaModelManagerResourceAdapter.getAdapter(resource, getMetaModelManager());
		super.loadResource(resource, document, encoding);
	}

	public void metaModelManagerDisposed(@NonNull MetaModelManager metaModelManager) {
		metaModelManager.removeListener(this);
		this.metaModelManager = null;
	}

	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput, String encoding) throws CoreException {
		URI uri = EditUIUtil.getURI(editorInput);
		uriMap.put(document, uri);
		return super.setDocumentContent(document, editorInput, encoding);
	}

	@Override
	protected void setDocumentContent(final IDocument document, InputStream inputStream, final String encoding) throws CoreException {
		boolean reload = false;
		try {
			if (!inputStream.markSupported()) {
				inputStream = createResettableInputStream(inputStream);
			}
			boolean isXML = isXML(inputStream);		
			String persistAs = PERSIST_AS_OCLINECORE;
			if (isXML) {
				ResourceSet resourceSet = getMetaModelManager().getExternalResourceSet();
				StandaloneProjectMap projectMap = ProjectMap.getAdapter(resourceSet);
				StandaloneProjectMap.IConflictHandler conflictHandler = MapToFirstConflictHandlerWithLog.INSTANCE; //null; 			// FIXME
				projectMap.configure(resourceSet, StandaloneProjectMap.LoadFirstStrategy.INSTANCE, conflictHandler);
				IProjectDescriptor pivotPackageDescriptor = projectMap.getProjectDescriptor(PivotConstants.PLUGIN_ID);
				if (pivotPackageDescriptor != null) {
					pivotPackageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadBothStrategy.INSTANCE, conflictHandler);	
				}
				URI uri = uriMap.get(document);
				XMLResource xmiResource = (XMLResource) resourceSet.getResource(uri, false);
				if ((xmiResource == null) || (xmiResource.getResourceSet() == null)) {	// Skip built-ins and try again as a file read.
					xmiResource = (XMLResource) resourceSet.createResource(uri, null);					
				}
				else {
					xmiResource.unload();
					reload = true;
				}
				xmiResource.load(inputStream, null);
				EcoreUtil.resolveAll(resourceSet);
				List<Resource.Diagnostic> allErrors = null;
				for (Resource resource : resourceSet.getResources()) {
					List<Resource.Diagnostic> errors = resource.getErrors();
					if (errors.size() > 0) {
						if (allErrors == null) {
							allErrors = new ArrayList<Resource.Diagnostic>();
						}
						allErrors.addAll(errors);
					}
				}
				if (allErrors != null) {
					StringBuilder s = new StringBuilder();
					for (Resource.Diagnostic diagnostic : allErrors) {
						s.append("\n");
						s.append(diagnostic.toString());
					}
					throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, s.toString()));
				}
				ASResource asResource = null;
				EList<EObject> contents = xmiResource.getContents();
				if (contents.size() > 0) {
					EObject xmiRoot = contents.get(0);
					if (xmiRoot instanceof EPackage) {
						Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(xmiResource, getMetaModelManager());
						Root pivotRoot = ecore2Pivot.getPivotRoot();
						asResource = (ASResource) pivotRoot.eResource();
						if (asResource != null) {
							if (reload) {
								ecore2Pivot.update(asResource, contents);
							}
							diagnoseErrors(asResource);		// FIXME On reload, this throws a CoreException which loses the user's source text
						}
						persistAs = PERSIST_AS_ECORE;
						exportDelegateURIMap.put(document, DelegateInstaller.getDelegateURI(contents));
					}
					else if (xmiRoot instanceof Root) {
						asResource = (ASResource) xmiResource;
						persistAs = PERSIST_AS_PIVOT;
					}
					else if (xmiRoot instanceof org.eclipse.uml2.uml.Package) {
						UML2Pivot uml2Pivot = UML2Pivot.getAdapter(xmiResource, getMetaModelManager());
						Root pivotRoot = uml2Pivot.getPivotRoot();
						asResource = (ASResource) pivotRoot.eResource();
						persistAs = PERSIST_AS_OCLINECORE;		// FIXME
					}
					// FIXME general extensibility
				}
				if (asResource == null) {
					throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, "Failed to load"));
				}
//				
				ResourceSetImpl csResourceSet = (ResourceSetImpl)resourceSet;
				csResourceSet.getPackageRegistry().put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
				URI oclinecoreURI = xmiResource.getURI().appendFileExtension("oclinecore");
				BaseResource csResource = (BaseResource) resourceSet.getResource(oclinecoreURI, false);
				if (csResource == null) {
					csResource = (BaseResource) resourceSet.createResource(oclinecoreURI, OCLinEcoreCSPackage.eCONTENT_TYPE);
				    Map<URI, Resource> map = csResourceSet.getURIResourceMap();
				    map.put(oclinecoreURI, csResource);
					csResource.setURI(xmiResource.getURI());
				}
				//
				//	ResourceSet contains
				//		Ecore XMI resource with *.ecore URI, possibly in URIResourceMap as *.ecore
				//		OCLinEcore CS resource with *.ecore URI, in URIResourceMap as *.ecore.oclinecore
				//
				csResource.updateFrom(asResource, getMetaModelManager());
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				try {
					csResource.save(outputStream, null);
				} catch (InvalidConcreteSyntaxException e) {
					diagnoseErrors((XtextResource) csResource, e);
				} catch (XtextSerializationException e) {
					diagnoseErrors((XtextResource) csResource, e);
				}
				csResource.unload();
				CS2PivotResourceAdapter resourceAdapter = ((BaseCSResource)csResource).getCS2ASAdapter(null);
				resourceAdapter.dispose();
				resourceSet.getResources().remove(csResource);
				inputStream = new ByteArrayInputStream(outputStream.toByteArray());
			}
			else if (inputStream.available() == 0) {		// Empty document
				URI uri = uriMap.get(document);
				Resource.Factory factory = Resource.Factory.Registry.INSTANCE.getFactory(uri);
				if (factory instanceof EcoreResourceFactoryImpl) {
					persistAs = PERSIST_AS_ECORE;
				}
				else if (factory instanceof OCLASResourceFactory) {
					persistAs = PERSIST_AS_PIVOT;
				}
//				else if (factory instanceof UMLResourceFactoryImpl) {
//					persistAs = PERSIST_AS_UML;
//				}
				String lastSegment = uri.trimFileExtension().lastSegment();
				if (lastSegment == null) {
					lastSegment = "Default";
				}
				String testDocument = 
						"package " + lastSegment + " : pfx = '"+ uri + "' {\n" +
						"}\n";
				inputStream = new ByteArrayInputStream(testDocument.getBytes());				
			}
			loadedAsMap.put(document, persistAs);
			saveAsMap.put(document, persistAs);
		} catch (ParserException e) {
			throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, "Failed to load", e));
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, "Failed to load", e));
		}
/*
 * 		This fails to setup Xtext correctly: No state leads to NPE from EcoreUtil.resolveAll.
 * 
  		if (reload) {		
			final InputStream finalInputStream = inputStream; 
			((XtextDocument)document).modify(new IUnitOfWork<Object, XtextResource>() {

				public Object exec(XtextResource state) throws Exception {
					OCLinEcoreDocumentProvider.super.setDocumentContent(document, finalInputStream, encoding);
					return null;
				}
			});
		}
		else { */
			super.setDocumentContent(document, inputStream, encoding);
//		}
	}

	public void setExportDelegateURI(Object element, String uri) {
		exportDelegateURIMap.put(getDocument(element), uri);
	}

	public void setPersistAs(Object element, String persistAs) {
		saveAsMap.put(getDocument(element), persistAs);
		setCanSaveDocument(element);
	}
}
