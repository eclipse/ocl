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
package org.eclipse.ocl.examples.library.executor;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.types.AbstractMetaclass;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;

public class ExecutorStandardLibrary extends ExecutableStandardLibrary
{
	private @NonNull Map<String, WeakReference<EcoreExecutorPackage>> ePackageMap = new WeakHashMap<String, WeakReference<EcoreExecutorPackage>>();
	private Map<DomainPackage, WeakReference<DomainReflectivePackage>> domainPackageMap = null;
	private /*@LazyNonNull*/ Map<EcoreExecutorPackage, List<EcoreExecutorPackage>> extensions = null;
	private /*@LazyNonNull*/ DomainType enumerationType = null;
	private /*@LazyNonNull*/ DomainType metaclassType = null;
	
	public ExecutorStandardLibrary(EcoreExecutorPackage... execPackages) {
		OCLstdlibTables.PACKAGE.getClass();
		for (EcoreExecutorPackage execPackage : execPackages) {
			assert execPackage != null;
			addPackage(execPackage, null);
		}
	}

	public void addExtension(@NonNull EcoreExecutorPackage basePackage, @NonNull EcoreExecutorPackage extensionPackage) {
		Map<EcoreExecutorPackage, List<EcoreExecutorPackage>> extensions2 = extensions;
		if (extensions2 == null) {
			extensions = extensions2 = new HashMap<EcoreExecutorPackage, List<EcoreExecutorPackage>>();
		}
		List<EcoreExecutorPackage> list = extensions2.get(basePackage);
		if (list == null) {
			list = new ArrayList<EcoreExecutorPackage>();
			extensions2.put(basePackage, list);
		}
		list.add(extensionPackage);
	}

	public synchronized void addPackage(@NonNull EcoreExecutorPackage execPackage, @Nullable EcoreExecutorPackage extendedPackage) {
		@SuppressWarnings("unused")
		WeakReference<EcoreExecutorPackage> oldExecPackage = ePackageMap.put(execPackage.getNsURI(), new WeakReference<EcoreExecutorPackage>(execPackage));
//		if ((oldExecPackage != null) && (oldExecPackage != execPackage)) {
//			Iterable<ExecutorType> newTypes = execPackage.getOwnedType();
//			for (DomainType oldType : oldExecPackage.getOwnedType()) {
//				-- check for type compatibility
//			}
//		}
	}

	@Override
	protected @NonNull DomainMetaclass createMetaclass(@NonNull DomainType classType) {
		DomainMetaclass metaclass = new AbstractMetaclass(this, classType);
		return metaclass;
	}

	public @NonNull DomainType getEnumerationType() {
		Map<EcoreExecutorPackage, List<EcoreExecutorPackage>> extensions2 = extensions;
		if (extensions2 == null) {
			throw new IllegalStateException("No extension package registered to define Enumeration type"); //$NON-NLS-1$
		}
		if (enumerationType != null) {
			return enumerationType;
		}
		for (EcoreExecutorPackage basePackage : extensions2.keySet()) {
			for (EcoreExecutorPackage extensionPackage : extensions2.get(basePackage)) {
				for (DomainType type : extensionPackage.getOwnedType()) {
					if ("Enumeration".equals(type.getName())) { //$NON-NLS-1$
						enumerationType = type;
						return type;
					}
				}
			}
		}
		throw new IllegalStateException("No extension package defines Enumeration type"); //$NON-NLS-1$
	}

