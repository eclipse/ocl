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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.elements.DomainPackage;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.NestedCompletePackage;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.impl.CompletePackageImpl;

public class NestedCompletePackages extends AbstractCompletePackages<NestedCompletePackage.Internal, NestedCompletePackage>
{
	private static final long serialVersionUID = 1L;

	public NestedCompletePackages(@NonNull CompletePackageImpl owner) {
		super(NestedCompletePackage.class, owner, PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES,
			PivotPackage.NESTED_COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE);
		doRefreshNestedPackages();
	}

	@Override
	public @NonNull NestedCompletePackage.Internal createCompletePackage(@NonNull DomainPackage partialPackage) {
		NestedCompletePackage.Internal completePackage = (NestedCompletePackage.Internal) PivotFactory.eINSTANCE.createNestedCompletePackage();
		completePackage.init(partialPackage.getName(), partialPackage.getNsPrefix(), partialPackage.getURI(), partialPackage.getPackageId());
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
	public @NonNull CompleteModel.Internal getCompleteModel() {
		return getCompletePackage().getCompleteModel();
	}

	@SuppressWarnings("null")
	public @NonNull CompletePackage.Internal getCompletePackage() {
		return (CompletePackage.Internal)owner;
	}

	@Override
	public @NonNull NestedCompletePackage.Internal getOwnedCompletePackage(@NonNull DomainPackage partialPackage) {
		String name = partialPackage.getName();
		NestedCompletePackage.Internal completePackage = super.getOwnedCompletePackage(name);
		if (completePackage == null) {
			completePackage = createCompletePackage(partialPackage);			
			completePackage.getPartialPackages().add((org.eclipse.ocl.pivot.Package)partialPackage);		// FIXME cast
			add(completePackage);
		}
		return completePackage;
	}

	@Override
	protected @NonNull Iterable<org.eclipse.ocl.pivot.Package> getPartialPackages() {
		return getCompletePackage().getPartialPackages().getNestedPartialPackages();
	}
}