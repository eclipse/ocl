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
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AssociationClassCallExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CallExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSFactory;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfThenExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterateCallExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterationCallExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LambdaLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperationCallExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PatternExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PropertyCallExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EssentialOCLCSPackageImpl
		extends EPackageImpl
		implements EssentialOCLCSPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractNameExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationClassCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prefixExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructorExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructorPartCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass curlyBracketedClauseCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expSpecificationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeNameExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unlimitedNaturalLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum navigationRoleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigatingArgCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nestedExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionLiteralPartCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionPatternCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roundBracketedClauseCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selfExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass squareBracketedClauseCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleLiteralPartCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invalidLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterateCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterationCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lambdaLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifThenExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass infixExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass letExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass letVariableCSEClass = null;

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
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EssentialOCLCSPackageImpl() {
		super(eNS_URI, EssentialOCLCSFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EssentialOCLCSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EssentialOCLCSPackage init() {
		if (isInited) return (EssentialOCLCSPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSPackage.eNS_URI);

		// Obtain or create and register package
		EssentialOCLCSPackageImpl theEssentialOCLCSPackage = (EssentialOCLCSPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EssentialOCLCSPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EssentialOCLCSPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BaseCSPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEssentialOCLCSPackage.createPackageContents();

		// Initialize created meta-data
		theEssentialOCLCSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEssentialOCLCSPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EssentialOCLCSPackage.eNS_URI, theEssentialOCLCSPackage);
		return theEssentialOCLCSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractNameExpCS()
	{
		return abstractNameExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNameExpCS_OwnedPathName()
	{
		return (EReference)abstractNameExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameExpCS_IsPre()
	{
		return (EAttribute)abstractNameExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNameExpCS_OwnedCurlyBracketedClause()
	{
		return (EReference)abstractNameExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNameExpCS_OwnedRoundBracketedClause()
	{
		return (EReference)abstractNameExpCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNameExpCS_OwnedSquareBracketedClauses()
	{
		return (EReference)abstractNameExpCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNameExpCS_SourceType()
	{
		return (EReference)abstractNameExpCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNameExpCS_SourceTypeValue()
	{
		return (EReference)abstractNameExpCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationClassCallExpCS()
	{
		return associationClassCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationClassCallExpCS_ReferredAssociation()
	{
		return (EReference)associationClassCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrefixExpCS() {
		return prefixExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionTypeCS() {
		return collectionTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionTypeCS_Name() {
		return (EAttribute)collectionTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTypeCS_OwnedType() {
		return (EReference)collectionTypeCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructorExpCS()
	{
		return constructorExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstructorExpCS_TypeName()
	{
		return (EReference)constructorExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstructorExpCS_Parts()
	{
		return (EReference)constructorExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstructorExpCS_Value()
	{
		return (EAttribute)constructorExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructorPartCS() {
		return constructorPartCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstructorPartCS_OwningCurlyBracketClause()
	{
		return (EReference)constructorPartCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstructorPartCS_ReferredProperty()
	{
		return (EReference)constructorPartCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstructorPartCS_OwnedInitExpression()
	{
		return (EReference)constructorPartCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextCS() {
		return contextCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextCS_OwnedExpression() {
		return (EReference)contextCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCurlyBracketedClauseCS()
	{
		return curlyBracketedClauseCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCurlyBracketedClauseCS_OwningNameExp()
	{
		return (EReference)curlyBracketedClauseCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCurlyBracketedClauseCS_OwnedParts()
	{
		return (EReference)curlyBracketedClauseCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCurlyBracketedClauseCS_Value()
	{
		return (EAttribute)curlyBracketedClauseCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpCS() {
		return expCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpCS_Parent() {
		return (EReference)expCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpCS_HasError()
	{
		return (EAttribute)expCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpSpecificationCS() {
		return expSpecificationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpSpecificationCS_OwnedExpression() {
		return (EReference)expSpecificationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeLiteralExpCS() {
		return typeLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeLiteralExpCS_OwnedPathName()
	{
		return (EReference)typeLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeLiteralExpCS_OwnedType() {
		return (EReference)typeLiteralExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeNameExpCS() {
		return typeNameExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeNameExpCS_OwnedPathName()
	{
		return (EReference)typeNameExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeNameExpCS_Element() {
		return (EReference)typeNameExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeNameExpCS_OwnedCurlyBracketedClause()
	{
		return (EReference)typeNameExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeNameExpCS_OwnedPatternGuard()
	{
		return (EReference)typeNameExpCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnlimitedNaturalLiteralExpCS() {
		return unlimitedNaturalLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableCS() {
		return variableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableCS_OwnedType() {
		return (EReference)variableCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableCS_OwnedInitExpression()
	{
		return (EReference)variableCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableExpCS()
	{
		return variableExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableExpCS_ReferredVariable()
	{
		return (EReference)variableExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNavigationRole() {
		return navigationRoleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteralExpCS() {
		return literalExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameExpCS() {
		return nameExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNavigatingArgCS() {
		return navigatingArgCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNavigatingArgCS_OwningRoundBracketedClause()
	{
		return (EReference)navigatingArgCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigatingArgCS_Role() {
		return (EAttribute)navigatingArgCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigatingArgCS_Prefix() {
		return (EAttribute)navigatingArgCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNavigatingArgCS_OwnedNameExpression()
	{
		return (EReference)navigatingArgCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNavigatingArgCS_OwnedType() {
		return (EReference)navigatingArgCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNavigatingArgCS_OwnedInitExpression()
	{
		return (EReference)navigatingArgCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNestedExpCS() {
		return nestedExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNestedExpCS_Source() {
		return (EReference)nestedExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionLiteralExpCS() {
		return collectionLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionLiteralExpCS_OwnedType() {
		return (EReference)collectionLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionLiteralExpCS_OwnedParts() {
		return (EReference)collectionLiteralExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionLiteralPartCS() {
		return collectionLiteralPartCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionLiteralPartCS_OwnedExpression()
	{
		return (EReference)collectionLiteralPartCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionLiteralPartCS_OwnedLastExpression()
	{
		return (EReference)collectionLiteralPartCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionPatternCS()
	{
		return collectionPatternCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionPatternCS_OwnedType()
	{
		return (EReference)collectionPatternCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionPatternCS_OwnedParts()
	{
		return (EReference)collectionPatternCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionPatternCS_RestVariableName()
	{
		return (EAttribute)collectionPatternCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionPatternCS_OwnedPatternGuard()
	{
		return (EReference)collectionPatternCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveLiteralExpCS() {
		return primitiveLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyCallExpCS()
	{
		return propertyCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyCallExpCS_ReferredProperty()
	{
		return (EReference)propertyCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoundBracketedClauseCS()
	{
		return roundBracketedClauseCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoundBracketedClauseCS_OwningNameExp()
	{
		return (EReference)roundBracketedClauseCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoundBracketedClauseCS_OwnedArguments()
	{
		return (EReference)roundBracketedClauseCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelfExpCS() {
		return selfExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelfExpCS_Name() {
		return (EAttribute)selfExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSquareBracketedClauseCS()
	{
		return squareBracketedClauseCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSquareBracketedClauseCS_OwningNameExp()
	{
		return (EReference)squareBracketedClauseCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSquareBracketedClauseCS_OwnedTerms()
	{
		return (EReference)squareBracketedClauseCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTupleLiteralExpCS() {
		return tupleLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTupleLiteralExpCS_OwnedParts() {
		return (EReference)tupleLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTupleLiteralPartCS() {
		return tupleLiteralPartCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringLiteralExpCS() {
		return stringLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringLiteralExpCS_Segments()
	{
		return (EAttribute)stringLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanLiteralExpCS() {
		return booleanLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanLiteralExpCS_Symbol()
	{
		return (EAttribute)booleanLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallExpCS()
	{
		return callExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallExpCS_Source()
	{
		return (EReference)callExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallExpCS_Arguments()
	{
		return (EReference)callExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvalidLiteralExpCS() {
		return invalidLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterateCallExpCS()
	{
		return iterateCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterateCallExpCS_Accumulators()
	{
		return (EReference)iterateCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterationCallExpCS()
	{
		return iterationCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterationCallExpCS_ReferredIteration()
	{
		return (EReference)iterationCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterationCallExpCS_Iterators()
	{
		return (EReference)iterationCallExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLambdaLiteralExpCS()
	{
		return lambdaLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLambdaLiteralExpCS_OwnedExpressionCS()
	{
		return (EReference)lambdaLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNullLiteralExpCS() {
		return nullLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberLiteralExpCS() {
		return numberLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberLiteralExpCS_Symbol()
	{
		return (EAttribute)numberLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationCallExpCS()
	{
		return operationCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCallExpCS_ReferredOperation()
	{
		return (EReference)operationCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorExpCS()
	{
		return operatorExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorExpCS_OwnedSource()
	{
		return (EReference)operatorExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorExpCS_Source()
	{
		return (EReference)operatorExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorExpCS_DerivedSource()
	{
		return (EReference)operatorExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorExpCS_DerivedParent()
	{
		return (EReference)operatorExpCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternExpCS()
	{
		return patternExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPatternExpCS_PatternVariableName()
	{
		return (EAttribute)patternExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternExpCS_OwnedPatternType()
	{
		return (EReference)patternExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EssentialOCLCSFactory getEssentialOCLCSFactory() {
		return (EssentialOCLCSFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfExpCS() {
		return ifExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpCS_OwnedCondition()
	{
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpCS_OwnedThenExpression()
	{
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpCS_OwnedIfThenExpressions()
	{
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpCS_OwnedElseExpression()
	{
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfExpCS_IsImplicit()
	{
		return (EAttribute)ifExpCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfThenExpCS()
	{
		return ifThenExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfThenExpCS_OwnedCondition()
	{
		return (EReference)ifThenExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfThenExpCS_OwnedThenExpression()
	{
		return (EReference)ifThenExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfixExpCS() {
		return infixExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInfixExpCS_OwnedArgument()
	{
		return (EReference)infixExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInfixExpCS_DerivedArgument()
	{
		return (EReference)infixExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInfixExpCS_Argument()
	{
		return (EReference)infixExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLetExpCS() {
		return letExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLetExpCS_OwnedVariables()
	{
		return (EReference)letExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLetExpCS_OwnedInExpression()
	{
		return (EReference)letExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLetExpCS_IsImplicit()
	{
		return (EAttribute)letExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLetVariableCS() {
		return letVariableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLetVariableCS_OwningLetExpression()
	{
		return (EReference)letVariableCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLetVariableCS_OwnedRoundBracketedClause()
	{
		return (EReference)letVariableCSEClass.getEStructuralFeatures().get(1);
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
		abstractNameExpCSEClass = createEClass(ABSTRACT_NAME_EXP_CS);
		createEReference(abstractNameExpCSEClass, ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME);
		createEAttribute(abstractNameExpCSEClass, ABSTRACT_NAME_EXP_CS__IS_PRE);
		createEReference(abstractNameExpCSEClass, ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE);
		createEReference(abstractNameExpCSEClass, ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE);
		createEReference(abstractNameExpCSEClass, ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES);
		createEReference(abstractNameExpCSEClass, ABSTRACT_NAME_EXP_CS__SOURCE_TYPE);
		createEReference(abstractNameExpCSEClass, ABSTRACT_NAME_EXP_CS__SOURCE_TYPE_VALUE);

		associationClassCallExpCSEClass = createEClass(ASSOCIATION_CLASS_CALL_EXP_CS);
		createEReference(associationClassCallExpCSEClass, ASSOCIATION_CLASS_CALL_EXP_CS__REFERRED_ASSOCIATION);

		booleanLiteralExpCSEClass = createEClass(BOOLEAN_LITERAL_EXP_CS);
		createEAttribute(booleanLiteralExpCSEClass, BOOLEAN_LITERAL_EXP_CS__SYMBOL);

		callExpCSEClass = createEClass(CALL_EXP_CS);
		createEReference(callExpCSEClass, CALL_EXP_CS__SOURCE);
		createEReference(callExpCSEClass, CALL_EXP_CS__ARGUMENTS);

		collectionLiteralExpCSEClass = createEClass(COLLECTION_LITERAL_EXP_CS);
		createEReference(collectionLiteralExpCSEClass, COLLECTION_LITERAL_EXP_CS__OWNED_TYPE);
		createEReference(collectionLiteralExpCSEClass, COLLECTION_LITERAL_EXP_CS__OWNED_PARTS);

		collectionLiteralPartCSEClass = createEClass(COLLECTION_LITERAL_PART_CS);
		createEReference(collectionLiteralPartCSEClass, COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION);
		createEReference(collectionLiteralPartCSEClass, COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION);

		collectionPatternCSEClass = createEClass(COLLECTION_PATTERN_CS);
		createEReference(collectionPatternCSEClass, COLLECTION_PATTERN_CS__OWNED_TYPE);
		createEReference(collectionPatternCSEClass, COLLECTION_PATTERN_CS__OWNED_PARTS);
		createEAttribute(collectionPatternCSEClass, COLLECTION_PATTERN_CS__REST_VARIABLE_NAME);
		createEReference(collectionPatternCSEClass, COLLECTION_PATTERN_CS__OWNED_PATTERN_GUARD);

		collectionTypeCSEClass = createEClass(COLLECTION_TYPE_CS);
		createEAttribute(collectionTypeCSEClass, COLLECTION_TYPE_CS__NAME);
		createEReference(collectionTypeCSEClass, COLLECTION_TYPE_CS__OWNED_TYPE);

		constructorExpCSEClass = createEClass(CONSTRUCTOR_EXP_CS);
		createEReference(constructorExpCSEClass, CONSTRUCTOR_EXP_CS__TYPE_NAME);
		createEReference(constructorExpCSEClass, CONSTRUCTOR_EXP_CS__PARTS);
		createEAttribute(constructorExpCSEClass, CONSTRUCTOR_EXP_CS__VALUE);

		constructorPartCSEClass = createEClass(CONSTRUCTOR_PART_CS);
		createEReference(constructorPartCSEClass, CONSTRUCTOR_PART_CS__OWNING_CURLY_BRACKET_CLAUSE);
		createEReference(constructorPartCSEClass, CONSTRUCTOR_PART_CS__REFERRED_PROPERTY);
		createEReference(constructorPartCSEClass, CONSTRUCTOR_PART_CS__OWNED_INIT_EXPRESSION);

		contextCSEClass = createEClass(CONTEXT_CS);
		createEReference(contextCSEClass, CONTEXT_CS__OWNED_EXPRESSION);

		curlyBracketedClauseCSEClass = createEClass(CURLY_BRACKETED_CLAUSE_CS);
		createEReference(curlyBracketedClauseCSEClass, CURLY_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP);
		createEReference(curlyBracketedClauseCSEClass, CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS);
		createEAttribute(curlyBracketedClauseCSEClass, CURLY_BRACKETED_CLAUSE_CS__VALUE);

		expCSEClass = createEClass(EXP_CS);
		createEReference(expCSEClass, EXP_CS__PARENT);
		createEAttribute(expCSEClass, EXP_CS__HAS_ERROR);

		expSpecificationCSEClass = createEClass(EXP_SPECIFICATION_CS);
		createEReference(expSpecificationCSEClass, EXP_SPECIFICATION_CS__OWNED_EXPRESSION);

		ifExpCSEClass = createEClass(IF_EXP_CS);
		createEReference(ifExpCSEClass, IF_EXP_CS__OWNED_CONDITION);
		createEReference(ifExpCSEClass, IF_EXP_CS__OWNED_THEN_EXPRESSION);
		createEReference(ifExpCSEClass, IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS);
		createEReference(ifExpCSEClass, IF_EXP_CS__OWNED_ELSE_EXPRESSION);
		createEAttribute(ifExpCSEClass, IF_EXP_CS__IS_IMPLICIT);

		ifThenExpCSEClass = createEClass(IF_THEN_EXP_CS);
		createEReference(ifThenExpCSEClass, IF_THEN_EXP_CS__OWNED_CONDITION);
		createEReference(ifThenExpCSEClass, IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION);

		infixExpCSEClass = createEClass(INFIX_EXP_CS);
		createEReference(infixExpCSEClass, INFIX_EXP_CS__OWNED_ARGUMENT);
		createEReference(infixExpCSEClass, INFIX_EXP_CS__DERIVED_ARGUMENT);
		createEReference(infixExpCSEClass, INFIX_EXP_CS__ARGUMENT);

		invalidLiteralExpCSEClass = createEClass(INVALID_LITERAL_EXP_CS);

		iterateCallExpCSEClass = createEClass(ITERATE_CALL_EXP_CS);
		createEReference(iterateCallExpCSEClass, ITERATE_CALL_EXP_CS__ACCUMULATORS);

		iterationCallExpCSEClass = createEClass(ITERATION_CALL_EXP_CS);
		createEReference(iterationCallExpCSEClass, ITERATION_CALL_EXP_CS__REFERRED_ITERATION);
		createEReference(iterationCallExpCSEClass, ITERATION_CALL_EXP_CS__ITERATORS);

		lambdaLiteralExpCSEClass = createEClass(LAMBDA_LITERAL_EXP_CS);
		createEReference(lambdaLiteralExpCSEClass, LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS);

		letExpCSEClass = createEClass(LET_EXP_CS);
		createEReference(letExpCSEClass, LET_EXP_CS__OWNED_VARIABLES);
		createEReference(letExpCSEClass, LET_EXP_CS__OWNED_IN_EXPRESSION);
		createEAttribute(letExpCSEClass, LET_EXP_CS__IS_IMPLICIT);

		letVariableCSEClass = createEClass(LET_VARIABLE_CS);
		createEReference(letVariableCSEClass, LET_VARIABLE_CS__OWNING_LET_EXPRESSION);
		createEReference(letVariableCSEClass, LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE);

		literalExpCSEClass = createEClass(LITERAL_EXP_CS);

		nameExpCSEClass = createEClass(NAME_EXP_CS);

		navigatingArgCSEClass = createEClass(NAVIGATING_ARG_CS);
		createEReference(navigatingArgCSEClass, NAVIGATING_ARG_CS__OWNING_ROUND_BRACKETED_CLAUSE);
		createEAttribute(navigatingArgCSEClass, NAVIGATING_ARG_CS__ROLE);
		createEAttribute(navigatingArgCSEClass, NAVIGATING_ARG_CS__PREFIX);
		createEReference(navigatingArgCSEClass, NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION);
		createEReference(navigatingArgCSEClass, NAVIGATING_ARG_CS__OWNED_TYPE);
		createEReference(navigatingArgCSEClass, NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION);

		nestedExpCSEClass = createEClass(NESTED_EXP_CS);
		createEReference(nestedExpCSEClass, NESTED_EXP_CS__SOURCE);

		nullLiteralExpCSEClass = createEClass(NULL_LITERAL_EXP_CS);

		numberLiteralExpCSEClass = createEClass(NUMBER_LITERAL_EXP_CS);
		createEAttribute(numberLiteralExpCSEClass, NUMBER_LITERAL_EXP_CS__SYMBOL);

		operationCallExpCSEClass = createEClass(OPERATION_CALL_EXP_CS);
		createEReference(operationCallExpCSEClass, OPERATION_CALL_EXP_CS__REFERRED_OPERATION);

		operatorExpCSEClass = createEClass(OPERATOR_EXP_CS);
		createEReference(operatorExpCSEClass, OPERATOR_EXP_CS__OWNED_SOURCE);
		createEReference(operatorExpCSEClass, OPERATOR_EXP_CS__SOURCE);
		createEReference(operatorExpCSEClass, OPERATOR_EXP_CS__DERIVED_SOURCE);
		createEReference(operatorExpCSEClass, OPERATOR_EXP_CS__DERIVED_PARENT);

		patternExpCSEClass = createEClass(PATTERN_EXP_CS);
		createEAttribute(patternExpCSEClass, PATTERN_EXP_CS__PATTERN_VARIABLE_NAME);
		createEReference(patternExpCSEClass, PATTERN_EXP_CS__OWNED_PATTERN_TYPE);

		prefixExpCSEClass = createEClass(PREFIX_EXP_CS);

		primitiveLiteralExpCSEClass = createEClass(PRIMITIVE_LITERAL_EXP_CS);

		propertyCallExpCSEClass = createEClass(PROPERTY_CALL_EXP_CS);
		createEReference(propertyCallExpCSEClass, PROPERTY_CALL_EXP_CS__REFERRED_PROPERTY);

		roundBracketedClauseCSEClass = createEClass(ROUND_BRACKETED_CLAUSE_CS);
		createEReference(roundBracketedClauseCSEClass, ROUND_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP);
		createEReference(roundBracketedClauseCSEClass, ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS);

		selfExpCSEClass = createEClass(SELF_EXP_CS);
		createEAttribute(selfExpCSEClass, SELF_EXP_CS__NAME);

		squareBracketedClauseCSEClass = createEClass(SQUARE_BRACKETED_CLAUSE_CS);
		createEReference(squareBracketedClauseCSEClass, SQUARE_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP);
		createEReference(squareBracketedClauseCSEClass, SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS);

		stringLiteralExpCSEClass = createEClass(STRING_LITERAL_EXP_CS);
		createEAttribute(stringLiteralExpCSEClass, STRING_LITERAL_EXP_CS__SEGMENTS);

		tupleLiteralExpCSEClass = createEClass(TUPLE_LITERAL_EXP_CS);
		createEReference(tupleLiteralExpCSEClass, TUPLE_LITERAL_EXP_CS__OWNED_PARTS);

		tupleLiteralPartCSEClass = createEClass(TUPLE_LITERAL_PART_CS);

		typeLiteralExpCSEClass = createEClass(TYPE_LITERAL_EXP_CS);
		createEReference(typeLiteralExpCSEClass, TYPE_LITERAL_EXP_CS__OWNED_PATH_NAME);
		createEReference(typeLiteralExpCSEClass, TYPE_LITERAL_EXP_CS__OWNED_TYPE);

		typeNameExpCSEClass = createEClass(TYPE_NAME_EXP_CS);
		createEReference(typeNameExpCSEClass, TYPE_NAME_EXP_CS__OWNED_PATH_NAME);
		createEReference(typeNameExpCSEClass, TYPE_NAME_EXP_CS__ELEMENT);
		createEReference(typeNameExpCSEClass, TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE);
		createEReference(typeNameExpCSEClass, TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD);

		unlimitedNaturalLiteralExpCSEClass = createEClass(UNLIMITED_NATURAL_LITERAL_EXP_CS);

		variableCSEClass = createEClass(VARIABLE_CS);
		createEReference(variableCSEClass, VARIABLE_CS__OWNED_TYPE);
		createEReference(variableCSEClass, VARIABLE_CS__OWNED_INIT_EXPRESSION);

		variableExpCSEClass = createEClass(VARIABLE_EXP_CS);
		createEReference(variableExpCSEClass, VARIABLE_EXP_CS__REFERRED_VARIABLE);

		// Create enums
		navigationRoleEEnum = createEEnum(NAVIGATION_ROLE);
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
		BaseCSPackage theBaseCSPackage = (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractNameExpCSEClass.getESuperTypes().add(this.getExpCS());
		associationClassCallExpCSEClass.getESuperTypes().add(this.getCallExpCS());
		booleanLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		callExpCSEClass.getESuperTypes().add(this.getAbstractNameExpCS());
		collectionLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		collectionLiteralPartCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		collectionPatternCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedRefCS());
		collectionTypeCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedRefCS());
		collectionTypeCSEClass.getESuperTypes().add(thePivotPackage.getNameable());
		constructorExpCSEClass.getESuperTypes().add(this.getAbstractNameExpCS());
		constructorPartCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		constructorPartCSEClass.getESuperTypes().add(thePivotPackage.getNameable());
		contextCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		contextCSEClass.getESuperTypes().add(theBaseCSPackage.getRootCS());
		curlyBracketedClauseCSEClass.getESuperTypes().add(theBaseCSPackage.getContextLessElementCS());
		expCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		expSpecificationCSEClass.getESuperTypes().add(theBaseCSPackage.getSpecificationCS());
		ifExpCSEClass.getESuperTypes().add(this.getExpCS());
		ifThenExpCSEClass.getESuperTypes().add(this.getExpCS());
		infixExpCSEClass.getESuperTypes().add(this.getOperatorExpCS());
		invalidLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		iterateCallExpCSEClass.getESuperTypes().add(this.getIterationCallExpCS());
		iterationCallExpCSEClass.getESuperTypes().add(this.getCallExpCS());
		lambdaLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		letExpCSEClass.getESuperTypes().add(this.getExpCS());
		letVariableCSEClass.getESuperTypes().add(this.getVariableCS());
		letVariableCSEClass.getESuperTypes().add(this.getExpCS());
		literalExpCSEClass.getESuperTypes().add(this.getExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getAssociationClassCallExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getConstructorExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getIterateCallExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getIterationCallExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getOperationCallExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getPropertyCallExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getVariableExpCS());
		navigatingArgCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		nestedExpCSEClass.getESuperTypes().add(this.getExpCS());
		nullLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		numberLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		operationCallExpCSEClass.getESuperTypes().add(this.getCallExpCS());
		operatorExpCSEClass.getESuperTypes().add(this.getExpCS());
		operatorExpCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		patternExpCSEClass.getESuperTypes().add(this.getExpCS());
		prefixExpCSEClass.getESuperTypes().add(this.getOperatorExpCS());
		primitiveLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		propertyCallExpCSEClass.getESuperTypes().add(this.getCallExpCS());
		roundBracketedClauseCSEClass.getESuperTypes().add(theBaseCSPackage.getContextLessElementCS());
		selfExpCSEClass.getESuperTypes().add(this.getExpCS());
		squareBracketedClauseCSEClass.getESuperTypes().add(theBaseCSPackage.getContextLessElementCS());
		stringLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		tupleLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		tupleLiteralPartCSEClass.getESuperTypes().add(this.getVariableCS());
		typeLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		typeNameExpCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedRefCS());
		unlimitedNaturalLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		variableCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		variableExpCSEClass.getESuperTypes().add(this.getAbstractNameExpCS());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractNameExpCSEClass, AbstractNameExpCS.class, "AbstractNameExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAbstractNameExpCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, AbstractNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAbstractNameExpCS_IsPre(), ecorePackage.getEBoolean(), "isPre", "false", 0, 1, AbstractNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getAbstractNameExpCS_OwnedCurlyBracketedClause(), this.getCurlyBracketedClauseCS(), this.getCurlyBracketedClauseCS_OwningNameExp(), "ownedCurlyBracketedClause", null, 0, 1, AbstractNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractNameExpCS_OwnedRoundBracketedClause(), this.getRoundBracketedClauseCS(), this.getRoundBracketedClauseCS_OwningNameExp(), "ownedRoundBracketedClause", null, 0, 1, AbstractNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractNameExpCS_OwnedSquareBracketedClauses(), this.getSquareBracketedClauseCS(), this.getSquareBracketedClauseCS_OwningNameExp(), "ownedSquareBracketedClauses", null, 0, 2, AbstractNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractNameExpCS_SourceType(), thePivotPackage.getType(), null, "sourceType", null, 0, 1, AbstractNameExpCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractNameExpCS_SourceTypeValue(), thePivotPackage.getType(), null, "sourceTypeValue", null, 0, 1, AbstractNameExpCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(associationClassCallExpCSEClass, AssociationClassCallExpCS.class, "AssociationClassCallExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAssociationClassCallExpCS_ReferredAssociation(), thePivotPackage.getAssociationClass(), null, "referredAssociation", null, 0, 1, AssociationClassCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(booleanLiteralExpCSEClass, BooleanLiteralExpCS.class, "BooleanLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getBooleanLiteralExpCS_Symbol(), ecorePackage.getEString(), "symbol", null, 0, 1, BooleanLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(callExpCSEClass, CallExpCS.class, "CallExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCallExpCS_Source(), this.getExpCS(), null, "source", null, 0, 1, CallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCallExpCS_Arguments(), this.getExpCS(), null, "arguments", null, 0, -1, CallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionLiteralExpCSEClass, CollectionLiteralExpCS.class, "CollectionLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCollectionLiteralExpCS_OwnedType(), this.getCollectionTypeCS(), null, "ownedType", null, 0, 1, CollectionLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionLiteralExpCS_OwnedParts(), this.getCollectionLiteralPartCS(), null, "ownedParts", null, 0, -1, CollectionLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionLiteralPartCSEClass, CollectionLiteralPartCS.class, "CollectionLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCollectionLiteralPartCS_OwnedExpression(), this.getExpCS(), null, "ownedExpression", null, 0, 1, CollectionLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionLiteralPartCS_OwnedLastExpression(), this.getExpCS(), null, "ownedLastExpression", null, 0, 1, CollectionLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionPatternCSEClass, CollectionPatternCS.class, "CollectionPatternCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCollectionPatternCS_OwnedType(), this.getCollectionTypeCS(), null, "ownedType", null, 0, 1, CollectionPatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionPatternCS_OwnedParts(), this.getPatternExpCS(), null, "ownedParts", null, 0, -1, CollectionPatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getCollectionPatternCS_RestVariableName(), ecorePackage.getEString(), "restVariableName", null, 0, 1, CollectionPatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionPatternCS_OwnedPatternGuard(), this.getExpCS(), null, "ownedPatternGuard", null, 0, 1, CollectionPatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionTypeCSEClass, CollectionTypeCS.class, "CollectionTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getCollectionTypeCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, CollectionTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionTypeCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, CollectionTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(constructorExpCSEClass, ConstructorExpCS.class, "ConstructorExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getConstructorExpCS_TypeName(), this.getTypeNameExpCS(), null, "typeName", null, 0, 1, ConstructorExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getConstructorExpCS_Parts(), this.getConstructorPartCS(), null, "parts", null, 0, -1, ConstructorExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getConstructorExpCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, ConstructorExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(constructorPartCSEClass, ConstructorPartCS.class, "ConstructorPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getConstructorPartCS_OwningCurlyBracketClause(), this.getCurlyBracketedClauseCS(), this.getCurlyBracketedClauseCS_OwnedParts(), "owningCurlyBracketClause", null, 0, 1, ConstructorPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getConstructorPartCS_ReferredProperty(), thePivotPackage.getProperty(), null, "referredProperty", null, 1, 1, ConstructorPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getConstructorPartCS_OwnedInitExpression(), this.getExpCS(), null, "ownedInitExpression", null, 1, 1, ConstructorPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(contextCSEClass, ContextCS.class, "ContextCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getContextCS_OwnedExpression(), this.getExpCS(), null, "ownedExpression", null, 0, 1, ContextCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(curlyBracketedClauseCSEClass, CurlyBracketedClauseCS.class, "CurlyBracketedClauseCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCurlyBracketedClauseCS_OwningNameExp(), this.getAbstractNameExpCS(), this.getAbstractNameExpCS_OwnedCurlyBracketedClause(), "owningNameExp", null, 0, 1, CurlyBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCurlyBracketedClauseCS_OwnedParts(), this.getConstructorPartCS(), this.getConstructorPartCS_OwningCurlyBracketClause(), "ownedParts", null, 0, -1, CurlyBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getCurlyBracketedClauseCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, CurlyBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(expCSEClass, ExpCS.class, "ExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getExpCS_Parent(), this.getOperatorExpCS(), null, "parent", null, 0, 1, ExpCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getExpCS_HasError(), ecorePackage.getEBoolean(), "hasError", "false", 0, 1, ExpCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(expSpecificationCSEClass, ExpSpecificationCS.class, "ExpSpecificationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getExpSpecificationCS_OwnedExpression(), this.getExpCS(), null, "ownedExpression", null, 0, 1, ExpSpecificationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ifExpCSEClass, IfExpCS.class, "IfExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIfExpCS_OwnedCondition(), this.getExpCS(), null, "ownedCondition", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIfExpCS_OwnedThenExpression(), this.getExpCS(), null, "ownedThenExpression", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIfExpCS_OwnedIfThenExpressions(), this.getIfThenExpCS(), null, "ownedIfThenExpressions", null, 0, -1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIfExpCS_OwnedElseExpression(), this.getExpCS(), null, "ownedElseExpression", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIfExpCS_IsImplicit(), theEcorePackage.getEBoolean(), "isImplicit", "false", 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(ifThenExpCSEClass, IfThenExpCS.class, "IfThenExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIfThenExpCS_OwnedCondition(), this.getExpCS(), null, "ownedCondition", null, 0, 1, IfThenExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIfThenExpCS_OwnedThenExpression(), this.getExpCS(), null, "ownedThenExpression", null, 0, 1, IfThenExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(infixExpCSEClass, InfixExpCS.class, "InfixExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getInfixExpCS_OwnedArgument(), this.getExpCS(), null, "ownedArgument", null, 1, 1, InfixExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInfixExpCS_DerivedArgument(), this.getExpCS(), null, "derivedArgument", null, 0, 1, InfixExpCS.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInfixExpCS_Argument(), this.getExpCS(), null, "argument", null, 1, 1, InfixExpCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(invalidLiteralExpCSEClass, InvalidLiteralExpCS.class, "InvalidLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iterateCallExpCSEClass, IterateCallExpCS.class, "IterateCallExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIterateCallExpCS_Accumulators(), this.getVariableCS(), null, "accumulators", null, 0, -1, IterateCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(iterationCallExpCSEClass, IterationCallExpCS.class, "IterationCallExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIterationCallExpCS_ReferredIteration(), thePivotPackage.getIteration(), null, "referredIteration", null, 0, 1, IterationCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIterationCallExpCS_Iterators(), this.getVariableCS(), null, "iterators", null, 0, -1, IterationCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(lambdaLiteralExpCSEClass, LambdaLiteralExpCS.class, "LambdaLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLambdaLiteralExpCS_OwnedExpressionCS(), this.getExpCS(), null, "ownedExpressionCS", null, 0, 1, LambdaLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(letExpCSEClass, LetExpCS.class, "LetExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLetExpCS_OwnedVariables(), this.getLetVariableCS(), this.getLetVariableCS_OwningLetExpression(), "ownedVariables", null, 0, -1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLetExpCS_OwnedInExpression(), this.getExpCS(), null, "ownedInExpression", null, 0, 1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLetExpCS_IsImplicit(), theEcorePackage.getEBoolean(), "isImplicit", "false", 0, 1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(letVariableCSEClass, LetVariableCS.class, "LetVariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLetVariableCS_OwningLetExpression(), this.getLetExpCS(), this.getLetExpCS_OwnedVariables(), "owningLetExpression", null, 0, 1, LetVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLetVariableCS_OwnedRoundBracketedClause(), this.getRoundBracketedClauseCS(), null, "ownedRoundBracketedClause", null, 0, 1, LetVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(literalExpCSEClass, LiteralExpCS.class, "LiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(nameExpCSEClass, NameExpCS.class, "NameExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(navigatingArgCSEClass, NavigatingArgCS.class, "NavigatingArgCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getNavigatingArgCS_OwningRoundBracketedClause(), this.getRoundBracketedClauseCS(), this.getRoundBracketedClauseCS_OwnedArguments(), "owningRoundBracketedClause", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNavigatingArgCS_Role(), this.getNavigationRole(), "role", null, 0, 1, NavigatingArgCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNavigatingArgCS_Prefix(), ecorePackage.getEString(), "prefix", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNavigatingArgCS_OwnedNameExpression(), this.getExpCS(), null, "ownedNameExpression", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNavigatingArgCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNavigatingArgCS_OwnedInitExpression(), this.getExpCS(), null, "ownedInitExpression", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(nestedExpCSEClass, NestedExpCS.class, "NestedExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getNestedExpCS_Source(), this.getExpCS(), null, "source", null, 0, 1, NestedExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(nullLiteralExpCSEClass, NullLiteralExpCS.class, "NullLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(numberLiteralExpCSEClass, NumberLiteralExpCS.class, "NumberLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getNumberLiteralExpCS_Symbol(), theBaseCSPackage.getBigNumber(), "symbol", null, 0, 1, NumberLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(operationCallExpCSEClass, OperationCallExpCS.class, "OperationCallExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOperationCallExpCS_ReferredOperation(), thePivotPackage.getOperation(), null, "referredOperation", null, 0, 1, OperationCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(operatorExpCSEClass, OperatorExpCS.class, "OperatorExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOperatorExpCS_OwnedSource(), this.getExpCS(), null, "ownedSource", null, 1, 1, OperatorExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperatorExpCS_Source(), this.getExpCS(), null, "source", null, 1, 1, OperatorExpCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperatorExpCS_DerivedSource(), this.getExpCS(), null, "derivedSource", null, 0, 1, OperatorExpCS.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperatorExpCS_DerivedParent(), this.getExpCS(), null, "derivedParent", null, 0, 1, OperatorExpCS.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(patternExpCSEClass, PatternExpCS.class, "PatternExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getPatternExpCS_PatternVariableName(), ecorePackage.getEString(), "patternVariableName", null, 0, 1, PatternExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPatternExpCS_OwnedPatternType(), theBaseCSPackage.getTypeRefCS(), null, "ownedPatternType", null, 0, 1, PatternExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(prefixExpCSEClass, PrefixExpCS.class, "PrefixExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(primitiveLiteralExpCSEClass, PrimitiveLiteralExpCS.class, "PrimitiveLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(propertyCallExpCSEClass, PropertyCallExpCS.class, "PropertyCallExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPropertyCallExpCS_ReferredProperty(), thePivotPackage.getProperty(), null, "referredProperty", null, 0, 1, PropertyCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(roundBracketedClauseCSEClass, RoundBracketedClauseCS.class, "RoundBracketedClauseCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getRoundBracketedClauseCS_OwningNameExp(), this.getAbstractNameExpCS(), this.getAbstractNameExpCS_OwnedRoundBracketedClause(), "owningNameExp", null, 0, 1, RoundBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getRoundBracketedClauseCS_OwnedArguments(), this.getNavigatingArgCS(), this.getNavigatingArgCS_OwningRoundBracketedClause(), "ownedArguments", null, 0, -1, RoundBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(selfExpCSEClass, SelfExpCS.class, "SelfExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSelfExpCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, SelfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(squareBracketedClauseCSEClass, SquareBracketedClauseCS.class, "SquareBracketedClauseCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSquareBracketedClauseCS_OwningNameExp(), this.getAbstractNameExpCS(), this.getAbstractNameExpCS_OwnedSquareBracketedClauses(), "owningNameExp", null, 0, 1, SquareBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSquareBracketedClauseCS_OwnedTerms(), this.getExpCS(), null, "ownedTerms", null, 1, -1, SquareBracketedClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringLiteralExpCSEClass, StringLiteralExpCS.class, "StringLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStringLiteralExpCS_Segments(), ecorePackage.getEString(), "segments", null, 0, -1, StringLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tupleLiteralExpCSEClass, TupleLiteralExpCS.class, "TupleLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTupleLiteralExpCS_OwnedParts(), this.getTupleLiteralPartCS(), null, "ownedParts", null, 0, -1, TupleLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tupleLiteralPartCSEClass, TupleLiteralPartCS.class, "TupleLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(typeLiteralExpCSEClass, TypeLiteralExpCS.class, "TypeLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypeLiteralExpCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, TypeLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeLiteralExpCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 1, 1, TypeLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeNameExpCSEClass, TypeNameExpCS.class, "TypeNameExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypeNameExpCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, TypeNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeNameExpCS_Element(), thePivotPackage.getType(), null, "element", null, 0, 1, TypeNameExpCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeNameExpCS_OwnedCurlyBracketedClause(), this.getCurlyBracketedClauseCS(), null, "ownedCurlyBracketedClause", null, 0, 1, TypeNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeNameExpCS_OwnedPatternGuard(), this.getExpCS(), null, "ownedPatternGuard", null, 0, 1, TypeNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(unlimitedNaturalLiteralExpCSEClass, UnlimitedNaturalLiteralExpCS.class, "UnlimitedNaturalLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(variableCSEClass, VariableCS.class, "VariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getVariableCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, VariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVariableCS_OwnedInitExpression(), this.getExpCS(), null, "ownedInitExpression", null, 0, 1, VariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(variableExpCSEClass, VariableExpCS.class, "VariableExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getVariableExpCS_ReferredVariable(), thePivotPackage.getVariable(), null, "referredVariable", null, 0, 1, VariableExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(navigationRoleEEnum, NavigationRole.class, "NavigationRole"); //$NON-NLS-1$
		addEEnumLiteral(navigationRoleEEnum, NavigationRole.ITERATOR);
		addEEnumLiteral(navigationRoleEEnum, NavigationRole.ACCUMULATOR);
		addEEnumLiteral(navigationRoleEEnum, NavigationRole.EXPRESSION);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
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
			 "pivot", "../../org.eclipse.ocl.examples.pivot/model/Pivot.ecore#/", //$NON-NLS-1$ //$NON-NLS-2$
			 "basecs", "../../org.eclipse.ocl.examples.xtext.base/model/BaseCS.ecore#/" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //EssentialOCLCSPackageImpl
