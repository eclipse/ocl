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
package org.eclipse.ocl.pivot.internal.impl;

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
import org.eclipse.ocl.domain.elements.DomainCallExp;
import org.eclipse.ocl.domain.elements.DomainConstraint;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainPackage;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.types.IdResolver;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.domain.values.OCLValue;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExtension;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.TypeImpl#getExtendedBys <em>Extended Bys</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("cast")
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
			case PivotPackage.TYPE__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.TYPE__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.TYPE__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
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
			case PivotPackage.TYPE__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.TYPE__COMMENT:
				return getComment();
			case PivotPackage.TYPE__EXTENSION:
				return getExtension();
			case PivotPackage.TYPE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.TYPE__OWNED_COMMENT:
				return getOwnedComment();
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
			case PivotPackage.TYPE__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
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
			case PivotPackage.TYPE__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.TYPE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
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
			case PivotPackage.TYPE__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.TYPE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.TYPE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.TYPE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
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
	public @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		if (type == this) {
			return this;
		}
		DomainStandardLibrary standardLibrary = idResolver.getStandardLibrary();
		DomainInheritance thisInheritance = this.getInheritance(standardLibrary);
		DomainInheritance thatInheritance = type.getInheritance(standardLibrary);
		return thisInheritance.getCommonInheritance(thatInheritance).getType();
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return DomainUtil.nonNullState(eClass().getName());
	}

	@Override
	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		DomainType thisType = this.getNormalizedType(standardLibrary);
		DomainType thatType = type.getNormalizedType(standardLibrary);
		return thisType == thatType;
	}

	@Override
	public boolean isEqualToUnspecializedType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isInvalid() {
		return false;
	}

	public boolean isOrdered() {
		return false;
	}

	public boolean isUnique() {
		return false;
	}

	@Override
	public boolean oclEquals(@NonNull OCLValue thatValue) {
		if (!(thatValue instanceof DomainType)) {
			return false;
		}
		TypeId thisTypeId = getTypeId();
		TypeId thatTypeId = ((DomainType)thatValue).getTypeId();
		return thisTypeId.equals(thatTypeId);
	}

	@Override
	public int oclHashCode() {
		return getTypeId().hashCode();
	}

	@Override
	public Type specializeIn(final /*@NonNull*/ OCLExpression expr, final /*@NonNull*/ Type selfType)
	{
		assert expr != null;
		assert selfType != null;
		return (Type) specializeIn(DomainUtil.nonNullState((DomainCallExp)expr), (DomainType)selfType);
	}

	@Override
	@NonNull
	public List<? extends DomainConstraint> getOwnedRule() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public DomainPackage getPackage() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		throw new UnsupportedOperationException();		// FIXME
	}
} //TypeImpl
