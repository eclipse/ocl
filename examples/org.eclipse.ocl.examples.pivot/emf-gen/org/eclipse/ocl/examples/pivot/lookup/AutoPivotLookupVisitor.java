package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;


public class AutoPivotLookupVisitor<C extends EObject> extends AbstractExtendingVisitor<AutoILookupResult<C>, AutoILookupContext>
	implements AutoIPivotLookupVisitor<C> {
		 
	@NonNull final protected MetaModelManager mmManager;
	@NonNull final protected AutoILookupResult<C> result;
	
	public AutoPivotLookupVisitor(@NonNull MetaModelManager mmManager, @NonNull AutoILookupResult<C> result, @NonNull AutoILookupContext context) {
		super(context);
		this.mmManager = mmManager;
		this.result = result;
	}
		
	@NonNull
	protected final AutoILookupResult<C> lookupInParent() {
		return result.isComplete() ? result : lookupInNewContext(context.getParent());
	}

	@NonNull
	protected final AutoILookupResult<C> lookupInNewContext(AutoILookupContext newContext) {
		return newContext == null ? result 
			: DomainUtil.nonNullState(((Element)newContext.getTarget()).accept(
				new AutoPivotLookupVisitor<C>(mmManager, result, newContext))); 
	}

	@NonNull
	public AutoILookupResult<C> visiting(@NonNull Visitable visitable) {
		return lookupInParent();
	}
}