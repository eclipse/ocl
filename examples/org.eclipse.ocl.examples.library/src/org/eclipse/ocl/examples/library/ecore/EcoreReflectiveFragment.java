/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.ecore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.library.executor.ReflectiveFragment;

public class EcoreReflectiveFragment extends ReflectiveFragment
{
	protected final @NonNull EClassifier eClassifier;

	public EcoreReflectiveFragment(@NonNull EcoreReflectiveType derivedInheritance, @NonNull DomainInheritance baseInheritance) {
		super(derivedInheritance, baseInheritance);
		this.eClassifier = derivedInheritance.getEClassifier();		
	}

	public final @NonNull EClassifier getEClassifier() {
		return eClassifier;
	}
	
	@Override
	public @NonNull Iterable<? extends DomainProperty> getLocalProperties() {
		Map<DomainProperty, LibraryFeature> propertyMap2 = propertyMap;
		if (propertyMap2 == null) {
			synchronized (this) {
				propertyMap2 = propertyMap;
				if (propertyMap2 == null) {
					propertyMap = propertyMap2 = initProperties();		// Optimize to reuse single super map if no local ops
				}
			}
		}
		@SuppressWarnings("null")@NonNull Set<DomainProperty> keySet = propertyMap2.keySet();
		return keySet;
	}

	@Override
	public @Nullable DomainOperation getLocalOperation(@NonNull DomainOperation baseOperation) {
		throw new UnsupportedOperationException();		// FIXME
	}

	protected @NonNull Map<DomainProperty, LibraryFeature> initProperties() {
		Map<DomainProperty, LibraryFeature> map = new HashMap<DomainProperty, LibraryFeature>();
		List<EStructuralFeature> eStructuralFeatures = ((EClass) eClassifier).getEStructuralFeatures();
		for (int i = 0; i < eStructuralFeatures.size(); i++) {
			@SuppressWarnings("null")@NonNull EStructuralFeature eFeature = eStructuralFeatures.get(i);
			EcoreExecutorProperty propertyAndImplementation = new EcoreExecutorProperty(eFeature, getDerivedInheritance(), i);
			map.put(propertyAndImplementation, propertyAndImplementation);
		}
		return map;
	}
}