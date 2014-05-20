/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.utilities;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.completeocl.pivot2cs.CompleteOCLSplitter;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreCSPackage;

/**
 * Converts a UML resource to its Pivot form.
 */
public class CompleteOCLSeparator extends WorkflowComponentWithModelSlot
{
	private Logger log = Logger.getLogger(getClass());

	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		Resource resource = (Resource) ctx.get(getModelSlot());
		log.info("Splitting Complete OCL from '" + resource.getURI() + "'");
		Resource oclResource = separateCompleteOCL(resource);
		ctx.set(getOclSlot(), oclResource);
	}

	private String oclSlot;
	private String oclURI;

	/**
	 * Sets the name of the OCL slot.
	 * 
	 * @param slot
	 *            name of slot
	 */
	public void setOclSlot(final String slot) {
		oclSlot = slot;
	}

	protected String getOclSlot() {
		return oclSlot;
	}

	/**
	 * Sets the name of the OCL slot.
	 * 
	 * @param slot
	 *            name of slot
	 */
	public void setOclURI(final String uri) {
		oclURI = uri;
	}

	protected String getOclURI() {
		return oclURI;
	}

	private Resource separateCompleteOCL(@NonNull Resource resource) {
		CompleteOCLStandaloneSetup.doSetup();
		URI uri = resource.getURI();
		ResourceSet resourceSet = resource.getResourceSet();
		assert resourceSet != null;
		MetaModelManager metaModelManager = MetaModelManager.getAdapter(resourceSet);
		ASResource oclResource = CompleteOCLSplitter.separate(metaModelManager, resource);
		URI xtextURI = oclURI != null ? URI.createPlatformResourceURI(oclURI, true) : uri.trimFileExtension().appendFileExtension("ocl");
		ResourceSetImpl csResourceSet = new ResourceSetImpl();
		MetaModelManagerResourceSetAdapter.getAdapter(csResourceSet, metaModelManager);
		BaseCSResource xtextResource = (BaseCSResource) csResourceSet.createResource(xtextURI, OCLinEcoreCSPackage.eCONTENT_TYPE);
		if (oclResource != null) {
			xtextResource.updateFrom(oclResource, metaModelManager);
		}
		return xtextResource;
	}
}
