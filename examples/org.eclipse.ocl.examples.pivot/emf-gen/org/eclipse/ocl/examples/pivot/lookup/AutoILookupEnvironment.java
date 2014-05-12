package org.eclipse.ocl.examples.pivot.lookup;


import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
		
/**
 * Interface to carry the results of a lookup process
 * 
 */
public interface AutoILookupEnvironment {

	/**
	 * Return true once the AutoILookupResult has accumulated sufficient results
	 * to satisfy the lookup criterion for which it was created. i.e. any result
	 * for a non-null name, all results for a null name.
	 */
	boolean isComplete();
		
	/**
	 * @return the type of the element to be looked up
	 */
	@NonNull
	EClassifier getType();
	
	@NonNull
	AutoILookupResult getResult();
}
