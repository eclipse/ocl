/*******************************************************************************
 * Copyright (c) 2012,2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.options;

import org.eclipse.ocl.common.internal.preferences.AnnotatedPreferenceInitializer;
import org.eclipse.ocl.examples.pivot.options.OCLinEcoreOptions;

/**
 * Class used to initialize default preference values.
 */
public class OCLinEcorePreferenceInitializer extends AnnotatedPreferenceInitializer
{
	@Override
	public void initializeDefaultPreferences() {
		putPreference(OCLinEcoreOptions.EXPORT_DELEGATION_URI);
	}
}
