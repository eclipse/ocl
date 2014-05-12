package org.eclipse.ocl.examples.autogen.namereso

import org.eclipse.ocl.examples.autogen.utilities.MergeWriter
import org.eclipse.jdt.annotation.NonNull

class AutoGenNameResoSpecificFramework {
	
	private static final String autoPrefix = "Auto"
	private static final AutoGenNameResoSpecificFramework generator = new AutoGenNameResoSpecificFramework();
	
	/**
	 * Parameters:
	 * 
	 * 
	 */
	def public static generateSpecificFramework(@NonNull String outputFolder, @NonNull String projectPrefix, @NonNull String modelPckName,
		@NonNull String packageName, @NonNull String visitorPckName, @NonNull String visitorName, @NonNull String baseElmntPckName, @NonNull String baseElmntName) {
		
		generator.generatePivotEnvironmentItf(outputFolder, projectPrefix, packageName, baseElmntName);
		generator.generatePivotNamedEnvironmentClass(outputFolder, projectPrefix, packageName,  baseElmntName);
		generator.generatePivotContextItf(outputFolder, projectPrefix, packageName, baseElmntName);
		generator.generatePivotContextClass(outputFolder, projectPrefix, packageName, baseElmntName);
		generator.generatePivotVisitorItf(outputFolder, projectPrefix,  packageName, visitorPckName, visitorName, baseElmntPckName, baseElmntName);
		generator.generatePivotVisitorClass(outputFolder, projectPrefix, packageName, visitorPckName, visitorName, baseElmntPckName, baseElmntName);
		generator.generatePivotNameResolverItf(outputFolder, projectPrefix, packageName, visitorPckName, visitorName, baseElmntPckName, baseElmntName);
		generator.generatePivotNameResolverClass(outputFolder, projectPrefix, packageName, visitorPckName, visitorName, baseElmntPckName, baseElmntName);
	}
	
