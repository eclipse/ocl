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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameter</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A template parameter exposes a parameterable element as a formal template parameter of a template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getConstrainingClass <em>Constraining Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getOwningTemplateSignature <em>Owning Template Signature</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTemplateParameter()
 * @generated
 */
public interface TemplateParameter
		extends Type, org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter {

	/**
	 * Returns the value of the '<em><b>Constraining Class</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The classifiers that constrain the argument that can be used for the parameter. If the allowSubstitutable attribute is true, then any classifier that is compatible with this constraining classifier can be substituted; otherwise, it must be either this classifier or one of its subclasses. If this property is empty, there are no constraints on the classifier that can be used as an argument.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraining Class</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTemplateParameter_ConstrainingClass()
	 * @generated
	 */
	List<org.eclipse.ocl.examples.pivot.Class> getConstrainingClass();

	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element that is the default for this formal template parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lower Bound</em>' reference.
	 * @see #setLowerBound(Type)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTemplateParameter_LowerBound()
	 * @generated
	 */
	@Override
	Type getLowerBound();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getLowerBound <em>Lower Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' reference.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(Type value);

	/**
	 * Returns the value of the '<em><b>Owning Template Signature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.TemplateSignature#getOwnedTemplateParameters <em>Owned Template Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The template signature that owns this template parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Template Signature</em>' container reference.
	 * @see #setOwningTemplateSignature(TemplateSignature)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTemplateParameter_OwningTemplateSignature()
	 * @see org.eclipse.ocl.examples.pivot.TemplateSignature#getOwnedTemplateParameters
	 * @generated
	 */
	TemplateSignature getOwningTemplateSignature();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getOwningTemplateSignature <em>Owning Template Signature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Template Signature</em>' container reference.
	 * @see #getOwningTemplateSignature()
	 * @generated
	 */
	void setOwningTemplateSignature(TemplateSignature value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element that is the default for this formal template parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upper Bound</em>' reference.
	 * @see #setUpperBound(Type)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTemplateParameter_UpperBound()
	 * @generated
	 */
	Type getUpperBound();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getUpperBound <em>Upper Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' reference.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(Type value);

} // TemplateParameter
