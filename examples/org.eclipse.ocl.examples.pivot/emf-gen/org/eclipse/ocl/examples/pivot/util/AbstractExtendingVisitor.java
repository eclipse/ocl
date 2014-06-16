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

	public @Nullable R visitAnnotation(@NonNull org.eclipse.ocl.examples.pivot.Annotation object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitAnyType(@NonNull org.eclipse.ocl.examples.pivot.AnyType object) {
		return visitClass(object);
	}

	public @Nullable R visitAssociationClass(@NonNull org.eclipse.ocl.examples.pivot.AssociationClass object) {
		return visitClass(object);
	}

	public @Nullable R visitAssociationClassCallExp(@NonNull org.eclipse.ocl.examples.pivot.AssociationClassCallExp object) {
		return visitNavigationCallExp(object);
	}

	public @Nullable R visitBagType(@NonNull org.eclipse.ocl.examples.pivot.BagType object) {
		return visitCollectionType(object);
	}

	public @Nullable R visitBehavior(@NonNull org.eclipse.ocl.examples.pivot.Behavior object) {
		return visitClass(object);
	}

	public @Nullable R visitBooleanLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.BooleanLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	public @Nullable R visitCallExp(@NonNull org.eclipse.ocl.examples.pivot.CallExp object) {
		return visitOCLExpression(object);
	}

	public @Nullable R visitCallOperationAction(@NonNull org.eclipse.ocl.examples.pivot.CallOperationAction object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		return visitType(object);
	}

	public @Nullable R visitCollectionItem(@NonNull org.eclipse.ocl.examples.pivot.CollectionItem object) {
		return visitCollectionLiteralPart(object);
	}

	public @Nullable R visitCollectionLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.CollectionLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable R visitCollectionLiteralPart(@NonNull org.eclipse.ocl.examples.pivot.CollectionLiteralPart object) {
		return visitTypedElement(object);
	}

	public @Nullable R visitCollectionRange(@NonNull org.eclipse.ocl.examples.pivot.CollectionRange object) {
		return visitCollectionLiteralPart(object);
	}

	public @Nullable R visitCollectionType(@NonNull org.eclipse.ocl.examples.pivot.CollectionType object) {
		return visitDataType(object);
	}

	public @Nullable R visitComment(@NonNull org.eclipse.ocl.examples.pivot.Comment object) {
		return visitElement(object);
	}

	public @Nullable R visitConnectionPointReference(@NonNull org.eclipse.ocl.examples.pivot.ConnectionPointReference object) {
		return visitVertex(object);
	}

	public @Nullable R visitConstraint(@NonNull org.eclipse.ocl.examples.pivot.Constraint object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitConstructorExp(@NonNull org.eclipse.ocl.examples.pivot.ConstructorExp object) {
		return visitOCLExpression(object);
	}

	public @Nullable R visitConstructorPart(@NonNull org.eclipse.ocl.examples.pivot.ConstructorPart object) {
		return visitTypedElement(object);
	}

	public @Nullable R visitDataType(@NonNull org.eclipse.ocl.examples.pivot.DataType object) {
		return visitClass(object);
	}

	public @Nullable R visitDetail(@NonNull org.eclipse.ocl.examples.pivot.Detail object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitDynamicBehavior(@NonNull org.eclipse.ocl.examples.pivot.DynamicBehavior object) {
		return visitBehavior(object);
	}

	public @Nullable R visitDynamicElement(@NonNull org.eclipse.ocl.examples.pivot.DynamicElement object) {
		return visitElement(object);
	}

	public @Nullable R visitDynamicProperty(@NonNull org.eclipse.ocl.examples.pivot.DynamicProperty object) {
		return visitElement(object);
	}

	public @Nullable R visitDynamicType(@NonNull org.eclipse.ocl.examples.pivot.DynamicType object) {
		return visitType(object);
	}

	public @Nullable R visitElement(@NonNull org.eclipse.ocl.examples.pivot.Element object) {
		return visiting(object);
	}

	public @Nullable R visitElementExtension(@NonNull org.eclipse.ocl.examples.pivot.ElementExtension object) {
		return visitType(object);
	}

	public @Nullable R visitEnumLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.EnumLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable R visitEnumeration(@NonNull org.eclipse.ocl.examples.pivot.Enumeration object) {
		return visitDataType(object);
	}

	public @Nullable R visitEnumerationLiteral(@NonNull org.eclipse.ocl.examples.pivot.EnumerationLiteral object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitExpressionInOCL(@NonNull org.eclipse.ocl.examples.pivot.ExpressionInOCL object) {
		return visitOpaqueExpression(object);
	}

	public @Nullable R visitFeature(@NonNull org.eclipse.ocl.examples.pivot.Feature object) {
		return visitTypedMultiplicityElement(object);
	}

	public @Nullable R visitFeatureCallExp(@NonNull org.eclipse.ocl.examples.pivot.FeatureCallExp object) {
		return visitCallExp(object);
	}

	public @Nullable R visitFinalState(@NonNull org.eclipse.ocl.examples.pivot.FinalState object) {
		return visitState(object);
	}

	public @Nullable R visitIfExp(@NonNull org.eclipse.ocl.examples.pivot.IfExp object) {
		return visitOCLExpression(object);
	}

	public @Nullable R visitImport(@NonNull org.eclipse.ocl.examples.pivot.Import object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitIntegerLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.IntegerLiteralExp object) {
		return visitNumericLiteralExp(object);
	}

	public @Nullable R visitInvalidLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.InvalidLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable R visitInvalidType(@NonNull org.eclipse.ocl.examples.pivot.InvalidType object) {
		return visitClass(object);
	}

	public @Nullable R visitIterateExp(@NonNull org.eclipse.ocl.examples.pivot.IterateExp object) {
		return visitLoopExp(object);
	}

	public @Nullable R visitIteration(@NonNull org.eclipse.ocl.examples.pivot.Iteration object) {
		return visitOperation(object);
	}

	public @Nullable R visitIteratorExp(@NonNull org.eclipse.ocl.examples.pivot.IteratorExp object) {
		return visitLoopExp(object);
	}

	public @Nullable R visitLambdaType(@NonNull org.eclipse.ocl.examples.pivot.LambdaType object) {
		return visitDataType(object);
	}

	public @Nullable R visitLetExp(@NonNull org.eclipse.ocl.examples.pivot.LetExp object) {
		return visitOCLExpression(object);
	}

	public @Nullable R visitLibrary(@NonNull org.eclipse.ocl.examples.pivot.Library object) {
		return visitPackage(object);
	}

	public @Nullable R visitLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.LiteralExp object) {
		return visitOCLExpression(object);
	}

	public @Nullable R visitLoopExp(@NonNull org.eclipse.ocl.examples.pivot.LoopExp object) {
		return visitCallExp(object);
	}

	public @Nullable R visitMessageExp(@NonNull org.eclipse.ocl.examples.pivot.MessageExp object) {
		return visitOCLExpression(object);
	}

	public @Nullable R visitMessageType(@NonNull org.eclipse.ocl.examples.pivot.MessageType object) {
		return visitType(object);
	}

	public @Nullable R visitMetaclass(@NonNull org.eclipse.ocl.examples.pivot.Metaclass<?> object) {
		return visitClass(object);
	}

	public @Nullable R visitNamedElement(@NonNull org.eclipse.ocl.examples.pivot.NamedElement object) {
		return visitElement(object);
	}

	public @Nullable R visitNamespace(@NonNull org.eclipse.ocl.examples.pivot.Namespace object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitNavigationCallExp(@NonNull org.eclipse.ocl.examples.pivot.NavigationCallExp object) {
		return visitFeatureCallExp(object);
	}

	public @Nullable R visitNullLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.NullLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	public @Nullable R visitNumericLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.NumericLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	public @Nullable R visitOCLExpression(@NonNull org.eclipse.ocl.examples.pivot.OCLExpression object) {
		return visitTypedElement(object);
	}

	public @Nullable R visitOpaqueExpression(@NonNull org.eclipse.ocl.examples.pivot.OpaqueExpression object) {
		return visitValueSpecification(object);
	}

	public @Nullable R visitOperation(@NonNull org.eclipse.ocl.examples.pivot.Operation object) {
		return visitFeature(object);
	}

	public @Nullable R visitOperationCallExp(@NonNull org.eclipse.ocl.examples.pivot.OperationCallExp object) {
		return visitFeatureCallExp(object);
	}

	public @Nullable R visitOperationTemplateParameter(@NonNull org.eclipse.ocl.examples.pivot.OperationTemplateParameter object) {
		return visitTemplateParameter(object);
	}

	public @Nullable R visitOppositePropertyCallExp(@NonNull org.eclipse.ocl.examples.pivot.OppositePropertyCallExp object) {
		return visitNavigationCallExp(object);
	}

	public @Nullable R visitOrderedSetType(@NonNull org.eclipse.ocl.examples.pivot.OrderedSetType object) {
		return visitCollectionType(object);
	}

	public @Nullable R visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package object) {
		return visitNamespace(object);
	}

	public @Nullable R visitPackageableElement(@NonNull org.eclipse.ocl.examples.pivot.PackageableElement object) {
		return visitParameterableElement(object);
	}

	public @Nullable R visitParameter(@NonNull org.eclipse.ocl.examples.pivot.Parameter object) {
		return visitTypedMultiplicityElement(object);
	}

	public @Nullable R visitParameterableElement(@NonNull org.eclipse.ocl.examples.pivot.ParameterableElement object) {
		return visitElement(object);
	}

	public @Nullable R visitPrecedence(@NonNull org.eclipse.ocl.examples.pivot.Precedence object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitPrimitiveLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable R visitPrimitiveType(@NonNull org.eclipse.ocl.examples.pivot.PrimitiveType object) {
		return visitDataType(object);
	}

	public @Nullable R visitProfile(@NonNull org.eclipse.ocl.examples.pivot.Profile object) {
		return visitPackage(object);
	}

	public @Nullable R visitProfileApplication(@NonNull org.eclipse.ocl.examples.pivot.ProfileApplication object) {
		return visitElement(object);
	}

	public @Nullable R visitProperty(@NonNull org.eclipse.ocl.examples.pivot.Property object) {
		return visitFeature(object);
	}

	public @Nullable R visitPropertyCallExp(@NonNull org.eclipse.ocl.examples.pivot.PropertyCallExp object) {
		return visitNavigationCallExp(object);
	}

	public @Nullable R visitPseudostate(@NonNull org.eclipse.ocl.examples.pivot.Pseudostate object) {
		return visitVertex(object);
	}

	public @Nullable R visitRealLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.RealLiteralExp object) {
		return visitNumericLiteralExp(object);
	}

	public @Nullable R visitRegion(@NonNull org.eclipse.ocl.examples.pivot.Region object) {
		return visitNamespace(object);
	}

	public @Nullable R visitRoot(@NonNull org.eclipse.ocl.examples.pivot.Root object) {
		return visitNamespace(object);
	}

	public @Nullable R visitSelfType(@NonNull org.eclipse.ocl.examples.pivot.SelfType object) {
		return visitClass(object);
	}

	public @Nullable R visitSendSignalAction(@NonNull org.eclipse.ocl.examples.pivot.SendSignalAction object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitSequenceType(@NonNull org.eclipse.ocl.examples.pivot.SequenceType object) {
		return visitCollectionType(object);
	}

	public @Nullable R visitSetType(@NonNull org.eclipse.ocl.examples.pivot.SetType object) {
		return visitCollectionType(object);
	}

	public @Nullable R visitSignal(@NonNull org.eclipse.ocl.examples.pivot.Signal object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitState(@NonNull org.eclipse.ocl.examples.pivot.State object) {
		return visitVertex(object);
	}

	public @Nullable R visitStateExp(@NonNull org.eclipse.ocl.examples.pivot.StateExp object) {
		return visitOCLExpression(object);
	}

	public @Nullable R visitStateMachine(@NonNull org.eclipse.ocl.examples.pivot.StateMachine object) {
		return visitBehavior(object);
	}

	public @Nullable R visitStereotype(@NonNull org.eclipse.ocl.examples.pivot.Stereotype object) {
		return visitClass(object);
	}

	public @Nullable R visitStringLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.StringLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	public @Nullable R visitTemplateBinding(@NonNull org.eclipse.ocl.examples.pivot.TemplateBinding object) {
		return visitElement(object);
	}

	public @Nullable R visitTemplateParameter(@NonNull org.eclipse.ocl.examples.pivot.TemplateParameter object) {
		return visitElement(object);
	}

	public @Nullable R visitTemplateParameterSubstitution(@NonNull org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution object) {
		return visitElement(object);
	}

	public @Nullable R visitTemplateParameterType(@NonNull org.eclipse.ocl.examples.pivot.TemplateParameterType object) {
		return visitType(object);
	}

	public @Nullable R visitTemplateSignature(@NonNull org.eclipse.ocl.examples.pivot.TemplateSignature object) {
		return visitElement(object);
	}

	public @Nullable R visitTemplateableElement(@NonNull org.eclipse.ocl.examples.pivot.TemplateableElement object) {
		return visitElement(object);
	}

	public @Nullable R visitTransition(@NonNull org.eclipse.ocl.examples.pivot.Transition object) {
		return visitNamespace(object);
	}

	public @Nullable R visitTrigger(@NonNull org.eclipse.ocl.examples.pivot.Trigger object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitTupleLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.TupleLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable R visitTupleLiteralPart(@NonNull org.eclipse.ocl.examples.pivot.TupleLiteralPart object) {
		return visitVariableDeclaration(object);
	}

	public @Nullable R visitTupleType(@NonNull org.eclipse.ocl.examples.pivot.TupleType object) {
		return visitDataType(object);
	}

	public @Nullable R visitType(@NonNull org.eclipse.ocl.examples.pivot.Type object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitTypeExp(@NonNull org.eclipse.ocl.examples.pivot.TypeExp object) {
		return visitOCLExpression(object);
	}

	public @Nullable R visitTypeExtension(@NonNull org.eclipse.ocl.examples.pivot.TypeExtension object) {
		return visitElement(object);
	}

	public @Nullable R visitTypeTemplateParameter(@NonNull org.eclipse.ocl.examples.pivot.TypeTemplateParameter object) {
		return visitTemplateParameter(object);
	}

	public @Nullable R visitTypedElement(@NonNull org.eclipse.ocl.examples.pivot.TypedElement object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitTypedMultiplicityElement(@NonNull org.eclipse.ocl.examples.pivot.TypedMultiplicityElement object) {
		return visitTypedElement(object);
	}

	public @Nullable R visitUnlimitedNaturalLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp object) {
		return visitNumericLiteralExp(object);
	}

	public @Nullable R visitUnspecifiedType(@NonNull org.eclipse.ocl.examples.pivot.UnspecifiedType object) {
		return visitClass(object);
	}

	public @Nullable R visitUnspecifiedValueExp(@NonNull org.eclipse.ocl.examples.pivot.UnspecifiedValueExp object) {
		return visitOCLExpression(object);
	}

	public @Nullable R visitValueSpecification(@NonNull org.eclipse.ocl.examples.pivot.ValueSpecification object) {
		return visitTypedElement(object);
	}

	public @Nullable R visitVariable(@NonNull org.eclipse.ocl.examples.pivot.Variable object) {
		return visitVariableDeclaration(object);
	}

	public @Nullable R visitVariableDeclaration(@NonNull org.eclipse.ocl.examples.pivot.VariableDeclaration object) {
		return visitTypedElement(object);
	}

	public @Nullable R visitVariableExp(@NonNull org.eclipse.ocl.examples.pivot.VariableExp object) {
		return visitOCLExpression(object);
	}

	public @Nullable R visitVertex(@NonNull org.eclipse.ocl.examples.pivot.Vertex object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitVoidType(@NonNull org.eclipse.ocl.examples.pivot.VoidType object) {
		return visitClass(object);
	}
}
