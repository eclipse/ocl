/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.basecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.SpecificationCS;
import org.eclipse.ocl.xtext.basecs.StructuralFeatureCS;
import org.eclipse.ocl.xtext.basecs.StructuredClassCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structural Feature CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.StructuralFeatureCSImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.StructuralFeatureCSImpl#isIsReadonly <em>Is Readonly</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.StructuralFeatureCSImpl#isIsTransient <em>Is Transient</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.StructuralFeatureCSImpl#isIsUnsettable <em>Is Unsettable</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.StructuralFeatureCSImpl#isIsVolatile <em>Is Volatile</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.StructuralFeatureCSImpl#getOwnedDefaultExpressions <em>Owned Default Expressions</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.StructuralFeatureCSImpl#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class StructuralFeatureCSImpl extends FeatureCSImpl implements StructuralFeatureCS {
	/**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected String default_ = DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsReadonly() <em>Is Readonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReadonly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_READONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsReadonly() <em>Is Readonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReadonly()
	 * @generated
	 * @ordered
	 */
	protected boolean isReadonly = IS_READONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsTransient() <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTransient()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TRANSIENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTransient() <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTransient()
	 * @generated
	 * @ordered
	 */
	protected boolean isTransient = IS_TRANSIENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsUnsettable() <em>Is Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnsettable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNSETTABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsUnsettable() <em>Is Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnsettable()
	 * @generated
	 * @ordered
	 */
	protected boolean isUnsettable = IS_UNSETTABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsVolatile() <em>Is Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsVolatile()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_VOLATILE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsVolatile() <em>Is Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsVolatile()
	 * @generated
	 * @ordered
	 */
	protected boolean isVolatile = IS_VOLATILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedDefaultExpressions() <em>Owned Default Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDefaultExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecificationCS> ownedDefaultExpressions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructuralFeatureCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructuredClassCS getOwningClass() {
		if (eContainerFeatureID() != BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNING_CLASS) return null;
		return (StructuredClassCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningClass(StructuredClassCS newOwningClass, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningClass, BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNING_CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningClass(StructuredClassCS newOwningClass) {
		if (newOwningClass != eInternalContainer() || (eContainerFeatureID() != BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNING_CLASS && newOwningClass != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningClass != null)
				msgs = ((InternalEObject)newOwningClass).eInverseAdd(this, BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, StructuredClassCS.class, msgs);
			msgs = basicSetOwningClass(newOwningClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNING_CLASS, newOwningClass, newOwningClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefault()
	{
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefault(String newDefault)
	{
		String oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.STRUCTURAL_FEATURE_CS__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsReadonly()
	{
		return isReadonly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsReadonly(boolean newIsReadonly)
	{
		boolean oldIsReadonly = isReadonly;
		isReadonly = newIsReadonly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_READONLY, oldIsReadonly, isReadonly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsTransient()
	{
		return isTransient;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsTransient(boolean newIsTransient)
	{
		boolean oldIsTransient = isTransient;
		isTransient = newIsTransient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_TRANSIENT, oldIsTransient, isTransient));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsUnsettable()
	{
		return isUnsettable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsUnsettable(boolean newIsUnsettable)
	{
		boolean oldIsUnsettable = isUnsettable;
		isUnsettable = newIsUnsettable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_UNSETTABLE, oldIsUnsettable, isUnsettable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsVolatile()
	{
		return isVolatile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsVolatile(boolean newIsVolatile)
	{
		boolean oldIsVolatile = isVolatile;
		isVolatile = newIsVolatile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_VOLATILE, oldIsVolatile, isVolatile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SpecificationCS> getOwnedDefaultExpressions()
	{
		if (ownedDefaultExpressions == null)
		{
			ownedDefaultExpressions = new EObjectContainmentEList<SpecificationCS>(SpecificationCS.class, this, BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS);
		}
		return ownedDefaultExpressions;
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNING_CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningClass((StructuredClassCS)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS:
				return ((InternalEList<?>)getOwnedDefaultExpressions()).basicRemove(otherEnd, msgs);
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNING_CLASS:
				return basicSetOwningClass(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNING_CLASS:
				return eInternalContainer().eInverseRemove(this, BaseCSPackage.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, StructuredClassCS.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__DEFAULT:
				return getDefault();
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_READONLY:
				return isIsReadonly();
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_TRANSIENT:
				return isIsTransient();
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_UNSETTABLE:
				return isIsUnsettable();
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_VOLATILE:
				return isIsVolatile();
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS:
				return getOwnedDefaultExpressions();
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNING_CLASS:
				return getOwningClass();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__DEFAULT:
				setDefault((String)newValue);
				return;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_READONLY:
				setIsReadonly((Boolean)newValue);
				return;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_TRANSIENT:
				setIsTransient((Boolean)newValue);
				return;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_UNSETTABLE:
				setIsUnsettable((Boolean)newValue);
				return;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_VOLATILE:
				setIsVolatile((Boolean)newValue);
				return;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS:
				getOwnedDefaultExpressions().clear();
				getOwnedDefaultExpressions().addAll((Collection<? extends SpecificationCS>)newValue);
				return;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNING_CLASS:
				setOwningClass((StructuredClassCS)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_READONLY:
				setIsReadonly(IS_READONLY_EDEFAULT);
				return;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_TRANSIENT:
				setIsTransient(IS_TRANSIENT_EDEFAULT);
				return;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_UNSETTABLE:
				setIsUnsettable(IS_UNSETTABLE_EDEFAULT);
				return;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_VOLATILE:
				setIsVolatile(IS_VOLATILE_EDEFAULT);
				return;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS:
				getOwnedDefaultExpressions().clear();
				return;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNING_CLASS:
				setOwningClass((StructuredClassCS)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_READONLY:
				return isReadonly != IS_READONLY_EDEFAULT;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_TRANSIENT:
				return isTransient != IS_TRANSIENT_EDEFAULT;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_UNSETTABLE:
				return isUnsettable != IS_UNSETTABLE_EDEFAULT;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__IS_VOLATILE:
				return isVolatile != IS_VOLATILE_EDEFAULT;
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS:
				return ownedDefaultExpressions != null && !ownedDefaultExpressions.isEmpty();
			case BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNING_CLASS:
				return getOwningClass() != null;
		}
		return super.eIsSet(featureID);
	}
} //StructuralFeatureCSImpl
