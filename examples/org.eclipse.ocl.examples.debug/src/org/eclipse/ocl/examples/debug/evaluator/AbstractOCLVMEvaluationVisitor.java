/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.evaluator;

import java.util.regex.Pattern;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEValuationVisitor;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationEnvironment;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationLogger;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.util.AbstractMergedVisitor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;

public abstract class AbstractOCLVMEvaluationVisitor extends AbstractMergedVisitor<Object, EvaluationVisitor> implements VMEValuationVisitor
{
	protected AbstractOCLVMEvaluationVisitor(@NonNull EvaluationVisitor nestedEvaluationVisitor) {
		super(nestedEvaluationVisitor);
		nestedEvaluationVisitor.setUndecoratedVisitor(this);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public void add(@NonNull TypedElement referredVariable, @Nullable Object value) {
		context.add(referredVariable, value);
	}
	
	/** @deprecated Evaluator no longer nests */
	@Deprecated
	@Override	
	public @NonNull EvaluationVisitor createNestedEvaluator() {
		return context.createNestedEvaluator();
	}
	
	/** @deprecated Evaluator no longer nests */
	@Deprecated
	@Override	
	public void dispose() {
		context.dispose();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull CompleteEnvironment getCompleteEnvironment() {
		return context.getCompleteEnvironment();
	}

	public abstract int getDepth();

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public int getDiagnosticSeverity(int severityPreference, @Nullable Object resultValue) {
        return context.getDiagnosticSeverity(severityPreference, resultValue);
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return context.getEnvironmentFactory();
	}

	public @NonNull EvaluationEnvironment getEvaluationEnvironment() {
		return context.getEvaluationEnvironment();
	}

	@Override
	public @NonNull Evaluator getEvaluator() {
		return context.getEvaluator();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull IdResolver getIdResolver() {
		return context.getIdResolver();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @Nullable EvaluationLogger getLogger() {
		return context.getLogger();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull MetamodelManager getMetamodelManager() {
		return context.getMetamodelManager();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull ModelManager getModelManager() {
        return context.getModelManager();
    }

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
        return context.getRegexPattern(regex);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull EvaluationEnvironment getRootEvaluationEnvironment() {
	       return context.getRootEvaluationEnvironment();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public int getSeverity(@Nullable Object validationKey) {
        return context.getSeverity(validationKey);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull StandardLibrary getStandardLibrary() {
		return context.getStandardLibrary();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value) {	
		return context.getStaticTypeOf(value);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
		return context.getStaticTypeOf(value, values);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value,	@NonNull Iterable<?> values) {
		return context.getStaticTypeOf(value, values);
	}

	public @NonNull OCLVMEvaluationEnvironment getVMEvaluationEnvironment() {
		return (OCLVMEvaluationEnvironment) context.getEvaluationEnvironment();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @Nullable Object getValueOf(@NonNull TypedElement referredVariable) {
		return context.getValueOf(referredVariable);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public void popEvaluationEnvironment() {
		context.popEvaluationEnvironment();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull EvaluationEnvironment pushEvaluationEnvironment(@NonNull NamedElement executableObject) {
		return context.pushEvaluationEnvironment(executableObject);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public void replace(@NonNull TypedElement referredVariable, @Nullable Object value) {
		context.replace(referredVariable, value);
	}

//	@Override
	protected void processDeferredTasks() {
//		IDebugEvaluationEnvironment evalEnv = getEvaluationEnvironment();
//		Transformation transformation = evalEnv.getTransformation();
//		UnitLocation startLocation = newLocalLocation(evalEnv, transformation, ASTBindingHelper.getEndPosition(transformation));//, 0);
//		try {
//			pushLocation(startLocation);

//			superProcessDeferredTasks();
//		} finally {
//			popLocation();
//		}
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public void setLogger(@Nullable EvaluationLogger logger) {
		context.setLogger(logger);
	}
	   
    protected Element setCurrentEnvInstructionPointer(Element element) {
		VMEvaluationEnvironment evalEnv = getVMEvaluationEnvironment();
    	if (element != null) {
    		return evalEnv.setCurrentIP(element);
    	}
    	else {
    		return evalEnv.getCurrentIP();
    	}
    }

	@Override
	public Object visitVariable(@NonNull Variable vd) {
		Object result = super.visitVariable(vd);
		Type declaredType = vd.getType();
//		String name = vd.getName();
		EvaluationEnvironment env = getEvaluationEnvironment();
		env.replace(vd, declaredType);
//		env.replace(name, env.getValueOf(name), declaredType);

		return result;
	}

	@Override
	public @Nullable Object evaluate(@NonNull OCLExpression body) {
		return context.evaluate(body);
	}

//	@Override
//	public @NonNull CompleteEnvironment getCompleteEnvironment() {
//		return context.getCompleteEnvironment();
//	}

//	@Override
//	public @NonNull EvaluationVisitor getEvaluator() {
//		return context.getEvaluator();
//	}

//	@Override
//	public @NonNull ModelManager getModelManager() {
//		return context.getModelManager();
//	}

//	@Override
//	public @NonNull MetamodelManager getMetamodelManager() {
//		return context.getMetamodelManager();
//	}

//	@Override
//	public int getSeverity(@Nullable Object validationKey) {
//        return context.getSeverity(validationKey);
//	}

//	@Override
//	public @NonNull StandardLibrary getStandardLibrary() {
//		return context.getStandardLibrary();
//	}

	@Override
	public void setUndecoratedVisitor(@NonNull EvaluationVisitor evaluationVisitor) {
		context.setUndecoratedVisitor(evaluationVisitor);
	}

//	@Override
//	public @NonNull IdResolver getIdResolver() {
//		return context.getIdResolver();
//	}

//	@Override
//	public @Nullable EvaluationLogger getLogger() {
//		return context.getLogger();
//	}

	public @Nullable Monitor getMonitor() {
		return context.getMonitor();
	}

//	@Override
//	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
//		return context.getRegexPattern(regex);
//	}

	public abstract @NonNull OCLVMEvaluationVisitor getVMRootEvaluationVisitor();
 
//	@Override
//	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value) {
//		return context.getStaticTypeOf(value);
//	}

//	@Override
//	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
//		return context.getStaticTypeOf(value, values);
//	}

//	@Override
//	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
//		return context.getStaticTypeOf(value, values);
//	}

	@Override
	public boolean isCanceled() {
		return context.isCanceled();
	}

	@Override
	public void setCanceled(boolean isCanceled) {
		context.setCanceled(isCanceled);
	}

//	@Override
//	public void setLogger(@Nullable EvaluationLogger logger) {
//		context.setLogger(logger);
//	}

	public void setMonitor(@Nullable Monitor monitor) {
		context.setMonitor(monitor);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + getDepth() + ")";
	}
}
