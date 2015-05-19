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

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.pivot.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public @Nullable R visitAnnotation(@NonNull org.eclipse.ocl.pivot.Annotation object) {
		return delegate.visitAnnotation(object);
	}

	@Override
	public @Nullable R visitAnyType(@NonNull org.eclipse.ocl.pivot.AnyType object) {
		return delegate.visitAnyType(object);
	}

	@Override
	public @Nullable R visitAssociationClass(@NonNull org.eclipse.ocl.pivot.AssociationClass object) {
		return delegate.visitAssociationClass(object);
	}

	@Override
	public @Nullable R visitAssociationClassCallExp(@NonNull org.eclipse.ocl.pivot.AssociationClassCallExp object) {
		return delegate.visitAssociationClassCallExp(object);
	}

	@Override
	public @Nullable R visitBagType(@NonNull org.eclipse.ocl.pivot.BagType object) {
		return delegate.visitBagType(object);
	}

	@Override
	public @Nullable R visitBehavior(@NonNull org.eclipse.ocl.pivot.Behavior object) {
		return delegate.visitBehavior(object);
	}

	@Override
	public @Nullable R visitBooleanLiteralExp(@NonNull org.eclipse.ocl.pivot.BooleanLiteralExp object) {
		return delegate.visitBooleanLiteralExp(object);
	}

	@Override
	public @Nullable R visitCallExp(@NonNull org.eclipse.ocl.pivot.CallExp object) {
		return delegate.visitCallExp(object);
	}

	@Override
	public @Nullable R visitCallOperationAction(@NonNull org.eclipse.ocl.pivot.CallOperationAction object) {
		return delegate.visitCallOperationAction(object);
	}

	@Override
	public @Nullable R visitClass(@NonNull org.eclipse.ocl.pivot.Class object) {
		return delegate.visitClass(object);
	}

	@Override
	public @Nullable R visitCollectionItem(@NonNull org.eclipse.ocl.pivot.CollectionItem object) {
		return delegate.visitCollectionItem(object);
	}

	@Override
	public @Nullable R visitCollectionLiteralExp(@NonNull org.eclipse.ocl.pivot.CollectionLiteralExp object) {
		return delegate.visitCollectionLiteralExp(object);
	}

	@Override
	public @Nullable R visitCollectionLiteralPart(@NonNull org.eclipse.ocl.pivot.CollectionLiteralPart object) {
		return delegate.visitCollectionLiteralPart(object);
	}

	@Override
	public @Nullable R visitCollectionRange(@NonNull org.eclipse.ocl.pivot.CollectionRange object) {
		return delegate.visitCollectionRange(object);
	}

	@Override
	public @Nullable R visitCollectionType(@NonNull org.eclipse.ocl.pivot.CollectionType object) {
		return delegate.visitCollectionType(object);
	}

	@Override
	public @Nullable R visitComment(@NonNull org.eclipse.ocl.pivot.Comment object) {
		return delegate.visitComment(object);
	}

	@Override
	public @Nullable R visitCompleteClass(@NonNull org.eclipse.ocl.pivot.CompleteClass object) {
		return delegate.visitCompleteClass(object);
	}

	@Override
	public @Nullable R visitCompleteEnvironment(@NonNull org.eclipse.ocl.pivot.CompleteEnvironment object) {
		return delegate.visitCompleteEnvironment(object);
	}

	@Override
	public @Nullable R visitCompleteModel(@NonNull org.eclipse.ocl.pivot.CompleteModel object) {
		return delegate.visitCompleteModel(object);
	}

	@Override
	public @Nullable R visitCompletePackage(@NonNull org.eclipse.ocl.pivot.CompletePackage object) {
		return delegate.visitCompletePackage(object);
	}

	@Override
	public @Nullable R visitConnectionPointReference(@NonNull org.eclipse.ocl.pivot.ConnectionPointReference object) {
		return delegate.visitConnectionPointReference(object);
	}

	@Override
	public @Nullable R visitConstraint(@NonNull org.eclipse.ocl.pivot.Constraint object) {
		return delegate.visitConstraint(object);
	}

	@Override
	public @Nullable R visitDataType(@NonNull org.eclipse.ocl.pivot.DataType object) {
		return delegate.visitDataType(object);
	}

	@Override
	public @Nullable R visitDetail(@NonNull org.eclipse.ocl.pivot.Detail object) {
		return delegate.visitDetail(object);
	}

	@Override
	public @Nullable R visitDynamicBehavior(@NonNull org.eclipse.ocl.pivot.DynamicBehavior object) {
		return delegate.visitDynamicBehavior(object);
	}

	@Override
	public @Nullable R visitDynamicElement(@NonNull org.eclipse.ocl.pivot.DynamicElement object) {
		return delegate.visitDynamicElement(object);
	}

	@Override
	public @Nullable R visitDynamicProperty(@NonNull org.eclipse.ocl.pivot.DynamicProperty object) {
		return delegate.visitDynamicProperty(object);
	}

	@Override
	public @Nullable R visitDynamicType(@NonNull org.eclipse.ocl.pivot.DynamicType object) {
		return delegate.visitDynamicType(object);
	}

	@Override
	public @Nullable R visitDynamicValueSpecification(@NonNull org.eclipse.ocl.pivot.DynamicValueSpecification object) {
		return delegate.visitDynamicValueSpecification(object);
	}

	@Override
	public @Nullable R visitElement(@NonNull org.eclipse.ocl.pivot.Element object) {
		return delegate.visitElement(object);
	}

	@Override
	public @Nullable R visitElementExtension(@NonNull org.eclipse.ocl.pivot.ElementExtension object) {
		return delegate.visitElementExtension(object);
	}

	@Override
	public @Nullable R visitEnumLiteralExp(@NonNull org.eclipse.ocl.pivot.EnumLiteralExp object) {
		return delegate.visitEnumLiteralExp(object);
	}

	@Override
	public @Nullable R visitEnumeration(@NonNull org.eclipse.ocl.pivot.Enumeration object) {
		return delegate.visitEnumeration(object);
	}

	@Override
	public @Nullable R visitEnumerationLiteral(@NonNull org.eclipse.ocl.pivot.EnumerationLiteral object) {
		return delegate.visitEnumerationLiteral(object);
	}

	@Override
	public @Nullable R visitExpressionInOCL(@NonNull org.eclipse.ocl.pivot.ExpressionInOCL object) {
		return delegate.visitExpressionInOCL(object);
	}

	@Override
	public @Nullable R visitFeature(@NonNull org.eclipse.ocl.pivot.Feature object) {
		return delegate.visitFeature(object);
	}

	@Override
	public @Nullable R visitFeatureCallExp(@NonNull org.eclipse.ocl.pivot.FeatureCallExp object) {
		return delegate.visitFeatureCallExp(object);
	}

	@Override
	public @Nullable R visitFinalState(@NonNull org.eclipse.ocl.pivot.FinalState object) {
		return delegate.visitFinalState(object);
	}

	@Override
	public @Nullable R visitIfExp(@NonNull org.eclipse.ocl.pivot.IfExp object) {
		return delegate.visitIfExp(object);
	}

	@Override
	public @Nullable R visitImport(@NonNull org.eclipse.ocl.pivot.Import object) {
		return delegate.visitImport(object);
	}

	@Override
	public @Nullable R visitInstanceSpecification(@NonNull org.eclipse.ocl.pivot.InstanceSpecification object) {
		return delegate.visitInstanceSpecification(object);
	}

	@Override
	public @Nullable R visitIntegerLiteralExp(@NonNull org.eclipse.ocl.pivot.IntegerLiteralExp object) {
		return delegate.visitIntegerLiteralExp(object);
	}

	@Override
	public @Nullable R visitInvalidLiteralExp(@NonNull org.eclipse.ocl.pivot.InvalidLiteralExp object) {
		return delegate.visitInvalidLiteralExp(object);
	}

	@Override
	public @Nullable R visitInvalidType(@NonNull org.eclipse.ocl.pivot.InvalidType object) {
		return delegate.visitInvalidType(object);
	}

	@Override
	public @Nullable R visitIterateExp(@NonNull org.eclipse.ocl.pivot.IterateExp object) {
		return delegate.visitIterateExp(object);
	}

	@Override
	public @Nullable R visitIteration(@NonNull org.eclipse.ocl.pivot.Iteration object) {
		return delegate.visitIteration(object);
	}

	@Override
	public @Nullable R visitIteratorExp(@NonNull org.eclipse.ocl.pivot.IteratorExp object) {
		return delegate.visitIteratorExp(object);
	}

	@Override
	public @Nullable R visitLambdaType(@NonNull org.eclipse.ocl.pivot.LambdaType object) {
		return delegate.visitLambdaType(object);
	}

	@Override
	public @Nullable R visitLanguageExpression(@NonNull org.eclipse.ocl.pivot.LanguageExpression object) {
		return delegate.visitLanguageExpression(object);
	}

	@Override
	public @Nullable R visitLetExp(@NonNull org.eclipse.ocl.pivot.LetExp object) {
		return delegate.visitLetExp(object);
	}

	@Override
	public @Nullable R visitLibrary(@NonNull org.eclipse.ocl.pivot.Library object) {
		return delegate.visitLibrary(object);
	}

	@Override
	public @Nullable R visitLiteralExp(@NonNull org.eclipse.ocl.pivot.LiteralExp object) {
		return delegate.visitLiteralExp(object);
	}

	@Override
	public @Nullable R visitLoopExp(@NonNull org.eclipse.ocl.pivot.LoopExp object) {
		return delegate.visitLoopExp(object);
	}

	@Override
	public @Nullable R visitMapLiteralExp(@NonNull org.eclipse.ocl.pivot.MapLiteralExp object) {
		return delegate.visitMapLiteralExp(object);
	}

	@Override
	public @Nullable R visitMapLiteralPart(@NonNull org.eclipse.ocl.pivot.MapLiteralPart object) {
		return delegate.visitMapLiteralPart(object);
	}

	@Override
	public @Nullable R visitMapType(@NonNull org.eclipse.ocl.pivot.MapType object) {
		return delegate.visitMapType(object);
	}

	@Override
	public @Nullable R visitMessageExp(@NonNull org.eclipse.ocl.pivot.MessageExp object) {
		return delegate.visitMessageExp(object);
	}

	@Override
	public @Nullable R visitMessageType(@NonNull org.eclipse.ocl.pivot.MessageType object) {
		return delegate.visitMessageType(object);
	}

	@Override
	public @Nullable R visitModel(@NonNull org.eclipse.ocl.pivot.Model object) {
		return delegate.visitModel(object);
	}

	@Override
	public @Nullable R visitNamedElement(@NonNull org.eclipse.ocl.pivot.NamedElement object) {
		return delegate.visitNamedElement(object);
	}

	@Override
	public @Nullable R visitNamespace(@NonNull org.eclipse.ocl.pivot.Namespace object) {
		return delegate.visitNamespace(object);
	}

	@Override
	public @Nullable R visitNavigationCallExp(@NonNull org.eclipse.ocl.pivot.NavigationCallExp object) {
		return delegate.visitNavigationCallExp(object);
	}

	@Override
	public @Nullable R visitNullLiteralExp(@NonNull org.eclipse.ocl.pivot.NullLiteralExp object) {
		return delegate.visitNullLiteralExp(object);
	}

	@Override
	public @Nullable R visitNumericLiteralExp(@NonNull org.eclipse.ocl.pivot.NumericLiteralExp object) {
		return delegate.visitNumericLiteralExp(object);
	}

	@Override
	public @Nullable R visitOCLExpression(@NonNull org.eclipse.ocl.pivot.OCLExpression object) {
		return delegate.visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitOperation(@NonNull org.eclipse.ocl.pivot.Operation object) {
		return delegate.visitOperation(object);
	}

	@Override
	public @Nullable R visitOperationCallExp(@NonNull org.eclipse.ocl.pivot.OperationCallExp object) {
		return delegate.visitOperationCallExp(object);
	}

	@Override
	public @Nullable R visitOppositePropertyCallExp(@NonNull org.eclipse.ocl.pivot.OppositePropertyCallExp object) {
		return delegate.visitOppositePropertyCallExp(object);
	}

	@Override
	public @Nullable R visitOrderedSetType(@NonNull org.eclipse.ocl.pivot.OrderedSetType object) {
		return delegate.visitOrderedSetType(object);
	}

	@Override
	public @Nullable R visitOrphanCompletePackage(@NonNull org.eclipse.ocl.pivot.OrphanCompletePackage object) {
		return delegate.visitOrphanCompletePackage(object);
	}

	@Override
	public @Nullable R visitPackage(@NonNull org.eclipse.ocl.pivot.Package object) {
		return delegate.visitPackage(object);
	}

	@Override
	public @Nullable R visitParameter(@NonNull org.eclipse.ocl.pivot.Parameter object) {
		return delegate.visitParameter(object);
	}

	@Override
	public @Nullable R visitPrecedence(@NonNull org.eclipse.ocl.pivot.Precedence object) {
		return delegate.visitPrecedence(object);
	}

	@Override
	public @Nullable R visitPrimitiveCompletePackage(@NonNull org.eclipse.ocl.pivot.PrimitiveCompletePackage object) {
		return delegate.visitPrimitiveCompletePackage(object);
	}

	@Override
	public @Nullable R visitPrimitiveLiteralExp(@NonNull org.eclipse.ocl.pivot.PrimitiveLiteralExp object) {
		return delegate.visitPrimitiveLiteralExp(object);
	}

	@Override
	public @Nullable R visitPrimitiveType(@NonNull org.eclipse.ocl.pivot.PrimitiveType object) {
		return delegate.visitPrimitiveType(object);
	}

	@Override
	public @Nullable R visitProfile(@NonNull org.eclipse.ocl.pivot.Profile object) {
		return delegate.visitProfile(object);
	}

	@Override
	public @Nullable R visitProfileApplication(@NonNull org.eclipse.ocl.pivot.ProfileApplication object) {
		return delegate.visitProfileApplication(object);
	}

	@Override
	public @Nullable R visitProperty(@NonNull org.eclipse.ocl.pivot.Property object) {
		return delegate.visitProperty(object);
	}

	@Override
	public @Nullable R visitPropertyCallExp(@NonNull org.eclipse.ocl.pivot.PropertyCallExp object) {
		return delegate.visitPropertyCallExp(object);
	}

	@Override
	public @Nullable R visitPseudostate(@NonNull org.eclipse.ocl.pivot.Pseudostate object) {
		return delegate.visitPseudostate(object);
	}

	@Override
	public @Nullable R visitRealLiteralExp(@NonNull org.eclipse.ocl.pivot.RealLiteralExp object) {
		return delegate.visitRealLiteralExp(object);
	}

	@Override
	public @Nullable R visitRegion(@NonNull org.eclipse.ocl.pivot.Region object) {
		return delegate.visitRegion(object);
	}

	@Override
	public @Nullable R visitSelfType(@NonNull org.eclipse.ocl.pivot.SelfType object) {
		return delegate.visitSelfType(object);
	}

	@Override
	public @Nullable R visitSendSignalAction(@NonNull org.eclipse.ocl.pivot.SendSignalAction object) {
		return delegate.visitSendSignalAction(object);
	}

	@Override
	public @Nullable R visitSequenceType(@NonNull org.eclipse.ocl.pivot.SequenceType object) {
		return delegate.visitSequenceType(object);
	}

	@Override
	public @Nullable R visitSetType(@NonNull org.eclipse.ocl.pivot.SetType object) {
		return delegate.visitSetType(object);
	}

	@Override
	public @Nullable R visitShadowExp(@NonNull org.eclipse.ocl.pivot.ShadowExp object) {
		return delegate.visitShadowExp(object);
	}

	@Override
	public @Nullable R visitShadowPart(@NonNull org.eclipse.ocl.pivot.ShadowPart object) {
		return delegate.visitShadowPart(object);
	}

	@Override
	public @Nullable R visitSignal(@NonNull org.eclipse.ocl.pivot.Signal object) {
		return delegate.visitSignal(object);
	}

	@Override
	public @Nullable R visitSlot(@NonNull org.eclipse.ocl.pivot.Slot object) {
		return delegate.visitSlot(object);
	}

	@Override
	public @Nullable R visitStandardLibrary(@NonNull org.eclipse.ocl.pivot.StandardLibrary object) {
		return delegate.visitStandardLibrary(object);
	}

	@Override
	public @Nullable R visitState(@NonNull org.eclipse.ocl.pivot.State object) {
		return delegate.visitState(object);
	}

	@Override
	public @Nullable R visitStateExp(@NonNull org.eclipse.ocl.pivot.StateExp object) {
		return delegate.visitStateExp(object);
	}

	@Override
	public @Nullable R visitStateMachine(@NonNull org.eclipse.ocl.pivot.StateMachine object) {
		return delegate.visitStateMachine(object);
	}

	@Override
	public @Nullable R visitStereotype(@NonNull org.eclipse.ocl.pivot.Stereotype object) {
		return delegate.visitStereotype(object);
	}

	@Override
	public @Nullable R visitStereotypeExtender(@NonNull org.eclipse.ocl.pivot.StereotypeExtender object) {
		return delegate.visitStereotypeExtender(object);
	}

	@Override
	public @Nullable R visitStringLiteralExp(@NonNull org.eclipse.ocl.pivot.StringLiteralExp object) {
		return delegate.visitStringLiteralExp(object);
	}

	@Override
	public @Nullable R visitTemplateBinding(@NonNull org.eclipse.ocl.pivot.TemplateBinding object) {
		return delegate.visitTemplateBinding(object);
	}

	@Override
	public @Nullable R visitTemplateParameter(@NonNull org.eclipse.ocl.pivot.TemplateParameter object) {
		return delegate.visitTemplateParameter(object);
	}

	@Override
	public @Nullable R visitTemplateParameterSubstitution(@NonNull org.eclipse.ocl.pivot.TemplateParameterSubstitution object) {
		return delegate.visitTemplateParameterSubstitution(object);
	}

	@Override
	public @Nullable R visitTemplateSignature(@NonNull org.eclipse.ocl.pivot.TemplateSignature object) {
		return delegate.visitTemplateSignature(object);
	}

	@Override
	public @Nullable R visitTemplateableElement(@NonNull org.eclipse.ocl.pivot.TemplateableElement object) {
		return delegate.visitTemplateableElement(object);
	}

	@Override
	public @Nullable R visitTransition(@NonNull org.eclipse.ocl.pivot.Transition object) {
		return delegate.visitTransition(object);
	}

	@Override
	public @Nullable R visitTrigger(@NonNull org.eclipse.ocl.pivot.Trigger object) {
		return delegate.visitTrigger(object);
	}

	@Override
	public @Nullable R visitTupleLiteralExp(@NonNull org.eclipse.ocl.pivot.TupleLiteralExp object) {
		return delegate.visitTupleLiteralExp(object);
	}

	@Override
	public @Nullable R visitTupleLiteralPart(@NonNull org.eclipse.ocl.pivot.TupleLiteralPart object) {
		return delegate.visitTupleLiteralPart(object);
	}

	@Override
	public @Nullable R visitTupleType(@NonNull org.eclipse.ocl.pivot.TupleType object) {
		return delegate.visitTupleType(object);
	}

	@Override
	public @Nullable R visitType(@NonNull org.eclipse.ocl.pivot.Type object) {
		return delegate.visitType(object);
	}

	@Override
	public @Nullable R visitTypeExp(@NonNull org.eclipse.ocl.pivot.TypeExp object) {
		return delegate.visitTypeExp(object);
	}

	@Override
	public @Nullable R visitTypedElement(@NonNull org.eclipse.ocl.pivot.TypedElement object) {
		return delegate.visitTypedElement(object);
	}

	@Override
	public @Nullable R visitUnlimitedNaturalLiteralExp(@NonNull org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp object) {
		return delegate.visitUnlimitedNaturalLiteralExp(object);
	}

	@Override
	public @Nullable R visitUnspecifiedValueExp(@NonNull org.eclipse.ocl.pivot.UnspecifiedValueExp object) {
		return delegate.visitUnspecifiedValueExp(object);
	}

	@Override
	public @Nullable R visitValueSpecification(@NonNull org.eclipse.ocl.pivot.ValueSpecification object) {
		return delegate.visitValueSpecification(object);
	}

	@Override
	public @Nullable R visitVariable(@NonNull org.eclipse.ocl.pivot.Variable object) {
		return delegate.visitVariable(object);
	}

	@Override
	public @Nullable R visitVariableDeclaration(@NonNull org.eclipse.ocl.pivot.VariableDeclaration object) {
		return delegate.visitVariableDeclaration(object);
	}

	@Override
	public @Nullable R visitVariableExp(@NonNull org.eclipse.ocl.pivot.VariableExp object) {
		return delegate.visitVariableExp(object);
	}

	@Override
	public @Nullable R visitVertex(@NonNull org.eclipse.ocl.pivot.Vertex object) {
		return delegate.visitVertex(object);
	}

	@Override
	public @Nullable R visitVoidType(@NonNull org.eclipse.ocl.pivot.VoidType object) {
		return delegate.visitVoidType(object);
	}

	@Override
	public @Nullable R visitWildcardType(@NonNull org.eclipse.ocl.pivot.WildcardType object) {
		return delegate.visitWildcardType(object);
	}
}
