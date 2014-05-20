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
package org.eclipse.ocl.examples.codegen.generator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cse.CommonSubexpressionEliminator;
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace;
import org.eclipse.ocl.examples.codegen.java.types.BoxedDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.UnboxedDescriptor;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public interface CodeGenerator
{
	void addProblem(@NonNull Exception e);
	@NonNull AnalysisVisitor createAnalysisVisitor();
	@NonNull BoxingAnalyzer createBoxingAnalyzer();
	@NonNull CommonSubexpressionEliminator createCommonSubexpressionEliminator();
	@NonNull DependencyVisitor createDependencyVisitor();
	@NonNull FieldingAnalyzer createFieldingAnalyzer();
	@NonNull CodeGenAnalyzer getAnalyzer();
	@NonNull BoxedDescriptor getBoxedDescriptor(@NonNull ElementId elementId);
	@Nullable String getConstantsClass();
	@NonNull String getDefaultIndent();
	@NonNull GenModelHelper getGenModelHelper();
	@NonNull GlobalContext getGlobalContext();
	@NonNull GlobalPlace getGlobalPlace();
	@Nullable IterationHelper getIterationHelper(@NonNull Iteration iteration);
	@NonNull MetaModelManager getMetaModelManager();
	@NonNull NameManager getNameManager();
	@NonNull CodeGenOptions getOptions();
	@NonNull ReferencesVisitor createReferencesVisitor();
	@NonNull TypeDescriptor getTypeDescriptor(@NonNull CGValuedElement cgElement);
	@Deprecated // Use getBoxed/UnboxedDescriptor
	@NonNull TypeDescriptor getTypeDescriptor(@NonNull ElementId elementId, boolean isBoxed);
	@Deprecated // Use getBoxed/UnboxedDescriptor and then getPrimitive()
	@NonNull TypeDescriptor getTypeDescriptor(@NonNull ElementId elementId, boolean isBoxed, boolean maybePrimitive);
	@NonNull UnboxedDescriptor getUnboxedDescriptor(@NonNull ElementId elementId);
	@Nullable DomainOperation isFinal(@NonNull Operation anOperation, @NonNull Type staticType);

	/**
	 * Return true if asOperationCallExp may return a nonNull value,
	 * false if asOperationCallExp may return a null value,
	 * null if no determination can be made.
	 */
	@Nullable Boolean isNonNull(@NonNull OperationCallExp asOperationCallExp);

	/**
	 * Return true if asProperty may provide a nonNull value,
	 * false if asOperationCallExp may provide a null value,
	 * null if no determination can be made.
	 */
	@Nullable Boolean isNonNull(@NonNull Property asProperty);

	/**
	 * Return true if cgValue could be represented by a primitive value. i.e. if it cannot convey a null or invalid value.
	 */
	boolean maybePrimitive(@NonNull CGValuedElement cgValue);
}
