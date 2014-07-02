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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.basecs.impl.ContextLessElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Square Bracketed Clause CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.SquareBracketedClauseCSImpl#getNameExp <em>Name Exp</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.SquareBracketedClauseCSImpl#getTerms <em>Terms</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SquareBracketedClauseCSImpl extends ContextLessElementCSImpl implements SquareBracketedClauseCS
{
	/**
	 * The cached value of the '{@link #getTerms() <em>Terms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerms()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpCS> terms;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SquareBracketedClauseCSImpl()
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
		return EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpCS getNameExp()
	{
		if (eContainerFeatureID() != EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__NAME_EXP) return null;
		return (NameExpCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNameExp(NameExpCS newNameExp, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newNameExp, EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__NAME_EXP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNameExp(NameExpCS newNameExp)
	{
		if (newNameExp != eInternalContainer() || (eContainerFeatureID() != EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__NAME_EXP && newNameExp != null))
		{
			if (EcoreUtil.isAncestor(this, newNameExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNameExp != null)
				msgs = ((InternalEObject)newNameExp).eInverseAdd(this, EssentialOCLCSPackage.NAME_EXP_CS__SQUARE_BRACKETED_CLAUSES, NameExpCS.class, msgs);
			msgs = basicSetNameExp(newNameExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__NAME_EXP, newNameExp, newNameExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpCS> getTerms()
	{
		if (terms == null)
		{
			terms = new EObjectContainmentEList<ExpCS>(ExpCS.class, this, EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__TERMS);
		}
		return terms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__NAME_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNameExp((NameExpCS)otherEnd, msgs);
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
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__NAME_EXP:
				return basicSetNameExp(null, msgs);
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__TERMS:
				return ((InternalEList<?>)getTerms()).basicRemove(otherEnd, msgs);
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
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__NAME_EXP:
				return eInternalContainer().eInverseRemove(this, EssentialOCLCSPackage.NAME_EXP_CS__SQUARE_BRACKETED_CLAUSES, NameExpCS.class, msgs);
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
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__NAME_EXP:
				return getNameExp();
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__TERMS:
				return getTerms();
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
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__NAME_EXP:
				setNameExp((NameExpCS)newValue);
				return;
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__TERMS:
				getTerms().clear();
				getTerms().addAll((Collection<? extends ExpCS>)newValue);
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
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__NAME_EXP:
				setNameExp((NameExpCS)null);
				return;
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__TERMS:
				getTerms().clear();
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
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__NAME_EXP:
				return getNameExp() != null;
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__TERMS:
				return terms != null && !terms.isEmpty();
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
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitSquareBracketedClauseCS(this);
	}

} //SquareBracketedClauseCSImpl
