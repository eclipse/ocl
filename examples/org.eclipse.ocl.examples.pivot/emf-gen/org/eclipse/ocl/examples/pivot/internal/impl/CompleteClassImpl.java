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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainFragment;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteClassImpl#getOwningCompletePackage <em>Owning Complete Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteClassImpl#getPartialClasses <em>Partial Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompleteClassImpl extends NamedElementImpl implements CompleteClass
{
	/**
	 * The cached value of the '{@link #getPartialClasses() <em>Partial Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartialClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.examples.pivot.Class> partialClasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteClassImpl()
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
		return PivotPackage.Literals.COMPLETE_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletePackage getOwningCompletePackage()
	{
		if (eContainerFeatureID() != PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE) return null;
		return (CompletePackage)eInternalContainer();
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
	@SuppressWarnings("cast")
	public void setOwningCompletePackage(CompletePackage newOwningCompletePackage)
	{
		if (newOwningCompletePackage != eInternalContainer() || (eContainerFeatureID() != PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE && newOwningCompletePackage != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newOwningCompletePackage))
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
				getPartialClasses().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
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

	protected /*@NonNull*/ TypeServer typeServer;
	
	private Set<CompleteClass> superCompleteClasses = null;
	
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCompleteClass(this);
	}

	public @NonNull Set<CompleteClass> computeSuperCompleteClasses() {
		Set<CompleteClass> superCompleteClasses2 = superCompleteClasses;
		if (superCompleteClasses2 == null) {
			MetaModelManager metaModelManager = DomainUtil.nonNullState(getOwningCompletePackage().getCompleteModel()).getMetaModelManager();
			superCompleteClasses2 = superCompleteClasses = new HashSet<CompleteClass>();
			for (org.eclipse.ocl.examples.pivot.Class partialClass : getPartialClasses()) {
				for (org.eclipse.ocl.examples.pivot.Class partialSuperClass : partialClass.getSuperClasses()) {
					if (partialSuperClass != null) {
						CompleteClass superCompleteClass = metaModelManager.getCompleteClass(PivotUtil.getUnspecializedTemplateableElement(partialSuperClass));
						superCompleteClasses2.add(superCompleteClass);
						superCompleteClasses2.addAll(((CompleteClassImpl) superCompleteClass).computeSuperCompleteClasses());
					}
				}
			}
		}
		return superCompleteClasses2;
	}

	protected void didAddPartialClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass) {
//		if (name2completeClass != null) {
//			doRefreshPartialClasses(partialPackage);
//		}
	}

	protected void didRemovePartialClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass) {
//		if (name2completeClass != null) {
//			doRefreshPartialClasses(partialPackage);
//		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("null")
	public @NonNull List<org.eclipse.ocl.examples.pivot.Class> getPartialClasses()
	{
		if (partialClasses == null)
		{
			partialClasses = new EObjectResolvingEList<org.eclipse.ocl.examples.pivot.Class>(org.eclipse.ocl.examples.pivot.Class.class, this, PivotPackage.COMPLETE_CLASS__PARTIAL_CLASSES)
			{
				private static final long serialVersionUID = 1L;

				@Override
				protected void didAdd(int index, org.eclipse.ocl.examples.pivot.Class partialClass) {
					assert partialClass != null;
					super.didAdd(index, partialClass);
					didAddPartialClass(partialClass);
				}

				@Override
				protected void didRemove(int index, org.eclipse.ocl.examples.pivot.Class partialClass) {
					assert partialClass != null;
					didRemovePartialClass(partialClass);
					super.didRemove(index, partialClass);
				}
			};
		}
		return partialClasses;
	}

	public org.eclipse.ocl.examples.pivot.Class getPivotClass() {
		for (org.eclipse.ocl.examples.pivot.Class partialClass : getPartialClasses()) {
//			if (partialPackage instanceof org.eclipse.ocl.examples.pivot.Package) {
				return partialClass;
//			}
		}
		return null;
	}
	
	@SuppressWarnings("null")
	public @NonNull Iterable<CompleteClass> getSuperCompleteClasses() {
////		if (type.getTemplateBinding().size() > 0) {		// FIXME need lazy specialization
////		pivotType = PivotUtil.getUnspecializedTemplateableElement(pivotType);
////		}
//		if (!libraryLoadInProgress && (asMetamodel == null) && (pivotType == getClassType()))  {
//			getASMetamodel();
//		}
//		return new CompleteClassSuperCompleteClassesIterable(getPartialClasses());
		DomainInheritance inheritance = getTypeServer();
//		final MetaModelManager metaModelManager = DomainUtil.nonNullState(getOwningCompletePackage().getCompleteModel()).getMetaModelManager();
		return Iterables.transform(inheritance.getAllProperSuperFragments(), new Function<DomainFragment, CompleteClass>()
		{
			public CompleteClass apply(DomainFragment input) {
				return ((TypeServer)input.getBaseInheritance()).getCompleteClass();
			}
		});
	}

	public @NonNull TypeServer getTypeServer() {
		return typeServer;
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

	public void setTypeServer(TypeServer typeServer) {
		this.typeServer = typeServer;
	}

	public void uninstall() {
		superCompleteClasses = null;
	}
	
/*	public class CompleteClassSuperCompleteClassesIterable
			extends CompleteElementIterable<CompleteClass, CompleteClass> {

		public CompleteClassSuperCompleteClassesIterable(@NonNull Iterable<CompleteClass> types) {
			super(types);
		}

		@Override
		protected @NonNull Iterable<CompleteClass> getInnerIterable(@NonNull CompleteClass model) {
			return DomainUtil.nonNullEMF(model.getSuperCompleteClasses());
		}
	} */
} //CompleteClassImpl
