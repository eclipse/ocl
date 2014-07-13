/*******************************************************************************
 * Copyright (c) 2010,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.scoping;

import java.util.ArrayList;
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
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.manager.RootPackageServer;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.utilities.IllegalLibraryException;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * An EnvironmentView provides a selective view of the environment visible at
 * some CS node.
 * 
 * The selection corresponds to an Environment lookup method as defined by the
 * OCL specification computed in accordance with the the Inherited Attributes.
 * 
 * The selective view is normally for just the single name required by the
 * lookUp, but may be for all names when a Completion Assist is required.
 * 
 * The EnvironmentView is computed on demand, rather than cached, since only
 * small parts of the overall environment are needed and caches may not remain
 * valid for long given the rapid recreation of CS nodes that occurs while
 * editing.
 */
public class EnvironmentView
{
	/**
	 * @since 3.5
	 */
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
	
	@SuppressWarnings("serial")
	private static final class MyList extends ArrayList<Object> {}
	
	private static final Logger logger = Logger.getLogger(EnvironmentView.class);
	
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
	protected final @NonNull EStructuralFeature reference;
	private EClassifier requiredType;
	private boolean isQualifier;
	protected final @Nullable String name;

	private final @NonNull Map<String, Object> contentsByName = new HashMap<String, Object>(); // Single Object or MyList
	private Map<Object, Map<TemplateParameter, ParameterableElement>> templateBindings = null;

	private int contentsSize = 0; // Deep size of contentsByName;

	private List<ScopeFilter> matchers = null;	// Prevailing filters for matching
	private Set<ScopeFilter> resolvers = null;	// Successful filters for resolving

	public EnvironmentView(@NonNull MetaModelManager metaModelManager, @NonNull EStructuralFeature reference, @Nullable String name) {
		this.metaModelManager = metaModelManager;
		this.reference = reference;
		this.requiredType = reference.getEType();
		this.isQualifier = false;
		this.name = name;
	}

	public boolean accepts(/*@NonNull*/ EClass eClass) {
		assert eClass != null;
		// If eClass conformsTo requiredType every candidate will be type-compatible
		// If requiredType conformsTo eClass some candidates may be type-compatible
		// else no candidates can be type-compatible
		return (name == null) || PivotUtil.conformsTo(requiredType, eClass) || ((requiredType != null) && PivotUtil.conformsTo(eClass, requiredType));
	}

	public void addAllElements(@NonNull Type type, @NonNull ScopeView scopeView) {
		Element element = PivotUtil.getLowerBound(type);
		Attribution attribution = PivotUtil.getAttribution(element);
		attribution.computeLookup(element, this, scopeView);
		TemplateableElement type2 = type.getUnspecializedElement();
		element = (type2 instanceof Type ? (Type)type2 : type).getPackage();
		if (element != null) {
			attribution = PivotUtil.getAttribution(element);
			attribution.computeLookup(element, this, scopeView);
		}
		if (type instanceof Metaclass<?>) {
			Type instanceType = ((Metaclass<?>)type).getInstanceType();
			if (instanceType != null) {
				element = PivotUtil.getLowerBound(instanceType);
				attribution = PivotUtil.getAttribution(element);
				attribution.computeLookup(element, this, scopeView);
			}
		}
		else {
			element = (type2 instanceof Type ? (Type)type2 : type).getPackage();
			if (element != null) {
				attribution = PivotUtil.getAttribution(element);
				attribution.computeLookup(element, this, scopeView);
			}
		}
	}

	public void addAllEnumerationLiterals(org.eclipse.ocl.examples.pivot.Enumeration pivot) {
		if (accepts(PivotPackage.Literals.ENUMERATION_LITERAL)) {
			String name2 = name;
			if (name2 != null) {
				for (EnumerationLiteral literal : pivot.getOwnedLiteral()) {
					if ((literal != null) && name2.equals(literal.getName())) {
						addElement(name2, literal);
					}
				}
			}
			else {
				for (EnumerationLiteral literal : pivot.getOwnedLiteral()) {
					if (literal != null) {
						addNamedElement(literal);
					}
				}
			}
		}
	}

