/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink (CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.TypeExtension#isRequired <em>Is Required</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TypeExtension#getOwningStereotype <em>Owning Stereotype</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TypeExtension#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getTypeExtension()
 * @generated
 */
public interface TypeExtension extends Element
{
	/**
	 * Returns the value of the '<em><b>Is Required</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Required</em>' attribute.
	 * @see #setIsRequired(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTypeExtension_IsRequired()
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TypeExtension#isRequired <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setIsRequired(boolean value);

	/**
	 * Returns the value of the '<em><b>Owning Stereotype</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Stereotype#getOwnedExtensionOfs <em>Owned Extension Ofs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Stereotype</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Stereotype</em>' container reference.
	 * @see #setOwningStereotype(Stereotype)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTypeExtension_OwningStereotype()
	 * @see org.eclipse.ocl.pivot.Stereotype#getOwnedExtensionOfs
	 * @generated
	 */
	Stereotype getOwningStereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TypeExtension#getOwningStereotype <em>Owning Stereotype</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Stereotype</em>' container reference.
	 * @see #getOwningStereotype()
	 * @generated
	 */
	void setOwningStereotype(Stereotype value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Type#getExtendedBys <em>Extended Bys</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTypeExtension_Type()
	 * @see org.eclipse.ocl.pivot.Type#getExtendedBys
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TypeExtension#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // TypeExtension
