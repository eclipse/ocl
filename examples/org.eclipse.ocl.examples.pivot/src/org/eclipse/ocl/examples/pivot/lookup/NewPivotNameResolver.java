package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


/**
 * @since 3.5
 */
public class NewPivotNameResolver  extends AutoPivotNameResolver {

	public NewPivotNameResolver(@NonNull MetaModelManager mmManager) {
		super(mmManager);
		OCLstdlibTables.LIBRARY.getClass();		// FIXME Why isn't initialization inherently reliable?
	}

	@Override
	protected @NonNull
	AutoPivotLookupVisitor createLookupVisitor(@NonNull Environment env) {
		return new NewPivotLookupVisitor(mmManager, env);
	};
	
	@Override
	public @NonNull
	ISingleResultEnvironment computeReferredOperationLookup(@NonNull OperationCallExp opCallExp,
		@NonNull ScopeFilter filter) {
		//@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION;
		String name = opCallExp.getName();
		Type sourceType = PivotUtil.getType(opCallExp.getSource());
		
		if (name == null // FIXME adolfosbh can we assume well-formedness of the opCallExp ?
			|| sourceType == null ) {
			return createLookupEnvironment(mmManager,  opCallExp, "") ; // Empty result
		}
		SingleResultEnvironment env = createLookupEnvironment(mmManager, opCallExp, name);
		env.addFilter(filter);
		return computeNamedResult(sourceType, env);
	}
	
	@Override
	public 	@NonNull
	ISingleResultEnvironment computeReferredIterationLookup(@NonNull IteratorExp iteratorExp, 
		@NonNull ScopeFilter filter) {
		//@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.LOOP_EXP__REFERRED_ITERATION;;
		String name =  iteratorExp.getName();
		Type sourceType = PivotUtil.getType(iteratorExp.getSource());
		if (name == null // FIXME adolfosbh can we assume well-formedness of the iteratorExp ?
			|| !(sourceType instanceof CollectionType)) { 
			return createLookupEnvironment(mmManager, iteratorExp, "") ; // Empty result
		}
		SingleResultEnvironment env = createLookupEnvironment(mmManager, iteratorExp, name);
		env.addFilter(filter);
		return computeNamedResult(sourceType, env);
	}

	@Override
	
	public @NonNull
	ISingleResultEnvironment computeReferredVariableLookup(
			@NonNull VariableExp variableExp) {
		String name = variableExp.getName();
		if (name == null) {  // FIXME adolfosbh can we assume well-formedness of the expression ?
			return createLookupEnvironment(mmManager, variableExp, "") ; // Empty result
		}
		SingleResultEnvironment env = createLookupEnvironment(mmManager, variableExp, name);
		return computeNamedResult(variableExp, env);		
	}
	
}