package org.eclipse.ocl.examples.pivot.lookup;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;



/**
 * @since 3.5
 * 
 */
public interface IAllResultsEnvironment  extends Environment {

	/**
	 * @return a named indexed map of all reachable named  objects
	 */
	@NonNull
	Map<String, List<? extends DomainNamedElement>> getAllResults();
	
}
