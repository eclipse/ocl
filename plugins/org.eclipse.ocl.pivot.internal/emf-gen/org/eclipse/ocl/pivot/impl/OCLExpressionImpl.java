/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.impl.OCLExpressionImpl#getTypeValue <em>Type Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OCLExpressionImpl
		extends TypedElementImpl
		implements OCLExpression {

	/**
	 * The cached value of the '{@link #getTypeValue() <em>Type Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeValue()
	 * @generated
	 * @ordered
	 */
	protected Type typeValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCLExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.OCL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getTypeValue()
	{
		return typeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTypeValue(Type newTypeValue)
	{
		Type oldTypeValue = typeValue;
		typeValue = newTypeValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.OCL_EXPRESSION__TYPE_VALUE, oldTypeValue, typeValue));
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
			case PivotPackage.OCL_EXPRESSION__COMMENT:
				return getComment();
			case PivotPackage.OCL_EXPRESSION__EXTENSION:
				return getExtension();
			case PivotPackage.OCL_EXPRESSION__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.OCL_EXPRESSION__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.OCL_EXPRESSION__NAME:
				return getName();
			case PivotPackage.OCL_EXPRESSION__IS_MANY:
				return isMany();
			case PivotPackage.OCL_EXPRESSION__IS_REQUIRED:
				return isRequired();
			case PivotPackage.OCL_EXPRESSION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.OCL_EXPRESSION__TYPE_VALUE:
				return getTypeValue();
		}
		return eDynamicGet(featureID, resolve, coreType);
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
			case PivotPackage.OCL_EXPRESSION__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.OCL_EXPRESSION__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.OCL_EXPRESSION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.OCL_EXPRESSION__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.OCL_EXPRESSION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.OCL_EXPRESSION__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.OCL_EXPRESSION__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.OCL_EXPRESSION__TYPE_VALUE:
				setTypeValue((Type)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
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
			case PivotPackage.OCL_EXPRESSION__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.OCL_EXPRESSION__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.OCL_EXPRESSION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.OCL_EXPRESSION__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.OCL_EXPRESSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.OCL_EXPRESSION__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.OCL_EXPRESSION__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.OCL_EXPRESSION__TYPE_VALUE:
				setTypeValue((Type)null);
				return;
		}
		eDynamicUnset(featureID);
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
			case PivotPackage.OCL_EXPRESSION__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.OCL_EXPRESSION__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.OCL_EXPRESSION__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.OCL_EXPRESSION__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.OCL_EXPRESSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.OCL_EXPRESSION__IS_MANY:
				return isMany() != IS_MANY_EDEFAULT;
			case PivotPackage.OCL_EXPRESSION__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.OCL_EXPRESSION__TYPE:
				return type != null;
			case PivotPackage.OCL_EXPRESSION__TYPE_VALUE:
				return typeValue != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitOCLExpression(this);
	}
} //OCLExpressionImpl

