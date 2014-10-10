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
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Part CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionLiteralPartCSImpl#getOwnedExpressionCS <em>Owned Expression CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionLiteralPartCSImpl#getOwnedLastExpressionCS <em>Owned Last Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionLiteralPartCSImpl
		extends ModelElementCSImpl
		implements CollectionLiteralPartCS {

	/**
	 * The cached value of the '{@link #getOwnedExpressionCS() <em>Owned Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedExpressionCS;

	/**
	 * The cached value of the '{@link #getOwnedLastExpressionCS() <em>Owned Last Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLastExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedLastExpressionCS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionLiteralPartCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getOwnedExpressionCS() {
		return ownedExpressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpressionCS(ExpCS newOwnedExpressionCS, NotificationChain msgs)
	{
		ExpCS oldOwnedExpressionCS = ownedExpressionCS;
		ownedExpressionCS = newOwnedExpressionCS;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION_CS, oldOwnedExpressionCS, newOwnedExpressionCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedExpressionCS(ExpCS newOwnedExpressionCS) {
		if (newOwnedExpressionCS != ownedExpressionCS)
		{
			NotificationChain msgs = null;
			if (ownedExpressionCS != null)
				msgs = ((InternalEObject)ownedExpressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION_CS, null, msgs);
			if (newOwnedExpressionCS != null)
				msgs = ((InternalEObject)newOwnedExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION_CS, null, msgs);
			msgs = basicSetOwnedExpressionCS(newOwnedExpressionCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION_CS, newOwnedExpressionCS, newOwnedExpressionCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getOwnedLastExpressionCS() {
		return ownedLastExpressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedLastExpressionCS(ExpCS newOwnedLastExpressionCS, NotificationChain msgs)
	{
		ExpCS oldOwnedLastExpressionCS = ownedLastExpressionCS;
		ownedLastExpressionCS = newOwnedLastExpressionCS;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION_CS, oldOwnedLastExpressionCS, newOwnedLastExpressionCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedLastExpressionCS(ExpCS newOwnedLastExpressionCS) {
		if (newOwnedLastExpressionCS != ownedLastExpressionCS)
		{
			NotificationChain msgs = null;
			if (ownedLastExpressionCS != null)
				msgs = ((InternalEObject)ownedLastExpressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION_CS, null, msgs);
			if (newOwnedLastExpressionCS != null)
				msgs = ((InternalEObject)newOwnedLastExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION_CS, null, msgs);
			msgs = basicSetOwnedLastExpressionCS(newOwnedLastExpressionCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION_CS, newOwnedLastExpressionCS, newOwnedLastExpressionCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION_CS:
				return basicSetOwnedExpressionCS(null, msgs);
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION_CS:
				return basicSetOwnedLastExpressionCS(null, msgs);
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
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION_CS:
				return getOwnedExpressionCS();
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION_CS:
				return getOwnedLastExpressionCS();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION_CS:
				setOwnedExpressionCS((ExpCS)newValue);
				return;
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION_CS:
				setOwnedLastExpressionCS((ExpCS)newValue);
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
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION_CS:
				setOwnedExpressionCS((ExpCS)null);
				return;
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION_CS:
				setOwnedLastExpressionCS((ExpCS)null);
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
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION_CS:
				return ownedExpressionCS != null;
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION_CS:
				return ownedLastExpressionCS != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitCollectionLiteralPartCS(this);
	}
} //CollectionLiteralPartCSImpl
