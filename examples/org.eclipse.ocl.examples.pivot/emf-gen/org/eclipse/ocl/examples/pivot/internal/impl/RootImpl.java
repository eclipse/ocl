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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Import;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.RootImpl#getExternalURI <em>External URI</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.RootImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.RootImpl#getNestedPackage <em>Nested Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootImpl extends NamespaceImpl implements Root
{

	/**
	 * The default value of the '{@link #getExternalURI() <em>External URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalURI()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTERNAL_URI_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getExternalURI() <em>External URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalURI()
	 * @generated
	 * @ordered
	 */
	protected String externalURI = EXTERNAL_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<Import> imports;
	/**
	 * The cached value of the '{@link #getNestedPackage() <em>Nested Package</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.examples.pivot.Package> nestedPackage;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootImpl()
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
		return PivotPackage.Literals.ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<org.eclipse.ocl.examples.pivot.Package> getNestedPackage()
	{
		if (nestedPackage == null)
		{
			nestedPackage = new EObjectContainmentEList<org.eclipse.ocl.examples.pivot.Package>(org.eclipse.ocl.examples.pivot.Package.class, this, PivotPackage.ROOT__NESTED_PACKAGE);
		}
		return nestedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExternalURI()
	{
		return externalURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternalURIGen(String newExternalURI)
	{
		String oldExternalURI = externalURI;
		externalURI = newExternalURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ROOT__EXTERNAL_URI, oldExternalURI, externalURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<Import> getImports()
	{
		if (imports == null)
		{
			imports = new EObjectContainmentEList<Import>(Import.class, this, PivotPackage.ROOT__IMPORTS);
		}
		return imports;
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
			case PivotPackage.ROOT__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.ROOT__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.ROOT__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.ROOT__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.ROOT__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case PivotPackage.ROOT__NESTED_PACKAGE:
				return ((InternalEList<?>)getNestedPackage()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.ROOT__EXTENSION:
				return getExtension();
			case PivotPackage.ROOT__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.ROOT__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.ROOT__IS_STATIC:
				return isStatic();
			case PivotPackage.ROOT__NAME:
				return getName();
			case PivotPackage.ROOT__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.ROOT__EXTERNAL_URI:
				return getExternalURI();
			case PivotPackage.ROOT__IMPORTS:
				return getImports();
			case PivotPackage.ROOT__NESTED_PACKAGE:
				return getNestedPackage();
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
			case PivotPackage.ROOT__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.ROOT__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.ROOT__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ROOT__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.ROOT__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ROOT__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.ROOT__EXTERNAL_URI:
				setExternalURI((String)newValue);
				return;
			case PivotPackage.ROOT__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends Import>)newValue);
				return;
			case PivotPackage.ROOT__NESTED_PACKAGE:
				getNestedPackage().clear();
				getNestedPackage().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
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
			case PivotPackage.ROOT__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.ROOT__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.ROOT__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.ROOT__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.ROOT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ROOT__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.ROOT__EXTERNAL_URI:
				setExternalURI(EXTERNAL_URI_EDEFAULT);
				return;
			case PivotPackage.ROOT__IMPORTS:
				getImports().clear();
				return;
			case PivotPackage.ROOT__NESTED_PACKAGE:
				getNestedPackage().clear();
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
			case PivotPackage.ROOT__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.ROOT__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.ROOT__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.ROOT__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.ROOT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ROOT__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.ROOT__EXTERNAL_URI:
				return EXTERNAL_URI_EDEFAULT == null ? externalURI != null : !EXTERNAL_URI_EDEFAULT.equals(externalURI);
			case PivotPackage.ROOT__IMPORTS:
				return imports != null && !imports.isEmpty();
			case PivotPackage.ROOT__NESTED_PACKAGE:
				return nestedPackage != null && !nestedPackage.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitRoot(this);
	}
	
	public void setExternalURI(String newExternalURI)
	{
		setExternalURIGen(newExternalURI);
		String newName;
		if (externalURI != null) {
			int lastIndex = externalURI.lastIndexOf("/");
			if (lastIndex > 0) {
				newName = externalURI.substring(lastIndex+1);
			}
			else {
				newName = externalURI;
			}
		}
		else {
			newName = null;
		}
		super.setName(newName);
	}

	@Override
	public void setName(String newName) {		// FIXME BUG 421716 remove Namedspace/NamedElement inheritance
		// name is a cached optimization of externalURI
	}
} //RootImpl
