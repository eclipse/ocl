/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.xtext.base.basecs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSFactory;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DetailCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.EnumerationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.basecs.FeatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.basecs.IteratorKind;
import org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS;
import org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.basecs.OperationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementWithURICS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSValidator;
import org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BaseCSPackageImpl extends EPackageImpl implements BaseCSPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass detailCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationLiteralCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lambdaTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicityBoundsCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicityCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicityStringCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namespaceCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageOwnerCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathElementWithURICSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathNameCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pivotableElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootPackageCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralFeatureCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateBindingCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateParameterCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateParameterSubstitutionCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateSignatureCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateableElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tuplePartCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeParameterCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedTypeRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitableCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wildcardTypeRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum iteratorKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType scopeFilterEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BaseCSPackageImpl() {
		super(eNS_URI, BaseCSFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link BaseCSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BaseCSPackage init() {
		if (isInited) return (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);

		// Obtain or create and register package
		BaseCSPackageImpl theBaseCSPackage = (BaseCSPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BaseCSPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BaseCSPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PivotPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBaseCSPackage.createPackageContents();

		// Initialize created meta-data
		theBaseCSPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theBaseCSPackage, 
			 new EValidator.Descriptor()
			 {
				 public EValidator getEValidator()
				 {
					 return BaseCSValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theBaseCSPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BaseCSPackage.eNS_URI, theBaseCSPackage);
		return theBaseCSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationCS()
	{
		return annotationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationCS_OwnedContent()
	{
		return (EReference)annotationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationCS_OwnedReference()
	{
		return (EReference)annotationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationElementCS() {
		return annotationElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationElementCS_OwnedDetail()
	{
		return (EReference)annotationElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeCS() {
		return attributeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassCS() {
		return classCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassCS_OwnedSuperType() {
		return (EReference)classCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassCS_OwnedOperation() {
		return (EReference)classCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassCS_OwnedProperty() {
		return (EReference)classCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassCS_OwnedMetaType()
	{
		return (EReference)classCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierCS() {
		return classifierCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierCS_Owner() {
		return (EReference)classifierCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierCS_InstanceClassName()
	{
		return (EAttribute)classifierCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierCS_OwnedConstraint()
	{
		return (EReference)classifierCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierCS_Qualifier()
	{
		return (EAttribute)classifierCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraintCS()
	{
		return constraintCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintCS_Stereotype()
	{
		return (EAttribute)constraintCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintCS_Specification()
	{
		return (EReference)constraintCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintCS_MessageSpecification()
	{
		return (EReference)constraintCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeCS()
	{
		return dataTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataTypeCS_Literals()
	{
		return (EReference)dataTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDetailCS() {
		return detailCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetailCS_Value() {
		return (EAttribute)detailCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentationCS()
	{
		return documentationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentationCS_Value()
	{
		return (EAttribute)documentationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementCS() {
		return elementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementCS_LogicalParent()
	{
		return (EReference)elementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementRefCS()
	{
		return elementRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationCS()
	{
		return enumerationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationCS_OwnedLiterals()
	{
		return (EReference)enumerationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationLiteralCS()
	{
		return enumerationLiteralCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationLiteralCS_Value()
	{
		return (EAttribute)enumerationLiteralCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureCS() {
		return featureCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImportCS() {
		return importCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImportCS_PathName()
	{
		return (EReference)importCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImportCS_Namespace() {
		return (EReference)importCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImportCS_All()
	{
		return (EAttribute)importCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLambdaTypeCS()
	{
		return lambdaTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLambdaTypeCS_Name()
	{
		return (EAttribute)lambdaTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLambdaTypeCS_OwnedContextType()
	{
		return (EReference)lambdaTypeCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLambdaTypeCS_OwnedParameterType()
	{
		return (EReference)lambdaTypeCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLambdaTypeCS_OwnedResultType()
	{
		return (EReference)lambdaTypeCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibraryCS() {
		return libraryCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryCS_Package() {
		return (EReference)libraryCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementCS() {
		return modelElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementCS_OwnedAnnotation()
	{
		return (EReference)modelElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElementCS_OriginalXmiId() {
		return (EAttribute)modelElementCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElementCS_Csi()
	{
		return (EAttribute)modelElementCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementRefCS()
	{
		return modelElementRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementRefCS_PathName()
	{
		return (EReference)modelElementRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementRefCS_Element()
	{
		return (EReference)modelElementRefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicityBoundsCS()
	{
		return multiplicityBoundsCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicityBoundsCS_LowerBound()
	{
		return (EAttribute)multiplicityBoundsCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicityBoundsCS_UpperBound()
	{
		return (EAttribute)multiplicityBoundsCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicityCS()
	{
		return multiplicityCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicityStringCS()
	{
		return multiplicityStringCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicityStringCS_StringBounds()
	{
		return (EAttribute)multiplicityStringCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElementCS() {
		return namedElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElementCS_Name()
	{
		return (EAttribute)namedElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamespaceCS() {
		return namespaceCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationCS() {
		return operationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_OwnedParameter() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_OwnedException()
	{
		return (EReference)operationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_OwnedPrecondition()
	{
		return (EReference)operationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_OwnedPostcondition()
	{
		return (EReference)operationCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_OwnedBodyExpression()
	{
		return (EReference)operationCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_OwningClass() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageCS() {
		return packageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageCS_OwnedType()
	{
		return (EReference)packageCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageCS_NsPrefix()
	{
		return (EAttribute)packageCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageCS_NsURI()
	{
		return (EAttribute)packageCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageOwnerCS()
	{
		return packageOwnerCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageOwnerCS_OwnedNestedPackage()
	{
		return (EReference)packageOwnerCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterCS() {
		return parameterCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterCS_Owner() {
		return (EReference)parameterCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathElementCS()
	{
		return pathElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathElementCS_PathName()
	{
		return (EReference)pathElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathElementCS_Element()
	{
		return (EReference)pathElementCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathElementCS_ElementType()
	{
		return (EReference)pathElementCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathElementWithURICS()
	{
		return pathElementWithURICSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPathElementWithURICS_Uri()
	{
		return (EAttribute)pathElementWithURICSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathNameCS()
	{
		return pathNameCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathNameCS_Path()
	{
		return (EReference)pathNameCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathNameCS_Element()
	{
		return (EReference)pathNameCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathNameCS_Context()
	{
		return (EReference)pathNameCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPathNameCS_ScopeFilter()
	{
		return (EAttribute)pathNameCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPivotableElementCS()
	{
		return pivotableElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPivotableElementCS_Pivot()
	{
		return (EReference)pivotableElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveTypeRefCS() {
		return primitiveTypeRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveTypeRefCS_Name()
	{
		return (EAttribute)primitiveTypeRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceCS() {
		return referenceCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceCS_Opposite() {
		return (EReference)referenceCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceCS_Keys()
	{
		return (EReference)referenceCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootCS()
	{
		return rootCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootCS_OwnedImport()
	{
		return (EReference)rootCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootCS_OwnedLibrary()
	{
		return (EReference)rootCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootPackageCS()
	{
		return rootPackageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificationCS()
	{
		return specificationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecificationCS_ExprString()
	{
		return (EAttribute)specificationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuralFeatureCS() {
		return structuralFeatureCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuralFeatureCS_Owner() {
		return (EReference)structuralFeatureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructuralFeatureCS_Default()
	{
		return (EAttribute)structuralFeatureCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuralFeatureCS_OwnedDefaultExpression()
	{
		return (EReference)structuralFeatureCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateBindingCS() {
		return templateBindingCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateBindingCS_OwningTemplateBindableElement() {
		return (EReference)templateBindingCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateBindingCS_OwnedParameterSubstitution() {
		return (EReference)templateBindingCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateParameterCS() {
		return templateParameterCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateParameterCS_OwningTemplateSignature() {
		return (EReference)templateParameterCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateParameterSubstitutionCS() {
		return templateParameterSubstitutionCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateParameterSubstitutionCS_OwningTemplateBinding() {
		return (EReference)templateParameterSubstitutionCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateParameterSubstitutionCS_OwnedActualParameter() {
		return (EReference)templateParameterSubstitutionCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateSignatureCS() {
		return templateSignatureCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateSignatureCS_OwningTemplateElement() {
		return (EReference)templateSignatureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateSignatureCS_OwnedTemplateParameter() {
		return (EReference)templateSignatureCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateableElementCS() {
		return templateableElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateableElementCS_OwnedTemplateSignature() {
		return (EReference)templateableElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTuplePartCS()
	{
		return tuplePartCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTupleTypeCS()
	{
		return tupleTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTupleTypeCS_Name()
	{
		return (EAttribute)tupleTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTupleTypeCS_OwnedParts()
	{
		return (EReference)tupleTypeCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeCS() {
		return typeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeParameterCS() {
		return typeParameterCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeParameterCS_OwnedExtends() {
		return (EReference)typeParameterCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeParameterCS_OwnedSuper() {
		return (EReference)typeParameterCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeRefCS() {
		return typeRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedElementCS() {
		return typedElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElementCS_OwnedType() {
		return (EReference)typedElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementCS_Qualifier()
	{
		return (EAttribute)typedElementCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementCS_Optional()
	{
		return (EAttribute)typedElementCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedRefCS() {
		return typedRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedRefCS_Multiplicity()
	{
		return (EReference)typedRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedTypeRefCS() {
		return typedTypeRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedTypeRefCS_PathName()
	{
		return (EReference)typedTypeRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedTypeRefCS_Type() {
		return (EReference)typedTypeRefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedTypeRefCS_OwnedTemplateBinding()
	{
		return (EReference)typedTypeRefCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitableCS()
	{
		return visitableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWildcardTypeRefCS() {
		return wildcardTypeRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWildcardTypeRefCS_Extends() {
		return (EReference)wildcardTypeRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWildcardTypeRefCS_Super() {
		return (EReference)wildcardTypeRefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIteratorKind()
	{
		return iteratorKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getScopeFilter()
	{
		return scopeFilterEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseCSFactory getBaseCSFactory()
	{
		return (BaseCSFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		annotationCSEClass = createEClass(ANNOTATION_CS);
		createEReference(annotationCSEClass, ANNOTATION_CS__OWNED_CONTENT);
		createEReference(annotationCSEClass, ANNOTATION_CS__OWNED_REFERENCE);

		annotationElementCSEClass = createEClass(ANNOTATION_ELEMENT_CS);
		createEReference(annotationElementCSEClass, ANNOTATION_ELEMENT_CS__OWNED_DETAIL);

		attributeCSEClass = createEClass(ATTRIBUTE_CS);

		classCSEClass = createEClass(CLASS_CS);
		createEReference(classCSEClass, CLASS_CS__OWNED_SUPER_TYPE);
		createEReference(classCSEClass, CLASS_CS__OWNED_OPERATION);
		createEReference(classCSEClass, CLASS_CS__OWNED_PROPERTY);
		createEReference(classCSEClass, CLASS_CS__OWNED_META_TYPE);

		classifierCSEClass = createEClass(CLASSIFIER_CS);
		createEReference(classifierCSEClass, CLASSIFIER_CS__OWNER);
		createEAttribute(classifierCSEClass, CLASSIFIER_CS__INSTANCE_CLASS_NAME);
		createEReference(classifierCSEClass, CLASSIFIER_CS__OWNED_CONSTRAINT);
		createEAttribute(classifierCSEClass, CLASSIFIER_CS__QUALIFIER);

		constraintCSEClass = createEClass(CONSTRAINT_CS);
		createEAttribute(constraintCSEClass, CONSTRAINT_CS__STEREOTYPE);
		createEReference(constraintCSEClass, CONSTRAINT_CS__SPECIFICATION);
		createEReference(constraintCSEClass, CONSTRAINT_CS__MESSAGE_SPECIFICATION);

		dataTypeCSEClass = createEClass(DATA_TYPE_CS);
		createEReference(dataTypeCSEClass, DATA_TYPE_CS__LITERALS);

		detailCSEClass = createEClass(DETAIL_CS);
		createEAttribute(detailCSEClass, DETAIL_CS__VALUE);

		documentationCSEClass = createEClass(DOCUMENTATION_CS);
		createEAttribute(documentationCSEClass, DOCUMENTATION_CS__VALUE);

		elementCSEClass = createEClass(ELEMENT_CS);
		createEReference(elementCSEClass, ELEMENT_CS__LOGICAL_PARENT);

		elementRefCSEClass = createEClass(ELEMENT_REF_CS);

		enumerationCSEClass = createEClass(ENUMERATION_CS);
		createEReference(enumerationCSEClass, ENUMERATION_CS__OWNED_LITERALS);

		enumerationLiteralCSEClass = createEClass(ENUMERATION_LITERAL_CS);
		createEAttribute(enumerationLiteralCSEClass, ENUMERATION_LITERAL_CS__VALUE);

		featureCSEClass = createEClass(FEATURE_CS);

		importCSEClass = createEClass(IMPORT_CS);
		createEReference(importCSEClass, IMPORT_CS__PATH_NAME);
		createEReference(importCSEClass, IMPORT_CS__NAMESPACE);
		createEAttribute(importCSEClass, IMPORT_CS__ALL);

		lambdaTypeCSEClass = createEClass(LAMBDA_TYPE_CS);
		createEAttribute(lambdaTypeCSEClass, LAMBDA_TYPE_CS__NAME);
		createEReference(lambdaTypeCSEClass, LAMBDA_TYPE_CS__OWNED_CONTEXT_TYPE);
		createEReference(lambdaTypeCSEClass, LAMBDA_TYPE_CS__OWNED_PARAMETER_TYPE);
		createEReference(lambdaTypeCSEClass, LAMBDA_TYPE_CS__OWNED_RESULT_TYPE);

		libraryCSEClass = createEClass(LIBRARY_CS);
		createEReference(libraryCSEClass, LIBRARY_CS__PACKAGE);

		modelElementCSEClass = createEClass(MODEL_ELEMENT_CS);
		createEReference(modelElementCSEClass, MODEL_ELEMENT_CS__OWNED_ANNOTATION);
		createEAttribute(modelElementCSEClass, MODEL_ELEMENT_CS__ORIGINAL_XMI_ID);
		createEAttribute(modelElementCSEClass, MODEL_ELEMENT_CS__CSI);

		modelElementRefCSEClass = createEClass(MODEL_ELEMENT_REF_CS);
		createEReference(modelElementRefCSEClass, MODEL_ELEMENT_REF_CS__PATH_NAME);
		createEReference(modelElementRefCSEClass, MODEL_ELEMENT_REF_CS__ELEMENT);

		multiplicityBoundsCSEClass = createEClass(MULTIPLICITY_BOUNDS_CS);
		createEAttribute(multiplicityBoundsCSEClass, MULTIPLICITY_BOUNDS_CS__LOWER_BOUND);
		createEAttribute(multiplicityBoundsCSEClass, MULTIPLICITY_BOUNDS_CS__UPPER_BOUND);

		multiplicityCSEClass = createEClass(MULTIPLICITY_CS);

		multiplicityStringCSEClass = createEClass(MULTIPLICITY_STRING_CS);
		createEAttribute(multiplicityStringCSEClass, MULTIPLICITY_STRING_CS__STRING_BOUNDS);

		namedElementCSEClass = createEClass(NAMED_ELEMENT_CS);
		createEAttribute(namedElementCSEClass, NAMED_ELEMENT_CS__NAME);

		namespaceCSEClass = createEClass(NAMESPACE_CS);

		operationCSEClass = createEClass(OPERATION_CS);
		createEReference(operationCSEClass, OPERATION_CS__OWNING_CLASS);
		createEReference(operationCSEClass, OPERATION_CS__OWNED_PARAMETER);
		createEReference(operationCSEClass, OPERATION_CS__OWNED_EXCEPTION);
		createEReference(operationCSEClass, OPERATION_CS__OWNED_PRECONDITION);
		createEReference(operationCSEClass, OPERATION_CS__OWNED_POSTCONDITION);
		createEReference(operationCSEClass, OPERATION_CS__OWNED_BODY_EXPRESSION);

		packageCSEClass = createEClass(PACKAGE_CS);
		createEReference(packageCSEClass, PACKAGE_CS__OWNED_TYPE);
		createEAttribute(packageCSEClass, PACKAGE_CS__NS_PREFIX);
		createEAttribute(packageCSEClass, PACKAGE_CS__NS_URI);

		packageOwnerCSEClass = createEClass(PACKAGE_OWNER_CS);
		createEReference(packageOwnerCSEClass, PACKAGE_OWNER_CS__OWNED_NESTED_PACKAGE);

		parameterCSEClass = createEClass(PARAMETER_CS);
		createEReference(parameterCSEClass, PARAMETER_CS__OWNER);

		pathElementCSEClass = createEClass(PATH_ELEMENT_CS);
		createEReference(pathElementCSEClass, PATH_ELEMENT_CS__PATH_NAME);
		createEReference(pathElementCSEClass, PATH_ELEMENT_CS__ELEMENT);
		createEReference(pathElementCSEClass, PATH_ELEMENT_CS__ELEMENT_TYPE);

		pathElementWithURICSEClass = createEClass(PATH_ELEMENT_WITH_URICS);
		createEAttribute(pathElementWithURICSEClass, PATH_ELEMENT_WITH_URICS__URI);

		pathNameCSEClass = createEClass(PATH_NAME_CS);
		createEReference(pathNameCSEClass, PATH_NAME_CS__PATH);
		createEReference(pathNameCSEClass, PATH_NAME_CS__ELEMENT);
		createEReference(pathNameCSEClass, PATH_NAME_CS__CONTEXT);
		createEAttribute(pathNameCSEClass, PATH_NAME_CS__SCOPE_FILTER);

		pivotableElementCSEClass = createEClass(PIVOTABLE_ELEMENT_CS);
		createEReference(pivotableElementCSEClass, PIVOTABLE_ELEMENT_CS__PIVOT);

		primitiveTypeRefCSEClass = createEClass(PRIMITIVE_TYPE_REF_CS);
		createEAttribute(primitiveTypeRefCSEClass, PRIMITIVE_TYPE_REF_CS__NAME);

		referenceCSEClass = createEClass(REFERENCE_CS);
		createEReference(referenceCSEClass, REFERENCE_CS__OPPOSITE);
		createEReference(referenceCSEClass, REFERENCE_CS__KEYS);

		rootCSEClass = createEClass(ROOT_CS);
		createEReference(rootCSEClass, ROOT_CS__OWNED_IMPORT);
		createEReference(rootCSEClass, ROOT_CS__OWNED_LIBRARY);

		rootPackageCSEClass = createEClass(ROOT_PACKAGE_CS);

		specificationCSEClass = createEClass(SPECIFICATION_CS);
		createEAttribute(specificationCSEClass, SPECIFICATION_CS__EXPR_STRING);

		structuralFeatureCSEClass = createEClass(STRUCTURAL_FEATURE_CS);
		createEReference(structuralFeatureCSEClass, STRUCTURAL_FEATURE_CS__OWNER);
		createEAttribute(structuralFeatureCSEClass, STRUCTURAL_FEATURE_CS__DEFAULT);
		createEReference(structuralFeatureCSEClass, STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSION);

		templateBindingCSEClass = createEClass(TEMPLATE_BINDING_CS);
		createEReference(templateBindingCSEClass, TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT);
		createEReference(templateBindingCSEClass, TEMPLATE_BINDING_CS__OWNED_PARAMETER_SUBSTITUTION);

		templateParameterCSEClass = createEClass(TEMPLATE_PARAMETER_CS);
		createEReference(templateParameterCSEClass, TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE);

		templateParameterSubstitutionCSEClass = createEClass(TEMPLATE_PARAMETER_SUBSTITUTION_CS);
		createEReference(templateParameterSubstitutionCSEClass, TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNING_TEMPLATE_BINDING);
		createEReference(templateParameterSubstitutionCSEClass, TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER);

		templateSignatureCSEClass = createEClass(TEMPLATE_SIGNATURE_CS);
		createEReference(templateSignatureCSEClass, TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT);
		createEReference(templateSignatureCSEClass, TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER);

		templateableElementCSEClass = createEClass(TEMPLATEABLE_ELEMENT_CS);
		createEReference(templateableElementCSEClass, TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE);

		tuplePartCSEClass = createEClass(TUPLE_PART_CS);

		tupleTypeCSEClass = createEClass(TUPLE_TYPE_CS);
		createEAttribute(tupleTypeCSEClass, TUPLE_TYPE_CS__NAME);
		createEReference(tupleTypeCSEClass, TUPLE_TYPE_CS__OWNED_PARTS);

		typeCSEClass = createEClass(TYPE_CS);

		typeParameterCSEClass = createEClass(TYPE_PARAMETER_CS);
		createEReference(typeParameterCSEClass, TYPE_PARAMETER_CS__OWNED_EXTENDS);
		createEReference(typeParameterCSEClass, TYPE_PARAMETER_CS__OWNED_SUPER);

		typeRefCSEClass = createEClass(TYPE_REF_CS);

		typedElementCSEClass = createEClass(TYPED_ELEMENT_CS);
		createEReference(typedElementCSEClass, TYPED_ELEMENT_CS__OWNED_TYPE);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__QUALIFIER);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__OPTIONAL);

		typedRefCSEClass = createEClass(TYPED_REF_CS);
		createEReference(typedRefCSEClass, TYPED_REF_CS__MULTIPLICITY);

		typedTypeRefCSEClass = createEClass(TYPED_TYPE_REF_CS);
		createEReference(typedTypeRefCSEClass, TYPED_TYPE_REF_CS__PATH_NAME);
		createEReference(typedTypeRefCSEClass, TYPED_TYPE_REF_CS__TYPE);
		createEReference(typedTypeRefCSEClass, TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING);

		visitableCSEClass = createEClass(VISITABLE_CS);

		wildcardTypeRefCSEClass = createEClass(WILDCARD_TYPE_REF_CS);
		createEReference(wildcardTypeRefCSEClass, WILDCARD_TYPE_REF_CS__EXTENDS);
		createEReference(wildcardTypeRefCSEClass, WILDCARD_TYPE_REF_CS__SUPER);

		// Create enums
		iteratorKindEEnum = createEEnum(ITERATOR_KIND);

		// Create data types
		scopeFilterEDataType = createEDataType(SCOPE_FILTER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		annotationCSEClass.getESuperTypes().add(this.getAnnotationElementCS());
		annotationElementCSEClass.getESuperTypes().add(this.getNamedElementCS());
		attributeCSEClass.getESuperTypes().add(this.getStructuralFeatureCS());
		classCSEClass.getESuperTypes().add(this.getClassifierCS());
		classCSEClass.getESuperTypes().add(this.getNamespaceCS());
		classifierCSEClass.getESuperTypes().add(this.getNamedElementCS());
		classifierCSEClass.getESuperTypes().add(this.getTypeCS());
		classifierCSEClass.getESuperTypes().add(this.getTemplateableElementCS());
		constraintCSEClass.getESuperTypes().add(this.getNamedElementCS());
		dataTypeCSEClass.getESuperTypes().add(this.getClassifierCS());
		dataTypeCSEClass.getESuperTypes().add(this.getNamespaceCS());
		detailCSEClass.getESuperTypes().add(this.getNamedElementCS());
		documentationCSEClass.getESuperTypes().add(this.getAnnotationElementCS());
		elementCSEClass.getESuperTypes().add(this.getVisitableCS());
		elementRefCSEClass.getESuperTypes().add(this.getPivotableElementCS());
		enumerationCSEClass.getESuperTypes().add(this.getClassifierCS());
		enumerationCSEClass.getESuperTypes().add(this.getNamespaceCS());
		enumerationLiteralCSEClass.getESuperTypes().add(this.getNamedElementCS());
		featureCSEClass.getESuperTypes().add(this.getTypedElementCS());
		importCSEClass.getESuperTypes().add(this.getNamespaceCS());
		lambdaTypeCSEClass.getESuperTypes().add(this.getTypedRefCS());
		lambdaTypeCSEClass.getESuperTypes().add(this.getTemplateableElementCS());
		lambdaTypeCSEClass.getESuperTypes().add(thePivotPackage.getNameable());
		libraryCSEClass.getESuperTypes().add(this.getNamespaceCS());
		modelElementCSEClass.getESuperTypes().add(this.getPivotableElementCS());
		modelElementRefCSEClass.getESuperTypes().add(this.getElementRefCS());
		multiplicityBoundsCSEClass.getESuperTypes().add(this.getMultiplicityCS());
		multiplicityCSEClass.getESuperTypes().add(this.getElementCS());
		multiplicityStringCSEClass.getESuperTypes().add(this.getMultiplicityCS());
		namedElementCSEClass.getESuperTypes().add(this.getModelElementCS());
		namedElementCSEClass.getESuperTypes().add(thePivotPackage.getNameable());
		namespaceCSEClass.getESuperTypes().add(this.getNamedElementCS());
		operationCSEClass.getESuperTypes().add(this.getFeatureCS());
		operationCSEClass.getESuperTypes().add(this.getTemplateableElementCS());
		packageCSEClass.getESuperTypes().add(this.getPackageOwnerCS());
		packageCSEClass.getESuperTypes().add(this.getNamespaceCS());
		packageOwnerCSEClass.getESuperTypes().add(this.getModelElementCS());
		parameterCSEClass.getESuperTypes().add(this.getTypedElementCS());
		pathElementCSEClass.getESuperTypes().add(this.getElementCS());
		pathElementCSEClass.getESuperTypes().add(thePivotPackage.getPivotable());
		pathElementWithURICSEClass.getESuperTypes().add(this.getPathElementCS());
		pathNameCSEClass.getESuperTypes().add(this.getElementCS());
		pathNameCSEClass.getESuperTypes().add(thePivotPackage.getPivotable());
		pivotableElementCSEClass.getESuperTypes().add(this.getElementCS());
		pivotableElementCSEClass.getESuperTypes().add(thePivotPackage.getPivotable());
		primitiveTypeRefCSEClass.getESuperTypes().add(this.getTypedRefCS());
		primitiveTypeRefCSEClass.getESuperTypes().add(thePivotPackage.getNameable());
		referenceCSEClass.getESuperTypes().add(this.getStructuralFeatureCS());
		rootCSEClass.getESuperTypes().add(this.getModelElementCS());
		rootPackageCSEClass.getESuperTypes().add(this.getPackageOwnerCS());
		rootPackageCSEClass.getESuperTypes().add(this.getRootCS());
		specificationCSEClass.getESuperTypes().add(this.getModelElementCS());
		structuralFeatureCSEClass.getESuperTypes().add(this.getFeatureCS());
		templateBindingCSEClass.getESuperTypes().add(this.getElementRefCS());
		templateParameterCSEClass.getESuperTypes().add(this.getNamedElementCS());
		templateParameterSubstitutionCSEClass.getESuperTypes().add(this.getModelElementCS());
		templateSignatureCSEClass.getESuperTypes().add(this.getModelElementCS());
		templateableElementCSEClass.getESuperTypes().add(this.getElementCS());
		tuplePartCSEClass.getESuperTypes().add(this.getTypedElementCS());
		tupleTypeCSEClass.getESuperTypes().add(this.getTypedRefCS());
		tupleTypeCSEClass.getESuperTypes().add(thePivotPackage.getNameable());
		typeCSEClass.getESuperTypes().add(this.getModelElementCS());
		typeParameterCSEClass.getESuperTypes().add(this.getTemplateParameterCS());
		typeParameterCSEClass.getESuperTypes().add(this.getTypeCS());
		typeRefCSEClass.getESuperTypes().add(this.getElementRefCS());
		typedElementCSEClass.getESuperTypes().add(this.getNamedElementCS());
		typedRefCSEClass.getESuperTypes().add(this.getTypeRefCS());
		typedTypeRefCSEClass.getESuperTypes().add(this.getTypedRefCS());
		wildcardTypeRefCSEClass.getESuperTypes().add(this.getTypeRefCS());

		// Initialize classes and features; add operations and parameters
		initEClass(annotationCSEClass, AnnotationCS.class, "AnnotationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAnnotationCS_OwnedContent(), this.getModelElementCS(), null, "ownedContent", null, 0, -1, AnnotationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnnotationCS_OwnedReference(), this.getModelElementRefCS(), null, "ownedReference", null, 0, -1, AnnotationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(annotationElementCSEClass, AnnotationElementCS.class, "AnnotationElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAnnotationElementCS_OwnedDetail(), this.getDetailCS(), null, "ownedDetail", null, 0, -1, AnnotationElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(attributeCSEClass, AttributeCS.class, "AttributeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(classCSEClass, ClassCS.class, "ClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getClassCS_OwnedSuperType(), this.getTypedRefCS(), null, "ownedSuperType", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassCS_OwnedOperation(), this.getOperationCS(), this.getOperationCS_OwningClass(), "ownedOperation", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassCS_OwnedProperty(), this.getStructuralFeatureCS(), this.getStructuralFeatureCS_Owner(), "ownedProperty", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassCS_OwnedMetaType(), this.getTypedRefCS(), null, "ownedMetaType", null, 0, 1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(classifierCSEClass, ClassifierCS.class, "ClassifierCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getClassifierCS_Owner(), this.getPackageCS(), this.getPackageCS_OwnedType(), "owner", null, 0, 1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getClassifierCS_InstanceClassName(), ecorePackage.getEString(), "instanceClassName", null, 0, 1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassifierCS_OwnedConstraint(), this.getConstraintCS(), null, "ownedConstraint", null, 0, -1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getClassifierCS_Qualifier(), ecorePackage.getEString(), "qualifier", null, 0, -1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(classifierCSEClass, thePivotPackage.getType(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(constraintCSEClass, ConstraintCS.class, "ConstraintCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getConstraintCS_Stereotype(), ecorePackage.getEString(), "stereotype", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getConstraintCS_Specification(), this.getSpecificationCS(), null, "specification", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getConstraintCS_MessageSpecification(), this.getSpecificationCS(), null, "messageSpecification", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(dataTypeCSEClass, DataTypeCS.class, "DataTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDataTypeCS_Literals(), this.getEnumerationLiteralCS(), null, "literals", null, 0, -1, DataTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(detailCSEClass, DetailCS.class, "DetailCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDetailCS_Value(), ecorePackage.getEString(), "value", null, 0, -1, DetailCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(documentationCSEClass, DocumentationCS.class, "DocumentationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDocumentationCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, DocumentationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(elementCSEClass, ElementCS.class, "ElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getElementCS_LogicalParent(), this.getElementCS(), null, "logicalParent", null, 0, 1, ElementCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(elementCSEClass, ecorePackage.getEString(), "getDescription", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(elementRefCSEClass, ElementRefCS.class, "ElementRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(enumerationCSEClass, EnumerationCS.class, "EnumerationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEnumerationCS_OwnedLiterals(), this.getEnumerationLiteralCS(), null, "ownedLiterals", null, 0, -1, EnumerationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(enumerationCSEClass, thePivotPackage.getEnumeration(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(enumerationLiteralCSEClass, EnumerationLiteralCS.class, "EnumerationLiteralCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getEnumerationLiteralCS_Value(), ecorePackage.getEInt(), "value", null, 0, 1, EnumerationLiteralCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(enumerationLiteralCSEClass, thePivotPackage.getEnumerationLiteral(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(featureCSEClass, FeatureCS.class, "FeatureCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(importCSEClass, ImportCS.class, "ImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getImportCS_PathName(), this.getPathNameCS(), null, "pathName", null, 0, 1, ImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getImportCS_Namespace(), thePivotPackage.getNamespace(), null, "namespace", null, 0, 1, ImportCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getImportCS_All(), ecorePackage.getEBoolean(), "all", "false", 0, 1, ImportCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(lambdaTypeCSEClass, LambdaTypeCS.class, "LambdaTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLambdaTypeCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, LambdaTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLambdaTypeCS_OwnedContextType(), this.getTypedRefCS(), null, "ownedContextType", null, 0, 1, LambdaTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLambdaTypeCS_OwnedParameterType(), this.getTypedRefCS(), null, "ownedParameterType", null, 0, -1, LambdaTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLambdaTypeCS_OwnedResultType(), this.getTypedRefCS(), null, "ownedResultType", null, 0, 1, LambdaTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(libraryCSEClass, LibraryCS.class, "LibraryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLibraryCS_Package(), thePivotPackage.getNamespace(), null, "package", null, 0, 1, LibraryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modelElementCSEClass, ModelElementCS.class, "ModelElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getModelElementCS_OwnedAnnotation(), this.getAnnotationElementCS(), null, "ownedAnnotation", null, 0, -1, ModelElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getModelElementCS_OriginalXmiId(), ecorePackage.getEString(), "originalXmiId", null, 0, 1, ModelElementCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getModelElementCS_Csi(), ecorePackage.getEString(), "csi", null, 0, 1, ModelElementCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modelElementRefCSEClass, ModelElementRefCS.class, "ModelElementRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getModelElementRefCS_PathName(), this.getPathNameCS(), null, "pathName", null, 0, 1, ModelElementRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModelElementRefCS_Element(), thePivotPackage.getElement(), null, "element", null, 0, 1, ModelElementRefCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(multiplicityBoundsCSEClass, MultiplicityBoundsCS.class, "MultiplicityBoundsCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMultiplicityBoundsCS_LowerBound(), ecorePackage.getEInt(), "lowerBound", "1", 0, 1, MultiplicityBoundsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getMultiplicityBoundsCS_UpperBound(), ecorePackage.getEIntegerObject(), "upperBound", null, 0, 1, MultiplicityBoundsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(multiplicityCSEClass, MultiplicityCS.class, "MultiplicityCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(multiplicityCSEClass, ecorePackage.getEInt(), "getLower", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(multiplicityCSEClass, ecorePackage.getEInt(), "getUpper", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(multiplicityStringCSEClass, MultiplicityStringCS.class, "MultiplicityStringCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMultiplicityStringCS_StringBounds(), ecorePackage.getEString(), "stringBounds", "1", 0, 1, MultiplicityStringCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(namedElementCSEClass, NamedElementCS.class, "NamedElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getNamedElementCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(namespaceCSEClass, NamespaceCS.class, "NamespaceCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(operationCSEClass, OperationCS.class, "OperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOperationCS_OwningClass(), this.getClassCS(), this.getClassCS_OwnedOperation(), "owningClass", null, 0, 1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationCS_OwnedParameter(), this.getParameterCS(), this.getParameterCS_Owner(), "ownedParameter", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationCS_OwnedException(), this.getTypedRefCS(), null, "ownedException", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationCS_OwnedPrecondition(), this.getConstraintCS(), null, "ownedPrecondition", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationCS_OwnedPostcondition(), this.getConstraintCS(), null, "ownedPostcondition", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationCS_OwnedBodyExpression(), this.getSpecificationCS(), null, "ownedBodyExpression", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(operationCSEClass, thePivotPackage.getOperation(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(packageCSEClass, PackageCS.class, "PackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPackageCS_OwnedType(), this.getClassifierCS(), this.getClassifierCS_Owner(), "ownedType", null, 0, -1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPackageCS_NsPrefix(), ecorePackage.getEString(), "nsPrefix", null, 0, 1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPackageCS_NsURI(), ecorePackage.getEString(), "nsURI", null, 0, 1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(packageCSEClass, thePivotPackage.getPackage(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(packageCSEClass, this.getClassifierCS(), "getClassifier", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(packageOwnerCSEClass, PackageOwnerCS.class, "PackageOwnerCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPackageOwnerCS_OwnedNestedPackage(), this.getPackageCS(), null, "ownedNestedPackage", null, 0, -1, PackageOwnerCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(parameterCSEClass, ParameterCS.class, "ParameterCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getParameterCS_Owner(), this.getOperationCS(), this.getOperationCS_OwnedParameter(), "owner", null, 0, 1, ParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(parameterCSEClass, thePivotPackage.getParameter(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(pathElementCSEClass, PathElementCS.class, "PathElementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPathElementCS_PathName(), this.getPathNameCS(), this.getPathNameCS_Path(), "pathName", null, 1, 1, PathElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPathElementCS_Element(), thePivotPackage.getElement(), null, "element", null, 1, 1, PathElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPathElementCS_ElementType(), ecorePackage.getEClassifier(), null, "elementType", null, 0, 1, PathElementCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(pathElementWithURICSEClass, PathElementWithURICS.class, "PathElementWithURICS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getPathElementWithURICS_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, PathElementWithURICS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(pathNameCSEClass, PathNameCS.class, "PathNameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPathNameCS_Path(), this.getPathElementCS(), this.getPathElementCS_PathName(), "path", null, 1, -1, PathNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPathNameCS_Element(), thePivotPackage.getElement(), null, "element", null, 1, 1, PathNameCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPathNameCS_Context(), this.getElementCS(), null, "context", null, 0, 1, PathNameCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPathNameCS_ScopeFilter(), this.getScopeFilter(), "scopeFilter", null, 0, 1, PathNameCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(pivotableElementCSEClass, PivotableElementCS.class, "PivotableElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPivotableElementCS_Pivot(), thePivotPackage.getElement(), null, "pivot", null, 0, 1, PivotableElementCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(primitiveTypeRefCSEClass, PrimitiveTypeRefCS.class, "PrimitiveTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getPrimitiveTypeRefCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, PrimitiveTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(referenceCSEClass, ReferenceCS.class, "ReferenceCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getReferenceCS_Opposite(), thePivotPackage.getProperty(), null, "opposite", null, 0, 1, ReferenceCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getReferenceCS_Keys(), thePivotPackage.getProperty(), null, "keys", null, 0, -1, ReferenceCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(rootCSEClass, RootCS.class, "RootCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getRootCS_OwnedImport(), this.getImportCS(), null, "ownedImport", null, 0, -1, RootCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getRootCS_OwnedLibrary(), this.getLibraryCS(), null, "ownedLibrary", null, 0, -1, RootCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(rootPackageCSEClass, RootPackageCS.class, "RootPackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(specificationCSEClass, SpecificationCS.class, "SpecificationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSpecificationCS_ExprString(), ecorePackage.getEString(), "exprString", null, 0, 1, SpecificationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(structuralFeatureCSEClass, StructuralFeatureCS.class, "StructuralFeatureCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getStructuralFeatureCS_Owner(), this.getClassCS(), this.getClassCS_OwnedProperty(), "owner", null, 0, 1, StructuralFeatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getStructuralFeatureCS_Default(), ecorePackage.getEString(), "default", null, 0, 1, StructuralFeatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getStructuralFeatureCS_OwnedDefaultExpression(), this.getSpecificationCS(), null, "ownedDefaultExpression", null, 0, -1, StructuralFeatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(structuralFeatureCSEClass, thePivotPackage.getProperty(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(templateBindingCSEClass, TemplateBindingCS.class, "TemplateBindingCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTemplateBindingCS_OwningTemplateBindableElement(), this.getTypedTypeRefCS(), this.getTypedTypeRefCS_OwnedTemplateBinding(), "owningTemplateBindableElement", null, 0, 1, TemplateBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplateBindingCS_OwnedParameterSubstitution(), this.getTemplateParameterSubstitutionCS(), this.getTemplateParameterSubstitutionCS_OwningTemplateBinding(), "ownedParameterSubstitution", null, 0, -1, TemplateBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(templateParameterCSEClass, TemplateParameterCS.class, "TemplateParameterCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTemplateParameterCS_OwningTemplateSignature(), this.getTemplateSignatureCS(), this.getTemplateSignatureCS_OwnedTemplateParameter(), "owningTemplateSignature", null, 1, 1, TemplateParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(templateParameterSubstitutionCSEClass, TemplateParameterSubstitutionCS.class, "TemplateParameterSubstitutionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTemplateParameterSubstitutionCS_OwningTemplateBinding(), this.getTemplateBindingCS(), this.getTemplateBindingCS_OwnedParameterSubstitution(), "owningTemplateBinding", null, 0, 1, TemplateParameterSubstitutionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplateParameterSubstitutionCS_OwnedActualParameter(), this.getTypeRefCS(), null, "ownedActualParameter", null, 0, 1, TemplateParameterSubstitutionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(templateSignatureCSEClass, TemplateSignatureCS.class, "TemplateSignatureCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTemplateSignatureCS_OwningTemplateElement(), this.getTemplateableElementCS(), this.getTemplateableElementCS_OwnedTemplateSignature(), "owningTemplateElement", null, 0, 1, TemplateSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplateSignatureCS_OwnedTemplateParameter(), this.getTemplateParameterCS(), this.getTemplateParameterCS_OwningTemplateSignature(), "ownedTemplateParameter", null, 0, -1, TemplateSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(templateableElementCSEClass, TemplateableElementCS.class, "TemplateableElementCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTemplateableElementCS_OwnedTemplateSignature(), this.getTemplateSignatureCS(), this.getTemplateSignatureCS_OwningTemplateElement(), "ownedTemplateSignature", null, 0, 1, TemplateableElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tuplePartCSEClass, TuplePartCS.class, "TuplePartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(tupleTypeCSEClass, TupleTypeCS.class, "TupleTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTupleTypeCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, TupleTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTupleTypeCS_OwnedParts(), this.getTuplePartCS(), null, "ownedParts", null, 0, -1, TupleTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeCSEClass, TypeCS.class, "TypeCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(typeParameterCSEClass, TypeParameterCS.class, "TypeParameterCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypeParameterCS_OwnedExtends(), this.getTypedRefCS(), null, "ownedExtends", null, 0, -1, TypeParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeParameterCS_OwnedSuper(), this.getTypedRefCS(), null, "ownedSuper", null, 0, 1, TypeParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeRefCSEClass, TypeRefCS.class, "TypeRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(typedElementCSEClass, TypedElementCS.class, "TypedElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypedElementCS_OwnedType(), this.getTypedRefCS(), null, "ownedType", null, 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTypedElementCS_Qualifier(), ecorePackage.getEString(), "qualifier", null, 0, -1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTypedElementCS_Optional(), ecorePackage.getEBoolean(), "optional", null, 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typedRefCSEClass, TypedRefCS.class, "TypedRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypedRefCS_Multiplicity(), this.getMultiplicityCS(), null, "multiplicity", null, 0, 1, TypedRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typedTypeRefCSEClass, TypedTypeRefCS.class, "TypedTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypedTypeRefCS_PathName(), this.getPathNameCS(), null, "pathName", null, 0, 1, TypedTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypedTypeRefCS_Type(), thePivotPackage.getType(), null, "type", null, 0, 1, TypedTypeRefCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypedTypeRefCS_OwnedTemplateBinding(), this.getTemplateBindingCS(), this.getTemplateBindingCS_OwningTemplateBindableElement(), "ownedTemplateBinding", null, 0, 1, TypedTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(visitableCSEClass, VisitableCS.class, "VisitableCS", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wildcardTypeRefCSEClass, WildcardTypeRefCS.class, "WildcardTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getWildcardTypeRefCS_Extends(), this.getTypedRefCS(), null, "extends", null, 0, 1, WildcardTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWildcardTypeRefCS_Super(), this.getTypedRefCS(), null, "super", null, 0, 1, WildcardTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(iteratorKindEEnum, IteratorKind.class, "IteratorKind"); //$NON-NLS-1$
		addEEnumLiteral(iteratorKindEEnum, IteratorKind.PARAMETER);
		addEEnumLiteral(iteratorKindEEnum, IteratorKind.ITERATOR);
		addEEnumLiteral(iteratorKindEEnum, IteratorKind.ACCUMULATOR);

		// Initialize data types
		initEDataType(scopeFilterEDataType, ScopeFilter.class, "ScopeFilter", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL
		createOCLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations()
	{
		String source = "http://www.eclipse.org/OCL/Import"; //$NON-NLS-1$	
		addAnnotation
		  (this, 
		   source, 
		   new String[] 
		   {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore", //$NON-NLS-1$ //$NON-NLS-2$
			 "pivot", "../../org.eclipse.ocl.examples.pivot/model/Pivot.ecore#/" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations()
	{
		String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$	
		addAnnotation
		  (this, 
		   source, 
		   new String[] 
		   {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL", //$NON-NLS-1$ //$NON-NLS-2$
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL", //$NON-NLS-1$ //$NON-NLS-2$
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL" //$NON-NLS-1$ //$NON-NLS-2$
		   });	
		addAnnotation
		  (rootCSEClass, 
		   source, 
		   new String[] 
		   {
			 "constraints", "TestConstraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });	
		addAnnotation
		  (rootPackageCSEClass, 
		   source, 
		   new String[] 
		   {
			 "constraints", "TestConstraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOCLAnnotations()
	{
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL"; //$NON-NLS-1$	
		addAnnotation
		  (classifierCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] 
		   {
			 "body", "pivot" //$NON-NLS-1$ //$NON-NLS-2$
		   });	
		addAnnotation
		  (enumerationCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] 
		   {
			 "body", "ocl::Enumeration {\n\t\t\t\tname = name,\n\t\t\t\townedLiteral = ownedLiterals.ast()\n\t\t\t}" //$NON-NLS-1$ //$NON-NLS-2$
		   });	
		addAnnotation
		  (enumerationLiteralCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] 
		   {
			 "body", "ocl::EnumerationLiteral {\n\t\t\t\tname = name\n\t\t\t}" //$NON-NLS-1$ //$NON-NLS-2$
		   });	
		addAnnotation
		  (operationCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] 
		   {
			 "body", "ocl::Operation {\n\t\t\t\t-- TODO\n\t\t\t\tname = name\n\t\t\t}" //$NON-NLS-1$ //$NON-NLS-2$
		   });	
		addAnnotation
		  (packageCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] 
		   {
			 "body", "ocl::Package{\n\t\t\t\t-- TODO\n\t\t\t\tname = name,\n\t\t\t\tnestedPackage = ownedNestedPackage.ast()\n\t\t\t}" //$NON-NLS-1$ //$NON-NLS-2$
		   });	
		addAnnotation
		  (parameterCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] 
		   {
			 "body", "ocl::Parameter {\n\t\t\t\t-- TODO\n\t\t\t\tname = name\n\t\t\t}" //$NON-NLS-1$ //$NON-NLS-2$
		   });	
		addAnnotation
		  (rootCSEClass, 
		   source, 
		   new String[] 
		   {
			 "TestConstraint", "true" //$NON-NLS-1$ //$NON-NLS-2$
		   });	
		addAnnotation
		  (rootPackageCSEClass, 
		   source, 
		   new String[] 
		   {
			 "TestConstraint", "true" //$NON-NLS-1$ //$NON-NLS-2$
		   });	
		addAnnotation
		  (structuralFeatureCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] 
		   {
			 "body", "ocl::Property{\n\t\t\t\t-- TODO\n\t\t\t\tname = name\n\t\t\t}" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //BaseCSPackageImpl
