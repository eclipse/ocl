/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.util.OCLstdlibCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Class CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class JavaClassCSImpl extends NamedElementCSImpl implements JavaClassCS
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaClassCSImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return OCLstdlibCSPackage.Literals.JAVA_CLASS_CS;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((OCLstdlibCSVisitor<?>)visitor).visitJavaClassCS(this);
	}

	@Override
	public String toString() {
		return String.valueOf(name);
	}
} //JavaClassCSImpl
