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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainElement
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An element is a constituent of a model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Element#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Element#getOwnedAnnotation <em>Owned Annotation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Element#getOwnedComment <em>Owned Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getElement()
 * @extends PivotObject
 * @generated
 */
public interface Element
		extends PivotObject, Visitable, org.eclipse.ocl.examples.domain.elements.DomainElement {

	/**
	 * Returns the value of the '<em><b>Owned Comment</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Comment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Comments owned by this element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Comment</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getElement_OwnedComment()
	 * @generated
	 */
	@NonNull List<Comment> getOwnedComment();

	/**
	 * Returns the value of the '<em><b>Extension</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.ElementExtension}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.ElementExtension#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getElement_Extension()
	 * @see org.eclipse.ocl.examples.pivot.ElementExtension#getBase
	 * @generated
	 */
	@NonNull List<ElementExtension> getExtension();

	/**
	 * Returns the value of the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Annotation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Annotation</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getElement_OwnedAnnotation()
	 * @generated
	 */
	@NonNull List<Element> getOwnedAnnotation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull List<Element> allOwnedElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Element getValue(Type stereotype, String propertyName);

	EObject getETarget();
} // Element
