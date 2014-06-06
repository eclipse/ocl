/*******************************************************************************
 * Copyright (c) 2010, 2013 Kenn Hussey and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Kenn Hussey - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.delegate;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.util.QueryDelegate;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.internal.delegate.OCLDelegateException;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainException;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.EvaluationException;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Query;
import org.eclipse.ocl.examples.pivot.SemanticException;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.context.EInvocationContext;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * An implementation of a query delegate for OCL expressions.
 * 
 * @see OCLQueryDelegateFactory
 * @since 3.1
 */
public class OCLQueryDelegate implements QueryDelegate
{
	protected @NonNull OCLDelegateDomain delegateDomain;
	protected final @NonNull EInvocationContext parserContext;
	protected final @NonNull String expression;
	private ExpressionInOCL specification = null;

	/**
	 * Initializes me with my domain, context, variables, and expression.
	 * 
	 * @param delegateDomain
	 *            my domain
	 * @param context
	 *            my context
	 * @param parameters
	 *            name and types of variables used in my expression
	 * @param expression
	 *            the expression that I handle
	 * 
	 * @throws ParserException
	 *             if the expression is invalid
	 */
	public OCLQueryDelegate(@NonNull OCLDelegateDomain delegateDomain, @NonNull EClassifier context, @Nullable Map<String, EClassifier> parameters, @NonNull String expression) {
		this.delegateDomain = delegateDomain;
		MetaModelManager metaModelManager = delegateDomain.getMetaModelManager();
		this.parserContext = new EInvocationContext(metaModelManager, null, context, parameters);
		this.expression = expression;
	}

	/**
	 * Executes the query for the specified <tt>target</tt> object. The result
	 * is the OCL evaluation result which may be a Number, String, Collection or
	 * other object for normal returns or a NullLiteralExp for null, or an
	 * InvalidLiteralExp for invalid.
	 * 
	 * @param target
	 *            the object on which to execute the query; this must be an
	 *            instance of the context with which the delegate was created
	 * @param arguments
	 *            a map of variable names to values; these must correspond to
	 *            the variables with which the delegate was created
	 * @return the query's result
	 * @throws InvocationTargetException
	 *             in case of failure to prepare or execute the query, usually
	 *             because of an exception
	 */
	public Object execute(@Nullable Object target, Map<String, ?> arguments) throws InvocationTargetException {
		@SuppressWarnings("null")
		@NonNull Map<String, ?> nonNullArguments = (arguments != null ? arguments : (Map<String, ?>)Collections.<String, Object>emptyMap());
		try {
			if (specification == null) {
				prepare();
			}
			@SuppressWarnings("null")
			@NonNull ExpressionInOCL nonNullSpecification = specification;
			OCL ocl = delegateDomain.getOCL();
			MetaModelManager metaModelManager = ocl.getMetaModelManager();
			IdResolver idResolver = metaModelManager.getIdResolver();
			Object targetValue = idResolver.boxedValueOf(target);
			DomainType targetType = idResolver.getStaticTypeOf(targetValue);
			DomainType requiredType = nonNullSpecification.getContextVariable().getType();
			if ((requiredType == null) || !targetType.conformsTo(metaModelManager, requiredType)) {
				String message = DomainUtil.bind(OCLMessages.WrongContextClassifier_ERROR_, targetType, requiredType);
				throw new OCLDelegateException(new SemanticException(message));
			}
			List<Variable> parameterVariables = nonNullSpecification.getParameterVariable();
			int argCount = arguments != null ? arguments.size() : 0;
			if (parameterVariables.size() != argCount) {
				String message = DomainUtil.bind(OCLMessages.MismatchedArgumentCount_ERROR_, argCount, parameterVariables.size());
				throw new OCLDelegateException(new SemanticException(message));
			}
			Query query = ocl.createQuery(nonNullSpecification);
			EvaluationEnvironment env = query.getEvaluationEnvironment();
			for (Variable parameterVariable : parameterVariables) {
				// bind arguments to parameter names
				String name = parameterVariable.getName();
				Object object = nonNullArguments.get(name);
				if ((object == null) && !nonNullArguments.containsKey(name)) {
					String message = DomainUtil.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, PivotUtil.getBody(nonNullSpecification));
					throw new OCLDelegateException(new SemanticException(message));
				}
				Object value = idResolver.boxedValueOf(object);
				targetType = idResolver.getStaticTypeOf(value);
				requiredType = DomainUtil.nonNullModel(parameterVariable.getType());
				if (!targetType.conformsTo(metaModelManager, requiredType)) {
					String message = DomainUtil.bind(OCLMessages.MismatchedArgumentType_ERROR_, name, targetType, requiredType);
					throw new OCLDelegateException(new SemanticException(message));
				}
				env.add(parameterVariable, value);
			}
			Object result = query.evaluate(target);
//			if (result.isInvalid()) {
//				String message = DomainUtil.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, getOperationName());
//				throw new OCLDelegateException(message);
//			}
	//		if ((result == null) / * || ocl.isInvalid(result) * /) {
	//			String message = DomainUtil.bind(OCLMessages.EvaluationResultIsNull_ERROR_, getOperationName());
	//			throw new OCLDelegateException(message);
	//		}
	//		return converter.convert(ocl, result);
//			if (result == null) {
//				String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, PivotUtil.getBody(specification));
//				throw new InvocationTargetException(new OCLDelegateException(message));
//			}
			Object unboxedValue = idResolver.unboxedValueOf(result);
			if (unboxedValue instanceof Number) {
				return ValuesUtil.getEcoreNumber((Number)unboxedValue, null);
			}
			else {
				return unboxedValue;
			}
		}
		catch (InvocationTargetException e) {
			throw e;
		}
		catch (DomainException e) {
			String message = DomainUtil.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, PivotUtil.getBody(specification));
			throw new InvocationTargetException(new EvaluationException(message));
		}
		catch (WrappedException e) {
			throw new InvocationTargetException(e.getCause());
		}
		catch (Exception e) {
			throw new InvocationTargetException(e);
		}
	}

	/**
	 * Prepares the query wrapping any exceptions as InvocationTargetException.
	 * This method is lazily invoked from execute, but may be invoked eagerly
	 * to detect compilation errors earlier or incur compilation costs at a more
	 * convenient time.
	 *  
	 * @throws InvocationTargetException wrapping any parser, io exceptions
	 */
	public void prepare() throws InvocationTargetException {
		try {
			specification = parserContext.parse(parserContext.getClassContext(), expression);
		} catch (Exception e) {
			throw new InvocationTargetException(e);
		}
	}

	@Override
	public String toString() {
		OCLExpression bodyExpression = specification.getBodyExpression();
		if (bodyExpression != null) {
			return "<" + delegateDomain.getURI() + ":query> " + bodyExpression; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			return "<" + delegateDomain.getURI() + ":query> " + PivotUtil.getBody(specification); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
