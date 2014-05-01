package org.eclipse.ocl.examples.pivot.lookup;

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


public class AutoPivotLookupResult<C extends Element> extends AutoLookupResult<C>
	implements AutoIPivotLookupResult<C>{

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
