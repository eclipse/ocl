/*******************************************************************************
 * Copyright (c) 2010, 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.ReferringElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryConstants;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.iterator.ClosureIteration;
import org.eclipse.ocl.pivot.library.iterator.SortedByIteration;
import org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.validation.ValidationWarning;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterator Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
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
	@Override
	public boolean validateClosureBodyTypeIsConformanttoIteratorType(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (getReferredIteration().getImplementation() != ClosureIteration.INSTANCE) {
			return true;
		}
		Diagnostic diagnostic = null;
		Resource asResource = ClassUtil.nonNullState(eResource());
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(asResource);
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		Type bodyType = getOwnedBody().getType();
		if (bodyType instanceof CollectionType) {
			bodyType = ((CollectionType)bodyType).getElementType();
		}
		Type bodyType2 = ClassUtil.nonNullState(bodyType);
		Type iteratorType = ClassUtil.nonNullState(getOwnedIterators().get(0).getType());
//		TemplateParameterSubstitutions bindings = null; //new HashMap<TemplateParameter, Type>();
		if (!metamodelManager.conformsTo(bodyType2, TemplateParameterSubstitutions.EMPTY, iteratorType, TemplateParameterSubstitutions.EMPTY)) {
			if (diagnostics == null) {
				return false;
			}
			diagnostic = new ValidationWarning(PivotMessagesInternal.IncompatibleBodyType_WARNING_, bodyType2, iteratorType);
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
	@Override
	public boolean validateSortedByIteratorTypeIsComparable(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (getReferredIteration().getImplementation() != SortedByIteration.INSTANCE) {
			return true;
		}
		Diagnostic diagnostic = null;
		Resource asResource = ClassUtil.nonNullState(eResource());
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(asResource);
		StandardLibraryInternal standardLibrary = environmentFactory.getStandardLibrary();
		try {
			org.eclipse.ocl.pivot.Class oclComparableType = standardLibrary.getOclComparableType();
			CompleteInheritance comparableInheritance = oclComparableType.getInheritance(standardLibrary);
			CompleteInheritance selfType = standardLibrary.getOclSelfType().getInheritance(standardLibrary);
			Operation staticOperation = comparableInheritance.lookupLocalOperation(standardLibrary, LibraryConstants.COMPARE_TO, selfType);
			if (staticOperation == null) {
				if (diagnostics == null) {
					return false;
				}
				diagnostic = new ValidationWarning(PivotMessagesInternal.UnresolvedOperation_ERROR_, String.valueOf(comparableInheritance), LibraryConstants.COMPARE_TO);
			}
			else {
				OCLExpression source2 = this.getOwnedSource();
				OCLExpression body2 = this.getOwnedBody();
				Type sourceType = source2.getType();
				Type sourceTypeValue = source2.getTypeValue();
				Type bodyType = body2.getType();
				Type specializedBodyType = bodyType != null ? TemplateParameterSubstitutionVisitor.specializeType(bodyType, this, environmentFactory, sourceType, sourceTypeValue) : null;
				boolean isOk = false;
				if (bodyType != null) {
					PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
					if ((specializedBodyType != null) && metamodelManager.conformsTo(specializedBodyType, TemplateParameterSubstitutions.EMPTY, oclComparableType, TemplateParameterSubstitutions.EMPTY)) {
						isOk = true;
					}
				}
				if (!isOk) {
					if (diagnostics == null) {
						return false;
					}
					diagnostic = new ValidationWarning(PivotMessagesInternal.UnresolvedOperation_ERROR_, String.valueOf(specializedBodyType), LibraryConstants.COMPARE_TO);
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
	@Override
	public boolean validateAnyHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateAnyHasOneIterator:
		 *   let severity : Integer[1] = 'IteratorExp::AnyHasOneIterator'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'any' implies
		 *         ownedIterators->size() = 1
		 *       in
		 *         'IteratorExp::AnyHasOneIterator'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_AnyHasOneIterator);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_any.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		            final @Nullable /*@Thrown*/ OrderedSetValue safe_null_sources = (OrderedSetValue)CollectionExcludingOperation.INSTANCE.evaluate(BOXED_ownedIterators, null);
		            final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(safe_null_sources);
		            final /*@Thrown*/ boolean eq_0 = size.equals(PivotTables.INT_1);
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_AnyHasOneIterator, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateAnyTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateAnyTypeIsSourceElementType:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::AnyTypeIsSourceElementType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'any' implies type =
		 *         ownedSource?.type?.oclAsType(CollectionType).elementType
		 *       in
		 *         'IteratorExp::AnyTypeIsSourceElementType'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_AnyTypeIsSourceElementType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_2;
		if (le) {
		    symbol_2 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_any.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		            final /*@Thrown*/ boolean symbol_0 = ownedSource == null;
		            @Nullable /*@Thrown*/ Type safe_type_source;
		            if (symbol_0) {
		                safe_type_source = null;
		            }
		            else {
		                assert ownedSource != null;
		                final @Nullable /*@Thrown*/ Type type_0 = ownedSource.getType();
		                safe_type_source = type_0;
		            }
		            final /*@Thrown*/ boolean symbol_1 = safe_type_source == null;
		            @Nullable /*@Thrown*/ CollectionType safe_oclAsType_source;
		            if (symbol_1) {
		                safe_oclAsType_source = null;
		            }
		            else {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_CollectionType = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		                final @NonNull /*@Thrown*/ CollectionType oclAsType = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, safe_type_source, TYP_CollectionType));
		                safe_oclAsType_source = oclAsType;
		            }
		            if (safe_oclAsType_source == null) {
		                throw new InvalidValueException("Null source for \'pivot::CollectionType::elementType\'");
		            }
		            final @Nullable /*@Thrown*/ Type elementType = safe_oclAsType_source.getElementType();
		            final /*@Thrown*/ boolean eq_0 = (type != null) && (elementType != null) ? (type.getTypeId() == elementType.getTypeId()) : false;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_AnyTypeIsSourceElementType, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_2 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateAnyBodyTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateAnyBodyTypeIsBoolean:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::AnyBodyTypeIsBoolean'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'any' implies ownedBody.type = 'Boolean'
		 *       in
		 *         'IteratorExp::AnyBodyTypeIsBoolean'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_AnyBodyTypeIsBoolean);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_any.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		            if (ownedBody == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type = ownedBody.getType();
		            final /*@Thrown*/ boolean eq_0 = PivotTables.STR_Boolean.equals(type);
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_AnyBodyTypeIsBoolean, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateClosureHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateClosureHasOneIterator:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::ClosureHasOneIterator'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'closure' implies
		 *         ownedIterators->size() = 1
		 *       in
		 *         'IteratorExp::ClosureHasOneIterator'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_ClosureHasOneIterator);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_closure.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		            final @Nullable /*@Thrown*/ OrderedSetValue safe_null_sources = (OrderedSetValue)CollectionExcludingOperation.INSTANCE.evaluate(BOXED_ownedIterators, null);
		            final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(safe_null_sources);
		            final /*@Thrown*/ boolean eq_0 = size.equals(PivotTables.INT_1);
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_ClosureHasOneIterator, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateClosureTypeIsUniqueCollection(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateClosureTypeIsUniqueCollection:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::ClosureTypeIsUniqueCollection'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'closure' implies
		 *         if
		 *           ownedSource?.type?.oclIsKindOf(SequenceType) or
		 *           ownedSource?.type.oclIsKindOf(OrderedSetType)
		 *         then type.oclIsKindOf(OrderedSetType)
		 *         else type.oclIsKindOf(SetType)
		 *         endif
		 *       in
		 *         'IteratorExp::ClosureTypeIsUniqueCollection'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_ClosureTypeIsUniqueCollection);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_4;
		if (le) {
		    symbol_4 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_closure.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_symbol_3;
		        try {
		            final @Nullable /*@Thrown*/ Type type_2 = this.getType();
		            @Nullable /*@Caught*/ Object CAUGHT_safe_oclIsKindOf_source;
		            try {
		                final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		                final /*@Thrown*/ boolean symbol_0 = ownedSource == null;
		                @Nullable /*@Thrown*/ Type safe_type_source;
		                if (symbol_0) {
		                    safe_type_source = null;
		                }
		                else {
		                    assert ownedSource != null;
		                    final @Nullable /*@Thrown*/ Type type = ownedSource.getType();
		                    safe_type_source = type;
		                }
		                final /*@Thrown*/ boolean symbol_1 = safe_type_source == null;
		                @Nullable /*@Thrown*/ Boolean safe_oclIsKindOf_source;
		                if (symbol_1) {
		                    safe_oclIsKindOf_source = null;
		                }
		                else {
		                    final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_SequenceType_0 = idResolver.getClass(PivotTables.CLSSid_SequenceType, null);
		                    final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, safe_type_source, TYP_SequenceType_0).booleanValue();
		                    safe_oclIsKindOf_source = oclIsKindOf;
		                }
		                CAUGHT_safe_oclIsKindOf_source = safe_oclIsKindOf_source;
		            }
		            catch (Exception e) {
		                CAUGHT_safe_oclIsKindOf_source = ValueUtil.createInvalidValue(e);
		            }
		            @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf_0;
		            try {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OrderedSetType_0 = idResolver.getClass(PivotTables.CLSSid_OrderedSetType, null);
		                final @Nullable /*@Thrown*/ OCLExpression ownedSource_0 = this.getOwnedSource();
		                final /*@Thrown*/ boolean symbol_2 = ownedSource_0 == null;
		                @Nullable /*@Thrown*/ Type safe_type_source_0;
		                if (symbol_2) {
		                    safe_type_source_0 = null;
		                }
		                else {
		                    assert ownedSource_0 != null;
		                    final @Nullable /*@Thrown*/ Type type_0 = ownedSource_0.getType();
		                    safe_type_source_0 = type_0;
		                }
		                final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, safe_type_source_0, TYP_OrderedSetType_0).booleanValue();
		                CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
		            }
		            catch (Exception e) {
		                CAUGHT_oclIsKindOf_0 = ValueUtil.createInvalidValue(e);
		            }
		            final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_safe_oclIsKindOf_source, CAUGHT_oclIsKindOf_0);
		            if (or == null) {
		                throw new InvalidValueException("Null if condition");
		            }
		            /*@Thrown*/ boolean symbol_3;
		            if (or) {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OrderedSetType_1 = idResolver.getClass(PivotTables.CLSSid_OrderedSetType, null);
		                final /*@Thrown*/ boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_OrderedSetType_1).booleanValue();
		                symbol_3 = oclIsKindOf_1;
		            }
		            else {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_SetType_0 = idResolver.getClass(PivotTables.CLSSid_SetType, null);
		                final /*@Thrown*/ boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_SetType_0).booleanValue();
		                symbol_3 = oclIsKindOf_2;
		            }
		            CAUGHT_symbol_3 = symbol_3;
		        }
		        catch (Exception e) {
		            CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_3);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_ClosureTypeIsUniqueCollection, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_4 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCollectElementTypeIsFlattenedBodyType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCollectElementTypeIsFlattenedBodyType:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::CollectElementTypeIsFlattenedBodyType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'collect' implies
		 *         type.oclAsType(CollectionType).elementType =
		 *         ownedBody.type.flattenedType()
		 *       in
		 *         'IteratorExp::CollectElementTypeIsFlattenedBodyType'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_CollectElementTypeIsFlattenedBodyType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_collect.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_CollectionType_0 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final @NonNull /*@Thrown*/ CollectionType oclAsType = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type, TYP_CollectionType_0));
		            final @Nullable /*@Thrown*/ Type elementType = oclAsType.getElementType();
		            final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		            if (ownedBody == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type_0 = ownedBody.getType();
		            if (type_0 == null) {
		                throw new InvalidValueException("Null source for \'pivot::Type::flattenedType() : Type[?]\'");
		            }
		            final @NonNull /*@Thrown*/ Type flattenedType = type_0.flattenedType();
		            final /*@Thrown*/ boolean eq_0 = (elementType != null) ? (elementType.getTypeId() == flattenedType.getTypeId()) : false;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_CollectElementTypeIsFlattenedBodyType, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateClosureSourceElementTypeIsBodyElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateClosureSourceElementTypeIsBodyElementType:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::ClosureSourceElementTypeIsBodyElementType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'closure' implies
		 *         ownedSource?.type.oclAsType(CollectionType).elementType =
		 *         if ownedBody.type.oclIsKindOf(CollectionType)
		 *         then
		 *           ownedBody.type.oclAsType(CollectionType).elementType
		 *         else ownedBody.type
		 *         endif
		 *       in
		 *         'IteratorExp::ClosureSourceElementTypeIsBodyElementType'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_ClosureSourceElementTypeIsBodyElementType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_2;
		if (le) {
		    symbol_2 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_closure.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_CollectionType_1 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		            final @Nullable /*@Thrown*/ OCLExpression ownedBody_1 = this.getOwnedBody();
		            if (ownedBody_1 == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type_2 = ownedBody_1.getType();
		            final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		            final /*@Thrown*/ boolean symbol_0 = ownedSource == null;
		            @Nullable /*@Thrown*/ Type safe_type_source;
		            if (symbol_0) {
		                safe_type_source = null;
		            }
		            else {
		                assert ownedSource != null;
		                final @Nullable /*@Thrown*/ Type type = ownedSource.getType();
		                safe_type_source = type;
		            }
		            final @NonNull /*@Thrown*/ CollectionType oclAsType = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, safe_type_source, TYP_CollectionType_1));
		            final @Nullable /*@Thrown*/ Type elementType = oclAsType.getElementType();
		            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_CollectionType_1).booleanValue();
		            @Nullable /*@Thrown*/ Type symbol_1;
		            if (oclIsKindOf) {
		                final @NonNull /*@Thrown*/ CollectionType oclAsType_0 = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type_2, TYP_CollectionType_1));
		                final @Nullable /*@Thrown*/ Type elementType_0 = oclAsType_0.getElementType();
		                symbol_1 = elementType_0;
		            }
		            else {
		                symbol_1 = type_2;
		            }
		            final /*@Thrown*/ boolean eq_0 = (elementType != null) && (symbol_1 != null) ? (elementType.getTypeId() == symbol_1.getTypeId()) : false;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_ClosureSourceElementTypeIsBodyElementType, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_2 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateClosureElementTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateClosureElementTypeIsSourceElementType:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::ClosureElementTypeIsSourceElementType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'closure' implies
		 *         type.oclAsType(CollectionType).elementType =
		 *         ownedSource?.type.oclAsType(CollectionType).elementType
		 *       in
		 *         'IteratorExp::ClosureElementTypeIsSourceElementType'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_ClosureElementTypeIsSourceElementType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_1;
		if (le) {
		    symbol_1 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_closure.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_CollectionType_1 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final @NonNull /*@Thrown*/ CollectionType oclAsType = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type, TYP_CollectionType_1));
		            final @Nullable /*@Thrown*/ Type elementType = oclAsType.getElementType();
		            final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		            final /*@Thrown*/ boolean symbol_0 = ownedSource == null;
		            @Nullable /*@Thrown*/ Type safe_type_source;
		            if (symbol_0) {
		                safe_type_source = null;
		            }
		            else {
		                assert ownedSource != null;
		                final @Nullable /*@Thrown*/ Type type_0 = ownedSource.getType();
		                safe_type_source = type_0;
		            }
		            final @NonNull /*@Thrown*/ CollectionType oclAsType_0 = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, safe_type_source, TYP_CollectionType_1));
		            final @Nullable /*@Thrown*/ Type elementType_0 = oclAsType_0.getElementType();
		            final /*@Thrown*/ boolean eq_0 = (elementType != null) && (elementType_0 != null) ? (elementType.getTypeId() == elementType_0.getTypeId()) : false;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_ClosureElementTypeIsSourceElementType, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_1 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCollectHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCollectHasOneIterator:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::CollectHasOneIterator'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'collect' implies
		 *         ownedIterators->size() = 1
		 *       in
		 *         'IteratorExp::CollectHasOneIterator'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_CollectHasOneIterator);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_collect.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		            final @Nullable /*@Thrown*/ OrderedSetValue safe_null_sources = (OrderedSetValue)CollectionExcludingOperation.INSTANCE.evaluate(BOXED_ownedIterators, null);
		            final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(safe_null_sources);
		            final /*@Thrown*/ boolean eq_0 = size.equals(PivotTables.INT_1);
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_CollectHasOneIterator, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCollectTypeIsUnordered(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCollectTypeIsUnordered:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::CollectTypeIsUnordered'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'collect' implies
		 *         if
		 *           ownedSource?.type.oclIsKindOf(SequenceType) or
		 *           ownedSource?.type.oclIsKindOf(OrderedSetType)
		 *         then type.oclIsKindOf(SequenceType)
		 *         else type.oclIsKindOf(BagType)
		 *         endif
		 *       in
		 *         'IteratorExp::CollectTypeIsUnordered'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_CollectTypeIsUnordered);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_3;
		if (le) {
		    symbol_3 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_collect.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_symbol_2;
		        try {
		            final @Nullable /*@Thrown*/ Type type_2 = this.getType();
		            @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		            try {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_SequenceType_0 = idResolver.getClass(PivotTables.CLSSid_SequenceType, null);
		                final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		                final /*@Thrown*/ boolean symbol_0 = ownedSource == null;
		                @Nullable /*@Thrown*/ Type safe_type_source;
		                if (symbol_0) {
		                    safe_type_source = null;
		                }
		                else {
		                    assert ownedSource != null;
		                    final @Nullable /*@Thrown*/ Type type = ownedSource.getType();
		                    safe_type_source = type;
		                }
		                final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, safe_type_source, TYP_SequenceType_0).booleanValue();
		                CAUGHT_oclIsKindOf = oclIsKindOf;
		            }
		            catch (Exception e) {
		                CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
		            }
		            @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf_0;
		            try {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OrderedSetType_0 = idResolver.getClass(PivotTables.CLSSid_OrderedSetType, null);
		                final @Nullable /*@Thrown*/ OCLExpression ownedSource_0 = this.getOwnedSource();
		                final /*@Thrown*/ boolean symbol_1 = ownedSource_0 == null;
		                @Nullable /*@Thrown*/ Type safe_type_source_0;
		                if (symbol_1) {
		                    safe_type_source_0 = null;
		                }
		                else {
		                    assert ownedSource_0 != null;
		                    final @Nullable /*@Thrown*/ Type type_0 = ownedSource_0.getType();
		                    safe_type_source_0 = type_0;
		                }
		                final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, safe_type_source_0, TYP_OrderedSetType_0).booleanValue();
		                CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
		            }
		            catch (Exception e) {
		                CAUGHT_oclIsKindOf_0 = ValueUtil.createInvalidValue(e);
		            }
		            final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf, CAUGHT_oclIsKindOf_0);
		            if (or == null) {
		                throw new InvalidValueException("Null if condition");
		            }
		            /*@Thrown*/ boolean symbol_2;
		            if (or) {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_SequenceType_1 = idResolver.getClass(PivotTables.CLSSid_SequenceType, null);
		                final /*@Thrown*/ boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_SequenceType_1).booleanValue();
		                symbol_2 = oclIsKindOf_1;
		            }
		            else {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_BagType_0 = idResolver.getClass(PivotTables.CLSSid_BagType, null);
		                final /*@Thrown*/ boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_BagType_0).booleanValue();
		                symbol_2 = oclIsKindOf_2;
		            }
		            CAUGHT_symbol_2 = symbol_2;
		        }
		        catch (Exception e) {
		            CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_2);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_CollectTypeIsUnordered, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_3 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCollectNestedHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCollectNestedHasOneIterator:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::CollectNestedHasOneIterator'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'collectNested' implies
		 *         ownedIterators->size() = 1
		 *       in
		 *         'IteratorExp::CollectNestedHasOneIterator'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_CollectNestedHasOneIterator);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_collectNested.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		            final @Nullable /*@Thrown*/ OrderedSetValue safe_null_sources = (OrderedSetValue)CollectionExcludingOperation.INSTANCE.evaluate(BOXED_ownedIterators, null);
		            final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(safe_null_sources);
		            final /*@Thrown*/ boolean eq_0 = size.equals(PivotTables.INT_1);
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_CollectNestedHasOneIterator, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCollectNestedTypeIsBag(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCollectNestedTypeIsBag:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::CollectNestedTypeIsBag'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'collectNested' implies
		 *         type.oclIsKindOf(BagType)
		 *       in
		 *         'IteratorExp::CollectNestedTypeIsBag'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_CollectNestedTypeIsBag);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_collectNested.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_BagType_0 = idResolver.getClass(PivotTables.CLSSid_BagType, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_BagType_0).booleanValue();
		            CAUGHT_oclIsKindOf = oclIsKindOf;
		        }
		        catch (Exception e) {
		            CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_oclIsKindOf);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_CollectNestedTypeIsBag, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCollectNestedTypeIsBodyType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCollectNestedTypeIsBodyType:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::CollectNestedTypeIsBodyType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'collectNested' implies type = ownedBody.type
		 *       in
		 *         'IteratorExp::CollectNestedTypeIsBodyType'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_CollectNestedTypeIsBodyType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_collectNested.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		            if (ownedBody == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type_0 = ownedBody.getType();
		            final /*@Thrown*/ boolean eq_0 = (type != null) && (type_0 != null) ? (type.getTypeId() == type_0.getTypeId()) : false;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_CollectNestedTypeIsBodyType, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateExistsTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateExistsTypeIsBoolean:
		 *   let severity : Integer[1] = 'IteratorExp::ExistsTypeIsBoolean'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'exists' implies type = Boolean
		 *       in
		 *         'IteratorExp::ExistsTypeIsBoolean'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_ExistsTypeIsBoolean);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_exists.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final /*@Thrown*/ boolean eq_0 = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : false;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_ExistsTypeIsBoolean, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateExistsBodyTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateExistsBodyTypeIsBoolean:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::ExistsBodyTypeIsBoolean'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'exists' implies ownedBody.type = Boolean
		 *       in
		 *         'IteratorExp::ExistsBodyTypeIsBoolean'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_ExistsBodyTypeIsBoolean);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_exists.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		            final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		            if (ownedBody == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type = ownedBody.getType();
		            final /*@Thrown*/ boolean eq_0 = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : false;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_ExistsBodyTypeIsBoolean, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateForAllTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateForAllTypeIsBoolean:
		 *   let severity : Integer[1] = 'IteratorExp::ForAllTypeIsBoolean'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'forAll' implies type = Boolean
		 *       in
		 *         'IteratorExp::ForAllTypeIsBoolean'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_ForAllTypeIsBoolean);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_forAll.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final /*@Thrown*/ boolean eq_0 = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : false;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_ForAllTypeIsBoolean, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateForAllBodyTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateForAllBodyTypeIsBoolean:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::ForAllBodyTypeIsBoolean'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'forAll' implies ownedBody.type = Boolean
		 *       in
		 *         'IteratorExp::ForAllBodyTypeIsBoolean'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_ForAllBodyTypeIsBoolean);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_forAll.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		            final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		            if (ownedBody == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type = ownedBody.getType();
		            final /*@Thrown*/ boolean eq_0 = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : false;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_ForAllBodyTypeIsBoolean, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateIsUniqueHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateIsUniqueHasOneIterator:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::IsUniqueHasOneIterator'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'isUnique' implies
		 *         ownedIterators->size() = 1
		 *       in
		 *         'IteratorExp::IsUniqueHasOneIterator'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_IsUniqueHasOneIterator);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_isUnique.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		            final @Nullable /*@Thrown*/ OrderedSetValue safe_null_sources = (OrderedSetValue)CollectionExcludingOperation.INSTANCE.evaluate(BOXED_ownedIterators, null);
		            final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(safe_null_sources);
		            final /*@Thrown*/ boolean eq_0 = size.equals(PivotTables.INT_1);
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_IsUniqueHasOneIterator, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateIsUniqueTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateIsUniqueTypeIsBoolean:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::IsUniqueTypeIsBoolean'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'isUnique' implies type = Boolean
		 *       in
		 *         'IteratorExp::IsUniqueTypeIsBoolean'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_IsUniqueTypeIsBoolean);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_isUnique.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final /*@Thrown*/ boolean eq_0 = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : false;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_IsUniqueTypeIsBoolean, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateOneHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateOneHasOneIterator:
		 *   let severity : Integer[1] = 'IteratorExp::OneHasOneIterator'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'one' implies
		 *         ownedIterators->size() = 1
		 *       in
		 *         'IteratorExp::OneHasOneIterator'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_OneHasOneIterator);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_one.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		            final @Nullable /*@Thrown*/ OrderedSetValue safe_null_sources = (OrderedSetValue)CollectionExcludingOperation.INSTANCE.evaluate(BOXED_ownedIterators, null);
		            final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(safe_null_sources);
		            final /*@Thrown*/ boolean eq_0 = size.equals(PivotTables.INT_1);
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_OneHasOneIterator, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateOneTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateOneTypeIsBoolean:
		 *   let severity : Integer[1] = 'IteratorExp::OneTypeIsBoolean'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'one' implies type = Boolean
		 *       in
		 *         'IteratorExp::OneTypeIsBoolean'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_OneTypeIsBoolean);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_one.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final /*@Thrown*/ boolean eq_0 = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : false;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_OneTypeIsBoolean, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateOneBodyTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateOneBodyTypeIsBoolean:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::OneBodyTypeIsBoolean'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'one' implies ownedBody.type = Boolean
		 *       in
		 *         'IteratorExp::OneBodyTypeIsBoolean'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_OneBodyTypeIsBoolean);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_one.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		            final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		            if (ownedBody == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type = ownedBody.getType();
		            final /*@Thrown*/ boolean eq_0 = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : false;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_OneBodyTypeIsBoolean, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateRejectOrSelectHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateRejectOrSelectHasOneIterator:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::RejectOrSelectHasOneIterator'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'reject' or name = 'select' implies
		 *         ownedIterators->size() = 1
		 *       in
		 *         'IteratorExp::RejectOrSelectHasOneIterator'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_RejectOrSelectHasOneIterator);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_status;
		    try {
		        @Nullable /*@Caught*/ Object CAUGHT_or;
		        try {
		            @NonNull /*@Caught*/ Object CAUGHT_eq;
		            try {
		                final @Nullable /*@Thrown*/ String name = this.getName();
		                final /*@Thrown*/ boolean eq = PivotTables.STR_reject.equals(name);
		                CAUGHT_eq = eq;
		            }
		            catch (Exception e) {
		                CAUGHT_eq = ValueUtil.createInvalidValue(e);
		            }
		            @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		            try {
		                final @Nullable /*@Thrown*/ String name_0 = this.getName();
		                final /*@Thrown*/ boolean eq_0 = PivotTables.STR_select.equals(name_0);
		                CAUGHT_eq_0 = eq_0;
		            }
		            catch (Exception e) {
		                CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		            }
		            final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		            CAUGHT_or = or;
		        }
		        catch (Exception e) {
		            CAUGHT_or = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_1;
		        try {
		            final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		            final @Nullable /*@Thrown*/ OrderedSetValue safe_null_sources = (OrderedSetValue)CollectionExcludingOperation.INSTANCE.evaluate(BOXED_ownedIterators, null);
		            final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(safe_null_sources);
		            final /*@Thrown*/ boolean eq_1 = size.equals(PivotTables.INT_1);
		            CAUGHT_eq_1 = eq_1;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_1 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean status = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_or, CAUGHT_eq_1);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_RejectOrSelectHasOneIterator, this, diagnostics, context, getSeverity, CAUGHT_status, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateRejectOrSelectTypeIsSourceType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateRejectOrSelectTypeIsSourceType:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::RejectOrSelectTypeIsSourceType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'reject' or name = 'select' implies type = ownedSource?.type
		 *       in
		 *         'IteratorExp::RejectOrSelectTypeIsSourceType'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_RejectOrSelectTypeIsSourceType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_1;
		if (le) {
		    symbol_1 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_status;
		    try {
		        @Nullable /*@Caught*/ Object CAUGHT_or;
		        try {
		            @NonNull /*@Caught*/ Object CAUGHT_eq;
		            try {
		                final @Nullable /*@Thrown*/ String name = this.getName();
		                final /*@Thrown*/ boolean eq = PivotTables.STR_reject.equals(name);
		                CAUGHT_eq = eq;
		            }
		            catch (Exception e) {
		                CAUGHT_eq = ValueUtil.createInvalidValue(e);
		            }
		            @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		            try {
		                final @Nullable /*@Thrown*/ String name_0 = this.getName();
		                final /*@Thrown*/ boolean eq_0 = PivotTables.STR_select.equals(name_0);
		                CAUGHT_eq_0 = eq_0;
		            }
		            catch (Exception e) {
		                CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		            }
		            final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		            CAUGHT_or = or;
		        }
		        catch (Exception e) {
		            CAUGHT_or = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_1;
		        try {
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		            final /*@Thrown*/ boolean symbol_0 = ownedSource == null;
		            @Nullable /*@Thrown*/ Type safe_type_source;
		            if (symbol_0) {
		                safe_type_source = null;
		            }
		            else {
		                assert ownedSource != null;
		                final @Nullable /*@Thrown*/ Type type_0 = ownedSource.getType();
		                safe_type_source = type_0;
		            }
		            final /*@Thrown*/ boolean eq_1 = (type != null) && (safe_type_source != null) ? (type.getTypeId() == safe_type_source.getTypeId()) : false;
		            CAUGHT_eq_1 = eq_1;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_1 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean status = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_or, CAUGHT_eq_1);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_RejectOrSelectTypeIsSourceType, this, diagnostics, context, getSeverity, CAUGHT_status, PivotTables.INT_0).booleanValue();
		    symbol_1 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateRejectOrSelectTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateRejectOrSelectTypeIsBoolean:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::RejectOrSelectTypeIsBoolean'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'reject' or name = 'select' implies type = Boolean
		 *       in
		 *         'IteratorExp::RejectOrSelectTypeIsBoolean'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_RejectOrSelectTypeIsBoolean);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_status;
		    try {
		        @Nullable /*@Caught*/ Object CAUGHT_or;
		        try {
		            @NonNull /*@Caught*/ Object CAUGHT_eq;
		            try {
		                final @Nullable /*@Thrown*/ String name = this.getName();
		                final /*@Thrown*/ boolean eq = PivotTables.STR_reject.equals(name);
		                CAUGHT_eq = eq;
		            }
		            catch (Exception e) {
		                CAUGHT_eq = ValueUtil.createInvalidValue(e);
		            }
		            @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		            try {
		                final @Nullable /*@Thrown*/ String name_0 = this.getName();
		                final /*@Thrown*/ boolean eq_0 = PivotTables.STR_select.equals(name_0);
		                CAUGHT_eq_0 = eq_0;
		            }
		            catch (Exception e) {
		                CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		            }
		            final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		            CAUGHT_or = or;
		        }
		        catch (Exception e) {
		            CAUGHT_or = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_1;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final /*@Thrown*/ boolean eq_1 = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : false;
		            CAUGHT_eq_1 = eq_1;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_1 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean status = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_or, CAUGHT_eq_1);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_RejectOrSelectTypeIsBoolean, this, diagnostics, context, getSeverity, CAUGHT_status, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSortedByHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateSortedByHasOneIterator:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::SortedByHasOneIterator'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'sortedBy' implies
		 *         ownedIterators->size() = 1
		 *       in
		 *         'IteratorExp::SortedByHasOneIterator'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_SortedByHasOneIterator);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_sortedBy.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		            final @Nullable /*@Thrown*/ OrderedSetValue safe_null_sources = (OrderedSetValue)CollectionExcludingOperation.INSTANCE.evaluate(BOXED_ownedIterators, null);
		            final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(safe_null_sources);
		            final /*@Thrown*/ boolean eq_0 = size.equals(PivotTables.INT_1);
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_SortedByHasOneIterator, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSortedByIsOrderedIfSourceIsOrdered(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateSortedByIsOrderedIfSourceIsOrdered:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::SortedByIsOrderedIfSourceIsOrdered'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'sortedBy' implies
		 *         if
		 *           ownedSource?.type.oclIsKindOf(SequenceType) or
		 *           ownedSource?.type.oclIsKindOf(BagType)
		 *         then type.oclIsKindOf(SequenceType)
		 *         else type.oclIsKindOf(OrderedSetType)
		 *         endif
		 *       in
		 *         'IteratorExp::SortedByIsOrderedIfSourceIsOrdered'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_SortedByIsOrderedIfSourceIsOrdered);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_3;
		if (le) {
		    symbol_3 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_sortedBy.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_symbol_2;
		        try {
		            final @Nullable /*@Thrown*/ Type type_2 = this.getType();
		            @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		            try {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_SequenceType_0 = idResolver.getClass(PivotTables.CLSSid_SequenceType, null);
		                final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		                final /*@Thrown*/ boolean symbol_0 = ownedSource == null;
		                @Nullable /*@Thrown*/ Type safe_type_source;
		                if (symbol_0) {
		                    safe_type_source = null;
		                }
		                else {
		                    assert ownedSource != null;
		                    final @Nullable /*@Thrown*/ Type type = ownedSource.getType();
		                    safe_type_source = type;
		                }
		                final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, safe_type_source, TYP_SequenceType_0).booleanValue();
		                CAUGHT_oclIsKindOf = oclIsKindOf;
		            }
		            catch (Exception e) {
		                CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
		            }
		            @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf_0;
		            try {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_BagType_0 = idResolver.getClass(PivotTables.CLSSid_BagType, null);
		                final @Nullable /*@Thrown*/ OCLExpression ownedSource_0 = this.getOwnedSource();
		                final /*@Thrown*/ boolean symbol_1 = ownedSource_0 == null;
		                @Nullable /*@Thrown*/ Type safe_type_source_0;
		                if (symbol_1) {
		                    safe_type_source_0 = null;
		                }
		                else {
		                    assert ownedSource_0 != null;
		                    final @Nullable /*@Thrown*/ Type type_0 = ownedSource_0.getType();
		                    safe_type_source_0 = type_0;
		                }
		                final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, safe_type_source_0, TYP_BagType_0).booleanValue();
		                CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
		            }
		            catch (Exception e) {
		                CAUGHT_oclIsKindOf_0 = ValueUtil.createInvalidValue(e);
		            }
		            final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf, CAUGHT_oclIsKindOf_0);
		            if (or == null) {
		                throw new InvalidValueException("Null if condition");
		            }
		            /*@Thrown*/ boolean symbol_2;
		            if (or) {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_SequenceType_1 = idResolver.getClass(PivotTables.CLSSid_SequenceType, null);
		                final /*@Thrown*/ boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_SequenceType_1).booleanValue();
		                symbol_2 = oclIsKindOf_1;
		            }
		            else {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OrderedSetType_0 = idResolver.getClass(PivotTables.CLSSid_OrderedSetType, null);
		                final /*@Thrown*/ boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_OrderedSetType_0).booleanValue();
		                symbol_2 = oclIsKindOf_2;
		            }
		            CAUGHT_symbol_2 = symbol_2;
		        }
		        catch (Exception e) {
		            CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_2);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_SortedByIsOrderedIfSourceIsOrdered, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_3 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSortedByElementTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateSortedByElementTypeIsSourceElementType:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::SortedByElementTypeIsSourceElementType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = name = 'sortedBy' implies
		 *         type.oclAsType(CollectionType).elementType =
		 *         ownedBody.type.oclAsType(CollectionType).elementType
		 *       in
		 *         'IteratorExp::SortedByElementTypeIsSourceElementType'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_SortedByElementTypeIsSourceElementType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_implies;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean eq = PivotTables.STR_sortedBy.equals(name);
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_CollectionType_1 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final @NonNull /*@Thrown*/ CollectionType oclAsType = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type, TYP_CollectionType_1));
		            final @Nullable /*@Thrown*/ Type elementType = oclAsType.getElementType();
		            final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		            if (ownedBody == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type_0 = ownedBody.getType();
		            final @NonNull /*@Thrown*/ CollectionType oclAsType_0 = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type_0, TYP_CollectionType_1));
		            final @Nullable /*@Thrown*/ Type elementType_0 = oclAsType_0.getElementType();
		            final /*@Thrown*/ boolean eq_0 = (elementType != null) && (elementType_0 != null) ? (elementType.getTypeId() == elementType_0.getTypeId()) : false;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_implies = implies;
		    }
		    catch (Exception e) {
		        CAUGHT_implies = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_SortedByElementTypeIsSourceElementType, this, diagnostics, context, getSeverity, CAUGHT_implies, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateIteratorTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateIteratorTypeIsSourceElementType:
		 *   let
		 *     severity : Integer[1] = 'IteratorExp::IteratorTypeIsSourceElementType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : Boolean[?] = self.ownedIterators->forAll(p |
		 *           ownedSource?.type.oclAsType(CollectionType)
		 *           .elementType.conformsTo(p?.type))
		 *       in
		 *         'IteratorExp::IteratorTypeIsSourceElementType'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, PivotTables.STR_IteratorExp_c_c_IteratorTypeIsSourceElementType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, getSeverity, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_2;
		if (le) {
		    symbol_2 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @NonNull /*@Caught*/ Object CAUGHT_status;
		    try {
		        final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		        @NonNull /*@Thrown*/ Object accumulator = ValueUtil.TRUE_VALUE;
		        @Nullable Iterator<?> ITERATOR_p = BOXED_ownedIterators.iterator();
		        /*@Thrown*/ boolean status;
		        while (true) {
		            if (!ITERATOR_p.hasNext()) {
		                if (accumulator == ValueUtil.TRUE_VALUE) {
		                    status = (Boolean)accumulator;
		                }
		                else {
		                    throw (InvalidValueException)accumulator;
		                }
		                break;
		            }
		            @Nullable /*@NonInvalid*/ Variable p = (Variable)ITERATOR_p.next();
		            /**
		             * 
		             * ownedSource?.type.oclAsType(CollectionType)
		             * .elementType.conformsTo(p?.type)
		             */
		            @NonNull /*@Caught*/ Object CAUGHT_conformsTo;
		            try {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_CollectionType_0 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		                final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		                final /*@Thrown*/ boolean symbol_0 = ownedSource == null;
		                @Nullable /*@Thrown*/ Type safe_type_source;
		                if (symbol_0) {
		                    safe_type_source = null;
		                }
		                else {
		                    assert ownedSource != null;
		                    final @Nullable /*@Thrown*/ Type type = ownedSource.getType();
		                    safe_type_source = type;
		                }
		                final @NonNull /*@Thrown*/ CollectionType oclAsType = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, safe_type_source, TYP_CollectionType_0));
		                final @Nullable /*@Thrown*/ Type elementType = oclAsType.getElementType();
		                final /*@NonInvalid*/ boolean symbol_1 = p == null;
		                @Nullable /*@Thrown*/ Type safe_type_source_0;
		                if (symbol_1) {
		                    safe_type_source_0 = null;
		                }
		                else {
		                    assert p != null;
		                    final @Nullable /*@Thrown*/ Type type_0 = p.getType();
		                    safe_type_source_0 = type_0;
		                }
		                final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(evaluator, elementType, safe_type_source_0).booleanValue();
		                CAUGHT_conformsTo = conformsTo;
		            }
		            catch (Exception e) {
		                CAUGHT_conformsTo = ValueUtil.createInvalidValue(e);
		            }
		            //
		            if (CAUGHT_conformsTo == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
		                status = ValueUtil.FALSE_VALUE;
		                break;														// Stop immediately 
		            }
		            else if (CAUGHT_conformsTo == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
		                ;															// Carry on
		            }
		            else if (CAUGHT_conformsTo instanceof InvalidValueException) {		// Abnormal exception evaluation result
		                accumulator = CAUGHT_conformsTo;									// Cache an exception failure
		            }
		            else {															// Impossible badly typed result
		                accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
		            }
		        }
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, PivotTables.STR_IteratorExp_c_c_IteratorTypeIsSourceElementType, this, diagnostics, context, getSeverity, CAUGHT_status, PivotTables.INT_0).booleanValue();
		    symbol_2 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_2;
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
			case PivotPackage.ITERATOR_EXP___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.ITERATOR_EXP___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotInvalid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
			case PivotPackage.ITERATOR_EXP___VALIDATE_COLLECT_ELEMENT_TYPE_IS_FLATTENED_BODY_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCollectElementTypeIsFlattenedBodyType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
	@Override
	public Element getReferredElement()
	{
		return getReferredIteration();
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

} //IteratorExpImpl
