/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   C.Damus - 291365
 *******************************************************************************/

package org.eclipse.ocl.pivot.internal.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;

/**
 * Implementation of the {@link EvaluationEnvironment} for evaluation of OCL
 * expressions on instances of Ecore models (i.e., on M0 models).
 * 
 * @author Tim Klinger (tklinger)
 * @author Christian W. Damus (cdamus)
 */
public class PivotEvaluationEnvironment extends AbstractEvaluationEnvironment {

    /**
     * Initializes me.
     */
    public PivotEvaluationEnvironment(@NonNull EnvironmentFactoryInternal environmentFactory) {
        super(environmentFactory);
    }

    /**
     * Initializes me with my parent evaluation environment (nesting scope).
     * 
     * @param parent
     *            my parent (nesting scope); must not be <code>null</code>
     */
    public PivotEvaluationEnvironment(@NonNull EvaluationEnvironment parent) {
        super(parent);
    }
}