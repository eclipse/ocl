package org.eclipse.ocl.pivot.internal.lookup;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;


/**
 * @since 3.5
 */
public interface ISingleResultEnvironment extends Environment {

	/**
	 * @return the matched result (or the first ambiguous one), otherwise <code>null</code>
	 */
	@Nullable
	NamedElement getSingleResult();
	
	/**
	 * @return a list with all matched (ambiguous) results. If no results are found,  it will return an empty list
	 */
	@NonNull
	List<NamedElement> getAllResults();	// FIXME, if no case of heterogeneous results is needed, change to List<? extends DomainNamedElement>
}
