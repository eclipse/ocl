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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.*;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSFactory;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS;
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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EssentialOCLCSFactoryImpl
		extends EFactoryImpl
		implements EssentialOCLCSFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EssentialOCLCSFactory init() {
		try
		{
			EssentialOCLCSFactory theEssentialOCLCSFactory = (EssentialOCLCSFactory)EPackage.Registry.INSTANCE.getEFactory(EssentialOCLCSPackage.eNS_URI);
			if (theEssentialOCLCSFactory != null)
			{
				return theEssentialOCLCSFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EssentialOCLCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EssentialOCLCSFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
			case EssentialOCLCSPackage.BINARY_OPERATOR_CS: return createBinaryOperatorCS();
			case EssentialOCLCSPackage.BOOLEAN_LITERAL_EXP_CS: return createBooleanLiteralExpCS();
			case EssentialOCLCSPackage.COLLECTION_LITERAL_EXP_CS: return createCollectionLiteralExpCS();
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS: return createCollectionLiteralPartCS();
			case EssentialOCLCSPackage.COLLECTION_TYPE_CS: return createCollectionTypeCS();
			case EssentialOCLCSPackage.CONSTRUCTOR_EXP_CS: return createConstructorExpCS();
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS: return createConstructorPartCS();
			case EssentialOCLCSPackage.CONTEXT_CS: return createContextCS();
			case EssentialOCLCSPackage.CURLY_BRACKETED_CLAUSE_CS: return createCurlyBracketedClauseCS();
			case EssentialOCLCSPackage.EXP_CS: return createExpCS();
			case EssentialOCLCSPackage.EXP_SPECIFICATION_CS: return createExpSpecificationCS();
			case EssentialOCLCSPackage.IF_EXP_CS: return createIfExpCS();
			case EssentialOCLCSPackage.INFIX_EXP_CS: return createInfixExpCS();
			case EssentialOCLCSPackage.INVALID_LITERAL_EXP_CS: return createInvalidLiteralExpCS();
			case EssentialOCLCSPackage.LET_EXP_CS: return createLetExpCS();
			case EssentialOCLCSPackage.LET_VARIABLE_CS: return createLetVariableCS();
			case EssentialOCLCSPackage.LITERAL_EXP_CS: return createLiteralExpCS();
			case EssentialOCLCSPackage.NAME_EXP_CS: return createNameExpCS();
			case EssentialOCLCSPackage.NAVIGATING_ARG_CS: return createNavigatingArgCS();
			case EssentialOCLCSPackage.NAVIGATION_OPERATOR_CS: return createNavigationOperatorCS();
			case EssentialOCLCSPackage.NESTED_EXP_CS: return createNestedExpCS();
			case EssentialOCLCSPackage.NULL_LITERAL_EXP_CS: return createNullLiteralExpCS();
			case EssentialOCLCSPackage.NUMBER_LITERAL_EXP_CS: return createNumberLiteralExpCS();
			case EssentialOCLCSPackage.PREFIX_EXP_CS: return createPrefixExpCS();
			case EssentialOCLCSPackage.PRIMITIVE_LITERAL_EXP_CS: return createPrimitiveLiteralExpCS();
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS: return createRoundBracketedClauseCS();
			case EssentialOCLCSPackage.SELF_EXP_CS: return createSelfExpCS();
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS: return createSquareBracketedClauseCS();
			case EssentialOCLCSPackage.STRING_LITERAL_EXP_CS: return createStringLiteralExpCS();
			case EssentialOCLCSPackage.TUPLE_LITERAL_EXP_CS: return createTupleLiteralExpCS();
			case EssentialOCLCSPackage.TUPLE_LITERAL_PART_CS: return createTupleLiteralPartCS();
			case EssentialOCLCSPackage.TYPE_LITERAL_EXP_CS: return createTypeLiteralExpCS();
			case EssentialOCLCSPackage.TYPE_NAME_EXP_CS: return createTypeNameExpCS();
			case EssentialOCLCSPackage.UNARY_OPERATOR_CS: return createUnaryOperatorCS();
			case EssentialOCLCSPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS: return createUnlimitedNaturalLiteralExpCS();
			case EssentialOCLCSPackage.VARIABLE_CS: return createVariableCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID())
		{
			case EssentialOCLCSPackage.NAVIGATION_ROLE:
				return createNavigationRoleFromString(eDataType, initialValue);
			case EssentialOCLCSPackage.BIG_NUMBER:
				return createBigNumberFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID())
		{
			case EssentialOCLCSPackage.NAVIGATION_ROLE:
				return convertNavigationRoleToString(eDataType, instanceValue);
			case EssentialOCLCSPackage.BIG_NUMBER:
				return convertBigNumberToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryOperatorCS createBinaryOperatorCS() {
		BinaryOperatorCSImpl binaryOperatorCS = new BinaryOperatorCSImpl();
		return binaryOperatorCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrefixExpCS createPrefixExpCS() {
		PrefixExpCSImpl prefixExpCS = new PrefixExpCSImpl();
		return prefixExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionTypeCS createCollectionTypeCS() {
		CollectionTypeCSImpl collectionTypeCS = new CollectionTypeCSImpl();
		return collectionTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstructorExpCS createConstructorExpCS()
	{
		ConstructorExpCSImpl constructorExpCS = new ConstructorExpCSImpl();
		return constructorExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstructorPartCS createConstructorPartCS() {
		ConstructorPartCSImpl constructorPartCS = new ConstructorPartCSImpl();
		return constructorPartCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextCS createContextCS() {
		ContextCSImpl contextCS = new ContextCSImpl();
		return contextCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurlyBracketedClauseCS createCurlyBracketedClauseCS()
	{
		CurlyBracketedClauseCSImpl curlyBracketedClauseCS = new CurlyBracketedClauseCSImpl();
		return curlyBracketedClauseCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS createExpCS() {
		ExpCSImpl expCS = new ExpCSImpl();
		return expCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpSpecificationCS createExpSpecificationCS() {
		ExpSpecificationCSImpl expSpecificationCS = new ExpSpecificationCSImpl();
		return expSpecificationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeLiteralExpCS createTypeLiteralExpCS() {
		TypeLiteralExpCSImpl typeLiteralExpCS = new TypeLiteralExpCSImpl();
		return typeLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeNameExpCS createTypeNameExpCS() {
		TypeNameExpCSImpl typeNameExpCS = new TypeNameExpCSImpl();
		return typeNameExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryOperatorCS createUnaryOperatorCS() {
		UnaryOperatorCSImpl unaryOperatorCS = new UnaryOperatorCSImpl();
		return unaryOperatorCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnlimitedNaturalLiteralExpCS createUnlimitedNaturalLiteralExpCS() {
		UnlimitedNaturalLiteralExpCSImpl unlimitedNaturalLiteralExpCS = new UnlimitedNaturalLiteralExpCSImpl();
		return unlimitedNaturalLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCS createVariableCS() {
		VariableCSImpl variableCS = new VariableCSImpl();
		return variableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationRole createNavigationRoleFromString(EDataType eDataType,
			String initialValue) {
		NavigationRole result = NavigationRole.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNavigationRoleToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralExpCS createLiteralExpCS() {
		LiteralExpCSImpl literalExpCS = new LiteralExpCSImpl();
		return literalExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpCS createNameExpCS() {
		NameExpCSImpl nameExpCS = new NameExpCSImpl();
		return nameExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigatingArgCS createNavigatingArgCS() {
		NavigatingArgCSImpl navigatingArgCS = new NavigatingArgCSImpl();
		return navigatingArgCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationOperatorCS createNavigationOperatorCS() {
		NavigationOperatorCSImpl navigationOperatorCS = new NavigationOperatorCSImpl();
		return navigationOperatorCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedExpCS createNestedExpCS() {
		NestedExpCSImpl nestedExpCS = new NestedExpCSImpl();
		return nestedExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionLiteralExpCS createCollectionLiteralExpCS() {
		CollectionLiteralExpCSImpl collectionLiteralExpCS = new CollectionLiteralExpCSImpl();
		return collectionLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionLiteralPartCS createCollectionLiteralPartCS() {
		CollectionLiteralPartCSImpl collectionLiteralPartCS = new CollectionLiteralPartCSImpl();
		return collectionLiteralPartCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveLiteralExpCS createPrimitiveLiteralExpCS() {
		PrimitiveLiteralExpCSImpl primitiveLiteralExpCS = new PrimitiveLiteralExpCSImpl();
		return primitiveLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoundBracketedClauseCS createRoundBracketedClauseCS()
	{
		RoundBracketedClauseCSImpl roundBracketedClauseCS = new RoundBracketedClauseCSImpl();
		return roundBracketedClauseCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelfExpCS createSelfExpCS() {
		SelfExpCSImpl selfExpCS = new SelfExpCSImpl();
		return selfExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SquareBracketedClauseCS createSquareBracketedClauseCS()
	{
		SquareBracketedClauseCSImpl squareBracketedClauseCS = new SquareBracketedClauseCSImpl();
		return squareBracketedClauseCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleLiteralExpCS createTupleLiteralExpCS() {
		TupleLiteralExpCSImpl tupleLiteralExpCS = new TupleLiteralExpCSImpl();
		return tupleLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleLiteralPartCS createTupleLiteralPartCS() {
		TupleLiteralPartCSImpl tupleLiteralPartCS = new TupleLiteralPartCSImpl();
		return tupleLiteralPartCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExpCS createStringLiteralExpCS() {
		StringLiteralExpCSImpl stringLiteralExpCS = new StringLiteralExpCSImpl();
		return stringLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteralExpCS createBooleanLiteralExpCS() {
		BooleanLiteralExpCSImpl booleanLiteralExpCS = new BooleanLiteralExpCSImpl();
		return booleanLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvalidLiteralExpCS createInvalidLiteralExpCS() {
		InvalidLiteralExpCSImpl invalidLiteralExpCS = new InvalidLiteralExpCSImpl();
		return invalidLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullLiteralExpCS createNullLiteralExpCS() {
		NullLiteralExpCSImpl nullLiteralExpCS = new NullLiteralExpCSImpl();
		return nullLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberLiteralExpCS createNumberLiteralExpCS() {
		NumberLiteralExpCSImpl numberLiteralExpCS = new NumberLiteralExpCSImpl();
		return numberLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Number createBigNumberFromString(EDataType eDataType,
			String initialValue) {
		return (Number)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBigNumberToString(EDataType eDataType,
			Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EssentialOCLCSPackage getEssentialOCLCSPackage() {
		return (EssentialOCLCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfExpCS createIfExpCS() {
		IfExpCSImpl ifExpCS = new IfExpCSImpl();
		return ifExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfixExpCS createInfixExpCS() {
		InfixExpCSImpl infixExpCS = new InfixExpCSImpl();
		return infixExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExpCS createLetExpCS() {
		LetExpCSImpl letExpCS = new LetExpCSImpl();
		return letExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetVariableCS createLetVariableCS() {
		LetVariableCSImpl letVariableCS = new LetVariableCSImpl();
		return letVariableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EssentialOCLCSPackage getPackage() {
		return EssentialOCLCSPackage.eINSTANCE;
	}

} //EssentialOCLCSFactoryImpl
