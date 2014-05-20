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
package org.eclipse.ocl.examples.pivot.internal.impl;

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
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression In Ocl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOCLImpl#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOCLImpl#getContextVariable <em>Context Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOCLImpl#getParameterVariable <em>Parameter Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOCLImpl#getResultVariable <em>Result Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionInOCLImpl
		extends OpaqueExpressionImpl
		implements ExpressionInOCL {

	/**
	 * The cached value of the '{@link #getBodyExpression() <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression bodyExpression;

	/**
	 * The cached value of the '{@link #getContextVariable() <em>Context Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable contextVariable;

	/**
	 * The cached value of the '{@link #getParameterVariable() <em>Parameter Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> parameterVariable;

	/**
	 * The cached value of the '{@link #getResultVariable() <em>Result Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable resultVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionInOCLImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.EXPRESSION_IN_OCL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getBodyExpression() {
		return bodyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyExpression(
			OCLExpression newBodyExpression, NotificationChain msgs) {
		OCLExpression oldBodyExpression = bodyExpression;
		bodyExpression = newBodyExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION, oldBodyExpression, newBodyExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyExpression(OCLExpression newBodyExpression) {
		if (newBodyExpression != bodyExpression)
		{
			NotificationChain msgs = null;
			if (bodyExpression != null)
				msgs = ((InternalEObject)bodyExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION, null, msgs);
			if (newBodyExpression != null)
				msgs = ((InternalEObject)newBodyExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION, null, msgs);
			msgs = basicSetBodyExpression(newBodyExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION, newBodyExpression, newBodyExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getContextVariable() {
		return contextVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextVariable(
			Variable newContextVariable, NotificationChain msgs) {
		Variable oldContextVariable = contextVariable;
		contextVariable = newContextVariable;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, oldContextVariable, newContextVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextVariable(Variable newContextVariable) {
		if (newContextVariable != contextVariable)
		{
			NotificationChain msgs = null;
			if (contextVariable != null)
				msgs = ((InternalEObject)contextVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, null, msgs);
			if (newContextVariable != null)
				msgs = ((InternalEObject)newContextVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, null, msgs);
			msgs = basicSetContextVariable(newContextVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, newContextVariable, newContextVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getResultVariable() {
		return resultVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultVariable(Variable newResultVariable,
			NotificationChain msgs) {
		Variable oldResultVariable = resultVariable;
		resultVariable = newResultVariable;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE, oldResultVariable, newResultVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultVariable(Variable newResultVariable) {
		if (newResultVariable != resultVariable)
		{
			NotificationChain msgs = null;
			if (resultVariable != null)
				msgs = ((InternalEObject)resultVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE, null, msgs);
			if (newResultVariable != null)
				msgs = ((InternalEObject)newResultVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE, null, msgs);
			msgs = basicSetResultVariable(newResultVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE, newResultVariable, newResultVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<Variable> getParameterVariable()
	{
		if (parameterVariable == null)
		{
			parameterVariable = new EObjectContainmentEList<Variable>(Variable.class, this, PivotPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE);
		}
		return parameterVariable;
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
			case PivotPackage.EXPRESSION_IN_OCL__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER:
				return basicSetOwningTemplateParameter(null, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION:
				return basicSetBodyExpression(null, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE:
				return basicSetContextVariable(null, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE:
				return ((InternalEList<?>)getParameterVariable()).basicRemove(otherEnd, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE:
				return basicSetResultVariable(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
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
			case PivotPackage.EXPRESSION_IN_OCL__EXTENSION:
				return getExtension();
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.EXPRESSION_IN_OCL__IS_STATIC:
				return isStatic();
			case PivotPackage.EXPRESSION_IN_OCL__NAME:
				return getName();
			case PivotPackage.EXPRESSION_IN_OCL__IS_REQUIRED:
				return isRequired();
			case PivotPackage.EXPRESSION_IN_OCL__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.EXPRESSION_IN_OCL__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.EXPRESSION_IN_OCL__BODY:
				return getBody();
			case PivotPackage.EXPRESSION_IN_OCL__EXPRESSION_IN_OCL:
				return getExpressionInOCL();
			case PivotPackage.EXPRESSION_IN_OCL__LANGUAGE:
				return getLanguage();
			case PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION:
				return getBodyExpression();
			case PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE:
				return getContextVariable();
			case PivotPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE:
				return getParameterVariable();
			case PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE:
				return getResultVariable();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case PivotPackage.EXPRESSION_IN_OCL__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__BODY:
				getBody().clear();
				getBody().addAll((Collection<? extends String>)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__EXPRESSION_IN_OCL:
				setExpressionInOCL((ExpressionInOCL)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__LANGUAGE:
				getLanguage().clear();
				getLanguage().addAll((Collection<? extends String>)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION:
				setBodyExpression((OCLExpression)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE:
				setContextVariable((Variable)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE:
				getParameterVariable().clear();
				getParameterVariable().addAll((Collection<? extends Variable>)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE:
				setResultVariable((Variable)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.EXPRESSION_IN_OCL__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.EXPRESSION_IN_OCL__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__BODY:
				getBody().clear();
				return;
			case PivotPackage.EXPRESSION_IN_OCL__EXPRESSION_IN_OCL:
				setExpressionInOCL((ExpressionInOCL)null);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__LANGUAGE:
				getLanguage().clear();
				return;
			case PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION:
				setBodyExpression((OCLExpression)null);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE:
				setContextVariable((Variable)null);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE:
				getParameterVariable().clear();
				return;
			case PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE:
				setResultVariable((Variable)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.EXPRESSION_IN_OCL__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.EXPRESSION_IN_OCL__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.EXPRESSION_IN_OCL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.EXPRESSION_IN_OCL__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.EXPRESSION_IN_OCL__TYPE:
				return type != null;
			case PivotPackage.EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.EXPRESSION_IN_OCL__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.EXPRESSION_IN_OCL__BODY:
				return body != null && !body.isEmpty();
			case PivotPackage.EXPRESSION_IN_OCL__EXPRESSION_IN_OCL:
				return expressionInOCL != null;
			case PivotPackage.EXPRESSION_IN_OCL__LANGUAGE:
				return language != null && !language.isEmpty();
			case PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION:
				return bodyExpression != null;
			case PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE:
				return contextVariable != null;
			case PivotPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE:
				return parameterVariable != null && !parameterVariable.isEmpty();
			case PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE:
				return resultVariable != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitExpressionInOCL(this);
	}

	@Override
	public @NonNull ExpressionInOCL getExpressionInOCL() {
		return this;
	}

} //ExpressionInOCLImpl
