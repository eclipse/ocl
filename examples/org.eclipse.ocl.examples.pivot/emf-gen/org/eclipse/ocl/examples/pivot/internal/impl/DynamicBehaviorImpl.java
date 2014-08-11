/**
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
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
import org.eclipse.ocl.examples.pivot.DynamicBehavior;
import org.eclipse.ocl.examples.pivot.DynamicProperty;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Transition;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.DynamicBehaviorImpl#getTransition <em>Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DynamicBehaviorImpl extends DynamicTypeImpl implements DynamicBehavior
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicBehaviorImpl()
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
		return PivotPackage.Literals.DYNAMIC_BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition getTransition()
	{
		if (eContainerFeatureID() != PivotPackage.DYNAMIC_BEHAVIOR__TRANSITION) return null;
		return (Transition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransition(Transition newTransition, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newTransition, PivotPackage.DYNAMIC_BEHAVIOR__TRANSITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransition(Transition newTransition)
	{
		if (newTransition != eInternalContainer() || (eContainerFeatureID() != PivotPackage.DYNAMIC_BEHAVIOR__TRANSITION && newTransition != null))
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
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.DYNAMIC_BEHAVIOR__TRANSITION, newTransition, newTransition));
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
			case PivotPackage.DYNAMIC_BEHAVIOR__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__EXTENDED_BYS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtendedBys()).basicAdd(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_BINDINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTemplateBindings()).basicAdd(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperations()).basicAdd(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_PROPERTIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedProperties()).basicAdd(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningPackage((org.eclipse.ocl.examples.pivot.Package)otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__TRANSITION:
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
			case PivotPackage.DYNAMIC_BEHAVIOR__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__EXTENDED_BYS:
				return ((InternalEList<?>)getExtendedBys()).basicRemove(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_BINDINGS:
				return ((InternalEList<?>)getOwnedTemplateBindings()).basicRemove(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_BEHAVIOR:
				return ((InternalEList<?>)getOwnedBehavior()).basicRemove(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_INVARIANTS:
				return ((InternalEList<?>)getOwnedInvariants()).basicRemove(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_OPERATIONS:
				return ((InternalEList<?>)getOwnedOperations()).basicRemove(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_PROPERTIES:
				return ((InternalEList<?>)getOwnedProperties()).basicRemove(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNING_PACKAGE:
				return basicSetOwningPackage(null, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_PROPERTY:
				return ((InternalEList<?>)getOwnedProperty()).basicRemove(otherEnd, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__TRANSITION:
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
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNING_PACKAGE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.PACKAGE__OWNED_CLASSES, org.eclipse.ocl.examples.pivot.Package.class, msgs);
			case PivotPackage.DYNAMIC_BEHAVIOR__TRANSITION:
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
			case PivotPackage.DYNAMIC_BEHAVIOR__COMMENT:
				return getComment();
			case PivotPackage.DYNAMIC_BEHAVIOR__EXTENSION:
				return getExtension();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.DYNAMIC_BEHAVIOR__NAME:
				return getName();
			case PivotPackage.DYNAMIC_BEHAVIOR__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_BINDINGS:
				return getOwnedTemplateBindings();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.DYNAMIC_BEHAVIOR__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.DYNAMIC_BEHAVIOR__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.DYNAMIC_BEHAVIOR__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.DYNAMIC_BEHAVIOR__IS_ACTIVE:
				return isActive();
			case PivotPackage.DYNAMIC_BEHAVIOR__IS_INTERFACE:
				return isInterface();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_INVARIANTS:
				return getOwnedInvariants();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_OPERATIONS:
				return getOwnedOperations();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_PROPERTIES:
				return getOwnedProperties();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNING_PACKAGE:
				return getOwningPackage();
			case PivotPackage.DYNAMIC_BEHAVIOR__SUPER_CLASSES:
				return getSuperClasses();
			case PivotPackage.DYNAMIC_BEHAVIOR__META_TYPE:
				if (resolve) return getMetaType();
				return basicGetMetaType();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_PROPERTY:
				return getOwnedProperty();
			case PivotPackage.DYNAMIC_BEHAVIOR__TRANSITION:
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
			case PivotPackage.DYNAMIC_BEHAVIOR__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_BINDINGS:
				getOwnedTemplateBindings().clear();
				getOwnedTemplateBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__IS_ACTIVE:
				setIsActive((Boolean)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				getOwnedBehavior().addAll((Collection<? extends Behavior>)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
				getOwnedInvariants().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				getOwnedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__SUPER_CLASSES:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__META_TYPE:
				setMetaType((Type)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_PROPERTY:
				getOwnedProperty().clear();
				getOwnedProperty().addAll((Collection<? extends DynamicProperty>)newValue);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__TRANSITION:
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
			case PivotPackage.DYNAMIC_BEHAVIOR__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_BINDINGS:
				getOwnedTemplateBindings().clear();
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__IS_ACTIVE:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__SUPER_CLASSES:
				getSuperClasses().clear();
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__META_TYPE:
				setMetaType((Type)null);
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_PROPERTY:
				getOwnedProperty().clear();
				return;
			case PivotPackage.DYNAMIC_BEHAVIOR__TRANSITION:
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
			case PivotPackage.DYNAMIC_BEHAVIOR__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.DYNAMIC_BEHAVIOR__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.DYNAMIC_BEHAVIOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.DYNAMIC_BEHAVIOR__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_BINDINGS:
				return ownedTemplateBindings != null && !ownedTemplateBindings.isEmpty();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.DYNAMIC_BEHAVIOR__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.DYNAMIC_BEHAVIOR__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.DYNAMIC_BEHAVIOR__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.DYNAMIC_BEHAVIOR__IS_ACTIVE:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case PivotPackage.DYNAMIC_BEHAVIOR__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_BEHAVIOR:
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_INVARIANTS:
				return ownedInvariants != null && !ownedInvariants.isEmpty();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_OPERATIONS:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_PROPERTIES:
				return ownedProperties != null && !ownedProperties.isEmpty();
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNING_PACKAGE:
				return getOwningPackage() != null;
			case PivotPackage.DYNAMIC_BEHAVIOR__SUPER_CLASSES:
				return superClasses != null && !superClasses.isEmpty();
			case PivotPackage.DYNAMIC_BEHAVIOR__META_TYPE:
				return metaType != null;
			case PivotPackage.DYNAMIC_BEHAVIOR__OWNED_PROPERTY:
				return ownedProperty != null && !ownedProperty.isEmpty();
			case PivotPackage.DYNAMIC_BEHAVIOR__TRANSITION:
				return getTransition() != null;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == Behavior.class)
		{
			switch (derivedFeatureID)
			{
				case PivotPackage.DYNAMIC_BEHAVIOR__TRANSITION: return PivotPackage.BEHAVIOR__TRANSITION;
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == Behavior.class)
		{
			switch (baseFeatureID)
			{
				case PivotPackage.BEHAVIOR__TRANSITION: return PivotPackage.DYNAMIC_BEHAVIOR__TRANSITION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitDynamicBehavior(this);
	}
} //DynamicBehaviorImpl
