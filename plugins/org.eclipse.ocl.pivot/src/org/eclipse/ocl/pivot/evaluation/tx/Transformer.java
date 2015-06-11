/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.evaluation.tx;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.ModelManager;

/**
 * A Transformer provides the core support to execute an auto-generated transformation
 * between models.
 * 
 * @since 1.1
 * @noimplement
 */
public interface Transformer extends ModelManager
{
	void addRootObjects(@NonNull String modelName, @NonNull Iterable<? extends EObject> rootObjects);
    @NonNull Collection<EObject> getRootObjects(@NonNull String modelName);
    boolean run() throws Exception;
}
