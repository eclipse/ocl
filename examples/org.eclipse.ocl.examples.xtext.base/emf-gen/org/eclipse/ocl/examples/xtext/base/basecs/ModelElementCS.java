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

package org.eclipse.ocl.examples.xtext.base.basecs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS#getOwnedAnnotation <em>Owned Annotation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS#getOriginalXmiId <em>Original Xmi Id</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS#getCsi <em>Csi</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getModelElementCS()
 * @model abstract="true"
 * @generated
 */
public interface ModelElementCS extends PivotableElementCS {
	/**
	 * Returns the value of the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Annotation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Annotation</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getModelElementCS_OwnedAnnotation()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnnotationElementCS> getOwnedAnnotation();

	/**
	 * Returns the value of the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Xmi Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Xmi Id</em>' attribute.
	 * @see #setOriginalXmiId(String)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getModelElementCS_OriginalXmiId()
	 * @model transient="true"
	 * @generated
	 */
	String getOriginalXmiId();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS#getOriginalXmiId <em>Original Xmi Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Xmi Id</em>' attribute.
	 * @see #getOriginalXmiId()
	 * @generated
	 */
	void setOriginalXmiId(String value);

	/**
	 * Returns the value of the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Csi</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Csi</em>' attribute.
	 * @see #setCsi(String)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getModelElementCS_Csi()
	 * @model transient="true"
	 * @generated
	 */
	String getCsi();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS#getCsi <em>Csi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Csi</em>' attribute.
	 * @see #getCsi()
	 * @generated
	 */
	void setCsi(String value);

} // ModelElementCS
