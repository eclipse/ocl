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
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl;

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
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IndexExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IndexExpCSImpl#getFirstIndexes <em>First Indexes</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IndexExpCSImpl#getSecondIndexes <em>Second Indexes</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IndexExpCSImpl#isAtPre <em>At Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IndexExpCSImpl
		extends NamedExpCSImpl
		implements IndexExpCS {

	/**
	 * The cached value of the '{@link #getFirstIndexes() <em>First Indexes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstIndexes()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpCS> firstIndexes;

	/**
	 * The cached value of the '{@link #getSecondIndexes() <em>Second Indexes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondIndexes()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpCS> secondIndexes;

	/**
	 * The default value of the '{@link #isAtPre() <em>At Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAtPre()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AT_PRE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAtPre() <em>At Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAtPre()
	 * @generated
	 * @ordered
	 */
	protected boolean atPre = AT_PRE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.INDEX_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpCS> getFirstIndexes() {
		if (firstIndexes == null)
		{
			firstIndexes = new EObjectContainmentEList<ExpCS>(ExpCS.class, this, EssentialOCLCSPackage.INDEX_EXP_CS__FIRST_INDEXES);
		}
		return firstIndexes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpCS> getSecondIndexes() {
		if (secondIndexes == null)
		{
			secondIndexes = new EObjectContainmentEList<ExpCS>(ExpCS.class, this, EssentialOCLCSPackage.INDEX_EXP_CS__SECOND_INDEXES);
		}
		return secondIndexes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAtPre() {
		return atPre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtPre(boolean newAtPre) {
		boolean oldAtPre = atPre;
		atPre = newAtPre;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.INDEX_EXP_CS__AT_PRE, oldAtPre, atPre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
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
			case EssentialOCLCSPackage.INDEX_EXP_CS__FIRST_INDEXES:
				return ((InternalEList<?>)getFirstIndexes()).basicRemove(otherEnd, msgs);
			case EssentialOCLCSPackage.INDEX_EXP_CS__SECOND_INDEXES:
				return ((InternalEList<?>)getSecondIndexes()).basicRemove(otherEnd, msgs);
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
			case EssentialOCLCSPackage.INDEX_EXP_CS__FIRST_INDEXES:
				return getFirstIndexes();
			case EssentialOCLCSPackage.INDEX_EXP_CS__SECOND_INDEXES:
				return getSecondIndexes();
			case EssentialOCLCSPackage.INDEX_EXP_CS__AT_PRE:
				return isAtPre();
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
			case EssentialOCLCSPackage.INDEX_EXP_CS__FIRST_INDEXES:
				getFirstIndexes().clear();
				getFirstIndexes().addAll((Collection<? extends ExpCS>)newValue);
				return;
			case EssentialOCLCSPackage.INDEX_EXP_CS__SECOND_INDEXES:
				getSecondIndexes().clear();
				getSecondIndexes().addAll((Collection<? extends ExpCS>)newValue);
				return;
			case EssentialOCLCSPackage.INDEX_EXP_CS__AT_PRE:
				setAtPre((Boolean)newValue);
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
			case EssentialOCLCSPackage.INDEX_EXP_CS__FIRST_INDEXES:
				getFirstIndexes().clear();
				return;
			case EssentialOCLCSPackage.INDEX_EXP_CS__SECOND_INDEXES:
				getSecondIndexes().clear();
				return;
			case EssentialOCLCSPackage.INDEX_EXP_CS__AT_PRE:
				setAtPre(AT_PRE_EDEFAULT);
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
			case EssentialOCLCSPackage.INDEX_EXP_CS__FIRST_INDEXES:
				return firstIndexes != null && !firstIndexes.isEmpty();
			case EssentialOCLCSPackage.INDEX_EXP_CS__SECOND_INDEXES:
				return secondIndexes != null && !secondIndexes.isEmpty();
			case EssentialOCLCSPackage.INDEX_EXP_CS__AT_PRE:
				return atPre != AT_PRE_EDEFAULT;
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
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitIndexExpCS(this);
	}
} //IndexExpCSImpl
