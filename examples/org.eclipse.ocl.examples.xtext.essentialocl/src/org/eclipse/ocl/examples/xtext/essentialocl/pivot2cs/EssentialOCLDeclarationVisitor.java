/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.BaseDeclarationVisitor;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;

public class EssentialOCLDeclarationVisitor extends BaseDeclarationVisitor
{
	static final Logger logger = Logger.getLogger(EssentialOCLDeclarationVisitor.class);

	public static final @NonNull TuplePartId TUPLE_MESSAGE_STATUS_0 = IdManager.getTuplePartId(0, PivotConstants.MESSAGE_PART_NAME, TypeId.STRING);
	public static final @NonNull TuplePartId TUPLE_MESSAGE_STATUS_1 = IdManager.getTuplePartId(1, PivotConstants.STATUS_PART_NAME, TypeId.BOOLEAN);
	public static final @NonNull TupleTypeId TUPLE_MESSAGE_STATUS = IdManager.getTupleTypeId("Tuple", TUPLE_MESSAGE_STATUS_0, TUPLE_MESSAGE_STATUS_1);

	public EssentialOCLDeclarationVisitor(@NonNull Pivot2CSConversion context) {
		super(context);
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

	@Override
	public @Nullable ElementCS visitCallExp(@NonNull CallExp object) {
		safeVisit(object.getSource());
		return null;
	}

	@Override
	public @Nullable ElementCS visitCollectionItem(@NonNull CollectionItem object) {
		safeVisit(object.getItem());
		return null;
	}

	@Override
	public @Nullable ElementCS visitCollectionLiteralExp(@NonNull CollectionLiteralExp object) {
		for (CollectionLiteralPart asPart : object.getPart()) {
			safeVisit(asPart);
		}
		return null;
	}

	@Override
	public @Nullable ElementCS visitCollectionRange(@NonNull CollectionRange object) {
		safeVisit(object.getFirst());
		safeVisit(object.getLast());
		return null;
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
	public @Nullable ElementCS visitConstructorExp(@NonNull ConstructorExp object) {
		for (ConstructorPart asPart : object.getPart()) {
			safeVisit(asPart);
		}
		return null;
	}

	@Override
	public @Nullable ElementCS visitConstructorPart(@NonNull ConstructorPart object) {
		safeVisit(object.getType());
		safeVisit(object.getInitExpression());
		return null;
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
	public @Nullable ElementCS visitIfExp(@NonNull IfExp object) {
		safeVisit(object.getCondition());
		safeVisit(object.getThenExpression());
		safeVisit(object.getElseExpression());
		return null;
	}

	@Override
	public @Nullable ElementCS visitLetExp(@NonNull LetExp object) {
		safeVisit(object.getVariable());
		safeVisit(object.getIn());
		return null;
	}

	@Override
	public @Nullable ElementCS visitIterateExp(@NonNull IterateExp object) {
		for (Variable asIterator : object.getIterator()) {
			safeVisit(asIterator);
		}
		safeVisit(object.getResult());
		safeVisit(object.getBody());
		return super.visitIterateExp(object);
	}

	@Override
	public @Nullable ElementCS visitIteratorExp(@NonNull IteratorExp object) {
		for (Variable asIterator : object.getIterator()) {
			safeVisit(asIterator);
		}
		safeVisit(object.getBody());
		return super.visitIteratorExp(object);
	}

	@Override
	public ElementCS visitOCLExpression(@NonNull OCLExpression object) {
		return null;
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
	public @Nullable ElementCS visitOperationCallExp(@NonNull OperationCallExp object) {
		for (OCLExpression asArgument : object.getArgument()) {
			safeVisit(asArgument);
		}
		return super.visitOperationCallExp(object);
	}

	@Override
	public @Nullable ElementCS visitTupleLiteralExp(@NonNull TupleLiteralExp object) {
		for (TupleLiteralPart asPart : object.getPart()) {
			safeVisit(asPart);
		}
		return null;
	}

	@Override
	public @Nullable ElementCS visitTupleLiteralPart(@NonNull TupleLiteralPart object) {
		safeVisit(object.getType());
		safeVisit(object.getInitExpression());
		return null;
	}

	@Override
	public @Nullable ElementCS visitTypeExp(@NonNull TypeExp object) {
		safeVisit(object.getType());
		return null;
	}

	@Override
	public @Nullable ElementCS visitVariable(@NonNull Variable object) {
		safeVisit(object.getType());
		safeVisit(object.getInitExpression());
		return null;
	}
}