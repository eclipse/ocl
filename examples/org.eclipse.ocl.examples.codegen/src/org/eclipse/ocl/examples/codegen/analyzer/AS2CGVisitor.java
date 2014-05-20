/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.analyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstant;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOppositePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInteger;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsEqualExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOppositePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGReal;
import org.eclipse.ocl.examples.codegen.cgmodel.CGString;
import org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.IterationHelper;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.ecore.EObjectOperation;
import org.eclipse.ocl.examples.pivot.ecore.EObjectProperty;
import org.eclipse.ocl.examples.pivot.internal.impl.TuplePartImpl;
import org.eclipse.ocl.examples.pivot.library.CompositionProperty;
import org.eclipse.ocl.examples.pivot.library.ConstrainedOperation;
import org.eclipse.ocl.examples.pivot.library.ConstrainedProperty;
import org.eclipse.ocl.examples.pivot.library.EInvokeOperation;
import org.eclipse.ocl.examples.pivot.library.ExplicitNavigationProperty;
import org.eclipse.ocl.examples.pivot.library.ImplicitNonCompositionProperty;
import org.eclipse.ocl.examples.pivot.library.StaticProperty;
import org.eclipse.ocl.examples.pivot.library.StereotypeProperty;
import org.eclipse.ocl.examples.pivot.library.TuplePartProperty;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * The AS2CGVisitor performs the first stage of code generation by converting the Pivot AST to the CG AST.
 */
public class AS2CGVisitor extends AbstractExtendingVisitor<CGNamedElement, CodeGenAnalyzer>
{
	protected final @NonNull CodeGenerator codeGenerator;
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull GenModelHelper genModelHelper;

	protected static class Variables
	{
		private @Nullable Variables outerVariables;
		/*
		 * The AS to CG parameter map assists in construction of ExpressionInOcl before/without an Operation.
		 */
		private final @NonNull Map<Variable, CGParameter> cgParameters = new HashMap<Variable, CGParameter>();

		private @NonNull Map<VariableDeclaration, CGVariable> cgVariables = new HashMap<VariableDeclaration, CGVariable>();
		
		public Variables(@Nullable Variables outerVariables) {
			this.outerVariables = outerVariables;
		}

		public CGVariable getLocalVariable(@NonNull VariableDeclaration asVariable) {
			return cgVariables.get(asVariable);
		}

		public CGParameter getParameter(@NonNull Variable asVariable) {
			CGParameter cgVariable = cgParameters.get(asVariable);
			if (cgVariable != null) {
				return cgVariable;
			}
			else if (outerVariables != null) {
				return outerVariables.getParameter(asVariable);
			}
			else {
				return null;
			}
		}

		public CGVariable getVariable(@NonNull VariableDeclaration asVariable) {
			CGVariable cgVariable = cgVariables.get(asVariable);
			if (cgVariable != null) {
				return cgVariable;
			}
			else if (outerVariables != null) {
				return outerVariables.getVariable(asVariable);
			}
			else {
				return null;
			}
		}

		public void putParameter(@NonNull Variable aParameter, @NonNull CGParameter cgParameter) {
			cgParameters.put(aParameter, cgParameter);
			cgVariables.put(aParameter, cgParameter);
		}

		public void putVariable(@NonNull VariableDeclaration asVariable, @NonNull CGVariable cgVariable) {
			cgVariables.put(asVariable, cgVariable);
		}
	}
	
	/**
	 * Mapping from an AS Variable to a CG Variable, maintained as a stack that is pushed when inline operations are exapanded.
	 */
	private @NonNull Variables variablesStack = new Variables(null);

	private @NonNull Map<OpaqueExpression, ExpressionInOCL> inlinePrototypes = new HashMap<OpaqueExpression, ExpressionInOCL>();
	
	public AS2CGVisitor(@NonNull CodeGenAnalyzer analyzer) {
		super(analyzer);
		codeGenerator = context.getCodeGenerator();
		metaModelManager = codeGenerator.getMetaModelManager();
		genModelHelper = codeGenerator.getGenModelHelper();
	}

	protected void addParameter(@NonNull Variable aParameter, @NonNull CGParameter cgParameter) {
		variablesStack.putParameter(aParameter, cgParameter);
	}

	public @Nullable CGVariable basicGetParameter(@NonNull Variable aParameter) {
		return variablesStack.getParameter(aParameter);
	}

/*	public @NonNull CGParameter createCGParameter(@NonNull VariableDeclaration asVariable) {
		CGParameter cgParameter = CGModelFactory.eINSTANCE.createCGParameter();
		setPivot(cgParameter, asVariable);
		cgParameter.setTypeId(context.getTypeId(TypeId.OCL_VOID));			// FIXME Java-specific
		return cgParameter;
	} */

	public @NonNull CGVariable createCGVariable(@NonNull Variable asVariable) {
		CGVariable cgVariable = variablesStack.getVariable(asVariable);
		if (cgVariable == null) {
			CGFinalVariable cgVariable2 = CGModelFactory.eINSTANCE.createCGFinalVariable();
			cgVariable = cgVariable2;
			variablesStack.putVariable(asVariable, cgVariable);
		}
		else {
			assert cgVariable.eContainer() == null;
		}
		setAst(cgVariable, asVariable);
//		cgVariable.setInit(doVisit(CGValuedElement.class, asVariable.getInitExpression()));
		return cgVariable;
	}

	protected CGVariable createCGVariable(@NonNull Variable contextVariable, @NonNull OCLExpression source) {
		CGVariable cgVariable = createCGVariable(contextVariable);
		cgVariable.setInit((CGValuedElement) source.accept(this));
		return cgVariable;
	}

	public @NonNull <T extends CGElement> T doVisit(@NonNull Class<T> requiredClass, @Nullable Element pElement) {
		if (pElement == null) {
			throw new NullPointerException("null source for mapping to " + requiredClass.getName());
		}
		CGNamedElement cgElement = pElement.accept(this);
		if (cgElement == null) {
			throw new NullPointerException("null result of mapping to " + requiredClass.getName());
		}
		Class<? extends CGNamedElement> actualClass = cgElement.getClass();
		if (!requiredClass.isAssignableFrom(actualClass)) {
			throw new ClassCastException("cannot cast " + actualClass.getName() + " result of mapping to " + requiredClass.getName());
		}
		@SuppressWarnings("unchecked") T cgElement2 = (T) cgElement;
		return cgElement2;
	}

