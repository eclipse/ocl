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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeTemplateParameterImpl#getConstrainingClass <em>Constraining Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeTemplateParameterImpl
		extends TemplateParameterImpl
		implements TypeTemplateParameter {

	/**
	 * The cached value of the '{@link #getConstrainingClass() <em>Constraining Class</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainingClass()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.examples.pivot.Class> constrainingClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeTemplateParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TYPE_TEMPLATE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<org.eclipse.ocl.examples.pivot.Class> getConstrainingClass()
	{
		if (constrainingClass == null)
		{
			constrainingClass = new EObjectResolvingEList<org.eclipse.ocl.examples.pivot.Class>(org.eclipse.ocl.examples.pivot.Class.class, this, PivotPackage.TYPE_TEMPLATE_PARAMETER__CONSTRAINING_CLASS);
		}
		return constrainingClass;
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
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__COMMENT:
				return getComment();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__EXTENSION:
				return getExtension();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__DEFAULT:
				if (resolve) return getDefault();
				return basicGetDefault();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_DEFAULT:
				return getOwnedDefault();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT:
				return getOwnedParameteredElement();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT:
				if (resolve) return getParameteredElement();
				return basicGetParameteredElement();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__SIGNATURE:
				return getSignature();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__CONSTRAINING_CLASS:
				return getConstrainingClass();
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
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__DEFAULT:
				setDefault((ParameterableElement)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_DEFAULT:
				setOwnedDefault((ParameterableElement)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT:
				setOwnedParameteredElement((ParameterableElement)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT:
				setParameteredElement((ParameterableElement)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__SIGNATURE:
				setSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__CONSTRAINING_CLASS:
				getConstrainingClass().clear();
				getConstrainingClass().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
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
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__DEFAULT:
				setDefault((ParameterableElement)null);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_DEFAULT:
				setOwnedDefault((ParameterableElement)null);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT:
				setOwnedParameteredElement((ParameterableElement)null);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT:
				setParameteredElement((ParameterableElement)null);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__SIGNATURE:
				setSignature((TemplateSignature)null);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__CONSTRAINING_CLASS:
				getConstrainingClass().clear();
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
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__DEFAULT:
				return default_ != null;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_DEFAULT:
				return ownedDefault != null;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT:
				return ownedParameteredElement != null;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT:
				return parameteredElement != null;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__SIGNATURE:
				return getSignature() != null;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__CONSTRAINING_CLASS:
				return constrainingClass != null && !constrainingClass.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitTypeTemplateParameter(this);
	}
} //TypeTemplateParameterImpl
