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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage
 * @generated
 */
public interface NameResoCGModelFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright>\r\n\r\nCopyright (c) 2014 Willink Transformations, University of York and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n\t Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation\r\n\r\n</copyright>";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NameResoCGModelFactory eINSTANCE = org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.NameResoCGModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CG Add Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Add Call</em>'.
	 * @generated
	 */
	CGAddCall createCGAddCall();

	/**
	 * Returns a new object of class '<em>CG Env Visit Op</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Env Visit Op</em>'.
	 * @generated
	 */
	CGEnvVisitOp createCGEnvVisitOp();

	/**
	 * Returns a new object of class '<em>CG Env Visit Op Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Env Visit Op Body</em>'.
	 * @generated
	 */
	CGEnvVisitOpBody createCGEnvVisitOpBody();

	/**
	 * Returns a new object of class '<em>CG Env Visit If Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Env Visit If Part</em>'.
	 * @generated
	 */
	CGEnvVisitIfPart createCGEnvVisitIfPart();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NameResoCGModelPackage getNameResoCGModelPackage();

} //NameResoCGModelFactory
