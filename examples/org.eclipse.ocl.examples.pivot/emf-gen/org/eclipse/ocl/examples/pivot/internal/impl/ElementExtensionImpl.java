/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Applied Stereotype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ElementExtensionImpl#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ElementExtensionImpl#isApplied <em>Is Applied</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ElementExtensionImpl#isRequired <em>Is Required</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ElementExtensionImpl#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("cast")
public class ElementExtensionImpl extends ClassImpl implements ElementExtension
{
	/**
	 * The default value of the '{@link #isApplied() <em>Is Applied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isApplied()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_APPLIED_EDEFAULT = false;
	/**
	 * The flag representing the value of the '{@link #isApplied() <em>Is Applied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isApplied()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_APPLIED_EFLAG = 1 << 11;
	/**
	 * The default value of the '{@link #isRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REQUIRED_EDEFAULT = false;
	/**
	 * The flag representing the value of the '{@link #isRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_REQUIRED_EFLAG = 1 << 12;
	/**
	 * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected Stereotype stereotype;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementExtensionImpl()
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
		return PivotPackage.Literals.ELEMENT_EXTENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype getStereotype()
	{
		if (stereotype != null && ((EObject)stereotype).eIsProxy())
		{
			InternalEObject oldStereotype = (InternalEObject)stereotype;
			stereotype = (Stereotype)eResolveProxy(oldStereotype);
			if (stereotype != oldStereotype)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.ELEMENT_EXTENSION__STEREOTYPE, oldStereotype, stereotype));
			}
		}
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype basicGetStereotype()
	{
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotype(Stereotype newStereotype)
	{
		Stereotype oldStereotype = stereotype;
		stereotype = newStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ELEMENT_EXTENSION__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getBase()
	{
		if (eContainerFeatureID() != PivotPackage.ELEMENT_EXTENSION__BASE) return null;
		return (Element)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBase(Element newBase, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newBase, PivotPackage.ELEMENT_EXTENSION__BASE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase(Element newBase)
	{
		if (newBase != eInternalContainer() || (eContainerFeatureID() != PivotPackage.ELEMENT_EXTENSION__BASE && newBase != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newBase))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBase != null)
				msgs = ((InternalEObject)newBase).eInverseAdd(this, PivotPackage.ELEMENT__EXTENSION, Element.class, msgs);
			msgs = basicSetBase(newBase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ELEMENT_EXTENSION__BASE, newBase, newBase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isApplied()
	{
		return (eFlags & IS_APPLIED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsApplied(boolean newIsApplied)
	{
		boolean oldIsApplied = (eFlags & IS_APPLIED_EFLAG) != 0;
		if (newIsApplied) eFlags |= IS_APPLIED_EFLAG; else eFlags &= ~IS_APPLIED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ELEMENT_EXTENSION__IS_APPLIED, oldIsApplied, newIsApplied));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequired()
	{
		return (eFlags & IS_REQUIRED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsRequired(boolean newIsRequired)
	{
		boolean oldIsRequired = (eFlags & IS_REQUIRED_EFLAG) != 0;
		if (newIsRequired) eFlags |= IS_REQUIRED_EFLAG; else eFlags &= ~IS_REQUIRED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ELEMENT_EXTENSION__IS_REQUIRED, oldIsRequired, newIsRequired));
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
			case PivotPackage.ELEMENT_EXTENSION__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__EXTENDED_BYS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtendedBys()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_BINDINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTemplateBindings()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperations()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_PROPERTIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedProperties()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningPackage((org.eclipse.ocl.examples.pivot.Package)otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__BASE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBase((Element)otherEnd, msgs);
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
			case PivotPackage.ELEMENT_EXTENSION__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__EXTENDED_BYS:
				return ((InternalEList<?>)getExtendedBys()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_BINDINGS:
				return ((InternalEList<?>)getOwnedTemplateBindings()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_BEHAVIOR:
				return ((InternalEList<?>)getOwnedBehavior()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_INVARIANTS:
				return ((InternalEList<?>)getOwnedInvariants()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_OPERATIONS:
				return ((InternalEList<?>)getOwnedOperations()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_PROPERTIES:
				return ((InternalEList<?>)getOwnedProperties()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNING_PACKAGE:
				return basicSetOwningPackage(null, msgs);
			case PivotPackage.ELEMENT_EXTENSION__BASE:
				return basicSetBase(null, msgs);
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
			case PivotPackage.ELEMENT_EXTENSION__OWNING_PACKAGE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.PACKAGE__OWNED_CLASSES, org.eclipse.ocl.examples.pivot.Package.class, msgs);
			case PivotPackage.ELEMENT_EXTENSION__BASE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.ELEMENT__EXTENSION, Element.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
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
			case PivotPackage.ELEMENT_EXTENSION__COMMENT:
				return getComment();
			case PivotPackage.ELEMENT_EXTENSION__EXTENSION:
				return getExtension();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.ELEMENT_EXTENSION__NAME:
				return getName();
			case PivotPackage.ELEMENT_EXTENSION__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_BINDINGS:
				return getOwnedTemplateBindings();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.ELEMENT_EXTENSION__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.ELEMENT_EXTENSION__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.ELEMENT_EXTENSION__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.ELEMENT_EXTENSION__IS_ACTIVE:
				return isActive();
			case PivotPackage.ELEMENT_EXTENSION__IS_INTERFACE:
				return isInterface();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_INVARIANTS:
				return getOwnedInvariants();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_OPERATIONS:
				return getOwnedOperations();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_PROPERTIES:
				return getOwnedProperties();
			case PivotPackage.ELEMENT_EXTENSION__OWNING_PACKAGE:
				return getOwningPackage();
			case PivotPackage.ELEMENT_EXTENSION__SUPER_CLASSES:
				return getSuperClasses();
			case PivotPackage.ELEMENT_EXTENSION__BASE:
				return getBase();
			case PivotPackage.ELEMENT_EXTENSION__IS_APPLIED:
				return isApplied();
			case PivotPackage.ELEMENT_EXTENSION__IS_REQUIRED:
				return isRequired();
			case PivotPackage.ELEMENT_EXTENSION__STEREOTYPE:
				if (resolve) return getStereotype();
				return basicGetStereotype();
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
			case PivotPackage.ELEMENT_EXTENSION__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_BINDINGS:
				getOwnedTemplateBindings().clear();
				getOwnedTemplateBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__IS_ACTIVE:
				setIsActive((Boolean)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				getOwnedBehavior().addAll((Collection<? extends Behavior>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
				getOwnedInvariants().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				getOwnedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__SUPER_CLASSES:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__BASE:
				setBase((Element)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__IS_APPLIED:
				setIsApplied((Boolean)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__STEREOTYPE:
				setStereotype((Stereotype)newValue);
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
			case PivotPackage.ELEMENT_EXTENSION__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ELEMENT_EXTENSION__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_BINDINGS:
				getOwnedTemplateBindings().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.ELEMENT_EXTENSION__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.ELEMENT_EXTENSION__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.ELEMENT_EXTENSION__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.ELEMENT_EXTENSION__IS_ACTIVE:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case PivotPackage.ELEMENT_EXTENSION__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.ELEMENT_EXTENSION__SUPER_CLASSES:
				getSuperClasses().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__BASE:
				setBase((Element)null);
				return;
			case PivotPackage.ELEMENT_EXTENSION__IS_APPLIED:
				setIsApplied(IS_APPLIED_EDEFAULT);
				return;
			case PivotPackage.ELEMENT_EXTENSION__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.ELEMENT_EXTENSION__STEREOTYPE:
				setStereotype((Stereotype)null);
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
			case PivotPackage.ELEMENT_EXTENSION__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ELEMENT_EXTENSION__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_BINDINGS:
				return ownedTemplateBindings != null && !ownedTemplateBindings.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.ELEMENT_EXTENSION__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.ELEMENT_EXTENSION__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.ELEMENT_EXTENSION__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.ELEMENT_EXTENSION__IS_ACTIVE:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case PivotPackage.ELEMENT_EXTENSION__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_BEHAVIOR:
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_INVARIANTS:
				return ownedInvariants != null && !ownedInvariants.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_OPERATIONS:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_PROPERTIES:
				return ownedProperties != null && !ownedProperties.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__OWNING_PACKAGE:
				return getOwningPackage() != null;
			case PivotPackage.ELEMENT_EXTENSION__SUPER_CLASSES:
				return superClasses != null && !superClasses.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__BASE:
				return getBase() != null;
			case PivotPackage.ELEMENT_EXTENSION__IS_APPLIED:
				return ((eFlags & IS_APPLIED_EFLAG) != 0) != IS_APPLIED_EDEFAULT;
			case PivotPackage.ELEMENT_EXTENSION__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.ELEMENT_EXTENSION__STEREOTYPE:
				return stereotype != null;
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
		return visitor.visitElementExtension(this);
	}

	@Override
	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		return stereotype.getInheritance(standardLibrary);
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Package getPackage() {
		return PivotUtil.getContainingPackage(eContainer());
	}
} //ElementExtensionImpl
