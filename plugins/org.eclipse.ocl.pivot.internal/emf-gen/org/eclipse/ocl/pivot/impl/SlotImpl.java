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
package org.eclipse.ocl.pivot.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.InstanceSpecification;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Slot;
import org.eclipse.ocl.pivot.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.impl.SlotImpl#getDefiningProperty <em>Defining Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.SlotImpl#getOwningInstance <em>Owning Instance</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.SlotImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SlotImpl extends ElementImpl implements Slot
{
	/**
	 * The cached value of the '{@link #getDefiningProperty() <em>Defining Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefiningProperty()
	 * @generated
	 * @ordered
	 */
	protected Property definingProperty;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueSpecification> values;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SlotImpl()
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
		return PivotPackage.Literals.SLOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getDefiningProperty()
	{
		if (definingProperty != null && definingProperty.eIsProxy())
		{
			InternalEObject oldDefiningProperty = (InternalEObject)definingProperty;
			definingProperty = (Property)eResolveProxy(oldDefiningProperty);
			if (definingProperty != oldDefiningProperty)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.SLOT__DEFINING_PROPERTY, oldDefiningProperty, definingProperty));
			}
		}
		return definingProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetDefiningProperty()
	{
		return definingProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefiningProperty(Property newDefiningProperty)
	{
		Property oldDefiningProperty = definingProperty;
		definingProperty = newDefiningProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.SLOT__DEFINING_PROPERTY, oldDefiningProperty, definingProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstanceSpecification getOwningInstance()
	{
		if (eContainerFeatureID() != PivotPackage.SLOT__OWNING_INSTANCE) return null;
		return (InstanceSpecification)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningInstance(InstanceSpecification newOwningInstance, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningInstance, PivotPackage.SLOT__OWNING_INSTANCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningInstance(InstanceSpecification newOwningInstance)
	{
		if (newOwningInstance != eInternalContainer() || (eContainerFeatureID() != PivotPackage.SLOT__OWNING_INSTANCE && newOwningInstance != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningInstance))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningInstance != null)
				msgs = ((InternalEObject)newOwningInstance).eInverseAdd(this, PivotPackage.INSTANCE_SPECIFICATION__SLOTS, InstanceSpecification.class, msgs);
			msgs = basicSetOwningInstance(newOwningInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.SLOT__OWNING_INSTANCE, newOwningInstance, newOwningInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ValueSpecification> getValues()
	{
		if (values == null)
		{
			values = new EObjectContainmentEList<ValueSpecification>(ValueSpecification.class, this, PivotPackage.SLOT__VALUES);
		}
		return values;
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
			case PivotPackage.SLOT__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.SLOT__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.SLOT__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.SLOT__OWNING_INSTANCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningInstance((InstanceSpecification)otherEnd, msgs);
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
			case PivotPackage.SLOT__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.SLOT__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.SLOT__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.SLOT__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.SLOT__OWNING_INSTANCE:
				return basicSetOwningInstance(null, msgs);
			case PivotPackage.SLOT__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.SLOT__OWNING_INSTANCE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.INSTANCE_SPECIFICATION__SLOTS, InstanceSpecification.class, msgs);
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
			case PivotPackage.SLOT__COMMENT:
				return getComment();
			case PivotPackage.SLOT__EXTENSION:
				return getExtension();
			case PivotPackage.SLOT__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.SLOT__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.SLOT__DEFINING_PROPERTY:
				if (resolve) return getDefiningProperty();
				return basicGetDefiningProperty();
			case PivotPackage.SLOT__OWNING_INSTANCE:
				return getOwningInstance();
			case PivotPackage.SLOT__VALUES:
				return getValues();
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
			case PivotPackage.SLOT__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.SLOT__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.SLOT__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.SLOT__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.SLOT__DEFINING_PROPERTY:
				setDefiningProperty((Property)newValue);
				return;
			case PivotPackage.SLOT__OWNING_INSTANCE:
				setOwningInstance((InstanceSpecification)newValue);
				return;
			case PivotPackage.SLOT__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends ValueSpecification>)newValue);
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
			case PivotPackage.SLOT__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.SLOT__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.SLOT__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.SLOT__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.SLOT__DEFINING_PROPERTY:
				setDefiningProperty((Property)null);
				return;
			case PivotPackage.SLOT__OWNING_INSTANCE:
				setOwningInstance((InstanceSpecification)null);
				return;
			case PivotPackage.SLOT__VALUES:
				getValues().clear();
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
			case PivotPackage.SLOT__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.SLOT__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.SLOT__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.SLOT__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.SLOT__DEFINING_PROPERTY:
				return definingProperty != null;
			case PivotPackage.SLOT__OWNING_INSTANCE:
				return getOwningInstance() != null;
			case PivotPackage.SLOT__VALUES:
				return values != null && !values.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

} //SlotImpl
