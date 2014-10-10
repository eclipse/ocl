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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Element Ref CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl#getOwnedPathName <em>Owned Path Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl#isAtPre <em>At Pre</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl#getOwnedCurlyBracketedClause <em>Owned Curly Bracketed Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl#getOwnedRoundBracketedClause <em>Owned Round Bracketed Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl#getOwnedSquareBracketedClauses <em>Owned Square Bracketed Clauses</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl#getSourceTypeValue <em>Source Type Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NameExpCSImpl
		extends ExpCSImpl
		implements NameExpCS {

	/**
	 * The cached value of the '{@link #getOwnedPathName() <em>Owned Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPathName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS ownedPathName;

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
	 * The cached value of the '{@link #getOwnedCurlyBracketedClause() <em>Owned Curly Bracketed Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCurlyBracketedClause()
	 * @generated
	 * @ordered
	 */
	protected CurlyBracketedClauseCS ownedCurlyBracketedClause;

	/**
	 * The cached value of the '{@link #getOwnedRoundBracketedClause() <em>Owned Round Bracketed Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRoundBracketedClause()
	 * @generated
	 * @ordered
	 */
	protected RoundBracketedClauseCS ownedRoundBracketedClause;

	/**
	 * The cached value of the '{@link #getOwnedSquareBracketedClauses() <em>Owned Square Bracketed Clauses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSquareBracketedClauses()
	 * @generated
	 * @ordered
	 */
	protected EList<SquareBracketedClauseCS> ownedSquareBracketedClauses;

	/**
	 * The cached value of the '{@link #getSourceType() <em>Source Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceType()
	 * @generated
	 * @ordered
	 */
	protected Type sourceType;

	/**
	 * The cached value of the '{@link #getSourceTypeValue() <em>Source Type Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceTypeValue()
	 * @generated
	 * @ordered
	 */
	protected Type sourceTypeValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NameExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.NAME_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getOwnedPathName()
	{
		return ownedPathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedPathName(PathNameCS newOwnedPathName, NotificationChain msgs)
	{
		PathNameCS oldOwnedPathName = ownedPathName;
		ownedPathName = newOwnedPathName;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__OWNED_PATH_NAME, oldOwnedPathName, newOwnedPathName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedPathName(PathNameCS newOwnedPathName)
	{
		if (newOwnedPathName != ownedPathName)
		{
			NotificationChain msgs = null;
			if (ownedPathName != null)
				msgs = ((InternalEObject)ownedPathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.NAME_EXP_CS__OWNED_PATH_NAME, null, msgs);
			if (newOwnedPathName != null)
				msgs = ((InternalEObject)newOwnedPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.NAME_EXP_CS__OWNED_PATH_NAME, null, msgs);
			msgs = basicSetOwnedPathName(newOwnedPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__OWNED_PATH_NAME, newOwnedPathName, newOwnedPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getSourceType()
	{
		return sourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceType(Type newSourceType)
	{
		Type oldSourceType = sourceType;
		sourceType = newSourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__SOURCE_TYPE, oldSourceType, sourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getSourceTypeValue()
	{
		return sourceTypeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceTypeValue(Type newSourceTypeValue)
	{
		Type oldSourceTypeValue = sourceTypeValue;
		sourceTypeValue = newSourceTypeValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__SOURCE_TYPE_VALUE, oldSourceTypeValue, sourceTypeValue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__AT_PRE, oldAtPre, atPre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurlyBracketedClauseCS getOwnedCurlyBracketedClause()
	{
		return ownedCurlyBracketedClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedCurlyBracketedClause(CurlyBracketedClauseCS newOwnedCurlyBracketedClause, NotificationChain msgs)
	{
		CurlyBracketedClauseCS oldOwnedCurlyBracketedClause = ownedCurlyBracketedClause;
		ownedCurlyBracketedClause = newOwnedCurlyBracketedClause;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, oldOwnedCurlyBracketedClause, newOwnedCurlyBracketedClause);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedCurlyBracketedClause(CurlyBracketedClauseCS newOwnedCurlyBracketedClause)
	{
		if (newOwnedCurlyBracketedClause != ownedCurlyBracketedClause)
		{
			NotificationChain msgs = null;
			if (ownedCurlyBracketedClause != null)
				msgs = ((InternalEObject)ownedCurlyBracketedClause).eInverseRemove(this, EssentialOCLCSPackage.CURLY_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP, CurlyBracketedClauseCS.class, msgs);
			if (newOwnedCurlyBracketedClause != null)
				msgs = ((InternalEObject)newOwnedCurlyBracketedClause).eInverseAdd(this, EssentialOCLCSPackage.CURLY_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP, CurlyBracketedClauseCS.class, msgs);
			msgs = basicSetOwnedCurlyBracketedClause(newOwnedCurlyBracketedClause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, newOwnedCurlyBracketedClause, newOwnedCurlyBracketedClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoundBracketedClauseCS getOwnedRoundBracketedClause()
	{
		return ownedRoundBracketedClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedRoundBracketedClause(RoundBracketedClauseCS newOwnedRoundBracketedClause, NotificationChain msgs)
	{
		RoundBracketedClauseCS oldOwnedRoundBracketedClause = ownedRoundBracketedClause;
		ownedRoundBracketedClause = newOwnedRoundBracketedClause;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, oldOwnedRoundBracketedClause, newOwnedRoundBracketedClause);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedRoundBracketedClause(RoundBracketedClauseCS newOwnedRoundBracketedClause)
	{
		if (newOwnedRoundBracketedClause != ownedRoundBracketedClause)
		{
			NotificationChain msgs = null;
			if (ownedRoundBracketedClause != null)
				msgs = ((InternalEObject)ownedRoundBracketedClause).eInverseRemove(this, EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP, RoundBracketedClauseCS.class, msgs);
			if (newOwnedRoundBracketedClause != null)
				msgs = ((InternalEObject)newOwnedRoundBracketedClause).eInverseAdd(this, EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP, RoundBracketedClauseCS.class, msgs);
			msgs = basicSetOwnedRoundBracketedClause(newOwnedRoundBracketedClause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, newOwnedRoundBracketedClause, newOwnedRoundBracketedClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull EList<SquareBracketedClauseCS> getOwnedSquareBracketedClauses()
	{
		if (ownedSquareBracketedClauses == null)
		{
			ownedSquareBracketedClauses = new EObjectContainmentWithInverseEList<SquareBracketedClauseCS>(SquareBracketedClauseCS.class, this, EssentialOCLCSPackage.NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP);
		}
		return ownedSquareBracketedClauses;
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE:
				if (ownedCurlyBracketedClause != null)
					msgs = ((InternalEObject)ownedCurlyBracketedClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, null, msgs);
				return basicSetOwnedCurlyBracketedClause((CurlyBracketedClauseCS)otherEnd, msgs);
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE:
				if (ownedRoundBracketedClause != null)
					msgs = ((InternalEObject)ownedRoundBracketedClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, null, msgs);
				return basicSetOwnedRoundBracketedClause((RoundBracketedClauseCS)otherEnd, msgs);
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedSquareBracketedClauses()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NamedElement getNamedElement() {
		Element element = getOwnedPathName().getElement();
		return element instanceof NamedElement
			? (NamedElement) element
			: null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NameExpCS getNameExp() {
		return this;
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
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_PATH_NAME:
				return basicSetOwnedPathName(null, msgs);
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE:
				return basicSetOwnedCurlyBracketedClause(null, msgs);
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE:
				return basicSetOwnedRoundBracketedClause(null, msgs);
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES:
				return ((InternalEList<?>)getOwnedSquareBracketedClauses()).basicRemove(otherEnd, msgs);
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
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_PATH_NAME:
				return getOwnedPathName();
			case EssentialOCLCSPackage.NAME_EXP_CS__AT_PRE:
				return isAtPre();
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE:
				return getOwnedCurlyBracketedClause();
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE:
				return getOwnedRoundBracketedClause();
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES:
				return getOwnedSquareBracketedClauses();
			case EssentialOCLCSPackage.NAME_EXP_CS__SOURCE_TYPE:
				return getSourceType();
			case EssentialOCLCSPackage.NAME_EXP_CS__SOURCE_TYPE_VALUE:
				return getSourceTypeValue();
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
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_PATH_NAME:
				setOwnedPathName((PathNameCS)newValue);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__AT_PRE:
				setAtPre((Boolean)newValue);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE:
				setOwnedCurlyBracketedClause((CurlyBracketedClauseCS)newValue);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE:
				setOwnedRoundBracketedClause((RoundBracketedClauseCS)newValue);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES:
				getOwnedSquareBracketedClauses().clear();
				getOwnedSquareBracketedClauses().addAll((Collection<? extends SquareBracketedClauseCS>)newValue);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__SOURCE_TYPE:
				setSourceType((Type)newValue);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__SOURCE_TYPE_VALUE:
				setSourceTypeValue((Type)newValue);
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
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_PATH_NAME:
				setOwnedPathName((PathNameCS)null);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__AT_PRE:
				setAtPre(AT_PRE_EDEFAULT);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE:
				setOwnedCurlyBracketedClause((CurlyBracketedClauseCS)null);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE:
				setOwnedRoundBracketedClause((RoundBracketedClauseCS)null);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES:
				getOwnedSquareBracketedClauses().clear();
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__SOURCE_TYPE:
				setSourceType((Type)null);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__SOURCE_TYPE_VALUE:
				setSourceTypeValue((Type)null);
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
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_PATH_NAME:
				return ownedPathName != null;
			case EssentialOCLCSPackage.NAME_EXP_CS__AT_PRE:
				return atPre != AT_PRE_EDEFAULT;
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE:
				return ownedCurlyBracketedClause != null;
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE:
				return ownedRoundBracketedClause != null;
			case EssentialOCLCSPackage.NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES:
				return ownedSquareBracketedClauses != null && !ownedSquareBracketedClauses.isEmpty();
			case EssentialOCLCSPackage.NAME_EXP_CS__SOURCE_TYPE:
				return sourceType != null;
			case EssentialOCLCSPackage.NAME_EXP_CS__SOURCE_TYPE_VALUE:
				return sourceTypeValue != null;
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
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitNameExpCS(this);
	}
} //NamedElementRefCSImpl
