/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.basecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.basecs.AttributeCS;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.AttributeCSImpl#isIsId <em>Is Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeCSImpl extends StructuralFeatureCSImpl implements AttributeCS
{
	/**
	 * The default value of the '{@link #isIsId() <em>Is Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsId()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ID_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIsId() <em>Is Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsId()
	 * @generated
	 * @ordered
	 */
	protected boolean isId = IS_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeCSImpl()
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
		return BaseCSPackage.Literals.ATTRIBUTE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsId()
	{
		return isId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsId(boolean newIsId)
	{
		boolean oldIsId = isId;
		isId = newIsId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.ATTRIBUTE_CS__IS_ID, oldIsId, isId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return super.toString();
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
			case BaseCSPackage.ATTRIBUTE_CS__IS_ID:
				return isIsId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case BaseCSPackage.ATTRIBUTE_CS__IS_ID:
				setIsId((Boolean)newValue);
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
			case BaseCSPackage.ATTRIBUTE_CS__IS_ID:
				setIsId(IS_ID_EDEFAULT);
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
			case BaseCSPackage.ATTRIBUTE_CS__IS_ID:
				return isId != IS_ID_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitAttributeCS(this);
	}
} //AttributeCSImpl
