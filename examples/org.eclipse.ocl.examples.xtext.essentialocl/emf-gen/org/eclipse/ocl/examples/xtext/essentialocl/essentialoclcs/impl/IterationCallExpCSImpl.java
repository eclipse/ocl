/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
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
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterationCallExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iteration Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IterationCallExpCSImpl#getReferredIteration <em>Referred Iteration</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IterationCallExpCSImpl#getOwnedIterators <em>Owned Iterators</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IterationCallExpCSImpl#getOwnedArguments <em>Owned Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterationCallExpCSImpl extends CallExpCSImpl implements IterationCallExpCS
{
	/**
	 * The cached value of the '{@link #getReferredIteration() <em>Referred Iteration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredIteration()
	 * @generated
	 * @ordered
	 */
	protected Iteration referredIteration;

	/**
	 * The cached value of the '{@link #getOwnedIterators() <em>Owned Iterators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedIterators()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableCS> ownedIterators;

	/**
	 * The cached value of the '{@link #getOwnedArguments() <em>Owned Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpCS> ownedArguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterationCallExpCSImpl()
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
		return EssentialOCLCSPackage.Literals.ITERATION_CALL_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iteration getReferredIteration()
	{
		return referredIteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferredIteration(Iteration newReferredIteration, NotificationChain msgs)
	{
		Iteration oldReferredIteration = referredIteration;
		referredIteration = newReferredIteration;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__REFERRED_ITERATION, oldReferredIteration, newReferredIteration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredIteration(Iteration newReferredIteration)
	{
		if (newReferredIteration != referredIteration)
		{
			NotificationChain msgs = null;
			if (referredIteration != null)
				msgs = ((InternalEObject)referredIteration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__REFERRED_ITERATION, null, msgs);
			if (newReferredIteration != null)
				msgs = ((InternalEObject)newReferredIteration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__REFERRED_ITERATION, null, msgs);
			msgs = basicSetReferredIteration(newReferredIteration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__REFERRED_ITERATION, newReferredIteration, newReferredIteration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableCS> getOwnedIterators()
	{
		if (ownedIterators == null)
		{
			ownedIterators = new EObjectContainmentEList<VariableCS>(VariableCS.class, this, EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__OWNED_ITERATORS);
		}
		return ownedIterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpCS> getOwnedArguments()
	{
		if (ownedArguments == null)
		{
			ownedArguments = new EObjectContainmentEList<ExpCS>(ExpCS.class, this, EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__OWNED_ARGUMENTS);
		}
		return ownedArguments;
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
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__REFERRED_ITERATION:
				return basicSetReferredIteration(null, msgs);
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__OWNED_ITERATORS:
				return ((InternalEList<?>)getOwnedIterators()).basicRemove(otherEnd, msgs);
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__OWNED_ARGUMENTS:
				return ((InternalEList<?>)getOwnedArguments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__REFERRED_ITERATION:
				return getReferredIteration();
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__OWNED_ITERATORS:
				return getOwnedIterators();
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__OWNED_ARGUMENTS:
				return getOwnedArguments();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__REFERRED_ITERATION:
				setReferredIteration((Iteration)newValue);
				return;
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__OWNED_ITERATORS:
				getOwnedIterators().clear();
				getOwnedIterators().addAll((Collection<? extends VariableCS>)newValue);
				return;
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__OWNED_ARGUMENTS:
				getOwnedArguments().clear();
				getOwnedArguments().addAll((Collection<? extends ExpCS>)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__REFERRED_ITERATION:
				setReferredIteration((Iteration)null);
				return;
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__OWNED_ITERATORS:
				getOwnedIterators().clear();
				return;
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__OWNED_ARGUMENTS:
				getOwnedArguments().clear();
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__REFERRED_ITERATION:
				return referredIteration != null;
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__OWNED_ITERATORS:
				return ownedIterators != null && !ownedIterators.isEmpty();
			case EssentialOCLCSPackage.ITERATION_CALL_EXP_CS__OWNED_ARGUMENTS:
				return ownedArguments != null && !ownedArguments.isEmpty();
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
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitIterationCallExpCS(this);
	}

} //IterationCallExpCSImpl
