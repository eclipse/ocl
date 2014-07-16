/**
 * Copyright (c) 2014 Willink Transformations, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		 Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation
 */
package org.eclipse.ocl.examples.autogen.namereso

import java.util.List
import java.util.Map
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.jdt.annotation.NonNull
import org.eclipse.ocl.examples.autogen.utilities.MergeWriter
import org.eclipse.ocl.examples.pivot.CollectionType
import org.eclipse.ocl.examples.pivot.Operation
import org.eclipse.ocl.examples.pivot.Package
import org.eclipse.ocl.examples.pivot.Type
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil

class AutoGenNameResoSpecificFramework {
	
	private final AutoNameResoCGNamesProvider nProvider;
	private final NameResoGenModelHelper helper;
		
	/**
	 * Parameters:
	 */
	def public static generateSpecificFramework(@NonNull String outputFolder, @NonNull GenPackage genPackage, @NonNull String projectPrefix, @NonNull String modelPckName,
		@NonNull String packageName, @NonNull String visitorPckName, @NonNull String visitorName, @NonNull String baseElmntPckName, 
		@NonNull String baseElmntName, @NonNull Package nameResoPackage) {

		var MetaModelManager mm = PivotUtil.getMetaModelManager(nameResoPackage.eResource);		
		var AutoGenNameResoSpecificFramework generator = new AutoGenNameResoSpecificFramework(projectPrefix, mm);		
		generator.generatePivotNamedEnvironmentItf(outputFolder, packageName,  baseElmntName);
		generator.generateAbstractPivotNamedEnvironmentClass(outputFolder, packageName);	
		generator.generatePivotContextItf(outputFolder, packageName, baseElmntPckName, baseElmntName);
		generator.generatePivotContextClass(outputFolder, packageName, baseElmntPckName, baseElmntName);
		generator.generatePivotVisitorItf(outputFolder,  packageName, visitorPckName, visitorName, baseElmntPckName, baseElmntName);
		generator.generatePivotNameResolverItf(outputFolder, packageName, visitorPckName, visitorName, baseElmntPckName, baseElmntName);
		generator.generatePivotNameResolverClass(outputFolder, packageName, visitorPckName, visitorName, baseElmntPckName, baseElmntName);
		
		// Generation from Complete OCL file
		generator.generatePivotEnvironmentItf(outputFolder, packageName, modelPckName, nameResoPackage);
		generator.generatePivotNamedEnvironmentClass(outputFolder, packageName,  baseElmntName, nameResoPackage);
		generator.generatePivotVisitorClass(outputFolder, packageName, modelPckName, visitorPckName, visitorName, baseElmntPckName, baseElmntName, nameResoPackage)
		AutoLookupCodeGenerator.generate(outputFolder, projectPrefix, genPackage, modelPckName, packageName, visitorPckName, visitorName, nameResoPackage);
	}
	
	
	new(@NonNull String projectPrefix, @NonNull MetaModelManager mManager) {
		nProvider = new AutoNameResoCGNamesProvider(projectPrefix);
		helper = new NameResoGenModelHelper(mManager);
	}
	
