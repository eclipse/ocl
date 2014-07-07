/**
 * <copyright>
 * 
 * Copyright (c) 2014 Willink Transformations, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	 Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.autogen.nameresocgmodel;

import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Env Visit If Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart#getEnvExpression <em>Env Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage#getCGEnvVisitIfPart()
 * @model
 * @generated
 */
public interface CGEnvVisitIfPart extends CGValuedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright>\r\n\r\nCopyright (c) 2014 Willink Transformations, University of York and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n\t Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation\r\n\r\n</copyright>";

	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage#getCGEnvVisitIfPart_PropertyName()
	 * @model
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Env Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Env Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Env Expression</em>' containment reference.
	 * @see #setEnvExpression(CGValuedElement)
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage#getCGEnvVisitIfPart_EnvExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getEnvExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart#getEnvExpression <em>Env Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Env Expression</em>' containment reference.
	 * @see #getEnvExpression()
	 * @generated
	 */
	void setEnvExpression(CGValuedElement value);

} // CGEnvVisitIfPart
