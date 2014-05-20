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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Multiplicity Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class TypedMultiplicityElementImpl
		extends TypedElementImpl
		implements TypedMultiplicityElement {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedMultiplicityElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TYPED_MULTIPLICITY_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean CompatibleBody(final ValueSpecification bodySpecification)
	{
		/**
		 * bodySpecification.type.conformsTo(self.type)
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		final @Nullable /*@Thrown*/ DomainType type = bodySpecification.getType();
		final @Nullable /*@Thrown*/ DomainType type_0 = this.getType();
		final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(evaluator, type, type_0).booleanValue();
		return conformsTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter makeParameter()
	{
		/**
		 * Parameter{name = 'name'}
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainProperty CTORid_name = idResolver.getProperty(PivotTables.PROPid_name);
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_Parameter_0 = idResolver.getType(PivotTables.CLSSid_Parameter, null);
		final @NonNull /*@Thrown*/ DomainTypedElement symbol_0 = (DomainTypedElement)TYP_pivot_c_c_Parameter_0.createInstance();
		CTORid_name.initValue(symbol_0, PivotTables.STR_name);
		return (Parameter)symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___MAKE_PARAMETER:
				return makeParameter();
		}
		return eDynamicInvoke(operationID, arguments);
	}

	public boolean isMany() {
		Type type = getType();
		if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)type;
			IntegerValue upperValue = collectionType.getUpperValue();
			return (upperValue instanceof UnlimitedValue) || (upperValue.intValue() > 1);
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //TypedMultiplicityElementImpl
