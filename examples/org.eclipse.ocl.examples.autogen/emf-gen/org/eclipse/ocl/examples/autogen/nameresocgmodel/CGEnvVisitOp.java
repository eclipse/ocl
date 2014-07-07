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

import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Env Visit Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOp#getEnvLookupPropagation <em>Env Lookup Propagation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage#getCGEnvVisitOp()
 * @model
 * @generated
 */
public interface CGEnvVisitOp extends CGOperation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright>\r\n\r\nCopyright (c) 2014 Willink Transformations, University of York and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n\t Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation\r\n\r\n</copyright>";

	/**
	 * Returns the value of the '<em><b>Env Lookup Propagation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.ocl.examples.autogen.nameresocgmodel.EnvLookupKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Env Lookup Propagation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Env Lookup Propagation</em>' attribute.
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.EnvLookupKind
	 * @see #setEnvLookupPropagation(EnvLookupKind)
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage#getCGEnvVisitOp_EnvLookupPropagation()
	 * @model
	 * @generated
	 */
	EnvLookupKind getEnvLookupPropagation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOp#getEnvLookupPropagation <em>Env Lookup Propagation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Env Lookup Propagation</em>' attribute.
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.EnvLookupKind
	 * @see #getEnvLookupPropagation()
	 * @generated
	 */
	void setEnvLookupPropagation(EnvLookupKind value);

} // CGEnvVisitOp
