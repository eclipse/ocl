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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAssertNonNullExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOppositePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsEqualExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNativeOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNavigationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractExtendingCGModelVisitor;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.BoxedDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.UnboxedDescriptor;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.manager.MetaModelManager;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.iterator.IterateIteration;

/**
 * A BoxingAnalyzer performs a bottom up tree-traversal inserting:
 * <p>CGBoxExp or CGUnboxExp whereever a conversion from boxed to unboxed or vice-versa is required.
 * <p>CGCastExp whereever the apparent type is not available (e.g. Parameters passed as Object).
 * <p>CGGuardExp whereever a non-null value is required.
 * <p>
 * No attempt at optimisation is made, since this can be performed by Common SubExpression Elimination.
 * <p>
 * <h2>Simple (both boxed and unboxed)</h2>
 * Boolean, String, null, EObject (except Types)
 * <h2>Boxed/Unboxed</h2>
 * IntegerValue/Number, RealValue/Number, TypeValue/EObject, InvalidValue/Exception, CollectionValue/List
 * <h2>Boxed</h2>
 * TupleValue
 * <h2>Boxed Protocol</h2>
 * Executor/Library Iteration/Operation/PropertyCall
 * <h2>Unboxed Protocol</h2>
 * Ecore Operation/PropertyCall
 */
public class BoxingAnalyzer extends AbstractExtendingCGModelVisitor<Object, CodeGenAnalyzer>
{
	protected final @NonNull CodeGenerator codeGenerator;
	
	public BoxingAnalyzer(@NonNull CodeGenAnalyzer analyzer) {
		super(analyzer);
		codeGenerator = analyzer.getCodeGenerator();
	}

	protected boolean hasOclVoidOperation(@NonNull OperationId operationId) {
		MetaModelManager metaModelManager = codeGenerator.getMetaModelManager();
		CompleteClass completeClass = metaModelManager.getCompleteClass(metaModelManager.getStandardLibrary().getOclVoidType());
		Operation memberOperation = completeClass.getOperation(operationId);
		if (memberOperation == null) {
			return false;
		}
		org.eclipse.ocl.pivot.Class owningType = memberOperation.getOwningClass();
		if (owningType == null) {
			return false;
		}
		CompleteClass owningCompleteClass = metaModelManager.getCompleteClass(owningType);
		return completeClass == owningCompleteClass;
	}

	/**
	 * Insert a CGAssertNonNullExp around cgChild.
	 */
	protected @Nullable CGValuedElement rewriteAsAssertNonNulled(@Nullable CGValuedElement cgChild) {
		if ((cgChild == null) || cgChild.isNonNull() /*|| (cgParent instanceof CGGuardExp)*/) {
			return cgChild;
		}
		CGAssertNonNullExp cgAssertExp = CGModelFactory.eINSTANCE.createCGAssertNonNullExp();
		CGUtils.wrap(cgAssertExp, cgChild);
		return cgAssertExp;
	}

	/**
	 * Insert a CGBoxExp around cgChild.
	 */
	protected CGValuedElement rewriteAsBoxed(@Nullable CGValuedElement cgChild) {
		if ((cgChild == null) || cgChild.isBoxed()) {
			return cgChild;
		}
		CGTypeId cgTypeId = cgChild.getTypeId();
		ElementId elementId = cgTypeId.getElementId();
		if (elementId != null) {
			BoxedDescriptor boxedTypeDescriptor = codeGenerator.getBoxedDescriptor(elementId);
			UnboxedDescriptor unboxedTypeDescriptor = boxedTypeDescriptor.getUnboxedDescriptor();
			if (boxedTypeDescriptor == unboxedTypeDescriptor) {
				return cgChild;
			}
		}
		CGBoxExp cgBoxExp = CGModelFactory.eINSTANCE.createCGBoxExp();
		CGUtils.wrap(cgBoxExp, cgChild);
		return cgBoxExp;
	}

