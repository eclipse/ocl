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
package org.eclipse.ocl.examples.pivot.internal.complete;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.pivot.CompleteModel;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.internal.impl.NamedElementImpl;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;

public abstract class AbstractCompletePackages<Tinternal extends CompletePackage.Internal, T extends CompletePackage> extends EObjectContainmentWithInverseEList<T>
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
		didAdd((Tinternal) completePackage);
	}

	@Override
	public void addUnique(int index, T completePackage) {
		assert completePackage != null;
		super.addUnique(index, completePackage);
		didAdd((Tinternal) completePackage);
	}

	public abstract @NonNull T createCompletePackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage);

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

	@Override
	protected void didRemove(int index, T completePackage) {
		assert completePackage != null;
		super.didRemove(index, completePackage);
		name2completePackage.remove(completePackage.getName());
		getCompleteModel().didRemoveCompletePackage((Tinternal)completePackage);
	}

	public synchronized void dispose() {
		Collection<Tinternal> savedCompletePackages = name2completePackage.values();
		name2completePackage.clear();
		for (Tinternal completePackage : savedCompletePackages) {
			((CompletePackage.Internal)completePackage).dispose();
		}
	}

	protected abstract CompleteModel.Internal getCompleteModel();

	public @Nullable Tinternal getOwnedCompletePackage(@Nullable String name) {
		return name2completePackage.get(name);
	}

	protected abstract @NonNull Iterable<org.eclipse.ocl.examples.pivot.Package> getPartialPackages();

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + owner.toString();
	}
}