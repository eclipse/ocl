/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
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

/**
 */
public interface EssentialOCLCSVisitor<R> extends org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor<R>
{
	@Nullable R visitAbstractNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AbstractNameExpCS object);
	@Nullable R visitAssociationClassCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AssociationClassCallExpCS object);
	@Nullable R visitBinaryOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS object);
	@Nullable R visitBooleanLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS object);
	@Nullable R visitCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CallExpCS object);
	@Nullable R visitCollectionLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS object);
	@Nullable R visitCollectionLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS object);
	@Nullable R visitCollectionPatternCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS object);
	@Nullable R visitCollectionTypeCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS object);
	@Nullable R visitConstructorExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS object);
	@Nullable R visitConstructorPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS object);
	@Nullable R visitContextCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS object);
	@Nullable R visitCurlyBracketedClauseCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS object);
	@Nullable R visitExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS object);
	@Nullable R visitExpSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS object);
	@Nullable R visitIfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS object);
	@Nullable R visitIfThenExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfThenExpCS object);
	@Nullable R visitInfixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS object);
	@Nullable R visitInvalidLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS object);
	@Nullable R visitIterateCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterateCallExpCS object);
	@Nullable R visitIterationCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterationCallExpCS object);
	@Nullable R visitLambdaLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LambdaLiteralExpCS object);
	@Nullable R visitLetExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS object);
	@Nullable R visitLetVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS object);
	@Nullable R visitLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS object);
	@Nullable R visitNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS object);
	@Nullable R visitNavigatingArgCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS object);
	@Nullable R visitNestedExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS object);
	@Nullable R visitNullLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS object);
	@Nullable R visitNumberLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS object);
	@Nullable R visitOperationCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperationCallExpCS object);
	@Nullable R visitOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS object);
	@Nullable R visitPatternExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PatternExpCS object);
	@Nullable R visitPrefixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS object);
	@Nullable R visitPrimitiveLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS object);
	@Nullable R visitPropertyCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PropertyCallExpCS object);
	@Nullable R visitRoundBracketedClauseCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS object);
	@Nullable R visitSelfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS object);
	@Nullable R visitSquareBracketedClauseCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS object);
	@Nullable R visitStringLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS object);
	@Nullable R visitTupleLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS object);
	@Nullable R visitTupleLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS object);
	@Nullable R visitTypeLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS object);
	@Nullable R visitTypeNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS object);
	@Nullable R visitUnlimitedNaturalLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS object);
	@Nullable R visitVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS object);
	@Nullable R visitVariableExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableExpCS object);
}
