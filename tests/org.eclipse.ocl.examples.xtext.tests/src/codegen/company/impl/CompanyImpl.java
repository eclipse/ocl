/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package codegen.company.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.domain.types.IdResolver;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.OrderedSetValue;
import org.eclipse.ocl.domain.values.SequenceValue;
import org.eclipse.ocl.domain.values.TupleValue;
import org.eclipse.ocl.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.domain.values.util.ValuesUtil;
import org.eclipse.ocl.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.library.ecore.EcoreExecutorManager;

import codegen.company.CodegencompanyPackage;
import codegen.company.CodegencompanyTables;
import codegen.company.Company;
import codegen.company.CompanySizeKind;
import codegen.company.Employee;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link codegen.company.impl.CompanyImpl#getName <em>Name</em>}</li>
 *   <li>{@link codegen.company.impl.CompanyImpl#getEmployees <em>Employees</em>}</li>
 *   <li>{@link codegen.company.impl.CompanyImpl#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompanyImpl extends EObjectImpl implements Company
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEmployees() <em>Employees</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployees()
	 * @generated
	 * @ordered
	 */
	protected EList<Employee> employees;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final CompanySizeKind SIZE_EDEFAULT = CompanySizeKind.SMALL;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompanyImpl()
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
		return CodegencompanyPackage.Literals.COMPANY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegencompanyPackage.COMPANY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Employee> getEmployees()
	{
		if (employees == null) {
			employees = new EObjectContainmentWithInverseEList<Employee>(Employee.class, this, CodegencompanyPackage.COMPANY__EMPLOYEES, CodegencompanyPackage.EMPLOYEE__COMPANY);
		}
		return employees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompanySizeKind getSize()
	{
		/**
		 * 
		 * let
		 *   table : Set(Tuple(range : Sequence(Integer), size : CompanySizeKind)) = Set{
		 *     Tuple{range = Sequence{0..49}, size = CompanySizeKind::small
		 *     }
		 *     , Tuple{range = Sequence{50..999}, size = CompanySizeKind::medium
		 *     }
		 *     , Tuple{range = Sequence{1000..1000000}, size = CompanySizeKind::large
		 *     }
		 *   }
		 * in
		 *   table->any(range->includes(employees->size())).size
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, CodegencompanyTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable Iterator<?> ITERATOR__1 = CodegencompanyTables.table.iterator();
		@Nullable /*@Thrown*/ TupleValue any;
		while (true) {
		    if (!ITERATOR__1.hasNext()) {
		        throw new InvalidValueException("No matching content for 'any'");
		    }
		    @Nullable /*@NonInvalid*/ TupleValue _1 = (TupleValue)ITERATOR__1.next();
		    /**
		     * range->includes(employees->size())
		     */
		    if (_1 == null) {
		        throw new InvalidValueException("Null source for \'$$::Tuple.range\'");
		    }
		    final @NonNull /*@NonInvalid*/ SequenceValue range = (SequenceValue)_1.getValue(0/*range*/);
		    final @NonNull /*@Thrown*/ List<Employee> employees = this.getEmployees();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_employees = idResolver.createOrderedSetOfAll(CodegencompanyTables.ORD_CLSSid_Employee, employees);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_employees);
		    final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(range, size);
		    //
		    if (includes != ValuesUtil.FALSE_VALUE) {			// Carry on till something found
		        any = _1;
		        break;
		    }
		}
		if (any == null) {
		    throw new InvalidValueException("Null source for \'$$::Tuple.size\'");
		}
		final @NonNull /*@NonInvalid*/ EnumerationLiteralId size_0 = (EnumerationLiteralId)any.getValue(1/*size*/);
		final @Nullable /*@NonInvalid*/ Enumerator UNBOXED_size_0 = idResolver.unboxedValueOf(size_0);
		return (CompanySizeKind)UNBOXED_size_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean dummyInvariant(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv dummyInvariant: true
		 */
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case CodegencompanyPackage.COMPANY__EMPLOYEES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEmployees()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case CodegencompanyPackage.COMPANY__EMPLOYEES:
				return ((InternalEList<?>)getEmployees()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case CodegencompanyPackage.COMPANY__NAME:
				return getName();
			case CodegencompanyPackage.COMPANY__EMPLOYEES:
				return getEmployees();
			case CodegencompanyPackage.COMPANY__SIZE:
				return getSize();
		}
		return super.eGet(featureID, resolve, coreType);
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
		switch (featureID) {
			case CodegencompanyPackage.COMPANY__NAME:
				setName((String)newValue);
				return;
			case CodegencompanyPackage.COMPANY__EMPLOYEES:
				getEmployees().clear();
				getEmployees().addAll((Collection<? extends Employee>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID) {
			case CodegencompanyPackage.COMPANY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CodegencompanyPackage.COMPANY__EMPLOYEES:
				getEmployees().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID) {
			case CodegencompanyPackage.COMPANY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CodegencompanyPackage.COMPANY__EMPLOYEES:
				return employees != null && !employees.isEmpty();
			case CodegencompanyPackage.COMPANY__SIZE:
				return getSize() != SIZE_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		switch (operationID) {
			case CodegencompanyPackage.COMPANY___DUMMY_INVARIANT__DIAGNOSTICCHAIN_MAP:
				return dummyInvariant((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //CompanyImpl