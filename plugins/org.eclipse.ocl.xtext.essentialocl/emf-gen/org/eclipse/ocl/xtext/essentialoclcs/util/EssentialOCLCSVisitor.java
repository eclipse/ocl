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
 */
public interface EssentialOCLCSVisitor<R> extends org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor<R>
{
	@Nullable R visitAbstractNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS object);
	@Nullable R visitAssociationClassCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS object);
	@Nullable R visitBooleanLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS object);
	@Nullable R visitCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CallExpCS object);
	@Nullable R visitCollectionLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS object);
	@Nullable R visitCollectionLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS object);
	@Nullable R visitCollectionPatternCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS object);
	@Nullable R visitCollectionTypeCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS object);
	@Nullable R visitContextCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ContextCS object);
	@Nullable R visitCurlyBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS object);
	@Nullable R visitExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ExpCS object);
	@Nullable R visitExpSpecificationCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS object);
	@Nullable R visitIfExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IfExpCS object);
	@Nullable R visitIfThenExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS object);
	@Nullable R visitInfixExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS object);
	@Nullable R visitInvalidLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS object);
	@Nullable R visitIterateCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS object);
	@Nullable R visitIterationCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS object);
	@Nullable R visitLambdaLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS object);
	@Nullable R visitLetExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LetExpCS object);
	@Nullable R visitLetVariableCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS object);
	@Nullable R visitLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.LiteralExpCS object);
	@Nullable R visitMapLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS object);
	@Nullable R visitMapLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS object);
	@Nullable R visitMapTypeCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS object);
	@Nullable R visitNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NameExpCS object);
	@Nullable R visitNavigatingArgCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS object);
	@Nullable R visitNestedExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS object);
	@Nullable R visitNullLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS object);
	@Nullable R visitNumberLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS object);
	@Nullable R visitOperationCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.OperationCallExpCS object);
	@Nullable R visitOperatorExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS object);
	@Nullable R visitPatternExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS object);
	@Nullable R visitPrefixExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS object);
	@Nullable R visitPrimitiveLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PrimitiveLiteralExpCS object);
	@Nullable R visitPropertyCallExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS object);
	@Nullable R visitRoundBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS object);
	@Nullable R visitSelfExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS object);
	@Nullable R visitShadowExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ShadowExpCS object);
	@Nullable R visitShadowPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS object);
	@Nullable R visitSquareBracketedClauseCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS object);
	@Nullable R visitStringLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS object);
	@Nullable R visitTupleLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS object);
	@Nullable R visitTupleLiteralPartCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS object);
	@Nullable R visitTypeLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS object);
	@Nullable R visitTypeNameExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS object);
	@Nullable R visitUnlimitedNaturalLiteralExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS object);
	@Nullable R visitVariableCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.VariableCS object);
	@Nullable R visitVariableExpCS(@NonNull org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS object);
}
