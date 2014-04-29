package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;


public class NewPivotNameResolutor  extends AutoPivotNameResolution {

	public NewPivotNameResolutor(@NonNull MetaModelManager mmManager) {
		super(mmManager);
	}

	@Override
	@NonNull
	protected <C extends Element> AutoIPivotLookupVisitor<C> createLookupVisitor(@NonNull MetaModelManager mmManager, 
		@NonNull AutoILookupResult<C> result, @NonNull AutoILookupContext context) {
		return new NewPivotLookupVisitor<C>(mmManager, result, context);
	};
}
