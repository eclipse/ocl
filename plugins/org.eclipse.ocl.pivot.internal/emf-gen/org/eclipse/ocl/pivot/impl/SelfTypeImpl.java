/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Self Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SelfTypeImpl extends ClassImpl implements SelfType
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelfTypeImpl()
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
		return PivotPackage.Literals.SELF_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings({"unchecked"})
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case PivotPackage.SELF_TYPE___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.SELF_TYPE___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.SELF_TYPE___FLATTENED_TYPE:
				return flattenedType();
			case PivotPackage.SELF_TYPE___IS_CLASS:
				return isClass();
			case PivotPackage.SELF_TYPE___IS_TEMPLATE_PARAMETER:
				return isTemplateParameter();
			case PivotPackage.SELF_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE:
				return specializeIn((OCLExpression)arguments.get(0), (Type)arguments.get(1));
			case PivotPackage.SELF_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP:
				return validateUniqueInvariantName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.SELF_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE_1:
				return specializeIn((OCLExpression)arguments.get(0), (Type)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitSelfType(this);
	}

	@Override
	public @NonNull TypeId computeId() {
		return TypeId.OCL_SELF;
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		throw new UnsupportedOperationException();		// WIP
	}

	@Override
	public Type specializeIn(final /*@NonNull*/ OCLExpression expr, final Type selfType)
	{
		assert expr != null;
		return specializeIn((CallExp)expr, selfType);
	}

	@Override
	public @NonNull Type specializeIn(@NonNull CallExp expr, @Nullable Type selfType) {
		if (selfType instanceof org.eclipse.ocl.pivot.Class) {
			TemplateSignature templateSignature = ((TemplateableElement)selfType).getOwnedSignature();
			if (templateSignature != null) {
				MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(expr);
				if (metaModelManager != null) {
					return metaModelManager.specializeType(selfType, expr, selfType, null); // FIXME is this a no-op
				}
				else {
					return this;
				}
			}
		}
		return selfType != null ? selfType : this;
	}
} //SelfTypeImpl
