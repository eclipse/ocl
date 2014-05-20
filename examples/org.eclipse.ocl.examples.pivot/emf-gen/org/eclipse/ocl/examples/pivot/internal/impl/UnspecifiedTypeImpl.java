/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TypeId;
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
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.UnspecifiedType;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unspecified Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedTypeImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedTypeImpl#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnspecifiedTypeImpl extends ClassImpl implements UnspecifiedType
{
	/**
	 * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected Type lowerBound;

	/**
	 * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected Type upperBound;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnspecifiedTypeImpl()
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
		return PivotPackage.Literals.UNSPECIFIED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getLowerBound()
	{
		if (lowerBound != null && ((EObject)lowerBound).eIsProxy())
		{
			InternalEObject oldLowerBound = (InternalEObject)lowerBound;
			lowerBound = (Type)eResolveProxy(oldLowerBound);
			if (lowerBound != oldLowerBound)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.UNSPECIFIED_TYPE__LOWER_BOUND, oldLowerBound, lowerBound));
			}
		}
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetLowerBound()
	{
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(Type newLowerBound)
	{
		Type oldLowerBound = lowerBound;
		lowerBound = newLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.UNSPECIFIED_TYPE__LOWER_BOUND, oldLowerBound, lowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getUpperBound()
	{
		if (upperBound != null && ((EObject)upperBound).eIsProxy())
		{
			InternalEObject oldUpperBound = (InternalEObject)upperBound;
			upperBound = (Type)eResolveProxy(oldUpperBound);
			if (upperBound != oldUpperBound)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.UNSPECIFIED_TYPE__UPPER_BOUND, oldUpperBound, upperBound));
			}
		}
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetUpperBound()
	{
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(Type newUpperBound)
	{
		Type oldUpperBound = upperBound;
		upperBound = newUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.UNSPECIFIED_TYPE__UPPER_BOUND, oldUpperBound, upperBound));
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
			case PivotPackage.UNSPECIFIED_TYPE__EXTENSION:
				return getExtension();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.UNSPECIFIED_TYPE__IS_STATIC:
				return isStatic();
			case PivotPackage.UNSPECIFIED_TYPE__NAME:
				return getName();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.UNSPECIFIED_TYPE__TEMPLATE_BINDING:
				return getTemplateBinding();
			case PivotPackage.UNSPECIFIED_TYPE__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.UNSPECIFIED_TYPE__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.UNSPECIFIED_TYPE__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.UNSPECIFIED_TYPE__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.UNSPECIFIED_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_ATTRIBUTE:
				return getOwnedAttribute();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_INVARIANT:
				return getOwnedInvariant();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_OPERATION:
				return getOwnedOperation();
			case PivotPackage.UNSPECIFIED_TYPE__PACKAGE:
				return getPackage();
			case PivotPackage.UNSPECIFIED_TYPE__SUPER_CLASS:
				return getSuperClass();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.UNSPECIFIED_TYPE__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.UNSPECIFIED_TYPE__IS_ACTIVE:
				return isActive();
			case PivotPackage.UNSPECIFIED_TYPE__IS_INTERFACE:
				return isInterface();
			case PivotPackage.UNSPECIFIED_TYPE__NESTED_TYPE:
				return getNestedType();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case PivotPackage.UNSPECIFIED_TYPE__LOWER_BOUND:
				if (resolve) return getLowerBound();
				return basicGetLowerBound();
			case PivotPackage.UNSPECIFIED_TYPE__UPPER_BOUND:
				if (resolve) return getUpperBound();
				return basicGetUpperBound();
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
			case PivotPackage.UNSPECIFIED_TYPE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				getTemplateBinding().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				getOwnedAttribute().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				getOwnedInvariant().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_OPERATION:
				getOwnedOperation().clear();
				getOwnedOperation().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__SUPER_CLASS:
				getSuperClass().clear();
				getSuperClass().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__IS_ACTIVE:
				setIsActive((Boolean)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__NESTED_TYPE:
				getNestedType().clear();
				getNestedType().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				getOwnedBehavior().addAll((Collection<? extends Behavior>)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__LOWER_BOUND:
				setLowerBound((Type)newValue);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__UPPER_BOUND:
				setUpperBound((Type)newValue);
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
			case PivotPackage.UNSPECIFIED_TYPE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.UNSPECIFIED_TYPE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				return;
			case PivotPackage.UNSPECIFIED_TYPE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.UNSPECIFIED_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_OPERATION:
				getOwnedOperation().clear();
				return;
			case PivotPackage.UNSPECIFIED_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__SUPER_CLASS:
				getSuperClass().clear();
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.UNSPECIFIED_TYPE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__IS_ACTIVE:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__NESTED_TYPE:
				getNestedType().clear();
				return;
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				return;
			case PivotPackage.UNSPECIFIED_TYPE__LOWER_BOUND:
				setLowerBound((Type)null);
				return;
			case PivotPackage.UNSPECIFIED_TYPE__UPPER_BOUND:
				setUpperBound((Type)null);
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
			case PivotPackage.UNSPECIFIED_TYPE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.UNSPECIFIED_TYPE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.UNSPECIFIED_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.UNSPECIFIED_TYPE__TEMPLATE_BINDING:
				return templateBinding != null && !templateBinding.isEmpty();
			case PivotPackage.UNSPECIFIED_TYPE__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.UNSPECIFIED_TYPE__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.UNSPECIFIED_TYPE__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.UNSPECIFIED_TYPE__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.UNSPECIFIED_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_ATTRIBUTE:
				return ownedAttribute != null && !ownedAttribute.isEmpty();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_INVARIANT:
				return ownedInvariant != null && !ownedInvariant.isEmpty();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_OPERATION:
				return ownedOperation != null && !ownedOperation.isEmpty();
			case PivotPackage.UNSPECIFIED_TYPE__PACKAGE:
				return getPackage() != null;
			case PivotPackage.UNSPECIFIED_TYPE__SUPER_CLASS:
				return superClass != null && !superClass.isEmpty();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.UNSPECIFIED_TYPE__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.UNSPECIFIED_TYPE__IS_ACTIVE:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case PivotPackage.UNSPECIFIED_TYPE__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.UNSPECIFIED_TYPE__NESTED_TYPE:
				return nestedType != null && !nestedType.isEmpty();
			case PivotPackage.UNSPECIFIED_TYPE__OWNED_BEHAVIOR:
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case PivotPackage.UNSPECIFIED_TYPE__LOWER_BOUND:
				return lowerBound != null;
			case PivotPackage.UNSPECIFIED_TYPE__UPPER_BOUND:
				return upperBound != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitUnspecifiedType(this);
	}
	
	@Override
	public @NonNull TypeId computeId() {
		String name2 = getName();
		assert name2 != null;
		return IdManager.getUnspecifiedTypeId(this);
	}

	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		throw new UnsupportedOperationException();		// WIP
	}
} //UnspecifiedTypeImpl
