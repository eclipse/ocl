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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.base.cs2as.BaseCSLeft2RightVisitor;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;

/**
 * An AbstractEssentialOCLCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractEssentialOCLCSLeft2RightVisitor
	extends BaseCSLeft2RightVisitor
	implements EssentialOCLCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractEssentialOCLCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Element visitAbstractNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitAssociationClassCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Element visitBooleanLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CallExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}

	@Override
	public @Nullable Element visitCollectionLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitCollectionLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitCollectionPatternCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS csElement) {
		return visitTypedRefCS(csElement);
	}

	@Override
	public @Nullable Element visitCollectionTypeCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	@Override
	public @Nullable Element visitContextCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ContextCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitCurlyBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	@Override
	public @Nullable Element visitExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ExpCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitExpSpecificationCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS csElement) {
		return visitSpecificationCS(csElement);
	}

	@Override
	public @Nullable Element visitIfExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IfExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitIfThenExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitInfixExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS csElement) {
		return visitOperatorExpCS(csElement);
	}

	@Override
	public @Nullable Element visitInvalidLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitIterateCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS csElement) {
		return visitIterationCallExpCS(csElement);
	}

	@Override
	public @Nullable Element visitIterationCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Element visitLambdaLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitLetExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LetExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitLetVariableCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LiteralExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitMapLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitMapLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitMapTypeCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	@Override
	public @Nullable Element visitNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NameExpCS csElement) {
		return visitAssociationClassCallExpCS(csElement);
	}

	@Override
	public @Nullable Element visitNavigatingArgCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitNestedExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitNullLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitNumberLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitOperationCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.OperationCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Element visitOperatorExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitPathExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PathExpCS csElement) {
		return visitPathTypeCS(csElement);
	}

	@Override
	public @Nullable Element visitPatternExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitPrefixExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS csElement) {
		return visitOperatorExpCS(csElement);
	}

	@Override
	public @Nullable Element visitPrimitiveLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PrimitiveLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitPropertyCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	@Override
	public @Nullable Element visitRoundBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	@Override
	public @Nullable Element visitSelfExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitShadowExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}

	@Override
	public @Nullable Element visitShadowPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitSquareBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	@Override
	public @Nullable Element visitStringLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitTupleLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitTupleLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS csElement) {
		return visitVariableCS(csElement);
	}

	@Override
	public @Nullable Element visitTypeLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitUnlimitedNaturalLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	@Override
	public @Nullable Element visitVariableCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.VariableCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitVariableExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}
}
