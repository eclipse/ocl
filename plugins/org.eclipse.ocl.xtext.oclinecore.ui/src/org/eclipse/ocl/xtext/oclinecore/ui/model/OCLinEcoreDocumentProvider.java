/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.ui.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.delegate.DelegateInstaller;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.uml.internal.es2as.UML2AS;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.ui.model.BaseCSorASDocumentProvider;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.oclinecore.ui.OCLinEcoreUiModule;
import org.eclipse.ocl.xtext.oclinecore.ui.OCLinEcoreUiPluginHelper;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator.InvalidConcreteSyntaxException;

/**
 * OCLinEcoreDocumentProvider orchestrates the load and saving of optional XMI content
 * externally while maintaining the serialised human friendly form internally. 
 */
public class OCLinEcoreDocumentProvider extends BaseCSorASDocumentProvider
{		// FIXME share more code with BaseCSorASDocumentProvider
	private static final Logger log = Logger.getLogger(OCLinEcoreDocumentProvider.class);
	
	public static final String PERSIST_AS_ECORE = "as-ecore";
	public static final String PERSIST_IN_ECORE = "in-ecore";
//	public static final String PERSIST_AS_PIVOT = "pivot";
	public static final String PERSIST_AS_OCLINECORE = "oclinecore";
	public static final String PERSIST_AS_UML = "uml";

	@Override
	protected @NonNull String createTestDocument(@NonNull URI uri, @NonNull String lastSegment) {
		return "package " + lastSegment + " : pfx = '"+ uri + "' {\n" + "}\n";
	}

	private void diagnoseErrors(Resource resource) throws CoreException {
		List<Resource.Diagnostic> errors = resource.getErrors();
		if (errors.size() > 0) {
			String formattedMessage = PivotUtil.formatResourceDiagnostics(errors, "Failed to load", "\n");
			throw new CoreException(new Status(IStatus.ERROR, OCLinEcoreUiModule.PLUGIN_ID, formattedMessage));
		}
	}

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
		String saveAs = saveAsMap.get(document);
		if ((element instanceof IFileEditorInput) && (document instanceof OCLinEcoreDocument) && !PERSIST_AS_OCLINECORE.equals(saveAs)) {
			StringWriter xmlWriter = new StringWriter();
			try {
				ASResource asResource = ((OCLinEcoreDocument) document).getASResource();
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
			superDoSaveDocument(monitor, element, document, overwrite);
		}
	}

	@Override
	protected String getCScontentType() {
		return OCLinEcoreCSPackage.eCONTENT_TYPE;
	}

	@Override
	protected @NonNull String getFileExtension() {
		return "oclinecore";
	}

	@Override
	protected void setDocumentText(@NonNull XtextDocument document, @NonNull String sourceText) throws CoreException {
		boolean reload = false;
		ByteArrayInputStream inputStream = new ByteArrayInputStream(sourceText.getBytes());
		@NonNull String displayText = sourceText;
		try {
			boolean isXML = isXML(inputStream);		
			String persistAs = PERSIST_AS_OCLINECORE;
			if (isXML) {
				ResourceSet resourceSet = getEnvironmentFactory().getResourceSet();
				StandaloneProjectMap projectMap = ProjectMap.getAdapter(resourceSet);
				StandaloneProjectMap.IConflictHandler conflictHandler = StandaloneProjectMap.MapToFirstConflictHandlerWithLog.INSTANCE; //null; 			// FIXME
				projectMap.configure(resourceSet, StandaloneProjectMap.LoadFirstStrategy.INSTANCE, conflictHandler);
				StandaloneProjectMap.IProjectDescriptor pivotPackageDescriptor = projectMap.getProjectDescriptor(PivotConstantsInternal.PLUGIN_ID);
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
					throw new CoreException(new Status(IStatus.ERROR, OCLinEcoreUiModule.PLUGIN_ID, s.toString()));
				}
				ASResource asResource = null;
				EList<EObject> contents = xmiResource.getContents();
				if (contents.size() > 0) {
					EObject xmiRoot = contents.get(0);
					if (xmiRoot instanceof EPackage) {
						Ecore2AS ecore2as = Ecore2AS.getAdapter(xmiResource, getEnvironmentFactory());
						Model pivotModel = ecore2as.getASModel();
						asResource = (ASResource) pivotModel.eResource();
						if (asResource != null) {
							if (reload) {
								ecore2as.update(asResource, contents);
							}
							diagnoseErrors(asResource);		// FIXME On reload, this throws a CoreException which loses the user's source text
						}
						persistAs = PERSIST_AS_ECORE;
						exportDelegateURIMap.put(document, DelegateInstaller.getDelegateURI(contents));
					}
					else if (xmiRoot instanceof Model) {
						asResource = (ASResource) xmiResource;
						persistAs = PERSIST_AS_PIVOT;
					}
					else if (xmiRoot instanceof org.eclipse.uml2.uml.Package) {
						UML2AS uml2as = UML2AS.getAdapter(xmiResource, getEnvironmentFactory());
						Model pivotModel = uml2as.getASModel();
						asResource = (ASResource) pivotModel.eResource();
						persistAs = PERSIST_AS_OCLINECORE;		// FIXME
					}
					// FIXME general extensibility
				}
				if (asResource == null) {
					throw new CoreException(new Status(IStatus.ERROR, OCLinEcoreUiModule.PLUGIN_ID, "Failed to load"));
				}
//				
				ResourceSetImpl csResourceSet = (ResourceSetImpl)resourceSet;
				csResourceSet.getPackageRegistry().put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
				URI oclinecoreURI = xmiResource.getURI().appendFileExtension("oclinecore");
				CSResource csResource = (CSResource) resourceSet.getResource(oclinecoreURI, false);
				if (csResource == null) {
					csResource = (CSResource) resourceSet.createResource(oclinecoreURI, OCLinEcoreCSPackage.eCONTENT_TYPE);
				    Map<URI, Resource> map = csResourceSet.getURIResourceMap();
				    map.put(oclinecoreURI, csResource);
					csResource.setURI(xmiResource.getURI());
				}
				//
				//	ResourceSet contains
				//		Ecore XMI resource with *.ecore URI, possibly in URIResourceMap as *.ecore
				//		OCLinEcore CS resource with *.ecore URI, in URIResourceMap as *.ecore.oclinecore
				//
				csResource.updateFrom(asResource, getEnvironmentFactory());
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				try {
					csResource.save(outputStream, null);
				} catch (InvalidConcreteSyntaxException e) {
					diagnoseErrors((XtextResource) csResource, e);
				} catch (XtextSerializationException e) {
					diagnoseErrors((XtextResource) csResource, e);
				}
				csResource.unload();
				((BaseCSResource)csResource).dispose();
				resourceSet.getResources().remove(csResource);
				@SuppressWarnings("null")@NonNull String string = outputStream.toString();
				displayText = string;
			}
			else if (inputStream.available() == 0) {		// Empty document
				URI uri = ClassUtil.nonNullState(uriMap.get(document));
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
				displayText = createTestDocument(uri, lastSegment);
			}
			loadedAsMap.put(document, persistAs);
			saveAsMap.put(document, persistAs);
		} catch (ParserException e) {
			throw new CoreException(new Status(IStatus.ERROR, OCLinEcoreUiModule.PLUGIN_ID, "Failed to load", e));
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, OCLinEcoreUiModule.PLUGIN_ID, "Failed to load", e));
		}
		superSetDocumentText(document, displayText);
	}
}
