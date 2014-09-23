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

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.CompleteModel;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.Model;
import org.eclipse.ocl.examples.pivot.ParentCompletePackage;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.RootCompletePackage;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteModelImpl;
import org.eclipse.ocl.examples.pivot.manager.Orphanage;

public class RootCompletePackages extends AbstractCompletePackages<RootCompletePackage.Internal, RootCompletePackage>
{
	private static final Logger logger = Logger.getLogger(RootCompletePackages.class);

	private static final long serialVersionUID = 1L;

	public RootCompletePackages(@NonNull CompleteModelImpl owner) {
		super(RootCompletePackage.class, owner, PivotPackage.COMPLETE_MODEL__OWNED_COMPLETE_PACKAGES, PivotPackage.ROOT_COMPLETE_PACKAGE__OWNING_COMPLETE_MODEL);
	}

	@Override
	public @NonNull RootCompletePackage.Internal createCompletePackage(@NonNull DomainPackage partialPackage) {
		RootCompletePackage.Internal completePackage = (RootCompletePackage.Internal) PivotFactory.eINSTANCE.createParentCompletePackage();
		completePackage.init(partialPackage.getName(), partialPackage.getNsPrefix(), partialPackage.getURI(), partialPackage.getPackageId());
		return completePackage;
	}
	
	protected @NonNull RootCompletePackage.Internal createRootCompletePackage(@NonNull DomainPackage pivotPackage) {
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
		RootCompletePackage.Internal rootCompletePackage;
		if (Orphanage.isTypeOrphanage(pivotPackage)) {
			rootCompletePackage = getCompleteModel().getOrphanCompletePackage();
		}
		else {
			PackageId metapackageId = getCompleteModel().getMetaModelManager().getMetapackageId(pivotPackage);
			ParentCompletePackage.Internal parentCompletePackage = (ParentCompletePackage.Internal) PivotFactory.eINSTANCE.createParentCompletePackage();
			parentCompletePackage.init(nonNullName, nsPrefix, completeURI, packageId, metapackageId);
			rootCompletePackage = parentCompletePackage;
			add(rootCompletePackage);
		}
		return rootCompletePackage;
	}

	@Override
	protected void didAdd(@NonNull RootCompletePackage.Internal rootCompletePackage) {
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
	public @NonNull CompleteModel.Internal getCompleteModel() {
		return (CompleteModel.Internal)owner;
	}

	@Override
	public @NonNull RootCompletePackage.Internal getOwnedCompletePackage(@NonNull DomainPackage pivotPackage) {
		//
		//	Try to find package by packageURI
		//
		CompletePackage.Internal completePackage = getCompleteModel().getCompleteURIs().getCompletePackage(pivotPackage);
		if (completePackage != null) {
			return (RootCompletePackage.Internal) completePackage;
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
		RootCompletePackage.Internal rootCompletePackage = getOwnedCompletePackage(name);
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
	protected @NonNull Iterable<org.eclipse.ocl.examples.pivot.Package> getPartialPackages() {
		return getCompleteModel().getPartialModels().getNestedPartialPackages();
	}
}