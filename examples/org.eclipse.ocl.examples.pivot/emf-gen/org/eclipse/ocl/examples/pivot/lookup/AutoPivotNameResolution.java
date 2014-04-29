package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


public class AutoPivotNameResolution implements AutoIPivotNameResolution {

	@NonNull
	private MetaModelManager mmManager;
	
	public AutoPivotNameResolution(@NonNull MetaModelManager mmManager) {
		this.mmManager = mmManager;
	}
	
	
	@NonNull
	public AutoILookupResult<Element> computeLookup(@NonNull Element lookupElement, @NonNull EStructuralFeature lookupFeature,
		@NonNull AutoLookupKind lookupKind, @Nullable String name, boolean isQualified) {
		AutoILookupContext context = new AutoLookupContext(lookupFeature, lookupElement);
		AutoLookupResult<Element> result = new AutoLookupResult<Element>(mmManager, lookupFeature, lookupKind, name);
		return executeVisitor(lookupElement, result, context);
	}

	@NonNull
	public AutoILookupResult<Operation> computeReferredOperationLookup(@NonNull OperationCallExp opCallExp,
		@NonNull AutoLookupKind lookupKind, @NonNull ScopeFilter filter) {
		@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION;
		AutoILookupResult<Operation> result = createLookupResult(mmManager, eReference, lookupKind, opCallExp.getName());
		result.addFilter(filter);
		Type sourceType = PivotUtil.getType(opCallExp.getSource());
		if (sourceType == null ) {
			return result; // Empty result
		}
		Type lowerBoundType = (Type) PivotUtil.getLowerBound(sourceType);
		AutoILookupContext context = createLookupContext(eReference, lowerBoundType);
		return executeVisitor(lowerBoundType, result, context);
	}
	
	@NonNull
	protected <C extends Element> AutoIPivotLookupVisitor<C> createLookupVisitor(@NonNull MetaModelManager mmManager,
		@NonNull AutoILookupResult<C> result, @NonNull AutoILookupContext context) {
		return new AutoPivotLookupVisitor<C>(mmManager, result, context);
	}
	
	@NonNull
	protected <C extends Element> AutoILookupResult<C> createLookupResult(@NonNull MetaModelManager mmManager, 
		@NonNull EStructuralFeature lookupFeature, 	@NonNull AutoLookupKind lookupKind, @Nullable String name) {
		return new AutoLookupResult<C>(mmManager, lookupFeature, lookupKind, name);
	}
	
	@NonNull
	protected AutoILookupContext createLookupContext(@NonNull EStructuralFeature lookupFeature,
		@NonNull EObject lookupElement) {
		return new AutoLookupContext(lookupFeature, lookupElement);
	}
	
	@NonNull
	protected <C extends Element> AutoILookupResult<C> executeVisitor(@NonNull Element element, @NonNull AutoILookupResult<C> result, 
		@NonNull AutoILookupContext context) { 
		return resolveDuplicates(element.accept(createLookupVisitor(mmManager, result, context)));
	}
	
	@NonNull
	protected <C extends Element> AutoILookupResult<C> resolveDuplicates(@Nullable AutoILookupResult<C> result) {
		return DomainUtil.nonNullState(result).resolveDuplicates();
	}
}