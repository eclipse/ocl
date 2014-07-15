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
package org.eclipse.ocl.examples.xtext.base.pivot2cs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.utilities.AbstractConversion;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CSI2PivotMapping;

/**
 * CS2Pivot manages the equivalence between a Concrete Syntax Resources
 * and their corresponding Pivot Resources creating a CS2PivotConversion
 * to update.
 */
public class Pivot2CS extends AbstractConversion
{	
	public static interface Factory {
		@NonNull BaseDeclarationVisitor createDeclarationVisitor(@NonNull Pivot2CSConversion converter);
		@NonNull BaseReferenceVisitor createReferenceVisitor(@NonNull Pivot2CSConversion converter, @Nullable Namespace scope);

		/**
		 * Return a list of classes for which this Pivot2CS overrides a base Pivot2CS.
		 */
		@NonNull EClass[] getEClasses();
	}
	
	private @NonNull Map<EClass, Factory> factoryMap = new HashMap<EClass, Factory>();
	
	/**
	 * Mapping of each CS resource to its corresponding pivot Resource.
	 */
	protected final @NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap;
	
	public Pivot2CS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
		this.cs2asResourceMap = cs2asResourceMap;
	}
	
	public Pivot2CS(@NonNull Pivot2CS aConverter) {
		super(aConverter.metaModelManager);
		this.cs2asResourceMap = aConverter.cs2asResourceMap;
	}

	protected synchronized void addFactory(@NonNull Factory factory) {
		for (EClass eClass : factory.getEClasses()) {
			factoryMap.put(eClass, factory);
		}
	}

	public @NonNull BaseDeclarationVisitor createDefaultDeclarationVisitor(@NonNull Pivot2CSConversion conversion) {
		return new BaseDeclarationVisitor(conversion);
	}

	public @NonNull BaseReferenceVisitor createDefaultReferenceVisitor(@NonNull Pivot2CSConversion conversion) {
		return new BaseReferenceVisitor(conversion);
	}

	public @NonNull Collection<? extends Resource> getCSResources() {
		@SuppressWarnings("null") @NonNull Set<? extends Resource> keySet = cs2asResourceMap.keySet();
		return keySet;
	}

	public @Nullable Factory getFactory(@NonNull EClass eClass) {
		return factoryMap.get(eClass);
	}

	public @Nullable Resource getPivotResource(@NonNull Resource csResource) {
		return cs2asResourceMap.get(csResource);
	}

	public @NonNull Collection<? extends Resource> getPivotResources() {
		@SuppressWarnings("null") @NonNull Collection<? extends Resource> values = cs2asResourceMap.values();
		return values;
	}
	
	public void update() {
		Pivot2CSConversion conversion = new Pivot2CSConversion(this);
		Collection<? extends Resource> csResources = getCSResources();
		conversion.update(csResources);
		CSI2PivotMapping cs2PivotMapping = CSI2PivotMapping.getAdapter(metaModelManager);
		cs2PivotMapping.add(cs2asResourceMap);
		cs2PivotMapping.update(/*csResources*/);
	}
}