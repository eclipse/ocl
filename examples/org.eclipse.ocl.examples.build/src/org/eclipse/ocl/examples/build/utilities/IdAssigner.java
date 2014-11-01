/*******************************************************************************
 * Copyright (c) 2010, 2014 E.D.Willink and others.
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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.Mapping;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.uml.UMLXMIID;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.internal.resource.XMI2UMLHandler;
import org.eclipse.uml2.uml.internal.resource.XMI2UMLLoadImpl;
import org.eclipse.uml2.uml.internal.resource.XMI2UMLResourceFactoryImpl;
import org.eclipse.uml2.uml.internal.resource.XMI2UMLResourceImpl;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resource.XMI2UMLResource;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Assigns simple package/type/type-name xmi:ids to Packages, Types, Properties that do not already have them.
 * *.xmi inputs are handled so as to use local rather than registered OMG resources.
 */
@SuppressWarnings("restriction")
public class IdAssigner extends AbstractWorkflowComponent
{
	protected static final class LocalXMI2UMLResourceFactory extends XMI2UMLResourceFactoryImpl
	{
		public static final @NonNull LocalXMI2UMLResourceFactory INSTANCE = new LocalXMI2UMLResourceFactory();
		
		@Override
		public Resource createResourceGen(URI uri) {
			XMI2UMLResource result = new LocalXMI2UMLResource(uri);
			result.setEncoding(XMI2UMLResource.DEFAULT_ENCODING);
			return result;
		}
	}

	protected static final class LocalXMI2UMLResource extends XMI2UMLResourceImpl
	{
		protected LocalXMI2UMLResource(URI uri) {
			super(uri);
		}

		@Override
		protected XMLLoad createXMLLoad() {
			return new LocalXMI2UMLLoad(createXMLHelper());
		}
	}

	protected static final class LocalXMI2UMLLoad extends XMI2UMLLoadImpl
	{
		protected LocalXMI2UMLLoad(XMLHelper helper) {
			super(helper);
		}

		@Override
		protected DefaultHandler makeDefaultHandler() {
			return new LocalXMI2UMLHandler(resource, helper, options);
		}
	}

	protected static final class LocalXMI2UMLHandler extends XMI2UMLHandler
	{
		protected LocalXMI2UMLHandler(XMLResource xmiResource, XMLHelper helper, Map<?, ?> options) {
			super(xmiResource, helper, options);
		}

		@Override
		protected void handleProxy(InternalEObject proxy, String uriLiteral) {
			if (uriLiteral.startsWith(XMI2UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI)) {
				URI uri = URI.createURI(uriLiteral);
				uriLiteral = uri.lastSegment() + "#" + uri.fragment();
			}
			super.handleProxy(proxy, uriLiteral);
		}
	}

	protected Logger log = Logger.getLogger(getClass());	
	private ResourceSet resourceSet = null;	
	protected Map<URI, URI> uriMapping = new HashMap<URI, URI>();
	protected boolean assignFlatIds = true;

	/**
	 * Define a mapping from a source UML/CMOF file to a UML file with resolved assignments.
	 */
	public void addMapping(final Mapping uriMap) {
		final URI fromURI = URI.createPlatformResourceURI(uriMap.getFrom(), true);
		final URI toURI = URI.createPlatformResourceURI(uriMap.getTo(), true);
		uriMapping.put(fromURI, toURI);
	}

	public void checkConfiguration(Issues issues) {
	}

