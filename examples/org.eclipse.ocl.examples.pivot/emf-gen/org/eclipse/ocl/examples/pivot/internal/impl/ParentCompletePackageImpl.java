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
package org.eclipse.ocl.examples.pivot.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.ParentCompletePackage;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.internal.complete.ParentPackageCompleteClasses;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parent Complete Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ParentCompletePackageImpl extends RootCompletePackageImpl implements ParentCompletePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParentCompletePackageImpl()
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
		return PivotPackage.Literals.PARENT_COMPLETE_PACKAGE;
	}
	
	private /*final*/ /*@NonNull*/ PackageId metapackageId;

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitParentCompletePackage(this);
	}
	
	public @NonNull PackageId getMetapackageId() {
		return metapackageId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull ParentPackageCompleteClasses getOwnedCompleteClasses()
	{
		ParentPackageCompleteClasses ownedCompleteClasses2 = (ParentPackageCompleteClasses) ownedCompleteClasses;
		if (ownedCompleteClasses2 == null)
		{
			ownedCompleteClasses = ownedCompleteClasses2 = new ParentPackageCompleteClasses(this);
		}
		return ownedCompleteClasses2;
	}

	public void init(@NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId, @NonNull PackageId metapackageId) {
		super.init(name, nsPrefix, nsURI, packageId);
		this.metapackageId = metapackageId;
	}
} //ParentCompletePackageImpl
