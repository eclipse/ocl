/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.cgmodel.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.ocl.examples.codegen.cse.AbstractPlace;
import org.eclipse.ocl.examples.codegen.cse.OuterStackPlace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationImpl#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationImpl#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationImpl#getContainingClass <em>Containing Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationImpl#getEOperation <em>EOperation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGOperationImpl extends CGValuedElementImpl implements CGOperation {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<CGParameter> parameters;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement body;

	/**
	 * The cached value of the '{@link #getPreconditions() <em>Preconditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreconditions()
	 * @generated
	 * @ordered
	 */
	protected EList<CGConstraint> preconditions;

	/**
	 * The cached value of the '{@link #getPostconditions() <em>Postconditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostconditions()
	 * @generated
	 * @ordered
	 */
	protected EList<CGConstraint> postconditions;

	/**
	 * The cached value of the '{@link #getEOperation() <em>EOperation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEOperation()
	 * @generated
	 * @ordered
	 */
	protected EOperation eOperation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGModelPackage.Literals.CG_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<CGParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<CGParameter>(CGParameter.class, this, CGModelPackage.CG_OPERATION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGValuedElement getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(CGValuedElement newBody, NotificationChain msgs) {
		CGValuedElement oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_OPERATION__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(CGValuedElement newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CGModelPackage.CG_OPERATION__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CGModelPackage.CG_OPERATION__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_OPERATION__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGConstraint> getPreconditions() {
		if (preconditions == null) {
			preconditions = new EObjectContainmentEList<CGConstraint>(CGConstraint.class, this, CGModelPackage.CG_OPERATION__PRECONDITIONS);
		}
		return preconditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGConstraint> getPostconditions() {
		if (postconditions == null) {
			postconditions = new EObjectContainmentEList<CGConstraint>(CGConstraint.class, this, CGModelPackage.CG_OPERATION__POSTCONDITIONS);
		}
		return postconditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGClass getContainingClass() {
		if (eContainerFeatureID() != CGModelPackage.CG_OPERATION__CONTAINING_CLASS) return null;
		return (CGClass)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingClass(CGClass newContainingClass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingClass, CGModelPackage.CG_OPERATION__CONTAINING_CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingClass(CGClass newContainingClass) {
		if (newContainingClass != eInternalContainer() || (eContainerFeatureID() != CGModelPackage.CG_OPERATION__CONTAINING_CLASS && newContainingClass != null)) {
			if (EcoreUtil.isAncestor(this, newContainingClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingClass != null)
				msgs = ((InternalEObject)newContainingClass).eInverseAdd(this, CGModelPackage.CG_CLASS__OPERATIONS, CGClass.class, msgs);
			msgs = basicSetContainingClass(newContainingClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_OPERATION__CONTAINING_CLASS, newContainingClass, newContainingClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEOperation() {
		if (eOperation != null && eOperation.eIsProxy()) {
			InternalEObject oldEOperation = (InternalEObject)eOperation;
			eOperation = (EOperation)eResolveProxy(oldEOperation);
			if (eOperation != oldEOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CGModelPackage.CG_OPERATION__EOPERATION, oldEOperation, eOperation));
			}
		}
		return eOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation basicGetEOperation() {
		return eOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEOperation(EOperation newEOperation) {
		EOperation oldEOperation = eOperation;
		eOperation = newEOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_OPERATION__EOPERATION, oldEOperation, eOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CGModelPackage.CG_OPERATION__CONTAINING_CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingClass((CGClass)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CGModelPackage.CG_OPERATION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case CGModelPackage.CG_OPERATION__BODY:
				return basicSetBody(null, msgs);
			case CGModelPackage.CG_OPERATION__PRECONDITIONS:
				return ((InternalEList<?>)getPreconditions()).basicRemove(otherEnd, msgs);
			case CGModelPackage.CG_OPERATION__POSTCONDITIONS:
				return ((InternalEList<?>)getPostconditions()).basicRemove(otherEnd, msgs);
			case CGModelPackage.CG_OPERATION__CONTAINING_CLASS:
				return basicSetContainingClass(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CGModelPackage.CG_OPERATION__CONTAINING_CLASS:
				return eInternalContainer().eInverseRemove(this, CGModelPackage.CG_CLASS__OPERATIONS, CGClass.class, msgs);
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
		switch (featureID) {
			case CGModelPackage.CG_OPERATION__PARAMETERS:
				return getParameters();
			case CGModelPackage.CG_OPERATION__BODY:
				return getBody();
			case CGModelPackage.CG_OPERATION__PRECONDITIONS:
				return getPreconditions();
			case CGModelPackage.CG_OPERATION__POSTCONDITIONS:
				return getPostconditions();
			case CGModelPackage.CG_OPERATION__CONTAINING_CLASS:
				return getContainingClass();
			case CGModelPackage.CG_OPERATION__EOPERATION:
				if (resolve) return getEOperation();
				return basicGetEOperation();
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
		switch (featureID) {
			case CGModelPackage.CG_OPERATION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends CGParameter>)newValue);
				return;
			case CGModelPackage.CG_OPERATION__BODY:
				setBody((CGValuedElement)newValue);
				return;
			case CGModelPackage.CG_OPERATION__PRECONDITIONS:
				getPreconditions().clear();
				getPreconditions().addAll((Collection<? extends CGConstraint>)newValue);
				return;
			case CGModelPackage.CG_OPERATION__POSTCONDITIONS:
				getPostconditions().clear();
				getPostconditions().addAll((Collection<? extends CGConstraint>)newValue);
				return;
			case CGModelPackage.CG_OPERATION__CONTAINING_CLASS:
				setContainingClass((CGClass)newValue);
				return;
			case CGModelPackage.CG_OPERATION__EOPERATION:
				setEOperation((EOperation)newValue);
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
		switch (featureID) {
			case CGModelPackage.CG_OPERATION__PARAMETERS:
				getParameters().clear();
				return;
			case CGModelPackage.CG_OPERATION__BODY:
				setBody((CGValuedElement)null);
				return;
			case CGModelPackage.CG_OPERATION__PRECONDITIONS:
				getPreconditions().clear();
				return;
			case CGModelPackage.CG_OPERATION__POSTCONDITIONS:
				getPostconditions().clear();
				return;
			case CGModelPackage.CG_OPERATION__CONTAINING_CLASS:
				setContainingClass((CGClass)null);
				return;
			case CGModelPackage.CG_OPERATION__EOPERATION:
				setEOperation((EOperation)null);
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
		switch (featureID) {
			case CGModelPackage.CG_OPERATION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case CGModelPackage.CG_OPERATION__BODY:
				return body != null;
			case CGModelPackage.CG_OPERATION__PRECONDITIONS:
				return preconditions != null && !preconditions.isEmpty();
			case CGModelPackage.CG_OPERATION__POSTCONDITIONS:
				return postconditions != null && !postconditions.isEmpty();
			case CGModelPackage.CG_OPERATION__CONTAINING_CLASS:
				return getContainingClass() != null;
			case CGModelPackage.CG_OPERATION__EOPERATION:
				return eOperation != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return visitor.visitCGOperation(this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable AbstractPlace getPlace(@NonNull Map<CGElement,AbstractPlace> element2place) {
		return OuterStackPlace.createPlace(element2place, this, body);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isBoxed() {
		return eOperation == null;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isContext() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isUnboxed() {
		return eOperation != null;
	}

} //CGOperationImpl
