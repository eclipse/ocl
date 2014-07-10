/*******************************************************************************
 * Copyright (c) 2010, 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSFactory;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.BaseDeclarationVisitor;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSFactory;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS;

public class EssentialOCLDeclarationVisitor extends BaseDeclarationVisitor
{
	public static final @NonNull TuplePartId TUPLE_MESSAGE_STATUS_0 = IdManager.getTuplePartId(0, PivotConstants.MESSAGE_PART_NAME, TypeId.STRING);
	public static final @NonNull TuplePartId TUPLE_MESSAGE_STATUS_1 = IdManager.getTuplePartId(1, PivotConstants.STATUS_PART_NAME, TypeId.BOOLEAN);
	public static final @NonNull TupleTypeId TUPLE_MESSAGE_STATUS = IdManager.getTupleTypeId("Tuple", TUPLE_MESSAGE_STATUS_0, TUPLE_MESSAGE_STATUS_1);

	public EssentialOCLDeclarationVisitor(@NonNull Pivot2CSConversion context) {
		super(context);
	}	

	private void appendInfixChild(@NonNull InfixExpCS csInfixExp, @NonNull BinaryOperatorCS csOperator) {	// FIXME NestedExpCS, UnaryOperatorCS
		ExpCS csSource = csOperator.getSource();
		if (csSource instanceof BinaryOperatorCS) {
			appendInfixChild(csInfixExp, (BinaryOperatorCS) csSource);
		}
		else if (csSource instanceof InfixExpCS) {
			csInfixExp.getOwnedExpression().addAll(((InfixExpCS)csSource).getOwnedExpression());
			csInfixExp.getOwnedOperator().addAll(((InfixExpCS)csSource).getOwnedOperator());
		}
		else {
			csInfixExp.getOwnedExpression().add(csSource);
		}
		csInfixExp.getOwnedOperator().add(csOperator);
		ExpCS csArgument = csOperator.getArgument();
		if (csArgument instanceof BinaryOperatorCS) {
			appendInfixChild(csInfixExp, (BinaryOperatorCS) csArgument);
		}
		else if (csArgument instanceof InfixExpCS) {
			csInfixExp.getOwnedExpression().addAll(((InfixExpCS)csArgument).getOwnedExpression());
			csInfixExp.getOwnedOperator().addAll(((InfixExpCS)csArgument).getOwnedOperator());
		}
		else {
			csInfixExp.getOwnedExpression().add(csArgument);
		}
	}

	/**
	 * @since 3.5
	 */
	protected ExpCS createExpCS(OCLExpression oclExpression) {			// FIXME Unary, Nested
		ExpCS csExp = context.visitDeclaration(ExpCS.class, oclExpression);
		if (csExp instanceof BinaryOperatorCS) {
			InfixExpCS csInfixExp = EssentialOCLCSFactory.eINSTANCE.createInfixExpCS();
			appendInfixChild(csInfixExp, (BinaryOperatorCS)csExp);
			return csInfixExp;
		}
		else {
			return csExp;
		}
	}

	/**
	 * @since 3.5
	 */
	protected @NonNull NameExpCS createNameExpCS(NamedElement asNamedElement) {
		NameExpCS csNameExp = EssentialOCLCSFactory.eINSTANCE.createNameExpCS();
		PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
		PathElementCS csPathElement = BaseCSFactory.eINSTANCE.createPathElementCS();
		csPathElement.setElement(asNamedElement);
		csPathName.getPath().add(csPathElement);
		csNameExp.setPathName(csPathName);
		return csNameExp;
	}

	/**
	 * @since 3.5
	 */
	protected @NonNull NavigatingArgCS createNavigatingArgCS(@Nullable String prefix, /*@NonNull*/ OCLExpression csExp) {
		NavigatingArgCS csNavigatingArg = EssentialOCLCSFactory.eINSTANCE.createNavigatingArgCS();
		csNavigatingArg.setPrefix(prefix);
		csNavigatingArg.setName(createExpCS(csExp));
		return csNavigatingArg;
	}

	/**
	 * @since 3.5
	 */
	protected NavigatingArgCS createNavigatingArgCS(@Nullable String prefix, /*@NonNull*/ NamedElement asNamedElement, @Nullable TypedElement asTypedElement, @Nullable OCLExpression csInit) {
		NavigatingArgCS csNavigatingArg = EssentialOCLCSFactory.eINSTANCE.createNavigatingArgCS();
		csNavigatingArg.setPrefix(prefix);
		csNavigatingArg.setName(createNameExpCS(asNamedElement));
		if (asTypedElement != null) {
			csNavigatingArg.setOwnedType(createTypeRefCS(asTypedElement.getType()));
		}
		if (csInit != null) {
			csNavigatingArg.setInit(createExpCS(csInit));
		}
		return csNavigatingArg;
	}

	/**
	 * @since 3.5
	 */
	protected @NonNull ExpCS createNavigationOperatorCS(@Nullable OCLExpression asSource, @NonNull ExpCS csArgument) {
		if (asSource == null) {
			return csArgument;
		}
		else {
			Type asType = asSource.getType();
			NavigationOperatorCS csNavigationOperator = EssentialOCLCSFactory.eINSTANCE.createNavigationOperatorCS();
			csNavigationOperator.setSource(createExpCS(asSource));
			csNavigationOperator.setName(asType instanceof CollectionType ? PivotConstants.COLLECTION_NAVIGATION_OPERATOR : PivotConstants.OBJECT_NAVIGATION_OPERATOR);
			csNavigationOperator.setArgument(csArgument);
			return csNavigationOperator;
		}
	}

	/**
	 * @since 3.5
	 */
	protected @Nullable TypedRefCS createTypeRefCS(@Nullable Type asType) {
		return asType != null ? context.visitReference(TypedRefCS.class, asType) : null;
	}

	protected ElementCS refreshConstraint(@NonNull ConstraintCS csElement, @NonNull Constraint object) {
		if (object.eContainmentFeature() == PivotPackage.Literals.OPERATION__POSTCONDITION) {
			csElement.setStereotype(UMLReflection.POSTCONDITION);
		}
		else if (object.eContainmentFeature() == PivotPackage.Literals.OPERATION__PRECONDITION) {
			csElement.setStereotype(UMLReflection.PRECONDITION);
		}
		else {
			csElement.setStereotype(UMLReflection.INVARIANT);
		}
		OpaqueExpression specification = object.getSpecification();
		if (specification instanceof ExpressionInOCL) {
			OCLExpression bodyExpression = ((ExpressionInOCL)specification).getBodyExpression();
			if ((bodyExpression instanceof TupleLiteralExp) && (bodyExpression.getTypeId() == TUPLE_MESSAGE_STATUS)) {
				TupleLiteralPart messagePart = DomainUtil.getNamedElement(((TupleLiteralExp)bodyExpression).getPart(), TUPLE_MESSAGE_STATUS_0.getName());
				TupleLiteralPart statusPart = DomainUtil.getNamedElement(((TupleLiteralExp)bodyExpression).getPart(), TUPLE_MESSAGE_STATUS_1.getName());
				OCLExpression messageExpression = messagePart.getInitExpression();
				OCLExpression statusExpression = statusPart.getInitExpression();
				ExpSpecificationCS csMessage = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
				csMessage.setExprString(messageExpression != null ? PrettyPrinter.print(messageExpression) : "null");
				csElement.setMessageSpecification(csMessage);
				ExpSpecificationCS csStatus = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
				csStatus.setExprString(statusExpression != null ? PrettyPrinter.print(statusExpression) : "null");
				csElement.setSpecification(csStatus);
				return csElement;
			}
		}
		else if (specification != null) {
			String body = PivotUtil.getBody(specification);
			if ((body != null) && body.startsWith("Tuple")) {
				String[] lines = body.split("\n");
				int lastLineNumber = lines.length-1;
				if ((lastLineNumber >= 3)
				 && lines[0].replaceAll("\\s", "").equals("Tuple{")
				 && lines[1].replaceAll("\\s", "").startsWith("message:String=")
				 && lines[lastLineNumber].replaceAll("\\s", "").equals("}.status")) {
					StringBuilder message = new StringBuilder();
					message.append(lines[1].substring(lines[1].indexOf("=")+1, lines[1].length()).trim());
					for (int i = 2; i < lastLineNumber; i++) {
						if (!lines[i].replaceAll("\\s", "").startsWith("status:Boolean=")) {
							message.append("\n" + lines[i]);
						}
						else {
							ExpSpecificationCS csMessage = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
							String messageString = message.toString();
							int lastIndex = messageString.lastIndexOf(',');
							if (lastIndex > 0) {
								messageString = messageString.substring(0, lastIndex); 
							}
							csMessage.setExprString(messageString);
							csElement.setMessageSpecification(csMessage);
							StringBuilder status = new StringBuilder();			
							status.append(lines[i].substring(lines[i].indexOf("=")+1, lines[i].length()).trim());
							for (i++; i < lastLineNumber; i++) {
								status.append("\n" + lines[i]);
							}
							ExpSpecificationCS csStatus = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
							csStatus.setExprString(status.toString());
							csElement.setSpecification(csStatus);
							return csElement;
						}					
					}
				}
			}
		}
		csElement.setSpecification(context.visitDeclaration(SpecificationCS.class, specification));	
		return csElement;
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitBooleanLiteralExp(@NonNull BooleanLiteralExp asBooleanLiteralExp) {
		BooleanLiteralExpCS csBooleanLiteralExp = EssentialOCLCSFactory.eINSTANCE.createBooleanLiteralExpCS();
		csBooleanLiteralExp.setName(Boolean.toString(asBooleanLiteralExp.isBooleanSymbol()));
		return csBooleanLiteralExp;
	}
	
	@Override
	public @Nullable ElementCS visitCallExp(@NonNull CallExp object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable ElementCS visitCollectionItem(@NonNull CollectionItem asCollectionItem) {
		CollectionLiteralPartCS csCollectionLiteralPart = EssentialOCLCSFactory.eINSTANCE.createCollectionLiteralPartCS();
		csCollectionLiteralPart.setExpressionCS(createExpCS(asCollectionItem.getItem()));
		return csCollectionLiteralPart;
	}

	@Override
	public @Nullable ElementCS visitCollectionLiteralExp(@NonNull CollectionLiteralExp asCollectionLiteralExp) {
		CollectionLiteralExpCS csCollectionLiteralExp = EssentialOCLCSFactory.eINSTANCE.createCollectionLiteralExpCS();
		csCollectionLiteralExp.setOwnedType((CollectionTypeCS) createTypeRefCS(asCollectionLiteralExp.getType()));
		List<CollectionLiteralPartCS> csOwnedParts = csCollectionLiteralExp.getOwnedParts();
		for (CollectionLiteralPart asPart : asCollectionLiteralExp.getPart()) {
			csOwnedParts.add(context.visitDeclaration(CollectionLiteralPartCS.class, asPart));
		}
		return csCollectionLiteralExp;
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitCollectionLiteralPart(@NonNull CollectionLiteralPart asCollectionLiteralPart) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable ElementCS visitCollectionRange(@NonNull CollectionRange asCollectionRange) {
		CollectionLiteralPartCS csCollectionLiteralPart = EssentialOCLCSFactory.eINSTANCE.createCollectionLiteralPartCS();
		csCollectionLiteralPart.setExpressionCS(createExpCS(asCollectionRange.getFirst()));
		csCollectionLiteralPart.setLastExpressionCS(createExpCS(asCollectionRange.getLast()));
		return csCollectionLiteralPart;
	}

	@Override
	public ElementCS visitConstraint(@NonNull Constraint object) {
		ConstraintCS csElement = context.refreshNamedElement(ConstraintCS.class, BaseCSPackage.Literals.CONSTRAINT_CS, object);
		if (csElement != null) {
			refreshConstraint(csElement, object);
		}
		return csElement;
	}

	@Override
	public @Nullable ElementCS visitConstructorExp(@NonNull ConstructorExp asConstructorExp) {
		ConstructorExpCS csConstructorExp = EssentialOCLCSFactory.eINSTANCE.createConstructorExpCS();
		csConstructorExp.setNameExp(createNameExpCS(asConstructorExp.getType()));
		List<ConstructorPartCS> csOwnedParts = csConstructorExp.getOwnedParts();
		for (ConstructorPart asPart : asConstructorExp.getPart()) {
			csOwnedParts.add(context.visitDeclaration(ConstructorPartCS.class, asPart));
		}
		return csConstructorExp;
	}

	@Override
	public @Nullable ElementCS visitConstructorPart(@NonNull ConstructorPart asConstructorPart) {
		ConstructorPartCS csConstructorPart = EssentialOCLCSFactory.eINSTANCE.createConstructorPartCS();
		csConstructorPart.setInitExpression(createExpCS(asConstructorPart.getInitExpression()));
		csConstructorPart.setProperty(asConstructorPart.getReferredProperty());
		return csConstructorPart;
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitEnumLiteralExp(@NonNull EnumLiteralExp asEnumLiteralExp) {
		return createNameExpCS(asEnumLiteralExp.getReferredEnumLiteral());
	}

	@Override
	public ElementCS visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		ExpSpecificationCS csElement = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, object);
		OCLExpression bodyExpression = object.getBodyExpression();
		if (bodyExpression != null) {
			String body = PrettyPrinter.print(bodyExpression);
			csElement.setExprString(body);
		}
		return csElement;
	}

	@Override
	public @Nullable ElementCS visitIfExp(@NonNull IfExp asIfExp) {
		IfExpCS csIfExp = EssentialOCLCSFactory.eINSTANCE.createIfExpCS();
		csIfExp.setCondition(createExpCS(asIfExp.getCondition()));
		csIfExp.setThenExpression(createExpCS(asIfExp.getThenExpression()));
		csIfExp.setElseExpression(createExpCS(asIfExp.getElseExpression()));
		return csIfExp;
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitIntegerLiteralExp(@NonNull IntegerLiteralExp asIntegerLiteralExp) {
		NumberLiteralExpCS csNumberLiteralExp = EssentialOCLCSFactory.eINSTANCE.createNumberLiteralExpCS();
		csNumberLiteralExp.setName(asIntegerLiteralExp.getIntegerSymbol());
		return csNumberLiteralExp;
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitInvalidLiteralExp(@NonNull InvalidLiteralExp asInvalidLiteralExp) {
		return EssentialOCLCSFactory.eINSTANCE.createInvalidLiteralExpCS();
	}

	@Override
	public @Nullable ElementCS visitIterateExp(@NonNull IterateExp asIterateExp) {
		InvocationExpCS csInvocationExp = EssentialOCLCSFactory.eINSTANCE.createInvocationExpCS();
		csInvocationExp.setNameExp(createNameExpCS(asIterateExp.getReferredIteration()));
		String prefix = null;
		for (Variable asIterator : asIterateExp.getIterator()) {
			if (!asIterator.isImplicit()) {
				csInvocationExp.getArgument().add(createNavigatingArgCS(prefix, asIterator, asIterator, null));
				prefix = ",";
			}
		}
		Variable asResult = asIterateExp.getResult();
		csInvocationExp.getArgument().add(createNavigatingArgCS(";", asResult, asResult, asResult.getInitExpression()));
		csInvocationExp.getArgument().add(createNavigatingArgCS("|", asIterateExp.getBody()));
		return createNavigationOperatorCS(asIterateExp.getSource(), csInvocationExp);
	}

	@Override
	public @Nullable ElementCS visitIteratorExp(@NonNull IteratorExp asIteratorExp) {
		InvocationExpCS csInvocationExp = EssentialOCLCSFactory.eINSTANCE.createInvocationExpCS();
		csInvocationExp.setNameExp(createNameExpCS(asIteratorExp.getReferredIteration()));
		String prefix = null;
		for (Variable asIterator : asIteratorExp.getIterator()) {
			if (!asIterator.isImplicit()) {
				csInvocationExp.getArgument().add(createNavigatingArgCS(prefix, asIterator, asIterator, null));
				prefix = ",";
			}
		}
		
		if (prefix != null) {
			prefix = "|";
		}
		csInvocationExp.getArgument().add(createNavigatingArgCS(prefix, asIteratorExp.getBody()));
		return createNavigationOperatorCS(asIteratorExp.getSource(), csInvocationExp);
	}
	
	@Override
	public @Nullable ElementCS visitLetExp(@NonNull LetExp asLetExp) {
		LetExpCS csLetExp = EssentialOCLCSFactory.eINSTANCE.createLetExpCS();
		csLetExp.setIn(createExpCS(asLetExp.getIn()));
		Variable asVariable = asLetExp.getVariable();
		LetVariableCS csLetVariable = EssentialOCLCSFactory.eINSTANCE.createLetVariableCS();
		csLetVariable.setName(asVariable.getName());
		csLetVariable.setInitExpression(createNameExpCS(asVariable.getInitExpression()));
		csLetVariable.setOwnedType(createTypeRefCS(asVariable.getType()));
		csLetExp.getVariable().add(csLetVariable);
		return csLetExp;
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitMessageExp(@NonNull MessageExp object) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitNullLiteralExp(@NonNull NullLiteralExp asNullLiteralExp) {
		return EssentialOCLCSFactory.eINSTANCE.createNullLiteralExpCS();
	}

	@Override
	public ElementCS visitOCLExpression(@NonNull OCLExpression object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitOpaqueExpression(@NonNull OpaqueExpression object) {
		String body = PivotUtil.getBody(object);
		if (body == null) {
			return null;
		}
		ExpSpecificationCS csElement = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, object);
		csElement.setExprString(body);
		return csElement;
	}

	@Override
	public ElementCS visitOperationCallExp(@NonNull OperationCallExp asOperationCallExp) {
		InvocationExpCS csInvocationExp = EssentialOCLCSFactory.eINSTANCE.createInvocationExpCS();
		csInvocationExp.setNameExp(createNameExpCS(asOperationCallExp.getReferredOperation()));
		String prefix = null;
		for (OCLExpression asArgument : asOperationCallExp.getArgument()) {
			csInvocationExp.getArgument().add(createNavigatingArgCS(prefix, asArgument));
			prefix = ",";
		}
		return createNavigationOperatorCS(asOperationCallExp.getSource(), csInvocationExp);
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp asOppositePropertyCallExp) {
		NameExpCS csNameExp = createNameExpCS(asOppositePropertyCallExp.getReferredProperty().getOpposite());
		return createNavigationOperatorCS(asOppositePropertyCallExp.getSource(), csNameExp);
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitPropertyCallExp(@NonNull PropertyCallExp asPropertyCallExp) {
		NameExpCS csNameExp = createNameExpCS(asPropertyCallExp.getReferredProperty());
		return createNavigationOperatorCS(asPropertyCallExp.getSource(), csNameExp);
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitRealLiteralExp(@NonNull RealLiteralExp asRealLiteralExp) {
		NumberLiteralExpCS csNumberLiteralExp = EssentialOCLCSFactory.eINSTANCE.createNumberLiteralExpCS();
		csNumberLiteralExp.setName(asRealLiteralExp.getRealSymbol());
		return csNumberLiteralExp;
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitStateExp(@NonNull StateExp asStateExp) {
		return createNameExpCS(asStateExp.getReferredState());
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitStringLiteralExp(@NonNull StringLiteralExp asStringLiteralExp) {
		StringLiteralExpCS csStringLiteralExp = EssentialOCLCSFactory.eINSTANCE.createStringLiteralExpCS();
		csStringLiteralExp.getName().add(asStringLiteralExp.getStringSymbol());
		return csStringLiteralExp;
	}

	@Override
	public @Nullable ElementCS visitTupleLiteralExp(@NonNull TupleLiteralExp asTupleLiteralExp) {
		TupleLiteralExpCS csTupleLiteralExp = EssentialOCLCSFactory.eINSTANCE.createTupleLiteralExpCS();
		List<TupleLiteralPartCS> csOwnedParts = csTupleLiteralExp.getOwnedParts();
		for (TupleLiteralPart asPart : asTupleLiteralExp.getPart()) {
			csOwnedParts.add(context.visitDeclaration(TupleLiteralPartCS.class, asPart));
		}
		return csTupleLiteralExp;
	}

	@Override
	public @Nullable ElementCS visitTupleLiteralPart(@NonNull TupleLiteralPart asTupleLiteralPart) {
		TupleLiteralPartCS csTupleLiteralPart = EssentialOCLCSFactory.eINSTANCE.createTupleLiteralPartCS();
		csTupleLiteralPart.setName(asTupleLiteralPart.getName());
		csTupleLiteralPart.setOwnedType(createTypeRefCS(asTupleLiteralPart.getType()));
		csTupleLiteralPart.setInitExpression(createExpCS(asTupleLiteralPart.getInitExpression()));
		return csTupleLiteralPart;
	}

	@Override
	public @Nullable ElementCS visitTypeExp(@NonNull TypeExp asTypeExp) {
		return createNameExpCS(asTypeExp.getReferredType());
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp asUnlimitedNaturalLiteralExp) {
		NumberLiteralExpCS csNumberLiteralExp = EssentialOCLCSFactory.eINSTANCE.createNumberLiteralExpCS();
		csNumberLiteralExp.setName(asUnlimitedNaturalLiteralExp.getUnlimitedNaturalSymbol());
		return csNumberLiteralExp;
	}

	@Override
	public @Nullable ElementCS visitVariable(@NonNull Variable object) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 3.5
	 */
	@Override
	public @Nullable ElementCS visitVariableExp(@NonNull VariableExp asVariableExp) {
		return createNameExpCS(asVariableExp.getReferredVariable());
	}
}