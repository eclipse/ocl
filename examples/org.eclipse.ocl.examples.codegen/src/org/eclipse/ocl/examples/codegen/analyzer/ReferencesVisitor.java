/*******************************************************************************
 * Copyright (c) 2013 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.analyzer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstant;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElementId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOppositePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractExtendingCGModelVisitor;

/**
 * The ReferencesVisitor compute a list of objects referenced by (but not contained by or containing) the visited object
 * that contribute to that objects identity. The computed list may contain null elements to ensure that the returned lists
 * by two different objects exhibit positioanl equivalence.
 */
public class ReferencesVisitor extends AbstractExtendingCGModelVisitor<List<Object>, Object>
{
	public static final @NonNull ReferencesVisitor INSTANCE = new ReferencesVisitor(new Object());
	
	protected ReferencesVisitor(@NonNull Object context) {
		super(context);
	}

	protected @Nullable List<Object> append(@Nullable List<Object> iterables, Object... objects) {
		if (objects != null) {
			if (iterables == null) {
				iterables = new ArrayList<Object>();
			}
			for (Object object : objects) {
				iterables.add(object);			// Nulls too to preserve positional equivalence between alternate lists
			}
		}
		return iterables;
	}

	@Override
	public @Nullable List<Object> visiting(@NonNull CGElement visitable) {
		throw new UnsupportedOperationException("Unsupported " + getClass().getName() + " visit");
	}

	@Override
	public @Nullable List<Object> visitCGCastExp(@NonNull CGCastExp cgElement) {
		return append(super.visitCGCastExp(cgElement), cgElement.getExecutorType());
	}

	@Override
	public @Nullable List<Object> visitCGConstant(@NonNull CGConstant cgElement) {
		return append(super.visitCGConstant(cgElement), cgElement.getConstantValue());
	}

	@Override
	public @Nullable List<Object> visitCGConstantExp(@NonNull CGConstantExp cgElement) {
		return append(super.visitCGConstantExp(cgElement), cgElement.getReferredConstant());
	}

	@Override
	public @Nullable List<Object> visitCGEcoreOperation(@NonNull CGEcoreOperation cgElement) {
		return append(super.visitCGEcoreOperation(cgElement), cgElement.getEOperation());
	}

	@Override
	public @Nullable List<Object> visitCGElement(@NonNull CGElement cgElement) {
		return null;
	}

	@Override
	public @Nullable List<Object> visitCGElementId(@NonNull CGElementId cgElement) {
		return append(super.visitCGElementId(cgElement), cgElement.getASTypeId());
	}

	@Override
	public @Nullable List<Object> visitCGExecutorOperation(@NonNull CGExecutorOperation cgElement) {
		return append(super.visitCGExecutorOperation(cgElement), cgElement.getUnderlyingOperationId());
	}

	@Override
	public @Nullable List<Object> visitCGExecutorProperty(@NonNull CGExecutorProperty cgElement) {
		return append(super.visitCGExecutorProperty(cgElement), cgElement.getUnderlyingPropertyId());
	}

	@Override
	public @Nullable List<Object> visitCGExecutorType(@NonNull CGExecutorType cgElement) {
		return append(super.visitCGExecutorType(cgElement), cgElement.getUnderlyingTypeId());
	}

	@Override
	public @Nullable List<Object> visitCGNamedElement(@NonNull CGNamedElement cgElement) {
		return append(super.visitCGNamedElement(cgElement), cgElement.getName());
	}

	@Override
	public @Nullable List<Object> visitCGIterationCallExp(@NonNull CGIterationCallExp cgElement) {
		return append(super.visitCGIterationCallExp(cgElement), cgElement.getReferredIteration());
	}

	@Override
	public @Nullable List<Object> visitCGOperationCallExp(@NonNull CGOperationCallExp cgElement) {
		return append(super.visitCGOperationCallExp(cgElement), cgElement.getReferredOperation());
	}

	@Override
	public @Nullable List<Object> visitCGOppositePropertyCallExp(@NonNull CGOppositePropertyCallExp cgElement) {
		return append(super.visitCGOppositePropertyCallExp(cgElement), cgElement.getReferredProperty());
	}

	@Override
	public @Nullable List<Object> visitCGPropertyCallExp(@NonNull CGPropertyCallExp cgElement) {
		return append(super.visitCGPropertyCallExp(cgElement), cgElement.getReferredProperty());
	}

	@Override
	public @Nullable List<Object> visitCGTypeExp(@NonNull CGTypeExp cgElement) {
		return append(super.visitCGTypeExp(cgElement), cgElement.getASTypeId());
	}

	@Override
	public @Nullable List<Object> visitCGTypedElement(@NonNull CGTypedElement cgElement) {
		return append(super.visitCGTypedElement(cgElement), cgElement.getASTypeId());
	}

	@Override
	public @Nullable List<Object> visitCGVariableExp(@NonNull CGVariableExp cgElement) {
		return append(super.visitCGVariableExp(cgElement), cgElement.getReferredVariable());
	}
}