/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl;

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
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.util.CompleteOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSFactory;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OperationContextDeclCSImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OperationContextDeclCSImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OperationContextDeclCSImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OperationContextDeclCSImpl#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OperationContextDeclCSImpl#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OperationContextDeclCSImpl#getBodies <em>Bodies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationContextDeclCSImpl
		extends FeatureContextDeclCSImpl
		implements OperationContextDeclCS {

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterCS> parameters;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected VariableCS result;

	/**
	 * The cached value of the '{@link #getPreconditions() <em>Preconditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreconditions()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintCS> preconditions;

	/**
	 * The cached value of the '{@link #getPostconditions() <em>Postconditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostconditions()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintCS> postconditions;

	/**
	 * The cached value of the '{@link #getBodies() <em>Bodies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodies()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpSpecificationCS> bodies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationContextDeclCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSPackage.Literals.OPERATION_CONTEXT_DECL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterCS> getParameters() {
		if (parameters == null)
		{
			parameters = new EObjectContainmentEList<ParameterCS>(ParameterCS.class, this, CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public VariableCS getResult() {
		if (result == null) {
			VariableCS resultVariable = EssentialOCLCSFactory.eINSTANCE
				.createVariableCS();
			resultVariable.setName(Environment.RESULT_VARIABLE_NAME);
			// FIXME			resultVariable.setType(getType());
			setResult(resultVariable);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResult(VariableCS newResult,
			NotificationChain msgs) {
		VariableCS oldResult = result;
		result = newResult;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__RESULT, oldResult, newResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(VariableCS newResult) {
		if (newResult != result)
		{
			NotificationChain msgs = null;
			if (result != null)
				msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__RESULT, null, msgs);
			if (newResult != null)
				msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__RESULT, null, msgs);
			msgs = basicSetResult(newResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__RESULT, newResult, newResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintCS> getPreconditions() {
		if (preconditions == null)
		{
			preconditions = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this, CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__PRECONDITIONS);
		}
		return preconditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintCS> getPostconditions() {
		if (postconditions == null)
		{
			postconditions = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this, CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS);
		}
		return postconditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpSpecificationCS> getBodies() {
		if (bodies == null)
		{
			bodies = new EObjectContainmentEList<ExpSpecificationCS>(ExpSpecificationCS.class, this, CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__BODIES);
		}
		return bodies;
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
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__RESULT:
				return basicSetResult(null, msgs);
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__PRECONDITIONS:
				return ((InternalEList<?>)getPreconditions()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS:
				return ((InternalEList<?>)getPostconditions()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__BODIES:
				return ((InternalEList<?>)getBodies()).basicRemove(otherEnd, msgs);
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
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__OPERATION:
				return getOperation();
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__PARAMETERS:
				return getParameters();
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__RESULT:
				return getResult();
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__PRECONDITIONS:
				return getPreconditions();
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS:
				return getPostconditions();
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__BODIES:
				return getBodies();
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
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ParameterCS>)newValue);
				return;
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__RESULT:
				setResult((VariableCS)newValue);
				return;
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__PRECONDITIONS:
				getPreconditions().clear();
				getPreconditions().addAll((Collection<? extends ConstraintCS>)newValue);
				return;
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS:
				getPostconditions().clear();
				getPostconditions().addAll((Collection<? extends ConstraintCS>)newValue);
				return;
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__BODIES:
				getBodies().clear();
				getBodies().addAll((Collection<? extends ExpSpecificationCS>)newValue);
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
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__PARAMETERS:
				getParameters().clear();
				return;
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__RESULT:
				setResult((VariableCS)null);
				return;
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__PRECONDITIONS:
				getPreconditions().clear();
				return;
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS:
				getPostconditions().clear();
				return;
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__BODIES:
				getBodies().clear();
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
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__OPERATION:
				return getOperation() != null;
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__RESULT:
				return result != null;
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__PRECONDITIONS:
				return preconditions != null && !preconditions.isEmpty();
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS:
				return postconditions != null && !postconditions.isEmpty();
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS__BODIES:
				return bodies != null && !bodies.isEmpty();
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
		return (R) ((CompleteOCLCSVisitor<?>)visitor).visitOperationContextDeclCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Operation getOperation() {
		if (pathName == null) {
			return null;
		}
		return (Operation) pathName.getElement();
	}
} //OperationContextDeclCSImpl
