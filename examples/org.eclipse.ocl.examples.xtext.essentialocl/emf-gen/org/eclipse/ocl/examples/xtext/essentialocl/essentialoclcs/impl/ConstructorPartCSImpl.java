/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.xtext.base.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constructor Part CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ConstructorPartCSImpl#getCurlyBracketClause <em>Curly Bracket Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ConstructorPartCSImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ConstructorPartCSImpl#getInitExpression <em>Init Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstructorPartCSImpl
		extends ModelElementCSImpl
		implements ConstructorPartCS {

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Property property;

	/**
	 * The cached value of the '{@link #getInitExpression() <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS initExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstructorPartCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.CONSTRUCTOR_PART_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurlyBracketedClauseCS getCurlyBracketClause()
	{
		if (eContainerFeatureID() != EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__CURLY_BRACKET_CLAUSE) return null;
		return (CurlyBracketedClauseCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCurlyBracketClause(CurlyBracketedClauseCS newCurlyBracketClause, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newCurlyBracketClause, EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__CURLY_BRACKET_CLAUSE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurlyBracketClause(CurlyBracketedClauseCS newCurlyBracketClause)
	{
		if (newCurlyBracketClause != eInternalContainer() || (eContainerFeatureID() != EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__CURLY_BRACKET_CLAUSE && newCurlyBracketClause != null))
		{
			if (EcoreUtil.isAncestor(this, newCurlyBracketClause))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCurlyBracketClause != null)
				msgs = ((InternalEObject)newCurlyBracketClause).eInverseAdd(this, EssentialOCLCSPackage.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, CurlyBracketedClauseCS.class, msgs);
			msgs = basicSetCurlyBracketClause(newCurlyBracketClause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__CURLY_BRACKET_CLAUSE, newCurlyBracketClause, newCurlyBracketClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty() {
		if (property != null && ((EObject)property).eIsProxy())
		{
			InternalEObject oldProperty = (InternalEObject)property;
			property = (Property)eResolveProxy(oldProperty);
			if (property != oldProperty)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__PROPERTY, oldProperty, property));
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(Property newProperty) {
		Property oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getInitExpression() {
		return initExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitExpression(ExpCS newInitExpression,
			NotificationChain msgs) {
		ExpCS oldInitExpression = initExpression;
		initExpression = newInitExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__INIT_EXPRESSION, oldInitExpression, newInitExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitExpression(ExpCS newInitExpression) {
		if (newInitExpression != initExpression)
		{
			NotificationChain msgs = null;
			if (initExpression != null)
				msgs = ((InternalEObject)initExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__INIT_EXPRESSION, null, msgs);
			if (newInitExpression != null)
				msgs = ((InternalEObject)newInitExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__INIT_EXPRESSION, null, msgs);
			msgs = basicSetInitExpression(newInitExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__INIT_EXPRESSION, newInitExpression, newInitExpression));
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
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__CURLY_BRACKET_CLAUSE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCurlyBracketClause((CurlyBracketedClauseCS)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__CURLY_BRACKET_CLAUSE:
				return basicSetCurlyBracketClause(null, msgs);
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__INIT_EXPRESSION:
				return basicSetInitExpression(null, msgs);
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
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__CURLY_BRACKET_CLAUSE:
				return eInternalContainer().eInverseRemove(this, EssentialOCLCSPackage.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, CurlyBracketedClauseCS.class, msgs);
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
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__CURLY_BRACKET_CLAUSE:
				return getCurlyBracketClause();
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__INIT_EXPRESSION:
				return getInitExpression();
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
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__CURLY_BRACKET_CLAUSE:
				setCurlyBracketClause((CurlyBracketedClauseCS)newValue);
				return;
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__PROPERTY:
				setProperty((Property)newValue);
				return;
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__INIT_EXPRESSION:
				setInitExpression((ExpCS)newValue);
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
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__CURLY_BRACKET_CLAUSE:
				setCurlyBracketClause((CurlyBracketedClauseCS)null);
				return;
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__PROPERTY:
				setProperty((Property)null);
				return;
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__INIT_EXPRESSION:
				setInitExpression((ExpCS)null);
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
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__CURLY_BRACKET_CLAUSE:
				return getCurlyBracketClause() != null;
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__PROPERTY:
				return property != null;
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS__INIT_EXPRESSION:
				return initExpression != null;
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
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitConstructorPartCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		return getProperty().getName();
	}
} //ConstructorPartCSImpl
