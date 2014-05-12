package org.eclipse.ocl.examples.pivot.lookup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.lookup.AutoLookupEnvironment.MyList;


public class AutoUnnamedLookupResult implements AutoIUnnamedLookupResult {

	protected final @NonNull Map<String, List<Object>> contentsByName = new HashMap<String, List<Object>>(); // Single Object or MyList
	protected int contentsSize = 0; // Deep size of contentsByName;
	
	public void addElement(@NonNull String name, @NonNull Object element) {
		Object value = contentsByName.get(name);
		if (value == element) {
			;	// Already present
		} else {
			MyList values;
			if (value instanceof MyList) {
				values = (MyList)value;
			} else {
				values = new MyList();
				values.add(value);
				contentsByName.put(name, values);
			}
			if (!values.contains(element)) {
				values.add(element);
				contentsSize++;
			}
		}
	}

	public int getSize() {
		return contentsSize;
	}

	@NonNull
	public Map<String, List<Object>> getAllResults() {
		return contentsByName;
	}

}
