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
/**
 */
package codegen.company.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.domain.types.IdResolver;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.InvalidValueException;
import org.eclipse.ocl.domain.values.OrderedSetValue;
import org.eclipse.ocl.domain.values.SetValue;
import org.eclipse.ocl.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.library.collection.CollectionNotEmptyOperation;
import org.eclipse.ocl.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.library.collection.OrderedCollectionPrependOperation;
import org.eclipse.ocl.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.library.numeric.NumericGreaterThanOperation;
import org.eclipse.ocl.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.library.string.StringSizeOperation;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.osgi.util.NLS;

import codegen.company.CodegencompanyPackage;
import codegen.company.CodegencompanyTables;
import codegen.company.Company;
import codegen.company.Employee;
import codegen.company.util.CodegencompanyValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link codegen.company.impl.EmployeeImpl#getName <em>Name</em>}</li>
 *   <li>{@link codegen.company.impl.EmployeeImpl#getManager <em>Manager</em>}</li>
 *   <li>{@link codegen.company.impl.EmployeeImpl#getCompany <em>Company</em>}</li>
 *   <li>{@link codegen.company.impl.EmployeeImpl#getDirectReports <em>Direct Reports</em>}</li>
 *   <li>{@link codegen.company.impl.EmployeeImpl#getAllReports <em>All Reports</em>}</li>
 *   <li>{@link codegen.company.impl.EmployeeImpl#getReportingChain <em>Reporting Chain</em>}</li>
 *   <li>{@link codegen.company.impl.EmployeeImpl#isHasNameAsAttribute <em>Has Name As Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings({"unchecked", "unused"})
public class EmployeeImpl extends EObjectImpl implements Employee {
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
	 * The cached value of the '{@link #getManager() <em>Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManager()
	 * @generated
	 * @ordered
	 */
	protected Employee manager;

	/**
	 * The default value of the '{@link #isHasNameAsAttribute() <em>Has Name As Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasNameAsAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_NAME_AS_ATTRIBUTE_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmployeeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegencompanyPackage.Literals.EMPLOYEE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegencompanyPackage.EMPLOYEE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Employee getManager() {
		if (manager != null && manager.eIsProxy()) {
			InternalEObject oldManager = (InternalEObject)manager;
			manager = (Employee)eResolveProxy(oldManager);
			if (manager != oldManager) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodegencompanyPackage.EMPLOYEE__MANAGER, oldManager, manager));
			}
		}
		return manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetManager() {
		return manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setManager(Employee newManager) {
		Employee oldManager = manager;
		manager = newManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegencompanyPackage.EMPLOYEE__MANAGER, oldManager, manager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Company getCompany() {
		if (eContainerFeatureID() != CodegencompanyPackage.EMPLOYEE__COMPANY) return null;
		return (Company)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompany(Company newCompany, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCompany, CodegencompanyPackage.EMPLOYEE__COMPANY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompany(Company newCompany) {
		if (newCompany != eInternalContainer() || (eContainerFeatureID() != CodegencompanyPackage.EMPLOYEE__COMPANY && newCompany != null)) {
			if (EcoreUtil.isAncestor(this, newCompany))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCompany != null)
				msgs = ((InternalEObject)newCompany).eInverseAdd(this, CodegencompanyPackage.COMPANY__EMPLOYEES, Company.class, msgs);
			msgs = basicSetCompany(newCompany, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegencompanyPackage.EMPLOYEE__COMPANY, newCompany, newCompany));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Employee> getDirectReports() {
		/**
		 * company.employees->select(manager = self)
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, CodegencompanyTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@Thrown*/ Company company = this.getCompany();
		final @NonNull /*@Thrown*/ List<Employee> employees = company.getEmployees();
		final @NonNull /*@Thrown*/ OrderedSetValue BOXED_employees = idResolver.createOrderedSetOfAll(CodegencompanyTables.ORD_CLSSid_Employee, employees);
		@NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(CodegencompanyTables.ORD_CLSSid_Employee);
		@Nullable Iterator<?> ITERATOR__1 = BOXED_employees.iterator();
		@NonNull /*@Thrown*/ OrderedSetValue select;
		while (true) {
		    if (!ITERATOR__1.hasNext()) {
		        select = accumulator;
		        break;
		    }
		    @Nullable /*@NonInvalid*/ Employee _1 = (Employee)ITERATOR__1.next();
		    /**
		     * manager = self
		     */
		    if (_1 == null) {
		        throw new InvalidValueException("Null source for \'company::Employee.manager\'");
		    }
		    final @Nullable /*@Thrown*/ Employee manager_0 = _1.getManager();
		    final /*@Thrown*/ boolean eq = manager_0 == this;
		    //
		    if (eq == ValueUtil.TRUE_VALUE) {
		        accumulator.add(_1);
		    }
		}
		final List<Employee> UNBOXED_select = select.asEcoreObjects(idResolver, codegen.company.Employee.class);
		assert UNBOXED_select != null;
		return (EList<Employee>)UNBOXED_select;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Employee> getAllReports() {
		/**
		 * Employee.allInstances()->select(reportsTo(self))
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, CodegencompanyTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ Type TYP_company_c_c_Employee_0 = idResolver.getType(CodegencompanyTables.CLSSid_Employee, null);
		final @NonNull /*@Thrown*/ SetValue allInstances = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, CodegencompanyTables.SET_CLSSid_Employee, TYP_company_c_c_Employee_0);
		@NonNull /*@Thrown*/ SetValue.Accumulator accumulator = ValueUtil.createSetAccumulatorValue(CodegencompanyTables.SET_CLSSid_Employee);
		@Nullable Iterator<?> ITERATOR__1 = allInstances.iterator();
		@NonNull /*@Thrown*/ SetValue select;
		while (true) {
		    if (!ITERATOR__1.hasNext()) {
		        select = accumulator;
		        break;
		    }
		    @Nullable /*@NonInvalid*/ Employee _1 = (Employee)ITERATOR__1.next();
		    /**
		     * reportsTo(self)
		     */
		    if (_1 == null) {
		        throw new InvalidValueException("Null source for \'company::Employee.reportsTo(company::Employee[?]) : Boolean\'");
		    }
		    final /*@Thrown*/ boolean reportsTo = _1.reportsTo(this);
		    //
		    if (reportsTo == ValueUtil.TRUE_VALUE) {
		        accumulator.add(_1);
		    }
		}
		final List<Employee> UNBOXED_select = select.asEcoreObjects(idResolver, codegen.company.Employee.class);
		assert UNBOXED_select != null;
		return (EList<Employee>)UNBOXED_select;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Employee> getReportingChain() {
		/**
		 * 
		 * if manager.oclIsUndefined()
		 * then OrderedSet{}
		 * else manager.reportingChain->prepend(manager)
		 * endif
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, CodegencompanyTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Caught*/ Object CAUGHT_manager_0;
		try {
		    final @Nullable /*@Thrown*/ Employee manager_0 = this.getManager();
		    CAUGHT_manager_0 = manager_0;
		}
		catch (Exception e) {
		    CAUGHT_manager_0 = ValueUtil.createInvalidValue(e);
		}
		final /*@NonInvalid*/ boolean symbol_6 = (CAUGHT_manager_0 == null) || (CAUGHT_manager_0 instanceof InvalidValueException);
		@NonNull /*@Thrown*/ OrderedSetValue symbol_7;
		if (symbol_6) {
		    symbol_7 = CodegencompanyTables.OrderedSet;
		}
		else {
		    final @Nullable /*@Thrown*/ Employee manager_2 = this.getManager();
		    if (manager_2 == null) {
		        throw new InvalidValueException("Null source for \'company::Employee.reportingChain\'");
		    }
		    final @NonNull /*@Thrown*/ List<Employee> reportingChain = manager_2.getReportingChain();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_reportingChain = idResolver.createOrderedSetOfAll(CodegencompanyTables.ORD_CLSSid_Employee, reportingChain);
		    final @NonNull /*@Thrown*/ OrderedSetValue prepend = (OrderedSetValue)OrderedCollectionPrependOperation.INSTANCE.evaluate(BOXED_reportingChain, manager_2);
		    symbol_7 = prepend;
		}
		final List<Employee> UNBOXED_symbol_7 = symbol_7.asEcoreObjects(idResolver, codegen.company.Employee.class);
		assert UNBOXED_symbol_7 != null;
		return (EList<Employee>)UNBOXED_symbol_7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasNameAsAttribute() {
		/**
		 * name <> null
		 */
		final @Nullable /*@Thrown*/ String name = this.getName();
		final /*@Thrown*/ boolean ne = name != null;
		return ne;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean reportsTo(final Employee manager) {
		/**
		 * self.reportingChain->includes(manager)
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, CodegencompanyTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@Thrown*/ List<Employee> reportingChain = this.getReportingChain();
		final @NonNull /*@Thrown*/ OrderedSetValue BOXED_reportingChain = idResolver.createOrderedSetOfAll(CodegencompanyTables.ORD_CLSSid_Employee, reportingChain);
		final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_reportingChain, manager);
		return includes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean noManagerImpliesDirectReports(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv noManagerImpliesDirectReports: manager.oclIsUndefined() implies directReports->size() > 0
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_9;
		try {
		    @Nullable /*@Caught*/ Object CAUGHT_manager_0;
		    try {
		        final @Nullable /*@Thrown*/ Employee manager_0 = this.getManager();
		        CAUGHT_manager_0 = manager_0;
		    }
		    catch (Exception e) {
		        CAUGHT_manager_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean self_11 = (CAUGHT_manager_0 == null) || (CAUGHT_manager_0 instanceof InvalidValueException);
		    final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, CodegencompanyTables.LIBRARY);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @NonNull /*@Thrown*/ List<Employee> directReports = this.getDirectReports();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_directReports = idResolver.createOrderedSetOfAll(CodegencompanyTables.ORD_CLSSid_Employee, directReports);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_directReports);
		        final /*@Thrown*/ boolean b = NumericGreaterThanOperation.INSTANCE.evaluate(size, CodegencompanyTables.INT_0);
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean eq = !self_11;
		    /*@Thrown*/ boolean symbol_9;
		    if (eq) {
		        symbol_9 = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@NonInvalid*/ boolean symbol_6 = CAUGHT_b instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_8;
		        if (symbol_6) {
		            if (CAUGHT_b instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_b;
		            }
		            symbol_8 = (Boolean)CAUGHT_b;
		        }
		        else {
		            /*@NonInvalid*/ boolean symbol_7;
		            if (CAUGHT_b == Boolean.TRUE) {
		                symbol_7 = ValueUtil.TRUE_VALUE;
		            }
		            else {
		                symbol_7 = ValueUtil.FALSE_VALUE;
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
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"Employee", "noManagerImpliesDirectReports", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, CodegencompanyValidator.DIAGNOSTIC_SOURCE, CodegencompanyValidator.EMPLOYEE__NO_MANAGER_IMPLIES_DIRECT_REPORTS, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean hasNameAsOperation() {
		/**
		 * name <> null
		 */
		final @Nullable /*@Thrown*/ String name = this.getName();
		final /*@Thrown*/ boolean ne = name != null;
		return ne;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean mustHaveName(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv mustHaveName: not name.oclIsUndefined() and hasNameAsAttribute and hasNameAsOperation()
		 */
		@Nullable /*@Caught*/ Object CAUGHT_symbol_20;
		try {
		    @Nullable /*@Caught*/ Object CAUGHT_symbol_10;
		    try {
		        @Nullable /*@Caught*/ Object CAUGHT_name;
		        try {
		            final @Nullable /*@Thrown*/ String name = this.getName();
		            CAUGHT_name = name;
		        }
		        catch (Exception e) {
		            CAUGHT_name = ValueUtil.createInvalidValue(e);
		        }
		        final /*@NonInvalid*/ boolean self_11 = (CAUGHT_name == null) || (CAUGHT_name instanceof InvalidValueException);
		        final /*@NonInvalid*/ boolean eq = !self_11;
		        @Nullable /*@Caught*/ Object CAUGHT_b;
		        try {
		            final @Nullable /*@Thrown*/ Boolean b = this.isHasNameAsAttribute();
		            CAUGHT_b = b;
		        }
		        catch (Exception e) {
		            CAUGHT_b = ValueUtil.createInvalidValue(e);
		        }
		        final /*@NonInvalid*/ boolean eq_0 = !eq;
		        @Nullable /*@Thrown*/ Boolean symbol_10;
		        if (eq_0) {
		            symbol_10 = ValueUtil.FALSE_VALUE;
		        }
		        else {
		            if (CAUGHT_b instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_b;
		            }
		            final /*@NonInvalid*/ boolean symbol_6 = CAUGHT_b instanceof InvalidValueException;
		            @Nullable /*@Thrown*/ Boolean symbol_9;
		            if (symbol_6) {
		                symbol_9 = (Boolean)CAUGHT_b;
		            }
		            else {
		                final /*@Thrown*/ boolean eq_1 = CAUGHT_b == Boolean.FALSE;
		                @Nullable /*@NonInvalid*/ Boolean symbol_8;
		                if (eq_1) {
		                    symbol_8 = ValueUtil.FALSE_VALUE;
		                }
		                else {
		                    final /*@Thrown*/ boolean eq_2 = CAUGHT_b == null;
		                    @Nullable /*@NonInvalid*/ Boolean symbol_7;
		                    if (eq_2) {
		                        symbol_7 = null;
		                    }
		                    else {
		                        symbol_7 = ValueUtil.TRUE_VALUE;
		                    }
		                    symbol_8 = symbol_7;
		                }
		                symbol_9 = symbol_8;
		            }
		            symbol_10 = symbol_9;
		        }
		        CAUGHT_symbol_10 = symbol_10;
		    }
		    catch (Exception e) {
		        CAUGHT_symbol_10 = ValueUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_b_0;
		    try {
		        final /*@Thrown*/ boolean b_0 = this.hasNameAsOperation();
		        CAUGHT_b_0 = b_0;
		    }
		    catch (Exception e) {
		        CAUGHT_b_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_11 = CAUGHT_symbol_10 instanceof InvalidValueException;
		    @Nullable /*@Thrown*/ Boolean symbol_20;
		    if (symbol_11) {
		        final /*@NonInvalid*/ boolean symbol_12 = CAUGHT_b_0 instanceof InvalidValueException;
		        @Nullable /*@Thrown*/ Boolean symbol_14;
		        if (symbol_12) {
		            if (CAUGHT_symbol_10 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_symbol_10;
		            }
		            symbol_14 = (Boolean)CAUGHT_symbol_10;
		        }
		        else {
		            if (CAUGHT_b_0 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_b_0;
		            }
		            final /*@Thrown*/ boolean eq_3 = CAUGHT_b_0 == Boolean.FALSE;
		            @Nullable /*@Thrown*/ Boolean symbol_13;
		            if (eq_3) {
		                symbol_13 = ValueUtil.FALSE_VALUE;
		            }
		            else {
		                if (CAUGHT_symbol_10 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_symbol_10;
		                }
		                symbol_13 = (Boolean)CAUGHT_symbol_10;
		            }
		            symbol_14 = symbol_13;
		        }
		        symbol_20 = symbol_14;
		    }
		    else {
		        if (CAUGHT_symbol_10 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_symbol_10;
		        }
		        final /*@Thrown*/ boolean eq_4 = CAUGHT_symbol_10 == Boolean.FALSE;
		        @Nullable /*@Thrown*/ Boolean symbol_19;
		        if (eq_4) {
		            symbol_19 = ValueUtil.FALSE_VALUE;
		        }
		        else {
		            if (CAUGHT_b_0 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_b_0;
		            }
		            final /*@NonInvalid*/ boolean symbol_15 = CAUGHT_b_0 instanceof InvalidValueException;
		            @Nullable /*@Thrown*/ Boolean symbol_18;
		            if (symbol_15) {
		                symbol_18 = (Boolean)CAUGHT_b_0;
		            }
		            else {
		                final /*@Thrown*/ boolean eq_5 = CAUGHT_b_0 == Boolean.FALSE;
		                @Nullable /*@NonInvalid*/ Boolean symbol_17;
		                if (eq_5) {
		                    symbol_17 = ValueUtil.FALSE_VALUE;
		                }
		                else {
		                    final /*@Thrown*/ boolean eq_6 = CAUGHT_symbol_10 == null;
		                    @Nullable /*@NonInvalid*/ Boolean symbol_16;
		                    if (eq_6) {
		                        symbol_16 = null;
		                    }
		                    else {
		                        symbol_16 = ValueUtil.TRUE_VALUE;
		                    }
		                    symbol_17 = symbol_16;
		                }
		                symbol_18 = symbol_17;
		            }
		            symbol_19 = symbol_18;
		        }
		        symbol_20 = symbol_19;
		    }
		    CAUGHT_symbol_20 = symbol_20;
		}
		catch (Exception e) {
		    CAUGHT_symbol_20 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_20 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_symbol_20 == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"Employee", "mustHaveName", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, CodegencompanyValidator.DIAGNOSTIC_SOURCE, CodegencompanyValidator.EMPLOYEE__MUST_HAVE_NAME, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean mustHaveNonEmptyName(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * inv mustHaveNonEmptyName: name->notEmpty() implies name.size() > 0
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, CodegencompanyTables.LIBRARY);
		@NonNull /*@Caught*/ Object CAUGHT_symbol_14;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_11;
		    try {
		        final @Nullable /*@Thrown*/ String name = this.getName();
		        final @NonNull /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, CodegencompanyTables.SET_PRIMid_String, name);
		        final /*@Thrown*/ boolean self_11 = CollectionNotEmptyOperation.INSTANCE.evaluate(oclAsSet);
		        CAUGHT_self_11 = self_11;
		    }
		    catch (Exception e) {
		        CAUGHT_self_11 = ValueUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @Nullable /*@Thrown*/ String name_0 = this.getName();
		        final @NonNull /*@Thrown*/ IntegerValue size = StringSizeOperation.INSTANCE.evaluate(name_0);
		        final /*@Thrown*/ boolean b = NumericGreaterThanOperation.INSTANCE.evaluate(size, CodegencompanyTables.INT_0);
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_6 = CAUGHT_self_11 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_14;
		    if (symbol_6) {
		        final /*@NonInvalid*/ boolean symbol_7 = CAUGHT_b instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_9;
		        if (symbol_7) {
		            if (CAUGHT_self_11 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_self_11;
		            }
		            symbol_9 = (Boolean)CAUGHT_self_11;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_8;
		            if (CAUGHT_b == Boolean.TRUE) {
		                symbol_8 = ValueUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_self_11 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_11;
		                }
		                symbol_8 = (Boolean)CAUGHT_self_11;
		            }
		            symbol_9 = symbol_8;
		        }
		        symbol_14 = symbol_9;
		    }
		    else {
		        if (CAUGHT_self_11 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_self_11;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_self_11 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_13;
		        if (eq) {
		            symbol_13 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_10 = CAUGHT_b instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_12;
		            if (symbol_10) {
		                if (CAUGHT_b instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b;
		                }
		                symbol_12 = (Boolean)CAUGHT_b;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_11;
		                if (CAUGHT_b == Boolean.TRUE) {
		                    symbol_11 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_11 = ValueUtil.FALSE_VALUE;
		                }
		                symbol_12 = symbol_11;
		            }
		            symbol_13 = symbol_12;
		        }
		        symbol_14 = symbol_13;
		    }
		    CAUGHT_symbol_14 = symbol_14;
		}
		catch (Exception e) {
		    CAUGHT_symbol_14 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_14 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"Employee", "mustHaveNonEmptyName", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, CodegencompanyValidator.DIAGNOSTIC_SOURCE, CodegencompanyValidator.EMPLOYEE__MUST_HAVE_NON_EMPTY_NAME, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCompany((Company)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				return basicSetCompany(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				return eInternalContainer().eInverseRemove(this, CodegencompanyPackage.COMPANY__EMPLOYEES, Company.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodegencompanyPackage.EMPLOYEE__NAME:
				return getName();
			case CodegencompanyPackage.EMPLOYEE__MANAGER:
				if (resolve) return getManager();
				return basicGetManager();
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				return getCompany();
			case CodegencompanyPackage.EMPLOYEE__DIRECT_REPORTS:
				return getDirectReports();
			case CodegencompanyPackage.EMPLOYEE__ALL_REPORTS:
				return getAllReports();
			case CodegencompanyPackage.EMPLOYEE__REPORTING_CHAIN:
				return getReportingChain();
			case CodegencompanyPackage.EMPLOYEE__HAS_NAME_AS_ATTRIBUTE:
				return isHasNameAsAttribute();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CodegencompanyPackage.EMPLOYEE__NAME:
				setName((String)newValue);
				return;
			case CodegencompanyPackage.EMPLOYEE__MANAGER:
				setManager((Employee)newValue);
				return;
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				setCompany((Company)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case CodegencompanyPackage.EMPLOYEE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CodegencompanyPackage.EMPLOYEE__MANAGER:
				setManager((Employee)null);
				return;
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				setCompany((Company)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CodegencompanyPackage.EMPLOYEE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CodegencompanyPackage.EMPLOYEE__MANAGER:
				return manager != null;
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				return getCompany() != null;
			case CodegencompanyPackage.EMPLOYEE__DIRECT_REPORTS:
				return !getDirectReports().isEmpty();
			case CodegencompanyPackage.EMPLOYEE__ALL_REPORTS:
				return !getAllReports().isEmpty();
			case CodegencompanyPackage.EMPLOYEE__REPORTING_CHAIN:
				return !getReportingChain().isEmpty();
			case CodegencompanyPackage.EMPLOYEE__HAS_NAME_AS_ATTRIBUTE:
				return isHasNameAsAttribute() != HAS_NAME_AS_ATTRIBUTE_EDEFAULT;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CodegencompanyPackage.EMPLOYEE___REPORTS_TO__EMPLOYEE:
				return reportsTo((Employee)arguments.get(0));
			case CodegencompanyPackage.EMPLOYEE___NO_MANAGER_IMPLIES_DIRECT_REPORTS__DIAGNOSTICCHAIN_MAP:
				return noManagerImpliesDirectReports((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case CodegencompanyPackage.EMPLOYEE___HAS_NAME_AS_OPERATION:
				return hasNameAsOperation();
			case CodegencompanyPackage.EMPLOYEE___MUST_HAVE_NAME__DIAGNOSTICCHAIN_MAP:
				return mustHaveName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case CodegencompanyPackage.EMPLOYEE___MUST_HAVE_NON_EMPTY_NAME__DIAGNOSTICCHAIN_MAP:
				return mustHaveNonEmptyName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EmployeeImpl