	public @NonNull DomainInheritance getInheritance(@NonNull DomainType type) {
		if (type instanceof DomainInheritance) {
			return (DomainInheritance) type;
		}
		if (type instanceof DomainMetaclass) {
			DomainType instanceType = DomainUtil.nonNullPivot(((DomainMetaclass)type).getInstanceType());
			DomainMetaclass metaclass = getMetaclass(instanceType);
			DomainType containerType = metaclass.getContainerType();
			return containerType.getInheritance(this);
		}
		if (type instanceof DomainCollectionType) {
			DomainType containerType = ((DomainCollectionType)type).getContainerType();
			if ((containerType != null) && (containerType != type)) {
				return containerType.getInheritance(this);
			}
		}
		DomainPackage domainPackage = type.getPackage();
		Map<DomainPackage, WeakReference<DomainReflectivePackage>> domainPackageMap2;
		synchronized (this) {
			String nsURI = domainPackage.getNsURI();
			EcoreExecutorPackage ecoreExecutorPackage = nsURI != null ? weakGet(ePackageMap, nsURI) : null;
			if (ecoreExecutorPackage != null) {
				DomainInheritance executorType = ecoreExecutorPackage.getType(type.getName());
				if (executorType != null) {
					return executorType;
				}
				Map<EcoreExecutorPackage, List<EcoreExecutorPackage>> extensions2 = extensions;
				if (extensions2 != null) {
					List<EcoreExecutorPackage> packages = extensions2.get(ecoreExecutorPackage);
					if (packages != null) {
						for (EcoreExecutorPackage extensionPackage : packages) {
							executorType = extensionPackage.getType(type
								.getName());
							if (executorType != null) {
								return executorType;
							}
						}
					}
				}
			}
			domainPackageMap2 = domainPackageMap;
			if (domainPackageMap2 == null) {
				domainPackageMap2 = domainPackageMap = new WeakHashMap<DomainPackage, WeakReference<DomainReflectivePackage>>();
			}
		}
		synchronized (domainPackageMap2) {
			DomainReflectivePackage domainExecutorPackage = weakGet(domainPackageMap2, domainPackage);
			if (domainExecutorPackage == null) {
				domainExecutorPackage = new DomainReflectivePackage(this, domainPackage);
				domainPackageMap2.put(domainPackage, new WeakReference<DomainReflectivePackage>(domainExecutorPackage));
			}
			return domainExecutorPackage.getInheritance(type);
		}
	}

	public @NonNull DomainType getMetaclassType() {
		Map<EcoreExecutorPackage, List<EcoreExecutorPackage>> extensions2 = extensions;
		if (extensions2 == null) {
			throw new IllegalStateException("No extension package registered to define Metaclass type"); //$NON-NLS-1$
		}
		if (metaclassType != null) {
			return metaclassType;
		}
		for (EcoreExecutorPackage basePackage : extensions2.keySet()) {
			for (EcoreExecutorPackage extensionPackage : extensions2.get(basePackage)) {
				for (DomainType type : extensionPackage.getOwnedType()) {
					if ("Metaclass".equals(type.getName())) { //$NON-NLS-1$
						metaclassType = type;
						return type;
					}
				}
			}
		}
		throw new IllegalStateException("No extension package defines Metaclass type"); //$NON-NLS-1$
	}

	@Override
	public @Nullable DomainType getNestedType(@NonNull DomainPackage parentPackage, @NonNull String name) {
		DomainType nestedType = super.getNestedType(parentPackage, name);
		if (nestedType != null) {
			return nestedType;
		}
		if (extensions != null) {
			List<EcoreExecutorPackage> list = extensions.get(parentPackage);
			if (list != null) {
				for (EcoreExecutorPackage extensionPackage : list) {
					assert extensionPackage != null;
					nestedType = super.getNestedType(extensionPackage, name);
					if (nestedType != null) {
						return nestedType;
					}
				}
			}
		}
		return nestedType;
	}

	@Override
	public DomainPackage getNsURIPackage(@NonNull String nsURI) {
		WeakReference<EcoreExecutorPackage> weakReference = ePackageMap.get(nsURI);
		if (weakReference == null) {
			return null;
		}
		return weakReference.get();
	}

	public synchronized @Nullable EcoreExecutorPackage getPackage(@NonNull EPackage ePackage) {
		String nsURI = ePackage.getNsURI();
		return nsURI != null ? weakGet(ePackageMap, nsURI) : null;
	}

	public synchronized DomainInheritance getOclType(@NonNull String typeName) {
		for (WeakReference<EcoreExecutorPackage> dPackage : ePackageMap.values()) {
// FIXME			if (OCLstdlibTables.PACKAGE.getNsURI().equals(dPackage.getNsURI())) {
			if (dPackage != null) {
				EcoreExecutorPackage packageRef = dPackage.get();
				if (packageRef != null) {
					DomainInheritance type = packageRef.getType(typeName);
					if (type != null) {
						return type;
					}
				}
			}
		}
		return null;
	}
}
