package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;


public interface AutoIPivotNamedLookupEnvironment<C extends Element> extends AutoIPivotLookupEnvironment<C>{

	@NonNull
	public AutoINamedLookupResult<C> getResult();
	/**
	 * Convenience method to remove name duplicates so that it can be called
	 * once the lookup process finishes 
	 * 
	 * @return returns the {@link AutoINamedLookupResult} after resolving duplicates 
	 */
	@NonNull
	public AutoINamedLookupResult<C> resolveDuplicates();
}
