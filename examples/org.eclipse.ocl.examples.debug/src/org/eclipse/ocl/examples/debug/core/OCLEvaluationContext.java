/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.core;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.evaluator.OCLVMEnvironmentFactory;
import org.eclipse.ocl.examples.debug.vm.core.EvaluationContext;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;

public class OCLEvaluationContext extends EvaluationContext
{
	private final @Nullable ExpressionInOCL expressionObject;
	private final @Nullable EObject contextObject;
	private final @NonNull URI constraintURI;
	private final @Nullable URI contextURI;

	public OCLEvaluationContext(@NonNull ExpressionInOCL expressionObject, @Nullable EObject contextObject) {
		super(new OCLVMEnvironmentFactory(OCL.NO_PROJECTS, null));
		this.expressionObject = expressionObject;
		this.contextObject = contextObject;
		this.constraintURI = ClassUtil.nonNullState(EcoreUtil.getURI(expressionObject));
		this.contextURI = contextObject != null ? EcoreUtil.getURI(contextObject) : null;
	}

	public OCLEvaluationContext(@NonNull URI constraintURI, @NonNull URI contextURI) {
		super(new OCLVMEnvironmentFactory(OCL.NO_PROJECTS, null));
		this.expressionObject = null;
		this.contextObject = null;
		this.constraintURI = constraintURI;
		this.contextURI = contextURI;
	}

/*	protected @Nullable MetamodelManager findMetamodelManager() {
		ExpressionInOCL expressionObject2 = expressionObject;
		if (expressionObject2 != null) {
			Resource eResource = expressionObject2.eResource();
			if (eResource != null) {
				MetamodelManager metamodelManager = PivotUtilInternal.getMetamodelManager(eResource);
				if (metamodelManager != null) {
					return metamodelManager;
				}
			}
		}
		EObject contextObject2 = contextObject;
		if (contextObject2 != null) {
			Resource eResource = contextObject2.eResource();
			if (eResource != null) {
				MetamodelManager metamodelManager = PivotUtilInternal.getMetamodelManager(eResource);
				if (metamodelManager != null) {
					return metamodelManager;
				}
			}
		}
		return null;
	} */

	public @NonNull URI getConstraintURI() {
		return constraintURI;
	}

	public @Nullable EObject getContextObject() {
		return contextObject;
	}

	public @Nullable URI getContextURI() {
		return contextURI;
	}

	public @NonNull URI getDebuggableURI() {
		return constraintURI;
	}

	public @Nullable ExpressionInOCL getExpressionObject() {
		return expressionObject;
	}
}
