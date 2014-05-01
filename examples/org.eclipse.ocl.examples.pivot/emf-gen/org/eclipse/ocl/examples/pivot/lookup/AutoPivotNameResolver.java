package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


public class AutoPivotNameResolver implements AutoIPivotNameResolver {

	@NonNull
	private MetaModelManager mmManager;
	
	public AutoPivotNameResolver(@NonNull MetaModelManager mmManager) {
		this.mmManager = mmManager;
	}
	
	
	@NonNull
	public AutoIPivotLookupResult<Element> computeLookup(@NonNull Element lookupElement, @NonNull EStructuralFeature lookupFeature,
		@NonNull AutoLookupKind lookupKind, @Nullable String name, boolean isQualified) {
		AutoILookupContext<Element> context = createLookupContext(lookupFeature, lookupElement);
		AutoIPivotLookupResult<Element> result = createLookupResult(mmManager, lookupFeature, lookupKind, name);
		return executeVisitor(lookupElement, result, context);
	}

	@NonNull
	public AutoIPivotLookupResult<Operation> computeReferredOperationLookup(@NonNull OperationCallExp opCallExp,
		@NonNull AutoLookupKind lookupKind, @NonNull ScopeFilter filter) {
		@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION;
		AutoIPivotLookupResult<Operation> result = createLookupResult(mmManager, eReference, lookupKind, opCallExp.getName());
		result.addFilter(filter);
		Type sourceType = PivotUtil.getType(opCallExp.getSource()); 
		if (sourceType == null ) { // FIXME adolfosbh cane assume well-formedness of the opCallExp ?
			return result; // Empty result
		}
		AutoILookupContext<Element> context = createLookupContext(eReference, sourceType);
		return executeVisitor(sourceType, result, context);
	}
	
	public 	@NonNull
	AutoILookupResult<Iteration> computeReferredIterationLookup(@NonNull IteratorExp iteratorExp , 
		@NonNull AutoLookupKind lookupKind, @NonNull ScopeFilter filter) {
		
		@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.LOOP_EXP__REFERRED_ITERATION;;
		AutoIPivotLookupResult<Iteration> result = createLookupResult(mmManager, eReference, lookupKind, iteratorExp.getName());
		result.addFilter(filter);
		Type sourceType = PivotUtil.getType(iteratorExp.getSource()); 
		if (!(sourceType instanceof CollectionType)) { // FIXME adolfosbh can we assume well-formedness of the iteratorExp ?
			return result; // Empty result
		}
		AutoILookupContext<Element> context = createLookupContext(eReference, sourceType);
		return executeVisitor(sourceType, result, context);
	}
	
	@NonNull
	protected <C extends Element> AutoIPivotLookupVisitor<C> createLookupVisitor(@NonNull MetaModelManager mmManager,
		@NonNull AutoIPivotLookupResult<C> result, @NonNull AutoILookupContext<Element> context) {
		return new AutoPivotLookupVisitor<C>(mmManager, result, context);
	}
	
	@NonNull
	protected <C extends Element> AutoIPivotLookupResult<C> createLookupResult(@NonNull MetaModelManager mmManager, 
		@NonNull EStructuralFeature lookupFeature, 	@NonNull AutoLookupKind lookupKind, @Nullable String name) {
		return new AutoPivotLookupResult<C>(mmManager, lookupFeature, lookupKind, name);
	}
	
	@NonNull
	protected AutoILookupContext<Element> createLookupContext(@NonNull EStructuralFeature lookupFeature,
		@NonNull Element lookupElement) {
		return new AutoLookupContext<Element>(lookupFeature, lookupElement);
	}
	
	@NonNull
	protected <C extends Element> AutoIPivotLookupResult<C> executeVisitor(@NonNull Element element, @NonNull AutoIPivotLookupResult<C> result, 
		@NonNull AutoILookupContext<Element> context) { 
		return resolveDuplicates(element.accept(createLookupVisitor(mmManager, result, context)));
	}
	
	@NonNull
	protected <C extends Element> AutoIPivotLookupResult<C> resolveDuplicates(@Nullable AutoIPivotLookupResult<C> result) {
		return (AutoIPivotLookupResult<C>)DomainUtil.nonNullState(result).resolveDuplicates();
	}
}