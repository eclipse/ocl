package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


public class NewPivotNameResolver  extends AutoPivotNameResolver {

	public NewPivotNameResolver(@NonNull MetaModelManager mmManager) {
		super(mmManager);
	}

	@Override
	protected @NonNull <C extends Element> 
	AutoIPivotLookupVisitor<C> createLookupVisitor(@NonNull MetaModelManager mmManager, 
		@NonNull AutoIPivotLookupResult<C> result, @NonNull AutoILookupContext<Element> context) {
		return new NewPivotLookupVisitor<C>(mmManager, result, context);
	};
	
	@Override
	public @NonNull
	AutoIPivotLookupResult<Operation> computeReferredOperationLookup(@NonNull OperationCallExp opCallExp,
		@NonNull AutoLookupKind lookupKind, @NonNull ScopeFilter filter) {
		@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION;
		AutoIPivotLookupResult<Operation> result = createLookupResult(mmManager, eReference, lookupKind, opCallExp.getName());
		result.addFilter(filter);
		Type sourceType = PivotUtil.getType(opCallExp.getSource()); 
		if (sourceType == null ) { // FIXME adolfosbh cane assume well-formedness of the opCallExp ?
			return result; // Empty result
		}
		AutoILookupContext<Element> context = createLookupContext(eReference, sourceType);
		return executeVisitor(sourceType, result, context);
	}
	
	@Override
	public 	@NonNull
	AutoIPivotLookupResult<Iteration> computeReferredIterationLookup(@NonNull IteratorExp iteratorExp , 
		@NonNull AutoLookupKind lookupKind, @NonNull ScopeFilter filter) {
		
		@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.LOOP_EXP__REFERRED_ITERATION;;
		AutoIPivotLookupResult<Iteration> result = createLookupResult(mmManager, eReference, lookupKind, iteratorExp.getName());
		result.addFilter(filter);
		Type sourceType = PivotUtil.getType(iteratorExp.getSource()); 
		if (!(sourceType instanceof CollectionType)) { // FIXME adolfosbh can we assume well-formedness of the iteratorExp ?
			return result; // Empty result
		}
		AutoILookupContext<Element> context = createLookupContext(eReference, sourceType);
		return executeVisitor(sourceType, result, context);
	}

	@Override
	
	public @NonNull
	AutoIPivotLookupResult<Variable> computeReferredVariableLookup(
			@NonNull VariableExp variableExp,
			@NonNull AutoLookupKind lookupKind) {
		@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE;;
		AutoIPivotLookupResult<Variable> result = createLookupResult(mmManager, eReference, lookupKind, variableExp.getName());		
		AutoILookupContext<Element> context = createLookupContext(eReference, variableExp);
		return executeVisitor(variableExp, result, context);		
	}
}