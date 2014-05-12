package org.eclipse.ocl.examples.pivot.lookup;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

public interface AutoIUnnamedLookupResult extends AutoILookupResult {

	/**
	 * @return a named indexed map of all reachable objects
	 */
	@NonNull
	Map<String, List<Object>> getAllResults();
}
