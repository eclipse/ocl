/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.basecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Named Element Ref CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PathElementCSImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PathElementCSImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PathElementCSImpl#getElementType <em>Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PathElementCSImpl extends ElementCSImpl implements PathElementCS
{
	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected Element element;

	/**
	 * The cached value of the '{@link #getElementType() <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
	protected EClassifier elementType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathElementCSImpl()
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
		return BaseCSPackage.Literals.PATH_ELEMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getPathName()
	{
		if (eContainerFeatureID() != BaseCSPackage.PATH_ELEMENT_CS__PATH_NAME) return null;
		return (PathNameCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPathName(PathNameCS newPathName, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newPathName, BaseCSPackage.PATH_ELEMENT_CS__PATH_NAME, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathName(PathNameCS newPathName)
	{
		if (newPathName != eInternalContainer() || (eContainerFeatureID() != BaseCSPackage.PATH_ELEMENT_CS__PATH_NAME && newPathName != null))
		{
			if (EcoreUtil.isAncestor(this, newPathName))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPathName != null)
				msgs = ((InternalEObject)newPathName).eInverseAdd(this, BaseCSPackage.PATH_NAME_CS__PATH, PathNameCS.class, msgs);
			msgs = basicSetPathName(newPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.PATH_ELEMENT_CS__PATH_NAME, newPathName, newPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getElementGen()
	{
		if (element != null && ((EObject)element).eIsProxy())
		{
			InternalEObject oldElement = (InternalEObject)element;
			element = (Element)eResolveProxy(oldElement);
			if (element != oldElement)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaseCSPackage.PATH_ELEMENT_CS__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetElement()
	{
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(Element newElement)
	{
		Element oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.PATH_ELEMENT_CS__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getElementType()
	{
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementType(EClassifier newElementType)
	{
		EClassifier oldElementType = elementType;
		elementType = newElementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.PATH_ELEMENT_CS__ELEMENT_TYPE, oldElementType, elementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case BaseCSPackage.PATH_ELEMENT_CS__PATH_NAME:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPathName((PathNameCS)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case BaseCSPackage.PATH_ELEMENT_CS__PATH_NAME:
				return basicSetPathName(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case BaseCSPackage.PATH_ELEMENT_CS__PATH_NAME:
				return eInternalContainer().eInverseRemove(this, BaseCSPackage.PATH_NAME_CS__PATH, PathNameCS.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case BaseCSPackage.PATH_ELEMENT_CS__PATH_NAME:
				return getPathName();
			case BaseCSPackage.PATH_ELEMENT_CS__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
			case BaseCSPackage.PATH_ELEMENT_CS__ELEMENT_TYPE:
				return getElementType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case BaseCSPackage.PATH_ELEMENT_CS__PATH_NAME:
				setPathName((PathNameCS)newValue);
				return;
			case BaseCSPackage.PATH_ELEMENT_CS__ELEMENT:
				setElement((Element)newValue);
				return;
			case BaseCSPackage.PATH_ELEMENT_CS__ELEMENT_TYPE:
				setElementType((EClassifier)newValue);
				return;
		}
		super.eSet(featureID, newValue);
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
			case BaseCSPackage.PATH_ELEMENT_CS__PATH_NAME:
				setPathName((PathNameCS)null);
				return;
			case BaseCSPackage.PATH_ELEMENT_CS__ELEMENT:
				setElement((Element)null);
				return;
			case BaseCSPackage.PATH_ELEMENT_CS__ELEMENT_TYPE:
				setElementType((EClassifier)null);
				return;
		}
		super.eUnset(featureID);
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
			case BaseCSPackage.PATH_ELEMENT_CS__PATH_NAME:
				return getPathName() != null;
			case BaseCSPackage.PATH_ELEMENT_CS__ELEMENT:
				return element != null;
			case BaseCSPackage.PATH_ELEMENT_CS__ELEMENT_TYPE:
				return elementType != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitPathElementCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element getElement()
	{
		Element element = getElementGen();
		if ((element == null) || ((EObject)element).eIsProxy())
		{
			MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(this);
			if (metaModelManager != null) {
				if (isType()) {
					element = metaModelManager.getOclInvalidType();
				}
			}
//			InternalEObject oldElement = (InternalEObject)element;
//			element = (NamedElement)eResolveProxy(oldElement);
//			if (element != oldElement)
//			{
//				if (eNotificationRequired())
//					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaseCSPackage.SIMPLE_NAMED_ELEMENT_REF_CS__ELEMENT, oldElement, element));
//			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element getPivot() {
		return getElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isType() {
		return elementType == PivotPackage.Literals.TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void resetPivot() {}
} //SimpleNamedElementRefCSImpl
