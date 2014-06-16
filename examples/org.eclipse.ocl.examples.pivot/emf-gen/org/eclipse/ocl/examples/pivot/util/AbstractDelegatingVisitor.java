/*******************************************************************************
 * Copyright (c) 2010,2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.pivot/model/Pivot.merged.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.pivot.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingVisitor delegates all visits.
 */
public abstract class AbstractDelegatingVisitor<R, C, D extends Visitor<R>>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected final D delegate;
	
	protected AbstractDelegatingVisitor(@NonNull D delegate, @NonNull C context) {
		super(context);
	//	assert delegate != null : "cannot decorate a null visitor"; //$NON-NLS-1$
		this.delegate = delegate;		
	//	delegate.setUndecoratedVisitor(this);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	//	public @NonNull DecorableVisitor<R> createNestedVisitor() {
	//		return delegate.createNestedVisitor();
	//	}

	/**
	 * Obtains the visitor that I decorate.
	 * 
	 * @return my decorated visitor
	 */
	@SuppressWarnings("null")
	protected final @NonNull D getDelegate() {
		return delegate;
	}

	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.pivot.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitAnnotation(@NonNull org.eclipse.ocl.examples.pivot.Annotation object) {
		return delegate.visitAnnotation(object);
	}

	public @Nullable R visitAnyType(@NonNull org.eclipse.ocl.examples.pivot.AnyType object) {
		return delegate.visitAnyType(object);
	}

	public @Nullable R visitAssociationClass(@NonNull org.eclipse.ocl.examples.pivot.AssociationClass object) {
		return delegate.visitAssociationClass(object);
	}

	public @Nullable R visitAssociationClassCallExp(@NonNull org.eclipse.ocl.examples.pivot.AssociationClassCallExp object) {
		return delegate.visitAssociationClassCallExp(object);
	}

	public @Nullable R visitBagType(@NonNull org.eclipse.ocl.examples.pivot.BagType object) {
		return delegate.visitBagType(object);
	}

	public @Nullable R visitBehavior(@NonNull org.eclipse.ocl.examples.pivot.Behavior object) {
		return delegate.visitBehavior(object);
	}

	public @Nullable R visitBooleanLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.BooleanLiteralExp object) {
		return delegate.visitBooleanLiteralExp(object);
	}

	public @Nullable R visitCallExp(@NonNull org.eclipse.ocl.examples.pivot.CallExp object) {
		return delegate.visitCallExp(object);
	}

	public @Nullable R visitCallOperationAction(@NonNull org.eclipse.ocl.examples.pivot.CallOperationAction object) {
		return delegate.visitCallOperationAction(object);
	}

	public @Nullable R visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		return delegate.visitClass(object);
	}

	public @Nullable R visitCollectionItem(@NonNull org.eclipse.ocl.examples.pivot.CollectionItem object) {
		return delegate.visitCollectionItem(object);
	}

	public @Nullable R visitCollectionLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.CollectionLiteralExp object) {
		return delegate.visitCollectionLiteralExp(object);
	}

	public @Nullable R visitCollectionLiteralPart(@NonNull org.eclipse.ocl.examples.pivot.CollectionLiteralPart object) {
		return delegate.visitCollectionLiteralPart(object);
	}

	public @Nullable R visitCollectionRange(@NonNull org.eclipse.ocl.examples.pivot.CollectionRange object) {
		return delegate.visitCollectionRange(object);
	}

	public @Nullable R visitCollectionType(@NonNull org.eclipse.ocl.examples.pivot.CollectionType object) {
		return delegate.visitCollectionType(object);
	}

	public @Nullable R visitComment(@NonNull org.eclipse.ocl.examples.pivot.Comment object) {
		return delegate.visitComment(object);
	}

	public @Nullable R visitConnectionPointReference(@NonNull org.eclipse.ocl.examples.pivot.ConnectionPointReference object) {
		return delegate.visitConnectionPointReference(object);
	}

	public @Nullable R visitConstraint(@NonNull org.eclipse.ocl.examples.pivot.Constraint object) {
		return delegate.visitConstraint(object);
	}

	public @Nullable R visitConstructorExp(@NonNull org.eclipse.ocl.examples.pivot.ConstructorExp object) {
		return delegate.visitConstructorExp(object);
	}

	public @Nullable R visitConstructorPart(@NonNull org.eclipse.ocl.examples.pivot.ConstructorPart object) {
		return delegate.visitConstructorPart(object);
	}

	public @Nullable R visitDataType(@NonNull org.eclipse.ocl.examples.pivot.DataType object) {
		return delegate.visitDataType(object);
	}

	public @Nullable R visitDetail(@NonNull org.eclipse.ocl.examples.pivot.Detail object) {
		return delegate.visitDetail(object);
	}

	public @Nullable R visitDynamicBehavior(@NonNull org.eclipse.ocl.examples.pivot.DynamicBehavior object) {
		return delegate.visitDynamicBehavior(object);
	}

	public @Nullable R visitDynamicElement(@NonNull org.eclipse.ocl.examples.pivot.DynamicElement object) {
		return delegate.visitDynamicElement(object);
	}

	public @Nullable R visitDynamicProperty(@NonNull org.eclipse.ocl.examples.pivot.DynamicProperty object) {
		return delegate.visitDynamicProperty(object);
	}

	public @Nullable R visitDynamicType(@NonNull org.eclipse.ocl.examples.pivot.DynamicType object) {
		return delegate.visitDynamicType(object);
	}

	public @Nullable R visitElement(@NonNull org.eclipse.ocl.examples.pivot.Element object) {
		return delegate.visitElement(object);
	}

	public @Nullable R visitElementExtension(@NonNull org.eclipse.ocl.examples.pivot.ElementExtension object) {
		return delegate.visitElementExtension(object);
	}

	public @Nullable R visitEnumLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.EnumLiteralExp object) {
		return delegate.visitEnumLiteralExp(object);
	}

	public @Nullable R visitEnumeration(@NonNull org.eclipse.ocl.examples.pivot.Enumeration object) {
		return delegate.visitEnumeration(object);
	}

	public @Nullable R visitEnumerationLiteral(@NonNull org.eclipse.ocl.examples.pivot.EnumerationLiteral object) {
		return delegate.visitEnumerationLiteral(object);
	}

	public @Nullable R visitExpressionInOCL(@NonNull org.eclipse.ocl.examples.pivot.ExpressionInOCL object) {
		return delegate.visitExpressionInOCL(object);
	}

	public @Nullable R visitFeature(@NonNull org.eclipse.ocl.examples.pivot.Feature object) {
		return delegate.visitFeature(object);
	}

	public @Nullable R visitFeatureCallExp(@NonNull org.eclipse.ocl.examples.pivot.FeatureCallExp object) {
		return delegate.visitFeatureCallExp(object);
	}

	public @Nullable R visitFinalState(@NonNull org.eclipse.ocl.examples.pivot.FinalState object) {
		return delegate.visitFinalState(object);
	}

	public @Nullable R visitIfExp(@NonNull org.eclipse.ocl.examples.pivot.IfExp object) {
		return delegate.visitIfExp(object);
	}

	public @Nullable R visitImport(@NonNull org.eclipse.ocl.examples.pivot.Import object) {
		return delegate.visitImport(object);
	}

	public @Nullable R visitIntegerLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.IntegerLiteralExp object) {
		return delegate.visitIntegerLiteralExp(object);
	}

	public @Nullable R visitInvalidLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.InvalidLiteralExp object) {
		return delegate.visitInvalidLiteralExp(object);
	}

	public @Nullable R visitInvalidType(@NonNull org.eclipse.ocl.examples.pivot.InvalidType object) {
		return delegate.visitInvalidType(object);
	}

	public @Nullable R visitIterateExp(@NonNull org.eclipse.ocl.examples.pivot.IterateExp object) {
		return delegate.visitIterateExp(object);
	}

	public @Nullable R visitIteration(@NonNull org.eclipse.ocl.examples.pivot.Iteration object) {
		return delegate.visitIteration(object);
	}

	public @Nullable R visitIteratorExp(@NonNull org.eclipse.ocl.examples.pivot.IteratorExp object) {
		return delegate.visitIteratorExp(object);
	}

	public @Nullable R visitLambdaType(@NonNull org.eclipse.ocl.examples.pivot.LambdaType object) {
		return delegate.visitLambdaType(object);
	}

	public @Nullable R visitLetExp(@NonNull org.eclipse.ocl.examples.pivot.LetExp object) {
		return delegate.visitLetExp(object);
	}

	public @Nullable R visitLibrary(@NonNull org.eclipse.ocl.examples.pivot.Library object) {
		return delegate.visitLibrary(object);
	}

	public @Nullable R visitLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.LiteralExp object) {
		return delegate.visitLiteralExp(object);
	}

	public @Nullable R visitLoopExp(@NonNull org.eclipse.ocl.examples.pivot.LoopExp object) {
		return delegate.visitLoopExp(object);
	}

	public @Nullable R visitMessageExp(@NonNull org.eclipse.ocl.examples.pivot.MessageExp object) {
		return delegate.visitMessageExp(object);
	}

	public @Nullable R visitMessageType(@NonNull org.eclipse.ocl.examples.pivot.MessageType object) {
		return delegate.visitMessageType(object);
	}

	public @Nullable R visitMetaclass(@NonNull org.eclipse.ocl.examples.pivot.Metaclass<?> object) {
		return delegate.visitMetaclass(object);
	}

	public @Nullable R visitNamedElement(@NonNull org.eclipse.ocl.examples.pivot.NamedElement object) {
		return delegate.visitNamedElement(object);
	}

	public @Nullable R visitNamespace(@NonNull org.eclipse.ocl.examples.pivot.Namespace object) {
		return delegate.visitNamespace(object);
	}

	public @Nullable R visitNavigationCallExp(@NonNull org.eclipse.ocl.examples.pivot.NavigationCallExp object) {
		return delegate.visitNavigationCallExp(object);
	}

	public @Nullable R visitNullLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.NullLiteralExp object) {
		return delegate.visitNullLiteralExp(object);
	}

	public @Nullable R visitNumericLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.NumericLiteralExp object) {
		return delegate.visitNumericLiteralExp(object);
	}

	public @Nullable R visitOCLExpression(@NonNull org.eclipse.ocl.examples.pivot.OCLExpression object) {
		return delegate.visitOCLExpression(object);
	}

	public @Nullable R visitOpaqueExpression(@NonNull org.eclipse.ocl.examples.pivot.OpaqueExpression object) {
		return delegate.visitOpaqueExpression(object);
	}

	public @Nullable R visitOperation(@NonNull org.eclipse.ocl.examples.pivot.Operation object) {
		return delegate.visitOperation(object);
	}

	public @Nullable R visitOperationCallExp(@NonNull org.eclipse.ocl.examples.pivot.OperationCallExp object) {
		return delegate.visitOperationCallExp(object);
	}

	public @Nullable R visitOperationTemplateParameter(@NonNull org.eclipse.ocl.examples.pivot.OperationTemplateParameter object) {
		return delegate.visitOperationTemplateParameter(object);
	}

	public @Nullable R visitOppositePropertyCallExp(@NonNull org.eclipse.ocl.examples.pivot.OppositePropertyCallExp object) {
		return delegate.visitOppositePropertyCallExp(object);
	}

	public @Nullable R visitOrderedSetType(@NonNull org.eclipse.ocl.examples.pivot.OrderedSetType object) {
		return delegate.visitOrderedSetType(object);
	}

	public @Nullable R visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package object) {
		return delegate.visitPackage(object);
	}

	public @Nullable R visitPackageableElement(@NonNull org.eclipse.ocl.examples.pivot.PackageableElement object) {
		return delegate.visitPackageableElement(object);
	}

	public @Nullable R visitParameter(@NonNull org.eclipse.ocl.examples.pivot.Parameter object) {
		return delegate.visitParameter(object);
	}

	public @Nullable R visitParameterableElement(@NonNull org.eclipse.ocl.examples.pivot.ParameterableElement object) {
		return delegate.visitParameterableElement(object);
	}

	public @Nullable R visitPrecedence(@NonNull org.eclipse.ocl.examples.pivot.Precedence object) {
		return delegate.visitPrecedence(object);
	}

	public @Nullable R visitPrimitiveLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp object) {
		return delegate.visitPrimitiveLiteralExp(object);
	}

	public @Nullable R visitPrimitiveType(@NonNull org.eclipse.ocl.examples.pivot.PrimitiveType object) {
		return delegate.visitPrimitiveType(object);
	}

	public @Nullable R visitProfile(@NonNull org.eclipse.ocl.examples.pivot.Profile object) {
		return delegate.visitProfile(object);
	}

	public @Nullable R visitProfileApplication(@NonNull org.eclipse.ocl.examples.pivot.ProfileApplication object) {
		return delegate.visitProfileApplication(object);
	}

	public @Nullable R visitProperty(@NonNull org.eclipse.ocl.examples.pivot.Property object) {
		return delegate.visitProperty(object);
	}

	public @Nullable R visitPropertyCallExp(@NonNull org.eclipse.ocl.examples.pivot.PropertyCallExp object) {
		return delegate.visitPropertyCallExp(object);
	}

	public @Nullable R visitPseudostate(@NonNull org.eclipse.ocl.examples.pivot.Pseudostate object) {
		return delegate.visitPseudostate(object);
	}

	public @Nullable R visitRealLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.RealLiteralExp object) {
		return delegate.visitRealLiteralExp(object);
	}

	public @Nullable R visitRegion(@NonNull org.eclipse.ocl.examples.pivot.Region object) {
		return delegate.visitRegion(object);
	}

	public @Nullable R visitRoot(@NonNull org.eclipse.ocl.examples.pivot.Root object) {
		return delegate.visitRoot(object);
	}

	public @Nullable R visitSelfType(@NonNull org.eclipse.ocl.examples.pivot.SelfType object) {
		return delegate.visitSelfType(object);
	}

	public @Nullable R visitSendSignalAction(@NonNull org.eclipse.ocl.examples.pivot.SendSignalAction object) {
		return delegate.visitSendSignalAction(object);
	}

	public @Nullable R visitSequenceType(@NonNull org.eclipse.ocl.examples.pivot.SequenceType object) {
		return delegate.visitSequenceType(object);
	}

	public @Nullable R visitSetType(@NonNull org.eclipse.ocl.examples.pivot.SetType object) {
		return delegate.visitSetType(object);
	}

	public @Nullable R visitSignal(@NonNull org.eclipse.ocl.examples.pivot.Signal object) {
		return delegate.visitSignal(object);
	}

	public @Nullable R visitState(@NonNull org.eclipse.ocl.examples.pivot.State object) {
		return delegate.visitState(object);
	}

	public @Nullable R visitStateExp(@NonNull org.eclipse.ocl.examples.pivot.StateExp object) {
		return delegate.visitStateExp(object);
	}

	public @Nullable R visitStateMachine(@NonNull org.eclipse.ocl.examples.pivot.StateMachine object) {
		return delegate.visitStateMachine(object);
	}

	public @Nullable R visitStereotype(@NonNull org.eclipse.ocl.examples.pivot.Stereotype object) {
		return delegate.visitStereotype(object);
	}

	public @Nullable R visitStringLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.StringLiteralExp object) {
		return delegate.visitStringLiteralExp(object);
	}

	public @Nullable R visitTemplateBinding(@NonNull org.eclipse.ocl.examples.pivot.TemplateBinding object) {
		return delegate.visitTemplateBinding(object);
	}

	public @Nullable R visitTemplateParameter(@NonNull org.eclipse.ocl.examples.pivot.TemplateParameter object) {
		return delegate.visitTemplateParameter(object);
	}

	public @Nullable R visitTemplateParameterSubstitution(@NonNull org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution object) {
		return delegate.visitTemplateParameterSubstitution(object);
	}

	public @Nullable R visitTemplateParameterType(@NonNull org.eclipse.ocl.examples.pivot.TemplateParameterType object) {
		return delegate.visitTemplateParameterType(object);
	}

	public @Nullable R visitTemplateSignature(@NonNull org.eclipse.ocl.examples.pivot.TemplateSignature object) {
		return delegate.visitTemplateSignature(object);
	}

	public @Nullable R visitTemplateableElement(@NonNull org.eclipse.ocl.examples.pivot.TemplateableElement object) {
		return delegate.visitTemplateableElement(object);
	}

	public @Nullable R visitTransition(@NonNull org.eclipse.ocl.examples.pivot.Transition object) {
		return delegate.visitTransition(object);
	}

	public @Nullable R visitTrigger(@NonNull org.eclipse.ocl.examples.pivot.Trigger object) {
		return delegate.visitTrigger(object);
	}

	public @Nullable R visitTupleLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.TupleLiteralExp object) {
		return delegate.visitTupleLiteralExp(object);
	}

	public @Nullable R visitTupleLiteralPart(@NonNull org.eclipse.ocl.examples.pivot.TupleLiteralPart object) {
		return delegate.visitTupleLiteralPart(object);
	}

	public @Nullable R visitTupleType(@NonNull org.eclipse.ocl.examples.pivot.TupleType object) {
		return delegate.visitTupleType(object);
	}

	public @Nullable R visitType(@NonNull org.eclipse.ocl.examples.pivot.Type object) {
		return delegate.visitType(object);
	}

	public @Nullable R visitTypeExp(@NonNull org.eclipse.ocl.examples.pivot.TypeExp object) {
		return delegate.visitTypeExp(object);
	}

	public @Nullable R visitTypeExtension(@NonNull org.eclipse.ocl.examples.pivot.TypeExtension object) {
		return delegate.visitTypeExtension(object);
	}

	public @Nullable R visitTypeTemplateParameter(@NonNull org.eclipse.ocl.examples.pivot.TypeTemplateParameter object) {
		return delegate.visitTypeTemplateParameter(object);
	}

	public @Nullable R visitTypedElement(@NonNull org.eclipse.ocl.examples.pivot.TypedElement object) {
		return delegate.visitTypedElement(object);
	}

	public @Nullable R visitTypedMultiplicityElement(@NonNull org.eclipse.ocl.examples.pivot.TypedMultiplicityElement object) {
		return delegate.visitTypedMultiplicityElement(object);
	}

	public @Nullable R visitUnlimitedNaturalLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp object) {
		return delegate.visitUnlimitedNaturalLiteralExp(object);
	}

	public @Nullable R visitUnspecifiedType(@NonNull org.eclipse.ocl.examples.pivot.UnspecifiedType object) {
		return delegate.visitUnspecifiedType(object);
	}

	public @Nullable R visitUnspecifiedValueExp(@NonNull org.eclipse.ocl.examples.pivot.UnspecifiedValueExp object) {
		return delegate.visitUnspecifiedValueExp(object);
	}

	public @Nullable R visitValueSpecification(@NonNull org.eclipse.ocl.examples.pivot.ValueSpecification object) {
		return delegate.visitValueSpecification(object);
	}

	public @Nullable R visitVariable(@NonNull org.eclipse.ocl.examples.pivot.Variable object) {
		return delegate.visitVariable(object);
	}

	public @Nullable R visitVariableDeclaration(@NonNull org.eclipse.ocl.examples.pivot.VariableDeclaration object) {
		return delegate.visitVariableDeclaration(object);
	}

	public @Nullable R visitVariableExp(@NonNull org.eclipse.ocl.examples.pivot.VariableExp object) {
		return delegate.visitVariableExp(object);
	}

	public @Nullable R visitVertex(@NonNull org.eclipse.ocl.examples.pivot.Vertex object) {
		return delegate.visitVertex(object);
	}

	public @Nullable R visitVoidType(@NonNull org.eclipse.ocl.examples.pivot.VoidType object) {
		return delegate.visitVoidType(object);
	}
}
