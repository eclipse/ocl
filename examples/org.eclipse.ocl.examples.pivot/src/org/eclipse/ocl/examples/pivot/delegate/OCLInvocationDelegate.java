/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.delegate;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicInvocationDelegate;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.common.internal.delegate.OCLDelegateException;
import org.eclipse.ocl.examples.domain.evaluation.DomainException;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.EvaluationException;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Query;
import org.eclipse.ocl.examples.pivot.SemanticException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.context.ClassContext;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;

/**
 * An implementation of an operation-invocation delegate for OCL body
 * expressions.
 */
public class OCLInvocationDelegate extends BasicInvocationDelegate
{
	protected final OCLDelegateDomain delegateDomain;
	private Operation operation;
	private ExpressionInOCL specification;

	/**
	 * Initializes me with my operation.
	 * 
	 * @param operation
	 *            the operation that I handle
	 */
	public OCLInvocationDelegate(@NonNull OCLDelegateDomain delegateDomain, @NonNull EOperation operation) {
		super(operation);
		this.delegateDomain = delegateDomain;
	}

	@Override
	public Object dynamicInvoke(InternalEObject target, EList<?> arguments) throws InvocationTargetException {
		try {
			OCL ocl = delegateDomain.getOCL();
			MetaModelManager metaModelManager = ocl.getMetaModelManager();
			IdResolver idResolver = metaModelManager.getIdResolver();
			ExpressionInOCL specification2 = specification;
			if (specification2 == null) {
				Operation operation2 = operation;
				NamedElement namedElement = delegateDomain.getPivot(NamedElement.class, DomainUtil.nonNullEMF(eOperation));
				if (namedElement instanceof Operation) {
					operation2 = operation = (Operation) namedElement;
					specification2 = specification = InvocationBehavior.INSTANCE.getExpressionInOCL(metaModelManager, operation2);
					InvocationBehavior.INSTANCE.validate(operation2);
				}
				else if (namedElement instanceof Constraint) {
					Constraint constraint = (Constraint)namedElement;
					specification2 = specification = getExpressionInOCL(metaModelManager, constraint);
					ValidationBehavior.INSTANCE.validate(constraint);
				}
				else {
					throw new OCLDelegateException(new SemanticException("Unsupported InvocationDelegate for a " + namedElement.eClass().getName())) ;
				}
			}
			Query query = ocl.createQuery(specification2);
			EvaluationEnvironment env = query.getEvaluationEnvironment();
			Object object = target;
			Object value = idResolver.boxedValueOf(target);
			env.add(DomainUtil.nonNullModel(specification2.getContextVariable()), value);
			List<Variable> parms = specification2.getParameterVariable();
			if (!parms.isEmpty()) {
				// bind arguments to parameter names
				for (int i = 0; i < parms.size(); i++) {
					object = arguments.get(i);
					value = idResolver.boxedValueOf(object);
					env.add(DomainUtil.nonNullModel(parms.get(i)), value);
				}
			}
			Object result = query.evaluate(target);
//			if (result == null) {
//				String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, operation);
//				throw new InvocationTargetException(new OCLDelegateException(message));
//			}
			Object unboxedValue = idResolver.unboxedValueOf(result);
			if (unboxedValue instanceof Number) {
				return ValuesUtil.getEcoreNumber((Number)unboxedValue, eOperation.getEType().getInstanceClass());
			}
			else {
				return unboxedValue;
			}
		}
		catch (DomainException e) {
			String message = DomainUtil.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, operation);
			throw new OCLDelegateException(new EvaluationException(message, e));
		}
	}

	public @NonNull ExpressionInOCL getExpressionInOCL(@NonNull MetaModelManager metaModelManager, @NonNull Constraint constraint) {
		ExpressionInOCL query = null;
		OpaqueExpression valueSpecification = constraint.getSpecification();
		if (valueSpecification instanceof ExpressionInOCL) {
			query = (ExpressionInOCL) valueSpecification;
		}
		else {
			Type contextType = (Type) constraint.getContext();
			if (contextType != null) {
				ClassContext classContext = new ClassContext(metaModelManager, null, contextType);
				query = ValidationBehavior.INSTANCE.getExpressionInOCL(classContext, constraint);
			}
		}
		if (query == null) {
			String message = DomainUtil.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, constraint.getContext());
			throw new OCLDelegateException(new SemanticException(message));
		}
		return query;
	}

	public @NonNull Operation getOperation() {
		Operation operation2 = operation;
		if (operation2 == null) {
			NamedElement pivot = delegateDomain.getPivot(NamedElement.class, DomainUtil.nonNullEMF(eOperation));
			if (pivot instanceof Operation) {
				operation2 = operation = (Operation) pivot;
			}
			if (operation2 == null) {
				throw new OCLDelegateException(new SemanticException("No pivot property for " + eOperation)) ;
			}
		}
		return operation2;
	}
	
	@Override
	public String toString() {
		if (operation != null) {
			return "<" + delegateDomain.getURI() + ":invocation> " + operation; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			String name = eOperation.getEContainingClass().getEPackage().getName()
			+ "::" + eOperation.getEContainingClass().getName()
			+ "." + eOperation.getName();
			return "<" + delegateDomain.getURI() + ":invocation> " + name; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
