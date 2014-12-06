/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.BaseCSPreOrderVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

/**
 * An AbstractEssentialOCLCSPreOrderVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractEssentialOCLCSPreOrderVisitor
	extends BaseCSPreOrderVisitor
	implements EssentialOCLCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractEssentialOCLCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Continuation<?> visitAbstractNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AbstractNameExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitAssociationClassCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AssociationClassCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitBooleanLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CallExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCollectionLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCollectionLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCollectionPatternCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS csElement) {
		return visitTypedRefCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCollectionTypeCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitConstructorExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitConstructorPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitContextCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCurlyBracketedClauseCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitExpSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS csElement) {
		return visitSpecificationCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitIfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitIfThenExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfThenExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitInfixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS csElement) {
		return visitOperatorExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitInvalidLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitIterateCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterateCallExpCS csElement) {
		return visitIterationCallExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitIterationCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterationCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitLambdaLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LambdaLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitLetExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitLetVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS csElement) {
		return visitAssociationClassCallExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitNavigatingArgCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitNestedExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitNullLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitNumberLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitOperationCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperationCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitOperatorExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPatternExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PatternExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPrefixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS csElement) {
		return visitOperatorExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPrimitiveLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPropertyCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PropertyCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitRoundBracketedClauseCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitSelfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitSquareBracketedClauseCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitStringLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTupleLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTupleLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS csElement) {
		return visitVariableCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTypeLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTypeNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS csElement) {
		return visitTypedRefCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitUnlimitedNaturalLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitVariableExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}
}
