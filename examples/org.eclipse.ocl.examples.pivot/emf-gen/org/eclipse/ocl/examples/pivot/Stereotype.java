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
package org.eclipse.ocl.examples.pivot;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Stereotype#getExtensionOfs <em>Extension Ofs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStereotype()
 * @generated
 */
public interface Stereotype extends org.eclipse.ocl.examples.pivot.Class
{

	/**
	 * Returns the value of the '<em><b>Extension Ofs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.TypeExtension}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.TypeExtension#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Ofs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Ofs</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStereotype_ExtensionOfs()
	 * @see org.eclipse.ocl.examples.pivot.TypeExtension#getStereotype
	 * @generated
	 */
	@NonNull List<TypeExtension> getExtensionOfs();
} // Stereotype
