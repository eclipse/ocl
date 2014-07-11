package org.eclipse.ocl.examples.pivot.lookup;

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

public class AutoPivotNamedLookupEnvironment extends AutoAbstractPivotNamedLookupEnvironment {
	public AutoPivotNamedLookupEnvironment(@NonNull MetaModelManager metaModelManager,
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
