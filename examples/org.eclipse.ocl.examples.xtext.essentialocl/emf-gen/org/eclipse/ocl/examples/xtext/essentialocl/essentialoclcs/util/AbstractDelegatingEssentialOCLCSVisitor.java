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
 * An AbstractDelegatingEssentialOCLCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingEssentialOCLCSVisitor<R, C, D extends EssentialOCLCSVisitor<R>>
	extends org.eclipse.ocl.examples.xtext.base.basecs.util.AbstractDelegatingBaseCSVisitor<R, C, D>
	implements EssentialOCLCSVisitor<R>
{
	protected AbstractDelegatingEssentialOCLCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitBinaryOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS object) {
		return delegate.visitBinaryOperatorCS(object);
	}

	public @Nullable R visitBooleanLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS object) {
		return delegate.visitBooleanLiteralExpCS(object);
	}

	public @Nullable R visitCollectionLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS object) {
		return delegate.visitCollectionLiteralExpCS(object);
	}

	public @Nullable R visitCollectionLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS object) {
		return delegate.visitCollectionLiteralPartCS(object);
	}

	public @Nullable R visitCollectionTypeCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS object) {
		return delegate.visitCollectionTypeCS(object);
	}

	public @Nullable R visitConstructorExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS object) {
		return delegate.visitConstructorExpCS(object);
	}

	public @Nullable R visitConstructorPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS object) {
		return delegate.visitConstructorPartCS(object);
	}

	public @Nullable R visitContextCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS object) {
		return delegate.visitContextCS(object);
	}

	public @Nullable R visitExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitExpSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS object) {
		return delegate.visitExpSpecificationCS(object);
	}

	public @Nullable R visitIfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS object) {
		return delegate.visitIfExpCS(object);
	}

	public @Nullable R visitIndexExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IndexExpCS object) {
		return delegate.visitIndexExpCS(object);
	}

	public @Nullable R visitInfixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS object) {
		return delegate.visitInfixExpCS(object);
	}

	public @Nullable R visitInvalidLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS object) {
		return delegate.visitInvalidLiteralExpCS(object);
	}

	public @Nullable R visitInvocationExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS object) {
		return delegate.visitInvocationExpCS(object);
	}

	public @Nullable R visitLetExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS object) {
		return delegate.visitLetExpCS(object);
	}

	public @Nullable R visitLetVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS object) {
		return delegate.visitLetVariableCS(object);
	}

	public @Nullable R visitLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS object) {
		return delegate.visitLiteralExpCS(object);
	}

	public @Nullable R visitNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS object) {
		return delegate.visitNameExpCS(object);
	}

	public @Nullable R visitNamedExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NamedExpCS object) {
		return delegate.visitNamedExpCS(object);
	}

	public @Nullable R visitNavigatingArgCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS object) {
		return delegate.visitNavigatingArgCS(object);
	}

	public @Nullable R visitNavigationOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS object) {
		return delegate.visitNavigationOperatorCS(object);
	}

	public @Nullable R visitNestedExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS object) {
		return delegate.visitNestedExpCS(object);
	}

	public @Nullable R visitNullLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS object) {
		return delegate.visitNullLiteralExpCS(object);
	}

	public @Nullable R visitNumberLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS object) {
		return delegate.visitNumberLiteralExpCS(object);
	}

	public @Nullable R visitOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS object) {
		return delegate.visitOperatorCS(object);
	}

	public @Nullable R visitPrefixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS object) {
		return delegate.visitPrefixExpCS(object);
	}

	public @Nullable R visitPrimitiveLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS object) {
		return delegate.visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable R visitSelfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS object) {
		return delegate.visitSelfExpCS(object);
	}

	public @Nullable R visitStringLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS object) {
		return delegate.visitStringLiteralExpCS(object);
	}

	public @Nullable R visitTupleLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS object) {
		return delegate.visitTupleLiteralExpCS(object);
	}

	public @Nullable R visitTupleLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS object) {
		return delegate.visitTupleLiteralPartCS(object);
	}

	public @Nullable R visitTypeLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS object) {
		return delegate.visitTypeLiteralExpCS(object);
	}

	public @Nullable R visitTypeNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS object) {
		return delegate.visitTypeNameExpCS(object);
	}

	public @Nullable R visitUnaryOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnaryOperatorCS object) {
		return delegate.visitUnaryOperatorCS(object);
	}

	public @Nullable R visitUnlimitedNaturalLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS object) {
		return delegate.visitUnlimitedNaturalLiteralExpCS(object);
	}

	public @Nullable R visitVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS object) {
		return delegate.visitVariableCS(object);
	}
}
