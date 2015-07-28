/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.ParameterableElement;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludingAllOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constructor Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ShadowExpImpl#getOwnedParts <em>Owned Parts</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ShadowExpImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ShadowExpImpl extends OCLExpressionImpl implements ShadowExp
{
	/**
	 * The cached value of the '{@link #getOwnedParts() <em>Owned Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ShadowPart> ownedParts;
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShadowExpImpl()
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
		return PivotPackage.Literals.SHADOW_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<ShadowPart> getOwnedParts()
	{
		if (ownedParts == null)
		{
			ownedParts = new EObjectContainmentEList<ShadowPart>(ShadowPart.class, this, PivotPackage.SHADOW_EXP__OWNED_PARTS);
		}
		return ownedParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValue()
	{
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(String newValue)
	{
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.SHADOW_EXP__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateAllPartsAreInitialized(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateAllPartsAreInitialized:
		 *   let
		 *     severity : Integer[1] = 'ShadowExp::AllPartsAreInitialized'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[1] = let
		 *           actualParts : Set(Property)[*|1] = ownedParts.referredProperty->asSet()
		 *         in
		 *           let
		 *             formalParts : OrderedSet(Property)[*|1] = type.oclAsType(Class).ownedProperties
		 *           in
		 *             let
		 *               nonDefaultParts : OrderedSet(Property)[*|1] = formalParts->select(
		 *                 (opposite <> null implies not opposite?.isComposite
		 *                 ) and not isImplicit and not isDerived and defaultValueString = null and ownedExpression = null and
		 *                 if type.oclIsKindOf(CollectionType)
		 *                 then type.oclAsType(CollectionType).lower > 0
		 *                 else isRequired
		 *                 endif)
		 *             in
		 *               let
		 *                 missingParts : OrderedSet(Property)[*|1] = nonDefaultParts->excludingAll(actualParts)
		 *               in missingParts->isEmpty()
		 *       in
		 *         let
		 *           message : String[?] = if status <> true
		 *           then
		 *             let
		 *               actualParts : Set(Property)[*|1] = ownedParts.referredProperty->asSet()
		 *             in
		 *               let
		 *                 formalParts : OrderedSet(Property)[*|1] = type.oclAsType(Class).ownedProperties
		 *               in
		 *                 let
		 *                   nonDefaultParts : OrderedSet(Property)[*|1] = formalParts->select(
		 *                     (opposite <> null implies not opposite?.isComposite
		 *                     ) and not isImplicit and not isDerived and defaultValueString = null and ownedExpression = null and
		 *                     if type.oclIsKindOf(CollectionType)
		 *                     then
		 *                       type.oclAsType(CollectionType).lower > 0
		 *                     else isRequired
		 *                     endif)
		 *                 in
		 *                   let
		 *                     missingParts : OrderedSet(Property)[*|1] = nonDefaultParts->excludingAll(actualParts)
		 *                   in
		 *                     missingParts->iterate(p; acc : String[?] = 'Missing initializer for ' | acc + ' ' + p.name)
		 *           else null
		 *           endif
		 *         in
		 *           'ShadowExp::AllPartsAreInitialized'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_ShadowExp_c_c_AllPartsAreInitialized);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_4;
		if (le) {
		    symbol_4 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @NonNull /*@Caught*/ Object CAUGHT_isEmpty;
		    try {
		        final @NonNull /*@Thrown*/ List<ShadowPart> ownedParts = this.getOwnedParts();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedParts = idResolver.createOrderedSetOfAll(PivotTables.ORD_NF_CLSSid_ShadowPart, ownedParts);
		        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PivotTables.SEQ_NF_CLSSid_Property);
		        @NonNull Iterator<?> ITERATOR__1 = BOXED_ownedParts.iterator();
		        @NonNull /*@Thrown*/ SequenceValue collect;
		        while (true) {
		            if (!ITERATOR__1.hasNext()) {
		                collect = accumulator;
		                break;
		            }
		            @SuppressWarnings("null")
		            @NonNull /*@NonInvalid*/ ShadowPart _1 = (ShadowPart)ITERATOR__1.next();
		            /**
		             * referredProperty
		             */
		            @SuppressWarnings("null")
		            final @NonNull /*@Thrown*/ Property referredProperty = _1.getReferredProperty();
		            //
		            accumulator.add(referredProperty);
		        }
		        final @NonNull /*@Thrown*/ SetValue actualParts = CollectionAsSetOperation.INSTANCE.evaluate(collect);
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Class_0 = idResolver.getClass(PivotTables.CLSSid_Class, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final @NonNull /*@Thrown*/ org.eclipse.ocl.pivot.Class oclAsType = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type, TYP_Class_0));
		        final @NonNull /*@Thrown*/ List<Property> formalParts = oclAsType.getOwnedProperties();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_formalParts = idResolver.createOrderedSetOfAll(PivotTables.ORD_NF_CLSSid_Property, formalParts);
		        @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator_0 = ValueUtil.createOrderedSetAccumulatorValue(PivotTables.ORD_NF_CLSSid_Property);
		        @NonNull Iterator<?> ITERATOR__1_0 = BOXED_formalParts.iterator();
		        @NonNull /*@Thrown*/ OrderedSetValue nonDefaultParts;
		        while (true) {
		            if (!ITERATOR__1_0.hasNext()) {
		                nonDefaultParts = accumulator_0;
		                break;
		            }
		            @SuppressWarnings("null")
		            @NonNull /*@NonInvalid*/ Property _1_0 = (Property)ITERATOR__1_0.next();
		            /**
		             * 
		             * (opposite <> null implies not opposite?.isComposite
		             * ) and not isImplicit and not isDerived and defaultValueString = null and ownedExpression = null and
		             * if type.oclIsKindOf(CollectionType)
		             * then type.oclAsType(CollectionType).lower > 0
		             * else isRequired
		             * endif
		             */
		            @Nullable /*@Caught*/ Object CAUGHT_and_2;
		            try {
		                @Nullable /*@Caught*/ Object CAUGHT_and_1;
		                try {
		                    @Nullable /*@Caught*/ Object CAUGHT_and_0;
		                    try {
		                        @Nullable /*@Caught*/ Object CAUGHT_and;
		                        try {
		                            @Nullable /*@Caught*/ Object CAUGHT_implies;
		                            try {
		                                @NonNull /*@Caught*/ Object CAUGHT_ne;
		                                try {
		                                    final @Nullable /*@Thrown*/ Property opposite = _1_0.getOpposite();
		                                    final /*@Thrown*/ boolean ne = opposite != null;
		                                    CAUGHT_ne = ne;
		                                }
		                                catch (Exception e) {
		                                    CAUGHT_ne = ValueUtil.createInvalidValue(e);
		                                }
		                                @Nullable /*@Caught*/ Object CAUGHT_not;
		                                try {
		                                    final @Nullable /*@Thrown*/ Property opposite_0 = _1_0.getOpposite();
		                                    @Nullable /*@Caught*/ Object CAUGHT_opposite_0;
		                                    try {
		                                        CAUGHT_opposite_0 = opposite_0;
		                                    }
		                                    catch (Exception e) {
		                                        CAUGHT_opposite_0 = ValueUtil.createInvalidValue(e);
		                                    }
		                                    final @NonNull /*@NonInvalid*/ Object symbol_0 = CAUGHT_opposite_0 == null;
		                                    @Nullable /*@Thrown*/ Boolean safe_isComposite_source;
		                                    if (symbol_0 == Boolean.TRUE) {
		                                        safe_isComposite_source = null;
		                                    }
		                                    else {
		                                        assert opposite_0 != null;
		                                        final /*@Thrown*/ boolean isComposite = opposite_0.isIsComposite();
		                                        safe_isComposite_source = isComposite;
		                                    }
		                                    final @Nullable /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(safe_isComposite_source);
		                                    CAUGHT_not = not;
		                                }
		                                catch (Exception e) {
		                                    CAUGHT_not = ValueUtil.createInvalidValue(e);
		                                }
		                                final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_ne, CAUGHT_not);
		                                CAUGHT_implies = implies;
		                            }
		                            catch (Exception e) {
		                                CAUGHT_implies = ValueUtil.createInvalidValue(e);
		                            }
		                            @Nullable /*@Caught*/ Object CAUGHT_not_0;
		                            try {
		                                final /*@Thrown*/ boolean isImplicit = _1_0.isIsImplicit();
		                                final @Nullable /*@Thrown*/ Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(isImplicit);
		                                CAUGHT_not_0 = not_0;
		                            }
		                            catch (Exception e) {
		                                CAUGHT_not_0 = ValueUtil.createInvalidValue(e);
		                            }
		                            final @Nullable /*@Thrown*/ Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_implies, CAUGHT_not_0);
		                            CAUGHT_and = and;
		                        }
		                        catch (Exception e) {
		                            CAUGHT_and = ValueUtil.createInvalidValue(e);
		                        }
		                        @Nullable /*@Caught*/ Object CAUGHT_not_1;
		                        try {
		                            final /*@Thrown*/ boolean isDerived = _1_0.isIsDerived();
		                            final @Nullable /*@Thrown*/ Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(isDerived);
		                            CAUGHT_not_1 = not_1;
		                        }
		                        catch (Exception e) {
		                            CAUGHT_not_1 = ValueUtil.createInvalidValue(e);
		                        }
		                        final @Nullable /*@Thrown*/ Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and, CAUGHT_not_1);
		                        CAUGHT_and_0 = and_0;
		                    }
		                    catch (Exception e) {
		                        CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
		                    }
		                    @NonNull /*@Caught*/ Object CAUGHT_eq;
		                    try {
		                        final @Nullable /*@Thrown*/ String defaultValueString = _1_0.getDefaultValueString();
		                        final /*@Thrown*/ boolean eq = defaultValueString == null;
		                        CAUGHT_eq = eq;
		                    }
		                    catch (Exception e) {
		                        CAUGHT_eq = ValueUtil.createInvalidValue(e);
		                    }
		                    final @Nullable /*@Thrown*/ Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_eq);
		                    CAUGHT_and_1 = and_1;
		                }
		                catch (Exception e) {
		                    CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
		                }
		                @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		                try {
		                    final @Nullable /*@Thrown*/ LanguageExpression ownedExpression = _1_0.getOwnedExpression();
		                    final /*@Thrown*/ boolean eq_0 = ownedExpression == null;
		                    CAUGHT_eq_0 = eq_0;
		                }
		                catch (Exception e) {
		                    CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		                }
		                final @Nullable /*@Thrown*/ Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, CAUGHT_eq_0);
		                CAUGHT_and_2 = and_2;
		            }
		            catch (Exception e) {
		                CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
		            }
		            @NonNull /*@Caught*/ Object CAUGHT_symbol_1;
		            try {
		                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_CollectionType_0 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		                final @Nullable /*@Thrown*/ Type type_0 = _1_0.getType();
		                final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type_0, TYP_CollectionType_0).booleanValue();
		                /*@Thrown*/ boolean symbol_1;
		                if (oclIsKindOf) {
		                    final @NonNull /*@Thrown*/ CollectionType oclAsType_0 = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_0, TYP_CollectionType_0));
		                    @SuppressWarnings("null")
		                    final @NonNull /*@Thrown*/ Object lower = oclAsType_0.getLower();
		                    final @NonNull /*@Thrown*/ IntegerValue BOXED_lower = ValueUtil.integerValueOf(lower);
		                    final /*@Thrown*/ boolean gt = OclComparableGreaterThanOperation.INSTANCE.evaluate(executor, BOXED_lower, PivotTables.INT_0).booleanValue();
		                    symbol_1 = gt;
		                }
		                else {
		                    final /*@Thrown*/ boolean isRequired = _1_0.isIsRequired();
		                    symbol_1 = isRequired;
		                }
		                CAUGHT_symbol_1 = symbol_1;
		            }
		            catch (Exception e) {
		                CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
		            }
		            final @Nullable /*@Thrown*/ Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_2, CAUGHT_symbol_1);
		            if (and_3 == null) {
		                throw new InvalidValueException("Null body for \'OrderedSet(T).select(OrderedSet.T[?] | Lambda T() : Boolean[1]) : OrderedSet(T)\'");
		            }
		            //
		            if (and_3 == ValueUtil.TRUE_VALUE) {
		                accumulator_0.add(_1_0);
		            }
		        }
		        final @NonNull /*@Thrown*/ OrderedSetValue missingParts = (OrderedSetValue)CollectionExcludingAllOperation.INSTANCE.evaluate(nonDefaultParts, actualParts);
		        final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(missingParts).booleanValue();
		        CAUGHT_isEmpty = isEmpty;
		    }
		    catch (Exception e) {
		        CAUGHT_isEmpty = ValueUtil.createInvalidValue(e);
		    }
		    @Nullable /*@Caught*/ Object CAUGHT_message_0;
		    try {
		        if (CAUGHT_isEmpty instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_isEmpty;
		        }
		        final /*@Thrown*/ boolean ne_0 = CAUGHT_isEmpty == Boolean.FALSE;
		        @Nullable /*@Thrown*/ String message_0;
		        if (ne_0) {
		            final @NonNull /*@Thrown*/ List<ShadowPart> ownedParts_0 = this.getOwnedParts();
		            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedParts_0 = idResolver.createOrderedSetOfAll(PivotTables.ORD_NF_CLSSid_ShadowPart, ownedParts_0);
		            @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(PivotTables.SEQ_NF_CLSSid_Property);
		            @NonNull Iterator<?> ITERATOR__1_1 = BOXED_ownedParts_0.iterator();
		            @NonNull /*@Thrown*/ SequenceValue collect_0;
		            while (true) {
		                if (!ITERATOR__1_1.hasNext()) {
		                    collect_0 = accumulator_1;
		                    break;
		                }
		                @SuppressWarnings("null")
		                @NonNull /*@NonInvalid*/ ShadowPart _1_1 = (ShadowPart)ITERATOR__1_1.next();
		                /**
		                 * referredProperty
		                 */
		                @SuppressWarnings("null")
		                final @NonNull /*@Thrown*/ Property referredProperty_0 = _1_1.getReferredProperty();
		                //
		                accumulator_1.add(referredProperty_0);
		            }
		            final @NonNull /*@Thrown*/ SetValue actualParts_0 = CollectionAsSetOperation.INSTANCE.evaluate(collect_0);
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Class_1 = idResolver.getClass(PivotTables.CLSSid_Class, null);
		            final @Nullable /*@Thrown*/ Type type_2 = this.getType();
		            final @NonNull /*@Thrown*/ org.eclipse.ocl.pivot.Class oclAsType_1 = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_2, TYP_Class_1));
		            final @NonNull /*@Thrown*/ List<Property> formalParts_0 = oclAsType_1.getOwnedProperties();
		            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_formalParts_0 = idResolver.createOrderedSetOfAll(PivotTables.ORD_NF_CLSSid_Property, formalParts_0);
		            @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator_2 = ValueUtil.createOrderedSetAccumulatorValue(PivotTables.ORD_NF_CLSSid_Property);
		            @NonNull Iterator<?> ITERATOR__1_2 = BOXED_formalParts_0.iterator();
		            @NonNull /*@Thrown*/ OrderedSetValue nonDefaultParts_0;
		            while (true) {
		                if (!ITERATOR__1_2.hasNext()) {
		                    nonDefaultParts_0 = accumulator_2;
		                    break;
		                }
		                @SuppressWarnings("null")
		                @NonNull /*@NonInvalid*/ Property _1_2 = (Property)ITERATOR__1_2.next();
		                /**
		                 * 
		                 * (opposite <> null implies not opposite?.isComposite
		                 * ) and not isImplicit and not isDerived and defaultValueString = null and ownedExpression = null and
		                 * if type.oclIsKindOf(CollectionType)
		                 * then type.oclAsType(CollectionType).lower > 0
		                 * else isRequired
		                 * endif
		                 */
		                @Nullable /*@Caught*/ Object CAUGHT_and_7;
		                try {
		                    @Nullable /*@Caught*/ Object CAUGHT_and_6;
		                    try {
		                        @Nullable /*@Caught*/ Object CAUGHT_and_5;
		                        try {
		                            @Nullable /*@Caught*/ Object CAUGHT_and_4;
		                            try {
		                                @Nullable /*@Caught*/ Object CAUGHT_implies_0;
		                                try {
		                                    @NonNull /*@Caught*/ Object CAUGHT_ne_1;
		                                    try {
		                                        final @Nullable /*@Thrown*/ Property opposite_1 = _1_2.getOpposite();
		                                        final /*@Thrown*/ boolean ne_1 = opposite_1 != null;
		                                        CAUGHT_ne_1 = ne_1;
		                                    }
		                                    catch (Exception e) {
		                                        CAUGHT_ne_1 = ValueUtil.createInvalidValue(e);
		                                    }
		                                    @Nullable /*@Caught*/ Object CAUGHT_not_2;
		                                    try {
		                                        final @Nullable /*@Thrown*/ Property opposite_2 = _1_2.getOpposite();
		                                        @Nullable /*@Caught*/ Object CAUGHT_opposite_2;
		                                        try {
		                                            CAUGHT_opposite_2 = opposite_2;
		                                        }
		                                        catch (Exception e) {
		                                            CAUGHT_opposite_2 = ValueUtil.createInvalidValue(e);
		                                        }
		                                        final @NonNull /*@NonInvalid*/ Object symbol_2 = CAUGHT_opposite_2 == null;
		                                        @Nullable /*@Thrown*/ Boolean safe_isComposite_source_0;
		                                        if (symbol_2 == Boolean.TRUE) {
		                                            safe_isComposite_source_0 = null;
		                                        }
		                                        else {
		                                            assert opposite_2 != null;
		                                            final /*@Thrown*/ boolean isComposite_0 = opposite_2.isIsComposite();
		                                            safe_isComposite_source_0 = isComposite_0;
		                                        }
		                                        final @Nullable /*@Thrown*/ Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(safe_isComposite_source_0);
		                                        CAUGHT_not_2 = not_2;
		                                    }
		                                    catch (Exception e) {
		                                        CAUGHT_not_2 = ValueUtil.createInvalidValue(e);
		                                    }
		                                    final @Nullable /*@Thrown*/ Boolean implies_0 = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_ne_1, CAUGHT_not_2);
		                                    CAUGHT_implies_0 = implies_0;
		                                }
		                                catch (Exception e) {
		                                    CAUGHT_implies_0 = ValueUtil.createInvalidValue(e);
		                                }
		                                @Nullable /*@Caught*/ Object CAUGHT_not_3;
		                                try {
		                                    final /*@Thrown*/ boolean isImplicit_0 = _1_2.isIsImplicit();
		                                    final @Nullable /*@Thrown*/ Boolean not_3 = BooleanNotOperation.INSTANCE.evaluate(isImplicit_0);
		                                    CAUGHT_not_3 = not_3;
		                                }
		                                catch (Exception e) {
		                                    CAUGHT_not_3 = ValueUtil.createInvalidValue(e);
		                                }
		                                final @Nullable /*@Thrown*/ Boolean and_4 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_implies_0, CAUGHT_not_3);
		                                CAUGHT_and_4 = and_4;
		                            }
		                            catch (Exception e) {
		                                CAUGHT_and_4 = ValueUtil.createInvalidValue(e);
		                            }
		                            @Nullable /*@Caught*/ Object CAUGHT_not_4;
		                            try {
		                                final /*@Thrown*/ boolean isDerived_0 = _1_2.isIsDerived();
		                                final @Nullable /*@Thrown*/ Boolean not_4 = BooleanNotOperation.INSTANCE.evaluate(isDerived_0);
		                                CAUGHT_not_4 = not_4;
		                            }
		                            catch (Exception e) {
		                                CAUGHT_not_4 = ValueUtil.createInvalidValue(e);
		                            }
		                            final @Nullable /*@Thrown*/ Boolean and_5 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_4, CAUGHT_not_4);
		                            CAUGHT_and_5 = and_5;
		                        }
		                        catch (Exception e) {
		                            CAUGHT_and_5 = ValueUtil.createInvalidValue(e);
		                        }
		                        @NonNull /*@Caught*/ Object CAUGHT_eq_1;
		                        try {
		                            final @Nullable /*@Thrown*/ String defaultValueString_0 = _1_2.getDefaultValueString();
		                            final /*@Thrown*/ boolean eq_1 = defaultValueString_0 == null;
		                            CAUGHT_eq_1 = eq_1;
		                        }
		                        catch (Exception e) {
		                            CAUGHT_eq_1 = ValueUtil.createInvalidValue(e);
		                        }
		                        final @Nullable /*@Thrown*/ Boolean and_6 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_5, CAUGHT_eq_1);
		                        CAUGHT_and_6 = and_6;
		                    }
		                    catch (Exception e) {
		                        CAUGHT_and_6 = ValueUtil.createInvalidValue(e);
		                    }
		                    @NonNull /*@Caught*/ Object CAUGHT_eq_2;
		                    try {
		                        final @Nullable /*@Thrown*/ LanguageExpression ownedExpression_0 = _1_2.getOwnedExpression();
		                        final /*@Thrown*/ boolean eq_2 = ownedExpression_0 == null;
		                        CAUGHT_eq_2 = eq_2;
		                    }
		                    catch (Exception e) {
		                        CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
		                    }
		                    final @Nullable /*@Thrown*/ Boolean and_7 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_6, CAUGHT_eq_2);
		                    CAUGHT_and_7 = and_7;
		                }
		                catch (Exception e) {
		                    CAUGHT_and_7 = ValueUtil.createInvalidValue(e);
		                }
		                @NonNull /*@Caught*/ Object CAUGHT_symbol_3;
		                try {
		                    final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_CollectionType_2 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		                    final @Nullable /*@Thrown*/ Type type_3 = _1_2.getType();
		                    final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type_3, TYP_CollectionType_2).booleanValue();
		                    /*@Thrown*/ boolean symbol_3;
		                    if (oclIsKindOf_0) {
		                        final @NonNull /*@Thrown*/ CollectionType oclAsType_2 = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_3, TYP_CollectionType_2));
		                        @SuppressWarnings("null")
		                        final @NonNull /*@Thrown*/ Object lower_0 = oclAsType_2.getLower();
		                        final @NonNull /*@Thrown*/ IntegerValue BOXED_lower_0 = ValueUtil.integerValueOf(lower_0);
		                        final /*@Thrown*/ boolean gt_0 = OclComparableGreaterThanOperation.INSTANCE.evaluate(executor, BOXED_lower_0, PivotTables.INT_0).booleanValue();
		                        symbol_3 = gt_0;
		                    }
		                    else {
		                        final /*@Thrown*/ boolean isRequired_0 = _1_2.isIsRequired();
		                        symbol_3 = isRequired_0;
		                    }
		                    CAUGHT_symbol_3 = symbol_3;
		                }
		                catch (Exception e) {
		                    CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
		                }
		                final @Nullable /*@Thrown*/ Boolean and_8 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_7, CAUGHT_symbol_3);
		                if (and_8 == null) {
		                    throw new InvalidValueException("Null body for \'OrderedSet(T).select(OrderedSet.T[?] | Lambda T() : Boolean[1]) : OrderedSet(T)\'");
		                }
		                //
		                if (and_8 == ValueUtil.TRUE_VALUE) {
		                    accumulator_2.add(_1_2);
		                }
		            }
		            final @NonNull /*@Thrown*/ OrderedSetValue missingParts_0 = (OrderedSetValue)CollectionExcludingAllOperation.INSTANCE.evaluate(nonDefaultParts_0, actualParts_0);
		            @NonNull /*@NonInvalid*/ String acc = PivotTables.STR_Missing_32_initializer_32_for_32;
		            @NonNull Iterator<?> ITERATOR_p_0 = missingParts_0.iterator();
		            @Nullable /*@Thrown*/ String iterate;
		            while (true) {
		                if (!ITERATOR_p_0.hasNext()) {
		                    iterate = acc;
		                    break;
		                }
		                @SuppressWarnings("null")
		                @NonNull /*@NonInvalid*/ Property p_0 = (Property)ITERATOR_p_0.next();
		                /**
		                 * acc + ' ' + p.name
		                 */
		                final @NonNull /*@NonInvalid*/ String sum = StringConcatOperation.INSTANCE.evaluate(acc, PivotTables.STR__32);
		                final @Nullable /*@Thrown*/ String name = p_0.getName();
		                final @NonNull /*@NonInvalid*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name);
		                //
		                acc = sum_0;
		            }
		            message_0 = iterate;
		        }
		        else {
		            message_0 = null;
		        }
		        CAUGHT_message_0 = message_0;
		    }
		    catch (Exception e) {
		        CAUGHT_message_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_ShadowExp_c_c_AllPartsAreInitialized, this, null, diagnostics, context, CAUGHT_message_0, severity_0, CAUGHT_isEmpty, PivotTables.INT_0).booleanValue();
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PivotPackage.SHADOW_EXP__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.SHADOW_EXP__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.SHADOW_EXP__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.SHADOW_EXP__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.SHADOW_EXP__OWNED_PARTS:
				return ((InternalEList<?>)getOwnedParts()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case PivotPackage.SHADOW_EXP__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.SHADOW_EXP__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.SHADOW_EXP__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.SHADOW_EXP__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.SHADOW_EXP__NAME:
				return getName();
			case PivotPackage.SHADOW_EXP__IS_MANY:
				return isIsMany();
			case PivotPackage.SHADOW_EXP__IS_REQUIRED:
				return isIsRequired();
			case PivotPackage.SHADOW_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.SHADOW_EXP__TYPE_VALUE:
				return getTypeValue();
			case PivotPackage.SHADOW_EXP__OWNED_PARTS:
				return getOwnedParts();
			case PivotPackage.SHADOW_EXP__VALUE:
				return getValue();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case PivotPackage.SHADOW_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.SHADOW_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.SHADOW_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.SHADOW_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.SHADOW_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.SHADOW_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.SHADOW_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.SHADOW_EXP__TYPE_VALUE:
				setTypeValue((Type)newValue);
				return;
			case PivotPackage.SHADOW_EXP__OWNED_PARTS:
				getOwnedParts().clear();
				getOwnedParts().addAll((Collection<? extends ShadowPart>)newValue);
				return;
			case PivotPackage.SHADOW_EXP__VALUE:
				setValue((String)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.SHADOW_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.SHADOW_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.SHADOW_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.SHADOW_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.SHADOW_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.SHADOW_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.SHADOW_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.SHADOW_EXP__TYPE_VALUE:
				setTypeValue((Type)null);
				return;
			case PivotPackage.SHADOW_EXP__OWNED_PARTS:
				getOwnedParts().clear();
				return;
			case PivotPackage.SHADOW_EXP__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.SHADOW_EXP__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.SHADOW_EXP__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.SHADOW_EXP__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.SHADOW_EXP__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.SHADOW_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.SHADOW_EXP__IS_MANY:
				return isIsMany() != IS_MANY_EDEFAULT;
			case PivotPackage.SHADOW_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.SHADOW_EXP__TYPE:
				return type != null;
			case PivotPackage.SHADOW_EXP__TYPE_VALUE:
				return typeValue != null;
			case PivotPackage.SHADOW_EXP__OWNED_PARTS:
				return ownedParts != null && !ownedParts.isEmpty();
			case PivotPackage.SHADOW_EXP__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
		}
		return eDynamicIsSet(featureID);
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
			case PivotPackage.SHADOW_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.SHADOW_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.SHADOW_EXP___MAY_HAVE_NULL_NAME:
				return mayHaveNullName();
			case PivotPackage.SHADOW_EXP___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.SHADOW_EXP___MAY_HAVE_NULL_TYPE:
				return mayHaveNullType();
			case PivotPackage.SHADOW_EXP___MAY_HAVE_OCL_INVALID_TYPE:
				return mayHaveOclInvalidType();
			case PivotPackage.SHADOW_EXP___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.SHADOW_EXP___VALIDATE_TYPE_IS_NOT_OCL_INVALID__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotOclInvalid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.SHADOW_EXP___AS_TEMPLATE_PARAMETER:
				return asTemplateParameter();
			case PivotPackage.SHADOW_EXP___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT:
				return isCompatibleWith((ParameterableElement)arguments.get(0));
			case PivotPackage.SHADOW_EXP___IS_TEMPLATE_PARAMETER:
				return isTemplateParameter();
			case PivotPackage.SHADOW_EXP___IS_NON_NULL:
				return isNonNull();
			case PivotPackage.SHADOW_EXP___VALIDATE_ALL_PARTS_ARE_INITIALIZED__DIAGNOSTICCHAIN_MAP:
				return validateAllPartsAreInitialized((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitShadowExp(this);
	}

	@Override
	public org.eclipse.ocl.pivot.Class getType() {
		return (org.eclipse.ocl.pivot.Class)super.getType();
	}
} //ConstructorExpImpl
