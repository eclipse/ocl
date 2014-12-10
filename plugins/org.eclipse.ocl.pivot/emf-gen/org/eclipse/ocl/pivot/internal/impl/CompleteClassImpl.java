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
package org.eclipse.ocl.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainFragment;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainOperation;
import org.eclipse.ocl.domain.elements.DomainProperty;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.elements.FeatureFilter;
import org.eclipse.ocl.domain.ids.OperationId;
import org.eclipse.ocl.domain.values.CollectionTypeParameters;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteInheritanceImpl;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.CompletePackageInternal;
import org.eclipse.ocl.pivot.internal.complete.PartialClasses;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.manager.PivotStandardLibrary;
import org.eclipse.ocl.pivot.util.Visitor;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Class</b></em>'.
 * @extends org.eclipse.ocl.pivot.CompleteClassInternal
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.CompleteClassImpl#getOwningCompletePackage <em>Owning Complete Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.CompleteClassImpl#getPartialClasses <em>Partial Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompleteClassImpl extends NamedElementImpl implements CompleteClass, CompleteClassInternal
{

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.COMPLETE_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletePackage getOwningCompletePackageGen()
	{
		if (eContainerFeatureID() != PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE) return null;
		return (CompletePackage)eInternalContainer();
	}
	@Override
	public CompletePackageInternal getOwningCompletePackage()
	{
		return (CompletePackageInternal)getOwningCompletePackageGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningCompletePackage(CompletePackage newOwningCompletePackage, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningCompletePackage, PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningCompletePackage(CompletePackage newOwningCompletePackage)
	{
		if (newOwningCompletePackage != eInternalContainer() || (eContainerFeatureID() != PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE && newOwningCompletePackage != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningCompletePackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningCompletePackage != null)
				msgs = ((InternalEObject)newOwningCompletePackage).eInverseAdd(this, PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES, CompletePackage.class, msgs);
			msgs = basicSetOwningCompletePackage(newOwningCompletePackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE, newOwningCompletePackage, newOwningCompletePackage));
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
			case PivotPackage.COMPLETE_CLASS__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.COMPLETE_CLASS__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.COMPLETE_CLASS__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE:
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
			case PivotPackage.COMPLETE_CLASS__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.COMPLETE_CLASS__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.COMPLETE_CLASS__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.COMPLETE_CLASS__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE:
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
			case PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES, CompletePackage.class, msgs);
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
			case PivotPackage.COMPLETE_CLASS__COMMENT:
				return getComment();
			case PivotPackage.COMPLETE_CLASS__EXTENSION:
				return getExtension();
			case PivotPackage.COMPLETE_CLASS__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.COMPLETE_CLASS__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.COMPLETE_CLASS__NAME:
				return getName();
			case PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE:
				return getOwningCompletePackage();
			case PivotPackage.COMPLETE_CLASS__PARTIAL_CLASSES:
				return getPartialClasses();
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
			case PivotPackage.COMPLETE_CLASS__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COMPLETE_CLASS__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.COMPLETE_CLASS__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.COMPLETE_CLASS__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COMPLETE_CLASS__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE:
				setOwningCompletePackage((CompletePackage)newValue);
				return;
			case PivotPackage.COMPLETE_CLASS__PARTIAL_CLASSES:
				getPartialClasses().clear();
				getPartialClasses().addAll((Collection<? extends org.eclipse.ocl.pivot.Class>)newValue);
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
			case PivotPackage.COMPLETE_CLASS__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.COMPLETE_CLASS__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.COMPLETE_CLASS__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.COMPLETE_CLASS__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.COMPLETE_CLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE:
				setOwningCompletePackage((CompletePackage)null);
				return;
			case PivotPackage.COMPLETE_CLASS__PARTIAL_CLASSES:
				getPartialClasses().clear();
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
			case PivotPackage.COMPLETE_CLASS__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.COMPLETE_CLASS__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.COMPLETE_CLASS__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.COMPLETE_CLASS__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.COMPLETE_CLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE:
				return getOwningCompletePackage() != null;
			case PivotPackage.COMPLETE_CLASS__PARTIAL_CLASSES:
				return partialClasses != null && !partialClasses.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * The cached value of the '{@link #getPartialClasses() <em>Partial Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartialClasses()
	 * @generated NOT
	 * @ordered
	 */
	protected final @NonNull PartialClasses partialClasses;

	protected CompleteClassImpl()
	{
		super();
		partialClasses = new PartialClasses(this);
	}
	
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCompleteClass(this);
	}

	@Override
	public void addClass(@NonNull org.eclipse.ocl.pivot.Class partialClass) {
		partialClasses.add(partialClass);
	}

	@Override
	public boolean conformsTo(@NonNull DomainType elementType) {
		DomainStandardLibrary standardLibrary = getStandardLibrary();
		DomainInheritance thisInheritance = getCompleteInheritance();
		DomainInheritance thatInheritance = elementType.getInheritance(standardLibrary);
		if (thisInheritance == thatInheritance) {
			return true;
		}
		return thatInheritance.isSuperInheritanceOf(thisInheritance);
	}

	@Override
	public boolean conformsTo(@NonNull CompleteClass thatCompleteClass) {
		DomainInheritance thisInheritance = getCompleteInheritance();
		DomainInheritance thatInheritance = thatCompleteClass.getCompleteInheritance();
		if (thisInheritance == thatInheritance) {
			return true;
		}
		return thatInheritance.isSuperInheritanceOf(thisInheritance);
	}

	/**
	 * Eliminate a partialClass from a CompleteClass returning true if the CompleteClass is empty.
	 */
	@Override
	public void didAddClass(@NonNull org.eclipse.ocl.pivot.Class partialClass) {
		partialClasses.add(partialClass);
	}

	/**
	 * Eliminate a partialClass from a CompleteClass returning true if the CompleteClass is empty.
	 */
	@Override
	public boolean didRemoveClass(@NonNull org.eclipse.ocl.pivot.Class partialClass) {
		partialClasses.remove(partialClass);
		return partialClasses.size() <= 0;		// FIXME Need to invalidate all derived inheritances
	}

	@Override
	public void dispose() {
		partialClasses.dispose();
	}

	@Override
	public @Nullable CollectionType findCollectionType(@NonNull CollectionTypeParameters<Type> typeParameters) {
		return null;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getBehavioralClass() {
		for (org.eclipse.ocl.pivot.Class partialClass : partialClasses) {
			if (partialClass != null) {
				if (partialClass instanceof DataType) {
					org.eclipse.ocl.pivot.Class behavioralClass = ((DataType)partialClass).getBehavioralClass();
					if (behavioralClass != null) {
						return behavioralClass;
					}
				}
				return partialClass;
			}
		}
		throw new IllegalStateException();
	}

	@Override
	public @NonNull CollectionType getCollectionType(@NonNull CollectionTypeParameters<Type> typeParameters) {
		throw new UnsupportedOperationException("Not a collection");
	}

	@Override
	public final @NonNull CompleteInheritanceImpl getCompleteInheritance() {
		return partialClasses.getCompleteInheritance();
	}

	@Override
	public @NonNull CompleteModelInternal getCompleteModel() {
		return getOwningCompletePackage().getCompleteModel();
	}
	
	public @NonNull Iterable<DomainOperation> getMemberOperations() {
		return partialClasses.getOperations();
	}

	@Override
	public @NonNull MetaModelManager getMetaModelManager() {
		return getCompleteModel().getMetaModelManager();
	}

	@Override
	public @Nullable DomainOperation getOperation(@NonNull OperationId operationId) {
		return partialClasses.getOperation(operationId);
	}

	@Override
	public @Nullable DomainOperation getOperation(@NonNull DomainOperation operationId) {
		return partialClasses.getOperation(operationId);
	}

	@Override
	public @Nullable Iterable<DomainOperation> getOperationOverloads(@NonNull DomainOperation pivotOperation) {
		return partialClasses.getOperationOverloads(pivotOperation);
	}

	@Override
	public @NonNull Iterable<? extends DomainOperation> getOperations(final @Nullable FeatureFilter featureFilter) {
		return partialClasses.getOperations(featureFilter);
	}

	@Override
	public @NonNull Iterable<? extends DomainOperation> getOperations(final @Nullable FeatureFilter featureFilter, @Nullable String name) {
		return partialClasses.getOperationOverloads(featureFilter, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull PartialClasses getPartialClasses() {
		return partialClasses;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getPivotClass() {
		for (org.eclipse.ocl.pivot.Class partialClass : partialClasses) {
			if (partialClass != null) {
				return partialClass;
			}
		}
		throw new IllegalStateException();
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull Iterable<? extends DomainClass> getProperSuperClasses() {
		DomainInheritance inheritance = getCompleteInheritance();
		return Iterables.transform(inheritance.getAllProperSuperFragments(), new Function<DomainFragment, DomainClass>()
		{
			@Override
			public DomainClass apply(DomainFragment input) {
				return input.getBaseInheritance().getType();
			}
		});
	}
	
	@Override
	@SuppressWarnings("null")
	public @NonNull Iterable<CompleteClass> getProperSuperCompleteClasses() {
		DomainInheritance inheritance = getCompleteInheritance();
		return Iterables.transform(inheritance.getAllProperSuperFragments(), new Function<DomainFragment, CompleteClass>()
		{
			@Override
			public CompleteClass apply(DomainFragment input) {
				return ((CompleteInheritanceImpl)input.getBaseInheritance()).getCompleteClass();		// FIXME cast
			}
		});
	}

	@Override
	public @Nullable Iterable<DomainProperty> getProperties(@NonNull DomainProperty pivotProperty) {
		return partialClasses.getProperties(pivotProperty);
	}

	@Override
	public @NonNull Iterable<? extends DomainProperty> getProperties(final @Nullable FeatureFilter featureFilter) {
		return partialClasses.getProperties(featureFilter);
	}

	@Override
	public @NonNull Iterable<? extends DomainProperty> getProperties(final @Nullable FeatureFilter featureFilter, @Nullable String name) {
		return partialClasses.getProperties(featureFilter, name);
	}

	@Override
	public @Nullable Iterable<DomainProperty> getProperties(@Nullable String propertyName) {
		return partialClasses.getProperties(propertyName);
	}

	@Override
	public @Nullable DomainProperty getProperty(@Nullable String propertyName) {
		return partialClasses.getProperty(propertyName);
	}

	public @NonNull PivotStandardLibrary getStandardLibrary() {
		return getCompleteModel().getStandardLibrary();
	}

	@Override
	public @NonNull Iterable<? extends State> getStates() {
		return partialClasses.getStates();
	}

	@Override
	public @NonNull Iterable<? extends State> getStates(@Nullable String name) {
		return partialClasses.getStates(name);
	}
	
	@Override
	public @NonNull Iterable<CompleteClass> getSuperCompleteClasses() {
		return partialClasses.getSuperCompleteClasses();
	}
	
/*	public boolean isSuperClassOf(@NonNull CompleteClass unspecializedFirstType, @NonNull CompleteClass secondType) {
		CompleteClass unspecializedSecondType = getCompleteClass(PivotUtil.getUnspecializedTemplateableElement(secondType.getPivotClass()));	// FIXME cast
		if (unspecializedFirstType == unspecializedSecondType) {
			return true;
		}
		for (CompleteClass superClass : getSuperCompleteClasses(unspecializedSecondType)) {
			if ((superClass != null) && isSuperClassOf(unspecializedFirstType, superClass)) {
				return true;
			}
		}
		return false;
	} */

	@Override
	public void uninstall() {
		partialClasses.dispose();
	}
} //CompleteClassImpl
