package org.eclipse.ocl.examples.pivot.lookup;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;

public interface AutoIPivotLookupEnvironment extends AutoILookupEnvironment {

	// TEMPORAL STUFF
	// ASBH FIXME can we get rid of this ?
	public void addFilter(@NonNull ScopeFilter filter);
	public void removeFilter(@NonNull ScopeFilter filter);
	@NonNull
	public MetaModelManager getMetaModelManager();
	public void setBindings(@NonNull Object object, @Nullable Map<TemplateParameter, ParameterableElement> bindings);
	// END OF TEMPORAL STUFF
	
	// Generated from NameResolution description
	
	// Library
	
	public void addLibrary0_PrecedenceElements(@NonNull Library object);
	public void addLibrary1_TypeElements(@NonNull Library object);
	public void addLibrary2_PackageElements(@NonNull Library object);
	
	// Metaclass
	
	public void addMetaclass0_NamedElementElements(@NonNull Metaclass object);
	public void addMetaclass1_NamedElementElements(@NonNull Metaclass object);
	
	// Operation
	
	public void addOperation0_ParameterElements(@NonNull Operation object);
	
	// Package
	
	public void addPackage0_TypeElements(@NonNull Package object);
	public void addPackage1_PackageElements(@NonNull Package object);
	
	// IterateExp
	
	public void addIterateExp0_VariableElements(@NonNull IterateExp object);
	public void addIterateExp1_VariableElement(@NonNull IterateExp object);
	public void addIterateExp2_VariableElements(@NonNull IterateExp object);
	public void addIterateExp3_VariableElements(@NonNull IterateExp object, int childIndex);
	
	// LetExp
	
	public void addLetExp0_VariableElement(@NonNull LetExp object);
	
	// IteratorExp
	
	public void addIteratorExp0_VariableElements(@NonNull IteratorExp object);
	public void addIteratorExp1_VariableElements(@NonNull IteratorExp object, int childIndex);
	
	// ExpressionInOCL
	
	public void addExpressionInOCL0_VariableElement(@NonNull ExpressionInOCL object);
	public void addExpressionInOCL1_VariableElement(@NonNull ExpressionInOCL object);
	
	// Enumeration
	
	public void addEnumeration0_BehaviorElements(@NonNull Enumeration object);
	public void addEnumeration1_OperationElements(@NonNull Enumeration object);
	public void addEnumeration2_PropertyElements(@NonNull Enumeration object);
	public void addEnumeration3_EnumerationLiteralElements(@NonNull Enumeration object);
	
	// Class
	
	public void addClass0_BehaviorElements(@NonNull Class object);
	public void addClass1_OperationElements(@NonNull Class object);
	public void addClass2_PropertyElements(@NonNull Class object);
	
	// DataType
	
	
	// Root
	
	public void addRoot0_PackageElements(@NonNull Root object);
	public void addRoot1_ImportElements(@NonNull Root object);
	
	// TemplateableElement
	// FIXME no auto-generated yet
	public void addTypeTemplateParameterables(@NonNull TemplateableElement tmpltblElement);
	
}
