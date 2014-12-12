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
package org.eclipse.ocl.pivot.internal.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.ids.IdManager;
import org.eclipse.ocl.domain.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExtension;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.TemplateParameterImpl#getConstrainingClass <em>Constraining Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.TemplateParameterImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.TemplateParameterImpl#getOwningTemplateSignature <em>Owning Template Signature</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.TemplateParameterImpl#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateParameterImpl
		extends TypeImpl
		implements TemplateParameter {

	/**
	 * The cached value of the '{@link #getConstrainingClass() <em>Constraining Class</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainingClass()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.pivot.Class> constrainingClass;

	/**
	 * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected Type lowerBound;

	/**
	 * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected Type upperBound;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TEMPLATE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<org.eclipse.ocl.pivot.Class> getConstrainingClass()
	{
		if (constrainingClass == null)
		{
			constrainingClass = new EObjectResolvingEList<org.eclipse.ocl.pivot.Class>(org.eclipse.ocl.pivot.Class.class, this, PivotPackage.TEMPLATE_PARAMETER__CONSTRAINING_CLASS);
		}
		return constrainingClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getLowerBound()
	{
		if (lowerBound != null && lowerBound.eIsProxy())
		{
			InternalEObject oldLowerBound = (InternalEObject)lowerBound;
			lowerBound = (Type)eResolveProxy(oldLowerBound);
			if (lowerBound != oldLowerBound)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.TEMPLATE_PARAMETER__LOWER_BOUND, oldLowerBound, lowerBound));
			}
		}
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetLowerBound()
	{
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLowerBound(Type newLowerBound)
	{
		Type oldLowerBound = lowerBound;
		lowerBound = newLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TEMPLATE_PARAMETER__LOWER_BOUND, oldLowerBound, lowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateSignature getOwningTemplateSignature() {
		if (eContainerFeatureID() != PivotPackage.TEMPLATE_PARAMETER__OWNING_TEMPLATE_SIGNATURE) return null;
		return (TemplateSignature)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTemplateSignature(TemplateSignature newOwningTemplateSignature, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningTemplateSignature, PivotPackage.TEMPLATE_PARAMETER__OWNING_TEMPLATE_SIGNATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTemplateSignature(TemplateSignature newOwningTemplateSignature) {
		if (newOwningTemplateSignature != eInternalContainer() || (eContainerFeatureID() != PivotPackage.TEMPLATE_PARAMETER__OWNING_TEMPLATE_SIGNATURE && newOwningTemplateSignature != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningTemplateSignature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTemplateSignature != null)
				msgs = ((InternalEObject)newOwningTemplateSignature).eInverseAdd(this, PivotPackage.TEMPLATE_SIGNATURE__OWNED_TEMPLATE_PARAMETERS, TemplateSignature.class, msgs);
			msgs = basicSetOwningTemplateSignature(newOwningTemplateSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TEMPLATE_PARAMETER__OWNING_TEMPLATE_SIGNATURE, newOwningTemplateSignature, newOwningTemplateSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getUpperBound()
	{
		if (upperBound != null && upperBound.eIsProxy())
		{
			InternalEObject oldUpperBound = (InternalEObject)upperBound;
			upperBound = (Type)eResolveProxy(oldUpperBound);
			if (upperBound != oldUpperBound)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.TEMPLATE_PARAMETER__UPPER_BOUND, oldUpperBound, upperBound));
			}
		}
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetUpperBound()
	{
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUpperBound(Type newUpperBound)
	{
		Type oldUpperBound = upperBound;
		upperBound = newUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TEMPLATE_PARAMETER__UPPER_BOUND, oldUpperBound, upperBound));
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
			case PivotPackage.TEMPLATE_PARAMETER__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.TEMPLATE_PARAMETER__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.TEMPLATE_PARAMETER__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.TEMPLATE_PARAMETER__EXTENDED_BYS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtendedBys()).basicAdd(otherEnd, msgs);
			case PivotPackage.TEMPLATE_PARAMETER__OWNING_TEMPLATE_SIGNATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateSignature((TemplateSignature)otherEnd, msgs);
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
			case PivotPackage.TEMPLATE_PARAMETER__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_PARAMETER__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_PARAMETER__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_PARAMETER__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_PARAMETER__EXTENDED_BYS:
				return ((InternalEList<?>)getExtendedBys()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_PARAMETER__OWNING_TEMPLATE_SIGNATURE:
				return basicSetOwningTemplateSignature(null, msgs);
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
			case PivotPackage.TEMPLATE_PARAMETER__OWNING_TEMPLATE_SIGNATURE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.TEMPLATE_SIGNATURE__OWNED_TEMPLATE_PARAMETERS, TemplateSignature.class, msgs);
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
			case PivotPackage.TEMPLATE_PARAMETER__COMMENT:
				return getComment();
			case PivotPackage.TEMPLATE_PARAMETER__EXTENSION:
				return getExtension();
			case PivotPackage.TEMPLATE_PARAMETER__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.TEMPLATE_PARAMETER__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.TEMPLATE_PARAMETER__NAME:
				return getName();
			case PivotPackage.TEMPLATE_PARAMETER__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.TEMPLATE_PARAMETER__CONSTRAINING_CLASS:
				return getConstrainingClass();
			case PivotPackage.TEMPLATE_PARAMETER__LOWER_BOUND:
				if (resolve) return getLowerBound();
				return basicGetLowerBound();
			case PivotPackage.TEMPLATE_PARAMETER__OWNING_TEMPLATE_SIGNATURE:
				return getOwningTemplateSignature();
			case PivotPackage.TEMPLATE_PARAMETER__UPPER_BOUND:
				if (resolve) return getUpperBound();
				return basicGetUpperBound();
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
			case PivotPackage.TEMPLATE_PARAMETER__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TEMPLATE_PARAMETER__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.TEMPLATE_PARAMETER__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.TEMPLATE_PARAMETER__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TEMPLATE_PARAMETER__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.TEMPLATE_PARAMETER__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.TEMPLATE_PARAMETER__CONSTRAINING_CLASS:
				getConstrainingClass().clear();
				getConstrainingClass().addAll((Collection<? extends org.eclipse.ocl.pivot.Class>)newValue);
				return;
			case PivotPackage.TEMPLATE_PARAMETER__LOWER_BOUND:
				setLowerBound((Type)newValue);
				return;
			case PivotPackage.TEMPLATE_PARAMETER__OWNING_TEMPLATE_SIGNATURE:
				setOwningTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.TEMPLATE_PARAMETER__UPPER_BOUND:
				setUpperBound((Type)newValue);
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
			case PivotPackage.TEMPLATE_PARAMETER__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.TEMPLATE_PARAMETER__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.TEMPLATE_PARAMETER__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.TEMPLATE_PARAMETER__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.TEMPLATE_PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.TEMPLATE_PARAMETER__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.TEMPLATE_PARAMETER__CONSTRAINING_CLASS:
				getConstrainingClass().clear();
				return;
			case PivotPackage.TEMPLATE_PARAMETER__LOWER_BOUND:
				setLowerBound((Type)null);
				return;
			case PivotPackage.TEMPLATE_PARAMETER__OWNING_TEMPLATE_SIGNATURE:
				setOwningTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.TEMPLATE_PARAMETER__UPPER_BOUND:
				setUpperBound((Type)null);
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
			case PivotPackage.TEMPLATE_PARAMETER__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.TEMPLATE_PARAMETER__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.TEMPLATE_PARAMETER__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.TEMPLATE_PARAMETER__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.TEMPLATE_PARAMETER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.TEMPLATE_PARAMETER__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.TEMPLATE_PARAMETER__CONSTRAINING_CLASS:
				return constrainingClass != null && !constrainingClass.isEmpty();
			case PivotPackage.TEMPLATE_PARAMETER__LOWER_BOUND:
				return lowerBound != null;
			case PivotPackage.TEMPLATE_PARAMETER__OWNING_TEMPLATE_SIGNATURE:
				return getOwningTemplateSignature() != null;
			case PivotPackage.TEMPLATE_PARAMETER__UPPER_BOUND:
				return upperBound != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitTemplateParameter(this);
	}
	
	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull Type type) {
		CompleteInheritance thisInheritance = standardLibrary.getOclAnyType().getInheritance(standardLibrary);
		CompleteInheritance thatInheritance = type.getInheritance(standardLibrary);
		return thisInheritance.isSubInheritanceOf(thatInheritance);
	}

	@Override
	public @NonNull CompleteInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		return standardLibrary.getInheritance(standardLibrary.getOclAnyType());		// FIXME loaer bound
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getNormalizedType(@NonNull DomainStandardLibrary standardLibrary) {
		try {
			return getInheritance(standardLibrary).getType();
		}
		catch (Throwable e) {
			return standardLibrary.getOclAnyType();			// WIP FIXME should never happen
		}
	}

	private /*@LazyNonNull*/ TemplateParameterId templateParameterId;
	
	@Override
	public @NonNull TemplateParameterId getTemplateParameterId() {
		TemplateParameterId templateParameterId2 = templateParameterId;
		if (templateParameterId2 == null) {
			synchronized (this) {
				templateParameterId2 = templateParameterId;
				if (templateParameterId2 == null) {
					int index = 0;
					TemplateSignature templateSignature1 = getOwningTemplateSignature();
					if (templateSignature1 != null) {
						index = templateSignature1.getOwnedTemplateParameters().indexOf(this);
						TemplateableElement template = templateSignature1.getOwningTemplateableElement();
						if (template != null) {
							for (EObject eContainer = template.eContainer(); eContainer != null; eContainer = eContainer.eContainer()) {
								if (eContainer instanceof TemplateableElement) {
									TemplateableElement eObject = PivotUtil.getUnspecializedTemplateableElement((TemplateableElement)eContainer);
									TemplateSignature templateSignature2 = eObject.getOwnedTemplateSignature();
									if (templateSignature2 != null) {
										index += templateSignature2.getOwnedTemplateParameters().size();
									}
								}
							}
						}
					}
					templateParameterId = templateParameterId2 = IdManager.getTemplateParameterId(index);
				}
			}
		}
		return templateParameterId2;
	}

	@Override
	public @NonNull TemplateParameterId getTypeId() {
		return getTemplateParameterId();
	}
	
	@Override
	public @Nullable org.eclipse.ocl.pivot.Class isClass() {
		return null;
	}

	@Override
	public @NonNull TemplateParameter isTemplateParameter() {
		return this;
	}

	@Override
	public Type specializeIn(@NonNull CallExp expr, @Nullable Type selfType) {
		Resource eResource = ((EObject) expr).eResource();
		if ((eResource != null) && (selfType != null)) {
			MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(eResource);
			return metaModelManager.specializeType(this, expr, selfType, null);
		}
		return null;
	}
} //TemplateParameterImpl
