/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.basecs;

import org.eclipse.ocl.examples.pivot.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Type Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#getOwnedTemplateBinding <em>Owned Template Binding</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#isTypeof <em>Typeof</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getTypedTypeRefCS()
 * @model
 * @generated
 */
public interface TypedTypeRefCS extends TypedRefCS {
	/**
	 * Returns the value of the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name</em>' containment reference.
	 * @see #setPathName(PathNameCS)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getTypedTypeRefCS_PathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#getPathName <em>Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name</em>' containment reference.
	 * @see #getPathName()
	 * @generated
	 */
	void setPathName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getTypedTypeRefCS_Type()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Returns the value of the '<em><b>Owned Template Binding</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS#getOwningTemplateBindableElement <em>Owning Template Bindable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Template Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Template Binding</em>' containment reference.
	 * @see #setOwnedTemplateBinding(TemplateBindingCS)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getTypedTypeRefCS_OwnedTemplateBinding()
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS#getOwningTemplateBindableElement
	 * @model opposite="owningTemplateBindableElement" containment="true"
	 * @generated
	 */
	TemplateBindingCS getOwnedTemplateBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#getOwnedTemplateBinding <em>Owned Template Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Template Binding</em>' containment reference.
	 * @see #getOwnedTemplateBinding()
	 * @generated
	 */
	void setOwnedTemplateBinding(TemplateBindingCS value);

	/**
	 * Returns the value of the '<em><b>Typeof</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typeof</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typeof</em>' attribute.
	 * @see #setTypeof(boolean)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getTypedTypeRefCS_Typeof()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isTypeof();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#isTypeof <em>Typeof</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typeof</em>' attribute.
	 * @see #isTypeof()
	 * @generated
	 */
	void setTypeof(boolean value);

} // TypedTypeRefCS
