/*******************************************************************************
 * Copyright (c) 2005, 2013 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 253252
 *   Radek Dvorak - Bugs 261128, 265066
 *   E.D.Willink - Bug 297541
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.evaluation.EvaluationHaltedException;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.library.EvaluatorMultipleIterationManager;
import org.eclipse.ocl.examples.domain.library.EvaluatorSingleIterationManager;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.NavigationCallExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.PivotIdResolver;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * An evaluation visitor implementation for OCL expressions.
 */
public class EvaluationVisitorImpl extends AbstractEvaluationVisitor
{
	public static boolean isSimpleRange(@NonNull CollectionLiteralExp cl) {
		List<CollectionLiteralPart> partsList = cl.getPart();
		int size = partsList.size();
		if (size == 1) {
			CollectionLiteralPart part = partsList.get(0);
			return part instanceof CollectionRange;
		}
		return false;
	}
	
	/**
	 * Constructor
	 * 
	 * @param env
	 *            an evaluation environment (map of variable names to values)
	 * @param modelManager
	 *            a map of classes to their instance lists
	 */
	public EvaluationVisitorImpl( @NonNull Environment env,  @NonNull EvaluationEnvironment evalEnv, @NonNull DomainModelManager modelManager) {
		super(env, evalEnv, modelManager);
	}
	
	// FIXME Revise API so that cannot invoke createNestedEvaluator() by mistake
	public @NonNull EvaluationVisitor createNestedEvaluator() {
		Environment environment = getEnvironment();
		EnvironmentFactory factory = environment.getFactory();
    	EvaluationEnvironment nestedEvalEnv = factory.createEvaluationEnvironment(getEvaluationEnvironment());
		EvaluationVisitorImpl nestedEvaluationVisitor = new EvaluationVisitorImpl(environment, nestedEvalEnv, getModelManager());
		nestedEvaluationVisitor.setMonitor(getMonitor());
		return nestedEvaluationVisitor;
	}
	
	// FIXME Revise API so that cannot invoke createNestedEvaluator() by mistake
	public @NonNull EvaluationVisitor createNestedUndecoratedEvaluator(@NonNull NamedElement operation) { // FIXME Pass 'operation'
		return undecoratedVisitor.createNestedEvaluator();
	}

	public void dispose() {
		if (undecoratedVisitor != this) {
			undecoratedVisitor.dispose();
		}
	}

	public @Nullable Object evaluate(@NonNull DomainExpression body) {
		Object value = ((OCLExpression) body).accept(undecoratedVisitor);
		assert ValuesUtil.isBoxed(value);	// Make sure Integer/Real are boxed, invalid is an exception, null is null
		return value;
	}

	public @Nullable Object evaluate(@NonNull ExpressionInOCL expressionInOCL) {
		Object value = expressionInOCL.accept(undecoratedVisitor);
		assert ValuesUtil.isBoxed(value);	// Make sure Integer/Real are boxed, invalid is an exception, null is null
		return value;
	}

