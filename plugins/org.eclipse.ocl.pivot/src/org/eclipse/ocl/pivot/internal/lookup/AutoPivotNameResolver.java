package org.eclipse.ocl.pivot.internal.lookup;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.manager.PivotExecutorManager;
import org.eclipse.ocl.pivot.internal.scoping.ScopeFilter;
import org.eclipse.ocl.pivot.util.AutoPivotLookupVisitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;


/**
 * TODO To be generated at:
 * emf-gen/org.eclipse.ocl.pivot.util
 */
public class AutoPivotNameResolver {

	@NonNull
	final protected EnvironmentFactory envFactory;
	
	public AutoPivotNameResolver(@NonNull EnvironmentFactory mmManager) {
		this.envFactory = mmManager;
	}
	
	@NonNull
	public ISingleResultEnvironment computeLookup(@NonNull Element lookupElement,
		@NonNull String name/*, boolean isQualified*/) {
		ISingleResultEnvironment env = createLookupEnvironment(envFactory, lookupElement, name);
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
	protected  AutoPivotLookupVisitor createLookupVisitor(@NonNull IEnvironment env ) {
		return new AutoPivotLookupVisitor(env);
	}
	
	@NonNull
	protected  SingleResultEnvironment createLookupEnvironment(@NonNull EnvironmentFactory mmManager, 
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
	protected  IEnvironment executeVisitor(@NonNull Element element, 
		@NonNull IEnvironment env) { 
		return ClassUtil.nonNullState(element.accept(createLookupVisitor(env)));
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
			@NonNull OperationCallExp opCallExp) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}

	@NonNull
	public ISingleResultEnvironment computeReferredIterationLookup(
			@NonNull IteratorExp iteratorExp) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}

	@NonNull
	public ISingleResultEnvironment computeReferredVariableLookup(
			@NonNull VariableExp variableExp) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}
}
