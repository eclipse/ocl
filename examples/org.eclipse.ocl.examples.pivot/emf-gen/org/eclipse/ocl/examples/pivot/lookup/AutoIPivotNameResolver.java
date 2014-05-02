package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;


public interface AutoIPivotNameResolver {
	
	/**
	 * Generic lookup contract
	 * 
	 * @param lookupElement the element from which the lookup will be fired up
	 * @param lookupFeature the feature for which the lookup is needed
	 * @param lookupKind 
	 * @param name
	 * @param isQualified
	 * @return
	 */
	@NonNull
	public <C extends Element> AutoIPivotLookupResult<C> computeLookup(@NonNull Element lookupElement, @NonNull EStructuralFeature lookupFeature,
		@NonNull AutoLookupKind lookupKind, @Nullable String name, boolean isQualified);
	
	/**
	 * Resolves the referred operation of OperationCallExp
	 * 
	 * @param opCallExp the element from which the lookup will be performed
	 * @param lookupKind the kind of lookup
	 * @return 
	 */
	@NonNull
	public AutoIPivotLookupResult<Operation> computeReferredOperationLookup(@NonNull OperationCallExp opCallExp,
		@NonNull AutoLookupKind lookupKind, @NonNull ScopeFilter filter);

	@NonNull
	public AutoIPivotLookupResult<Iteration> computeReferredIterationLookup(@NonNull IteratorExp iteratorExp, 
		@NonNull AutoLookupKind lookupKind, @NonNull ScopeFilter filter);
	
	@NonNull
	public AutoIPivotLookupResult<Variable> computeReferredVariableLookup(@NonNull VariableExp variableExp,
		@NonNull AutoLookupKind lookupKind);
}
