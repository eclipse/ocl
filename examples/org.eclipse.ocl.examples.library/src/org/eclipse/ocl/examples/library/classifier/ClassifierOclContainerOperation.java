/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ClassifierOclContainerOperation.java,v 1.2 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.classifier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleUnaryOperation;

/**
 * ClassifierOclContainerOperation realises the Classifier::oclContainer() library operation.
 */
public class ClassifierOclContainerOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull ClassifierOclContainerOperation INSTANCE = new ClassifierOclContainerOperation();

	@Override
	public @Nullable Object evaluate(@Nullable Object sourceVal) {
		EObject object = asNavigableObject(sourceVal, "oclContainer()"); //$NON-NLS-1$
		return object.eContainer();
	}
}
