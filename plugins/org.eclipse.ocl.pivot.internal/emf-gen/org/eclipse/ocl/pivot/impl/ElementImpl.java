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
package org.eclipse.ocl.pivot.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.library.classifier.ClassifierOclContentsOperation;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.DomainEvaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.impl.ElementImpl#getAnnotatingComments <em>Annotating Comments</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.ElementImpl#getOwnedAnnotations <em>Owned Annotations</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.ElementImpl#getOwnedComments <em>Owned Comments</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.ElementImpl#getOwnedExtensions <em>Owned Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ElementImpl
		extends PivotObjectImpl
		implements Element {

	/**
	 * The cached value of the '{@link #getAnnotatingComments() <em>Annotating Comments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotatingComments()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> annotatingComments;
	/**
	 * The cached value of the '{@link #getOwnedAnnotations() <em>Owned Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> ownedAnnotations;
	/**
	 * The cached value of the '{@link #getOwnedComments() <em>Owned Comments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedComments()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> ownedComments;
	/**
	 * The cached value of the '{@link #getOwnedExtensions() <em>Owned Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementExtension> ownedExtensions;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Comment> getAnnotatingComments()
	{
		if (annotatingComments == null)
		{
			annotatingComments = new EObjectWithInverseResolvingEList.ManyInverse<Comment>(Comment.class, this, PivotPackage.ELEMENT__ANNOTATING_COMMENTS, PivotPackage.COMMENT__ANNOTATED_ELEMENTS);
		}
		return annotatingComments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<ElementExtension> getOwnedExtensions()
	{
		if (ownedExtensions == null)
		{
			ownedExtensions = new EObjectContainmentWithInverseEList<ElementExtension>(ElementExtension.class, this, PivotPackage.ELEMENT__OWNED_EXTENSIONS, PivotPackage.ELEMENT_EXTENSION__BASE);
		}
		return ownedExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<Element> getOwnedAnnotations()
	{
		if (ownedAnnotations == null)
		{
			ownedAnnotations = new EObjectContainmentEList<Element>(Element.class, this, PivotPackage.ELEMENT__OWNED_ANNOTATIONS);
		}
		return ownedAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Comment> getOwnedComments()
	{
		if (ownedComments == null)
		{
			ownedComments = new EObjectContainmentWithInverseEList<Comment>(Comment.class, this, PivotPackage.ELEMENT__OWNED_COMMENTS, PivotPackage.COMMENT__OWNING_ELEMENT);
		}
		return ownedComments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @NonNull List<Element> allOwnedElements()
	{
		/**
		 * oclContents()
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@Thrown*/ SetValue oclContents = (SetValue)ClassifierOclContentsOperation.INSTANCE.evaluate(evaluator, PivotTables.SET_CLSSid_OclElement, this);
		final List<? extends Object> UNBOXED_oclContents = oclContents.asEcoreObjects(idResolver, Object.class);
		assert UNBOXED_oclContents != null;
		return (List<Element>)UNBOXED_oclContents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Element getValue(final Type stereotype, final String propertyName)
	{
		/**
		 * null
		 */
		return null;
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
			case PivotPackage.ELEMENT__ANNOTATING_COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotatingComments()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT__OWNED_COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComments()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT__OWNED_EXTENSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedExtensions()).basicAdd(otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
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
			case PivotPackage.ELEMENT__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.ELEMENT__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.ELEMENT__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.ELEMENT__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.ELEMENT__OWNED_EXTENSIONS:
				return getOwnedExtensions();
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
			case PivotPackage.ELEMENT__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ELEMENT__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.ELEMENT__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ELEMENT__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
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
			case PivotPackage.ELEMENT__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.ELEMENT__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.ELEMENT__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.ELEMENT__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
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
			case PivotPackage.ELEMENT__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.ELEMENT__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.ELEMENT__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.ELEMENT__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitElement(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return ToStringVisitor.toString(this);
	}
} //ElementImpl
