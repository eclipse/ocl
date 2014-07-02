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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.basecs.impl.ContextLessElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Round Bracketed Clause CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.RoundBracketedClauseCSImpl#getNameExp <em>Name Exp</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.RoundBracketedClauseCSImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoundBracketedClauseCSImpl extends ContextLessElementCSImpl implements RoundBracketedClauseCS
{
	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<NavigatingArgCS> arguments;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoundBracketedClauseCSImpl()
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
		return EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpCS getNameExp()
	{
		if (eContainerFeatureID() != EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__NAME_EXP) return null;
		return (NameExpCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNameExp(NameExpCS newNameExp, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newNameExp, EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__NAME_EXP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNameExp(NameExpCS newNameExp)
	{
		if (newNameExp != eInternalContainer() || (eContainerFeatureID() != EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__NAME_EXP && newNameExp != null))
		{
			if (EcoreUtil.isAncestor(this, newNameExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNameExp != null)
				msgs = ((InternalEObject)newNameExp).eInverseAdd(this, EssentialOCLCSPackage.NAME_EXP_CS__ROUND_BRACKETED_CLAUSE, NameExpCS.class, msgs);
			msgs = basicSetNameExp(newNameExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__NAME_EXP, newNameExp, newNameExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull EList<NavigatingArgCS> getArguments()
	{
		if (arguments == null)
		{
			arguments = new EObjectContainmentWithInverseEList<NavigatingArgCS>(NavigatingArgCS.class, this, EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__ARGUMENTS, EssentialOCLCSPackage.NAVIGATING_ARG_CS__ROUND_BRACKETED_CLAUSE);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__NAME_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNameExp((NameExpCS)otherEnd, msgs);
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__ARGUMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArguments()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__NAME_EXP:
				return basicSetNameExp(null, msgs);
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__NAME_EXP:
				return eInternalContainer().eInverseRemove(this, EssentialOCLCSPackage.NAME_EXP_CS__ROUND_BRACKETED_CLAUSE, NameExpCS.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__NAME_EXP:
				return getNameExp();
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__ARGUMENTS:
				return getArguments();
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
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__NAME_EXP:
				setNameExp((NameExpCS)newValue);
				return;
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends NavigatingArgCS>)newValue);
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
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__NAME_EXP:
				setNameExp((NameExpCS)null);
				return;
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__ARGUMENTS:
				getArguments().clear();
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
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__NAME_EXP:
				return getNameExp() != null;
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
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
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitRoundBracketedClauseCS(this);
	}

} //RoundBracketedClauseCSImpl
