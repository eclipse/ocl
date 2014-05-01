/*******************************************************************************
 * Copyright (c) 2010,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 388493
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.cs2as;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.FeatureCallExp;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.NavigationCallExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.NumericLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.lookup.AutoILookupResult;
import org.eclipse.ocl.examples.pivot.lookup.AutoLookupKind;
import org.eclipse.ocl.examples.pivot.lookup.NewPivotNameResolver;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.scoping.BaseScopeView;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.attributes.BinaryOperationFilter;
import org.eclipse.ocl.examples.xtext.essentialocl.attributes.ImplicitCollectFilter;
import org.eclipse.ocl.examples.xtext.essentialocl.attributes.ImplicitCollectionFilter;
import org.eclipse.ocl.examples.xtext.essentialocl.attributes.UnaryOperationFilter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IndexExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.AbstractEssentialOCLCSLeft2RightVisitor;

public class EssentialOCLCSLeft2RightVisitor extends AbstractEssentialOCLCSLeft2RightVisitor
{
	private static final class TypeArgumentFilter implements ScopeFilter
	{
		public static TypeArgumentFilter INSTANCE = new TypeArgumentFilter();
		
		public int compareMatches(@NonNull MetaModelManager metaModelManager, @NonNull Object match1, @Nullable Map<TemplateParameter, ParameterableElement> bindings1,
				@NonNull Object match2, @Nullable Map<TemplateParameter, ParameterableElement> bindings2) {
			return 0;
		}

		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			if (object instanceof Type) {
				return true;
			}
			if (object instanceof TypedElement) {
				return ((TypedElement)object).getType() instanceof Metaclass<?>;
			}
			return false;
		}
	}

	      
//	private static final Logger logger = Logger.getLogger(EssentialOCLLeft2RightVisitor.class);

	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull NewPivotNameResolver lResolver;
	
	public EssentialOCLCSLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
		this.metaModelManager = context.getMetaModelManager();
		this.lResolver = new NewPivotNameResolver(metaModelManager); // FIXME factory method
	}

/*	protected OCLExpression zzcheckImplementation(NamedExpCS csNavigatingExp,
			Feature feature, CallExp callExp, OCLExpression expression) {
		LibraryFeature implementation;
		try {
			implementation = metaModelManager.getImplementation(feature);
		} catch (Exception e) {
			return context.addBadExpressionError(csNavigatingExp, "Failed to load '" + feature.getImplementationClass() + "': " + e);
		}
		if (implementation != null) {
			LibraryValidator validator = implementation.getValidator(metaModelManager);
			if (validator != null) {
				Diagnostic diagnostic = validator.validate(metaModelManager, callExp);
				if (diagnostic != null) {
					context.addDiagnostic(csNavigatingExp, diagnostic);
				}
			}
		}
		return expression;
	} */

	protected void checkForInvalidImplicitSourceType(@NonNull ExpCS csInvocationExp) {
		for (ImplicitSourceTypeIterator it = new ImplicitSourceTypeIterator(csInvocationExp); it.hasNext(); ) {
			if (isInvalidType(it.next())) {
				csInvocationExp.setHasError(true);
				break;
			}
		}
	}

	protected ImplicitSourceTypeIterator createImplicitSourceTypeIterator(@NonNull ElementCS csElement) {
		return new ImplicitSourceTypeIterator(csElement);
	}

	protected @NonNull OCLExpression createImplicitSourceVariableExp(@NonNull AbstractNameExpCS csNameExp, Type owningType) {
		VariableDeclaration sourceVariable = owningType != null ? getImplicitSource(csNameExp, owningType) : null;
		if (sourceVariable == null) {
			@SuppressWarnings("unused") VariableDeclaration sourceVariable2 = owningType != null ? getImplicitSource(csNameExp, owningType) : null;
			return context.addBadExpressionError(csNameExp, "No implicit source");
		}
		else {
			return createImplicitVariableExp(sourceVariable);
		}
	}

	protected @NonNull VariableExp createImplicitVariableExp(@NonNull VariableDeclaration variable) {
		VariableExp variableExp = context.refreshModelElement(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, null); // FIXME reuse
		variableExp.setReferredVariable(variable);
		variableExp.setImplicit(true);
		context.setType(variableExp, variable.getType(), variable.isRequired());
		return variableExp;
	}

/*	private TemplateParameterSubstitution findFormalParameter(TemplateParameter formalTemplateParameter, Type actualType) {
		for (TemplateBinding actualTemplateBinding : actualType.getTemplateBinding()) {
			for (TemplateParameterSubstitution actualTemplateParameterSubstitution : actualTemplateBinding.getParameterSubstitution()) {
				TemplateParameter actualFormal = actualTemplateParameterSubstitution.getFormal();
				if (actualFormal == formalTemplateParameter) {
					return actualTemplateParameterSubstitution;
				}
			}
		}
		if (actualType instanceof org.eclipse.ocl.examples.pivot.Class) {
			for (org.eclipse.ocl.examples.pivot.Class superClass : ((org.eclipse.ocl.examples.pivot.Class)actualType).getSuperClass()) {
				TemplateParameterSubstitution actualTemplateParameterSubstitution = findFormalParameter(formalTemplateParameter, superClass);
				if (actualTemplateParameterSubstitution != null) {
					return actualTemplateParameterSubstitution;
				}
			}
		}
		return null;
	} */
	
	protected @Nullable Iteration getBestIteration(@NonNull List<NamedElement> invocations) {
		Iteration bestIteration = null;
		Type bestType = null;
		int bestIteratorsSize = Integer.MAX_VALUE;
		for (NamedElement operation : invocations) {
			if (operation instanceof Iteration) {
				Iteration iteration = (Iteration) operation;
				int iteratorsSize = iteration.getOwnedIterator().size();
				if ((bestIteration == null) || (iteratorsSize <= bestIteratorsSize)) {
					Type specializedType = iteration.getOwningType();
					if (specializedType != null) {
						Type unspecializedType = PivotUtil.getUnspecializedTemplateableElement(specializedType);
						if ((bestType == null) || !metaModelManager.isSuperClassOf(unspecializedType, bestType)) {
							bestIteration = iteration;
							bestType = unspecializedType;
							bestIteratorsSize = iteratorsSize;
						}
					}
				}
			}
		}
		return bestIteration;
	}

	protected @Nullable Operation getExampleOperation(@NonNull List<NamedElement> invocations) {
		if (invocations.size() <= 1) {
			NamedElement namedElement = invocations.get(0);
			return namedElement instanceof Operation ? (Operation)namedElement : null;
		}
		@SuppressWarnings("null")@NonNull EReference aReferredOperation = PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION;
		EnvironmentView environmentView = new EnvironmentView(metaModelManager, aReferredOperation, null);
		environmentView.addElements(invocations);
		environmentView.resolveDuplicates();
		Object content = environmentView.getEntries().iterator().next().getValue();
		if (content instanceof List<?>) {
			content = ((List<?>)content).get(0);
		}
		return (Operation) content;
	}

