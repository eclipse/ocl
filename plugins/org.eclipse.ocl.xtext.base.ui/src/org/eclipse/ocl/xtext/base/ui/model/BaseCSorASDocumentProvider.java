/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.model;

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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.base.ui.BaseUiModule;
import org.eclipse.ocl.xtext.base.ui.BaseUiPluginHelper;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator.InvalidConcreteSyntaxException;

/**
 * QVTimperativeDocumentProvider orchestrates the load and saving of optional XMI content
 * externally while maintaining the serialised human friendly form internally. 
 */
public abstract class BaseCSorASDocumentProvider extends BaseDocumentProvider
{
	private static final Logger log = Logger.getLogger(BaseCSorASDocumentProvider.class);
	
	public static final String PERSIST_AS_PIVOT = "pivot";
	public static final String PERSIST_AS_TEXT = "text";

	/**
	 * Representation used when loaded.
	 */
	protected Map<IDocument,String> loadedAsMap = new HashMap<IDocument,String>();
	/**
	 * Delegate URI to be used when exporting, null for default.
	 */
	protected Map<IDocument,String> exportDelegateURIMap = new HashMap<IDocument,String>();
	/**
	 * Representation to be used when saved.
	 */
	protected Map<IDocument,String> saveAsMap = new HashMap<IDocument,String>();

	protected Map<IDocument, URI> uriMap = new HashMap<IDocument, URI>();		// Helper for setDocumentContent

	protected void diagnoseErrors(XtextResource xtextResource, Exception e) throws CoreException {
		List<Diagnostic> diagnostics = xtextResource.validateConcreteSyntax();
		if (diagnostics.size() > 0) {
			StringBuilder s = new StringBuilder();
			s.append("Concrete Syntax validation failed");
			for (Diagnostic diagnostic : diagnostics) {
				s.append("\n");
				s.append(diagnostic.toString());
			}
			throw new CoreException(new Status(IStatus.ERROR, BaseUiModule.PLUGIN_ID, s.toString(), e));
		}
		else {
			throw new CoreException(new Status(IStatus.ERROR, BaseUiModule.PLUGIN_ID, "Failed to load", e));
		}
	}

