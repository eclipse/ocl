package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;


public interface AutoIPivotUnnamedLookupEnvironment<C extends Element> extends AutoIPivotLookupEnvironment<C>{

	@NonNull
	public AutoIUnnamedLookupResult getResult();
}
