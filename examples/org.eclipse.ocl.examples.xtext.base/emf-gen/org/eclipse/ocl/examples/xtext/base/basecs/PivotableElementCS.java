/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.base.basecs;

import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.util.Pivotable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pivotable Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS#getPivot <em>Pivot</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getPivotableElementCS()
 * @model abstract="true" superTypes="org.eclipse.ocl.examples.xtext.base.basecs.ElementCS org.eclipse.ocl.examples.pivot.Pivotable"
 * @generated
 */
public interface PivotableElementCS extends ElementCS, Pivotable
{
	/**
	 * Returns the value of the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pivot</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pivot</em>' reference.
	 * @see #setPivot(Element)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getPivotableElementCS_Pivot()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	Element getPivot();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS#getPivot <em>Pivot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pivot</em>' reference.
	 * @see #getPivot()
	 * @generated
	 */
	void setPivot(Element value);

} // PivotableElementCS
