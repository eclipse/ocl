/**
 */
package bug477283.a.asub;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see bug477283.a.asub.Bug477283subPackage
 * @generated
 */
public interface Bug477283subFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Bug477283subFactory eINSTANCE = bug477283.a.asub.impl.Bug477283subFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>ASub</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ASub</em>'.
	 * @generated
	 */
	ASub createASub();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Bug477283subPackage getBug477283subPackage();

} //Bug477283subFactory
