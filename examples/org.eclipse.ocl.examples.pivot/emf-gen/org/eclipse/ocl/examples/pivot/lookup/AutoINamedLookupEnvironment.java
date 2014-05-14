package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.jdt.annotation.NonNull;


public interface AutoINamedLookupEnvironment extends AutoILookupEnvironment {
	
	@NonNull
	public AutoINamedLookupResult getResult();
}
