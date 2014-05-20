/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.completeocl.completeoclcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS#getSelfName <em>Self Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage#getClassifierContextDeclCS()
 * @model
 * @generated
 */
public interface ClassifierContextDeclCS
		extends ContextDeclCS {

	/**
	 * Returns the value of the '<em><b>Self Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Name</em>' attribute.
	 * @see #setSelfName(String)
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage#getClassifierContextDeclCS_SelfName()
	 * @model
	 * @generated
	 */
	String getSelfName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS#getSelfName <em>Self Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Name</em>' attribute.
	 * @see #getSelfName()
	 * @generated
	 */
	void setSelfName(String value);

	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' reference.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage#getClassifierContextDeclCS_Classifier()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Type getClassifier();

	/**
	 * Returns the value of the '<em><b>Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invariants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariants</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage#getClassifierContextDeclCS_Invariants()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintCS> getInvariants();

	/**
	 * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS#getClassifierContextDecl <em>Classifier Context Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definitions</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage#getClassifierContextDeclCS_Definitions()
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS#getClassifierContextDecl
	 * @model opposite="classifierContextDecl" containment="true"
	 * @generated
	 */
	EList<DefCS> getDefinitions();

} // ClassifierContextDeclCS
