/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.lookup;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaGlobalContext;

/**
 * A LookupClassContext maintains the Java-specific global context for generation of a LookupVisitor.
 */
public class LookupClassContext extends JavaGlobalContext<LookupCodeGenerator>
{
	public static final @NonNull String ADD_ELEMENTS_OF_NAME = "addElementsOf";
	public static final @NonNull String CHILD_NAME = "child";
	public static final @NonNull String CONTEXT_NAME = "context";
	public static final @NonNull String ELEMENT_NAME = "element";
	public static final @NonNull String EMPTY_ENV_NAME = "emptyEnv";
	public static final @NonNull String ENV_NAME = "_env";
	public static final @NonNull String ENV_FOR_CHILD_NAME = "envForChild";
	public static final @NonNull String HAS_FINAL_RESULT_NAME = "hasFinalResult";
	public static final @NonNull String INNER_ENV_NAME = "innerEnv";
	public static final @NonNull String NESTED_ENV_NAME = "nestedEnv";
	public static final @NonNull String OUTER_ENV_NAME = "outerEnv";
	public static final @NonNull String PARENT_NAME = "parent";
	public static final @NonNull String PARENT_ENV_NAME = "parentEnv";
	
	public LookupClassContext(@NonNull LookupCodeGenerator codeGenerator, org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		super(codeGenerator);
	}
	
	@Override
	protected @NonNull LookupLocalContext createNestedContext(@NonNull CGElement cgScope) {
		return new LookupLocalContext(this, cgScope);
	}

	public @NonNull CGValuedElement getIdResolverVariable(@NonNull CGValuedElement cgValuedElement) {
		return codeGenerator.getIdResolverVariable();
	}
}