package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;


public class AutoUnnamedLookupEnvironment extends AutoLookupEnvironment
	implements AutoIUnnamedLookupEnvironment{

	public AutoUnnamedLookupEnvironment(@NonNull EStructuralFeature reference) {
		super(reference, AutoILookupStrategy.LOOKUP_ALL, new AutoUnnamedLookupResult());
	}
	
	@Override
	@NonNull
	public AutoIUnnamedLookupResult getResult() {		
		return (AutoIUnnamedLookupResult)super.getResult();
	}
	protected void addElements(Iterable<? extends Object> elements) {
		if (elements != null) {
			for (Object element : elements) {
				addNamedElement(element);
			}	
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ocl.examples.pivot.lookup.AutoLookupEnvironment#isComplete()
	 * 
	 * The environment used to do unnamed lookups is never complete since all the names
	 * needs to be searched
	 */
	@Override
	public boolean isComplete() {		
		return false;
	}
}

