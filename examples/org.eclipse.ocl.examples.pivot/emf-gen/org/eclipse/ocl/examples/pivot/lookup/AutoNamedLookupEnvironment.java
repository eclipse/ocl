package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;


public class AutoNamedLookupEnvironment<C extends EObject> extends  AutoLookupEnvironment
	implements AutoINamedLookupEnvironment<C> {

	@NonNull protected String name;
	
	public AutoNamedLookupEnvironment(@NonNull EStructuralFeature reference, @NonNull String name) {
		super(reference);
		this.name = name;
	}
	
	@Override
	protected @NonNull
	AutoINamedLookupResult<C> createResult() {
		return new AutoNamedLookupResult<C>(name);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public @NonNull
	AutoINamedLookupResult<C> getResult() {
		return (AutoINamedLookupResult<C>)super.getResult();
	}
	protected void addElements(Iterable<? extends Object> elements) {
		if (elements != null) {
			for (Object element : elements) {
				if (name.equals(getName(element))) {
					addElement(name, element);
				}
			}
		}
	}
}