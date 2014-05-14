package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;


public class AutoNamedLookupEnvironment extends  AutoLookupEnvironment
	implements AutoINamedLookupEnvironment {

	@NonNull protected String name;
	
	public AutoNamedLookupEnvironment(@NonNull EStructuralFeature reference, @NonNull String name) {
		super(reference);
		this.name = name;
	}
	
	@Override
	protected @NonNull
	AutoINamedLookupResult createResult() {
		return new AutoNamedLookupResult(name);
	}
	
	@Override
	public @NonNull
	AutoINamedLookupResult getResult() {
		return (AutoINamedLookupResult)super.getResult();
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