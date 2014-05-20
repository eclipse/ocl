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
/**
 */
package org.eclipse.ocl.examples.xtext.base.basecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Owner CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PackageOwnerCSImpl#getOwnedNestedPackage <em>Owned Nested Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PackageOwnerCSImpl extends ModelElementCSImpl implements PackageOwnerCS
{
	/**
	 * The cached value of the '{@link #getOwnedNestedPackage() <em>Owned Nested Package</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedNestedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageCS> ownedNestedPackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageOwnerCSImpl()
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
		return BaseCSPackage.Literals.PACKAGE_OWNER_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageCS> getOwnedNestedPackage()
	{
		if (ownedNestedPackage == null)
		{
			ownedNestedPackage = new EObjectContainmentEList<PackageCS>(PackageCS.class, this, BaseCSPackage.PACKAGE_OWNER_CS__OWNED_NESTED_PACKAGE);
		}
		return ownedNestedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case BaseCSPackage.PACKAGE_OWNER_CS__OWNED_NESTED_PACKAGE:
				return ((InternalEList<?>)getOwnedNestedPackage()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case BaseCSPackage.PACKAGE_OWNER_CS__OWNED_NESTED_PACKAGE:
				return getOwnedNestedPackage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case BaseCSPackage.PACKAGE_OWNER_CS__OWNED_NESTED_PACKAGE:
				getOwnedNestedPackage().clear();
				getOwnedNestedPackage().addAll((Collection<? extends PackageCS>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case BaseCSPackage.PACKAGE_OWNER_CS__OWNED_NESTED_PACKAGE:
				getOwnedNestedPackage().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case BaseCSPackage.PACKAGE_OWNER_CS__OWNED_NESTED_PACKAGE:
				return ownedNestedPackage != null && !ownedNestedPackage.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //PackageOwnerCSImpl
