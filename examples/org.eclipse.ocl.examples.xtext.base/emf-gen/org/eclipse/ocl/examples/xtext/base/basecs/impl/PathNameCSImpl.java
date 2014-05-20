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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Element Ref CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PathNameCSImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PathNameCSImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PathNameCSImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PathNameCSImpl#getScopeFilter <em>Scope Filter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PathNameCSImpl extends ElementCSImpl implements PathNameCS
{
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected EList<PathElementCS> path;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected ElementCS context;

	/**
	 * This is true if the Context reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean contextESet;

	/**
	 * The default value of the '{@link #getScopeFilter() <em>Scope Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopeFilter()
	 * @generated
	 * @ordered
	 */
	protected static final ScopeFilter SCOPE_FILTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScopeFilter() <em>Scope Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopeFilter()
	 * @generated
	 * @ordered
	 */
	protected ScopeFilter scopeFilter = SCOPE_FILTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathNameCSImpl()
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
		return BaseCSPackage.Literals.PATH_NAME_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PathElementCS> getPath()
	{
		if (path == null)
		{
			path = new EObjectContainmentWithInverseEList<PathElementCS>(PathElementCS.class, this, BaseCSPackage.PATH_NAME_CS__PATH, BaseCSPackage.PATH_ELEMENT_CS__PATH_NAME);
		}
		return path;
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
			case BaseCSPackage.PATH_NAME_CS__PATH:
				return ((InternalEList<?>)getPath()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case BaseCSPackage.PATH_NAME_CS__PATH:
				return getPath();
			case BaseCSPackage.PATH_NAME_CS__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
			case BaseCSPackage.PATH_NAME_CS__CONTEXT:
				return getContext();
			case BaseCSPackage.PATH_NAME_CS__SCOPE_FILTER:
				return getScopeFilter();
		}
		return super.eGet(featureID, resolve, coreType);
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
			case BaseCSPackage.PATH_NAME_CS__PATH:
				getPath().clear();
				getPath().addAll((Collection<? extends PathElementCS>)newValue);
				return;
			case BaseCSPackage.PATH_NAME_CS__CONTEXT:
				setContext((ElementCS)newValue);
				return;
			case BaseCSPackage.PATH_NAME_CS__SCOPE_FILTER:
				setScopeFilter((ScopeFilter)newValue);
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
			case BaseCSPackage.PATH_NAME_CS__PATH:
				getPath().clear();
				return;
			case BaseCSPackage.PATH_NAME_CS__CONTEXT:
				unsetContext();
				return;
			case BaseCSPackage.PATH_NAME_CS__SCOPE_FILTER:
				setScopeFilter(SCOPE_FILTER_EDEFAULT);
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
			case BaseCSPackage.PATH_NAME_CS__PATH:
				return path != null && !path.isEmpty();
			case BaseCSPackage.PATH_NAME_CS__ELEMENT:
				return basicGetElement() != null;
			case BaseCSPackage.PATH_NAME_CS__CONTEXT:
				return isSetContext();
			case BaseCSPackage.PATH_NAME_CS__SCOPE_FILTER:
				return SCOPE_FILTER_EDEFAULT == null ? scopeFilter != null : !SCOPE_FILTER_EDEFAULT.equals(scopeFilter);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitPathNameCS(this);
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
			case BaseCSPackage.PATH_NAME_CS__PATH:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPath()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementCS getContext()
	{
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(ElementCS newContext)
	{
		ElementCS oldContext = context;
		context = newContext;
		boolean oldContextESet = contextESet;
		contextESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.PATH_NAME_CS__CONTEXT, oldContext, context, !oldContextESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetContext()
	{
		ElementCS oldContext = context;
		boolean oldContextESet = contextESet;
		context = null;
		contextESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, BaseCSPackage.PATH_NAME_CS__CONTEXT, oldContext, null, oldContextESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetContext()
	{
		return contextESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeFilter getScopeFilter()
	{
		return scopeFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScopeFilter(ScopeFilter newScopeFilter)
	{
		ScopeFilter oldScopeFilter = scopeFilter;
		scopeFilter = newScopeFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.PATH_NAME_CS__SCOPE_FILTER, oldScopeFilter, scopeFilter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element basicGetElement()
	{
		if (path == null) {
			return null;
		}
		int iMax = path.size();
		if (iMax <= 0) {
			return null;
		}
		return path.get(iMax-1).basicGetElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element getElement()
	{
		if (path == null) {
			return null;
		}
		int iMax = path.size();
		if (iMax <= 0) {
			return null;
		}
		for (int i = 0; i < iMax-1; i++) {
			Element element = path.get(i).getElement();
			if (element == null) {
				return null;
			}
		}
		Element element = path.get(iMax-1).getElement();
		if (element == null) {
			return null;
		}
		if (element.eIsProxy()) {
			return null;
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
	public void resetPivot() {}
} //QualifiedElementRefCSImpl
