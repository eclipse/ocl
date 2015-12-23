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


import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.internal.evaluation.tx.AbstractTransformerInternal;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.TracingOption;

/**
 * The abstract implementation of an auto-generated transformation provides the mandatory shared functionality for maintaining
 * models and deferring invocation of not-ready mapping invocations.
 * 
 * @since 1.1
 */
public abstract class AbstractTransformer extends AbstractTransformerInternal
{	
	public static final @NonNull TracingOption INVOCATIONS = new TracingOption(PivotPlugin.PLUGIN_ID, "tx/invocations");

	protected AbstractTransformer(@NonNull Executor executor, @NonNull String @NonNull [] modelNames,
			@NonNull PropertyId @Nullable [] propertyIndex2propertyId, @NonNull ClassId @Nullable [] classIndex2classId, int @Nullable [] @NonNull [] classIndex2allClassIndexes) {
		super(executor, modelNames, propertyIndex2propertyId, classIndex2classId, classIndex2allClassIndexes) ;
	}
}
