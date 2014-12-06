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
package org.eclipse.ocl.pivot.internal.impl;

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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.complete.ModelListeners;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.ModelImpl#getExternalURI <em>External URI</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.ModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.ModelImpl#getOwnedPackages <em>Owned Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends NamespaceImpl implements Model
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
	 * The cached value of the '{@link #getOwnedPackages() <em>Owned Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.pivot.Package> ownedPackages;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl()
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
		return PivotPackage.Literals.MODEL;
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Package> getOwnedPackages()
	{
		EList<org.eclipse.ocl.pivot.Package> ownedPackages2 = ownedPackages;
		if (ownedPackages2 == null)
		{
			ownedPackages = ownedPackages2 = new EObjectContainmentEList<org.eclipse.ocl.pivot.Package>(org.eclipse.ocl.pivot.Package.class, this, PivotPackage.MODEL__OWNED_PACKAGES)
			{
				private static final long serialVersionUID = 1L;
	
				@Override
				public void didAdd(int index, org.eclipse.ocl.pivot.Package partialPackage) {
					assert partialPackage != null;
					didAddPackage(partialPackage);
				}
	
				@Override
				protected void didRemove(int index, org.eclipse.ocl.pivot.Package partialPackage) {
					assert partialPackage != null;
					didRemovePackage(partialPackage);
				}
			};
		}
		return ownedPackages2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.MODEL__EXTERNAL_URI, oldExternalURI, externalURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<Import> getImports()
	{
		if (imports == null)
		{
			imports = new EObjectContainmentEList<Import>(Import.class, this, PivotPackage.MODEL__IMPORTS);
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
			case PivotPackage.MODEL__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.MODEL__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.MODEL__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.MODEL__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.MODEL__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.MODEL__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case PivotPackage.MODEL__OWNED_PACKAGES:
				return ((InternalEList<?>)getOwnedPackages()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.MODEL__COMMENT:
				return getComment();
			case PivotPackage.MODEL__EXTENSION:
				return getExtension();
			case PivotPackage.MODEL__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.MODEL__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.MODEL__NAME:
				return getName();
			case PivotPackage.MODEL__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.MODEL__EXTERNAL_URI:
				return getExternalURI();
			case PivotPackage.MODEL__IMPORTS:
				return getImports();
			case PivotPackage.MODEL__OWNED_PACKAGES:
				return getOwnedPackages();
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
			case PivotPackage.MODEL__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.MODEL__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.MODEL__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.MODEL__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.MODEL__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.MODEL__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.MODEL__EXTERNAL_URI:
				setExternalURI((String)newValue);
				return;
			case PivotPackage.MODEL__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends Import>)newValue);
				return;
			case PivotPackage.MODEL__OWNED_PACKAGES:
				getOwnedPackages().clear();
				getOwnedPackages().addAll((Collection<? extends org.eclipse.ocl.pivot.Package>)newValue);
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
			case PivotPackage.MODEL__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.MODEL__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.MODEL__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.MODEL__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.MODEL__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.MODEL__EXTERNAL_URI:
				setExternalURI(EXTERNAL_URI_EDEFAULT);
				return;
			case PivotPackage.MODEL__IMPORTS:
				getImports().clear();
				return;
			case PivotPackage.MODEL__OWNED_PACKAGES:
				getOwnedPackages().clear();
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
			case PivotPackage.MODEL__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.MODEL__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.MODEL__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.MODEL__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.MODEL__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.MODEL__EXTERNAL_URI:
				return EXTERNAL_URI_EDEFAULT == null ? externalURI != null : !EXTERNAL_URI_EDEFAULT.equals(externalURI);
			case PivotPackage.MODEL__IMPORTS:
				return imports != null && !imports.isEmpty();
			case PivotPackage.MODEL__OWNED_PACKAGES:
				return ownedPackages != null && !ownedPackages.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}
	
	private @Nullable ModelListeners<ModelListeners.IModelListener> rootListeners = null;

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitModel(this);
	}

	public synchronized void addRootListener(@NonNull ModelListeners.IModelListener rootListener) {
		ModelListeners<ModelListeners.IModelListener> rootListeners2 = rootListeners;
		if (rootListeners2 == null) {
			rootListeners2 = rootListeners = new ModelListeners<ModelListeners.IModelListener>();
		}
		rootListeners2.addListener(rootListener);
	}

	protected void didAddPackage(@NonNull org.eclipse.ocl.pivot.Package partialPackage) {
		if (rootListeners != null) {
			rootListeners.didAddPackage(partialPackage);
		}
	}

	protected void didRemovePackage(@NonNull org.eclipse.ocl.pivot.Package partialPackage) {
		if (rootListeners != null) {
			rootListeners.didRemovePackage(partialPackage);
		}
	}

	public synchronized void removeRootListener(@NonNull ModelListeners.IModelListener rootListener) {
		ModelListeners<ModelListeners.IModelListener> rootListeners2 = rootListeners;
		if ((rootListeners2 != null) && rootListeners2.removeListener(rootListener)) {
			rootListeners = null;
		}
	}
	
	@Override
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

	@Override
	public String toString() {
		return super.toString();
	}
} //RootImpl
