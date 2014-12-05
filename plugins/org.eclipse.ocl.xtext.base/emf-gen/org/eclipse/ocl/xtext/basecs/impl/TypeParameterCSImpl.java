/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.TypeParameterCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Parameter CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.TypeParameterCSImpl#getOwnedExtends <em>Owned Extends</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.TypeParameterCSImpl#getOwnedSuper <em>Owned Super</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeParameterCSImpl extends TemplateParameterCSImpl implements TypeParameterCS {
	/**
	 * The cached value of the '{@link #getOwnedExtends() <em>Owned Extends</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExtends()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedRefCS> ownedExtends;

	/**
	 * The cached value of the '{@link #getOwnedSuper() <em>Owned Super</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSuper()
	 * @generated
	 * @ordered
	 */
	protected TypedRefCS ownedSuper;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeParameterCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSPackage.Literals.TYPE_PARAMETER_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypedRefCS> getOwnedExtends() {
		if (ownedExtends == null)
		{
			ownedExtends = new EObjectContainmentEList<TypedRefCS>(TypedRefCS.class, this, BaseCSPackage.TYPE_PARAMETER_CS__OWNED_EXTENDS);
		}
		return ownedExtends;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedRefCS getOwnedSuper() {
		return ownedSuper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSuper(TypedRefCS newOwnedSuper, NotificationChain msgs) {
		TypedRefCS oldOwnedSuper = ownedSuper;
		ownedSuper = newOwnedSuper;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaseCSPackage.TYPE_PARAMETER_CS__OWNED_SUPER, oldOwnedSuper, newOwnedSuper);
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
	public void setOwnedSuper(TypedRefCS newOwnedSuper) {
		if (newOwnedSuper != ownedSuper)
		{
			NotificationChain msgs = null;
			if (ownedSuper != null)
				msgs = ((InternalEObject)ownedSuper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaseCSPackage.TYPE_PARAMETER_CS__OWNED_SUPER, null, msgs);
			if (newOwnedSuper != null)
				msgs = ((InternalEObject)newOwnedSuper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BaseCSPackage.TYPE_PARAMETER_CS__OWNED_SUPER, null, msgs);
			msgs = basicSetOwnedSuper(newOwnedSuper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.TYPE_PARAMETER_CS__OWNED_SUPER, newOwnedSuper, newOwnedSuper));
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
			case BaseCSPackage.TYPE_PARAMETER_CS__OWNED_EXTENDS:
				return ((InternalEList<?>)getOwnedExtends()).basicRemove(otherEnd, msgs);
			case BaseCSPackage.TYPE_PARAMETER_CS__OWNED_SUPER:
				return basicSetOwnedSuper(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case BaseCSPackage.TYPE_PARAMETER_CS__OWNED_EXTENDS:
				return getOwnedExtends();
			case BaseCSPackage.TYPE_PARAMETER_CS__OWNED_SUPER:
				return getOwnedSuper();
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
			case BaseCSPackage.TYPE_PARAMETER_CS__OWNED_EXTENDS:
				getOwnedExtends().clear();
				getOwnedExtends().addAll((Collection<? extends TypedRefCS>)newValue);
				return;
			case BaseCSPackage.TYPE_PARAMETER_CS__OWNED_SUPER:
				setOwnedSuper((TypedRefCS)newValue);
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
			case BaseCSPackage.TYPE_PARAMETER_CS__OWNED_EXTENDS:
				getOwnedExtends().clear();
				return;
			case BaseCSPackage.TYPE_PARAMETER_CS__OWNED_SUPER:
				setOwnedSuper((TypedRefCS)null);
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
			case BaseCSPackage.TYPE_PARAMETER_CS__OWNED_EXTENDS:
				return ownedExtends != null && !ownedExtends.isEmpty();
			case BaseCSPackage.TYPE_PARAMETER_CS__OWNED_SUPER:
				return ownedSuper != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitTypeParameterCS(this);
	}
} //TypeParameterCSImpl