	protected def void generatePivotEnvironmentItf(@NonNull String outputFolder, @NonNull String projectPrefix,
		@NonNull String packageName, @NonNull String baseElmntName) {
		
		var String commonEnvItf = getCommonEnvironmentItf()
		var String envItf = getSpecificEnvironmentItf(projectPrefix)
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«envItf».java''')
		writer.append('''
package «packageName»;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;


public interface «envItf»<C extends «baseElmntName»> extends «commonEnvItf» {

	// TEMPORAL STUFF
	// ASBH FIXME can we get rid of this ?
	public void addFilter(@NonNull ScopeFilter filter);
	public void removeFilter(@NonNull ScopeFilter filter);
	@NonNull
	public MetaModelManager getMetaModelManager();
	public void setBindings(@NonNull C object, @Nullable Map<TemplateParameter, ParameterableElement> bindings);
	// END OF TEMPORAL STUFF
	
	// Generated from NameResolution description
	
	// Root
	public void addRootPackages();
	public void addNestedPackages(@NonNull Root root);
	
	// Package
	public void addAllPackages(@NonNull Package pkge);
	public void addOwnedTypes(@NonNull Package pkge);
	
	// Library 
	public void addOwnedPrecedence(@NonNull Library library);
	
	// TemplateableElement
	public void addTypeTemplateParameterables(@NonNull TemplateableElement tmpltblElement);
	
	// Operation
	public void addOwnedParameter(@NonNull Operation object);
	
	// Type
	public void addOwnedOperation(@NonNull Type type, @Nullable FeatureFilter featureFilter);
	public void addOwnedProperty(@NonNull Type type, @Nullable FeatureFilter featureFilter);
	
	// Class
	public void addOwnedState(@NonNull org.eclipse.ocl.examples.pivot.Class type);
	
	// Enumeration
	public void addOwnedEnumerationLiteral(@NonNull Enumeration enumeration);
	
	// IterateExp
	public void addIterator(@NonNull IterateExp  iterateExp);
	public void addIterator(@NonNull IterateExp  iterateExp, int index);
	public void addResult(@NonNull IterateExp iterateExp);	

	
	// Iterator Exp
	public void addIterator(@NonNull IteratorExp  iteratorExp);
	public void addIterator(@NonNull IteratorExp  iterateExp, int index);
	
	// LetExp
	public void addVariable(@NonNull LetExp  letExp);
	
	// ExpressionInOCL
	public void addContextVariable(@NonNull ExpressionInOCL expressionInOCL);
	public void addResultVariable(@NonNull ExpressionInOCL expressionInOCL);
}
		''');
		writer.close();
	}
	
	protected def void generatePivotNamedEnvironmentClass(@NonNull String outputFolder, @NonNull String projectPrefix, 
		@NonNull String packageName, @NonNull String baseElmntName) {
		
		var String namedEnvItf = getSpecificNamedEnvironmentItf(projectPrefix)
		var String namedEnvClass = getSpecificNamedEnvironmentClass(projectPrefix)
		var String commonNamedEnvClass = getCommonNamedEnvironmentClass()
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«namedEnvClass».java''');
		writer.append('''
package «packageName»;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


public class «namedEnvClass»<C extends «baseElmntName»> extends «commonNamedEnvClass»<C>
	implements «namedEnvItf»<C>{
	
	
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
	
	
	private final @NonNull MetaModelManager metaModelManager;

	private Map<C, Map<TemplateParameter, ParameterableElement>> templateBindings = null;
	private List<ScopeFilter> matchers = null;	// Prevailing filters for matching
	private Set<ScopeFilter> resolvers = null;	// Successful filters for resolving

	
	public «namedEnvClass»(@NonNull MetaModelManager metaModelManager,
			@NonNull EStructuralFeature reference, @NonNull String name) {
		super(reference, name);
		this.metaModelManager = metaModelManager;
	}

	protected boolean accepts(/*@NonNull*/ EClass eClass) {
		assert eClass != null;
		// If eClass conformsTo requiredType every candidate will be type-compatible
		// If requiredType conformsTo eClass some candidates may be type-compatible
		// else no candidates can be type-compatible
		return PivotUtil.conformsTo(lookupType, eClass) || PivotUtil.conformsTo(eClass, lookupType);
	}
	
	public void addOwnedParameter(@NonNull Operation object) {
		if (accepts(PivotPackage.Literals.PARAMETER)) {
			addElements(object.getOwnedParameter());
		}
	}
	
	public void addTypeTemplateParameterables(@NonNull TemplateableElement object) {
		if (accepts(PivotPackage.Literals.TYPE)) {
			addElements(PivotUtil.getTypeTemplateParameterables(object));
		}
	}
	
	public void addOwnedEnumerationLiteral(@NonNull Enumeration object) {
		if (accepts(PivotPackage.Literals.ENUMERATION_LITERAL)) {
			addElements(object.getOwnedLiteral());
		}
	}
	
	public void addOwnedOperation(@NonNull Type type, @Nullable FeatureFilter featureFilter) {
		if (accepts(PivotPackage.Literals.ITERATION)		// If ITERATION is acceptable then so too is OPERATION
				&& (getType() != PivotPackage.Literals.NAMESPACE)) {	// Don't really want operations when looking for NAMESPACE
			assert metaModelManager.isTypeServeable(type);
			type = PivotUtil.getUnspecializedTemplateableElement(type);
			TypeServer typeServer = metaModelManager.getTypeServer(type);
			addElements(typeServer.getAllOperations(featureFilter, name));
			//: typeServer.getAllOperations(featureFilter));
		}
	}
	
	public void addOwnedProperty(@NonNull Type type, @Nullable FeatureFilter featureFilter) {
		if (accepts(PivotPackage.Literals.PROPERTY)
			&& (getType() != PivotPackage.Literals.NAMESPACE)) { // Don't really want properties when looking for NAMESPACE
			assert metaModelManager.isTypeServeable(type);
			TypeServer typeServer = metaModelManager.getTypeServer(type);
			addElements(typeServer.getAllProperties(featureFilter, name));
			// : typeServer.getAllProperties(featureFilter));
		}
	}
	
	public void addOwnedState(@NonNull org.eclipse.ocl.examples.pivot.Class type) {
		if (accepts(PivotPackage.Literals.STATE)) {
			assert metaModelManager.isTypeServeable(type);
			TypeServer typeServer = metaModelManager.getTypeServer(type);
			addElements(typeServer.getAllStates(name));
			//: typeServer.getAllStates());
		}
	}
	

	public void addAllPackages(@NonNull Package pkge) {
		if (accepts(PivotPackage.Literals.PACKAGE)) {
			PackageServer parentPackageServer = metaModelManager.getPackageServer(pkge);
			PackageServer packageServer = parentPackageServer.getMemberPackage(name);
			if (packageServer != null) {
					addElement(name, packageServer);
			}
//			else {
//				for (PackageServer packageServer : parentPackageServer.getMemberPackages()) {
//					if (packageServer != null) {
//						addNamedElement(packageServer);
//					}
//				}
//			}
		}
	}
	
	public void addOwnedTypes(@NonNull Package pkge) {
		if (accepts(PivotPackage.Literals.CLASS)) {
			PackageServer packageServer = metaModelManager.getPackageServer(pkge);
			Type type = packageServer.getMemberType(name);
			if (type != null) {
				addNamedElement(type);
			}
//			else {
//				for (TypeServer type : packageServer.getMemberTypes()) {
//					if (type != null) {
//						addNamedElement(type);
//					}
//				}
//			}
		}
	}
	
	
	public void addNestedPackages(@NonNull Root root) {
		if (accepts(PivotPackage.Literals.PACKAGE)) {
			addElements(root.getNestedPackage());
		}
	}
	
	public void addRootPackages() {
		PackageManager packageManager = metaModelManager.getPackageManager();
		addNamedElement(packageManager.getMemberPackage(name));
		addNamedElement(packageManager.getPackageByURI(name));			
//		else {			
//			for (RootPackageServer rootPackageServer : packageManager.getMemberPackages()) {
//				addNamedElement(rootPackageServer);
//			}
//			for (PackageServer packageServer : packageManager.getAllPackagesWithUris()) {
//				String nsURI = packageServer.getNsURI();
//				if (nsURI != null) {
//					addElement(nsURI, packageServer);
//				}
//			}
//		}
	}
	
	public void addOwnedPrecedence(@NonNull Library library) {
		if (accepts(PivotPackage.Literals.PRECEDENCE)) {
			addElements(library.getOwnedPrecedence());
		}
	}
	
	public void addIterator(@NonNull IterateExp  iterateExp) {
		addElements(iterateExp.getIterator());
	}
	
	public void addIterator(@NonNull IterateExp  iteraterExp, int index) {
		addNamedElement(iteraterExp.getIterator().get(index));
	}
	
	public void addResult(@NonNull IterateExp iterateExp) {
		addNamedElement(iterateExp.getResult());
	}
	
	public void addIterator(@NonNull IteratorExp  iteratorExp) {
		addElements(iteratorExp.getIterator());
	}
	
	public void addIterator(@NonNull IteratorExp  iteratorExp, int index) {
		addNamedElement(iteratorExp.getIterator().get(index));
	}
	
	public void addVariable(@NonNull LetExp  letExp) {
		addNamedElement(letExp.getVariable());
	}
	
	public void addContextVariable(@NonNull ExpressionInOCL expressionInOCL) {
		addNamedElement(expressionInOCL.getContextVariable());
	}
	
	public void addResultVariable(@NonNull ExpressionInOCL expressionInOCL) {
		addNamedElement(expressionInOCL.getResultVariable());
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
	
	public void addImportedElement(@NonNull URI baseURI) {
		if (PivotUtil.isASURI(baseURI)) {
			baseURI = PivotUtil.getNonASURI(baseURI);
		}		
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
	
	@Override
	protected void addElement(String elementName, Object element) {
		if ((elementName == null) || (element == null)) {
			return;
		}
		if ((element instanceof EObject) && !(element instanceof Variable) && (((EObject)element).eResource() == null)) {
			// Orphans are bad but LetExp/LoopExp/ExpressionInOCL Variables are created left-to-right
			logger.error("Orphan '" + element + "'");
			return;
		}
		if (!name.equals(elementName)) {
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
		if (matchers != null) {
			for (ScopeFilter filter : matchers) {
				if (filter instanceof ScopeFilter.ScopeFilter2){
					if (!((ScopeFilter.ScopeFilter2<C>)filter).matches(this, (C)element)) { // FIXME ADOLFOSBH
						return;
					}
				}
			}
		}
		 
		if (element instanceof TypeServer) {
			element = ((TypeServer) element).getPivotType();		// FIXME lose casts
		}
		if (!lookupType.isInstance(element)) {
			return;
		}
		if (matchers != null) {
			if (resolvers == null) {
				resolvers = new HashSet<ScopeFilter>();
			}
			resolvers.addAll(matchers);
		}
		super.addElement(elementName, element);
	}
	
	@NonNull
	public AutoINamedLookupResult<C> resolveDuplicates() {
		AutoINamedLookupResult<C> result = getResult();
		if (result.getSize() > 1)  {			
			@NonNull List<C> values = result.getAllResults();
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
			AutoINamedLookupResult<C> newResult = createResult();
			for (int i=0; i < values.size(); i++) {
				@SuppressWarnings("null") 
				@NonNull C value = values.get(i);
				newResult.addElement(name, value);
			}
			return newResult;
		}
		return result;
	}
}
		''');
		writer.close();
	}
		


	protected def void generatePivotContextItf(@NonNull String outputFolder, @NonNull String projectPrefix,
		@NonNull String packageName, @NonNull String baseElmntName) {
		
		var String commonContextItf = getCommonContextItf()
		var String contextItf = getSpecificContextItf(projectPrefix)
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«contextItf».java''')
		writer.append('''
package «packageName»;

import org.eclipse.ocl.examples.pivot.Element;

public interface «contextItf» extends «commonContextItf»<«baseElmntName»> {

}
		''');
		writer.close();
	}
	
	protected def void generatePivotContextClass(@NonNull String outputFolder, @NonNull String projectPrefix,
		@NonNull String packageName, @NonNull String baseElmntName) {
		
		var String commonContextClass = getCommonContextClass()
		var String contextClass = getSpecificContextClass(projectPrefix);
		var String contextItf = getSpecificContextItf(projectPrefix)
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«contextClass».java''')
		writer.append('''
package «packageName»;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;

public class «contextClass» extends «commonContextClass»<«baseElmntName»>
	implements «contextItf» {

	protected «contextClass»(@NonNull EStructuralFeature lookupFeature,
			@NonNull «baseElmntName» target) {
		super(lookupFeature, target);
	}

	protected «contextClass»(@NonNull EStructuralFeature lookupFeature ,
			@NonNull «baseElmntName» target, @Nullable «baseElmntName» child) {
		super(lookupFeature, target, child);
	}
}
		''');
		writer.close();
	}
	protected def void generatePivotVisitorItf(@NonNull String outputFolder, @NonNull String projectPrefix, @NonNull String packageName, 
		@NonNull String visitorPckName, @NonNull String visitorName,  @NonNull String baseElmntPckName,  @NonNull String baseElmntName
	) {
		var visitorItf =  getSpecificVisitorItf(projectPrefix)
		var environmentItf = getSpecificEnvironmentItf(projectPrefix)
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«visitorItf».java''');
		writer.append('''
package «packageName»;

import «baseElmntPckName».«baseElmntName»;
import «visitorPckName».«visitorName»;

public interface «visitorItf»<C extends «baseElmntName»> extends «visitorName»<«environmentItf»<C>> {

}
		''');
		writer.close();
	}
	
	protected def void generatePivotVisitorClass(@NonNull String outputFolder, @NonNull String projectPrefix, @NonNull String packageName,
		@NonNull String visitorPckName, @NonNull String visitorName, @NonNull String baseElemntPckgName, @NonNull String baseElmntName
	) {
		var String visitorClass = getSpecificVisitorClass(projectPrefix)
		var String visitorItf =  getSpecificVisitorItf(projectPrefix)
		var String environmentItf =  getSpecificEnvironmentItf(projectPrefix)
		var String commonContextItf = getCommonContextItf()
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«visitorClass».java''');
		writer.append('''
package «packageName»;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;


public class «visitorClass»<C extends «baseElmntName»> extends AbstractExtendingVisitor<«environmentItf»<C>, «commonContextItf»<«baseElmntName»>>
	implements «visitorItf»<C> {
		 
	@NonNull final protected MetaModelManager mmManager;
	@NonNull final protected «environmentItf»<C> result;
	
	public AutoPivotLookupVisitor(@NonNull MetaModelManager mmManager, @NonNull «environmentItf»<C> result, @NonNull «commonContextItf»<«baseElmntName»> context) {
		super(context);
		this.mmManager = mmManager;
		this.result = result;
	}

	@NonNull
	public «environmentItf»<C> visiting(@NonNull Visitable visitable) {
		return lookupInParentIfNotComplete();
	}
	
	@NonNull
	protected final «environmentItf»<C> lookupInNewContext(@Nullable «commonContextItf»<«baseElmntName»> newContext) {
		return newContext == null ? result // If we have reached the top element
			: DomainUtil.nonNullState((newContext.getTarget()).accept( 
				new «visitorClass»<C>(mmManager, result, newContext))); 
	}
	@NonNull
	protected «environmentItf»<C> lookupFromNewElement(Element element) {
		return DomainUtil.nonNullState(element.accept(this));
	}
	
	// Lookup propagation protocols 
	
	/**
	 * Used when ONLY looking up in local 
	 * @return the accumulated lookup result
	 */
	@NonNull
	protected «environmentItf»<C> lookupOnlyLocal() {
		return result;
	}
	
	/**
	 * Used when looking up in local AND in parent environments if not found 
	 * in local -> outer scope/environment elements are occluded in nested 
	 * contexts
	 * @return the accumulated lookup result
	 */
	@NonNull
	protected «environmentItf»<C> lookupInParentIfNotComplete() {
		return result.isComplete() ? result : lookupInNewContext(context.getParent());
	}
	
	/**
	 * Used when looking up in local AND in parent environments
	 * @return the accumulated lookup result
	 */
	@NonNull
	protected «environmentItf»<C> lookupInParent() {
		return lookupInNewContext(context.getParent());
	}
}
		''');
		writer.close();
	}


	protected def void generatePivotNameResolverItf(@NonNull String outputFolder, @NonNull String projectPrefix, @NonNull String packageName,
		@NonNull String visitorPckName, @NonNull String visitorName, @NonNull String baseElemntPckgName, @NonNull String baseElmntName
	) {
		var String resolverItf = getSpecificNameResolverItf(projectPrefix);
		var String commonNamedResultItf = getCommonNamedResultItf();
		var String commonUnnamedResultItf = getCommonUnnamedResultItf();
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«resolverItf».java''');
		writer.append('''
package «packageName»;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;


public interface «resolverItf» {
	
	/**
	 * Generic lookup contract
	 * 
	 * @param lookupElement the element from which the lookup will be fired up
	 * @param lookupFeature the feature for which the lookup is needed
	 * @param lookupKind 
	 * @param name
	 * @param isQualified
	 * @return
	 */
	@NonNull
	public <C extends Element> «commonNamedResultItf»<C> computeLookup(@NonNull Element lookupElement, 
		@NonNull EStructuralFeature lookupFeature,
		@NonNull String name, boolean isQualified);
	
	@NonNull
	public <C extends Element> «commonUnnamedResultItf» computeLookup(@NonNull Element lookupElement,
		@NonNull EStructuralFeature lookupFeature,
		boolean isQualified);
	
	/**
	 * Resolves the referred operation of OperationCallExp
	 * 
	 * @param opCallExp the element from which the lookup will be performed
	 * @param lookupKind the kind of lookup
	 * @return 
	 */
	@NonNull
	public AutoINamedLookupResult<Operation> computeReferredOperationLookup(@NonNull OperationCallExp opCallExp,
		@NonNull ScopeFilter filter);

	@NonNull
	public AutoINamedLookupResult<Iteration> computeReferredIterationLookup(@NonNull IteratorExp iteratorExp,
		@NonNull ScopeFilter filter);
	
	@NonNull
	public AutoINamedLookupResult<Variable> computeReferredVariableLookup(@NonNull VariableExp variableExp);
}
		''');
		writer.close();
	}
	
	protected def void generatePivotNameResolverClass(@NonNull String outputFolder, @NonNull String projectPrefix, @NonNull String packageName,
		@NonNull String visitorPckName, @NonNull String visitorName, @NonNull String baseElemntPckgName, @NonNull String baseElmntName
	) {
		var String resolverItf = getSpecificNameResolverItf(projectPrefix);
		var String resolverClass = getSpecificNameResolverClass(projectPrefix);
		var String contextItf = getSpecificContextItf(projectPrefix);
		var String contextClass = getSpecificContextClass(projectPrefix);
		var String commonNamedResultItf = getCommonNamedResultItf();
		var String commonUnnamedResultItf = getCommonUnnamedResultItf();
		var String envItf = getSpecificEnvironmentItf(projectPrefix);
		var String namedEnvItf = getSpecificNamedEnvironmentItf(projectPrefix);
		var String namedEnvClass = getSpecificNamedEnvironmentClass(projectPrefix);
		var String unnamedEnvItf = getSpecificUnnamedEnvironmentItf(projectPrefix);
		var String unnamedEnvClass = getSpecificUnnamedEnvironmentClass(projectPrefix);
		var String visitorItf = getSpecificVisitorItf(projectPrefix);
		var String visitorClass = getSpecificVisitorClass(projectPrefix);
		
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«resolverClass».java''');
		writer.append('''
package «packageName»;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;


public class «resolverClass» implements «resolverItf» {

	@NonNull
	final protected MetaModelManager mmManager;
	
	public «resolverClass»(@NonNull MetaModelManager mmManager) {
		this.mmManager = mmManager;
	}
	
	@NonNull
	public <C extends «baseElmntName»> «commonNamedResultItf»<C> computeLookup(@NonNull «baseElmntName» lookupElement,
		@NonNull EStructuralFeature lookupFeature,
		@NonNull String name, boolean isQualified) {
		«contextItf» context = createLookupContext(lookupFeature, lookupElement);
		«namedEnvItf»<C> env = createLookupEnvironment(mmManager, lookupFeature, name);		
		return computeNamedResult(lookupElement, env, context);
	}
	
	@NonNull
	public <C extends «baseElmntName»> «commonUnnamedResultItf» computeLookup(
			@NonNull «baseElmntName» lookupElement,
			@NonNull EStructuralFeature lookupFeature, boolean isQualified) {
		«contextItf» context = createLookupContext(lookupFeature, lookupElement);
		«unnamedEnvItf»<C> env = createLookupEnvironment(mmManager, lookupFeature);		
		return computeUnnamedResult(lookupElement, env, context);
	}
	
	@NonNull
	protected <C extends «baseElmntName»> «visitorItf»<C> createLookupVisitor(@NonNull MetaModelManager mmManager,
		@NonNull «envItf»<C> env, @NonNull «contextItf» context) {
		return new «visitorClass»<C>(mmManager, env, context);
	}
	
	@NonNull
	protected <C extends «baseElmntName»> «namedEnvItf»<C> createLookupEnvironment(@NonNull MetaModelManager mmManager, 
		@NonNull EStructuralFeature lookupFeature, @NonNull String name) {
		return new «namedEnvClass»<C>(mmManager, lookupFeature, name);
	}
	
	@NonNull
	protected <C extends «baseElmntName»> «unnamedEnvItf»<C> createLookupEnvironment(@NonNull MetaModelManager mmManager, 
		@NonNull EStructuralFeature lookupFeature) {
		return new «unnamedEnvClass»<C>(mmManager, lookupFeature);
	}
	
	@NonNull
	protected «contextItf» createLookupContext(@NonNull EStructuralFeature lookupFeature,
		@NonNull «baseElmntName» lookupElement) {
		return new «contextClass»(lookupFeature, lookupElement);
	}
		
	@NonNull
	protected <C extends «baseElmntName»> «envItf»<C> executeVisitor(@NonNull «baseElmntName» element, 
		@NonNull «envItf»<C> env, 
		@NonNull «contextItf» context) { 
		return DomainUtil.nonNullState(element.accept(createLookupVisitor(mmManager, env, context)));
	}
	
	@NonNull
	protected <C extends «baseElmntName»> «commonNamedResultItf»<C> computeNamedResult(@NonNull «baseElmntName» element, 
		@NonNull «namedEnvItf»<C> env, 
		@NonNull «contextItf» context) { 
		«envItf»<C> env2= executeVisitor(element, env, context);		
		return ((«namedEnvItf»<C>)env2).resolveDuplicates();
	}		
	
	@NonNull
	protected <C extends «baseElmntName»> «commonUnnamedResultItf» computeUnnamedResult(@NonNull «baseElmntName» element, 
		@NonNull «unnamedEnvItf»<C> env, 
		@NonNull «contextItf» context) { 
		«envItf»<C> env2 = executeVisitor(element, env, context);		
		return ((«unnamedEnvItf»<C>)env2).getResult();
	}	

	@NonNull
	public «commonNamedResultItf»<Operation> computeReferredOperationLookup(
			@NonNull OperationCallExp opCallExp,
			@NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}

	@NonNull
	public «commonNamedResultItf»<Iteration> computeReferredIterationLookup(
			@NonNull IteratorExp iteratorExp,
			@NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}

	@NonNull
	public «commonNamedResultItf»<Variable> computeReferredVariableLookup(
			@NonNull VariableExp variableExp) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}
}
		''');
		writer.close();
	}
	
	def protected String getCommonContextItf() {
		return '''«autoPrefix»ILookupContext'''
	}
	
	def protected String getSpecificContextItf(String projectPrefix) {
		return '''«autoPrefix»I«projectPrefix»LookupContext'''
	}
	
	def protected String getCommonContextClass() {
		return '''«autoPrefix»LookupContext'''
	}	
	
	def protected String getSpecificContextClass(String projectPrefix) {
		return '''«autoPrefix»«projectPrefix»LookupContext'''
	}
	
	// Result
	def protected String getCommonResultItf() {
		return '''«autoPrefix»ILookupResult'''
	}
	
	def protected String getSpecificResultItf(String projectPrefix) {
		return '''«autoPrefix»I«projectPrefix»LookupResult'''
	}
	
	def protected String getCommonResultClass() {
		return '''«autoPrefix»LookupResult'''
	}
	
	def protected String getSpecificResultClass(String projectPrefix) {
		return '''«autoPrefix»«projectPrefix»LookupResult'''
	}
	
	// Named Result
	
	def protected String getCommonNamedResultItf() {
		return '''«autoPrefix»INamedLookupResult'''
	}
	
	def protected String getSpecificNamedResultItf(String projectPrefix) {
		return '''«autoPrefix»I«projectPrefix»NamedLookupResult'''
	}
	
	def protected String getCommonNamedResultClass() {
		return '''«autoPrefix»NamedLookupResult'''
	}
	
	def protected String getSpecificNamedResultClass(String projectPrefix) {
		return '''«autoPrefix»«projectPrefix»NamedLookupResult'''
		
	}
	
	// Unnamed Result
	def protected String getCommonUnnamedResultItf() {
		return '''«autoPrefix»IUnnamedLookupResult'''
	}
	
	def protected String getSpecificUnnamedResultItf(String projectPrefix) {
		return '''«autoPrefix»I«projectPrefix»UnnamedLookupResult'''
	}
	
	def protected String getCommonUnnamedResultClass() {
		return '''«autoPrefix»UnnamedLookupResult'''
	}
	
	def protected String getSpecificUnnamedResultClass(String projectPrefix) {
		return '''«autoPrefix»«projectPrefix»UnnamedLookupResult'''
		
	}
	
	// Environment
	def protected String getCommonEnvironmentItf() {
		return '''«autoPrefix»ILookupEnvironment'''
	}
	
	def protected String getSpecificEnvironmentItf(String projectPrefix) {
		return '''«autoPrefix»I«projectPrefix»LookupEnvironment'''
	}
	
	def protected String getCommonEnvironmentClass() {
		return '''«autoPrefix»LookupEnvironment'''
	}
	
	def protected String getSpecificEnvironmentClass(String projectPrefix) {
		return '''«autoPrefix»«projectPrefix»LookupEnvironment'''
	}
	
	// Named Environment
	
	def protected String getCommonNamedEnvironmentItf() {
		return '''«autoPrefix»INamedLookupEnvironment'''
	}
	
	def protected String getSpecificNamedEnvironmentItf(String projectPrefix) {
		return '''«autoPrefix»I«projectPrefix»NamedLookupEnvironment'''
	}
	
	def protected String getCommonNamedEnvironmentClass() {
		return '''«autoPrefix»NamedLookupEnvironment'''
	}
	
	def protected String getSpecificNamedEnvironmentClass(String projectPrefix) {
		return '''«autoPrefix»«projectPrefix»NamedLookupEnvironment'''
		
	}
	
	// Unnamed Environment
	def protected String getCommonUnnamedEnvironmentItf() {
		return '''«autoPrefix»IUnnamedLookupEnvironment'''
	}
	
	def protected String getSpecificUnnamedEnvironmentItf(String projectPrefix) {
		return '''«autoPrefix»I«projectPrefix»UnnamedLookupEnvironment'''
	}
	
	def protected String getCommonUnnamedEnvironmentClass() {
		return '''«autoPrefix»UnnamedLookupEnvironment'''
	}
	
	def protected String getSpecificUnnamedEnvironmentClass(String projectPrefix) {
		return '''«autoPrefix»«projectPrefix»UnnamedLookupEnvironment'''
		
	}
	// Visitor
	def protected String getSpecificVisitorItf(String projectPrefix) {
		return '''«autoPrefix»I«projectPrefix»LookupVisitor''' 
	}
	
	def protected String getSpecificVisitorClass(String projectPrefix) {
		return '''«autoPrefix»«projectPrefix»LookupVisitor'''
	}
	
	// Name Resolver
	def protected String getSpecificNameResolverItf(String projectPrefix) {
		return '''«autoPrefix»I«projectPrefix»NameResolver'''
	}
	
	def protected String getSpecificNameResolverClass(String projectPrefix) {
		return '''«autoPrefix»«projectPrefix»NameResolver'''
	}
}