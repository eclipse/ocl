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
package org.eclipse.ocl.pivot.uml.ocl4uml.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.ocl.pivot.uml.ocl4uml.BoundedInteger;
import org.eclipse.ocl.pivot.uml.ocl4uml.Collection;
import org.eclipse.ocl.pivot.uml.ocl4uml.Collections;
import org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint;
import org.eclipse.ocl.pivot.uml.ocl4uml.FloatingPoint;
import org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage;
import org.eclipse.ocl.pivot.uml.ocl4uml.Real;
import org.eclipse.ocl.pivot.uml.ocl4uml.Validation;
import org.eclipse.ocl.pivot.uml.ocl4uml.Validations;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage
 * @generated
 */
public class OCL4UMLSwitch<T>
		extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OCL4UMLPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCL4UMLSwitch() {
		if (modelPackage == null) {
			modelPackage = OCL4UMLPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case OCL4UMLPackage.BOUNDED_INTEGER : {
				BoundedInteger boundedInteger = (BoundedInteger) theEObject;
				T result = caseBoundedInteger(boundedInteger);
				if (result == null)
					result = caseInteger(boundedInteger);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case OCL4UMLPackage.INTEGER : {
				org.eclipse.ocl.pivot.uml.ocl4uml.Integer integer = (org.eclipse.ocl.pivot.uml.ocl4uml.Integer) theEObject;
				T result = caseInteger(integer);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case OCL4UMLPackage.COLLECTION : {
				Collection collection = (Collection) theEObject;
				T result = caseCollection(collection);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case OCL4UMLPackage.COLLECTIONS : {
				Collections collections = (Collections) theEObject;
				T result = caseCollections(collections);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case OCL4UMLPackage.FIXED_POINT : {
				FixedPoint fixedPoint = (FixedPoint) theEObject;
				T result = caseFixedPoint(fixedPoint);
				if (result == null)
					result = caseReal(fixedPoint);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case OCL4UMLPackage.REAL : {
				Real real = (Real) theEObject;
				T result = caseReal(real);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case OCL4UMLPackage.FLOATING_POINT : {
				FloatingPoint floatingPoint = (FloatingPoint) theEObject;
				T result = caseFloatingPoint(floatingPoint);
				if (result == null)
					result = caseReal(floatingPoint);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case OCL4UMLPackage.VALIDATION : {
				Validation validation = (Validation) theEObject;
				T result = caseValidation(validation);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case OCL4UMLPackage.VALIDATIONS : {
				Validations validations = (Validations) theEObject;
				T result = caseValidations(validations);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default :
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bounded Integer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bounded Integer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundedInteger(BoundedInteger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInteger(org.eclipse.ocl.pivot.uml.ocl4uml.Integer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollection(Collection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collections</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collections</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollections(Collections object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedPoint(FixedPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReal(Real object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Floating Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Floating Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloatingPoint(FloatingPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Validation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidation(Validation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Validations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidations(Validations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //OCL4UMLSwitch
