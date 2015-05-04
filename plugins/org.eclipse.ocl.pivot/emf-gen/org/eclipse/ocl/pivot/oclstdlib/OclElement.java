/**
 * Copyright (c) 2010,2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.oclstdlib;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage#getOclElement()
 * @model kind="class" abstract="true"
 * @generated
 */
public abstract class OclElement extends EObjectImpl implements EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclElement() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLstdlibPackage.Literals.OCL_ELEMENT;
	}


} // OclElement
