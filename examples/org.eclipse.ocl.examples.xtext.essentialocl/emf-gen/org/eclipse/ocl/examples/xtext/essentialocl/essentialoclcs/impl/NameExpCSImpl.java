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
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl#isAtPre <em>At Pre</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl#getCurlyBracketedClause <em>Curly Bracketed Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl#getRoundBracketedClause <em>Round Bracketed Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl#getSquareBracketedClauses <em>Square Bracketed Clauses</em>}</li>
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
	 * The cached value of the '{@link #getPathName() <em>Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS pathName;

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
	 * The cached value of the '{@link #getCurlyBracketedClause() <em>Curly Bracketed Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurlyBracketedClause()
	 * @generated
	 * @ordered
	 */
	protected CurlyBracketedClauseCS curlyBracketedClause;

	/**
	 * The cached value of the '{@link #getRoundBracketedClause() <em>Round Bracketed Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoundBracketedClause()
	 * @generated
	 * @ordered
	 */
	protected RoundBracketedClauseCS roundBracketedClause;

	/**
	 * The cached value of the '{@link #getSquareBracketedClauses() <em>Square Bracketed Clauses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSquareBracketedClauses()
	 * @generated
	 * @ordered
	 */
	protected EList<SquareBracketedClauseCS> squareBracketedClauses;

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
	public PathNameCS getPathName()
	{
		return pathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPathName(PathNameCS newPathName, NotificationChain msgs)
	{
		PathNameCS oldPathName = pathName;
		pathName = newPathName;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__PATH_NAME, oldPathName, newPathName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathName(PathNameCS newPathName)
	{
		if (newPathName != pathName)
		{
			NotificationChain msgs = null;
			if (pathName != null)
				msgs = ((InternalEObject)pathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.NAME_EXP_CS__PATH_NAME, null, msgs);
			if (newPathName != null)
				msgs = ((InternalEObject)newPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.NAME_EXP_CS__PATH_NAME, null, msgs);
			msgs = basicSetPathName(newPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__PATH_NAME, newPathName, newPathName));
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
	public CurlyBracketedClauseCS getCurlyBracketedClause()
	{
		return curlyBracketedClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCurlyBracketedClause(CurlyBracketedClauseCS newCurlyBracketedClause, NotificationChain msgs)
	{
		CurlyBracketedClauseCS oldCurlyBracketedClause = curlyBracketedClause;
		curlyBracketedClause = newCurlyBracketedClause;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__CURLY_BRACKETED_CLAUSE, oldCurlyBracketedClause, newCurlyBracketedClause);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurlyBracketedClause(CurlyBracketedClauseCS newCurlyBracketedClause)
	{
		if (newCurlyBracketedClause != curlyBracketedClause)
		{
			NotificationChain msgs = null;
			if (curlyBracketedClause != null)
				msgs = ((InternalEObject)curlyBracketedClause).eInverseRemove(this, EssentialOCLCSPackage.CURLY_BRACKETED_CLAUSE_CS__NAME_EXP, CurlyBracketedClauseCS.class, msgs);
			if (newCurlyBracketedClause != null)
				msgs = ((InternalEObject)newCurlyBracketedClause).eInverseAdd(this, EssentialOCLCSPackage.CURLY_BRACKETED_CLAUSE_CS__NAME_EXP, CurlyBracketedClauseCS.class, msgs);
			msgs = basicSetCurlyBracketedClause(newCurlyBracketedClause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__CURLY_BRACKETED_CLAUSE, newCurlyBracketedClause, newCurlyBracketedClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoundBracketedClauseCS getRoundBracketedClause()
	{
		return roundBracketedClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoundBracketedClause(RoundBracketedClauseCS newRoundBracketedClause, NotificationChain msgs)
	{
		RoundBracketedClauseCS oldRoundBracketedClause = roundBracketedClause;
		roundBracketedClause = newRoundBracketedClause;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__ROUND_BRACKETED_CLAUSE, oldRoundBracketedClause, newRoundBracketedClause);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoundBracketedClause(RoundBracketedClauseCS newRoundBracketedClause)
	{
		if (newRoundBracketedClause != roundBracketedClause)
		{
			NotificationChain msgs = null;
			if (roundBracketedClause != null)
				msgs = ((InternalEObject)roundBracketedClause).eInverseRemove(this, EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__NAME_EXP, RoundBracketedClauseCS.class, msgs);
			if (newRoundBracketedClause != null)
				msgs = ((InternalEObject)newRoundBracketedClause).eInverseAdd(this, EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS__NAME_EXP, RoundBracketedClauseCS.class, msgs);
			msgs = basicSetRoundBracketedClause(newRoundBracketedClause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAME_EXP_CS__ROUND_BRACKETED_CLAUSE, newRoundBracketedClause, newRoundBracketedClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull EList<SquareBracketedClauseCS> getSquareBracketedClauses()
	{
		if (squareBracketedClauses == null)
		{
			squareBracketedClauses = new EObjectContainmentWithInverseEList<SquareBracketedClauseCS>(SquareBracketedClauseCS.class, this, EssentialOCLCSPackage.NAME_EXP_CS__SQUARE_BRACKETED_CLAUSES, EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS__NAME_EXP);
		}
		return squareBracketedClauses;
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
			case EssentialOCLCSPackage.NAME_EXP_CS__CURLY_BRACKETED_CLAUSE:
				if (curlyBracketedClause != null)
					msgs = ((InternalEObject)curlyBracketedClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.NAME_EXP_CS__CURLY_BRACKETED_CLAUSE, null, msgs);
				return basicSetCurlyBracketedClause((CurlyBracketedClauseCS)otherEnd, msgs);
			case EssentialOCLCSPackage.NAME_EXP_CS__ROUND_BRACKETED_CLAUSE:
				if (roundBracketedClause != null)
					msgs = ((InternalEObject)roundBracketedClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.NAME_EXP_CS__ROUND_BRACKETED_CLAUSE, null, msgs);
				return basicSetRoundBracketedClause((RoundBracketedClauseCS)otherEnd, msgs);
			case EssentialOCLCSPackage.NAME_EXP_CS__SQUARE_BRACKETED_CLAUSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSquareBracketedClauses()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NamedElement getNamedElement() {
		Element element = getPathName().getElement();
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
			case EssentialOCLCSPackage.NAME_EXP_CS__PATH_NAME:
				return basicSetPathName(null, msgs);
			case EssentialOCLCSPackage.NAME_EXP_CS__CURLY_BRACKETED_CLAUSE:
				return basicSetCurlyBracketedClause(null, msgs);
			case EssentialOCLCSPackage.NAME_EXP_CS__ROUND_BRACKETED_CLAUSE:
				return basicSetRoundBracketedClause(null, msgs);
			case EssentialOCLCSPackage.NAME_EXP_CS__SQUARE_BRACKETED_CLAUSES:
				return ((InternalEList<?>)getSquareBracketedClauses()).basicRemove(otherEnd, msgs);
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
			case EssentialOCLCSPackage.NAME_EXP_CS__PATH_NAME:
				return getPathName();
			case EssentialOCLCSPackage.NAME_EXP_CS__AT_PRE:
				return isAtPre();
			case EssentialOCLCSPackage.NAME_EXP_CS__CURLY_BRACKETED_CLAUSE:
				return getCurlyBracketedClause();
			case EssentialOCLCSPackage.NAME_EXP_CS__ROUND_BRACKETED_CLAUSE:
				return getRoundBracketedClause();
			case EssentialOCLCSPackage.NAME_EXP_CS__SQUARE_BRACKETED_CLAUSES:
				return getSquareBracketedClauses();
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
			case EssentialOCLCSPackage.NAME_EXP_CS__PATH_NAME:
				setPathName((PathNameCS)newValue);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__AT_PRE:
				setAtPre((Boolean)newValue);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__CURLY_BRACKETED_CLAUSE:
				setCurlyBracketedClause((CurlyBracketedClauseCS)newValue);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__ROUND_BRACKETED_CLAUSE:
				setRoundBracketedClause((RoundBracketedClauseCS)newValue);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__SQUARE_BRACKETED_CLAUSES:
				getSquareBracketedClauses().clear();
				getSquareBracketedClauses().addAll((Collection<? extends SquareBracketedClauseCS>)newValue);
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
			case EssentialOCLCSPackage.NAME_EXP_CS__PATH_NAME:
				setPathName((PathNameCS)null);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__AT_PRE:
				setAtPre(AT_PRE_EDEFAULT);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__CURLY_BRACKETED_CLAUSE:
				setCurlyBracketedClause((CurlyBracketedClauseCS)null);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__ROUND_BRACKETED_CLAUSE:
				setRoundBracketedClause((RoundBracketedClauseCS)null);
				return;
			case EssentialOCLCSPackage.NAME_EXP_CS__SQUARE_BRACKETED_CLAUSES:
				getSquareBracketedClauses().clear();
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
			case EssentialOCLCSPackage.NAME_EXP_CS__PATH_NAME:
				return pathName != null;
			case EssentialOCLCSPackage.NAME_EXP_CS__AT_PRE:
				return atPre != AT_PRE_EDEFAULT;
			case EssentialOCLCSPackage.NAME_EXP_CS__CURLY_BRACKETED_CLAUSE:
				return curlyBracketedClause != null;
			case EssentialOCLCSPackage.NAME_EXP_CS__ROUND_BRACKETED_CLAUSE:
				return roundBracketedClause != null;
			case EssentialOCLCSPackage.NAME_EXP_CS__SQUARE_BRACKETED_CLAUSES:
				return squareBracketedClauses != null && !squareBracketedClauses.isEmpty();
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
