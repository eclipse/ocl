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
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Annotation#getOwnedContent <em>Owned Content</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Annotation#getOwnedDetail <em>Owned Detail</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Annotation#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getAnnotation()
 * @generated
 */
public interface Annotation
		extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Owned Content</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Content</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Content</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getAnnotation_OwnedContent()
	 * @generated
	 */
	@NonNull List<Element> getOwnedContent();

	/**
	 * Returns the value of the '<em><b>Owned Detail</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Detail}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Detail</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Detail</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getAnnotation_OwnedDetail()
	 * @generated
	 */
	@NonNull List<Detail> getOwnedDetail();

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getAnnotation_Reference()
	 * @generated
	 */
	@NonNull List<Element> getReference();

} // Annotation
