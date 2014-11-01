/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
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
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2AS;
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
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl#getOwnedImports <em>Owned Imports</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl#getOwnedLibraries <em>Owned Libraries</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl#getOwnedPackages <em>Owned Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl#getOwnedContexts <em>Owned Contexts</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl#getOwnedIncludes <em>Owned Includes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompleteOCLDocumentCSImpl
		extends NamedElementCSImpl
		implements CompleteOCLDocumentCS {

	/**
	 * The cached value of the '{@link #getOwnedImports() <em>Owned Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedImports()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportCS> ownedImports;

	/**
	 * The cached value of the '{@link #getOwnedLibraries() <em>Owned Libraries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLibraries()
	 * @generated
	 * @ordered
	 */
	protected EList<LibraryCS> ownedLibraries;

	/**
	 * The cached value of the '{@link #getOwnedPackages() <em>Owned Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageDeclarationCS> ownedPackages;

	/**
	 * The cached value of the '{@link #getOwnedContexts() <em>Owned Contexts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<ContextDeclCS> ownedContexts;

	/**
	 * The cached value of the '{@link #getOwnedIncludes() <em>Owned Includes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedIncludes()
	 * @generated
	 * @ordered
	 */
	protected EList<IncludeCS> ownedIncludes;

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
	public EList<ImportCS> getOwnedImports()
	{
		if (ownedImports == null)
		{
			ownedImports = new EObjectContainmentEList<ImportCS>(ImportCS.class, this, CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORTS);
		}
		return ownedImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LibraryCS> getOwnedLibraries()
	{
		if (ownedLibraries == null)
		{
			ownedLibraries = new EObjectContainmentEList<LibraryCS>(LibraryCS.class, this, CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARIES);
		}
		return ownedLibraries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageDeclarationCS> getOwnedPackages() {
		if (ownedPackages == null)
		{
			ownedPackages = new EObjectContainmentEList<PackageDeclarationCS>(PackageDeclarationCS.class, this, CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_PACKAGES);
		}
		return ownedPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContextDeclCS> getOwnedContexts() {
		if (ownedContexts == null)
		{
			ownedContexts = new EObjectContainmentEList<ContextDeclCS>(ContextDeclCS.class, this, CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_CONTEXTS);
		}
		return ownedContexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IncludeCS> getOwnedIncludes() {
		if (ownedIncludes == null)
		{
			ownedIncludes = new EObjectContainmentEList<IncludeCS>(IncludeCS.class, this, CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDES);
		}
		return ownedIncludes;
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
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORTS:
				return ((InternalEList<?>)getOwnedImports()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARIES:
				return ((InternalEList<?>)getOwnedLibraries()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_PACKAGES:
				return ((InternalEList<?>)getOwnedPackages()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_CONTEXTS:
				return ((InternalEList<?>)getOwnedContexts()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDES:
				return ((InternalEList<?>)getOwnedIncludes()).basicRemove(otherEnd, msgs);
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
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORTS:
				return getOwnedImports();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARIES:
				return getOwnedLibraries();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_PACKAGES:
				return getOwnedPackages();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_CONTEXTS:
				return getOwnedContexts();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDES:
				return getOwnedIncludes();
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
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORTS:
				getOwnedImports().clear();
				getOwnedImports().addAll((Collection<? extends ImportCS>)newValue);
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARIES:
				getOwnedLibraries().clear();
				getOwnedLibraries().addAll((Collection<? extends LibraryCS>)newValue);
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_PACKAGES:
				getOwnedPackages().clear();
				getOwnedPackages().addAll((Collection<? extends PackageDeclarationCS>)newValue);
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_CONTEXTS:
				getOwnedContexts().clear();
				getOwnedContexts().addAll((Collection<? extends ContextDeclCS>)newValue);
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDES:
				getOwnedIncludes().clear();
				getOwnedIncludes().addAll((Collection<? extends IncludeCS>)newValue);
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
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORTS:
				getOwnedImports().clear();
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARIES:
				getOwnedLibraries().clear();
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_PACKAGES:
				getOwnedPackages().clear();
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_CONTEXTS:
				getOwnedContexts().clear();
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDES:
				getOwnedIncludes().clear();
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
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORTS:
				return ownedImports != null && !ownedImports.isEmpty();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARIES:
				return ownedLibraries != null && !ownedLibraries.isEmpty();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_PACKAGES:
				return ownedPackages != null && !ownedPackages.isEmpty();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_CONTEXTS:
				return ownedContexts != null && !ownedContexts.isEmpty();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDES:
				return ownedIncludes != null && !ownedIncludes.isEmpty();
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
				case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORTS: return BaseCSPackage.ROOT_CS__OWNED_IMPORTS;
				case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARIES: return BaseCSPackage.ROOT_CS__OWNED_LIBRARIES;
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
				case BaseCSPackage.ROOT_CS__OWNED_IMPORTS: return CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORTS;
				case BaseCSPackage.ROOT_CS__OWNED_LIBRARIES: return CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARIES;
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
			result = CS2AS.computeRootContainmentFeatures(this);
			eBasicProperties().setEContents(result);
		}
		return result;
	}
} //DocumentCSImpl
