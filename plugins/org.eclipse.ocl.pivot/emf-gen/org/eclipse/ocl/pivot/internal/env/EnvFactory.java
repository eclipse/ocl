/**
 */
package org.eclipse.ocl.pivot.internal.env;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.ocl.pivot.internal.lookup.IEnvironment;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.internal.env.EnvPackage
 * @generated
 */
public interface EnvFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnvFactory eINSTANCE = org.eclipse.ocl.pivot.internal.env.impl.EnvFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Environment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Environment</em>'.
	 * @generated
	 */
	IEnvironment createEnvironment();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EnvPackage getEnvPackage();

} //EnvFactory
