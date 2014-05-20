/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.analyzer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.autogen.java.AutoCodeGenerator;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;

public class AutoAnalyzer extends CodeGenAnalyzer
{
	public AutoAnalyzer(@NonNull AutoCodeGenerator codeGenerator) {
		super(codeGenerator);
	}
}
