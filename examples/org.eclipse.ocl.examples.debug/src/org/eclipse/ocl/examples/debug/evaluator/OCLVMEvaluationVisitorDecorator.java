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

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.OCLDebugPlugin;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.evaluation.EvaluationLogger;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractEvaluationVisitorDecorator;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * OCLVMEvaluationVisitorDecorator is the class for ...
 */
public abstract class OCLVMEvaluationVisitorDecorator extends AbstractEvaluationVisitorDecorator<IOCLVMEvaluationVisitor>
        implements IOCLVMEvaluationVisitor {
	
	
	public OCLVMEvaluationVisitorDecorator(@NonNull IOCLVMEvaluationVisitor decorated) {
		super(decorated);
	}
	
	/**
     * Delegates to my decorated visitor.
     */
	@Override
	public @NonNull IOCLVMEvaluationVisitor createNestedEvaluator() {
        return delegate.createNestedEvaluator();
	}

	public void dispose() {}
	
	/**
     * Delegates to my decorated visitor.
     */
	public @Nullable Object evaluate(@NonNull OCLExpression body) {
		return delegate.evaluate(body);
	}

	/**
     * Delegates to my decorated visitor.
     */
	@Override
	public @NonNull EvaluationVisitor getClonedEvaluator() {
		return delegate.getClonedEvaluator();
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @NonNull CompleteEnvironment getCompleteEnvironment() {
		return delegate.getCompleteEnvironment();
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @NonNull EvaluationVisitor getEvaluator() {
		return delegate.getEvaluator();
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @NonNull IdResolver getIdResolver() {
		return delegate.getIdResolver();
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @Nullable EvaluationLogger getLogger() {
		return delegate.getLogger();
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @NonNull MetamodelManager getMetamodelManager() {
		return delegate.getMetamodelManager();
	}

	public @Nullable Monitor getMonitor() {
		return delegate.getMonitor();
	}

	@Override
	public @NonNull String getPluginId() {
		return OCLDebugPlugin.PLUGIN_ID;
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @NonNull StandardLibrary getStandardLibrary() {
		return delegate.getStandardLibrary();
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value) {
		
		return delegate.getStaticTypeOf(value);
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value,
			@NonNull Object... values) {
		return delegate.getStaticTypeOf(value, values);
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value,
			@NonNull Iterable<?> values) {
		return delegate.getStaticTypeOf(value, values);
	}

	/**
     * Delegates to my decorated visitor.
     */
	public boolean isCanceled() {
		return delegate.isCanceled();
	}
	
	@Override
	public Object safeVisit(@Nullable Visitable v) {
		if (v == null) {
			throw new InvalidValueException("null expression");
		}
		try {
			Object result = v.accept(delegate);
			assert ValueUtil.isBoxed(result);	// Make sure Integer/Real are boxed, invalid is an exception, null is null
			return result;
		} catch (InvalidValueException e) {
			throw e;
		} catch (Exception e) {
			throw new InvalidValueException(e, "Evaluation Failure");
		}
	}

	/**
     * Delegates to my decorated visitor.
     */
	public void setCanceled(boolean isCanceled) {
		delegate.setCanceled(isCanceled);
	}

	/**
     * Delegates to my decorated visitor.
     */
	public void setLogger(@Nullable EvaluationLogger loger) {
		delegate.setLogger(loger);
	}

	public void setMonitor(@Nullable Monitor monitor) {
		delegate.setMonitor(monitor);
	}

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visiting(@NonNull Visitable visitable) {
    	return delegate.visiting(visitable);
	}
}
