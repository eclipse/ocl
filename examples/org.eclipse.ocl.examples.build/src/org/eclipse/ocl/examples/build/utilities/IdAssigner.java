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
package org.eclipse.ocl.examples.build.utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.Mapping;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Assigns simple package/type/type-name xmi:ids to Packages, Types, Properties that do not already have them.
 */
public class IdAssigner extends AbstractWorkflowComponent
{
	protected Logger log = Logger.getLogger(getClass());	
	private ResourceSet resourceSet = null;	
	protected Map<URI, URI> uriMapping = new HashMap<URI, URI>();

	/**
	 * Define a mapping from a source UML/CMOF file to a UML file with resolved assignments.
	 */
	public void addMapping(final Mapping uriMap) {
		final URI fromURI = URI.createPlatformResourceURI(uriMap.getFrom(), true);
		final URI toURI = URI.createPlatformResourceURI(uriMap.getTo(), true);
		uriMapping.put(fromURI, toURI);
	}

	@Override
	public void checkConfiguration(Issues issues) {
	}

	public @NonNull ResourceSet getResourceSet() {
		ResourceSet resourceSet2 = resourceSet;
		if (resourceSet2 == null) {
			resourceSet = resourceSet2 = new ResourceSetImpl();
		}
		return resourceSet2;
	}

	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		ResourceSet resourceSet = getResourceSet();
		Map<UMLResource, UMLResource> resourceMap = new HashMap<UMLResource, UMLResource>();
		for (URI fromURI : uriMapping.keySet()) {
			log.info("Assigning Ids from '" + fromURI + "'");
			URI toURI = uriMapping.get(fromURI);
			UMLResource fromResource = (UMLResource) resourceSet.getResource(fromURI, true);
			UMLResource toResource = (UMLResource) resourceSet.createResource(toURI);
			resourceMap.put(fromResource, toResource);
		}
		EcoreUtil.resolveAll(resourceSet);
		ResourceUtils.checkResourceSet(resourceSet);
		for (UMLResource fromResource : resourceMap.keySet()) {
			UMLResource toResource = resourceMap.get(fromResource);
			toResource.getContents().addAll(fromResource.getContents());
			for (TreeIterator<EObject> tit = toResource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if ((eObject instanceof org.eclipse.uml2.uml.Package) || (eObject instanceof Type)) {
					NamedElement namedElement = (NamedElement) eObject;
					toResource.setID(eObject, namedElement.getName());
				}
				else if (eObject instanceof Property) {
					Property property = (Property) eObject;
					Type type = property.getClass_();
					if (type != null) {
						String id = toResource.getID(eObject);
						if ((id == null) || !id.startsWith(type.getName())) {	// If it starts with type it may be a good name
							toResource.setID(eObject, type.getName() + "-" + property.getName());
						}
					}
				}
			}
		}
		for (UMLResource toResource : resourceMap.values()) {
			log.info("Assigned Ids to '" + toResource.getURI() + "'");
			try {
				toResource.save(getSaveOptions());
			} catch (IOException e) {
				throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
			}
		}
	}

	protected Map<?, ?> getSaveOptions() {
		Map<Object, Object> result = new HashMap<Object, Object>();
		result.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
//		result.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));
		result.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		return result;
	}
	
	public void setResourceSet(@NonNull ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
}