	public void addAllOperations(@NonNull Type type, @Nullable FeatureFilter featureFilter) {
		if (accepts(PivotPackage.Literals.ITERATION)		// If ITERATION is acceptable then so too is OPERATION
				&& (requiredType != PivotPackage.Literals.NAMESPACE)) {			// Don't really want operations when looking for NAMESPACE
			assert metaModelManager.isTypeServeable(type);
			type = PivotUtil.getUnspecializedTemplateableElement(type);
			TypeServer typeServer = metaModelManager.getTypeServer(type);
			String name2 = name;
			if (name2 != null) {
				for (DomainOperation operation : typeServer.getAllOperations(featureFilter, name2)) {
					if ((operation != null) /*&& (operation.isStatic() == selectStatic)*/) {
						addElement(name2, operation);
					}
				}
			}
			else {
				for (DomainOperation operation : typeServer.getAllOperations(featureFilter)) {
					if ((operation != null) /*&& (operation.isStatic() == selectStatic)*/) {
						addNamedElement(operation);
					}
				}
			}
		}
	}

	public void addAllPackages(@NonNull org.eclipse.ocl.examples.pivot.Package pkge) {
		if (accepts(PivotPackage.Literals.PACKAGE)) {
			PackageServer parentPackageServer = metaModelManager.getPackageServer(pkge);
			String name2 = name;
			if (name2 != null) {
				PackageServer packageServer = parentPackageServer.getMemberPackage(name2);
				if (packageServer != null) {
					addElement(name2, packageServer);
				}
			}
			else {
				for (PackageServer packageServer : parentPackageServer.getMemberPackages()) {
					if (packageServer != null) {
						addNamedElement(packageServer);
					}
				}
			}
		}
	}

	public void addAllPackages(@NonNull Root root) {
		if (accepts(PivotPackage.Literals.PACKAGE)) {
			String name2 = name;
			if (name2 != null) {
				for (org.eclipse.ocl.examples.pivot.Package pkge : root.getNestedPackage()) {
					if ((pkge != null) && name2.equals(pkge.getName())) {
						addElement(name2, metaModelManager.getPrimaryPackage(pkge));
					}
				}
			}
			else {
				for (org.eclipse.ocl.examples.pivot.Package pkge : root.getNestedPackage()) {
					if (pkge != null) {
						addNamedElement(metaModelManager.getPrimaryPackage(pkge));
					}
				}
			}
		}
	}

	public void addAllParameters(@NonNull Operation pivot) {
		if (accepts(PivotPackage.Literals.PARAMETER)) {
			String name2 = name;
			if (name2 != null) {
				for (Parameter parameter : pivot.getOwnedParameter()) {
					if (name2.equals(parameter.getName())) {
						addElement(name2, parameter);
					}
				}
			}
			else {
				for (Parameter parameter : pivot.getOwnedParameter()) {
					if (parameter != null) {
						addNamedElement(parameter);
					}
				}
			}
		}
	}

	public void addAllPrecedences(@NonNull Library pivot) {
		if (accepts(PivotPackage.Literals.PRECEDENCE)) {
			String name2 = name;
			if (name2 != null) {
				for (Precedence precedence : pivot.getOwnedPrecedence()) {
					if (name2.equals(precedence.getName())) {
						addElement(name2, precedence);
					}
				}
			}
			else {
				for (Precedence precedence : pivot.getOwnedPrecedence()) {
					if (precedence != null) {
						addNamedElement(precedence);
					}
				}
			}
		}
	}
	
