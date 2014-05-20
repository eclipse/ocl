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
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
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
public class ElementExtensionImpl extends TypeImpl implements ElementExtension
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
	protected static final int IS_APPLIED_EFLAG = 1 << 9;
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
	protected static final int IS_REQUIRED_EFLAG = 1 << 10;
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
			case PivotPackage.ELEMENT_EXTENSION__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__TEMPLATE_BINDING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTemplateBinding()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNING_TEMPLATE_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__TEMPLATE_PARAMETER:
				if (templateParameter != null)
					msgs = ((InternalEObject)templateParameter).eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
				return basicSetTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__EXTENDED_BYS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtendedBys()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ATTRIBUTE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedAttribute()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_OPERATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperation()).basicAdd(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPackage((org.eclipse.ocl.examples.pivot.Package)otherEnd, msgs);
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
			case PivotPackage.ELEMENT_EXTENSION__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case PivotPackage.ELEMENT_EXTENSION__TEMPLATE_BINDING:
				return ((InternalEList<?>)getTemplateBinding()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNING_TEMPLATE_PARAMETER:
				return basicSetOwningTemplateParameter(null, msgs);
			case PivotPackage.ELEMENT_EXTENSION__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case PivotPackage.ELEMENT_EXTENSION__EXTENDED_BYS:
				return ((InternalEList<?>)getExtendedBys()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ATTRIBUTE:
				return ((InternalEList<?>)getOwnedAttribute()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_INVARIANT:
				return ((InternalEList<?>)getOwnedInvariant()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_OPERATION:
				return ((InternalEList<?>)getOwnedOperation()).basicRemove(otherEnd, msgs);
			case PivotPackage.ELEMENT_EXTENSION__PACKAGE:
				return basicSetPackage(null, msgs);
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
			case PivotPackage.ELEMENT_EXTENSION__OWNING_TEMPLATE_PARAMETER:
				return eInternalContainer().eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
			case PivotPackage.ELEMENT_EXTENSION__PACKAGE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.PACKAGE__OWNED_TYPE, org.eclipse.ocl.examples.pivot.Package.class, msgs);
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
			case PivotPackage.ELEMENT_EXTENSION__EXTENSION:
				return getExtension();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.ELEMENT_EXTENSION__IS_STATIC:
				return isStatic();
			case PivotPackage.ELEMENT_EXTENSION__NAME:
				return getName();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.ELEMENT_EXTENSION__TEMPLATE_BINDING:
				return getTemplateBinding();
			case PivotPackage.ELEMENT_EXTENSION__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.ELEMENT_EXTENSION__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.ELEMENT_EXTENSION__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.ELEMENT_EXTENSION__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.ELEMENT_EXTENSION__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ATTRIBUTE:
				return getOwnedAttribute();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_INVARIANT:
				return getOwnedInvariant();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_OPERATION:
				return getOwnedOperation();
			case PivotPackage.ELEMENT_EXTENSION__PACKAGE:
				return getPackage();
			case PivotPackage.ELEMENT_EXTENSION__SUPER_CLASS:
				return getSuperClass();
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
			case PivotPackage.ELEMENT_EXTENSION__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				getTemplateBinding().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				getOwnedAttribute().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				getOwnedInvariant().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_OPERATION:
				getOwnedOperation().clear();
				getOwnedOperation().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.ELEMENT_EXTENSION__SUPER_CLASS:
				getSuperClass().clear();
				getSuperClass().addAll((Collection<? extends Type>)newValue);
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
			case PivotPackage.ELEMENT_EXTENSION__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.ELEMENT_EXTENSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.ELEMENT_EXTENSION__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.ELEMENT_EXTENSION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.ELEMENT_EXTENSION__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__OWNED_OPERATION:
				getOwnedOperation().clear();
				return;
			case PivotPackage.ELEMENT_EXTENSION__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.ELEMENT_EXTENSION__SUPER_CLASS:
				getSuperClass().clear();
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
			case PivotPackage.ELEMENT_EXTENSION__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.ELEMENT_EXTENSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.ELEMENT_EXTENSION__TEMPLATE_BINDING:
				return templateBinding != null && !templateBinding.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.ELEMENT_EXTENSION__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.ELEMENT_EXTENSION__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.ELEMENT_EXTENSION__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.ELEMENT_EXTENSION__OWNED_ATTRIBUTE:
				return ownedAttribute != null && !ownedAttribute.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_INVARIANT:
				return ownedInvariant != null && !ownedInvariant.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__OWNED_OPERATION:
				return ownedOperation != null && !ownedOperation.isEmpty();
			case PivotPackage.ELEMENT_EXTENSION__PACKAGE:
				return getPackage() != null;
			case PivotPackage.ELEMENT_EXTENSION__SUPER_CLASS:
				return superClass != null && !superClass.isEmpty();
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
