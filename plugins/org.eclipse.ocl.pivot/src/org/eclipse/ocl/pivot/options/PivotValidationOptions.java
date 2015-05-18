/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.options;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentFactory;

/**
 * Options applicable to the {@link AbstractEnvironmentFactory}
 */
public class PivotValidationOptions
{
    public static final @NonNull EnumeratedOption<StatusCodes.Severity> MissingSafeNavigation = new EnumeratedOption<StatusCodes.Severity>(
    		PivotPlugin.PLUGIN_ID, "pivot.missing.safe.navigation", StatusCodes.Severity.IGNORE, StatusCodes.Severity.class); //$NON-NLS-1$

    public static final @NonNull EnumeratedOption<StatusCodes.Severity> RedundantSafeNavigation = new EnumeratedOption<StatusCodes.Severity>(
    		PivotPlugin.PLUGIN_ID, "pivot.redundant.safe.navigation", StatusCodes.Severity.IGNORE, StatusCodes.Severity.class); //$NON-NLS-1$

    private PivotValidationOptions() {
        super();
    }
}
