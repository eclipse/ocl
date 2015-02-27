package org.eclipse.ocl.pivot.internal.lookup;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;



/**
 * @since 3.5
 * 
 */
public interface IAllResultsEnvironment  extends Environment {

	/**
	 * @return a named indexed map of all reachable named  objects
	 */
	@NonNull
	Map<String, List<? extends NamedElement>> getAllResults();
	
}
