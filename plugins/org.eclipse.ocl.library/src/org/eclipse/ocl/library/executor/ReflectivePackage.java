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
package org.eclipse.ocl.library.executor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.ids.PackageId;
import org.eclipse.ocl.domain.utilities.DomainUtil;

/**
 * A ReflectivePackage builds a dispatch table representative of a model package at run-time using a minimal reflective API.
 */
public abstract class ReflectivePackage extends ExecutorPackage
{
	protected @Nullable Map<DomainClass, DomainInheritance> class2inheritance = null;

	public ReflectivePackage(@NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId) {
		super(name, nsPrefix, nsURI, packageId);
	}
	
	protected synchronized @NonNull Map<DomainClass, DomainInheritance> computeClasses() {
		Map<DomainClass, DomainInheritance> class2inheritance2 = class2inheritance = new HashMap<DomainClass, DomainInheritance>();
		for (DomainClass domainClass : getDomainClasses()) {
			if (domainClass != null) {
				DomainInheritance executorType = createInheritance(domainClass);
				class2inheritance2.put(domainClass, executorType);
			}
		}
		return class2inheritance2;
	}

	protected abstract @NonNull DomainInheritance createInheritance(@NonNull DomainClass domainClass);

	protected abstract @NonNull List<org.eclipse.ocl.pivot.Class> getDomainClasses();

	public @NonNull DomainInheritance getInheritance(@NonNull DomainClass domainClass) {
		Map<DomainClass, DomainInheritance> class2inheritance2 = class2inheritance;
		if (class2inheritance2 == null) {
			class2inheritance2 = computeClasses();
		}
		return DomainUtil.nonNullState(class2inheritance2.get(domainClass));
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Class> getOwnedClasses() {
/*		Map<DomainClass, DomainInheritance> types2 = class2inheritance;
		if (types2 == null) {
			types2 = computeClasses();
		}
		List<DomainInheritance> values2 = new ArrayList<DomainInheritance>(types2.values());
		return values2; */
		return getDomainClasses();
	}

	protected abstract @NonNull DomainStandardLibrary getStandardLibrary();
}