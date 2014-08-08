/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type template parameter exposes a type as a formal template parameter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TypeTemplateParameter#getConstrainingClass <em>Constraining Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTypeTemplateParameter()
 * @generated
 */
public interface TypeTemplateParameter
		extends TemplateParameter {

	/**
	 * Returns the value of the '<em><b>Constraining Class</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The classifiers that constrain the argument that can be used for the parameter. If the allowSubstitutable attribute is true, then any classifier that is compatible with this constraining classifier can be substituted; otherwise, it must be either this classifier or one of its subclasses. If this property is empty, there are no constraints on the classifier that can be used as an argument.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraining Class</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTypeTemplateParameter_ConstrainingClass()
	 * @generated
	 */
	List<org.eclipse.ocl.examples.pivot.Class> getConstrainingClass();

} // TypeTemplateParameter
