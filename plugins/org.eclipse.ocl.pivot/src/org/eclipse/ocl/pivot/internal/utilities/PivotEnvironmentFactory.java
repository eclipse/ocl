/*******************************************************************************
 * Copyright (c) 2005, 2013 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera (University of York) - Bug 415697
 *******************************************************************************/

package org.eclipse.ocl.pivot.internal.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractEvaluationEnvironment;
import org.eclipse.ocl.pivot.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentFactory;

/**
 * Implementation of the {@link EnvironmentFactoryInternal} for parsing OCL expressions
 * on Ecore models.
 *
 * @author Christian W. Damus (cdamus)
 */
public class PivotEnvironmentFactory extends AbstractEnvironmentFactory {
	
	/**
	 * Initializes me with an optional <code>StandaloneProjectMap</code> of accessible resources and
	 * an optional <code>ModelManager</code> for loaded instances.
	 */
	public PivotEnvironmentFactory(@Nullable StandaloneProjectMap projectMap) {
		super(projectMap);
	}

	@Override
	public @NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull NamedElement executableObject, @NonNull ModelManager modelManager) {
		return new AbstractEvaluationEnvironment(this, executableObject, modelManager);
	}

	@Override
	public @NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent, @NonNull NamedElement executableObject) {
		return new AbstractEvaluationEnvironment(parent, executableObject);
	}
}
