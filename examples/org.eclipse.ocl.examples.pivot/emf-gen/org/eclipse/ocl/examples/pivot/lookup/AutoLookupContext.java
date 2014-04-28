package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


/**
 * Default implementation of {@link AutoILookupContext}
 * 
 * @author adolfosbh
 */
public class AutoLookupContext implements AutoILookupContext {
	
	protected final @NonNull EObject target;							// node in which a lookup is to be performed
	protected final @NonNull EStructuralFeature lookupFeature;			// target reference on which name resolution will be performed 
	protected final @Nullable EObject child;							// node from which a lookup is to be performed

	private AutoLookupContext parent = null; // Lazily computed scope view for target's parent
		
	protected AutoLookupContext(@NonNull EStructuralFeature lookupFeature , 
			@NonNull EObject target) {
		this (lookupFeature, target, null);
	}
	
	protected AutoLookupContext(@NonNull EStructuralFeature lookupFeature ,
			@NonNull EObject target, @Nullable EObject child) {
		this.target = target;
		this.lookupFeature = lookupFeature;
		this.child = child;
	}
	
	public final @NonNull EObject getTarget() {
		return target;
	}
	
	public @Nullable EObject getChild() {
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

	public @Nullable AutoLookupContext getParent() {
		if (parent == null) {
			EObject container = target.eContainer();
			if (container != null) {
				parent = new AutoLookupContext(lookupFeature, container, target);
			} else {
				parent = null; // TODO
			}
		}
		return parent;
	}
	


	@Override
	public String toString() {
		EObject target = getTarget();
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
