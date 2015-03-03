package org.eclipse.ocl.pivot.internal.lookup;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.util.AutoPivotLookupVisitor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;

public class NewPivotNameResolver  extends AutoPivotNameResolver {

	
	public NewPivotNameResolver(@NonNull EnvironmentFactory mmManager) {
		super(mmManager);
	}

	@Override
	protected @NonNull
	AutoPivotLookupVisitor createLookupVisitor(@NonNull IEnvironment env) {
		return new NewPivotLookupVisitor(envFactory, env);
	};
	
	@Override
	public @NonNull
	ISingleResultEnvironment computeReferredOperationLookup(@NonNull OperationCallExp opCallExp) {
		//@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION;
		String name = opCallExp.getName();
		Type sourceType = PivotUtilInternal.getType(opCallExp.getOwnedSource());
		
		if (name == null // FIXME adolfosbh can we assume well-formedness of the opCallExp ?
			|| sourceType == null ) {
			return createLookupEnvironment(envFactory,  opCallExp, "") ; // Empty result
		}
		SingleResultEnvironment env = createLookupEnvironment(envFactory, opCallExp, name);
		// env.addFilter(filter);
		return computeNamedResult(sourceType, env);
	}
	
	@Override
	public 	@NonNull
	ISingleResultEnvironment computeReferredIterationLookup(@NonNull IteratorExp iteratorExp) {
		//@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.LOOP_EXP__REFERRED_ITERATION;;
		String name =  iteratorExp.getName();
		Type sourceType = PivotUtilInternal.getType(iteratorExp.getOwnedSource());
		if (name == null // FIXME adolfosbh can we assume well-formedness of the iteratorExp ?
			|| !(sourceType instanceof CollectionType)) { 
			return createLookupEnvironment(envFactory, iteratorExp, "") ; // Empty result
		}
		SingleResultEnvironment env = createLookupEnvironment(envFactory, iteratorExp, name);
		// env.addFilter(filter);
		return computeNamedResult(sourceType, env);
	}

	@Override
	
	public @NonNull
	ISingleResultEnvironment computeReferredVariableLookup(
			@NonNull VariableExp variableExp) {
		String name = variableExp.getName();
		if (name == null) {  // FIXME adolfosbh can we assume well-formedness of the expression ?
			return createLookupEnvironment(envFactory, variableExp, "") ; // Empty result
		}
		SingleResultEnvironment env = createLookupEnvironment(envFactory, variableExp, name);
		return computeNamedResult(variableExp, env);		
	}
	
}
