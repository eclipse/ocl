/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.library.ecore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorPackage;

public class EcoreReflectivePackage extends ExecutorPackage
{
	protected final @NonNull EcoreIdResolver idResolver;
//	protected final @NonNull ExecutorStandardLibrary standardLibrary;
	protected final EPackage ePackage;
	protected @Nullable Map<EClassifier, DomainInheritance> types = null;
	protected @Nullable Map<String, EcoreReflectivePackage> nestedPackages = null;
	
	public EcoreReflectivePackage(@NonNull EPackage ePackage, @NonNull EcoreIdResolver idResolver, @NonNull PackageId packageId) {
		super(DomainUtil.nonNullEMF(ePackage.getName()), ePackage.getNsPrefix(), ePackage.getNsURI(), packageId);
		this.idResolver = idResolver;
//		this.standardLibrary = idResolver.getStandardLibrary();
		this.ePackage = ePackage;
	}
	
	protected synchronized @NonNull Map<EClassifier, DomainInheritance> computeClasses() {
		Map<EClassifier, DomainInheritance> types2 = types = new HashMap<EClassifier, DomainInheritance>();
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier != null) {
				DomainInheritance executorType;
				if (eClassifier instanceof EEnum) {
					executorType = new EcoreReflectiveEnumeration(this, 0, (EEnum)eClassifier);
				}
				else {
					executorType = new EcoreReflectiveType(this, 0, eClassifier);
				}
				types2.put(eClassifier, executorType);
			}
		}
		return types2;
	}

//	@Override
//	protected @NonNull DomainInheritance createExecutorType(@NonNull DomainType domainType) {
//		throw new UnsupportedOperationException();		// FIXME
//	}

//	@Override
//	protected @NonNull Iterable<? extends DomainType> getDomainTypes() {
//		throw new UnsupportedOperationException();		// FIXME
//	}

	public @NonNull EcoreIdResolver getIdResolver() {
		return idResolver;
	}

	public List<? extends DomainPackage> getNestedPackage() {
		Map<String, EcoreReflectivePackage> nestedPackages2 = nestedPackages;
		if (nestedPackages2 == null) {
			nestedPackages = nestedPackages2 = new HashMap<String, EcoreReflectivePackage>();
			for (EPackage eSubPackage : ePackage.getESubpackages()) {
				if (eSubPackage != null) {
					PackageId subPackageId = IdManager.getPackageId(eSubPackage);
					EcoreReflectivePackage executorPackage = new EcoreReflectivePackage(eSubPackage, idResolver, subPackageId);
					nestedPackages2.put(eSubPackage.getName(), executorPackage);
				}
			}
		}
		return new ArrayList<DomainPackage>(nestedPackages2.values());
	}

	public DomainPackage getNestingPackage() {
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull List<DomainInheritance> getOwnedType() {
		Map<EClassifier, DomainInheritance> types2 = types;
		if (types2 == null) {
			types2 = computeClasses();
		}
		List<DomainInheritance> values2 = new ArrayList<DomainInheritance>(types2.values());
		return values2;
	}

	@Override
	public DomainInheritance getType(String typeName) {
		for (DomainInheritance type: getOwnedType()) {
			if (type.getName().equals(typeName)) {
				return type;
			}
		}
		return null;
	}

	public @NonNull DomainStandardLibrary getStandardLibrary() {
		return idResolver.getStandardLibrary();
	}
}
