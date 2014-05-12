package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;


public interface AutoINamedLookupEnvironment<C extends EObject> extends AutoILookupEnvironment {
	
	@NonNull
	public AutoINamedLookupResult<C> getResult();
}
