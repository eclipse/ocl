package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
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
	public <C extends Element> AutoINamedLookupResult<C> computeLookup(@NonNull Element lookupElement,
		@NonNull EStructuralFeature lookupFeature,
		@NonNull String name, boolean isQualified) {
		AutoIPivotLookupContext context = createLookupContext(lookupFeature, lookupElement);
		AutoIPivotNamedLookupEnvironment<C> env = createLookupEnvironment(mmManager, lookupFeature, name);		
		return computeNamedResult(lookupElement, env, context);
	}
	
	@NonNull
	public <C extends Element> AutoIUnnamedLookupResult computeLookup(
			@NonNull Element lookupElement,
			@NonNull EStructuralFeature lookupFeature, boolean isQualified) {
		AutoIPivotLookupContext context = createLookupContext(lookupFeature, lookupElement);
		AutoIPivotUnnamedLookupEnvironment<C> env = createLookupEnvironment(mmManager, lookupFeature);		
		return computeUnnamedResult(lookupElement, env, context);
	}
	
	@NonNull
	protected <C extends Element> AutoIPivotLookupVisitor<C> createLookupVisitor(@NonNull MetaModelManager mmManager,
		@NonNull AutoIPivotLookupEnvironment<C> env, @NonNull AutoIPivotLookupContext context) {
		return new AutoPivotLookupVisitor<C>(mmManager, env, context);
	}
	
	@NonNull
	protected <C extends Element> AutoIPivotNamedLookupEnvironment<C> createLookupEnvironment(@NonNull MetaModelManager mmManager, 
		@NonNull EStructuralFeature lookupFeature, @NonNull String name) {
		return new AutoPivotNamedLookupEnvironment<C>(mmManager, lookupFeature, name);
	}
	
	@NonNull
	protected <C extends Element> AutoIPivotUnnamedLookupEnvironment<C> createLookupEnvironment(@NonNull MetaModelManager mmManager, 
		@NonNull EStructuralFeature lookupFeature) {
		return new AutoPivotUnnamedLookupEnvironment<C>(mmManager, lookupFeature);
	}
	
	@NonNull
	protected AutoIPivotLookupContext createLookupContext(@NonNull EStructuralFeature lookupFeature,
		@NonNull Element lookupElement) {
		return new AutoPivotLookupContext(lookupFeature, lookupElement);
	}
		
	@NonNull
	protected <C extends Element> AutoIPivotLookupEnvironment<C> executeVisitor(@NonNull Element element, 
		@NonNull AutoIPivotLookupEnvironment<C> env, 
		@NonNull AutoIPivotLookupContext context) { 
		return DomainUtil.nonNullState(element.accept(createLookupVisitor(mmManager, env, context)));
	}
	
	@NonNull
	protected <C extends Element> AutoINamedLookupResult<C> computeNamedResult(@NonNull Element element, 
		@NonNull AutoIPivotNamedLookupEnvironment<C> env, 
		@NonNull AutoIPivotLookupContext context) { 
		AutoIPivotLookupEnvironment<C> env2= executeVisitor(element, env, context);		
		return ((AutoIPivotNamedLookupEnvironment<C>)env2).resolveDuplicates();
	}		
	
	@NonNull
	protected <C extends Element> AutoIUnnamedLookupResult computeUnnamedResult(@NonNull Element element, 
		@NonNull AutoIPivotUnnamedLookupEnvironment<C> env, 
		@NonNull AutoIPivotLookupContext context) { 
		AutoIPivotLookupEnvironment<C> env2 = executeVisitor(element, env, context);		
		return ((AutoIPivotUnnamedLookupEnvironment<C>)env2).getResult();
	}	

	@NonNull
	public AutoINamedLookupResult<Operation> computeReferredOperationLookup(
			@NonNull OperationCallExp opCallExp,
			@NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}

	@NonNull
	public AutoINamedLookupResult<Iteration> computeReferredIterationLookup(
			@NonNull IteratorExp iteratorExp,
			@NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}

	@NonNull
	public AutoINamedLookupResult<Variable> computeReferredVariableLookup(
			@NonNull VariableExp variableExp) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}
}
