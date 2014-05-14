package org.eclipse.ocl.examples.pivot.lookup;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


public interface AutoINamedLookupResult extends AutoILookupResult {
	
	/**
	 * @return the matched result (or the first ambiguous one), otherwise <code>null</code>
	 */
	@Nullable
	Object getSingleResult();
	
	/**
	 * @return a list with all matched (ambiguous) results. If no results are found,  it will return an empty list
	 */
	@NonNull
	List<Object> getAllResults();	// FIXME, if no case of heterogeneous results is needed, change to List<?>
	
}
