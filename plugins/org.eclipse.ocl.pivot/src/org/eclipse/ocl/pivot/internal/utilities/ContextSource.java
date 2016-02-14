/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

/**
 * Enumeration of context sources that identify where the type of an object selected as self is found.
 * 
 * This is normally the metamodel, using something like EObject::eClass(), but may be an InstanceSpecification::classifier for UML.
 * @since 1.1
 */
public enum ContextSource {
	METAMODEL,			// Default: classifiers of a selected context object are determined from its metamodel
	MODEL;				// Alternatively the classifiers may be determined within the model; e.g. by UML's InstanceSpecification::classifier
}
