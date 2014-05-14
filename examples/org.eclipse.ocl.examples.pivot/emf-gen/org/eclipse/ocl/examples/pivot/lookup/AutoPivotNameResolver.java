package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;


public class AutoPivotNameResolver implements AutoIPivotNameResolver {

	@NonNull
	final protected MetaModelManager mmManager;
	
	public AutoPivotNameResolver(@NonNull MetaModelManager mmManager) {
		this.mmManager = mmManager;
	}
	
	@NonNull
	public AutoINamedLookupResult computeLookup(@NonNull Element lookupElement,
		@NonNull EStructuralFeature lookupFeature,
		@NonNull String name, boolean isQualified) {
		AutoIPivotLookupContext context = createLookupContext(lookupFeature, lookupElement);
		AutoIPivotNamedLookupEnvironment env = createLookupEnvironment(mmManager, lookupFeature, name);		
		return computeNamedResult(lookupElement, env, context);
	}
	
	@NonNull
	public AutoIUnnamedLookupResult computeLookup(
			@NonNull Element lookupElement,
			@NonNull EStructuralFeature lookupFeature, boolean isQualified) {
		AutoIPivotLookupContext context = createLookupContext(lookupFeature, lookupElement);
		AutoIPivotUnnamedLookupEnvironment env = createLookupEnvironment(mmManager, lookupFeature);		
		return computeUnnamedResult(lookupElement, env, context);
	}
	
	@NonNull
	protected  AutoIPivotLookupVisitor createLookupVisitor(@NonNull MetaModelManager mmManager,
		@NonNull AutoIPivotLookupEnvironment env, @NonNull AutoIPivotLookupContext context) {
		return new AutoPivotLookupVisitor(mmManager, env, context);
	}
	
	@NonNull
	protected  AutoIPivotNamedLookupEnvironment createLookupEnvironment(@NonNull MetaModelManager mmManager, 
		@NonNull EStructuralFeature lookupFeature, @NonNull String name) {
		return new AutoPivotNamedLookupEnvironment(mmManager, lookupFeature, name);
	}
	
	@NonNull
	protected  AutoIPivotUnnamedLookupEnvironment createLookupEnvironment(@NonNull MetaModelManager mmManager, 
		@NonNull EStructuralFeature lookupFeature) {
		return new AutoPivotUnnamedLookupEnvironment(mmManager, lookupFeature);
	}
	
	@NonNull
	protected AutoIPivotLookupContext createLookupContext(@NonNull EStructuralFeature lookupFeature,
		@NonNull Element lookupElement) {
		return new AutoPivotLookupContext(lookupFeature, lookupElement);
	}
		
	@NonNull
	protected  AutoIPivotLookupEnvironment executeVisitor(@NonNull Element element, 
		@NonNull AutoIPivotLookupEnvironment env, 
		@NonNull AutoIPivotLookupContext context) { 
		return DomainUtil.nonNullState(element.accept(createLookupVisitor(mmManager, env, context)));
	}
	
	@NonNull
	protected AutoINamedLookupResult computeNamedResult(@NonNull Element element, 
		@NonNull AutoIPivotNamedLookupEnvironment env, 
		@NonNull AutoIPivotLookupContext context) { 
		AutoIPivotLookupEnvironment env2= executeVisitor(element, env, context);		
		return ((AutoIPivotNamedLookupEnvironment)env2).resolveDuplicates();
	}		
	
	@NonNull
	protected  AutoIUnnamedLookupResult computeUnnamedResult(@NonNull Element element, 
		@NonNull AutoIPivotUnnamedLookupEnvironment env, 
		@NonNull AutoIPivotLookupContext context) { 
		AutoIPivotLookupEnvironment env2 = executeVisitor(element, env, context);		
		return ((AutoIPivotUnnamedLookupEnvironment)env2).getResult();
	}	

	@NonNull
	public AutoINamedLookupResult computeReferredOperationLookup(
			@NonNull OperationCallExp opCallExp,
			@NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}

	@NonNull
	public AutoINamedLookupResult computeReferredIterationLookup(
			@NonNull IteratorExp iteratorExp,
			@NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}

	@NonNull
	public AutoINamedLookupResult computeReferredVariableLookup(
			@NonNull VariableExp variableExp) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}
}
