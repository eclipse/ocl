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

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectValidator;
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
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryConstants;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.iterator.ClosureIteration;
import org.eclipse.ocl.pivot.library.iterator.SortedByIteration;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.util.PivotValidator;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.validation.ValidationWarning;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterator Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
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
		MetamodelManager metamodelManager = PivotUtilInternal.getMetamodelManager(ClassUtil.nonNullState(eResource()));
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
		MetamodelManager metamodelManager = PivotUtilInternal.getMetamodelManager(ClassUtil.nonNullState(eResource()));
		StandardLibraryInternal standardLibrary = metamodelManager.getStandardLibrary();
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
				Type specializedBodyType = bodyType != null ? TemplateParameterSubstitutionVisitor.specializeType(bodyType, this, metamodelManager, sourceType, sourceTypeValue) : null;
				boolean isOk = false;
				if (bodyType != null) {
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
		 * inv AnyHasOneIterator: name = 'any' implies ownedIterators->size() = 1
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_any.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedIterators);
		        final /*@Thrown*/ boolean b = size.equals(PivotTables.INT_1);
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "AnyHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ANY_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
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
		 * inv AnyTypeIsSourceElementType: name = 'any' implies type =
		 *   ownedSource.type.oclAsType(CollectionType).elementType
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_any.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_CollectionType_0 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		        if (ownedSource == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type_0 = ownedSource.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_CollectionType_0);
		        if (oclAsType == null) {
		            throw new InvalidValueException("Null source for \'pivot::CollectionType::elementType\'");
		        }
		        final @Nullable /*@Thrown*/ Type elementType = oclAsType.getElementType();
		        final /*@Thrown*/ boolean b = (type != null) && (elementType != null) ? (type.getTypeId() == elementType.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "AnyTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ANY_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
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
		 * inv AnyBodyTypeIsBoolean: name = 'any' implies ownedBody.type = 'Boolean'
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_any.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		        if (ownedBody == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type = ownedBody.getType();
		        final /*@Thrown*/ boolean b = PivotTables.STR_Boolean.equals(type);
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "AnyBodyTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ANY_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
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
		 * inv ClosureHasOneIterator: name = 'closure' implies ownedIterators->size() = 1
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_closure.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedIterators);
		        final /*@Thrown*/ boolean b = size.equals(PivotTables.INT_1);
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ClosureHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__CLOSURE_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
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
		 * inv ClosureTypeIsUniqueCollection: name = 'closure' implies
		 *   if
		 *     ownedSource.type.oclIsKindOf(SequenceType) or
		 *     ownedSource.type.oclIsKindOf(OrderedSetType)
		 *   then type.oclIsKindOf(OrderedSetType)
		 *   else type.oclIsKindOf(SetType)
		 *   endif
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_17;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_closure.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b_0;
		    try {
		        final @Nullable /*@Thrown*/ Type type_2 = this.getType();
		        @NonNull /*@Caught*/ Object CAUGHT_self_72;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_SequenceType_0 = idResolver.getClass(PivotTables.CLSSid_SequenceType, null);
		            final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		            if (ownedSource == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type = ownedSource.getType();
		            final /*@Thrown*/ boolean self_72 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_SequenceType_0).booleanValue();
		            CAUGHT_self_72 = self_72;
		        }
		        catch (Exception e) {
		            CAUGHT_self_72 = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_b;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_OrderedSetType_0 = idResolver.getClass(PivotTables.CLSSid_OrderedSetType, null);
		            final @Nullable /*@Thrown*/ OCLExpression ownedSource_0 = this.getOwnedSource();
		            if (ownedSource_0 == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type_0 = ownedSource_0.getType();
		            final /*@Thrown*/ boolean b = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_OrderedSetType_0).booleanValue();
		            CAUGHT_b = b;
		        }
		        catch (Exception e) {
		            CAUGHT_b = ValueUtil.createInvalidValue(e);
		        }
		        final /*@NonInvalid*/ boolean symbol_0 = CAUGHT_self_72 instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_8;
		        if (symbol_0) {
		            final /*@NonInvalid*/ boolean symbol_1 = CAUGHT_b instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_3;
		            if (symbol_1) {
		                if (CAUGHT_self_72 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_72;
		                }
		                symbol_3 = (Boolean)CAUGHT_self_72;
		            }
		            else {
		                /*@Thrown*/ boolean symbol_2;
		                if (CAUGHT_b == Boolean.TRUE) {
		                    symbol_2 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    if (CAUGHT_self_72 instanceof InvalidValueException) {
		                        throw (InvalidValueException)CAUGHT_self_72;
		                    }
		                    symbol_2 = (Boolean)CAUGHT_self_72;
		                }
		                symbol_3 = symbol_2;
		            }
		            symbol_8 = symbol_3;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_7;
		            if (CAUGHT_self_72 == Boolean.TRUE) {
		                symbol_7 = ValueUtil.TRUE_VALUE;
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
		                        symbol_5 = ValueUtil.TRUE_VALUE;
		                    }
		                    else {
		                        symbol_5 = ValueUtil.FALSE_VALUE;
		                    }
		                    symbol_6 = symbol_5;
		                }
		                symbol_7 = symbol_6;
		            }
		            symbol_8 = symbol_7;
		        }
		        /*@Thrown*/ boolean b_0;
		        if (symbol_8) {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_OrderedSetType_1 = idResolver.getClass(PivotTables.CLSSid_OrderedSetType, null);
		            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_pivot_c_c_OrderedSetType_1).booleanValue();
		            b_0 = oclIsKindOf;
		        }
		        else {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_SetType_0 = idResolver.getClass(PivotTables.CLSSid_SetType, null);
		            final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_pivot_c_c_SetType_0).booleanValue();
		            b_0 = oclIsKindOf_0;
		        }
		        CAUGHT_b_0 = b_0;
		    }
		    catch (Exception e) {
		        CAUGHT_b_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_9 = CAUGHT_self_71 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_17;
		    if (symbol_9) {
		        final /*@NonInvalid*/ boolean symbol_10 = CAUGHT_b_0 instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_12;
		        if (symbol_10) {
		            if (CAUGHT_self_71 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_self_71;
		            }
		            symbol_12 = (Boolean)CAUGHT_self_71;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_11;
		            if (CAUGHT_b_0 == Boolean.TRUE) {
		                symbol_11 = ValueUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_self_71 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_71;
		                }
		                symbol_11 = (Boolean)CAUGHT_self_71;
		            }
		            symbol_12 = symbol_11;
		        }
		        symbol_17 = symbol_12;
		    }
		    else {
		        if (CAUGHT_self_71 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_self_71;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_self_71 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_16;
		        if (eq) {
		            symbol_16 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_13 = CAUGHT_b_0 instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_15;
		            if (symbol_13) {
		                if (CAUGHT_b_0 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b_0;
		                }
		                symbol_15 = (Boolean)CAUGHT_b_0;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_14;
		                if (CAUGHT_b_0 == Boolean.TRUE) {
		                    symbol_14 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_14 = ValueUtil.FALSE_VALUE;
		                }
		                symbol_15 = symbol_14;
		            }
		            symbol_16 = symbol_15;
		        }
		        symbol_17 = symbol_16;
		    }
		    CAUGHT_symbol_17 = symbol_17;
		}
		catch (Exception e) {
		    CAUGHT_symbol_17 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_17 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ClosureTypeIsUniqueCollection", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__CLOSURE_TYPE_IS_UNIQUE_COLLECTION, message, new Object [] { this }));
		}
		return false;
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
		 * inv CollectElementTypeIsFlattenedBodyType: name = 'collect' implies
		 *   type.oclAsType(CollectionType).elementType =
		 *   ownedBody.type.flattenedType()
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_collect.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_CollectionType_0 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType_0);
		        if (oclAsType == null) {
		            throw new InvalidValueException("Null source for \'pivot::CollectionType::elementType\'");
		        }
		        final @Nullable /*@Thrown*/ Type elementType = oclAsType.getElementType();
		        final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		        if (ownedBody == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type_0 = ownedBody.getType();
		        if (type_0 == null) {
		            throw new InvalidValueException("Null source for \'pivot::Type::flattenedType() : pivot::Type[?]\'");
		        }
		        final @NonNull /*@Thrown*/ Type flattenedType = type_0.flattenedType();
		        final /*@Thrown*/ boolean b = (elementType != null) ? (elementType.getTypeId() == flattenedType.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectElementTypeIsFlattenedBodyType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_ELEMENT_TYPE_IS_FLATTENED_BODY_TYPE, message, new Object [] { this }));
		}
		return false;
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
		 * inv ClosureSourceElementTypeIsBodyElementType: name = 'closure' implies
		 *   ownedSource.type.oclAsType(CollectionType).elementType =
		 *   if ownedBody.type.oclIsKindOf(CollectionType)
		 *   then ownedBody.type.oclAsType(CollectionType).elementType
		 *   else ownedBody.type
		 *   endif
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_9;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_closure.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_CollectionType_1 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		        final @Nullable /*@Thrown*/ OCLExpression ownedBody_1 = this.getOwnedBody();
		        if (ownedBody_1 == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type_2 = ownedBody_1.getType();
		        final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		        if (ownedSource == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type = ownedSource.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType_1);
		        if (oclAsType == null) {
		            throw new InvalidValueException("Null source for \'pivot::CollectionType::elementType\'");
		        }
		        final @Nullable /*@Thrown*/ Type elementType = oclAsType.getElementType();
		        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_pivot_c_c_CollectionType_1).booleanValue();
		        @Nullable /*@Thrown*/ Type symbol_0;
		        if (oclIsKindOf) {
		            final @Nullable /*@Thrown*/ CollectionType oclAsType_0 = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type_2, TYP_pivot_c_c_CollectionType_1);
		            if (oclAsType_0 == null) {
		                throw new InvalidValueException("Null source for \'pivot::CollectionType::elementType\'");
		            }
		            final @Nullable /*@Thrown*/ Type elementType_0 = oclAsType_0.getElementType();
		            symbol_0 = elementType_0;
		        }
		        else {
		            symbol_0 = type_2;
		        }
		        final /*@Thrown*/ boolean b = (elementType != null) && (symbol_0 != null) ? (elementType.getTypeId() == symbol_0.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_1 = CAUGHT_self_71 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_9;
		    if (symbol_1) {
		        final /*@NonInvalid*/ boolean symbol_2 = CAUGHT_b instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_4;
		        if (symbol_2) {
		            if (CAUGHT_self_71 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_self_71;
		            }
		            symbol_4 = (Boolean)CAUGHT_self_71;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_3;
		            if (CAUGHT_b == Boolean.TRUE) {
		                symbol_3 = ValueUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_self_71 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_71;
		                }
		                symbol_3 = (Boolean)CAUGHT_self_71;
		            }
		            symbol_4 = symbol_3;
		        }
		        symbol_9 = symbol_4;
		    }
		    else {
		        if (CAUGHT_self_71 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_self_71;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_self_71 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_8;
		        if (eq) {
		            symbol_8 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_5 = CAUGHT_b instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_7;
		            if (symbol_5) {
		                if (CAUGHT_b instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b;
		                }
		                symbol_7 = (Boolean)CAUGHT_b;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_6;
		                if (CAUGHT_b == Boolean.TRUE) {
		                    symbol_6 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_6 = ValueUtil.FALSE_VALUE;
		                }
		                symbol_7 = symbol_6;
		            }
		            symbol_8 = symbol_7;
		        }
		        symbol_9 = symbol_8;
		    }
		    CAUGHT_symbol_9 = symbol_9;
		}
		catch (Exception e) {
		    CAUGHT_symbol_9 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_9 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ClosureSourceElementTypeIsBodyElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__CLOSURE_SOURCE_ELEMENT_TYPE_IS_BODY_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
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
		 * inv ClosureElementTypeIsSourceElementType: name = 'closure' implies
		 *   type.oclAsType(CollectionType).elementType =
		 *   ownedSource.type.oclAsType(CollectionType).elementType
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_closure.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_CollectionType_1 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType_1);
		        if (oclAsType == null) {
		            throw new InvalidValueException("Null source for \'pivot::CollectionType::elementType\'");
		        }
		        final @Nullable /*@Thrown*/ Type elementType = oclAsType.getElementType();
		        final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		        if (ownedSource == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type_0 = ownedSource.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType_0 = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_CollectionType_1);
		        if (oclAsType_0 == null) {
		            throw new InvalidValueException("Null source for \'pivot::CollectionType::elementType\'");
		        }
		        final @Nullable /*@Thrown*/ Type elementType_0 = oclAsType_0.getElementType();
		        final /*@Thrown*/ boolean b = (elementType != null) && (elementType_0 != null) ? (elementType.getTypeId() == elementType_0.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ClosureElementTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__CLOSURE_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
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
		 * inv CollectHasOneIterator: name = 'collect' implies ownedIterators->size() = 1
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_collect.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedIterators);
		        final /*@Thrown*/ boolean b = size.equals(PivotTables.INT_1);
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
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
		 * inv CollectTypeIsUnordered: name = 'collect' implies
		 *   if
		 *     ownedSource.type.oclIsKindOf(SequenceType) or
		 *     ownedSource.type.oclIsKindOf(OrderedSetType)
		 *   then type.oclIsKindOf(SequenceType)
		 *   else type.oclIsKindOf(BagType)
		 *   endif
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_17;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_collect.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b_0;
		    try {
		        final @Nullable /*@Thrown*/ Type type_2 = this.getType();
		        @NonNull /*@Caught*/ Object CAUGHT_self_72;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_SequenceType_0 = idResolver.getClass(PivotTables.CLSSid_SequenceType, null);
		            final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		            if (ownedSource == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type = ownedSource.getType();
		            final /*@Thrown*/ boolean self_72 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_SequenceType_0).booleanValue();
		            CAUGHT_self_72 = self_72;
		        }
		        catch (Exception e) {
		            CAUGHT_self_72 = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_b;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_OrderedSetType_0 = idResolver.getClass(PivotTables.CLSSid_OrderedSetType, null);
		            final @Nullable /*@Thrown*/ OCLExpression ownedSource_0 = this.getOwnedSource();
		            if (ownedSource_0 == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type_0 = ownedSource_0.getType();
		            final /*@Thrown*/ boolean b = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_OrderedSetType_0).booleanValue();
		            CAUGHT_b = b;
		        }
		        catch (Exception e) {
		            CAUGHT_b = ValueUtil.createInvalidValue(e);
		        }
		        final /*@NonInvalid*/ boolean symbol_0 = CAUGHT_self_72 instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_8;
		        if (symbol_0) {
		            final /*@NonInvalid*/ boolean symbol_1 = CAUGHT_b instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_3;
		            if (symbol_1) {
		                if (CAUGHT_self_72 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_72;
		                }
		                symbol_3 = (Boolean)CAUGHT_self_72;
		            }
		            else {
		                /*@Thrown*/ boolean symbol_2;
		                if (CAUGHT_b == Boolean.TRUE) {
		                    symbol_2 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    if (CAUGHT_self_72 instanceof InvalidValueException) {
		                        throw (InvalidValueException)CAUGHT_self_72;
		                    }
		                    symbol_2 = (Boolean)CAUGHT_self_72;
		                }
		                symbol_3 = symbol_2;
		            }
		            symbol_8 = symbol_3;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_7;
		            if (CAUGHT_self_72 == Boolean.TRUE) {
		                symbol_7 = ValueUtil.TRUE_VALUE;
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
		                        symbol_5 = ValueUtil.TRUE_VALUE;
		                    }
		                    else {
		                        symbol_5 = ValueUtil.FALSE_VALUE;
		                    }
		                    symbol_6 = symbol_5;
		                }
		                symbol_7 = symbol_6;
		            }
		            symbol_8 = symbol_7;
		        }
		        /*@Thrown*/ boolean b_0;
		        if (symbol_8) {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_SequenceType_1 = idResolver.getClass(PivotTables.CLSSid_SequenceType, null);
		            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_pivot_c_c_SequenceType_1).booleanValue();
		            b_0 = oclIsKindOf;
		        }
		        else {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_BagType_0 = idResolver.getClass(PivotTables.CLSSid_BagType, null);
		            final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_pivot_c_c_BagType_0).booleanValue();
		            b_0 = oclIsKindOf_0;
		        }
		        CAUGHT_b_0 = b_0;
		    }
		    catch (Exception e) {
		        CAUGHT_b_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_9 = CAUGHT_self_71 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_17;
		    if (symbol_9) {
		        final /*@NonInvalid*/ boolean symbol_10 = CAUGHT_b_0 instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_12;
		        if (symbol_10) {
		            if (CAUGHT_self_71 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_self_71;
		            }
		            symbol_12 = (Boolean)CAUGHT_self_71;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_11;
		            if (CAUGHT_b_0 == Boolean.TRUE) {
		                symbol_11 = ValueUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_self_71 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_71;
		                }
		                symbol_11 = (Boolean)CAUGHT_self_71;
		            }
		            symbol_12 = symbol_11;
		        }
		        symbol_17 = symbol_12;
		    }
		    else {
		        if (CAUGHT_self_71 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_self_71;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_self_71 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_16;
		        if (eq) {
		            symbol_16 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_13 = CAUGHT_b_0 instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_15;
		            if (symbol_13) {
		                if (CAUGHT_b_0 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b_0;
		                }
		                symbol_15 = (Boolean)CAUGHT_b_0;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_14;
		                if (CAUGHT_b_0 == Boolean.TRUE) {
		                    symbol_14 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_14 = ValueUtil.FALSE_VALUE;
		                }
		                symbol_15 = symbol_14;
		            }
		            symbol_16 = symbol_15;
		        }
		        symbol_17 = symbol_16;
		    }
		    CAUGHT_symbol_17 = symbol_17;
		}
		catch (Exception e) {
		    CAUGHT_symbol_17 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_17 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectTypeIsUnordered", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_TYPE_IS_UNORDERED, message, new Object [] { this }));
		}
		return false;
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
		 * inv CollectNestedHasOneIterator: name = 'collectNested' implies
		 *   ownedIterators->size() = 1
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_collectNested.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedIterators);
		        final /*@Thrown*/ boolean b = size.equals(PivotTables.INT_1);
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectNestedHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_NESTED_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
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
		 * inv CollectNestedTypeIsBag: name = 'collectNested' implies
		 *   type.oclIsKindOf(BagType)
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_collectNested.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_BagType_0 = idResolver.getClass(PivotTables.CLSSid_BagType, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final /*@Thrown*/ boolean b = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_BagType_0).booleanValue();
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectNestedTypeIsBag", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_NESTED_TYPE_IS_BAG, message, new Object [] { this }));
		}
		return false;
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
		 * inv CollectNestedTypeIsBodyType: name = 'collectNested' implies type = ownedBody.type
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_collectNested.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		        if (ownedBody == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type_0 = ownedBody.getType();
		        final /*@Thrown*/ boolean b = (type != null) && (type_0 != null) ? (type.getTypeId() == type_0.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectNestedTypeIsBodyType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_NESTED_TYPE_IS_BODY_TYPE, message, new Object [] { this }));
		}
		return false;
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
		 * inv ExistsTypeIsBoolean: name = 'exists' implies type = Boolean
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_exists.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final /*@Thrown*/ boolean b = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ExistsTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__EXISTS_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
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
		 * inv ExistsBodyTypeIsBoolean: name = 'exists' implies ownedBody.type = Boolean
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_exists.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		        final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		        if (ownedBody == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type = ownedBody.getType();
		        final /*@Thrown*/ boolean b = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ExistsBodyTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__EXISTS_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
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
		 * inv ForAllTypeIsBoolean: name = 'forAll' implies type = Boolean
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_forAll.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final /*@Thrown*/ boolean b = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ForAllTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__FOR_ALL_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
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
		 * inv ForAllBodyTypeIsBoolean: name = 'forAll' implies ownedBody.type = Boolean
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_forAll.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		        final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		        if (ownedBody == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type = ownedBody.getType();
		        final /*@Thrown*/ boolean b = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ForAllBodyTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__FOR_ALL_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
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
		 * inv IsUniqueHasOneIterator: name = 'isUnique' implies
		 *   ownedIterators->size() = 1
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_isUnique.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedIterators);
		        final /*@Thrown*/ boolean b = size.equals(PivotTables.INT_1);
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "IsUniqueHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__IS_UNIQUE_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
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
		 * inv IsUniqueTypeIsBoolean: name = 'isUnique' implies type = Boolean
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_isUnique.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final /*@Thrown*/ boolean b = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "IsUniqueTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__IS_UNIQUE_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
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
		 * inv OneHasOneIterator: name = 'one' implies ownedIterators->size() = 1
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_one.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedIterators);
		        final /*@Thrown*/ boolean b = size.equals(PivotTables.INT_1);
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "OneHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ONE_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
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
		 * inv OneTypeIsBoolean: name = 'one' implies type = Boolean
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_one.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final /*@Thrown*/ boolean b = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "OneTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ONE_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
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
		 * inv OneBodyTypeIsBoolean: name = 'one' implies ownedBody.type = Boolean
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_one.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		        final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		        if (ownedBody == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type = ownedBody.getType();
		        final /*@Thrown*/ boolean b = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "OneBodyTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ONE_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
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
		 * inv RejectOrSelectHasOneIterator: name = 'reject' or name = 'select' implies
		 *   ownedIterators->size() = 1
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_17;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_self_71;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean self_71 = PivotTables.STR_reject.equals(name);
		            CAUGHT_self_71 = self_71;
		        }
		        catch (Exception e) {
		            CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_b;
		        try {
		            final @Nullable /*@Thrown*/ String name_0 = this.getName();
		            final /*@Thrown*/ boolean b = PivotTables.STR_select.equals(name_0);
		            CAUGHT_b = b;
		        }
		        catch (Exception e) {
		            CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                    symbol_2 = ValueUtil.TRUE_VALUE;
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
		            /*@Thrown*/ boolean symbol_7;
		            if (CAUGHT_self_71 == Boolean.TRUE) {
		                symbol_7 = ValueUtil.TRUE_VALUE;
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
		                        symbol_5 = ValueUtil.TRUE_VALUE;
		                    }
		                    else {
		                        symbol_5 = ValueUtil.FALSE_VALUE;
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
		        CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b_0;
		    try {
		        final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedIterators);
		        final /*@Thrown*/ boolean b_0 = size.equals(PivotTables.INT_1);
		        CAUGHT_b_0 = b_0;
		    }
		    catch (Exception e) {
		        CAUGHT_b_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_9 = CAUGHT_symbol_8 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_17;
		    if (symbol_9) {
		        final /*@NonInvalid*/ boolean symbol_10 = CAUGHT_b_0 instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_12;
		        if (symbol_10) {
		            if (CAUGHT_symbol_8 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_symbol_8;
		            }
		            symbol_12 = (Boolean)CAUGHT_symbol_8;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_11;
		            if (CAUGHT_b_0 == Boolean.TRUE) {
		                symbol_11 = ValueUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_symbol_8 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_symbol_8;
		                }
		                symbol_11 = (Boolean)CAUGHT_symbol_8;
		            }
		            symbol_12 = symbol_11;
		        }
		        symbol_17 = symbol_12;
		    }
		    else {
		        if (CAUGHT_symbol_8 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_symbol_8;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_symbol_8 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_16;
		        if (eq) {
		            symbol_16 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_13 = CAUGHT_b_0 instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_15;
		            if (symbol_13) {
		                if (CAUGHT_b_0 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b_0;
		                }
		                symbol_15 = (Boolean)CAUGHT_b_0;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_14;
		                if (CAUGHT_b_0 == Boolean.TRUE) {
		                    symbol_14 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_14 = ValueUtil.FALSE_VALUE;
		                }
		                symbol_15 = symbol_14;
		            }
		            symbol_16 = symbol_15;
		        }
		        symbol_17 = symbol_16;
		    }
		    CAUGHT_symbol_17 = symbol_17;
		}
		catch (Exception e) {
		    CAUGHT_symbol_17 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_17 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "RejectOrSelectHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__REJECT_OR_SELECT_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
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
		 * inv RejectOrSelectTypeIsSourceType: name = 'reject' or name = 'select' implies type = ownedSource.type
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_17;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_self_71;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean self_71 = PivotTables.STR_reject.equals(name);
		            CAUGHT_self_71 = self_71;
		        }
		        catch (Exception e) {
		            CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_b;
		        try {
		            final @Nullable /*@Thrown*/ String name_0 = this.getName();
		            final /*@Thrown*/ boolean b = PivotTables.STR_select.equals(name_0);
		            CAUGHT_b = b;
		        }
		        catch (Exception e) {
		            CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                    symbol_2 = ValueUtil.TRUE_VALUE;
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
		            /*@Thrown*/ boolean symbol_7;
		            if (CAUGHT_self_71 == Boolean.TRUE) {
		                symbol_7 = ValueUtil.TRUE_VALUE;
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
		                        symbol_5 = ValueUtil.TRUE_VALUE;
		                    }
		                    else {
		                        symbol_5 = ValueUtil.FALSE_VALUE;
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
		        CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_b_0;
		    try {
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		        if (ownedSource == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type_0 = ownedSource.getType();
		        final /*@Thrown*/ boolean b_0 = (type != null) && (type_0 != null) ? (type.getTypeId() == type_0.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b_0 = b_0;
		    }
		    catch (Exception e) {
		        CAUGHT_b_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_9 = CAUGHT_symbol_8 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_17;
		    if (symbol_9) {
		        final /*@NonInvalid*/ boolean symbol_10 = CAUGHT_b_0 instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_12;
		        if (symbol_10) {
		            if (CAUGHT_symbol_8 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_symbol_8;
		            }
		            symbol_12 = (Boolean)CAUGHT_symbol_8;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_11;
		            if (CAUGHT_b_0 == Boolean.TRUE) {
		                symbol_11 = ValueUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_symbol_8 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_symbol_8;
		                }
		                symbol_11 = (Boolean)CAUGHT_symbol_8;
		            }
		            symbol_12 = symbol_11;
		        }
		        symbol_17 = symbol_12;
		    }
		    else {
		        if (CAUGHT_symbol_8 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_symbol_8;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_symbol_8 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_16;
		        if (eq) {
		            symbol_16 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_13 = CAUGHT_b_0 instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_15;
		            if (symbol_13) {
		                if (CAUGHT_b_0 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b_0;
		                }
		                symbol_15 = (Boolean)CAUGHT_b_0;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_14;
		                if (CAUGHT_b_0 == Boolean.TRUE) {
		                    symbol_14 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_14 = ValueUtil.FALSE_VALUE;
		                }
		                symbol_15 = symbol_14;
		            }
		            symbol_16 = symbol_15;
		        }
		        symbol_17 = symbol_16;
		    }
		    CAUGHT_symbol_17 = symbol_17;
		}
		catch (Exception e) {
		    CAUGHT_symbol_17 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_17 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "RejectOrSelectTypeIsSourceType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__REJECT_OR_SELECT_TYPE_IS_SOURCE_TYPE, message, new Object [] { this }));
		}
		return false;
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
		 * inv RejectOrSelectTypeIsBoolean: name = 'reject' or name = 'select' implies type = Boolean
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_17;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_self_71;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            final /*@Thrown*/ boolean self_71 = PivotTables.STR_reject.equals(name);
		            CAUGHT_self_71 = self_71;
		        }
		        catch (Exception e) {
		            CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_b;
		        try {
		            final @Nullable /*@Thrown*/ String name_0 = this.getName();
		            final /*@Thrown*/ boolean b = PivotTables.STR_select.equals(name_0);
		            CAUGHT_b = b;
		        }
		        catch (Exception e) {
		            CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                    symbol_2 = ValueUtil.TRUE_VALUE;
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
		            /*@Thrown*/ boolean symbol_7;
		            if (CAUGHT_self_71 == Boolean.TRUE) {
		                symbol_7 = ValueUtil.TRUE_VALUE;
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
		                        symbol_5 = ValueUtil.TRUE_VALUE;
		                    }
		                    else {
		                        symbol_5 = ValueUtil.FALSE_VALUE;
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
		        CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b_0;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final /*@Thrown*/ boolean b_0 = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b_0 = b_0;
		    }
		    catch (Exception e) {
		        CAUGHT_b_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_9 = CAUGHT_symbol_8 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_17;
		    if (symbol_9) {
		        final /*@NonInvalid*/ boolean symbol_10 = CAUGHT_b_0 instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_12;
		        if (symbol_10) {
		            if (CAUGHT_symbol_8 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_symbol_8;
		            }
		            symbol_12 = (Boolean)CAUGHT_symbol_8;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_11;
		            if (CAUGHT_b_0 == Boolean.TRUE) {
		                symbol_11 = ValueUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_symbol_8 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_symbol_8;
		                }
		                symbol_11 = (Boolean)CAUGHT_symbol_8;
		            }
		            symbol_12 = symbol_11;
		        }
		        symbol_17 = symbol_12;
		    }
		    else {
		        if (CAUGHT_symbol_8 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_symbol_8;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_symbol_8 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_16;
		        if (eq) {
		            symbol_16 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_13 = CAUGHT_b_0 instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_15;
		            if (symbol_13) {
		                if (CAUGHT_b_0 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b_0;
		                }
		                symbol_15 = (Boolean)CAUGHT_b_0;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_14;
		                if (CAUGHT_b_0 == Boolean.TRUE) {
		                    symbol_14 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_14 = ValueUtil.FALSE_VALUE;
		                }
		                symbol_15 = symbol_14;
		            }
		            symbol_16 = symbol_15;
		        }
		        symbol_17 = symbol_16;
		    }
		    CAUGHT_symbol_17 = symbol_17;
		}
		catch (Exception e) {
		    CAUGHT_symbol_17 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_17 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "RejectOrSelectTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__REJECT_OR_SELECT_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
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
		 * inv SortedByHasOneIterator: name = 'sortedBy' implies
		 *   ownedIterators->size() = 1
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_sortedBy.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedIterators);
		        final /*@Thrown*/ boolean b = size.equals(PivotTables.INT_1);
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "SortedByHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__SORTED_BY_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
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
		 * inv SortedByIsOrderedIfSourceIsOrdered: name = 'sortedBy' implies
		 *   if
		 *     ownedSource.type.oclIsKindOf(SequenceType) or
		 *     ownedSource.type.oclIsKindOf(BagType)
		 *   then type.oclIsKindOf(SequenceType)
		 *   else type.oclIsKindOf(OrderedSetType)
		 *   endif
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_17;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_sortedBy.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b_0;
		    try {
		        final @Nullable /*@Thrown*/ Type type_2 = this.getType();
		        @NonNull /*@Caught*/ Object CAUGHT_self_72;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_SequenceType_0 = idResolver.getClass(PivotTables.CLSSid_SequenceType, null);
		            final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		            if (ownedSource == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type = ownedSource.getType();
		            final /*@Thrown*/ boolean self_72 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_SequenceType_0).booleanValue();
		            CAUGHT_self_72 = self_72;
		        }
		        catch (Exception e) {
		            CAUGHT_self_72 = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_b;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_BagType_0 = idResolver.getClass(PivotTables.CLSSid_BagType, null);
		            final @Nullable /*@Thrown*/ OCLExpression ownedSource_0 = this.getOwnedSource();
		            if (ownedSource_0 == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type_0 = ownedSource_0.getType();
		            final /*@Thrown*/ boolean b = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_BagType_0).booleanValue();
		            CAUGHT_b = b;
		        }
		        catch (Exception e) {
		            CAUGHT_b = ValueUtil.createInvalidValue(e);
		        }
		        final /*@NonInvalid*/ boolean symbol_0 = CAUGHT_self_72 instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_8;
		        if (symbol_0) {
		            final /*@NonInvalid*/ boolean symbol_1 = CAUGHT_b instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_3;
		            if (symbol_1) {
		                if (CAUGHT_self_72 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_72;
		                }
		                symbol_3 = (Boolean)CAUGHT_self_72;
		            }
		            else {
		                /*@Thrown*/ boolean symbol_2;
		                if (CAUGHT_b == Boolean.TRUE) {
		                    symbol_2 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    if (CAUGHT_self_72 instanceof InvalidValueException) {
		                        throw (InvalidValueException)CAUGHT_self_72;
		                    }
		                    symbol_2 = (Boolean)CAUGHT_self_72;
		                }
		                symbol_3 = symbol_2;
		            }
		            symbol_8 = symbol_3;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_7;
		            if (CAUGHT_self_72 == Boolean.TRUE) {
		                symbol_7 = ValueUtil.TRUE_VALUE;
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
		                        symbol_5 = ValueUtil.TRUE_VALUE;
		                    }
		                    else {
		                        symbol_5 = ValueUtil.FALSE_VALUE;
		                    }
		                    symbol_6 = symbol_5;
		                }
		                symbol_7 = symbol_6;
		            }
		            symbol_8 = symbol_7;
		        }
		        /*@Thrown*/ boolean b_0;
		        if (symbol_8) {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_SequenceType_1 = idResolver.getClass(PivotTables.CLSSid_SequenceType, null);
		            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_pivot_c_c_SequenceType_1).booleanValue();
		            b_0 = oclIsKindOf;
		        }
		        else {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_OrderedSetType_0 = idResolver.getClass(PivotTables.CLSSid_OrderedSetType, null);
		            final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type_2, TYP_pivot_c_c_OrderedSetType_0).booleanValue();
		            b_0 = oclIsKindOf_0;
		        }
		        CAUGHT_b_0 = b_0;
		    }
		    catch (Exception e) {
		        CAUGHT_b_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_9 = CAUGHT_self_71 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_17;
		    if (symbol_9) {
		        final /*@NonInvalid*/ boolean symbol_10 = CAUGHT_b_0 instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_12;
		        if (symbol_10) {
		            if (CAUGHT_self_71 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_self_71;
		            }
		            symbol_12 = (Boolean)CAUGHT_self_71;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_11;
		            if (CAUGHT_b_0 == Boolean.TRUE) {
		                symbol_11 = ValueUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_self_71 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_71;
		                }
		                symbol_11 = (Boolean)CAUGHT_self_71;
		            }
		            symbol_12 = symbol_11;
		        }
		        symbol_17 = symbol_12;
		    }
		    else {
		        if (CAUGHT_self_71 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_self_71;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_self_71 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_16;
		        if (eq) {
		            symbol_16 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_13 = CAUGHT_b_0 instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_15;
		            if (symbol_13) {
		                if (CAUGHT_b_0 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b_0;
		                }
		                symbol_15 = (Boolean)CAUGHT_b_0;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_14;
		                if (CAUGHT_b_0 == Boolean.TRUE) {
		                    symbol_14 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_14 = ValueUtil.FALSE_VALUE;
		                }
		                symbol_15 = symbol_14;
		            }
		            symbol_16 = symbol_15;
		        }
		        symbol_17 = symbol_16;
		    }
		    CAUGHT_symbol_17 = symbol_17;
		}
		catch (Exception e) {
		    CAUGHT_symbol_17 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_17 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "SortedByIsOrderedIfSourceIsOrdered", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__SORTED_BY_IS_ORDERED_IF_SOURCE_IS_ORDERED, message, new Object [] { this }));
		}
		return false;
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
		 * inv SortedByElementTypeIsSourceElementType: name = 'sortedBy' implies
		 *   type.oclAsType(CollectionType).elementType =
		 *   ownedBody.type.oclAsType(CollectionType).elementType
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final /*@Thrown*/ boolean self_71 = PivotTables.STR_sortedBy.equals(name);
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_CollectionType_1 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType_1);
		        if (oclAsType == null) {
		            throw new InvalidValueException("Null source for \'pivot::CollectionType::elementType\'");
		        }
		        final @Nullable /*@Thrown*/ Type elementType = oclAsType.getElementType();
		        final @Nullable /*@Thrown*/ OCLExpression ownedBody = this.getOwnedBody();
		        if (ownedBody == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type_0 = ownedBody.getType();
		        final @Nullable /*@Thrown*/ CollectionType oclAsType_0 = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type_0, TYP_pivot_c_c_CollectionType_1);
		        if (oclAsType_0 == null) {
		            throw new InvalidValueException("Null source for \'pivot::CollectionType::elementType\'");
		        }
		        final @Nullable /*@Thrown*/ Type elementType_0 = oclAsType_0.getElementType();
		        final /*@Thrown*/ boolean b = (elementType != null) && (elementType_0 != null) ? (elementType.getTypeId() == elementType_0.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		        ;
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
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
		                symbol_2 = ValueUtil.TRUE_VALUE;
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
		            symbol_7 = ValueUtil.TRUE_VALUE;
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
		                    symbol_5 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValueUtil.FALSE_VALUE;
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
		    CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "SortedByElementTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__SORTED_BY_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
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
		 * inv IteratorTypeIsSourceElementType:
		 *   self.ownedIterators->forAll(
		 *     ownedSource.type.oclAsType(CollectionType)
		 *     .elementType.conformsTo(type))
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object CAUGHT_forAll;
		try {
		    final @NonNull /*@Thrown*/ List<Variable> ownedIterators = this.getOwnedIterators();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
		    @NonNull /*@Thrown*/ Object accumulator = ValueUtil.TRUE_VALUE;
		    @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedIterators.iterator();
		    /*@Thrown*/ boolean forAll;
		    while (true) {
		        if (!ITERATOR__1.hasNext()) {
		            if (accumulator == ValueUtil.TRUE_VALUE) {
		                forAll = (Boolean)accumulator;
		            }
		            else {
		                throw (InvalidValueException)accumulator;
		            }
		            break;
		        }
		        @Nullable /*@NonInvalid*/ Variable _1 = (Variable)ITERATOR__1.next();
		        /**
		         * 
		         * ownedSource.type.oclAsType(CollectionType)
		         * .elementType.conformsTo(type)
		         */
		        @NonNull /*@Caught*/ Object CAUGHT_conformsTo;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_CollectionType_0 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		            final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		            if (ownedSource == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type = ownedSource.getType();
		            final @Nullable /*@Thrown*/ CollectionType oclAsType = (CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType_0);
		            if (oclAsType == null) {
		                throw new InvalidValueException("Null source for \'pivot::CollectionType::elementType\'");
		            }
		            final @Nullable /*@Thrown*/ Type elementType = oclAsType.getElementType();
		            if (_1 == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            final @Nullable /*@Thrown*/ Type type_0 = _1.getType();
		            final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(evaluator, elementType, type_0).booleanValue();
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
		if (CAUGHT_forAll == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "IteratorTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
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
			case PivotPackage.ITERATOR_EXP___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.ITERATOR_EXP___MAKE_PARAMETER:
				return makeParameter();
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

} //IteratorExpImpl
