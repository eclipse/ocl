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

import java.util.List;

import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Env Visit Op Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody#getEnvConfigParts <em>Env Config Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage#getCGEnvVisitOpBody()
 * @model
 * @generated
 */
public interface CGEnvVisitOpBody extends CGValuedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright>\r\n\r\nCopyright (c) 2014 Willink Transformations, University of York and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n\t Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation\r\n\r\n</copyright>";

	/**
	 * Returns the value of the '<em><b>Env Config Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Env Config Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Env Config Parts</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage#getCGEnvVisitOpBody_EnvConfigParts()
	 * @model containment="true"
	 * @generated
	 */
	List<CGEnvVisitIfPart> getEnvConfigParts();

} // CGEnvVisitOpBody
