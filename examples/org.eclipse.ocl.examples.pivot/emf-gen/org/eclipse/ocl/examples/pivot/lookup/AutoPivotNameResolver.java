package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
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
	public <C extends Element> AutoIPivotLookupResult<C> computeLookup(@NonNull Element lookupElement, @NonNull EStructuralFeature lookupFeature,
		@NonNull AutoLookupKind lookupKind, @Nullable String name, boolean isQualified) {
		AutoIPivotLookupContext context = createLookupContext(lookupFeature, lookupElement);
		AutoIPivotLookupResult<C> result = createLookupResult(mmManager, lookupFeature, lookupKind, name);
		return executeVisitor(lookupElement, result, context);
	}
	
	@NonNull
	protected <C extends Element> AutoIPivotLookupVisitor<C> createLookupVisitor(@NonNull MetaModelManager mmManager,
		@NonNull AutoIPivotLookupResult<C> result, @NonNull AutoIPivotLookupContext context) {
		return new AutoPivotLookupVisitor<C>(mmManager, result, context);
	}
	
	@NonNull
	protected <C extends Element> AutoIPivotLookupResult<C> createLookupResult(@NonNull MetaModelManager mmManager, 
		@NonNull EStructuralFeature lookupFeature, 	@NonNull AutoLookupKind lookupKind, @Nullable String name) {
		return new AutoPivotLookupResult<C>(mmManager, lookupFeature, lookupKind, name);
	}
	
	@NonNull
	protected AutoIPivotLookupContext createLookupContext(@NonNull EStructuralFeature lookupFeature,
		@NonNull Element lookupElement) {
		return new AutoPivotLookupContext(lookupFeature, lookupElement);
	}
	
	@NonNull
	protected <C extends Element> AutoIPivotLookupResult<C> executeVisitor(@NonNull Element element, @NonNull AutoIPivotLookupResult<C> result, 
		@NonNull AutoIPivotLookupContext context) { 
		return resolveDuplicates(element.accept(createLookupVisitor(mmManager, result, context)));
	}
	
	@NonNull
	protected <C extends Element> AutoIPivotLookupResult<C> resolveDuplicates(@Nullable AutoIPivotLookupResult<C> result) {
		return (AutoIPivotLookupResult<C>)DomainUtil.nonNullState(result).resolveDuplicates();
	}

	@NonNull
	public AutoIPivotLookupResult<Operation> computeReferredOperationLookup(
			@NonNull OperationCallExp opCallExp,
			@NonNull AutoLookupKind lookupKind, @NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("Not auto-generated implemented");
	}

	@NonNull
	public AutoIPivotLookupResult<Iteration> computeReferredIterationLookup(
			@NonNull IteratorExp iteratorExp,
			@NonNull AutoLookupKind lookupKind, @NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("Not auto-generated implemented");
	}

	@NonNull
	public AutoIPivotLookupResult<Variable> computeReferredVariableLookup(
			@NonNull VariableExp variableExp, @NonNull AutoLookupKind lookupKind) {
		throw new IllegalArgumentException("Not auto-generated implemented");
	}
}
