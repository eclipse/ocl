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
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Null Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NullLiteralExpImpl
		extends PrimitiveLiteralExpImpl
		implements NullLiteralExp {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NullLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.NULL_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean isNonNull()
	{
		/**
		 * false
		 */
		return ValueUtil.FALSE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTypeIsOclVoid(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateTypeIsOclVoid:
		 *   let severity : Integer[1] = 'NullLiteralExp::TypeIsOclVoid'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[1] = type = OclVoid
		 *       in
		 *         'NullLiteralExp::TypeIsOclVoid'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_NullLiteralExp_c_c_TypeIsOclVoid);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @NonNull /*@Caught*/ Object CAUGHT_status;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid = idResolver.getClass(TypeId.OCL_VOID, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final /*@Thrown*/ boolean status = (type != null) ? (type.getTypeId() == TYP_OclVoid.getTypeId()) : false;
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_NullLiteralExp_c_c_TypeIsOclVoid, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
	{
		if (baseClass == OCLExpression.class)
		{
			switch (baseOperationID)
			{
				case PivotPackage.OCL_EXPRESSION___IS_NON_NULL: return PivotPackage.NULL_LITERAL_EXP___IS_NON_NULL;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == LiteralExp.class)
		{
			switch (baseOperationID)
			{
				case PivotPackage.LITERAL_EXP___IS_NON_NULL: return PivotPackage.NULL_LITERAL_EXP___IS_NON_NULL;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case PivotPackage.NULL_LITERAL_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.NULL_LITERAL_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.NULL_LITERAL_EXP___MAY_HAVE_NULL_NAME:
				return mayHaveNullName();
			case PivotPackage.NULL_LITERAL_EXP___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.NULL_LITERAL_EXP___MAY_HAVE_NULL_TYPE:
				return mayHaveNullType();
			case PivotPackage.NULL_LITERAL_EXP___MAY_HAVE_OCL_INVALID_TYPE:
				return mayHaveOclInvalidType();
			case PivotPackage.NULL_LITERAL_EXP___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.NULL_LITERAL_EXP___VALIDATE_TYPE_IS_NOT_OCL_INVALID__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotOclInvalid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.NULL_LITERAL_EXP___IS_NON_NULL:
				return isNonNull();
			case PivotPackage.NULL_LITERAL_EXP___VALIDATE_TYPE_VALUE_IS_NULL__DIAGNOSTICCHAIN_MAP:
				return validateTypeValueIsNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.NULL_LITERAL_EXP___VALIDATE_TYPE_IS_OCL_VOID__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsOclVoid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitNullLiteralExp(this);
	}
} //NullLiteralExpImpl