	/**
	 * Insert a CGGuardExp around cgChild.
	 */
	protected @Nullable CGValuedElement rewriteAsGuarded(@Nullable CGValuedElement cgChild, @NonNull String message) {
		if ((cgChild == null) || cgChild.isNonNull() /*|| (cgParent instanceof CGGuardExp)*/) {
			return cgChild;
		}
		CGGuardExp cgGuardExp = CGModelFactory.eINSTANCE.createCGGuardExp();
		cgGuardExp.setMessage(message);
		CGUtils.wrap(cgGuardExp, cgChild);
		return cgGuardExp;
	}

	/**
	 * Insert a CGCastExp around cgChild.
	 */
	protected CGValuedElement rewriteAsCast(@Nullable CGVariableExp cgChild) {
		if (cgChild == null) {
			return cgChild;
		}
		CGCastExp cgCastExp = CGModelFactory.eINSTANCE.createCGCastExp();
		CGUtils.wrap(cgCastExp, cgChild);
		TypedElement pivot = (TypedElement) cgChild.getAst();
		Type asType = pivot.getType();
		cgCastExp.setAst(pivot);
		if (asType != null) {
			CGExecutorType cgExecutorType = context.createExecutorType(asType);
			cgCastExp.setExecutorType(cgExecutorType);
		}
		cgCastExp.setTypeId(codeGenerator.getAnalyzer().getTypeId(pivot.getTypeId()));
		return cgCastExp;
	}

	/**
	 * Insert a CGUnboxExp around cgChild.
	 */
	protected CGValuedElement rewriteAsUnboxed(@Nullable CGValuedElement cgChild) {
		if ((cgChild == null) || cgChild.isUnboxed()) {
			return cgChild;
		}
		CGTypeId cgTypeId = cgChild.getTypeId();
		ElementId elementId = cgTypeId.getElementId();
		if (elementId != null) {
//			boolean maybePrimitive = codeGenerator.maybePrimitive(cgChild);
//			TypeDescriptor boxedTypeDescriptor = codeGenerator.getTypeDescriptor(elementId, true, maybePrimitive);
//			TypeDescriptor unboxedTypeDescriptor = codeGenerator.getTypeDescriptor(elementId, false, maybePrimitive);
			TypeDescriptor boxedTypeDescriptor = codeGenerator.getBoxedDescriptor(elementId);
			TypeDescriptor unboxedTypeDescriptor = boxedTypeDescriptor.getUnboxedDescriptor();
			if (boxedTypeDescriptor == unboxedTypeDescriptor) {
				return cgChild;
			}
		}
		CGUnboxExp cgUnboxExp = CGModelFactory.eINSTANCE.createCGUnboxExp();
		CGUtils.wrap(cgUnboxExp, cgChild);
		return cgUnboxExp;
	}

