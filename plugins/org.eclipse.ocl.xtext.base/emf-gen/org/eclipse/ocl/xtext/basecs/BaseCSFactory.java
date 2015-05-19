/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.basecs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage
 * @generated
 */
public interface BaseCSFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BaseCSFactory eINSTANCE = org.eclipse.ocl.xtext.basecs.impl.BaseCSFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Annotation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation CS</em>'.
	 * @generated
	 */
	AnnotationCS createAnnotationCS();

	/**
	 * Returns a new object of class '<em>Attribute CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute CS</em>'.
	 * @generated
	 */
	AttributeCS createAttributeCS();

	/**
	 * Returns a new object of class '<em>Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint CS</em>'.
	 * @generated
	 */
	ConstraintCS createConstraintCS();

	/**
	 * Returns a new object of class '<em>Data Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type CS</em>'.
	 * @generated
	 */
	DataTypeCS createDataTypeCS();

	/**
	 * Returns a new object of class '<em>Detail CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Detail CS</em>'.
	 * @generated
	 */
	DetailCS createDetailCS();

	/**
	 * Returns a new object of class '<em>Documentation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Documentation CS</em>'.
	 * @generated
	 */
	DocumentationCS createDocumentationCS();

	/**
	 * Returns a new object of class '<em>Enumeration CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration CS</em>'.
	 * @generated
	 */
	EnumerationCS createEnumerationCS();

	/**
	 * Returns a new object of class '<em>Enumeration Literal CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Literal CS</em>'.
	 * @generated
	 */
	EnumerationLiteralCS createEnumerationLiteralCS();

	/**
	 * Returns a new object of class '<em>Import CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import CS</em>'.
	 * @generated
	 */
	ImportCS createImportCS();

	/**
	 * Returns a new object of class '<em>Lambda Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lambda Type CS</em>'.
	 * @generated
	 */
	LambdaTypeCS createLambdaTypeCS();

	/**
	 * Returns a new object of class '<em>Model Element Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Element Ref CS</em>'.
	 * @generated
	 */
	ModelElementRefCS createModelElementRefCS();

	/**
	 * Returns a new object of class '<em>Multiplicity Bounds CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicity Bounds CS</em>'.
	 * @generated
	 */
	MultiplicityBoundsCS createMultiplicityBoundsCS();

	/**
	 * Returns a new object of class '<em>Multiplicity String CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicity String CS</em>'.
	 * @generated
	 */
	MultiplicityStringCS createMultiplicityStringCS();

	/**
	 * Returns a new object of class '<em>Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation CS</em>'.
	 * @generated
	 */
	OperationCS createOperationCS();

	/**
	 * Returns a new object of class '<em>Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package CS</em>'.
	 * @generated
	 */
	PackageCS createPackageCS();

	/**
	 * Returns a new object of class '<em>Parameter CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter CS</em>'.
	 * @generated
	 */
	ParameterCS createParameterCS();

	/**
	 * Returns a new object of class '<em>Path Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path Element CS</em>'.
	 * @generated
	 */
	PathElementCS createPathElementCS();

	/**
	 * Returns a new object of class '<em>Path Element With URICS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path Element With URICS</em>'.
	 * @generated
	 */
	PathElementWithURICS createPathElementWithURICS();

	/**
	 * Returns a new object of class '<em>Path Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path Name CS</em>'.
	 * @generated
	 */
	PathNameCS createPathNameCS();

	/**
	 * Returns a new object of class '<em>Primitive Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type Ref CS</em>'.
	 * @generated
	 */
	PrimitiveTypeRefCS createPrimitiveTypeRefCS();

	/**
	 * Returns a new object of class '<em>Reference CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference CS</em>'.
	 * @generated
	 */
	ReferenceCS createReferenceCS();

	/**
	 * Returns a new object of class '<em>Root Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Package CS</em>'.
	 * @generated
	 */
	RootPackageCS createRootPackageCS();

	/**
	 * Returns a new object of class '<em>Specification CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specification CS</em>'.
	 * @generated
	 */
	SpecificationCS createSpecificationCS();

	/**
	 * Returns a new object of class '<em>Structured Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structured Class CS</em>'.
	 * @generated
	 */
	StructuredClassCS createStructuredClassCS();

	/**
	 * Returns a new object of class '<em>Template Binding CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Binding CS</em>'.
	 * @generated
	 */
	TemplateBindingCS createTemplateBindingCS();

	/**
	 * Returns a new object of class '<em>Template Parameter Substitution CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Parameter Substitution CS</em>'.
	 * @generated
	 */
	TemplateParameterSubstitutionCS createTemplateParameterSubstitutionCS();

	/**
	 * Returns a new object of class '<em>Template Signature CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Signature CS</em>'.
	 * @generated
	 */
	TemplateSignatureCS createTemplateSignatureCS();

	/**
	 * Returns a new object of class '<em>Tuple Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Part CS</em>'.
	 * @generated
	 */
	TuplePartCS createTuplePartCS();

	/**
	 * Returns a new object of class '<em>Tuple Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Type CS</em>'.
	 * @generated
	 */
	TupleTypeCS createTupleTypeCS();

	/**
	 * Returns a new object of class '<em>Type Parameter CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Parameter CS</em>'.
	 * @generated
	 */
	TypeParameterCS createTypeParameterCS();

	/**
	 * Returns a new object of class '<em>Typed Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Type Ref CS</em>'.
	 * @generated
	 */
	TypedTypeRefCS createTypedTypeRefCS();

	/**
	 * Returns a new object of class '<em>Wildcard Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wildcard Type Ref CS</em>'.
	 * @generated
	 */
	WildcardTypeRefCS createWildcardTypeRefCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BaseCSPackage getBaseCSPackage();

} //BaseCSFactory
