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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.pivot.CompleteModel;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteModelImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.RootImpl;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

public class PartialRoots extends EObjectResolvingEList<Root> implements RootListeners.IRootListener
{
	public static final @NonNull TracingOption PARTIAL_ROOTS = new TracingOption(PivotPlugin.PLUGIN_ID, "partialRoots");
//	static { PARTIAL_ROOTS.setState(true); }
	private static final long serialVersionUID = 1L;

	private static class Root2RootOwnedPackages implements Function<Root, Iterable<org.eclipse.ocl.examples.pivot.Package>>
	{
		public Iterable<Package> apply(Root partialRoot) {
			return partialRoot.getOwnedPackages();
		}
	}
	private static final @NonNull Root2RootOwnedPackages root2RootOwnedPackages = new Root2RootOwnedPackages();


	public PartialRoots(@NonNull CompleteModelImpl owner) {
		super(Root.class, owner, PivotPackage.COMPLETE_MODEL__PARTIAL_ROOTS);
	}
	
	@Override
	public void addUnique(Root partialRoot) {
		assert partialRoot != null;
		super.addUnique(partialRoot);
		didAdd(partialRoot);
	}

	@Override
	public void addUnique(int index, Root partialRoot) {
		assert partialRoot != null;
		super.addUnique(index, partialRoot);
		didAdd(partialRoot);
	}

	protected void didAdd(@NonNull Root partialRoot) {
		if (PARTIAL_ROOTS.isActive()) {
			PARTIAL_ROOTS.println("Do-didAdd Root" + this + " " + partialRoot);
		}
		CompleteModel.Internal completeModel = getCompleteModel();
		completeModel.didAddPartialRoot(partialRoot);
		for (org.eclipse.ocl.examples.pivot.Package pivotPackage : partialRoot.getOwnedPackages()) {
			if (pivotPackage != null) {
				completeModel.didAddNestedPackage(pivotPackage);
			}
		}
		((RootImpl)partialRoot).addRootListener(this);
	}

	public void didAddPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		getCompleteModel().didAddNestedPackage(partialPackage);
	}
	
	@Override
	protected void didRemove(int index, Root partialRoot) {
		assert partialRoot != null;
		if (PARTIAL_ROOTS.isActive()) {
			PARTIAL_ROOTS.println("Do-didRemove Root " + this + " " + partialRoot);
		}
		didRemove(partialRoot);
	}

	protected void didRemove(@NonNull Root partialRoot) {
		((RootImpl)partialRoot).removeRootListener(this);
		CompleteModel.Internal completeModel = getCompleteModel();
		for (org.eclipse.ocl.examples.pivot.Package pivotPackage : partialRoot.getOwnedPackages()) {
			if (pivotPackage != null) {
				completeModel.didRemoveNestedPackage(pivotPackage);
			}
		}
		completeModel.didRemovePartialRoot(partialRoot);
	}

	public void didRemovePackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		getCompleteModel().didRemoveNestedPackage(partialPackage);
	}
	
	@SuppressWarnings("null")
	protected @NonNull CompleteModel.Internal getCompleteModel() {
		return (CompleteModel.Internal)owner;
	}

	protected @NonNull Iterable<org.eclipse.ocl.examples.pivot.Package> getNestedPartialPackages() {
		PartialRoots partialRoots = getCompleteModel().getPartialRoots();
		Iterable<Iterable<org.eclipse.ocl.examples.pivot.Package>> roots_packages = Iterables.transform(partialRoots, root2RootOwnedPackages);
		@SuppressWarnings("null")@NonNull Iterable<Package> allPackages = Iterables.concat(roots_packages);
		return allPackages;
	}
}