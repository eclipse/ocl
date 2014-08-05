/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.util.CompleteOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.ClassifierContextDeclCSImpl#getSelfName <em>Self Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.ClassifierContextDeclCSImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.ClassifierContextDeclCSImpl#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.ClassifierContextDeclCSImpl#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifierContextDeclCSImpl
		extends ContextDeclCSImpl
		implements ClassifierContextDeclCS {

	/**
	 * The default value of the '{@link #getSelfName() <em>Self Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfName()
	 * @generated
	 * @ordered
	 */
	protected static final String SELF_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSelfName() <em>Self Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfName()
	 * @generated
	 * @ordered
	 */
	protected String selfName = SELF_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInvariants() <em>Invariants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvariants()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintCS> invariants;

	/**
	 * The cached value of the '{@link #getDefinitions() <em>Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<DefCS> definitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierContextDeclCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSPackage.Literals.CLASSIFIER_CONTEXT_DECL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSelfName() {
		return selfName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelfName(String newSelfName) {
		String oldSelfName = selfName;
		selfName = newSelfName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME, oldSelfName, selfName));
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
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME:
				return getSelfName();
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__CLASSIFIER:
				return getClassifier();
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS:
				return getInvariants();
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS:
				return getDefinitions();
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
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME:
				setSelfName((String)newValue);
				return;
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS:
				getInvariants().clear();
				getInvariants().addAll((Collection<? extends ConstraintCS>)newValue);
				return;
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS:
				getDefinitions().clear();
				getDefinitions().addAll((Collection<? extends DefCS>)newValue);
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
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME:
				setSelfName(SELF_NAME_EDEFAULT);
				return;
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS:
				getInvariants().clear();
				return;
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS:
				getDefinitions().clear();
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
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME:
				return SELF_NAME_EDEFAULT == null ? selfName != null : !SELF_NAME_EDEFAULT.equals(selfName);
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__CLASSIFIER:
				return getClassifier() != null;
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS:
				return invariants != null && !invariants.isEmpty();
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS:
				return definitions != null && !definitions.isEmpty();
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
		return (R) ((CompleteOCLCSVisitor<?>)visitor).visitClassifierContextDeclCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public org.eclipse.ocl.examples.pivot.Class getClassifier() {
		PathNameCS pathName2 = pathName;
		if (pathName2 == null) {
			return null;
		}
		CS2Pivot.setElementType(pathName2, PivotPackage.Literals.TYPE, this, null);
		return (org.eclipse.ocl.examples.pivot.Class) pathName2.getElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintCS> getInvariants() {
		if (invariants == null)
		{
			invariants = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this, CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS);
		}
		return invariants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefCS> getDefinitions() {
		if (definitions == null)
		{
			definitions = new EObjectContainmentWithInverseEList<DefCS>(DefCS.class, this, CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS, CompleteOCLCSPackage.DEF_CS__CLASSIFIER_CONTEXT_DECL);
		}
		return definitions;
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDefinitions()).basicAdd(otherEnd, msgs);
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
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS:
				return ((InternalEList<?>)getInvariants()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS:
				return ((InternalEList<?>)getDefinitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
} //ClassifierContextDeclCSImpl
