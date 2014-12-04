/*******************************************************************************
 * Copyright (c) 2010, 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.basecs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Binding CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS#getOwnedSubstitutions <em>Owned Substitutions</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS#getOwningElement <em>Owning Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getTemplateBindingCS()
 * @model
 * @generated
 */
public interface TemplateBindingCS extends ElementRefCS {
	/**
	 * Returns the value of the '<em><b>Owning Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#getOwnedBinding <em>Owned Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Template Bindable Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Element</em>' container reference.
	 * @see #setOwningElement(TypedTypeRefCS)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getTemplateBindingCS_OwningElement()
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#getOwnedBinding
	 * @model opposite="ownedBinding" transient="false"
	 * @generated
	 */
	TypedTypeRefCS getOwningElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS#getOwningElement <em>Owning Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Element</em>' container reference.
	 * @see #getOwningElement()
	 * @generated
	 */
	void setOwningElement(TypedTypeRefCS value);

	/**
	 * Returns the value of the '<em><b>Owned Substitutions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS#getOwningBinding <em>Owning Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameter Substitution</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Substitutions</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getTemplateBindingCS_OwnedSubstitutions()
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS#getOwningBinding
	 * @model opposite="owningBinding" containment="true"
	 * @generated
	 */
	EList<TemplateParameterSubstitutionCS> getOwnedSubstitutions();

} // TemplateBindingCS
