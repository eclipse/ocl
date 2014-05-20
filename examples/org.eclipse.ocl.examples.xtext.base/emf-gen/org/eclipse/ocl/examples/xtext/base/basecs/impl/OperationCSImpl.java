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

package org.eclipse.ocl.examples.xtext.base.basecs.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.OperationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.OperationCSImpl#getOwnedTemplateSignature <em>Owned Template Signature</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.OperationCSImpl#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.OperationCSImpl#getOwnedParameter <em>Owned Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.OperationCSImpl#getOwnedException <em>Owned Exception</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.OperationCSImpl#getOwnedPrecondition <em>Owned Precondition</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.OperationCSImpl#getOwnedPostcondition <em>Owned Postcondition</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.OperationCSImpl#getOwnedBodyExpression <em>Owned Body Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationCSImpl extends TypedElementCSImpl implements OperationCS {
	/**
	 * The cached value of the '{@link #getOwnedTemplateSignature() <em>Owned Template Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTemplateSignature()
	 * @generated
	 * @ordered
	 */
	protected TemplateSignatureCS ownedTemplateSignature;

	/**
	 * The cached value of the '{@link #getOwnedParameter() <em>Owned Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterCS> ownedParameter;

	/**
	 * The cached value of the '{@link #getOwnedException() <em>Owned Exception</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedException()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedRefCS> ownedException;

	/**
	 * The cached value of the '{@link #getOwnedPrecondition() <em>Owned Precondition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPrecondition()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintCS> ownedPrecondition;

	/**
	 * The cached value of the '{@link #getOwnedPostcondition() <em>Owned Postcondition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPostcondition()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintCS> ownedPostcondition;

	/**
	 * The cached value of the '{@link #getOwnedBodyExpression() <em>Owned Body Expression</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBodyExpression()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecificationCS> ownedBodyExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSPackage.Literals.OPERATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignatureCS getOwnedTemplateSignature() {
		return ownedTemplateSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedTemplateSignature(TemplateSignatureCS newOwnedTemplateSignature, NotificationChain msgs) {
		TemplateSignatureCS oldOwnedTemplateSignature = ownedTemplateSignature;
		ownedTemplateSignature = newOwnedTemplateSignature;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE, oldOwnedTemplateSignature, newOwnedTemplateSignature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedTemplateSignature(TemplateSignatureCS newOwnedTemplateSignature) {
		if (newOwnedTemplateSignature != ownedTemplateSignature)
		{
			NotificationChain msgs = null;
			if (ownedTemplateSignature != null)
				msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, BaseCSPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT, TemplateSignatureCS.class, msgs);
			if (newOwnedTemplateSignature != null)
				msgs = ((InternalEObject)newOwnedTemplateSignature).eInverseAdd(this, BaseCSPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT, TemplateSignatureCS.class, msgs);
			msgs = basicSetOwnedTemplateSignature(newOwnedTemplateSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE, newOwnedTemplateSignature, newOwnedTemplateSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterCS> getOwnedParameter() {
		if (ownedParameter == null)
		{
			ownedParameter = new EObjectContainmentWithInverseEList<ParameterCS>(ParameterCS.class, this, BaseCSPackage.OPERATION_CS__OWNED_PARAMETER, BaseCSPackage.PARAMETER_CS__OWNER);
		}
		return ownedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedRefCS> getOwnedException()
	{
		if (ownedException == null)
		{
			ownedException = new EObjectContainmentEList<TypedRefCS>(TypedRefCS.class, this, BaseCSPackage.OPERATION_CS__OWNED_EXCEPTION);
		}
		return ownedException;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintCS> getOwnedPrecondition()
	{
		if (ownedPrecondition == null)
		{
			ownedPrecondition = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this, BaseCSPackage.OPERATION_CS__OWNED_PRECONDITION);
		}
		return ownedPrecondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintCS> getOwnedPostcondition()
	{
		if (ownedPostcondition == null)
		{
			ownedPostcondition = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this, BaseCSPackage.OPERATION_CS__OWNED_POSTCONDITION);
		}
		return ownedPostcondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SpecificationCS> getOwnedBodyExpression()
	{
		if (ownedBodyExpression == null)
		{
			ownedBodyExpression = new EObjectContainmentEList<SpecificationCS>(SpecificationCS.class, this, BaseCSPackage.OPERATION_CS__OWNED_BODY_EXPRESSION);
		}
		return ownedBodyExpression;
	}

	/**
	 * The cached invocation delegate for the '{@link #ast() <em>Ast</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ast()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate AST__EINVOCATION_DELEGATE = ((EOperation.Internal)BaseCSPackage.Literals.OPERATION_CS.getEOperations().get(0)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation ast()
	{
		try
		{
			return (Operation)AST__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite)
		{
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassCS getOwningClass() {
		if (eContainerFeatureID() != BaseCSPackage.OPERATION_CS__OWNING_CLASS) return null;
		return (ClassCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningClass(ClassCS newOwningClass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningClass, BaseCSPackage.OPERATION_CS__OWNING_CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningClass(ClassCS newOwningClass) {
		if (newOwningClass != eInternalContainer() || (eContainerFeatureID() != BaseCSPackage.OPERATION_CS__OWNING_CLASS && newOwningClass != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningClass != null)
				msgs = ((InternalEObject)newOwningClass).eInverseAdd(this, BaseCSPackage.CLASS_CS__OWNED_OPERATION, ClassCS.class, msgs);
			msgs = basicSetOwningClass(newOwningClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.OPERATION_CS__OWNING_CLASS, newOwningClass, newOwningClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TemplateSignatureCS getTemplateSignature() {
		return getOwnedTemplateSignature();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignatureCS)otherEnd, msgs);
			case BaseCSPackage.OPERATION_CS__OWNING_CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningClass((ClassCS)otherEnd, msgs);
			case BaseCSPackage.OPERATION_CS__OWNED_PARAMETER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedParameter()).basicAdd(otherEnd, msgs);
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
		switch (featureID)
		{
			case BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case BaseCSPackage.OPERATION_CS__OWNING_CLASS:
				return basicSetOwningClass(null, msgs);
			case BaseCSPackage.OPERATION_CS__OWNED_PARAMETER:
				return ((InternalEList<?>)getOwnedParameter()).basicRemove(otherEnd, msgs);
			case BaseCSPackage.OPERATION_CS__OWNED_EXCEPTION:
				return ((InternalEList<?>)getOwnedException()).basicRemove(otherEnd, msgs);
			case BaseCSPackage.OPERATION_CS__OWNED_PRECONDITION:
				return ((InternalEList<?>)getOwnedPrecondition()).basicRemove(otherEnd, msgs);
			case BaseCSPackage.OPERATION_CS__OWNED_POSTCONDITION:
				return ((InternalEList<?>)getOwnedPostcondition()).basicRemove(otherEnd, msgs);
			case BaseCSPackage.OPERATION_CS__OWNED_BODY_EXPRESSION:
				return ((InternalEList<?>)getOwnedBodyExpression()).basicRemove(otherEnd, msgs);
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
		switch (eContainerFeatureID())
		{
			case BaseCSPackage.OPERATION_CS__OWNING_CLASS:
				return eInternalContainer().eInverseRemove(this, BaseCSPackage.CLASS_CS__OWNED_OPERATION, ClassCS.class, msgs);
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
			case BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case BaseCSPackage.OPERATION_CS__OWNING_CLASS:
				return getOwningClass();
			case BaseCSPackage.OPERATION_CS__OWNED_PARAMETER:
				return getOwnedParameter();
			case BaseCSPackage.OPERATION_CS__OWNED_EXCEPTION:
				return getOwnedException();
			case BaseCSPackage.OPERATION_CS__OWNED_PRECONDITION:
				return getOwnedPrecondition();
			case BaseCSPackage.OPERATION_CS__OWNED_POSTCONDITION:
				return getOwnedPostcondition();
			case BaseCSPackage.OPERATION_CS__OWNED_BODY_EXPRESSION:
				return getOwnedBodyExpression();
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
			case BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignatureCS)newValue);
				return;
			case BaseCSPackage.OPERATION_CS__OWNING_CLASS:
				setOwningClass((ClassCS)newValue);
				return;
			case BaseCSPackage.OPERATION_CS__OWNED_PARAMETER:
				getOwnedParameter().clear();
				getOwnedParameter().addAll((Collection<? extends ParameterCS>)newValue);
				return;
			case BaseCSPackage.OPERATION_CS__OWNED_EXCEPTION:
				getOwnedException().clear();
				getOwnedException().addAll((Collection<? extends TypedRefCS>)newValue);
				return;
			case BaseCSPackage.OPERATION_CS__OWNED_PRECONDITION:
				getOwnedPrecondition().clear();
				getOwnedPrecondition().addAll((Collection<? extends ConstraintCS>)newValue);
				return;
			case BaseCSPackage.OPERATION_CS__OWNED_POSTCONDITION:
				getOwnedPostcondition().clear();
				getOwnedPostcondition().addAll((Collection<? extends ConstraintCS>)newValue);
				return;
			case BaseCSPackage.OPERATION_CS__OWNED_BODY_EXPRESSION:
				getOwnedBodyExpression().clear();
				getOwnedBodyExpression().addAll((Collection<? extends SpecificationCS>)newValue);
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
			case BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignatureCS)null);
				return;
			case BaseCSPackage.OPERATION_CS__OWNING_CLASS:
				setOwningClass((ClassCS)null);
				return;
			case BaseCSPackage.OPERATION_CS__OWNED_PARAMETER:
				getOwnedParameter().clear();
				return;
			case BaseCSPackage.OPERATION_CS__OWNED_EXCEPTION:
				getOwnedException().clear();
				return;
			case BaseCSPackage.OPERATION_CS__OWNED_PRECONDITION:
				getOwnedPrecondition().clear();
				return;
			case BaseCSPackage.OPERATION_CS__OWNED_POSTCONDITION:
				getOwnedPostcondition().clear();
				return;
			case BaseCSPackage.OPERATION_CS__OWNED_BODY_EXPRESSION:
				getOwnedBodyExpression().clear();
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
			case BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case BaseCSPackage.OPERATION_CS__OWNING_CLASS:
				return getOwningClass() != null;
			case BaseCSPackage.OPERATION_CS__OWNED_PARAMETER:
				return ownedParameter != null && !ownedParameter.isEmpty();
			case BaseCSPackage.OPERATION_CS__OWNED_EXCEPTION:
				return ownedException != null && !ownedException.isEmpty();
			case BaseCSPackage.OPERATION_CS__OWNED_PRECONDITION:
				return ownedPrecondition != null && !ownedPrecondition.isEmpty();
			case BaseCSPackage.OPERATION_CS__OWNED_POSTCONDITION:
				return ownedPostcondition != null && !ownedPostcondition.isEmpty();
			case BaseCSPackage.OPERATION_CS__OWNED_BODY_EXPRESSION:
				return ownedBodyExpression != null && !ownedBodyExpression.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == TemplateableElementCS.class)
		{
			switch (derivedFeatureID)
			{
				case BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE: return BaseCSPackage.TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == TemplateableElementCS.class)
		{
			switch (baseFeatureID)
			{
				case BaseCSPackage.TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE: return BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitOperationCS(this);
	}
} //OperationCSImpl
