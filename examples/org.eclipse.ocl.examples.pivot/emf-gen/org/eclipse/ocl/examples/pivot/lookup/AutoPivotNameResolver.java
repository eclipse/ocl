package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PivotExecutorManager;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;


/**
 * TODO To be generated
 * @since 3.5
 */
public class AutoPivotNameResolver {

	@NonNull
	final protected MetaModelManager mmManager;
	
	public AutoPivotNameResolver(@NonNull MetaModelManager mmManager) {
		this.mmManager = mmManager;
	}
	
	@NonNull
	public ISingleResultEnvironment computeLookup(@NonNull Element lookupElement,
		@NonNull String name/*, boolean isQualified*/) {
		ISingleResultEnvironment env = createLookupEnvironment(mmManager, lookupElement, name);
		return computeNamedResult(lookupElement, env);
	}
	
//	@NonNull
//	public IAllResultsEnvironment computeLookup(
//			@NonNull Element lookupElement/*, boolean isQualified*/) {
//		AutoIPivotLookupContext context = createLookupContext(lookupFeature, lookupElement);
//		IAllResultsEnvironment env = createLookupEnvironment(mmManager, lookupFeature);		
//		return computeUnnamedResult(lookupElement, env, context);
//	}
	
	@NonNull
	protected  AutoPivotLookupVisitor createLookupVisitor(@NonNull Environment env ) {
		return new AutoPivotLookupVisitor(env);
	}
	
	@NonNull
	protected  SingleResultEnvironment createLookupEnvironment(@NonNull MetaModelManager mmManager, 
		@NonNull Element lookupElement, @NonNull  String name) {
		// FIXME ask Ed how to better provide this DomainEvaluator
		return new SingleResultEnvironment(mmManager, new PivotExecutorManager(mmManager,  lookupElement), name);
	}
	
//	@NonNull
//	protected  IAllResultsEnvironment createLookupEnvironment(@NonNull MetaModelManager mmManager, 
//		@NonNull EStructuralFeature lookupFeature) {
//		return new AllResultsEnvironment(mmManager, lookupFeature);
//	}
	
		
	@NonNull
	protected  Environment executeVisitor(@NonNull Element element, 
		@NonNull Environment env) { 
		return DomainUtil.nonNullState(element.accept(createLookupVisitor(env)));
	}
	
	@NonNull
	protected ISingleResultEnvironment computeNamedResult(@NonNull Element element, 
		@NonNull ISingleResultEnvironment env) { 
		ISingleResultEnvironment env2= (ISingleResultEnvironment) executeVisitor(element, env);	
		return env2 instanceof SingleResultEnvironment ? ((SingleResultEnvironment)env2).resolveDuplicates() : env2; 
	}		
	
//	@NonNull
//	protected  AutoIUnnamedLookupResult computeUnnamedResult(@NonNull Element element, 
//		@NonNull IAllResultsEnvironment env) { 
//		AutoIPivotLookupEnvironment env2 = executeVisitor(element, env, context);		
//		return ((IAllResultsEnvironment)env2).getResult();
//	}	

	@NonNull
	public ISingleResultEnvironment computeReferredOperationLookup(
			@NonNull OperationCallExp opCallExp,
			@NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}

	@NonNull
	public ISingleResultEnvironment computeReferredIterationLookup(
			@NonNull IteratorExp iteratorExp,
			@NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}

	@NonNull
	public ISingleResultEnvironment computeReferredVariableLookup(
			@NonNull VariableExp variableExp) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}
}