	public @NonNull CodeGenAnalyzer getAnalyzer() {
		return context;
	}

	public @NonNull CGIterator getIterator(@NonNull VariableDeclaration asVariable) {
		CGParameter cgParameter = (CGParameter) variablesStack.getVariable(asVariable);
		if (cgParameter == null) {
			cgParameter = CGModelFactory.eINSTANCE.createCGIterator();
			setAst(cgParameter, asVariable);
			cgParameter.setTypeId(context.getTypeId(TypeId.OCL_VOID));			// FIXME Java-specific
			variablesStack.putVariable(asVariable, cgParameter);
		}
		return (CGIterator) cgParameter;
	}

	public @NonNull CGVariable getLocalVariable(@NonNull VariableDeclaration asVariable) {
		CGVariable cgVariable = variablesStack.getLocalVariable(asVariable);
		if (cgVariable == null) {
			cgVariable = CGModelFactory.eINSTANCE.createCGFinalVariable();
			setAst(cgVariable, asVariable);
			variablesStack.putVariable(asVariable, cgVariable);
		}
		return cgVariable;
	}

	public @NonNull CGParameter getParameter(@NonNull Variable aParameter) {
		CGParameter cgParameter = variablesStack.getParameter(aParameter);
		if (cgParameter == null) {
			cgParameter = CGModelFactory.eINSTANCE.createCGParameter();
			context.setNames(cgParameter, aParameter);
			setAst(cgParameter, aParameter);
			cgParameter.setTypeId(context.getTypeId(TypeId.OCL_VOID));			// FIXME Java-specific
			addParameter(aParameter, cgParameter);
			cgParameter.setRequired(aParameter.isRequired());
			if (aParameter.isRequired()) {
				cgParameter.setNonNull();
			}
		}
		return cgParameter;
	}

	public @NonNull CGParameter getSelfParameter(@NonNull Variable aParameter) {
		return getParameter(aParameter);
	}

	public @NonNull CGVariable getVariable(@NonNull VariableDeclaration asVariable) {
		CGVariable cgVariable = variablesStack.getVariable(asVariable);
		if (cgVariable == null) {
			cgVariable = CGModelFactory.eINSTANCE.createCGFinalVariable();
			setAst(cgVariable, asVariable);
			variablesStack.putVariable(asVariable, cgVariable);
		}
		return cgVariable;
	}

	public @NonNull Variables getVariablesStack() {
		return variablesStack;
	}

	protected @Nullable CGValuedElement inlineOperationCall(@NonNull OperationCallExp callExp, @NonNull OpaqueExpression bodyExpression) {
		ExpressionInOCL prototype = inlinePrototypes.get(bodyExpression);
		if (prototype == null) {
			try {
				prototype = PivotUtil.getExpressionInOCL(callExp, bodyExpression);
			}
			catch (Exception e) {
				// FIXME log error
				e.printStackTrace();
			}
			if (prototype == null) {
				return null;
			}
			inlinePrototypes.put(bodyExpression, prototype);
		}
		variablesStack = new Variables(variablesStack);
		try {
			Variable contextVariable = DomainUtil.nonNullModel(prototype.getContextVariable());
			CGVariable cgContextVariable = getLocalVariable(contextVariable);
			OCLExpression source = callExp.getSource();
			CGValuedElement cgSource = doVisit(CGValuedElement.class, source);
			cgContextVariable.setInit(cgSource);
			cgSource.setName(cgContextVariable.getName());
//			cgSource.setValueName(cgContextVariable.getName());
			List<OCLExpression> arguments = callExp.getArgument();
			List<Variable> parameterVariables = prototype.getParameterVariable();
			int iMax = Math.min(arguments.size(), parameterVariables.size());
			for (int i = 0; i < iMax; i++) {
				OCLExpression argument = arguments.get(i);
				CGValuedElement cgArgument = doVisit(CGValuedElement.class, argument);
				@SuppressWarnings("null")@NonNull Variable parameterVariable = parameterVariables.get(i);
				CGVariable cgParameterVariable = getLocalVariable(parameterVariable);
				cgParameterVariable.setInit(cgArgument);
				cgArgument.setName(cgParameterVariable.getName());
			}
			//
			@NonNull CGLetExp cgOuterLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
			cgOuterLetExp.setInit(cgContextVariable);
			cgOuterLetExp.setAst(callExp);
			CGLetExp cgInnerLetExp = cgOuterLetExp;
			for (int i = iMax-1; i >= 0; i--) {
				@SuppressWarnings("null")@NonNull Variable parameterVariable = parameterVariables.get(i);
				CGVariable cgParameterVariable = getVariable(parameterVariable);
				@NonNull CGLetExp cgLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
				cgLetExp.setInit(cgParameterVariable);
				cgLetExp.setAst(callExp);
				cgInnerLetExp.setIn(cgLetExp);
				cgInnerLetExp = cgLetExp;
			}
			CGValuedElement cgResult = doVisit(CGValuedElement.class, prototype.getBodyExpression());
			boolean isValidating = callExp.getReferredOperation().isValidating();
			if (!isValidating) {
				for (int i = iMax-1; i >= 0; i--) {
					@SuppressWarnings("null")@NonNull Variable parameterVariable = parameterVariables.get(i);
					CGVariable cgParameterVariable = getVariable(parameterVariable);
					CGValuedElement cgArgument = cgParameterVariable.getInit();
					if (!cgArgument.isNonInvalid()) {
						@NonNull CGThrowExp cgThrowExp = CGModelFactory.eINSTANCE.createCGThrowExp();
						cgThrowExp.setTypeId(cgResult.getTypeId());
						cgThrowExp.setAst(cgResult.getAst());
						cgThrowExp.setSource(cgArgument);
						cgResult = cgThrowExp;
					}
				}
			}
			cgInnerLetExp.setIn(cgResult);
			for (CGValuedElement cgLetExp = cgOuterLetExp; cgLetExp != cgResult; cgLetExp = ((CGLetExp) cgLetExp).getIn()) {
				cgLetExp.setTypeId(cgResult.getTypeId());
			}
			return cgOuterLetExp;
		}
		finally {
			Variables outerVariables = variablesStack.outerVariables;
			if (outerVariables != null) {
				variablesStack = outerVariables;
			}
		}
	}

