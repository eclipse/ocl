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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateBindingImpl#getOwnedTemplateParameterSubstitutions <em>Owned Template Parameter Substitutions</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateBindingImpl#getOwningTemplateableElement <em>Owning Templateable Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateBindingImpl#getTemplateSignature <em>Template Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateBindingImpl
		extends ElementImpl
		implements TemplateBinding {

	/**
	 * The cached value of the '{@link #getOwnedTemplateParameterSubstitutions() <em>Owned Template Parameter Substitutions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTemplateParameterSubstitutions()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateParameterSubstitution> ownedTemplateParameterSubstitutions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TEMPLATE_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<TemplateParameterSubstitution> getOwnedTemplateParameterSubstitutions()
	{
		if (ownedTemplateParameterSubstitutions == null)
		{
			ownedTemplateParameterSubstitutions = new EObjectContainmentWithInverseEList<TemplateParameterSubstitution>(TemplateParameterSubstitution.class, this, PivotPackage.TEMPLATE_BINDING__OWNED_TEMPLATE_PARAMETER_SUBSTITUTIONS, PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNING_TEMPLATE_BINDING);
		}
		return ownedTemplateParameterSubstitutions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateableElement getOwningTemplateableElement() {
		if (eContainerFeatureID() != PivotPackage.TEMPLATE_BINDING__OWNING_TEMPLATEABLE_ELEMENT) return null;
		return (TemplateableElement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTemplateableElement(TemplateableElement newOwningTemplateableElement, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningTemplateableElement, PivotPackage.TEMPLATE_BINDING__OWNING_TEMPLATEABLE_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTemplateableElement(TemplateableElement newOwningTemplateableElement) {
		if (newOwningTemplateableElement != eInternalContainer() || (eContainerFeatureID() != PivotPackage.TEMPLATE_BINDING__OWNING_TEMPLATEABLE_ELEMENT && newOwningTemplateableElement != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newOwningTemplateableElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTemplateableElement != null)
				msgs = ((InternalEObject)newOwningTemplateableElement).eInverseAdd(this, PivotPackage.TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_BINDINGS, TemplateableElement.class, msgs);
			msgs = basicSetOwningTemplateableElement(newOwningTemplateableElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TEMPLATE_BINDING__OWNING_TEMPLATEABLE_ELEMENT, newOwningTemplateableElement, newOwningTemplateableElement));
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
			case PivotPackage.TEMPLATE_BINDING__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.TEMPLATE_BINDING__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.TEMPLATE_BINDING__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.TEMPLATE_BINDING__OWNED_TEMPLATE_PARAMETER_SUBSTITUTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTemplateParameterSubstitutions()).basicAdd(otherEnd, msgs);
			case PivotPackage.TEMPLATE_BINDING__OWNING_TEMPLATEABLE_ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateableElement((TemplateableElement)otherEnd, msgs);
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
			case PivotPackage.TEMPLATE_BINDING__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_BINDING__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_BINDING__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_BINDING__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_BINDING__OWNED_TEMPLATE_PARAMETER_SUBSTITUTIONS:
				return ((InternalEList<?>)getOwnedTemplateParameterSubstitutions()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_BINDING__OWNING_TEMPLATEABLE_ELEMENT:
				return basicSetOwningTemplateableElement(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case PivotPackage.TEMPLATE_BINDING__OWNING_TEMPLATEABLE_ELEMENT:
				return eInternalContainer().eInverseRemove(this, PivotPackage.TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_BINDINGS, TemplateableElement.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
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
			case PivotPackage.TEMPLATE_BINDING__COMMENT:
				return getComment();
			case PivotPackage.TEMPLATE_BINDING__EXTENSION:
				return getExtension();
			case PivotPackage.TEMPLATE_BINDING__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.TEMPLATE_BINDING__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.TEMPLATE_BINDING__OWNED_TEMPLATE_PARAMETER_SUBSTITUTIONS:
				return getOwnedTemplateParameterSubstitutions();
			case PivotPackage.TEMPLATE_BINDING__OWNING_TEMPLATEABLE_ELEMENT:
				return getOwningTemplateableElement();
			case PivotPackage.TEMPLATE_BINDING__TEMPLATE_SIGNATURE:
				return getTemplateSignature();
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
			case PivotPackage.TEMPLATE_BINDING__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TEMPLATE_BINDING__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.TEMPLATE_BINDING__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.TEMPLATE_BINDING__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TEMPLATE_BINDING__OWNED_TEMPLATE_PARAMETER_SUBSTITUTIONS:
				getOwnedTemplateParameterSubstitutions().clear();
				getOwnedTemplateParameterSubstitutions().addAll((Collection<? extends TemplateParameterSubstitution>)newValue);
				return;
			case PivotPackage.TEMPLATE_BINDING__OWNING_TEMPLATEABLE_ELEMENT:
				setOwningTemplateableElement((TemplateableElement)newValue);
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
			case PivotPackage.TEMPLATE_BINDING__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.TEMPLATE_BINDING__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.TEMPLATE_BINDING__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.TEMPLATE_BINDING__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.TEMPLATE_BINDING__OWNED_TEMPLATE_PARAMETER_SUBSTITUTIONS:
				getOwnedTemplateParameterSubstitutions().clear();
				return;
			case PivotPackage.TEMPLATE_BINDING__OWNING_TEMPLATEABLE_ELEMENT:
				setOwningTemplateableElement((TemplateableElement)null);
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
			case PivotPackage.TEMPLATE_BINDING__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.TEMPLATE_BINDING__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.TEMPLATE_BINDING__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.TEMPLATE_BINDING__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.TEMPLATE_BINDING__OWNED_TEMPLATE_PARAMETER_SUBSTITUTIONS:
				return ownedTemplateParameterSubstitutions != null && !ownedTemplateParameterSubstitutions.isEmpty();
			case PivotPackage.TEMPLATE_BINDING__OWNING_TEMPLATEABLE_ELEMENT:
				return getOwningTemplateableElement() != null;
			case PivotPackage.TEMPLATE_BINDING__TEMPLATE_SIGNATURE:
				return getTemplateSignature() != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitTemplateBinding(this);
	}

	@Override
	public TemplateSignature getTemplateSignature()
	{
		for (TemplateParameterSubstitution templateParameterSubstitution : getOwnedTemplateParameterSubstitutions()) {
			TemplateParameter formal = templateParameterSubstitution.getFormal();
			if (formal != null) {
				TemplateSignature templateSignature = formal.getOwningTemplateSignature();
				if (templateSignature != null) {
					return templateSignature;
				}
			}
		}
		return null;		// Never happens
	}
} //TemplateBindingImpl
