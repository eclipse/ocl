/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
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
 * @noimplement clients should derive from AbstractTransformer
 */
public interface Transformer extends ModelManager
{
	/**
	 * Clients may reference this explicitly to force a compile-time failure for a mismatch.
	 * 
	 * @noreference this is solely for development usage.
	 * 
	 * 1.1.0-1 API version introduced, ObjectManager etc interfaces separated out, AbstractObjectManager etc enforced.
	 */
	public static int RUN_TIME_EVALUATOR_API_VERSION_1_1_0_1 = 1*1000 + 1 * 100 + 0*10 + 1;
	
	/**
	 * The run-time API version.
	 * 
	 * @noreference this is solely for development usage.
	 */
	public static int RUN_TIME_EVALUATOR_API_VERSION = RUN_TIME_EVALUATOR_API_VERSION_1_1_0_1;
	
	void addRootObjects(@NonNull String modelName, @NonNull Iterable<? extends EObject> rootObjects);
    @NonNull Collection<EObject> getRootObjects(@NonNull String modelName);
    boolean run() throws Exception;
}