	protected boolean isEcoreProperty(@NonNull LibraryProperty libraryProperty) {
		return (libraryProperty instanceof ExplicitNavigationProperty)
			|| (libraryProperty instanceof CompositionProperty)
			|| (libraryProperty instanceof ImplicitNonCompositionProperty)		// FIXME surely this isn't Ecore
			|| (libraryProperty instanceof StaticProperty)
			|| (libraryProperty instanceof StereotypeProperty)
			|| (libraryProperty instanceof ConstrainedProperty)
			|| (libraryProperty instanceof EObjectProperty);
	}

	protected void setAst(@NonNull CGNamedElement cgElement, @NonNull NamedElement asElement) {
		cgElement.setAst(asElement);
		cgElement.setName(asElement.getName());
	}

	protected void setAst(@NonNull CGTypedElement cgElement, @NonNull TypedElement asElement) {
		cgElement.setAst(asElement);
		TypeId asTypeId = asElement.getTypeId();
		cgElement.setTypeId(context.getTypeId(asTypeId));
		cgElement.setName(asElement.getName());
	}

/*	@Override
	public @Nullable CGElement visitAssociationClassCallExp(@NonNull AssociationClassCallExp element) {
//		CGElement thisAnalysis = context.getCurrentAnalysis();
		return super.visitAssociationClassCallExp(element);
	} */

