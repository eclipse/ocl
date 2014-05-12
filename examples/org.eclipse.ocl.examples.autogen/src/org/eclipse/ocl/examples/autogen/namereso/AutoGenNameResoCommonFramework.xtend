package org.eclipse.ocl.examples.autogen.namereso

import org.eclipse.ocl.examples.autogen.utilities.MergeWriter
import org.eclipse.jdt.annotation.NonNull

class AutoGenNameResoCommonFramework {
	
	private static AutoGenNameResoCommonFramework generator = new AutoGenNameResoCommonFramework();
	 
	def public static generateCommonFramework(@NonNull String outputFolder,@NonNull String pkgName ) {
		
		generator.generateLookupContextItf(outputFolder, pkgName);
		generator.generateLookupContextClass(outputFolder, pkgName);
		generator.generateLookupResultItf(outputFolder, pkgName);
		generator.generateLookupEnvironmentItf(outputFolder, pkgName);
		generator.generateLookupEnvironmentClass(outputFolder, pkgName);
	}
	
	protected def void generateLookupContextItf(@NonNull String outputFolder, @NonNull String packageName) {
		var MergeWriter writer = new MergeWriter(outputFolder + "AutoILookupContext.java");
		writer.append('''
package «packageName»;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
		
/**
 * This interface describes the context needed to do the lookup
 *
 * @param <R> a convenient "root" or "base" {@link EClass} in the class hierarchy of the context elements meta-model. 
 * If no such a root class exists, just use {@link EObject} 
 */

public interface AutoILookupContext<R extends EObject> {

	/**
	 * Return the target node at which the lookup will be performed.
	 */
	@NonNull R getTarget();

	/**
	 * Return the immediate child node for which a lookup is requested.
	 */
	@Nullable R getChild();

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
	@Nullable AutoILookupContext<R> getParent();
}
		''');
		writer.close();
	}

	protected def void generateLookupContextClass(@NonNull String outputFolder, @NonNull String packageName) {
		var MergeWriter writer = new MergeWriter (outputFolder + "AutoLookupContext.java") 
		writer.append('''
package «packageName»;

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
	''');
		writer.close();
	}
	
	protected def void generateLookupResultItf(@NonNull String outputFolder, @NonNull String packageName) {
		var MergeWriter writer = new MergeWriter(outputFolder + "AutoILookupResult.java");
		writer.append('''
package «packageName»;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Interface to carry the results of a lookup process
 * 
 */
public interface AutoILookupResult {

	void addElement(@NonNull String name, @NonNull Object element);
	
	int getSize();
}
	''');
		writer.close();
	}
	
	
	
	
	protected def void generateLookupEnvironmentItf(@NonNull String outputFolder, @NonNull String packageName) {
		var MergeWriter writer = new MergeWriter(outputFolder + "AutoLookupEnvironment.java");
		writer.append('''
package «packageName»;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
		
/**
 * Interface to carry the results of a lookup process
 * 
 */
public interface AutoILookupEnvironment {

	/**
	 * Return true once the AutoILookupResult has accumulated sufficient results
	 * to satisfy the lookup criterion for which it was created. i.e. when any result
	 * has been found in named lookups and once all the names has been computed
	 * in the case of unnamed lookups
	 */
	boolean isComplete();
		
	/**
	 * @return the type of the element to be looked up
	 */
	@NonNull
	EClassifier getType();
	
	@NonNull
	AutoILookupResult getResult();
}
		''');
	
	}
	protected def void generateLookupEnvironmentClass(@NonNull String outputFolder, @NonNull String packageName) {
		var MergeWriter writer = new MergeWriter(outputFolder + "AutoLookupEnvironment.java");
		writer.append('''
package «packageName»;

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
		''');
		writer.close();
	}
}