package org.eclipse.ocl.examples.pivot.lookup;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;


/**
 * @since 3.5
 */
public interface ISingleResultEnvironment extends Environment {

	/**
	 * @return the matched result (or the first ambiguous one), otherwise <code>null</code>
	 */
	@Nullable
	DomainNamedElement getSingleResult();
	
	/**
	 * @return a list with all matched (ambiguous) results. If no results are found,  it will return an empty list
	 */
	@NonNull
	List<DomainNamedElement> getAllResults();	// FIXME, if no case of heterogeneous results is needed, change to List<? extends DomainNamedElement>
}
