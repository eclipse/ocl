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
	@Nullable R visiting(@NonNull org.eclipse.ocl.examples.pivot.util.Visitable visitable);

	@Nullable R visitAnnotation(@NonNull org.eclipse.ocl.examples.pivot.Annotation object);
	@Nullable R visitAnyType(@NonNull org.eclipse.ocl.examples.pivot.AnyType object);
	@Nullable R visitAssociationClass(@NonNull org.eclipse.ocl.examples.pivot.AssociationClass object);
	@Nullable R visitAssociationClassCallExp(@NonNull org.eclipse.ocl.examples.pivot.AssociationClassCallExp object);
	@Nullable R visitBagType(@NonNull org.eclipse.ocl.examples.pivot.BagType object);
	@Nullable R visitBehavior(@NonNull org.eclipse.ocl.examples.pivot.Behavior object);
	@Nullable R visitBooleanLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.BooleanLiteralExp object);
	@Nullable R visitCallExp(@NonNull org.eclipse.ocl.examples.pivot.CallExp object);
	@Nullable R visitCallOperationAction(@NonNull org.eclipse.ocl.examples.pivot.CallOperationAction object);
	@Nullable R visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object);
	@Nullable R visitCollectionItem(@NonNull org.eclipse.ocl.examples.pivot.CollectionItem object);
	@Nullable R visitCollectionLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.CollectionLiteralExp object);
	@Nullable R visitCollectionLiteralPart(@NonNull org.eclipse.ocl.examples.pivot.CollectionLiteralPart object);
	@Nullable R visitCollectionRange(@NonNull org.eclipse.ocl.examples.pivot.CollectionRange object);
	@Nullable R visitCollectionType(@NonNull org.eclipse.ocl.examples.pivot.CollectionType object);
	@Nullable R visitComment(@NonNull org.eclipse.ocl.examples.pivot.Comment object);
	@Nullable R visitConnectionPointReference(@NonNull org.eclipse.ocl.examples.pivot.ConnectionPointReference object);
	@Nullable R visitConstraint(@NonNull org.eclipse.ocl.examples.pivot.Constraint object);
	@Nullable R visitConstructorExp(@NonNull org.eclipse.ocl.examples.pivot.ConstructorExp object);
	@Nullable R visitConstructorPart(@NonNull org.eclipse.ocl.examples.pivot.ConstructorPart object);
	@Nullable R visitDataType(@NonNull org.eclipse.ocl.examples.pivot.DataType object);
	@Nullable R visitDetail(@NonNull org.eclipse.ocl.examples.pivot.Detail object);
	@Nullable R visitDynamicBehavior(@NonNull org.eclipse.ocl.examples.pivot.DynamicBehavior object);
	@Nullable R visitDynamicElement(@NonNull org.eclipse.ocl.examples.pivot.DynamicElement object);
	@Nullable R visitDynamicProperty(@NonNull org.eclipse.ocl.examples.pivot.DynamicProperty object);
	@Nullable R visitDynamicType(@NonNull org.eclipse.ocl.examples.pivot.DynamicType object);
	@Nullable R visitElement(@NonNull org.eclipse.ocl.examples.pivot.Element object);
	@Nullable R visitElementExtension(@NonNull org.eclipse.ocl.examples.pivot.ElementExtension object);
	@Nullable R visitEnumLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.EnumLiteralExp object);
	@Nullable R visitEnumeration(@NonNull org.eclipse.ocl.examples.pivot.Enumeration object);
	@Nullable R visitEnumerationLiteral(@NonNull org.eclipse.ocl.examples.pivot.EnumerationLiteral object);
	@Nullable R visitExpressionInOCL(@NonNull org.eclipse.ocl.examples.pivot.ExpressionInOCL object);
	@Nullable R visitFeature(@NonNull org.eclipse.ocl.examples.pivot.Feature object);
	@Nullable R visitFeatureCallExp(@NonNull org.eclipse.ocl.examples.pivot.FeatureCallExp object);
	@Nullable R visitFinalState(@NonNull org.eclipse.ocl.examples.pivot.FinalState object);
	@Nullable R visitIfExp(@NonNull org.eclipse.ocl.examples.pivot.IfExp object);
	@Nullable R visitImport(@NonNull org.eclipse.ocl.examples.pivot.Import object);
	@Nullable R visitIntegerLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.IntegerLiteralExp object);
	@Nullable R visitInvalidLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.InvalidLiteralExp object);
	@Nullable R visitInvalidType(@NonNull org.eclipse.ocl.examples.pivot.InvalidType object);
	@Nullable R visitIterateExp(@NonNull org.eclipse.ocl.examples.pivot.IterateExp object);
	@Nullable R visitIteration(@NonNull org.eclipse.ocl.examples.pivot.Iteration object);
	@Nullable R visitIteratorExp(@NonNull org.eclipse.ocl.examples.pivot.IteratorExp object);
	@Nullable R visitLambdaType(@NonNull org.eclipse.ocl.examples.pivot.LambdaType object);
	@Nullable R visitLetExp(@NonNull org.eclipse.ocl.examples.pivot.LetExp object);
	@Nullable R visitLibrary(@NonNull org.eclipse.ocl.examples.pivot.Library object);
	@Nullable R visitLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.LiteralExp object);
	@Nullable R visitLoopExp(@NonNull org.eclipse.ocl.examples.pivot.LoopExp object);
	@Nullable R visitMessageExp(@NonNull org.eclipse.ocl.examples.pivot.MessageExp object);
	@Nullable R visitMessageType(@NonNull org.eclipse.ocl.examples.pivot.MessageType object);
	@Nullable R visitMetaclass(@NonNull org.eclipse.ocl.examples.pivot.Metaclass<?> object);
	@Nullable R visitNamedElement(@NonNull org.eclipse.ocl.examples.pivot.NamedElement object);
	@Nullable R visitNamespace(@NonNull org.eclipse.ocl.examples.pivot.Namespace object);
	@Nullable R visitNavigationCallExp(@NonNull org.eclipse.ocl.examples.pivot.NavigationCallExp object);
	@Nullable R visitNullLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.NullLiteralExp object);
	@Nullable R visitNumericLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.NumericLiteralExp object);
	@Nullable R visitOCLExpression(@NonNull org.eclipse.ocl.examples.pivot.OCLExpression object);
	@Nullable R visitOpaqueExpression(@NonNull org.eclipse.ocl.examples.pivot.OpaqueExpression object);
	@Nullable R visitOperation(@NonNull org.eclipse.ocl.examples.pivot.Operation object);
	@Nullable R visitOperationCallExp(@NonNull org.eclipse.ocl.examples.pivot.OperationCallExp object);
	@Nullable R visitOperationTemplateParameter(@NonNull org.eclipse.ocl.examples.pivot.OperationTemplateParameter object);
	@Nullable R visitOppositePropertyCallExp(@NonNull org.eclipse.ocl.examples.pivot.OppositePropertyCallExp object);
	@Nullable R visitOrderedSetType(@NonNull org.eclipse.ocl.examples.pivot.OrderedSetType object);
	@Nullable R visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package object);
	@Nullable R visitPackageableElement(@NonNull org.eclipse.ocl.examples.pivot.PackageableElement object);
	@Nullable R visitParameter(@NonNull org.eclipse.ocl.examples.pivot.Parameter object);
	@Nullable R visitParameterableElement(@NonNull org.eclipse.ocl.examples.pivot.ParameterableElement object);
	@Nullable R visitPrecedence(@NonNull org.eclipse.ocl.examples.pivot.Precedence object);
	@Nullable R visitPrimitiveLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp object);
	@Nullable R visitPrimitiveType(@NonNull org.eclipse.ocl.examples.pivot.PrimitiveType object);
	@Nullable R visitProfile(@NonNull org.eclipse.ocl.examples.pivot.Profile object);
	@Nullable R visitProfileApplication(@NonNull org.eclipse.ocl.examples.pivot.ProfileApplication object);
	@Nullable R visitProperty(@NonNull org.eclipse.ocl.examples.pivot.Property object);
	@Nullable R visitPropertyCallExp(@NonNull org.eclipse.ocl.examples.pivot.PropertyCallExp object);
	@Nullable R visitPseudostate(@NonNull org.eclipse.ocl.examples.pivot.Pseudostate object);
	@Nullable R visitRealLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.RealLiteralExp object);
	@Nullable R visitRegion(@NonNull org.eclipse.ocl.examples.pivot.Region object);
	@Nullable R visitRoot(@NonNull org.eclipse.ocl.examples.pivot.Root object);
	@Nullable R visitSelfType(@NonNull org.eclipse.ocl.examples.pivot.SelfType object);
	@Nullable R visitSendSignalAction(@NonNull org.eclipse.ocl.examples.pivot.SendSignalAction object);
	@Nullable R visitSequenceType(@NonNull org.eclipse.ocl.examples.pivot.SequenceType object);
	@Nullable R visitSetType(@NonNull org.eclipse.ocl.examples.pivot.SetType object);
	@Nullable R visitSignal(@NonNull org.eclipse.ocl.examples.pivot.Signal object);
	@Nullable R visitState(@NonNull org.eclipse.ocl.examples.pivot.State object);
	@Nullable R visitStateExp(@NonNull org.eclipse.ocl.examples.pivot.StateExp object);
	@Nullable R visitStateMachine(@NonNull org.eclipse.ocl.examples.pivot.StateMachine object);
	@Nullable R visitStereotype(@NonNull org.eclipse.ocl.examples.pivot.Stereotype object);
	@Nullable R visitStringLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.StringLiteralExp object);
	@Nullable R visitTemplateBinding(@NonNull org.eclipse.ocl.examples.pivot.TemplateBinding object);
	@Nullable R visitTemplateParameter(@NonNull org.eclipse.ocl.examples.pivot.TemplateParameter object);
	@Nullable R visitTemplateParameterSubstitution(@NonNull org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution object);
	@Nullable R visitTemplateParameterType(@NonNull org.eclipse.ocl.examples.pivot.TemplateParameterType object);
	@Nullable R visitTemplateSignature(@NonNull org.eclipse.ocl.examples.pivot.TemplateSignature object);
	@Nullable R visitTemplateableElement(@NonNull org.eclipse.ocl.examples.pivot.TemplateableElement object);
	@Nullable R visitTransition(@NonNull org.eclipse.ocl.examples.pivot.Transition object);
	@Nullable R visitTrigger(@NonNull org.eclipse.ocl.examples.pivot.Trigger object);
	@Nullable R visitTupleLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.TupleLiteralExp object);
	@Nullable R visitTupleLiteralPart(@NonNull org.eclipse.ocl.examples.pivot.TupleLiteralPart object);
	@Nullable R visitTupleType(@NonNull org.eclipse.ocl.examples.pivot.TupleType object);
	@Nullable R visitType(@NonNull org.eclipse.ocl.examples.pivot.Type object);
	@Nullable R visitTypeExp(@NonNull org.eclipse.ocl.examples.pivot.TypeExp object);
	@Nullable R visitTypeExtension(@NonNull org.eclipse.ocl.examples.pivot.TypeExtension object);
	@Nullable R visitTypeTemplateParameter(@NonNull org.eclipse.ocl.examples.pivot.TypeTemplateParameter object);
	@Nullable R visitTypedElement(@NonNull org.eclipse.ocl.examples.pivot.TypedElement object);
	@Nullable R visitTypedMultiplicityElement(@NonNull org.eclipse.ocl.examples.pivot.TypedMultiplicityElement object);
	@Nullable R visitUnlimitedNaturalLiteralExp(@NonNull org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp object);
	@Nullable R visitUnspecifiedType(@NonNull org.eclipse.ocl.examples.pivot.UnspecifiedType object);
	@Nullable R visitUnspecifiedValueExp(@NonNull org.eclipse.ocl.examples.pivot.UnspecifiedValueExp object);
	@Nullable R visitValueSpecification(@NonNull org.eclipse.ocl.examples.pivot.ValueSpecification object);
	@Nullable R visitVariable(@NonNull org.eclipse.ocl.examples.pivot.Variable object);
	@Nullable R visitVariableDeclaration(@NonNull org.eclipse.ocl.examples.pivot.VariableDeclaration object);
	@Nullable R visitVariableExp(@NonNull org.eclipse.ocl.examples.pivot.VariableExp object);
	@Nullable R visitVertex(@NonNull org.eclipse.ocl.examples.pivot.Vertex object);
	@Nullable R visitVoidType(@NonNull org.eclipse.ocl.examples.pivot.VoidType object);
}
