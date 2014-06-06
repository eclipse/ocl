/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
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
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingCGModelVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingCGModelVisitor<R, C>
	extends AbstractCGModelVisitor<R, C>
	implements CGModelVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingCGModelVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitCGAccumulator(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator object) {
		return visitCGIterator(object);
	}

	@Override
	public @Nullable R visitCGAssertNonNullExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGAssertNonNullExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @Nullable R visitCGBoolean(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean object) {
		return visitCGConstant(object);
	}

	@Override
	public @Nullable R visitCGBoxExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @Nullable R visitCGBuiltInIterationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp object) {
		return visitCGIterationCallExp(object);
	}

	@Override
	public @Nullable R visitCGCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGCallable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCallable object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGCastExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @Nullable R visitCGCatchExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @Nullable R visitCGClass(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGClass object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @Nullable R visitCGCollectionExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGCollectionPart(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGConstant(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGConstant object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGConstantExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGConstraint(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint object) {
		return visitCGCallable(object);
	}

	@Override
	public @Nullable R visitCGConstructorExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGConstructorPart(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGEcoreClassConstructorExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassConstructorExp object) {
		return visitCGConstructorExp(object);
	}

	@Override
	public @Nullable R visitCGEcoreDataTypeConstructorExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp object) {
		return visitCGConstructorExp(object);
	}

	@Override
	public @Nullable R visitCGEcoreOperation(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperation object) {
		return visitCGOperation(object);
	}

	@Override
	public @Nullable R visitCGEcoreOperationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @Nullable R visitCGEcoreOppositePropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOppositePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	@Override
	public @Nullable R visitCGEcorePropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp object) {
		return visitCGPropertyCallExp(object);
	}

	@Override
	public @Nullable R visitCGElement(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGElement object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitCGElementId(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGElementId object) {
		return visitCGConstant(object);
	}

	@Override
	public @Nullable R visitCGExecutorCompositionProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorCompositionProperty object) {
		return visitCGExecutorProperty(object);
	}

	@Override
	public @Nullable R visitCGExecutorConstructorPart(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorConstructorPart object) {
		return visitCGExecutorProperty(object);
	}

	@Override
	public @Nullable R visitCGExecutorNavigationProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorNavigationProperty object) {
		return visitCGExecutorProperty(object);
	}

	@Override
	public @Nullable R visitCGExecutorOperation(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGExecutorOperationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @Nullable R visitCGExecutorOppositeProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositeProperty object) {
		return visitCGExecutorProperty(object);
	}

	@Override
	public @Nullable R visitCGExecutorOppositePropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	@Override
	public @Nullable R visitCGExecutorProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGExecutorPropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp object) {
		return visitCGPropertyCallExp(object);
	}

	@Override
	public @Nullable R visitCGExecutorType(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGFinalVariable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable object) {
		return visitCGVariable(object);
	}

	@Override
	public @Nullable R visitCGGuardExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @Nullable R visitCGIfExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGInteger(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGInteger object) {
		return visitCGNumber(object);
	}

	@Override
	public @Nullable R visitCGInvalid(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid object) {
		return visitCGConstant(object);
	}

	@Override
	public @Nullable R visitCGIsEqualExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIsEqualExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @Nullable R visitCGIsInvalidExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @Nullable R visitCGIsUndefinedExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @Nullable R visitCGIterationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @Nullable R visitCGIterator(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIterator object) {
		return visitCGParameter(object);
	}

	@Override
	public @Nullable R visitCGLetExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGLibraryIterateCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp object) {
		return visitCGLibraryIterationCallExp(object);
	}

	@Override
	public @Nullable R visitCGLibraryIterationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp object) {
		return visitCGIterationCallExp(object);
	}

	@Override
	public @Nullable R visitCGLibraryOperation(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperation object) {
		return visitCGOperation(object);
	}

	@Override
	public @Nullable R visitCGLibraryOperationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @Nullable R visitCGLibraryPropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp object) {
		return visitCGPropertyCallExp(object);
	}

	@Override
	public @Nullable R visitCGLocalVariable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLocalVariable object) {
		return visitCGVariable(object);
	}

	@Override
	public @Nullable R visitCGModel(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGModel object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @Nullable R visitCGNamedElement(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement object) {
		return visitCGElement(object);
	}

	@Override
	public @Nullable R visitCGNavigationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNavigationCallExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @Nullable R visitCGNull(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNull object) {
		return visitCGConstant(object);
	}

	@Override
	public @Nullable R visitCGNumber(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNumber object) {
		return visitCGConstant(object);
	}

	@Override
	public @Nullable R visitCGOperation(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGOperation object) {
		return visitCGCallable(object);
	}

	@Override
	public @Nullable R visitCGOperationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @Nullable R visitCGOppositePropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGOppositePropertyCallExp object) {
		return visitCGNavigationCallExp(object);
	}

	@Override
	public @Nullable R visitCGPackage(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGPackage object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @Nullable R visitCGParameter(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGParameter object) {
		return visitCGVariable(object);
	}

	@Override
	public @Nullable R visitCGProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGProperty object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGPropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp object) {
		return visitCGNavigationCallExp(object);
	}

	@Override
	public @Nullable R visitCGReal(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGReal object) {
		return visitCGNumber(object);
	}

	@Override
	public @Nullable R visitCGSettableVariable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGSettableVariable object) {
		return visitCGVariable(object);
	}

	@Override
	public @Nullable R visitCGString(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGString object) {
		return visitCGConstant(object);
	}

	@Override
	public @Nullable R visitCGText(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGText object) {
		return visitCGConstant(object);
	}

	@Override
	public @Nullable R visitCGTextParameter(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter object) {
		return visitCGParameter(object);
	}

	@Override
	public @Nullable R visitCGThrowExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @Nullable R visitCGTupleExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGTuplePart(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGTuplePartCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp object) {
		return visitCGPropertyCallExp(object);
	}

	@Override
	public @Nullable R visitCGTypeExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGTypeId(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId object) {
		return visitCGElementId(object);
	}

	@Override
	public @Nullable R visitCGTypedElement(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @Nullable R visitCGUnboxExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp object) {
		return visitCGCallExp(object);
	}

	@Override
	public @Nullable R visitCGUnlimited(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGUnlimited object) {
		return visitCGConstant(object);
	}

	@Override
	public @Nullable R visitCGValuedElement(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement object) {
		return visitCGTypedElement(object);
	}

	@Override
	public @Nullable R visitCGVariable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGVariable object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable R visitCGVariableExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp object) {
		return visitCGValuedElement(object);
	}
}
