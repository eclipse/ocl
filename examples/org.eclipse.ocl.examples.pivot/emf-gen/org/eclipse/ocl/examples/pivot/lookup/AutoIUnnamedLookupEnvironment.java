package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.jdt.annotation.NonNull;


public interface AutoIUnnamedLookupEnvironment extends AutoILookupEnvironment {
	
	@NonNull
	public AutoIUnnamedLookupResult getResult();
}
