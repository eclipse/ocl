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
 * An AbstractExtendingVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingVisitor<R, C>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitAnnotation(org.eclipse.ocl.pivot.@NonNull Annotation object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitAnyType(org.eclipse.ocl.pivot.@NonNull AnyType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitAssociationClass(org.eclipse.ocl.pivot.@NonNull AssociationClass object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitAssociationClassCallExp(org.eclipse.ocl.pivot.@NonNull AssociationClassCallExp object) {
		return visitNavigationCallExp(object);
	}

	@Override
	public @Nullable R visitBagType(org.eclipse.ocl.pivot.@NonNull BagType object) {
		return visitCollectionType(object);
	}

	@Override
	public @Nullable R visitBehavior(org.eclipse.ocl.pivot.@NonNull Behavior object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitBooleanLiteralExp(org.eclipse.ocl.pivot.@NonNull BooleanLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	@Override
	public @Nullable R visitCallExp(org.eclipse.ocl.pivot.@NonNull CallExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitCallOperationAction(org.eclipse.ocl.pivot.@NonNull CallOperationAction object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		return visitType(object);
	}

	@Override
	public @Nullable R visitCollectionItem(org.eclipse.ocl.pivot.@NonNull CollectionItem object) {
		return visitCollectionLiteralPart(object);
	}

	@Override
	public @Nullable R visitCollectionLiteralExp(org.eclipse.ocl.pivot.@NonNull CollectionLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public @Nullable R visitCollectionLiteralPart(org.eclipse.ocl.pivot.@NonNull CollectionLiteralPart object) {
		return visitTypedElement(object);
	}

	@Override
	public @Nullable R visitCollectionRange(org.eclipse.ocl.pivot.@NonNull CollectionRange object) {
		return visitCollectionLiteralPart(object);
	}

	@Override
	public @Nullable R visitCollectionType(org.eclipse.ocl.pivot.@NonNull CollectionType object) {
		return visitDataType(object);
	}

	@Override
	public @Nullable R visitComment(org.eclipse.ocl.pivot.@NonNull Comment object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitCompleteClass(org.eclipse.ocl.pivot.@NonNull CompleteClass object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitCompleteEnvironment(org.eclipse.ocl.pivot.@NonNull CompleteEnvironment object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitCompleteModel(org.eclipse.ocl.pivot.@NonNull CompleteModel object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitCompletePackage(org.eclipse.ocl.pivot.@NonNull CompletePackage object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitConnectionPointReference(org.eclipse.ocl.pivot.@NonNull ConnectionPointReference object) {
		return visitVertex(object);
	}

	@Override
	public @Nullable R visitConstraint(org.eclipse.ocl.pivot.@NonNull Constraint object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitDataType(org.eclipse.ocl.pivot.@NonNull DataType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitDetail(org.eclipse.ocl.pivot.@NonNull Detail object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitDynamicBehavior(org.eclipse.ocl.pivot.@NonNull DynamicBehavior object) {
		return visitBehavior(object);
	}

	@Override
	public @Nullable R visitDynamicElement(org.eclipse.ocl.pivot.@NonNull DynamicElement object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitDynamicProperty(org.eclipse.ocl.pivot.@NonNull DynamicProperty object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitDynamicType(org.eclipse.ocl.pivot.@NonNull DynamicType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitDynamicValueSpecification(org.eclipse.ocl.pivot.@NonNull DynamicValueSpecification object) {
		return visitValueSpecification(object);
	}

	@Override
	public @Nullable R visitElement(org.eclipse.ocl.pivot.@NonNull Element object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitElementExtension(org.eclipse.ocl.pivot.@NonNull ElementExtension object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitEnumLiteralExp(org.eclipse.ocl.pivot.@NonNull EnumLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public @Nullable R visitEnumeration(org.eclipse.ocl.pivot.@NonNull Enumeration object) {
		return visitDataType(object);
	}

	@Override
	public @Nullable R visitEnumerationLiteral(org.eclipse.ocl.pivot.@NonNull EnumerationLiteral object) {
		return visitInstanceSpecification(object);
	}

	@Override
	public @Nullable R visitExpressionInOCL(org.eclipse.ocl.pivot.@NonNull ExpressionInOCL object) {
		return visitLanguageExpression(object);
	}

	@Override
	public @Nullable R visitFeature(org.eclipse.ocl.pivot.@NonNull Feature object) {
		return visitTypedElement(object);
	}

	@Override
	public @Nullable R visitFeatureCallExp(org.eclipse.ocl.pivot.@NonNull FeatureCallExp object) {
		return visitCallExp(object);
	}

	@Override
	public @Nullable R visitFinalState(org.eclipse.ocl.pivot.@NonNull FinalState object) {
		return visitState(object);
	}

	@Override
	public @Nullable R visitIfExp(org.eclipse.ocl.pivot.@NonNull IfExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitImport(org.eclipse.ocl.pivot.@NonNull Import object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitInstanceSpecification(org.eclipse.ocl.pivot.@NonNull InstanceSpecification object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitIntegerLiteralExp(org.eclipse.ocl.pivot.@NonNull IntegerLiteralExp object) {
		return visitNumericLiteralExp(object);
	}

	@Override
	public @Nullable R visitInvalidLiteralExp(org.eclipse.ocl.pivot.@NonNull InvalidLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public @Nullable R visitInvalidType(org.eclipse.ocl.pivot.@NonNull InvalidType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitIterateExp(org.eclipse.ocl.pivot.@NonNull IterateExp object) {
		return visitLoopExp(object);
	}

	@Override
	public @Nullable R visitIteration(org.eclipse.ocl.pivot.@NonNull Iteration object) {
		return visitOperation(object);
	}

	@Override
	public @Nullable R visitIteratorExp(org.eclipse.ocl.pivot.@NonNull IteratorExp object) {
		return visitLoopExp(object);
	}

	@Override
	public @Nullable R visitLambdaType(org.eclipse.ocl.pivot.@NonNull LambdaType object) {
		return visitDataType(object);
	}

	@Override
	public @Nullable R visitLanguageExpression(org.eclipse.ocl.pivot.@NonNull LanguageExpression object) {
		return visitValueSpecification(object);
	}

	@Override
	public @Nullable R visitLetExp(org.eclipse.ocl.pivot.@NonNull LetExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitLibrary(org.eclipse.ocl.pivot.@NonNull Library object) {
		return visitPackage(object);
	}

	@Override
	public @Nullable R visitLiteralExp(org.eclipse.ocl.pivot.@NonNull LiteralExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitLoopExp(org.eclipse.ocl.pivot.@NonNull LoopExp object) {
		return visitCallExp(object);
	}

	@Override
	public @Nullable R visitMapLiteralExp(org.eclipse.ocl.pivot.@NonNull MapLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public @Nullable R visitMapLiteralPart(org.eclipse.ocl.pivot.@NonNull MapLiteralPart object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitMapType(org.eclipse.ocl.pivot.@NonNull MapType object) {
		return visitDataType(object);
	}

	@Override
	public @Nullable R visitMessageExp(org.eclipse.ocl.pivot.@NonNull MessageExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitMessageType(org.eclipse.ocl.pivot.@NonNull MessageType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitModel(org.eclipse.ocl.pivot.@NonNull Model object) {
		return visitNamespace(object);
	}

	@Override
	public @Nullable R visitNamedElement(org.eclipse.ocl.pivot.@NonNull NamedElement object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitNamespace(org.eclipse.ocl.pivot.@NonNull Namespace object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitNavigationCallExp(org.eclipse.ocl.pivot.@NonNull NavigationCallExp object) {
		return visitFeatureCallExp(object);
	}

	@Override
	public @Nullable R visitNullLiteralExp(org.eclipse.ocl.pivot.@NonNull NullLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	@Override
	public @Nullable R visitNumericLiteralExp(org.eclipse.ocl.pivot.@NonNull NumericLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	@Override
	public @Nullable R visitOCLExpression(org.eclipse.ocl.pivot.@NonNull OCLExpression object) {
		return visitTypedElement(object);
	}

	@Override
	public @Nullable R visitOperation(org.eclipse.ocl.pivot.@NonNull Operation object) {
		return visitFeature(object);
	}

	@Override
	public @Nullable R visitOperationCallExp(org.eclipse.ocl.pivot.@NonNull OperationCallExp object) {
		return visitFeatureCallExp(object);
	}

	@Override
	public @Nullable R visitOppositePropertyCallExp(org.eclipse.ocl.pivot.@NonNull OppositePropertyCallExp object) {
		return visitNavigationCallExp(object);
	}

	@Override
	public @Nullable R visitOrderedSetType(org.eclipse.ocl.pivot.@NonNull OrderedSetType object) {
		return visitCollectionType(object);
	}

	@Override
	public @Nullable R visitOrphanCompletePackage(org.eclipse.ocl.pivot.@NonNull OrphanCompletePackage object) {
		return visitCompletePackage(object);
	}

	@Override
	public @Nullable R visitPackage(org.eclipse.ocl.pivot.@NonNull Package object) {
		return visitNamespace(object);
	}

	@Override
	public @Nullable R visitParameter(org.eclipse.ocl.pivot.@NonNull Parameter object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable R visitPrecedence(org.eclipse.ocl.pivot.@NonNull Precedence object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitPrimitiveCompletePackage(org.eclipse.ocl.pivot.@NonNull PrimitiveCompletePackage object) {
		return visitCompletePackage(object);
	}

	@Override
	public @Nullable R visitPrimitiveLiteralExp(org.eclipse.ocl.pivot.@NonNull PrimitiveLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public @Nullable R visitPrimitiveType(org.eclipse.ocl.pivot.@NonNull PrimitiveType object) {
		return visitDataType(object);
	}

	@Override
	public @Nullable R visitProfile(org.eclipse.ocl.pivot.@NonNull Profile object) {
		return visitPackage(object);
	}

	@Override
	public @Nullable R visitProfileApplication(org.eclipse.ocl.pivot.@NonNull ProfileApplication object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitProperty(org.eclipse.ocl.pivot.@NonNull Property object) {
		return visitFeature(object);
	}

	@Override
	public @Nullable R visitPropertyCallExp(org.eclipse.ocl.pivot.@NonNull PropertyCallExp object) {
		return visitNavigationCallExp(object);
	}

	@Override
	public @Nullable R visitPseudostate(org.eclipse.ocl.pivot.@NonNull Pseudostate object) {
		return visitVertex(object);
	}

	@Override
	public @Nullable R visitRealLiteralExp(org.eclipse.ocl.pivot.@NonNull RealLiteralExp object) {
		return visitNumericLiteralExp(object);
	}

	@Override
	public @Nullable R visitRegion(org.eclipse.ocl.pivot.@NonNull Region object) {
		return visitNamespace(object);
	}

	@Override
	public @Nullable R visitSelfType(org.eclipse.ocl.pivot.@NonNull SelfType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitSendSignalAction(org.eclipse.ocl.pivot.@NonNull SendSignalAction object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitSequenceType(org.eclipse.ocl.pivot.@NonNull SequenceType object) {
		return visitCollectionType(object);
	}

	@Override
	public @Nullable R visitSetType(org.eclipse.ocl.pivot.@NonNull SetType object) {
		return visitCollectionType(object);
	}

	@Override
	public @Nullable R visitShadowExp(org.eclipse.ocl.pivot.@NonNull ShadowExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitShadowPart(org.eclipse.ocl.pivot.@NonNull ShadowPart object) {
		return visitTypedElement(object);
	}

	@Override
	public @Nullable R visitSignal(org.eclipse.ocl.pivot.@NonNull Signal object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitSlot(org.eclipse.ocl.pivot.@NonNull Slot object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitStandardLibrary(org.eclipse.ocl.pivot.@NonNull StandardLibrary object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitState(org.eclipse.ocl.pivot.@NonNull State object) {
		return visitNamespace(object);
	}

	@Override
	public @Nullable R visitStateExp(org.eclipse.ocl.pivot.@NonNull StateExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitStateMachine(org.eclipse.ocl.pivot.@NonNull StateMachine object) {
		return visitBehavior(object);
	}

	@Override
	public @Nullable R visitStereotype(org.eclipse.ocl.pivot.@NonNull Stereotype object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitStereotypeExtender(org.eclipse.ocl.pivot.@NonNull StereotypeExtender object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitStringLiteralExp(org.eclipse.ocl.pivot.@NonNull StringLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	@Override
	public @Nullable R visitTemplateBinding(org.eclipse.ocl.pivot.@NonNull TemplateBinding object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitTemplateParameter(org.eclipse.ocl.pivot.@NonNull TemplateParameter object) {
		return visitType(object);
	}

	@Override
	public @Nullable R visitTemplateParameterSubstitution(org.eclipse.ocl.pivot.@NonNull TemplateParameterSubstitution object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitTemplateSignature(org.eclipse.ocl.pivot.@NonNull TemplateSignature object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitTemplateableElement(org.eclipse.ocl.pivot.@NonNull TemplateableElement object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitTransition(org.eclipse.ocl.pivot.@NonNull Transition object) {
		return visitNamespace(object);
	}

	@Override
	public @Nullable R visitTrigger(org.eclipse.ocl.pivot.@NonNull Trigger object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitTupleLiteralExp(org.eclipse.ocl.pivot.@NonNull TupleLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public @Nullable R visitTupleLiteralPart(org.eclipse.ocl.pivot.@NonNull TupleLiteralPart object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable R visitTupleType(org.eclipse.ocl.pivot.@NonNull TupleType object) {
		return visitDataType(object);
	}

	@Override
	public @Nullable R visitType(org.eclipse.ocl.pivot.@NonNull Type object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitTypeExp(org.eclipse.ocl.pivot.@NonNull TypeExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitTypedElement(org.eclipse.ocl.pivot.@NonNull TypedElement object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitUnlimitedNaturalLiteralExp(org.eclipse.ocl.pivot.@NonNull UnlimitedNaturalLiteralExp object) {
		return visitNumericLiteralExp(object);
	}

	@Override
	public @Nullable R visitUnspecifiedValueExp(org.eclipse.ocl.pivot.@NonNull UnspecifiedValueExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitValueSpecification(org.eclipse.ocl.pivot.@NonNull ValueSpecification object) {
		return visitTypedElement(object);
	}

	@Override
	public @Nullable R visitVariable(org.eclipse.ocl.pivot.@NonNull Variable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable R visitVariableDeclaration(org.eclipse.ocl.pivot.@NonNull VariableDeclaration object) {
		return visitTypedElement(object);
	}

	@Override
	public @Nullable R visitVariableExp(org.eclipse.ocl.pivot.@NonNull VariableExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitVertex(org.eclipse.ocl.pivot.@NonNull Vertex object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitVoidType(org.eclipse.ocl.pivot.@NonNull VoidType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitWildcardType(org.eclipse.ocl.pivot.@NonNull WildcardType object) {
		return visitClass(object);
	}
}
