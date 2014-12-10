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
package org.eclipse.ocl.pivot;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A template signature bundles the set of formal template parameters for a templated element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateSignature#getOwnedTemplateParameters <em>Owned Template Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateSignature#getOwningTemplateableElement <em>Owning Templateable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateSignature()
 * @generated
 */
public interface TemplateSignature
		extends Element {

	/**
	 * Returns the value of the '<em><b>Owned Template Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.TemplateParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.TemplateParameter#getOwningTemplateSignature <em>Owning Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The formal template parameters that are owned by this template signature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Template Parameters</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateSignature_OwnedTemplateParameters()
	 * @see org.eclipse.ocl.pivot.TemplateParameter#getOwningTemplateSignature
	 * @generated
	 */
	@NonNull List<TemplateParameter> getOwnedTemplateParameters();

	/**
	 * Returns the value of the '<em><b>Owning Templateable Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.TemplateableElement#getOwnedTemplateSignature <em>Owned Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element that owns this template signature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Templateable Element</em>' container reference.
	 * @see #setOwningTemplateableElement(TemplateableElement)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateSignature_OwningTemplateableElement()
	 * @see org.eclipse.ocl.pivot.TemplateableElement#getOwnedTemplateSignature
	 * @generated
	 */
	TemplateableElement getOwningTemplateableElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateSignature#getOwningTemplateableElement <em>Owning Templateable Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Templateable Element</em>' container reference.
	 * @see #getOwningTemplateableElement()
	 * @generated
	 */
	void setOwningTemplateableElement(TemplateableElement value);

} // TemplateSignature
