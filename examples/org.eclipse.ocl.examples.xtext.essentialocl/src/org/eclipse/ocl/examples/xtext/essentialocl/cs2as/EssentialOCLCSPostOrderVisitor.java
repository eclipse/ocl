/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.cs2as;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.LanguageExpression;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil.PrecedenceComparator;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ContextLessElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.AbstractEssentialOCLCSPostOrderVisitor;

public class EssentialOCLCSPostOrderVisitor extends AbstractEssentialOCLCSPostOrderVisitor
{
	static final Logger logger = Logger.getLogger(EssentialOCLCSPostOrderVisitor.class);

	public static class ConstraintCSCompletion extends SingleContinuation<ConstraintCS>
	{
		public ConstraintCSCompletion(@NonNull CS2PivotConversion context, @NonNull ConstraintCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			// NB Three cases for the Constraint content
			// a) refreshing an OpaqueExpression that originated from Ecore2Pivot 
			// b) refreshing an ExpressionInOCL for a simple statusExpression 
			// c) refreshing an ExpressionInOCL+PropertyCallExp of a TupleLiteralExp for statusExpression+messageExpression
			Constraint asConstraint = PivotUtil.getPivot(Constraint.class, csElement);
			ExpSpecificationCS csStatusSpecification = (ExpSpecificationCS)csElement.getSpecification();
			if ((asConstraint != null) && (csStatusSpecification != null)) {
				ExpCS csStatusExpression = csStatusSpecification.getOwnedExpression();
				if (csStatusExpression != null) {
					@SuppressWarnings("null")@NonNull ExpressionInOCL asSpecification = (ExpressionInOCL) asConstraint.getSpecification();
					context.refreshContextVariable(asSpecification);
					ExpSpecificationCS csMessageSpecification = (ExpSpecificationCS)csElement.getMessageSpecification();
					String statusText = ElementUtil.getExpressionText(csStatusExpression);
					if (csMessageSpecification == null) {
						OCLExpression asExpression = context.visitLeft2Right(OCLExpression.class, csStatusExpression);
						asSpecification.setBodyExpression(asExpression);
						boolean isRequired = (asExpression != null) && asExpression.isRequired();
						context.setType(asSpecification, asExpression != null ? asExpression.getType() : null, isRequired);
						PivotUtil.setBody(asSpecification, asExpression, statusText);
					}
					else {
						TupleLiteralPart asStatusTuplePart = PivotUtil.getNonNullAst(TupleLiteralPart.class, csStatusSpecification);
						OCLExpression asStatusExpression = context.visitLeft2Right(OCLExpression.class, csStatusExpression);
						asStatusTuplePart.setInitExpression(asStatusExpression);
						TupleLiteralPart asMessageTuplePart = PivotUtil.getNonNullAst(TupleLiteralPart.class, csMessageSpecification);
						ExpCS csMessageExpression = csMessageSpecification.getOwnedExpression();
						OCLExpression asMessageExpression = csMessageExpression != null ? context.visitLeft2Right(OCLExpression.class, csMessageExpression) : null;
						asMessageTuplePart.setInitExpression(asMessageExpression);
						@SuppressWarnings("null")@NonNull OCLExpression asTuplePartExp = asSpecification.getBodyExpression();
						context.setType(asSpecification, asTuplePartExp.getType(), true);
						String messageText = csMessageExpression != null ? ElementUtil.getExpressionText(csMessageExpression) : "null";
						String tupleText = PivotUtil.createTupleValuedConstraint(statusText, null, messageText);
						PivotUtil.setBody(asSpecification, asTuplePartExp, tupleText);					
					}
				}
				else {
					@SuppressWarnings("null")@NonNull LanguageExpression asSpecification = asConstraint.getSpecification();
					asSpecification.setBody(csStatusSpecification.getExprString());					
				}
			}
			return null;
		}
	}

	protected static class ContextCSCompletion extends SingleContinuation<ContextCS>
	{
		public ContextCSCompletion(@NonNull CS2PivotConversion context, @NonNull ContextCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			context.visitLeft2Right(Element.class, csElement);
			return null;
		}
	}