	protected Object evaluatePropertyCallExp(@NonNull NavigationCallExp propertyCallExp, @NonNull Property referredProperty) {
		OCLExpression source = propertyCallExp.getSource();
		Type propertyType = propertyCallExp.getType();
		assert propertyType != null;
		EvaluationVisitor evaluationVisitor = undecoratedVisitor;
		Object sourceValue = source != null ? evaluationVisitor.evaluate(source) : null;
		LibraryProperty implementation = metaModelManager.getImplementation(sourceValue, referredProperty);
		try {
			return implementation.evaluate(this, propertyType.getTypeId(), sourceValue);
		}
		catch (InvalidValueException e) {
			throw e;
		}
		catch (Exception e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, "Failed to evaluate '" + referredProperty + "'", sourceValue, propertyCallExp);
		}
	}

	public @NonNull EvaluationVisitor getEvaluator() {
		return this;
	}

	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainType dynamicType, @NonNull DomainOperation staticOperation) {
		DomainInheritance inheritance = metaModelManager.getInheritance(dynamicType);
		return inheritance.lookupImplementation(metaModelManager, staticOperation);
	}

	@Override
	public Object safeVisit(@Nullable Visitable v) {
		if (v == null) {
			throw new InvalidValueException("null expression");
		}
		try {
			Object result = v.accept(undecoratedVisitor);
			assert ValuesUtil.isBoxed(result);	// Make sure Integer/Real are boxed, invalid is an exception, null is null
			return result;
		} catch (InvalidValueException e) {
			throw e;
		} catch (Exception e) {
			throw new InvalidValueException(e, "Evaluation Failure");
		}
	}


	/**
	 * Callback for an AssociationClassCallExp visit. Evaluates the source of the
	 * expression and then reflectively gets the value of the reference on the
	 * result. For example, in "self.foo", "self" is the source and would be
	 * evaluated first, then the value of the reference "foo" would be derived
	 * on that object.
	 */
	@Override
    public Object visitAssociationClassCallExp(@NonNull AssociationClassCallExp ae) {
		Object context = ae.getSource().accept(undecoratedVisitor);
		
//		if ((context == null) || ValuesUtil.isUndefined(context)) {
//			return evaluationEnvironment.throwInvalidEvaluation("Undefined context for AssociationClassCall", ae);
//		}
//		context = ValuesUtil.asValidValue(context);
		// evaluate attribute on source value
		return evaluationEnvironment.navigateAssociationClass(
			ae.getReferredAssociationClass(),
			ae.getNavigationSource(),
			context);
	}

	/**
	 * Callback for a BooleanLiteralExp visit.
	 * 
	 * @return the value of the boolean literal as a java.lang.Boolean.
	 */
	@Override
    public Object visitBooleanLiteralExp(@NonNull BooleanLiteralExp booleanLiteralExp) {
    	boolean value = booleanLiteralExp.isBooleanSymbol();
		return value;
	}

	@Override
	public Object visitCollectionItem(@NonNull CollectionItem item) {
		throw new UnsupportedOperationException("evaluation of CollectionItem"); //$NON-NLS-1$
	}

	/**
	 * Callback for a CollectionLiteralExp visit.
	 */
	@Override
    public Object visitCollectionLiteralExp(@NonNull CollectionLiteralExp cl) {
		// construct the appropriate collection from the parts
		// based on the collection kind.
		List<CollectionLiteralPart> parts = cl.getPart();
		DomainCollectionType type = (DomainCollectionType) cl.getType();
		boolean isOrdered = type.isOrdered();
		if (isOrdered && isSimpleRange(cl)) {
			// literal is of the form: Sequence{first..last}.
			// construct a list with a lazy iterator for it.
			CollectionRange collRange = (CollectionRange) parts.get(0);
			OCLExpression first = collRange.getFirst();
			OCLExpression last = collRange.getLast();

			// evaluate first value
			Object firstVal = first.accept(undecoratedVisitor);
//			if (firstVal == null) {
//				return evaluationEnvironment.throwInvalidEvaluation("Invalid first element", cl, first);
//			}
			// evaluate last value
			Object lastVal = last.accept(undecoratedVisitor);
//			if (lastVal == null) {
//				return evaluationEnvironment.throwInvalidEvaluation("Invalid last element", cl, last);
//			}
			IntegerValue firstInteger;
//			try {
				firstInteger = ValuesUtil.asIntegerValue(firstVal);
//			} catch (InvalidValueException e) {
//				return evaluationEnvironment.throwInvalidEvaluation(e, cl, firstVal, "Non integer first element");
//			}
			IntegerValue lastInteger;
//			try {
				lastInteger = ValuesUtil.asIntegerValue(lastVal);
//			} catch (InvalidValueException e) {
//				return evaluationEnvironment.throwInvalidEvaluation(e, cl, lastVal, "Non integer last element");
//			}
			// construct a lazy integer list for the range
//			try {
				CollectionTypeId typeId = type.getTypeId();
				IntegerRange range = ValuesUtil.createRange(firstInteger, lastInteger);
				if (type.isUnique()) {
					return ValuesUtil.createOrderedSetRange(typeId, range);
				}
				else {
					return ValuesUtil.createSequenceRange(typeId, range);
				}
//			} catch (InvalidValueException e) {
//				return evaluationEnvironment.throwInvalidEvaluation(e, cl, lastVal, "Non integer first or last element");
//			}
		} else
		{
			List<Object> orderedResults = new ArrayList<Object>();
			Set<Object> uniqueResults = type.isUnique() ? new HashSet<Object>() : null;
					// not a sequence or not a simple range
			for (CollectionLiteralPart part : parts) {
				if (part instanceof CollectionItem) {
					// CollectionItem part
					CollectionItem item = (CollectionItem) part;
					OCLExpression itemExp = item.getItem();
					Object itemVal = itemExp.accept(undecoratedVisitor);
//					Object itemValue = ValuesUtil.asValidValue(itemVal);
					if ((uniqueResults == null) || uniqueResults.add(itemVal)) {
						orderedResults.add(itemVal);
					}
				} else {
					// Collection range
					CollectionRange range = (CollectionRange) part;
					OCLExpression first = range.getFirst();
					OCLExpression last = range.getLast();

					// evaluate first value
					Object firstVal = first.accept(undecoratedVisitor);
//					if (firstVal == null) {
//						return evaluationEnvironment.throwInvalidEvaluation("Invalid first element", cl, first);
//					}
					Object lastVal = last.accept(undecoratedVisitor);
//					if (lastVal == null) {
//						return evaluationEnvironment.throwInvalidEvaluation("Invalid last element", cl, last);
//					}
					IntegerValue firstInteger;
//					try {
						firstInteger = ValuesUtil.asIntegerValue(firstVal);
//					} catch (InvalidValueException e) {
//						return evaluationEnvironment.throwInvalidEvaluation(e, cl, firstVal, "Non integer first element");
//					}
					IntegerValue lastInteger;
//					try {
						lastInteger = ValuesUtil.asIntegerValue(lastVal);
//					} catch (InvalidValueException e) {
//						return evaluationEnvironment.throwInvalidEvaluation(e, cl, lastVal, "Non integer last element");
//					}
					Integer firstInt;
//					try {
						firstInt = firstInteger.asInteger();
//					} catch (InvalidValueException e) {
//						return evaluationEnvironment.throwInvalidEvaluation(e, cl, firstInteger, "Out of range first element");
//					}
					Integer lastInt;
//					try {
						lastInt = lastInteger.asInteger();
//					} catch (InvalidValueException e) {
//						return ValuesUtil.createInvalidValue("Out of range last element", e, cl, lastInteger, );
//					}
					// TODO: enhance IntegerRangeList to support multiple ranges
					// add values between first and last inclusive
					for (int i = firstInt; true; i++) {
                        IntegerValue integerValue = ValuesUtil.integerValueOf(i);
    					if ((uniqueResults == null) || uniqueResults.add(integerValue)) {
    						orderedResults.add(integerValue);
    					}
                        if (i >= lastInt) {
                        	break;
                        }
                    }
				} // end of collection range

			} // end of parts iterator
			return getIdResolver().createCollectionOfAll(type.isOrdered(), type.isUnique(), DomainUtil.nonNullModel(type.getElementType()).getTypeId(), orderedResults);
		} // end of not-simple range case
	} // end of Set, OrderedSet, Bag Literals

	@Override
	public Object visitCollectionRange(@NonNull CollectionRange range) {
		throw new UnsupportedOperationException("evaluation of CollectionRange"); //$NON-NLS-1$
	}

    @Override
	public Object visitConstructorExp(@NonNull ConstructorExp ce) {
		DomainType type = ce.getType();
		String value = ce.getValue();
		Object object;
		if (value == null) {
			object = type.createInstance();
			for (ConstructorPart part : ce.getPart()) {
				OCLExpression initExpression = part.getInitExpression();
				if (initExpression != null) {
					Object boxedValue = undecoratedVisitor.evaluate(initExpression);
					Object unboxedValue = getIdResolver().unboxedValueOf(boxedValue);
					part.getReferredProperty().initValue(object, unboxedValue);
				}
			}
		}
		else {
			object = type.createInstance(value);
		}
		return object != null ? ValuesUtil.createObjectValue(type.getTypeId(), object) : null;
    }

	/**
	 * Callback for an EnumLiteralExp visit. Get the referred enum literal and
	 * return it as an Integer.
	 * 
	 * @param el
	 *            the enumeration literal expresion
	 * @return the enumeration literal as an Integer
	 */
	@Override
    public Object visitEnumLiteralExp(@NonNull EnumLiteralExp el) {
		EnumerationLiteral enumLiteral = el.getReferredEnumLiteral();
		assert enumLiteral != null;
		EnumerationLiteralId enumerationLiteralId = enumLiteral.getEnumerationLiteralId();
		DomainModelManager modelManager = getModelManager();
		boolean isUML = (modelManager instanceof PivotModelManager) && ((PivotModelManager)modelManager).isUML();
		if (isUML) {		// FIXME BUG 448470 UML EnumerationLiterals should consistently unboxed
			PivotIdResolver idResolver = metaModelManager.getIdResolver();
			return idResolver.unboxedValueOfUML(enumerationLiteralId);
		}
		else {
			return enumerationLiteralId;
		}
	}

