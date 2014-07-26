/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.generator;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public interface GenModelHelper
{
	@NonNull Class<?> getAbstractOperationClass(@NonNull List<?> parameters);
	@Nullable Class<?> getEcoreFactoryClass(@NonNull EPackage ePackage);
	@NonNull Class<?> getEcoreInterfaceClass(@NonNull Type owningType) throws GenModelException;
	@Nullable String getEcoreInterfaceClassName(@NonNull EClass eClass);
	@NonNull Class<?> getEcoreInterfaceClassifier(@NonNull EClassifier eClassifier) throws GenModelException;
	@Nullable String getEcoreInterfaceClassifierName(@NonNull EClassifier eClassifier);
	@Nullable String getEcoreInterfaceName(@NonNull Type type);
	@Nullable String getEcoreClassName(@NonNull Type type);
//	@Nullable GenClass getGenClass(@NonNull Type type);
	@Nullable GenClassifier getGenClassifier(@NonNull Type type);
	@Nullable GenOperation getGenOperation(@NonNull Operation operation);
	@Nullable GenPackage getGenPackage(@NonNull org.eclipse.ocl.examples.pivot.Package asPackage);
	@Nullable GenPackage getGenPackage(@NonNull Type type);
	@Nullable GenParameter getGenParameter(@NonNull Parameter parameter);
	@NonNull String getGetAccessor(@NonNull Property aProperty) throws GenModelException;
	@NonNull String getGetAccessor(@NonNull EStructuralFeature eStructuralFeature) throws GenModelException;
	@Nullable String getImplementationClassName(@NonNull EClassifier eClassifier);
	@NonNull String getLiteralName(@NonNull EClassifier eClassifier);
	@NonNull MetaModelManager getMetaModelManager();
	@NonNull String getOperationAccessor(@NonNull Operation anOperation) throws GenModelException;
	@NonNull Class<?> getOperationInterface(@NonNull List<? extends TypedElement> parameters);
	@NonNull String getOperationReturnType(@NonNull Operation operation) throws GenModelException;
	@NonNull String getPropertyResultType(@NonNull Property property) throws GenModelException;
	@Nullable String getQualifiedFactoryInterfaceName(@NonNull EPackage ePackage);
	@Nullable String getQualifiedFactoryInterfaceName(@NonNull Type type);
	@Nullable String getQualifiedFactoryInstanceAccessor(@NonNull EPackage ePackage);
	@Nullable String getQualifiedFactoryInstanceAccessor(@NonNull Type type);
	@Nullable String getQualifiedPackageInterfaceName(@NonNull EPackage ePackage);
//	@Nullable String getQualifiedLiteraleName(@NonNull EPackage ePackage);
//	@Nullable String getQualifiedOperationImplementationName(@NonNull CodeGenSnippet snippet, @NonNull Operation anOperation, @NonNull String stereotype);
//	@Nullable String getQualifiedPropertyImplementationName(@NonNull CodeGenSnippet snippet, @NonNull Property aProperty, @NonNull String stereotype);
//	@Nullable String getQualifiedLiteralName(@NonNull CodeGenSnippet snippet, @NonNull Operation anOperation);
//	@Nullable String getQualifiedLiteralName(@NonNull CodeGenSnippet snippet, @NonNull Property aProperty);
	@NonNull String getQualifiedValidatorClassName(@NonNull GenPackage genPackage);
	@NonNull String getSetAccessor(@NonNull EStructuralFeature eStructuralFeature);
	@NonNull String getTablesClassName(@NonNull GenPackage genPackage);
}
