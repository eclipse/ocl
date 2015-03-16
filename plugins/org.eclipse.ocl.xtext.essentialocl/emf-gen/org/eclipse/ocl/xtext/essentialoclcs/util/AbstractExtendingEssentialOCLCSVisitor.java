/*******************************************************************************
 * Copyright (c) 2010,2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.xtext.essentialocl/model/EssentialOCLCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.essentialoclcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingEssentialOCLCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingEssentialOCLCSVisitor<R, C>
	extends org.eclipse.ocl.xtext.basecs.util.AbstractExtendingBaseCSVisitor<R, C>
	implements EssentialOCLCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingEssentialOCLCSVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitAbstractNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitAssociationClassCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS object) {
		return visitCallExpCS(object);
	}

	@Override
	public @Nullable R visitBooleanLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CallExpCS object) {
		return visitAbstractNameExpCS(object);
	}

	@Override
	public @Nullable R visitCollectionLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitCollectionLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitCollectionPatternCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public @Nullable R visitCollectionTypeCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public @Nullable R visitContextCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ContextCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitCurlyBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS object) {
		return visitContextLessElementCS(object);
	}

	@Override
	public @Nullable R visitExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ExpCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitExpSpecificationCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS object) {
		return visitSpecificationCS(object);
	}

	@Override
	public @Nullable R visitIfExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IfExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitIfThenExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitInfixExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS object) {
		return visitOperatorExpCS(object);
	}

	@Override
	public @Nullable R visitInvalidLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitIterateCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS object) {
		return visitIterationCallExpCS(object);
	}

	@Override
	public @Nullable R visitIterationCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS object) {
		return visitCallExpCS(object);
	}

	@Override
	public @Nullable R visitLambdaLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitLetExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LetExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitLetVariableCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LiteralExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NameExpCS object) {
		return visitAssociationClassCallExpCS(object);
	}

	@Override
	public @Nullable R visitNavigatingArgCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitNestedExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitNullLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitNumberLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitOperationCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.OperationCallExpCS object) {
		return visitCallExpCS(object);
	}

	@Override
	public @Nullable R visitOperatorExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitPatternExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitPrefixExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS object) {
		return visitOperatorExpCS(object);
	}

	@Override
	public @Nullable R visitPrimitiveLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PrimitiveLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitPropertyCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS object) {
		return visitCallExpCS(object);
	}

	@Override
	public @Nullable R visitRoundBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS object) {
		return visitContextLessElementCS(object);
	}

	@Override
	public @Nullable R visitSelfExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitShadowExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS object) {
		return visitAbstractNameExpCS(object);
	}

	@Override
	public @Nullable R visitShadowPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitSquareBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS object) {
		return visitContextLessElementCS(object);
	}

	@Override
	public @Nullable R visitStringLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitTupleLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitTupleLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS object) {
		return visitVariableCS(object);
	}

	@Override
	public @Nullable R visitTypeLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitTypeNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public @Nullable R visitUnlimitedNaturalLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitVariableCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.VariableCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitVariableExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS object) {
		return visitAbstractNameExpCS(object);
	}
}
