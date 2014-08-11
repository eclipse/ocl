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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.MetaclassImpl#getInstanceType <em>Instance Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetaclassImpl<T> extends ClassImpl implements Metaclass<T>
{
	/**
	 * The cached value of the '{@link #getInstanceType() <em>Instance Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceType()
	 * @generated
	 * @ordered
	 */
	protected Type instanceType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaclassImpl()
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
		return PivotPackage.Literals.METACLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getInstanceType()
	{
		if (instanceType != null && ((EObject)instanceType).eIsProxy())
		{
			InternalEObject oldInstanceType = (InternalEObject)instanceType;
			instanceType = (Type)eResolveProxy(oldInstanceType);
			if (instanceType != oldInstanceType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.METACLASS__INSTANCE_TYPE, oldInstanceType, instanceType));
			}
		}
		return instanceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetInstanceType()
	{
		return instanceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceType(Type newInstanceType)
	{
		Type oldInstanceType = instanceType;
		instanceType = newInstanceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.METACLASS__INSTANCE_TYPE, oldInstanceType, instanceType));
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
			case PivotPackage.METACLASS__COMMENT:
				return getComment();
			case PivotPackage.METACLASS__EXTENSION:
				return getExtension();
			case PivotPackage.METACLASS__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.METACLASS__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.METACLASS__NAME:
				return getName();
			case PivotPackage.METACLASS__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.METACLASS__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.METACLASS__OWNED_TEMPLATE_BINDINGS:
				return getOwnedTemplateBindings();
			case PivotPackage.METACLASS__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.METACLASS__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.METACLASS__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.METACLASS__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.METACLASS__IS_ACTIVE:
				return isActive();
			case PivotPackage.METACLASS__IS_INTERFACE:
				return isInterface();
			case PivotPackage.METACLASS__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case PivotPackage.METACLASS__OWNED_INVARIANTS:
				return getOwnedInvariants();
			case PivotPackage.METACLASS__OWNED_OPERATIONS:
				return getOwnedOperations();
			case PivotPackage.METACLASS__OWNED_PROPERTIES:
				return getOwnedProperties();
			case PivotPackage.METACLASS__OWNING_PACKAGE:
				return getOwningPackage();
			case PivotPackage.METACLASS__SUPER_CLASSES:
				return getSuperClasses();
			case PivotPackage.METACLASS__INSTANCE_TYPE:
				if (resolve) return getInstanceType();
				return basicGetInstanceType();
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
			case PivotPackage.METACLASS__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.METACLASS__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.METACLASS__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.METACLASS__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.METACLASS__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.METACLASS__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.METACLASS__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.METACLASS__OWNED_TEMPLATE_BINDINGS:
				getOwnedTemplateBindings().clear();
				getOwnedTemplateBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.METACLASS__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.METACLASS__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.METACLASS__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.METACLASS__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.METACLASS__IS_ACTIVE:
				setIsActive((Boolean)newValue);
				return;
			case PivotPackage.METACLASS__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.METACLASS__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				getOwnedBehavior().addAll((Collection<? extends Behavior>)newValue);
				return;
			case PivotPackage.METACLASS__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
				getOwnedInvariants().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.METACLASS__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.METACLASS__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				getOwnedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.METACLASS__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.METACLASS__SUPER_CLASSES:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.METACLASS__INSTANCE_TYPE:
				setInstanceType((Type)newValue);
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
			case PivotPackage.METACLASS__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.METACLASS__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.METACLASS__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.METACLASS__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.METACLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.METACLASS__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.METACLASS__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.METACLASS__OWNED_TEMPLATE_BINDINGS:
				getOwnedTemplateBindings().clear();
				return;
			case PivotPackage.METACLASS__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.METACLASS__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.METACLASS__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.METACLASS__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.METACLASS__IS_ACTIVE:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case PivotPackage.METACLASS__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.METACLASS__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				return;
			case PivotPackage.METACLASS__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
				return;
			case PivotPackage.METACLASS__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				return;
			case PivotPackage.METACLASS__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				return;
			case PivotPackage.METACLASS__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.METACLASS__SUPER_CLASSES:
				getSuperClasses().clear();
				return;
			case PivotPackage.METACLASS__INSTANCE_TYPE:
				setInstanceType((Type)null);
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
			case PivotPackage.METACLASS__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.METACLASS__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.METACLASS__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.METACLASS__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.METACLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.METACLASS__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.METACLASS__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.METACLASS__OWNED_TEMPLATE_BINDINGS:
				return ownedTemplateBindings != null && !ownedTemplateBindings.isEmpty();
			case PivotPackage.METACLASS__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.METACLASS__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.METACLASS__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.METACLASS__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.METACLASS__IS_ACTIVE:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case PivotPackage.METACLASS__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.METACLASS__OWNED_BEHAVIOR:
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case PivotPackage.METACLASS__OWNED_INVARIANTS:
				return ownedInvariants != null && !ownedInvariants.isEmpty();
			case PivotPackage.METACLASS__OWNED_OPERATIONS:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case PivotPackage.METACLASS__OWNED_PROPERTIES:
				return ownedProperties != null && !ownedProperties.isEmpty();
			case PivotPackage.METACLASS__OWNING_PACKAGE:
				return getOwningPackage() != null;
			case PivotPackage.METACLASS__SUPER_CLASSES:
				return superClasses != null && !superClasses.isEmpty();
			case PivotPackage.METACLASS__INSTANCE_TYPE:
				return instanceType != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitMetaclass(this);
	}

	@Override
	public @NonNull MetaclassId computeId() {
		if (getUnspecializedElement() == null) {
			return TypeId.METACLASS;
		}
		else {
			return TypeId.METACLASS.getSpecializedId(getInstanceType().getTypeId());
		}
	}

	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		Type instanceType = getInstanceType();
		if (instanceType instanceof ElementExtension) {									// FIXME Rationalize ElementEXtension metatyping
			instanceType = ((ElementExtension)instanceType).getStereotype();
			return instanceType.conformsTo(standardLibrary, type);
		}
		String metaTypeName = instanceType.getMetaTypeName();
		DomainType metaType = standardLibrary.getOclType(metaTypeName);
		if (type instanceof DomainMetaclass) {
			return instanceType.conformsTo(standardLibrary, DomainUtil.nonNullModel(((DomainMetaclass)type).getInstanceType()));
		}
		else {
//			boolean conformsTo1 = instanceType.conformsTo(standardLibrary, type);
			boolean conformsTo2 = metaType.conformsTo(standardLibrary, type);
//			DomainType metaType2 = ((MetaModelManager)standardLibrary).getIdResolver().getStaticTypeOf(instanceType);
//			boolean conformsTo3 = metaType2.conformsTo(standardLibrary, type);
//			if (conformsTo1 != conformsTo2) {
//				instanceType.conformsTo(standardLibrary, type);
//				metaType.conformsTo(standardLibrary, type);
//			}
			return conformsTo2;
		}
	}

	public DomainType getContainerType() {
		return (DomainType) getUnspecializedElement();
	}

	@Override
	public TemplateableElement getUnspecializedElement() {
		TemplateableElement unspecializedElement2 = super.getUnspecializedElement();
		if (unspecializedElement2 != null) {
			return unspecializedElement2;
		}
		else if (getOwnedTemplateSignature() != null) {
			return unspecializedElement2;
		}
		else {
			Resource resource = eResource();
			if (resource != null) {
				for (EObject eObject : resource.getContents()) {
					if (eObject instanceof Root) {
						for (org.eclipse.ocl.examples.pivot.Package pkg : ((Root)eObject).getOwnedPackages()) {
							org.eclipse.ocl.examples.pivot.Class type = DomainUtil.getNamedElement(pkg.getOwnedClasses(), getName());
							if (type instanceof Metaclass) {
								setUnspecializedElement(type);
								return type;
							}
						}
					}
				}
			}
			return unspecializedElement2;
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //MetaclassImpl
