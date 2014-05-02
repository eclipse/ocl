package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


/**
 * Default implementation of {@link AutoILookupContext} 
 * 
 *  @param <R> see R at {@link AutoILookupContext}
 */
public class AutoLookupContext<R extends EObject> implements AutoILookupContext<R> {
	
	protected final @NonNull R target;                          // node in which a lookup is to be performed
	protected final @NonNull EStructuralFeature lookupFeature;  // target reference on which name resolution will be performed 
	protected final @Nullable R child;                          // node from which a lookup is to be performed

	private AutoLookupContext<R> parent = null; // Lazily computed scope view for target's parent
		
	protected AutoLookupContext(@NonNull EStructuralFeature lookupFeature , 
			@NonNull R target) {
		this (lookupFeature, target, null);
	}
	
	protected AutoLookupContext(@NonNull EStructuralFeature lookupFeature ,
			@NonNull R target, @Nullable R child) {
		this.target = target;
		this.lookupFeature = lookupFeature;
		this.child = child;
	}
	
	public final @NonNull R getTarget() {
		return target;
	}
	
	public @Nullable R getChild() {
		return child;
	}
	
	@Nullable
	public EReference getToChildReference() {
		EObject child2 = child;
		return child2 == null ? null : child2.eContainmentFeature();
	}
	
	@NonNull
	public EStructuralFeature getLookupFeature() {
		return lookupFeature;
	}

	public @Nullable AutoLookupContext<R> getParent() {
		if (parent == null) {
			@SuppressWarnings("unchecked") // Assumption: All the objects are R as the API specifies 
			R container = (R) target.eContainer();
			if (container != null) {
				parent = new AutoLookupContext<R>(lookupFeature, container, target);
			} else {
				parent = null;
			}
		}
		return parent;
	}
	


	@Override
	public String toString() {
		R target = getTarget();
		StringBuilder s = new StringBuilder();
		s.append("["); //$NON-NLS-1$
		s.append(target.eClass().getName());
		EStructuralFeature containmentRef = getToChildReference();
		if (containmentRef != null) {
			s.append("::"); //$NON-NLS-1$
			s.append(containmentRef.getName());
		}
		s.append("] "); //$NON-NLS-1$
		s.append(String.valueOf(target));
		return s.toString();
	}
}
