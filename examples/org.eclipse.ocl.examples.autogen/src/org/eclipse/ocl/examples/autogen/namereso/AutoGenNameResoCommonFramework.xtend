package org.eclipse.ocl.examples.autogen.namereso

import org.eclipse.ocl.examples.autogen.utilities.MergeWriter
import org.eclipse.jdt.annotation.NonNull

class AutoGenNameResoCommonFramework {
	
	private static AutoGenNameResoCommonFramework generator = new AutoGenNameResoCommonFramework();
	 
	def public static generateCommonFramework(@NonNull String outputFolder,@NonNull String pkgName ) {
		
		generator.generateLookupContextItf(outputFolder, pkgName);
		generator.generateLookupContextClass(outputFolder, pkgName);
		generator.generateLookupResultItf(outputFolder, pkgName);
		generator.generateLookupResultClass(outputFolder, pkgName);
		generator.generateLookupKind(outputFolder, pkgName);
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

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
		
/**
 * Interface to carry the results of a lookup process
 * 
 */
public interface AutoILookupResult<C extends EObject> {

	/**
	 * Return true once the AutoILookupResult has accumulated sufficient results
	 * to satisfy the lookup criterion for which it was created. i.e. any result
	 * for a non-null name, all results for a null name.
	 */
	boolean isComplete();
		
	@NonNull
	EClassifier getType();
	
	int getSize();
	
	@Nullable
	C getSingleResult();
	/**
	 * @return a list with all matched results. If no results are found,  it will return an empty list
	 */
	@NonNull
	List<C> getAllResults();

	// TEMPORAL STUFF
	// ASBH FIXME can we get rid of this ?
	/**
	 * Convenience method to remove name duplicates so that it can be called
	 * once the lookup process finishes 
	 * 
	 * @return returns this {@link AutoILookupResult} after resolving duplicates 
	 */
	@NonNull
	AutoILookupResult<C> resolveDuplicates();
	// END OF TEMPORAL STUFF
}
		''');
		writer.close();
	}
	
	protected def void generateLookupResultClass(@NonNull String outputFolder, @NonNull String packageName) {
		var MergeWriter writer = new MergeWriter(outputFolder + "AutoLookupResult.java");
		writer.append('''
package «packageName»;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


public class AutoLookupResult<C extends EObject> implements AutoILookupResult<C>{
	
	private static final class ImplicitDisambiguator implements Comparator<Object>
	{
		public int compare(Object match1, Object match2) {
			boolean match1IsImplicit = (match1 instanceof Property) && ((Property)match1).isImplicit();
			boolean match2IsImplicit = (match2 instanceof Property) && ((Property)match2).isImplicit();
			if (!match1IsImplicit) {
				return match2IsImplicit ? 1 : 0;				// match2 inferior			
			}
			else {
				return match2IsImplicit ? 0 : -1;				// match1 inferior			
			}
		}
	}

	private static final class OperationDisambiguator implements Comparator<Operation>
	{
		@SuppressWarnings("null")
		public int compare(Operation match1, Operation match2) {
			if (isRedefinitionOf(match1, match2)) {
				return 1;				// match2 inferior			
			}
			if (isRedefinitionOf(match2, match1)) {
				return -1;				// match1 inferior			
			}
			return 0;
		}

		protected boolean isRedefinitionOf(@NonNull Operation operation1, @NonNull Operation operation2) {
			List<Operation> redefinedOperations = operation1.getRedefinedOperation();
			for (Operation redefinedOperation : redefinedOperations) {
				if (redefinedOperation != null) {
					if (redefinedOperation == operation2) {
						return true;
					}
					if (isRedefinitionOf(redefinedOperation, operation2)) {
						return true;
					}
				}
			}
			return false;
		}
	}

	private static final class PropertyDisambiguator implements Comparator<Property>
	{
		@SuppressWarnings("null")
		public int compare(Property match1, Property match2) {
			if (isRedefinitionOf(match1, match2)) {
				return 1;				// match2 inferior			
			}
			if (isRedefinitionOf(match2, match1)) {
				return -1;				// match1 inferior			
			}
			return 0;
		}

		protected boolean isRedefinitionOf(@NonNull Property property1, @NonNull Property property2) {
			List<Property> redefinedProperties = property1.getRedefinedProperty();
			for (Property redefinedProperty : redefinedProperties) {
				if (redefinedProperty != null) {
					if (redefinedProperty == property2) {
						return true;
					}
					if (isRedefinitionOf(redefinedProperty, property2)) {
						return true;
					}
				}
			}
			return false;
		}
	}
	
	@SuppressWarnings("serial")
	private static final class MyList<C> extends ArrayList<C> {}
	
	private static final Logger logger = Logger.getLogger(AutoLookupResult.class);
	
	private static @NonNull LinkedHashMap<Class<?>, List<Comparator<Object>>> disambiguatorMap =
			new LinkedHashMap<Class<?>, List<Comparator<Object>>>();

	static {
		addDisambiguator(Object.class, new ImplicitDisambiguator());
		addDisambiguator(Operation.class, new OperationDisambiguator());
		addDisambiguator(Property.class, new PropertyDisambiguator());
	}
	
	public static synchronized <T> void addDisambiguator(@NonNull Class<T> targetClass, @NonNull Comparator<T> disambiguator) {
		List<Comparator<Object>> disambiguators = disambiguatorMap.get(targetClass);
		if (disambiguators == null) {
			disambiguators = new ArrayList<Comparator<Object>>();
			disambiguatorMap.put(targetClass, disambiguators);
		}
		@SuppressWarnings("unchecked")
		Comparator<Object> castDisambiguator = (Comparator<Object>) disambiguator;
		disambiguators.add(castDisambiguator);
	}

	@SuppressWarnings("null")
	public static @NonNull Iterable<Class<?>> getDisambiguatorKeys() {
		return disambiguatorMap.keySet();
	}

	public static @Nullable List<Comparator<Object>> getDisambiguators(@NonNull Class<?> key) {
		return disambiguatorMap.get(key);
	}
		
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull EStructuralFeature lookupRef;
	private @NonNull EClassifier lookupType;
	protected final AutoLookupKind lookupKind;
	protected final @Nullable String name;
	

	private final @NonNull Map<String, Object> contentsByName = new HashMap<String, Object>(); // Single Object or MyList
	private Map<C, Map<TemplateParameter, ParameterableElement>> templateBindings = null;

	private int contentsSize = 0; // Deep size of contentsByName;

	private List<ScopeFilter> matchers = null;	// Prevailing filters for matching
	private Set<ScopeFilter> resolvers = null;	// Successful filters for resolving

	@SuppressWarnings("null")
	public AutoLookupResult(@NonNull MetaModelManager metaModelManager, @NonNull EStructuralFeature reference,
			@NonNull AutoLookupKind lookupKind, @Nullable String name) {
		this.metaModelManager = metaModelManager;
		this.lookupRef = reference;
		this.lookupType = reference.getEType();
		this.lookupKind = lookupKind;
		this.name = name;
	}

	public boolean accepts(/*@NonNull*/ EClass eClass) {
		assert eClass != null;
		// If eClass conformsTo requiredType every candidate will be type-compatible
		// If requiredType conformsTo eClass some candidates may be type-compatible
		// else no candidates can be type-compatible
		return (name == null) || PivotUtil.conformsTo(lookupType, eClass) || PivotUtil.conformsTo(eClass, lookupType);
	}

//	protected void computeLookups(Element element) {
//		AutoLookupKind lookupKind = name == null ? AutoLookupKind.ALL_EXACT : AutoLookupKind.SINGLE; 
//		element.accept(new AutoPivotLookupVisitor<C>(this, new AutoLookupContext<C>(metaModelManager, lookupRef, element, lookupKind, name, isQualifier)));
//	}
	
	
	protected void addElements(Iterable<? extends Object> elements) {
		
		if (elements != null) {
			String name2 = name;
			if (name2 != null) { // TODO use lookupKind
				for (Object parameter : elements) {
					if (name2.equals(getName(parameter))) {
						addElement(name2, parameter);
					}
				}
			}
			else {
				for (Object element : elements) {
					addNamedElement(element);
				}
			}
		}
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
	 * TODO another class
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

	/**
	 * Add an element with an elementName to the lookup result
	 * 
	 * @param elementName
	 *            name of element
	 * @param element
	 *            the element
	 */
	protected void addElement(/*@NonNull*/ String elementName, /*@NonNull*/ Object element) {
		if ((elementName == null) || (element == null)) {
			return;
		}
		if ((element instanceof EObject) && !(element instanceof Variable) && (((EObject)element).eResource() == null)) {
			// Orphans are bad but LetExp/LoopExp/ExpressionInOCL Variables are created left-to-right
			logger.error("Orphan '" + element + "'");
			return;
		}
		if ((name != null) && !name.equals(elementName)) {
			assert !(element instanceof DomainProperty) &&  !(element instanceof DomainOperation);
			return;
		}
		if (element instanceof PackageServer) {
			element = ((PackageServer)element).getPivotPackage();
		}
		else if (element instanceof DomainPackage) {
			element = metaModelManager.getPackageServer((DomainPackage) element).getPivotPackage();
		}
//		else if (element instanceof org.eclipse.ocl.examples.pivot.Package) {
//			element = ((PackageServer) element).getPrimaryPackage();		// FIXME lose casts
//		}
//		else if (element instanceof TypeServer) {
//			element = ((TypeServer) element).getPrimaryType();		// FIXME lose casts
//		}
		else if (element instanceof EObject) {
			element = metaModelManager.getPrimaryElement((EObject) element);		// FIXME lose casts
		}
		if ((name != null) && (matchers != null)) {
			for (ScopeFilter filter : matchers) {
				if (filter instanceof ScopeFilter.ScopeFilter2){
					if (!((ScopeFilter.ScopeFilter2<C>)filter).matches(this, (C)element)) { // FIXME ADOLFOSBH
						return;
					}
				}
			}
		}
		/*if (element instanceof PackageServer) {
			element = ((PackageServer) element).getPrimaryPackage();		// FIXME lose casts
		}
		else*/ if (element instanceof TypeServer) {
			element = ((TypeServer) element).getPivotType();		// FIXME lose casts
		}
		if (name != null) {
			if (!lookupType.isInstance(element)) {
				return;
			}
		}
		if (matchers != null) {
			if (resolvers == null) {
				resolvers = new HashSet<ScopeFilter>();
			}
			resolvers.addAll(matchers);
		}
		Object value = contentsByName.get(elementName);
		if (value == element) {
			;	// Already present
		} else if (value == null) {
			contentsByName.put(elementName, element);
			contentsSize++;
		} else {
			MyList<C> values;
			if (value instanceof MyList) {
				values = (MyList<C>)value;
			} else {
				values = new MyList<C>();
				values.add((C)value);
				contentsByName.put(elementName, values);
			}
			if (!values.contains(element)) {
				values.add((C)element);
				contentsSize++;
			}
		}
	}
	

	
	public void addFilter(@NonNull ScopeFilter filter) {
		if (matchers == null) {
			matchers = new ArrayList<ScopeFilter>();
		}
		matchers.add(filter);
	}
	
	public void removeFilter(@NonNull ScopeFilter filter) {
		if (matchers != null) {
			matchers.remove(filter);
		}
	}

	public void addImportedElement(@NonNull URI baseURI) {
    	if (PivotUtil.isASURI(baseURI)) {
    		baseURI = PivotUtil.getNonASURI(baseURI);
    	}		
		if (name != null) {
			@SuppressWarnings("null")
			@NonNull URI uri = URI.createURI(name).resolve(baseURI);
			try {
				Element importedElement = metaModelManager.loadResource(uri, null, null);
				if (importedElement != null) {
					addElement(name, importedElement);
				}
			} catch (Exception e) {
				// if it doesn't load just treat it as unresolved
			}
		}
	}

	public @Nullable C getSingleResult() {
		if (contentsSize == 0) {
			return null;
		}
		if (contentsSize != 1) {
			logger.warn("Unhandled ambiguous content for '" + name + "'");
		}
		for (Map.Entry<String, Object> entry : contentsByName.entrySet()) {
			Object value = entry.getValue();
			if (value instanceof MyList) {
				MyList<C> values = (MyList<C>) value; // FIXME 
				value = values.get(values.size() - 1);
			}
			if (value instanceof EObject) {
				return (C) value; // FIXME 
			}
		}
		return null;
	}
	
	@SuppressWarnings("null")
	@NonNull
	public List<C> getAllResults() {
		if (contentsSize == 0) {
			return Collections.<C>emptyList();
		}		
		if (contentsSize != 1) {
			logger.warn("Unhandled ambiguous content for '" + name + "'");
		}
		List<C> allResults = new ArrayList<C>();
		for (Map.Entry<String, Object> entry : contentsByName.entrySet()) {
			Object value = entry.getValue();
			if (value instanceof MyList) {
				allResults.addAll((MyList<C>)value); // FIXME
			}
			if (value instanceof EObject) {
				allResults.add((C)value); // FIXME 
			}
		}
		return allResults;
	}

	public @NonNull Set<Map.Entry<String, Object>> getEntries() {
		@SuppressWarnings("null") @NonNull Set<Entry<String, Object>> result = contentsByName.entrySet();
		return result;
	}

	public boolean isComplete() {
		if (contentsSize == 0) {
			return false; // Not thing found is not a final result
		}
		if (name == null) {
			return false; // No name means search full hierarchy
		}
		return true;
	}

	@NonNull
	public final EClassifier getType() {
		return lookupType;
	}

	public final int getSize() {
		return contentsSize;
	}

	@NonNull
	public MetaModelManager getMetaModelManager() {		
		return metaModelManager;
	}
	
	public void setBindings(@NonNull C object, @Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		if (templateBindings == null) {
			templateBindings = new HashMap<C, Map<TemplateParameter, ParameterableElement>>();
		}
		templateBindings.put(object, bindings);
	}

//	public void setRequiredType(@NonNull EClassifier requiredType) {
//		assert (requiredType == null) || PivotUtil.conformsTo(lookupRef.getEType(), requiredType);
//		this.lookupType = requiredType;
//	}

	@NonNull
	public AutoILookupResult<C> resolveDuplicates() {
		if ((contentsSize > 1) && (name != null)) {
			int newSize = 0;
			for (Map.Entry<String, Object> entry : contentsByName.entrySet()) {
				Object listOrValue = entry.getValue();
				if (listOrValue instanceof MyList) {
					MyList values = (MyList) listOrValue;
					for (int i = 0; i < values.size()-1;) {
						boolean iRemoved = false;
						@SuppressWarnings("null") @NonNull Object iValue = values.get(i);
						Map<TemplateParameter, ParameterableElement> iBindings = templateBindings != null ? templateBindings.get(iValue) : null;
						for (int j = i + 1; j < values.size();) {
							Class<?> iClass = iValue.getClass();
							@SuppressWarnings("null") @NonNull Object jValue = values.get(j);
							Class<?> jClass = jValue.getClass();
							int verdict = 0;
							for (Class<?> key : disambiguatorMap.keySet()) {
								if (key.isAssignableFrom(iClass) && key.isAssignableFrom(jClass)) {
									for (Comparator<Object> comparator : disambiguatorMap.get(key)) {
										verdict = comparator.compare(iValue, jValue);
										if (verdict != 0) {
											break;
										}
									}
									if (verdict != 0) {
										break;
									}
								}
							}
							if ((verdict == 0) && (resolvers != null)) {
								Map<TemplateParameter, ParameterableElement> jBindings = templateBindings != null ? templateBindings.get(jValue) : null;
								for (ScopeFilter filter : resolvers) {
									verdict = filter.compareMatches(metaModelManager, iValue, iBindings, jValue, jBindings);
									if (verdict != 0) {
										break;
									}
								}
							}
							if (verdict == 0) {
								j++;
							} else if (verdict < 0) {
								values.remove(i);
								iRemoved = true;
								break;
							} else {
								values.remove(j);
							}
						}
						if (!iRemoved) {
							i++;
						}
					}
					newSize += values.size();
				} else {
					newSize++;
				}
			}
			contentsSize = newSize;
		}
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(lookupRef.getName());
		s.append(" : "); //$NON-NLS-1$
//		s.append(reference.getEType().getName());
//		if (lookupType != null) {
			s.append(lookupType.getName());
//		}
		s.append(" \""); //$NON-NLS-1$
		if (name != null) {
			s.append(name);
		}
		s.append("\" {"); //$NON-NLS-1$
		String prefix = ""; //$NON-NLS-1$
		for (String contentName : contentsByName.keySet()) {
			s.append(prefix);
			s.append(contentName);
			Object content = contentsByName.get(contentName);
			if (content instanceof List<?>) {
				s.append("*");
				s.append(((List<?>) content).size());
			}
			prefix = ","; //$NON-NLS-1$
		}
		s.append("}"); //$NON-NLS-1$
		return s.toString();
	}
}
		''');
		writer.close();
	}
	
	
	protected def void generateLookupKind(@NonNull String outputFolder, @NonNull String packageName) {
		var MergeWriter writer = new MergeWriter(outputFolder + "AutoLookupKind.java");
		writer.append('''
package «packageName»;

public enum AutoLookupKind {
	SINGLE,
	ALL_EXACT,
	ALL_PARTIAL
}
	''');
		writer.close();
	}
}