	@Override
	public @Nullable CGConstantExp visitBooleanLiteralExp(@NonNull BooleanLiteralExp element) {
		CGConstant constant = context.getBoolean(element.isBooleanSymbol());
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, constant);
		setAst(cgLiteralExp, element);
		return cgLiteralExp;
	}

	@Override
	public @Nullable CGClass visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class element) {
		CGClass cgClass = CGModelFactory.eINSTANCE.createCGClass();
		setAst(cgClass, element);
		for (Constraint asConstraint : element.getOwnedInvariant()) {
			CGConstraint cgConstraint = doVisit(CGConstraint.class, asConstraint);
			cgClass.getInvariants().add(cgConstraint);
		}
		for (Operation asOperation : element.getOwnedOperation()) {
			CGOperation cgOperation = doVisit(CGOperation.class, asOperation);
			cgClass.getOperations().add(cgOperation);
		}
		for (Property asProperty : element.getOwnedAttribute()) {
			CGProperty cgProperty = doVisit(CGProperty.class, asProperty);
			cgClass.getProperties().add(cgProperty);
		}
		return cgClass;
	}

	@Override
	public @Nullable CGCollectionPart visitCollectionItem(@NonNull CollectionItem element) {
		CGCollectionPart cgCollectionPart = CGModelFactory.eINSTANCE.createCGCollectionPart();
		setAst(cgCollectionPart, element);
		cgCollectionPart.setFirst(doVisit(CGValuedElement.class, element.getItem()));
		return cgCollectionPart;
	} 

	@Override
	public @Nullable CGCollectionExp visitCollectionLiteralExp(@NonNull CollectionLiteralExp element) {
		CGCollectionExp cgCollectionExp = CGModelFactory.eINSTANCE.createCGCollectionExp();
		setAst(cgCollectionExp, element);
		cgCollectionExp.setName(element.getKind().getName());
		List<CGCollectionPart> cgParts = cgCollectionExp.getParts();
		for (CollectionLiteralPart asPart : element.getPart()) {
			cgParts.add((CGCollectionPart) asPart.accept(this));
		}
		context.getTypeId(element.getTypeId());
		return cgCollectionExp;
	}

	@Override
	public @Nullable CGCollectionPart visitCollectionRange(@NonNull CollectionRange element) {
		CGCollectionPart cgCollectionPart = CGModelFactory.eINSTANCE.createCGCollectionPart();
		setAst(cgCollectionPart, element);
		cgCollectionPart.setFirst(doVisit(CGValuedElement.class, element.getFirst()));
		cgCollectionPart.setLast(doVisit(CGValuedElement.class, element.getLast()));
		cgCollectionPart.setTypeId(context.getTypeId(TypeId.INTEGER_RANGE));
		return cgCollectionPart;
	}

	@Override
	public @Nullable CGConstraint visitConstraint(@NonNull Constraint element) {
		CGConstraint cgConstraint = CGModelFactory.eINSTANCE.createCGConstraint();
		setAst(cgConstraint, element);
		OpaqueExpression specification = element.getSpecification();
		if (specification != null) {
			ExpressionInOCL expressionInOCL = PivotUtil.getExpressionInOCL(element, specification);
			if (expressionInOCL != null) {
				Variable contextVariable = expressionInOCL.getContextVariable();
				if (contextVariable != null) {
					CGParameter cgParameter = getSelfParameter(contextVariable);
					cgConstraint.getParameters().add(cgParameter);
				}
				for (@SuppressWarnings("null")@NonNull Variable parameterVariable : expressionInOCL.getParameterVariable()) {
					CGParameter cgParameter = getParameter(parameterVariable);
					cgConstraint.getParameters().add(cgParameter);
				}
				cgConstraint.setBody(doVisit(CGValuedElement.class, expressionInOCL.getBodyExpression()));
			}
		}
		return cgConstraint;
	}

	@Override
	public @Nullable CGConstructorExp visitConstructorExp(@NonNull ConstructorExp element) {
		CGConstructorExp cgConstructorExp = null;
		Type type = element.getType();
		if (type != null) {
			EObject eTarget = type.getETarget();
			if (eTarget instanceof EDataType) {
				CGEcoreDataTypeConstructorExp cgEConstructorExp = CGModelFactory.eINSTANCE.createCGEcoreDataTypeConstructorExp();
				cgEConstructorExp.setEDataType((EDataType)eTarget);
				cgEConstructorExp.setString(element.getValue());
				cgConstructorExp = cgEConstructorExp;
			}
			else if (eTarget instanceof EClass) {
				CGEcoreClassConstructorExp cgEConstructorExp = CGModelFactory.eINSTANCE.createCGEcoreClassConstructorExp();
				cgEConstructorExp.setEClass((EClass)eTarget);
				cgConstructorExp = cgEConstructorExp;
			}
		}
		if (cgConstructorExp != null) {
			CGExecutorType cgExecutorType = context.createExecutorType(DomainUtil.nonNullState(element.getType()));
			cgConstructorExp.setExecutorType(cgExecutorType);
			cgConstructorExp.getOwns().add(cgExecutorType);
			setAst(cgConstructorExp, element);
//			context.setNames(cgConstructorExp, element);
			List<CGConstructorPart> cgParts = cgConstructorExp.getParts();
			for (ConstructorPart asPart : element.getPart()) {
				cgParts.add((CGConstructorPart) asPart.accept(this));
			}
		}
		return cgConstructorExp;
	}

	@Override
	public @Nullable CGConstructorPart visitConstructorPart(@NonNull ConstructorPart element) {
		CGConstructorPart cgConstructorPart = CGModelFactory.eINSTANCE.createCGConstructorPart();
		setAst(cgConstructorPart, element);
		cgConstructorPart.setInit(doVisit(CGValuedElement.class, element.getInitExpression()));
		Property referredProperty = element.getReferredProperty();
		if (referredProperty != null) {
			CGExecutorConstructorPart cgExecutorConstructorPart = context.createExecutorConstructorPart(referredProperty);
			cgConstructorPart.setExecutorPart(cgExecutorConstructorPart);
		}
		return cgConstructorPart;
	}

	@Override
	public @Nullable CGConstantExp visitEnumLiteralExp(@NonNull EnumLiteralExp element) {
//		CGConstant constant = context.getEnumerationLiteral(element.getReferredEnumLiteral());
		CGConstant constant = context.getElementId(element.getReferredEnumLiteral().getEnumerationLiteralId());
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, constant);
		setAst(cgLiteralExp, element);
		return cgLiteralExp;
	}

	@Override
	public @NonNull CGValuedElement visitExpressionInOCL(@NonNull ExpressionInOCL element) {
		Variable contextVariable = element.getContextVariable();
		if (contextVariable != null) {
			CGVariable cgContext = getParameter(contextVariable);
			cgContext.setNonInvalid();
//			cgContext.setNonNull();
		}
		for (@SuppressWarnings("null")@NonNull Variable parameterVariable : element.getParameterVariable()) {
			@SuppressWarnings("unused") CGVariable cgParameter = getParameter(parameterVariable);
		}
		CGValuedElement cgBody = doVisit(CGValuedElement.class, element.getBodyExpression());
//		cgOperation.getDependsOn().add(cgBody);
		return cgBody;
	}

	@Override
	public @NonNull CGIfExp visitIfExp(@NonNull IfExp element) {
		CGIfExp cgIfExp = CGModelFactory.eINSTANCE.createCGIfExp();
		setAst(cgIfExp, element);
		CGValuedElement cgCondition = doVisit(CGValuedElement.class, element.getCondition());
		CGValuedElement cgThenExpression = doVisit(CGValuedElement.class, element.getThenExpression());
		CGValuedElement cgElseExpression = doVisit(CGValuedElement.class, element.getElseExpression());
		cgIfExp.setCondition(cgCondition);
		cgIfExp.setThenExpression(cgThenExpression);
		cgIfExp.setElseExpression(cgElseExpression);
//		cgIfExp.getDependsOn().add(cgCondition);
//		cgIfExp.getDependsOn().add(cgThenExpression);
//		cgIfExp.getDependsOn().add(cgElseExpression);
		return cgIfExp;
	}

	@Override
	public @Nullable CGConstantExp visitIntegerLiteralExp(@NonNull IntegerLiteralExp element) {
		Number integerSymbol = element.getIntegerSymbol();
		CGInteger constant = context.getInteger(integerSymbol != null ? integerSymbol : 0);
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, constant);
		setAst(cgLiteralExp, element);
		return cgLiteralExp;
	}

	@Override
	public @Nullable CGConstantExp visitInvalidLiteralExp(@NonNull InvalidLiteralExp element) {
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, context.getInvalid());
		setAst(cgLiteralExp, element);
		return cgLiteralExp;
	}

	@Override
	public @NonNull CGIterationCallExp visitIterateExp(@NonNull IterateExp element) {
		Iteration asIteration = element.getReferredIteration();
		CGValuedElement cgSource = doVisit(CGValuedElement.class, element.getSource());
		LibraryIteration libraryIteration = (LibraryIteration) asIteration.getImplementation();
		IterationHelper iterationHelper = codeGenerator.getIterationHelper(asIteration);
		if (iterationHelper != null) {
			CGBuiltInIterationCallExp cgBuiltInIterationCallExp = CGModelFactory.eINSTANCE.createCGBuiltInIterationCallExp();
			cgBuiltInIterationCallExp.setReferredIteration(asIteration);
			cgBuiltInIterationCallExp.setSource(cgSource);
			for (@SuppressWarnings("null")@NonNull Variable iterator : element.getIterator()) {
				CGIterator cgIterator = getIterator(iterator);
				cgIterator.setTypeId(context.getTypeId(iterator.getTypeId()));
				cgIterator.setRequired(iterator.isRequired());
				if (iterator.isRequired()) {
					cgIterator.setNonNull();
				}
				cgIterator.setNonInvalid();
				cgBuiltInIterationCallExp.getIterators().add(cgIterator);
			}
			if (asIteration.getOwnedParameter().get(0).isRequired()) {
				cgBuiltInIterationCallExp.getBody().setRequired(true);
			}
			cgBuiltInIterationCallExp.setInvalidating(false);
			cgBuiltInIterationCallExp.setValidating(false);
//			cgBuiltInIterationCallExp.setNonNull();
			setAst(cgBuiltInIterationCallExp, element);
			@SuppressWarnings("null")@NonNull Variable accumulator = element.getResult();
			CGIterator cgAccumulator = getIterator(accumulator);
			cgAccumulator.setTypeId(context.getTypeId(accumulator.getTypeId()));
			cgAccumulator.setRequired(accumulator.isRequired());
			if (accumulator.isRequired()) {
				cgAccumulator.setNonNull();
			}
			cgAccumulator.setInit(doVisit(CGValuedElement.class, accumulator.getInitExpression()));
			cgAccumulator.setNonInvalid();
			cgBuiltInIterationCallExp.setAccumulator(cgAccumulator);
			cgBuiltInIterationCallExp.setBody(doVisit(CGValuedElement.class, element.getBody()));
/*			CGTypeId cgAccumulatorId = iterationHelper.getAccumulatorTypeId(context, cgBuiltInIterationCallExp);
			if (cgAccumulatorId != null) {
				CGIterator cgAccumulator = CGModelFactory.eINSTANCE.createCGIterator();
				cgAccumulator.setName("accumulator");
				cgAccumulator.setTypeId(cgAccumulatorId);
//				cgAccumulator.setRequired(true);
				cgAccumulator.setNonNull();
				cgAccumulator.setNonInvalid();
				cgBuiltInIterationCallExp.setAccumulator(cgAccumulator);
//				variablesStack.putVariable(asVariable, cgAccumulator);
//				cgAccumulator.setNonInvalid();
			} */
			return cgBuiltInIterationCallExp;
		}
		CGLibraryIterateCallExp cgLibraryIterateCallExp = CGModelFactory.eINSTANCE.createCGLibraryIterateCallExp();
		cgLibraryIterateCallExp.setLibraryIteration(libraryIteration);
		cgLibraryIterateCallExp.setReferredIteration(asIteration);
		setAst(cgLibraryIterateCallExp, element);
		cgLibraryIterateCallExp.setInvalidating(asIteration.isInvalidating());
		cgLibraryIterateCallExp.setValidating(asIteration.isValidating());
		cgLibraryIterateCallExp.setSource(cgSource);
		for (@SuppressWarnings("null")@NonNull Variable iterator : element.getIterator()) {
			cgLibraryIterateCallExp.getIterators().add(getIterator(iterator));
		}
		Variable result = element.getResult();
		if (result != null) {
			CGIterator cgResult = getIterator(result);
			cgLibraryIterateCallExp.setResult(cgResult);
			CGValuedElement cgInitExpression = doVisit(CGValuedElement.class, result.getInitExpression());
			cgResult.setInit(cgInitExpression);
		}
		cgLibraryIterateCallExp.setBody(doVisit(CGValuedElement.class, element.getBody()));
		cgLibraryIterateCallExp.setRequired(asIteration.isRequired());
//		cgIterationCallExp.setOperation(getOperation(element.getReferredOperation()));
		return cgLibraryIterateCallExp;
	}

	@Override
	public @NonNull CGIterationCallExp visitIteratorExp(@NonNull IteratorExp element) {
		Iteration asIteration = element.getReferredIteration();
		CGValuedElement cgSource = doVisit(CGValuedElement.class, element.getSource());
		LibraryIteration libraryIteration = (LibraryIteration) asIteration.getImplementation();
		IterationHelper iterationHelper = codeGenerator.getIterationHelper(asIteration);
		if (iterationHelper != null) {
			CGBuiltInIterationCallExp cgBuiltInIterationCallExp = CGModelFactory.eINSTANCE.createCGBuiltInIterationCallExp();
			cgBuiltInIterationCallExp.setReferredIteration(asIteration);
			cgBuiltInIterationCallExp.setSource(cgSource);
			for (@SuppressWarnings("null")@NonNull Variable iterator : element.getIterator()) {
				CGIterator cgIterator = getIterator(iterator);
				cgIterator.setTypeId(context.getTypeId(iterator.getTypeId()));
				cgIterator.setRequired(iterator.isRequired());
				if (iterator.isRequired()) {
					cgIterator.setNonNull();
				}
				cgBuiltInIterationCallExp.getIterators().add(cgIterator);
			}
			cgBuiltInIterationCallExp.setInvalidating(false);
			cgBuiltInIterationCallExp.setValidating(false);
//			cgBuiltInIterationCallExp.setNonNull();
			setAst(cgBuiltInIterationCallExp, element);
			CGTypeId cgAccumulatorId = iterationHelper.getAccumulatorTypeId(context, cgBuiltInIterationCallExp);
			if (cgAccumulatorId != null) {
				CGAccumulator cgAccumulator = CGModelFactory.eINSTANCE.createCGAccumulator();
				cgAccumulator.setName("accumulator");
				cgAccumulator.setTypeId(cgAccumulatorId);
//				cgAccumulator.setRequired(true);
				if (asIteration.isRequired() || element.getBody().isRequired()) {
					cgAccumulator.setNonNull();
					cgBuiltInIterationCallExp.setNonNull();
				}
				if (!asIteration.isValidating()) {
					cgAccumulator.setNonInvalid();
				}
				cgBuiltInIterationCallExp.setAccumulator(cgAccumulator);
//				variablesStack.putVariable(asVariable, cgAccumulator);
//				cgAccumulator.setNonInvalid();
			}
			cgBuiltInIterationCallExp.setBody(doVisit(CGValuedElement.class, element.getBody()));
			if (asIteration.getOwnedParameter().get(0).isRequired()) {
				cgBuiltInIterationCallExp.getBody().setRequired(true);
			}
			cgBuiltInIterationCallExp.setRequired(asIteration.isRequired());
			return cgBuiltInIterationCallExp;
		}
		CGLibraryIterationCallExp cgLibraryIterationCallExp = CGModelFactory.eINSTANCE.createCGLibraryIterationCallExp();
		cgLibraryIterationCallExp.setLibraryIteration(libraryIteration);
		cgLibraryIterationCallExp.setReferredIteration(asIteration);
		setAst(cgLibraryIterationCallExp, element);
		cgLibraryIterationCallExp.setInvalidating(asIteration.isInvalidating());
		cgLibraryIterationCallExp.setValidating(asIteration.isValidating());
		cgLibraryIterationCallExp.setSource(cgSource);
		for (@SuppressWarnings("null")@NonNull Variable iterator : element.getIterator()) {
			cgLibraryIterationCallExp.getIterators().add(getIterator(iterator));
		}
		cgLibraryIterationCallExp.setBody(doVisit(CGValuedElement.class, element.getBody()));
		cgLibraryIterationCallExp.setRequired(asIteration.isRequired());
//		cgIterationCallExp.setOperation(getOperation(element.getReferredOperation()));
		return cgLibraryIterationCallExp;
	}

	@Override
	public @Nullable CGLetExp visitLetExp(@NonNull LetExp element) {
		CGLetExp cgLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
		setAst(cgLetExp, element);
		Variable variable = element.getVariable();
		CGValuedElement initExpression = doVisit(CGValuedElement.class, variable.getInitExpression());
		initExpression.setName(variable.getName());
		CGFinalVariable cgVariable = (CGFinalVariable) createCGVariable(variable);		// FIXME Lose cast
		cgVariable.setInit(initExpression);
//		initExpression.setVariableValue(cgVariable);
//		variables.put(variable, cgVariable);
		cgLetExp.setInit(cgVariable);
		cgLetExp.setIn(doVisit(CGValuedElement.class, element.getIn()));
		return cgLetExp;
	}

