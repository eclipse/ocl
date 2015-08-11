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
import org.eclipse.ocl.pivot.PatternProperty;
import org.eclipse.ocl.pivot.PatternValue;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;

import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PatternPropertyImpl#getOwnedElements <em>Owned Elements</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PatternPropertyImpl#getOwnedRest <em>Owned Rest</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PatternPropertyImpl#getReferredProperty <em>Referred Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternPropertyImpl extends PatternValueImpl implements PatternProperty
{
	/**
	 * The cached value of the '{@link #getOwnedElements() <em>Owned Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<PatternValue> ownedElements;

	/**
	 * The cached value of the '{@link #getOwnedRest() <em>Owned Rest</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRest()
	 * @generated
	 * @ordered
	 */
	protected PatternValue ownedRest;

	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternPropertyImpl()
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
		return PivotPackage.Literals.PATTERN_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<PatternValue> getOwnedElements()
	{
		if (ownedElements == null)
		{
			ownedElements = new EObjectContainmentEList<PatternValue>(PatternValue.class, this, PivotPackage.PATTERN_PROPERTY__OWNED_ELEMENTS);
		}
		return ownedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PatternValue getOwnedRest()
	{
		return ownedRest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedRest(PatternValue newOwnedRest, NotificationChain msgs)
	{
		PatternValue oldOwnedRest = ownedRest;
		ownedRest = newOwnedRest;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.PATTERN_PROPERTY__OWNED_REST, oldOwnedRest, newOwnedRest);
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
	public void setOwnedRest(PatternValue newOwnedRest)
	{
		if (newOwnedRest != ownedRest)
		{
			NotificationChain msgs = null;
			if (ownedRest != null)
				msgs = ((InternalEObject)ownedRest).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.PATTERN_PROPERTY__OWNED_REST, null, msgs);
			if (newOwnedRest != null)
				msgs = ((InternalEObject)newOwnedRest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.PATTERN_PROPERTY__OWNED_REST, null, msgs);
			msgs = basicSetOwnedRest(newOwnedRest, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PATTERN_PROPERTY__OWNED_REST, newOwnedRest, newOwnedRest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredProperty()
	{
		if (referredProperty != null && referredProperty.eIsProxy())
		{
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (Property)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.PATTERN_PROPERTY__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
			}
		}
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredProperty()
	{
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredProperty(Property newReferredProperty)
	{
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PATTERN_PROPERTY__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
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
			case PivotPackage.PATTERN_PROPERTY__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.PATTERN_PROPERTY__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.PATTERN_PROPERTY__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.PATTERN_PROPERTY__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.PATTERN_PROPERTY__OWNED_ELEMENTS:
				return ((InternalEList<?>)getOwnedElements()).basicRemove(otherEnd, msgs);
			case PivotPackage.PATTERN_PROPERTY__OWNED_REST:
				return basicSetOwnedRest(null, msgs);
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
			case PivotPackage.PATTERN_PROPERTY__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.PATTERN_PROPERTY__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.PATTERN_PROPERTY__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.PATTERN_PROPERTY__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.PATTERN_PROPERTY__REFERRED_VARIABLE:
				if (resolve) return getReferredVariable();
				return basicGetReferredVariable();
			case PivotPackage.PATTERN_PROPERTY__OWNED_ELEMENTS:
				return getOwnedElements();
			case PivotPackage.PATTERN_PROPERTY__OWNED_REST:
				return getOwnedRest();
			case PivotPackage.PATTERN_PROPERTY__REFERRED_PROPERTY:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
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
			case PivotPackage.PATTERN_PROPERTY__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PATTERN_PROPERTY__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.PATTERN_PROPERTY__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PATTERN_PROPERTY__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.PATTERN_PROPERTY__REFERRED_VARIABLE:
				setReferredVariable((Variable)newValue);
				return;
			case PivotPackage.PATTERN_PROPERTY__OWNED_ELEMENTS:
				getOwnedElements().clear();
				getOwnedElements().addAll((Collection<? extends PatternValue>)newValue);
				return;
			case PivotPackage.PATTERN_PROPERTY__OWNED_REST:
				setOwnedRest((PatternValue)newValue);
				return;
			case PivotPackage.PATTERN_PROPERTY__REFERRED_PROPERTY:
				setReferredProperty((Property)newValue);
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
			case PivotPackage.PATTERN_PROPERTY__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.PATTERN_PROPERTY__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.PATTERN_PROPERTY__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.PATTERN_PROPERTY__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.PATTERN_PROPERTY__REFERRED_VARIABLE:
				setReferredVariable((Variable)null);
				return;
			case PivotPackage.PATTERN_PROPERTY__OWNED_ELEMENTS:
				getOwnedElements().clear();
				return;
			case PivotPackage.PATTERN_PROPERTY__OWNED_REST:
				setOwnedRest((PatternValue)null);
				return;
			case PivotPackage.PATTERN_PROPERTY__REFERRED_PROPERTY:
				setReferredProperty((Property)null);
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
			case PivotPackage.PATTERN_PROPERTY__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.PATTERN_PROPERTY__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.PATTERN_PROPERTY__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.PATTERN_PROPERTY__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.PATTERN_PROPERTY__REFERRED_VARIABLE:
				return referredVariable != null;
			case PivotPackage.PATTERN_PROPERTY__OWNED_ELEMENTS:
				return ownedElements != null && !ownedElements.isEmpty();
			case PivotPackage.PATTERN_PROPERTY__OWNED_REST:
				return ownedRest != null;
			case PivotPackage.PATTERN_PROPERTY__REFERRED_PROPERTY:
				return referredProperty != null;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitPatternProperty(this);
	}

} //PatternPropertyImpl
