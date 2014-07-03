/**
 * Copyright (c) 2014 Willink Transformations, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		 Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation
 */
package org.eclipse.ocl.examples.autogen.cs2as;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalysisVisitor;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoBoxingAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoDependencyVisitor;
import org.eclipse.ocl.examples.autogen.analyzer.AutoFieldingAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoReferencesVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCG2JavaPreVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCG2JavaVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCodeGenerator;
import org.eclipse.ocl.examples.autogen.java.AutoGlobalContext;
import org.eclipse.ocl.examples.autogen.java.IAutoCGComponentFactory;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;


public class AutoCS2ASFactory  implements IAutoCGComponentFactory {

	@NonNull
	public AnalysisVisitor createAnalysisVisitor(@NonNull AutoAnalyzer analyzer) {
		return new AutoAnalysisVisitor(analyzer);
	}

	@NonNull
	public BoxingAnalyzer createBoxingAnalyzer(@NonNull AutoAnalyzer analyzer) {
		return new AutoBoxingAnalyzer(analyzer);
	}

	@NonNull
	public CG2JavaPreVisitor createCG2JavaPreVisitor(
			@NonNull AutoGlobalContext javaContext) {
		return new AutoCG2JavaPreVisitor(javaContext);
	}

	@NonNull
	public DependencyVisitor createDependencyVisitor(
			@NonNull AutoAnalyzer analyzer,
			@NonNull AutoGlobalContext globalContext,
			@NonNull GlobalPlace globalPlace) {
		return new AutoDependencyVisitor(analyzer, globalContext, globalPlace);
	}

	@NonNull
	public FieldingAnalyzer createFieldingAnalyzer(
			@NonNull AutoAnalyzer analyzer) {
		return new AutoFieldingAnalyzer(analyzer);
	}

	@NonNull
	public ReferencesVisitor createReferencesVisitor() {
		return AutoReferencesVisitor.INSTANCE;
	}
	
	@NonNull
	public AutoCG2JavaVisitor createCG2JavaVisitor(
			@NonNull AutoCodeGenerator codeGenerator,
			@NonNull CGPackage cgPackage,
			@Nullable List<CGValuedElement> sortedGlobals) {
		return new AutoCG2JavaVisitor(codeGenerator, cgPackage, sortedGlobals);
	}
	
	@NonNull
	public AutoGlobalContext createGlobalContext(
		@NonNull AutoCodeGenerator codeGenerator) {
		return new AutoCS2ASGlobalContext(codeGenerator);
	}
}
