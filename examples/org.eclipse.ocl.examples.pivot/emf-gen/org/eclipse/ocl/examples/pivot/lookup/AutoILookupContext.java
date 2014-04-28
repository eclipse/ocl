package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


/**
 * Class providing some context needed to do the lookup
 * 
 * @author adolfosbh
 *
 */
public interface AutoILookupContext {
		
		
	/**
	 * Return the target node at which the lookup will be performed.
	 */
	@NonNull EObject getTarget();
	
	/**
	 * Return the immediate child node for which a lookup is requested.
	 */
	@Nullable EObject getChild();

	/**
	 * Return the containment feature of the child within the target.
	 */
	@Nullable EReference getToChildReference();

	/**
	 * Return the original structural feature for which a lookup is needed
	 */
	@NonNull EStructuralFeature getLookupFeature();
	
	/**
	 * Return the {@link AutoILookupContext} that characterizes a lookup in the parent of the target node.
	 * If the target element doesn't have parent, it returns <code>null</code> 
	 * @return The parent {@link AutoILookupContext} of the container element, or null if it doesn't exist
	 */
	@Nullable AutoILookupContext getParent();
}
