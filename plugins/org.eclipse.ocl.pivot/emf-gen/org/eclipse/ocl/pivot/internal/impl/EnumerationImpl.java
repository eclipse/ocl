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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.EnumerationId;
import org.eclipse.ocl.domain.ids.IdManager;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.TypeExtension;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.EnumerationImpl#getOwnedLiteral <em>Owned Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationImpl
		extends DataTypeImpl
		implements Enumeration {

	/**
	 * The cached value of the '{@link #getOwnedLiteral() <em>Owned Literal</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLiteral()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumerationLiteral> ownedLiteral;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.ENUMERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<EnumerationLiteral> getOwnedLiteral()
	{
		if (ownedLiteral == null)
		{
			ownedLiteral = new EObjectContainmentWithInverseEList<EnumerationLiteral>(EnumerationLiteral.class, this, PivotPackage.ENUMERATION__OWNED_LITERAL, PivotPackage.ENUMERATION_LITERAL__ENUMERATION);
		}
		return ownedLiteral;
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
			case PivotPackage.ENUMERATION__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.ENUMERATION__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.ENUMERATION__EXTENDED_BYS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtendedBys()).basicAdd(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_TEMPLATE_BINDINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTemplateBindings()).basicAdd(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ENUMERATION__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperations()).basicAdd(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_PROPERTIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedProperties()).basicAdd(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningPackage((org.eclipse.ocl.pivot.Package)otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_LITERAL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedLiteral()).basicAdd(otherEnd, msgs);
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
			case PivotPackage.ENUMERATION__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION__EXTENDED_BYS:
				return ((InternalEList<?>)getExtendedBys()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_TEMPLATE_BINDINGS:
				return ((InternalEList<?>)getOwnedTemplateBindings()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case PivotPackage.ENUMERATION__OWNED_BEHAVIOR:
				return ((InternalEList<?>)getOwnedBehavior()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_INVARIANTS:
				return ((InternalEList<?>)getOwnedInvariants()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_OPERATIONS:
				return ((InternalEList<?>)getOwnedOperations()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNED_PROPERTIES:
				return ((InternalEList<?>)getOwnedProperties()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION__OWNING_PACKAGE:
				return basicSetOwningPackage(null, msgs);
			case PivotPackage.ENUMERATION__OWNED_LITERAL:
				return ((InternalEList<?>)getOwnedLiteral()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
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
			case PivotPackage.ENUMERATION__COMMENT:
				return getComment();
			case PivotPackage.ENUMERATION__EXTENSION:
				return getExtension();
			case PivotPackage.ENUMERATION__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.ENUMERATION__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.ENUMERATION__NAME:
				return getName();
			case PivotPackage.ENUMERATION__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.ENUMERATION__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.ENUMERATION__OWNED_TEMPLATE_BINDINGS:
				return getOwnedTemplateBindings();
			case PivotPackage.ENUMERATION__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.ENUMERATION__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.ENUMERATION__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.ENUMERATION__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.ENUMERATION__IS_ACTIVE:
				return isActive();
			case PivotPackage.ENUMERATION__IS_INTERFACE:
				return isInterface();
			case PivotPackage.ENUMERATION__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case PivotPackage.ENUMERATION__OWNED_INVARIANTS:
				return getOwnedInvariants();
			case PivotPackage.ENUMERATION__OWNED_OPERATIONS:
				return getOwnedOperations();
			case PivotPackage.ENUMERATION__OWNED_PROPERTIES:
				return getOwnedProperties();
			case PivotPackage.ENUMERATION__OWNING_PACKAGE:
				return getOwningPackage();
			case PivotPackage.ENUMERATION__SUPER_CLASSES:
				return getSuperClasses();
			case PivotPackage.ENUMERATION__BEHAVIORAL_CLASS:
				if (resolve) return getBehavioralClass();
				return basicGetBehavioralClass();
			case PivotPackage.ENUMERATION__IS_SERIALIZABLE:
				return isSerializable();
			case PivotPackage.ENUMERATION__OWNED_LITERAL:
				return getOwnedLiteral();
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
			case PivotPackage.ENUMERATION__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ENUMERATION__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.ENUMERATION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.ENUMERATION__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ENUMERATION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ENUMERATION__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.ENUMERATION__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.ENUMERATION__OWNED_TEMPLATE_BINDINGS:
				getOwnedTemplateBindings().clear();
				getOwnedTemplateBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.ENUMERATION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.ENUMERATION__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.ENUMERATION__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.ENUMERATION__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.ENUMERATION__IS_ACTIVE:
				setIsActive((Boolean)newValue);
				return;
			case PivotPackage.ENUMERATION__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.ENUMERATION__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				getOwnedBehavior().addAll((Collection<? extends Behavior>)newValue);
				return;
			case PivotPackage.ENUMERATION__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
				getOwnedInvariants().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.ENUMERATION__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.ENUMERATION__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				getOwnedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.ENUMERATION__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.pivot.Package)newValue);
				return;
			case PivotPackage.ENUMERATION__SUPER_CLASSES:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends org.eclipse.ocl.pivot.Class>)newValue);
				return;
			case PivotPackage.ENUMERATION__BEHAVIORAL_CLASS:
				setBehavioralClass((org.eclipse.ocl.pivot.Class)newValue);
				return;
			case PivotPackage.ENUMERATION__IS_SERIALIZABLE:
				setIsSerializable((Boolean)newValue);
				return;
			case PivotPackage.ENUMERATION__OWNED_LITERAL:
				getOwnedLiteral().clear();
				getOwnedLiteral().addAll((Collection<? extends EnumerationLiteral>)newValue);
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
			case PivotPackage.ENUMERATION__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.ENUMERATION__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.ENUMERATION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.ENUMERATION__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.ENUMERATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ENUMERATION__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.ENUMERATION__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.ENUMERATION__OWNED_TEMPLATE_BINDINGS:
				getOwnedTemplateBindings().clear();
				return;
			case PivotPackage.ENUMERATION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.ENUMERATION__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.ENUMERATION__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.ENUMERATION__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.ENUMERATION__IS_ACTIVE:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case PivotPackage.ENUMERATION__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.ENUMERATION__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				return;
			case PivotPackage.ENUMERATION__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
				return;
			case PivotPackage.ENUMERATION__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				return;
			case PivotPackage.ENUMERATION__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				return;
			case PivotPackage.ENUMERATION__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.pivot.Package)null);
				return;
			case PivotPackage.ENUMERATION__SUPER_CLASSES:
				getSuperClasses().clear();
				return;
			case PivotPackage.ENUMERATION__BEHAVIORAL_CLASS:
				setBehavioralClass((org.eclipse.ocl.pivot.Class)null);
				return;
			case PivotPackage.ENUMERATION__IS_SERIALIZABLE:
				setIsSerializable(IS_SERIALIZABLE_EDEFAULT);
				return;
			case PivotPackage.ENUMERATION__OWNED_LITERAL:
				getOwnedLiteral().clear();
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
			case PivotPackage.ENUMERATION__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.ENUMERATION__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.ENUMERATION__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.ENUMERATION__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.ENUMERATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ENUMERATION__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.ENUMERATION__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.ENUMERATION__OWNED_TEMPLATE_BINDINGS:
				return ownedTemplateBindings != null && !ownedTemplateBindings.isEmpty();
			case PivotPackage.ENUMERATION__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.ENUMERATION__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.ENUMERATION__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.ENUMERATION__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.ENUMERATION__IS_ACTIVE:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case PivotPackage.ENUMERATION__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.ENUMERATION__OWNED_BEHAVIOR:
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case PivotPackage.ENUMERATION__OWNED_INVARIANTS:
				return ownedInvariants != null && !ownedInvariants.isEmpty();
			case PivotPackage.ENUMERATION__OWNED_OPERATIONS:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case PivotPackage.ENUMERATION__OWNED_PROPERTIES:
				return ownedProperties != null && !ownedProperties.isEmpty();
			case PivotPackage.ENUMERATION__OWNING_PACKAGE:
				return getOwningPackage() != null;
			case PivotPackage.ENUMERATION__SUPER_CLASSES:
				return superClasses != null && !superClasses.isEmpty();
			case PivotPackage.ENUMERATION__BEHAVIORAL_CLASS:
				return behavioralClass != null;
			case PivotPackage.ENUMERATION__IS_SERIALIZABLE:
				return ((eFlags & IS_SERIALIZABLE_EFLAG) != 0) != IS_SERIALIZABLE_EDEFAULT;
			case PivotPackage.ENUMERATION__OWNED_LITERAL:
				return ownedLiteral != null && !ownedLiteral.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitEnumeration(this);
	}
	
	@Override
	public @NonNull EnumerationId computeId() {
		return IdManager.getEnumerationId(this);
	}

	@Override
	public @NonNull EnumerationId getEnumerationId() {
		return (EnumerationId) getTypeId();
	}

	@Override
	public @Nullable EnumerationLiteral getEnumerationLiteral(@NonNull String name) {
		for (EnumerationLiteral enumerationLiteral : getEnumerationLiterals()) {
			if (name.equals(enumerationLiteral.getName())) {
				return enumerationLiteral;
			}
		}
		return null;
	}

	@Override
	public @NonNull List<EnumerationLiteral> getEnumerationLiterals() {
		return DomainUtil.nonNullEMF(getOwnedLiteral());
	}
} //EnumerationImpl
