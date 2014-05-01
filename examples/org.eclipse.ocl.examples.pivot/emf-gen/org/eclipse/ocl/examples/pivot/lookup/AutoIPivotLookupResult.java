package org.eclipse.ocl.examples.pivot.lookup;

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
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;


public interface AutoIPivotLookupResult<C extends Element> extends AutoILookupResult<C> {

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
