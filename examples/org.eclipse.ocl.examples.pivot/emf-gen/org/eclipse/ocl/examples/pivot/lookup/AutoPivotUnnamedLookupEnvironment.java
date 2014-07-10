package org.eclipse.ocl.examples.pivot.lookup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.pivot.Class;
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
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.manager.RootPackageServer;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


public class AutoPivotUnnamedLookupEnvironment extends AutoUnnamedLookupEnvironment
	implements AutoIPivotUnnamedLookupEnvironment{
	
	
	private final @NonNull MetaModelManager metaModelManager;

	private Map<Object, Map<TemplateParameter, ParameterableElement>> templateBindings = null;
	private List<ScopeFilter> matchers = null;	// Prevailing filters for matching
	private Set<ScopeFilter> resolvers = null;	// Successful filters for resolving

	
	public AutoPivotUnnamedLookupEnvironment(@NonNull MetaModelManager metaModelManager,
			@NonNull EStructuralFeature reference) {
		super(reference);
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
	
	public void addOwnedLiteral(@NonNull Enumeration object) {
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
			addElements(typeServer.getAllOperations(featureFilter));
		}
	}
	
	public void addOwnedProperty(@NonNull Type type, @Nullable FeatureFilter featureFilter) {
		if (accepts(PivotPackage.Literals.PROPERTY)
			&& (getType() != PivotPackage.Literals.NAMESPACE)) { // Don't really want properties when looking for NAMESPACE
			assert metaModelManager.isTypeServeable(type);
			TypeServer typeServer = metaModelManager.getTypeServer(type);
			addElements(typeServer.getAllProperties(featureFilter));
		}
	}
	
	public void addOwnedBehavior(@NonNull org.eclipse.ocl.examples.pivot.Class aClass) {
		if (accepts(PivotPackage.Literals.STATE)) {
			assert metaModelManager.isTypeServeable(aClass);
			TypeServer typeServer = metaModelManager.getTypeServer(aClass);
			addElements(typeServer.getAllStates());
		}
	}
	

	public void addNestedPackage(@NonNull Package pkge) {
		if (accepts(PivotPackage.Literals.PACKAGE)) {
			PackageServer parentPackageServer = metaModelManager.getPackageServer(pkge);
			for (PackageServer packageServer : parentPackageServer.getMemberPackages()) {
				if (packageServer != null) {
					addNamedElement(packageServer);
				}
			}

		}
	}
	
	public void addOwnedType(@NonNull Package pkge) {
		if (accepts(PivotPackage.Literals.CLASS)) {
			PackageServer packageServer = metaModelManager.getPackageServer(pkge);
			for (TypeServer type : packageServer.getMemberTypes()) {
				if (type != null) {
					addNamedElement(type);
				}
			}
		}
	}
	
	
	public void addNestedPackage(@NonNull Root root) {
		if (accepts(PivotPackage.Literals.PACKAGE)) {
			addElements(root.getNestedPackage());
		}
	}
	
	public void addRootPackages() {
		PackageManager packageManager = metaModelManager.getPackageManager();
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
	
	public void addOwnedPrecedence(@NonNull Library library) {
		if (accepts(PivotPackage.Literals.PRECEDENCE)) {
			addElements(library.getOwnedPrecedence());
		}
	}
	
	public void addIterator(@NonNull LoopExp  aLoopExp) {
		addElements(aLoopExp.getIterator());
	}
	
	public void addIterator(@NonNull LoopExp  aLoopExp, int index) {
		addNamedElement(aLoopExp.getIterator().get(index));
	}
	
	public void addResult(@NonNull IterateExp iterateExp) {
		addNamedElement(iterateExp.getResult());
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
	
	public void addImports(@NonNull Root aRoot) {
		addRootPackages();
	}

	public void addOwnedOperation(@NonNull Type aType) {
		// FIXME Pending on filter design
	}

	public void addOwnedAttribute(@NonNull Type aType) {
		// FIXME Pending on filter design
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

	public void addExpressionInOCL0_VariableElement(
			@NonNull ExpressionInOCL object) {
		// TODO Auto-generated method stub
		
	}

	public void addExpressionInOCL1_VariableElement(
			@NonNull ExpressionInOCL object) {
		// TODO Auto-generated method stub
		
	}

	public void addIteratorExp0_VariableElements(@NonNull IteratorExp object) {
		// TODO Auto-generated method stub
		
	}

	public void addPackage0_TypeElements(@NonNull Package object) {
		// TODO Auto-generated method stub
		
	}

	public void addPackage1_PackageElements(@NonNull Package object) {
		// TODO Auto-generated method stub
		
	}

	public void addLibrary0_PrecedenceElements(@NonNull Library object) {
		// TODO Auto-generated method stub
		
	}

	public void addLibrary1_TypeElements(@NonNull Library object) {
		// TODO Auto-generated method stub
		
	}

	public void addLibrary2_PackageElements(@NonNull Library object) {
		// TODO Auto-generated method stub
		
	}

	public void addOperation0_ParameterElements(@NonNull Operation object) {
		// TODO Auto-generated method stub
		
	}

	public void addRoot0_PackageElements(@NonNull Root object) {
		// TODO Auto-generated method stub
		
	}

	public void addRoot1_ImportElements(@NonNull Root object) {
		// TODO Auto-generated method stub
		
	}

	public void addEnumeration0_BehaviorElements(@NonNull Enumeration object) {
		// TODO Auto-generated method stub
		
	}

	public void addEnumeration1_OperationElements(@NonNull Enumeration object) {
		// TODO Auto-generated method stub
		
	}

	public void addEnumeration2_PropertyElements(@NonNull Enumeration object) {
		// TODO Auto-generated method stub
		
	}

	public void addEnumeration3_EnumerationLiteralElements(
			@NonNull Enumeration object) {
		// TODO Auto-generated method stub
		
	}

	public void addMetaclass0_NamedElementElements(@NonNull Metaclass object) {
		// TODO Auto-generated method stub
		
	}

	public void addMetaclass1_NamedElementElements(@NonNull Metaclass object) {
		// TODO Auto-generated method stub
		
	}

	public void addLetExp0_VariableElement(@NonNull LetExp object) {
		// TODO Auto-generated method stub
		
	}

	public void addClass0_BehaviorElements(@NonNull Class object) {
		// TODO Auto-generated method stub
		
	}

	public void addClass1_OperationElements(@NonNull Class object) {
		// TODO Auto-generated method stub
		
	}

	public void addClass2_PropertyElements(@NonNull Class object) {
		// TODO Auto-generated method stub
		
	}

	public void addIterateExp0_VariableElements(@NonNull IterateExp object) {
		// TODO Auto-generated method stub
		
	}

	public void addIterateExp1_VariableElement(@NonNull IterateExp object) {
		// TODO Auto-generated method stub
		
	}

	public void addIterateExp2_VariableElements(@NonNull IterateExp object) {
		// TODO Auto-generated method stub
		
	}
}
