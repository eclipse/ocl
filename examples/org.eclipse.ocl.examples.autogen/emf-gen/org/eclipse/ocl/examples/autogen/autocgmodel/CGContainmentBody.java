/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.autocgmodel;

import java.util.List;

import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Containment Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody#getContainmentVisit <em>Containment Visit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelPackage#getCGContainmentBody()
 * @model
 * @generated
 */
public interface CGContainmentBody extends CGValuedElement {
	/**
	 * Returns the value of the '<em><b>Containment Visit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment Visit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containment Visit</em>' reference.
	 * @see #setContainmentVisit(CGContainmentVisit)
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelPackage#getCGContainmentBody_ContainmentVisit()
	 * @model resolveProxies="false" required="true"
	 * @generated
	 */
	CGContainmentVisit getContainmentVisit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody#getContainmentVisit <em>Containment Visit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containment Visit</em>' reference.
	 * @see #getContainmentVisit()
	 * @generated
	 */
	void setContainmentVisit(CGContainmentVisit value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart#getContainmentBody <em>Containment Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parameters of this operation, with 'self' as the first parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelPackage#getCGContainmentBody_Parts()
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart#getContainmentBody
	 * @model opposite="containmentBody" containment="true" ordered="false"
	 * @generated
	 */
	List<CGContainmentPart> getParts();

} // CGContainmentBody
