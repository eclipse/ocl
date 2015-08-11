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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.PatternExp;
import org.eclipse.ocl.pivot.PatternValue;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;

import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PatternExpImpl#getOwnedPattern <em>Owned Pattern</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PatternExpImpl#getOwnedVariables <em>Owned Variables</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternExpImpl extends ElementImpl implements PatternExp
{
	/**
	 * The cached value of the '{@link #getOwnedPattern() <em>Owned Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPattern()
	 * @generated
	 * @ordered
	 */
	protected PatternValue ownedPattern;

	/**
	 * The cached value of the '{@link #getOwnedVariables() <em>Owned Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> ownedVariables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternExpImpl()
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
		return PivotPackage.Literals.PATTERN_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PatternValue getOwnedPattern()
	{
		return ownedPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedPattern(PatternValue newOwnedPattern, NotificationChain msgs)
	{
		PatternValue oldOwnedPattern = ownedPattern;
		ownedPattern = newOwnedPattern;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.PATTERN_EXP__OWNED_PATTERN, oldOwnedPattern, newOwnedPattern);
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
	public void setOwnedPattern(PatternValue newOwnedPattern)
	{
		if (newOwnedPattern != ownedPattern)
		{
			NotificationChain msgs = null;
			if (ownedPattern != null)
				msgs = ((InternalEObject)ownedPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.PATTERN_EXP__OWNED_PATTERN, null, msgs);
			if (newOwnedPattern != null)
				msgs = ((InternalEObject)newOwnedPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.PATTERN_EXP__OWNED_PATTERN, null, msgs);
			msgs = basicSetOwnedPattern(newOwnedPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PATTERN_EXP__OWNED_PATTERN, newOwnedPattern, newOwnedPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Variable> getOwnedVariables()
	{
		if (ownedVariables == null)
		{
			ownedVariables = new EObjectContainmentEList<Variable>(Variable.class, this, PivotPackage.PATTERN_EXP__OWNED_VARIABLES);
		}
		return ownedVariables;
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
			case PivotPackage.PATTERN_EXP__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.PATTERN_EXP__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.PATTERN_EXP__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.PATTERN_EXP__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.PATTERN_EXP__OWNED_PATTERN:
				return basicSetOwnedPattern(null, msgs);
			case PivotPackage.PATTERN_EXP__OWNED_VARIABLES:
				return ((InternalEList<?>)getOwnedVariables()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.PATTERN_EXP__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.PATTERN_EXP__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.PATTERN_EXP__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.PATTERN_EXP__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.PATTERN_EXP__OWNED_PATTERN:
				return getOwnedPattern();
			case PivotPackage.PATTERN_EXP__OWNED_VARIABLES:
				return getOwnedVariables();
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
			case PivotPackage.PATTERN_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PATTERN_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.PATTERN_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PATTERN_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.PATTERN_EXP__OWNED_PATTERN:
				setOwnedPattern((PatternValue)newValue);
				return;
			case PivotPackage.PATTERN_EXP__OWNED_VARIABLES:
				getOwnedVariables().clear();
				getOwnedVariables().addAll((Collection<? extends Variable>)newValue);
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
			case PivotPackage.PATTERN_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.PATTERN_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.PATTERN_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.PATTERN_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.PATTERN_EXP__OWNED_PATTERN:
				setOwnedPattern((PatternValue)null);
				return;
			case PivotPackage.PATTERN_EXP__OWNED_VARIABLES:
				getOwnedVariables().clear();
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
			case PivotPackage.PATTERN_EXP__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.PATTERN_EXP__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.PATTERN_EXP__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.PATTERN_EXP__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.PATTERN_EXP__OWNED_PATTERN:
				return ownedPattern != null;
			case PivotPackage.PATTERN_EXP__OWNED_VARIABLES:
				return ownedVariables != null && !ownedVariables.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitPatternExp(this);
	}

} //PatternExpImpl
