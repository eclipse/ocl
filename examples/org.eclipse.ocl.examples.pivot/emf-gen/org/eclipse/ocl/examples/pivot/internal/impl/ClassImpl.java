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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl#getOwnedRule <em>Owned Rule</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl#isAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl#isActive <em>Is Active</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl#isInterface <em>Is Interface</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl#getNestedType <em>Nested Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl#getOwnedAttribute <em>Owned Attribute</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl#getOwnedBehavior <em>Owned Behavior</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl#getOwnedOperation <em>Owned Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl#getSuperClass <em>Super Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl
		extends TypeImpl
		implements org.eclipse.ocl.examples.pivot.Class {

	/**
	 * The cached value of the '{@link #getOwnedRule() <em>Owned Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRule()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> ownedRule;

	/**
	 * The default value of the '{@link #isAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_ABSTRACT_EFLAG = 1 << 9;

	/**
	 * The default value of the '{@link #isActive() <em>Is Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ACTIVE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isActive() <em>Is Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_ACTIVE_EFLAG = 1 << 10;

	/**
	 * The default value of the '{@link #isInterface() <em>Is Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterface()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INTERFACE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isInterface() <em>Is Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterface()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_INTERFACE_EFLAG = 1 << 11;

	/**
	 * The cached value of the '{@link #getNestedType() <em>Nested Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedType()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.examples.pivot.Class> nestedType;

	/**
	 * The cached value of the '{@link #getOwnedAttribute() <em>Owned Attribute</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> ownedAttribute;

	/**
	 * The cached value of the '{@link #getOwnedBehavior() <em>Owned Behavior</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBehavior()
	 * @generated
	 * @ordered
	 */
	protected EList<Behavior> ownedBehavior;

	/**
	 * The cached value of the '{@link #getOwnedOperation() <em>Owned Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> ownedOperation;

	/**
	 * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClass()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.examples.pivot.Class> superClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<Constraint> getOwnedRule()
	{
		if (ownedRule == null)
		{
			ownedRule = new EObjectContainmentEList<Constraint>(Constraint.class, this, PivotPackage.CLASS__OWNED_RULE);
		}
		return ownedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return (eFlags & IS_ABSTRACT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = (eFlags & IS_ABSTRACT_EFLAG) != 0;
		if (newIsAbstract) eFlags |= IS_ABSTRACT_EFLAG; else eFlags &= ~IS_ABSTRACT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.CLASS__IS_ABSTRACT, oldIsAbstract, newIsAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActive()
	{
		return (eFlags & IS_ACTIVE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsActive(boolean newIsActive)
	{
		boolean oldIsActive = (eFlags & IS_ACTIVE_EFLAG) != 0;
		if (newIsActive) eFlags |= IS_ACTIVE_EFLAG; else eFlags &= ~IS_ACTIVE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.CLASS__IS_ACTIVE, oldIsActive, newIsActive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Behavior> getOwnedBehavior()
	{
		if (ownedBehavior == null)
		{
			ownedBehavior = new EObjectContainmentEList<Behavior>(Behavior.class, this, PivotPackage.CLASS__OWNED_BEHAVIOR);
		}
		return ownedBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<Operation> getOwnedOperation()
	{
		if (ownedOperation == null)
		{
			ownedOperation = new EObjectContainmentWithInverseEList<Operation>(Operation.class, this, PivotPackage.CLASS__OWNED_OPERATION, PivotPackage.OPERATION__CLASS);
		}
		return ownedOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.examples.pivot.Package getPackage()
	{
		if (eContainerFeatureID() != PivotPackage.CLASS__PACKAGE) return null;
		return (org.eclipse.ocl.examples.pivot.Package)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPackage(org.eclipse.ocl.examples.pivot.Package newPackage, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newPackage, PivotPackage.CLASS__PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(org.eclipse.ocl.examples.pivot.Package newPackage)
	{
		if (newPackage != eInternalContainer() || (eContainerFeatureID() != PivotPackage.CLASS__PACKAGE && newPackage != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPackage != null)
				msgs = ((InternalEObject)newPackage).eInverseAdd(this, PivotPackage.PACKAGE__OWNED_TYPE, org.eclipse.ocl.examples.pivot.Package.class, msgs);
			msgs = basicSetPackage(newPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.CLASS__PACKAGE, newPackage, newPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PivotPackage.CLASS__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.CLASS__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.CLASS__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.CLASS__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.CLASS__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
			case PivotPackage.CLASS__TEMPLATE_BINDING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTemplateBinding()).basicAdd(otherEnd, msgs);
			case PivotPackage.CLASS__OWNING_TEMPLATE_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.CLASS__TEMPLATE_PARAMETER:
				if (templateParameter != null)
					msgs = ((InternalEObject)templateParameter).eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
				return basicSetTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.CLASS__EXTENDED_BYS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtendedBys()).basicAdd(otherEnd, msgs);
			case PivotPackage.CLASS__OWNED_ATTRIBUTE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedAttribute()).basicAdd(otherEnd, msgs);
			case PivotPackage.CLASS__OWNED_OPERATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperation()).basicAdd(otherEnd, msgs);
			case PivotPackage.CLASS__PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPackage((org.eclipse.ocl.examples.pivot.Package)otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
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
			case PivotPackage.CLASS__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.CLASS__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.CLASS__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.CLASS__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.CLASS__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case PivotPackage.CLASS__TEMPLATE_BINDING:
				return ((InternalEList<?>)getTemplateBinding()).basicRemove(otherEnd, msgs);
			case PivotPackage.CLASS__OWNING_TEMPLATE_PARAMETER:
				return basicSetOwningTemplateParameter(null, msgs);
			case PivotPackage.CLASS__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case PivotPackage.CLASS__EXTENDED_BYS:
				return ((InternalEList<?>)getExtendedBys()).basicRemove(otherEnd, msgs);
			case PivotPackage.CLASS__OWNED_INVARIANT:
				return ((InternalEList<?>)getOwnedInvariant()).basicRemove(otherEnd, msgs);
			case PivotPackage.CLASS__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.CLASS__NESTED_TYPE:
				return ((InternalEList<?>)getNestedType()).basicRemove(otherEnd, msgs);
			case PivotPackage.CLASS__OWNED_ATTRIBUTE:
				return ((InternalEList<?>)getOwnedAttribute()).basicRemove(otherEnd, msgs);
			case PivotPackage.CLASS__OWNED_BEHAVIOR:
				return ((InternalEList<?>)getOwnedBehavior()).basicRemove(otherEnd, msgs);
			case PivotPackage.CLASS__OWNED_OPERATION:
				return ((InternalEList<?>)getOwnedOperation()).basicRemove(otherEnd, msgs);
			case PivotPackage.CLASS__PACKAGE:
				return basicSetPackage(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case PivotPackage.CLASS__OWNING_TEMPLATE_PARAMETER:
				return eInternalContainer().eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
			case PivotPackage.CLASS__PACKAGE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.PACKAGE__OWNED_TYPE, org.eclipse.ocl.examples.pivot.Package.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<org.eclipse.ocl.examples.pivot.Class> getSuperClass()
	{
		if (superClass == null)
		{
			superClass = new EObjectResolvingEList<org.eclipse.ocl.examples.pivot.Class>(org.eclipse.ocl.examples.pivot.Class.class, this, PivotPackage.CLASS__SUPER_CLASS);
		}
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInterface()
	{
		return (eFlags & IS_INTERFACE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInterface(boolean newIsInterface)
	{
		boolean oldIsInterface = (eFlags & IS_INTERFACE_EFLAG) != 0;
		if (newIsInterface) eFlags |= IS_INTERFACE_EFLAG; else eFlags &= ~IS_INTERFACE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.CLASS__IS_INTERFACE, oldIsInterface, newIsInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<org.eclipse.ocl.examples.pivot.Class> getNestedType()
	{
		if (nestedType == null)
		{
			nestedType = new EObjectContainmentEList<org.eclipse.ocl.examples.pivot.Class>(org.eclipse.ocl.examples.pivot.Class.class, this, PivotPackage.CLASS__NESTED_TYPE);
		}
		return nestedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<Property> getOwnedAttribute()
	{
		if (ownedAttribute == null)
		{
			ownedAttribute = new EObjectContainmentWithInverseEList<Property>(Property.class, this, PivotPackage.CLASS__OWNED_ATTRIBUTE, PivotPackage.PROPERTY__CLASS);
		}
		return ownedAttribute;
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
			case PivotPackage.CLASS__COMMENT:
				return getComment();
			case PivotPackage.CLASS__EXTENSION:
				return getExtension();
			case PivotPackage.CLASS__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.CLASS__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.CLASS__IS_STATIC:
				return isStatic();
			case PivotPackage.CLASS__NAME:
				return getName();
			case PivotPackage.CLASS__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.CLASS__TEMPLATE_BINDING:
				return getTemplateBinding();
			case PivotPackage.CLASS__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.CLASS__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.CLASS__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.CLASS__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.CLASS__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.CLASS__OWNED_INVARIANT:
				return getOwnedInvariant();
			case PivotPackage.CLASS__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.CLASS__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.CLASS__IS_ACTIVE:
				return isActive();
			case PivotPackage.CLASS__IS_INTERFACE:
				return isInterface();
			case PivotPackage.CLASS__NESTED_TYPE:
				return getNestedType();
			case PivotPackage.CLASS__OWNED_ATTRIBUTE:
				return getOwnedAttribute();
			case PivotPackage.CLASS__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case PivotPackage.CLASS__OWNED_OPERATION:
				return getOwnedOperation();
			case PivotPackage.CLASS__PACKAGE:
				return getPackage();
			case PivotPackage.CLASS__SUPER_CLASS:
				return getSuperClass();
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
			case PivotPackage.CLASS__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.CLASS__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.CLASS__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.CLASS__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.CLASS__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.CLASS__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.CLASS__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.CLASS__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				getTemplateBinding().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.CLASS__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.CLASS__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.CLASS__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.CLASS__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.CLASS__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.CLASS__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				getOwnedInvariant().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.CLASS__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.CLASS__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.CLASS__IS_ACTIVE:
				setIsActive((Boolean)newValue);
				return;
			case PivotPackage.CLASS__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.CLASS__NESTED_TYPE:
				getNestedType().clear();
				getNestedType().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.CLASS__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				getOwnedAttribute().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.CLASS__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				getOwnedBehavior().addAll((Collection<? extends Behavior>)newValue);
				return;
			case PivotPackage.CLASS__OWNED_OPERATION:
				getOwnedOperation().clear();
				getOwnedOperation().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.CLASS__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.CLASS__SUPER_CLASS:
				getSuperClass().clear();
				getSuperClass().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
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
			case PivotPackage.CLASS__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.CLASS__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.CLASS__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.CLASS__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.CLASS__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.CLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.CLASS__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.CLASS__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				return;
			case PivotPackage.CLASS__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.CLASS__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.CLASS__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.CLASS__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.CLASS__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.CLASS__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				return;
			case PivotPackage.CLASS__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.CLASS__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.CLASS__IS_ACTIVE:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case PivotPackage.CLASS__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.CLASS__NESTED_TYPE:
				getNestedType().clear();
				return;
			case PivotPackage.CLASS__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				return;
			case PivotPackage.CLASS__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				return;
			case PivotPackage.CLASS__OWNED_OPERATION:
				getOwnedOperation().clear();
				return;
			case PivotPackage.CLASS__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.CLASS__SUPER_CLASS:
				getSuperClass().clear();
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
			case PivotPackage.CLASS__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.CLASS__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.CLASS__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.CLASS__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.CLASS__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.CLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.CLASS__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.CLASS__TEMPLATE_BINDING:
				return templateBinding != null && !templateBinding.isEmpty();
			case PivotPackage.CLASS__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.CLASS__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.CLASS__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.CLASS__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.CLASS__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.CLASS__OWNED_INVARIANT:
				return ownedInvariant != null && !ownedInvariant.isEmpty();
			case PivotPackage.CLASS__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.CLASS__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.CLASS__IS_ACTIVE:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case PivotPackage.CLASS__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.CLASS__NESTED_TYPE:
				return nestedType != null && !nestedType.isEmpty();
			case PivotPackage.CLASS__OWNED_ATTRIBUTE:
				return ownedAttribute != null && !ownedAttribute.isEmpty();
			case PivotPackage.CLASS__OWNED_BEHAVIOR:
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case PivotPackage.CLASS__OWNED_OPERATION:
				return ownedOperation != null && !ownedOperation.isEmpty();
			case PivotPackage.CLASS__PACKAGE:
				return getPackage() != null;
			case PivotPackage.CLASS__SUPER_CLASS:
				return superClass != null && !superClass.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == Namespace.class)
		{
			switch (derivedFeatureID)
			{
				case PivotPackage.CLASS__OWNED_RULE: return PivotPackage.NAMESPACE__OWNED_RULE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == Namespace.class)
		{
			switch (baseFeatureID)
			{
				case PivotPackage.NAMESPACE__OWNED_RULE: return PivotPackage.CLASS__OWNED_RULE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		return visitor.visitClass(this);
	}

	@Override
	public @NonNull List<? extends DomainType> getLocalSuperTypes() {
		return getSuperClass();
	}
} //ClassImpl
