/*******************************************************************************
 * Copyright (c) 2010,2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.scoping;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * A ScopeFilter is initially used to reject unwanted name contributions from a scope and
 * once all candidate names have been identified, is used again to select a best match from
 * ambiguous contributions.
 */
public interface ScopeFilter
{
	/**
	 * Return -ve if match1 is inferior to match2, +ve if match2 is inferior to match1, or
	 * zero if both matches are of equal validity.
	 */
	int compareMatches(@NonNull MetaModelManager metaModelManager, @NonNull Object match1, @Nullable Map<TemplateParameter, ParameterableElement> bindings1, @NonNull Object match2, @Nullable Map<TemplateParameter, ParameterableElement> bindings2);

	/**
	 * Return true if the filter accepts eObject as a candidate for
	 * inclusion in the EnvironmentView.
	 */
	boolean matches(@NonNull EnvironmentView environmentView,  @NonNull Object object);
}
