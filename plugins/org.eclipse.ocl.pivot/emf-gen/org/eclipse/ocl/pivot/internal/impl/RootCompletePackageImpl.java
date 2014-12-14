/**
 * Copyright (c) 2010,2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.RootCompletePackage;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Complete Package</b></em>'.
 * @extends org.eclipse.ocl.pivot.internal.complete.RootCompletePackageInternal
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class RootCompletePackageImpl extends CompletePackageImpl implements RootCompletePackage, org.eclipse.ocl.pivot.internal.complete.RootCompletePackageInternal
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootCompletePackageImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.ROOT_COMPLETE_PACKAGE;
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitRootCompletePackage(this);
	}

	@Override
	public void assertSamePackage(@Nullable org.eclipse.ocl.pivot.Package domainPackage) {
		assert domainPackage != null;
		org.eclipse.ocl.pivot.Package parentPackage = domainPackage.getOwningPackage();
		assert parentPackage == null;
		String typeBasedNsURI = domainPackage.getURI();
		String serverBasedNsURI = getURI();
		if (typeBasedNsURI == null) {
//			assert serverBasedNsURI == null;
		}
		else {
			CompleteModelInternal completeModel = getCompleteModel();
			assert (serverBasedNsURI == null) || (completeModel.getCompletePackageByURI(typeBasedNsURI) == completeModel.getCompletePackageByURI(serverBasedNsURI));
		}
	}

	@Override
	public CompletePackage getOwningCompletePackage() {
		return null;
	}

/*	@Override
	public void dispose() {
		super.dispose();
		packageManager.disposedRootPackageServer(this);
	} */
} //RootCompletePackageImpl
