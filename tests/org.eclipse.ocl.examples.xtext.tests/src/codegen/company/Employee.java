/**
 * <copyright>
 *******************************************************************************/
package codegen.company;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link codegen.company.Employee#getName <em>Name</em>}</li>
 *   <li>{@link codegen.company.Employee#getManager <em>Manager</em>}</li>
 *   <li>{@link codegen.company.Employee#getCompany <em>Company</em>}</li>
 *   <li>{@link codegen.company.Employee#getDirectReports <em>Direct Reports</em>}</li>
 *   <li>{@link codegen.company.Employee#getAllReports <em>All Reports</em>}</li>
 *   <li>{@link codegen.company.Employee#getReportingChain <em>Reporting Chain</em>}</li>
 *   <li>{@link codegen.company.Employee#isHasNameAsAttribute <em>Has Name As Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see codegen.company.CodegencompanyPackage#getEmployee()
 * @model
 * @generated
 */
public interface Employee extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see codegen.company.CodegencompanyPackage#getEmployee_Name()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/test/Pivot/Company.ecore!Employee!name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link codegen.company.Employee#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manager</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manager</em>' reference.
	 * @see #setManager(Employee)
	 * @see codegen.company.CodegencompanyPackage#getEmployee_Manager()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/test/Pivot/Company.ecore!Employee!manager'"
	 * @generated
	 */
	Employee getManager();

	/**
	 * Sets the value of the '{@link codegen.company.Employee#getManager <em>Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager</em>' reference.
	 * @see #getManager()
	 * @generated
	 */
	void setManager(Employee value);

	/**
	 * Returns the value of the '<em><b>Company</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link codegen.company.Company#getEmployees <em>Employees</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Company</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Company</em>' container reference.
	 * @see #setCompany(Company)
	 * @see codegen.company.CodegencompanyPackage#getEmployee_Company()
	 * @see codegen.company.Company#getEmployees
	 * @model opposite="employees" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/test/Pivot/Company.ecore!Employee!company'"
	 * @generated
	 */
	Company getCompany();

	/**
	 * Sets the value of the '{@link codegen.company.Employee#getCompany <em>Company</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Company</em>' container reference.
	 * @see #getCompany()
	 * @generated
	 */
	void setCompany(Company value);

	/**
	 * Returns the value of the '<em><b>Direct Reports</b></em>' reference list.
	 * The list contents are of type {@link codegen.company.Employee}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direct Reports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direct Reports</em>' reference list.
	 * @see codegen.company.CodegencompanyPackage#getEmployee_DirectReports()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * company.employees->select(manager = self)\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.library.ecore.EcoreExecutorManager%>(this, <%codegen.company.CodegencompanyTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%codegen.company.Company%> company = this.getCompany();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.util.List%><<%codegen.company.Employee%>> employees = company.getEmployees();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.OrderedSetValue%> BOXED_employees = idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, employees);\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.OrderedSetValue%>.Accumulator accumulator = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createOrderedSetAccumulatorValue(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee);\n@<%org.eclipse.jdt.annotation.Nullable%> <%java.util.Iterator%><?> ITERATOR__1 = BOXED_employees.iterator();\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.OrderedSetValue%> select;\nwhile (true) {\n    if (!ITERATOR__1.hasNext()) {\n        select = accumulator;\n        break;\n    }\n    @<%org.eclipse.jdt.annotation.Nullable%> /*@NonInvalid\052/ <%codegen.company.Employee%> _1 = (<%codegen.company.Employee%>)ITERATOR__1.next();\n    /**\n     * manager = self\n     \052/\n    if (_1 == null) {\n        throw new <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>(\"Null source for \\\'company::Employee.manager\\\'\");\n    }\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%codegen.company.Employee%> manager_0 = _1.getManager();\n    final /*@Thrown\052/ boolean eq = manager_0 == this;\n    //\n    if (eq == <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n        accumulator.add(_1);\n    }\n}\nfinal <%java.util.List%><<%codegen.company.Employee%>> UNBOXED_select = select.asEcoreObjects(idResolver, codegen.company.Employee.class);\nassert UNBOXED_select != null;\nreturn (<%org.eclipse.emf.common.util.EList<codegen.company.Employee>%>)UNBOXED_select;'"
	 * @generated
	 */
	EList<Employee> getDirectReports();

	/**
	 * Returns the value of the '<em><b>All Reports</b></em>' reference list.
	 * The list contents are of type {@link codegen.company.Employee}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Reports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Reports</em>' reference list.
	 * @see codegen.company.CodegencompanyPackage#getEmployee_AllReports()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * Employee.allInstances()->select(reportsTo(self))\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.library.ecore.EcoreExecutorManager%>(this, <%codegen.company.CodegencompanyTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.domain.elements.DomainType%> TYP_company_c_c_Employee_0 = idResolver.getType(<%codegen.company.CodegencompanyTables%>.CLSSid_Employee, null);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.SetValue%> allInstances = <%org.eclipse.ocl.library.classifier.ClassifierAllInstancesOperation%>.INSTANCE.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.SET_CLSSid_Employee, TYP_company_c_c_Employee_0);\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.SetValue%>.Accumulator accumulator = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createSetAccumulatorValue(<%codegen.company.CodegencompanyTables%>.SET_CLSSid_Employee);\n@<%org.eclipse.jdt.annotation.Nullable%> <%java.util.Iterator%><?> ITERATOR__1 = allInstances.iterator();\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.SetValue%> select;\nwhile (true) {\n    if (!ITERATOR__1.hasNext()) {\n        select = accumulator;\n        break;\n    }\n    @<%org.eclipse.jdt.annotation.Nullable%> /*@NonInvalid\052/ <%codegen.company.Employee%> _1 = (<%codegen.company.Employee%>)ITERATOR__1.next();\n    /**\n     * reportsTo(self)\n     \052/\n    if (_1 == null) {\n        throw new <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>(\"Null source for \\\'company::Employee.reportsTo(company::Employee[?]) : Boolean\\\'\");\n    }\n    final /*@Thrown\052/ boolean reportsTo = _1.reportsTo(this);\n    //\n    if (reportsTo == <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n        accumulator.add(_1);\n    }\n}\nfinal <%java.util.List%><<%codegen.company.Employee%>> UNBOXED_select = select.asEcoreObjects(idResolver, codegen.company.Employee.class);\nassert UNBOXED_select != null;\nreturn (<%org.eclipse.emf.common.util.EList<codegen.company.Employee>%>)UNBOXED_select;'"
	 * @generated
	 */
	EList<Employee> getAllReports();

	/**
	 * Returns the value of the '<em><b>Reporting Chain</b></em>' reference list.
	 * The list contents are of type {@link codegen.company.Employee}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reporting Chain</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reporting Chain</em>' reference list.
	 * @see codegen.company.CodegencompanyPackage#getEmployee_ReportingChain()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * \n * if manager.oclIsUndefined()\n * then OrderedSet{}\n * else manager.reportingChain->prepend(manager)\n * endif\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.library.ecore.EcoreExecutorManager%>(this, <%codegen.company.CodegencompanyTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_manager_0;\ntry {\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%codegen.company.Employee%> manager_0 = this.getManager();\n    CAUGHT_manager_0 = manager_0;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_manager_0 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n}\nfinal /*@NonInvalid\052/ boolean symbol_6 = (CAUGHT_manager_0 == null) || (CAUGHT_manager_0 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>);\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.OrderedSetValue%> symbol_7;\nif (symbol_6) {\n    symbol_7 = <%codegen.company.CodegencompanyTables%>.OrderedSet;\n}\nelse {\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%codegen.company.Employee%> manager_2 = this.getManager();\n    if (manager_2 == null) {\n        throw new <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>(\"Null source for \\\'company::Employee.reportingChain\\\'\");\n    }\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.util.List%><<%codegen.company.Employee%>> reportingChain = manager_2.getReportingChain();\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.OrderedSetValue%> BOXED_reportingChain = idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, reportingChain);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.OrderedSetValue%> prepend = (<%org.eclipse.ocl.domain.values.OrderedSetValue%>)<%org.eclipse.ocl.library.collection.OrderedCollectionPrependOperation%>.INSTANCE.evaluate(BOXED_reportingChain, manager_2);\n    symbol_7 = prepend;\n}\nfinal <%java.util.List%><<%codegen.company.Employee%>> UNBOXED_symbol_7 = symbol_7.asEcoreObjects(idResolver, codegen.company.Employee.class);\nassert UNBOXED_symbol_7 != null;\nreturn (<%org.eclipse.emf.common.util.EList<codegen.company.Employee>%>)UNBOXED_symbol_7;'"
	 * @generated
	 */
	EList<Employee> getReportingChain();

	/**
	 * Returns the value of the '<em><b>Has Name As Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Name As Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Name As Attribute</em>' attribute.
	 * @see codegen.company.CodegencompanyPackage#getEmployee_HasNameAsAttribute()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * name <> null\n \052/\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name = this.getName();\nfinal /*@Thrown\052/ boolean ne = name != null;\nreturn ne;'"
	 * @generated
	 */
	boolean isHasNameAsAttribute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * self.reportingChain->includes(manager)\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.library.ecore.EcoreExecutorManager%>(this, <%codegen.company.CodegencompanyTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.util.List%><<%codegen.company.Employee%>> reportingChain = this.getReportingChain();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.OrderedSetValue%> BOXED_reportingChain = idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, reportingChain);\nfinal /*@Thrown\052/ boolean includes = <%org.eclipse.ocl.library.collection.CollectionIncludesOperation%>.INSTANCE.evaluate(BOXED_reportingChain, manager);\nreturn includes;'"
	 * @generated
	 */
	boolean reportsTo(Employee manager);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv noManagerImpliesDirectReports: manager.oclIsUndefined() implies directReports->size() > 0\n \052/\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_symbol_9;\ntry {\n    @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_manager_0;\n    try {\n        final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%codegen.company.Employee%> manager_0 = this.getManager();\n        CAUGHT_manager_0 = manager_0;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_manager_0 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean self_11 = (CAUGHT_manager_0 == null) || (CAUGHT_manager_0 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.library.ecore.EcoreExecutorManager%>(this, <%codegen.company.CodegencompanyTables%>.LIBRARY);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\n    @<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_b;\n    try {\n        final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.util.List%><<%codegen.company.Employee%>> directReports = this.getDirectReports();\n        final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.OrderedSetValue%> BOXED_directReports = idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, directReports);\n        final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.IntegerValue%> size = <%org.eclipse.ocl.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_directReports);\n        final /*@Thrown\052/ boolean b = <%org.eclipse.ocl.library.numeric.NumericGreaterThanOperation%>.INSTANCE.evaluate(size, <%codegen.company.CodegencompanyTables%>.INT_0);\n        CAUGHT_b = b;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_b = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean eq = !self_11;\n    /*@Thrown\052/ boolean symbol_9;\n    if (eq) {\n        symbol_9 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.TRUE_VALUE;\n    }\n    else {\n        final /*@NonInvalid\052/ boolean symbol_6 = CAUGHT_b instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>;\n        /*@Thrown\052/ boolean symbol_8;\n        if (symbol_6) {\n            if (CAUGHT_b instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>) {\n                throw (<%org.eclipse.ocl.domain.values.impl.InvalidValueException%>)CAUGHT_b;\n            }\n            symbol_8 = (<%java.lang.Boolean%>)CAUGHT_b;\n        }\n        else {\n            /*@NonInvalid\052/ boolean symbol_7;\n            if (CAUGHT_b == Boolean.TRUE) {\n                symbol_7 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.TRUE_VALUE;\n            }\n            else {\n                symbol_7 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.FALSE_VALUE;\n            }\n            symbol_8 = symbol_7;\n        }\n        symbol_9 = symbol_8;\n    }\n    CAUGHT_symbol_9 = symbol_9;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_symbol_9 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_symbol_9 == <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n    return true;\n}\nif (diagnostics != null) {\n    int severity = <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n    <%java.lang.String%> message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"Employee\", \"noManagerImpliesDirectReports\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%codegen.company.util.CodegencompanyValidator%>.DIAGNOSTIC_SOURCE, <%codegen.company.util.CodegencompanyValidator%>.EMPLOYEE__NO_MANAGER_IMPLIES_DIRECT_REPORTS, message, new Object [] { this }));\n}\nreturn false;'"
	 * @generated
	 */
	boolean noManagerImpliesDirectReports(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * name <> null\n \052/\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name = this.getName();\nfinal /*@Thrown\052/ boolean ne = name != null;\nreturn ne;'"
	 * @generated
	 */
	boolean hasNameAsOperation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv mustHaveName: not name.oclIsUndefined() and hasNameAsAttribute and hasNameAsOperation()\n \052/\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_symbol_20;\ntry {\n    @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_symbol_10;\n    try {\n        @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_name;\n        try {\n            final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name = this.getName();\n            CAUGHT_name = name;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_name = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n        }\n        final /*@NonInvalid\052/ boolean self_11 = (CAUGHT_name == null) || (CAUGHT_name instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>);\n        final /*@NonInvalid\052/ boolean eq = !self_11;\n        @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_b;\n        try {\n            final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> b = this.isHasNameAsAttribute();\n            CAUGHT_b = b;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_b = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n        }\n        final /*@NonInvalid\052/ boolean eq_0 = !eq;\n        @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> symbol_10;\n        if (eq_0) {\n            symbol_10 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.FALSE_VALUE;\n        }\n        else {\n            if (CAUGHT_b instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>) {\n                throw (<%org.eclipse.ocl.domain.values.impl.InvalidValueException%>)CAUGHT_b;\n            }\n            final /*@NonInvalid\052/ boolean symbol_6 = CAUGHT_b instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>;\n            @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> symbol_9;\n            if (symbol_6) {\n                symbol_9 = (<%java.lang.Boolean%>)CAUGHT_b;\n            }\n            else {\n                final /*@Thrown\052/ boolean eq_1 = CAUGHT_b == Boolean.FALSE;\n                @<%org.eclipse.jdt.annotation.Nullable%> /*@NonInvalid\052/ <%java.lang.Boolean%> symbol_8;\n                if (eq_1) {\n                    symbol_8 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.FALSE_VALUE;\n                }\n                else {\n                    final /*@Thrown\052/ boolean eq_2 = CAUGHT_b == null;\n                    @<%org.eclipse.jdt.annotation.Nullable%> /*@NonInvalid\052/ <%java.lang.Boolean%> symbol_7;\n                    if (eq_2) {\n                        symbol_7 = null;\n                    }\n                    else {\n                        symbol_7 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.TRUE_VALUE;\n                    }\n                    symbol_8 = symbol_7;\n                }\n                symbol_9 = symbol_8;\n            }\n            symbol_10 = symbol_9;\n        }\n        CAUGHT_symbol_10 = symbol_10;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_symbol_10 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n    }\n    @<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_b_0;\n    try {\n        final /*@Thrown\052/ boolean b_0 = this.hasNameAsOperation();\n        CAUGHT_b_0 = b_0;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_b_0 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean symbol_11 = CAUGHT_symbol_10 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>;\n    @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> symbol_20;\n    if (symbol_11) {\n        final /*@NonInvalid\052/ boolean symbol_12 = CAUGHT_b_0 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>;\n        @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> symbol_14;\n        if (symbol_12) {\n            if (CAUGHT_symbol_10 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>) {\n                throw (<%org.eclipse.ocl.domain.values.impl.InvalidValueException%>)CAUGHT_symbol_10;\n            }\n            symbol_14 = (<%java.lang.Boolean%>)CAUGHT_symbol_10;\n        }\n        else {\n            if (CAUGHT_b_0 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>) {\n                throw (<%org.eclipse.ocl.domain.values.impl.InvalidValueException%>)CAUGHT_b_0;\n            }\n            final /*@Thrown\052/ boolean eq_3 = CAUGHT_b_0 == Boolean.FALSE;\n            @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> symbol_13;\n            if (eq_3) {\n                symbol_13 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.FALSE_VALUE;\n            }\n            else {\n                if (CAUGHT_symbol_10 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>) {\n                    throw (<%org.eclipse.ocl.domain.values.impl.InvalidValueException%>)CAUGHT_symbol_10;\n                }\n                symbol_13 = (<%java.lang.Boolean%>)CAUGHT_symbol_10;\n            }\n            symbol_14 = symbol_13;\n        }\n        symbol_20 = symbol_14;\n    }\n    else {\n        if (CAUGHT_symbol_10 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>) {\n            throw (<%org.eclipse.ocl.domain.values.impl.InvalidValueException%>)CAUGHT_symbol_10;\n        }\n        final /*@Thrown\052/ boolean eq_4 = CAUGHT_symbol_10 == Boolean.FALSE;\n        @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> symbol_19;\n        if (eq_4) {\n            symbol_19 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.FALSE_VALUE;\n        }\n        else {\n            if (CAUGHT_b_0 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>) {\n                throw (<%org.eclipse.ocl.domain.values.impl.InvalidValueException%>)CAUGHT_b_0;\n            }\n            final /*@NonInvalid\052/ boolean symbol_15 = CAUGHT_b_0 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>;\n            @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> symbol_18;\n            if (symbol_15) {\n                symbol_18 = (<%java.lang.Boolean%>)CAUGHT_b_0;\n            }\n            else {\n                final /*@Thrown\052/ boolean eq_5 = CAUGHT_b_0 == Boolean.FALSE;\n                @<%org.eclipse.jdt.annotation.Nullable%> /*@NonInvalid\052/ <%java.lang.Boolean%> symbol_17;\n                if (eq_5) {\n                    symbol_17 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.FALSE_VALUE;\n                }\n                else {\n                    final /*@Thrown\052/ boolean eq_6 = CAUGHT_symbol_10 == null;\n                    @<%org.eclipse.jdt.annotation.Nullable%> /*@NonInvalid\052/ <%java.lang.Boolean%> symbol_16;\n                    if (eq_6) {\n                        symbol_16 = null;\n                    }\n                    else {\n                        symbol_16 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.TRUE_VALUE;\n                    }\n                    symbol_17 = symbol_16;\n                }\n                symbol_18 = symbol_17;\n            }\n            symbol_19 = symbol_18;\n        }\n        symbol_20 = symbol_19;\n    }\n    CAUGHT_symbol_20 = symbol_20;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_symbol_20 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_symbol_20 == <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n    return true;\n}\nif (diagnostics != null) {\n    int severity = CAUGHT_symbol_20 == null ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n    <%java.lang.String%> message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"Employee\", \"mustHaveName\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%codegen.company.util.CodegencompanyValidator%>.DIAGNOSTIC_SOURCE, <%codegen.company.util.CodegencompanyValidator%>.EMPLOYEE__MUST_HAVE_NAME, message, new Object [] { this }));\n}\nreturn false;'"
	 * @generated
	 */
	boolean mustHaveName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * inv mustHaveNonEmptyName: name->notEmpty() implies name.size() > 0\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.library.ecore.EcoreExecutorManager%>(this, <%codegen.company.CodegencompanyTables%>.LIBRARY);\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_symbol_14;\ntry {\n    @<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_self_11;\n    try {\n        final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name = this.getName();\n        final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.SetValue%> oclAsSet = <%org.eclipse.ocl.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.SET_PRIMid_String, name);\n        final /*@Thrown\052/ boolean self_11 = <%org.eclipse.ocl.library.collection.CollectionNotEmptyOperation%>.INSTANCE.evaluate(oclAsSet);\n        CAUGHT_self_11 = self_11;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_self_11 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n    }\n    @<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_b;\n    try {\n        final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name_0 = this.getName();\n        final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.domain.values.IntegerValue%> size = <%org.eclipse.ocl.library.string.StringSizeOperation%>.INSTANCE.evaluate(name_0);\n        final /*@Thrown\052/ boolean b = <%org.eclipse.ocl.library.numeric.NumericGreaterThanOperation%>.INSTANCE.evaluate(size, <%codegen.company.CodegencompanyTables%>.INT_0);\n        CAUGHT_b = b;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_b = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean symbol_6 = CAUGHT_self_11 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>;\n    /*@Thrown\052/ boolean symbol_14;\n    if (symbol_6) {\n        final /*@NonInvalid\052/ boolean symbol_7 = CAUGHT_b instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>;\n        /*@Thrown\052/ boolean symbol_9;\n        if (symbol_7) {\n            if (CAUGHT_self_11 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>) {\n                throw (<%org.eclipse.ocl.domain.values.impl.InvalidValueException%>)CAUGHT_self_11;\n            }\n            symbol_9 = (<%java.lang.Boolean%>)CAUGHT_self_11;\n        }\n        else {\n            /*@Thrown\052/ boolean symbol_8;\n            if (CAUGHT_b == Boolean.TRUE) {\n                symbol_8 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.TRUE_VALUE;\n            }\n            else {\n                if (CAUGHT_self_11 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>) {\n                    throw (<%org.eclipse.ocl.domain.values.impl.InvalidValueException%>)CAUGHT_self_11;\n                }\n                symbol_8 = (<%java.lang.Boolean%>)CAUGHT_self_11;\n            }\n            symbol_9 = symbol_8;\n        }\n        symbol_14 = symbol_9;\n    }\n    else {\n        if (CAUGHT_self_11 instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>) {\n            throw (<%org.eclipse.ocl.domain.values.impl.InvalidValueException%>)CAUGHT_self_11;\n        }\n        final /*@Thrown\052/ boolean eq = CAUGHT_self_11 == Boolean.FALSE;\n        /*@Thrown\052/ boolean symbol_13;\n        if (eq) {\n            symbol_13 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.TRUE_VALUE;\n        }\n        else {\n            final /*@NonInvalid\052/ boolean symbol_10 = CAUGHT_b instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>;\n            /*@Thrown\052/ boolean symbol_12;\n            if (symbol_10) {\n                if (CAUGHT_b instanceof <%org.eclipse.ocl.domain.values.impl.InvalidValueException%>) {\n                    throw (<%org.eclipse.ocl.domain.values.impl.InvalidValueException%>)CAUGHT_b;\n                }\n                symbol_12 = (<%java.lang.Boolean%>)CAUGHT_b;\n            }\n            else {\n                /*@NonInvalid\052/ boolean symbol_11;\n                if (CAUGHT_b == Boolean.TRUE) {\n                    symbol_11 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.TRUE_VALUE;\n                }\n                else {\n                    symbol_11 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.FALSE_VALUE;\n                }\n                symbol_12 = symbol_11;\n            }\n            symbol_13 = symbol_12;\n        }\n        symbol_14 = symbol_13;\n    }\n    CAUGHT_symbol_14 = symbol_14;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_symbol_14 = <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_symbol_14 == <%org.eclipse.ocl.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n    return true;\n}\nif (diagnostics != null) {\n    int severity = <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n    <%java.lang.String%> message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"Employee\", \"mustHaveNonEmptyName\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%codegen.company.util.CodegencompanyValidator%>.DIAGNOSTIC_SOURCE, <%codegen.company.util.CodegencompanyValidator%>.EMPLOYEE__MUST_HAVE_NON_EMPTY_NAME, message, new Object [] { this }));\n}\nreturn false;'"
	 * @generated
	 */
	boolean mustHaveNonEmptyName(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Employee
