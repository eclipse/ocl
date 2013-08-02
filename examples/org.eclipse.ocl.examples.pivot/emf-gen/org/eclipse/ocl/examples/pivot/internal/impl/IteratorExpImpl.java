/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: IteratorExpImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.validation.ValidationWarning;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.LibraryConstants;
import org.eclipse.ocl.examples.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.library.iterator.ClosureIteration;
import org.eclipse.ocl.examples.library.iterator.SortedByIteration;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.logical.BooleanOrOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclany.OclComparableCompareToOperation;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.ReferringElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterator Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("cast")
public class IteratorExpImpl extends LoopExpImpl implements IteratorExp
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IteratorExpImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.ITERATOR_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateClosureBodyTypeIsConformanttoIteratorType(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (getReferredIteration().getImplementation() != ClosureIteration.INSTANCE) {
			return true;
		}
		Diagnostic diagnostic = null;
		MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(DomainUtil.nonNullState(eResource()));
		Type bodyType = getBody().getType();
		if (bodyType instanceof CollectionType) {
			bodyType = ((CollectionType)bodyType).getElementType();
		}
		Type bodyType2 = DomainUtil.nonNullState(bodyType);
		Type iteratorType = DomainUtil.nonNullState(getIterator().get(0).getType());
		Map<TemplateParameter, ParameterableElement> bindings = new HashMap<TemplateParameter, ParameterableElement>();
		if (!metaModelManager.conformsTo(bodyType2, iteratorType, bindings)) {
			if (diagnostics == null) {
				return false;
			}
			diagnostic = new ValidationWarning(OCLMessages.IncompatibleBodyType_WARNING_, bodyType2, iteratorType);
		}
		if (diagnostic == null) {
			return true;
		}
	    diagnostics.add(diagnostic);
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateSortedByIteratorTypeIsComparable(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (getReferredIteration().getImplementation() != SortedByIteration.INSTANCE) {
			return true;
		}
		Diagnostic diagnostic = null;
		MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(DomainUtil.nonNullState(eResource()));
		try {
			@NonNull Type type = DomainUtil.nonNullPivot(getBody().getType());
			TemplateParameter templateParameter = type.getOwningTemplateParameter();
			if (templateParameter != null) {
				Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions = PivotUtil.getAllTemplateParameterSubstitutions(null, (TemplateableElement) getSource().getType());
				if (templateParameterSubstitutions != null) {
					ParameterableElement resolvedTemplateParameter = templateParameterSubstitutions.get(templateParameter);
					if (resolvedTemplateParameter instanceof Type) {
						type = (Type) resolvedTemplateParameter;
					}
				}
			}
			type = PivotUtil.getType(type);
			DomainInheritance comparableType = metaModelManager.getOclComparableType().getInheritance(metaModelManager);
			DomainInheritance selfType = metaModelManager.getOclSelfType().getInheritance(metaModelManager);
			DomainOperation staticOperation = comparableType.lookupLocalOperation(metaModelManager, LibraryConstants.COMPARE_TO, selfType);
			if (staticOperation == null) {
				if (diagnostics == null) {
					return false;
				}
				diagnostic = new ValidationWarning(OCLMessages.UnresolvedOperation_ERROR_, LibraryConstants.COMPARE_TO, String.valueOf(comparableType));
			}
			else {
				LibraryFeature implementation = type.lookupImplementation(metaModelManager, staticOperation);
				if (implementation == OclComparableCompareToOperation.INSTANCE) {
					if (diagnostics == null) {
						return false;
					}
					diagnostic = new ValidationWarning(OCLMessages.UnresolvedOperation_ERROR_, LibraryConstants.COMPARE_TO, String.valueOf(type));
				}
			}
		} catch (Exception e) {
			if (diagnostics == null) {
				return false;
			}
			diagnostic = new ValidationWarning(e.getLocalizedMessage());
		}
		if (diagnostic == null) {
			return true;
		}
	    diagnostics.add(diagnostic);
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnyHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv AnyHasOneIterator: name = 'any' implies iterator->size() = 1
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_any);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<Variable> iterator = self.getIterator();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_iterator);
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(size, PivotTables.INT_1);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "AnyHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ANY_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnyTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv AnyTypeIsSourceElementType: name = 'any' implies type = source.type.oclAsType(CollectionType).elementType
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_any);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @Nullable /*@Thrown*/ DomainExpression source = self.getSource();
		        if (source == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_CollectionType);
		        if (oclAsType == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @NonNull /*@Thrown*/ DomainType elementType = oclAsType.getElementType();
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(type, elementType);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "AnyTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ANY_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnyBodyTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv AnyBodyTypeIsBoolean: name = 'any' implies _'body'.type = 'Boolean'
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_any);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @NonNull /*@Thrown*/ DomainExpression body = self.getBody();
		        final @Nullable /*@Thrown*/ DomainType type = body.getType();
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(type, PivotTables.STR_Boolean);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "AnyBodyTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ANY_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClosureHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv ClosureHasOneIterator: name = 'closure' implies iterator->size() = 1
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_closure);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<Variable> iterator = self.getIterator();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_iterator);
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(size, PivotTables.INT_1);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ClosureHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__CLOSURE_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClosureTypeIsUniqueCollection(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv ClosureTypeIsUniqueCollection: name = 'closure' implies
		 * if source.type.oclIsKindOf(SequenceType) or source.type.oclIsKindOf(OrderedSetType) then
		 * type.oclIsKindOf(OrderedSetType)
		 * else
		 * type.oclIsKindOf(SetType)
		 * endif
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_OrderedSetType = idResolver.getType(PivotTables.CLSSid_OrderedSetType, null);
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SequenceType = idResolver.getType(PivotTables.CLSSid_SequenceType, null);
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SetType = idResolver.getType(PivotTables.CLSSid_SetType, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_closure);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_symbol_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		        try {
		            final @Nullable /*@Thrown*/ DomainExpression source = self.getSource();
		            if (source == null) {
		                throw new InvalidValueException("Null source");
		            }
		            final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
		            final @NonNull /*@Thrown*/ Boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_SequenceType);
		            CAUGHT_oclIsKindOf = oclIsKindOf;
		        }
		        catch (Exception e) {
		            CAUGHT_oclIsKindOf = ValuesUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf_0;
		        try {
		            final @Nullable /*@Thrown*/ DomainExpression source_0 = self.getSource();
		            if (source_0 == null) {
		                throw new InvalidValueException("Null source");
		            }
		            final @Nullable /*@Thrown*/ DomainType type_1 = source_0.getType();
		            final @NonNull /*@Thrown*/ Boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_1, TYP_pivot_c_c_OrderedSetType);
		            CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
		        }
		        catch (Exception e) {
		            CAUGHT_oclIsKindOf_0 = ValuesUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf, CAUGHT_oclIsKindOf_0);
		        if (or == null) {
		            throw new InvalidValueException("Null source");
		        }
		        @NonNull /*@Thrown*/ Boolean symbol_0;
		        if (or) {
		            final @NonNull /*@Thrown*/ Boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_OrderedSetType);
		            symbol_0 = oclIsKindOf_1;
		        }
		        else {
		            final @NonNull /*@Thrown*/ Boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_SetType);
		            symbol_0 = oclIsKindOf_2;
		        }
		        CAUGHT_symbol_0 = symbol_0;
		    }
		    catch (Exception e) {
		        CAUGHT_symbol_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ClosureTypeIsUniqueCollection", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__CLOSURE_TYPE_IS_UNIQUE_COLLECTION, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClosureSourceElementTypeIsBodyElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv ClosureSourceElementTypeIsBodyElementType: name = 'closure' implies
		 * source.type.oclAsType(CollectionType).elementType =
		 * if _'body'.type.oclIsKindOf(CollectionType)
		 * then _'body'.type.oclAsType(CollectionType).elementType
		 * else _'body'.type
		 * endif
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_closure);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = body.getType();
		        final @NonNull /*@Thrown*/ DomainExpression body = self.getBody();
		        final @Nullable /*@Thrown*/ DomainExpression source = self.getSource();
		        if (source == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_CollectionType);
		        if (oclAsType == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @NonNull /*@Thrown*/ DomainType elementType = oclAsType.getElementType();
		        final @NonNull /*@Thrown*/ Boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType);
		        @Nullable /*@Thrown*/ DomainType symbol_0;
		        if (oclIsKindOf) {
		            final @Nullable /*@Thrown*/ CollectionType oclAsType_0 = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType);
		            if (oclAsType_0 == null) {
		                throw new InvalidValueException("Null source");
		            }
		            final @NonNull /*@Thrown*/ DomainType elementType_0 = oclAsType_0.getElementType();
		            symbol_0 = elementType_0;
		        }
		        else {
		            symbol_0 = type;
		        }
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(elementType, symbol_0);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ClosureSourceElementTypeIsBodyElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__CLOSURE_SOURCE_ELEMENT_TYPE_IS_BODY_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClosureElementTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv ClosureElementTypeIsSourceElementType: name = 'closure' implies
		 * type.oclAsType(CollectionType).elementType
		 * = source.type.oclAsType(CollectionType).elementType
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_closure);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType);
		        if (oclAsType == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @NonNull /*@Thrown*/ DomainType elementType = oclAsType.getElementType();
		        final @Nullable /*@Thrown*/ DomainExpression source = self.getSource();
		        if (source == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType_0 = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_CollectionType);
		        if (oclAsType_0 == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @NonNull /*@Thrown*/ DomainType elementType_0 = oclAsType_0.getElementType();
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(elementType, elementType_0);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ClosureElementTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__CLOSURE_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv CollectHasOneIterator: name = 'collect' implies iterator->size() = 1
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_collect);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<Variable> iterator = self.getIterator();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_iterator);
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(size, PivotTables.INT_1);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectTypeIsUnordered(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv CollectTypeIsUnordered: name = 'collect' implies
		 * if source.type.oclIsKindOf(SequenceType) or source.type.oclIsKindOf(OrderedSetType) then
		 * type.oclIsKindOf(SequenceType)
		 * else
		 * type.oclIsKindOf(BagType)
		 * endif
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_BagType = idResolver.getType(PivotTables.CLSSid_BagType, null);
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_OrderedSetType = idResolver.getType(PivotTables.CLSSid_OrderedSetType, null);
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SequenceType = idResolver.getType(PivotTables.CLSSid_SequenceType, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_collect);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_symbol_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		        try {
		            final @Nullable /*@Thrown*/ DomainExpression source = self.getSource();
		            if (source == null) {
		                throw new InvalidValueException("Null source");
		            }
		            final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
		            final @NonNull /*@Thrown*/ Boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_SequenceType);
		            CAUGHT_oclIsKindOf = oclIsKindOf;
		        }
		        catch (Exception e) {
		            CAUGHT_oclIsKindOf = ValuesUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf_0;
		        try {
		            final @Nullable /*@Thrown*/ DomainExpression source_0 = self.getSource();
		            if (source_0 == null) {
		                throw new InvalidValueException("Null source");
		            }
		            final @Nullable /*@Thrown*/ DomainType type_1 = source_0.getType();
		            final @NonNull /*@Thrown*/ Boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_1, TYP_pivot_c_c_OrderedSetType);
		            CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
		        }
		        catch (Exception e) {
		            CAUGHT_oclIsKindOf_0 = ValuesUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf, CAUGHT_oclIsKindOf_0);
		        if (or == null) {
		            throw new InvalidValueException("Null source");
		        }
		        @NonNull /*@Thrown*/ Boolean symbol_0;
		        if (or) {
		            final @NonNull /*@Thrown*/ Boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_SequenceType);
		            symbol_0 = oclIsKindOf_1;
		        }
		        else {
		            final @NonNull /*@Thrown*/ Boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_BagType);
		            symbol_0 = oclIsKindOf_2;
		        }
		        CAUGHT_symbol_0 = symbol_0;
		    }
		    catch (Exception e) {
		        CAUGHT_symbol_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectTypeIsUnordered", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_TYPE_IS_UNORDERED, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectElementTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv CollectElementTypeIsSourceElementType: name = 'collect' implies
		 * type.oclAsType(CollectionType).elementType =
		 * _'body'.type.oclAsType(CollectionType).elementType
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_collect);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType);
		        if (oclAsType == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @NonNull /*@Thrown*/ DomainType elementType = oclAsType.getElementType();
		        final @NonNull /*@Thrown*/ DomainExpression body = self.getBody();
		        final @Nullable /*@Thrown*/ DomainType type_0 = body.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType_0 = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_CollectionType);
		        if (oclAsType_0 == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @NonNull /*@Thrown*/ DomainType elementType_0 = oclAsType_0.getElementType();
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(elementType, elementType_0);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectElementTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectNestedHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv CollectNestedHasOneIterator: name = 'collectNested' implies iterator->size() = 1
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_collectNested);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<Variable> iterator = self.getIterator();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_iterator);
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(size, PivotTables.INT_1);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectNestedHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_NESTED_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectNestedTypeIsBag(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv CollectNestedTypeIsBag: name = 'collectNested' implies type.oclIsKindOf(BagType)
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_BagType = idResolver.getType(PivotTables.CLSSid_BagType, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_collectNested);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @NonNull /*@Thrown*/ Boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_BagType);
		        CAUGHT_oclIsKindOf = oclIsKindOf;
		    }
		    catch (Exception e) {
		        CAUGHT_oclIsKindOf = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_oclIsKindOf);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectNestedTypeIsBag", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_NESTED_TYPE_IS_BAG, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectNestedTypeIsBodyType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv CollectNestedTypeIsBodyType: name = 'collectNested' implies type = _'body'.type
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_collectNested);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @NonNull /*@Thrown*/ DomainExpression body = self.getBody();
		        final @Nullable /*@Thrown*/ DomainType type_0 = body.getType();
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(type, type_0);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectNestedTypeIsBodyType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_NESTED_TYPE_IS_BODY_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExistsTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv ExistsTypeIsBoolean: name = 'exists' implies type = Boolean
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_exists);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(type, TYP_Boolean);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ExistsTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__EXISTS_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExistsBodyTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv ExistsBodyTypeIsBoolean: name = 'exists' implies _'body'.type = Boolean
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_exists);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @NonNull /*@Thrown*/ DomainExpression body = self.getBody();
		        final @Nullable /*@Thrown*/ DomainType type = body.getType();
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(type, TYP_Boolean);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ExistsBodyTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__EXISTS_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForAllTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv ForAllTypeIsBoolean: name = 'forAll' implies type = Boolean
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_forAll);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(type, TYP_Boolean);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ForAllTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__FOR_ALL_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForAllBodyTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv ForAllBodyTypeIsBoolean: name = 'forAll' implies _'body'.type = Boolean
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_forAll);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @NonNull /*@Thrown*/ DomainExpression body = self.getBody();
		        final @Nullable /*@Thrown*/ DomainType type = body.getType();
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(type, TYP_Boolean);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ForAllBodyTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__FOR_ALL_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsUniqueHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv IsUniqueHasOneIterator: name = 'isUnique' implies iterator->size() = 1
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_isUnique);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<Variable> iterator = self.getIterator();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_iterator);
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(size, PivotTables.INT_1);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "IsUniqueHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__IS_UNIQUE_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsUniqueTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv IsUniqueTypeIsBoolean: name = 'isUnique' implies type = Boolean
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_isUnique);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(type, TYP_Boolean);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "IsUniqueTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__IS_UNIQUE_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOneHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv OneHasOneIterator: name = 'one' implies iterator->size() = 1
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_one);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<Variable> iterator = self.getIterator();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_iterator);
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(size, PivotTables.INT_1);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "OneHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ONE_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOneTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv OneTypeIsBoolean: name = 'one' implies type = Boolean
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_one);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(type, TYP_Boolean);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "OneTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ONE_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOneBodyTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv OneBodyTypeIsBoolean: name = 'one' implies _'body'.type = Boolean
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_one);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @NonNull /*@Thrown*/ DomainExpression body = self.getBody();
		        final @Nullable /*@Thrown*/ DomainType type = body.getType();
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(type, TYP_Boolean);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "OneBodyTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ONE_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRejectOrSelectHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv RejectOrSelectHasOneIterator: name = 'reject' or name = 'select' implies iterator->size() = 1
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @Nullable /*@Caught*/ Object CAUGHT_or;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = self.getName();
		            final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_reject);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @Nullable /*@Thrown*/ String name_0 = self.getName();
		            final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(name_0, PivotTables.STR_select);
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_or = or;
		    }
		    catch (Exception e) {
		        CAUGHT_or = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_1;
		    try {
		        final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<Variable> iterator = self.getIterator();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_iterator);
		        final @NonNull /*@Thrown*/ Boolean eq_1 = OclAnyEqualOperation.INSTANCE.evaluate(size, PivotTables.INT_1);
		        CAUGHT_eq_1 = eq_1;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_1 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_or, CAUGHT_eq_1);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "RejectOrSelectHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__REJECT_OR_SELECT_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRejectOrSelectTypeIsSourceType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv RejectOrSelectTypeIsSourceType: name = 'reject' or name = 'select' implies type = source.type
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @Nullable /*@Caught*/ Object CAUGHT_or;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = self.getName();
		            final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_reject);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @Nullable /*@Thrown*/ String name_0 = self.getName();
		            final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(name_0, PivotTables.STR_select);
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_or = or;
		    }
		    catch (Exception e) {
		        CAUGHT_or = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_1;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @Nullable /*@Thrown*/ DomainExpression source = self.getSource();
		        if (source == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
		        final @NonNull /*@Thrown*/ Boolean eq_1 = OclAnyEqualOperation.INSTANCE.evaluate(type, type_0);
		        CAUGHT_eq_1 = eq_1;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_1 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_or, CAUGHT_eq_1);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "RejectOrSelectTypeIsSourceType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__REJECT_OR_SELECT_TYPE_IS_SOURCE_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRejectOrSelectTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv RejectOrSelectTypeIsBoolean: name = 'reject' or name = 'select' implies type = Boolean
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @Nullable /*@Caught*/ Object CAUGHT_or;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = self.getName();
		            final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_reject);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @Nullable /*@Thrown*/ String name_0 = self.getName();
		            final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(name_0, PivotTables.STR_select);
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_or = or;
		    }
		    catch (Exception e) {
		        CAUGHT_or = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_1;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @NonNull /*@Thrown*/ Boolean eq_1 = OclAnyEqualOperation.INSTANCE.evaluate(type, TYP_Boolean);
		        CAUGHT_eq_1 = eq_1;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_1 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_or, CAUGHT_eq_1);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "RejectOrSelectTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__REJECT_OR_SELECT_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSortedByHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv SortedByHasOneIterator: name = 'sortedBy' implies iterator->size() = 1
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_sortedBy);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<Variable> iterator = self.getIterator();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_iterator);
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(size, PivotTables.INT_1);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "SortedByHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__SORTED_BY_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSortedByIsOrderedIfSourceIsOrdered(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv SortedByIsOrderedIfSourceIsOrdered: name = 'sortedBy' implies
		 * if source.type.oclIsKindOf(SequenceType) or source.type.oclIsKindOf(BagType) then
		 * type.oclIsKindOf(SequenceType)
		 * else
		 * type.oclIsKindOf(OrderedSetType)
		 * endif
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_BagType = idResolver.getType(PivotTables.CLSSid_BagType, null);
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_OrderedSetType = idResolver.getType(PivotTables.CLSSid_OrderedSetType, null);
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SequenceType = idResolver.getType(PivotTables.CLSSid_SequenceType, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_sortedBy);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_symbol_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		        try {
		            final @Nullable /*@Thrown*/ DomainExpression source = self.getSource();
		            if (source == null) {
		                throw new InvalidValueException("Null source");
		            }
		            final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
		            final @NonNull /*@Thrown*/ Boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_SequenceType);
		            CAUGHT_oclIsKindOf = oclIsKindOf;
		        }
		        catch (Exception e) {
		            CAUGHT_oclIsKindOf = ValuesUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf_0;
		        try {
		            final @Nullable /*@Thrown*/ DomainExpression source_0 = self.getSource();
		            if (source_0 == null) {
		                throw new InvalidValueException("Null source");
		            }
		            final @Nullable /*@Thrown*/ DomainType type_1 = source_0.getType();
		            final @NonNull /*@Thrown*/ Boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_1, TYP_pivot_c_c_BagType);
		            CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
		        }
		        catch (Exception e) {
		            CAUGHT_oclIsKindOf_0 = ValuesUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf, CAUGHT_oclIsKindOf_0);
		        if (or == null) {
		            throw new InvalidValueException("Null source");
		        }
		        @NonNull /*@Thrown*/ Boolean symbol_0;
		        if (or) {
		            final @NonNull /*@Thrown*/ Boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_SequenceType);
		            symbol_0 = oclIsKindOf_1;
		        }
		        else {
		            final @NonNull /*@Thrown*/ Boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_OrderedSetType);
		            symbol_0 = oclIsKindOf_2;
		        }
		        CAUGHT_symbol_0 = symbol_0;
		    }
		    catch (Exception e) {
		        CAUGHT_symbol_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "SortedByIsOrderedIfSourceIsOrdered", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__SORTED_BY_IS_ORDERED_IF_SOURCE_IS_ORDERED, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSortedByElementTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv SortedByElementTypeIsSourceElementType: name = 'sortedBy' implies
		 * type.oclAsType(CollectionType).elementType =
		 * _'body'.type.oclAsType(CollectionType).elementType
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @Nullable /*@Thrown*/ String name = self.getName();
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(name, PivotTables.STR_sortedBy);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType);
		        if (oclAsType == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @NonNull /*@Thrown*/ DomainType elementType = oclAsType.getElementType();
		        final @NonNull /*@Thrown*/ DomainExpression body = self.getBody();
		        final @Nullable /*@Thrown*/ DomainType type_0 = body.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType_0 = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_CollectionType);
		        if (oclAsType_0 == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @NonNull /*@Thrown*/ DomainType elementType_0 = oclAsType_0.getElementType();
		        final @NonNull /*@Thrown*/ Boolean eq_0 = OclAnyEqualOperation.INSTANCE.evaluate(elementType, elementType_0);
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "SortedByElementTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__SORTED_BY_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv IteratorTypeIsSourceElementType: self.iterator->forAll(source.type.oclAsType (CollectionType).elementType.conformsTo(type))
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ IteratorExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		@NonNull /*@Caught*/ Object CAUGHT_forAll;
		try {
		    final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<Variable> iterator = self.getIterator();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		    @Nullable Iterator<?> ITERATOR__1 = BOXED_iterator.iterator();
		    @NonNull /*@Thrown*/ Boolean forAll;
		    while (true) {
		        if (!ITERATOR__1.hasNext()) {
		            forAll = ValuesUtil.TRUE_VALUE;
		            break;
		        }
		        @Nullable /*@NonInvalid*/ Variable _1 = (Variable)ITERATOR__1.next();
		        /**
		         * 
		         * source.type.oclAsType(CollectionType)
		         * .elementType.conformsTo(type)
		         */
		        final @Nullable /*@Thrown*/ DomainExpression source = self.getSource();
		        if (source == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @Nullable /*@Thrown*/ DomainType type = source.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType);
		        if (oclAsType == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @NonNull /*@Thrown*/ DomainType elementType = oclAsType.getElementType();
		        if (_1 == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @Nullable /*@Thrown*/ DomainType type_0 = _1.getType();
		        final @NonNull /*@Thrown*/ Boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(evaluator, elementType, type_0);
		        //
		        if (conformsTo != ValuesUtil.TRUE_VALUE) {			// Carry unless something not found
		            forAll = ValuesUtil.FALSE_VALUE;			// Abort after a fail
		            break;
		        }
		    }
		    CAUGHT_forAll = forAll;
		}
		catch (Exception e) {
		    CAUGHT_forAll = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_forAll == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "IteratorTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ITERATOR_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
	{
		if (baseClass == ReferringElement.class)
		{
			switch (baseOperationID)
			{
				case PivotPackage.REFERRING_ELEMENT___GET_REFERRED_ELEMENT: return PivotPackage.ITERATOR_EXP___GET_REFERRED_ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case PivotPackage.ITERATOR_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.ITERATOR_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP:
				return validateNoInitializers((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP:
				return validateSourceIsCollection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___GET_REFERRED_ELEMENT:
				return getReferredElement();
			case PivotPackage.ITERATOR_EXP___VALIDATE_ANY_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateAnyBodyTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_ANY_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateAnyHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_ANY_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateAnyTypeIsSourceElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_CLOSURE_BODY_TYPE_IS_CONFORMANTTO_ITERATOR_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateClosureBodyTypeIsConformanttoIteratorType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_CLOSURE_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateClosureElementTypeIsSourceElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_CLOSURE_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateClosureHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_CLOSURE_SOURCE_ELEMENT_TYPE_IS_BODY_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateClosureSourceElementTypeIsBodyElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_CLOSURE_TYPE_IS_UNIQUE_COLLECTION__DIAGNOSTICCHAIN_MAP:
				return validateClosureTypeIsUniqueCollection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_COLLECT_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCollectElementTypeIsSourceElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_COLLECT_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateCollectHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_COLLECT_NESTED_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateCollectNestedHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_COLLECT_NESTED_TYPE_IS_BAG__DIAGNOSTICCHAIN_MAP:
				return validateCollectNestedTypeIsBag((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_COLLECT_NESTED_TYPE_IS_BODY_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCollectNestedTypeIsBodyType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_COLLECT_TYPE_IS_UNORDERED__DIAGNOSTICCHAIN_MAP:
				return validateCollectTypeIsUnordered((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_EXISTS_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateExistsBodyTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_EXISTS_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateExistsTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_FOR_ALL_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateForAllBodyTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_FOR_ALL_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateForAllTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_IS_UNIQUE_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateIsUniqueHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_IS_UNIQUE_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateIsUniqueTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_ITERATOR_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateIteratorTypeIsSourceElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_ONE_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateOneBodyTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_ONE_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateOneHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_ONE_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateOneTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_REJECT_OR_SELECT_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateRejectOrSelectHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_REJECT_OR_SELECT_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateRejectOrSelectTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_REJECT_OR_SELECT_TYPE_IS_SOURCE_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateRejectOrSelectTypeIsSourceType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_SORTED_BY_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateSortedByElementTypeIsSourceElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_SORTED_BY_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateSortedByHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_SORTED_BY_IS_ORDERED_IF_SOURCE_IS_ORDERED__DIAGNOSTICCHAIN_MAP:
				return validateSortedByIsOrderedIfSourceIsOrdered((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_SORTED_BY_ITERATOR_TYPE_IS_COMPARABLE__DIAGNOSTICCHAIN_MAP:
				return validateSortedByIteratorTypeIsComparable((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitIteratorExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element getReferredElement()
	{
		return getReferredIteration();
	}

} //IteratorExpImpl
