/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
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
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainLogger;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.evaluation.AbstractEvaluationVisitorDecorator;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.Visitable;

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
	public @Nullable Object evaluate(@NonNull DomainExpression body) {
		return delegate.evaluate(body);
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @Nullable Object evaluate(@NonNull ExpressionInOCL expressionInOCL) {
		return delegate.evaluate(expressionInOCL);
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
	public @Nullable DomainLogger getLogger() {
		return delegate.getLogger();
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @NonNull MetaModelManager getMetaModelManager() {
		return delegate.getMetaModelManager();
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
	public @NonNull DomainStandardLibrary getStandardLibrary() {
		return delegate.getStandardLibrary();
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @NonNull DomainType getStaticTypeOf(@Nullable Object value) {
		
		return delegate.getStaticTypeOf(value);
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @NonNull DomainType getStaticTypeOf(@Nullable Object value,
			@NonNull Object... values) {
		return delegate.getStaticTypeOf(value, values);
	}

	/**
     * Delegates to my decorated visitor.
     */
	public @NonNull DomainType getStaticTypeOf(@Nullable Object value,
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
			assert ValuesUtil.isBoxed(result);	// Make sure Integer/Real are boxed, invalid is an exception, null is null
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
	public void setLogger(@Nullable DomainLogger loger) {
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
