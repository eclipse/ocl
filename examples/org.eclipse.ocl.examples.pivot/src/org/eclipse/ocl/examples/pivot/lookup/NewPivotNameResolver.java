package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


public class NewPivotNameResolver  extends AutoPivotNameResolver {

	public NewPivotNameResolver(@NonNull MetaModelManager mmManager) {
		super(mmManager);
	}

	@Override
	protected @NonNull
	AutoIPivotLookupVisitor createLookupVisitor(@NonNull MetaModelManager mmManager, 
		@NonNull AutoIPivotLookupEnvironment env, @NonNull AutoIPivotLookupContext context) {
		return new NewPivotLookupVisitor(mmManager, env, context);
	};
	
	@Override
	public @NonNull
	AutoINamedLookupResult computeReferredOperationLookup(@NonNull OperationCallExp opCallExp,
		@NonNull ScopeFilter filter) {
		@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION;
		String name = opCallExp.getName();
		Type sourceType = PivotUtil.getType(opCallExp.getSource()); 
		if (name == null // FIXME adolfosbh can we assume well-formedness of the opCallExp ?
			|| sourceType == null ) {
			return AutoNamedLookupResult.emptyResult(); // Empty result
		}
		AutoIPivotNamedLookupEnvironment env = createLookupEnvironment(mmManager, eReference, name);
		env.addFilter(filter);
		AutoIPivotLookupContext context = createLookupContext(eReference, sourceType);
		return computeNamedResult(sourceType, env, context);
	}
	
	@Override
	public 	@NonNull
	AutoINamedLookupResult computeReferredIterationLookup(@NonNull IteratorExp iteratorExp, 
		@NonNull ScopeFilter filter) {
		@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.LOOP_EXP__REFERRED_ITERATION;;
		String name =  iteratorExp.getName();
		Type sourceType = PivotUtil.getType(iteratorExp.getSource());
		if (name == null // FIXME adolfosbh can we assume well-formedness of the iteratorExp ?
			|| !(sourceType instanceof CollectionType)) { 
			return  AutoNamedLookupResult.emptyResult(); // Empty result
		}
		AutoIPivotNamedLookupEnvironment env = createLookupEnvironment(mmManager, eReference, name);
		env.addFilter(filter);
		AutoIPivotLookupContext context = createLookupContext(eReference, sourceType);
		return computeNamedResult(sourceType, env, context);
	}

	@Override
	
	public @NonNull
	AutoINamedLookupResult computeReferredVariableLookup(
			@NonNull VariableExp variableExp) {
		@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE;;
		String name = variableExp.getName();
		if (name == null) {  // FIXME adolfosbh can we assume well-formedness of the expression ?
			 return AutoNamedLookupResult.emptyResult(); // Empty result
		}
		AutoIPivotNamedLookupEnvironment env = createLookupEnvironment(mmManager, eReference, name);
		AutoIPivotLookupContext context = createLookupContext(eReference, variableExp);
		return computeNamedResult(variableExp, env, context);		
	}
	
}