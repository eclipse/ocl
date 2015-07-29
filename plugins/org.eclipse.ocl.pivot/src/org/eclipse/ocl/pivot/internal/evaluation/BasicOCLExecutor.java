/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.manager.ShadowObjectManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;

/**
 * @since 1.1
 */
public class BasicOCLExecutor extends AbstractExecutor implements OCLExecutor
{	
	/**
	 * Lazily created cache of shadow objects.
	 */
	private /*@LazyNonNull*/ ShadowObjectManager shadowObjectManager = null;
	
	public BasicOCLExecutor(@NonNull EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension environmentFactory, @NonNull ModelManager modelManager) {
		super(environmentFactory, modelManager);
	}

	@Override
	public @NonNull Object getShadowObject(@NonNull org.eclipse.ocl.pivot.Class shadowClass,
			@NonNull Property[] shadowProperties, @NonNull Object[] shadowValues) {
		if (shadowObjectManager == null) {
			shadowObjectManager = new ShadowObjectManager(getIdResolver());
		}
		return shadowObjectManager.getShadowObject(shadowClass, shadowProperties, shadowValues);
	}
}
