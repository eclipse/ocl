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



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameterable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A parameterable element is an element that can be exposed as a formal template parameter for a template, or specified as an actual parameter in a binding of a template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ParameterableElement#getOwningTemplateParameter <em>Owning Template Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ParameterableElement#getTemplateParameter <em>Template Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getParameterableElement()
 * @generated
 */
public interface ParameterableElement
		extends Element {

	/**
	 * Returns the value of the '<em><b>Template Parameter</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getParameteredElement <em>Parametered Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The template parameter that exposes this element as a formal parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Template Parameter</em>' reference.
	 * @see #setTemplateParameter(TemplateParameter)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getParameterableElement_TemplateParameter()
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#getParameteredElement
	 * @generated
	 */
	TemplateParameter getTemplateParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.ParameterableElement#getTemplateParameter <em>Template Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Parameter</em>' reference.
	 * @see #getTemplateParameter()
	 * @generated
	 */
	void setTemplateParameter(TemplateParameter value);

	/**
	 * Returns the value of the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getOwnedParameteredElement <em>Owned Parametered Element</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.eclipse.ocl.examples.pivot.ParameterableElement#getTemplateParameter() <em>Template Parameter</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The formal template parameter that owns this element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Template Parameter</em>' container reference.
	 * @see #setOwningTemplateParameter(TemplateParameter)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getParameterableElement_OwningTemplateParameter()
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#getOwnedParameteredElement
	 * @generated
	 */
	TemplateParameter getOwningTemplateParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.ParameterableElement#getOwningTemplateParameter <em>Owning Template Parameter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Template Parameter</em>' container reference.
	 * @see #getOwningTemplateParameter()
	 * @generated
	 */
	void setOwningTemplateParameter(TemplateParameter value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query isTemplateParameter() determines if this parameterable element is exposed as a formal template parameter.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean isTemplateParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean isCompatibleWith(ParameterableElement p);

} // ParameterableElement
