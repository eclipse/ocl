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
		
		generator.generatePivotResultItf(outputFolder, projectPrefix, packageName, baseElmntName);
		generator.generatePivotResultClass(outputFolder, projectPrefix, packageName,  baseElmntName);
		generator.generatePivotContextItf(outputFolder, projectPrefix, packageName, baseElmntName);
		generator.generatePivotContextClass(outputFolder, projectPrefix, packageName, baseElmntName);
		generator.generatePivotVisitorItf(outputFolder, projectPrefix,  packageName, visitorPckName, visitorName, baseElmntPckName, baseElmntName);
		generator.generatePivotVisitorClass(outputFolder, projectPrefix, packageName, visitorPckName, visitorName, baseElmntPckName, baseElmntName);
		generator.generatePivotNameResolverItf(outputFolder, projectPrefix, packageName, visitorPckName, visitorName, baseElmntPckName, baseElmntName);
		generator.generatePivotNameResolverClass(outputFolder, projectPrefix, packageName, visitorPckName, visitorName, baseElmntPckName, baseElmntName);
	}
	
	protected def void generatePivotResultItf(@NonNull String outputFolder, @NonNull String projectPrefix,
		@NonNull String packageName, @NonNull String baseElmntName) {
		
		var String commonResultItf = getCommonResultItf()
		var String resultItf = getSpecificResultItf(projectPrefix)
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«resultItf».java''')
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


public interface «resultItf»<C extends «baseElmntName»> extends «commonResultItf»<C> {

	public void addFilter(@NonNull ScopeFilter filter);
	public void removeFilter(@NonNull ScopeFilter filter);
	@NonNull
	public MetaModelManager getMetaModelManager();
	public void setBindings(@NonNull C object, @Nullable Map<TemplateParameter, ParameterableElement> bindings);
	
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
	
	protected def void generatePivotResultClass(@NonNull String outputFolder, @NonNull String projectPrefix, 
		@NonNull String packageName, @NonNull String baseElmntName) {
		
		var String resultItf = getSpecificResultItf(projectPrefix)
		var String resultClass = getSpecificResultClass(projectPrefix)
		var String commonClass = getCommonResultClass()
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«resultClass».java''');
		writer.append('''
package «packageName»;

import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.manager.RootPackageServer;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


public class «resultClass»<C extends «baseElmntName»> extends «commonClass»<C>
	implements «resultItf»<C>{

	public AutoPivotLookupResult(@NonNull MetaModelManager metaModelManager,
			@NonNull EStructuralFeature reference, @NonNull AutoLookupKind lookupKind, String name) {
		super(metaModelManager, reference, lookupKind, name);
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
			addElements(name != null ? typeServer.getAllOperations(featureFilter, name)
				: typeServer.getAllOperations(featureFilter));
		}
	}
	
	public void addOwnedProperty(@NonNull Type type, @Nullable FeatureFilter featureFilter) {
		if (accepts(PivotPackage.Literals.PROPERTY)
			&& (getType() != PivotPackage.Literals.NAMESPACE)) { // Don't really want properties when looking for NAMESPACE
			assert metaModelManager.isTypeServeable(type);
			TypeServer typeServer = metaModelManager.getTypeServer(type);
			addElements(name != null ? typeServer.getAllProperties(featureFilter, name)
				: typeServer.getAllProperties(featureFilter));
		}
	}
	
	public void addOwnedState(@NonNull org.eclipse.ocl.examples.pivot.Class type) {
		if (accepts(PivotPackage.Literals.STATE)) {
			assert metaModelManager.isTypeServeable(type);
			TypeServer typeServer = metaModelManager.getTypeServer(type);
			addElements(name != null ? typeServer.getAllStates(name)
				: typeServer.getAllStates());
		}
	}
	

	public void addAllPackages(@NonNull Package pkge) {
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
	
	public void addOwnedTypes(@NonNull Package pkge) {
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
	
	
	public void addNestedPackages(@NonNull Root root) {
		if (accepts(PivotPackage.Literals.PACKAGE)) {
			addElements(root.getNestedPackage());
		}
	}
	
	public void addRootPackages() {
		PackageManager packageManager = metaModelManager.getPackageManager();
		String name2 = name;
		if (name2 != null) {
			addNamedElement(packageManager.getMemberPackage(name2));
			addNamedElement(packageManager.getPackageByURI(name2));			
		}
		else {			
			for (RootPackageServer rootPackageServer : packageManager.getMemberPackages()) {
				addNamedElement(rootPackageServer);
			}
			for (PackageServer packageServer : packageManager.getAllPackagesWithUris()) {
				String nsURI = packageServer.getNsURI();
				if (nsURI != null) {
					addElement(nsURI, packageServer);
				}
			}
		}
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
		var resultItf = getSpecificResultItf(projectPrefix)
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«visitorItf».java''');
		writer.append('''
package «packageName»;

import «baseElmntPckName».«baseElmntName»;
import «visitorPckName».«visitorName»;

public interface «visitorItf»<C extends «baseElmntName»> extends «visitorName»<«resultItf»<C>> {

}
		''');
		writer.close();
	}
	
	protected def void generatePivotVisitorClass(@NonNull String outputFolder, @NonNull String projectPrefix, @NonNull String packageName,
		@NonNull String visitorPckName, @NonNull String visitorName, @NonNull String baseElemntPckgName, @NonNull String baseElmntName
	) {
		var String visitorClass = getSpecificVisitorClass(projectPrefix)
		var String visitorItf =  getSpecificVisitorItf(projectPrefix)
		var String resultItf =  getSpecificResultItf(projectPrefix)
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


public class «visitorClass»<C extends «baseElmntName»> extends AbstractExtendingVisitor<«resultItf»<C>, «commonContextItf»<«baseElmntName»>>
	implements «visitorItf»<C> {
		 
	@NonNull final protected MetaModelManager mmManager;
	@NonNull final protected «resultItf»<C> result;
	
	public AutoPivotLookupVisitor(@NonNull MetaModelManager mmManager, @NonNull «resultItf»<C> result, @NonNull «commonContextItf»<«baseElmntName»> context) {
		super(context);
		this.mmManager = mmManager;
		this.result = result;
	}

	@NonNull
	public «resultItf»<C> visiting(@NonNull Visitable visitable) {
		return lookupInParentIfNotComplete();
	}
	
	@NonNull
	protected final «resultItf»<C> lookupInNewContext(@Nullable «commonContextItf»<«baseElmntName»> newContext) {
		return newContext == null ? result // If we have reached the top element
			: DomainUtil.nonNullState((newContext.getTarget()).accept( 
				new «visitorClass»<C>(mmManager, result, newContext))); 
	}
	@NonNull
	protected «resultItf»<C> lookupFromNewElement(Element element) {
		return DomainUtil.nonNullState(element.accept(this));
	}
	
	// Lookup propagation protocols 
	
	/**
	 * Used when ONLY looking up in local 
	 * @return the accumulated lookup result
	 */
	@NonNull
	protected «resultItf»<C> lookupOnlyLocal() {
		return result;
	}
	
	/**
	 * Used when looking up in local AND in parent environments if not found 
	 * in local -> outer scope/environment elements are occluded in nested 
	 * contexts
	 * @return the accumulated lookup result
	 */
	@NonNull
	protected «resultItf»<C> lookupInParentIfNotComplete() {
		return result.isComplete() ? result : lookupInNewContext(context.getParent());
	}
	
	/**
	 * Used when looking up in local AND in parent environments
	 * @return the accumulated lookup result
	 */
	@NonNull
	protected «resultItf»<C> lookupInParent() {
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
		var String resultItf = getSpecificResultItf(projectPrefix);
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«resolverItf».java''');
		writer.append('''
package «packageName»;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
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
	public <C extends «baseElmntName»> «resultItf»<C> computeLookup(@NonNull «baseElmntName» lookupElement, @NonNull EStructuralFeature lookupFeature,
		@NonNull AutoLookupKind lookupKind, @Nullable String name, boolean isQualified);
	
	/**
	 * Resolves the referred operation of OperationCallExp
	 * 
	 * @param opCallExp the element from which the lookup will be performed
	 * @param lookupKind the kind of lookup
	 * @return 
	 */
	@NonNull
	public AutoIPivotLookupResult<Operation> computeReferredOperationLookup(@NonNull OperationCallExp opCallExp,
		@NonNull AutoLookupKind lookupKind, @NonNull ScopeFilter filter);

	@NonNull
	public AutoIPivotLookupResult<Iteration> computeReferredIterationLookup(@NonNull IteratorExp iteratorExp, 
		@NonNull AutoLookupKind lookupKind, @NonNull ScopeFilter filter);
	
	@NonNull
	public AutoIPivotLookupResult<Variable> computeReferredVariableLookup(@NonNull VariableExp variableExp,
		@NonNull AutoLookupKind lookupKind);
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
		var String resultItf = getSpecificResultItf(projectPrefix);
		var String resultClass = getSpecificResultClass(projectPrefix);
		var String visitorItf = getSpecificVisitorItf(projectPrefix);
		var String visitorClass = getSpecificVisitorClass(projectPrefix);
		
		
		var MergeWriter writer = new MergeWriter(outputFolder + '''«resolverClass».java''');
		writer.append('''
package «packageName»;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
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
	
	public AutoPivotNameResolver(@NonNull MetaModelManager mmManager) {
		this.mmManager = mmManager;
	}
		
	@NonNull
	public <C extends «baseElmntName»> «resultItf»<C> computeLookup(@NonNull «baseElmntName» lookupElement, @NonNull EStructuralFeature lookupFeature,
		@NonNull AutoLookupKind lookupKind, @Nullable String name, boolean isQualified) {
		«contextItf» context = createLookupContext(lookupFeature, lookupElement);
		«resultItf»<C> result = createLookupResult(mmManager, lookupFeature, lookupKind, name);
		return executeVisitor(lookupElement, result, context);
	}
	
	@NonNull
	protected <C extends «baseElmntName»> «visitorItf»<C> createLookupVisitor(@NonNull MetaModelManager mmManager,
		@NonNull «resultItf»<C> result, @NonNull «contextItf» context) {
		return new «visitorClass»<C>(mmManager, result, context);
	}
	
	@NonNull
	protected <C extends «baseElmntName»> «resultItf»<C> createLookupResult(@NonNull MetaModelManager mmManager, 
		@NonNull EStructuralFeature lookupFeature, 	@NonNull AutoLookupKind lookupKind, @Nullable String name) {
		return new «resultClass»<C>(mmManager, lookupFeature, lookupKind, name);
	}
	
	@NonNull
	protected «contextItf» createLookupContext(@NonNull EStructuralFeature lookupFeature,
		@NonNull Element lookupElement) {
		return new «contextClass»(lookupFeature, lookupElement);
	}
	
	@NonNull
	protected <C extends «baseElmntName»> «resultItf»<C> executeVisitor(@NonNull «baseElmntName» element, @NonNull «resultItf»<C> result, 
		@NonNull «contextItf» context) { 
		return resolveDuplicates(element.accept(createLookupVisitor(mmManager, result, context)));
	}
	
	@NonNull
	protected <C extends «baseElmntName»> «resultItf»<C> resolveDuplicates(@Nullable «resultItf»<C> result) {
		return («resultItf»<C>)DomainUtil.nonNullState(result).resolveDuplicates();
	}

	@NonNull
	public AutoIPivotLookupResult<Operation> computeReferredOperationLookup(
			@NonNull OperationCallExp opCallExp,
			@NonNull AutoLookupKind lookupKind, @NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("Not auto-generated implemented");
	}

	@NonNull
	public AutoIPivotLookupResult<Iteration> computeReferredIterationLookup(
			@NonNull IteratorExp iteratorExp,
			@NonNull AutoLookupKind lookupKind, @NonNull ScopeFilter filter) {
		throw new IllegalArgumentException("Not auto-generated implemented");
	}

	@NonNull
	public AutoIPivotLookupResult<Variable> computeReferredVariableLookup(
			@NonNull VariableExp variableExp, @NonNull AutoLookupKind lookupKind) {
		throw new IllegalArgumentException("Not auto-generated implemented");
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
	
	def protected String getSpecificVisitorItf(String projectPrefix) {
		return '''«autoPrefix»I«projectPrefix»LookupVisitor''' 
	}
	
	def protected String getSpecificVisitorClass(String projectPrefix) {
		return '''«autoPrefix»«projectPrefix»LookupVisitor'''
	}
	
	def protected String getSpecificNameResolverItf(String projectPrefix) {
		return '''«autoPrefix»I«projectPrefix»NameResolver'''
	}
	
	def protected String getSpecificNameResolverClass(String projectPrefix) {
		return '''«autoPrefix»«projectPrefix»NameResolver'''
	}
	
}