/*	@Override
	public @Nullable CGElement visitMessageExp(@NonNull MessageExp element) {
//		CGElement thisAnalysis = context.getCurrentAnalysis();
		return super.visitMessageExp(element);
	} */

	@Override
	public @Nullable CGConstantExp visitNullLiteralExp(@NonNull NullLiteralExp element) {
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, context.getNull());
		setAst(cgLiteralExp, element);
		return cgLiteralExp;
	}

	@Override
	public @Nullable CGOperation visitOperation(@NonNull Operation element) {
		CGOperation cgOperation = null;
		LibraryOperation libraryOperation = metaModelManager.getImplementation(element);
		if (libraryOperation instanceof EObjectOperation) {
			EOperation eOperation = (EOperation) element.getETarget();
			if (eOperation != null) {
				CGEcoreOperation cgEcoreOperation = CGModelFactory.eINSTANCE.createCGEcoreOperation();
				cgEcoreOperation.setEOperation(eOperation);
				cgOperation = cgEcoreOperation;
			}
		}
		if (cgOperation == null) {
			cgOperation = CGModelFactory.eINSTANCE.createCGLibraryOperation();
		}
		setAst(cgOperation, element);
		cgOperation.setRequired(element.isRequired());
		OpaqueExpression specification = element.getBodyExpression();
		if (specification != null) {
			ExpressionInOCL expressionInOCL = PivotUtil.getExpressionInOCL(element, specification);
			if (expressionInOCL != null) {
				Variable contextVariable = expressionInOCL.getContextVariable();
				if (contextVariable != null) {
					CGParameter cgParameter = getSelfParameter(contextVariable);
					cgOperation.getParameters().add(cgParameter);
				}
				for (@SuppressWarnings("null")@NonNull Variable parameterVariable : expressionInOCL.getParameterVariable()) {
					CGParameter cgParameter = getParameter(parameterVariable);
					cgOperation.getParameters().add(cgParameter);
				}
				cgOperation.setBody(doVisit(CGValuedElement.class, expressionInOCL.getBodyExpression()));
			}
		}
		return cgOperation;
	}

	@Override
	public @NonNull CGValuedElement visitOperationCallExp(@NonNull OperationCallExp element) {
		Operation asOperation = DomainUtil.nonNullState(element.getReferredOperation());
		OCLExpression pSource = element.getSource();
		boolean isRequired = asOperation.isRequired();
		CGValuedElement cgSource = pSource != null ? doVisit(CGValuedElement.class, pSource) : null;
		LibraryOperation libraryOperation = metaModelManager.getImplementation(asOperation);
		if (libraryOperation instanceof OclAnyOclIsInvalidOperation) {
			CGIsInvalidExp cgIsInvalidExp = CGModelFactory.eINSTANCE.createCGIsInvalidExp();
			cgIsInvalidExp.setSource(cgSource);
			setAst(cgIsInvalidExp, element);
			cgIsInvalidExp.setInvalidating(false);
			cgIsInvalidExp.setValidating(true);
			return cgIsInvalidExp;
		}
		if (libraryOperation instanceof OclAnyOclIsUndefinedOperation) {
			CGIsUndefinedExp cgIsUndefinedExp = CGModelFactory.eINSTANCE.createCGIsUndefinedExp();
			cgIsUndefinedExp.setSource(cgSource);
			setAst(cgIsUndefinedExp, element);
			cgIsUndefinedExp.setInvalidating(false);
			cgIsUndefinedExp.setValidating(true);
			return cgIsUndefinedExp;
		}
		if (libraryOperation instanceof OclAnyEqualOperation) {
			OCLExpression pArgument = element.getArgument().get(0);
			CGValuedElement cgArgument = pArgument != null ? doVisit(CGValuedElement.class, pArgument) : null;
			CGIsEqualExp cgIsEqualExp = CGModelFactory.eINSTANCE.createCGIsEqualExp();
			cgIsEqualExp.setNotEquals(libraryOperation instanceof OclAnyNotEqualOperation);
			cgIsEqualExp.setSource(cgSource);
			cgIsEqualExp.setArgument(cgArgument);
			setAst(cgIsEqualExp, element);
			cgIsEqualExp.setInvalidating(false);
			cgIsEqualExp.setValidating(true);
			return cgIsEqualExp;
		}
		if ((libraryOperation instanceof ConstrainedOperation) && (pSource != null)) {
			DomainOperation finalOperation = codeGenerator.isFinal(asOperation, DomainUtil.nonNullState(pSource.getType()));
			if (finalOperation != null) {
				OpaqueExpression bodyExpression = asOperation.getBodyExpression();
				if (bodyExpression != null) {
					CGValuedElement cgOperationCallExp = inlineOperationCall(element, bodyExpression);
					if (cgOperationCallExp != null) {
						return cgOperationCallExp;
					}
				}
			}
		}
/*		OpaqueExpression bodyExpression = asOperation.getBodyExpression();
		if (bodyExpression != null) {
			CGValuedElement cgOperationCallExp = inlineOperationCall(element, bodyExpression);
			if (cgOperationCallExp != null) {
				return cgOperationCallExp;
			}
		} */
		CGOperationCallExp cgOperationCallExp = null;
		if (/*(libraryOperation != null) &&*/ !(libraryOperation instanceof EObjectOperation) && !(libraryOperation instanceof EInvokeOperation)) {
			OpaqueExpression bodyExpression = asOperation.getBodyExpression();
			if (bodyExpression != null) {
				CGValuedElement cgOperationCallExp2 = inlineOperationCall(element, bodyExpression);
				if (cgOperationCallExp2 != null) {
					return cgOperationCallExp2;
				}
			}
			CGLibraryOperationCallExp cgLibraryOperationCallExp = CGModelFactory.eINSTANCE.createCGLibraryOperationCallExp();
			cgLibraryOperationCallExp.setLibraryOperation(libraryOperation);
			cgOperationCallExp = cgLibraryOperationCallExp;
		}
		else {		// FIXME proper alternatives
			EOperation eOperation = (EOperation) asOperation.getETarget();
			if (eOperation != null) {
				try {
					genModelHelper.getOperationAccessor(asOperation);
					CGEcoreOperationCallExp cgEcoreOperationCallExp = CGModelFactory.eINSTANCE.createCGEcoreOperationCallExp();
					cgEcoreOperationCallExp.setEOperation(eOperation);
					Boolean ecoreIsRequired = codeGenerator.isNonNull(element);
					if (ecoreIsRequired != null) {
						isRequired = ecoreIsRequired;
					}
					cgOperationCallExp = cgEcoreOperationCallExp;
				} catch (GenModelException e) {}
			}
		}
		if (cgOperationCallExp == null) {
			CGExecutorOperationCallExp cgExecutorOperationCallExp = CGModelFactory.eINSTANCE.createCGExecutorOperationCallExp();
			CGExecutorOperation cgExecutorOperation = context.createExecutorOperation(asOperation);
			cgExecutorOperationCallExp.setExecutorOperation(cgExecutorOperation);
			cgExecutorOperationCallExp.getOwns().add(cgExecutorOperation);
			cgOperationCallExp = cgExecutorOperationCallExp;
		}
		cgOperationCallExp.setReferredOperation(asOperation);
		setAst(cgOperationCallExp, element);
		cgOperationCallExp.setInvalidating(asOperation.isInvalidating());
		cgOperationCallExp.setValidating(asOperation.isValidating());
		cgOperationCallExp.setRequired(isRequired);
		cgOperationCallExp.setSource(cgSource);
//		cgOperationCallExp.getDependsOn().add(cgSource);
		for (OCLExpression pArgument : element.getArgument()) {
			CGValuedElement cgArgument = doVisit(CGValuedElement.class, pArgument);
			cgOperationCallExp.getArguments().add(cgArgument);
//			cgOperationCallExp.getDependsOn().add(cgArgument);
		}
//		cgOperationCallExp.setOperation(getOperation(element.getReferredOperation()));
		return cgOperationCallExp;
	}

	@Override
	public @NonNull CGValuedElement visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp element) {
		Property asOppositeProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		Property asProperty = DomainUtil.nonNullModel(asOppositeProperty.getOpposite());
		boolean isRequired = asProperty.isRequired();
		LibraryProperty libraryProperty = metaModelManager.getImplementation(null, asProperty);
		CGOppositePropertyCallExp cgPropertyCallExp = null;
		if (isEcoreProperty(libraryProperty)) {
			EStructuralFeature eStructuralFeature = (EStructuralFeature) asProperty.getETarget();
			if (eStructuralFeature != null) {
				try {
					genModelHelper.getGetAccessor(eStructuralFeature);
					CGEcoreOppositePropertyCallExp cgEcorePropertyCallExp = CGModelFactory.eINSTANCE.createCGEcoreOppositePropertyCallExp();
					cgEcorePropertyCallExp.setEStructuralFeature(eStructuralFeature);
					Boolean ecoreIsRequired = codeGenerator.isNonNull(asProperty);
					if (ecoreIsRequired != null) {
						isRequired = ecoreIsRequired;
					}
					cgPropertyCallExp = cgEcorePropertyCallExp;
				} catch (GenModelException e) {
				}
			}
		}
		else {
			throw new UnsupportedOperationException();
		}
		if (cgPropertyCallExp == null) {
			CGExecutorOppositePropertyCallExp cgExecutorPropertyCallExp = CGModelFactory.eINSTANCE.createCGExecutorOppositePropertyCallExp();
			CGExecutorProperty cgExecutorProperty = context.createExecutorOppositeProperty(asProperty);
			cgExecutorPropertyCallExp.setExecutorProperty(cgExecutorProperty);
			cgExecutorPropertyCallExp.getOwns().add(cgExecutorProperty);
			cgPropertyCallExp = cgExecutorPropertyCallExp;
		}
		cgPropertyCallExp.setReferredProperty(asProperty);
		setAst(cgPropertyCallExp, element);
		cgPropertyCallExp.setRequired(isRequired);
		CGValuedElement cgSource = doVisit(CGValuedElement.class, element.getSource());
		cgPropertyCallExp.setSource(cgSource);
		return cgPropertyCallExp;
	}

	@Override
	public @Nullable CGPackage visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package element) {
		CGPackage cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		setAst(cgPackage, element);
		for (Type asType : element.getOwnedType()) {
			CGClass cgClass = doVisit(CGClass.class, asType);
			cgPackage.getClasses().add(cgClass);
		}
		return cgPackage;
	}

	@Override
	public @Nullable CGProperty visitProperty(@NonNull Property element) {
		CGProperty cgProperty = CGModelFactory.eINSTANCE.createCGProperty();
		setAst(cgProperty, element);
		cgProperty.setRequired(element.isRequired());
		OpaqueExpression specification = element.getDefaultExpression();
		if (specification != null) {
			ExpressionInOCL expressionInOCL = PivotUtil.getExpressionInOCL(element, specification);
			if (expressionInOCL != null) {
				Variable contextVariable = expressionInOCL.getContextVariable();
				if (contextVariable != null) {
					getSelfParameter(contextVariable);
				}
				cgProperty.setBody(doVisit(CGValuedElement.class, expressionInOCL.getBodyExpression()));
			}
		}
		return cgProperty;
	}

	@Override
	public @NonNull CGValuedElement visitPropertyCallExp(@NonNull PropertyCallExp element) {
		Property asProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		boolean isRequired = asProperty.isRequired();
		LibraryProperty libraryProperty = metaModelManager.getImplementation(null, asProperty);
		CGPropertyCallExp cgPropertyCallExp = null;
		if (isEcoreProperty(libraryProperty)) {
			EStructuralFeature eStructuralFeature = (EStructuralFeature) asProperty.getETarget();
			if (eStructuralFeature != null) {
				try {
					genModelHelper.getGetAccessor(eStructuralFeature);
					CGEcorePropertyCallExp cgEcorePropertyCallExp = CGModelFactory.eINSTANCE.createCGEcorePropertyCallExp();
					cgEcorePropertyCallExp.setEStructuralFeature(eStructuralFeature);
					Boolean ecoreIsRequired = codeGenerator.isNonNull(asProperty);
					if (ecoreIsRequired != null) {
						isRequired = ecoreIsRequired;
					}
					cgPropertyCallExp = cgEcorePropertyCallExp;
				} catch (GenModelException e) {
				}
			}
		}
		else if (libraryProperty instanceof TuplePartProperty) {
			CGTuplePartCallExp cgTuplePartCallExp = CGModelFactory.eINSTANCE.createCGTuplePartCallExp();
			cgTuplePartCallExp.setAstTuplePartId(((TuplePartImpl) asProperty).getTuplePartId());
			cgPropertyCallExp = cgTuplePartCallExp;
		}
		else {
			CGLibraryPropertyCallExp cgLibraryPropertyCallExp = CGModelFactory.eINSTANCE.createCGLibraryPropertyCallExp();
			cgLibraryPropertyCallExp.setLibraryProperty(libraryProperty);
			cgPropertyCallExp = cgLibraryPropertyCallExp;
		}
		if (cgPropertyCallExp == null) {
			CGExecutorPropertyCallExp cgExecutorPropertyCallExp = CGModelFactory.eINSTANCE.createCGExecutorPropertyCallExp();
			CGExecutorProperty cgExecutorProperty = context.createExecutorProperty(asProperty);
			cgExecutorPropertyCallExp.setExecutorProperty(cgExecutorProperty);
			cgExecutorPropertyCallExp.getOwns().add(cgExecutorProperty);
			cgPropertyCallExp = cgExecutorPropertyCallExp;
		}
		cgPropertyCallExp.setReferredProperty(asProperty);
		setAst(cgPropertyCallExp, element);
		cgPropertyCallExp.setRequired(isRequired);
		CGValuedElement cgSource = doVisit(CGValuedElement.class, element.getSource());
		cgPropertyCallExp.setSource(cgSource);
		return cgPropertyCallExp;
	}

	@Override
	public @Nullable CGConstantExp visitRealLiteralExp(@NonNull RealLiteralExp element) {
		Number realSymbol = element.getRealSymbol();
		@SuppressWarnings("null")
		CGReal cgReal = context.getReal(realSymbol != null ? realSymbol : Double.valueOf(0.0));
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, cgReal);
		setAst(cgLiteralExp, element);
		return cgLiteralExp;
	}

	@Override
	public @Nullable CGNamedElement visitStateExp(@NonNull StateExp element) {
//		CGElement thisAnalysis = context.getCurrentAnalysis();
		return super.visitStateExp(element);
	}

	@Override
	public @Nullable CGConstantExp visitStringLiteralExp(@NonNull StringLiteralExp element) {
		String stringSymbol = element.getStringSymbol();
		CGString cgString = context.getString(stringSymbol != null ? stringSymbol : "");
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, cgString);
		return cgLiteralExp;
	}

	@Override
	public @Nullable CGTupleExp visitTupleLiteralExp(@NonNull TupleLiteralExp element) {
		CGTupleExp cgTupleExp = CGModelFactory.eINSTANCE.createCGTupleExp();
		setAst(cgTupleExp, element);
		List<CGTuplePart> cgParts = cgTupleExp.getParts();
		for (TupleLiteralPart asPart : element.getPart()) {
			cgParts.add((CGTuplePart) asPart.accept(this));
		}
		context.getTypeId(element.getTypeId());
		return cgTupleExp;
	}

	@Override
	public @Nullable CGTuplePart visitTupleLiteralPart(@NonNull TupleLiteralPart element) {
		CGTuplePart cgTuplePart = CGModelFactory.eINSTANCE.createCGTuplePart();
		setAst(cgTuplePart, element);
		cgTuplePart.setInit(doVisit(CGValuedElement.class, element.getInitExpression()));
		TuplePartId partId = element.getPartId();
		if (partId != null) {
			context.getElementId(partId);
		}
		return cgTuplePart;
	}

	@Override
	public @Nullable CGTypeExp visitTypeExp(@NonNull TypeExp pTypeExp) {
//		Type referredType = pTypeExp.getReferredType();
		CGTypeExp cgTypeExp = CGModelFactory.eINSTANCE.createCGTypeExp();
//		setPivot(cgTypeExp, pTypeExp);
		cgTypeExp.setAst(pTypeExp);
		CGExecutorType cgExecutorType = context.createExecutorType(DomainUtil.nonNullState(pTypeExp.getReferredType()));
		cgTypeExp.setExecutorType(cgExecutorType);
		cgTypeExp.getOwns().add(cgExecutorType);
//		cgTypeExp.setReferredType(codeGenerator.getGlobalContext().getLocalContext(cgTypeExp).getExecutorType(pTypeExp.getReferredType()));
//		TypeId asTypeId = pTypeExp.getTypeId();
//		cgTypeExp.setTypeId(context.getTypeId(asTypeId)); -- no need to reify the metaclassid
		cgTypeExp.setName(cgExecutorType.getName());
		return cgTypeExp;
	}

	@Override
	public @Nullable CGConstantExp visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp element) {
		Number unlimitedNaturalSymbol = element.getUnlimitedNaturalSymbol();
		CGConstantExp cgLiteralExp;
		if (unlimitedNaturalSymbol instanceof UnlimitedValue) {
			cgLiteralExp = context.createCGConstantExp(element, context.getUnlimited());
		}
		else if (unlimitedNaturalSymbol instanceof Unlimited) {
			cgLiteralExp = context.createCGConstantExp(element, context.getUnlimited());
		}
		else if (unlimitedNaturalSymbol != null) {
			cgLiteralExp = context.createCGConstantExp(element, context.getInteger(unlimitedNaturalSymbol));
		}
		else {
			cgLiteralExp = context.createCGConstantExp(element, context.getInteger(0));
		}
		setAst(cgLiteralExp, element);
		return cgLiteralExp;
	}

	@Override
	public @Nullable CGNamedElement visitUnspecifiedValueExp(@NonNull UnspecifiedValueExp element) {
//		CGElement thisAnalysis = context.getCurrentAnalysis();
		return super.visitUnspecifiedValueExp(element);
	}

	@Override
	public @Nullable CGValuedElement visitVariableExp(@NonNull VariableExp asVariableExp) {
		VariableDeclaration referredVariable = asVariableExp.getReferredVariable();
		CGVariableExp cgVariableExp = CGModelFactory.eINSTANCE.createCGVariableExp();
		setAst(cgVariableExp, asVariableExp);
		if (referredVariable != null) {
			cgVariableExp.setReferredVariable(getVariable(referredVariable));
		}
		return cgVariableExp;
	}

	@Override
	@Nullable
	public CGValuedElement visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}
}
