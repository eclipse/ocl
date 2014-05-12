package org.eclipse.ocl.examples.pivot.lookup;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.Nameable;


public abstract class AutoLookupEnvironment implements AutoILookupEnvironment {
	
	@SuppressWarnings("serial")
	protected static final class MyList extends ArrayList<Object> {}
	
	protected static final Logger logger = Logger.getLogger(AutoLookupEnvironment.class);
		
	protected final @NonNull EStructuralFeature lookupRef;
	protected @NonNull EClassifier lookupType;	


	private AutoILookupResult result;
	@SuppressWarnings("null")
	public AutoLookupEnvironment(@NonNull EStructuralFeature reference) {
		this.lookupRef = reference;
		this.lookupType = reference.getEType();
	}

	
	@SuppressWarnings("null")
	@NonNull
	public AutoILookupResult getResult() {
		if (result == null) {
			result = createResult();
		}
		return result;
	}
	
	@NonNull
	abstract protected AutoILookupResult createResult();
	
	/**
	 * TODO another class
	 *      use EMF by default, and allow derived classess to inject their policy
	 *      
	 * Comprises policies to obtain the name of an object 
	 * 
	 * @param object
	 * @return the name of the element 
	 */
	@Nullable
	protected String getName(Object object) {
		if (object instanceof Nameable) {
			return ((Nameable)object).getName();
		}
		return null;
	}
	
	protected void addNamedElement(Object object) {
		if (object == null) {
			return;
		}
		String name = getName(object);
		if (name != null) {
			addElement(name, object);
		}
	}
	

	/**
	 * Add an element with an elementName to the lookup result
	 * 
	 * @param elementName
	 *            name of element
	 * @param element
	 *            the element
	 */
	protected void addElement(/*@NonNull*/ String elementName, /*@NonNull*/ Object element) {
		if (elementName == null || element == null)
			return;
		getResult().addElement(elementName, element);
	}

	public boolean isComplete() {
		if (getResult().getSize() == 0) {
			return false; // Not thing found is not a final result
		}
		return true;
	}

	@NonNull
	public final EClassifier getType() {
		return lookupType;
	}

//	public void setRequiredType(@NonNull EClassifier requiredType) {
//		assert (requiredType == null) || PivotUtil.conformsTo(lookupRef.getEType(), requiredType);
//		this.lookupType = requiredType;
//	}
	
//	@Override
//	public String toString() {
//		StringBuilder s = new StringBuilder();
//		s.append(lookupRef.getName());
//		s.append(" : "); //$NON-NLS-1$
////		s.append(reference.getEType().getName());
////		if (lookupType != null) {
//			s.append(lookupType.getName());
////		}
//		s.append(" \""); //$NON-NLS-1$
//		if (name != null) {
//			s.append(name);
//		}
//		s.append("\" {"); //$NON-NLS-1$
//		String prefix = ""; //$NON-NLS-1$
//		for (String contentName : contentsByName.keySet()) {
//			s.append(prefix);
//			s.append(contentName);
//			Object content = contentsByName.get(contentName);
//			if (content instanceof List<?>) {
//				s.append("*");
//				s.append(((List<?>) content).size());
//			}
//			prefix = ","; //$NON-NLS-1$
//		}
//		s.append("}"); //$NON-NLS-1$
//		return s.toString();
//	}
}
