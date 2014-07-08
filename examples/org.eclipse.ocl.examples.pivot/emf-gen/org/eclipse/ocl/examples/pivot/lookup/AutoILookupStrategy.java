package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.jdt.annotation.NonNull;


/**
 * Provides different lookup strategies when looking up elements. 
 * 
 * @author adolfosbh
 *
 */
public interface AutoILookupStrategy {
		
	/**
	 * Regardless the result a local lookup will not propagate to parent environments
	 */
	@NonNull
	static public final AutoILookupStrategy LOOKUP_ONLY_LOCAL = new AutoILookupStrategy() {
		public boolean shouldPropagateToParent(AutoILookupResult result) {
			return false;
		}
	};
		
	/**
	 * Regardless the result a "lookup all" will always propagate to parent
	 * environment to compute all possible results
	 */
	@NonNull
	static public final AutoILookupStrategy LOOKUP_ALL = new AutoILookupStrategy() {
		public boolean shouldPropagateToParent(AutoILookupResult result) {
			return true;
		}
	};
	
	/**
	 * Typical bottom-up lookup strategy. If an element has already found stop
	 * lookup propagation to parent environments
	 */
	@NonNull
	static public final AutoILookupStrategy LOOKUP_IN_PARENT_IF_NOT_FOUND = new AutoILookupStrategy() {
		
		public boolean shouldPropagateToParent(AutoILookupResult result) {
			if (result.getSize() == 0) {
				return false; // Not thing found is not a final result
			}
			return true;
		}
	};

	
	boolean shouldPropagateToParent(AutoILookupResult result);
	
}