	protected abstract @NonNull String createTestDocument(@NonNull URI uri, @NonNull String lastSegment);

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
		String saveAs = saveAsMap.get(document);
		if ((element instanceof IFileEditorInput) && (document instanceof BaseDocument) && !PERSIST_AS_TEXT.equals(saveAs)) {
			StringWriter xmlWriter = new StringWriter();
			try {
				URI uri = EditUIUtil.getURI((IFileEditorInput)element);
				if (uri == null) {
					log.warn("No URI");
				}
				else if (PERSIST_AS_PIVOT.equals(saveAs)) {
					((BaseDocument) document).saveAsPivot(xmlWriter);
				}
				else {
					log.warn("Unknown saveAs '" + saveAs + "'");
				}
				IDocument saveDocument = new Document();
				saveDocument.set(xmlWriter.toString());
				superDoSaveDocument(monitor, element, saveDocument, overwrite);
				loadedAsMap.put(document, saveAs);
			} catch (Exception e) {
				BaseUiPluginHelper helper = BaseUiPluginHelper.INSTANCE;
				String title = helper.getString("_UI_SaveFailure_title", true);
				String message = helper.getString("_UI_SaveFailure_message", true);
				ErrorDialog.openError(null, title, message, helper.createErrorStatus(e));
				monitor.setCanceled(true);				// Still dirty
			}
		}
		else {
			superDoSaveDocument(monitor, element, document, overwrite);
		}
	}

	protected abstract String getCScontentType();

	protected abstract @NonNull String getFileExtension();

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

	protected boolean isXML(@NonNull InputStream inputStream) throws IOException {
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
		getOCL().getEnvironmentFactory().adapt(resource);
		super.loadResource(resource, document, encoding);
	}

	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput, String encoding) throws CoreException {
		URI uri = EditUIUtil.getURI(editorInput);
		uriMap.put(document, uri);
		return super.setDocumentContent(document, editorInput, encoding);
	}

	@Override
	protected void setDocumentText(@NonNull XtextDocument document, @NonNull String sourceText) throws CoreException {
		final InputStream inputStream = new ByteArrayInputStream(sourceText.getBytes());
		@NonNull String displayText = sourceText;
 		try {
 			boolean isXML = isXML(inputStream);		
			String persistAs = PERSIST_AS_TEXT;
			if (isXML) {
				ResourceSet asResourceSet = getOCL().getMetamodelManager().getASResourceSet();
				StandaloneProjectMap projectMap = StandaloneProjectMap.getAdapter(asResourceSet);
				StandaloneProjectMap.IConflictHandler conflictHandler = StandaloneProjectMap.MapToFirstConflictHandlerWithLog.INSTANCE; //null; 			// FIXME
				projectMap.configure(asResourceSet, StandaloneProjectMap.LoadFirstStrategy.INSTANCE, conflictHandler);
				StandaloneProjectMap.IProjectDescriptor pivotPackageDescriptor = projectMap.getProjectDescriptor(PivotConstantsInternal.PLUGIN_ID);
				if (pivotPackageDescriptor != null) {
					pivotPackageDescriptor.configure(asResourceSet, StandaloneProjectMap.LoadBothStrategy.INSTANCE, conflictHandler);	
				}
				URI uri = uriMap.get(document);
				XMLResource xmiResource = (XMLResource) asResourceSet.getResource(uri, false);
				if ((xmiResource == null) || (xmiResource.getResourceSet() == null)) {	// Skip built-ins and try again as a file read.
					xmiResource = (XMLResource) asResourceSet.createResource(uri, null);					
				}
				else {
					xmiResource.unload();
				}
				xmiResource.load(inputStream, null);
				EcoreUtil.resolveAll(asResourceSet);
				List<Resource.Diagnostic> allErrors = null;
				for (Resource resource : asResourceSet.getResources()) {
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
					throw new CoreException(new Status(IStatus.ERROR, BaseUiModule.PLUGIN_ID, s.toString()));
				}
				ASResource asResource = null;
				EList<EObject> contents = xmiResource.getContents();
				if (contents.size() > 0) {
					EObject xmiRoot = contents.get(0);
					if (xmiRoot instanceof Model) {
						asResource = (ASResource) xmiResource;
						persistAs = PERSIST_AS_PIVOT;
					}

					// FIXME general extensibility
				}
				if (asResource == null) {
					throw new CoreException(new Status(IStatus.ERROR, BaseUiModule.PLUGIN_ID, "Failed to load"));
				}
//				
				ResourceSetImpl csResourceSet = (ResourceSetImpl)getOCL().getResourceSet();
				csResourceSet.getPackageRegistry().put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
				URI textURI = xmiResource.getURI().appendFileExtension(getFileExtension());
				CSResource csResource = (CSResource) csResourceSet.getResource(textURI, false);
				if (csResource == null) {
					csResource = (CSResource) csResourceSet.createResource(textURI, getCScontentType());
				    Map<URI, Resource> map = csResourceSet.getURIResourceMap();
				    map.put(textURI, csResource);
					csResource.setURI(xmiResource.getURI());
				}
				//
				//	ResourceSet contains
				//		Ecore XMI resource with *.ecore URI, possibly in URIResourceMap as *.ecore
				//		QVTimperative CS resource with *.ecore URI, in URIResourceMap as *.ecore.oclinecore
				//
				csResource.updateFrom(asResource, getOCL().getEnvironmentFactory());
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				try {
					csResource.save(outputStream, null);
				} catch (InvalidConcreteSyntaxException e) {
					diagnoseErrors((XtextResource) csResource, e);
				} catch (XtextSerializationException e) {
					diagnoseErrors((XtextResource) csResource, e);
				}
				csResource.unload();
				@SuppressWarnings("null")@NonNull String string = outputStream.toString();
				displayText = string;
			}
			else if (inputStream.available() == 0) {		// Empty document
				URI uri = ClassUtil.nonNullState(uriMap.get(document));
				Resource.Factory factory = Resource.Factory.Registry.INSTANCE.getFactory(uri);
				if (factory instanceof OCLASResourceFactory) {
					persistAs = PERSIST_AS_PIVOT;
				}
//				else if (factory instanceof UMLResourceFactoryImpl) {
//					persistAs = PERSIST_AS_UML;
//				}
				String lastSegment = uri.trimFileExtension().lastSegment();
				if (lastSegment == null) {
					lastSegment = "Default";
				}
				displayText = createTestDocument(uri, lastSegment);
			}
			loadedAsMap.put(document, persistAs);
			saveAsMap.put(document, persistAs);
//		} catch (ParserException e) {
//			throw new CoreException(new Status(IStatus.ERROR, OCLExamplesCommonPlugin.PLUGIN_ID, "Failed to load", e));
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, BaseUiModule.PLUGIN_ID, "Failed to load", e));
		}
		superSetDocumentText(document, displayText);
	}

	public void setExportDelegateURI(Object element, String uri) {
		exportDelegateURIMap.put(getDocument(element), uri);
	}

	public void setPersistAs(Object element, String persistAs) {
		saveAsMap.put(getDocument(element), persistAs);
		setCanSaveDocument(element);
	}

	protected void superDoSaveDocument(IProgressMonitor monitor, Object element, IDocument document,
			boolean overwrite) throws CoreException {
		super.doSaveDocument(monitor, element, document, overwrite);
	}

	protected void superSetDocumentText(@NonNull XtextDocument document, @NonNull String displayText) throws CoreException {
		super.setDocumentText(document, displayText);
	}
}
