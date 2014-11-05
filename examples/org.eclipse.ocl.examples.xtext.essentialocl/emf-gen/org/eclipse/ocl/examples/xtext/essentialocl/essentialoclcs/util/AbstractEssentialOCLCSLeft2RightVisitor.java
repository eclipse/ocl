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
import org.eclipse.ocl.examples.xtext.base.cs2as.BaseCSLeft2RightVisitor;
import org.eclipse.ocl.examples.pivot.Element;

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

	public @Nullable Element visitAbstractNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AbstractNameExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitAssociationClassCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AssociationClassCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	public @Nullable Element visitBooleanLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	public @Nullable Element visitCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CallExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}

	public @Nullable Element visitCollectionLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	public @Nullable Element visitCollectionLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Element visitCollectionPatternCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS csElement) {
		return visitTypedRefCS(csElement);
	}

	public @Nullable Element visitCollectionTypeCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	public @Nullable Element visitConstructorExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}

	public @Nullable Element visitConstructorPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Element visitContextCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Element visitCurlyBracketedClauseCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	public @Nullable Element visitExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Element visitExpSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS csElement) {
		return visitSpecificationCS(csElement);
	}

	public @Nullable Element visitIfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitIfThenExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfThenExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitInfixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS csElement) {
		return visitOperatorCS(csElement);
	}

	public @Nullable Element visitInvalidLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	public @Nullable Element visitIterateCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterateCallExpCS csElement) {
		return visitIterationCallExpCS(csElement);
	}

	public @Nullable Element visitIterationCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterationCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	public @Nullable Element visitLambdaLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LambdaLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	public @Nullable Element visitLetExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitLetVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS csElement) {
		return visitVariableCS(csElement);
	}

	public @Nullable Element visitLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS csElement) {
		return visitAssociationClassCallExpCS(csElement);
	}

	public @Nullable Element visitNavigatingArgCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Element visitNestedExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitNullLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	public @Nullable Element visitNumberLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	public @Nullable Element visitOperationCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperationCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	public @Nullable Element visitOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitPatternExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PatternExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitPrefixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS csElement) {
		return visitOperatorCS(csElement);
	}

	public @Nullable Element visitPrimitiveLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	public @Nullable Element visitPropertyCallExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PropertyCallExpCS csElement) {
		return visitCallExpCS(csElement);
	}

	public @Nullable Element visitRoundBracketedClauseCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	public @Nullable Element visitSelfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitSquareBracketedClauseCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS csElement) {
		return visitContextLessElementCS(csElement);
	}

	public @Nullable Element visitStringLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	public @Nullable Element visitTupleLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	public @Nullable Element visitTupleLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS csElement) {
		return visitVariableCS(csElement);
	}

	public @Nullable Element visitTypeLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS csElement) {
		return visitLiteralExpCS(csElement);
	}

	public @Nullable Element visitTypeNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS csElement) {
		return visitTypedRefCS(csElement);
	}

	public @Nullable Element visitUnlimitedNaturalLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS csElement) {
		return visitPrimitiveLiteralExpCS(csElement);
	}

	public @Nullable Element visitVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Element visitVariableExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableExpCS csElement) {
		return visitAbstractNameExpCS(csElement);
	}
}
