/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.resource.ASResourceFactory;
import org.eclipse.ocl.examples.pivot.resource.ASResourceFactoryRegistry;

public class AS2XMIid
{
	/**
	 * Create an AS2ID conversion primed with the xmi:id values obtained by loading uri. 
	 */
	public static @NonNull AS2XMIid load(@NonNull URI uri) {
		Map<String, String> moniker2id = new HashMap<String, String>();
		ResourceSet resourceSet = new ResourceSetImpl();
		ASResourceFactoryRegistry.INSTANCE.configureResourceSet(resourceSet);
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(PivotConstants.OCL_AS_FILE_EXTENSION, OCLASResourceFactory.INSTANCE);
		try {
			Resource resource = resourceSet.getResource(uri, true);
			if (resource instanceof XMLResource) {
				@SuppressWarnings("null")@NonNull List<Adapter> eAdapters = resource.eAdapters();
				AS2MonikerVisitor monikerVisitor = PivotUtil.getAdapter(AS2MonikerVisitor.class, eAdapters);
				if (monikerVisitor != null) {
					XMLResource xmlResource = (XMLResource) resource;
					for (TreeIterator<EObject> tit = xmlResource.getAllContents(); tit.hasNext(); ) {
						EObject eObject = tit.next();
						if (eObject instanceof Element) {
							Element element = (Element) eObject;
							String oldID = xmlResource.getID(element);
							if (oldID != null) {
								Object moniker = element.accept(monikerVisitor);
								if (moniker instanceof String) {
									moniker2id.put((String) moniker, oldID);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {}
		return new AS2XMIid(moniker2id);
	}

	protected final @NonNull Map<String, String> moniker2id;
	
	public AS2XMIid() {
		this.moniker2id = new HashMap<String, String>();
	}
	
	protected AS2XMIid(@NonNull Map<String, String> moniker2id) {
		this.moniker2id = moniker2id;
	}

	/**
	 * Assign xmi:id values to referenceable elements in asResource re-using the xmi:id
	 * values read when this AS2ID was constructed.
	 */
	public void assignIds(@NonNull ASResource asResource, @Nullable Map<?, ?> options) {
		StringBuilder s = null;
		Map<String, EObject> allIds = new HashMap<String, EObject>();
		ASResourceFactory resourceFactory = asResource.getASResourceFactory();
		Object optionInternalUUIDs = options != null ? options.get(ASResource.OPTION_INTERNAL_UUIDS) : null;
		boolean internalUUIDs = (optionInternalUUIDs != null) && Boolean.valueOf(optionInternalUUIDs.toString());
		for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Element) {
				Element element = (Element)eObject;
				AS2XMIidVisitor idVisitor = resourceFactory.createAS2XMIidVisitor(this);
				String id = asResource.getID(element);
				if (id == null) {
					id = idVisitor.getID(element, internalUUIDs);
				}
				if (id != null) {
					assert id.length() > 0 : "Zero length id for '" + element.eClass().getName() + "'";
					EObject oldElement = allIds.put(id, element);
					if (oldElement != null) {
						if (s == null) {
							s = new StringBuilder();
							s.append("Duplicate xmi:id values generated for ");
						}
						s.append("\n '" + id + "' for '" + element.eClass().getName() + "'");
					}
					asResource.setID(element, id);
				}
			}
		}
		if (s != null) {
			throw new IllegalStateException(s.toString());
		}
	}

	/**
	 * Assign xmi:id values to referenceable elements in asResourceSet re-using the xmi:id
	 * values read when this AS2ID was constructed.
	 */
	public void assignIds(@NonNull ResourceSet asResourceSet, @Nullable Map<?, ?> options) {
		for (@SuppressWarnings("null")@NonNull Resource resource : asResourceSet.getResources()) {
			if (resource instanceof ASResource) {
				assignIds((ASResource)resource, options);
			}
		}
		MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(asResourceSet);
		if (metaModelManager != null) {
			metaModelManager.assignLibraryIds(this, options);
		}
	}

	public String getID(@NonNull Element element, boolean internalUUIDs) {
		String moniker = AS2Moniker.toString(element);
		String id = moniker2id.get(moniker);
		if ((id == null) && internalUUIDs) {
			id = EcoreUtil.generateUUID();
//			System.out.println(id + " for " + element + " " + DomainUtil.debugSimpleName(element));
		}
		return id;
	}
}