	protected def void generatePivotEnvironmentItf(@NonNull String outputFolder,
		@NonNull String packageName, @NonNull String modelPckName, 
		@NonNull Package nameResoPackage) {
				
		var String commonEnvItf = nProvider.getCommonEnvironmentItf()
		var String envItf = nProvider.getSpecificEnvironmentItf()
		var Map<Type, List<NameResolutionUtil.AddingCallArgExp>> type2expTypes = NameResolutionUtil.computeType2EnvAddingExps(nameResoPackage);
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«envItf».java''')
		writer.append('''
package «packageName»;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
«FOR type : type2expTypes.keySet»
import «modelPckName».«type.name»;
«ENDFOR»
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;

public interface «envItf» extends «commonEnvItf» {

	// TEMPORAL STUFF
	// ASBH FIXME can we get rid of this ?
	public void addFilter(@NonNull ScopeFilter filter);
	public void removeFilter(@NonNull ScopeFilter filter);
	@NonNull
	public MetaModelManager getMetaModelManager();
	public void setBindings(@NonNull Object object, @Nullable Map<TemplateParameter, ParameterableElement> bindings);
	// END OF TEMPORAL STUFF
	
	// Generated from NameResolution description
	«FOR type : type2expTypes.keySet»
	
	// «type.name»
	
	«FOR addingExptype : type2expTypes.get(type)»
	«val expType = addingExptype.getType»	
	«val isMany = expType instanceof CollectionType»
	«val expTypeName = if (expType instanceof CollectionType) expType.elementType.name else expType.name»
	public void add«type.name»«addingExptype.getNumber»_«expTypeName.toFirstUpper»Element«if (isMany) "s"»(@NonNull «type.name» object«IF(addingExptype.isHasChildIndex)», int childIndex«ENDIF»);
	«ENDFOR»
	«ENDFOR»
	
	// TemplateableElement
	// FIXME no auto-generated yet
	public void addTypeTemplateParameterables(@NonNull TemplateableElement tmpltblElement);
	
}
		''');
		writer.close();
	}
	
	protected def void generatePivotNamedEnvironmentItf(@NonNull String outputFolder,
		@NonNull String packageName, @NonNull String baseElmntName) {
		
		var String namedEnvItf = nProvider.getSpecificNamedEnvironmentItf()
		var String envItf = nProvider.getSpecificEnvironmentItf()
		var String commonNamedResultItf = nProvider.getCommonNamedResultItf()
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«namedEnvItf».java''');
		writer.append('''
package «packageName»;

import org.eclipse.jdt.annotation.NonNull;

public interface «namedEnvItf» extends «envItf»{

	@NonNull
	public «commonNamedResultItf» getResult();
	/**
	 * Convenience method to remove name duplicates so that it can be called
	 * once the lookup process finishes 
	 * 
	 * @return returns the {@link «commonNamedResultItf»} after resolving duplicates 
	 */
	@NonNull
	public «commonNamedResultItf» resolveDuplicates();
}
	''');
		writer.close();
	}
	
	protected def void generatePivotNamedEnvironmentClass(@NonNull String outputFolder, 
		@NonNull String packageName, @NonNull String baseElmntName, @NonNull Package nameResoPackage) {
		
		var String namedEnvClass = nProvider.getSpecificNamedEnvironmentClass()
		var String superNamedEnvClass = nProvider.getSpecificAbstractNamedEnvironmentClass();
				
		var MergeWriter writer = new MergeWriter(outputFolder + '''«namedEnvClass».java''');
		writer.append('''
package «packageName»;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class «namedEnvClass» extends «superNamedEnvClass» {
	public «namedEnvClass»(@NonNull MetaModelManager metaModelManager,
			@NonNull EStructuralFeature reference, @NonNull String name) {
		super(metaModelManager, reference, name);
	}

	protected boolean accepts(/*@NonNull*/ EClass eClass) {
		assert eClass != null;
		// If eClass conformsTo requiredType every candidate will be type-compatible
		// If requiredType conformsTo eClass some candidates may be type-compatible
		// else no candidates can be type-compatible
		return PivotUtil.conformsTo(lookupType, eClass) || PivotUtil.conformsTo(eClass, lookupType);
	}
	
	public void addOperation0_ParameterElements(@NonNull Operation object) {
		addOwnedParameter(object);
	}
	
	// FIXME remove when Auto-generation is finished
	private  void addOwnedParameter(@NonNull Operation object) {
		if (accepts(PivotPackage.Literals.PARAMETER)) {
			addElements(object.getOwnedParameter());
		}
	}
			
	public void addTypeTemplateParameterables(@NonNull TemplateableElement object) {
		if (accepts(PivotPackage.Literals.TYPE)) {
			addElements(PivotUtil.getTypeTemplateParameterables(object));
		}
	}

	public void addEnumeration3_EnumerationLiteralElements(
			@NonNull Enumeration object) {
		addOwnedLiteral(object);
	}
	
	// FIXME remove when Auto-generation is finished
	private void addOwnedLiteral(@NonNull Enumeration object) {
		if (accepts(PivotPackage.Literals.ENUMERATION_LITERAL)) {
			addElements(object.getOwnedLiteral());
		}
	}
	
	public void addClass1_OperationElements(
			@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		addOwnedOperation(object, FeatureFilter.SELECT_NON_STATIC);
	}
	
	public void addMetaclass0_NamedElementElements(@NonNull Metaclass object) {
		Type instanceType = object.getInstanceType();
		if (instanceType != null) {
			addOwnedOperation(instanceType, null);
		}
	}
	
	public void addEnumeration1_OperationElements(@NonNull Enumeration object) {
		addOwnedOperation(object, FeatureFilter.SELECT_NON_STATIC);
	}
	
	// FIXME remove when Auto-generation is finished
	private void addOwnedOperation(@NonNull Type type, @Nullable FeatureFilter featureFilter) {
		if (accepts(PivotPackage.Literals.ITERATION)		// If ITERATION is acceptable then so too is OPERATION
				&& (getType() != PivotPackage.Literals.NAMESPACE)) {	// Don't really want operations when looking for NAMESPACE
			assert metaModelManager.isTypeServeable(type);
			type = PivotUtil.getUnspecializedTemplateableElement(type);
			TypeServer typeServer = metaModelManager.getTypeServer(type);
			addElements(typeServer.getAllOperations(featureFilter, name));
			//: typeServer.getAllOperations(featureFilter));
		}
	}
	
	public void addClass2_PropertyElements(
			@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		addOwnedProperty(object, FeatureFilter.SELECT_NON_STATIC);
	}
	
	public void addMetaclass1_NamedElementElements(@NonNull Metaclass object) {
		Type instanceType = object.getInstanceType();
		if (instanceType != null) {
			addOwnedProperty(object, null);
		}
	}
	
	public void addEnumeration2_PropertyElements(@NonNull Enumeration object) {
		addOwnedProperty(object, FeatureFilter.SELECT_NON_STATIC);
	}
	
	// FIXME remove when Auto-generation is finished
	private void addOwnedProperty(@NonNull Type type, @Nullable FeatureFilter featureFilter) {
		if (accepts(PivotPackage.Literals.PROPERTY)
			&& (getType() != PivotPackage.Literals.NAMESPACE)) { // Don't really want properties when looking for NAMESPACE
			assert metaModelManager.isTypeServeable(type);
			TypeServer typeServer = metaModelManager.getTypeServer(type);
			addElements(typeServer.getAllProperties(featureFilter, name));
			// : typeServer.getAllProperties(featureFilter));
		}
	}
	
	public void addClass0_BehaviorElements(
			@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		addOwnedBehavior(object);
	}
		
	public void addEnumeration0_BehaviorElements(@NonNull Enumeration object) {
		addOwnedBehavior(object);
	}
	
	// FIXME remove when Auto-generation is finished
	private void addOwnedBehavior(@NonNull org.eclipse.ocl.examples.pivot.Class aClass) {
		if (accepts(PivotPackage.Literals.STATE)) {
			assert metaModelManager.isTypeServeable(aClass);
			TypeServer typeServer = metaModelManager.getTypeServer(aClass);
			addElements(typeServer.getAllStates(name));
			//: typeServer.getAllStates());
		}
	}

	public void addPackage1_PackageElements(@NonNull Package object) {
		addNestedPackage(object);
	}

	// FIXME remove when Auto-generation is finished
	private void addNestedPackage(@NonNull Package pkge) {
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
	
	public void addPackage0_TypeElements(@NonNull Package object) {
		addOwnedType(object);
	}
	
	// FIXME remove when Auto-generation is finished
	private void addOwnedType(@NonNull Package pkge) {
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
	
	public void addRoot0_PackageElements(@NonNull Root object) {
		addNestedPackage(object);
		
	}
	
	// FIXME remove when Auto-generation is finished
	private void addNestedPackage(@NonNull Root root) {
		if (accepts(PivotPackage.Literals.PACKAGE)) {
			addElements(root.getNestedPackage());
	
		}
	}
	
	public void addRoot1_ImportElements(@NonNull Root object) {
		addRootPackages();
	}
	
	// FIXME remove when Auto-generation is finished
	private void addRootPackages() {
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
	
	public void addLibrary0_PrecedenceElements(@NonNull Library object) {
		addOwnedPrecedence(object);
	}
	
	// FIXME remove when Auto-generation is finished
	private void addOwnedPrecedence(@NonNull Library library) {
		if (accepts(PivotPackage.Literals.PRECEDENCE)) {
			addElements(library.getOwnedPrecedence());
		}
	}
	
	public void addLibrary1_TypeElements(@NonNull Library object) {
		addOwnedType(object);
	}
	
		public void addLibrary2_PackageElements(@NonNull Library object) {
		addNestedPackage(object);
	}
		
	public void addIterateExp0_VariableElements(@NonNull IterateExp object) {
		addIterator(object);
	}
	
	public void addIterateExp2_VariableElements(@NonNull IterateExp object) {
		addIterator(object);
	}
	
	public void addIteratorExp0_VariableElements(@NonNull IteratorExp object) {
		addIterator(object);		
	}
	
	// FIXME remove when Auto-generation is finished
	private void addIterator(@NonNull LoopExp  aLoopExp) {
		addElements(aLoopExp.getIterator());
	}
	
	public void addIterateExp3_VariableElements(@NonNull IterateExp object,
			int childIndex) {
		addIterator(object, childIndex);
	}
	
	public void addIteratorExp1_VariableElements(@NonNull IteratorExp object,
			int childIndex) {
		addIterator(object, childIndex);
	}
	
	// FIXME remove when Auto-generation is finished
	private void addIterator(@NonNull LoopExp  aLoopExp, int index) {
		
		// self.iterator->select(x| self.iterator->indexOf(x) < index)		
		for (int i = 0; i <= index -1; i++) { 
			addNamedElement(aLoopExp.getIterator().get(i));
		}
	}
	
	public void addIterateExp1_VariableElement(@NonNull IterateExp object) {
		addResult(object);
	}
	
	// FIXME remove when Auto-generation is finished
	private void addResult(@NonNull IterateExp iterateExp) {
		addNamedElement(iterateExp.getResult());
	}
		
	public void addLetExp0_VariableElement(@NonNull LetExp object) {
		addVariable(object);		
	}
	
	private void addVariable(@NonNull LetExp  letExp) {
		addNamedElement(letExp.getVariable());
	}
	
	public void addExpressionInOCL0_VariableElement(
			@NonNull ExpressionInOCL object) {
		addContextVariable(object);		
	}
	
	// FIXME remove when Auto-generation is finished
	private void addContextVariable(@NonNull ExpressionInOCL expressionInOCL) {
		addNamedElement(expressionInOCL.getContextVariable());
	}

	public void addExpressionInOCL1_VariableElement(
			@NonNull ExpressionInOCL object) {
		addResultVariable(object);
		
	}
	
	// FIXME remove when Auto-generation is finished
	private void addResultVariable(@NonNull ExpressionInOCL expressionInOCL) {
		addNamedElement(expressionInOCL.getResultVariable());
	}
}
		''');
		writer.close();
	}
		
	protected def void generateAbstractPivotNamedEnvironmentClass(@NonNull String outputFolder, 
		@NonNull String packageName) {
				
		var String namedEnvItf = nProvider.getSpecificNamedEnvironmentItf()
		var String commonNamedEnvClass = nProvider.getCommonNamedEnvironmentClass();
		var String abstractNamedEnvClass = nProvider.getSpecificAbstractNamedEnvironmentClass();

		var MergeWriter writer = new MergeWriter(outputFolder + '''«commonNamedEnvClass».java''')
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


public abstract class «abstractNamedEnvClass» extends «commonNamedEnvClass» 
	implements «namedEnvItf» {

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

	
	public «abstractNamedEnvClass»(@NonNull MetaModelManager metaModelManager,
			@NonNull EStructuralFeature reference, @NonNull String name) {
		super(reference, name);
		this.metaModelManager = metaModelManager;
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
	
	public void setBindings(@NonNull Object object, @Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		if (templateBindings == null) {
			templateBindings = new HashMap<Object, Map<TemplateParameter, ParameterableElement>>();
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
					if (!((ScopeFilter.ScopeFilter2)filter).matches(this, element)) { // FIXME ADOLFOSBH
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
	public AutoINamedLookupResult resolveDuplicates() {
		AutoINamedLookupResult result = getResult();
		if (result.getSize() > 1)  {			
			@NonNull List<Object> values = result.getAllResults();
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
			AutoINamedLookupResult newResult = new AutoNamedLookupResult(name); // FIXME asbh worth to use factory method ?
			for (int i=0; i < values.size(); i++) {
				@SuppressWarnings("null") 
				@NonNull Object value = values.get(i);
				newResult.addElement(name, value);
			}
			return newResult;
		}
		return result;
	}

}		
		
		''');

}
	protected def void generatePivotContextItf(@NonNull String outputFolder,
		@NonNull String packageName, @NonNull String baseElmntPckgName, @NonNull String baseElmntName) {
		
		var String commonContextItf = nProvider.getCommonContextItf()
		var String contextItf = nProvider.getSpecificContextItf()
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«contextItf».java''')
		writer.append('''
package «packageName»;

import «baseElmntPckgName».«baseElmntName»;

public interface «contextItf» extends «commonContextItf»<«baseElmntName»> {

}
		''');
		writer.close();
	}
	
	protected def void generatePivotContextClass(@NonNull String outputFolder,
		@NonNull String packageName, @NonNull String baseElmntPckName, @NonNull String baseElmntName) {
		
		var String commonContextClass = nProvider.getCommonContextClass()
		var String contextClass = nProvider.getSpecificContextClass();
		var String contextItf = nProvider.getSpecificContextItf()
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«contextClass».java''')
		writer.append('''
package «packageName»;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import «baseElmntPckName».«baseElmntName»;

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
	protected def void generatePivotVisitorItf(@NonNull String outputFolder, @NonNull String packageName, 
		@NonNull String visitorPckName, @NonNull String visitorName,  
		@NonNull String baseElmntPckName,  @NonNull String baseElmntName
	) {
		var visitorItf =  nProvider.getSpecificVisitorItf()
		var environmentItf = nProvider.getSpecificEnvironmentItf()
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«visitorItf».java''');
		writer.append('''
package «packageName»;

import «visitorPckName».«visitorName»;

public interface «visitorItf» extends «visitorName»<«environmentItf»> {

}
		''');
		writer.close();
	}
	
	protected def void generatePivotVisitorClass(@NonNull String outputFolder, 
		@NonNull String packageName, @NonNull String modelPckName,		
		@NonNull String visitorPckName, @NonNull String visitorName, 
		@NonNull String baseElemntPckgName, @NonNull String baseElmntName,
		@NonNull Package nameResoPackage ) {
			
		var String visitorClass = nProvider.getSpecificVisitorClass()
		var String visitorItf =  nProvider.getSpecificVisitorItf()
		var String environmentItf =  nProvider.getSpecificEnvironmentItf()
		var String commonContextItf = nProvider.getCommonContextItf()
		var Map<Type,List<Operation>> type2envOperations = NameResolutionUtil.computeType2EnvOperations(nameResoPackage);		
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«visitorClass».java''');
		writer.append('''
package «packageName»;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import «baseElemntPckgName».«baseElmntName»;
«FOR type : type2envOperations.keySet»
import «modelPckName».«type.name»;
«ENDFOR»
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;


public class «visitorClass» extends AbstractExtendingVisitor<«environmentItf», «commonContextItf»<«baseElmntName»>>
	implements «visitorItf» {
		 
	@NonNull final protected MetaModelManager mmManager;
	@NonNull final protected «environmentItf» env;
	
	public AutoPivotLookupVisitor(@NonNull MetaModelManager mmManager, @NonNull «environmentItf» env, @NonNull «commonContextItf»<«baseElmntName»> context) {
		super(context);
		this.mmManager = mmManager;
		this.env = env;
	}

	@NonNull
	public «environmentItf» visiting(@NonNull Visitable visitable) {
		return lookupInParent();
	}
	
	@NonNull
	protected final «environmentItf» lookupInNewContext(@Nullable «commonContextItf»<«baseElmntName»> newContext) {
		return newContext == null ? env // If we have reached the top element
			: DomainUtil.nonNullState((newContext.getTarget()).accept( 
				new «visitorClass»(mmManager, env, newContext))); 
	}
	@NonNull
	protected «environmentItf» lookupFromNewElement(Element element) {
		return DomainUtil.nonNullState(element.accept(this));
	}
	
	/**
	 * Will carry on the lookup through parent elements if the accumulated lookup
	 * environment is not complete (i.e a result has been found)
	 * 
	 * This propagation protocol is used when outer scope/environment elements 
	 * are occluded by nested environments (i.e when a fresh nestedEnvironment() has
	 * been configured for the element which has been configured)
	 *
	 * @return the accumulated lookup env
	 */
	@NonNull
	protected «environmentItf» lookupInParentIfEnvNoComplete() {
		return env.isComplete() ? env : lookupInNewContext(context.getParent());
	}
	
	/**
	 * Will carry on the look up thrugh parent elements. 
	 *
	 * By the fault the propagation will occur towards parent elements so that
	 * all ambiguous (duplicated) named elements are detected.
	 *
	 * contexts
	 * @return the accumulated lookup env
	 */
	@NonNull
	protected «environmentItf» lookupInParent() {
		return lookupInNewContext(context.getParent());
	}
	
	// Generated from NameResolution description
	«FOR type : type2envOperations.keySet»	
	«val envOps = type2envOperations.get(type)»
	
	@Override
	public @NonNull
	«environmentItf» visit«type.name»(@NonNull «type.name» object) {
		«IF !NameResolutionUtil.isChildrenBasedEnvOperations(envOps)»
			«val envOp = envOps.get(0) /*FIXME one envOp is assumed*/»
			«FOR addingExpType : NameResolutionUtil.computeEnvOperation2EnvAddingExp(envOp) »
				«val expType = addingExpType.getType»
				«val isMany = expType instanceof CollectionType»
				«val expTypeName = if (expType instanceof CollectionType) expType.elementType.name else expType.name»
				env.add«type.name»«addingExpType.getNumber»_«expTypeName.toFirstUpper»Element«if(isMany)"s"»(object);				
			«ENDFOR»
			«IF NameResolutionUtil.hasNestedEnvCall(envOp)»
			return lookupInParentIfEnvNoComplete();
			«ELSE»
			return lookupInParent();
			«ENDIF»
		«ELSE»
			EReference containmentReference = context.getToChildReference();
			«var genericEnvOpHasNestedEnvCall = false /*To control last return printing simple lookupInParent*/»
			«FOR envOp : envOps»
			«val isFirst = envOps.indexOf(envOp)==0»
			«val propName = NameResolutionUtil.getEnvOpPropertyName(envOp)»
			«IF !isFirst»else«ENDIF»
			«IF NameResolutionUtil.isChildBasedEnvOperation(envOp)»
			if (containmentReference == «helper.getChildQualifiedFeatureAccessor(type, propName)»)
			«ENDIF»
			{
				«FOR addingExp : NameResolutionUtil.computeEnvOperation2EnvAddingExp(envOp) »
				«val useIndex = addingExp.isHasChildIndex»
				«IF useIndex»int childIndex = object.«helper.getFeatureAccessor(type, propName)»().indexOf(context.getChild()); «ENDIF»
				env.«nProvider.getAddMethodName(type, addingExp)»(object«IF useIndex», childIndex«ENDIF»);
				«ENDFOR»
				«IF NameResolutionUtil.hasNestedEnvCall(envOp)»				
				return lookupInParentIfEnvNoComplete();
				«IF NameResolutionUtil.isGenericEnvOperation(envOp)»«{genericEnvOpHasNestedEnvCall = true ''}»«ENDIF»
				«ENDIF»
			}
			«ENDFOR»
			«IF !genericEnvOpHasNestedEnvCall»
			return lookupInParent();
			«ENDIF»
		«ENDIF»
	}
	«ENDFOR»
}
		''');
		writer.close();
	}


	protected def void generatePivotNameResolverItf(@NonNull String outputFolder, @NonNull String packageName,
		@NonNull String visitorPckName, @NonNull String visitorName, 
		@NonNull String baseElemntPckgName, @NonNull String baseElmntName
	) {
		var String resolverItf = nProvider.getSpecificNameResolverItf();
		var String commonNamedResultItf = nProvider.getCommonNamedResultItf();
		var String commonUnnamedResultItf = nProvider.getCommonUnnamedResultItf();
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«resolverItf».java''');
		writer.append('''
package «packageName»;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
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
	public «commonNamedResultItf» computeLookup(@NonNull Element lookupElement, 
		@NonNull EStructuralFeature lookupFeature,
		@NonNull String name, boolean isQualified);
	
	@NonNull
	public «commonUnnamedResultItf» computeLookup(@NonNull Element lookupElement,
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
	public AutoINamedLookupResult computeReferredOperationLookup(@NonNull OperationCallExp opCallExp,
		@NonNull ScopeFilter filter);

	@NonNull
	public AutoINamedLookupResult computeReferredIterationLookup(@NonNull IteratorExp iteratorExp,
		@NonNull ScopeFilter filter);
	
	@NonNull
	public AutoINamedLookupResult computeReferredVariableLookup(@NonNull VariableExp variableExp);
}
		''');
		writer.close();
	}
	
	protected def void generatePivotNameResolverClass(@NonNull String outputFolder, @NonNull String packageName,
		@NonNull String visitorPckName, @NonNull String visitorName, 
		@NonNull String baseElemntPckgName, @NonNull String baseElmntName
	) {
		var String resolverItf = nProvider.getSpecificNameResolverItf();
		var String resolverClass = nProvider.getSpecificNameResolverClass();
		var String contextItf = nProvider.getSpecificContextItf();
		var String contextClass = nProvider.getSpecificContextClass();
		var String commonNamedResultItf = nProvider.getCommonNamedResultItf();
		var String commonUnnamedResultItf = nProvider.getCommonUnnamedResultItf();
		var String envItf = nProvider.getSpecificEnvironmentItf();
		var String namedEnvItf = nProvider.getSpecificNamedEnvironmentItf();
		var String namedEnvClass = nProvider.getSpecificNamedEnvironmentClass();
		var String unnamedEnvItf = nProvider.getSpecificUnnamedEnvironmentItf();
		var String unnamedEnvClass = nProvider.getSpecificUnnamedEnvironmentClass();
		var String visitorItf = nProvider.getSpecificVisitorItf();
		var String visitorClass = nProvider.getSpecificVisitorClass();
		
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«resolverClass».java''');
		writer.append('''
package «packageName»;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
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
	public «commonNamedResultItf» computeLookup(@NonNull «baseElmntName» lookupElement,
		@NonNull EStructuralFeature lookupFeature,
		@NonNull String name, boolean isQualified) {
		«contextItf» context = createLookupContext(lookupFeature, lookupElement);
		«namedEnvItf» env = createLookupEnvironment(mmManager, lookupFeature, name);		
		return computeNamedResult(lookupElement, env, context);
	}
	
	@NonNull
	public «commonUnnamedResultItf» computeLookup(
			@NonNull «baseElmntName» lookupElement,
			@NonNull EStructuralFeature lookupFeature, boolean isQualified) {
		«contextItf» context = createLookupContext(lookupFeature, lookupElement);
		«unnamedEnvItf» env = createLookupEnvironment(mmManager, lookupFeature);		
		return computeUnnamedResult(lookupElement, env, context);
	}
	
	@NonNull
	protected  «visitorItf» createLookupVisitor(@NonNull MetaModelManager mmManager,
		@NonNull «envItf» env, @NonNull «contextItf» context) {
		return new «visitorClass»(mmManager, env, context);
	}
	
	@NonNull
	protected  «namedEnvItf» createLookupEnvironment(@NonNull MetaModelManager mmManager, 
		@NonNull EStructuralFeature lookupFeature, @NonNull String name) {
		return new «namedEnvClass»(mmManager, lookupFeature, name);
	}
	
	@NonNull
	protected  «unnamedEnvItf» createLookupEnvironment(@NonNull MetaModelManager mmManager, 
		@NonNull EStructuralFeature lookupFeature) {
		return new «unnamedEnvClass»(mmManager, lookupFeature);
	}
	
	@NonNull
	protected «contextItf» createLookupContext(@NonNull EStructuralFeature lookupFeature,
		@NonNull «baseElmntName» lookupElement) {
		return new «contextClass»(lookupFeature, lookupElement);
	}
		
	@NonNull
	protected  «envItf» executeVisitor(@NonNull «baseElmntName» element, 
		@NonNull «envItf» env, 
		@NonNull «contextItf» context) { 
		return DomainUtil.nonNullState(element.accept(createLookupVisitor(mmManager, env, context)));
	}
	
	@NonNull
	protected «commonNamedResultItf» computeNamedResult(@NonNull «baseElmntName» element, 
		@NonNull «namedEnvItf» env, 
		@NonNull «contextItf» context) { 
		«envItf» env2= executeVisitor(element, env, context);		
		return ((«namedEnvItf»)env2).resolveDuplicates();
	}		
	
	@NonNull
	protected  «commonUnnamedResultItf» computeUnnamedResult(@NonNull «baseElmntName» element, 
		@NonNull «unnamedEnvItf» env, 
		@NonNull «contextItf» context) { 
		«envItf» env2 = executeVisitor(element, env, context);		
		return ((«unnamedEnvItf»)env2).getResult();
	}	

	@NonNull
	public «commonNamedResultItf» computeReferredOperationLookup(
			@NonNull OperationCallExp opCallExp,
			@NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}

	@NonNull
	public «commonNamedResultItf» computeReferredIterationLookup(
			@NonNull IteratorExp iteratorExp,
			@NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}

	@NonNull
	public «commonNamedResultItf» computeReferredVariableLookup(
			@NonNull VariableExp variableExp) {
		throw new IllegalArgumentException("No auto-generation implemented");
	}
}
		''');
		writer.close();
	}	
}