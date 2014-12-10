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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.domain.elements.DomainPackage;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.internal.impl.NamedElementImpl;
import org.eclipse.ocl.pivot.util.PivotPlugin;

public abstract class AbstractCompletePackages<Tinternal extends CompletePackageInternal, T extends CompletePackage> extends EObjectContainmentWithInverseEList<T>
{
	public static final @NonNull TracingOption COMPLETE_PACKAGES = new TracingOption(PivotPlugin.PLUGIN_ID, "completePackages");
//	static { COMPLETE_PACKAGES.setState(true); }
	private static final long serialVersionUID = 1L;

	/**
	 * Map of (nested) package-name to package server.
	 */
	private final @NonNull Map<String, Tinternal> name2completePackage = new HashMap<String, Tinternal>();

	public AbstractCompletePackages(Class<?> dataClass, @NonNull NamedElementImpl owner, int featureID, int inverseFeatureID) {
		super(dataClass, owner, featureID, inverseFeatureID);
		if (COMPLETE_PACKAGES.isActive()) {
			COMPLETE_PACKAGES.println("Create " + this);
		}
	}
	
	@Override
	public void addUnique(T completePackage) {
		assert completePackage != null;
		super.addUnique(completePackage);
		@SuppressWarnings("unchecked")Tinternal castCompletePackage = (Tinternal) completePackage;
		didAdd(castCompletePackage);
	}

	@Override
	public void addUnique(int index, T completePackage) {
		assert completePackage != null;
		super.addUnique(index, completePackage);
		@SuppressWarnings("unchecked")Tinternal castCompletePackage = (Tinternal) completePackage;
		didAdd(castCompletePackage);
	}

	public abstract @NonNull T createCompletePackage(@NonNull DomainPackage partialPackage);

	protected void didAdd(@NonNull Tinternal completePackage) {
		String name = completePackage.getName();
		if (name != null) {
			if (!name2completePackage.containsKey(name)) {
				CompletePackage oldCompletePackage = name2completePackage.put(name, completePackage);		// New name
				assert oldCompletePackage == null;
			}
			else {
				name2completePackage.put(name, null);														// Ambiguous name
			}
		}
		getCompleteModel().didAddCompletePackage(completePackage);
	}

	public void didAddPackage(@NonNull org.eclipse.ocl.pivot.Package pivotPackage) {
		CompletePackage completePackage = null;
		String name = pivotPackage.getName();
		String packageURI = pivotPackage.getURI();
		if (packageURI != null) {										// Explicit packageURI for explicit package (merge)
			completePackage = getCompleteModel().getCompleteURIs().getCompletePackage(packageURI);
		}
		else if (name != null) {										// Null packageURI can merge into same named package
			completePackage = getOwnedCompletePackage(name);
		}
		if (completePackage == null) {
			completePackage = getOwnedCompletePackage(pivotPackage);
			completePackage.assertSamePackage(pivotPackage);
		}
		completePackage.getPartialPackages().add(pivotPackage);
//		completePackage.addTrackedPackage(pivotPackage);
//		for (org.eclipse.ocl.pivot.Package nestedPackage : pivotPackage.getOwnedPackages()) {
//			if (nestedPackage != null) {
//				addPackage(completePackage, nestedPackage);
//			}
//		}
	}

	@Override
	protected void didRemove(int index, T completePackage) {
		assert completePackage != null;
		super.didRemove(index, completePackage);
		name2completePackage.remove(completePackage.getName());
		@SuppressWarnings("unchecked")Tinternal castCompletePackage = (Tinternal) completePackage;
		getCompleteModel().didRemoveCompletePackage(castCompletePackage);
	}

	public void didRemovePackage(@NonNull org.eclipse.ocl.pivot.Package partialPackage) {
		CompletePackage completePackage = getCompletePackage(partialPackage);
		List<Package> partialPackages = completePackage.getPartialPackages();
		partialPackages.remove(partialPackage);
		if (partialPackages.size() <= 0) {
			getCompleteModel().getCompleteURIs().removeCompletePackage(completePackage.getURI());
//			name2completePackage.remove(completePackage.getName());
			remove(completePackage);
		}
	}

	public synchronized void dispose() {
		Collection<Tinternal> savedCompletePackages = name2completePackage.values();
		name2completePackage.clear();
		for (Tinternal completePackage : savedCompletePackages) {
			((CompletePackageInternal)completePackage).dispose();
		}
	}

	protected abstract CompleteModelInternal getCompleteModel();

	public @NonNull Tinternal getCompletePackage(@NonNull DomainPackage pivotPackage) {
		Tinternal completePackage = null;
		if (pivotPackage instanceof CompletePackageInternal) {
			((CompletePackage)pivotPackage).assertSamePackage(pivotPackage);
			completePackage = (Tinternal)pivotPackage;
		}
		else {
			completePackage = (Tinternal)getCompleteModel().getCompleteURIs().getCompletePackage(pivotPackage);
			if (completePackage == null) {
				DomainPackage pivotPackageParent = pivotPackage.getOwningPackage();
				if (pivotPackageParent == null) {
					completePackage = getOwnedCompletePackage(pivotPackage);
					completePackage.getPartialPackages().add((org.eclipse.ocl.pivot.Package)pivotPackage);		// FIXME cast
//					completePackage.addTrackedPackage(pivotPackage);
					completePackage.assertSamePackage(pivotPackage);
				}
				else {
					CompletePackageInternal completeParentPackage = getCompletePackage(pivotPackageParent);
					@SuppressWarnings("unchecked")Tinternal completeChildPackage = (Tinternal)completeParentPackage.getOwnedCompletePackage(pivotPackage.getName());
					assert completeChildPackage != null;
					return completeChildPackage;
//					CompletePackageParent completePackageParent;
/*					PackageTracker parentTracker = getPackageTracker(pivotPackageParent);
					completePackageParent = parentTracker.getPackageServer();
					((PackageServer)completePackageParent).assertSamePackage(pivotPackageParent); */
//					completePackage = completePackageParent.getMemberPackageServer(pivotPackage);
//					completePackage.addTrackedPackage(pivotPackage);
//					completePackage.assertSamePackage(pivotPackage);
				}
			}
		}
		completePackage.assertSamePackage(pivotPackage);
		return completePackage;
	}

	public @Nullable Tinternal getOwnedCompletePackage(@Nullable String name) {
		return name2completePackage.get(name);
	}
	
	protected abstract @NonNull Tinternal getOwnedCompletePackage(@NonNull DomainPackage pivotPackage);

	protected abstract @NonNull Iterable<org.eclipse.ocl.pivot.Package> getPartialPackages();

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + owner.toString();
	}
}