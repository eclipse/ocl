package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;


public class AutoPivotLookupVisitor extends AbstractExtendingVisitor<AutoIPivotLookupEnvironment, AutoILookupContext<Element>>
	implements AutoIPivotLookupVisitor {
		 
	@NonNull final protected MetaModelManager mmManager;
	@NonNull final protected AutoIPivotLookupEnvironment result;
	
	public AutoPivotLookupVisitor(@NonNull MetaModelManager mmManager, @NonNull AutoIPivotLookupEnvironment result, @NonNull AutoILookupContext<Element> context) {
		super(context);
		this.mmManager = mmManager;
		this.result = result;
	}

	@NonNull
	public AutoIPivotLookupEnvironment visiting(@NonNull Visitable visitable) {
		return lookupInParentIfNotComplete();
	}
	
	@NonNull
	protected final AutoIPivotLookupEnvironment lookupInNewContext(@Nullable AutoILookupContext<Element> newContext) {
		return newContext == null ? result // If we have reached the top element
			: DomainUtil.nonNullState((newContext.getTarget()).accept( 
				new AutoPivotLookupVisitor(mmManager, result, newContext))); 
	}
	@NonNull
	protected AutoIPivotLookupEnvironment lookupFromNewElement(Element element) {
		return DomainUtil.nonNullState(element.accept(this));
	}
	
	// Lookup propagation protocols 
	
	/**
	 * Used when ONLY looking up in local 
	 * @return the accumulated lookup result
	 */
	@NonNull
	protected AutoIPivotLookupEnvironment lookupOnlyLocal() {
		return result;
	}
	
	/**
	 * Used when looking up in local AND in parent environments if not found 
	 * in local -> outer scope/environment elements are occluded in nested 
	 * contexts
	 * @return the accumulated lookup result
	 */
	@NonNull
	protected AutoIPivotLookupEnvironment lookupInParentIfNotComplete() {
		return result.isComplete() ? result : lookupInNewContext(context.getParent());
	}
	
	/**
	 * Used when looking up in local AND in parent environments
	 * @return the accumulated lookup result
	 */
	@NonNull
	protected AutoIPivotLookupEnvironment lookupInParent() {
		return lookupInNewContext(context.getParent());
	}
}