	public void addAllProperties(@NonNull Type type, @Nullable FeatureFilter featureFilter) {
		if (accepts(PivotPackage.Literals.PROPERTY)
			&& (requiredType != PivotPackage.Literals.NAMESPACE)) {			// Don't really want properties when looking for NAMESPACE
			assert metaModelManager.isTypeServeable(type);
			TypeServer typeServer = metaModelManager.getTypeServer(type);
			String name2 = name;
			if (name2 != null) {
				for (DomainProperty property : typeServer.getAllProperties(featureFilter, name2)) {
					if (property != null) {
						addNamedElement(property);
					}
				}
			}
			else {
				for (DomainProperty property : typeServer.getAllProperties(featureFilter)) {
					if (property != null) {
						addNamedElement(property);
					}
				}
			}
		}
	}
	
	public void addAllStates(@NonNull Type type) {
		if (accepts(PivotPackage.Literals.STATE)) {
			assert metaModelManager.isTypeServeable(type);
			TypeServer typeServer = metaModelManager.getTypeServer(type);
			String name2 = name;
			if (name2 != null) {
				for (State state : typeServer.getAllStates(name2)) {
					if (state != null) {
						addNamedElement(state);
					}
				}
			}
			else {
				for (State state : typeServer.getAllStates()) {
					if (state != null) {
						addNamedElement(state);
					}
				}
			}
		}
	}

	public void addAllTemplateParameters(@NonNull TemplateableElement pivot) {
		if (accepts(PivotPackage.Literals.TYPE) || accepts(PivotPackage.Literals.OPERATION)) {
			List<TemplateParameter> templateParameters = PivotUtil.getTemplateParameters(pivot);
			String name2 = name;
			if (name2 != null) {
				for (TemplateParameter templateParameter : templateParameters) {
					if (templateParameter != null) {
						Nameable parameteredElement = (Nameable)templateParameter.getParameteredElement();
						if (name2.equals(parameteredElement.getName())) {
							addElement(name2, parameteredElement);
						}
					}
				}
			}
			else {
				for (TemplateParameter templateParameter : templateParameters) {
					if (templateParameter != null) {
						Nameable parameteredElement = (Nameable)templateParameter.getParameteredElement();
						if (parameteredElement != null) {
							addNamedElement(parameteredElement);
						}
					}
				}
			}
		}
	}

	public void addAllTypeTemplateParameterables(@NonNull TemplateableElement pivot) {
		if (accepts(PivotPackage.Literals.TYPE)) {
			List<Type> types = PivotUtil.getTypeTemplateParameterables(pivot);
			String name2 = name;
			if (name2 != null) {
				for (Type type : types) {
					if (name2.equals(type.getName())) {
						addElement(name2, type);
					}
				}
			}
			else {
				for (Type type : types) {
					if (type != null) {
						addNamedElement(type);
					}
				}
			}
		}
	}

	public void addAllTypes(@NonNull org.eclipse.ocl.examples.pivot.Package pkge) {
		if (accepts(PivotPackage.Literals.CLASS)) {
			PackageServer packageServer = metaModelManager.getPackageServer(pkge);
			String name2 = name;
			if (name2 != null) {
				Type type = packageServer.getMemberType(name2);
				if (type != null) {
					addNamedElement(type);
				}
			}
			else {
				for (TypeServer type : packageServer.getMemberTypes()) {
					if (type != null) {
						addNamedElement(type);
					}
				}
			}
		}
	}

