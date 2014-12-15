/*******************************************************************************
 * Copyright (c) 2010,2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.pivot/model/Pivot.merged.genmodel
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
	public @Nullable R visitAnnotation(@NonNull org.eclipse.ocl.pivot.Annotation object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitAnyType(@NonNull org.eclipse.ocl.pivot.AnyType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitAssociationClass(@NonNull org.eclipse.ocl.pivot.AssociationClass object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitAssociationClassCallExp(@NonNull org.eclipse.ocl.pivot.AssociationClassCallExp object) {
		return visitNavigationCallExp(object);
	}

	@Override
	public @Nullable R visitBagType(@NonNull org.eclipse.ocl.pivot.BagType object) {
		return visitCollectionType(object);
	}

	@Override
	public @Nullable R visitBehavior(@NonNull org.eclipse.ocl.pivot.Behavior object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitBooleanLiteralExp(@NonNull org.eclipse.ocl.pivot.BooleanLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	@Override
	public @Nullable R visitCallExp(@NonNull org.eclipse.ocl.pivot.CallExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitCallOperationAction(@NonNull org.eclipse.ocl.pivot.CallOperationAction object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitClass(@NonNull org.eclipse.ocl.pivot.Class object) {
		return visitType(object);
	}

	@Override
	public @Nullable R visitCollectionItem(@NonNull org.eclipse.ocl.pivot.CollectionItem object) {
		return visitCollectionLiteralPart(object);
	}

	@Override
	public @Nullable R visitCollectionLiteralExp(@NonNull org.eclipse.ocl.pivot.CollectionLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public @Nullable R visitCollectionLiteralPart(@NonNull org.eclipse.ocl.pivot.CollectionLiteralPart object) {
		return visitTypedElement(object);
	}

	@Override
	public @Nullable R visitCollectionRange(@NonNull org.eclipse.ocl.pivot.CollectionRange object) {
		return visitCollectionLiteralPart(object);
	}

	@Override
	public @Nullable R visitCollectionType(@NonNull org.eclipse.ocl.pivot.CollectionType object) {
		return visitDataType(object);
	}

	@Override
	public @Nullable R visitComment(@NonNull org.eclipse.ocl.pivot.Comment object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitCompleteClass(@NonNull org.eclipse.ocl.pivot.CompleteClass object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitCompleteModel(@NonNull org.eclipse.ocl.pivot.CompleteModel object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitCompletePackage(@NonNull org.eclipse.ocl.pivot.CompletePackage object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitConnectionPointReference(@NonNull org.eclipse.ocl.pivot.ConnectionPointReference object) {
		return visitVertex(object);
	}

	@Override
	public @Nullable R visitConstraint(@NonNull org.eclipse.ocl.pivot.Constraint object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitConstructorExp(@NonNull org.eclipse.ocl.pivot.ConstructorExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitConstructorPart(@NonNull org.eclipse.ocl.pivot.ConstructorPart object) {
		return visitTypedElement(object);
	}

	@Override
	public @Nullable R visitDataType(@NonNull org.eclipse.ocl.pivot.DataType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitDetail(@NonNull org.eclipse.ocl.pivot.Detail object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitDynamicBehavior(@NonNull org.eclipse.ocl.pivot.DynamicBehavior object) {
		return visitDynamicType(object);
	}

	@Override
	public @Nullable R visitDynamicElement(@NonNull org.eclipse.ocl.pivot.DynamicElement object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitDynamicProperty(@NonNull org.eclipse.ocl.pivot.DynamicProperty object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitDynamicType(@NonNull org.eclipse.ocl.pivot.DynamicType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitDynamicValueSpecification(@NonNull org.eclipse.ocl.pivot.DynamicValueSpecification object) {
		return visitValueSpecification(object);
	}

	@Override
	public @Nullable R visitElement(@NonNull org.eclipse.ocl.pivot.Element object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitElementExtension(@NonNull org.eclipse.ocl.pivot.ElementExtension object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitEnumLiteralExp(@NonNull org.eclipse.ocl.pivot.EnumLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public @Nullable R visitEnumeration(@NonNull org.eclipse.ocl.pivot.Enumeration object) {
		return visitDataType(object);
	}

	@Override
	public @Nullable R visitEnumerationLiteral(@NonNull org.eclipse.ocl.pivot.EnumerationLiteral object) {
		return visitInstanceSpecification(object);
	}

	@Override
	public @Nullable R visitExpressionInOCL(@NonNull org.eclipse.ocl.pivot.ExpressionInOCL object) {
		return visitLanguageExpression(object);
	}

	@Override
	public @Nullable R visitFeature(@NonNull org.eclipse.ocl.pivot.Feature object) {
		return visitTypedElement(object);
	}

	@Override
	public @Nullable R visitFeatureCallExp(@NonNull org.eclipse.ocl.pivot.FeatureCallExp object) {
		return visitCallExp(object);
	}

	@Override
	public @Nullable R visitFinalState(@NonNull org.eclipse.ocl.pivot.FinalState object) {
		return visitState(object);
	}

	@Override
	public @Nullable R visitIfExp(@NonNull org.eclipse.ocl.pivot.IfExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitImport(@NonNull org.eclipse.ocl.pivot.Import object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitInstanceSpecification(@NonNull org.eclipse.ocl.pivot.InstanceSpecification object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitIntegerLiteralExp(@NonNull org.eclipse.ocl.pivot.IntegerLiteralExp object) {
		return visitNumericLiteralExp(object);
	}

	@Override
	public @Nullable R visitInvalidLiteralExp(@NonNull org.eclipse.ocl.pivot.InvalidLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public @Nullable R visitInvalidType(@NonNull org.eclipse.ocl.pivot.InvalidType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitIterateExp(@NonNull org.eclipse.ocl.pivot.IterateExp object) {
		return visitLoopExp(object);
	}

	@Override
	public @Nullable R visitIteration(@NonNull org.eclipse.ocl.pivot.Iteration object) {
		return visitOperation(object);
	}

	@Override
	public @Nullable R visitIteratorExp(@NonNull org.eclipse.ocl.pivot.IteratorExp object) {
		return visitLoopExp(object);
	}

	@Override
	public @Nullable R visitLambdaType(@NonNull org.eclipse.ocl.pivot.LambdaType object) {
		return visitDataType(object);
	}

	@Override
	public @Nullable R visitLanguageExpression(@NonNull org.eclipse.ocl.pivot.LanguageExpression object) {
		return visitValueSpecification(object);
	}

	@Override
	public @Nullable R visitLetExp(@NonNull org.eclipse.ocl.pivot.LetExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitLibrary(@NonNull org.eclipse.ocl.pivot.Library object) {
		return visitPackage(object);
	}

	@Override
	public @Nullable R visitLiteralExp(@NonNull org.eclipse.ocl.pivot.LiteralExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitLoopExp(@NonNull org.eclipse.ocl.pivot.LoopExp object) {
		return visitCallExp(object);
	}

	@Override
	public @Nullable R visitMessageExp(@NonNull org.eclipse.ocl.pivot.MessageExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitMessageType(@NonNull org.eclipse.ocl.pivot.MessageType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitModel(@NonNull org.eclipse.ocl.pivot.Model object) {
		return visitNamespace(object);
	}

	@Override
	public @Nullable R visitNamedElement(@NonNull org.eclipse.ocl.pivot.NamedElement object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitNamespace(@NonNull org.eclipse.ocl.pivot.Namespace object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitNavigationCallExp(@NonNull org.eclipse.ocl.pivot.NavigationCallExp object) {
		return visitFeatureCallExp(object);
	}

	@Override
	public @Nullable R visitNullLiteralExp(@NonNull org.eclipse.ocl.pivot.NullLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	@Override
	public @Nullable R visitNumericLiteralExp(@NonNull org.eclipse.ocl.pivot.NumericLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	@Override
	public @Nullable R visitOCLExpression(@NonNull org.eclipse.ocl.pivot.OCLExpression object) {
		return visitTypedElement(object);
	}

	@Override
	public @Nullable R visitOperation(@NonNull org.eclipse.ocl.pivot.Operation object) {
		return visitFeature(object);
	}

	@Override
	public @Nullable R visitOperationCallExp(@NonNull org.eclipse.ocl.pivot.OperationCallExp object) {
		return visitFeatureCallExp(object);
	}

	@Override
	public @Nullable R visitOppositePropertyCallExp(@NonNull org.eclipse.ocl.pivot.OppositePropertyCallExp object) {
		return visitNavigationCallExp(object);
	}

	@Override
	public @Nullable R visitOrderedSetType(@NonNull org.eclipse.ocl.pivot.OrderedSetType object) {
		return visitCollectionType(object);
	}

	@Override
	public @Nullable R visitOrphanCompletePackage(@NonNull org.eclipse.ocl.pivot.OrphanCompletePackage object) {
		return visitCompletePackage(object);
	}

	@Override
	public @Nullable R visitPackage(@NonNull org.eclipse.ocl.pivot.Package object) {
		return visitNamespace(object);
	}

	@Override
	public @Nullable R visitParameter(@NonNull org.eclipse.ocl.pivot.Parameter object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable R visitPrecedence(@NonNull org.eclipse.ocl.pivot.Precedence object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitPrimitiveCompletePackage(@NonNull org.eclipse.ocl.pivot.PrimitiveCompletePackage object) {
		return visitCompletePackage(object);
	}

	@Override
	public @Nullable R visitPrimitiveLiteralExp(@NonNull org.eclipse.ocl.pivot.PrimitiveLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public @Nullable R visitPrimitiveType(@NonNull org.eclipse.ocl.pivot.PrimitiveType object) {
		return visitDataType(object);
	}

	@Override
	public @Nullable R visitProfile(@NonNull org.eclipse.ocl.pivot.Profile object) {
		return visitPackage(object);
	}

	@Override
	public @Nullable R visitProfileApplication(@NonNull org.eclipse.ocl.pivot.ProfileApplication object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitProperty(@NonNull org.eclipse.ocl.pivot.Property object) {
		return visitFeature(object);
	}

	@Override
	public @Nullable R visitPropertyCallExp(@NonNull org.eclipse.ocl.pivot.PropertyCallExp object) {
		return visitNavigationCallExp(object);
	}

	@Override
	public @Nullable R visitPseudostate(@NonNull org.eclipse.ocl.pivot.Pseudostate object) {
		return visitVertex(object);
	}

	@Override
	public @Nullable R visitRealLiteralExp(@NonNull org.eclipse.ocl.pivot.RealLiteralExp object) {
		return visitNumericLiteralExp(object);
	}

	@Override
	public @Nullable R visitRegion(@NonNull org.eclipse.ocl.pivot.Region object) {
		return visitNamespace(object);
	}

	@Override
	public @Nullable R visitSelfType(@NonNull org.eclipse.ocl.pivot.SelfType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitSendSignalAction(@NonNull org.eclipse.ocl.pivot.SendSignalAction object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitSequenceType(@NonNull org.eclipse.ocl.pivot.SequenceType object) {
		return visitCollectionType(object);
	}

	@Override
	public @Nullable R visitSetType(@NonNull org.eclipse.ocl.pivot.SetType object) {
		return visitCollectionType(object);
	}

	@Override
	public @Nullable R visitSignal(@NonNull org.eclipse.ocl.pivot.Signal object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitSlot(@NonNull org.eclipse.ocl.pivot.Slot object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitStandardLibrary(@NonNull org.eclipse.ocl.pivot.StandardLibrary object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitState(@NonNull org.eclipse.ocl.pivot.State object) {
		return visitNamespace(object);
	}

	@Override
	public @Nullable R visitStateExp(@NonNull org.eclipse.ocl.pivot.StateExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitStateMachine(@NonNull org.eclipse.ocl.pivot.StateMachine object) {
		return visitBehavior(object);
	}

	@Override
	public @Nullable R visitStereotype(@NonNull org.eclipse.ocl.pivot.Stereotype object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitStringLiteralExp(@NonNull org.eclipse.ocl.pivot.StringLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	@Override
	public @Nullable R visitTemplateBinding(@NonNull org.eclipse.ocl.pivot.TemplateBinding object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitTemplateParameter(@NonNull org.eclipse.ocl.pivot.TemplateParameter object) {
		return visitType(object);
	}

	@Override
	public @Nullable R visitTemplateParameterSubstitution(@NonNull org.eclipse.ocl.pivot.TemplateParameterSubstitution object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitTemplateSignature(@NonNull org.eclipse.ocl.pivot.TemplateSignature object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitTemplateableElement(@NonNull org.eclipse.ocl.pivot.TemplateableElement object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitTransition(@NonNull org.eclipse.ocl.pivot.Transition object) {
		return visitNamespace(object);
	}

	@Override
	public @Nullable R visitTrigger(@NonNull org.eclipse.ocl.pivot.Trigger object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitTupleLiteralExp(@NonNull org.eclipse.ocl.pivot.TupleLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public @Nullable R visitTupleLiteralPart(@NonNull org.eclipse.ocl.pivot.TupleLiteralPart object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable R visitTupleType(@NonNull org.eclipse.ocl.pivot.TupleType object) {
		return visitDataType(object);
	}

	@Override
	public @Nullable R visitType(@NonNull org.eclipse.ocl.pivot.Type object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitTypeExp(@NonNull org.eclipse.ocl.pivot.TypeExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitTypeExtension(@NonNull org.eclipse.ocl.pivot.TypeExtension object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitTypedElement(@NonNull org.eclipse.ocl.pivot.TypedElement object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitUnlimitedNaturalLiteralExp(@NonNull org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp object) {
		return visitNumericLiteralExp(object);
	}

	@Override
	public @Nullable R visitUnspecifiedValueExp(@NonNull org.eclipse.ocl.pivot.UnspecifiedValueExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitValueSpecification(@NonNull org.eclipse.ocl.pivot.ValueSpecification object) {
		return visitTypedElement(object);
	}

	@Override
	public @Nullable R visitVariable(@NonNull org.eclipse.ocl.pivot.Variable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable R visitVariableDeclaration(@NonNull org.eclipse.ocl.pivot.VariableDeclaration object) {
		return visitTypedElement(object);
	}

	@Override
	public @Nullable R visitVariableExp(@NonNull org.eclipse.ocl.pivot.VariableExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitVertex(@NonNull org.eclipse.ocl.pivot.Vertex object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitVoidType(@NonNull org.eclipse.ocl.pivot.VoidType object) {
		return visitClass(object);
	}

	@Override
	public @Nullable R visitWildcardType(@NonNull org.eclipse.ocl.pivot.WildcardType object) {
		return visitClass(object);
	}
}
