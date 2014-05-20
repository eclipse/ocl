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
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSFactory;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IndexExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NamedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS;

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
	private EClass binaryOperatorCSEClass = null;

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
	private EClass unaryOperatorCSEClass = null;

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
	private EClass namedExpCSEClass = null;

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
	private EClass navigationOperatorCSEClass = null;

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
	private EClass primitiveLiteralExpCSEClass = null;

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
	private EClass invalidLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invocationExpCSEClass = null;

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
	private EClass operatorCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType bigNumberEDataType = null;

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
	private EClass indexExpCSEClass = null;

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
	public EClass getAbstractNameExpCS() {
		return abstractNameExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNameExpCS_SourceType()
	{
		return (EReference)abstractNameExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryOperatorCS() {
		return binaryOperatorCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryOperatorCS_Argument() {
		return (EReference)binaryOperatorCSEClass.getEStructuralFeatures().get(0);
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
	public EReference getPrefixExpCS_OwnedOperator() {
		return (EReference)prefixExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrefixExpCS_OwnedExpression() {
		return (EReference)prefixExpCSEClass.getEStructuralFeatures().get(1);
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
	public EClass getConstructorExpCS() {
		return constructorExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstructorExpCS_OwnedParts() {
		return (EReference)constructorExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstructorExpCS_Value() {
		return (EAttribute)constructorExpCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getConstructorPartCS_Property() {
		return (EReference)constructorPartCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstructorPartCS_InitExpression() {
		return (EReference)constructorPartCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getTypeLiteralExpCS_OwnedType() {
		return (EReference)typeLiteralExpCSEClass.getEStructuralFeatures().get(0);
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
	public EReference getTypeNameExpCS_PathName() {
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
	public EClass getUnaryOperatorCS() {
		return unaryOperatorCSEClass;
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
	public EReference getVariableCS_InitExpression() {
		return (EReference)variableCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getNameExpCS_PathName() {
		return (EReference)nameExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameExpCS_AtPre() {
		return (EAttribute)nameExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedExpCS() {
		return namedExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedExpCS_NameExp() {
		return (EReference)namedExpCSEClass.getEStructuralFeatures().get(0);
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
	public EReference getNavigatingArgCS_NavigatingExp() {
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
	public EReference getNavigatingArgCS_Name() {
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
	public EReference getNavigatingArgCS_Init() {
		return (EReference)navigatingArgCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNavigationOperatorCS() {
		return navigationOperatorCSEClass;
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
	public EReference getCollectionLiteralPartCS_ExpressionCS() {
		return (EReference)collectionLiteralPartCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionLiteralPartCS_LastExpressionCS() {
		return (EReference)collectionLiteralPartCSEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getStringLiteralExpCS_Name() {
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
	public EAttribute getBooleanLiteralExpCS_Name() {
		return (EAttribute)booleanLiteralExpCSEClass.getEStructuralFeatures().get(0);
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
	public EClass getInvocationExpCS() {
		return invocationExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvocationExpCS_Argument() {
		return (EReference)invocationExpCSEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getNumberLiteralExpCS_Name() {
		return (EAttribute)numberLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorCS() {
		return operatorCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorCS_Source() {
		return (EReference)operatorCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBigNumber() {
		return bigNumberEDataType;
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
	public EReference getIfExpCS_Condition() {
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpCS_ThenExpression() {
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpCS_ElseExpression() {
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexExpCS() {
		return indexExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexExpCS_FirstIndexes() {
		return (EReference)indexExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexExpCS_SecondIndexes() {
		return (EReference)indexExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexExpCS_AtPre() {
		return (EAttribute)indexExpCSEClass.getEStructuralFeatures().get(2);
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
	public EReference getInfixExpCS_OwnedExpression() {
		return (EReference)infixExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInfixExpCS_OwnedOperator() {
		return (EReference)infixExpCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getLetExpCS_Variable() {
		return (EReference)letExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLetExpCS_In() {
		return (EReference)letExpCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getLetVariableCS_LetExpression() {
		return (EReference)letVariableCSEClass.getEStructuralFeatures().get(0);
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
		createEReference(abstractNameExpCSEClass, ABSTRACT_NAME_EXP_CS__SOURCE_TYPE);

		binaryOperatorCSEClass = createEClass(BINARY_OPERATOR_CS);
		createEReference(binaryOperatorCSEClass, BINARY_OPERATOR_CS__ARGUMENT);

		booleanLiteralExpCSEClass = createEClass(BOOLEAN_LITERAL_EXP_CS);
		createEAttribute(booleanLiteralExpCSEClass, BOOLEAN_LITERAL_EXP_CS__NAME);

		collectionLiteralExpCSEClass = createEClass(COLLECTION_LITERAL_EXP_CS);
		createEReference(collectionLiteralExpCSEClass, COLLECTION_LITERAL_EXP_CS__OWNED_TYPE);
		createEReference(collectionLiteralExpCSEClass, COLLECTION_LITERAL_EXP_CS__OWNED_PARTS);

		collectionLiteralPartCSEClass = createEClass(COLLECTION_LITERAL_PART_CS);
		createEReference(collectionLiteralPartCSEClass, COLLECTION_LITERAL_PART_CS__EXPRESSION_CS);
		createEReference(collectionLiteralPartCSEClass, COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS);

		collectionTypeCSEClass = createEClass(COLLECTION_TYPE_CS);
		createEAttribute(collectionTypeCSEClass, COLLECTION_TYPE_CS__NAME);
		createEReference(collectionTypeCSEClass, COLLECTION_TYPE_CS__OWNED_TYPE);

		constructorExpCSEClass = createEClass(CONSTRUCTOR_EXP_CS);
		createEReference(constructorExpCSEClass, CONSTRUCTOR_EXP_CS__OWNED_PARTS);
		createEAttribute(constructorExpCSEClass, CONSTRUCTOR_EXP_CS__VALUE);

		constructorPartCSEClass = createEClass(CONSTRUCTOR_PART_CS);
		createEReference(constructorPartCSEClass, CONSTRUCTOR_PART_CS__PROPERTY);
		createEReference(constructorPartCSEClass, CONSTRUCTOR_PART_CS__INIT_EXPRESSION);

		contextCSEClass = createEClass(CONTEXT_CS);
		createEReference(contextCSEClass, CONTEXT_CS__OWNED_EXPRESSION);

		expCSEClass = createEClass(EXP_CS);
		createEReference(expCSEClass, EXP_CS__PARENT);
		createEAttribute(expCSEClass, EXP_CS__HAS_ERROR);

		expSpecificationCSEClass = createEClass(EXP_SPECIFICATION_CS);
		createEReference(expSpecificationCSEClass, EXP_SPECIFICATION_CS__OWNED_EXPRESSION);

		ifExpCSEClass = createEClass(IF_EXP_CS);
		createEReference(ifExpCSEClass, IF_EXP_CS__CONDITION);
		createEReference(ifExpCSEClass, IF_EXP_CS__THEN_EXPRESSION);
		createEReference(ifExpCSEClass, IF_EXP_CS__ELSE_EXPRESSION);

		indexExpCSEClass = createEClass(INDEX_EXP_CS);
		createEReference(indexExpCSEClass, INDEX_EXP_CS__FIRST_INDEXES);
		createEReference(indexExpCSEClass, INDEX_EXP_CS__SECOND_INDEXES);
		createEAttribute(indexExpCSEClass, INDEX_EXP_CS__AT_PRE);

		infixExpCSEClass = createEClass(INFIX_EXP_CS);
		createEReference(infixExpCSEClass, INFIX_EXP_CS__OWNED_EXPRESSION);
		createEReference(infixExpCSEClass, INFIX_EXP_CS__OWNED_OPERATOR);

		invalidLiteralExpCSEClass = createEClass(INVALID_LITERAL_EXP_CS);

		invocationExpCSEClass = createEClass(INVOCATION_EXP_CS);
		createEReference(invocationExpCSEClass, INVOCATION_EXP_CS__ARGUMENT);

		letExpCSEClass = createEClass(LET_EXP_CS);
		createEReference(letExpCSEClass, LET_EXP_CS__VARIABLE);
		createEReference(letExpCSEClass, LET_EXP_CS__IN);

		letVariableCSEClass = createEClass(LET_VARIABLE_CS);
		createEReference(letVariableCSEClass, LET_VARIABLE_CS__LET_EXPRESSION);

		literalExpCSEClass = createEClass(LITERAL_EXP_CS);

		nameExpCSEClass = createEClass(NAME_EXP_CS);
		createEReference(nameExpCSEClass, NAME_EXP_CS__PATH_NAME);
		createEAttribute(nameExpCSEClass, NAME_EXP_CS__AT_PRE);

		namedExpCSEClass = createEClass(NAMED_EXP_CS);
		createEReference(namedExpCSEClass, NAMED_EXP_CS__NAME_EXP);

		navigatingArgCSEClass = createEClass(NAVIGATING_ARG_CS);
		createEReference(navigatingArgCSEClass, NAVIGATING_ARG_CS__NAVIGATING_EXP);
		createEAttribute(navigatingArgCSEClass, NAVIGATING_ARG_CS__ROLE);
		createEAttribute(navigatingArgCSEClass, NAVIGATING_ARG_CS__PREFIX);
		createEReference(navigatingArgCSEClass, NAVIGATING_ARG_CS__NAME);
		createEReference(navigatingArgCSEClass, NAVIGATING_ARG_CS__OWNED_TYPE);
		createEReference(navigatingArgCSEClass, NAVIGATING_ARG_CS__INIT);

		navigationOperatorCSEClass = createEClass(NAVIGATION_OPERATOR_CS);

		nestedExpCSEClass = createEClass(NESTED_EXP_CS);
		createEReference(nestedExpCSEClass, NESTED_EXP_CS__SOURCE);

		nullLiteralExpCSEClass = createEClass(NULL_LITERAL_EXP_CS);

		numberLiteralExpCSEClass = createEClass(NUMBER_LITERAL_EXP_CS);
		createEAttribute(numberLiteralExpCSEClass, NUMBER_LITERAL_EXP_CS__NAME);

		operatorCSEClass = createEClass(OPERATOR_CS);
		createEReference(operatorCSEClass, OPERATOR_CS__SOURCE);

		prefixExpCSEClass = createEClass(PREFIX_EXP_CS);
		createEReference(prefixExpCSEClass, PREFIX_EXP_CS__OWNED_OPERATOR);
		createEReference(prefixExpCSEClass, PREFIX_EXP_CS__OWNED_EXPRESSION);

		primitiveLiteralExpCSEClass = createEClass(PRIMITIVE_LITERAL_EXP_CS);

		selfExpCSEClass = createEClass(SELF_EXP_CS);
		createEAttribute(selfExpCSEClass, SELF_EXP_CS__NAME);

		stringLiteralExpCSEClass = createEClass(STRING_LITERAL_EXP_CS);
		createEAttribute(stringLiteralExpCSEClass, STRING_LITERAL_EXP_CS__NAME);

		tupleLiteralExpCSEClass = createEClass(TUPLE_LITERAL_EXP_CS);
		createEReference(tupleLiteralExpCSEClass, TUPLE_LITERAL_EXP_CS__OWNED_PARTS);

		tupleLiteralPartCSEClass = createEClass(TUPLE_LITERAL_PART_CS);

		typeLiteralExpCSEClass = createEClass(TYPE_LITERAL_EXP_CS);
		createEReference(typeLiteralExpCSEClass, TYPE_LITERAL_EXP_CS__OWNED_TYPE);

		typeNameExpCSEClass = createEClass(TYPE_NAME_EXP_CS);
		createEReference(typeNameExpCSEClass, TYPE_NAME_EXP_CS__PATH_NAME);
		createEReference(typeNameExpCSEClass, TYPE_NAME_EXP_CS__ELEMENT);

		unaryOperatorCSEClass = createEClass(UNARY_OPERATOR_CS);

		unlimitedNaturalLiteralExpCSEClass = createEClass(UNLIMITED_NATURAL_LITERAL_EXP_CS);

		variableCSEClass = createEClass(VARIABLE_CS);
		createEReference(variableCSEClass, VARIABLE_CS__OWNED_TYPE);
		createEReference(variableCSEClass, VARIABLE_CS__INIT_EXPRESSION);

		// Create enums
		navigationRoleEEnum = createEEnum(NAVIGATION_ROLE);

		// Create data types
		bigNumberEDataType = createEDataType(BIG_NUMBER);
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
		BaseCSPackage theBaseCSPackage = (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractNameExpCSEClass.getESuperTypes().add(this.getExpCS());
		binaryOperatorCSEClass.getESuperTypes().add(this.getOperatorCS());
		booleanLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		collectionLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		collectionLiteralPartCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		collectionTypeCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedRefCS());
		collectionTypeCSEClass.getESuperTypes().add(thePivotPackage.getNameable());
		constructorExpCSEClass.getESuperTypes().add(this.getNamedExpCS());
		constructorPartCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		constructorPartCSEClass.getESuperTypes().add(thePivotPackage.getNameable());
		contextCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		contextCSEClass.getESuperTypes().add(theBaseCSPackage.getRootCS());
		expCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		expSpecificationCSEClass.getESuperTypes().add(theBaseCSPackage.getSpecificationCS());
		ifExpCSEClass.getESuperTypes().add(this.getExpCS());
		indexExpCSEClass.getESuperTypes().add(this.getNamedExpCS());
		infixExpCSEClass.getESuperTypes().add(this.getExpCS());
		invalidLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		invocationExpCSEClass.getESuperTypes().add(this.getNamedExpCS());
		letExpCSEClass.getESuperTypes().add(this.getExpCS());
		letVariableCSEClass.getESuperTypes().add(this.getVariableCS());
		letVariableCSEClass.getESuperTypes().add(this.getExpCS());
		literalExpCSEClass.getESuperTypes().add(this.getExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getAbstractNameExpCS());
		namedExpCSEClass.getESuperTypes().add(this.getAbstractNameExpCS());
		navigatingArgCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		navigationOperatorCSEClass.getESuperTypes().add(this.getBinaryOperatorCS());
		nestedExpCSEClass.getESuperTypes().add(this.getExpCS());
		nullLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		numberLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		operatorCSEClass.getESuperTypes().add(this.getExpCS());
		operatorCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		prefixExpCSEClass.getESuperTypes().add(this.getExpCS());
		primitiveLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		selfExpCSEClass.getESuperTypes().add(this.getExpCS());
		stringLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		tupleLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		tupleLiteralPartCSEClass.getESuperTypes().add(this.getVariableCS());
		typeLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		typeNameExpCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedRefCS());
		unaryOperatorCSEClass.getESuperTypes().add(this.getOperatorCS());
		unlimitedNaturalLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		variableCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractNameExpCSEClass, AbstractNameExpCS.class, "AbstractNameExpCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAbstractNameExpCS_SourceType(), thePivotPackage.getType(), null, "sourceType", null, 0, 1, AbstractNameExpCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(abstractNameExpCSEClass, thePivotPackage.getNamedElement(), "getNamedElement", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(abstractNameExpCSEClass, this.getAbstractNameExpCS(), "getNameExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(abstractNameExpCSEClass, theBaseCSPackage.getPathNameCS(), "getPathName", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(binaryOperatorCSEClass, BinaryOperatorCS.class, "BinaryOperatorCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getBinaryOperatorCS_Argument(), this.getExpCS(), null, "argument", null, 1, 1, BinaryOperatorCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(booleanLiteralExpCSEClass, BooleanLiteralExpCS.class, "BooleanLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getBooleanLiteralExpCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, BooleanLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionLiteralExpCSEClass, CollectionLiteralExpCS.class, "CollectionLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCollectionLiteralExpCS_OwnedType(), this.getCollectionTypeCS(), null, "ownedType", null, 0, 1, CollectionLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionLiteralExpCS_OwnedParts(), this.getCollectionLiteralPartCS(), null, "ownedParts", null, 0, -1, CollectionLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionLiteralPartCSEClass, CollectionLiteralPartCS.class, "CollectionLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCollectionLiteralPartCS_ExpressionCS(), this.getExpCS(), null, "expressionCS", null, 0, 1, CollectionLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionLiteralPartCS_LastExpressionCS(), this.getExpCS(), null, "lastExpressionCS", null, 0, 1, CollectionLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionTypeCSEClass, CollectionTypeCS.class, "CollectionTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getCollectionTypeCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, CollectionTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionTypeCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, CollectionTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(constructorExpCSEClass, ConstructorExpCS.class, "ConstructorExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getConstructorExpCS_OwnedParts(), this.getConstructorPartCS(), null, "ownedParts", null, 0, -1, ConstructorExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getConstructorExpCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, ConstructorExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(constructorPartCSEClass, ConstructorPartCS.class, "ConstructorPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getConstructorPartCS_Property(), thePivotPackage.getProperty(), null, "property", null, 1, 1, ConstructorPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getConstructorPartCS_InitExpression(), this.getExpCS(), null, "initExpression", null, 1, 1, ConstructorPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(contextCSEClass, ContextCS.class, "ContextCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getContextCS_OwnedExpression(), this.getExpCS(), null, "ownedExpression", null, 0, 1, ContextCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(expCSEClass, ExpCS.class, "ExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getExpCS_Parent(), this.getOperatorCS(), null, "parent", null, 0, 1, ExpCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getExpCS_HasError(), ecorePackage.getEBoolean(), "hasError", "false", 0, 1, ExpCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(expSpecificationCSEClass, ExpSpecificationCS.class, "ExpSpecificationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getExpSpecificationCS_OwnedExpression(), this.getExpCS(), null, "ownedExpression", null, 0, 1, ExpSpecificationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ifExpCSEClass, IfExpCS.class, "IfExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIfExpCS_Condition(), this.getExpCS(), null, "condition", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIfExpCS_ThenExpression(), this.getExpCS(), null, "thenExpression", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIfExpCS_ElseExpression(), this.getExpCS(), null, "elseExpression", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(indexExpCSEClass, IndexExpCS.class, "IndexExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIndexExpCS_FirstIndexes(), this.getExpCS(), null, "firstIndexes", null, 1, -1, IndexExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIndexExpCS_SecondIndexes(), this.getExpCS(), null, "secondIndexes", null, 0, -1, IndexExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIndexExpCS_AtPre(), ecorePackage.getEBoolean(), "atPre", "false", 0, 1, IndexExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(infixExpCSEClass, InfixExpCS.class, "InfixExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getInfixExpCS_OwnedExpression(), this.getExpCS(), null, "ownedExpression", null, 2, -1, InfixExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInfixExpCS_OwnedOperator(), this.getBinaryOperatorCS(), null, "ownedOperator", null, 1, -1, InfixExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(invalidLiteralExpCSEClass, InvalidLiteralExpCS.class, "InvalidLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(invocationExpCSEClass, InvocationExpCS.class, "InvocationExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getInvocationExpCS_Argument(), this.getNavigatingArgCS(), this.getNavigatingArgCS_NavigatingExp(), "argument", null, 0, -1, InvocationExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(letExpCSEClass, LetExpCS.class, "LetExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLetExpCS_Variable(), this.getLetVariableCS(), this.getLetVariableCS_LetExpression(), "variable", null, 0, -1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLetExpCS_In(), this.getExpCS(), null, "in", null, 0, 1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(letVariableCSEClass, LetVariableCS.class, "LetVariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLetVariableCS_LetExpression(), this.getLetExpCS(), this.getLetExpCS_Variable(), "letExpression", null, 0, 1, LetVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(literalExpCSEClass, LiteralExpCS.class, "LiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(nameExpCSEClass, NameExpCS.class, "NameExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getNameExpCS_PathName(), theBaseCSPackage.getPathNameCS(), null, "pathName", null, 0, 1, NameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNameExpCS_AtPre(), ecorePackage.getEBoolean(), "atPre", "false", 0, 1, NameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(namedExpCSEClass, NamedExpCS.class, "NamedExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getNamedExpCS_NameExp(), this.getNameExpCS(), null, "nameExp", null, 0, 1, NamedExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(navigatingArgCSEClass, NavigatingArgCS.class, "NavigatingArgCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getNavigatingArgCS_NavigatingExp(), this.getInvocationExpCS(), this.getInvocationExpCS_Argument(), "navigatingExp", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNavigatingArgCS_Role(), this.getNavigationRole(), "role", null, 0, 1, NavigatingArgCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNavigatingArgCS_Prefix(), ecorePackage.getEString(), "prefix", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNavigatingArgCS_Name(), this.getExpCS(), null, "name", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNavigatingArgCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNavigatingArgCS_Init(), this.getExpCS(), null, "init", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(navigationOperatorCSEClass, NavigationOperatorCS.class, "NavigationOperatorCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(nestedExpCSEClass, NestedExpCS.class, "NestedExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getNestedExpCS_Source(), this.getExpCS(), null, "source", null, 0, 1, NestedExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(nullLiteralExpCSEClass, NullLiteralExpCS.class, "NullLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(numberLiteralExpCSEClass, NumberLiteralExpCS.class, "NumberLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getNumberLiteralExpCS_Name(), this.getBigNumber(), "name", null, 0, 1, NumberLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(operatorCSEClass, OperatorCS.class, "OperatorCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOperatorCS_Source(), this.getExpCS(), null, "source", null, 1, 1, OperatorCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(prefixExpCSEClass, PrefixExpCS.class, "PrefixExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPrefixExpCS_OwnedOperator(), this.getUnaryOperatorCS(), null, "ownedOperator", null, 0, -1, PrefixExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPrefixExpCS_OwnedExpression(), this.getExpCS(), null, "ownedExpression", null, 0, 1, PrefixExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(primitiveLiteralExpCSEClass, PrimitiveLiteralExpCS.class, "PrimitiveLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(selfExpCSEClass, SelfExpCS.class, "SelfExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSelfExpCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, SelfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringLiteralExpCSEClass, StringLiteralExpCS.class, "StringLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStringLiteralExpCS_Name(), ecorePackage.getEString(), "name", null, 0, -1, StringLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tupleLiteralExpCSEClass, TupleLiteralExpCS.class, "TupleLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTupleLiteralExpCS_OwnedParts(), this.getTupleLiteralPartCS(), null, "ownedParts", null, 0, -1, TupleLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tupleLiteralPartCSEClass, TupleLiteralPartCS.class, "TupleLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(typeLiteralExpCSEClass, TypeLiteralExpCS.class, "TypeLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypeLiteralExpCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 1, 1, TypeLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeNameExpCSEClass, TypeNameExpCS.class, "TypeNameExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypeNameExpCS_PathName(), theBaseCSPackage.getPathNameCS(), null, "pathName", null, 0, 1, TypeNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeNameExpCS_Element(), thePivotPackage.getType(), null, "element", null, 0, 1, TypeNameExpCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(unaryOperatorCSEClass, UnaryOperatorCS.class, "UnaryOperatorCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(unlimitedNaturalLiteralExpCSEClass, UnlimitedNaturalLiteralExpCS.class, "UnlimitedNaturalLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(variableCSEClass, VariableCS.class, "VariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getVariableCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, VariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVariableCS_InitExpression(), this.getExpCS(), null, "initExpression", null, 0, 1, VariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(navigationRoleEEnum, NavigationRole.class, "NavigationRole"); //$NON-NLS-1$
		addEEnumLiteral(navigationRoleEEnum, NavigationRole.ITERATOR);
		addEEnumLiteral(navigationRoleEEnum, NavigationRole.ACCUMULATOR);
		addEEnumLiteral(navigationRoleEEnum, NavigationRole.EXPRESSION);

		// Initialize data types
		initEDataType(bigNumberEDataType, Number.class, "BigNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

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