	@Override
	@Nullable
	public Object visiting(@NonNull CGElement visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public @Nullable Object visitCGBuiltInIterationCallExp(@NonNull CGBuiltInIterationCallExp cgElement) {
		super.visitCGBuiltInIterationCallExp(cgElement);
		rewriteAsBoxed(rewriteAsGuarded(cgElement.getSource(), "source for '" + cgElement.getReferredIteration() + "'"));
		CGValuedElement cgBody = cgElement.getBody();
		if (cgBody.isRequired()) {
			rewriteAsBoxed(rewriteAsGuarded(cgBody, "body for '" + cgElement.getReferredIteration() + "'"));
		}
		else {
			rewriteAsBoxed(cgBody);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGConstructorPart(@NonNull CGConstructorPart cgConstructorPart) {
		rewriteAsUnboxed(cgConstructorPart.getInit());
		return super.visitCGConstructorPart(cgConstructorPart);
	}

	@Override
	public @Nullable Object visitCGEcoreOperation(@NonNull CGEcoreOperation cgElement) {
		super.visitCGEcoreOperation(cgElement);
		CGValuedElement body = cgElement.getBody();
		if (body != null) {
			rewriteAsUnboxed(body);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGEcoreOperationCallExp(@NonNull CGEcoreOperationCallExp cgElement) {
		super.visitCGEcoreOperationCallExp(cgElement);
		CGValuedElement cgSource = cgElement.getSource();
		rewriteAsGuarded(cgSource, "source for '" + cgElement.getReferredOperation() + "'");
		rewriteAsUnboxed(cgSource);
		List<CGValuedElement> cgArguments = cgElement.getArguments();
		int iMax = cgArguments.size();
		for (int i = 0; i < iMax; i++) {			// Avoid CME from rewrite
			rewriteAsUnboxed(cgArguments.get(i));
		}
		if (cgElement.getEOperation().isMany()) {
			rewriteAsAssertNonNulled(cgElement);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGEcoreOppositePropertyCallExp(@NonNull CGEcoreOppositePropertyCallExp cgElement) {
		super.visitCGEcoreOppositePropertyCallExp(cgElement);
		if (cgElement.getEStructuralFeature().isMany()) {
			rewriteAsAssertNonNulled(cgElement);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGEcorePropertyCallExp(@NonNull CGEcorePropertyCallExp cgElement) {
		super.visitCGEcorePropertyCallExp(cgElement);
		if (cgElement.getEStructuralFeature().isMany()) {
			rewriteAsAssertNonNulled(cgElement);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorOppositePropertyCallExp(@NonNull CGExecutorOppositePropertyCallExp cgElement) {
		super.visitCGExecutorOppositePropertyCallExp(cgElement);
		rewriteAsUnboxed(cgElement.getSource());
		CGTypedElement cgParent = (CGTypedElement) cgElement.getParent();
		if (cgParent != null) {
			rewriteAsBoxed(cgElement);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorPropertyCallExp(@NonNull CGExecutorPropertyCallExp cgElement) {
		super.visitCGExecutorPropertyCallExp(cgElement);
		rewriteAsUnboxed(cgElement.getSource());
		CGTypedElement cgParent = (CGTypedElement) cgElement.getParent();
		if (cgParent != null) {
			rewriteAsBoxed(cgElement);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGElement(@NonNull CGElement cgElement) {
		for (@SuppressWarnings("null")@NonNull CGElement cgChild : cgElement.getChildren()) {
			cgChild.accept(this);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGIfExp(@NonNull CGIfExp cgElement) {
		super.visitCGIfExp(cgElement);
		rewriteAsGuarded(cgElement.getCondition(), "if condition");
		CGValuedElement thenExpression = cgElement.getThenExpression();
		CGValuedElement elseExpression = cgElement.getElseExpression();
		if ((thenExpression != null) && (elseExpression != null)) {
			boolean thenIsBoxed = thenExpression.isBoxed();
			boolean elseIsBoxed = elseExpression.isBoxed();
			if (thenIsBoxed != elseIsBoxed) {
				if (thenIsBoxed) {
					rewriteAsBoxed(cgElement.getElseExpression());
				}
				else {
					rewriteAsBoxed(cgElement.getThenExpression());
				}
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGIsEqualExp(@NonNull CGIsEqualExp cgElement) {
		super.visitCGIsEqualExp(cgElement);
		CGValuedElement cgSource = cgElement.getSource();
		CGValuedElement cgArgument = cgElement.getArgument();
		boolean sourceIsBoxed = cgSource.isBoxed();
		boolean argumentIsBoxed = cgArgument.isBoxed();
		if (sourceIsBoxed != argumentIsBoxed) {				// FIXME also needs-boxing
			if (!sourceIsBoxed) {
				rewriteAsBoxed(cgSource);
			}
			if (!argumentIsBoxed) {
				rewriteAsBoxed(cgArgument);
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGLibraryIterateCallExp(@NonNull CGLibraryIterateCallExp cgElement) {
		super.visitCGLibraryIterateCallExp(cgElement);
		rewriteAsGuarded(cgElement.getSource(), "source for '" + cgElement.getReferredIteration() + "'");
		rewriteAsBoxed(cgElement.getSource());
		LibraryIteration libraryIteration = cgElement.getLibraryIteration();
		if (!(libraryIteration instanceof IterateIteration)) {
			rewriteAsBoxed(cgElement.getBody());
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGLibraryIterationCallExp(@NonNull CGLibraryIterationCallExp cgElement) {
		super.visitCGLibraryIterationCallExp(cgElement);
		rewriteAsGuarded(cgElement.getSource(), "source for '" + cgElement.getReferredIteration() + "'");
		rewriteAsBoxed(cgElement.getSource());
		LibraryIteration libraryIteration = cgElement.getLibraryIteration();
		if (!(libraryIteration instanceof IterateIteration)) {
			rewriteAsBoxed(cgElement.getBody());
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGLibraryOperationCallExp(@NonNull CGLibraryOperationCallExp cgElement) {
		super.visitCGLibraryOperationCallExp(cgElement);
//		if (!cgElement.getReferredOperation().isValidating()) {
//			OperationId operationId = cgElement.getReferredOperation().getOperationId();
//			if (!hasOclVoidOperation(operationId)) {
//				guard(cgElement, cgElement.getSource());
//			}
//		}
		rewriteAsBoxed(cgElement.getSource());
		List<CGValuedElement> cgArguments = cgElement.getArguments();
		int iMax = cgArguments.size();
		for (int i = 0; i < iMax; i++) {			// Avoid CME from rewrite
			rewriteAsBoxed(cgArguments.get(i));
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGNativeOperationCallExp(@NonNull CGNativeOperationCallExp cgElement) {
		super.visitCGNativeOperationCallExp(cgElement);
		CGValuedElement cgSource = cgElement.getSource();
		rewriteAsGuarded(cgSource, "source for '" + cgElement.getReferredOperation() + "'");
		rewriteAsUnboxed(cgSource);
		List<CGValuedElement> cgArguments = cgElement.getArguments();
		int iMax = cgArguments.size();
		for (int i = 0; i < iMax; i++) {			// Avoid CME from rewrite
			rewriteAsUnboxed(cgArguments.get(i));
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGNavigationCallExp(@NonNull CGNavigationCallExp cgElement) {
		super.visitCGNavigationCallExp(cgElement);
		rewriteAsGuarded(cgElement.getSource(), "source for '" + cgElement.getReferredProperty() + "'");
		return null;
	}

	@Override
	public @Nullable Object visitCGOperation(@NonNull CGOperation cgElement) {
		super.visitCGOperation(cgElement);
//		if ("isAttribute".equals(cgElement.getName())) {
//			System.out.println("visitCGOperation for " + cgElement.getAst().toString());
//		}
		if (cgElement.isRequired()) {
			CGValuedElement body = cgElement.getBody();
			if (body != null) {
				rewriteAsGuarded(body, "body for '" + cgElement.getAst() + "'");
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGProperty(@NonNull CGProperty cgElement) {
		super.visitCGProperty(cgElement);
		if (cgElement.isRequired()) {
			CGValuedElement body = cgElement.getBody();
			if (body != null) {
				rewriteAsGuarded(body, "body for '" + cgElement.getAst() + "'");
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGVariableExp(@NonNull CGVariableExp cgElement) {
		super.visitCGVariableExp(cgElement);
		CGVariable referredVariable = cgElement.getReferredVariable();
		if (referredVariable instanceof CGIterator) {
			CGIterator cgIterator = (CGIterator)referredVariable;
			EObject cgOperation = cgIterator.eContainer();
			if ((cgOperation instanceof CGIterationCallExp) && !(cgOperation instanceof CGBuiltInIterationCallExp)) {
				rewriteAsCast(cgElement);
			}
		}
		else if (referredVariable instanceof CGParameter) {
			CGParameter cgParameter = (CGParameter)referredVariable;
			EObject cgOperation = cgParameter.eContainer();
			if (cgOperation instanceof CGLibraryOperation) {
				rewriteAsCast(cgElement);
			}
		}
		return null;
	}
}
