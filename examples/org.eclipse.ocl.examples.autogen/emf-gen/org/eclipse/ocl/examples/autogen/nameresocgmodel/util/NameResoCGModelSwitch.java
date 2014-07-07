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
package org.eclipse.ocl.examples.autogen.nameresocgmodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddCall;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCallable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.domain.elements.Nameable;

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
 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage
 * @generated
 */
public class NameResoCGModelSwitch<T> extends Switch<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright>\r\n\r\nCopyright (c) 2014 Willink Transformations, University of York and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n\t Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation\r\n\r\n</copyright>";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NameResoCGModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameResoCGModelSwitch() {
		if (modelPackage == null) {
			modelPackage = NameResoCGModelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
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
			case NameResoCGModelPackage.CG_ADD_CALL: {
				CGAddCall cgAddCall = (CGAddCall)theEObject;
				T result = caseCGAddCall(cgAddCall);
				if (result == null) result = caseCGOperationCallExp(cgAddCall);
				if (result == null) result = caseCGCallExp(cgAddCall);
				if (result == null) result = caseCGValuedElement(cgAddCall);
				if (result == null) result = caseCGTypedElement(cgAddCall);
				if (result == null) result = caseCGNamedElement(cgAddCall);
				if (result == null) result = caseCGElement(cgAddCall);
				if (result == null) result = caseNameable(cgAddCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NameResoCGModelPackage.CG_ENV_VISIT_OP: {
				CGEnvVisitOp cgEnvVisitOp = (CGEnvVisitOp)theEObject;
				T result = caseCGEnvVisitOp(cgEnvVisitOp);
				if (result == null) result = caseCGOperation(cgEnvVisitOp);
				if (result == null) result = caseCGCallable(cgEnvVisitOp);
				if (result == null) result = caseCGValuedElement(cgEnvVisitOp);
				if (result == null) result = caseCGTypedElement(cgEnvVisitOp);
				if (result == null) result = caseCGNamedElement(cgEnvVisitOp);
				if (result == null) result = caseCGElement(cgEnvVisitOp);
				if (result == null) result = caseNameable(cgEnvVisitOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NameResoCGModelPackage.CG_ENV_VISIT_OP_BODY: {
				CGEnvVisitOpBody cgEnvVisitOpBody = (CGEnvVisitOpBody)theEObject;
				T result = caseCGEnvVisitOpBody(cgEnvVisitOpBody);
				if (result == null) result = caseCGValuedElement(cgEnvVisitOpBody);
				if (result == null) result = caseCGTypedElement(cgEnvVisitOpBody);
				if (result == null) result = caseCGNamedElement(cgEnvVisitOpBody);
				if (result == null) result = caseCGElement(cgEnvVisitOpBody);
				if (result == null) result = caseNameable(cgEnvVisitOpBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NameResoCGModelPackage.CG_ENV_VISIT_IF_PART: {
				CGEnvVisitIfPart cgEnvVisitIfPart = (CGEnvVisitIfPart)theEObject;
				T result = caseCGEnvVisitIfPart(cgEnvVisitIfPart);
				if (result == null) result = caseCGValuedElement(cgEnvVisitIfPart);
				if (result == null) result = caseCGTypedElement(cgEnvVisitIfPart);
				if (result == null) result = caseCGNamedElement(cgEnvVisitIfPart);
				if (result == null) result = caseCGElement(cgEnvVisitIfPart);
				if (result == null) result = caseNameable(cgEnvVisitIfPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Add Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Add Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGAddCall(CGAddCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Env Visit Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Env Visit Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGEnvVisitOp(CGEnvVisitOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Env Visit Op Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Env Visit Op Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGEnvVisitOpBody(CGEnvVisitOpBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Env Visit If Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Env Visit If Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGEnvVisitIfPart(CGEnvVisitIfPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGElement(CGElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGNamedElement(CGNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGTypedElement(CGTypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Valued Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Valued Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGValuedElement(CGValuedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGCallExp(CGCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGOperationCallExp(CGOperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Callable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Callable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGCallable(CGCallable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGOperation(CGOperation object) {
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

} //NameResoCGModelSwitch
