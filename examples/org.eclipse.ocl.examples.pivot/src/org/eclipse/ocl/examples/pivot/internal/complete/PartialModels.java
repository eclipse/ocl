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
import org.eclipse.ocl.examples.pivot.Model;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteModelImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.ModelImpl;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

public class PartialModels extends EObjectResolvingEList<Model> implements ModelListeners.IModelListener
{
	public static final @NonNull TracingOption PARTIAL_MODELS = new TracingOption(PivotPlugin.PLUGIN_ID, "partialModels");
//	static { PARTIAL_ROOTS.setState(true); }
	private static final long serialVersionUID = 1L;

	private static class Model2RootOwnedPackages implements Function<Model, Iterable<org.eclipse.ocl.examples.pivot.Package>>
	{
		public Iterable<Package> apply(Model partialModel) {
			return partialModel.getOwnedPackages();
		}
	}
	private static final @NonNull Model2RootOwnedPackages model2RootOwnedPackages = new Model2RootOwnedPackages();


	public PartialModels(@NonNull CompleteModelImpl owner) {
		super(Model.class, owner, PivotPackage.COMPLETE_MODEL__PARTIAL_MODELS);
	}
	
	@Override
	public void addUnique(Model partialModel) {
		assert partialModel != null;
		super.addUnique(partialModel);
		didAdd(partialModel);
	}

	@Override
	public void addUnique(int index, Model partialModel) {
		assert partialModel != null;
		super.addUnique(index, partialModel);
		didAdd(partialModel);
	}

	protected void didAdd(@NonNull Model partialModel) {
		if (PARTIAL_MODELS.isActive()) {
			PARTIAL_MODELS.println("Do-didAdd Model" + this + " " + partialModel);
		}
		CompleteModel.Internal completeModel = getCompleteModel();
		completeModel.didAddPartialModel(partialModel);
		for (org.eclipse.ocl.examples.pivot.Package pivotPackage : partialModel.getOwnedPackages()) {
			if (pivotPackage != null) {
				completeModel.didAddNestedPackage(pivotPackage);
			}
		}
		((ModelImpl)partialModel).addRootListener(this);
	}

	public void didAddPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		getCompleteModel().didAddNestedPackage(partialPackage);
	}
	
	@Override
	protected void didRemove(int index, Model partialModel) {
		assert partialModel != null;
		if (PARTIAL_MODELS.isActive()) {
			PARTIAL_MODELS.println("Do-didRemove Model " + this + " " + partialModel);
		}
		didRemove(partialModel);
	}

	protected void didRemove(@NonNull Model partialModel) {
		((ModelImpl)partialModel).removeRootListener(this);
		CompleteModel.Internal completeModel = getCompleteModel();
		for (org.eclipse.ocl.examples.pivot.Package pivotPackage : partialModel.getOwnedPackages()) {
			if (pivotPackage != null) {
				completeModel.didRemoveNestedPackage(pivotPackage);
			}
		}
		completeModel.didRemovePartialModel(partialModel);
	}

	public void didRemovePackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		getCompleteModel().didRemoveNestedPackage(partialPackage);
	}
	
	@SuppressWarnings("null")
	protected @NonNull CompleteModel.Internal getCompleteModel() {
		return (CompleteModel.Internal)owner;
	}

	protected @NonNull Iterable<org.eclipse.ocl.examples.pivot.Package> getNestedPartialPackages() {
		PartialModels partialModels = getCompleteModel().getPartialModels();
		Iterable<Iterable<org.eclipse.ocl.examples.pivot.Package>> roots_packages = Iterables.transform(partialModels, model2RootOwnedPackages);
		@SuppressWarnings("null")@NonNull Iterable<Package> allPackages = Iterables.concat(roots_packages);
		return allPackages;
	}
}