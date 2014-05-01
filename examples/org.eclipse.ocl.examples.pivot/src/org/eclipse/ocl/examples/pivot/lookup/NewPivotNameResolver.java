package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;


public class NewPivotNameResolver  extends AutoPivotNameResolver {

	public NewPivotNameResolver(@NonNull MetaModelManager mmManager) {
		super(mmManager);
	}

	@Override
	protected @NonNull <C extends Element> 
	AutoIPivotLookupVisitor<C> createLookupVisitor(@NonNull MetaModelManager mmManager, 
		@NonNull AutoIPivotLookupResult<C> result, @NonNull AutoILookupContext<Element> context) {
		return new NewPivotLookupVisitor<C>(mmManager, result, context);
	};
}