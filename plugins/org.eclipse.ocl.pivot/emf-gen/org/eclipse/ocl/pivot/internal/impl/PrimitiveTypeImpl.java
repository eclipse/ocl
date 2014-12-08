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
package org.eclipse.ocl.pivot.internal.impl;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.ids.IdManager;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.TypeExtension;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.PrimitiveTypeImpl#getCoercions <em>Coercions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimitiveTypeImpl
		extends DataTypeImpl
		implements PrimitiveType {

	/**
	 * The cached value of the '{@link #getCoercions() <em>Coercions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoercions()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> coercions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.PRIMITIVE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Operation> getCoercions()
	{
		if (coercions == null)
		{
			coercions = new EObjectResolvingEList<Operation>(Operation.class, this, PivotPackage.PRIMITIVE_TYPE__COERCIONS);
		}
		return coercions;
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
			case PivotPackage.PRIMITIVE_TYPE__COMMENT:
				return getComment();
			case PivotPackage.PRIMITIVE_TYPE__EXTENSION:
				return getExtension();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.PRIMITIVE_TYPE__NAME:
				return getName();
			case PivotPackage.PRIMITIVE_TYPE__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_TEMPLATE_BINDINGS:
				return getOwnedTemplateBindings();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.PRIMITIVE_TYPE__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.PRIMITIVE_TYPE__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.PRIMITIVE_TYPE__IS_ACTIVE:
				return isActive();
			case PivotPackage.PRIMITIVE_TYPE__IS_INTERFACE:
				return isInterface();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_INVARIANTS:
				return getOwnedInvariants();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_OPERATIONS:
				return getOwnedOperations();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_PROPERTIES:
				return getOwnedProperties();
			case PivotPackage.PRIMITIVE_TYPE__OWNING_PACKAGE:
				return getOwningPackage();
			case PivotPackage.PRIMITIVE_TYPE__SUPER_CLASSES:
				return getSuperClasses();
			case PivotPackage.PRIMITIVE_TYPE__BEHAVIORAL_CLASS:
				if (resolve) return getBehavioralClass();
				return basicGetBehavioralClass();
			case PivotPackage.PRIMITIVE_TYPE__IS_SERIALIZABLE:
				return isSerializable();
			case PivotPackage.PRIMITIVE_TYPE__COERCIONS:
				return getCoercions();
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
			case PivotPackage.PRIMITIVE_TYPE__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_TEMPLATE_BINDINGS:
				getOwnedTemplateBindings().clear();
				getOwnedTemplateBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__IS_ACTIVE:
				setIsActive((Boolean)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				getOwnedBehavior().addAll((Collection<? extends Behavior>)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
				getOwnedInvariants().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				getOwnedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.pivot.Package)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__SUPER_CLASSES:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends org.eclipse.ocl.pivot.Class>)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__BEHAVIORAL_CLASS:
				setBehavioralClass((org.eclipse.ocl.pivot.Class)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__IS_SERIALIZABLE:
				setIsSerializable((Boolean)newValue);
				return;
			case PivotPackage.PRIMITIVE_TYPE__COERCIONS:
				getCoercions().clear();
				getCoercions().addAll((Collection<? extends Operation>)newValue);
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
			case PivotPackage.PRIMITIVE_TYPE__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.PRIMITIVE_TYPE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.PRIMITIVE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.PRIMITIVE_TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_TEMPLATE_BINDINGS:
				getOwnedTemplateBindings().clear();
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.PRIMITIVE_TYPE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.PRIMITIVE_TYPE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.PRIMITIVE_TYPE__IS_ACTIVE:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case PivotPackage.PRIMITIVE_TYPE__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				return;
			case PivotPackage.PRIMITIVE_TYPE__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.pivot.Package)null);
				return;
			case PivotPackage.PRIMITIVE_TYPE__SUPER_CLASSES:
				getSuperClasses().clear();
				return;
			case PivotPackage.PRIMITIVE_TYPE__BEHAVIORAL_CLASS:
				setBehavioralClass((org.eclipse.ocl.pivot.Class)null);
				return;
			case PivotPackage.PRIMITIVE_TYPE__IS_SERIALIZABLE:
				setIsSerializable(IS_SERIALIZABLE_EDEFAULT);
				return;
			case PivotPackage.PRIMITIVE_TYPE__COERCIONS:
				getCoercions().clear();
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
			case PivotPackage.PRIMITIVE_TYPE__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.PRIMITIVE_TYPE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.PRIMITIVE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.PRIMITIVE_TYPE__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_TEMPLATE_BINDINGS:
				return ownedTemplateBindings != null && !ownedTemplateBindings.isEmpty();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.PRIMITIVE_TYPE__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.PRIMITIVE_TYPE__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.PRIMITIVE_TYPE__IS_ACTIVE:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case PivotPackage.PRIMITIVE_TYPE__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.PRIMITIVE_TYPE__OWNED_BEHAVIOR:
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_INVARIANTS:
				return ownedInvariants != null && !ownedInvariants.isEmpty();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_OPERATIONS:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case PivotPackage.PRIMITIVE_TYPE__OWNED_PROPERTIES:
				return ownedProperties != null && !ownedProperties.isEmpty();
			case PivotPackage.PRIMITIVE_TYPE__OWNING_PACKAGE:
				return getOwningPackage() != null;
			case PivotPackage.PRIMITIVE_TYPE__SUPER_CLASSES:
				return superClasses != null && !superClasses.isEmpty();
			case PivotPackage.PRIMITIVE_TYPE__BEHAVIORAL_CLASS:
				return behavioralClass != null;
			case PivotPackage.PRIMITIVE_TYPE__IS_SERIALIZABLE:
				return ((eFlags & IS_SERIALIZABLE_EFLAG) != 0) != IS_SERIALIZABLE_EDEFAULT;
			case PivotPackage.PRIMITIVE_TYPE__COERCIONS:
				return coercions != null && !coercions.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitPrimitiveType(this);
	}
	
	@Override
	public @NonNull TypeId computeId() {
		String name2 = getName();
		assert name2 != null;
		return IdManager.getPrimitiveTypeId(name2);
	}
} //PrimitiveTypeImpl
