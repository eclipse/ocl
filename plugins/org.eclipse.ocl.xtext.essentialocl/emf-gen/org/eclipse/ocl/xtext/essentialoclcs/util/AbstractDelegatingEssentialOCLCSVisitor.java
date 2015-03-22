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
 * An AbstractDelegatingEssentialOCLCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingEssentialOCLCSVisitor<R, C, D extends EssentialOCLCSVisitor<R>>
	extends org.eclipse.ocl.xtext.basecs.util.AbstractDelegatingBaseCSVisitor<R, C, D>
	implements EssentialOCLCSVisitor<R>
{
	protected AbstractDelegatingEssentialOCLCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.xtext.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public @Nullable R visitAbstractNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS object) {
		return delegate.visitAbstractNameExpCS(object);
	}

	@Override
	public @Nullable R visitAssociationClassCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS object) {
		return delegate.visitAssociationClassCallExpCS(object);
	}

	@Override
	public @Nullable R visitBooleanLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS object) {
		return delegate.visitBooleanLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CallExpCS object) {
		return delegate.visitCallExpCS(object);
	}

	@Override
	public @Nullable R visitCollectionLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS object) {
		return delegate.visitCollectionLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitCollectionLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS object) {
		return delegate.visitCollectionLiteralPartCS(object);
	}

	@Override
	public @Nullable R visitCollectionPatternCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS object) {
		return delegate.visitCollectionPatternCS(object);
	}

	@Override
	public @Nullable R visitCollectionTypeCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS object) {
		return delegate.visitCollectionTypeCS(object);
	}

	@Override
	public @Nullable R visitContextCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ContextCS object) {
		return delegate.visitContextCS(object);
	}

	@Override
	public @Nullable R visitCurlyBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS object) {
		return delegate.visitCurlyBracketedClauseCS(object);
	}

	@Override
	public @Nullable R visitExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ExpCS object) {
		return delegate.visitExpCS(object);
	}

	@Override
	public @Nullable R visitExpSpecificationCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS object) {
		return delegate.visitExpSpecificationCS(object);
	}

	@Override
	public @Nullable R visitIfExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IfExpCS object) {
		return delegate.visitIfExpCS(object);
	}

	@Override
	public @Nullable R visitIfThenExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS object) {
		return delegate.visitIfThenExpCS(object);
	}

	@Override
	public @Nullable R visitInfixExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS object) {
		return delegate.visitInfixExpCS(object);
	}

	@Override
	public @Nullable R visitInvalidLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS object) {
		return delegate.visitInvalidLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitIterateCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS object) {
		return delegate.visitIterateCallExpCS(object);
	}

	@Override
	public @Nullable R visitIterationCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS object) {
		return delegate.visitIterationCallExpCS(object);
	}

	@Override
	public @Nullable R visitLambdaLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS object) {
		return delegate.visitLambdaLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitLetExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LetExpCS object) {
		return delegate.visitLetExpCS(object);
	}

	@Override
	public @Nullable R visitLetVariableCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS object) {
		return delegate.visitLetVariableCS(object);
	}

	@Override
	public @Nullable R visitLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LiteralExpCS object) {
		return delegate.visitLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitMapLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS object) {
		return delegate.visitMapLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitMapLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS object) {
		return delegate.visitMapLiteralPartCS(object);
	}

	@Override
	public @Nullable R visitMapTypeCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS object) {
		return delegate.visitMapTypeCS(object);
	}

	@Override
	public @Nullable R visitNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NameExpCS object) {
		return delegate.visitNameExpCS(object);
	}

	@Override
	public @Nullable R visitNavigatingArgCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS object) {
		return delegate.visitNavigatingArgCS(object);
	}

	@Override
	public @Nullable R visitNestedExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS object) {
		return delegate.visitNestedExpCS(object);
	}

	@Override
	public @Nullable R visitNullLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS object) {
		return delegate.visitNullLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitNumberLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS object) {
		return delegate.visitNumberLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitOperationCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.OperationCallExpCS object) {
		return delegate.visitOperationCallExpCS(object);
	}

	@Override
	public @Nullable R visitOperatorExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS object) {
		return delegate.visitOperatorExpCS(object);
	}

	@Override
	public @Nullable R visitPatternExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS object) {
		return delegate.visitPatternExpCS(object);
	}

	@Override
	public @Nullable R visitPrefixExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS object) {
		return delegate.visitPrefixExpCS(object);
	}

	@Override
	public @Nullable R visitPrimitiveLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PrimitiveLiteralExpCS object) {
		return delegate.visitPrimitiveLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitPropertyCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS object) {
		return delegate.visitPropertyCallExpCS(object);
	}

	@Override
	public @Nullable R visitRoundBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS object) {
		return delegate.visitRoundBracketedClauseCS(object);
	}

	@Override
	public @Nullable R visitSelfExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS object) {
		return delegate.visitSelfExpCS(object);
	}

	@Override
	public @Nullable R visitShadowExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS object) {
		return delegate.visitShadowExpCS(object);
	}

	@Override
	public @Nullable R visitShadowPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS object) {
		return delegate.visitShadowPartCS(object);
	}

	@Override
	public @Nullable R visitSquareBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS object) {
		return delegate.visitSquareBracketedClauseCS(object);
	}

	@Override
	public @Nullable R visitStringLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS object) {
		return delegate.visitStringLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitTupleLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS object) {
		return delegate.visitTupleLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitTupleLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS object) {
		return delegate.visitTupleLiteralPartCS(object);
	}

	@Override
	public @Nullable R visitTypeLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS object) {
		return delegate.visitTypeLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitTypeNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS object) {
		return delegate.visitTypeNameExpCS(object);
	}

	@Override
	public @Nullable R visitUnlimitedNaturalLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS object) {
		return delegate.visitUnlimitedNaturalLiteralExpCS(object);
	}

	@Override
	public @Nullable R visitVariableCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.VariableCS object) {
		return delegate.visitVariableCS(object);
	}

	@Override
	public @Nullable R visitVariableExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS object) {
		return delegate.visitVariableExpCS(object);
	}
}
