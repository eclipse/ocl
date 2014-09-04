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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.NestedCompletePackage;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nested Complete Package</b></em>'.
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
public class NestedCompletePackageImpl extends CompletePackageImpl implements NestedCompletePackage
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

	private /*final*/ /*@LazyNonNull*/ Map<String, CompleteClass> name2completeClass = null;

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitNestedCompletePackage(this);
	}

	@Override
	protected void didAddCompleteClass(@NonNull CompleteClass completeClass) {
		assert name2completeClass != null;
		String name = completeClass.getName();
		if (name != null) {
			CompleteClass oldCompleteClass = name2completeClass.put(name, completeClass);
			assert oldCompleteClass == null;
		}
	}

	@Override
	protected void didAddPartialPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		if (name2completeClass != null) {
			doRefreshPartialClasses(partialPackage);
		}
	}

	@Override
	protected void didRemoveCompleteClass(@NonNull CompleteClass completeClass) {
		assert name2completeClass != null;
		String name = completeClass.getName();
		if (name != null) {
			CompleteClass oldCompleteClass = name2completeClass.remove(name);
			assert oldCompleteClass == completeClass;
		}
	}

	@Override
	protected void didRemovePartialPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		for (org.eclipse.ocl.examples.pivot.Class partialClass : partialPackage.getOwnedClasses()) {
			String name = partialClass.getName();
			if (name != null) {
				CompleteClass completeClass = name2completeClass.remove(name);
				completeClass.getPartialClasses().remove(partialClass);
			}
		}
	}

	protected void doRefreshPartialClasses() {
		if (name2completeClass == null) {
			name2completeClass = new HashMap<String, CompleteClass>();
		}
		for (org.eclipse.ocl.examples.pivot.Package partialPackage : getPartialPackages()) {
			if (partialPackage != null) {
				doRefreshPartialClasses(partialPackage);
			}
		}
	}

	private void doRefreshPartialClasses(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		assert name2completeClass != null;
		for (org.eclipse.ocl.examples.pivot.Class partialClass : partialPackage.getOwnedClasses()) {
			String name = partialClass.getName();
			if (name != null) {
				CompleteClass completeClass = name2completeClass.get(name);
				if (completeClass == null) {
					completeClass = PivotFactory.eINSTANCE.createCompleteClass();
					completeClass.setName(name);
					getOwnedCompleteClasses().add(completeClass);
//					TypeServer typeServer = getCompleteModel().getTypeServer(partialClass);
//					((CompleteClassImpl)completeClass).setTypeServer(typeServer);
				}
				completeClass.getPartialClasses().add(partialClass);
			}
		}
	}

	public @Nullable CompleteClass getCompleteClass(String name) {
		if (name2completeClass == null) {
			doRefreshPartialClasses();
		}
		return name2completeClass.get(name);
	}

	@Override
	public @Nullable CompleteClass getOwnedCompleteClass(@NonNull String name) {
		if (name2completeClass == null) {
			doRefreshPartialClasses();
		}
		return name2completeClass.get(name);
	}

	public TypeServer getTypeServer(DomainType pivotType) {
		CompleteClass completeClass = getCompleteClass(pivotType.getName());
		assert completeClass != null;
		if (name2completeClass == null) {
			doRefreshPartialClasses();
		}
		TypeServer typeServer = completeClass.getTypeServer();
		if (typeServer == null) {
			typeServer = getTypeServer2(completeClass, pivotType);
			((CompleteClassImpl)completeClass).setTypeServer(typeServer);
		}
		return typeServer;
	}
	
/*	@SuppressWarnings("null")
	public static final @NonNull List<NestedPackageServer> EMPTY_LIST = Collections.<NestedPackageServer>emptyList();
	
	private final @NonNull PackageServer parentPackageServer;
	
	public NestedPackageServer(@NonNull PackageServer parentPackageServer, @NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId) {
		super(parentPackageServer.getPackageManager(), name, nsPrefix, nsURI, packageId);
		this.parentPackageServer = parentPackageServer;
	}

	@Override
	protected void assertSamePackage(@Nullable DomainPackage domainPackage) {
		assert domainPackage != null;
		DomainPackage parentPackage = domainPackage.getOwningPackage();
		assert parentPackage != null;
		parentPackageServer.assertSamePackage(parentPackage);
		super.assertSamePackage(domainPackage);
	}

	@Override
	public void dispose() {
		super.dispose();
		parentPackageServer.disposedNestedPackageServer(this);
	}

	public @NonNull DomainPackage getOwningPackage() {
		return parentPackageServer;
	}

	@Override
	public @NonNull PackageServer getParentPackageServer() {
		return parentPackageServer;
	} */
} //NestedCompletePackageImpl
