package org.eclipse.ocl.examples.pivot.lookup;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;

public interface AutoIPivotLookupEnvironment<C extends Element> extends AutoILookupEnvironment {

	// TEMPORAL STUFF
	// ASBH FIXME can we get rid of this ?
	public void addFilter(@NonNull ScopeFilter filter);
	public void removeFilter(@NonNull ScopeFilter filter);
	@NonNull
	public MetaModelManager getMetaModelManager();
	public void setBindings(@NonNull C object, @Nullable Map<TemplateParameter, ParameterableElement> bindings);
	// END OF TEMPORAL STUFF
	
	// Generated from NameResolution description
	
	// Class
	public void addOwnedBehavior(@NonNull Class aClass);
	
	// LoopExp
	public void addIterator(@NonNull LoopExp aLoopExp);
	
	// Package
	public void addOwnedType(@NonNull Package aPackage);
	public void addNestedPackage(@NonNull Package aPackage);
	
	// Root
	public void addNestedPackage(@NonNull Root aRoot);
	public void addImports(@NonNull Root aRoot);
	
	// LetExp
	public void addVariable(@NonNull LetExp aLetExp);
	
	// IterateExp
	public void addResult(@NonNull IterateExp aIterateExp);
	
	// ExpressionInOCL
	public void addResultVariable(@NonNull ExpressionInOCL aExpressionInOCL);
	public void addContextVariable(@NonNull ExpressionInOCL aExpressionInOCL);
	
	// Library
	public void addOwnedPrecedence(@NonNull Library aLibrary);
	
	// Type
	public void addOwnedOperation(@NonNull Type aType);
	public void addOwnedAttribute(@NonNull Type aType);
	
	// Enumeration
	public void addOwnedLiteral(@NonNull Enumeration aEnumeration);
	
	// Operation
	public void addOwnedParameter(@NonNull Operation aOperation);
	
	// TemplateableElement
	// FIXME
	public void addTypeTemplateParameterables(@NonNull TemplateableElement tmpltblElement);
	
	// Type
	// FIXME
	public void addOwnedOperation(@NonNull Type type, @Nullable FeatureFilter featureFilter);
	public void addOwnedProperty(@NonNull Type type, @Nullable FeatureFilter featureFilter);
	
	// LoopExp
	// FIXME
	public void addIterator(@NonNull LoopExp  aLoopExp, int index);
}
