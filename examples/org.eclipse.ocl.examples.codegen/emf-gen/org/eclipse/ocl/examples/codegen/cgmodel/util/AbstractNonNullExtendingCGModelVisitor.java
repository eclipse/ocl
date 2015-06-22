/*******************************************************************************
 * Copyright (c) 2013, 2015 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.codegen/model/cgmodel.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.codegen.cgmodel.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractExtendingNonNullCGModelVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 * The return in annotated as @NonNull.
 */
public abstract class AbstractNonNullExtendingCGModelVisitor<R, C>
	extends AbstractCGModelVisitor<R, C>
	implements CGModelVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNonNullExtendingCGModelVisitor(@NonNull C context) {
		super(context);
	}	
	
	/**
	 * Perform a visit to the specified visitable.
	 * 
	 * @param visitable a visitable
	 * @return the non-null result of visiting it
	 */
	@Override
	public @NonNull R visit(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGElement visitable) {
		R result = visitable.accept(this);
		if (result == null) {
			throw new IllegalStateException("null return from non-null " + getClass().getName());
		}
		return result;
	}

	@Override
	public @NonNull R visitCGAccumulator(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator object) {
		return visitCGIterator(object);
	}

	@Override
	public @NonNull R visitCGAssertNonNullExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGAssertNonNullExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGBoolean(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean object) {
		return visitCGConstant(object);
	}

	@Override
	public @NonNull R visitCGBoxExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGBuiltInIterationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp object) {
		return visitCGIterationCallExp(object);
	}

	@Override
	public @NonNull R visitCGCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGCallable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCallable object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGCastExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGCatchExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGClass(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGClass object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @NonNull R visitCGCollectionExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGCollectionPart(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGConstant(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGConstant object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGConstantExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGConstraint(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint object) {
		return visitCGCallable(object);
	}

	@Override
	public @NonNull R visitCGEcoreClassShadowExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassShadowExp object) {
		return visitCGShadowExp(object);
	}

	@Override
	public @NonNull R visitCGEcoreDataTypeShadowExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeShadowExp object) {
		return visitCGShadowExp(object);
	}

	@Override
	public @NonNull R visitCGEcoreExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGEcoreOperation(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperation object) {
		return visitCGOperation(object);
	}

	@Override
	public @NonNull R visitCGEcoreOperationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @NonNull R visitCGEcoreOppositePropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOppositePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	@Override
	public @NonNull R visitCGEcorePropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp object) {
		return visitCGPropertyCallExp(object);
	}

	@Override
	public @NonNull R visitCGElement(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGElement object) {
		return visiting(object);
	}

	@Override
	public @NonNull R visitCGElementId(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGElementId object) {
		return visitCGConstant(object);
	}

	@Override
	public @NonNull R visitCGExecutorCompositionProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorCompositionProperty object) {
		return visitCGExecutorProperty(object);
	}

	@Override
	public @NonNull R visitCGExecutorNavigationProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorNavigationProperty object) {
		return visitCGExecutorProperty(object);
	}

	@Override
	public @NonNull R visitCGExecutorOperation(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGExecutorOperationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @NonNull R visitCGExecutorOppositeProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositeProperty object) {
		return visitCGExecutorProperty(object);
	}

	@Override
	public @NonNull R visitCGExecutorOppositePropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	@Override
	public @NonNull R visitCGExecutorProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGExecutorPropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp object) {
		return visitCGPropertyCallExp(object);
	}

	@Override
	public @NonNull R visitCGExecutorShadowPart(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorShadowPart object) {
		return visitCGExecutorProperty(object);
	}

	@Override
	public @NonNull R visitCGExecutorType(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGFinalVariable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable object) {
		return visitCGVariable(object);
	}

	@Override
	public @NonNull R visitCGGuardExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGIfExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGInteger(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGInteger object) {
		return visitCGNumber(object);
	}

	@Override
	public @NonNull R visitCGInvalid(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid object) {
		return visitCGConstant(object);
	}

	@Override
	public @NonNull R visitCGIsEqual2Exp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIsEqual2Exp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGIsEqualExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIsEqualExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGIsInvalidExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGIsUndefinedExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGIterationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGIterator(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIterator object) {
		return visitCGParameter(object);
	}

	@Override
	public @NonNull R visitCGLetExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGLibraryIterateCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp object) {
		return visitCGLibraryIterationCallExp(object);
	}

	@Override
	public @NonNull R visitCGLibraryIterationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp object) {
		return visitCGIterationCallExp(object);
	}

	@Override
	public @NonNull R visitCGLibraryOperation(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperation object) {
		return visitCGOperation(object);
	}

	@Override
	public @NonNull R visitCGLibraryOperationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @NonNull R visitCGLibraryPropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp object) {
		return visitCGPropertyCallExp(object);
	}

	@Override
	public @NonNull R visitCGLocalVariable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLocalVariable object) {
		return visitCGVariable(object);
	}

	@Override
	public @NonNull R visitCGMapExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGMapExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGMapPart(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGMapPart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGModel(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGModel object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @NonNull R visitCGNamedElement(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement object) {
		return visitCGElement(object);
	}

	@Override
	public @NonNull R visitCGNativeOperation(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNativeOperation object) {
		return visitCGOperation(object);
	}

	@Override
	public @NonNull R visitCGNativeOperationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNativeOperationCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @NonNull R visitCGNativeProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNativeProperty object) {
		return visitCGProperty(object);
	}

	@Override
	public @NonNull R visitCGNativePropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNativePropertyCallExp object) {
		return visitCGPropertyCallExp(object);
	}

	@Override
	public @NonNull R visitCGNavigationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNavigationCallExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGNull(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNull object) {
		return visitCGConstant(object);
	}

	@Override
	public @NonNull R visitCGNumber(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNumber object) {
		return visitCGConstant(object);
	}

	@Override
	public @NonNull R visitCGOperation(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGOperation object) {
		return visitCGCallable(object);
	}

	@Override
	public @NonNull R visitCGOperationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGOppositePropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGOppositePropertyCallExp object) {
		return visitCGNavigationCallExp(object);
	}

	@Override
	public @NonNull R visitCGPackage(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGPackage object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @NonNull R visitCGParameter(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGParameter object) {
		return visitCGVariable(object);
	}

	@Override
	public @NonNull R visitCGProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGProperty object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGPropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp object) {
		return visitCGNavigationCallExp(object);
	}

	@Override
	public @NonNull R visitCGReal(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGReal object) {
		return visitCGNumber(object);
	}

	@Override
	public @NonNull R visitCGSettableVariable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGSettableVariable object) {
		return visitCGVariable(object);
	}

	@Override
	public @NonNull R visitCGShadowExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGShadowExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGShadowPart(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGShadowPart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGString(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGString object) {
		return visitCGConstant(object);
	}

	@Override
	public @NonNull R visitCGText(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGText object) {
		return visitCGConstant(object);
	}

	@Override
	public @NonNull R visitCGTextParameter(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter object) {
		return visitCGParameter(object);
	}

	@Override
	public @NonNull R visitCGThrowExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGTupleExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGTuplePart(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGTuplePartCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp object) {
		return visitCGPropertyCallExp(object);
	}

	@Override
	public @NonNull R visitCGTypeExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGTypeId(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId object) {
		return visitCGElementId(object);
	}

	@Override
	public @NonNull R visitCGTypedElement(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @NonNull R visitCGUnboxExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @NonNull R visitCGUnlimited(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGUnlimited object) {
		return visitCGConstant(object);
	}

	@Override
	public @NonNull R visitCGValuedElement(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement object) {
		return visitCGTypedElement(object);
	}

	@Override
	public @NonNull R visitCGVariable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGVariable object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull R visitCGVariableExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp object) {
		return visitCGValuedElement(object);
	}

	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	@Override
	public abstract @NonNull R visiting(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGElement visitable);
}
