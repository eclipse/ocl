/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.context;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * ClassContext supports parsing OCL expressions in the context of a Class.
 */
public class ClassContext extends AbstractParserContext
{
	protected final @NonNull Type classContext;
	
	public ClassContext(@NonNull MetaModelManager metaModelManager, @Nullable URI uri, @NonNull Type classContext) {
		super(metaModelManager, uri);
		this.classContext = metaModelManager.getPrimaryType(classContext);
	}

	@Override
	public @NonNull Type getClassContext() {
		return classContext;
	}

	@Override
	public void initialize(@NonNull Base2PivotConversion conversion, @NonNull ExpressionInOCL expression) {
		super.initialize(conversion, expression);
		conversion.setContextVariable(expression, Environment.SELF_VARIABLE_NAME, classContext);
	}
}
