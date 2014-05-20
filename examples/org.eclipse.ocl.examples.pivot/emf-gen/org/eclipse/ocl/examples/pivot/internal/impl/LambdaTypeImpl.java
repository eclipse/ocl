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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainLambdaType;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.ParametersId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.LambdaType;
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
 * An implementation of the model object '<em><b>Lambda Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.LambdaTypeImpl#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.LambdaTypeImpl#getParameterType <em>Parameter Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.LambdaTypeImpl#getResultType <em>Result Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LambdaTypeImpl extends DataTypeImpl implements LambdaType
{
	/**
	 * The cached value of the '{@link #getContextType() <em>Context Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextType()
	 * @generated
	 * @ordered
	 */
	protected Type contextType;

	/**
	 * The cached value of the '{@link #getParameterType() <em>Parameter Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterType()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> parameterType;

	/**
	 * The cached value of the '{@link #getResultType() <em>Result Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected Type resultType;

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
	public Type getContextType()
	{
		if (contextType != null && ((EObject)contextType).eIsProxy())
		{
			InternalEObject oldContextType = (InternalEObject)contextType;
			contextType = (Type)eResolveProxy(oldContextType);
			if (contextType != oldContextType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.LAMBDA_TYPE__CONTEXT_TYPE, oldContextType, contextType));
			}
		}
		return contextType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetContextType()
	{
		return contextType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextType(Type newContextType)
	{
		Type oldContextType = contextType;
		contextType = newContextType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.LAMBDA_TYPE__CONTEXT_TYPE, oldContextType, contextType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<Type> getParameterType()
	{
		if (parameterType == null)
		{
			parameterType = new EObjectResolvingEList<Type>(Type.class, this, PivotPackage.LAMBDA_TYPE__PARAMETER_TYPE);
		}
		return parameterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getResultType()
	{
		if (resultType != null && ((EObject)resultType).eIsProxy())
		{
			InternalEObject oldResultType = (InternalEObject)resultType;
			resultType = (Type)eResolveProxy(oldResultType);
			if (resultType != oldResultType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.LAMBDA_TYPE__RESULT_TYPE, oldResultType, resultType));
			}
		}
		return resultType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetResultType()
	{
		return resultType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultType(Type newResultType)
	{
		Type oldResultType = resultType;
		resultType = newResultType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.LAMBDA_TYPE__RESULT_TYPE, oldResultType, resultType));
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
			case PivotPackage.LAMBDA_TYPE__EXTENSION:
				return getExtension();
			case PivotPackage.LAMBDA_TYPE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.LAMBDA_TYPE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.LAMBDA_TYPE__IS_STATIC:
				return isStatic();
			case PivotPackage.LAMBDA_TYPE__NAME:
				return getName();
			case PivotPackage.LAMBDA_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_BINDING:
				return getTemplateBinding();
			case PivotPackage.LAMBDA_TYPE__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.LAMBDA_TYPE__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.LAMBDA_TYPE__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.LAMBDA_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.LAMBDA_TYPE__OWNED_ATTRIBUTE:
				return getOwnedAttribute();
			case PivotPackage.LAMBDA_TYPE__OWNED_INVARIANT:
				return getOwnedInvariant();
			case PivotPackage.LAMBDA_TYPE__OWNED_OPERATION:
				return getOwnedOperation();
			case PivotPackage.LAMBDA_TYPE__PACKAGE:
				return getPackage();
			case PivotPackage.LAMBDA_TYPE__SUPER_CLASS:
				return getSuperClass();
			case PivotPackage.LAMBDA_TYPE__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.LAMBDA_TYPE__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.LAMBDA_TYPE__IS_ACTIVE:
				return isActive();
			case PivotPackage.LAMBDA_TYPE__IS_INTERFACE:
				return isInterface();
			case PivotPackage.LAMBDA_TYPE__NESTED_TYPE:
				return getNestedType();
			case PivotPackage.LAMBDA_TYPE__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case PivotPackage.LAMBDA_TYPE__BEHAVIORAL_TYPE:
				if (resolve) return getBehavioralType();
				return basicGetBehavioralType();
			case PivotPackage.LAMBDA_TYPE__IS_SERIALIZABLE:
				return isSerializable();
			case PivotPackage.LAMBDA_TYPE__CONTEXT_TYPE:
				if (resolve) return getContextType();
				return basicGetContextType();
			case PivotPackage.LAMBDA_TYPE__PARAMETER_TYPE:
				return getParameterType();
			case PivotPackage.LAMBDA_TYPE__RESULT_TYPE:
				if (resolve) return getResultType();
				return basicGetResultType();
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
			case PivotPackage.LAMBDA_TYPE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				getTemplateBinding().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				getOwnedAttribute().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				getOwnedInvariant().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_OPERATION:
				getOwnedOperation().clear();
				getOwnedOperation().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__SUPER_CLASS:
				getSuperClass().clear();
				getSuperClass().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
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
			case PivotPackage.LAMBDA_TYPE__NESTED_TYPE:
				getNestedType().clear();
				getNestedType().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				getOwnedBehavior().addAll((Collection<? extends Behavior>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__BEHAVIORAL_TYPE:
				setBehavioralType((Type)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_SERIALIZABLE:
				setIsSerializable((Boolean)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__CONTEXT_TYPE:
				setContextType((Type)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__PARAMETER_TYPE:
				getParameterType().clear();
				getParameterType().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__RESULT_TYPE:
				setResultType((Type)newValue);
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
			case PivotPackage.LAMBDA_TYPE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.LAMBDA_TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_OPERATION:
				getOwnedOperation().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.LAMBDA_TYPE__SUPER_CLASS:
				getSuperClass().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_RULE:
				getOwnedRule().clear();
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
			case PivotPackage.LAMBDA_TYPE__NESTED_TYPE:
				getNestedType().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__BEHAVIORAL_TYPE:
				setBehavioralType((Type)null);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_SERIALIZABLE:
				setIsSerializable(IS_SERIALIZABLE_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__CONTEXT_TYPE:
				setContextType((Type)null);
				return;
			case PivotPackage.LAMBDA_TYPE__PARAMETER_TYPE:
				getParameterType().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__RESULT_TYPE:
				setResultType((Type)null);
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
			case PivotPackage.LAMBDA_TYPE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.LAMBDA_TYPE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.LAMBDA_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.LAMBDA_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_BINDING:
				return templateBinding != null && !templateBinding.isEmpty();
			case PivotPackage.LAMBDA_TYPE__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.LAMBDA_TYPE__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.LAMBDA_TYPE__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.LAMBDA_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.LAMBDA_TYPE__OWNED_ATTRIBUTE:
				return ownedAttribute != null && !ownedAttribute.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_INVARIANT:
				return ownedInvariant != null && !ownedInvariant.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_OPERATION:
				return ownedOperation != null && !ownedOperation.isEmpty();
			case PivotPackage.LAMBDA_TYPE__PACKAGE:
				return getPackage() != null;
			case PivotPackage.LAMBDA_TYPE__SUPER_CLASS:
				return superClass != null && !superClass.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.LAMBDA_TYPE__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.LAMBDA_TYPE__IS_ACTIVE:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case PivotPackage.LAMBDA_TYPE__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.LAMBDA_TYPE__NESTED_TYPE:
				return nestedType != null && !nestedType.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_BEHAVIOR:
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case PivotPackage.LAMBDA_TYPE__BEHAVIORAL_TYPE:
				return behavioralType != null;
			case PivotPackage.LAMBDA_TYPE__IS_SERIALIZABLE:
				return ((eFlags & IS_SERIALIZABLE_EFLAG) != 0) != IS_SERIALIZABLE_EDEFAULT;
			case PivotPackage.LAMBDA_TYPE__CONTEXT_TYPE:
				return contextType != null;
			case PivotPackage.LAMBDA_TYPE__PARAMETER_TYPE:
				return parameterType != null && !parameterType.isEmpty();
			case PivotPackage.LAMBDA_TYPE__RESULT_TYPE:
				return resultType != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitLambdaType(this);
	}
	
	@Override
	public @NonNull TypeId computeId() {
		TemplateParameter owningTemplateParameter = getOwningTemplateParameter();
		if (owningTemplateParameter != null) {
			return owningTemplateParameter.getElementId();
		}
		else {
			return IdManager.getLambdaTypeId(this);
		}
	}
	
	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof DomainLambdaType)) {
			return false;
		}
		return standardLibrary.conformsToLambdaType(this, (DomainLambdaType)type);
	}
	
	private ParametersId parametersId = null;

	public @NonNull ParametersId getParametersId() {
		ParametersId parametersId2 = parametersId;
		if (parametersId2 == null) {
			synchronized (this) {
				parametersId2 = parametersId;
				if (parametersId2 == null) {
					List<Type> parameterTypes = getParameterType();
					TypeId[] typeIds = new TypeId[2+parameterTypes.size()];
					typeIds[0] = getContextType().getTypeId();
					typeIds[1] = getResultType().getTypeId();
					for (int i = 0; i < parameterTypes.size(); i++) {
						typeIds[2+i] = parameterTypes.get(i).getTypeId();
					}
					parametersId = parametersId2 = IdManager.getParametersId(typeIds);
				}
			}
		}
		return parametersId2;
	}

	public @NonNull List<? extends DomainType> getParameterTypes() {
		return getParameterType();
	}
} //LambdaTypeImpl
