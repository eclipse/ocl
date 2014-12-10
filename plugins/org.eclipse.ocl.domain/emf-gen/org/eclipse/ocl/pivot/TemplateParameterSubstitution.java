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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameter Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A template parameter substitution relates the actual parameter to a formal template parameter as part of a template binding.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getActual <em>Actual</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getFormal <em>Formal</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwnedWildcard <em>Owned Wildcard</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwningTemplateBinding <em>Owning Template Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameterSubstitution()
 * @generated
 */
public interface TemplateParameterSubstitution
		extends Element {

	/**
	 * Returns the value of the '<em><b>Formal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The formal template parameter that is associated with this substitution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Formal</em>' reference.
	 * @see #setFormal(TemplateParameter)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameterSubstitution_Formal()
	 * @generated
	 */
	TemplateParameter getFormal();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getFormal <em>Formal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formal</em>' reference.
	 * @see #getFormal()
	 * @generated
	 */
	void setFormal(TemplateParameter value);

	/**
	 * Returns the value of the '<em><b>Owned Wildcard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element that is the actual parameter for this substitution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Wildcard</em>' containment reference.
	 * @see #setOwnedWildcard(WildcardType)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameterSubstitution_OwnedWildcard()
	 * @generated
	 */
	WildcardType getOwnedWildcard();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwnedWildcard <em>Owned Wildcard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Wildcard</em>' containment reference.
	 * @see #getOwnedWildcard()
	 * @generated
	 */
	void setOwnedWildcard(WildcardType value);

	/**
	 * Returns the value of the '<em><b>Actual</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element that is the actual parameter for this substitution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actual</em>' reference.
	 * @see #setActual(Type)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameterSubstitution_Actual()
	 * @generated
	 */
	Type getActual();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getActual <em>Actual</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual</em>' reference.
	 * @see #getActual()
	 * @generated
	 */
	void setActual(Type value);

	/**
	 * Returns the value of the '<em><b>Owning Template Binding</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.TemplateBinding#getOwnedTemplateParameterSubstitutions <em>Owned Template Parameter Substitutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The optional bindings from this element to templates.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Template Binding</em>' container reference.
	 * @see #setOwningTemplateBinding(TemplateBinding)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameterSubstitution_OwningTemplateBinding()
	 * @see org.eclipse.ocl.pivot.TemplateBinding#getOwnedTemplateParameterSubstitutions
	 * @generated
	 */
	TemplateBinding getOwningTemplateBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwningTemplateBinding <em>Owning Template Binding</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Template Binding</em>' container reference.
	 * @see #getOwningTemplateBinding()
	 * @generated
	 */
	void setOwningTemplateBinding(TemplateBinding value);

} // TemplateParameterSubstitution
