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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * EClassContext supports parsing OCL expressions in the context of an Ecore Class.
 */
public class EClassContext extends AbstractParserContext
{
	protected final @Nullable EClassifier eClassContext;
	private Type classContext = null;

	public EClassContext(@NonNull MetaModelManager metaModelManager, @Nullable URI uri, @Nullable EClassifier eClassContext) {
		super(metaModelManager, uri);
		this.eClassContext = eClassContext;
	}

	@Override
	public @Nullable Type getClassContext() {
		if (classContext == null) {
			classContext = metaModelManager.getPivotOfEcore(Type.class, eClassContext);
		}
		return classContext;
	}

	@Override
	public void initialize(@NonNull Base2PivotConversion conversion, @NonNull ExpressionInOCL expression) {
		super.initialize(conversion, expression);
		Type classContext = getClassContext();
		if (classContext != null) {
			conversion.setContextVariable(expression, Environment.SELF_VARIABLE_NAME, classContext);
		}
	}
}
