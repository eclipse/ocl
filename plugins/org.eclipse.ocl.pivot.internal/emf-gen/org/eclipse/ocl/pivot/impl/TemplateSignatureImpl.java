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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.elements.DomainTypeParameters;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.impl.TemplateSignatureImpl#getOwnedTemplateParameters <em>Owned Template Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.TemplateSignatureImpl#getOwningTemplateableElement <em>Owning Templateable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateSignatureImpl
		extends ElementImpl
		implements TemplateSignature {

	/**
	 * The cached value of the '{@link #getOwnedTemplateParameters() <em>Owned Template Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTemplateParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateParameter> ownedTemplateParameters;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateSignatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TEMPLATE_SIGNATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<TemplateParameter> getOwnedTemplateParameters()
	{
		if (ownedTemplateParameters == null)
		{
			ownedTemplateParameters = new EObjectContainmentWithInverseEList<TemplateParameter>(TemplateParameter.class, this, PivotPackage.TEMPLATE_SIGNATURE__OWNED_TEMPLATE_PARAMETERS, PivotPackage.TEMPLATE_PARAMETER__OWNING_TEMPLATE_SIGNATURE);
		}
		return ownedTemplateParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateableElement getOwningTemplateableElement() {
		if (eContainerFeatureID() != PivotPackage.TEMPLATE_SIGNATURE__OWNING_TEMPLATEABLE_ELEMENT) return null;
		return (TemplateableElement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTemplateableElement(TemplateableElement newOwningTemplateableElement, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningTemplateableElement, PivotPackage.TEMPLATE_SIGNATURE__OWNING_TEMPLATEABLE_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTemplateableElement(TemplateableElement newOwningTemplateableElement) {
		if (newOwningTemplateableElement != eInternalContainer() || (eContainerFeatureID() != PivotPackage.TEMPLATE_SIGNATURE__OWNING_TEMPLATEABLE_ELEMENT && newOwningTemplateableElement != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningTemplateableElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTemplateableElement != null)
				msgs = ((InternalEObject)newOwningTemplateableElement).eInverseAdd(this, PivotPackage.TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_SIGNATURE, TemplateableElement.class, msgs);
			msgs = basicSetOwningTemplateableElement(newOwningTemplateableElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TEMPLATE_SIGNATURE__OWNING_TEMPLATEABLE_ELEMENT, newOwningTemplateableElement, newOwningTemplateableElement));
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
			case PivotPackage.TEMPLATE_SIGNATURE__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.TEMPLATE_SIGNATURE__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_TEMPLATE_PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTemplateParameters()).basicAdd(otherEnd, msgs);
			case PivotPackage.TEMPLATE_SIGNATURE__OWNING_TEMPLATEABLE_ELEMENT:
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
			case PivotPackage.TEMPLATE_SIGNATURE__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_SIGNATURE__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_TEMPLATE_PARAMETERS:
				return ((InternalEList<?>)getOwnedTemplateParameters()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_SIGNATURE__OWNING_TEMPLATEABLE_ELEMENT:
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
			case PivotPackage.TEMPLATE_SIGNATURE__OWNING_TEMPLATEABLE_ELEMENT:
				return eInternalContainer().eInverseRemove(this, PivotPackage.TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_SIGNATURE, TemplateableElement.class, msgs);
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
			case PivotPackage.TEMPLATE_SIGNATURE__COMMENT:
				return getComment();
			case PivotPackage.TEMPLATE_SIGNATURE__EXTENSION:
				return getExtension();
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_TEMPLATE_PARAMETERS:
				return getOwnedTemplateParameters();
			case PivotPackage.TEMPLATE_SIGNATURE__OWNING_TEMPLATEABLE_ELEMENT:
				return getOwningTemplateableElement();
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
			case PivotPackage.TEMPLATE_SIGNATURE__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TEMPLATE_SIGNATURE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_TEMPLATE_PARAMETERS:
				getOwnedTemplateParameters().clear();
				getOwnedTemplateParameters().addAll((Collection<? extends TemplateParameter>)newValue);
				return;
			case PivotPackage.TEMPLATE_SIGNATURE__OWNING_TEMPLATEABLE_ELEMENT:
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
			case PivotPackage.TEMPLATE_SIGNATURE__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.TEMPLATE_SIGNATURE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_TEMPLATE_PARAMETERS:
				getOwnedTemplateParameters().clear();
				return;
			case PivotPackage.TEMPLATE_SIGNATURE__OWNING_TEMPLATEABLE_ELEMENT:
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
			case PivotPackage.TEMPLATE_SIGNATURE__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.TEMPLATE_SIGNATURE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.TEMPLATE_SIGNATURE__OWNED_TEMPLATE_PARAMETERS:
				return ownedTemplateParameters != null && !ownedTemplateParameters.isEmpty();
			case PivotPackage.TEMPLATE_SIGNATURE__OWNING_TEMPLATEABLE_ELEMENT:
				return getOwningTemplateableElement() != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitTemplateSignature(this);
	}
	
	public static @NonNull DomainTypeParameters getTypeParameters(@Nullable TemplateSignature templateSignature) {
		if (templateSignature == null) {
			return DomainTypeParameters.EMPTY_LIST;
		}
		List<TemplateParameter> templateParameters = templateSignature.getOwnedTemplateParameters();
		int iMax = templateParameters.size();
		TemplateParameter[] typeParameters = new TemplateParameter[iMax];
		for (int i = 0; i < iMax; i++) {
			typeParameters[i] = templateParameters.get(i);
		}
		return new DomainTypeParameters(typeParameters);
	}
} //TemplateSignatureImpl