//	private static int depth = 0;
	@Override
	public Object visitExpressionInOCL(@NonNull ExpressionInOCL expression) {
		if ((monitor != null) && monitor.isCanceled()) {
			throw new EvaluationHaltedException("Canceled");
		}
//		Object object = getEvaluationEnvironment().getValueOf(expression.getContextVariable());
//		System.out.println(++depth + " " + expression.getContextVariable() + " = " + object + "\n\t" + expression);
//		try {
			Object result = safeVisit(expression.getBodyExpression());
//			System.out.println(depth + "\t=> " + result);
			return result;
//		}
//		catch (RuntimeException e) {
//			System.out.println(depth + "\t=> " + e);
//			throw e;
//		}
//		finally {
//			--depth;
//		}
	}

	/**
	 * Callback for an IfExp visit.
	 */
	@Override
    public Object visitIfExp(@NonNull IfExp ifExp) {
		OCLExpression condition = ifExp.getCondition();
		Object acceptedValue = condition.accept(undecoratedVisitor);
		Object evaluatedCondition = ValuesUtil.asBoolean(acceptedValue);
		OCLExpression expression = null;
		if (evaluatedCondition == ValuesUtil.TRUE_VALUE) {
			expression = ifExp.getThenExpression();
		}
		else {
			expression = ifExp.getElseExpression();
		}
		return expression.accept(undecoratedVisitor);
	}

	/**
	 * Callback for an IntegerLiteralExp visit.
	 * 
	 * @return the value of the integer literal as a java.lang.Integer.
	 */
	@Override
    public Object visitIntegerLiteralExp(@NonNull IntegerLiteralExp integerLiteralExp) {
		Number integerSymbol = integerLiteralExp.getIntegerSymbol();
		return integerSymbol != null ? ValuesUtil.integerValueOf(integerSymbol) : null;
	}

	@Override
    public Object visitInvalidLiteralExp(@NonNull InvalidLiteralExp invalidLiteralExp) {
		throw ValuesUtil.INVALID_VALUE;
	}

	/**
	 * Callback for an IterateExp visit.
	 */
	@Override
    public Object visitIterateExp(@NonNull IterateExp iterateExp) {
		if (isCanceled()) {
			throw new EvaluationHaltedException("Canceled");
		}
		Iteration staticIteration = DomainUtil.nonNullModel(iterateExp.getReferredIteration());
		OCLExpression source = iterateExp.getSource();
		Object acceptedValue = source.accept(undecoratedVisitor);
		CollectionValue sourceValue = ValuesUtil.asCollectionValue(acceptedValue);
		DomainType dynamicSourceType = metaModelManager.getIdResolver().getType(sourceValue.getTypeId(), null);
		LibraryIteration implementation = (LibraryIteration) dynamicSourceType.lookupImplementation(metaModelManager, staticIteration);
/*		Operation dynamicIteration = metaModelManager.getDynamicOperation((org.eclipse.ocl.examples.pivot.Type) dynamicSourceType, staticIteration);
 		if (dynamicIteration == null) {
 			dynamicIteration = staticIteration;
 		}
 		LibraryIteration implementation1;
		try {
			implementation = (LibraryIteration) metaModelManager.getImplementation(dynamicIteration);
		} catch (Exception e) {
			String implementationClass = dynamicIteration.getImplementationClass();
			if (implementationClass != null) {
				return evaluationEnvironment.throwInvalidEvaluation(e, iterateExp, null, EvaluatorMessages.ImplementationClassLoadFailure, implementationClass);
			}
			else {
				return evaluationEnvironment.throwInvalidEvaluation(e, iterateExp, null, "Failed to load implementation for '" + dynamicIteration + "'");
			}
		} */
		Object result = null;
		try {
			Variable accumulator = iterateExp.getResult();
			Object initValue = accumulator.getInitExpression().accept(undecoratedVisitor);
//			if ((initValue == null) || ValuesUtil.isUndefined(initValue)) {
//				return evaluationEnvironment.throwInvalidEvaluation(null, iterateExp, initValue, EvaluatorMessages.UndefinedInitialiser);
//			}
//			initValue = ValuesUtil.asValidValue(initValue);
			DomainIterationManager iterationManager;
			VariableDeclaration accumulatorVariable = accumulator;
			OCLExpression body = DomainUtil.nonNullModel(iterateExp.getBody());
			List<Variable> iterators = iterateExp.getIterator();
			int iSize = iterators.size();
			if (iSize == 1) {
				VariableDeclaration firstIterator = DomainUtil.nonNullModel(iterators.get(0));
				iterationManager = new EvaluatorSingleIterationManager(undecoratedVisitor, body, sourceValue, accumulatorVariable, initValue, firstIterator);
			}
			else {
				VariableDeclaration[] variables = new VariableDeclaration[iSize];
				for (int i = 0; i < iSize; i++) {
					variables[i] = iterators.get(i); 
				}
				iterationManager = new EvaluatorMultipleIterationManager(undecoratedVisitor, body, sourceValue, accumulatorVariable, initValue, variables);
			}
			result = implementation.evaluateIteration(iterationManager);
//		} catch (InvalidValueException e) {
//			return evaluationEnvironment.throwInvalidEvaluation(e);
		} catch (InvalidValueException e) {
			throw e;
		} catch (Exception e) {
			// This is a backstop. Library iterations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, "Failed to evaluate '" + staticIteration + "'", sourceValue, iterateExp);	// FIXME dymamicIteration throughout
		}
		return result;
	}

	/**
	 * Callback for an IteratorExp visit.
	 */
	@Override
    public Object visitIteratorExp(@NonNull IteratorExp iteratorExp) {
		if ((monitor != null) && monitor.isCanceled()) {
			throw new EvaluationHaltedException("Canceled");
		}
		Iteration staticIteration = DomainUtil.nonNullModel(iteratorExp.getReferredIteration());
		CollectionValue sourceValue;
//		try {
			OCLExpression source = iteratorExp.getSource();
			Object sourceVal = source.accept(undecoratedVisitor);
//			if (sourceVal == null) {
//				return evaluationEnvironment.throwInvalidEvaluation("null iterator source");
//			}
			sourceValue = ValuesUtil.asCollectionValue(sourceVal);
//		} catch (InvalidValueException e) {
//			return evaluationEnvironment.throwInvalidEvaluation(e);
//		}
		DomainType dynamicSourceType = metaModelManager.getIdResolver().getType(sourceValue.getTypeId(), null);
		LibraryIteration implementation = (LibraryIteration) dynamicSourceType.lookupImplementation(metaModelManager, staticIteration);
/*		Operation dynamicIteration = metaModelManager.getDynamicOperation((org.eclipse.ocl.examples.pivot.Type) dynamicSourceType, staticIteration);
 		if (dynamicIteration == null) {
 			dynamicIteration = staticIteration;
 		}
 		LibraryIteration implementation;
		try {
			implementation = (LibraryIteration) metaModelManager.getImplementation(dynamicIteration);
		} catch (Exception e) {
			String implementationClass = dynamicIteration.getImplementationClass();
			if (implementationClass != null) {
				return evaluationEnvironment.throwInvalidEvaluation(e, iteratorExp, null, EvaluatorMessages.ImplementationClassLoadFailure, implementationClass);
			}
			else {
				return evaluationEnvironment.throwInvalidEvaluation(e, iteratorExp, null, "Failed to load implementation for '" + dynamicIteration + "'");
			}
		} */
		Object result = null;
		try {
			DomainIterationManager iterationManager;
			OCLExpression body = iteratorExp.getBody();
			Type iterationType = PivotUtil.getType(DomainUtil.nonNullModel(iteratorExp.getType()));
			Type bodyType = PivotUtil.getType(DomainUtil.nonNullModel(body.getType()));
			Object accumulatorValue = implementation.createAccumulatorValue(undecoratedVisitor, iterationType.getTypeId(), bodyType.getTypeId());
			List<Variable> iterators = iteratorExp.getIterator();
			int iSize = iterators.size();
			if (iSize == 1) {
				VariableDeclaration firstIterator = DomainUtil.nonNullModel(iterators.get(0));
				iterationManager = new EvaluatorSingleIterationManager(undecoratedVisitor, body, sourceValue, null, accumulatorValue, firstIterator);
			}
			else {
				VariableDeclaration[] variables = new VariableDeclaration[iSize];
				for (int i = 0; i < iSize; i++) {
					variables[i] = iterators.get(i);
				}
				iterationManager = new EvaluatorMultipleIterationManager(undecoratedVisitor, body, sourceValue, null, accumulatorValue, variables);
			}
			result = implementation.evaluateIteration(iterationManager);
//		} catch (InvalidValueException e) {
//			return evaluationEnvironment.throwInvalidEvaluation(e);
		} catch (InvalidValueException e) {
			throw e;
		} catch (Exception e) {
			// This is a backstop. Library iterations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, "Failed to evaluate '" + staticIteration + "'", sourceValue, iteratorExp);
		}
		return result;
	}

	/**
	 * Callback for LetExp visit.
	 */
	@Override
    public Object visitLetExp(@NonNull LetExp letExp) {
		OCLExpression expression = letExp.getIn();		// Never null when valid
		Variable variable = letExp.getVariable();		// Never null when valid
		assert variable != null;
		Object value;
		try {
			value = variable.accept(undecoratedVisitor);
		}
		catch (EvaluationHaltedException e) {
			throw e;
		}
		catch (InvalidValueException e) {
			value = e;
		}
//		value = ValuesUtil.asValue(value);
    	EvaluationVisitor nestedVisitor = undecoratedVisitor.createNestedEvaluator();		
		nestedVisitor.getEvaluationEnvironment().add(variable, value);
		try {
			return expression.accept(nestedVisitor);
		}
		finally {
			nestedVisitor.dispose();
		}
	}
	
	@Override
    public Object visitMessageExp(@NonNull MessageExp m) {
		throw new UnsupportedOperationException("evaluation of MessageExp"); //$NON-NLS-1$
/*        T targetResult = safeVisit(messageExp.getTarget());        
        List<T> argumentResults;
        List<OCLExpression> arguments = messageExp.getArgument();       
        if (arguments.isEmpty()) {
            argumentResults = Collections.emptyList();
        } else {
            argumentResults = new java.util.ArrayList<T>(arguments.size());
            for (OCLExpression qual : arguments) {
                argumentResults.add(safeVisit(qual));
            }
        }        
        return handleMessageExp(messageExp, targetResult, argumentResults);
*/	}

	@Override
    public Object visitNullLiteralExp(@NonNull NullLiteralExp nullLiteralExp) {
		return null;
	}

	/**
	 * Callback for an OperationCallExp visit.
	 */
	@Override
    public Object visitOperationCallExp(@NonNull OperationCallExp operationCallExp) {
		if ((monitor != null) && monitor.isCanceled()) {
			throw new EvaluationHaltedException("Canceled");
		}
		DomainEvaluator evaluator = undecoratedVisitor.getEvaluator();
		Operation staticOperation = operationCallExp.getReferredOperation();
		assert staticOperation != null;
		//
		//	Resolve source value
		//
 		Object sourceValue;
		OCLExpression source = operationCallExp.getSource();
		boolean isValidating = staticOperation.isValidating();
		if (isValidating) {
			try {
				sourceValue = source.accept(undecoratedVisitor);
			}
			catch (EvaluationHaltedException e) {
				throw e;
			}
			catch (InvalidValueException e) {
				sourceValue = e;	// FIXME ?? propagate part of environment
			}
		}
		else {
			sourceValue = source.accept(undecoratedVisitor);
		}
		//
		//	Resolve source dispatch type
		//
 		PivotIdResolver idResolver = metaModelManager.getIdResolver();
		DomainType dynamicSourceType = idResolver.getStaticTypeOf(sourceValue);
		List<Parameter> ownedParameters = staticOperation.getOwnedParameter();
		if ((ownedParameters.size() == 1) && (ownedParameters.get(0).getType() instanceof SelfType)) {
			//
			//	Resolve and dispatch OclSelf operation
			//
			List<OCLExpression> arguments = operationCallExp.getArgument();
			Object onlyArgument = arguments.get(0).accept(undecoratedVisitor);
			if (onlyArgument != null) {
				DomainType argType = idResolver.getStaticTypeOf(onlyArgument);
				dynamicSourceType = dynamicSourceType.getCommonType(idResolver, argType);
			}
			LibraryBinaryOperation implementation = (LibraryBinaryOperation) dynamicSourceType.lookupImplementation(metaModelManager, staticOperation);
			try {
				Object result = implementation.evaluate(evaluator, operationCallExp.getTypeId(), sourceValue, onlyArgument);
				assert !(result instanceof NullValue);
				return result;
			} catch (InvalidValueException e) {
				throw e;
			} catch (Exception e) {
				// This is a backstop. Library operations should catch their own exceptions
				//  and produce a better reason as a result.
				throw new InvalidValueException(e, "Failed to evaluate '" + staticOperation + "'", sourceValue, operationCallExp);
			}
	 	}
		else {
			//
			//	Resolve and dispatch regular operation
			//
			LibraryOperation implementation = (LibraryOperation) dynamicSourceType.lookupImplementation(metaModelManager, staticOperation);
			try {
				Object result = implementation.dispatch(evaluator, operationCallExp, sourceValue);
				assert !(result instanceof NullValue);
				return result;
			} catch (InvalidValueException e) {
				throw e;
			} catch (Exception e) {
				// This is a backstop. Library operations should catch their own exceptions
				//  and produce a better reason as a result.
				throw new InvalidValueException(e, "Failed to evaluate '" + staticOperation + "'", sourceValue, operationCallExp);
			}
		}
	}

	/**
	 * Callback for an OppositePropertyCallExp visit.
	 */
	@Override
    public Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp oppositePropertyCallExp) {
		Property oppositeReferredProperty = oppositePropertyCallExp.getReferredProperty();
		Property referredProperty = oppositeReferredProperty.getOpposite();
		assert referredProperty != null;
		return evaluatePropertyCallExp(oppositePropertyCallExp, referredProperty);
	}

	/**
	 * Callback for a PropertyCallExp visit.
	 */
	@Override
    public Object visitPropertyCallExp(@NonNull PropertyCallExp propertyCallExp) {
		Property referredProperty = propertyCallExp.getReferredProperty();
		assert referredProperty != null;
		return evaluatePropertyCallExp(propertyCallExp, referredProperty);
	}
	
	/**
	 * Callback for a RealLiteralExp visit.
	 * 
	 * @return the value of the real literal as a java.lang.Double.
	 */
	@Override
    public Object visitRealLiteralExp(@NonNull RealLiteralExp realLiteralExp) {
		Number realSymbol = realLiteralExp.getRealSymbol();
		return realSymbol != null ? ValuesUtil.realValueOf(realSymbol) : null;
	}
	
	@Override
    public Object visitStateExp(@NonNull StateExp s) {
		return s.getReferredState();
	}

	/**
	 * Callback for a StringLiteralExp visit.
	 * 
	 * @return the value of the string literal as a java.lang.String.
	 */
	@Override
    public Object visitStringLiteralExp(@NonNull StringLiteralExp stringLiteralExp) {
		String value = stringLiteralExp.getStringSymbol();
		if (value == null) {
			throw new InvalidValueException("Invalid String Value", stringLiteralExp);
		}
		return value;
	}

	/**
	 * Callback for a TupleLiteralExp visit.
	 * 
	 * @param tl
	 *            tuple literal expression
	 * @return String
	 */
	@Override
    public Object visitTupleLiteralExp(@NonNull TupleLiteralExp tl) {
		DomainType type = DomainUtil.nonNullModel(tl.getType());
		Map<TuplePartId, Object> propertyValues = new HashMap<TuplePartId, Object>();		
		for (TupleLiteralPart part : tl.getPart()) {
			// Set the tuple field with the value of the init expression
			propertyValues.put(part.getPartId(), part.accept(undecoratedVisitor));
		}
//		TupleType tupleType = metaModelManager.getTupleType(type.getName(), propertyValues.keySet());
		return ValuesUtil.createTupleValue(((TupleType) type).getTupleTypeId(), propertyValues);
	}
	
	@Override
    public Object visitTupleLiteralPart(@NonNull TupleLiteralPart tp) {
		return tp.getInitExpression().accept(undecoratedVisitor);
	}

	/**
	 * Callback for a TypeExp visit.
	 */
	@Override
    public Object visitTypeExp(@NonNull TypeExp t) {
//		DomainMetaclass domainMetaclass = (DomainMetaclass)t.getType();
//		DomainType instanceType = domainMetaclass.getInstanceType();
//		assert instanceType != null;
//		return ValuesUtil.createTypeValue(instanceType);
//		DomainMetaclass domainMetaclass = (DomainMetaclass)t.getType();
//		DomainType instanceType = domainMetaclass.getInstanceType();
//		assert instanceType != null;
		return t.getReferredType();
	}
    
    /**
     * Callback for an UnlimitedNaturalLiteralExp visit.
     * 
     * @return the value of the natural literal as a java.lang.Integer.
     */
    @Override
    public Object visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp unlimitedNaturalLiteralExp) {
		Number unlimitedNaturalSymbol = unlimitedNaturalLiteralExp.getUnlimitedNaturalSymbol();
		if (unlimitedNaturalSymbol == null) {
			return null;
		}
		IntegerValue integerValue = ValuesUtil.integerValueOf(unlimitedNaturalSymbol);
		if (integerValue.signum() < 0) {
			if (integerValue == ValuesUtil.integerValueOf(-1)) {
				integerValue = ValuesUtil.UNLIMITED_VALUE;
			}
		}
		return integerValue;
	}
	
	/**
	 * Callback for an UnspecifiedValueExp visit.
	 */
	@Override
    public Object visitUnspecifiedValueExp(@NonNull UnspecifiedValueExp uv) {
		// TODO: return a "random instance of the type of the expression"
		throw new UnsupportedOperationException("evaluation of UnspecifiedValueExp"); //$NON-NLS-1$
	}

	/**
	 * Callback for a Variable visit.
	 */
	@Override
    public Object visitVariable(@NonNull Variable variable) {
		// return the initial (only) value
		OCLExpression initExp = variable.getInitExpression();
		if (initExp == null) {
			throw new InvalidValueException("Uninitialized variable", variable);
		}
		else {
			return initExp.accept(undecoratedVisitor);
		}
	}

	/**
	 * Callback for a VariableExp visit.
	 * 
	 * @param variableExp
	 *            the variable expression
	 * @return the value of the variable
	 */
	@Override
    public Object visitVariableExp(@NonNull VariableExp variableExp) {
		VariableDeclaration variableDeclaration = variableExp.getReferredVariable();
		if (variableDeclaration == null) {
			throw new InvalidValueException("Undefined variable", null, null, variableExp);
		}
		Object value = evaluationEnvironment.getValueOf(variableDeclaration);
		if (value instanceof InvalidValueException) {
			throw (InvalidValueException)value;
		}
		else {
			return value;
		}
	}

	public Object visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
	}
}
