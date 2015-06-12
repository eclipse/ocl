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
	protected @Nullable R badVisit(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable, @Nullable P prologue, @NonNull Throwable e) throws RuntimeException {
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
	protected @Nullable R postVisit(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable, @Nullable P prologue, @Nullable R result) {
		return result;
	}

	/**
	 * Compute and return some value before performing the delegated visit.
	 * 
	 * @return the prologue result, which defauilts to null.
	 */
	protected @Nullable P preVisit(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable) {
		return null;
	}

	@Override
	public @Nullable R visiting(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable) {
		throw new UnsupportedOperationException();		// Cannot happen since all methods delegate.
	}

	@Override
	public @Nullable R visitAnnotation(org.eclipse.ocl.pivot.@NonNull Annotation object) {
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
	public @Nullable R visitAnyType(org.eclipse.ocl.pivot.@NonNull AnyType object) {
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
	public @Nullable R visitAssociationClass(org.eclipse.ocl.pivot.@NonNull AssociationClass object) {
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
	public @Nullable R visitAssociationClassCallExp(org.eclipse.ocl.pivot.@NonNull AssociationClassCallExp object) {
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
	public @Nullable R visitBagType(org.eclipse.ocl.pivot.@NonNull BagType object) {
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
	public @Nullable R visitBehavior(org.eclipse.ocl.pivot.@NonNull Behavior object) {
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
	public @Nullable R visitBooleanLiteralExp(org.eclipse.ocl.pivot.@NonNull BooleanLiteralExp object) {
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
	public @Nullable R visitCallExp(org.eclipse.ocl.pivot.@NonNull CallExp object) {
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
	public @Nullable R visitCallOperationAction(org.eclipse.ocl.pivot.@NonNull CallOperationAction object) {
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
	public @Nullable R visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
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
	public @Nullable R visitCollectionItem(org.eclipse.ocl.pivot.@NonNull CollectionItem object) {
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
	public @Nullable R visitCollectionLiteralExp(org.eclipse.ocl.pivot.@NonNull CollectionLiteralExp object) {
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
	public @Nullable R visitCollectionLiteralPart(org.eclipse.ocl.pivot.@NonNull CollectionLiteralPart object) {
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
	public @Nullable R visitCollectionRange(org.eclipse.ocl.pivot.@NonNull CollectionRange object) {
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
	public @Nullable R visitCollectionType(org.eclipse.ocl.pivot.@NonNull CollectionType object) {
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
	public @Nullable R visitComment(org.eclipse.ocl.pivot.@NonNull Comment object) {
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
	public @Nullable R visitCompleteClass(org.eclipse.ocl.pivot.@NonNull CompleteClass object) {
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
	public @Nullable R visitCompleteEnvironment(org.eclipse.ocl.pivot.@NonNull CompleteEnvironment object) {
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
	public @Nullable R visitCompleteModel(org.eclipse.ocl.pivot.@NonNull CompleteModel object) {
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
	public @Nullable R visitCompletePackage(org.eclipse.ocl.pivot.@NonNull CompletePackage object) {
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
	public @Nullable R visitConnectionPointReference(org.eclipse.ocl.pivot.@NonNull ConnectionPointReference object) {
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
	public @Nullable R visitConstraint(org.eclipse.ocl.pivot.@NonNull Constraint object) {
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
	public @Nullable R visitDataType(org.eclipse.ocl.pivot.@NonNull DataType object) {
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
	public @Nullable R visitDetail(org.eclipse.ocl.pivot.@NonNull Detail object) {
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
	public @Nullable R visitDynamicBehavior(org.eclipse.ocl.pivot.@NonNull DynamicBehavior object) {
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
	public @Nullable R visitDynamicElement(org.eclipse.ocl.pivot.@NonNull DynamicElement object) {
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
	public @Nullable R visitDynamicProperty(org.eclipse.ocl.pivot.@NonNull DynamicProperty object) {
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
	public @Nullable R visitDynamicType(org.eclipse.ocl.pivot.@NonNull DynamicType object) {
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
	public @Nullable R visitDynamicValueSpecification(org.eclipse.ocl.pivot.@NonNull DynamicValueSpecification object) {
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
	public @Nullable R visitElement(org.eclipse.ocl.pivot.@NonNull Element object) {
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
	public @Nullable R visitElementExtension(org.eclipse.ocl.pivot.@NonNull ElementExtension object) {
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
	public @Nullable R visitEnumLiteralExp(org.eclipse.ocl.pivot.@NonNull EnumLiteralExp object) {
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
	public @Nullable R visitEnumeration(org.eclipse.ocl.pivot.@NonNull Enumeration object) {
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
	public @Nullable R visitEnumerationLiteral(org.eclipse.ocl.pivot.@NonNull EnumerationLiteral object) {
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
	public @Nullable R visitExpressionInOCL(org.eclipse.ocl.pivot.@NonNull ExpressionInOCL object) {
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
	public @Nullable R visitFeature(org.eclipse.ocl.pivot.@NonNull Feature object) {
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
	public @Nullable R visitFeatureCallExp(org.eclipse.ocl.pivot.@NonNull FeatureCallExp object) {
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
	public @Nullable R visitFinalState(org.eclipse.ocl.pivot.@NonNull FinalState object) {
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
	public @Nullable R visitIfExp(org.eclipse.ocl.pivot.@NonNull IfExp object) {
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
	public @Nullable R visitImport(org.eclipse.ocl.pivot.@NonNull Import object) {
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
	public @Nullable R visitInstanceSpecification(org.eclipse.ocl.pivot.@NonNull InstanceSpecification object) {
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
	public @Nullable R visitIntegerLiteralExp(org.eclipse.ocl.pivot.@NonNull IntegerLiteralExp object) {
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
	public @Nullable R visitInvalidLiteralExp(org.eclipse.ocl.pivot.@NonNull InvalidLiteralExp object) {
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
	public @Nullable R visitInvalidType(org.eclipse.ocl.pivot.@NonNull InvalidType object) {
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
	public @Nullable R visitIterateExp(org.eclipse.ocl.pivot.@NonNull IterateExp object) {
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
	public @Nullable R visitIteration(org.eclipse.ocl.pivot.@NonNull Iteration object) {
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
	public @Nullable R visitIteratorExp(org.eclipse.ocl.pivot.@NonNull IteratorExp object) {
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
	public @Nullable R visitLambdaType(org.eclipse.ocl.pivot.@NonNull LambdaType object) {
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
	public @Nullable R visitLanguageExpression(org.eclipse.ocl.pivot.@NonNull LanguageExpression object) {
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
	public @Nullable R visitLetExp(org.eclipse.ocl.pivot.@NonNull LetExp object) {
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
	public @Nullable R visitLibrary(org.eclipse.ocl.pivot.@NonNull Library object) {
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
	public @Nullable R visitLiteralExp(org.eclipse.ocl.pivot.@NonNull LiteralExp object) {
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
	public @Nullable R visitLoopExp(org.eclipse.ocl.pivot.@NonNull LoopExp object) {
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
	public @Nullable R visitMapLiteralExp(org.eclipse.ocl.pivot.@NonNull MapLiteralExp object) {
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
	public @Nullable R visitMapLiteralPart(org.eclipse.ocl.pivot.@NonNull MapLiteralPart object) {
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
	public @Nullable R visitMapType(org.eclipse.ocl.pivot.@NonNull MapType object) {
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
	public @Nullable R visitMessageExp(org.eclipse.ocl.pivot.@NonNull MessageExp object) {
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
	public @Nullable R visitMessageType(org.eclipse.ocl.pivot.@NonNull MessageType object) {
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
	public @Nullable R visitModel(org.eclipse.ocl.pivot.@NonNull Model object) {
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
	public @Nullable R visitNamedElement(org.eclipse.ocl.pivot.@NonNull NamedElement object) {
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
	public @Nullable R visitNamespace(org.eclipse.ocl.pivot.@NonNull Namespace object) {
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
	public @Nullable R visitNavigationCallExp(org.eclipse.ocl.pivot.@NonNull NavigationCallExp object) {
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
	public @Nullable R visitNullLiteralExp(org.eclipse.ocl.pivot.@NonNull NullLiteralExp object) {
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
	public @Nullable R visitNumericLiteralExp(org.eclipse.ocl.pivot.@NonNull NumericLiteralExp object) {
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
	public @Nullable R visitOCLExpression(org.eclipse.ocl.pivot.@NonNull OCLExpression object) {
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
	public @Nullable R visitOperation(org.eclipse.ocl.pivot.@NonNull Operation object) {
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
	public @Nullable R visitOperationCallExp(org.eclipse.ocl.pivot.@NonNull OperationCallExp object) {
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
	public @Nullable R visitOppositePropertyCallExp(org.eclipse.ocl.pivot.@NonNull OppositePropertyCallExp object) {
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
	public @Nullable R visitOrderedSetType(org.eclipse.ocl.pivot.@NonNull OrderedSetType object) {
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
	public @Nullable R visitOrphanCompletePackage(org.eclipse.ocl.pivot.@NonNull OrphanCompletePackage object) {
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
	public @Nullable R visitPackage(org.eclipse.ocl.pivot.@NonNull Package object) {
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
	public @Nullable R visitParameter(org.eclipse.ocl.pivot.@NonNull Parameter object) {
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
	public @Nullable R visitPrecedence(org.eclipse.ocl.pivot.@NonNull Precedence object) {
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
	public @Nullable R visitPrimitiveCompletePackage(org.eclipse.ocl.pivot.@NonNull PrimitiveCompletePackage object) {
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
	public @Nullable R visitPrimitiveLiteralExp(org.eclipse.ocl.pivot.@NonNull PrimitiveLiteralExp object) {
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
	public @Nullable R visitPrimitiveType(org.eclipse.ocl.pivot.@NonNull PrimitiveType object) {
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
	public @Nullable R visitProfile(org.eclipse.ocl.pivot.@NonNull Profile object) {
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
	public @Nullable R visitProfileApplication(org.eclipse.ocl.pivot.@NonNull ProfileApplication object) {
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
	public @Nullable R visitProperty(org.eclipse.ocl.pivot.@NonNull Property object) {
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
	public @Nullable R visitPropertyCallExp(org.eclipse.ocl.pivot.@NonNull PropertyCallExp object) {
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
	public @Nullable R visitPseudostate(org.eclipse.ocl.pivot.@NonNull Pseudostate object) {
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
	public @Nullable R visitRealLiteralExp(org.eclipse.ocl.pivot.@NonNull RealLiteralExp object) {
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
	public @Nullable R visitRegion(org.eclipse.ocl.pivot.@NonNull Region object) {
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
	public @Nullable R visitSelfType(org.eclipse.ocl.pivot.@NonNull SelfType object) {
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
	public @Nullable R visitSendSignalAction(org.eclipse.ocl.pivot.@NonNull SendSignalAction object) {
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
	public @Nullable R visitSequenceType(org.eclipse.ocl.pivot.@NonNull SequenceType object) {
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
	public @Nullable R visitSetType(org.eclipse.ocl.pivot.@NonNull SetType object) {
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
	public @Nullable R visitShadowExp(org.eclipse.ocl.pivot.@NonNull ShadowExp object) {
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
	public @Nullable R visitShadowPart(org.eclipse.ocl.pivot.@NonNull ShadowPart object) {
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
	public @Nullable R visitSignal(org.eclipse.ocl.pivot.@NonNull Signal object) {
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
	public @Nullable R visitSlot(org.eclipse.ocl.pivot.@NonNull Slot object) {
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
	public @Nullable R visitStandardLibrary(org.eclipse.ocl.pivot.@NonNull StandardLibrary object) {
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
	public @Nullable R visitState(org.eclipse.ocl.pivot.@NonNull State object) {
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
	public @Nullable R visitStateExp(org.eclipse.ocl.pivot.@NonNull StateExp object) {
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
	public @Nullable R visitStateMachine(org.eclipse.ocl.pivot.@NonNull StateMachine object) {
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
	public @Nullable R visitStereotype(org.eclipse.ocl.pivot.@NonNull Stereotype object) {
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
	public @Nullable R visitStereotypeExtender(org.eclipse.ocl.pivot.@NonNull StereotypeExtender object) {
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
	public @Nullable R visitStringLiteralExp(org.eclipse.ocl.pivot.@NonNull StringLiteralExp object) {
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
	public @Nullable R visitTemplateBinding(org.eclipse.ocl.pivot.@NonNull TemplateBinding object) {
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
	public @Nullable R visitTemplateParameter(org.eclipse.ocl.pivot.@NonNull TemplateParameter object) {
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
	public @Nullable R visitTemplateParameterSubstitution(org.eclipse.ocl.pivot.@NonNull TemplateParameterSubstitution object) {
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
	public @Nullable R visitTemplateSignature(org.eclipse.ocl.pivot.@NonNull TemplateSignature object) {
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
	public @Nullable R visitTemplateableElement(org.eclipse.ocl.pivot.@NonNull TemplateableElement object) {
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
	public @Nullable R visitTransition(org.eclipse.ocl.pivot.@NonNull Transition object) {
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
	public @Nullable R visitTrigger(org.eclipse.ocl.pivot.@NonNull Trigger object) {
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
	public @Nullable R visitTupleLiteralExp(org.eclipse.ocl.pivot.@NonNull TupleLiteralExp object) {
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
	public @Nullable R visitTupleLiteralPart(org.eclipse.ocl.pivot.@NonNull TupleLiteralPart object) {
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
	public @Nullable R visitTupleType(org.eclipse.ocl.pivot.@NonNull TupleType object) {
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
	public @Nullable R visitType(org.eclipse.ocl.pivot.@NonNull Type object) {
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
	public @Nullable R visitTypeExp(org.eclipse.ocl.pivot.@NonNull TypeExp object) {
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
	public @Nullable R visitTypedElement(org.eclipse.ocl.pivot.@NonNull TypedElement object) {
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
	public @Nullable R visitUnlimitedNaturalLiteralExp(org.eclipse.ocl.pivot.@NonNull UnlimitedNaturalLiteralExp object) {
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
	public @Nullable R visitUnspecifiedValueExp(org.eclipse.ocl.pivot.@NonNull UnspecifiedValueExp object) {
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
	public @Nullable R visitValueSpecification(org.eclipse.ocl.pivot.@NonNull ValueSpecification object) {
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
	public @Nullable R visitVariable(org.eclipse.ocl.pivot.@NonNull Variable object) {
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
	public @Nullable R visitVariableDeclaration(org.eclipse.ocl.pivot.@NonNull VariableDeclaration object) {
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
	public @Nullable R visitVariableExp(org.eclipse.ocl.pivot.@NonNull VariableExp object) {
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
	public @Nullable R visitVertex(org.eclipse.ocl.pivot.@NonNull Vertex object) {
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
	public @Nullable R visitVoidType(org.eclipse.ocl.pivot.@NonNull VoidType object) {
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
	public @Nullable R visitWildcardType(org.eclipse.ocl.pivot.@NonNull WildcardType object) {
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
