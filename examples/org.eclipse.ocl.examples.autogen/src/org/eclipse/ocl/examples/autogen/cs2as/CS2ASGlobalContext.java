/*******************************************************************************
 * Copyright (c) 2013, 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLocalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaGlobalContext;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

/**
 * A AutoGlobalContext maintains the Java-specific global context for generation of Auto code.
 */
public class CS2ASGlobalContext extends JavaGlobalContext<CS2ASCodeGenerator>
{
	private /*@LazyNonNull*/ CGLocalVariable idResolver = null;
	
	public CS2ASGlobalContext(@NonNull CS2ASCodeGenerator codeGenerator) {
		super(codeGenerator);
		nameManager.reserveName(JavaConstants.EVALUATOR_NAME, null);
		nameManager.reserveName("context", null);
		nameManager.reserveName("converter", null);
		nameManager.reserveName("element", null);
		nameManager.reserveName(PivotConstants.RESULT_NAME, null);
	}
	
	@Override
	protected @NonNull CS2ASLocalContext createNestedContext(@NonNull CGElement cgScope) {
		return new CS2ASLocalContext(this, cgScope);
	}

	public @NonNull CGValuedElement getIdResolverVariable(@NonNull CGValuedElement cgValuedElement) {
		CGLocalVariable idResolver2 = idResolver;
		if (idResolver2 == null) {
			idResolver = idResolver2 = CGModelFactory.eINSTANCE.createCGLocalVariable();
			idResolver2.setName(JavaConstants.ID_RESOLVER_NAME);
			idResolver2.setValueName(JavaConstants.ID_RESOLVER_NAME);
			idResolver2.setTypeId(analyzer.getTypeId(JavaConstants.ID_RESOLVER_TYPE_ID));
			idResolver2.setNonInvalid();
			idResolver2.setNonNull();
		}
		return idResolver2;
	}
}