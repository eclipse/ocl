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
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.ReferringElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableExpImpl#isImplicit <em>Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableExpImpl#getReferredVariable <em>Referred Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableExpImpl
		extends OCLExpressionImpl
		implements VariableExp {

	/**
	 * The default value of the '{@link #isImplicit() <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMPLICIT_EDEFAULT = false;
	/**
	 * The flag representing the value of the '{@link #isImplicit() <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final int IMPLICIT_EFLAG = 1 << 10;

	/**
	 * The cached value of the '{@link #getReferredVariable() <em>Referred Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration referredVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.VARIABLE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getReferredVariable() {
		if (referredVariable != null && ((EObject)referredVariable).eIsProxy())
		{
			InternalEObject oldReferredVariable = (InternalEObject)referredVariable;
			referredVariable = (VariableDeclaration)eResolveProxy(oldReferredVariable);
			if (referredVariable != oldReferredVariable)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.VARIABLE_EXP__REFERRED_VARIABLE, oldReferredVariable, referredVariable));
			}
		}
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetReferredVariable() {
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredVariable(VariableDeclaration newReferredVariable) {
		VariableDeclaration oldReferredVariable = referredVariable;
		referredVariable = newReferredVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.VARIABLE_EXP__REFERRED_VARIABLE, oldReferredVariable, referredVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImplicit()
	{
		return (eFlags & IMPLICIT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplicit(boolean newImplicit)
	{
		boolean oldImplicit = (eFlags & IMPLICIT_EFLAG) != 0;
		if (newImplicit) eFlags |= IMPLICIT_EFLAG; else eFlags &= ~IMPLICIT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.VARIABLE_EXP__IMPLICIT, oldImplicit, newImplicit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case PivotPackage.VARIABLE_EXP__EXTENSION:
				return getExtension();
			case PivotPackage.VARIABLE_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.VARIABLE_EXP__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.VARIABLE_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.VARIABLE_EXP__NAME:
				return getName();
			case PivotPackage.VARIABLE_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.VARIABLE_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.VARIABLE_EXP__IMPLICIT:
				return isImplicit();
			case PivotPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				if (resolve) return getReferredVariable();
				return basicGetReferredVariable();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case PivotPackage.VARIABLE_EXP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				setReferredVariable((VariableDeclaration)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.VARIABLE_EXP__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.VARIABLE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.VARIABLE_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.VARIABLE_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.VARIABLE_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.VARIABLE_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.VARIABLE_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.VARIABLE_EXP__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				setReferredVariable((VariableDeclaration)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.VARIABLE_EXP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.VARIABLE_EXP__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.VARIABLE_EXP__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.VARIABLE_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.VARIABLE_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.VARIABLE_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.VARIABLE_EXP__TYPE:
				return type != null;
			case PivotPackage.VARIABLE_EXP__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.VARIABLE_EXP__REFERRED_VARIABLE:
				return referredVariable != null;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
	{
		if (baseClass == ReferringElement.class)
		{
			switch (baseOperationID)
			{
				case PivotPackage.REFERRING_ELEMENT___GET_REFERRED_ELEMENT: return PivotPackage.VARIABLE_EXP___GET_REFERRED_ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case PivotPackage.VARIABLE_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.VARIABLE_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.VARIABLE_EXP___GET_REFERRED_ELEMENT:
				return getReferredElement();
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitVariableExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element getReferredElement()
	{
		return getReferredVariable();
	}
} //VariableExpImpl
