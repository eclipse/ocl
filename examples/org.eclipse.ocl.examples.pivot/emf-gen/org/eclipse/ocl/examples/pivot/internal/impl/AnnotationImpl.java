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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl#getOwnedContent <em>Owned Content</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl#getOwnedDetail <em>Owned Detail</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationImpl
		extends NamedElementImpl
		implements Annotation {

	/**
	 * The cached value of the '{@link #getOwnedContent() <em>Owned Content</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedContent()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> ownedContent;

	/**
	 * The cached value of the '{@link #getOwnedDetail() <em>Owned Detail</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDetail()
	 * @generated
	 * @ordered
	 */
	protected EList<Detail> ownedDetail;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> reference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null") 
	public @NonNull List<Element> getOwnedContent()
	{
		if (ownedContent == null)
		{
			ownedContent = new EObjectContainmentEList<Element>(Element.class, this, PivotPackage.ANNOTATION__OWNED_CONTENT);
		}
		return ownedContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<Detail> getOwnedDetail()
	{
		if (ownedDetail == null)
		{
			ownedDetail = new EObjectContainmentEList<Detail>(Detail.class, this, PivotPackage.ANNOTATION__OWNED_DETAIL);
		}
		return ownedDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<Element> getReference()
	{
		if (reference == null)
		{
			reference = new EObjectResolvingEList<Element>(Element.class, this, PivotPackage.ANNOTATION__REFERENCE);
		}
		return reference;
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
			case PivotPackage.ANNOTATION__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.ANNOTATION__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.ANNOTATION__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.ANNOTATION__OWNED_CONTENT:
				return ((InternalEList<?>)getOwnedContent()).basicRemove(otherEnd, msgs);
			case PivotPackage.ANNOTATION__OWNED_DETAIL:
				return ((InternalEList<?>)getOwnedDetail()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.ANNOTATION__EXTENSION:
				return getExtension();
			case PivotPackage.ANNOTATION__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.ANNOTATION__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.ANNOTATION__IS_STATIC:
				return isStatic();
			case PivotPackage.ANNOTATION__NAME:
				return getName();
			case PivotPackage.ANNOTATION__OWNED_CONTENT:
				return getOwnedContent();
			case PivotPackage.ANNOTATION__OWNED_DETAIL:
				return getOwnedDetail();
			case PivotPackage.ANNOTATION__REFERENCE:
				return getReference();
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
			case PivotPackage.ANNOTATION__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.ANNOTATION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.ANNOTATION__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ANNOTATION__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.ANNOTATION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ANNOTATION__OWNED_CONTENT:
				getOwnedContent().clear();
				getOwnedContent().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.ANNOTATION__OWNED_DETAIL:
				getOwnedDetail().clear();
				getOwnedDetail().addAll((Collection<? extends Detail>)newValue);
				return;
			case PivotPackage.ANNOTATION__REFERENCE:
				getReference().clear();
				getReference().addAll((Collection<? extends Element>)newValue);
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
			case PivotPackage.ANNOTATION__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.ANNOTATION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.ANNOTATION__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.ANNOTATION__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.ANNOTATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ANNOTATION__OWNED_CONTENT:
				getOwnedContent().clear();
				return;
			case PivotPackage.ANNOTATION__OWNED_DETAIL:
				getOwnedDetail().clear();
				return;
			case PivotPackage.ANNOTATION__REFERENCE:
				getReference().clear();
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
			case PivotPackage.ANNOTATION__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.ANNOTATION__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.ANNOTATION__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.ANNOTATION__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.ANNOTATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ANNOTATION__OWNED_CONTENT:
				return ownedContent != null && !ownedContent.isEmpty();
			case PivotPackage.ANNOTATION__OWNED_DETAIL:
				return ownedDetail != null && !ownedDetail.isEmpty();
			case PivotPackage.ANNOTATION__REFERENCE:
				return reference != null && !reference.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitAnnotation(this);
	}
} //AnnotationImpl
