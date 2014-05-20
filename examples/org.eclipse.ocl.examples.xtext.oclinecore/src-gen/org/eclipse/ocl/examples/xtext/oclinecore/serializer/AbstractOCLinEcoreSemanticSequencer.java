/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.oclinecore.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DetailCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.EnumerationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS;
import org.eclipse.ocl.examples.xtext.base.basecs.OperationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementWithURICS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IndexExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.serializer.EssentialOCLSemanticSequencer;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.SysMLCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.TopLevelCS;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public abstract class AbstractOCLinEcoreSemanticSequencer extends EssentialOCLSemanticSequencer {

	@Inject
	private OCLinEcoreGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == BaseCSPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case BaseCSPackage.ANNOTATION_CS:
				if(context == grammarAccess.getAnnotationCSRule() ||
				   context == grammarAccess.getAnnotationElementCSRule()) {
					sequence_AnnotationCS(context, (AnnotationCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.ATTRIBUTE_CS:
				if(context == grammarAccess.getAttributeCSRule() ||
				   context == grammarAccess.getModelElementCSRule() ||
				   context == grammarAccess.getStructuralFeatureCSRule()) {
					sequence_AttributeCS(context, (AttributeCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.CLASS_CS:
				if(context == grammarAccess.getClassCSRule() ||
				   context == grammarAccess.getClassifierCSRule() ||
				   context == grammarAccess.getModelElementCSRule()) {
					sequence_ClassCS(context, (ClassCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.DATA_TYPE_CS:
				if(context == grammarAccess.getClassifierCSRule() ||
				   context == grammarAccess.getDataTypeCSRule() ||
				   context == grammarAccess.getModelElementCSRule()) {
					sequence_DataTypeCS(context, (DataTypeCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.DETAIL_CS:
				if(context == grammarAccess.getDetailCSRule()) {
					sequence_DetailCS(context, (DetailCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.DOCUMENTATION_CS:
				if(context == grammarAccess.getAnnotationElementCSRule() ||
				   context == grammarAccess.getDocumentationCSRule()) {
					sequence_DocumentationCS(context, (DocumentationCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.ENUMERATION_CS:
				if(context == grammarAccess.getClassifierCSRule() ||
				   context == grammarAccess.getEnumerationCSRule() ||
				   context == grammarAccess.getModelElementCSRule()) {
					sequence_EnumerationCS(context, (EnumerationCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.ENUMERATION_LITERAL_CS:
				if(context == grammarAccess.getEnumerationLiteralCSRule() ||
				   context == grammarAccess.getModelElementCSRule()) {
					sequence_EnumerationLiteralCS(context, (EnumerationLiteralCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.IMPORT_CS:
				if(context == grammarAccess.getImportCSRule()) {
					sequence_ImportCS(context, (ImportCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.LIBRARY_CS:
				if(context == grammarAccess.getLibraryCSRule()) {
					sequence_LibraryCS(context, (LibraryCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.MODEL_ELEMENT_REF_CS:
				if(context == grammarAccess.getModelElementRefCSRule()) {
					sequence_ModelElementRefCS(context, (ModelElementRefCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.MULTIPLICITY_BOUNDS_CS:
				if(context == grammarAccess.getMultiplicityBoundsCSRule() ||
				   context == grammarAccess.getMultiplicityCSRule()) {
					sequence_MultiplicityBoundsCS(context, (MultiplicityBoundsCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.MULTIPLICITY_STRING_CS:
				if(context == grammarAccess.getMultiplicityCSRule() ||
				   context == grammarAccess.getMultiplicityStringCSRule()) {
					sequence_MultiplicityStringCS(context, (MultiplicityStringCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.OPERATION_CS:
				if(context == grammarAccess.getModelElementCSRule() ||
				   context == grammarAccess.getOperationCSRule()) {
					sequence_OperationCS(context, (OperationCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PACKAGE_CS:
				if(context == grammarAccess.getModelElementCSRule() ||
				   context == grammarAccess.getPackageCSRule()) {
					sequence_PackageCS(context, (PackageCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PARAMETER_CS:
				if(context == grammarAccess.getParameterCSRule()) {
					sequence_ParameterCS(context, (ParameterCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PATH_ELEMENT_CS:
				if(context == grammarAccess.getFirstPathElementCSRule()) {
					sequence_FirstPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNextPathElementCSRule()) {
					sequence_NextPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getURIFirstPathElementCSRule()) {
					sequence_URIFirstPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PATH_ELEMENT_WITH_URICS:
				if(context == grammarAccess.getURIFirstPathElementCSRule()) {
					sequence_URIFirstPathElementCS(context, (PathElementWithURICS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PATH_NAME_CS:
				if(context == grammarAccess.getPathNameCSRule()) {
					sequence_PathNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getURIPathNameCSRule()) {
					sequence_URIPathNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PRIMITIVE_TYPE_REF_CS:
				if(context == grammarAccess.getPrimitiveTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule() ||
				   context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getTypedRefCSRule()) {
					sequence_PrimitiveTypeCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_PrimitiveTypeCS_TypeExpCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_PrimitiveTypeCS_TypeLiteralWithMultiplicityCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_PrimitiveTypeCS_TypedMultiplicityRefCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.REFERENCE_CS:
				if(context == grammarAccess.getModelElementCSRule() ||
				   context == grammarAccess.getReferenceCSRule() ||
				   context == grammarAccess.getStructuralFeatureCSRule()) {
					sequence_ReferenceCS(context, (ReferenceCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TEMPLATE_BINDING_CS:
				if(context == grammarAccess.getTemplateBindingCSRule()) {
					sequence_TemplateBindingCS(context, (TemplateBindingCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TEMPLATE_PARAMETER_SUBSTITUTION_CS:
				if(context == grammarAccess.getTemplateParameterSubstitutionCSRule()) {
					sequence_TemplateParameterSubstitutionCS(context, (TemplateParameterSubstitutionCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TEMPLATE_SIGNATURE_CS:
				if(context == grammarAccess.getTemplateSignatureCSRule()) {
					sequence_TemplateSignatureCS(context, (TemplateSignatureCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TUPLE_PART_CS:
				if(context == grammarAccess.getTuplePartCSRule()) {
					sequence_TuplePartCS(context, (TuplePartCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TUPLE_TYPE_CS:
				if(context == grammarAccess.getTupleTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule() ||
				   context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getTypedRefCSRule()) {
					sequence_TupleTypeCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_TupleTypeCS_TypeExpCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_TupleTypeCS_TypeLiteralWithMultiplicityCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_TupleTypeCS_TypedMultiplicityRefCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TYPE_PARAMETER_CS:
				if(context == grammarAccess.getTypeParameterCSRule()) {
					sequence_TypeParameterCS(context, (TypeParameterCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TYPED_TYPE_REF_CS:
				if(context == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_TypedMultiplicityRefCS_TypedTypeRefCS(context, (TypedTypeRefCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getTypedRefCSRule() ||
				   context == grammarAccess.getTypedTypeRefCSRule()) {
					sequence_TypedTypeRefCS(context, (TypedTypeRefCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.WILDCARD_TYPE_REF_CS:
				if(context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getWildcardTypeRefCSRule()) {
					sequence_WildcardTypeRefCS(context, (WildcardTypeRefCS) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == EssentialOCLCSPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EssentialOCLCSPackage.BINARY_OPERATOR_CS:
				if(context == grammarAccess.getBinaryOperatorCSRule() ||
				   context == grammarAccess.getEssentialOCLInfixOperatorCSRule() ||
				   context == grammarAccess.getInfixOperatorCSRule()) {
					sequence_EssentialOCLInfixOperatorCS(context, (BinaryOperatorCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.BOOLEAN_LITERAL_EXP_CS:
				if(context == grammarAccess.getBooleanLiteralExpCSRule() ||
				   context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule()) {
					sequence_BooleanLiteralExpCS(context, (BooleanLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.COLLECTION_LITERAL_EXP_CS:
				if(context == grammarAccess.getCollectionLiteralExpCSRule() ||
				   context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_CollectionLiteralExpCS(context, (CollectionLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS:
				if(context == grammarAccess.getCollectionLiteralPartCSRule()) {
					sequence_CollectionLiteralPartCS(context, (CollectionLiteralPartCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.COLLECTION_TYPE_CS:
				if(context == grammarAccess.getCollectionTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule() ||
				   context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getTypedRefCSRule()) {
					sequence_CollectionTypeCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_CollectionTypeCS_TypeExpCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_CollectionTypeCS_TypeLiteralWithMultiplicityCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_CollectionTypeCS_TypedMultiplicityRefCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.CONSTRUCTOR_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_PrimaryExpCS(context, (ConstructorExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS:
				if(context == grammarAccess.getConstructorPartCSRule()) {
					sequence_ConstructorPartCS(context, (ConstructorPartCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.CONTEXT_CS:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (ContextCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.EXP_SPECIFICATION_CS:
				if(context == grammarAccess.getSpecificationCSRule()) {
					sequence_SpecificationCS(context, (ExpSpecificationCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.IF_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getIfExpCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_IfExpCS(context, (IfExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.INDEX_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_PrimaryExpCS(context, (IndexExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.INFIX_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule()) {
					sequence_ExpCS(context, (InfixExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.INVALID_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getInvalidLiteralExpCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule()) {
					sequence_InvalidLiteralExpCS(context, (InvalidLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.INVOCATION_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_PrimaryExpCS(context, (InvocationExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.LET_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getLetExpCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule()) {
					sequence_LetExpCS(context, (LetExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.LET_VARIABLE_CS:
				if(context == grammarAccess.getLetVariableCSRule()) {
					sequence_LetVariableCS(context, (LetVariableCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NAME_EXP_CS:
				if(context == grammarAccess.getPrimaryExpCSAccess().getConstructorExpCSNameExpAction_7_2_1_0() ||
				   context == grammarAccess.getPrimaryExpCSAccess().getIndexExpCSNameExpAction_7_2_0_0()) {
					sequence_PrimaryExpCS_ConstructorExpCS_7_2_1_0_IndexExpCS_7_2_0_0(context, (NameExpCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSAccess().getInvocationExpCSNameExpAction_7_2_2_1_0()) {
					sequence_PrimaryExpCS(context, (NameExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NAVIGATING_ARG_CS:
				if(context == grammarAccess.getNavigatingArgCSRule()) {
					sequence_NavigatingArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNavigatingBarArgCSRule()) {
					sequence_NavigatingBarArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNavigatingCommaArgCSRule()) {
					sequence_NavigatingCommaArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNavigatingSemiArgCSRule()) {
					sequence_NavigatingSemiArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NAVIGATION_OPERATOR_CS:
				if(context == grammarAccess.getBinaryOperatorCSRule() ||
				   context == grammarAccess.getEssentialOCLNavigationOperatorCSRule() ||
				   context == grammarAccess.getNavigationOperatorCSRule()) {
					sequence_EssentialOCLNavigationOperatorCS(context, (NavigationOperatorCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NESTED_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getNestedExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_NestedExpCS(context, (NestedExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NULL_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getNullLiteralExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule()) {
					sequence_NullLiteralExpCS(context, (NullLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NUMBER_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getNumberLiteralExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule()) {
					sequence_NumberLiteralExpCS(context, (NumberLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.PREFIX_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule()) {
					sequence_ExpCS_PrefixedExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getPrefixedExpCSRule()) {
					sequence_PrefixedExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.SELF_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getSelfExpCSRule()) {
					sequence_SelfExpCS(context, (SelfExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.STRING_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule() ||
				   context == grammarAccess.getStringLiteralExpCSRule()) {
					sequence_StringLiteralExpCS(context, (StringLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.TUPLE_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getTupleLiteralExpCSRule()) {
					sequence_TupleLiteralExpCS(context, (TupleLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.TUPLE_LITERAL_PART_CS:
				if(context == grammarAccess.getTupleLiteralPartCSRule()) {
					sequence_TupleLiteralPartCS(context, (TupleLiteralPartCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.TYPE_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getTypeLiteralExpCSRule()) {
					sequence_TypeLiteralExpCS(context, (TypeLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.TYPE_NAME_EXP_CS:
				if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_TypeExpCS_TypeNameExpCS(context, (TypeNameExpCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeNameExpCSRule()) {
					sequence_TypeNameExpCS(context, (TypeNameExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.UNARY_OPERATOR_CS:
				if(context == grammarAccess.getEssentialOCLUnaryOperatorCSRule() ||
				   context == grammarAccess.getUnaryOperatorCSRule()) {
					sequence_EssentialOCLUnaryOperatorCS(context, (UnaryOperatorCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedExpressionAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule() ||
				   context == grammarAccess.getUnlimitedNaturalLiteralExpCSRule()) {
					sequence_UnlimitedNaturalLiteralExpCS(context, (UnlimitedNaturalLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == OCLinEcoreCSPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case OCLinEcoreCSPackage.OC_LIN_ECORE_CONSTRAINT_CS:
				if(context == grammarAccess.getInvariantConstraintCSRule()) {
					sequence_InvariantConstraintCS(context, (OCLinEcoreConstraintCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPostconditionConstraintCSRule()) {
					sequence_PostconditionConstraintCS(context, (OCLinEcoreConstraintCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPreconditionConstraintCSRule()) {
					sequence_PreconditionConstraintCS(context, (OCLinEcoreConstraintCS) semanticObject); 
					return; 
				}
				else break;
			case OCLinEcoreCSPackage.SYS_MLCS:
				if(context == grammarAccess.getAnnotationElementCSRule() ||
				   context == grammarAccess.getSysMLCSRule()) {
					sequence_SysMLCS(context, (SysMLCS) semanticObject); 
					return; 
				}
				else break;
			case OCLinEcoreCSPackage.TOP_LEVEL_CS:
				if(context == grammarAccess.getTopLevelCSRule()) {
					sequence_TopLevelCS(context, (TopLevelCS) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         (name=UnrestrictedName | name=SINGLE_QUOTED_STRING)? 
	 *         (ownedDetail+=DetailCS ownedDetail+=DetailCS*)? 
	 *         (ownedAnnotation+=AnnotationElementCS | ownedContent+=ModelElementCS | ownedReference+=ModelElementRefCS)*
	 *     )
	 */
	protected void sequence_AnnotationCS(EObject context, AnnotationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((qualifier+='static' qualifier+='definition'?) | (qualifier+='definition' qualifier+='static'?))? 
	 *         name=UnrestrictedName 
	 *         ownedType=TypedMultiplicityRefCS? 
	 *         default=SINGLE_QUOTED_STRING? 
	 *         (
	 *             qualifier+='derived' | 
	 *             qualifier+='!derived' | 
	 *             qualifier+='id' | 
	 *             qualifier+='!id' | 
	 *             qualifier+='ordered' | 
	 *             qualifier+='!ordered' | 
	 *             qualifier+='readonly' | 
	 *             qualifier+='!readonly' | 
	 *             qualifier+='transient' | 
	 *             qualifier+='!transient' | 
	 *             qualifier+='unique' | 
	 *             qualifier+='!unique' | 
	 *             qualifier+='unsettable' | 
	 *             qualifier+='!unsettable' | 
	 *             qualifier+='volatile' | 
	 *             qualifier+='!volatile'
	 *         )* 
	 *         (ownedAnnotation+=AnnotationElementCS | ownedDefaultExpression+=SpecificationCS? | ownedDefaultExpression+=SpecificationCS?)*
	 *     )
	 */
	protected void sequence_AttributeCS(EObject context, AttributeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         qualifier+='abstract'? 
	 *         name=UnrestrictedName 
	 *         ownedTemplateSignature=TemplateSignatureCS? 
	 *         (ownedSuperType+=TypedRefCS ownedSuperType+=TypedRefCS*)? 
	 *         instanceClassName=SINGLE_QUOTED_STRING? 
	 *         qualifier+='interface'? 
	 *         (ownedAnnotation+=AnnotationElementCS | ownedOperation+=OperationCS | ownedProperty+=StructuralFeatureCS | ownedConstraint+=InvariantConstraintCS)*
	 *     )
	 */
	protected void sequence_ClassCS(EObject context, ClassCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=CollectionTypeIdentifier ownedType=TypeExpCS? multiplicity=MultiplicityCS?)
	 */
	protected void sequence_CollectionTypeCS_TypedMultiplicityRefCS(EObject context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName 
	 *         ownedTemplateSignature=TemplateSignatureCS? 
	 *         instanceClassName=SINGLE_QUOTED_STRING? 
	 *         (qualifier+='serializable' | qualifier+='!serializable')? 
	 *         (ownedAnnotation+=AnnotationElementCS | ownedConstraint+=InvariantConstraintCS)*
	 *     )
	 */
	protected void sequence_DataTypeCS(EObject context, DataTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=UnrestrictedName | name=SINGLE_QUOTED_STRING) (value+=SINGLE_QUOTED_STRING | value+=ML_SINGLE_QUOTED_STRING)*)
	 */
	protected void sequence_DetailCS(EObject context, DetailCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=SINGLE_QUOTED_STRING? (ownedDetail+=DetailCS ownedDetail+=DetailCS*)?)
	 */
	protected void sequence_DocumentationCS(EObject context, DocumentationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName 
	 *         ownedTemplateSignature=TemplateSignatureCS? 
	 *         instanceClassName=SINGLE_QUOTED_STRING? 
	 *         (qualifier+='serializable' | qualifier+='!serializable')? 
	 *         (ownedAnnotation+=AnnotationElementCS | ownedLiterals+=EnumerationLiteralCS | ownedConstraint+=InvariantConstraintCS)*
	 *     )
	 */
	protected void sequence_EnumerationCS(EObject context, EnumerationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=UnrestrictedName | name=EnumerationLiteralName) value=SIGNED? ownedAnnotation+=AnnotationElementCS*)
	 */
	protected void sequence_EnumerationLiteralCS(EObject context, EnumerationLiteralCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName? pathName=URIPathNameCS all?='::'?)
	 */
	protected void sequence_ImportCS(EObject context, ImportCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (callable?='callable'? stereotype='invariant' (name=UnrestrictedName messageSpecification=SpecificationCS?)? specification=SpecificationCS?)
	 */
	protected void sequence_InvariantConstraintCS(EObject context, OCLinEcoreConstraintCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName? package=[Package|URI])
	 */
	protected void sequence_LibraryCS(EObject context, LibraryCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     pathName=PathNameCS
	 */
	protected void sequence_ModelElementRefCS(EObject context, ModelElementRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((qualifier+='static' qualifier+='definition'?) | (qualifier+='definition' qualifier+='static'?))? 
	 *         ownedTemplateSignature=TemplateSignatureCS? 
	 *         name=UnrestrictedName 
	 *         (ownedParameter+=ParameterCS ownedParameter+=ParameterCS*)? 
	 *         ownedType=TypedMultiplicityRefCS? 
	 *         (ownedException+=TypedRefCS ownedException+=TypedRefCS*)? 
	 *         (
	 *             qualifier+='derived' | 
	 *             qualifier+='!derived' | 
	 *             qualifier+='ordered' | 
	 *             qualifier+='!ordered' | 
	 *             qualifier+='unique' | 
	 *             qualifier+='!unique'
	 *         )* 
	 *         (
	 *             ownedAnnotation+=AnnotationElementCS | 
	 *             ownedPrecondition+=PreconditionConstraintCS | 
	 *             ownedBodyExpression+=SpecificationCS? | 
	 *             ownedPostcondition+=PostconditionConstraintCS
	 *         )*
	 *     )
	 */
	protected void sequence_OperationCS(EObject context, OperationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName 
	 *         nsPrefix=UnrestrictedName? 
	 *         nsURI=URI? 
	 *         (ownedAnnotation+=AnnotationElementCS | ownedNestedPackage+=PackageCS | ownedType+=ClassifierCS)*
	 *     )
	 */
	protected void sequence_PackageCS(EObject context, PackageCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName 
	 *         ownedType=TypedMultiplicityRefCS? 
	 *         (qualifier+='ordered' | qualifier+='!ordered' | qualifier+='unique' | qualifier+='!unique')* 
	 *         ownedAnnotation+=AnnotationElementCS*
	 *     )
	 */
	protected void sequence_ParameterCS(EObject context, ParameterCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (stereotype='postcondition' (name=UnrestrictedName messageSpecification=SpecificationCS?)? specification=SpecificationCS?)
	 */
	protected void sequence_PostconditionConstraintCS(EObject context, OCLinEcoreConstraintCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (stereotype='precondition' (name=UnrestrictedName messageSpecification=SpecificationCS?)? specification=SpecificationCS?)
	 */
	protected void sequence_PreconditionConstraintCS(EObject context, OCLinEcoreConstraintCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=PrimitiveTypeIdentifier multiplicity=MultiplicityCS?)
	 */
	protected void sequence_PrimitiveTypeCS_TypedMultiplicityRefCS(EObject context, PrimitiveTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((qualifier+='static' qualifier+='definition'?) | (qualifier+='definition' qualifier+='static'?))? 
	 *         name=UnrestrictedName 
	 *         opposite=[Property|UnrestrictedName]? 
	 *         ownedType=TypedMultiplicityRefCS? 
	 *         default=SINGLE_QUOTED_STRING? 
	 *         (
	 *             qualifier+='composes' | 
	 *             qualifier+='!composes' | 
	 *             qualifier+='derived' | 
	 *             qualifier+='!derived' | 
	 *             qualifier+='ordered' | 
	 *             qualifier+='!ordered' | 
	 *             qualifier+='readonly' | 
	 *             qualifier+='!readonly' | 
	 *             qualifier+='resolve' | 
	 *             qualifier+='!resolve' | 
	 *             qualifier+='transient' | 
	 *             qualifier+='!transient' | 
	 *             qualifier+='unique' | 
	 *             qualifier+='!unique' | 
	 *             qualifier+='unsettable' | 
	 *             qualifier+='!unsettable' | 
	 *             qualifier+='volatile' | 
	 *             qualifier+='!volatile'
	 *         )* 
	 *         (
	 *             ownedAnnotation+=AnnotationElementCS | 
	 *             (keys+=[Property|UnrestrictedName] keys+=[Property|UnrestrictedName]*) | 
	 *             ownedDefaultExpression+=SpecificationCS? | 
	 *             ownedDefaultExpression+=SpecificationCS?
	 *         )*
	 *     )
	 */
	protected void sequence_ReferenceCS(EObject context, ReferenceCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedExpression=ExpCS | exprString=UNQUOTED_STRING)
	 */
	protected void sequence_SpecificationCS(EObject context, ExpSpecificationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedDetail+=DetailCS | ownedDetail+=DetailCS*)
	 */
	protected void sequence_SysMLCS(EObject context, SysMLCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (ownedParameterSubstitution+=TemplateParameterSubstitutionCS ownedParameterSubstitution+=TemplateParameterSubstitutionCS*) | 
	 *         (ownedParameterSubstitution+=TemplateParameterSubstitutionCS ownedParameterSubstitution+=TemplateParameterSubstitutionCS*)
	 *     )
	 */
	protected void sequence_TemplateBindingCS(EObject context, TemplateBindingCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedActualParameter=TypeRefCS
	 */
	protected void sequence_TemplateParameterSubstitutionCS(EObject context, TemplateParameterSubstitutionCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (ownedTemplateParameter+=TypeParameterCS ownedTemplateParameter+=TypeParameterCS*) | 
	 *         (ownedTemplateParameter+=TypeParameterCS ownedTemplateParameter+=TypeParameterCS*)
	 *     )
	 */
	protected void sequence_TemplateSignatureCS(EObject context, TemplateSignatureCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedLibrary+=LibraryCS* ownedImport+=ImportCS* ownedNestedPackage+=PackageCS*)
	 */
	protected void sequence_TopLevelCS(EObject context, TopLevelCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)? multiplicity=MultiplicityCS?)
	 */
	protected void sequence_TupleTypeCS_TypedMultiplicityRefCS(EObject context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName ((ownedExtends+=TypedRefCS ownedExtends+=TypedRefCS*) | ownedSuper=TypedRefCS)?)
	 */
	protected void sequence_TypeParameterCS(EObject context, TypeParameterCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (pathName=PathNameCS ownedTemplateBinding=TemplateBindingCS? multiplicity=MultiplicityCS?)
	 */
	protected void sequence_TypedMultiplicityRefCS_TypedTypeRefCS(EObject context, TypedTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (pathName=PathNameCS ownedTemplateBinding=TemplateBindingCS?)
	 */
	protected void sequence_TypedTypeRefCS(EObject context, TypedTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((extends=TypedRefCS | super=TypedRefCS)?)
	 */
	protected void sequence_WildcardTypeRefCS(EObject context, WildcardTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
