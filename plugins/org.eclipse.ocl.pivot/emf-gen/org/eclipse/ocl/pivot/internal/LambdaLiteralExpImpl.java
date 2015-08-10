/**
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.LambdaLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;

import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lambda Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.LambdaLiteralExpImpl#getOwnedBody <em>Owned Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.LambdaLiteralExpImpl#getOwnedParameters <em>Owned Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LambdaLiteralExpImpl extends LiteralExpImpl implements LambdaLiteralExp
{
	/**
	 * The cached value of the '{@link #getOwnedBody() <em>Owned Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBody()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedBody;

	/**
	 * The cached value of the '{@link #getOwnedParameters() <em>Owned Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> ownedParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LambdaLiteralExpImpl()
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
		return PivotPackage.Literals.LAMBDA_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedBody()
	{
		return ownedBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedBody(OCLExpression newOwnedBody, NotificationChain msgs)
	{
		OCLExpression oldOwnedBody = ownedBody;
		ownedBody = newOwnedBody;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.LAMBDA_LITERAL_EXP__OWNED_BODY, oldOwnedBody, newOwnedBody);
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
	public void setOwnedBody(OCLExpression newOwnedBody)
	{
		if (newOwnedBody != ownedBody)
		{
			NotificationChain msgs = null;
			if (ownedBody != null)
				msgs = ((InternalEObject)ownedBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.LAMBDA_LITERAL_EXP__OWNED_BODY, null, msgs);
			if (newOwnedBody != null)
				msgs = ((InternalEObject)newOwnedBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.LAMBDA_LITERAL_EXP__OWNED_BODY, null, msgs);
			msgs = basicSetOwnedBody(newOwnedBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.LAMBDA_LITERAL_EXP__OWNED_BODY, newOwnedBody, newOwnedBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Parameter> getOwnedParameters()
	{
		if (ownedParameters == null)
		{
			ownedParameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, PivotPackage.LAMBDA_LITERAL_EXP__OWNED_PARAMETERS);
		}
		return ownedParameters;
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
			case PivotPackage.LAMBDA_LITERAL_EXP__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_BODY:
				return basicSetOwnedBody(null, msgs);
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_PARAMETERS:
				return ((InternalEList<?>)getOwnedParameters()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
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
			case PivotPackage.LAMBDA_LITERAL_EXP__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.LAMBDA_LITERAL_EXP__NAME:
				return getName();
			case PivotPackage.LAMBDA_LITERAL_EXP__IS_MANY:
				return isIsMany();
			case PivotPackage.LAMBDA_LITERAL_EXP__IS_REQUIRED:
				return isIsRequired();
			case PivotPackage.LAMBDA_LITERAL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.LAMBDA_LITERAL_EXP__TYPE_VALUE:
				return getTypeValue();
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_BODY:
				return getOwnedBody();
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_PARAMETERS:
				return getOwnedParameters();
		}
		return eDynamicGet(featureID, resolve, coreType);
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
			case PivotPackage.LAMBDA_LITERAL_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__TYPE_VALUE:
				setTypeValue((Type)newValue);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_BODY:
				setOwnedBody((OCLExpression)newValue);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_PARAMETERS:
				getOwnedParameters().clear();
				getOwnedParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
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
			case PivotPackage.LAMBDA_LITERAL_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__TYPE_VALUE:
				setTypeValue((Type)null);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_BODY:
				setOwnedBody((OCLExpression)null);
				return;
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_PARAMETERS:
				getOwnedParameters().clear();
				return;
		}
		eDynamicUnset(featureID);
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
			case PivotPackage.LAMBDA_LITERAL_EXP__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.LAMBDA_LITERAL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.LAMBDA_LITERAL_EXP__IS_MANY:
				return isIsMany() != IS_MANY_EDEFAULT;
			case PivotPackage.LAMBDA_LITERAL_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.LAMBDA_LITERAL_EXP__TYPE:
				return type != null;
			case PivotPackage.LAMBDA_LITERAL_EXP__TYPE_VALUE:
				return typeValue != null;
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_BODY:
				return ownedBody != null;
			case PivotPackage.LAMBDA_LITERAL_EXP__OWNED_PARAMETERS:
				return ownedParameters != null && !ownedParameters.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitLambdaLiteralExp(this);
	}

} //LambdaLiteralExpImpl
