/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.ids.TemplateParameterId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A TemplateParameter exposes a ParameterableElement as a formal parameter of a template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateParameter#getConstrainingClasses <em>Constraining Classes</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateParameter#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateParameter#getOwnedDefault <em>Owned Default</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateParameter#getOwningSignature <em>Owning Signature</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameter()
 * @generated
 */
public interface TemplateParameter extends Type {

	/**
	 * Returns the value of the '<em><b>Constraining Classes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraining Classes</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameter_ConstrainingClasses()
	 * @generated
	 */
	List<org.eclipse.ocl.pivot.Class> getConstrainingClasses();

	/**
	 * Returns the value of the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ParameterableElement that is the default for this formal TemplateParameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default</em>' reference.
	 * @see #setDefault(ParameterableElement)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameter_Default()
	 * @generated
	 */
	ParameterableElement getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateParameter#getDefault <em>Default</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(ParameterableElement value);

	/**
	 * Returns the value of the '<em><b>Owned Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ParameterableElement that is owned by this TemplateParameter for the purpose of providing a default.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Default</em>' containment reference.
	 * @see #setOwnedDefault(ParameterableElement)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameter_OwnedDefault()
	 * @generated
	 */
	ParameterableElement getOwnedDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateParameter#getOwnedDefault <em>Owned Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Default</em>' containment reference.
	 * @see #getOwnedDefault()
	 * @generated
	 */
	void setOwnedDefault(ParameterableElement value);

	/**
	 * Returns the value of the '<em><b>Owning Signature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.TemplateSignature#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TemplateSignature that owns this TemplateParameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Signature</em>' container reference.
	 * @see #setOwningSignature(TemplateSignature)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameter_OwningSignature()
	 * @see org.eclipse.ocl.pivot.TemplateSignature#getOwnedParameters
	 * @generated
	 */
	TemplateSignature getOwningSignature();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateParameter#getOwningSignature <em>Owning Signature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Signature</em>' container reference.
	 * @see #getOwningSignature()
	 * @generated
	 */
	void setOwningSignature(TemplateSignature value);

	@NonNull TemplateParameterId getTemplateParameterId();

} // TemplateParameter
