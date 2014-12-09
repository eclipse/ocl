/*******************************************************************************
 * Copyright (c) 2010, 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.basecs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.basecs.util.VisitableCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.ElementCS#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getElementCS()
 * @model abstract="true" superTypes="org.eclipse.ocl.xtext.basecs.VisitableCS"
 * @generated
 */
public interface ElementCS extends EObject, VisitableCS {

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logical Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getElementCS_Parent()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	ElementCS getParent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.ocl.pivot.String"
	 * @generated
	 */
	String getDescription();

	/**
	 * Accept a visit from a visitor and return the result of a call to the derived type-specific visitXXX in the visitor.
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build/templates/model/Class/insert.javajetinc
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor);
} // ElementCS
