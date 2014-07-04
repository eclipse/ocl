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
package org.eclipse.ocl.examples.autogen.namereso;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoFieldingAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoReferencesVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCG2JavaVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCodeGenerator;
import org.eclipse.ocl.examples.autogen.java.AutoGlobalContext;
import org.eclipse.ocl.examples.autogen.java.IAutoCGComponentFactory;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;


public class AutoLookupFactory  implements IAutoCGComponentFactory {

	@NonNull
	public AS2CGVisitor createAS2CGVisitor(@NonNull AutoAnalyzer analyzer) {
		return new AS2CGVisitor(analyzer);
	}
	
	@NonNull
	public AnalysisVisitor createAnalysisVisitor(@NonNull AutoAnalyzer analyzer) {
		return new AnalysisVisitor(analyzer);
	}

	@NonNull
	public BoxingAnalyzer createBoxingAnalyzer(@NonNull AutoAnalyzer analyzer) {
		return new BoxingAnalyzer(analyzer);
	}

	@NonNull
	public CG2JavaPreVisitor createCG2JavaPreVisitor(
			@NonNull AutoGlobalContext javaContext) {
		return new CG2JavaPreVisitor(javaContext);
	}

	@NonNull
	public DependencyVisitor createDependencyVisitor(
			@NonNull AutoAnalyzer analyzer,
			@NonNull AutoGlobalContext globalContext,
			@NonNull GlobalPlace globalPlace) {
		return new DependencyVisitor(analyzer, globalPlace);
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
			@Nullable List<CGValuedElement> sortedGlobals) {
		return new AutoCG2JavaLookupVisitor(codeGenerator, sortedGlobals);
	}
	
	@NonNull
	public AutoGlobalContext createGlobalContext(
		@NonNull AutoCodeGenerator codeGenerator) {
		return new AutoLookupGlobalContext(codeGenerator);
	}
}
