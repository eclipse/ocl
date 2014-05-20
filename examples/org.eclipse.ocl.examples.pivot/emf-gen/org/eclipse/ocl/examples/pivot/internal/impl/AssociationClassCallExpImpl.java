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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.AssociationClass;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association Class Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassCallExpImpl#getReferredAssociationClass <em>Referred Association Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationClassCallExpImpl
		extends NavigationCallExpImpl
		implements AssociationClassCallExp {

	/**
	 * The cached value of the '{@link #getReferredAssociationClass() <em>Referred Association Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredAssociationClass()
	 * @generated
	 * @ordered
	 */
	protected AssociationClass referredAssociationClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationClassCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.ASSOCIATION_CLASS_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass getReferredAssociationClass() {
		if (referredAssociationClass != null && ((EObject)referredAssociationClass).eIsProxy())
		{
			InternalEObject oldReferredAssociationClass = (InternalEObject)referredAssociationClass;
			referredAssociationClass = (AssociationClass)eResolveProxy(oldReferredAssociationClass);
			if (referredAssociationClass != oldReferredAssociationClass)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS, oldReferredAssociationClass, referredAssociationClass));
			}
		}
		return referredAssociationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass basicGetReferredAssociationClass() {
		return referredAssociationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredAssociationClass(
			AssociationClass newReferredAssociationClass) {
		AssociationClass oldReferredAssociationClass = referredAssociationClass;
		referredAssociationClass = newReferredAssociationClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS, oldReferredAssociationClass, referredAssociationClass));
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
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__EXTENSION:
				return getExtension();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAME:
				return getName();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IMPLICIT:
				return isImplicit();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__SOURCE:
				return getSource();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_PRE:
				return isPre();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAVIGATION_SOURCE:
				if (resolve) return getNavigationSource();
				return basicGetNavigationSource();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__QUALIFIER:
				return getQualifier();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
				if (resolve) return getReferredAssociationClass();
				return basicGetReferredAssociationClass();
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
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__SOURCE:
				setSource((OCLExpression)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_PRE:
				setIsPre((Boolean)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((Property)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__QUALIFIER:
				getQualifier().clear();
				getQualifier().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
				setReferredAssociationClass((AssociationClass)newValue);
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
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__SOURCE:
				setSource((OCLExpression)null);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_PRE:
				setIsPre(IS_PRE_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((Property)null);
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__QUALIFIER:
				getQualifier().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
				setReferredAssociationClass((AssociationClass)null);
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
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__TYPE:
				return type != null;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__SOURCE:
				return source != null;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__IS_PRE:
				return ((eFlags & IS_PRE_EFLAG) != 0) != IS_PRE_EDEFAULT;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__NAVIGATION_SOURCE:
				return navigationSource != null;
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__QUALIFIER:
				return qualifier != null && !qualifier.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
				return referredAssociationClass != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitAssociationClassCallExp(this);
	}
} //AssociationClassCallExpImpl
