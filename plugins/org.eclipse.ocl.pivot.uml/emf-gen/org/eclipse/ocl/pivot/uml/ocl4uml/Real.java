/**
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.uml.ocl4uml;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Real</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specifies that a DataType behaves as a Real and optionally defines a limited numeric range and resolution that an implementation must support. Computations resulting in values beyond a specified minimum or maximum limits or resolution are ill-defined. The derived FixedPoint or FloatingPoint stereotypes may be used to define more exact precisions, overflow and underflow behaviors.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.Real#getBase_DataType <em>Base Data Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.Real#getEpsilon <em>Epsilon</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.Real#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.Real#getMinimum <em>Minimum</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage#getReal()
 * @model
 * @generated
 */
public interface Real
		extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Data Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Data Type</em>' reference.
	 * @see #setBase_DataType(DataType)
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage#getReal_Base_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getBase_DataType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Real#getBase_DataType <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Data Type</em>' reference.
	 * @see #getBase_DataType()
	 * @generated
	 */
	void setBase_DataType(DataType value);

	/**
	 * Returns the value of the '<em><b>Epsilon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum required ratio between adjacent values.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Epsilon</em>' attribute.
	 * @see #setEpsilon(double)
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage#getReal_Epsilon()
	 * @model dataType="org.eclipse.uml2.types.Real" ordered="false"
	 * @generated
	 */
	double getEpsilon();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Real#getEpsilon <em>Epsilon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Epsilon</em>' attribute.
	 * @see #getEpsilon()
	 * @generated
	 */
	void setEpsilon(double value);

	/**
	 * Returns the value of the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The most positive inclusive value of the DataType. Defaults to unlimited.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximum</em>' attribute.
	 * @see #setMaximum(double)
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage#getReal_Maximum()
	 * @model dataType="org.eclipse.uml2.types.Real" ordered="false"
	 * @generated
	 */
	double getMaximum();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Real#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(double value);

	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The most negative inclusive value of the DataType. Defaults to unlimited.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum</em>' attribute.
	 * @see #setMinimum(double)
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage#getReal_Minimum()
	 * @model dataType="org.eclipse.uml2.types.Real" ordered="false"
	 * @generated
	 */
	double getMinimum();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Real#getMinimum <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' attribute.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(double value);

} // Real
