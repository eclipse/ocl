package org.eclipse.ocl.examples.pivot.lookup;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
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


/**
 * Interface to carry the results of a lookup process
 * 
 * @author adolfosbh
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
	C getContent();

	// TEMPORAL STUFF
	// FIXME can we get rid of this ?
	/**
	 * Convenience method to remove name duplicates so that it can be called
	 * once the lookup process finishes 
	 * 
	 * @return returns this {@link AutoILookupResult} after resolving duplicates 
	 */
	@NonNull
	AutoILookupResult<C> resolveDuplicates();
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
	public void addVariable(@NonNull IterateExp  iterateExp);	
	public void addResult(@NonNull IterateExp iterateExp);
	
	// Iterator Exp
	public void addVariable(@NonNull IteratorExp  iteratorExp);
	
	// LetExp
	public void addVariable(@NonNull LetExp  letExp);
	
	// ExpressionInOCL
	public void addContextVariable(@NonNull ExpressionInOCL expressionInOCL);
	public void addResultVariable(@NonNull ExpressionInOCL expressionInOCL);
}
