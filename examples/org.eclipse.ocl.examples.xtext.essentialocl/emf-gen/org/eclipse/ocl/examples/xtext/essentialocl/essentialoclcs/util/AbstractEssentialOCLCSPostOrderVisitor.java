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
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.BaseCSPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

/**
 * An AbstractEssentialOCLCSPostOrderVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractEssentialOCLCSPostOrderVisitor
	extends BaseCSPostOrderVisitor
	implements EssentialOCLCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractEssentialOCLCSPostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Continuation<?> visitBinaryOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS csElement) {
		return visitOperatorCS(csElement);
	}

	public @Nullable Continuation<?> visitBooleanLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	public @Nullable Continuation<?> visitCollectionLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	public @Nullable Continuation<?> visitCollectionLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitCollectionTypeCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	public @Nullable Continuation<?> visitConstructorPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitContextCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitCurlyBracketedClauseCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	public @Nullable Continuation<?> visitExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitExpSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS csElement) {
		return visitSpecificationCS(csElement);
	}

	public @Nullable Continuation<?> visitIfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitIfThenExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfThenExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitInfixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitInvalidLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	public @Nullable Continuation<?> visitLambdaLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LambdaLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	public @Nullable Continuation<?> visitLetExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitLetVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS csElement) {
		return visitVariableCS(csElement);
	}

	public @Nullable Continuation<?> visitLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitNavigatingArgCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitNavigationOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS csElement) {
		return visitBinaryOperatorCS(csElement);
	}

	public @Nullable Continuation<?> visitNestedExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitNullLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	public @Nullable Continuation<?> visitNumberLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	public @Nullable Continuation<?> visitOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitPrefixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitPrimitiveLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	public @Nullable Continuation<?> visitRoundBracketedClauseCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	public @Nullable Continuation<?> visitSelfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitSquareBracketedClauseCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	public @Nullable Continuation<?> visitStringLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	public @Nullable Continuation<?> visitTupleLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	public @Nullable Continuation<?> visitTupleLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS csElement) {
		return visitVariableCS(csElement);
	}

	public @Nullable Continuation<?> visitTypeLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	public @Nullable Continuation<?> visitTypeNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS csElement) {
		return visitTypedRefCS(csElement);
	}

	public @Nullable Continuation<?> visitUnaryOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnaryOperatorCS csElement) {
		return visitOperatorCS(csElement);
	}

	public @Nullable Continuation<?> visitUnlimitedNaturalLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	public @Nullable Continuation<?> visitVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS csElement) {
		return visitNamedElementCS(csElement);
	}
}
