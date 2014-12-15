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
	@Nullable R visiting(@NonNull org.eclipse.ocl.pivot.util.Visitable visitable);

	@Nullable R visitAnnotation(@NonNull org.eclipse.ocl.pivot.Annotation object);
	@Nullable R visitAnyType(@NonNull org.eclipse.ocl.pivot.AnyType object);
	@Nullable R visitAssociationClass(@NonNull org.eclipse.ocl.pivot.AssociationClass object);
	@Nullable R visitAssociationClassCallExp(@NonNull org.eclipse.ocl.pivot.AssociationClassCallExp object);
	@Nullable R visitBagType(@NonNull org.eclipse.ocl.pivot.BagType object);
	@Nullable R visitBehavior(@NonNull org.eclipse.ocl.pivot.Behavior object);
	@Nullable R visitBooleanLiteralExp(@NonNull org.eclipse.ocl.pivot.BooleanLiteralExp object);
	@Nullable R visitCallExp(@NonNull org.eclipse.ocl.pivot.CallExp object);
	@Nullable R visitCallOperationAction(@NonNull org.eclipse.ocl.pivot.CallOperationAction object);
	@Nullable R visitClass(@NonNull org.eclipse.ocl.pivot.Class object);
	@Nullable R visitCollectionItem(@NonNull org.eclipse.ocl.pivot.CollectionItem object);
	@Nullable R visitCollectionLiteralExp(@NonNull org.eclipse.ocl.pivot.CollectionLiteralExp object);
	@Nullable R visitCollectionLiteralPart(@NonNull org.eclipse.ocl.pivot.CollectionLiteralPart object);
	@Nullable R visitCollectionRange(@NonNull org.eclipse.ocl.pivot.CollectionRange object);
	@Nullable R visitCollectionType(@NonNull org.eclipse.ocl.pivot.CollectionType object);
	@Nullable R visitComment(@NonNull org.eclipse.ocl.pivot.Comment object);
	@Nullable R visitCompleteClass(@NonNull org.eclipse.ocl.pivot.CompleteClass object);
	@Nullable R visitCompleteModel(@NonNull org.eclipse.ocl.pivot.CompleteModel object);
	@Nullable R visitCompletePackage(@NonNull org.eclipse.ocl.pivot.CompletePackage object);
	@Nullable R visitConnectionPointReference(@NonNull org.eclipse.ocl.pivot.ConnectionPointReference object);
	@Nullable R visitConstraint(@NonNull org.eclipse.ocl.pivot.Constraint object);
	@Nullable R visitConstructorExp(@NonNull org.eclipse.ocl.pivot.ConstructorExp object);
	@Nullable R visitConstructorPart(@NonNull org.eclipse.ocl.pivot.ConstructorPart object);
	@Nullable R visitDataType(@NonNull org.eclipse.ocl.pivot.DataType object);
	@Nullable R visitDetail(@NonNull org.eclipse.ocl.pivot.Detail object);
	@Nullable R visitDynamicBehavior(@NonNull org.eclipse.ocl.pivot.DynamicBehavior object);
	@Nullable R visitDynamicElement(@NonNull org.eclipse.ocl.pivot.DynamicElement object);
	@Nullable R visitDynamicProperty(@NonNull org.eclipse.ocl.pivot.DynamicProperty object);
	@Nullable R visitDynamicType(@NonNull org.eclipse.ocl.pivot.DynamicType object);
	@Nullable R visitDynamicValueSpecification(@NonNull org.eclipse.ocl.pivot.DynamicValueSpecification object);
	@Nullable R visitElement(@NonNull org.eclipse.ocl.pivot.Element object);
	@Nullable R visitElementExtension(@NonNull org.eclipse.ocl.pivot.ElementExtension object);
	@Nullable R visitEnumLiteralExp(@NonNull org.eclipse.ocl.pivot.EnumLiteralExp object);
	@Nullable R visitEnumeration(@NonNull org.eclipse.ocl.pivot.Enumeration object);
	@Nullable R visitEnumerationLiteral(@NonNull org.eclipse.ocl.pivot.EnumerationLiteral object);
	@Nullable R visitExpressionInOCL(@NonNull org.eclipse.ocl.pivot.ExpressionInOCL object);
	@Nullable R visitFeature(@NonNull org.eclipse.ocl.pivot.Feature object);
	@Nullable R visitFeatureCallExp(@NonNull org.eclipse.ocl.pivot.FeatureCallExp object);
	@Nullable R visitFinalState(@NonNull org.eclipse.ocl.pivot.FinalState object);
	@Nullable R visitIfExp(@NonNull org.eclipse.ocl.pivot.IfExp object);
	@Nullable R visitImport(@NonNull org.eclipse.ocl.pivot.Import object);
	@Nullable R visitInstanceSpecification(@NonNull org.eclipse.ocl.pivot.InstanceSpecification object);
	@Nullable R visitIntegerLiteralExp(@NonNull org.eclipse.ocl.pivot.IntegerLiteralExp object);
	@Nullable R visitInvalidLiteralExp(@NonNull org.eclipse.ocl.pivot.InvalidLiteralExp object);
	@Nullable R visitInvalidType(@NonNull org.eclipse.ocl.pivot.InvalidType object);
	@Nullable R visitIterateExp(@NonNull org.eclipse.ocl.pivot.IterateExp object);
	@Nullable R visitIteration(@NonNull org.eclipse.ocl.pivot.Iteration object);
	@Nullable R visitIteratorExp(@NonNull org.eclipse.ocl.pivot.IteratorExp object);
	@Nullable R visitLambdaType(@NonNull org.eclipse.ocl.pivot.LambdaType object);
	@Nullable R visitLanguageExpression(@NonNull org.eclipse.ocl.pivot.LanguageExpression object);
	@Nullable R visitLetExp(@NonNull org.eclipse.ocl.pivot.LetExp object);
	@Nullable R visitLibrary(@NonNull org.eclipse.ocl.pivot.Library object);
	@Nullable R visitLiteralExp(@NonNull org.eclipse.ocl.pivot.LiteralExp object);
	@Nullable R visitLoopExp(@NonNull org.eclipse.ocl.pivot.LoopExp object);
	@Nullable R visitMessageExp(@NonNull org.eclipse.ocl.pivot.MessageExp object);
	@Nullable R visitMessageType(@NonNull org.eclipse.ocl.pivot.MessageType object);
	@Nullable R visitModel(@NonNull org.eclipse.ocl.pivot.Model object);
	@Nullable R visitNamedElement(@NonNull org.eclipse.ocl.pivot.NamedElement object);
	@Nullable R visitNamespace(@NonNull org.eclipse.ocl.pivot.Namespace object);
	@Nullable R visitNavigationCallExp(@NonNull org.eclipse.ocl.pivot.NavigationCallExp object);
	@Nullable R visitNullLiteralExp(@NonNull org.eclipse.ocl.pivot.NullLiteralExp object);
	@Nullable R visitNumericLiteralExp(@NonNull org.eclipse.ocl.pivot.NumericLiteralExp object);
	@Nullable R visitOCLExpression(@NonNull org.eclipse.ocl.pivot.OCLExpression object);
	@Nullable R visitOperation(@NonNull org.eclipse.ocl.pivot.Operation object);
	@Nullable R visitOperationCallExp(@NonNull org.eclipse.ocl.pivot.OperationCallExp object);
	@Nullable R visitOppositePropertyCallExp(@NonNull org.eclipse.ocl.pivot.OppositePropertyCallExp object);
	@Nullable R visitOrderedSetType(@NonNull org.eclipse.ocl.pivot.OrderedSetType object);
	@Nullable R visitOrphanCompletePackage(@NonNull org.eclipse.ocl.pivot.OrphanCompletePackage object);
	@Nullable R visitPackage(@NonNull org.eclipse.ocl.pivot.Package object);
	@Nullable R visitParameter(@NonNull org.eclipse.ocl.pivot.Parameter object);
	@Nullable R visitPrecedence(@NonNull org.eclipse.ocl.pivot.Precedence object);
	@Nullable R visitPrimitiveCompletePackage(@NonNull org.eclipse.ocl.pivot.PrimitiveCompletePackage object);
	@Nullable R visitPrimitiveLiteralExp(@NonNull org.eclipse.ocl.pivot.PrimitiveLiteralExp object);
	@Nullable R visitPrimitiveType(@NonNull org.eclipse.ocl.pivot.PrimitiveType object);
	@Nullable R visitProfile(@NonNull org.eclipse.ocl.pivot.Profile object);
	@Nullable R visitProfileApplication(@NonNull org.eclipse.ocl.pivot.ProfileApplication object);
	@Nullable R visitProperty(@NonNull org.eclipse.ocl.pivot.Property object);
	@Nullable R visitPropertyCallExp(@NonNull org.eclipse.ocl.pivot.PropertyCallExp object);
	@Nullable R visitPseudostate(@NonNull org.eclipse.ocl.pivot.Pseudostate object);
	@Nullable R visitRealLiteralExp(@NonNull org.eclipse.ocl.pivot.RealLiteralExp object);
	@Nullable R visitRegion(@NonNull org.eclipse.ocl.pivot.Region object);
	@Nullable R visitSelfType(@NonNull org.eclipse.ocl.pivot.SelfType object);
	@Nullable R visitSendSignalAction(@NonNull org.eclipse.ocl.pivot.SendSignalAction object);
	@Nullable R visitSequenceType(@NonNull org.eclipse.ocl.pivot.SequenceType object);
	@Nullable R visitSetType(@NonNull org.eclipse.ocl.pivot.SetType object);
	@Nullable R visitSignal(@NonNull org.eclipse.ocl.pivot.Signal object);
	@Nullable R visitSlot(@NonNull org.eclipse.ocl.pivot.Slot object);
	@Nullable R visitStandardLibrary(@NonNull org.eclipse.ocl.pivot.StandardLibrary object);
	@Nullable R visitState(@NonNull org.eclipse.ocl.pivot.State object);
	@Nullable R visitStateExp(@NonNull org.eclipse.ocl.pivot.StateExp object);
	@Nullable R visitStateMachine(@NonNull org.eclipse.ocl.pivot.StateMachine object);
	@Nullable R visitStereotype(@NonNull org.eclipse.ocl.pivot.Stereotype object);
	@Nullable R visitStringLiteralExp(@NonNull org.eclipse.ocl.pivot.StringLiteralExp object);
	@Nullable R visitTemplateBinding(@NonNull org.eclipse.ocl.pivot.TemplateBinding object);
	@Nullable R visitTemplateParameter(@NonNull org.eclipse.ocl.pivot.TemplateParameter object);
	@Nullable R visitTemplateParameterSubstitution(@NonNull org.eclipse.ocl.pivot.TemplateParameterSubstitution object);
	@Nullable R visitTemplateSignature(@NonNull org.eclipse.ocl.pivot.TemplateSignature object);
	@Nullable R visitTemplateableElement(@NonNull org.eclipse.ocl.pivot.TemplateableElement object);
	@Nullable R visitTransition(@NonNull org.eclipse.ocl.pivot.Transition object);
	@Nullable R visitTrigger(@NonNull org.eclipse.ocl.pivot.Trigger object);
	@Nullable R visitTupleLiteralExp(@NonNull org.eclipse.ocl.pivot.TupleLiteralExp object);
	@Nullable R visitTupleLiteralPart(@NonNull org.eclipse.ocl.pivot.TupleLiteralPart object);
	@Nullable R visitTupleType(@NonNull org.eclipse.ocl.pivot.TupleType object);
	@Nullable R visitType(@NonNull org.eclipse.ocl.pivot.Type object);
	@Nullable R visitTypeExp(@NonNull org.eclipse.ocl.pivot.TypeExp object);
	@Nullable R visitTypeExtension(@NonNull org.eclipse.ocl.pivot.TypeExtension object);
	@Nullable R visitTypedElement(@NonNull org.eclipse.ocl.pivot.TypedElement object);
	@Nullable R visitUnlimitedNaturalLiteralExp(@NonNull org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp object);
	@Nullable R visitUnspecifiedValueExp(@NonNull org.eclipse.ocl.pivot.UnspecifiedValueExp object);
	@Nullable R visitValueSpecification(@NonNull org.eclipse.ocl.pivot.ValueSpecification object);
	@Nullable R visitVariable(@NonNull org.eclipse.ocl.pivot.Variable object);
	@Nullable R visitVariableDeclaration(@NonNull org.eclipse.ocl.pivot.VariableDeclaration object);
	@Nullable R visitVariableExp(@NonNull org.eclipse.ocl.pivot.VariableExp object);
	@Nullable R visitVertex(@NonNull org.eclipse.ocl.pivot.Vertex object);
	@Nullable R visitVoidType(@NonNull org.eclipse.ocl.pivot.VoidType object);
	@Nullable R visitWildcardType(@NonNull org.eclipse.ocl.pivot.WildcardType object);
}
