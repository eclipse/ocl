package org.eclipse.ocl.examples.pivot.lookup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


public class AutoNamedLookupResult<C extends EObject> implements AutoINamedLookupResult<C> {

	public static @NonNull  
	<C extends EObject> AutoINamedLookupResult<C> emptyResult() {
		return new AutoINamedLookupResult<C>() {

			public void addElement(@NonNull String name, @NonNull Object element) {
				throw new IllegalStateException("This empty result was not conceived to add elements "); 
			}

			public int getSize() {
				return 0;
			}

			@Nullable
			public C getSingleResult() {
				return null;
			}

			@SuppressWarnings("null")
			@NonNull
			public List<C> getAllResults() {
				return Collections.emptyList();
			}
		};
	}
	private static final Logger logger = Logger.getLogger(AutoNamedLookupResult.class);
	private @NonNull List<C> elements = new ArrayList<C>();
	private @NonNull String name; 
	
	public AutoNamedLookupResult(@NonNull String name) {
		this.name = name;
	}
	
	public void addElement(@NonNull String name, @NonNull Object element) {
		assert(this.name == name);
		if (!elements.contains(element)) { 	// FIXME use a set ?
			elements.add((C)element);		// FIXME lose cast
		}
	}

	public int getSize() {
		return elements.size();
	}

	@Nullable
	public C getSingleResult() {
		int contentsSize = elements.size();
		if (contentsSize > 1) {
			logger.warn("Unhandled ambiguous content for '" + name + "'");
		}
		return  contentsSize == 0 ? null : elements.get(0);
	}

	@NonNull
	public List<C> getAllResults() {
		return elements;
	}
}
