/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
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
import org.eclipse.ocl.xtext.base.cs2as.BaseCSContainmentVisitor;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;

/**
 * An AbstractEssentialOCLCSContainmentVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractEssentialOCLCSContainmentVisitor
	extends BaseCSContainmentVisitor
	implements EssentialOCLCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractEssentialOCLCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Continuation<?> visitAbstractNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitAssociationClassCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitBooleanLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CallExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCollectionLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCollectionLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCollectionPatternCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS csElement) {
		return visitTypedRefCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCollectionTypeCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitContextCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ContextCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCurlyBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ExpCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitExpSpecificationCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS csElement) {
		return visitSpecificationCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitIfExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IfExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitIfThenExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitInfixExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS csElement) {
		return visitOperatorExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitInvalidLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitIterateCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS csElement) {
		return visitIterationCallExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitIterationCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitLambdaLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitLetExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LetExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitLetVariableCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LiteralExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMapLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMapLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMapTypeCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NameExpCS csElement) {
		return visitAssociationClassCallExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitNavigatingArgCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitNestedExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitNullLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitNumberLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitOperationCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.OperationCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitOperatorExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPatternExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPrefixExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS csElement) {
		return visitOperatorExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPrimitiveLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PrimitiveLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPropertyCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitRoundBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitSelfExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitShadowExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitShadowPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitSquareBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitStringLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTupleLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTupleLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS csElement) {
		return visitVariableCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTypeLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTypeNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS csElement) {
		return visitTypedTypeRefCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitUnlimitedNaturalLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitVariableCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.VariableCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitVariableExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}
}
