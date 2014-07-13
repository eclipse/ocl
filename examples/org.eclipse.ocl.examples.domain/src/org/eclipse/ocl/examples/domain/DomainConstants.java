/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain;

import org.eclipse.jdt.annotation.NonNull;

/**
 * @since 3.5
 */
public interface DomainConstants
{
	/**
	 * EPackage annotation indicating that the EPackage is an Ecore serialisation of an OCL AS Metamodel.
	 * No details are defined for this EAnnotation.
	 * <p>
	 * This annotation is used by /org.eclipse.ocl.examples.pivot/model/Pivot.ecore. It is not
	 * intended to be used by client code.
	 */
	static final @NonNull String AS_METAMODEL_ANNOTATION_SOURCE = "http://www.eclipse.org/OCL/ASMetamodel";
	
	/**
	 * The Package name of the shared metamodel.
	 */
	static final @NonNull String METAMODEL_NAME = "$metamodel$";
	
	/**
	 * The Package name of the shared types metamodel.
	 */
	static final @NonNull String TYPES_METAMODEL_NAME = "$types$";	// FIXME Use extension point
	
	/**
	 * The Package name of the shared uml metamodel.
	 */
	static final @NonNull String UML_METAMODEL_NAME = "$uml$";	// FIXME Use extension point
}
