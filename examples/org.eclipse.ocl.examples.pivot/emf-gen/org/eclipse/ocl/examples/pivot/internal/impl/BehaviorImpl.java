/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Transition;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.BehaviorImpl#getTransition <em>Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BehaviorImpl extends ClassImpl implements Behavior
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition getTransition()
	{
		if (eContainerFeatureID() != PivotPackage.BEHAVIOR__TRANSITION) return null;
		return (Transition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransition(Transition newTransition, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newTransition, PivotPackage.BEHAVIOR__TRANSITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("cast")
	public void setTransition(Transition newTransition)
	{
		if (newTransition != eInternalContainer() || (eContainerFeatureID() != PivotPackage.BEHAVIOR__TRANSITION && newTransition != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newTransition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTransition != null)
				msgs = ((InternalEObject)newTransition).eInverseAdd(this, PivotPackage.TRANSITION__EFFECT, Transition.class, msgs);
			msgs = basicSetTransition(newTransition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.BEHAVIOR__TRANSITION, newTransition, newTransition));
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
			case PivotPackage.BEHAVIOR__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.BEHAVIOR__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
			case PivotPackage.BEHAVIOR__TEMPLATE_BINDING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTemplateBinding()).basicAdd(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__OWNING_TEMPLATE_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.BEHAVIOR__TEMPLATE_PARAMETER:
				if (templateParameter != null)
					msgs = ((InternalEObject)templateParameter).eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
				return basicSetTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.BEHAVIOR__EXTENDED_BYS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtendedBys()).basicAdd(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__OWNED_ATTRIBUTE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedAttribute()).basicAdd(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__OWNED_OPERATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperation()).basicAdd(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPackage((org.eclipse.ocl.examples.pivot.Package)otherEnd, msgs);
			case PivotPackage.BEHAVIOR__TRANSITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTransition((Transition)otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PivotPackage.BEHAVIOR__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case PivotPackage.BEHAVIOR__TEMPLATE_BINDING:
				return ((InternalEList<?>)getTemplateBinding()).basicRemove(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__OWNING_TEMPLATE_PARAMETER:
				return basicSetOwningTemplateParameter(null, msgs);
			case PivotPackage.BEHAVIOR__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case PivotPackage.BEHAVIOR__EXTENDED_BYS:
				return ((InternalEList<?>)getExtendedBys()).basicRemove(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__OWNED_ATTRIBUTE:
				return ((InternalEList<?>)getOwnedAttribute()).basicRemove(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__OWNED_INVARIANT:
				return ((InternalEList<?>)getOwnedInvariant()).basicRemove(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__OWNED_OPERATION:
				return ((InternalEList<?>)getOwnedOperation()).basicRemove(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__PACKAGE:
				return basicSetPackage(null, msgs);
			case PivotPackage.BEHAVIOR__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__NESTED_TYPE:
				return ((InternalEList<?>)getNestedType()).basicRemove(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__OWNED_BEHAVIOR:
				return ((InternalEList<?>)getOwnedBehavior()).basicRemove(otherEnd, msgs);
			case PivotPackage.BEHAVIOR__TRANSITION:
				return basicSetTransition(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case PivotPackage.BEHAVIOR__OWNING_TEMPLATE_PARAMETER:
				return eInternalContainer().eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
			case PivotPackage.BEHAVIOR__PACKAGE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.PACKAGE__OWNED_TYPE, org.eclipse.ocl.examples.pivot.Package.class, msgs);
			case PivotPackage.BEHAVIOR__TRANSITION:
				return eInternalContainer().eInverseRemove(this, PivotPackage.TRANSITION__EFFECT, Transition.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case PivotPackage.BEHAVIOR__EXTENSION:
				return getExtension();
			case PivotPackage.BEHAVIOR__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.BEHAVIOR__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.BEHAVIOR__IS_STATIC:
				return isStatic();
			case PivotPackage.BEHAVIOR__NAME:
				return getName();
			case PivotPackage.BEHAVIOR__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.BEHAVIOR__TEMPLATE_BINDING:
				return getTemplateBinding();
			case PivotPackage.BEHAVIOR__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.BEHAVIOR__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.BEHAVIOR__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.BEHAVIOR__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.BEHAVIOR__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.BEHAVIOR__OWNED_ATTRIBUTE:
				return getOwnedAttribute();
			case PivotPackage.BEHAVIOR__OWNED_INVARIANT:
				return getOwnedInvariant();
			case PivotPackage.BEHAVIOR__OWNED_OPERATION:
				return getOwnedOperation();
			case PivotPackage.BEHAVIOR__PACKAGE:
				return getPackage();
			case PivotPackage.BEHAVIOR__SUPER_CLASS:
				return getSuperClass();
			case PivotPackage.BEHAVIOR__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.BEHAVIOR__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.BEHAVIOR__IS_ACTIVE:
				return isActive();
			case PivotPackage.BEHAVIOR__IS_INTERFACE:
				return isInterface();
			case PivotPackage.BEHAVIOR__NESTED_TYPE:
				return getNestedType();
			case PivotPackage.BEHAVIOR__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case PivotPackage.BEHAVIOR__TRANSITION:
				return getTransition();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case PivotPackage.BEHAVIOR__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.BEHAVIOR__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.BEHAVIOR__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.BEHAVIOR__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.BEHAVIOR__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.BEHAVIOR__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.BEHAVIOR__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				getTemplateBinding().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.BEHAVIOR__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.BEHAVIOR__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.BEHAVIOR__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.BEHAVIOR__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.BEHAVIOR__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.BEHAVIOR__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				getOwnedAttribute().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.BEHAVIOR__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				getOwnedInvariant().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.BEHAVIOR__OWNED_OPERATION:
				getOwnedOperation().clear();
				getOwnedOperation().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.BEHAVIOR__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.BEHAVIOR__SUPER_CLASS:
				getSuperClass().clear();
				getSuperClass().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.BEHAVIOR__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.BEHAVIOR__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.BEHAVIOR__IS_ACTIVE:
				setIsActive((Boolean)newValue);
				return;
			case PivotPackage.BEHAVIOR__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.BEHAVIOR__NESTED_TYPE:
				getNestedType().clear();
				getNestedType().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.BEHAVIOR__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				getOwnedBehavior().addAll((Collection<? extends Behavior>)newValue);
				return;
			case PivotPackage.BEHAVIOR__TRANSITION:
				setTransition((Transition)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.BEHAVIOR__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.BEHAVIOR__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.BEHAVIOR__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.BEHAVIOR__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.BEHAVIOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.BEHAVIOR__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.BEHAVIOR__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				return;
			case PivotPackage.BEHAVIOR__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.BEHAVIOR__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.BEHAVIOR__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.BEHAVIOR__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.BEHAVIOR__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.BEHAVIOR__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				return;
			case PivotPackage.BEHAVIOR__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				return;
			case PivotPackage.BEHAVIOR__OWNED_OPERATION:
				getOwnedOperation().clear();
				return;
			case PivotPackage.BEHAVIOR__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.BEHAVIOR__SUPER_CLASS:
				getSuperClass().clear();
				return;
			case PivotPackage.BEHAVIOR__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.BEHAVIOR__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.BEHAVIOR__IS_ACTIVE:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case PivotPackage.BEHAVIOR__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.BEHAVIOR__NESTED_TYPE:
				getNestedType().clear();
				return;
			case PivotPackage.BEHAVIOR__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				return;
			case PivotPackage.BEHAVIOR__TRANSITION:
				setTransition((Transition)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.BEHAVIOR__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.BEHAVIOR__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.BEHAVIOR__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.BEHAVIOR__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.BEHAVIOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.BEHAVIOR__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.BEHAVIOR__TEMPLATE_BINDING:
				return templateBinding != null && !templateBinding.isEmpty();
			case PivotPackage.BEHAVIOR__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.BEHAVIOR__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.BEHAVIOR__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.BEHAVIOR__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.BEHAVIOR__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.BEHAVIOR__OWNED_ATTRIBUTE:
				return ownedAttribute != null && !ownedAttribute.isEmpty();
			case PivotPackage.BEHAVIOR__OWNED_INVARIANT:
				return ownedInvariant != null && !ownedInvariant.isEmpty();
			case PivotPackage.BEHAVIOR__OWNED_OPERATION:
				return ownedOperation != null && !ownedOperation.isEmpty();
			case PivotPackage.BEHAVIOR__PACKAGE:
				return getPackage() != null;
			case PivotPackage.BEHAVIOR__SUPER_CLASS:
				return superClass != null && !superClass.isEmpty();
			case PivotPackage.BEHAVIOR__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.BEHAVIOR__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.BEHAVIOR__IS_ACTIVE:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case PivotPackage.BEHAVIOR__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.BEHAVIOR__NESTED_TYPE:
				return nestedType != null && !nestedType.isEmpty();
			case PivotPackage.BEHAVIOR__OWNED_BEHAVIOR:
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case PivotPackage.BEHAVIOR__TRANSITION:
				return getTransition() != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitBehavior(this);
	}
} //BehaviorImpl
