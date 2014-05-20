/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.java;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;

/**
 * A JavaLocalContext maintains the Java-specific context for generation of coide from a CGOperation.
 */
public abstract class AbstractJavaContext
{
	protected @NonNull JavaCodeGenerator codeGenerator;
	protected @NonNull CodeGenAnalyzer analyzer;

	protected AbstractJavaContext(@NonNull JavaCodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
		this.analyzer = codeGenerator.getAnalyzer();
	}

	public @NonNull CodeGenAnalyzer getAnalyzer() {
		return analyzer;
	}

	public @NonNull JavaCodeGenerator getCodeGenerator() {
		return codeGenerator;
	}
}