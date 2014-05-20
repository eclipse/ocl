/*******************************************************************************
 * Copyright (c) 2012, 2014 E.D.Willink and others.
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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Profile;
import org.eclipse.ocl.examples.pivot.ProfileApplication;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ProfileImpl#getApplication <em>Application</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfileImpl extends PackageImpl implements Profile
{
	/**
	 * The cached value of the '{@link #getApplication() <em>Application</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplication()
	 * @generated
	 * @ordered
	 */
	protected EList<ProfileApplication> application;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfileImpl()
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
		return PivotPackage.Literals.PROFILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<ProfileApplication> getApplication()
	{
		if (application == null)
		{
			application = new EObjectWithInverseResolvingEList<ProfileApplication>(ProfileApplication.class, this, PivotPackage.PROFILE__APPLICATION, PivotPackage.PROFILE_APPLICATION__APPLIED_PROFILE);
		}
		return application;
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
			case PivotPackage.PROFILE__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.PROFILE__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.PROFILE__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
			case PivotPackage.PROFILE__TEMPLATE_BINDING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTemplateBinding()).basicAdd(otherEnd, msgs);
			case PivotPackage.PROFILE__NESTED_PACKAGE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNestedPackage()).basicAdd(otherEnd, msgs);
			case PivotPackage.PROFILE__NESTING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNestingPackage((org.eclipse.ocl.examples.pivot.Package)otherEnd, msgs);
			case PivotPackage.PROFILE__OWNED_TYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedType()).basicAdd(otherEnd, msgs);
			case PivotPackage.PROFILE__PROFILE_APPLICATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProfileApplication()).basicAdd(otherEnd, msgs);
			case PivotPackage.PROFILE__APPLICATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getApplication()).basicAdd(otherEnd, msgs);
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
			case PivotPackage.PROFILE__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROFILE__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROFILE__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROFILE__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROFILE__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case PivotPackage.PROFILE__TEMPLATE_BINDING:
				return ((InternalEList<?>)getTemplateBinding()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROFILE__NESTED_PACKAGE:
				return ((InternalEList<?>)getNestedPackage()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROFILE__NESTING_PACKAGE:
				return basicSetNestingPackage(null, msgs);
			case PivotPackage.PROFILE__OWNED_TYPE:
				return ((InternalEList<?>)getOwnedType()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROFILE__PROFILE_APPLICATION:
				return ((InternalEList<?>)getProfileApplication()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROFILE__APPLICATION:
				return ((InternalEList<?>)getApplication()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.PROFILE__EXTENSION:
				return getExtension();
			case PivotPackage.PROFILE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.PROFILE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.PROFILE__IS_STATIC:
				return isStatic();
			case PivotPackage.PROFILE__NAME:
				return getName();
			case PivotPackage.PROFILE__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.PROFILE__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.PROFILE__TEMPLATE_BINDING:
				return getTemplateBinding();
			case PivotPackage.PROFILE__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.PROFILE__IMPORTED_PACKAGE:
				return getImportedPackage();
			case PivotPackage.PROFILE__NESTED_PACKAGE:
				return getNestedPackage();
			case PivotPackage.PROFILE__NESTING_PACKAGE:
				return getNestingPackage();
			case PivotPackage.PROFILE__NS_PREFIX:
				return getNsPrefix();
			case PivotPackage.PROFILE__NS_URI:
				return getNsURI();
			case PivotPackage.PROFILE__OWNED_TYPE:
				return getOwnedType();
			case PivotPackage.PROFILE__PROFILE_APPLICATION:
				return getProfileApplication();
			case PivotPackage.PROFILE__APPLICATION:
				return getApplication();
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
			case PivotPackage.PROFILE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.PROFILE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.PROFILE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PROFILE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.PROFILE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.PROFILE__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.PROFILE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.PROFILE__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				getTemplateBinding().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.PROFILE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.PROFILE__IMPORTED_PACKAGE:
				getImportedPackage().clear();
				getImportedPackage().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
				return;
			case PivotPackage.PROFILE__NESTED_PACKAGE:
				getNestedPackage().clear();
				getNestedPackage().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
				return;
			case PivotPackage.PROFILE__NESTING_PACKAGE:
				setNestingPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.PROFILE__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case PivotPackage.PROFILE__NS_URI:
				setNsURI((String)newValue);
				return;
			case PivotPackage.PROFILE__OWNED_TYPE:
				getOwnedType().clear();
				getOwnedType().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.PROFILE__PROFILE_APPLICATION:
				getProfileApplication().clear();
				getProfileApplication().addAll((Collection<? extends ProfileApplication>)newValue);
				return;
			case PivotPackage.PROFILE__APPLICATION:
				getApplication().clear();
				getApplication().addAll((Collection<? extends ProfileApplication>)newValue);
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
			case PivotPackage.PROFILE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.PROFILE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.PROFILE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.PROFILE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.PROFILE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.PROFILE__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.PROFILE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.PROFILE__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				return;
			case PivotPackage.PROFILE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.PROFILE__IMPORTED_PACKAGE:
				getImportedPackage().clear();
				return;
			case PivotPackage.PROFILE__NESTED_PACKAGE:
				getNestedPackage().clear();
				return;
			case PivotPackage.PROFILE__NESTING_PACKAGE:
				setNestingPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.PROFILE__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case PivotPackage.PROFILE__NS_URI:
				setNsURI(NS_URI_EDEFAULT);
				return;
			case PivotPackage.PROFILE__OWNED_TYPE:
				getOwnedType().clear();
				return;
			case PivotPackage.PROFILE__PROFILE_APPLICATION:
				getProfileApplication().clear();
				return;
			case PivotPackage.PROFILE__APPLICATION:
				getApplication().clear();
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
			case PivotPackage.PROFILE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.PROFILE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.PROFILE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.PROFILE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.PROFILE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.PROFILE__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.PROFILE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.PROFILE__TEMPLATE_BINDING:
				return templateBinding != null && !templateBinding.isEmpty();
			case PivotPackage.PROFILE__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.PROFILE__IMPORTED_PACKAGE:
				return importedPackage != null && !importedPackage.isEmpty();
			case PivotPackage.PROFILE__NESTED_PACKAGE:
				return nestedPackage != null && !nestedPackage.isEmpty();
			case PivotPackage.PROFILE__NESTING_PACKAGE:
				return getNestingPackage() != null;
			case PivotPackage.PROFILE__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case PivotPackage.PROFILE__NS_URI:
				return NS_URI_EDEFAULT == null ? nsURI != null : !NS_URI_EDEFAULT.equals(nsURI);
			case PivotPackage.PROFILE__OWNED_TYPE:
				return ownedType != null && !ownedType.isEmpty();
			case PivotPackage.PROFILE__PROFILE_APPLICATION:
				return profileApplication != null && !profileApplication.isEmpty();
			case PivotPackage.PROFILE__APPLICATION:
				return application != null && !application.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitProfile(this);
	}

} //ProfileImpl
