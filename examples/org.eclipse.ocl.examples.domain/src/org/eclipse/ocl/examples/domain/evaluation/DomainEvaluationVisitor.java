/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;

public interface DomainEvaluationVisitor
{
	/**
     * Obtains the evaluation environment that keeps track of variable values
     * and knows how to call operations, navigate properties, etc.
     * 
	 * @return the evaluation environment
	 */
	@NonNull DomainEvaluationEnvironment getEvaluationEnvironment();

	@NonNull DomainEvaluator getEvaluator();
	
	/**
     * Obtains the mapping of model classes to their extents.
     * 
	 * @return the model manager
	 */
	@NonNull DomainModelManager getModelManager();

	@NonNull DomainStandardLibrary getStandardLibrary();
}
