package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


public class AutoNamedLookupEnvironment extends  AutoLookupEnvironment
	implements AutoINamedLookupEnvironment {

	@NonNull protected String name;
	
	public AutoNamedLookupEnvironment(@NonNull EStructuralFeature reference, @NonNull String name) {
		super(reference, AutoILookupStrategy.LOOKUP_IN_PARENT_IF_NOT_FOUND, new AutoNamedLookupResult(name));
		this.name = name;
	}
	
	@Override
	public @NonNull
	AutoINamedLookupResult getResult() {
		return (AutoINamedLookupResult)super.getResult();
	}
	
	protected void addElements(@Nullable Iterable<? extends Object> elements) {
		if (elements != null) {
			for (Object element : elements) {
				if (name.equals(getName(element))) {
					addElement(name, element);
				}
			}
		}
	}
}