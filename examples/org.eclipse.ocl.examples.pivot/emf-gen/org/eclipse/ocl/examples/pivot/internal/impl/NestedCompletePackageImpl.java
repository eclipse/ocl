/**
 * Copyright (c) 2010,2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
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
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.NestedCompletePackage;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.internal.complete.NestedPackageCompleteClasses;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nested Complete Package</b></em>'.
 * @extends org.eclipse.ocl.examples.pivot.NestedCompletePackage.Internal
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.NestedCompletePackageImpl#getOwningCompletePackage <em>Owning Complete Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NestedCompletePackageImpl extends CompletePackageImpl implements NestedCompletePackage, org.eclipse.ocl.examples.pivot.NestedCompletePackage.Internal
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NestedCompletePackageImpl()
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
		return PivotPackage.Literals.NESTED_COMPLETE_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletePackage getOwningCompletePackage()
	{
		if (eContainerFeatureID() != PivotPackage.NESTED_COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE) return null;
		return (CompletePackage)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningCompletePackage(CompletePackage newOwningCompletePackage, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningCompletePackage, PivotPackage.NESTED_COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("cast")
	public void setOwningCompletePackage(CompletePackage newOwningCompletePackage)
	{
		if (newOwningCompletePackage != eInternalContainer() || (eContainerFeatureID() != PivotPackage.NESTED_COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE && newOwningCompletePackage != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newOwningCompletePackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningCompletePackage != null)
				msgs = ((InternalEObject)newOwningCompletePackage).eInverseAdd(this, PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES, CompletePackage.class, msgs);
			msgs = basicSetOwningCompletePackage(newOwningCompletePackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.NESTED_COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE, newOwningCompletePackage, newOwningCompletePackage));
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
			case PivotPackage.NESTED_COMPLETE_PACKAGE__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.NESTED_COMPLETE_PACKAGE__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedCompleteClasses()).basicAdd(otherEnd, msgs);
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedCompletePackages()).basicAdd(otherEnd, msgs);
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningCompletePackage((CompletePackage)otherEnd, msgs);
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
			case PivotPackage.NESTED_COMPLETE_PACKAGE__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.NESTED_COMPLETE_PACKAGE__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES:
				return ((InternalEList<?>)getOwnedCompleteClasses()).basicRemove(otherEnd, msgs);
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES:
				return ((InternalEList<?>)getOwnedCompletePackages()).basicRemove(otherEnd, msgs);
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE:
				return basicSetOwningCompletePackage(null, msgs);
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
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES, CompletePackage.class, msgs);
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
			case PivotPackage.NESTED_COMPLETE_PACKAGE__COMMENT:
				return getComment();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__EXTENSION:
				return getExtension();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__NAME:
				return getName();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES:
				return getOwnedCompleteClasses();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES:
				return getOwnedCompletePackages();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__PARTIAL_PACKAGES:
				return getPartialPackages();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE:
				return getOwningCompletePackage();
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
			case PivotPackage.NESTED_COMPLETE_PACKAGE__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES:
				getOwnedCompleteClasses().clear();
				getOwnedCompleteClasses().addAll((Collection<? extends CompleteClass>)newValue);
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES:
				getOwnedCompletePackages().clear();
				getOwnedCompletePackages().addAll((Collection<? extends NestedCompletePackage>)newValue);
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__PARTIAL_PACKAGES:
				getPartialPackages().clear();
				getPartialPackages().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE:
				setOwningCompletePackage((CompletePackage)newValue);
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
			case PivotPackage.NESTED_COMPLETE_PACKAGE__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES:
				getOwnedCompleteClasses().clear();
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES:
				getOwnedCompletePackages().clear();
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__PARTIAL_PACKAGES:
				getPartialPackages().clear();
				return;
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE:
				setOwningCompletePackage((CompletePackage)null);
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.NESTED_COMPLETE_PACKAGE__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES:
				return ownedCompleteClasses != null && !ownedCompleteClasses.isEmpty();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES:
				return ownedCompletePackages != null && !ownedCompletePackages.isEmpty();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__PARTIAL_PACKAGES:
				return partialPackages != null && !partialPackages.isEmpty();
			case PivotPackage.NESTED_COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE:
				return getOwningCompletePackage() != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitNestedCompletePackage(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull NestedPackageCompleteClasses getOwnedCompleteClasses()
	{
		NestedPackageCompleteClasses ownedCompleteClasses2 = (NestedPackageCompleteClasses) ownedCompleteClasses;
		if (ownedCompleteClasses2 == null)
		{
			ownedCompleteClasses = ownedCompleteClasses2 = new NestedPackageCompleteClasses(this);
		}
		return ownedCompleteClasses2;
	}
} //NestedCompletePackageImpl
