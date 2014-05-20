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
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionTypeImpl#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionTypeImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionTypeImpl#getUpper <em>Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionTypeImpl
		extends DataTypeImpl
		implements CollectionType {

	/**
	 * The cached value of the '{@link #getElementType() <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
	protected Type elementType;

	/**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final Number LOWER_EDEFAULT = (Number)PivotFactory.eINSTANCE.createFromString(PivotPackage.eINSTANCE.getInteger(), "0"); //$NON-NLS-1$
	/**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected Number lower = LOWER_EDEFAULT;
	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final Number UPPER_EDEFAULT = (Number)PivotFactory.eINSTANCE.createFromString(PivotPackage.eINSTANCE.getUnlimitedNatural(), "*"); //$NON-NLS-1$
	/**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected Number upper = UPPER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected CollectionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.COLLECTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getElementType() {
		if (elementType != null && ((EObject)elementType).eIsProxy())
		{
			InternalEObject oldElementType = (InternalEObject)elementType;
			elementType = (Type)eResolveProxy(oldElementType);
			if (elementType != oldElementType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE, oldElementType, elementType));
			}
		}
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetElementType() {
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementType(Type newElementType) {
		Type oldElementType = elementType;
		elementType = newElementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE, oldElementType, elementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Number getLower()
	{
		return lower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(Number newLower)
	{
		Number oldLower = lower;
		lower = newLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_TYPE__LOWER, oldLower, lower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Number getUpper()
	{
		return upper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(Number newUpper)
	{
		Number oldUpper = upper;
		upper = newUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_TYPE__UPPER, oldUpper, upper));
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
			case PivotPackage.COLLECTION_TYPE__EXTENSION:
				return getExtension();
			case PivotPackage.COLLECTION_TYPE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.COLLECTION_TYPE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.COLLECTION_TYPE__IS_STATIC:
				return isStatic();
			case PivotPackage.COLLECTION_TYPE__NAME:
				return getName();
			case PivotPackage.COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_BINDING:
				return getTemplateBinding();
			case PivotPackage.COLLECTION_TYPE__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.COLLECTION_TYPE__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.COLLECTION_TYPE__OWNED_ATTRIBUTE:
				return getOwnedAttribute();
			case PivotPackage.COLLECTION_TYPE__OWNED_INVARIANT:
				return getOwnedInvariant();
			case PivotPackage.COLLECTION_TYPE__OWNED_OPERATION:
				return getOwnedOperation();
			case PivotPackage.COLLECTION_TYPE__PACKAGE:
				return getPackage();
			case PivotPackage.COLLECTION_TYPE__SUPER_CLASS:
				return getSuperClass();
			case PivotPackage.COLLECTION_TYPE__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.COLLECTION_TYPE__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.COLLECTION_TYPE__IS_ACTIVE:
				return isActive();
			case PivotPackage.COLLECTION_TYPE__IS_INTERFACE:
				return isInterface();
			case PivotPackage.COLLECTION_TYPE__NESTED_TYPE:
				return getNestedType();
			case PivotPackage.COLLECTION_TYPE__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case PivotPackage.COLLECTION_TYPE__BEHAVIORAL_TYPE:
				if (resolve) return getBehavioralType();
				return basicGetBehavioralType();
			case PivotPackage.COLLECTION_TYPE__IS_SERIALIZABLE:
				return isSerializable();
			case PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE:
				if (resolve) return getElementType();
				return basicGetElementType();
			case PivotPackage.COLLECTION_TYPE__LOWER:
				return getLower();
			case PivotPackage.COLLECTION_TYPE__UPPER:
				return getUpper();
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
			case PivotPackage.COLLECTION_TYPE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				getTemplateBinding().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				getOwnedAttribute().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				getOwnedInvariant().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_OPERATION:
				getOwnedOperation().clear();
				getOwnedOperation().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__SUPER_CLASS:
				getSuperClass().clear();
				getSuperClass().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__IS_ACTIVE:
				setIsActive((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__NESTED_TYPE:
				getNestedType().clear();
				getNestedType().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				getOwnedBehavior().addAll((Collection<? extends Behavior>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__BEHAVIORAL_TYPE:
				setBehavioralType((Type)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__IS_SERIALIZABLE:
				setIsSerializable((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE:
				setElementType((Type)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__LOWER:
				setLower((Number)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__UPPER:
				setUpper((Number)newValue);
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
			case PivotPackage.COLLECTION_TYPE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.COLLECTION_TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_OPERATION:
				getOwnedOperation().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.COLLECTION_TYPE__SUPER_CLASS:
				getSuperClass().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__IS_ACTIVE:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__NESTED_TYPE:
				getNestedType().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__BEHAVIORAL_TYPE:
				setBehavioralType((Type)null);
				return;
			case PivotPackage.COLLECTION_TYPE__IS_SERIALIZABLE:
				setIsSerializable(IS_SERIALIZABLE_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE:
				setElementType((Type)null);
				return;
			case PivotPackage.COLLECTION_TYPE__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__UPPER:
				setUpper(UPPER_EDEFAULT);
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
			case PivotPackage.COLLECTION_TYPE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.COLLECTION_TYPE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.COLLECTION_TYPE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.COLLECTION_TYPE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.COLLECTION_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_BINDING:
				return templateBinding != null && !templateBinding.isEmpty();
			case PivotPackage.COLLECTION_TYPE__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.COLLECTION_TYPE__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.COLLECTION_TYPE__OWNED_ATTRIBUTE:
				return ownedAttribute != null && !ownedAttribute.isEmpty();
			case PivotPackage.COLLECTION_TYPE__OWNED_INVARIANT:
				return ownedInvariant != null && !ownedInvariant.isEmpty();
			case PivotPackage.COLLECTION_TYPE__OWNED_OPERATION:
				return ownedOperation != null && !ownedOperation.isEmpty();
			case PivotPackage.COLLECTION_TYPE__PACKAGE:
				return getPackage() != null;
			case PivotPackage.COLLECTION_TYPE__SUPER_CLASS:
				return superClass != null && !superClass.isEmpty();
			case PivotPackage.COLLECTION_TYPE__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.COLLECTION_TYPE__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.COLLECTION_TYPE__IS_ACTIVE:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case PivotPackage.COLLECTION_TYPE__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.COLLECTION_TYPE__NESTED_TYPE:
				return nestedType != null && !nestedType.isEmpty();
			case PivotPackage.COLLECTION_TYPE__OWNED_BEHAVIOR:
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case PivotPackage.COLLECTION_TYPE__BEHAVIORAL_TYPE:
				return behavioralType != null;
			case PivotPackage.COLLECTION_TYPE__IS_SERIALIZABLE:
				return ((eFlags & IS_SERIALIZABLE_EFLAG) != 0) != IS_SERIALIZABLE_EDEFAULT;
			case PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE:
				return elementType != null;
			case PivotPackage.COLLECTION_TYPE__LOWER:
				return LOWER_EDEFAULT == null ? lower != null : !LOWER_EDEFAULT.equals(lower);
			case PivotPackage.COLLECTION_TYPE__UPPER:
				return UPPER_EDEFAULT == null ? upper != null : !UPPER_EDEFAULT.equals(upper);
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
		return visitor.visitCollectionType(this);
	}

	@Override
	public @NonNull TypeId computeId() {
		if (getUnspecializedElement() == null) {
			if (TypeId.COLLECTION_NAME.equals(name)) {
				return TypeId.COLLECTION;
			}
			else if (TypeId.UNIQUE_COLLECTION_NAME.equals(name)) {
				return TypeId.UNIQUE_COLLECTION;
			}
			else {
				String name2 = name;
				assert name2 != null;
				return IdManager.getCollectionTypeId(name2);		// e.g. UniqueCollection
			}
		}
		else {
			return TypeId.COLLECTION.getSpecializedId(getElementType().getTypeId());
		}
	}
	
	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		if (type instanceof DomainCollectionType) {
			return standardLibrary.conformsToCollectionType(this, (DomainCollectionType)type);
		}
		if (getUnspecializedElement() != null) {
			return ((Type)getUnspecializedElement()).conformsTo(standardLibrary, type);
		}
		return super.conformsTo(standardLibrary, type);
	}

	@Override
	public @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		DomainStandardLibrary standardLibrary = idResolver.getStandardLibrary();
		DomainInheritance thisInheritance = this.getInheritance(standardLibrary);
		DomainInheritance thatInheritance = type.getInheritance(standardLibrary);
		DomainInheritance commonInheritance = thisInheritance.getCommonInheritance(thatInheritance);
		if (type instanceof DomainCollectionType) {
			DomainType thisElementType = this.getElementType();
			DomainType thatElementType = DomainUtil.nonNullEMF(((DomainCollectionType)type).getElementType());
			DomainType commonElementType = thisElementType.getCommonType(idResolver, thatElementType);
			if (commonInheritance instanceof TypeServer) {
				DomainCollectionType commonCollectionType = (DomainCollectionType)((TypeServer)commonInheritance).getPivotType();
				return standardLibrary.getCollectionType(commonCollectionType, commonElementType, null, null);
			}
			else {
				if (commonInheritance.isOrdered()) {
					if (commonInheritance.isUnique()) {
						return standardLibrary.getOrderedSetType(commonElementType, null, null);
					}
					else {
						return standardLibrary.getSequenceType(commonElementType, null, null);
					}
				}
				else {
					if (commonInheritance.isUnique()) {
						return standardLibrary.getSetType(commonElementType, null, null);
					}
					else {
						return standardLibrary.getBagType(commonElementType, null, null);
					}
				}
			}
		}
		else {
			return commonInheritance;
		}
	}

	public @NonNull CollectionType getContainerType() {
		TemplateableElement unspecializedElement2 = unspecializedElement;
		return unspecializedElement2 != null ? (CollectionType)unspecializedElement2 : this;
	}
	
	@Override
	public @NonNull CollectionTypeId getTypeId() {
		return (CollectionTypeId) super.getTypeId();
	}

	@Override
	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof DomainCollectionType)) {
			return false;
		}
		return standardLibrary.isEqualToCollectionType(this, (DomainCollectionType)type);
	}

	public @NonNull IntegerValue getLowerValue() {
		Number lower2 = lower;
		assert lower2 != null;
		return ValuesUtil.integerValueOf(lower2);
	}

	public @NonNull IntegerValue getUpperValue() {
		Number upper2 = upper;
		assert upper2 != null;
		return ValuesUtil.integerValueOf(upper2);
	}

	public void setLowerValue(@NonNull IntegerValue lower) {
		setLower(lower.intValue());
	}

	public void setUpperValue(@NonNull IntegerValue upper) {
		setUpper(upper.isUnlimited() ? Unlimited.INSTANCE : upper.intValue());
	}
} //CollectionTypeImpl
