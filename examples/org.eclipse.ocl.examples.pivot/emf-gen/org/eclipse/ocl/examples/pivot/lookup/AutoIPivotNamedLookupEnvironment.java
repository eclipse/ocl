package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.jdt.annotation.NonNull;

public interface AutoIPivotNamedLookupEnvironment extends AutoIPivotLookupEnvironment{

	@NonNull
	public AutoINamedLookupResult getResult();
	/**
	 * Convenience method to remove name duplicates so that it can be called
	 * once the lookup process finishes 
	 * 
	 * @return returns the {@link AutoINamedLookupResult} after resolving duplicates 
	 */
	@NonNull
	public AutoINamedLookupResult resolveDuplicates();
}
