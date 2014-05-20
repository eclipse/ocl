/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.basecs;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.util.Pivotable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Named Element Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getElementType <em>Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getPathElementCS()
 * @model superTypes="org.eclipse.ocl.examples.xtext.base.basecs.ElementCS org.eclipse.ocl.examples.pivot.Pivotable"
 * @generated
 */
public interface PathElementCS extends ElementCS, Pivotable
{
	/**
	 * Returns the value of the '<em><b>Path Name</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name</em>' container reference.
	 * @see #setPathName(PathNameCS)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getPathElementCS_PathName()
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getPath
	 * @model opposite="path" required="true" transient="false"
	 * @generated
	 */
	PathNameCS getPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getPathName <em>Path Name</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name</em>' container reference.
	 * @see #getPathName()
	 * @generated
	 */
	void setPathName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(Element)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getPathElementCS_Element()
	 * @model required="true"
	 * @generated
	 */
	Element getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(Element value);

	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' reference.
	 * @see #setElementType(EClassifier)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getPathElementCS_ElementType()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	EClassifier getElementType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getElementType <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' reference.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(EClassifier value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	Element basicGetElement();

	boolean isType();

} // SimpleNamedElementRefCS
