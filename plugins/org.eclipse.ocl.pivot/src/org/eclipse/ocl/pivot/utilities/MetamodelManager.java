/*******************************************************************************
 * Copyright (c) 2010,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *	E.D.Willink (CEA LIST) - Bug 399252
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.External2AS;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public interface MetamodelManager
{
	public static interface Internal extends MetamodelManager
	{
		void addClassLoader(@NonNull ClassLoader classLoader);

		void addES2AS(@NonNull Resource esResource, @NonNull External2AS es2as);

		void addExternalResource(@NonNull External2AS external2as);

		void addGenModel(@NonNull GenModel genModel);

		@Nullable Namespace addGlobalNamespace(@NonNull String name, @NonNull Namespace namespace);

		void addLockedElement(@NonNull Object lockedElement);

		void configureLoadFirstStrategy();

		boolean conformsTo(@NonNull Type firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
				@NonNull Type secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions);

		@Nullable org.eclipse.ocl.pivot.Package getASmetamodel();
		
		@NonNull Iterable<Constraint> getAllInvariants(@NonNull Type pivotType);

		@NonNull org.eclipse.ocl.pivot.Class getCollectionType(@NonNull String collectionTypeName, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper);

		@NonNull CompleteClassInternal getCompleteClass(@NonNull Type pivotType);
		
		@Override
		@NonNull CompleteModelInternal getCompleteModel();

		@NonNull CompletePackage getCompletePackage(@NonNull org.eclipse.ocl.pivot.Package asPackage);

		@Override
		@NonNull EnvironmentFactoryInternal getEnvironmentFactory();

		@Nullable GenPackage getGenPackage(@NonNull String nsURI);

		@Nullable ParserContext getParserContext(@NonNull Element element, Object... todoParameters);

		@Nullable org.eclipse.ocl.pivot.Class getPrimaryType(@NonNull String nsURI, @NonNull String path, String... extraPath);

		@Override
		@NonNull StandardLibraryInternal getStandardLibrary();

		@NonNull org.eclipse.ocl.pivot.Class getType(@NonNull org.eclipse.ocl.pivot.Class dType);

		void installRoot(@NonNull Model pivotModel);

		@Nullable Element loadResource(@NonNull URI uri, String alias, @Nullable ResourceSet resourceSet) throws ParserException;

		@Nullable Element loadResource(@NonNull Resource resource, @Nullable URI uri) throws ParserException;
	}

	@Nullable org.eclipse.ocl.pivot.Class getASClass(@NonNull String className);

	@Nullable <T extends Element> T getASOf(@NonNull Class<T> pivotClass, @Nullable EObject eObject) throws ParserException;

	@Nullable <T extends Element> T getASOfEcore(@NonNull Class<T> pivotClass, @Nullable EObject eObject);

	@NonNull ResourceSet getASResourceSet();
	
	@NonNull CompleteModel getCompleteModel();

	@Nullable <T extends EObject> T getEcoreOfPivot(@NonNull Class<T> ecoreClass, @NonNull Element element);

	@NonNull EnvironmentFactory getEnvironmentFactory();

	@NonNull ResourceSet getExternalResourceSet();

	@NonNull Operation getPrimaryOperation(@NonNull Operation pivotOperation);

	@NonNull org.eclipse.ocl.pivot.Package getPrimaryPackage(@NonNull org.eclipse.ocl.pivot.Package eObject);

	@NonNull Property getPrimaryProperty(@NonNull Property pivotProperty);
	
	@NonNull ProjectManager getProjectManager();

	@NonNull StandardLibrary getStandardLibrary();
	
	/**
	 * Convert the specification of an OCL expression from textual CS form to parsed executable AS form. The textual form typically
	 * results from simple construction from source text or a UML OpaqueExpression.
	 * <p>
	 * The returned object may be the same object as the specification, but with the more derived type to signify successful conversion
	 * from textual to executable form. Redundant re-invocation of parseSpecification is harmless.
	 * <p>
	 * The specification's container, typically a Constraint or Operation is used as the contextElement to determine self within the expression.
	 * 
	 * @throws ParserException if text parsing fails
	 */
	@NonNull ExpressionInOCL parseSpecification(@NonNull LanguageExpression specification) throws ParserException;
	
	/**
	 * Convert the specification of an OCL expression from textual CS form to parsed executable AS form. The textual form typically
	 * results from simple construction from source text or a UML OpaqueExpression.
	 * <p>
	 * The returned object may be the same object as the specification, but with the more derived type to signify successful conversion
	 * from textual to executable form. Redundant re-invocation of parseSpecification is harmless.
	 * <p>
	 * The contextElement, typically a Constraint/Operation/Property or ECLass/EOperation/EStructuralFeature,
	 * to determine the type of self within the expression.
	 * 
	 * @throws ParserException if text parsing fails
	 */
	@NonNull ExpressionInOCL parseSpecification(@NonNull EObject contextElement, @NonNull LanguageExpression specification) throws ParserException;
}
