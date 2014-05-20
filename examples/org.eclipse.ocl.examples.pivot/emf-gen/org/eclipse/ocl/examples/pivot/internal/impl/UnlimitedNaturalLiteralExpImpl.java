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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unlimited Natural Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.UnlimitedNaturalLiteralExpImpl#getUnlimitedNaturalSymbol <em>Unlimited Natural Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnlimitedNaturalLiteralExpImpl
		extends NumericLiteralExpImpl
		implements UnlimitedNaturalLiteralExp {

	/**
	 * The default value of the '{@link #getUnlimitedNaturalSymbol() <em>Unlimited Natural Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnlimitedNaturalSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final Number UNLIMITED_NATURAL_SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnlimitedNaturalSymbol() <em>Unlimited Natural Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnlimitedNaturalSymbol()
	 * @generated
	 * @ordered
	 */
	protected Number unlimitedNaturalSymbol = UNLIMITED_NATURAL_SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnlimitedNaturalLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Number getUnlimitedNaturalSymbol() {
		return unlimitedNaturalSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnlimitedNaturalSymbol(Number newUnlimitedNaturalSymbol)
	{
		Number oldUnlimitedNaturalSymbol = unlimitedNaturalSymbol;
		unlimitedNaturalSymbol = newUnlimitedNaturalSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL, oldUnlimitedNaturalSymbol, unlimitedNaturalSymbol));
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
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__EXTENSION:
				return getExtension();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__NAME:
				return getName();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL:
				return getUnlimitedNaturalSymbol();
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
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL:
				setUnlimitedNaturalSymbol((Number)newValue);
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
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL:
				setUnlimitedNaturalSymbol(UNLIMITED_NATURAL_SYMBOL_EDEFAULT);
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
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__TYPE:
				return type != null;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL:
				return UNLIMITED_NATURAL_SYMBOL_EDEFAULT == null ? unlimitedNaturalSymbol != null : !UNLIMITED_NATURAL_SYMBOL_EDEFAULT.equals(unlimitedNaturalSymbol);
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitUnlimitedNaturalLiteralExp(this);
	}
} //UnlimitedNaturalLiteralExpImpl
