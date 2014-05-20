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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.DataTypeImpl#getBehavioralType <em>Behavioral Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.DataTypeImpl#isSerializable <em>Is Serializable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataTypeImpl
		extends ClassImpl
		implements DataType {

	/**
	 * The cached value of the '{@link #getBehavioralType() <em>Behavioral Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavioralType()
	 * @generated
	 * @ordered
	 */
	protected Type behavioralType;
	/**
	 * The default value of the '{@link #isSerializable() <em>Is Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSerializable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SERIALIZABLE_EDEFAULT = true;
	/**
	 * The flag representing the value of the '{@link #isSerializable() <em>Is Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSerializable()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_SERIALIZABLE_EFLAG = 1 << 12;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeImpl() {
		super();
		eFlags |= IS_SERIALIZABLE_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSerializable()
	{
		return (eFlags & IS_SERIALIZABLE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSerializable(boolean newIsSerializable)
	{
		boolean oldIsSerializable = (eFlags & IS_SERIALIZABLE_EFLAG) != 0;
		if (newIsSerializable) eFlags |= IS_SERIALIZABLE_EFLAG; else eFlags &= ~IS_SERIALIZABLE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.DATA_TYPE__IS_SERIALIZABLE, oldIsSerializable, newIsSerializable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getBehavioralType()
	{
		if (behavioralType != null && ((EObject)behavioralType).eIsProxy())
		{
			InternalEObject oldBehavioralType = (InternalEObject)behavioralType;
			behavioralType = (Type)eResolveProxy(oldBehavioralType);
			if (behavioralType != oldBehavioralType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.DATA_TYPE__BEHAVIORAL_TYPE, oldBehavioralType, behavioralType));
			}
		}
		return behavioralType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetBehavioralType()
	{
		return behavioralType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehavioralType(Type newBehavioralType)
	{
		Type oldBehavioralType = behavioralType;
		behavioralType = newBehavioralType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.DATA_TYPE__BEHAVIORAL_TYPE, oldBehavioralType, behavioralType));
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
			case PivotPackage.DATA_TYPE__EXTENSION:
				return getExtension();
			case PivotPackage.DATA_TYPE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.DATA_TYPE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.DATA_TYPE__IS_STATIC:
				return isStatic();
			case PivotPackage.DATA_TYPE__NAME:
				return getName();
			case PivotPackage.DATA_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.DATA_TYPE__TEMPLATE_BINDING:
				return getTemplateBinding();
			case PivotPackage.DATA_TYPE__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.DATA_TYPE__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.DATA_TYPE__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.DATA_TYPE__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.DATA_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.DATA_TYPE__OWNED_ATTRIBUTE:
				return getOwnedAttribute();
			case PivotPackage.DATA_TYPE__OWNED_INVARIANT:
				return getOwnedInvariant();
			case PivotPackage.DATA_TYPE__OWNED_OPERATION:
				return getOwnedOperation();
			case PivotPackage.DATA_TYPE__PACKAGE:
				return getPackage();
			case PivotPackage.DATA_TYPE__SUPER_CLASS:
				return getSuperClass();
			case PivotPackage.DATA_TYPE__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.DATA_TYPE__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.DATA_TYPE__IS_ACTIVE:
				return isActive();
			case PivotPackage.DATA_TYPE__IS_INTERFACE:
				return isInterface();
			case PivotPackage.DATA_TYPE__NESTED_TYPE:
				return getNestedType();
			case PivotPackage.DATA_TYPE__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case PivotPackage.DATA_TYPE__BEHAVIORAL_TYPE:
				if (resolve) return getBehavioralType();
				return basicGetBehavioralType();
			case PivotPackage.DATA_TYPE__IS_SERIALIZABLE:
				return isSerializable();
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
			case PivotPackage.DATA_TYPE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.DATA_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.DATA_TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.DATA_TYPE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.DATA_TYPE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.DATA_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.DATA_TYPE__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				getTemplateBinding().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.DATA_TYPE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.DATA_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.DATA_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.DATA_TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.DATA_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.DATA_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				getOwnedAttribute().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.DATA_TYPE__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				getOwnedInvariant().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.DATA_TYPE__OWNED_OPERATION:
				getOwnedOperation().clear();
				getOwnedOperation().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.DATA_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.DATA_TYPE__SUPER_CLASS:
				getSuperClass().clear();
				getSuperClass().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.DATA_TYPE__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.DATA_TYPE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.DATA_TYPE__IS_ACTIVE:
				setIsActive((Boolean)newValue);
				return;
			case PivotPackage.DATA_TYPE__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.DATA_TYPE__NESTED_TYPE:
				getNestedType().clear();
				getNestedType().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.DATA_TYPE__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				getOwnedBehavior().addAll((Collection<? extends Behavior>)newValue);
				return;
			case PivotPackage.DATA_TYPE__BEHAVIORAL_TYPE:
				setBehavioralType((Type)newValue);
				return;
			case PivotPackage.DATA_TYPE__IS_SERIALIZABLE:
				setIsSerializable((Boolean)newValue);
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
			case PivotPackage.DATA_TYPE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.DATA_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.DATA_TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.DATA_TYPE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.DATA_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.DATA_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.DATA_TYPE__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				return;
			case PivotPackage.DATA_TYPE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.DATA_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.DATA_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.DATA_TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.DATA_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.DATA_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				return;
			case PivotPackage.DATA_TYPE__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				return;
			case PivotPackage.DATA_TYPE__OWNED_OPERATION:
				getOwnedOperation().clear();
				return;
			case PivotPackage.DATA_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.DATA_TYPE__SUPER_CLASS:
				getSuperClass().clear();
				return;
			case PivotPackage.DATA_TYPE__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.DATA_TYPE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.DATA_TYPE__IS_ACTIVE:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case PivotPackage.DATA_TYPE__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.DATA_TYPE__NESTED_TYPE:
				getNestedType().clear();
				return;
			case PivotPackage.DATA_TYPE__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				return;
			case PivotPackage.DATA_TYPE__BEHAVIORAL_TYPE:
				setBehavioralType((Type)null);
				return;
			case PivotPackage.DATA_TYPE__IS_SERIALIZABLE:
				setIsSerializable(IS_SERIALIZABLE_EDEFAULT);
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
			case PivotPackage.DATA_TYPE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.DATA_TYPE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.DATA_TYPE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.DATA_TYPE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.DATA_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.DATA_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.DATA_TYPE__TEMPLATE_BINDING:
				return templateBinding != null && !templateBinding.isEmpty();
			case PivotPackage.DATA_TYPE__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.DATA_TYPE__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.DATA_TYPE__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.DATA_TYPE__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.DATA_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.DATA_TYPE__OWNED_ATTRIBUTE:
				return ownedAttribute != null && !ownedAttribute.isEmpty();
			case PivotPackage.DATA_TYPE__OWNED_INVARIANT:
				return ownedInvariant != null && !ownedInvariant.isEmpty();
			case PivotPackage.DATA_TYPE__OWNED_OPERATION:
				return ownedOperation != null && !ownedOperation.isEmpty();
			case PivotPackage.DATA_TYPE__PACKAGE:
				return getPackage() != null;
			case PivotPackage.DATA_TYPE__SUPER_CLASS:
				return superClass != null && !superClass.isEmpty();
			case PivotPackage.DATA_TYPE__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.DATA_TYPE__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.DATA_TYPE__IS_ACTIVE:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case PivotPackage.DATA_TYPE__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.DATA_TYPE__NESTED_TYPE:
				return nestedType != null && !nestedType.isEmpty();
			case PivotPackage.DATA_TYPE__OWNED_BEHAVIOR:
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case PivotPackage.DATA_TYPE__BEHAVIORAL_TYPE:
				return behavioralType != null;
			case PivotPackage.DATA_TYPE__IS_SERIALIZABLE:
				return ((eFlags & IS_SERIALIZABLE_EFLAG) != 0) != IS_SERIALIZABLE_EDEFAULT;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitDataType(this);
	}
	
	@Override
	public @NonNull TypeId computeId() {
		TemplateParameter owningTemplateParameter = getOwningTemplateParameter();
		if (owningTemplateParameter != null) {
			return owningTemplateParameter.getElementId();
		}
		else if (eContainer() instanceof Library) {
			String name2 = name;
			if (name2 == null) {
				name2 = "";
			}
			return IdManager.getNsURIPackageId(PivotPackage.eNS_URI, PivotPackage.eNS_PREFIX, PivotPackage.eINSTANCE).getDataTypeId(name2, getTypeParameters().parametersSize());
		}
		else {
			Type behavioralType = getBehavioralType();
			if ((behavioralType != null) && (behavioralType != this)) {
//				return behavioralType.getTypeId();
			}
			return IdManager.getDataTypeId(this);
		}
	}

	@Override
	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		DomainType behavioralType = getBehavioralType();
		return standardLibrary.getInheritance(behavioralType != null ? behavioralType : this);
	}
} //DataTypeImpl
