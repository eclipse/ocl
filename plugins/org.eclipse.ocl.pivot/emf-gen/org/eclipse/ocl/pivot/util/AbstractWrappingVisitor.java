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
 * from: org.eclipse.ocl.pivot/model/Pivot.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.pivot.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractWrappingVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingVisitor<R, C, D extends Visitor<R>, P>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected final D delegate;
	
	protected AbstractWrappingVisitor(@NonNull D delegate, @NonNull C context) {
		super(context);
		this.delegate = delegate;		
	//	delegate.setUndecoratedVisitor(this);
	}

	/**
	 * Intercept an exception thrown by the delegated visit to perform some post-functionality that may use the visitable object,
	 * the result of preVisit and the thrown exception to determine the overall wrapped result.
	 * 
	 * @return a rethrown RuntimeException or a RuntimeException-wrapped non-RuntimeException.
	 */
	protected @Nullable R badVisit(@NonNull org.eclipse.ocl.pivot.util.Visitable visitable, @Nullable P prologue, @NonNull Throwable e) throws RuntimeException {
		if (e instanceof Exception) {
			throw (RuntimeException)e;
		}
		else {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Obtains the visitor that I wrap.
	 * 
	 * @return my wrapped visitor
	 */
	@SuppressWarnings("null")
	protected @NonNull D getDelegate() {
		return delegate;
	}

	/**
	 * Intercept the result of the delegated visit to perform some post-functionality that may use the visitable object,
	 * the result of preVisit and the result of the delegated visit to determine the overall wrapped result.
	 * 
	 * @return the epilogue result, which defaults to the delegated result.
	 */
	protected @Nullable R postVisit(@NonNull org.eclipse.ocl.pivot.util.Visitable visitable, @Nullable P prologue, @Nullable R result) {
		return result;
	}

	/**
	 * Compute and return some value before performing the delegated visit.
	 * 
	 * @return the prologue result, which defauilts to null.
	 */
	protected @Nullable P preVisit(@NonNull org.eclipse.ocl.pivot.util.Visitable visitable) {
		return null;
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.pivot.util.Visitable visitable) {
		throw new UnsupportedOperationException();		// Cannot happen since all methods delegate.
	}

	@Override
	public @Nullable R visitAnnotation(@NonNull org.eclipse.ocl.pivot.Annotation object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitAnnotation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitAnyType(@NonNull org.eclipse.ocl.pivot.AnyType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitAnyType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitAssociationClass(@NonNull org.eclipse.ocl.pivot.AssociationClass object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitAssociationClass(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitAssociationClassCallExp(@NonNull org.eclipse.ocl.pivot.AssociationClassCallExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitAssociationClassCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitBagType(@NonNull org.eclipse.ocl.pivot.BagType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitBagType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitBehavior(@NonNull org.eclipse.ocl.pivot.Behavior object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitBehavior(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitBooleanLiteralExp(@NonNull org.eclipse.ocl.pivot.BooleanLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitBooleanLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitCallExp(@NonNull org.eclipse.ocl.pivot.CallExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitCallOperationAction(@NonNull org.eclipse.ocl.pivot.CallOperationAction object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitCallOperationAction(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitClass(@NonNull org.eclipse.ocl.pivot.Class object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitClass(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitCollectionItem(@NonNull org.eclipse.ocl.pivot.CollectionItem object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionItem(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitCollectionLiteralExp(@NonNull org.eclipse.ocl.pivot.CollectionLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitCollectionLiteralPart(@NonNull org.eclipse.ocl.pivot.CollectionLiteralPart object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionLiteralPart(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitCollectionRange(@NonNull org.eclipse.ocl.pivot.CollectionRange object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionRange(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitCollectionType(@NonNull org.eclipse.ocl.pivot.CollectionType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitComment(@NonNull org.eclipse.ocl.pivot.Comment object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitComment(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitCompleteClass(@NonNull org.eclipse.ocl.pivot.CompleteClass object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitCompleteClass(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitCompleteEnvironment(@NonNull org.eclipse.ocl.pivot.CompleteEnvironment object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitCompleteEnvironment(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitCompleteModel(@NonNull org.eclipse.ocl.pivot.CompleteModel object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitCompleteModel(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitCompletePackage(@NonNull org.eclipse.ocl.pivot.CompletePackage object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitCompletePackage(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitConnectionPointReference(@NonNull org.eclipse.ocl.pivot.ConnectionPointReference object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitConnectionPointReference(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitConstraint(@NonNull org.eclipse.ocl.pivot.Constraint object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitConstraint(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitDataType(@NonNull org.eclipse.ocl.pivot.DataType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitDataType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitDetail(@NonNull org.eclipse.ocl.pivot.Detail object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitDetail(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitDynamicBehavior(@NonNull org.eclipse.ocl.pivot.DynamicBehavior object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitDynamicBehavior(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitDynamicElement(@NonNull org.eclipse.ocl.pivot.DynamicElement object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitDynamicElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitDynamicProperty(@NonNull org.eclipse.ocl.pivot.DynamicProperty object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitDynamicProperty(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitDynamicType(@NonNull org.eclipse.ocl.pivot.DynamicType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitDynamicType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitDynamicValueSpecification(@NonNull org.eclipse.ocl.pivot.DynamicValueSpecification object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitDynamicValueSpecification(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitElement(@NonNull org.eclipse.ocl.pivot.Element object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitElementExtension(@NonNull org.eclipse.ocl.pivot.ElementExtension object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitElementExtension(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitEnumLiteralExp(@NonNull org.eclipse.ocl.pivot.EnumLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitEnumLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitEnumeration(@NonNull org.eclipse.ocl.pivot.Enumeration object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitEnumeration(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitEnumerationLiteral(@NonNull org.eclipse.ocl.pivot.EnumerationLiteral object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitEnumerationLiteral(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitExpressionInOCL(@NonNull org.eclipse.ocl.pivot.ExpressionInOCL object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitExpressionInOCL(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitFeature(@NonNull org.eclipse.ocl.pivot.Feature object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitFeature(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitFeatureCallExp(@NonNull org.eclipse.ocl.pivot.FeatureCallExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitFeatureCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitFinalState(@NonNull org.eclipse.ocl.pivot.FinalState object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitFinalState(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitIfExp(@NonNull org.eclipse.ocl.pivot.IfExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitIfExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitImport(@NonNull org.eclipse.ocl.pivot.Import object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitImport(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitInstanceSpecification(@NonNull org.eclipse.ocl.pivot.InstanceSpecification object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitInstanceSpecification(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitIntegerLiteralExp(@NonNull org.eclipse.ocl.pivot.IntegerLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitIntegerLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitInvalidLiteralExp(@NonNull org.eclipse.ocl.pivot.InvalidLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitInvalidLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitInvalidType(@NonNull org.eclipse.ocl.pivot.InvalidType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitInvalidType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitIterateExp(@NonNull org.eclipse.ocl.pivot.IterateExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitIterateExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitIteration(@NonNull org.eclipse.ocl.pivot.Iteration object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitIteration(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitIteratorExp(@NonNull org.eclipse.ocl.pivot.IteratorExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitIteratorExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitLambdaType(@NonNull org.eclipse.ocl.pivot.LambdaType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitLambdaType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitLanguageExpression(@NonNull org.eclipse.ocl.pivot.LanguageExpression object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitLanguageExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitLetExp(@NonNull org.eclipse.ocl.pivot.LetExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitLetExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitLibrary(@NonNull org.eclipse.ocl.pivot.Library object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitLibrary(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitLiteralExp(@NonNull org.eclipse.ocl.pivot.LiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitLoopExp(@NonNull org.eclipse.ocl.pivot.LoopExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitLoopExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitMapLiteralExp(@NonNull org.eclipse.ocl.pivot.MapLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitMapLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitMapLiteralPart(@NonNull org.eclipse.ocl.pivot.MapLiteralPart object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitMapLiteralPart(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitMapType(@NonNull org.eclipse.ocl.pivot.MapType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitMapType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitMessageExp(@NonNull org.eclipse.ocl.pivot.MessageExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitMessageExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitMessageType(@NonNull org.eclipse.ocl.pivot.MessageType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitMessageType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitModel(@NonNull org.eclipse.ocl.pivot.Model object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitModel(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitNamedElement(@NonNull org.eclipse.ocl.pivot.NamedElement object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitNamedElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitNamespace(@NonNull org.eclipse.ocl.pivot.Namespace object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitNamespace(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitNavigationCallExp(@NonNull org.eclipse.ocl.pivot.NavigationCallExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitNavigationCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitNullLiteralExp(@NonNull org.eclipse.ocl.pivot.NullLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitNullLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitNumericLiteralExp(@NonNull org.eclipse.ocl.pivot.NumericLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitNumericLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitOCLExpression(@NonNull org.eclipse.ocl.pivot.OCLExpression object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitOCLExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitOperation(@NonNull org.eclipse.ocl.pivot.Operation object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitOperation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitOperationCallExp(@NonNull org.eclipse.ocl.pivot.OperationCallExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitOperationCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitOppositePropertyCallExp(@NonNull org.eclipse.ocl.pivot.OppositePropertyCallExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitOppositePropertyCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitOrderedSetType(@NonNull org.eclipse.ocl.pivot.OrderedSetType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitOrderedSetType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitOrphanCompletePackage(@NonNull org.eclipse.ocl.pivot.OrphanCompletePackage object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitOrphanCompletePackage(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitPackage(@NonNull org.eclipse.ocl.pivot.Package object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitPackage(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitParameter(@NonNull org.eclipse.ocl.pivot.Parameter object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitParameterableElement(@NonNull org.eclipse.ocl.pivot.ParameterableElement object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitParameterableElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitPrecedence(@NonNull org.eclipse.ocl.pivot.Precedence object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitPrecedence(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitPrimitiveCompletePackage(@NonNull org.eclipse.ocl.pivot.PrimitiveCompletePackage object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitPrimitiveCompletePackage(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitPrimitiveLiteralExp(@NonNull org.eclipse.ocl.pivot.PrimitiveLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitPrimitiveLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitPrimitiveType(@NonNull org.eclipse.ocl.pivot.PrimitiveType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitPrimitiveType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitProfile(@NonNull org.eclipse.ocl.pivot.Profile object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitProfile(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitProfileApplication(@NonNull org.eclipse.ocl.pivot.ProfileApplication object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitProfileApplication(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitProperty(@NonNull org.eclipse.ocl.pivot.Property object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitProperty(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitPropertyCallExp(@NonNull org.eclipse.ocl.pivot.PropertyCallExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitPropertyCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitPseudostate(@NonNull org.eclipse.ocl.pivot.Pseudostate object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitPseudostate(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitRealLiteralExp(@NonNull org.eclipse.ocl.pivot.RealLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitRealLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitRegion(@NonNull org.eclipse.ocl.pivot.Region object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitRegion(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitSelfType(@NonNull org.eclipse.ocl.pivot.SelfType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitSelfType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitSendSignalAction(@NonNull org.eclipse.ocl.pivot.SendSignalAction object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitSendSignalAction(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitSequenceType(@NonNull org.eclipse.ocl.pivot.SequenceType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitSequenceType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitSetType(@NonNull org.eclipse.ocl.pivot.SetType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitSetType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitShadowExp(@NonNull org.eclipse.ocl.pivot.ShadowExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitShadowExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitShadowPart(@NonNull org.eclipse.ocl.pivot.ShadowPart object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitShadowPart(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitSignal(@NonNull org.eclipse.ocl.pivot.Signal object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitSignal(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitSlot(@NonNull org.eclipse.ocl.pivot.Slot object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitSlot(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitStandardLibrary(@NonNull org.eclipse.ocl.pivot.StandardLibrary object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitStandardLibrary(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitState(@NonNull org.eclipse.ocl.pivot.State object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitState(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitStateExp(@NonNull org.eclipse.ocl.pivot.StateExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitStateExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitStateMachine(@NonNull org.eclipse.ocl.pivot.StateMachine object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitStateMachine(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitStereotype(@NonNull org.eclipse.ocl.pivot.Stereotype object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitStereotype(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitStereotypeExtender(@NonNull org.eclipse.ocl.pivot.StereotypeExtender object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitStereotypeExtender(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitStringLiteralExp(@NonNull org.eclipse.ocl.pivot.StringLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitStringLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitTemplateBinding(@NonNull org.eclipse.ocl.pivot.TemplateBinding object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTemplateBinding(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitTemplateParameter(@NonNull org.eclipse.ocl.pivot.TemplateParameter object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTemplateParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitTemplateParameterSubstitution(@NonNull org.eclipse.ocl.pivot.TemplateParameterSubstitution object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTemplateParameterSubstitution(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitTemplateSignature(@NonNull org.eclipse.ocl.pivot.TemplateSignature object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTemplateSignature(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitTemplateableElement(@NonNull org.eclipse.ocl.pivot.TemplateableElement object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTemplateableElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitTransition(@NonNull org.eclipse.ocl.pivot.Transition object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTransition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitTrigger(@NonNull org.eclipse.ocl.pivot.Trigger object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTrigger(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitTupleLiteralExp(@NonNull org.eclipse.ocl.pivot.TupleLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTupleLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitTupleLiteralPart(@NonNull org.eclipse.ocl.pivot.TupleLiteralPart object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTupleLiteralPart(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitTupleType(@NonNull org.eclipse.ocl.pivot.TupleType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTupleType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitType(@NonNull org.eclipse.ocl.pivot.Type object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitTypeExp(@NonNull org.eclipse.ocl.pivot.TypeExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTypeExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitTypedElement(@NonNull org.eclipse.ocl.pivot.TypedElement object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTypedElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitUnlimitedNaturalLiteralExp(@NonNull org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitUnlimitedNaturalLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitUnspecifiedValueExp(@NonNull org.eclipse.ocl.pivot.UnspecifiedValueExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitUnspecifiedValueExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitValueSpecification(@NonNull org.eclipse.ocl.pivot.ValueSpecification object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitValueSpecification(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitVariable(@NonNull org.eclipse.ocl.pivot.Variable object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitVariable(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitVariableDeclaration(@NonNull org.eclipse.ocl.pivot.VariableDeclaration object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitVariableDeclaration(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitVariableExp(@NonNull org.eclipse.ocl.pivot.VariableExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitVariableExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitVertex(@NonNull org.eclipse.ocl.pivot.Vertex object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitVertex(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitVoidType(@NonNull org.eclipse.ocl.pivot.VoidType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitVoidType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public @Nullable R visitWildcardType(@NonNull org.eclipse.ocl.pivot.WildcardType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitWildcardType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
