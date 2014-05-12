package org.eclipse.ocl.examples.pivot.lookup;


import org.eclipse.jdt.annotation.NonNull;


public interface AutoILookupResult {
	
	void addElement(@NonNull String name, @NonNull Object element);
	
	int getSize();
}