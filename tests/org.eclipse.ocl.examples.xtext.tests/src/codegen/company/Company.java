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
 * A representation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link codegen.company.Company#getName <em>Name</em>}</li>
 *   <li>{@link codegen.company.Company#getEmployees <em>Employees</em>}</li>
 *   <li>{@link codegen.company.Company#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see codegen.company.CodegencompanyPackage#getCompany()
 * @model
 * @generated
 */
public interface Company extends EObject {
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
	 * @see codegen.company.CodegencompanyPackage#getCompany_Name()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/test/Pivot/Company.ecore!Company!name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link codegen.company.Company#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Employees</b></em>' containment reference list.
	 * The list contents are of type {@link codegen.company.Employee}.
	 * It is bidirectional and its opposite is '{@link codegen.company.Employee#getCompany <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employees</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employees</em>' containment reference list.
	 * @see codegen.company.CodegencompanyPackage#getCompany_Employees()
	 * @see codegen.company.Employee#getCompany
	 * @model opposite="company" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/test/Pivot/Company.ecore!Company!employees'"
	 * @generated
	 */
	EList<Employee> getEmployees();

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The literals are from the enumeration {@link codegen.company.CompanySizeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see codegen.company.CompanySizeKind
	 * @see codegen.company.CodegencompanyPackage#getCompany_Size()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * \n * let\n *   table : Set(Tuple(range:Sequence(Integer), size:company::CompanySizeKind)) = Set{\n *     Tuple{range = Sequence{0..49}, size = CompanySizeKind::small\n *     }\n *     , Tuple{range = Sequence{50..999}, size = CompanySizeKind::medium\n *     }\n *     , Tuple{range = Sequence{1000..1000000}, size = CompanySizeKind::large\n *     }\n *   }\n * in\n *   table->any(range->includes(employees->size())).size\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.DomainEvaluator%> evaluator = <%org.eclipse.ocl.pivot.utilities.PivotUtil%>.getEvaluator(this);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\n@<%org.eclipse.jdt.annotation.Nullable%> <%java.util.Iterator%><?> ITERATOR__1 = <%codegen.company.CodegencompanyTables%>.table.iterator();\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.TupleValue%> any;\nwhile (true) {\n    if (!ITERATOR__1.hasNext()) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"No matching content for \'any\'\");\n    }\n    @<%org.eclipse.jdt.annotation.Nullable%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.TupleValue%> _1 = (<%org.eclipse.ocl.pivot.values.TupleValue%>)ITERATOR__1.next();\n    /**\n     * range->includes(employees->size())\n     \052/\n    if (_1 == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'$$::Tuple::range\\\'\");\n    }\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%> range = (<%org.eclipse.ocl.pivot.values.SequenceValue%>)_1.getValue(0/*range\052/);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.util.List%><<%codegen.company.Employee%>> employees = this.getEmployees();\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_employees = idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, employees);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> size = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_employees));\n    final /*@Thrown\052/ boolean includes = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.library.collection.CollectionIncludesOperation%>.INSTANCE.evaluate(range, size).booleanValue());\n    //\n    if (includes != <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.FALSE_VALUE) {\t\t\t// Carry on till something found\n        any = _1;\n        break;\n    }\n}\nif (any == null) {\n    throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'$$::Tuple::size\\\'\");\n}\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.EnumerationLiteralId%> size_0 = (<%org.eclipse.ocl.pivot.ids.EnumerationLiteralId%>)any.getValue(1/*size\052/);\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@NonInvalid\052/ <%org.eclipse.emf.common.util.Enumerator%> UNBOXED_size_0 = idResolver.unboxedValueOf(size_0);\nreturn (<%codegen.company.CompanySizeKind%>)UNBOXED_size_0;'"
	 * @generated
	 */
	CompanySizeKind getSize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * inv dummyInvariant: true\n \052/\nreturn true;'"
	 * @generated
	 */
	boolean dummyInvariant(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Company
