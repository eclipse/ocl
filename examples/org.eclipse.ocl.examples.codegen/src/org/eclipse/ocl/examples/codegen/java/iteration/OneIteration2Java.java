/*******************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.java.iteration;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ValueUtil;

public class OneIteration2Java extends AbstractAccumulation2Java
{
	public static final @NonNull OneIteration2Java INSTANCE = new OneIteration2Java();

	@Override
	public void appendAccumulatorInit(@NonNull JavaStream js, @NonNull CGBuiltInIterationCallExp cgIterationCallExp) {
		js.append("0");
	}
	
	@Override
	public boolean appendFinalValue(@NonNull JavaStream js, @NonNull CGBuiltInIterationCallExp cgIterationCallExp) {
		CGIterator cgAccumulator = getAccumulator(cgIterationCallExp);
		js.appendValueName(cgIterationCallExp);
		js.append(" = ");
		js.appendValueName(cgAccumulator);
		js.append(" == 1;\n");
		return true;
	}
	
	@Override
	public boolean appendUpdate(@NonNull JavaStream js, @NonNull CGBuiltInIterationCallExp cgIterationCallExp) {
		CGValuedElement cgBody = getBody(cgIterationCallExp);
		if (cgBody.getASTypeId() == TypeId.BOOLEAN) { 
			CGIterator cgAccumulator = getAccumulator(cgIterationCallExp);
			js.append("if (");
			js.appendValueName(cgBody);
			js.append(" == ");
			js.appendClassReference(ValueUtil.class);
			js.append(".TRUE_VALUE) {			// If something found\n");
			js.pushIndentation(null);
				js.append("if (");
				js.appendValueName(cgAccumulator);
				js.append(" < 2) {\n");
				js.pushIndentation(null);
					js.appendValueName(cgAccumulator);
					js.append("++;\n");
				js.popIndentation();
				js.append("}\n");
			js.popIndentation();
			js.append("}\n");
			return true;
		}
		else {
			js.appendThrowInvalidValueException(PivotMessages.NonBooleanBody, "one");
			return true;
		}
	}

	@Override
	public @Nullable CGTypeId getAccumulatorTypeId(@NonNull CodeGenAnalyzer analyzer, @NonNull CGBuiltInIterationCallExp cgIterationCallExp) {
		return analyzer.getTypeId(JavaConstants.getJavaTypeId(int.class));
	}
}