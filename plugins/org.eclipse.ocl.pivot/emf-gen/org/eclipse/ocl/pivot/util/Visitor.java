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
 */
public interface Visitor<R>
{
	/**
	 * Returns an object which is an instance of the given class
	 * associated with this object. Returns <code>null</code> if
	 * no such object can be found.
	 *
	 * @param adapter the adapter class to look up
	 * @return an object of the given class, 
	 *    or <code>null</code> if this object does not
	 *    have an adapter for the given class
	 */
	@Nullable <A> A getAdapter(@NonNull Class<A> adapter);

	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	@Nullable R visiting(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable);

	@Nullable R visitAnnotation(org.eclipse.ocl.pivot.@NonNull Annotation object);
	@Nullable R visitAnyType(org.eclipse.ocl.pivot.@NonNull AnyType object);
	@Nullable R visitAssociationClass(org.eclipse.ocl.pivot.@NonNull AssociationClass object);
	@Nullable R visitAssociationClassCallExp(org.eclipse.ocl.pivot.@NonNull AssociationClassCallExp object);
	@Nullable R visitBagType(org.eclipse.ocl.pivot.@NonNull BagType object);
	@Nullable R visitBehavior(org.eclipse.ocl.pivot.@NonNull Behavior object);
	@Nullable R visitBooleanLiteralExp(org.eclipse.ocl.pivot.@NonNull BooleanLiteralExp object);
	@Nullable R visitCallExp(org.eclipse.ocl.pivot.@NonNull CallExp object);
	@Nullable R visitCallOperationAction(org.eclipse.ocl.pivot.@NonNull CallOperationAction object);
	@Nullable R visitClass(org.eclipse.ocl.pivot.@NonNull Class object);
	@Nullable R visitCollectionItem(org.eclipse.ocl.pivot.@NonNull CollectionItem object);
	@Nullable R visitCollectionLiteralExp(org.eclipse.ocl.pivot.@NonNull CollectionLiteralExp object);
	@Nullable R visitCollectionLiteralPart(org.eclipse.ocl.pivot.@NonNull CollectionLiteralPart object);
	@Nullable R visitCollectionRange(org.eclipse.ocl.pivot.@NonNull CollectionRange object);
	@Nullable R visitCollectionType(org.eclipse.ocl.pivot.@NonNull CollectionType object);
	@Nullable R visitComment(org.eclipse.ocl.pivot.@NonNull Comment object);
	@Nullable R visitCompleteClass(org.eclipse.ocl.pivot.@NonNull CompleteClass object);
	@Nullable R visitCompleteEnvironment(org.eclipse.ocl.pivot.@NonNull CompleteEnvironment object);
	@Nullable R visitCompleteModel(org.eclipse.ocl.pivot.@NonNull CompleteModel object);
	@Nullable R visitCompletePackage(org.eclipse.ocl.pivot.@NonNull CompletePackage object);
	@Nullable R visitConnectionPointReference(org.eclipse.ocl.pivot.@NonNull ConnectionPointReference object);
	@Nullable R visitConstraint(org.eclipse.ocl.pivot.@NonNull Constraint object);
	@Nullable R visitDataType(org.eclipse.ocl.pivot.@NonNull DataType object);
	@Nullable R visitDetail(org.eclipse.ocl.pivot.@NonNull Detail object);
	@Nullable R visitDynamicBehavior(org.eclipse.ocl.pivot.@NonNull DynamicBehavior object);
	@Nullable R visitDynamicElement(org.eclipse.ocl.pivot.@NonNull DynamicElement object);
	@Nullable R visitDynamicProperty(org.eclipse.ocl.pivot.@NonNull DynamicProperty object);
	@Nullable R visitDynamicType(org.eclipse.ocl.pivot.@NonNull DynamicType object);
	@Nullable R visitDynamicValueSpecification(org.eclipse.ocl.pivot.@NonNull DynamicValueSpecification object);
	@Nullable R visitElement(org.eclipse.ocl.pivot.@NonNull Element object);
	@Nullable R visitElementExtension(org.eclipse.ocl.pivot.@NonNull ElementExtension object);
	@Nullable R visitEnumLiteralExp(org.eclipse.ocl.pivot.@NonNull EnumLiteralExp object);
	@Nullable R visitEnumeration(org.eclipse.ocl.pivot.@NonNull Enumeration object);
	@Nullable R visitEnumerationLiteral(org.eclipse.ocl.pivot.@NonNull EnumerationLiteral object);
	@Nullable R visitExpressionInOCL(org.eclipse.ocl.pivot.@NonNull ExpressionInOCL object);
	@Nullable R visitFeature(org.eclipse.ocl.pivot.@NonNull Feature object);
	@Nullable R visitFeatureCallExp(org.eclipse.ocl.pivot.@NonNull FeatureCallExp object);
	@Nullable R visitFinalState(org.eclipse.ocl.pivot.@NonNull FinalState object);
	@Nullable R visitIfExp(org.eclipse.ocl.pivot.@NonNull IfExp object);
	@Nullable R visitImport(org.eclipse.ocl.pivot.@NonNull Import object);
	@Nullable R visitInstanceSpecification(org.eclipse.ocl.pivot.@NonNull InstanceSpecification object);
	@Nullable R visitIntegerLiteralExp(org.eclipse.ocl.pivot.@NonNull IntegerLiteralExp object);
	@Nullable R visitInvalidLiteralExp(org.eclipse.ocl.pivot.@NonNull InvalidLiteralExp object);
	@Nullable R visitInvalidType(org.eclipse.ocl.pivot.@NonNull InvalidType object);
	@Nullable R visitIterateExp(org.eclipse.ocl.pivot.@NonNull IterateExp object);
	@Nullable R visitIteration(org.eclipse.ocl.pivot.@NonNull Iteration object);
	@Nullable R visitIteratorExp(org.eclipse.ocl.pivot.@NonNull IteratorExp object);
	@Nullable R visitLambdaType(org.eclipse.ocl.pivot.@NonNull LambdaType object);
	@Nullable R visitLanguageExpression(org.eclipse.ocl.pivot.@NonNull LanguageExpression object);
	@Nullable R visitLetExp(org.eclipse.ocl.pivot.@NonNull LetExp object);
	@Nullable R visitLibrary(org.eclipse.ocl.pivot.@NonNull Library object);
	@Nullable R visitLiteralExp(org.eclipse.ocl.pivot.@NonNull LiteralExp object);
	@Nullable R visitLoopExp(org.eclipse.ocl.pivot.@NonNull LoopExp object);
	@Nullable R visitMapLiteralExp(org.eclipse.ocl.pivot.@NonNull MapLiteralExp object);
	@Nullable R visitMapLiteralPart(org.eclipse.ocl.pivot.@NonNull MapLiteralPart object);
	@Nullable R visitMapType(org.eclipse.ocl.pivot.@NonNull MapType object);
	@Nullable R visitMessageExp(org.eclipse.ocl.pivot.@NonNull MessageExp object);
	@Nullable R visitMessageType(org.eclipse.ocl.pivot.@NonNull MessageType object);
	@Nullable R visitModel(org.eclipse.ocl.pivot.@NonNull Model object);
	@Nullable R visitNamedElement(org.eclipse.ocl.pivot.@NonNull NamedElement object);
	@Nullable R visitNamespace(org.eclipse.ocl.pivot.@NonNull Namespace object);
	@Nullable R visitNavigationCallExp(org.eclipse.ocl.pivot.@NonNull NavigationCallExp object);
	@Nullable R visitNullLiteralExp(org.eclipse.ocl.pivot.@NonNull NullLiteralExp object);
	@Nullable R visitNumericLiteralExp(org.eclipse.ocl.pivot.@NonNull NumericLiteralExp object);
	@Nullable R visitOCLExpression(org.eclipse.ocl.pivot.@NonNull OCLExpression object);
	@Nullable R visitOperation(org.eclipse.ocl.pivot.@NonNull Operation object);
	@Nullable R visitOperationCallExp(org.eclipse.ocl.pivot.@NonNull OperationCallExp object);
	@Nullable R visitOppositePropertyCallExp(org.eclipse.ocl.pivot.@NonNull OppositePropertyCallExp object);
	@Nullable R visitOrderedSetType(org.eclipse.ocl.pivot.@NonNull OrderedSetType object);
	@Nullable R visitOrphanCompletePackage(org.eclipse.ocl.pivot.@NonNull OrphanCompletePackage object);
	@Nullable R visitPackage(org.eclipse.ocl.pivot.@NonNull Package object);
	@Nullable R visitParameter(org.eclipse.ocl.pivot.@NonNull Parameter object);
	@Nullable R visitPrecedence(org.eclipse.ocl.pivot.@NonNull Precedence object);
	@Nullable R visitPrimitiveCompletePackage(org.eclipse.ocl.pivot.@NonNull PrimitiveCompletePackage object);
	@Nullable R visitPrimitiveLiteralExp(org.eclipse.ocl.pivot.@NonNull PrimitiveLiteralExp object);
	@Nullable R visitPrimitiveType(org.eclipse.ocl.pivot.@NonNull PrimitiveType object);
	@Nullable R visitProfile(org.eclipse.ocl.pivot.@NonNull Profile object);
	@Nullable R visitProfileApplication(org.eclipse.ocl.pivot.@NonNull ProfileApplication object);
	@Nullable R visitProperty(org.eclipse.ocl.pivot.@NonNull Property object);
	@Nullable R visitPropertyCallExp(org.eclipse.ocl.pivot.@NonNull PropertyCallExp object);
	@Nullable R visitPseudostate(org.eclipse.ocl.pivot.@NonNull Pseudostate object);
	@Nullable R visitRealLiteralExp(org.eclipse.ocl.pivot.@NonNull RealLiteralExp object);
	@Nullable R visitRegion(org.eclipse.ocl.pivot.@NonNull Region object);
	@Nullable R visitSelfType(org.eclipse.ocl.pivot.@NonNull SelfType object);
	@Nullable R visitSendSignalAction(org.eclipse.ocl.pivot.@NonNull SendSignalAction object);
	@Nullable R visitSequenceType(org.eclipse.ocl.pivot.@NonNull SequenceType object);
	@Nullable R visitSetType(org.eclipse.ocl.pivot.@NonNull SetType object);
	@Nullable R visitShadowExp(org.eclipse.ocl.pivot.@NonNull ShadowExp object);
	@Nullable R visitShadowPart(org.eclipse.ocl.pivot.@NonNull ShadowPart object);
	@Nullable R visitSignal(org.eclipse.ocl.pivot.@NonNull Signal object);
	@Nullable R visitSlot(org.eclipse.ocl.pivot.@NonNull Slot object);
	@Nullable R visitStandardLibrary(org.eclipse.ocl.pivot.@NonNull StandardLibrary object);
	@Nullable R visitState(org.eclipse.ocl.pivot.@NonNull State object);
	@Nullable R visitStateExp(org.eclipse.ocl.pivot.@NonNull StateExp object);
	@Nullable R visitStateMachine(org.eclipse.ocl.pivot.@NonNull StateMachine object);
	@Nullable R visitStereotype(org.eclipse.ocl.pivot.@NonNull Stereotype object);
	@Nullable R visitStereotypeExtender(org.eclipse.ocl.pivot.@NonNull StereotypeExtender object);
	@Nullable R visitStringLiteralExp(org.eclipse.ocl.pivot.@NonNull StringLiteralExp object);
	@Nullable R visitTemplateBinding(org.eclipse.ocl.pivot.@NonNull TemplateBinding object);
	@Nullable R visitTemplateParameter(org.eclipse.ocl.pivot.@NonNull TemplateParameter object);
	@Nullable R visitTemplateParameterSubstitution(org.eclipse.ocl.pivot.@NonNull TemplateParameterSubstitution object);
	@Nullable R visitTemplateSignature(org.eclipse.ocl.pivot.@NonNull TemplateSignature object);
	@Nullable R visitTemplateableElement(org.eclipse.ocl.pivot.@NonNull TemplateableElement object);
	@Nullable R visitTransition(org.eclipse.ocl.pivot.@NonNull Transition object);
	@Nullable R visitTrigger(org.eclipse.ocl.pivot.@NonNull Trigger object);
	@Nullable R visitTupleLiteralExp(org.eclipse.ocl.pivot.@NonNull TupleLiteralExp object);
	@Nullable R visitTupleLiteralPart(org.eclipse.ocl.pivot.@NonNull TupleLiteralPart object);
	@Nullable R visitTupleType(org.eclipse.ocl.pivot.@NonNull TupleType object);
	@Nullable R visitType(org.eclipse.ocl.pivot.@NonNull Type object);
	@Nullable R visitTypeExp(org.eclipse.ocl.pivot.@NonNull TypeExp object);
	@Nullable R visitTypedElement(org.eclipse.ocl.pivot.@NonNull TypedElement object);
	@Nullable R visitUnlimitedNaturalLiteralExp(org.eclipse.ocl.pivot.@NonNull UnlimitedNaturalLiteralExp object);
	@Nullable R visitUnspecifiedValueExp(org.eclipse.ocl.pivot.@NonNull UnspecifiedValueExp object);
	@Nullable R visitValueSpecification(org.eclipse.ocl.pivot.@NonNull ValueSpecification object);
	@Nullable R visitVariable(org.eclipse.ocl.pivot.@NonNull Variable object);
	@Nullable R visitVariableDeclaration(org.eclipse.ocl.pivot.@NonNull VariableDeclaration object);
	@Nullable R visitVariableExp(org.eclipse.ocl.pivot.@NonNull VariableExp object);
	@Nullable R visitVertex(org.eclipse.ocl.pivot.@NonNull Vertex object);
	@Nullable R visitVoidType(org.eclipse.ocl.pivot.@NonNull VoidType object);
	@Nullable R visitWildcardType(org.eclipse.ocl.pivot.@NonNull WildcardType object);
}
