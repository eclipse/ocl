package org.eclipse.ocl.examples.pivot.lookup;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


public interface AutoINamedLookupResult<C extends EObject> extends AutoILookupResult {
	
	/**
	 * @return the matched result (or the first ambiguous one), otherwise <code>null</code>
	 */
	@Nullable
	C getSingleResult();
	/**
	 * @return a list with all matched (ambiguous) results. If no results are found,  it will return an empty list
	 */
	@NonNull
	List<C> getAllResults();

}
