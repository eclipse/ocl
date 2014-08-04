package org.eclipse.ocl.examples.pivot.lookup;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


/**
 * @since 3.5
 */
public class SingleResultEnvironment implements ISingleResultEnvironment {
	
	
	private static final Logger logger = Logger.getLogger(SingleResultEnvironment.class);
	private @NonNull List<DomainNamedElement> elements = new ArrayList<DomainNamedElement>();
	private @NonNull String name; 
	private @NonNull DomainEvaluator evaluator;
	
	
	public SingleResultEnvironment(@NonNull MetaModelManager mmManager, @NonNull DomainEvaluator evaluator, @NonNull String name) {
		this.evaluator = evaluator;
		this.name = name;
		this.metaModelManager = mmManager;
	}
	
	@NonNull
	public Environment addElement(@Nullable DomainNamedElement namedElement) {
		if (namedElement != null) {
			if (name.equals(namedElement.getName())) {
				if (!elements.contains(namedElement)) { 	// FIXME use a set ?
					elements.add(namedElement);
				}
			}
		}
		return this;
	}
	
	
	@NonNull
	public Environment addElements(
			@Nullable List<? extends DomainNamedElement> namedElements) {
		
		if (namedElements != null) {
			for (DomainNamedElement namedElement : namedElements) {
				addElement(namedElement);
			}	
		}
		return this;
	}

	public int getSize() {
		return elements.size();
	}

	@Nullable
	public DomainNamedElement getSingleResult() {
		int contentsSize = elements.size();
		if (contentsSize > 1) {
			logger.warn("Unhandled ambiguous content for '" + name + "'");
		}
		return  contentsSize == 0 ? null : elements.get(0);
	}

	@NonNull
	public List<DomainNamedElement> getAllResults() {
		return elements;
	}
	
	
	public boolean hasFinalResult() {
		// Not thing found is not a final result
		return elements.size() == 0 ? false : true;
	}
	
	@NonNull
	public DomainEvaluator getEvaluator() {
		return evaluator;
	}
	
//	To delete
//	public String getName() {
//		return name;
//	}
	
	//
	// ADDITIONAL STUFF TO INTEGRATE WITH
	//
	
	public static abstract class Disambiguator<T> implements Comparator<T>
	{
	    public int compare(T o1, T o2) {
		    throw new UnsupportedOperationException();
	    }
	    
	    public abstract int compare(@NonNull MetaModelManager metaModelManager, @NonNull T o1, @NonNull T o2);
	}
	
	private static final class ImplicitDisambiguator extends Disambiguator<Object>
	{
		@Override
		public int compare(@NonNull MetaModelManager metaModelManager, @NonNull Object match1, @NonNull Object match2) {
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
	
	private static final class MetamodelMergeDisambiguator extends Disambiguator<Feature>
	{
		@Override
		public int compare(@NonNull MetaModelManager metaModelManager, @NonNull Feature match1, @NonNull Feature match2) {
			org.eclipse.ocl.examples.pivot.Package p1 = PivotUtil.getContainingPackage(match1);
			org.eclipse.ocl.examples.pivot.Package p2 = PivotUtil.getContainingPackage(match2);
			if (p1 == null) {
				return 0;
			}
			if (p2 == null) {
				return 0;
			}
			PackageManager packageManager = metaModelManager.getPackageManager();
			PackageServer s1 = packageManager.getPackageServer(p1);
			PackageServer s2 = packageManager.getPackageServer(p2);
			if (s1 != s2) {
				return 0;
			}
			int i1 = s1.getIndex(p1);
			int i2 = s2.getIndex(p2);
			return i2 - i1;
		}
	}

	private static final class OperationDisambiguator extends Disambiguator<Operation>
	{
		@Override
		public int compare(@NonNull MetaModelManager metaModelManager, @NonNull Operation match1, @NonNull Operation match2) {
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

	private static final class PropertyDisambiguator extends Disambiguator<Property>
	{
		@Override
		public int compare(@NonNull MetaModelManager metaModelManager, @NonNull Property match1, @NonNull Property match2) {
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
			
	private static @NonNull LinkedHashMap<Class<?>, List<Comparator<Object>>> disambiguatorMap =	// FIXME narrow API to Disambiguator
		new LinkedHashMap<Class<?>, List<Comparator<Object>>>();

	static {
		addDisambiguator(Object.class, new ImplicitDisambiguator());
		addDisambiguator(Feature.class, new MetamodelMergeDisambiguator());
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
	private Map<Object, Map<TemplateParameter, ParameterableElement>> templateBindings = null;
	private List<ScopeFilter> matchers = null;	// Prevailing filters for matching
	private Set<ScopeFilter> resolvers = null;	// Successful filters for resolving
	
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
	
	@NonNull
	public SingleResultEnvironment resolveDuplicates() {
		if (elements.size() > 1)  {
			// FIXME this WAS done while "adding" elements. Adding here where they are supposed
			// to be used. Talk with ED about this.
			if (matchers != null) {
				if (resolvers == null) {
					resolvers = new HashSet<ScopeFilter>();
				}
				resolvers.addAll(matchers);
			}
			for (int i = 0; i < elements.size()-1;) {
				boolean iRemoved = false;
				@SuppressWarnings("null") @NonNull Object iValue = elements.get(i);
				Map<TemplateParameter, ParameterableElement> iBindings = templateBindings != null ? templateBindings.get(iValue) : null;
				for (int j = i + 1; j < elements.size();) {
					Class<?> iClass = iValue.getClass();
					@SuppressWarnings("null") @NonNull Object jValue = elements.get(j);
					Class<?> jClass = jValue.getClass();
					int verdict = 0;
					for (Class<?> key : disambiguatorMap.keySet()) {
						if (key.isAssignableFrom(iClass) && key.isAssignableFrom(jClass)) {
							for (Comparator<Object> comparator : disambiguatorMap.get(key)) {
								if (comparator instanceof Disambiguator<?>) {
									verdict = ((Disambiguator<Object>)comparator).compare(metaModelManager, iValue, jValue);
								} else {
									verdict = comparator.compare(iValue, jValue);
								}
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
						elements.remove(i);
						iRemoved = true;
						break;
					} else {
						elements.remove(j);
					}
				}
				if (!iRemoved) {
					i++;
				}				
			}
		}
		return this;
	}
}
