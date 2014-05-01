package org.eclipse.ocl.examples.pivot.lookup;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
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
	C getSingleResult();
	/**
	 * @return a list with all matched results. If no results are found,  it will return an empty list
	 */
	@NonNull
	List<C> getAllResults();

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
	@NonNull
	public MetaModelManager getMetaModelManager();
	public void setBindings(@NonNull C object, @Nullable Map<TemplateParameter, ParameterableElement> bindings);
	// END OF TEMPORAL STUFF
}
