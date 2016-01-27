/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.evaluation;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

/**
 * ModelManager provides the models to be used during evaluation. In particular
 * the managed models constitute the extent from which Classifier.allInstances
 * returns are made.
 */
public interface ModelManager
{
	/**
	 * @since 1.1
	 */
	public interface ModelManagerExtension extends ModelManager
	{
		void dispose();
	}
	
	@NonNull ModelManager NULL = new ModelManager()
	{
		@Override
		public @NonNull Set<EObject> get(org.eclipse.ocl.pivot.@NonNull Class type) {
			return Collections.emptySet();
		}
	};

	@NonNull Set<EObject> get(org.eclipse.ocl.pivot.@NonNull Class type);
}
