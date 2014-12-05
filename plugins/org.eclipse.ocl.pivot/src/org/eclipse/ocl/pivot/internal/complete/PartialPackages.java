/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.complete;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.NestedCompletePackage;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.impl.CompletePackageImpl;
import org.eclipse.ocl.pivot.internal.impl.PackageImpl;
import org.eclipse.ocl.pivot.manager.CompleteInheritance;
import org.eclipse.ocl.pivot.util.PivotPlugin;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

public final class PartialPackages extends EObjectResolvingEList<org.eclipse.ocl.pivot.Package> implements PackageListeners.IPackageListener
{
	private static class Package2PackageOwnedPackages implements Function<org.eclipse.ocl.pivot.Package, Iterable<org.eclipse.ocl.pivot.Package>>
	{
		@Override
		public Iterable<org.eclipse.ocl.pivot.Package> apply(org.eclipse.ocl.pivot.Package partialPackage) {
			return partialPackage.getOwnedPackages();
		}
	}

	private static final @NonNull Package2PackageOwnedPackages package2PackageOwnedPackages = new Package2PackageOwnedPackages();
	public static final @NonNull TracingOption PARTIAL_PACKAGES = new TracingOption(PivotPlugin.PLUGIN_ID, "partialPackages");
//	static { PARTIAL_PACKAGES.setState(true); }
	private static final long serialVersionUID = 1L;

	/**
	 * Map of (nested) package-name to package server.
	 */
	private Map<String, NestedCompletePackage> name2nestedCompletePackage = null;
	
	/**
	 * Lazily created map of nested class-name to its inheritance.
	 */
	protected final @NonNull Map<String, CompleteInheritance> name2inheritance = new HashMap<String, CompleteInheritance>();

	public PartialPackages(@NonNull CompletePackageImpl owner) {
		super(org.eclipse.ocl.pivot.Package.class, owner, PivotPackage.COMPLETE_PACKAGE__PARTIAL_PACKAGES);
	}

	@Override
	public void addUnique(org.eclipse.ocl.pivot.Package partialPackage) {
		assert partialPackage != null;
		didAdd(partialPackage);
		super.addUnique(partialPackage);
	}

	@Override
	public void addUnique(int index, org.eclipse.ocl.pivot.Package partialPackage) {
		assert partialPackage != null;
		didAdd(partialPackage);
		super.addUnique(index, partialPackage);
	}

	protected void didAdd(@NonNull org.eclipse.ocl.pivot.Package partialPackage) {
		if (PARTIAL_PACKAGES.isActive()) {
			PARTIAL_PACKAGES.println("Do-didAdd " + this + " " + partialPackage);
		}
		((PackageImpl)partialPackage).addPackageListener(this);
		getCompletePackage().didAddPartialPackage(partialPackage);
	}

	@Override
	public void didAddPackage(@NonNull org.eclipse.ocl.pivot.Package nestedPackage) {
		getCompletePackage().didAddNestedPackage(nestedPackage);
	}

/*	public void didAddClass(@NonNull CompleteClass completeClass, @NonNull DomainClass partialClass) {
		if (getCompleteModel().didAddClass(partialClass, completeClass)) {
			((CompleteClassImpl)completeClass).getPartialClasses().initMemberFeaturesFrom((org.eclipse.ocl.pivot.Class)partialClass);	
		}
	} */
	
/*	protected void didAddCompleteClass(@NonNull CompleteClass completeClass) {
		Map<String, CompleteClass> name2completeClass2 = name2completeClass;
		if (name2completeClass2 != null) {
			String name = completeClass.getName();
			if (name != null) {
				CompleteClass oldCompleteClass = name2completeClass2.put(name, completeClass);
				assert oldCompleteClass == null;
			}
		}
	} */

	void didAddNestedCompletePackage(@NonNull NestedCompletePackage nestedCompletePackage) {
		assert name2nestedCompletePackage != null;
		String name = nestedCompletePackage.getName();
		if (name != null) {
			CompletePackage oldCompletePackage = name2nestedCompletePackage.put(name, nestedCompletePackage);
			assert oldCompletePackage == null;
		}
	}

/*	protected void didRemoveCompleteClass(@NonNull CompleteClass completeClass) {
		Map<String, CompleteClass> name2completeClass2 = name2completeClass;
		if (name2completeClass2 != null) {
			String name = completeClass.getName();
			if (name != null) {
				CompleteClass oldCompleteClass = name2completeClass2.remove(name);
				assert oldCompleteClass == completeClass;
			}
		}
	} */
	
	void didRemoveNestedCompletePackage(@NonNull NestedCompletePackage nestedCompletePackage) {
		assert name2nestedCompletePackage != null;
		String name = nestedCompletePackage.getName();
		if (name != null) {
			name2nestedCompletePackage.remove(name);
		}
	}

	@Override
	protected void didRemove(int index, org.eclipse.ocl.pivot.Package partialPackage) {
		assert partialPackage != null;
		if (PARTIAL_PACKAGES.isActive()) {
			PARTIAL_PACKAGES.println("Do-didRemove " + this + " " + partialPackage);
		}
		super.didRemove(index, partialPackage);
		((PackageImpl)partialPackage).removePackageListener(this);
		getCompletePackage().didRemovePartialPackage(partialPackage);
	}

	@Override
	public void didRemovePackage(@NonNull org.eclipse.ocl.pivot.Package nestedPackage) {
		getCompletePackage().didRemoveNestedPackage(nestedPackage);
	}

	@Override
	public void didAddClass(@NonNull org.eclipse.ocl.pivot.Class partialClass) {
		getCompletePackage().didAddClass(partialClass);
	}

	@Override
	public void didRemoveClass(@NonNull org.eclipse.ocl.pivot.Class partialClass) {
		name2inheritance.remove(partialClass.getName());
		getCompletePackage().didRemoveClass(partialClass);
	}

	public @NonNull CompleteInheritance getCompleteInheritance(@NonNull CompleteClass.Internal completeClass) {
		String name = completeClass.getName();
		CompleteInheritance completeInheritance = name2inheritance.get(name);
		if (completeInheritance == null) {
			completeInheritance = new CompleteInheritance(completeClass);
			name2inheritance.put(name, completeInheritance);
		}
		return completeInheritance;
	}

	public @NonNull CompleteModel.Internal getCompleteModel() {
		return getCompletePackage().getCompleteModel();
	}

	@SuppressWarnings("null")
	public @NonNull CompletePackageImpl getCompletePackage() {
		return (CompletePackageImpl) owner;
	}

	protected @NonNull Iterable<org.eclipse.ocl.pivot.Package> getNestedPartialPackages() {
		PartialPackages partialPackages = getCompletePackage().getPartialPackages();
		Iterable<Iterable<org.eclipse.ocl.pivot.Package>> roots_packages = Iterables.transform(partialPackages, package2PackageOwnedPackages);
		@SuppressWarnings("null")@NonNull Iterable<Package> allPackages = Iterables.concat(roots_packages);
		return allPackages;
	}
}