package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;


/**
 * Interface to carry the results of a lookup process
 * 
 * @author adolfosbh
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
	C getContent();

	// TEMPORAL STUFF
	// FIXME can we get rid of this ?
	/**
	 * Convenience method to remove name duplicates so that it can be called
	 * once the lookup process finishes 
	 * 
	 * @return returns this {@link AutoILookupResult} after resolving duplicates 
	 */
	@NonNull
	AutoILookupResult<C> resolveDuplicates();
	public void addFilter(@NonNull ScopeFilter filter);
	public void removeFilter(@NonNull ScopeFilter filter);
	// END OF TEMPORAL STUFF
	
	// TemplateableElement
	public void addTypeTemplateParameterables(@NonNull TemplateableElement object);
	
	// Operation
	public void addOwnedParameter(@NonNull Operation object);
	
	
	// Type
	public void addOwnedOperation(@NonNull Type type, boolean selectStatic);
	public void addOwnedProperty(@NonNull Type type, boolean selectStatic);
	
	// Class
	public void addOwnedState(@NonNull org.eclipse.ocl.examples.pivot.Class type);
	
	// Enumeration
	public void addOwnedEnumerationLiteral(@NonNull Enumeration enumeration);
}
