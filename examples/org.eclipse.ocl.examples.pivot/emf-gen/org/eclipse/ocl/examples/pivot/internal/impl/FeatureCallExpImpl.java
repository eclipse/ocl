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
import org.eclipse.ocl.examples.pivot.FeatureCallExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.FeatureCallExpImpl#isPre <em>Is Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FeatureCallExpImpl
		extends CallExpImpl
		implements FeatureCallExp {

	/**
	 * The default value of the '{@link #isPre() <em>Is Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPre()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PRE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isPre() <em>Is Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPre()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_PRE_EFLAG = 1 << 11;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.FEATURE_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPre() {
		return (eFlags & IS_PRE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPre(boolean newIsPre) {
		boolean oldIsPre = (eFlags & IS_PRE_EFLAG) != 0;
		if (newIsPre) eFlags |= IS_PRE_EFLAG; else eFlags &= ~IS_PRE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.FEATURE_CALL_EXP__IS_PRE, oldIsPre, newIsPre));
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
			case PivotPackage.FEATURE_CALL_EXP__EXTENSION:
				return getExtension();
			case PivotPackage.FEATURE_CALL_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.FEATURE_CALL_EXP__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.FEATURE_CALL_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.FEATURE_CALL_EXP__NAME:
				return getName();
			case PivotPackage.FEATURE_CALL_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.FEATURE_CALL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.FEATURE_CALL_EXP__IMPLICIT:
				return isImplicit();
			case PivotPackage.FEATURE_CALL_EXP__SOURCE:
				return getSource();
			case PivotPackage.FEATURE_CALL_EXP__IS_PRE:
				return isPre();
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
			case PivotPackage.FEATURE_CALL_EXP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.FEATURE_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.FEATURE_CALL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.FEATURE_CALL_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.FEATURE_CALL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.FEATURE_CALL_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.FEATURE_CALL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.FEATURE_CALL_EXP__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.FEATURE_CALL_EXP__SOURCE:
				setSource((OCLExpression)newValue);
				return;
			case PivotPackage.FEATURE_CALL_EXP__IS_PRE:
				setIsPre((Boolean)newValue);
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
			case PivotPackage.FEATURE_CALL_EXP__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.FEATURE_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.FEATURE_CALL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.FEATURE_CALL_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.FEATURE_CALL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.FEATURE_CALL_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.FEATURE_CALL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.FEATURE_CALL_EXP__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.FEATURE_CALL_EXP__SOURCE:
				setSource((OCLExpression)null);
				return;
			case PivotPackage.FEATURE_CALL_EXP__IS_PRE:
				setIsPre(IS_PRE_EDEFAULT);
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
			case PivotPackage.FEATURE_CALL_EXP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.FEATURE_CALL_EXP__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.FEATURE_CALL_EXP__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.FEATURE_CALL_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.FEATURE_CALL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.FEATURE_CALL_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.FEATURE_CALL_EXP__TYPE:
				return type != null;
			case PivotPackage.FEATURE_CALL_EXP__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.FEATURE_CALL_EXP__SOURCE:
				return source != null;
			case PivotPackage.FEATURE_CALL_EXP__IS_PRE:
				return ((eFlags & IS_PRE_EFLAG) != 0) != IS_PRE_EDEFAULT;
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
		return visitor.visitFeatureCallExp(this);
	}
} //FeatureCallExpImpl
