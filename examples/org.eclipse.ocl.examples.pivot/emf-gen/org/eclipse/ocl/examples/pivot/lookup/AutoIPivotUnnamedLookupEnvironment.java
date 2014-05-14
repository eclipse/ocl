package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.jdt.annotation.NonNull;


public interface AutoIPivotUnnamedLookupEnvironment extends AutoIPivotLookupEnvironment{

	@NonNull
	public AutoIUnnamedLookupResult getResult();
}
