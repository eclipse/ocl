/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.utilities;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerListener;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;

/**
 * The CSI2ASMapping maintains the mapping between CS elements or rather their CSIs
 * that remain stable after recreation and the Pivot elements. This mapping may be used
 * repeatedly while editing (CS2AS conversions) to associate changing CS elements with
 * stable Pivot elements.
 * The mapping is also created during a AS2CS conversion to allow subsequent CS2AS
 * conversions to reuse the original Pivot elements.  
 */
public class CSI2ASMapping extends AdapterImpl implements MetaModelManagerListener
{
	public static @NonNull CSI2ASMapping getAdapter(@NonNull MetaModelManager metaModelManager) {
		List<Adapter> eAdapters = metaModelManager.getASResourceSet().eAdapters();
		for (Adapter adapter : eAdapters) {
			if (adapter instanceof CSI2ASMapping) {
				return (CSI2ASMapping) adapter;
			}
		}
		CSI2ASMapping adapter = new CSI2ASMapping();
		eAdapters.add(adapter);
		return adapter;
	}
	
	/**
	 * Mapping of each CS resource to its corresponding pivot Resource.
	 */
	protected final @NonNull Map<BaseCSResource, ASResource> cs2asResourceMap = new HashMap<BaseCSResource, ASResource>();

	/**
	 * Mapping of each CS resource's URI to a short alias used in URI maps.
	 */
	private Map<String, String> csURI2aliasMap = new HashMap<String, String>();

	/**
	 * The map from CS element (identified by URI) to pivot element at the end of the last update. This map enables
	 * the next update from a potentially different CS Resource and elements but the same URIs to re-use the pivot elements
	 * and to kill off the obsolete elements. 
	 */
	private Map<String, Element> csi2as = new HashMap<String, Element>();

	/**
	 * A lazily created inverse map that may be required for navigation from an outline.
	 */
	private Map<Element, ModelElementCS> as2cs = null;
	
	private int nextAlias = 0;
	
	private CSI2ASMapping() {}

	public void add(Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap) {
		as2cs = null;
		this.cs2asResourceMap.putAll(cs2asResourceMap); 
	}

	public void clear() {
		csURI2aliasMap.clear();
		csi2as.clear();
		as2cs = null;
	}
	
	public Set<String> computeCSIs(Collection<? extends Resource> csResources) {
		Set<String> map = new HashSet<String>();
		for (Resource csResource : csResources) {
			for (Iterator<EObject> it = csResource.getAllContents(); it.hasNext(); ) {
				EObject eObject = it.next();
				if (eObject instanceof ModelElementCS) {
					ModelElementCS csElement = (ModelElementCS)eObject;
					String csURI = getCSI(csElement);
					map.add(csURI);
				}
			}
		}
		return map;
	}

	protected @NonNull Map<Element, ModelElementCS> computeAS2CSMap() {
		Map<Element, ModelElementCS> map = new HashMap<Element, ModelElementCS>();
		for (Resource csResource : cs2asResourceMap.keySet()) {
			for (Iterator<EObject> it = csResource.getAllContents(); it.hasNext(); ) {
				EObject eObject = it.next();
				if (eObject instanceof ModelElementCS) {
					ModelElementCS csElement = (ModelElementCS)eObject;
					Element pivotElement = csElement.getPivot();
					if (pivotElement != null) {
						map.put(pivotElement, csElement);
					}
//					System.out.println(DomainUtil.debugSimpleName(pivotElement) + " => " + DomainUtil.debugSimpleName(csElement));
				}
			}
		}
		return map;
	}

	/**
	 * Return the Pivot element corresponding to a given CS element.
	 */
	public @Nullable Element get(@NonNull ModelElementCS csElement) {
		String csi = getCSI(csElement);
		return csi2as.get(csi);
	}

	/**
	 * Return the AS Resource corresponding to a given CS Resource.
	 */
	public @Nullable ASResource getASResource(@Nullable BaseCSResource csResource) {
		return cs2asResourceMap.get(csResource);
	}

	/**
	 * Get the Concrete Syntax Identifier for a CS element. This is a form of URI. It is significantly compacted to
	 * save on memory.
	 * @param csResource2aliasMap 
	 */
	private @NonNull String getCSI(@NonNull ModelElementCS csElement) {
		String csi = csElement.getCsi();
		if (csi == null) {
			Resource csResource = csElement.eResource();
			String csResourceURI = csResource.getURI().toString();
			String fragment = csResource.getURIFragment(csElement);		// FIXME Use more optimized compressing algorithm
			String alias = csURI2aliasMap.get(csResourceURI);
			if (alias == null) {
				alias = Integer.toString(nextAlias++);
				csURI2aliasMap.put(csResourceURI, alias);
			}
			csi = alias + '#' + fragment;
			csElement.setCsi(csi);
		}
		return csi;
	}

	/**
	 * Return all mapped CS Resources.
	 */
	@SuppressWarnings("null")
	public @NonNull Set<BaseCSResource> getCSResources() {
		return cs2asResourceMap.keySet();
	}

	public @Nullable ModelElementCS getCSElement(@NonNull Element pivotElement) {
		if (as2cs == null) {
			as2cs = computeAS2CSMap();
		}
		return as2cs.get(pivotElement);
	}

	public Map<String, Element> getMapping() {
		return csi2as;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == CSI2ASMapping.class;
	}

	@Override
	public void metaModelManagerDisposed(@NonNull MetaModelManager metaModelManager) {
		clear();
	}

	/**
	 * Install the Pivot element corresponding to a given CS element.
	 */
	public void put(@NonNull ModelElementCS csElement, @Nullable Element pivotElement) {
		String csi = getCSI(csElement);
		csi2as.put(csi, pivotElement);
	}

	/**
	 * Remove the Resource mappings for all csResources. The CSI mappings persist until update() is called.
	 */
	public void removeCSResources(@NonNull Set<? extends BaseCSResource> csResources) {
		as2cs = null;
		for (Resource csResource : csResources) {
			cs2asResourceMap.remove(csResource); 
		}
	}

	/**
	 * Update the mapping to cache the Pivot elements with respect to the CSIs for all CS elements in csResources.
	 */
	public void update() {
		as2cs = null;
		csi2as.clear();
		Set<String> deadURIs = new HashSet<String>(csURI2aliasMap.keySet());
		for (Resource csResource : cs2asResourceMap.keySet()) {
			deadURIs.remove(csResource.getURI().toString());
			for (Iterator<EObject> it = csResource.getAllContents(); it.hasNext(); ) {
				EObject eObject = it.next();
				if (eObject instanceof ModelElementCS) {
					ModelElementCS csElement = (ModelElementCS)eObject;
					Element pivotElement = csElement.getPivot();
					put(csElement, pivotElement);
				}
			}
		}
//		for (String deadURI : deadURIs) {
// FIXME Imported CS kills off Importing CS			csURI2aliasMap.remove(deadURI);
//		}
	}
}
