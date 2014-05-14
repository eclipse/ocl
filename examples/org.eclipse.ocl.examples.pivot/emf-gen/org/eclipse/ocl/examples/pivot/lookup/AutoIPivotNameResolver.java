package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
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
	public AutoINamedLookupResult computeLookup(@NonNull Element lookupElement, 
		@NonNull EStructuralFeature lookupFeature,
		@NonNull String name, boolean isQualified);
	
	@NonNull
	public AutoIUnnamedLookupResult computeLookup(@NonNull Element lookupElement,
		@NonNull EStructuralFeature lookupFeature,
		boolean isQualified);
	
	/**
	 * Resolves the referred operation of OperationCallExp
	 * 
	 * @param opCallExp the element from which the lookup will be performed
	 * @param lookupKind the kind of lookup
	 * @return 
	 */
	@NonNull
	public AutoINamedLookupResult computeReferredOperationLookup(@NonNull OperationCallExp opCallExp,
		@NonNull ScopeFilter filter);

	@NonNull
	public AutoINamedLookupResult computeReferredIterationLookup(@NonNull IteratorExp iteratorExp,
		@NonNull ScopeFilter filter);
	
	@NonNull
	public AutoINamedLookupResult computeReferredVariableLookup(@NonNull VariableExp variableExp);
}