	public static class ExpSpecificationCSCompletion extends SingleContinuation<ExpSpecificationCS>
	{
		public ExpSpecificationCSCompletion(@NonNull CS2PivotConversion context, @NonNull ExpSpecificationCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			ExpressionInOCL asSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csElement);
			if (asSpecification != null) {
				context.refreshContextVariable(asSpecification);
				ExpCS csExpression = csElement.getOwnedExpression();
				OCLExpression asExpression = csExpression != null ? context.visitLeft2Right(OCLExpression.class, csExpression) : null;
				String statusText = csExpression != null ? ElementUtil.getExpressionText(csExpression) : "null";
				PivotUtil.setBody(asSpecification, asExpression, statusText);
				boolean isRequired = (asExpression != null) && asExpression.isRequired();
				context.setType(asSpecification, asExpression != null ? asExpression.getType() : null, isRequired);
			}
			return null;
		}
	}

	protected final @NonNull MetaModelManager metaModelManager;
	
	public EssentialOCLCSPostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
		this.metaModelManager = context.getMetaModelManager();
	}

	/**
	 * Establish the parent-{source,argument} relationships between all infix
	 * operators in accordance with the precedence and associativity configuration.
	 */
	protected void createInfixOperatorTree(InfixExpCS csInfix) {
		//
		//	Create the per-precedence list of operator indexes, and a
		//	highest precedence first list of all used infix precedences.
		//
		Map<Precedence, List<Integer>> precedenceToOperatorIndexes = createInfixPrecedenceToOperatorIndexesMap(csInfix);
		List<Precedence> sortedPrecedences = new ArrayList<Precedence>(precedenceToOperatorIndexes.keySet());
		Collections.sort(sortedPrecedences, PrecedenceComparator.INSTANCE);
		//
		//	Build the tree leaf-to root precedence at a time.
		//
		List<ExpCS> csExpressions = csInfix.getOwnedExpressions();
		List<BinaryOperatorCS> csOperators = csInfix.getOwnedOperators();
		for (Precedence precedence : sortedPrecedences) {
			// null precedence arises when precedence or operation-to-precedence is wrong
			boolean isLeft = precedence == null || (precedence.getAssociativity() == AssociativityKind.LEFT);
			List<Integer> operatorIndexes = precedenceToOperatorIndexes.get(precedence);
			int operatorCount = operatorIndexes.size();
			int iFirst = isLeft ? 0 : operatorCount-1;
			int iIndex = isLeft ? 1 : -1;
			int iLast = isLeft ? operatorCount : -1;
			for (int i = iFirst; i != iLast; i += iIndex) {
				int operatorIndex = operatorIndexes.get(i);
				BinaryOperatorCS csOperator = csOperators.get(operatorIndex);
				//
				//	Establish parent-child relationship of operator source
				//
				ExpCS csSource = csExpressions.get(operatorIndex);
				while ((csSource.getParent() != null) && (csSource.getParent() != csOperator)) {
					csSource = csSource.getParent();
				}
				setSource(csOperator, csSource);
				//
				//	Establish parent-child relationship of operator argument
				//
				ExpCS csArgument = csExpressions.get(operatorIndex+1);
				while ((csArgument.getParent() != null) && (csArgument.getParent() != csOperator)) {
					csArgument = csArgument.getParent();
				}
				setArgument(csOperator, csArgument);
			}
		}
	}

	/**
	 * Return a map of operator indexes for each used precedence.
	 */
	protected Map<Precedence, List<Integer>> createInfixPrecedenceToOperatorIndexesMap(InfixExpCS csInfix) {
		List<BinaryOperatorCS> csOperators = csInfix.getOwnedOperators();
		int operatorCount = csInfix.getOwnedExpressions().size()-1;	// Ignore a spurious trailing operator from a syntax error
		Map<Precedence, List<Integer>> precedenceToOperatorIndex = new HashMap<Precedence, List<Integer>>();
		for (int operatorIndex = 0; operatorIndex < operatorCount; operatorIndex++) {
			BinaryOperatorCS csOperator = csOperators.get(operatorIndex);
			String operatorName = csOperator.getName();
			assert operatorName != null;
			Precedence precedence = metaModelManager.getInfixPrecedence(operatorName);
			List<Integer> indexesList = precedenceToOperatorIndex.get(precedence);
			if (indexesList == null) {
				indexesList = new ArrayList<Integer>();
				precedenceToOperatorIndex.put(precedence, indexesList);
			}
			indexesList.add(operatorIndex);
		}
		return precedenceToOperatorIndex;
	}

	protected void initializePrefixOperators(PrefixExpCS prefixExpCS, OperatorCS csParent) {
		prefixExpCS.setParent(null);		// FIXME asymmetric
		for (UnaryOperatorCS csUnaryOperator : prefixExpCS.getOwnedOperators()) {
			if (csParent instanceof UnaryOperatorCS) {
				setSource(csParent, csUnaryOperator);
			}
			else if (csParent instanceof BinaryOperatorCS) {
				if (csParent.getSource() == prefixExpCS) {
					setSource(csParent, csUnaryOperator);
				}
				else {
					setArgument((BinaryOperatorCS) csParent, csUnaryOperator);
				}
			}
			ExpCS csChild = prefixExpCS.getOwnedExpression();
			setSource(csUnaryOperator, csChild);
			csParent = csUnaryOperator;
		}
	}

	protected void interleavePrefixes(InfixExpCS csElement) {
		for (ExpCS csExp : csElement.getOwnedExpressions()) {
			if (csExp instanceof PrefixExpCS) {
				PrefixExpCS prefixExpCS = (PrefixExpCS)csExp;
				OperatorCS csExpressionParent = prefixExpCS.getParent();
				initializePrefixOperators(prefixExpCS, csExpressionParent);			
				for (UnaryOperatorCS csUnaryOperator : prefixExpCS.getOwnedOperators()) {
					interleaveUnaryOperator(csUnaryOperator);
				}			
			}
		}
	}
	
	protected void interleaveUnaryOperator(UnaryOperatorCS csOperator) {
		while (true) {
			OperatorCS csParent = csOperator.getParent();
			if (!(csParent instanceof BinaryOperatorCS)) {
				break;
			}
			String parentOperatorName = csParent.getName();
			assert parentOperatorName != null;
			Precedence parentPrecedence = metaModelManager.getInfixPrecedence(parentOperatorName);
			String operatorName = csOperator.getName();
			assert operatorName != null;
			Precedence unaryPrecedence = metaModelManager.getPrefixPrecedence(operatorName);
			int parentOrder = parentPrecedence != null ? parentPrecedence.getOrder().intValue() : -1;
			int unaryOrder = unaryPrecedence != null ? unaryPrecedence.getOrder().intValue() : -1;
			if (unaryOrder < parentOrder) {
				break;
			}
			OperatorCS csGrandParent = csParent.getParent();
			ExpCS csExp = csOperator.getSource();
			if (csOperator == csParent.getSource()) {
				setSource(csParent, null);			// Avoid a transient loop
				if (csGrandParent instanceof BinaryOperatorCS) {
					if (csGrandParent.getSource() == csParent) {
						setSource(csGrandParent, csOperator);
					}
					else {
						setArgument((BinaryOperatorCS) csGrandParent, csOperator);
					}
				}
//				else if (csGrandParent == null) {
//					setSource(null, csOperator);
//				}
				setSource(csOperator, csParent);
				setSource(csParent, csExp);
			}
//			else if (csOperator == ((BinaryOperatorCS) csParent).getArgument()) {
//				if (csGrandParent instanceof BinaryOperatorCS) {
//					if (csGrandParent.getSource() == csParent) {
//						setSource(csOperator, null);			// Avoid a transient loop
//						setSource(csGrandParent, csExp);		
//						setSource(csOperator, csGrandParent);
//					}
//				}
//			}
			else {
				break;
			}
		}
	}

	private void setArgument(BinaryOperatorCS csParent, ExpCS csArgument) {
		csArgument.setParent(csParent);
		csParent.setArgument(csArgument);
		int i = 0;
		for (OperatorCS csOperator = csParent.getParent(); csOperator != null; csOperator = csOperator.getParent()) {
			if (csOperator == csParent) {
				logger.error("Operator loop established");
			}
			else if (i++ > 1000) {
				logger.error("Operator depth limit exceeded");
			}
		}
	}

	private void setSource(OperatorCS csParent, ExpCS csSource) {
		if (csSource != null) {
			csSource.setParent(csParent);
			int i = 0;
			for (OperatorCS csOperator = csParent.getParent(); csOperator != null; csOperator = csOperator.getParent()) {
				if (csOperator == csParent) {
					logger.error("Operator loop established");
				}
				else if (i++ > 1000) {
					logger.error("Operator depth limit exceeded");
				}
			}
			csParent.setSource(csSource);
		}
		else {
			csParent.getSource().setParent(null);
			csParent.setSource(csSource);
		}
	}

	@Override
	public Continuation<?> visitCollectionTypeCS(@NonNull CollectionTypeCS csCollectionType) {
		// FIXME untemplated collections need type deduction here
/*		MetaModelManager metaModelManager = context.getMetaModelManager();
		TypedRefCS csElementType = csCollectionType.getOwnedType();
		Type type;
		if (csElementType != null) {
			Type elementType = PivotUtil.getPivot(Type.class, csElementType);
			type = metaModelManager.getLibraryType(csCollectionType.getName(), Collections.singletonList(elementType));
		}
		else {
			type = metaModelManager.getLibraryType(csCollectionType.getName());
		}
		context.reusePivotElement(csCollectionType, type);
*/		return null;
	}

	@Override
	public Continuation<?> visitConstraintCS(@NonNull ConstraintCS csConstraint) {
		return new ConstraintCSCompletion(context, csConstraint);
	}

	@Override
	public Continuation<?> visitContextCS(@NonNull ContextCS csContext) {
		ExpCS ownedExpression = csContext.getOwnedExpression();
		if (ownedExpression != null) {
			return new ContextCSCompletion(context, csContext);
		}
		else {
			return null;
		}
	}

	@Override
	public Continuation<?> visitContextLessElementCS(@NonNull ContextLessElementCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitExpCS(@NonNull ExpCS csExp) {
		return null;
	}

	@Override
	public final @Nullable Continuation<?> visitExpSpecificationCS(@NonNull ExpSpecificationCS csElement) {
		if (!(csElement.eContainer() instanceof ConstraintCS)) {
			return new ExpSpecificationCSCompletion(context, csElement);
		}
		else {
			return null;
		}
	}

	@Override
	public Continuation<?> visitInfixExpCS(@NonNull InfixExpCS csInfixExp) {
		//
		//	Establish the Infix tree and the per leaf expression parent operator.
		//
		createInfixOperatorTree(csInfixExp);
		//
		//	Interleave the Prefix Operators.
		//
		interleavePrefixes(csInfixExp);
		return null;
	}

	@Override
	public Continuation<?> visitOperatorCS(@NonNull OperatorCS csOperator) {
		return null;
	}

	@Override
	public Continuation<?> visitPathNameCS(@NonNull PathNameCS object) {
		// TODO Auto-generated method stub
		return super.visitPathNameCS(object);
	}

	@Override
	public Continuation<?> visitPrefixExpCS(@NonNull PrefixExpCS csPrefixExp) {
		if (!(csPrefixExp.eContainer() instanceof InfixExpCS)) {
			initializePrefixOperators(csPrefixExp, null);
		}
		return null;
	}

	@Override
	public final Continuation<?> visitSpecificationCS(@NonNull SpecificationCS csSpecification) {
		return null;	// Must be managed by container
	}

	@Override
	public Continuation<?> visitTypeNameExpCS(@NonNull TypeNameExpCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitVariableCS(@NonNull VariableCS csVariable) {
		return null;
	}	
}
