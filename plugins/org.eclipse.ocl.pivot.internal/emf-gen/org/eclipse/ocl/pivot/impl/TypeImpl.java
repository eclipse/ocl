/*******************************************************************************
 * Copyright (c) 2010, 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExtension;
import org.eclipse.ocl.pivot.elements.DomainTypeParameters;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.values.OCLValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.impl.TypeImpl#getExtendedBys <em>Extended Bys</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TypeImpl
		extends NamedElementImpl
		implements Type {

	/**
	 * The cached value of the '{@link #getExtendedBys() <em>Extended Bys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedBys()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeExtension> extendedBys;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Class isClass()
	{
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/2015/Pivot!Type!isClass()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateParameter isTemplateParameter()
	{
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/2015/Pivot!Type!isTemplateParameter()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<TypeExtension> getExtendedBys()
	{
		if (extendedBys == null)
		{
			extendedBys = new EObjectWithInverseResolvingEList<TypeExtension>(TypeExtension.class, this, PivotPackage.TYPE__EXTENDED_BYS, PivotPackage.TYPE_EXTENSION__TYPE);
		}
		return extendedBys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type flattenedType()
	{
		/**
		 * self
		 */
		return this;
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
			case PivotPackage.TYPE__ANNOTATING_COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotatingComments()).basicAdd(otherEnd, msgs);
			case PivotPackage.TYPE__OWNED_COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComments()).basicAdd(otherEnd, msgs);
			case PivotPackage.TYPE__OWNED_EXTENSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedExtensions()).basicAdd(otherEnd, msgs);
			case PivotPackage.TYPE__EXTENDED_BYS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtendedBys()).basicAdd(otherEnd, msgs);
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
			case PivotPackage.TYPE__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE__EXTENDED_BYS:
				return ((InternalEList<?>)getExtendedBys()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.TYPE__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.TYPE__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.TYPE__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.TYPE__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.TYPE__NAME:
				return getName();
			case PivotPackage.TYPE__EXTENDED_BYS:
				return getExtendedBys();
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
			case PivotPackage.TYPE__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPE__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.TYPE__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPE__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.TYPE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
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
			case PivotPackage.TYPE__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.TYPE__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.TYPE__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.TYPE__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
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
			case PivotPackage.TYPE__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.TYPE__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.TYPE__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.TYPE__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.TYPE__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID)
		{
			case PivotPackage.TYPE___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.TYPE___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.TYPE___FLATTENED_TYPE:
				return flattenedType();
			case PivotPackage.TYPE___IS_CLASS:
				return isClass();
			case PivotPackage.TYPE___IS_TEMPLATE_PARAMETER:
				return isTemplateParameter();
			case PivotPackage.TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE:
				return specializeIn((OCLExpression)arguments.get(0), (Type)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
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
		return visitor.visitType(this);
	}

	public @NonNull EObject createInstance() {
		EObject eTarget = getETarget();
		if (eTarget instanceof EClass) {
			EClass eClass = (EClass) eTarget;
			@SuppressWarnings("null")@NonNull EObject element = eClass.getEPackage().getEFactoryInstance().create(eClass);
//			TypeId typeId = IdManager.getTypeId(eClass);
			return /*ValuesUtil.createObjectValue(typeId, */element;//);
		}
		throw new UnsupportedOperationException();		// FIXME do a lazy AS2Ecore
	}

	public @Nullable Object createInstance(@NonNull String value) {
		EObject eTarget = getETarget();
		if (eTarget instanceof EDataType) {
			EDataType eDataType = (EDataType) eTarget;
			Object element = eDataType.getEPackage().getEFactoryInstance().createFromString(eDataType, value);
//			TypeId typeId = IdManager.getTypeId(eDataType);
			return /*ValuesUtil.createObjectValue(typeId, */element;//);
//			return ValuesUtil.valueOf(element);
		}
		throw new UnsupportedOperationException();		// FIXME do a lazy AS2Ecore
	}

	@Override
	public @NonNull Type getCommonType(@NonNull IdResolver idResolver, @NonNull Type type) {
		if (type == this) {
			return this;
		}
		StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		CompleteInheritance thisInheritance = this.getInheritance(standardLibrary);
		CompleteInheritance thatInheritance = type.getInheritance(standardLibrary);
		return thisInheritance.getCommonInheritance(thatInheritance).getType();
	}

	@Override
	public boolean isEqualTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		Type thisType = this.getNormalizedType(standardLibrary);
		Type thatType = type.getNormalizedType(standardLibrary);
		return thisType == thatType;
	}

	@Override
	public boolean isEqualToUnspecializedType(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		return false;
	}

//	@Override
//	public boolean isInvalid() {
//		return false;
//	}

	@Override
	public boolean oclEquals(@NonNull OCLValue thatValue) {
		if (!(thatValue instanceof Type)) {
			return false;
		}
		TypeId thisTypeId = getTypeId();
		TypeId thatTypeId = ((Type)thatValue).getTypeId();
		return thisTypeId.equals(thatTypeId);
	}

	@Override
	public int oclHashCode() {
		return getTypeId().hashCode();
	}

	@Override
	public Type specializeIn(OCLExpression expr, Type selfType)
	{
		assert expr != null;
		assert selfType != null;
		return specializeIn(ClassUtil.nonNullState((CallExp)expr), selfType);
	}

//	@Override
//	@NonNull
//	public List<? extends Constraint> getOwnedRule() {
//		throw new UnsupportedOperationException();		// FIXME
//	}

	public org.eclipse.ocl.pivot.Package getPackage() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		throw new UnsupportedOperationException();		// FIXME
	}
} //TypeImpl
