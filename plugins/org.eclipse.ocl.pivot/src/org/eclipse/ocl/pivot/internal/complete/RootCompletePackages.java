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

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.elements.DomainPackage;
import org.eclipse.ocl.domain.ids.PackageId;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.RootCompletePackage;
import org.eclipse.ocl.pivot.internal.impl.CompleteModelImpl;
import org.eclipse.ocl.pivot.manager.Orphanage;

public class RootCompletePackages extends AbstractCompletePackages<RootCompletePackageInternal, RootCompletePackage>
{
	private static final Logger logger = Logger.getLogger(RootCompletePackages.class);

	private static final long serialVersionUID = 1L;

	public RootCompletePackages(@NonNull CompleteModelImpl owner) {
		super(RootCompletePackage.class, owner, PivotPackage.COMPLETE_MODEL__OWNED_COMPLETE_PACKAGES, PivotPackage.ROOT_COMPLETE_PACKAGE__OWNING_COMPLETE_MODEL);
	}

	@Override
	public @NonNull RootCompletePackageInternal createCompletePackage(@NonNull DomainPackage partialPackage) {
		RootCompletePackageInternal completePackage = (RootCompletePackageInternal) PivotFactory.eINSTANCE.createParentCompletePackage();
		completePackage.init(partialPackage.getName(), partialPackage.getNsPrefix(), partialPackage.getURI(), partialPackage.getPackageId());
		return completePackage;
	}
	
	protected @NonNull RootCompletePackageInternal createRootCompletePackage(@NonNull DomainPackage pivotPackage) {
		String name = pivotPackage.getName();
//		if (name == null) {
//			throw new IllegalStateException("Unnamed package");
//		}
		String nonNullName = name;
		if (nonNullName == null) {
			nonNullName = "$anon_" + Integer.toHexString(System.identityHashCode(pivotPackage));
		}
		String nsPrefix = pivotPackage.getNsPrefix();
		String completeURI = getCompleteModel().getCompleteURIs().getCompleteURI(pivotPackage.getURI());
		PackageId packageId = pivotPackage.getPackageId();
		RootCompletePackageInternal rootCompletePackage;
		if (Orphanage.isTypeOrphanage(pivotPackage)) {
			rootCompletePackage = getCompleteModel().getOrphanCompletePackage();
		}
		else {
			PackageId metapackageId = getCompleteModel().getMetaModelManager().getMetapackageId(pivotPackage);
			ParentCompletePackageInternal parentCompletePackage = (ParentCompletePackageInternal) PivotFactory.eINSTANCE.createParentCompletePackage();
			parentCompletePackage.init(nonNullName, nsPrefix, completeURI, packageId, metapackageId);
			rootCompletePackage = parentCompletePackage;
			add(rootCompletePackage);
		}
		return rootCompletePackage;
	}

	@Override
	protected void didAdd(@NonNull RootCompletePackageInternal rootCompletePackage) {
		super.didAdd(rootCompletePackage);
//		String nsURI = rootCompletePackage.getURI();			// FIXME complete/package/URI/name
//		String sharedNsURI = getCompleteURI(nsURI);
//		if ((sharedNsURI != null) && (sharedNsURI == nsURI)) {
//			name2completePackage.put(nsURI, rootCompletePackage);
//		}
	}

	@Override
	protected void didRemove(int index, RootCompletePackage rootCompletePackage) {
		assert rootCompletePackage != null;
		super.didRemove(index, rootCompletePackage);
//		getCompleteModel().didRemoveCompletePackage(rootCompletePackage);
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull CompleteModelInternal getCompleteModel() {
		return (CompleteModelInternal)owner;
	}

	@Override
	public @NonNull RootCompletePackageInternal getOwnedCompletePackage(@NonNull DomainPackage pivotPackage) {
		//
		//	Try to find package by packageURI
		//
		CompletePackageInternal completePackage = getCompleteModel().getCompleteURIs().getCompletePackage(pivotPackage);
		if (completePackage != null) {
			return (RootCompletePackageInternal) completePackage;
		}
		//
		//	Else generate an error for a name-less Package, fatally if also packageURI-less.
		//
		String packageURI = pivotPackage.getURI();
		String name = pivotPackage.getName();
		if (name == null) {
			String message = null;
			if (pivotPackage instanceof EObject) {
				for (EObject eObject = (EObject) pivotPackage; eObject != null; eObject = eObject.eContainer()) {
					if (eObject instanceof Model) {
						message = "Unnamed package for '" + packageURI + "' in '" + ((Model)eObject).getExternalURI() + "'";
						break;
					}
				}
			}
			if (message == null) {
				message = "Unnamed package for '" + packageURI + "'";
			}
			logger.error(message);
			name = packageURI;
			if (name == null) {
				throw new IllegalStateException(message);
			}
		}
		//
		//	Try to find package by name, provided there is no packageURI conflict
		//
		RootCompletePackageInternal rootCompletePackage = getOwnedCompletePackage(name);
		if (rootCompletePackage != null) {
			String completeURI2 = rootCompletePackage.getURI();
			if ((packageURI == null) || (completeURI2 == null) || packageURI.equals(completeURI2)) {
				return rootCompletePackage;
			}
		}
		rootCompletePackage = createRootCompletePackage(pivotPackage);
		return rootCompletePackage;
	}

	@Override
	protected @NonNull Iterable<org.eclipse.ocl.pivot.Package> getPartialPackages() {
		return getCompleteModel().getPartialModels().getNestedPartialPackages();
	}
}