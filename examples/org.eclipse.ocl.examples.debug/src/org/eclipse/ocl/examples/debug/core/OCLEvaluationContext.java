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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.core.EvaluationContext;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class OCLEvaluationContext extends EvaluationContext
{
	private final @Nullable Constraint constraintObject;
	private final @Nullable EObject contextObject;
	private final @NonNull URI constraintURI;
	private final @NonNull URI contextURI;

	public OCLEvaluationContext(@NonNull Constraint constraintObject, @NonNull EObject contextObject) {
		this.constraintObject = constraintObject;
		this.contextObject = contextObject;
		this.constraintURI = DomainUtil.nonNullState(EcoreUtil.getURI(constraintObject));
		this.contextURI = DomainUtil.nonNullState(EcoreUtil.getURI(contextObject));
	}

	public OCLEvaluationContext(@NonNull URI constraintURI, @NonNull URI contextURI) {
		this.constraintObject = null;
		this.contextObject = null;
		this.constraintURI = constraintURI;
		this.contextURI = contextURI;
	}

	protected @Nullable MetaModelManager findMetaModelManager() {
		Constraint constraintObject2 = constraintObject;
		if (constraintObject2 != null) {
			Resource eResource = constraintObject2.eResource();
			if (eResource != null) {
				MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(eResource);
				if (metaModelManager != null) {
					return metaModelManager;
				}
			}
		}
		EObject contextObject2 = contextObject;
		if (contextObject2 != null) {
			Resource eResource = contextObject2.eResource();
			if (eResource != null) {
				MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(eResource);
				if (metaModelManager != null) {
					return metaModelManager;
				}
			}
		}
		return null;
	}

	public @Nullable Constraint getConstraintObject() {
		return constraintObject;
	}

	public @NonNull URI getConstraintURI() {
		return constraintURI;
	}

	public @Nullable EObject getContextObject() {
		return contextObject;
	}

	public @NonNull URI getContextURI() {
		return contextURI;
	}

	public @NonNull URI getDebuggableURI() {
		return constraintURI;
	}
}
