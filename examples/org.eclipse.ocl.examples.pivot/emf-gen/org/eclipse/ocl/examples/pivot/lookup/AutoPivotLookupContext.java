package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;

public class AutoPivotLookupContext extends AutoLookupContext<Element>
	implements AutoIPivotLookupContext {

	protected AutoPivotLookupContext(@NonNull EStructuralFeature lookupFeature,
			@NonNull Element target) {
		super(lookupFeature, target);
	}

	protected AutoPivotLookupContext(@NonNull EStructuralFeature lookupFeature ,
			@NonNull Element target, @Nullable Element child) {
		super(lookupFeature, target, child);
	}
}
