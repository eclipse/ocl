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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumerationLiteralImpl#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumerationLiteralImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("cast")
public class EnumerationLiteralImpl
		extends NamedElementImpl
		implements EnumerationLiteral {

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Number VALUE_EDEFAULT = (Number)PivotFactory.eINSTANCE.createFromString(PivotPackage.eINSTANCE.getInteger(), "0"); //$NON-NLS-1$
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Number value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.ENUMERATION_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration getEnumeration() {
		if (eContainerFeatureID() != PivotPackage.ENUMERATION_LITERAL__ENUMERATION) return null;
		return (Enumeration)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnumeration(Enumeration newEnumeration,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEnumeration, PivotPackage.ENUMERATION_LITERAL__ENUMERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumeration(Enumeration newEnumeration) {
		if (newEnumeration != eInternalContainer() || (eContainerFeatureID() != PivotPackage.ENUMERATION_LITERAL__ENUMERATION && newEnumeration != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newEnumeration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEnumeration != null)
				msgs = ((InternalEObject)newEnumeration).eInverseAdd(this, PivotPackage.ENUMERATION__OWNED_LITERAL, Enumeration.class, msgs);
			msgs = basicSetEnumeration(newEnumeration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ENUMERATION_LITERAL__ENUMERATION, newEnumeration, newEnumeration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Number getValue()
	{
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Number newValue)
	{
		Number oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ENUMERATION_LITERAL__VALUE, oldValue, value));
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
			case PivotPackage.ENUMERATION_LITERAL__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.ENUMERATION_LITERAL__ENUMERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEnumeration((Enumeration)otherEnd, msgs);
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
			case PivotPackage.ENUMERATION_LITERAL__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION_LITERAL__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION_LITERAL__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.ENUMERATION_LITERAL__ENUMERATION:
				return basicSetEnumeration(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case PivotPackage.ENUMERATION_LITERAL__ENUMERATION:
				return eInternalContainer().eInverseRemove(this, PivotPackage.ENUMERATION__OWNED_LITERAL, Enumeration.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
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
			case PivotPackage.ENUMERATION_LITERAL__EXTENSION:
				return getExtension();
			case PivotPackage.ENUMERATION_LITERAL__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.ENUMERATION_LITERAL__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.ENUMERATION_LITERAL__IS_STATIC:
				return isStatic();
			case PivotPackage.ENUMERATION_LITERAL__NAME:
				return getName();
			case PivotPackage.ENUMERATION_LITERAL__ENUMERATION:
				return getEnumeration();
			case PivotPackage.ENUMERATION_LITERAL__VALUE:
				return getValue();
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
			case PivotPackage.ENUMERATION_LITERAL__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.ENUMERATION_LITERAL__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.ENUMERATION_LITERAL__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ENUMERATION_LITERAL__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.ENUMERATION_LITERAL__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ENUMERATION_LITERAL__ENUMERATION:
				setEnumeration((Enumeration)newValue);
				return;
			case PivotPackage.ENUMERATION_LITERAL__VALUE:
				setValue((Number)newValue);
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
			case PivotPackage.ENUMERATION_LITERAL__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.ENUMERATION_LITERAL__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.ENUMERATION_LITERAL__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.ENUMERATION_LITERAL__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.ENUMERATION_LITERAL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ENUMERATION_LITERAL__ENUMERATION:
				setEnumeration((Enumeration)null);
				return;
			case PivotPackage.ENUMERATION_LITERAL__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case PivotPackage.ENUMERATION_LITERAL__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.ENUMERATION_LITERAL__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.ENUMERATION_LITERAL__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.ENUMERATION_LITERAL__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.ENUMERATION_LITERAL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ENUMERATION_LITERAL__ENUMERATION:
				return getEnumeration() != null;
			case PivotPackage.ENUMERATION_LITERAL__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		return visitor.visitEnumerationLiteral(this);
	}

	public @NonNull Enumerator getEnumerator() {
		EObject eTarget = getETarget();
		if (eTarget instanceof EEnumLiteral) {
			return DomainUtil.nonNullEMF(((EEnumLiteral) eTarget).getInstance());
		}
		else {
			throw new UnsupportedOperationException();			// FIXME
		}
	}
	
	private /*@LazyNonNull*/ EnumerationLiteralId enumerationLiteralId = null;

	public @NonNull EnumerationLiteralId getEnumerationLiteralId() {
		EnumerationLiteralId enumerationLiteralId2 = enumerationLiteralId;
		if (enumerationLiteralId2 == null) {
			String name = DomainUtil.nonNullModel(getName());
			EnumerationId enumerationId = getEnumeration().getEnumerationId();
			enumerationLiteralId = enumerationLiteralId2 = enumerationId.getEnumerationLiteralId(name);
		}
		return enumerationLiteralId2;
	}
} //EnumerationLiteralImpl
