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

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.uml.Pivot2UML;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseDocument;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * An OCLinEcoreDocument refines a document to support generation of an alternate (XMI) content
 * for use during save in place of its normal textual content.
 */
public class OCLinEcoreDocument extends BaseDocument
{
	@Inject
	public OCLinEcoreDocument(DocumentTokenSource tokenSource, ITextEditComposer composer) {
		super(tokenSource, composer);
	}

	/**
	 * Write the XMI representation of the Ecore to be saved.
	 * @param exportDelegateURI 
	 */
	public void saveAsEcore(final @NonNull Writer writer, final @NonNull URI ecoreURI, final @Nullable String exportDelegateURI) throws IOException, CoreException {
		readOnly(new IUnitOfWork<Object, XtextResource>()
			{
				public Object exec(@Nullable XtextResource resource) throws Exception {
					if (resource != null) {
						XMLResource asResource = getPivotResource();
						if (asResource != null) {
							CS2PivotResourceAdapter adapter = ((BaseCSResource)resource).findCS2ASAdapter();
							if (adapter != null) {
								Resource csResource = adapter.getTarget();
								checkForErrors(csResource);
								Map<String,Object> options = new HashMap<String,Object>();
								options.put(OCLConstants.OCL_DELEGATE_URI, exportDelegateURI);
								XMLResource ecoreResource = Pivot2Ecore.createResource(adapter.getMetaModelManager(), asResource, ecoreURI, options);
			//					ResourceSetImpl resourceSet = new ResourceSetImpl();
			//					XMLResource ecoreResource = (XMLResource) resourceSet.createResource(ecoreURI);
			//					ecoreResource.getContents().addAll(ecoreContents);
								ecoreResource.save(writer, null);
								checkForErrors(ecoreResource);
							}
						}
					}
					return null;
				}
			});
	}

	/**
	 * Write the XMI representation of the UML to be saved.
	 */
	public void saveAsUML(final @NonNull Writer writer, final @NonNull URI umlURI) throws IOException, CoreException {
		readOnly(new IUnitOfWork<Object, XtextResource>()
			{
				public Object exec(@Nullable XtextResource resource) throws Exception {
					if (resource != null) {
						XMLResource asResource = getPivotResource();
						if (asResource != null) {
							CS2PivotResourceAdapter adapter = ((BaseCSResource)resource).findCS2ASAdapter();
							if (adapter != null) {
								List<EObject> umlContents = Pivot2UML.createResource(adapter.getMetaModelManager(), asResource);
								ResourceSetImpl resourceSet = new ResourceSetImpl();
				//				URI umlURI = URI.createURI("internal.uml");
								UMLResource umlResource = (UMLResource) resourceSet.createResource(umlURI);
								umlResource.getContents().addAll(umlContents);
								checkForErrors(umlResource);
								umlResource.save(writer, null);
							}
						}
					}
					return null;
				}
			});
	}

	/**
	 * Write the XMI representation of the Ecore to be saved.
	 */
	public void saveInEcore(final @NonNull Writer writer, final @NonNull URI ecoreURI, final @Nullable String exportDelegateURI) throws IOException, CoreException {
		readOnly(new IUnitOfWork<Object, XtextResource>()
			{
				public Object exec(@Nullable XtextResource resource) throws Exception {
					if (resource != null) {
						XMLResource asResource = getPivotResource();
						if (asResource != null) {
							CS2PivotResourceAdapter adapter = ((BaseCSResource)resource).findCS2ASAdapter();
							if (adapter != null) {
								Map<String,Object> options = new HashMap<String,Object>();
								options.put(PivotConstants.PRIMITIVE_TYPES_URI_PREFIX, "primitives.ecore#//");
								options.put(OCLConstants.OCL_DELEGATE_URI, exportDelegateURI);
								XMLResource ecoreResource = Pivot2Ecore.createResource(adapter.getMetaModelManager(), asResource, ecoreURI, options);
								ecoreResource.save(writer, null);
								checkForErrors(ecoreResource);
							}
						}
					}
					return null;
				}
			});
	}
}
