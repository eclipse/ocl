package org.eclipse.ocl.examples.pivot.lookup;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
		
/**
 * Interface to carry the results of a lookup process
 * 
 */
public interface AutoILookupResult<C extends EObject> {

	/**
	 * Return true once the AutoILookupResult has accumulated sufficient results
	 * to satisfy the lookup criterion for which it was created. i.e. any result
	 * for a non-null name, all results for a null name.
	 */
	boolean isComplete();
		
	@NonNull
	EClassifier getType();
	
	int getSize();
	
	@Nullable
	C getSingleResult();
	/**
	 * @return a list with all matched results. If no results are found,  it will return an empty list
	 */
	@NonNull
	List<C> getAllResults();

	// TEMPORAL STUFF
	// ASBH FIXME can we get rid of this ?
	/**
	 * Convenience method to remove name duplicates so that it can be called
	 * once the lookup process finishes 
	 * 
	 * @return returns this {@link AutoILookupResult} after resolving duplicates 
	 */
	@NonNull
	AutoILookupResult<C> resolveDuplicates();
	// END OF TEMPORAL STUFF
}