	public String computeId(@NonNull StringBuilder s, @NonNull NamedElement namedElement) {
		EObject eContainer = namedElement.eContainer();
		if (eContainer instanceof NamedElement) {
			computeId(s, (NamedElement) eContainer);
			s.append("-");
		}
		String name = namedElement.getName();
		if (name == null) {
			UMLXMIID umlXMIid = new UMLXMIID((XMLResource) namedElement.eResource());
			name = umlXMIid.doSwitch(namedElement);
		}
		s.append(name);
		return s.toString();
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
		ResourceSetImpl resourceSet = (ResourceSetImpl) getResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", LocalXMI2UMLResourceFactory.INSTANCE);
		Map<UMLResource, UMLResource> resourceMap = new HashMap<UMLResource, UMLResource>();
		for (URI fromURI : uriMapping.keySet()) {
			log.info("Assigning Ids from '" + fromURI + "'");
			URI toURI = uriMapping.get(fromURI);
			UMLResource fromResource = (UMLResource) resourceSet.getResource(fromURI, true);
			EcoreUtil.resolveAll(fromResource);
			for (EObject eRoot : fromResource.getContents()) {
				if (eRoot instanceof org.eclipse.uml2.uml.Package) {
					org.eclipse.uml2.uml.Package umlPackage = (org.eclipse.uml2.uml.Package)eRoot;
					String uri = umlPackage.getURI();
					if (uri != null) {
						resourceSet.getURIResourceMap().put(URI.createURI(uri), fromResource);
					}
				}	// http://www.omg.org/spec/UML/20131001/PrimitiveTypes.xmi
			}
			UMLResource toResource = (UMLResource) resourceSet.createResource(toURI);
			resourceMap.put(fromResource, toResource);
		}
		EcoreUtil.resolveAll(resourceSet);
		ResourceUtils.checkResourceSet(resourceSet);
		for (UMLResource fromResource : resourceMap.keySet()) {
			UMLResource toResource = resourceMap.get(fromResource);
			toResource.getContents().addAll(fromResource.getContents());
			if (assignFlatIds) {
				for (TreeIterator<EObject> tit = toResource.getAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					if (eObject instanceof org.eclipse.uml2.uml.Package) {
						NamedElement namedElement = (NamedElement) eObject;
						toResource.setID(eObject, namedElement.getName());
					}
	/*				else if (eObject instanceof Property) {
						Property property = (Property) eObject;
						Type type = property.getClass_();
						if (type != null) {
							String id = toResource.getID(eObject);
							if (assignIds || (id == null)) { // || !id.startsWith(type.getName())) {	// If it starts with type it may be a good name
								toResource.setID(eObject, computeId(new StringBuilder(), property));
							}
						}
					} */
				}
			}
			else {
	//			new UMLXMIID(toResource).assign();
				for (TreeIterator<EObject> tit = toResource.getAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					if ((eObject instanceof org.eclipse.ocl.examples.pivot.Package) || (eObject instanceof Type) || (eObject instanceof Property) || (eObject instanceof Operation)) {
						@SuppressWarnings("null")@NonNull NamedElement namedElement = (NamedElement) eObject;
						toResource.setID(eObject, computeId(new StringBuilder(), namedElement));
					}
					else if ((eObject instanceof org.eclipse.uml2.uml.Package) || (eObject instanceof org.eclipse.uml2.uml.Type) || (eObject instanceof org.eclipse.uml2.uml.Property) || (eObject instanceof org.eclipse.uml2.uml.Operation)) {
						@SuppressWarnings("null")@NonNull NamedElement namedElement = (NamedElement) eObject;
						toResource.setID(eObject, computeId(new StringBuilder(), namedElement));
					}
	/*				else if (eObject instanceof Property) {
						Property property = (Property) eObject;
						Type type = property.getClass_();
						if (type != null) {
							String id = toResource.getID(eObject);
							if (assignIds || (id == null)) { // || !id.startsWith(type.getName())) {	// If it starts with type it may be a good name
								toResource.setID(eObject, computeId(new StringBuilder(), property));
							}
						}
					} */
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
		result.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));
		result.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		return result;
	}
	
	public void setAssignFlatIds(boolean assignFlatIds) {
		this.assignFlatIds = assignFlatIds;
	}
	
	public void setResourceSet(@NonNull ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
}
