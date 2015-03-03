/**
 */
package org.eclipse.ocl.pivot.internal.env;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.env.Environment#getNamedElements <em>Named Elements</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.env.Environment#getParentEnv <em>Parent Env</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.internal.env.EnvPackage#getEnvironment()
 * @model
 * @generated
 */
public interface Environment extends EObject {
	/**
	 * Returns the value of the '<em><b>Named Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Named Elements</em>' reference list.
	 * @see org.eclipse.ocl.pivot.internal.env.EnvPackage#getEnvironment_NamedElements()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getNamedElements();

	/**
	 * Returns the value of the '<em><b>Parent Env</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Env</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Env</em>' reference.
	 * @see #setParentEnv(Environment)
	 * @see org.eclipse.ocl.pivot.internal.env.EnvPackage#getEnvironment_ParentEnv()
	 * @model
	 * @generated
	 */
	Environment getParentEnv();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.internal.env.Environment#getParentEnv <em>Parent Env</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Env</em>' reference.
	 * @see #getParentEnv()
	 * @generated
	 */
	void setParentEnv(Environment value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementsRequired="true"
	 * @generated
	 */
	Environment addElementsOf(Namespace elements);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean hasFinalResult();

} // Environment
