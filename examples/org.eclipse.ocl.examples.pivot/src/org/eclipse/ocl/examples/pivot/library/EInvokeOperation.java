/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.library;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractOperation;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

/**
 * An EInvokeOperation supports evaluation of an operation call by using eInvoke on the underlying eObject.
 */
public class EInvokeOperation extends AbstractOperation
{
	protected final @NonNull EOperation eOperation;	
	
	public EInvokeOperation(@NonNull EOperation eOperation) {
		this.eOperation = eOperation;
		EClassifier eType = eOperation.getEType();
		if (eType == null) {
			throw new IllegalArgumentException("Non-query EOperation");
		}
	}

	public @Nullable Object dispatch(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue) {
		TypeId typeId = callExp.getTypeId();
		List<? extends DomainExpression> arguments = callExp.getArgument();
		if (arguments.size() == 0) {
			return evaluate(evaluator, typeId, sourceValue);
		}
		DomainExpression argument0 = arguments.get(0);
		assert argument0 != null;
		Object firstArgument = evaluator.evaluate(argument0);
		if (arguments.size() == 1) {
			return evaluate(evaluator, typeId, sourceValue, firstArgument);
		}
		DomainExpression argument1 = arguments.get(1);
		assert argument1 != null;
		Object secondArgument = evaluator.evaluate(argument1);
		if (arguments.size() == 2) {
			return evaluate(evaluator, typeId, sourceValue, firstArgument, secondArgument);
		}
		Object[] argumentValues = new Object[arguments.size()];
		argumentValues[0] = firstArgument;
		argumentValues[1] = secondArgument;
		for (int i = 2; i < arguments.size(); i++) {
			DomainExpression argument = arguments.get(i);
			assert argument != null;
			argumentValues[i] = evaluator.evaluate(argument);
		}
		return evaluate(evaluator, typeId, sourceValue, argumentValues);
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue,
			@NonNull Object... argumentValues) {
		EObject eObject = asNavigableObject(sourceValue, eOperation);
		EList<Object> arguments = evaluator.getIdResolver().unboxedValuesOfEach(argumentValues);
		try {
			Object eResult = eObject.eInvoke(eOperation, arguments);
			return getResultValue(evaluator, returnTypeId, eResult);
		} catch (InvocationTargetException e) {
			return createInvalidValue(e);
		}
	}

	protected @Nullable Object getResultValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object eResult) {
		if (returnTypeId instanceof CollectionTypeId) {
			if (eResult instanceof Iterable<?>) {
				return evaluator.getIdResolver().createCollectionOfAll((CollectionTypeId)returnTypeId, (Iterable<?>)eResult);
			}
			else {
				throw new InvalidValueException("Non-iterable result");
			}
		} else if (eResult != null) {
			@SuppressWarnings("null") @NonNull EClassifier eType = eOperation.getEType();
			return evaluator.getIdResolver().boxedValueOf(eResult, eType);
		}
		else {
			return null;
		}
	}
}