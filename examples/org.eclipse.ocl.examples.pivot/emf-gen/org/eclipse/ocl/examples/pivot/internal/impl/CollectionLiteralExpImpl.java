/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
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
	protected static final int KIND_EFLAG_OFFSET = 10;

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
	 * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionLiteralPart> part;

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
	public CollectionKind getKind() {
		return KIND_EFLAG_VALUES[(eFlags & KIND_EFLAG) >>> KIND_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public List<CollectionLiteralPart> getPart()
	{
		if (part == null)
		{
			part = new EObjectContainmentEList<CollectionLiteralPart>(CollectionLiteralPart.class, this, PivotPackage.COLLECTION_LITERAL_EXP__PART);
		}
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionKindIsConcrete(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv CollectionKindIsConcrete: kind <> CollectionKind::Collection
		 * 
		 * 
		 */
		@NonNull /*@Caught*/ Object CAUGHT_ne;
		try {
		    final @Nullable /*@Thrown*/ Enumerator kind = this.getKind();
		    final @Nullable /*@Thrown*/ EnumerationLiteralId BOXED_kind = kind == null ? null : PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(DomainUtil.nonNullState(kind.getName()));
		    final /*@Thrown*/ boolean ne = BOXED_kind != PivotTables.ELITid_Collection;
		    CAUGHT_ne = ne;
		}
		catch (Exception e) {
		    CAUGHT_ne = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_ne == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"CollectionLiteralExp", "CollectionKindIsConcrete", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.COLLECTION_LITERAL_EXP__COLLECTION_KIND_IS_CONCRETE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetKindIsSet(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv SetKindIsSet: kind = CollectionKind::Set implies type.oclIsKindOf (SetType)
		 * 
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ Enumerator kind = this.getKind();
		        final @Nullable /*@Thrown*/ EnumerationLiteralId BOXED_kind = kind == null ? null : PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(DomainUtil.nonNullState(kind.getName()));
		        final /*@Thrown*/ boolean self_71 = BOXED_kind == PivotTables.ELITid_Set;
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValuesUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SetType_0 = idResolver.getType(PivotTables.CLSSid_SetType, null);
		        final @Nullable /*@Thrown*/ DomainType type = this.getType();
		        final /*@Thrown*/ boolean b = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_SetType_0).booleanValue();
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValuesUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_0 = CAUGHT_self_71 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_8;
		    if (symbol_0) {
		        final /*@NonInvalid*/ boolean symbol_1 = CAUGHT_b instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_3;
		        if (symbol_1) {
		            if (CAUGHT_self_71 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_self_71;
		            }
		            symbol_3 = (Boolean)CAUGHT_self_71;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_2;
		            if (CAUGHT_b == Boolean.TRUE) {
		                symbol_2 = ValuesUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_self_71 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_71;
		                }
		                symbol_2 = (Boolean)CAUGHT_self_71;
		            }
		            symbol_3 = symbol_2;
		        }
		        symbol_8 = symbol_3;
		    }
		    else {
		        if (CAUGHT_self_71 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_self_71;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_self_71 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_7;
		        if (eq) {
		            symbol_7 = ValuesUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_4 = CAUGHT_b instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_6;
		            if (symbol_4) {
		                if (CAUGHT_b instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b;
		                }
		                symbol_6 = (Boolean)CAUGHT_b;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_5;
		                if (CAUGHT_b == Boolean.TRUE) {
		                    symbol_5 = ValuesUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValuesUtil.FALSE_VALUE;
		                }
		                symbol_6 = symbol_5;
		            }
		            symbol_7 = symbol_6;
		        }
		        symbol_8 = symbol_7;
		    }
		    CAUGHT_symbol_8 = symbol_8;
		}
		catch (Exception e) {
		    CAUGHT_symbol_8 = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"CollectionLiteralExp", "SetKindIsSet", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.COLLECTION_LITERAL_EXP__SET_KIND_IS_SET, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderedSetKindIsOrderedSet(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv OrderedSetKindIsOrderedSet: kind = CollectionKind::OrderedSet implies type.oclIsKindOf (OrderedSetType)
		 * 
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ Enumerator kind = this.getKind();
		        final @Nullable /*@Thrown*/ EnumerationLiteralId BOXED_kind = kind == null ? null : PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(DomainUtil.nonNullState(kind.getName()));
		        final /*@Thrown*/ boolean self_71 = BOXED_kind == PivotTables.ELITid_OrderedSet;
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValuesUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_OrderedSetType_0 = idResolver.getType(PivotTables.CLSSid_OrderedSetType, null);
		        final @Nullable /*@Thrown*/ DomainType type = this.getType();
		        final /*@Thrown*/ boolean b = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_OrderedSetType_0).booleanValue();
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValuesUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_0 = CAUGHT_self_71 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_8;
		    if (symbol_0) {
		        final /*@NonInvalid*/ boolean symbol_1 = CAUGHT_b instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_3;
		        if (symbol_1) {
		            if (CAUGHT_self_71 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_self_71;
		            }
		            symbol_3 = (Boolean)CAUGHT_self_71;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_2;
		            if (CAUGHT_b == Boolean.TRUE) {
		                symbol_2 = ValuesUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_self_71 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_71;
		                }
		                symbol_2 = (Boolean)CAUGHT_self_71;
		            }
		            symbol_3 = symbol_2;
		        }
		        symbol_8 = symbol_3;
		    }
		    else {
		        if (CAUGHT_self_71 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_self_71;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_self_71 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_7;
		        if (eq) {
		            symbol_7 = ValuesUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_4 = CAUGHT_b instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_6;
		            if (symbol_4) {
		                if (CAUGHT_b instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b;
		                }
		                symbol_6 = (Boolean)CAUGHT_b;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_5;
		                if (CAUGHT_b == Boolean.TRUE) {
		                    symbol_5 = ValuesUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValuesUtil.FALSE_VALUE;
		                }
		                symbol_6 = symbol_5;
		            }
		            symbol_7 = symbol_6;
		        }
		        symbol_8 = symbol_7;
		    }
		    CAUGHT_symbol_8 = symbol_8;
		}
		catch (Exception e) {
		    CAUGHT_symbol_8 = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"CollectionLiteralExp", "OrderedSetKindIsOrderedSet", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.COLLECTION_LITERAL_EXP__ORDERED_SET_KIND_IS_ORDERED_SET, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceKindIsSequence(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv SequenceKindIsSequence: kind = CollectionKind::Sequence implies type.oclIsKindOf (SequenceType)
		 * 
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ Enumerator kind = this.getKind();
		        final @Nullable /*@Thrown*/ EnumerationLiteralId BOXED_kind = kind == null ? null : PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(DomainUtil.nonNullState(kind.getName()));
		        final /*@Thrown*/ boolean self_71 = BOXED_kind == PivotTables.ELITid_Sequence;
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValuesUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SequenceType_0 = idResolver.getType(PivotTables.CLSSid_SequenceType, null);
		        final @Nullable /*@Thrown*/ DomainType type = this.getType();
		        final /*@Thrown*/ boolean b = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_SequenceType_0).booleanValue();
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValuesUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_0 = CAUGHT_self_71 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_8;
		    if (symbol_0) {
		        final /*@NonInvalid*/ boolean symbol_1 = CAUGHT_b instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_3;
		        if (symbol_1) {
		            if (CAUGHT_self_71 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_self_71;
		            }
		            symbol_3 = (Boolean)CAUGHT_self_71;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_2;
		            if (CAUGHT_b == Boolean.TRUE) {
		                symbol_2 = ValuesUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_self_71 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_71;
		                }
		                symbol_2 = (Boolean)CAUGHT_self_71;
		            }
		            symbol_3 = symbol_2;
		        }
		        symbol_8 = symbol_3;
		    }
		    else {
		        if (CAUGHT_self_71 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_self_71;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_self_71 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_7;
		        if (eq) {
		            symbol_7 = ValuesUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_4 = CAUGHT_b instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_6;
		            if (symbol_4) {
		                if (CAUGHT_b instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b;
		                }
		                symbol_6 = (Boolean)CAUGHT_b;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_5;
		                if (CAUGHT_b == Boolean.TRUE) {
		                    symbol_5 = ValuesUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValuesUtil.FALSE_VALUE;
		                }
		                symbol_6 = symbol_5;
		            }
		            symbol_7 = symbol_6;
		        }
		        symbol_8 = symbol_7;
		    }
		    CAUGHT_symbol_8 = symbol_8;
		}
		catch (Exception e) {
		    CAUGHT_symbol_8 = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"CollectionLiteralExp", "SequenceKindIsSequence", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.COLLECTION_LITERAL_EXP__SEQUENCE_KIND_IS_SEQUENCE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBagKindIsBag(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv BagKindIsBag: kind = CollectionKind::Bag implies type.oclIsKindOf (BagType)
		 * 
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ Enumerator kind = this.getKind();
		        final @Nullable /*@Thrown*/ EnumerationLiteralId BOXED_kind = kind == null ? null : PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(DomainUtil.nonNullState(kind.getName()));
		        final /*@Thrown*/ boolean self_71 = BOXED_kind == PivotTables.ELITid_Bag;
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValuesUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_BagType_0 = idResolver.getType(PivotTables.CLSSid_BagType, null);
		        final @Nullable /*@Thrown*/ DomainType type = this.getType();
		        final /*@Thrown*/ boolean b = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_BagType_0).booleanValue();
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValuesUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_0 = CAUGHT_self_71 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_8;
		    if (symbol_0) {
		        final /*@NonInvalid*/ boolean symbol_1 = CAUGHT_b instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_3;
		        if (symbol_1) {
		            if (CAUGHT_self_71 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_self_71;
		            }
		            symbol_3 = (Boolean)CAUGHT_self_71;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_2;
		            if (CAUGHT_b == Boolean.TRUE) {
		                symbol_2 = ValuesUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_self_71 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_71;
		                }
		                symbol_2 = (Boolean)CAUGHT_self_71;
		            }
		            symbol_3 = symbol_2;
		        }
		        symbol_8 = symbol_3;
		    }
		    else {
		        if (CAUGHT_self_71 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_self_71;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_self_71 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_7;
		        if (eq) {
		            symbol_7 = ValuesUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_4 = CAUGHT_b instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_6;
		            if (symbol_4) {
		                if (CAUGHT_b instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b;
		                }
		                symbol_6 = (Boolean)CAUGHT_b;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_5;
		                if (CAUGHT_b == Boolean.TRUE) {
		                    symbol_5 = ValuesUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValuesUtil.FALSE_VALUE;
		                }
		                symbol_6 = symbol_5;
		            }
		            symbol_7 = symbol_6;
		        }
		        symbol_8 = symbol_7;
		    }
		    CAUGHT_symbol_8 = symbol_8;
		}
		catch (Exception e) {
		    CAUGHT_symbol_8 = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"CollectionLiteralExp", "BagKindIsBag", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.COLLECTION_LITERAL_EXP__BAG_KIND_IS_BAG, message, new Object [] { this }));
		}
		return false;
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
			case PivotPackage.COLLECTION_LITERAL_EXP__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				return ((InternalEList<?>)getPart()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.COLLECTION_LITERAL_EXP__EXTENSION:
				return getExtension();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				return getName();
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				return getKind();
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				return getPart();
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
			case PivotPackage.COLLECTION_LITERAL_EXP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
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
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				setKind((CollectionKind)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				getPart().clear();
				getPart().addAll((Collection<? extends CollectionLiteralPart>)newValue);
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
			case PivotPackage.COLLECTION_LITERAL_EXP__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
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
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				getPart().clear();
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
			case PivotPackage.COLLECTION_LITERAL_EXP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				return type != null;
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				return (eFlags & KIND_EFLAG) != KIND_EFLAG_DEFAULT;
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				return part != null && !part.isEmpty();
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
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_BAG_KIND_IS_BAG__DIAGNOSTICCHAIN_MAP:
				return validateBagKindIsBag((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_COLLECTION_KIND_IS_CONCRETE__DIAGNOSTICCHAIN_MAP:
				return validateCollectionKindIsConcrete((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
