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
package org.eclipse.ocl.examples.pivot;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * @implements org.eclipse.ocl.examples.domain.elements.DomainEnumeration
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An enumeration defines a set of literals that can be used as its values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Enumeration#getOwnedLiteral <em>Owned Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getEnumeration()
 * @generated
 */
public interface Enumeration
		extends DataType, org.eclipse.ocl.examples.domain.elements.DomainEnumeration {

	/**
	 * Returns the value of the '<em><b>Owned Literal</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.EnumerationLiteral}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.EnumerationLiteral#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ordered set of literals for this Enumeration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Literal</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getEnumeration_OwnedLiteral()
	 * @see org.eclipse.ocl.examples.pivot.EnumerationLiteral#getEnumeration
	 * @generated
	 */
	@NonNull List<EnumerationLiteral> getOwnedLiteral();

} // Enumeration
