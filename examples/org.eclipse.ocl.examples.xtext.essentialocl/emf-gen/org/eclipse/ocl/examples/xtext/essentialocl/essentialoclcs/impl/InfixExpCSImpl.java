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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Expression CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl#getOwnedExpressions <em>Owned Expressions</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl#getOwnedOperators <em>Owned Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfixExpCSImpl
		extends ExpCSImpl
		implements InfixExpCS {

	/**
	 * The cached value of the '{@link #getOwnedExpressions() <em>Owned Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpCS> ownedExpressions;

	/**
	 * The cached value of the '{@link #getOwnedOperators() <em>Owned Operators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<BinaryOperatorCS> ownedOperators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfixExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.INFIX_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpCS> getOwnedExpressions() {
		if (ownedExpressions == null)
		{
			ownedExpressions = new EObjectContainmentEList<ExpCS>(ExpCS.class, this, EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSIONS);
		}
		return ownedExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BinaryOperatorCS> getOwnedOperators() {
		if (ownedOperators == null)
		{
			ownedOperators = new EObjectContainmentEList<BinaryOperatorCS>(BinaryOperatorCS.class, this, EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATORS);
		}
		return ownedOperators;
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSIONS:
				return ((InternalEList<?>)getOwnedExpressions()).basicRemove(otherEnd, msgs);
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATORS:
				return ((InternalEList<?>)getOwnedOperators()).basicRemove(otherEnd, msgs);
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSIONS:
				return getOwnedExpressions();
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATORS:
				return getOwnedOperators();
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSIONS:
				getOwnedExpressions().clear();
				getOwnedExpressions().addAll((Collection<? extends ExpCS>)newValue);
				return;
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATORS:
				getOwnedOperators().clear();
				getOwnedOperators().addAll((Collection<? extends BinaryOperatorCS>)newValue);
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSIONS:
				getOwnedExpressions().clear();
				return;
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATORS:
				getOwnedOperators().clear();
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSIONS:
				return ownedExpressions != null && !ownedExpressions.isEmpty();
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATORS:
				return ownedOperators != null && !ownedOperators.isEmpty();
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
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitInfixExpCS(this);
	}
} //BinaryExpressionCSImpl
