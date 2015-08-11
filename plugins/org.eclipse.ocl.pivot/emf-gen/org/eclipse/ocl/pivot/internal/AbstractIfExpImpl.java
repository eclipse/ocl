/**
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.internal;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.pivot.AbstractIfExp;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract If Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.AbstractIfExpImpl#isIsElseIf <em>Is Else If</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.AbstractIfExpImpl#getOwnedElse <em>Owned Else</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.AbstractIfExpImpl#getOwnedThen <em>Owned Then</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractIfExpImpl extends OCLExpressionImpl implements AbstractIfExp
{
	/**
	 * The default value of the '{@link #isIsElseIf() <em>Is Else If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsElseIf()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ELSE_IF_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsElseIf() <em>Is Else If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsElseIf()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_ELSE_IF_EFLAG = 1 << 9;

	/**
	 * The cached value of the '{@link #getOwnedElse() <em>Owned Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElse()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedElse;

	/**
	 * The cached value of the '{@link #getOwnedThen() <em>Owned Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedThen()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedThen;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractIfExpImpl()
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
		return PivotPackage.Literals.ABSTRACT_IF_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsElseIf()
	{
		return (eFlags & IS_ELSE_IF_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsElseIf(boolean newIsElseIf)
	{
		boolean oldIsElseIf = (eFlags & IS_ELSE_IF_EFLAG) != 0;
		if (newIsElseIf) eFlags |= IS_ELSE_IF_EFLAG; else eFlags &= ~IS_ELSE_IF_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ABSTRACT_IF_EXP__IS_ELSE_IF, oldIsElseIf, newIsElseIf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedElse()
	{
		return ownedElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedElse(OCLExpression newOwnedElse, NotificationChain msgs)
	{
		OCLExpression oldOwnedElse = ownedElse;
		ownedElse = newOwnedElse;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.ABSTRACT_IF_EXP__OWNED_ELSE, oldOwnedElse, newOwnedElse);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedElse(OCLExpression newOwnedElse)
	{
		if (newOwnedElse != ownedElse)
		{
			NotificationChain msgs = null;
			if (ownedElse != null)
				msgs = ((InternalEObject)ownedElse).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ABSTRACT_IF_EXP__OWNED_ELSE, null, msgs);
			if (newOwnedElse != null)
				msgs = ((InternalEObject)newOwnedElse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ABSTRACT_IF_EXP__OWNED_ELSE, null, msgs);
			msgs = basicSetOwnedElse(newOwnedElse, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ABSTRACT_IF_EXP__OWNED_ELSE, newOwnedElse, newOwnedElse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedThen()
	{
		return ownedThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedThen(OCLExpression newOwnedThen, NotificationChain msgs)
	{
		OCLExpression oldOwnedThen = ownedThen;
		ownedThen = newOwnedThen;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.ABSTRACT_IF_EXP__OWNED_THEN, oldOwnedThen, newOwnedThen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedThen(OCLExpression newOwnedThen)
	{
		if (newOwnedThen != ownedThen)
		{
			NotificationChain msgs = null;
			if (ownedThen != null)
				msgs = ((InternalEObject)ownedThen).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ABSTRACT_IF_EXP__OWNED_THEN, null, msgs);
			if (newOwnedThen != null)
				msgs = ((InternalEObject)newOwnedThen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ABSTRACT_IF_EXP__OWNED_THEN, null, msgs);
			msgs = basicSetOwnedThen(newOwnedThen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ABSTRACT_IF_EXP__OWNED_THEN, newOwnedThen, newOwnedThen));
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
			case PivotPackage.ABSTRACT_IF_EXP__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_ELSE:
				return basicSetOwnedElse(null, msgs);
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_THEN:
				return basicSetOwnedThen(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
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
			case PivotPackage.ABSTRACT_IF_EXP__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.ABSTRACT_IF_EXP__NAME:
				return getName();
			case PivotPackage.ABSTRACT_IF_EXP__IS_MANY:
				return isIsMany();
			case PivotPackage.ABSTRACT_IF_EXP__IS_REQUIRED:
				return isIsRequired();
			case PivotPackage.ABSTRACT_IF_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.ABSTRACT_IF_EXP__TYPE_VALUE:
				return getTypeValue();
			case PivotPackage.ABSTRACT_IF_EXP__IS_ELSE_IF:
				return isIsElseIf();
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_ELSE:
				return getOwnedElse();
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_THEN:
				return getOwnedThen();
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
			case PivotPackage.ABSTRACT_IF_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__TYPE_VALUE:
				setTypeValue((Type)newValue);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__IS_ELSE_IF:
				setIsElseIf((Boolean)newValue);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_ELSE:
				setOwnedElse((OCLExpression)newValue);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_THEN:
				setOwnedThen((OCLExpression)newValue);
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
			case PivotPackage.ABSTRACT_IF_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.ABSTRACT_IF_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__TYPE_VALUE:
				setTypeValue((Type)null);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__IS_ELSE_IF:
				setIsElseIf(IS_ELSE_IF_EDEFAULT);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_ELSE:
				setOwnedElse((OCLExpression)null);
				return;
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_THEN:
				setOwnedThen((OCLExpression)null);
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
			case PivotPackage.ABSTRACT_IF_EXP__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.ABSTRACT_IF_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ABSTRACT_IF_EXP__IS_MANY:
				return isIsMany() != IS_MANY_EDEFAULT;
			case PivotPackage.ABSTRACT_IF_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.ABSTRACT_IF_EXP__TYPE:
				return type != null;
			case PivotPackage.ABSTRACT_IF_EXP__TYPE_VALUE:
				return typeValue != null;
			case PivotPackage.ABSTRACT_IF_EXP__IS_ELSE_IF:
				return ((eFlags & IS_ELSE_IF_EFLAG) != 0) != IS_ELSE_IF_EDEFAULT;
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_ELSE:
				return ownedElse != null;
			case PivotPackage.ABSTRACT_IF_EXP__OWNED_THEN:
				return ownedThen != null;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isElseIf: "); //$NON-NLS-1$
		result.append((eFlags & IS_ELSE_IF_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}


} //AbstractIfExpImpl
