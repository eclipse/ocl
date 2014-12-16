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
package org.eclipse.ocl.pivot.complete;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.impl.CompletePackageImpl;

public class NestedCompletePackages extends AbstractCompletePackages
{
	private static final long serialVersionUID = 1L;

	public NestedCompletePackages(@NonNull CompletePackageImpl owner) {
		super(CompletePackage.class, owner, PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES,
			PivotPackage.COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE);
		doRefreshNestedPackages();
	}

	@Override
	public @NonNull CompletePackageInternal createCompletePackage(@NonNull org.eclipse.ocl.pivot.Package partialPackage) {
		CompletePackageInternal completePackage = (CompletePackageInternal) PivotFactory.eINSTANCE.createCompletePackage();
		completePackage.init(partialPackage.getName(), partialPackage.getNsPrefix(), partialPackage.getURI());
		return completePackage;
	}

	protected void doRefreshNestedPackages() {
		for (org.eclipse.ocl.pivot.Package partialPackage : getPartialPackages()) {
//			for (org.eclipse.ocl.pivot.Package partialChildPackage : partialParentPackage.getOwnedPackages()) {
				if (partialPackage != null) {
					getOwnedCompletePackage(partialPackage);
				}
//			}
		}
	}

	@Override
	public @NonNull CompleteModelInternal getCompleteModel() {
		return getCompletePackage().getCompleteModel();
	}

	@SuppressWarnings("null")
	public @NonNull CompletePackageInternal getCompletePackage() {
		return (CompletePackageInternal)owner;
	}

	@Override
	public @NonNull CompletePackageInternal getOwnedCompletePackage(@NonNull org.eclipse.ocl.pivot.Package partialPackage) {
		String name = partialPackage.getName();
		CompletePackageInternal completePackage = super.getOwnedCompletePackage(name);
		if (completePackage == null) {
			completePackage = createCompletePackage(partialPackage);
			completePackage.getPartialPackages().add(partialPackage);
			add(completePackage);
		}
		return completePackage;
	}

	@Override
	protected @NonNull Iterable<org.eclipse.ocl.pivot.Package> getPartialPackages() {
		return getCompletePackage().getPartialPackages().getNestedPartialPackages();
	}
}