/*	private TemplateParameter getFormal(List<TemplateBinding> templateBindings, TemplateParameter templateParameter) {
		for (TemplateBinding templateBinding : templateBindings) {
			for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitution()) {
				if (templateParameter == templateParameterSubstitution.getFormal()) {
					return templateParameterSubstitution.getActual().getOwningTemplateParameter();
				}
			}
		}
		return null;
	} */
	
	protected @Nullable List<NamedElement> getInvocations(@Nullable OCLExpression sourceExp, @NonNull InvocationExpCS csInvocationExp) {
		NameExpCS csNameExp = csInvocationExp.getNameExp();
		if (csNameExp == null) {
			return null;
		}
		PathNameCS csPathName = csNameExp.getPathName();
		if (csPathName == null) {
			return null;
		}
		List<PathElementCS> csPathElements = csPathName.getPath();
		if (csPathElements == null) {
			return null;
		}
		int pathSize = csPathElements.size();
		if (pathSize <= 0) {
			return null;
		}
		PathElementCS csLastPathElement = csPathElements.get(pathSize-1);
		if (csLastPathElement == null) {
			return null;
		}
		Element asElement = csLastPathElement.basicGetElement();
		if ((asElement instanceof Operation) && !asElement.eIsProxy()) {
			return Collections.singletonList((NamedElement)asElement);
		}
		String name = ElementUtil.getTextName(csLastPathElement);
		if (name == null) {
			return null;
		}
		int iteratorCount = 0;
		int expressionCount = 0;
		for (NavigatingArgCS csArg : csInvocationExp.getArgument()) {
			if (csArg.getRole() == NavigationRole.ITERATOR) {
				iteratorCount++;
			}
			else if (csArg.getRole() == NavigationRole.EXPRESSION) {
				expressionCount++;
			}
		}
		if (pathSize > 1) {											// Search for B::b() or a.B::b() candidates in B
			Element asScope = csPathElements.get(pathSize - 2).getElement();
			if (!(asScope instanceof Type)) {
				return null;
			}
			Type asType = (Type)asScope;
			List<NamedElement> invocations = getInvocations(asType, name, iteratorCount, expressionCount);
			if ((invocations == null) && name.startsWith("_")) {
				@SuppressWarnings("null")@NonNull String unescapedName = name.substring(1);				// FIXME Compatibility
				invocations = getInvocations(asType, unescapedName, iteratorCount, expressionCount);
			}
			return invocations;
		}
		else if (sourceExp != null) {								// Search for a.b() candidates in type of a
			Type asType = sourceExp.getType();
			if (asType == null) {
				return null;
			}
			if (asType.getOwningTemplateParameter() != null) {
				asType = metaModelManager.getOclAnyType();
			}
			List<NamedElement> invocations = getInvocations(asType, name, iteratorCount, expressionCount);
			if ((invocations == null) && name.startsWith("_")) {
				@SuppressWarnings("null")@NonNull String unescapedName = name.substring(1);				// FIXME Compatibility
				invocations = getInvocations(asType, unescapedName, iteratorCount, expressionCount);
			}
			return invocations;
		}
		else {														// Search for a() candidates in implicit source variable types
			List<NamedElement> invocations = null;
			for (ImplicitSourceTypeIterator it = createImplicitSourceTypeIterator(csInvocationExp); (invocations == null) && it.hasNext(); ) {
				Type asType = it.next();
				invocations = getInvocations(asType, name, iteratorCount, expressionCount);
			}
			if ((invocations == null) && name.startsWith("_")) {
				@SuppressWarnings("null")@NonNull String unescapedName = name.substring(1);				// FIXME Compatibility
				for (ImplicitSourceTypeIterator it = createImplicitSourceTypeIterator(csInvocationExp); (invocations == null) && it.hasNext(); ) {
					Type asType = it.next();
					invocations = getInvocations(asType, unescapedName, iteratorCount, expressionCount);
				}
			}
			return invocations;
		}
	}

	protected @Nullable VariableDeclaration getImplicitSource(@NonNull ModelElementCS csExp, @NonNull Type requiredType) {
		@Nullable VariableDeclaration lastVariable = null;
		for (ImplicitSourceVariableIterator it = new ImplicitSourceVariableIterator(csExp); it.hasNext(); )  {
			@NonNull Variable variable = it.next();
			lastVariable = variable;
			Type type = variable.getType();
			if ((type != null) && type.conformsTo(metaModelManager, requiredType)) {
				return variable;
			}
		}
		return lastVariable;		// If no good variable found, the outermost variable is the least bad.
	}			// FIXME report all possible variables as bad to user

	/**
	 * Return all operations/iterations in asType and its superclasses whose name is name. For iterations the number of iteration iterators must
	 * match iteratorCount unless iteratorCount is zero. For operations the number of parameters must be expressionCount. Returns null if
	 * nothing is found.
	 */
	protected @Nullable List<NamedElement> getInvocations(@NonNull Type asType, @NonNull String name, int iteratorCount, int expressionCount) {
		Iterable<? extends DomainOperation> instanceOperations = metaModelManager.getAllOperations(asType, FeatureFilter.SELECT_NON_STATIC, name);
		List<NamedElement> invocations = getInvocationsInternal(null, instanceOperations, iteratorCount, expressionCount);
		if (asType instanceof ElementExtension) {
			Type asStereotype = ((ElementExtension)asType).getStereotype();
			if (asStereotype != null) {
				Iterable<? extends DomainOperation> stereotypeOperations = metaModelManager.getAllOperations(asStereotype, FeatureFilter.SELECT_NON_STATIC, name);
				invocations = getInvocationsInternal(invocations, stereotypeOperations, iteratorCount, expressionCount);
			}
		}
		if (asType instanceof Metaclass<?>) {
			Type instanceType = ((Metaclass<?>)asType).getInstanceType();
			if (instanceType != null) {
				Iterable<? extends DomainOperation> classOperations = metaModelManager.getAllOperations(instanceType, FeatureFilter.SELECT_STATIC, name);
				invocations = getInvocationsInternal(invocations, classOperations, iteratorCount, expressionCount);
			}
		}
		return invocations;
	}
	protected @Nullable List<NamedElement> getInvocationsInternal(@Nullable List<NamedElement> invocations,
			@NonNull Iterable<? extends DomainOperation> allOperations, int iteratorCount, int expressionCount) {
		for (DomainOperation operation : allOperations) {
			Operation asOperation = null;
			if (operation instanceof Iteration) {
				Iteration candidateIteration = (Iteration) operation;
				int iteratorsSize = candidateIteration.getOwnedIterator().size();
				if ((iteratorCount == 0) || (iteratorCount == iteratorsSize)) {
					asOperation = candidateIteration;
				}
			}
			else if (operation instanceof Operation){
				Operation candidateOperation = (Operation) operation;
				int operationsSize = candidateOperation.getOwnedParameter().size();
				if (expressionCount == operationsSize) {
					asOperation = candidateOperation;
				}
			}
			if (asOperation != null) {
				if (invocations == null) {
					invocations = new ArrayList<NamedElement>();
				}
				invocations.add(asOperation);
			}
		}
		return invocations;
	}

	protected boolean isInvalidType(@Nullable Type type) {
		return (type == null) || (type instanceof InvalidType)
		 || ((type instanceof CollectionType) && (((CollectionType)type).getElementType() instanceof InvalidType));
	}

	protected @NonNull OperationCallExp refreshOperationCallExp(@NonNull InvocationExpCS csInvocationExp, @NonNull OCLExpression sourceExp) {
		OperationCallExp callExp = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csInvocationExp);
		callExp.setSource(sourceExp);			
		return callExp;
	}

	protected @NonNull OppositePropertyCallExp refreshOppositePropertyCallExp(@NonNull NameExpCS csNameExp, @NonNull OCLExpression sourceExp, @NonNull Property property) {
		OppositePropertyCallExp callExp = context.refreshModelElement(OppositePropertyCallExp.class, PivotPackage.Literals.OPPOSITE_PROPERTY_CALL_EXP, csNameExp);
		callExp.setSource(sourceExp);			
		callExp.setReferredProperty(property.getOpposite());
		return callExp;
	}

	protected @NonNull PropertyCallExp refreshPropertyCallExp(@NonNull NameExpCS csNameExp, @NonNull OCLExpression sourceExp, @NonNull Property property) {
		PropertyCallExp callExp = context.refreshModelElement(PropertyCallExp.class, PivotPackage.Literals.PROPERTY_CALL_EXP, csNameExp);
		callExp.setSource(sourceExp);			
		callExp.setReferredProperty(property);
		return callExp;
	}

	protected void resolveAtPre(@Nullable NameExpCS csNameExp, @NonNull FeatureCallExp featureCallExp) {
		if (csNameExp != null) {
			featureCallExp.setIsPre(csNameExp.isAtPre());
		}
	}

	/**
	 * Resolve an invocation such as name() or source.name(...)  or source->name(...) to the best candidate from invocations.
	 * <p>
	 * sourceExp is null for an implicit source invocation.
	 * <p>
	 * csInvocationExp.getNamedElement() must be invoked once, after the left-hand context has been established to enable the lokup to
	 * proceed in a simple (perhaps rivial) fashion.
	 */
	protected @Nullable OCLExpression resolveBestInvocation(@Nullable OCLExpression sourceExp, @NonNull InvocationExpCS csInvocationExp, @NonNull List<NamedElement> invocations) {
		Iteration iteration = getBestIteration(invocations);
		if (iteration != null) {
			if (sourceExp == null) {
				sourceExp = createImplicitSourceVariableExp(csInvocationExp, iteration.getOwningType());
			}
			LoopExp iterationCallExp = resolveIterationCallExp(csInvocationExp, sourceExp, iteration);
			@SuppressWarnings("unused")NamedElement namedElement = csInvocationExp.getNamedElement();	// Now let Xtext find the iteration
			resolveIterationContent(csInvocationExp, iterationCallExp);
			return iterationCallExp;
		}
		else {
			Operation exampleOperation = getExampleOperation(invocations);
			if (exampleOperation != null) {
				if (sourceExp == null) {
					sourceExp = createImplicitSourceVariableExp(csInvocationExp, exampleOperation.getOwningType());
				}
				OperationCallExp operationCallExp = refreshOperationCallExp(csInvocationExp, sourceExp);
				if (invocations.size() == 1) {
					context.setReferredOperation(operationCallExp, exampleOperation);
				}
				//
				//	Need to resolve types for operation arguments in order to disambiguate operation names.
				//
				resolveOperationArgumentTypes(csInvocationExp);
				//
				//	Resolve the static operation/iteration by name and known operation argument types.
				//
				NamedElement namedElement = csInvocationExp.getNamedElement();								// Now let Xtext resolve the operation
				if (namedElement instanceof Operation) {
					return resolveOperationCallExp(csInvocationExp, operationCallExp, (Operation)namedElement);
				}
			}
		}
		return null;
	}

	protected @NonNull EnumLiteralExp resolveEnumLiteral(@NonNull ExpCS csExp, @NonNull EnumerationLiteral enumerationLiteral) {
		EnumLiteralExp expression = context.refreshModelElement(EnumLiteralExp.class, PivotPackage.Literals.ENUM_LITERAL_EXP, csExp);
		context.setType(expression, enumerationLiteral.getEnumeration(), true);
		expression.setReferredEnumLiteral(enumerationLiteral);
		return expression;
	}

	/**
	 * Resolve an invocation such as source.name  or source->name
	 */
	protected @NonNull OCLExpression resolveExplicitSourceNavigation(@NonNull OCLExpression sourceExp, @NonNull NameExpCS csNamedExp) {
		NamedElement namedElement = csNamedExp.getNamedElement();
		if ((namedElement instanceof Property) && !namedElement.eIsProxy()) {
			CallExp callExp = resolvePropertyCallExp(sourceExp, csNamedExp, (Property)namedElement);
			return callExp;
		}
		PropertyCallExp expression = refreshPropertyCallExp(csNamedExp, sourceExp, metaModelManager.getOclInvalidProperty());
		context.setType(expression, metaModelManager.getOclInvalidType(), false);
		return expression;
	}

	protected @NonNull OCLExpression resolveImplicitAsSet(@NonNull OCLExpression sourceExp, @NonNull Type sourceType, @NonNull NavigationOperatorCS csOperator) {
		OperationCallExp expression = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, null);
		expression.setImplicit(true);
		PivotUtil.resetContainer(sourceExp);
		expression.setSource(sourceExp);
		expression.setName("oclAsSet");
		resolveOperationCall(expression, csOperator, new ImplicitCollectionFilter(sourceType));
		return expression;
	}

	/**
	 * Return a non-null implicit collect() call if a sourceExp for a csElement requires an implicit collect.
	 * The return call has noo bosdy or return type since they cannot be synmthesized until the body is synthesized.
	 */
	protected @Nullable IteratorExp resolveImplicitCollectExp(@NonNull OCLExpression sourceExp, @NonNull AbstractNameExpCS csElement) {
		OperatorCS parent = csElement.getParent();
		if (!(parent instanceof NavigationOperatorCS)) {
			return null;
		}
		if (parent.getSource() == csElement) {
			return null;
		}
		NavigationOperatorCS navigationOperatorCS = (NavigationOperatorCS)parent;
		if (!PivotConstants.OBJECT_NAVIGATION_OPERATOR.equals(navigationOperatorCS.getName())) {
			return null;
		}
		Type actualSourceType = sourceExp.getType();
		if (!(actualSourceType instanceof CollectionType)) {
			return null;
		}
		Type elementType = ((CollectionType)actualSourceType).getElementType();
		if (elementType == null) {
			return null;
		}
		IteratorExp implicitCollectExp = context.refreshModelElement(IteratorExp.class, PivotPackage.Literals.ITERATOR_EXP, null);
		implicitCollectExp.setSource(sourceExp);
		implicitCollectExp.setImplicit(true);
		implicitCollectExp.setName("collect");
		AutoILookupResult<Iteration> lResult = lResolver.computeReferredIterationLookup(implicitCollectExp, 
			AutoLookupKind.SINGLE, new ImplicitCollectFilter((CollectionType) actualSourceType, elementType));
		Iteration resolvedIteration = lResult.getSingleResult();
		implicitCollectExp.setName(null); // ASBH FIXME otherwise, test cases fail -> ??????
		if (resolvedIteration == null) {
			return null;
		}
		context.setReferredIteration(implicitCollectExp, resolvedIteration);
		Variable iterator = context.refreshModelElement(Variable.class, PivotPackage.Literals.VARIABLE, null); // FIXME reuse
		Parameter resolvedIterator = resolvedIteration.getOwnedIterator().get(0);
		iterator.setRepresentedParameter(resolvedIterator);
		context.refreshName(iterator, "1_");
		context.setType(iterator, elementType, false);
		iterator.setImplicit(true);
		implicitCollectExp.getIterator().add(iterator);
		return implicitCollectExp;
	}

	/**
	 * Resolve an invocation such as name() or source.name(...)  or source->name(...)
	 */
	protected @NonNull OCLExpression resolveInvocation(@Nullable OCLExpression sourceExp, @NonNull InvocationExpCS csInvocationExp) {
		List<NamedElement> invocations = getInvocations(sourceExp, csInvocationExp);
		if (invocations != null) {
			OCLExpression invocationExp = resolveBestInvocation(sourceExp, csInvocationExp, invocations);
			if (invocationExp != null) {
				return invocationExp;
			}
		}
		else {
			checkForInvalidImplicitSourceType(csInvocationExp);
			csInvocationExp.getNamedElement();													// Now let Xtext register the unresolved operation
		}
		if (sourceExp == null) {
			sourceExp = createImplicitSourceVariableExp(csInvocationExp, metaModelManager.getOclAnyType());
		}
		OperationCallExp operationCallExp = refreshOperationCallExp(csInvocationExp, sourceExp);
		context.setReferredOperation(operationCallExp, metaModelManager.getOclInvalidOperation());
		context.installPivotUsage(csInvocationExp, operationCallExp);		
		context.setType(operationCallExp, metaModelManager.getOclInvalidType(), false);
		return operationCallExp;
	}

	protected void resolveIterationAccumulators(@NonNull InvocationExpCS csInvocationExp, @NonNull LoopExp expression) {
		Iteration iteration = expression.getReferredIteration();
		List<Variable> pivotAccumulators = new ArrayList<Variable>();
		//
		//	Explicit accumulator
		//
		for (NavigatingArgCS csArgument : csInvocationExp.getArgument()) {
			if (csArgument.getRole() != NavigationRole.ACCUMULATOR) {
				continue;
			}
			ExpCS csName = csArgument.getName();
			Variable acc = PivotUtil.getPivot(Variable.class, csName);
			if (acc != null) {
				context.installPivotUsage(csArgument, acc);
				ExpCS csInit = csArgument.getInit();
				if (csInit != null) {
					OCLExpression initExpression = context.visitLeft2Right(OCLExpression.class, csInit);
					acc.setInitExpression(initExpression);
					TypedRefCS csAccType = csArgument.getOwnedType();
					Type initType = initExpression.getType();
					Type accType;
					if (csAccType != null) {
						accType = PivotUtil.getPivot(Type.class, csAccType);
					}
					else {
						accType = initType;
					}
					if (metaModelManager.isUnderspecified(initType)) {
						initExpression.setType(accType);
					}
					context.setType(acc, accType, false);
				}
				acc.setRepresentedParameter(iteration.getOwnedAccumulator().get(pivotAccumulators.size()));
				pivotAccumulators.add(acc);
			}
			if (csArgument.getInit() == null) {
				context.addDiagnostic(csArgument, "Missing initializer for accumulator");
			}
//			if (csArgument.getOwnedType() != null) {
//				context.addError(csArgument, "Unexpected type for parameter");
//			}
		}
		//
		//	Implicit Accumulator
		//
		if (expression instanceof IterateExp) {
			IterateExp iterateExp = (IterateExp)expression;
			if (pivotAccumulators.size() > 1) {
				context.addDiagnostic(csInvocationExp, "Iterate '" + csInvocationExp.getPathName() + "' cannot have more than one accumulator");			
			}
			else {
				iterateExp.setResult(pivotAccumulators.get(0));
			}
		}
		else if (pivotAccumulators.size() > 0) {
			context.addDiagnostic(csInvocationExp, "Iteration '" + csInvocationExp.getPathName() + "' cannot have an accumulator");			
		}
	}

	protected void resolveIterationBody(@NonNull InvocationExpCS csInvocationExp, @NonNull LoopExp expression) {
		List<OCLExpression> pivotBodies = new ArrayList<OCLExpression>();
		for (NavigatingArgCS csArgument : csInvocationExp.getArgument()) {
			if (csArgument.getRole() == NavigationRole.EXPRESSION) {
				if (csArgument.getInit() != null) {
					context.addDiagnostic(csArgument, "Unexpected initializer for expression");
				}
				if (csArgument.getOwnedType() != null) {
					context.addDiagnostic(csArgument, "Unexpected type for expression");
				}
				ExpCS name = csArgument.getName();
				assert name != null;
				OCLExpression exp = context.visitLeft2Right(OCLExpression.class, name);
//				context.installPivotElement(csArgument, exp);
				if (exp != null) {
					context.installPivotUsage(csArgument, exp);
					pivotBodies.add(exp);
				}
				else {
					pivotBodies.add(context.addBadExpressionError(csArgument, "Invalid '" + csInvocationExp.getPathName() + "' iteration body"));
				}
			}
		}
		if (pivotBodies.size() != 1) {
			expression.setBody(context.addBadExpressionError(csInvocationExp, "Iteration '" + csInvocationExp.getPathName() + "' must have exactly one body"));
		}
		else {
			expression.setBody(pivotBodies.get(0));
		}
	}

	protected @NonNull LoopExp resolveIterationCallExp(@NonNull InvocationExpCS csInvocationExp, @NonNull OCLExpression sourceExp, @NonNull Iteration iteration) {
		LoopExp expression;
		if (iteration.getOwnedAccumulator().size() > 0) {
			expression = context.refreshModelElement(IterateExp.class, PivotPackage.Literals.ITERATE_EXP, csInvocationExp);
		}
		else {
			expression = context.refreshModelElement(IteratorExp.class, PivotPackage.Literals.ITERATOR_EXP, csInvocationExp);
		}
		expression.setSource(sourceExp);
		context.setReferredIteration(expression, iteration);
		return expression;
	}

	protected void resolveIterationContent(@NonNull InvocationExpCS csInvocationExp, @NonNull LoopExp expression) {
		OCLExpression source = DomainUtil.nonNullState(expression.getSource());
		resolveIterationIterators(csInvocationExp, source, expression);
		resolveIterationAccumulators(csInvocationExp, expression);
		resolveOperationArgumentTypes(csInvocationExp);
		resolveIterationBody(csInvocationExp, expression);
		resolveOperationReturnType(expression);
	}

	protected void resolveIterationIterators(@NonNull InvocationExpCS csInvocationExp, @NonNull OCLExpression source, @NonNull LoopExp expression) {
		Iteration iteration = expression.getReferredIteration();
		List<Variable> pivotIterators = new ArrayList<Variable>();
		//
		//	Explicit iterators
		//
		int iterationIteratorsSize = iteration.getOwnedIterator().size();
		Type sourceType = ((CollectionType)csInvocationExp.getSourceType()).getElementType();
		Type sourceElementType = sourceType != null ? metaModelManager.getPrimaryType(sourceType) : null;
		for (int argIndex = 0; argIndex < csInvocationExp.getArgument().size(); argIndex++) {
			NavigatingArgCS csArgument = csInvocationExp.getArgument().get(argIndex);
			if (csArgument.getRole() != NavigationRole.ITERATOR) {
				continue;
			}
			if (iterationIteratorsSize <= argIndex) {
				context.addWarning(csArgument, OCLMessages.RedundantIterator_WARNING_, iteration.getName());
				continue;
			}
			if (csArgument.getInit() != null) {
				context.addDiagnostic(csArgument, "Unexpected initializer for iterator");
			}
//			if (csArgument.getOwnedType() == null) {
//				context.addError(csArgument, "Missing type for iterator");
//			}
			ExpCS csName = csArgument.getName();
			Variable iterator = PivotUtil.getPivot(Variable.class, csName);
			if (iterator != null) {
				context.installPivotUsage(csArgument, iterator);
				iterator.setRepresentedParameter(iteration.getOwnedIterator().get(pivotIterators.size()));
				TypedRefCS csType = csArgument.getOwnedType();
				Type varType = csType != null ? PivotUtil.getPivot(Type.class, csType) : sourceElementType;
				if (varType == null) {
					varType = sourceElementType;
				}
				context.setType(iterator, varType, false);
				pivotIterators.add(iterator);
			}
		}
		//
		//	Implicit Iterators
		//
		while (pivotIterators.size() < iterationIteratorsSize) {
			String varName = Integer.toString(pivotIterators.size()+1) + "_";
			Variable iterator = context.refreshModelElement(Variable.class, PivotPackage.Literals.VARIABLE, null);
			context.refreshName(iterator, varName);
			context.setType(iterator, sourceElementType, false);
			iterator.setImplicit(true);
			iterator.setRepresentedParameter(iteration.getOwnedIterator().get(pivotIterators.size()));
			pivotIterators.add(iterator);
		}
		context.refreshList(expression.getIterator(), pivotIterators);
	}

	/**
	 * Determine the type of each operation argument so that the appropriate operation overload can be selected.
	 * Arguments aligned with type (MetaClass) parameters are set to be parsed as types avoiding ambiguities from
	 * implicit opposite properties. Iterator bodies are left unresolved.
	 */
	protected void resolveOperationArgumentTypes(@NonNull InvocationExpCS csInvocationExp) {
		int argIndex = 0;
		for (NavigatingArgCS csArgument : csInvocationExp.getArgument()) {
			if (csArgument.getRole() == NavigationRole.ITERATOR) {
				break;
			}
			else if (csArgument.getRole() == NavigationRole.ACCUMULATOR) {
				break;
			}
			else if (csArgument.getRole() == NavigationRole.EXPRESSION) {
				ExpCS csName = csArgument.getName();
				if (csName != null) {
					if (csName instanceof NameExpCS) {
						PathNameCS csPathName = ((NameExpCS)csName).getPathName();
						if (csPathName != null) {
							Element callExp = csInvocationExp.getPivot();
							if (callExp instanceof OperationCallExp) {
								Operation operation = ((OperationCallExp)callExp).getReferredOperation();
								if (operation != null) {
									List<Parameter> parameters = operation.getOwnedParameter();
									if (argIndex < parameters.size()) {
										Type type = parameters.get(argIndex).getType();
										if (type instanceof Metaclass<?>) {
											CS2Pivot.setElementType(csPathName, PivotPackage.Literals.NAMED_ELEMENT, csName, TypeArgumentFilter.INSTANCE);
										}
									}
								}
							}
						}
					}
					OCLExpression arg = context.visitLeft2Right(OCLExpression.class, csName);
					if (arg != null) {
						context.installPivotUsage(csArgument, arg);
					}
				}
				argIndex++;
			}
		}
	}

	/**
	 * Complete the installation of each operation argument in its operation call.
	 */
	protected void resolveOperationArguments(@NonNull InvocationExpCS csInvocationExp, @NonNull Operation operation, @NonNull OperationCallExp expression) {
		List<OCLExpression> pivotArguments = new ArrayList<OCLExpression>();
		List<NavigatingArgCS> csArguments = csInvocationExp.getArgument();
		List<Parameter> ownedParameters = operation.getOwnedParameter();
		int parametersCount = ownedParameters.size();
		int csArgumentCount = csArguments.size();
		if (csArgumentCount > 0) {
			if (csArguments.get(0).getRole() != NavigationRole.EXPRESSION) {
				context.addDiagnostic(csInvocationExp, "Operation calls can only specify expressions");			
			}
			for (int argIndex = 0; argIndex < csArgumentCount; argIndex++) {
				NavigatingArgCS csArgument = csArguments.get(argIndex);
				if (csArgument.getInit() != null) {
					context.addDiagnostic(csArgument, "Unexpected initializer for expression");
				}
				if (csArgument.getOwnedType() != null) {
					context.addDiagnostic(csArgument, "Unexpected type for expression");
				}
				OCLExpression arg = PivotUtil.getPivot(OCLExpression.class, csArgument);
				if (arg != null) {
					pivotArguments.add(arg);
				}
			}
		}
		if ((csArgumentCount != parametersCount) && (operation != metaModelManager.basicGetOclInvalidOperation())) {
			String boundMessage = DomainUtil.bind(OCLMessages.MismatchedArgumentCount_ERROR_, csArgumentCount, parametersCount);
			context.addDiagnostic(csInvocationExp, boundMessage);			
		}
		context.refreshList(expression.getArgument(), pivotArguments);
	}

	protected void resolveOperationCall(@NonNull OperationCallExp expression, @NonNull OperatorCS csOperator, @NonNull ScopeFilter filter) {
				
		

		// environmentView.addFilter(filter);
		AutoILookupResult<Operation> lResult = lResolver.computeReferredOperationLookup(expression,
			AutoLookupKind.SINGLE, filter);
		if (lResult.getSize() == 1) {
			Operation operation = lResult.getSingleResult();
			context.setReferredOperation(expression, operation);
			resolveOperationReturnType(expression);
		}
		else {
			StringBuilder s = new StringBuilder();
			for (OCLExpression argument : expression.getArgument()) {
				Type argumentType = PivotUtil.getType(argument);
				if (s.length() > 0) {
					s.append(",");
				}
				if (argumentType != null) {
					s.append(argumentType.toString());
				}
			}
			String boundMessage;
			Type sourceType = PivotUtil.getType(expression.getSource());
			if (s.length() > 0) {
				boundMessage = DomainUtil.bind(OCLMessages.UnresolvedOperationCall_ERROR_, csOperator, sourceType, s.toString());
			}
			else {
				boundMessage = DomainUtil.bind(OCLMessages.UnresolvedOperation_ERROR_, csOperator, sourceType);
			}
//			context.addBadExpressionError(csOperator, boundMessage);
			context.addDiagnostic(csOperator, boundMessage);
			context.setReferredOperation(expression, metaModelManager.getOclInvalidOperation());
			context.setType(expression, metaModelManager.getOclInvalidType(), false);
		}
	}

	protected @NonNull OperationCallExp resolveOperationCallExp(@NonNull InvocationExpCS csInvocationExp, @NonNull OperationCallExp operationCallExp, @NonNull Operation operation) {
		context.setReferredOperation(operationCallExp, operation);
		resolveAtPre(csInvocationExp.getNameExp(), operationCallExp);
		context.installPivotUsage(csInvocationExp, operationCallExp);
		resolveOperationArguments(csInvocationExp, operation, operationCallExp);
		resolveOperationReturnType(operationCallExp);
		return operationCallExp;
	}

	protected void resolveOperationReturnType(@NonNull CallExp callExp) {
		Operation operation = null;
		if (callExp instanceof OperationCallExp) {
			operation = ((OperationCallExp)callExp).getReferredOperation();
		}
		else if (callExp instanceof LoopExp) {
			operation = ((LoopExp)callExp).getReferredIteration();
		}
		if (operation == null) {
			return;
		}
		Map<TemplateParameter, ParameterableElement> templateBindings = new HashMap<TemplateParameter, ParameterableElement>();
		Type sourceType = null;
		OCLExpression source = callExp.getSource();
		if (source != null) {
			sourceType = source.getType();
		}
		if (sourceType != null) {
			if (operation.isStatic() && (sourceType instanceof Metaclass<?>)) {
				sourceType = ((Metaclass<?>)sourceType).getInstanceType();
			}
			templateBindings.put(null, sourceType);		// Use the null key to pass OclSelf without creating an object
		}
		PivotUtil.getAllTemplateParameterSubstitutions(templateBindings, sourceType);
//		PivotUtil.getAllTemplateParameterSubstitutions(templateBindings, operation);
		TemplateSignature templateSignature = operation.getOwnedTemplateSignature();
		if (templateSignature != null) {
			for (TemplateParameter templateParameter : templateSignature.getOwnedParameter()) {
				templateBindings.put(templateParameter, null);
			}
		}
		String implementationClass = operation.getImplementationClass();
		if ((implementationClass != null) && implementationClass.equals(CollectionFlattenOperation.class.getName())) {	// FIXME Use Tree(T) to make this modellable
			Type elementType = sourceType;
			while (elementType instanceof CollectionType) {
				elementType = ((CollectionType)elementType).getElementType();
			}
			if (elementType != null) {
				templateBindings.put(operation.getOwnedTemplateSignature().getOwnedParameter().get(0), elementType);
			}
		}
		@SuppressWarnings("unused")		// Should never happen; just for debugging
		boolean isConformant = true;
		if (callExp instanceof OperationCallExp) {
			List<Parameter> parameters = operation.getOwnedParameter();
			List<OCLExpression> arguments = ((OperationCallExp)callExp).getArgument();
			int iMax = Math.min(parameters.size(), arguments.size());
			for (int i = 0; i < iMax; i++) {
				Parameter parameter = parameters.get(i);
				OCLExpression argument = arguments.get(i);
				Type parameterType = PivotUtil.getType(parameter);
				Type argumentType = PivotUtil.getType(argument);
				if ((parameterType != null) && (argumentType != null)) {
					if (!metaModelManager.conformsTo(argumentType, parameterType, templateBindings)) {
						isConformant = false;
					}
				}
			}
		}
		else if (callExp instanceof LoopExp) {
			if (callExp instanceof IterateExp) {
				List<Parameter> accumulators = ((Iteration)operation).getOwnedAccumulator();
				if (accumulators.size() >= 1) {
					Parameter accumulator = accumulators.get(0);
					Variable result = ((IterateExp)callExp).getResult();
					Type accumulatorType = PivotUtil.getType(accumulator);
					Type resultType = PivotUtil.getType(result);
					if ((accumulatorType != null) && (resultType != null)) {
						if (!metaModelManager.conformsTo(resultType, accumulatorType, templateBindings)) {
							isConformant = false;
						}
					}
				}
			}
			List<Parameter> parameters = ((Iteration)operation).getOwnedParameter();
			if (parameters.size() >= 1) {
				Parameter parameter = parameters.get(0);
				OCLExpression body = ((LoopExp)callExp).getBody();
				Type parameterType = PivotUtil.getType(parameter);
				Type bodyType = PivotUtil.getType(body);
				if ((bodyType != null) && (parameterType != null)) {
					if (!metaModelManager.conformsTo(bodyType, parameterType, templateBindings)) {
						isConformant = false;
					}
				}
			}
		}
		Type behavioralType = PivotUtil.getType(operation);
		Type returnType = behavioralType != null ? metaModelManager.getSpecializedType(behavioralType, templateBindings) : null;
		//
		//	The flattening of collect() and consequently implicit-collect is not modelled accurately so we need to code it.
		//
		if ((operation instanceof Iteration) && "collect".equals(operation.getName()) && (callExp instanceof LoopExp) && (returnType instanceof CollectionType)) {
			OCLExpression body = ((LoopExp)callExp).getBody();
			Type bodyType = PivotUtil.getType(body);
			if (bodyType != null) {
				if (bodyType instanceof CollectionType) {
					@NonNull Type elementType = bodyType;
					while (elementType instanceof CollectionType) {
						Type elementType2 = ((CollectionType)elementType).getElementType();
						if (elementType2 != null) {
							elementType = elementType2;
						}
					}
					boolean isOrdered = ((CollectionType)returnType).isOrdered();
					returnType = metaModelManager.getCollectionType(isOrdered, false, elementType, null, null);	// FIXME null, null
				}
			}
		}
		if (operation.isStatic() && (behavioralType != null) && (behavioralType.getOwningTemplateParameter() != null) && (returnType != null)) {
			returnType = metaModelManager.getMetaclass(returnType);
		}
		context.setType(callExp, returnType, operation.isRequired());
	}

	protected @NonNull CallExp resolvePropertyCallExp(@NonNull OCLExpression sourceExp, @NonNull NameExpCS csNameExp, @NonNull Property property) {
		NavigationCallExp callExp;
		if (property.isImplicit()) {
			callExp = refreshOppositePropertyCallExp(csNameExp, sourceExp, property);
		}
		else {
			callExp = refreshPropertyCallExp(csNameExp, sourceExp, property);
		}
//		if (isInvalidType(property.getType())) {
//			EssentialOCLUtils.setHasError(csNameExp);
//		}
		resolveAtPre(csNameExp, callExp);
		Type returnType = resolvePropertyReturnType(sourceExp, csNameExp, property);
		context.setType(callExp, returnType, property.isRequired());
		return callExp;
	}

	protected Type resolvePropertyReturnType(@NonNull OCLExpression sourceExp, @NonNull NameExpCS csNameExp, @NonNull Property property) {
		Map<TemplateParameter, ParameterableElement> templateBindings = new HashMap<TemplateParameter, ParameterableElement>();
		Type sourceType = sourceExp.getType();
		if (sourceType != null) {
			if (property.isStatic() && (sourceType instanceof Metaclass<?>)) {
				sourceType = ((Metaclass<?>)sourceType).getInstanceType();
			}
			templateBindings.put(null, sourceType);		// Use the null key to pass OclSelf without creating an object
			Type owningType = property.getOwningType();
			if (owningType instanceof Metaclass) {
				owningType = PivotUtil.getUnspecializedTemplateableElement(owningType);
				templateBindings.put(owningType.getOwnedTemplateSignature().getOwnedParameter().get(0), sourceType);		// Use the null key to pass OclSelf without creating an object
			}
		}
		PivotUtil.getAllTemplateParameterSubstitutions(templateBindings, sourceType);
		Type returnType = null;
		Type behavioralType = PivotUtil.getType(property);
		if (behavioralType != null) {
			returnType = metaModelManager.getSpecializedType(behavioralType, templateBindings);
			if (property.isStatic() && (behavioralType.getOwningTemplateParameter() != null)) {
				returnType = metaModelManager.getMetaclass(returnType);
			}
		}
		return returnType;
	}

	protected StateExp resolveStateExp(@NonNull ExpCS csExp, @NonNull State state) {
		StateExp expression = context.refreshModelElement(StateExp.class, PivotPackage.Literals.STATE_EXP, csExp);
		context.setType(expression, metaModelManager.getPivotType("State"), true);		// FIXME What should this be
		expression.setReferredState(state);
		return expression;
	}

	protected @NonNull TypeExp resolveTypeExp(@NonNull ExpCS csExp, @NonNull Type type) {
		TypeExp expression = context.refreshModelElement(TypeExp.class, PivotPackage.Literals.TYPE_EXP, csExp);
		context.setType(expression, metaModelManager.getMetaclass(type), true);
		expression.setReferredType(type);
		return expression;
	}

	protected @NonNull VariableExp resolveVariableExp(@NonNull AbstractNameExpCS csNameExp, @NonNull VariableDeclaration variableDeclaration) {
		VariableExp expression = context.refreshModelElement(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, csNameExp);
		expression.setReferredVariable(variableDeclaration);
		context.setType(expression, variableDeclaration.getType(), variableDeclaration.isRequired());
		return expression;
	}
	  
	@Override
	public @NonNull Element visitBinaryOperatorCS(@NonNull BinaryOperatorCS csOperator) {
		OperationCallExp expression = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csOperator);
		String name = csOperator.getName();
		assert name != null;
		context.refreshName(expression, name);
		ExpCS csSource = csOperator.getSource();
		if (csSource != null) {
			OCLExpression source = context.visitLeft2Right(OCLExpression.class, csSource);
			expression.setSource(source);
			ExpCS csArgument = csOperator.getArgument();
			if (csArgument != null) {
				OCLExpression argument = context.visitLeft2Right(OCLExpression.class, csArgument);
				List<? extends OCLExpression> newElements = argument != null ? Collections.singletonList(argument) : Collections.<OCLExpression>emptyList();
				context.refreshList(expression.getArgument(), newElements);
				Type sourceType = PivotUtil.getType(source);
				Type argumentType = PivotUtil.getType(argument);
				if ((sourceType != null) && (argumentType != null)) {
					resolveOperationCall(expression, csOperator, new BinaryOperationFilter(sourceType, argumentType));
				}
			}
		}
		return expression;
	}

	@Override
	public Element visitBooleanLiteralExpCS(@NonNull BooleanLiteralExpCS csBooleanLiteralExp) {
		BooleanLiteralExp expression = PivotUtil.getPivot(BooleanLiteralExp.class, csBooleanLiteralExp);
		if (expression != null) {
			expression.setBooleanSymbol(Boolean.valueOf(csBooleanLiteralExp.getName()));
			context.setType(expression, metaModelManager.getBooleanType(), true);
		}
		return expression;
	}

	@Override
	public Element visitCollectionLiteralExpCS(@NonNull CollectionLiteralExpCS csCollectionLiteralExp) {
		Type commonType = null;
//		InvalidLiteralExp invalidValue = null;
		for (CollectionLiteralPartCS csPart : csCollectionLiteralExp.getOwnedParts()) {
			assert csPart != null;
			CollectionLiteralPart pivotPart = context.visitLeft2Right(CollectionLiteralPart.class, csPart);
			Type type = pivotPart.getType();
//			if (type instanceof InvalidType) {	// FIXME Use propagated reason via InvalidType
//				if (invalidValue == null) {
//					invalidValue = metaModelManager.createInvalidValue(csPart, null, "Invalid Collection content", null);
//				}
//			}
//			else
			if (type != null) {
				if (commonType == null) {
					commonType = type;
				}
				else if (commonType != type) {
					commonType = metaModelManager.getCommonType(commonType, type, null);
				}
			}
		}
//		if (invalidValue != null) {
//			context.installPivotElement(csCollectionLiteralExp, invalidValue);
//			return invalidValue;
//		}
		CollectionLiteralExp expression = PivotUtil.getPivot(CollectionLiteralExp.class, csCollectionLiteralExp);
		if (expression != null) {
			CollectionTypeCS ownedCollectionType = csCollectionLiteralExp.getOwnedType();
			String collectionTypeName = ownedCollectionType.getName();
			assert collectionTypeName != null;
			TypedRefCS ownedElementType = ownedCollectionType.getOwnedType();
			if (ownedElementType != null) {
				commonType = (Type) ownedElementType.getPivot();
			}
			if (commonType == null) {
				commonType = metaModelManager.createUnspecifiedType();
			}
			Type type = metaModelManager.getCollectionType(collectionTypeName, commonType, null, null);
			context.setType(expression, type, true);
			expression.setKind(PivotUtil.getCollectionKind((CollectionType) type));
		}
		return expression;
	}

	@Override
	public Element visitCollectionLiteralPartCS(@NonNull CollectionLiteralPartCS csCollectionLiteralPart) {
		ExpCS csFirst = csCollectionLiteralPart.getExpressionCS();
		if (csFirst == null) {
			return null;
		}
		OCLExpression pivotFirst = context.visitLeft2Right(OCLExpression.class, csFirst);
		ExpCS csLast = csCollectionLiteralPart.getLastExpressionCS();
		if (csLast == null) {
			CollectionItem expression = PivotUtil.getPivot(CollectionItem.class, csCollectionLiteralPart);	
			if (expression != null) {
				expression.setItem(pivotFirst);
			}
		}
		else {
			CollectionRange expression = PivotUtil.getPivot(CollectionRange.class, csCollectionLiteralPart);
			if (expression != null) {
				expression.setFirst(pivotFirst);
				OCLExpression pivotLast = context.visitLeft2Right(OCLExpression.class, csLast);
				expression.setLast(pivotLast);
			}
		}
		Type type = pivotFirst.getType();
		if (type == null) {
			return null;
		}
		boolean isRequired = pivotFirst.isRequired();
		if (csLast != null) {
			OCLExpression pivotLast = PivotUtil.getPivot(OCLExpression.class, csLast);
			if (pivotLast != null) {
				Type secondType = pivotLast.getType();
				if (secondType != null) {
					type = metaModelManager.getCommonType(type, secondType, null);
				}
				isRequired &= pivotLast.isRequired();
			}
		}
		CollectionLiteralPart expression = PivotUtil.getPivot(CollectionLiteralPart.class, csCollectionLiteralPart);
		if (expression != null) {
			context.setType(expression, type, isRequired);
		}
		return expression;
	}

	@Override
	public Element visitCollectionTypeCS(@NonNull CollectionTypeCS object) {
		return null;
	}

	@Override
	public Element visitConstructorExpCS(@NonNull ConstructorExpCS csConstructorExp) {
		ConstructorExp expression = PivotUtil.getPivot(ConstructorExp.class, csConstructorExp);	
		if (expression != null) {
			expression.setType((Type) csConstructorExp.getNamedElement());
			for (ConstructorPartCS csPart : csConstructorExp.getOwnedParts()) {
				assert csPart != null;
				context.visitLeft2Right(ConstructorPart.class, csPart);
			}
		}
		return expression;
	}

	@Override
	public Element visitConstructorPartCS(@NonNull ConstructorPartCS csConstructorPart) {
		ConstructorPart pivotElement = PivotUtil.getPivot(ConstructorPart.class, csConstructorPart);	
		if (pivotElement != null) {
			Property property = csConstructorPart.getProperty();
			pivotElement.setReferredProperty(property);
			context.refreshName(pivotElement, property.getName());
			context.setType(pivotElement, property.getType(), property.isRequired());
			ExpCS csInitExpression = csConstructorPart.getInitExpression();
			if (csInitExpression != null) {
				OCLExpression initExpression = context.visitLeft2Right(OCLExpression.class, csInitExpression);
				pivotElement.setInitExpression(initExpression);
			}
		}
		return pivotElement;
	}

	@Override
	public Element visitContextCS(@NonNull ContextCS csContext) {
		ExpressionInOCL pivotElement = PivotUtil.getPivot(ExpressionInOCL.class, csContext);
		if (pivotElement != null) {
			pivotElement.getLanguage().clear();
			pivotElement.getBody().clear();
			ExpCS csExpression = csContext.getOwnedExpression();
			if (csExpression != null) {
				pivotElement.getLanguage().add("OCL");
				pivotElement.getBody().add(csExpression.toString());
				OCLExpression expression = context.visitLeft2Right(OCLExpression.class, csExpression);
				if (expression != null) {
					PivotUtil.setBody(pivotElement, expression, ElementUtil.getExpressionText(csExpression));
					context.setType(pivotElement, expression.getType(), expression.isRequired());
				}
			}
		}
		return pivotElement;
	}

	@Override
	public Element visitExpCS(@NonNull ExpCS object) {
		return null;
	}

	@Override
	public Element visitIfExpCS(@NonNull IfExpCS csIfExp) {
		IfExp expression = PivotUtil.getPivot(IfExp.class, csIfExp);
		if (expression != null) {
			ExpCS csIf = csIfExp.getCondition();
			ExpCS csThen = csIfExp.getThenExpression();
			ExpCS csElse = csIfExp.getElseExpression();
			if ((csIf != null) && (csThen != null) && (csElse != null)) {
				expression.setCondition(context.visitLeft2Right(OCLExpression.class, csIf));
				OCLExpression thenExpression = context.visitLeft2Right(OCLExpression.class, csThen);
				expression.setThenExpression(thenExpression);
				OCLExpression elseExpression = context.visitLeft2Right(OCLExpression.class, csElse);
				expression.setElseExpression(elseExpression);
				Type thenType = thenExpression != null ? thenExpression.getType() : null;
				Type elseType = elseExpression != null ? elseExpression.getType() : null;
				Type commonType = (thenType != null) && (elseType != null) ? metaModelManager.getCommonType(thenType, elseType, null) : null;
				boolean isRequired = ((thenExpression != null) && thenExpression.isRequired()) && ((elseExpression != null) && elseExpression.isRequired());
				context.setType(expression, commonType, isRequired);
			}
		}
		return expression;
	}

	@Override
	public Element visitIndexExpCS(@NonNull IndexExpCS csIndexExp) {
		// Navigating completions are orchestrated by the SimpleNamedExpCS.
		return null;
	}

	@Override
	public Element visitInfixExpCS(@NonNull InfixExpCS csInfixExp) {
		//
		//	Find the root.
		//
		OperatorCS csRoot = csInfixExp.getOwnedOperator().get(0);
		for (OperatorCS csParent = csRoot.getParent(); csParent != null; csParent = csParent.getParent()) {
			csRoot = csParent;
		}
		//
		//	Build the corresponding AST and reuse as the Infix node.
		//
		OCLExpression pivot = context.visitLeft2Right(OCLExpression.class, csRoot);		
		if (pivot != null) {
			context.installPivotUsage(csInfixExp, pivot);
		}
		return pivot;
	}

	@Override
	public Element visitInvalidLiteralExpCS(@NonNull InvalidLiteralExpCS csInvalidLiteralExp) {
		InvalidLiteralExp expression = PivotUtil.getPivot(InvalidLiteralExp.class, csInvalidLiteralExp);
		if (expression == null) {
			expression = metaModelManager.createInvalidExpression();
		}
//		expression.setType(metaModelManager.getOclInvalidType());
		context.installPivotUsage(csInvalidLiteralExp, expression);
		return expression;
	}

	/**
	 * Resolve an invocation such as name()
	 */
	@Override
	public Element visitInvocationExpCS(@NonNull InvocationExpCS csInvocationExp) {
		OperatorCS csParent = csInvocationExp.getParent();
		if ((csParent instanceof NavigationOperatorCS) && (csInvocationExp != csParent.getSource())) {
			// source.name(), source->name() are resolved by the parent NavigationOperatorCS
			return PivotUtil.getPivot(OCLExpression.class, csInvocationExp);
		}
		return resolveInvocation(null, csInvocationExp);
	}

	@Override
	public Element visitLetExpCS(@NonNull LetExpCS csLetExp) {
		// Each CS Let Variable becomes a Pivot LetExpression and Variable
		// The CS Let therefore just re-uses the Pivot of the first CS Let Variable
		LetExp firstLetExp = null;
		LetExp lastLetExp = null;
		for (LetVariableCS csLetVariable : csLetExp.getVariable()) {
			Variable variable = PivotUtil.getPivot(Variable.class, csLetVariable);
			if (variable != null) {
				LetExp letExp;
				EObject variableContainer = variable.eContainer();
				if (variableContainer instanceof LetExp) {
					letExp = (LetExp)variableContainer;
				}
				else {
					letExp = context.refreshModelElement(LetExp.class, PivotPackage.Literals.LET_EXP, null); // FIXME reuse
				}
				letExp.setVariable(variable);		
				ExpCS csInitExpression = csLetVariable.getInitExpression();
				if (csInitExpression != null) {
					OCLExpression initExpression = context.visitLeft2Right(OCLExpression.class, csInitExpression);
					variable.setInitExpression(initExpression);
					Type initType = initExpression != null ? initExpression.getType() : null;
					boolean isRequired = variable.isRequired() && (initExpression != null) && initExpression.isRequired();
					TypedRefCS csVariableType = csLetVariable.getOwnedType();
					Type variableType = csVariableType != null ? PivotUtil.getPivot(Type.class, csVariableType) : null;
					if (variableType == null) {
						variableType = initType;
					}
					else if ((initExpression != null) && metaModelManager.isUnderspecified(initType)) {
						initExpression.setType(variableType);
					}
					context.setType(variable, variableType, isRequired);
					if (lastLetExp != null) {
						lastLetExp.setIn(letExp);
						context.installPivotUsage(csLetExp, letExp);
					}
					else {
						firstLetExp = letExp;
						context.installPivotUsage(csLetExp, firstLetExp);
					}
					lastLetExp = letExp;
				}
			}
		}
		if (lastLetExp != null) {
			ExpCS csIn = csLetExp.getIn();
			if (csIn != null) {
				OCLExpression in = context.visitLeft2Right(OCLExpression.class, csIn);
				lastLetExp.setIn(in);
				if (in != null) {
					Type type = in.getType();
					for (OCLExpression letExp = firstLetExp; (letExp != in) && (letExp != null); letExp = ((LetExp)letExp).getIn()) {
						context.setType(letExp, type, in.isRequired());
					}
				}
			}
		}
		return firstLetExp;
	}

	@Override
	public Element visitLetVariableCS(@NonNull LetVariableCS csLetVariable) {
		return null;	// Handled by parent
	}

	@Override
	public Element visitNameExpCS(@NonNull NameExpCS csNameExp) {
		checkForInvalidImplicitSourceType(csNameExp);
		Element element = csNameExp.getNamedElement();
		if ((element == null) || element.eIsProxy()) {
			Element pivot = csNameExp.getPivot();
			if (pivot instanceof InvalidLiteralExp) {
				return pivot;
			}
			InvalidLiteralExp invalidLiteralExp = metaModelManager.createInvalidExpression();
			context.installPivotUsage(csNameExp, invalidLiteralExp);
			return invalidLiteralExp;
		}
		else if (element instanceof VariableDeclaration) {
			return resolveVariableExp(csNameExp, (VariableDeclaration)element);
		}
		else if (element instanceof Property) {
			Property property = (Property) element;
			OCLExpression sourceExp = createImplicitSourceVariableExp(csNameExp, property.getOwningType());
			return resolvePropertyCallExp(sourceExp, csNameExp, property);
		}
		else if (element instanceof Operation) {
			return context.addBadExpressionError(csNameExp, "No parameters for operation " + ((Operation)element).getName());
		}
		else if (element instanceof Type) {
			return resolveTypeExp(csNameExp, (Type) element);
		}
		else if (element instanceof EnumerationLiteral) {
			return resolveEnumLiteral(csNameExp, (EnumerationLiteral) element);
		}
		else if (element instanceof State) {
			return resolveStateExp(csNameExp, (State) element);
		}
		else {
			return context.addBadExpressionError(csNameExp, "Unsupported NameExpCS " + element.eClass().getName());		// FIXME
		}
	}

	@Override
	public Element visitNavigatingArgCS(@NonNull NavigatingArgCS csNavigatingArg) {
		OCLExpression pivot = PivotUtil.getPivot(OCLExpression.class, csNavigatingArg.getName());
		if (pivot != null) {
			context.installPivotUsage(csNavigatingArg, pivot);
		}
		return pivot;
	}

	@Override
	public OCLExpression visitNavigationOperatorCS(@NonNull NavigationOperatorCS csOperator) {
		OCLExpression navigatingExp = null;
		ExpCS csSource = csOperator.getSource();
		if (csSource != null) {
			OCLExpression sourceExp = context.visitLeft2Right(OCLExpression.class, csSource);
			if (sourceExp != null) {
				Type actualSourceType = PivotUtil.getType(sourceExp);
				if (actualSourceType != null) {
					ExpCS argument = csOperator.getArgument();
					if (argument instanceof AbstractNameExpCS) {
						AbstractNameExpCS csNameExp = (AbstractNameExpCS) argument;
						LoopExp implicitCollectExp = null;
						OCLExpression collectedSourceExp = sourceExp;
						//
						//	Condition the source for implicit set or implicit collect
						//
						String navigationOperatorName = csOperator.getName();
						if (actualSourceType instanceof CollectionType) {
							if (PivotConstants.OBJECT_NAVIGATION_OPERATOR.equals(navigationOperatorName)) {
								implicitCollectExp = resolveImplicitCollectExp(sourceExp, csNameExp);
								if (implicitCollectExp != null) {
									@SuppressWarnings("null")@NonNull Variable iterator = implicitCollectExp.getIterator().get(0);
									collectedSourceExp = createImplicitVariableExp(iterator);
								}
							}
						}
						else {
							if (PivotConstants.COLLECTION_NAVIGATION_OPERATOR.equals(navigationOperatorName)) {
								collectedSourceExp = resolveImplicitAsSet(sourceExp, actualSourceType, csOperator);
							}
						}
						csNameExp.setSourceType(collectedSourceExp.getType());
						//
						//	Resolve the inner call expression 
						//
						OCLExpression callExp;
						if (csNameExp instanceof InvocationExpCS) {
							callExp = resolveInvocation(collectedSourceExp, (InvocationExpCS) csNameExp);
						}
						else if (argument instanceof NameExpCS) {
							callExp = resolveExplicitSourceNavigation(collectedSourceExp, (NameExpCS) argument);
						}
						else {
							callExp = context.addBadExpressionError(argument, "bad navigation argument");
						}
						//
						//	Complete the wrapping of the inner call expression in an outer implicit collect expression
						//
						if (callExp instanceof CallExp) {
							if (implicitCollectExp != null) {
								implicitCollectExp.setBody(callExp);
								resolveOperationReturnType(implicitCollectExp);
								navigatingExp = implicitCollectExp;
							}
							else {
								navigatingExp = callExp;
							}
						}
						else {
							navigatingExp = callExp;		// Place holder for an error
						}
					}
					else if (argument != null) {
						navigatingExp = context.addBadExpressionError(argument, "bad navigation argument");
					}
				}
			}
			if (navigatingExp != null) {
				context.installPivotUsage(csOperator, navigatingExp);
			}
		}
		return navigatingExp;
	}

	@Override
	public Element visitNestedExpCS(@NonNull NestedExpCS csNestedExp) {
		ExpCS csSource = csNestedExp.getSource();
		if (csSource == null) {
			return null;
		}
		OCLExpression pivot = context.visitLeft2Right(OCLExpression.class, csSource);
		if (pivot != null) {
			context.installPivotUsage(csNestedExp, pivot);
		}
		return pivot;
	}

	@Override
	public Element visitNullLiteralExpCS(@NonNull NullLiteralExpCS csNullLiteralExp) {
		NullLiteralExp expression = PivotUtil.getPivot(NullLiteralExp.class, csNullLiteralExp);
		if (expression != null) {
			context.setType(expression, metaModelManager.getOclVoidType(), false);
		}
		return expression;
	}

	@Override
	public Element visitNumberLiteralExpCS(@NonNull NumberLiteralExpCS csNumberLiteralExp) {
		NumericLiteralExp expression = PivotUtil.getPivot(NumericLiteralExp.class, csNumberLiteralExp);
		if (expression instanceof UnlimitedNaturalLiteralExp) {
			context.setType(expression, metaModelManager.getUnlimitedNaturalType(), true);
		}
		else if (expression instanceof IntegerLiteralExp) {
			context.setType(expression, metaModelManager.getIntegerType(), true);
		}
		else if (expression != null){
			context.setType(expression, metaModelManager.getRealType(), true);
		}
		return expression;
	}

	@Override
	public Element visitOperatorCS(@NonNull OperatorCS object) {
		return null;
	}

	@Override
	public Element visitPrefixExpCS(@NonNull PrefixExpCS csPrefixExp) {
		UnaryOperatorCS csRoot = csPrefixExp.getOwnedOperator().get(0);
		if (csRoot == null) {
			return null;
		}
		if (csPrefixExp.eContainer() instanceof InfixExpCS) {
			// PrefixExpCS embedded in InfixExpCS is resolved as part of the Infix tree;		
		}
		else {
//			initializePrefixOperators(csPrefixExp, null);
			context.visitLeft2Right(OCLExpression.class, csRoot);		
		}
		OCLExpression pivotElement = PivotUtil.getPivot(OCLExpression.class, csRoot);
		if (pivotElement != null) {
			context.installPivotUsage(csPrefixExp, pivotElement);
		}
		return pivotElement;
	}

	@Override
	public Element visitSelfExpCS(@NonNull SelfExpCS csSelfExp) {	// FIXME Just use VariableExpCS
		VariableExp expression = PivotUtil.getPivot(VariableExp.class, csSelfExp);
		if (expression != null) {
			ElementCS parent = csSelfExp.getLogicalParent();
			if (parent != null) {
				@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE;
				EnvironmentView environmentView = new EnvironmentView(metaModelManager, eReference, Environment.SELF_VARIABLE_NAME);
				ScopeView baseScopeView = BaseScopeView.getScopeView(metaModelManager, parent, eReference);
				environmentView.computeLookups(baseScopeView);
				VariableDeclaration variableDeclaration = (VariableDeclaration) environmentView.getContent();
				if (variableDeclaration == null) {
					return context.addBadExpressionError(csSelfExp, "The context of 'self' is unspecified");
				}
				expression.setReferredVariable(variableDeclaration);
				context.setType(expression, variableDeclaration.getType(), true);
			}
		}
		return expression;
	}

	@Override
	public Element visitStringLiteralExpCS(@NonNull StringLiteralExpCS csStringLiteralExp) {
		StringLiteralExp pivotElement = PivotUtil.getPivot(StringLiteralExp.class, csStringLiteralExp);
		if (pivotElement != null) {
			context.setType(pivotElement, metaModelManager.getStringType(), true);
		}
		return pivotElement;
	}

	@Override
	public Element visitTupleLiteralExpCS(@NonNull TupleLiteralExpCS csTupleLiteralExp) {
		TupleLiteralExp expression = PivotUtil.getPivot(TupleLiteralExp.class, csTupleLiteralExp);	
		if (expression != null) {
			for (TupleLiteralPartCS csPart : csTupleLiteralExp.getOwnedParts()) {
				assert csPart != null;
				context.visitLeft2Right(TupleLiteralPart.class, csPart);
			}
			String tupleTypeName = "Tuple"; //ownedCollectionType.getName();
			List<TupleLiteralPart> parts = expression.getPart();
			assert parts != null;
			Type type = metaModelManager.getTupleType(tupleTypeName, parts, null);
			context.setType(expression, type, true);
		}
		return expression;
	}

	@Override
	public Element visitTupleLiteralPartCS(@NonNull TupleLiteralPartCS csTupleLiteralPart) {
		TupleLiteralPart pivotElement = PivotUtil.getPivot(TupleLiteralPart.class, csTupleLiteralPart);	
		if (pivotElement != null) {
			ExpCS csInitExpression = csTupleLiteralPart.getInitExpression();
			if (csInitExpression != null) {
				OCLExpression initExpression = context.visitLeft2Right(OCLExpression.class, csInitExpression);
				pivotElement.setInitExpression(initExpression);
				TypedRefCS csType = csTupleLiteralPart.getOwnedType();
				Type type = csType != null ? PivotUtil.getPivot(Type.class, csType) : initExpression.getType();
				context.setType(pivotElement, type, initExpression.isRequired());
			}
		}
		return pivotElement;
	}

	@Override
	public Element visitTypeLiteralExpCS(@NonNull TypeLiteralExpCS csTypeLiteralExp) {
		TypedRefCS csType = csTypeLiteralExp.getOwnedType();
//		context.visitInOrder(csType, null);
		Type type = PivotUtil.getPivot(Type.class, csType);
		return type != null ? resolveTypeExp(csTypeLiteralExp, type) : null;
	}

	@Override
	public Element visitUnaryOperatorCS(@NonNull UnaryOperatorCS csOperator) {
		OperationCallExp expression = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csOperator);
		String name = csOperator.getName();
		assert name != null;
		context.refreshName(expression, name);
		ExpCS csSource = csOperator.getSource();
		if (csSource != null) {
			OCLExpression source = context.visitLeft2Right(OCLExpression.class, csSource);
			if (source != null) {
				expression.setSource(source);
				Type sourceType = PivotUtil.getType(source);
				if (sourceType != null) {
					resolveOperationCall(expression, csOperator, new UnaryOperationFilter(sourceType));
				}
			}
		}
		return expression;
	}

	@Override
	public Element visitUnlimitedNaturalLiteralExpCS(@NonNull UnlimitedNaturalLiteralExpCS csUnlimitedNaturalLiteralExp) {
		UnlimitedNaturalLiteralExp expression = PivotUtil.getPivot(UnlimitedNaturalLiteralExp.class, csUnlimitedNaturalLiteralExp);
		if (expression != null) {
			context.setType(expression, metaModelManager.getUnlimitedNaturalType(), true);
		}
		return expression;
	}

	@Override
	public Element visitVariableCS(@NonNull VariableCS csVariable) {
		Variable variable = PivotUtil.getPivot(Variable.class, csVariable);
		if (variable != null) {
			OCLExpression initExpression = PivotUtil.getPivot(OCLExpression.class, csVariable.getInitExpression());
			if (initExpression != null) {
				Type initType = initExpression.getType();
				TypedRefCS csType = csVariable.getOwnedType();
				Type type;
				if (csType != null) {
					type = PivotUtil.getPivot(Type.class, csType);
				}
				else {
					type = initType;
					// FIXME deduction is more complex than this
				}
				if (metaModelManager.isUnderspecified(initType)) {
					initExpression.setType(type);
				}
				context.setType(variable, type, initExpression.isRequired());
			}
			variable.setInitExpression(initExpression);
		}
		return variable;
	}	
}
