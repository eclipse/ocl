/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootCS;
import org.eclipse.ocl.examples.xtext.base.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.IncludeCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.util.CompleteOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl#getOwnedImport <em>Owned Import</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl#getOwnedLibrary <em>Owned Library</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl#getContexts <em>Contexts</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl#getOwnedInclude <em>Owned Include</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompleteOCLDocumentCSImpl
		extends NamedElementCSImpl
		implements CompleteOCLDocumentCS {

	/**
	 * The cached value of the '{@link #getOwnedImport() <em>Owned Import</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedImport()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportCS> ownedImport;

	/**
	 * The cached value of the '{@link #getOwnedLibrary() <em>Owned Library</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLibrary()
	 * @generated
	 * @ordered
	 */
	protected EList<LibraryCS> ownedLibrary;

	/**
	 * The cached value of the '{@link #getPackages() <em>Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageDeclarationCS> packages;

	/**
	 * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<ContextDeclCS> contexts;

	/**
	 * The cached value of the '{@link #getOwnedInclude() <em>Owned Include</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInclude()
	 * @generated
	 * @ordered
	 */
	protected EList<IncludeCS> ownedInclude;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteOCLDocumentCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSPackage.Literals.COMPLETE_OCL_DOCUMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImportCS> getOwnedImport()
	{
		if (ownedImport == null)
		{
			ownedImport = new EObjectContainmentEList<ImportCS>(ImportCS.class, this, CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORT);
		}
		return ownedImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LibraryCS> getOwnedLibrary()
	{
		if (ownedLibrary == null)
		{
			ownedLibrary = new EObjectContainmentEList<LibraryCS>(LibraryCS.class, this, CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARY);
		}
		return ownedLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageDeclarationCS> getPackages() {
		if (packages == null)
		{
			packages = new EObjectContainmentEList<PackageDeclarationCS>(PackageDeclarationCS.class, this, CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__PACKAGES);
		}
		return packages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContextDeclCS> getContexts() {
		if (contexts == null)
		{
			contexts = new EObjectContainmentEList<ContextDeclCS>(ContextDeclCS.class, this, CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__CONTEXTS);
		}
		return contexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IncludeCS> getOwnedInclude() {
		if (ownedInclude == null)
		{
			ownedInclude = new EObjectContainmentEList<IncludeCS>(IncludeCS.class, this, CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDE);
		}
		return ownedInclude;
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
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORT:
				return ((InternalEList<?>)getOwnedImport()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARY:
				return ((InternalEList<?>)getOwnedLibrary()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__PACKAGES:
				return ((InternalEList<?>)getPackages()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__CONTEXTS:
				return ((InternalEList<?>)getContexts()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDE:
				return ((InternalEList<?>)getOwnedInclude()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORT:
				return getOwnedImport();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARY:
				return getOwnedLibrary();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__PACKAGES:
				return getPackages();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__CONTEXTS:
				return getContexts();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDE:
				return getOwnedInclude();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORT:
				getOwnedImport().clear();
				getOwnedImport().addAll((Collection<? extends ImportCS>)newValue);
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARY:
				getOwnedLibrary().clear();
				getOwnedLibrary().addAll((Collection<? extends LibraryCS>)newValue);
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__PACKAGES:
				getPackages().clear();
				getPackages().addAll((Collection<? extends PackageDeclarationCS>)newValue);
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__CONTEXTS:
				getContexts().clear();
				getContexts().addAll((Collection<? extends ContextDeclCS>)newValue);
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDE:
				getOwnedInclude().clear();
				getOwnedInclude().addAll((Collection<? extends IncludeCS>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORT:
				getOwnedImport().clear();
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARY:
				getOwnedLibrary().clear();
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__PACKAGES:
				getPackages().clear();
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__CONTEXTS:
				getContexts().clear();
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDE:
				getOwnedInclude().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORT:
				return ownedImport != null && !ownedImport.isEmpty();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARY:
				return ownedLibrary != null && !ownedLibrary.isEmpty();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__PACKAGES:
				return packages != null && !packages.isEmpty();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__CONTEXTS:
				return contexts != null && !contexts.isEmpty();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDE:
				return ownedInclude != null && !ownedInclude.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == RootCS.class)
		{
			switch (derivedFeatureID)
			{
				case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORT: return BaseCSPackage.ROOT_CS__OWNED_IMPORT;
				case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARY: return BaseCSPackage.ROOT_CS__OWNED_LIBRARY;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == RootCS.class)
		{
			switch (baseFeatureID)
			{
				case BaseCSPackage.ROOT_CS__OWNED_IMPORT: return CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORT;
				case BaseCSPackage.ROOT_CS__OWNED_LIBRARY: return CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((CompleteOCLCSVisitor<?>)visitor).visitCompleteOCLDocumentCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Overridden to ensure that librarty and import declarations preceed other content.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<EObject> eContents() {
		EList<EObject> result = eProperties().getEContents();
		if (result == null) {
			result = CS2Pivot.computeRootContainmentFeatures(this);
			eBasicProperties().setEContents(result);
		}
		return result;
	}
} //DocumentCSImpl
