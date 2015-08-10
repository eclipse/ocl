/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.ParameterType;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.TypeUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lambda Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.LambdaTypeImpl#getOwnedParameterTypes <em>Owned Parameter Types</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.LambdaTypeImpl#getOwnedResultType <em>Owned Result Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LambdaTypeImpl extends DataTypeImpl implements LambdaType
{
	/**
	 * The cached value of the '{@link #getOwnedParameterTypes() <em>Owned Parameter Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParameterTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterType> ownedParameterTypes;

	/**
	 * The cached value of the '{@link #getOwnedResultType() <em>Owned Result Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedResultType()
	 * @generated
	 * @ordered
	 */
	protected ParameterType ownedResultType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LambdaTypeImpl()
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
		return PivotPackage.Literals.LAMBDA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<ParameterType> getOwnedParameterTypes()
	{
		if (ownedParameterTypes == null)
		{
			ownedParameterTypes = new EObjectContainmentEList<ParameterType>(ParameterType.class, this, PivotPackage.LAMBDA_TYPE__OWNED_PARAMETER_TYPES);
		}
		return ownedParameterTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterType getOwnedResultType()
	{
		return ownedResultType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedResultType(ParameterType newOwnedResultType, NotificationChain msgs)
	{
		ParameterType oldOwnedResultType = ownedResultType;
		ownedResultType = newOwnedResultType;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.LAMBDA_TYPE__OWNED_RESULT_TYPE, oldOwnedResultType, newOwnedResultType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedResultType(ParameterType newOwnedResultType)
	{
		if (newOwnedResultType != ownedResultType)
		{
			NotificationChain msgs = null;
			if (ownedResultType != null)
				msgs = ((InternalEObject)ownedResultType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.LAMBDA_TYPE__OWNED_RESULT_TYPE, null, msgs);
			if (newOwnedResultType != null)
				msgs = ((InternalEObject)newOwnedResultType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.LAMBDA_TYPE__OWNED_RESULT_TYPE, null, msgs);
			msgs = basicSetOwnedResultType(newOwnedResultType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.LAMBDA_TYPE__OWNED_RESULT_TYPE, newOwnedResultType, newOwnedResultType));
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
			case PivotPackage.LAMBDA_TYPE__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_TYPE__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_TYPE__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_TYPE__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_TYPE__OWNED_CONSTRAINTS:
				return ((InternalEList<?>)getOwnedConstraints()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_TYPE__OWNED_BINDINGS:
				return ((InternalEList<?>)getOwnedBindings()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_TYPE__OWNED_SIGNATURE:
				return basicSetOwnedSignature(null, msgs);
			case PivotPackage.LAMBDA_TYPE__EXTENDERS:
				return ((InternalEList<?>)getExtenders()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_TYPE__OWNED_BEHAVIORS:
				return ((InternalEList<?>)getOwnedBehaviors()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_TYPE__OWNED_INVARIANTS:
				return ((InternalEList<?>)getOwnedInvariants()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_TYPE__OWNED_OPERATIONS:
				return ((InternalEList<?>)getOwnedOperations()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_TYPE__OWNED_PROPERTIES:
				return ((InternalEList<?>)getOwnedProperties()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_TYPE__OWNING_PACKAGE:
				return basicSetOwningPackage(null, msgs);
			case PivotPackage.LAMBDA_TYPE__OWNED_PARAMETER_TYPES:
				return ((InternalEList<?>)getOwnedParameterTypes()).basicRemove(otherEnd, msgs);
			case PivotPackage.LAMBDA_TYPE__OWNED_RESULT_TYPE:
				return basicSetOwnedResultType(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
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
			case PivotPackage.LAMBDA_TYPE__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.LAMBDA_TYPE__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.LAMBDA_TYPE__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.LAMBDA_TYPE__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.LAMBDA_TYPE__NAME:
				return getName();
			case PivotPackage.LAMBDA_TYPE__OWNED_CONSTRAINTS:
				return getOwnedConstraints();
			case PivotPackage.LAMBDA_TYPE__OWNED_BINDINGS:
				return getOwnedBindings();
			case PivotPackage.LAMBDA_TYPE__OWNED_SIGNATURE:
				return getOwnedSignature();
			case PivotPackage.LAMBDA_TYPE__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.LAMBDA_TYPE__EXTENDERS:
				return getExtenders();
			case PivotPackage.LAMBDA_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.LAMBDA_TYPE__IS_ABSTRACT:
				return isIsAbstract();
			case PivotPackage.LAMBDA_TYPE__IS_ACTIVE:
				return isIsActive();
			case PivotPackage.LAMBDA_TYPE__IS_INTERFACE:
				return isIsInterface();
			case PivotPackage.LAMBDA_TYPE__OWNED_BEHAVIORS:
				return getOwnedBehaviors();
			case PivotPackage.LAMBDA_TYPE__OWNED_INVARIANTS:
				return getOwnedInvariants();
			case PivotPackage.LAMBDA_TYPE__OWNED_OPERATIONS:
				return getOwnedOperations();
			case PivotPackage.LAMBDA_TYPE__OWNED_PROPERTIES:
				return getOwnedProperties();
			case PivotPackage.LAMBDA_TYPE__OWNING_PACKAGE:
				return getOwningPackage();
			case PivotPackage.LAMBDA_TYPE__SUPER_CLASSES:
				return getSuperClasses();
			case PivotPackage.LAMBDA_TYPE__BEHAVIORAL_CLASS:
				if (resolve) return getBehavioralClass();
				return basicGetBehavioralClass();
			case PivotPackage.LAMBDA_TYPE__IS_SERIALIZABLE:
				return isIsSerializable();
			case PivotPackage.LAMBDA_TYPE__OWNED_PARAMETER_TYPES:
				return getOwnedParameterTypes();
			case PivotPackage.LAMBDA_TYPE__OWNED_RESULT_TYPE:
				return getOwnedResultType();
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
			case PivotPackage.LAMBDA_TYPE__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_CONSTRAINTS:
				getOwnedConstraints().clear();
				getOwnedConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_BINDINGS:
				getOwnedBindings().clear();
				getOwnedBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_SIGNATURE:
				setOwnedSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__EXTENDERS:
				getExtenders().clear();
				getExtenders().addAll((Collection<? extends StereotypeExtender>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_ACTIVE:
				setIsActive((Boolean)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_BEHAVIORS:
				getOwnedBehaviors().clear();
				getOwnedBehaviors().addAll((Collection<? extends Behavior>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
				getOwnedInvariants().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				getOwnedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.pivot.Package)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__SUPER_CLASSES:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends org.eclipse.ocl.pivot.Class>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__BEHAVIORAL_CLASS:
				setBehavioralClass((org.eclipse.ocl.pivot.Class)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_SERIALIZABLE:
				setIsSerializable((Boolean)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_PARAMETER_TYPES:
				getOwnedParameterTypes().clear();
				getOwnedParameterTypes().addAll((Collection<? extends ParameterType>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_RESULT_TYPE:
				setOwnedResultType((ParameterType)newValue);
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
			case PivotPackage.LAMBDA_TYPE__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_CONSTRAINTS:
				getOwnedConstraints().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_BINDINGS:
				getOwnedBindings().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_SIGNATURE:
				setOwnedSignature((TemplateSignature)null);
				return;
			case PivotPackage.LAMBDA_TYPE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.LAMBDA_TYPE__EXTENDERS:
				getExtenders().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_ACTIVE:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_BEHAVIORS:
				getOwnedBehaviors().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.pivot.Package)null);
				return;
			case PivotPackage.LAMBDA_TYPE__SUPER_CLASSES:
				getSuperClasses().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__BEHAVIORAL_CLASS:
				setBehavioralClass((org.eclipse.ocl.pivot.Class)null);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_SERIALIZABLE:
				setIsSerializable(IS_SERIALIZABLE_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_PARAMETER_TYPES:
				getOwnedParameterTypes().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_RESULT_TYPE:
				setOwnedResultType((ParameterType)null);
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
			case PivotPackage.LAMBDA_TYPE__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.LAMBDA_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.LAMBDA_TYPE__OWNED_CONSTRAINTS:
				return ownedConstraints != null && !ownedConstraints.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_BINDINGS:
				return ownedBindings != null && !ownedBindings.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_SIGNATURE:
				return ownedSignature != null;
			case PivotPackage.LAMBDA_TYPE__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.LAMBDA_TYPE__EXTENDERS:
				return extenders != null && !extenders.isEmpty();
			case PivotPackage.LAMBDA_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.LAMBDA_TYPE__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.LAMBDA_TYPE__IS_ACTIVE:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case PivotPackage.LAMBDA_TYPE__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.LAMBDA_TYPE__OWNED_BEHAVIORS:
				return ownedBehaviors != null && !ownedBehaviors.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_INVARIANTS:
				return ownedInvariants != null && !ownedInvariants.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_OPERATIONS:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_PROPERTIES:
				return ownedProperties != null && !ownedProperties.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNING_PACKAGE:
				return getOwningPackage() != null;
			case PivotPackage.LAMBDA_TYPE__SUPER_CLASSES:
				return superClasses != null && !superClasses.isEmpty();
			case PivotPackage.LAMBDA_TYPE__BEHAVIORAL_CLASS:
				return behavioralClass != null;
			case PivotPackage.LAMBDA_TYPE__IS_SERIALIZABLE:
				return ((eFlags & IS_SERIALIZABLE_EFLAG) != 0) != IS_SERIALIZABLE_EDEFAULT;
			case PivotPackage.LAMBDA_TYPE__OWNED_PARAMETER_TYPES:
				return ownedParameterTypes != null && !ownedParameterTypes.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_RESULT_TYPE:
				return ownedResultType != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitLambdaType(this);
	}
	
	@Override
	public @NonNull TypeId computeId() {
		return IdManager.getLambdaTypeId(this);
	}
	
	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		if (type instanceof AnyType) {
			return true;
		}
		if (!(type instanceof LambdaType)) {
			return false;
		}
		return TypeUtil.conformsToLambdaType(standardLibrary, this, (LambdaType)type);
	}
	
	private ParametersId parametersId = null;

	@Override
	public @NonNull ParametersId getParametersId() {
		ParametersId parametersId2 = parametersId;
		if (parametersId2 == null) {
			synchronized (this) {
				parametersId2 = parametersId;
				if (parametersId2 == null) {
					parametersId = parametersId2 = IdManager.getParametersId(getOwnedParameterTypes(), getOwnedResultType());
				}
			}
		}
		return parametersId2;
	}
} //LambdaTypeImpl