	/**
	 * Add an element with an elementName to the view
	 * 
	 * @param elementName
	 *            name of element
	 * @param element
	 *            the element
	 */
	public void addElement(/*@NonNull*/ String elementName, /*@NonNull*/ Object element) {
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
				if (!filter.matches(this, element)) {
					return;
				}
			}
		}
		/*if (element instanceof PackageServer) {
			element = ((PackageServer) element).getPrimaryPackage();		// FIXME lose casts
		}
		else*/ if (element instanceof TypeServer) {
			element = ((TypeServer) element).getPivotType();		// FIXME lose casts
		}
		if ((requiredType != null) && (name != null)) {
			if (!requiredType.isInstance(element)) {
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
			MyList values;
			if (value instanceof MyList) {
				values = (MyList)value;
			} else {
				values = new MyList();
				values.add(value);
				contentsByName.put(elementName, values);
			}
			if (!values.contains(element)) {
				values.add(element);
				contentsSize++;
			}
		}
	}
	// This copy here to preserve API until failure of clients to update understood.
	public void addElement(/*@NonNull*/ String elementName, /*@NonNull*/ DomainElement element) {
		addElement(elementName, (Object)element);
	}

	public void addElements(@NonNull Map<String, ?> elements) {
		String name2 = name;
		if (name2 != null) {
			Object element = elements.get(name2);
			if (element != null) {
				addElement(name2, element);
			}
		}
		else {
			for (String key : elements.keySet()) {
				if (key != null) {
					Object element = elements.get(key);
					if (element != null) {
						addElement(key, element);
					}
				}
			}
		}
	}

	public void addElements(@Nullable Iterable<? extends Object> elements) {
		if (elements != null) {
			for (Object element : elements) {
				if (element instanceof Nameable) {
					Nameable namedElement = (Nameable) element;
					String elementName = namedElement.getName();
					if (elementName != null) {
						addElement(elementName, namedElement);
					}
				}
			}
		}
	}

	public void addElementsOfScope(@Nullable Element element, @NonNull ScopeView scopeView) {
		if (element != null) {
			element = PivotUtil.getLowerBound(element);
			Attribution attribution = PivotUtil.getAttribution(element);
			attribution.computeLookup(element, this, scopeView);
		}
	}

	public void addFilter(@NonNull ScopeFilter filter) {
		if (matchers == null) {
			matchers = new ArrayList<ScopeFilter>();
		}
		matchers.add(filter);
	}

	public void addImportedElement(@NonNull URI baseURI) {
    	if (PivotUtil.isASURI(baseURI)) {
    		baseURI = PivotUtil.getNonASURI(baseURI);
    	}
		String name = getName();
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

	public void addLibContents(@NonNull Type libType, @NonNull ScopeView scopeView) {
		addElementsOfScope(libType, scopeView);
		for (Type superClass : libType.getSuperClass()) {
			if (superClass != null) {
				addLibContents(superClass, scopeView);
			}
		}
	}

	public void addNamedElement(/*@NonNull*/ Nameable namedElement) {
		if (namedElement == null) {
			return;
		}
		String elementName = namedElement.getName();
		if (elementName != null) {
			addElement(elementName, namedElement);
		}
	}
	// This copy here to preserve API until failure of clients to update understood.
	public void addNamedElement(/*@NonNull*/ DomainNamedElement namedElement) {
		addNamedElement((Nameable)namedElement);
	}

	public void addNamedElements(/*@NonNull*/ Iterable<? extends Nameable> namedElements) {
		for (Nameable namedElement : namedElements) {
			if (namedElement != null) {
				addNamedElement(namedElement);
			}
		}
	}

	public void addRootPackages() {
		PackageManager packageManager = metaModelManager.getPackageManager();
		String name2 = name;
		if (name2 != null) {
			RootPackageServer rootPackageServer = packageManager.getMemberPackage(name2);
			if (rootPackageServer != null) {
				addNamedElement(rootPackageServer);
			}
			PackageServer packageServer = packageManager.getPackageByURI(name2);
			if (packageServer != null) {
				addElement(name2, packageServer);
			}
		}
		else {
			for (RootPackageServer rootPackageServer : packageManager.getMemberPackages()) {
				if (rootPackageServer != null) {
					addNamedElement(rootPackageServer);
				}
			}
			for (PackageServer packageServer : packageManager.getAllPackagesWithUris()) {
				String nsURI = packageServer.getNsURI();
				if (nsURI != null) {
					addElement(nsURI, packageServer);
				}
			}
		}
	}

	public int computeLookups(@NonNull Element target, @Nullable Element child) {
		ScopeView pivotScopeView = new PivotScopeView(metaModelManager, target, child, false);
		return computeLookups(pivotScopeView);
	}
	
	public int computeLookups(@NonNull ScopeView scopeView) {
		ScopeView aScope = scopeView;
		try {
			while ((aScope != null) && !hasFinalResult()) {
				EObject aTarget = aScope.getTarget();
				if (aTarget == null) {
					break;					// The NULLSCOPEVIEW
				}
				Attribution attribution = aScope.getAttribution();
				aScope = attribution.computeLookup(aTarget, this, aScope);
			}
		}
		catch (IllegalLibraryException e) {
			throw e;
		}
		catch (Exception e) {
			logger.warn("Lookup of '" + name + "' failed", e);
		}
		return resolveDuplicates();
	}

	public void computeQualifiedLookups(@NonNull Element target) {
		ScopeView parentScopeView = new PivotScopeView(metaModelManager, target, null, true);
		addElementsOfScope(target, parentScopeView);
	}

	public @Nullable EObject getContent() {
		if (contentsSize == 0) {
			return null;
		}
		if (contentsSize != 1) {
			logger.warn("Unhandled ambiguous content for '" + name + "'");
		}
		for (Map.Entry<String, Object> entry : contentsByName.entrySet()) {
			Object value = entry.getValue();
			if (value instanceof MyList) {
				MyList values = (MyList) value;
				value = values.get(values.size() - 1);
			}
			if (value instanceof EObject) {
				return (EObject) value;
			}
		}
		return null;
	}

	public @NonNull Set<Map.Entry<String, Object>> getEntries() {
		@SuppressWarnings("null") @NonNull Set<Entry<String, Object>> result = contentsByName.entrySet();
		return result;
	}

	public @Nullable String getName() {
		return name;
	}

	public @NonNull EStructuralFeature getReference() {
		return reference;
	}

	public @Nullable EClassifier getRequiredType() {
		return requiredType;
	}

	public int getSize() {
		return contentsSize;
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	/**
	 * Return true once the EnvironmentView has accumulated sufficient results
	 * to satisfy the lookup criterion for which it was created. i.e. any result
	 * for a non-null name, all results for a null name.
	 */
	public boolean hasFinalResult() {
		if (contentsSize == 0) {
			return false; // Not thing found is not a final result
		}
		if (getName() == null) {
			return false; // No name means search full hierarchy
		}
		return true;
	}
	
	public boolean isQualifier() {
		return isQualifier;
	}

	public void removeFilter(@NonNull ScopeFilter filter) {
		if (matchers != null) {
			matchers.remove(filter);
		}
	}

	public int resolveDuplicates() {
		if ((contentsSize > 1) && (getName() != null)) {
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
										if (comparator instanceof Disambiguator<?>) {
											verdict = ((Disambiguator<Object>)comparator).compare(metaModelManager, iValue, jValue);
										}
										else {
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
		return getSize();
	}

	public void setBindings(@NonNull Object object, @Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		if (templateBindings == null) {
			templateBindings = new HashMap<Object, Map<TemplateParameter, ParameterableElement>>();
		}
		templateBindings.put(object, bindings);
	}

	public void setIsQualifier(boolean isQualifier) {
		this.isQualifier = isQualifier;
	}

	public void setRequiredType(@Nullable EClassifier requiredType) {
		assert (requiredType == null) || PivotUtil.conformsTo(reference.getEType(), requiredType);
		this.requiredType = requiredType;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(reference.getName());
		s.append(" : "); //$NON-NLS-1$
//		s.append(reference.getEType().getName());
		if (requiredType != null) {
			s.append(requiredType.getName());
		}
		if (isQualifier) {
			s.append(" (qualifier)");
		}
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
