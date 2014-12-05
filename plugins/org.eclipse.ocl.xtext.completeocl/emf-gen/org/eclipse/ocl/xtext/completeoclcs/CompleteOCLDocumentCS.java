/*******************************************************************************
 * Copyright (c) 2010, 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeoclcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.NamespaceCS;
import org.eclipse.ocl.xtext.basecs.RootCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS#getOwnedContexts <em>Owned Contexts</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS#getOwnedIncludes <em>Owned Includes</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS#getOwnedPackages <em>Owned Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getCompleteOCLDocumentCS()
 * @model
 * @generated
 */
public interface CompleteOCLDocumentCS
		extends NamespaceCS, RootCS {

	/**
	 * Returns the value of the '<em><b>Owned Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Packages</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getCompleteOCLDocumentCS_OwnedPackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageDeclarationCS> getOwnedPackages();

	/**
	 * Returns the value of the '<em><b>Owned Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Contexts</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getCompleteOCLDocumentCS_OwnedContexts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ContextDeclCS> getOwnedContexts();

	/**
	 * Returns the value of the '<em><b>Owned Includes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.completeoclcs.IncludeCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Include</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Includes</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getCompleteOCLDocumentCS_OwnedIncludes()
	 * @model containment="true"
	 * @generated
	 */
	EList<IncludeCS> getOwnedIncludes();

} // DocumentCS
