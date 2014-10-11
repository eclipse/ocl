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

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.util.Pivotable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Element Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getOwnedPathElements <em>Owned Path Elements</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getReferredElement <em>Referred Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getScopeFilter <em>Scope Filter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getPathNameCS()
 * @model superTypes="org.eclipse.ocl.examples.xtext.base.basecs.ElementCS org.eclipse.ocl.examples.pivot.Pivotable"
 * @generated
 */
public interface PathNameCS extends ElementCS, Pivotable
{
	/**
	 * Returns the value of the '<em><b>Owned Path Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getOwningPathName <em>Owning Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Path Elements</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getPathNameCS_OwnedPathElements()
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getOwningPathName
	 * @model opposite="owningPathName" containment="true" required="true"
	 * @generated
	 */
	EList<PathElementCS> getOwnedPathElements();

	/**
	 * Returns the value of the '<em><b>Referred Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Element</em>' reference.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getPathNameCS_ReferredElement()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Element getReferredElement();

	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #isSetContext()
	 * @see #unsetContext()
	 * @see #setContext(ElementCS)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getPathNameCS_Context()
	 * @model resolveProxies="false" unsettable="true" transient="true"
	 * @generated
	 */
	ElementCS getContext();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #isSetContext()
	 * @see #unsetContext()
	 * @see #getContext()
	 * @generated
	 */
	void setContext(ElementCS value);

	/**
	 * Unsets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetContext()
	 * @see #getContext()
	 * @see #setContext(ElementCS)
	 * @generated
	 */
	void unsetContext();

	/**
	 * Returns whether the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getContext <em>Context</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Context</em>' reference is set.
	 * @see #unsetContext()
	 * @see #getContext()
	 * @see #setContext(ElementCS)
	 * @generated
	 */
	boolean isSetContext();

	/**
	 * Returns the value of the '<em><b>Scope Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope Filter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope Filter</em>' attribute.
	 * @see #setScopeFilter(ScopeFilter)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getPathNameCS_ScopeFilter()
	 * @model dataType="org.eclipse.ocl.examples.xtext.base.basecs.ScopeFilter" transient="true"
	 * @generated
	 */
	ScopeFilter getScopeFilter();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getScopeFilter <em>Scope Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope Filter</em>' attribute.
	 * @see #getScopeFilter()
	 * @generated
	 */
	void setScopeFilter(ScopeFilter value);

} // QualifiedElementRefCS
