/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.CollectionKind;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.EnumerationLiteralId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CollectionLiteralExpImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CollectionLiteralExpImpl#getOwnedParts <em>Owned Parts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionLiteralExpImpl
		extends LiteralExpImpl
		implements CollectionLiteralExp {

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final CollectionKind KIND_EDEFAULT = CollectionKind.COLLECTION;

	/**
	 * The offset of the flags representing the value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG_OFFSET = 9;

	/**
	 * The flags representing the default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG_DEFAULT = KIND_EDEFAULT.ordinal() << KIND_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link CollectionKind Collection Kind}'
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	private static final CollectionKind[] KIND_EFLAG_VALUES = CollectionKind.values();

	/**
	 * The flags representing the value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG = 0x7 << KIND_EFLAG_OFFSET;

	/**
	 * The cached value of the '{@link #getOwnedParts() <em>Owned Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParts()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionLiteralPart> ownedParts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.COLLECTION_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CollectionKind getKind() {
		return KIND_EFLAG_VALUES[(eFlags & KIND_EFLAG) >>> KIND_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKind(CollectionKind newKind) {
		CollectionKind oldKind = KIND_EFLAG_VALUES[(eFlags & KIND_EFLAG) >>> KIND_EFLAG_OFFSET];
		if (newKind == null) newKind = KIND_EDEFAULT;
		eFlags = eFlags & ~KIND_EFLAG | newKind.ordinal() << KIND_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_LITERAL_EXP__KIND, oldKind, newKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<CollectionLiteralPart> getOwnedParts()
	{
		if (ownedParts == null)
		{
			ownedParts = new EObjectContainmentEList<CollectionLiteralPart>(CollectionLiteralPart.class, this, PivotPackage.COLLECTION_LITERAL_EXP__OWNED_PARTS);
		}
		return ownedParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCollectionKindIsConcrete(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCollectionKindIsConcrete:
		 *   let
		 *     severity : Integer[1] = 'CollectionLiteralExp::CollectionKindIsConcrete'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[1] = kind <> CollectionKind::Collection
		 *       in
		 *         'CollectionLiteralExp::CollectionKindIsConcrete'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_CollectionLiteralExp_c_c_CollectionKindIsConcrete);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @NonNull /*@Caught*/ Object CAUGHT_status;
		    try {
		        @SuppressWarnings("null")
		        final @NonNull /*@Thrown*/ CollectionKind kind = this.getKind();
		        final @NonNull /*@Thrown*/ EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(ClassUtil.nonNullState(kind.getName()));
		        final /*@Thrown*/ boolean status = BOXED_kind != PivotTables.ELITid_Collection;
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_CollectionLiteralExp_c_c_CollectionKindIsConcrete, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
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
	public boolean validateCompatibleElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCompatibleElementType:
		 *   let
		 *     severity : Integer[1] = 'CollectionLiteralExp::CompatibleElementType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[?] = let
		 *           elementType : Type[1] = type.oclAsType(CollectionType).elementType
		 *         in
		 *           ownedParts->forAll(type.conformsTo(elementType))
		 *       in
		 *         'CollectionLiteralExp::CompatibleElementType'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_CollectionLiteralExp_c_c_CompatibleElementType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @NonNull /*@Caught*/ Object CAUGHT_forAll;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_CollectionType = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final @NonNull /*@Thrown*/ CollectionType oclAsType = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType));
		        @SuppressWarnings("null")
		        final @NonNull /*@Thrown*/ Type elementType = oclAsType.getElementType();
		        final @NonNull /*@Thrown*/ List<CollectionLiteralPart> ownedParts = this.getOwnedParts();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedParts = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_CollectionLiteralPart, ownedParts);
		        @Nullable /*@Thrown*/ Object accumulator = ValueUtil.TRUE_VALUE;
		        @NonNull Iterator<?> ITERATOR__1 = BOXED_ownedParts.iterator();
		        /*@Thrown*/ boolean forAll;
		        while (true) {
		            if (!ITERATOR__1.hasNext()) {
		                if (accumulator == ValueUtil.TRUE_VALUE) {
		                    forAll = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    throw (InvalidValueException)accumulator;
		                }
		                break;
		            }
		            @SuppressWarnings("null")
		            @NonNull /*@NonInvalid*/ CollectionLiteralPart _1 = (CollectionLiteralPart)ITERATOR__1.next();
		            /**
		             * type.conformsTo(elementType)
		             */
		            @NonNull /*@Caught*/ Object CAUGHT_conformsTo;
		            try {
		                final @Nullable /*@Thrown*/ Type type_0 = _1.getType();
		                final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type_0, elementType).booleanValue();
		                CAUGHT_conformsTo = conformsTo;
		            }
		            catch (Exception e) {
		                CAUGHT_conformsTo = ValueUtil.createInvalidValue(e);
		            }
		            //
		            if (CAUGHT_conformsTo == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
		                forAll = ValueUtil.FALSE_VALUE;
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
		        CAUGHT_forAll = forAll;
		    }
		    catch (Exception e) {
		        CAUGHT_forAll = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_CollectionLiteralExp_c_c_CompatibleElementType, this, null, diagnostics, context, null, severity_0, CAUGHT_forAll, PivotTables.INT_0).booleanValue();
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
	public boolean validateCompatibleNullFree(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCompatibleNullFree:
		 *   let
		 *     severity : Integer[1] = 'CollectionLiteralExp::CompatibleNullFree'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[?] = type.oclAsType(CollectionType).isNullFree implies
		 *         let nullFrees : Sequence(Boolean) = ownedParts.isNullFree()
		 *         in nullFrees->excludes(null) implies nullFrees->forAll(nf | nf)
		 *       in
		 *         'CollectionLiteralExp::CompatibleNullFree'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_CollectionLiteralExp_c_c_CompatibleNullFree);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_status;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_isNullFree;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_CollectionType_0 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final @NonNull /*@Thrown*/ CollectionType oclAsType = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType_0));
		            final /*@Thrown*/ boolean isNullFree = oclAsType.isIsNullFree();
		            CAUGHT_isNullFree = isNullFree;
		        }
		        catch (Exception e) {
		            CAUGHT_isNullFree = ValueUtil.createInvalidValue(e);
		        }
		        @Nullable /*@Caught*/ Object CAUGHT_implies;
		        try {
		            @NonNull /*@Caught*/ Object CAUGHT_nullFrees;
		            try {
		                final @NonNull /*@Thrown*/ List<CollectionLiteralPart> ownedParts = this.getOwnedParts();
		                final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedParts = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_CollectionLiteralPart, ownedParts);
		                @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PivotTables.SEQ_PRIMid_Boolean);
		                @NonNull Iterator<?> ITERATOR__1 = BOXED_ownedParts.iterator();
		                @NonNull /*@Thrown*/ SequenceValue nullFrees;
		                while (true) {
		                    if (!ITERATOR__1.hasNext()) {
		                        nullFrees = accumulator;
		                        break;
		                    }
		                    @SuppressWarnings("null")
		                    @NonNull /*@NonInvalid*/ CollectionLiteralPart _1 = (CollectionLiteralPart)ITERATOR__1.next();
		                    /**
		                     * isNullFree()
		                     */
		                    final @Nullable /*@Thrown*/ Boolean isNullFree_0 = _1.isNullFree();
		                    //
		                    accumulator.add(isNullFree_0);
		                }
		                CAUGHT_nullFrees = nullFrees;
		            }
		            catch (Exception e) {
		                CAUGHT_nullFrees = ValueUtil.createInvalidValue(e);
		            }
		            @NonNull /*@Caught*/ Object CAUGHT_excludes;
		            try {
		                if (CAUGHT_nullFrees instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_nullFrees;
		                }
		                final /*@Thrown*/ boolean excludes = CollectionExcludesOperation.INSTANCE.evaluate(CAUGHT_nullFrees, null).booleanValue();
		                CAUGHT_excludes = excludes;
		            }
		            catch (Exception e) {
		                CAUGHT_excludes = ValueUtil.createInvalidValue(e);
		            }
		            @Nullable /*@Caught*/ Object CAUGHT_forAll;
		            try {
		                if (CAUGHT_nullFrees instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_nullFrees;
		                }
		                @Nullable /*@Thrown*/ Object accumulator_0 = ValueUtil.TRUE_VALUE;
		                @Nullable Iterator<?> ITERATOR_nf = ((SequenceValue)CAUGHT_nullFrees).iterator();
		                @Nullable /*@Thrown*/ Boolean forAll;
		                while (true) {
		                    if (!ITERATOR_nf.hasNext()) {
		                        if (accumulator_0 == null) {
		                            forAll = null;
		                        }
		                        else if (accumulator_0 == ValueUtil.TRUE_VALUE) {
		                            forAll = ValueUtil.TRUE_VALUE;
		                        }
		                        else {
		                            throw (InvalidValueException)accumulator_0;
		                        }
		                        break;
		                    }
		                    @Nullable /*@NonInvalid*/ Boolean nf = (Boolean)ITERATOR_nf.next();
		                    /**
		                     * nf
		                     */
		                    //
		                    if (nf == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
		                        forAll = ValueUtil.FALSE_VALUE;
		                        break;														// Stop immediately 
		                    }
		                    else if (nf == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
		                        ;															// Carry on
		                    }
		                    else if (nf == null) {								// Abnormal null body evaluation result
		                        if (accumulator_0 == ValueUtil.TRUE_VALUE) {
		                            accumulator_0 = null;										// Cache a null failure
		                        }
		                    }
		                    else {															// Impossible badly typed result
		                        accumulator_0 = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
		                    }
		                }
		                CAUGHT_forAll = forAll;
		            }
		            catch (Exception e) {
		                CAUGHT_forAll = ValueUtil.createInvalidValue(e);
		            }
		            final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_excludes, CAUGHT_forAll);
		            CAUGHT_implies = implies;
		        }
		        catch (Exception e) {
		            CAUGHT_implies = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean status = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_isNullFree, CAUGHT_implies);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_CollectionLiteralExp_c_c_CompatibleNullFree, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
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
	public boolean validateCompatibleType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCompatibleType:
		 *   let
		 *     severity : Integer[1] = 'CollectionLiteralExp::CompatibleType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[1] = type.oclIsKindOf(CollectionType)
		 *       in
		 *         'CollectionLiteralExp::CompatibleType'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_CollectionLiteralExp_c_c_CompatibleType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @NonNull /*@Caught*/ Object CAUGHT_status;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_CollectionType_0 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final /*@Thrown*/ boolean status = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType_0).booleanValue();
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_CollectionLiteralExp_c_c_CompatibleType, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
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
	public boolean validateSetKindIsSet(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateSetKindIsSet:
		 *   let
		 *     severity : Integer[1] = 'CollectionLiteralExp::SetKindIsSet'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[?] = kind = CollectionKind::Set implies
		 *         type.oclIsKindOf(SetType)
		 *       in
		 *         'CollectionLiteralExp::SetKindIsSet'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_CollectionLiteralExp_c_c_SetKindIsSet);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_status;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            @SuppressWarnings("null")
		            final @NonNull /*@Thrown*/ CollectionKind kind = this.getKind();
		            final @NonNull /*@Thrown*/ EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(ClassUtil.nonNullState(kind.getName()));
		            final /*@Thrown*/ boolean eq = BOXED_kind == PivotTables.ELITid_Set;
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_SetType = idResolver.getClass(PivotTables.CLSSid_SetType, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_SetType).booleanValue();
		            CAUGHT_oclIsKindOf = oclIsKindOf;
		        }
		        catch (Exception e) {
		            CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean status = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_oclIsKindOf);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_CollectionLiteralExp_c_c_SetKindIsSet, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
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
	public boolean validateOrderedSetKindIsOrderedSet(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateOrderedSetKindIsOrderedSet:
		 *   let
		 *     severity : Integer[1] = 'CollectionLiteralExp::OrderedSetKindIsOrderedSet'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[?] = kind = CollectionKind::OrderedSet implies
		 *         type.oclIsKindOf(OrderedSetType)
		 *       in
		 *         'CollectionLiteralExp::OrderedSetKindIsOrderedSet'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_CollectionLiteralExp_c_c_OrderedSetKindIsOrderedSet);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_status;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            @SuppressWarnings("null")
		            final @NonNull /*@Thrown*/ CollectionKind kind = this.getKind();
		            final @NonNull /*@Thrown*/ EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(ClassUtil.nonNullState(kind.getName()));
		            final /*@Thrown*/ boolean eq = BOXED_kind == PivotTables.ELITid_OrderedSet;
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OrderedSetType = idResolver.getClass(PivotTables.CLSSid_OrderedSetType, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_OrderedSetType).booleanValue();
		            CAUGHT_oclIsKindOf = oclIsKindOf;
		        }
		        catch (Exception e) {
		            CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean status = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_oclIsKindOf);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_CollectionLiteralExp_c_c_OrderedSetKindIsOrderedSet, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
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
	public boolean validateSequenceKindIsSequence(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateSequenceKindIsSequence:
		 *   let
		 *     severity : Integer[1] = 'CollectionLiteralExp::SequenceKindIsSequence'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[?] = kind = CollectionKind::Sequence implies
		 *         type.oclIsKindOf(SequenceType)
		 *       in
		 *         'CollectionLiteralExp::SequenceKindIsSequence'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_CollectionLiteralExp_c_c_SequenceKindIsSequence);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_status;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            @SuppressWarnings("null")
		            final @NonNull /*@Thrown*/ CollectionKind kind = this.getKind();
		            final @NonNull /*@Thrown*/ EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(ClassUtil.nonNullState(kind.getName()));
		            final /*@Thrown*/ boolean eq = BOXED_kind == PivotTables.ELITid_Sequence;
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_SequenceType = idResolver.getClass(PivotTables.CLSSid_SequenceType, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_SequenceType).booleanValue();
		            CAUGHT_oclIsKindOf = oclIsKindOf;
		        }
		        catch (Exception e) {
		            CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean status = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_oclIsKindOf);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_CollectionLiteralExp_c_c_SequenceKindIsSequence, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
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
	public boolean validateBagKindIsBag(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateBagKindIsBag:
		 *   let
		 *     severity : Integer[1] = 'CollectionLiteralExp::BagKindIsBag'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[?] = kind = CollectionKind::Bag implies
		 *         type.oclIsKindOf(BagType)
		 *       in
		 *         'CollectionLiteralExp::BagKindIsBag'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_CollectionLiteralExp_c_c_BagKindIsBag);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_status;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            @SuppressWarnings("null")
		            final @NonNull /*@Thrown*/ CollectionKind kind = this.getKind();
		            final @NonNull /*@Thrown*/ EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(ClassUtil.nonNullState(kind.getName()));
		            final /*@Thrown*/ boolean eq = BOXED_kind == PivotTables.ELITid_Bag;
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_BagType = idResolver.getClass(PivotTables.CLSSid_BagType, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_BagType).booleanValue();
		            CAUGHT_oclIsKindOf = oclIsKindOf;
		        }
		        catch (Exception e) {
		            CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean status = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_oclIsKindOf);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_CollectionLiteralExp_c_c_BagKindIsBag, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_LITERAL_EXP__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_PARTS:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_LITERAL_EXP__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				return getName();
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_MANY:
				return isIsMany();
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_REQUIRED:
				return isIsRequired();
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE_VALUE:
				return getTypeValue();
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				return getKind();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_PARTS:
				return getOwnedParts();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_LITERAL_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE_VALUE:
				setTypeValue((Type)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				setKind((CollectionKind)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_PARTS:
				getOwnedParts().clear();
				getOwnedParts().addAll((Collection<? extends CollectionLiteralPart>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_LITERAL_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE_VALUE:
				setTypeValue((Type)null);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_PARTS:
				getOwnedParts().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_LITERAL_EXP__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_MANY:
				return isIsMany() != IS_MANY_EDEFAULT;
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				return type != null;
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE_VALUE:
				return typeValue != null;
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				return (eFlags & KIND_EFLAG) != KIND_EFLAG_DEFAULT;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_PARTS:
				return ownedParts != null && !ownedParts.isEmpty();
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
			case PivotPackage.COLLECTION_LITERAL_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.COLLECTION_LITERAL_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___MAY_HAVE_NULL_NAME:
				return mayHaveNullName();
			case PivotPackage.COLLECTION_LITERAL_EXP___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.COLLECTION_LITERAL_EXP___MAY_HAVE_NULL_TYPE:
				return mayHaveNullType();
			case PivotPackage.COLLECTION_LITERAL_EXP___MAY_HAVE_OCL_INVALID_TYPE:
				return mayHaveOclInvalidType();
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_TYPE_IS_NOT_OCL_INVALID__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotOclInvalid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___IS_NON_NULL:
				return isNonNull();
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_TYPE_VALUE_IS_NULL__DIAGNOSTICCHAIN_MAP:
				return validateTypeValueIsNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_BAG_KIND_IS_BAG__DIAGNOSTICCHAIN_MAP:
				return validateBagKindIsBag((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_COLLECTION_KIND_IS_CONCRETE__DIAGNOSTICCHAIN_MAP:
				return validateCollectionKindIsConcrete((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_COMPATIBLE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_COMPATIBLE_NULL_FREE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleNullFree((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_COMPATIBLE_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_ORDERED_SET_KIND_IS_ORDERED_SET__DIAGNOSTICCHAIN_MAP:
				return validateOrderedSetKindIsOrderedSet((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_SEQUENCE_KIND_IS_SEQUENCE__DIAGNOSTICCHAIN_MAP:
				return validateSequenceKindIsSequence((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_SET_KIND_IS_SET__DIAGNOSTICCHAIN_MAP:
				return validateSetKindIsSet((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCollectionLiteralExp(this);
	}
} //CollectionLiteralExpImpl
