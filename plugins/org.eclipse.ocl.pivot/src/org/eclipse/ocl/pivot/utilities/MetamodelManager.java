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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.resource.ProjectManager;

public interface MetamodelManager
{
	@Nullable org.eclipse.ocl.pivot.Class getASClass(@NonNull String className);

	@Nullable <T extends Element> T getASOf(@NonNull Class<T> pivotClass, @Nullable EObject eObject) throws ParserException;

	@Nullable <T extends Element> T getASOfEcore(@NonNull Class<T> pivotClass, @Nullable EObject eObject);

	@NonNull ResourceSet getASResourceSet();
	
	@NonNull CompleteModel getCompleteModel();

	@Nullable <T extends EObject> T getEcoreOfPivot(@NonNull Class<T> ecoreClass, @NonNull Element element);

	@NonNull EnvironmentFactory getEnvironmentFactory();

	@Deprecated // Use getEnvironmentFactory().getResourceSet()
	@NonNull ResourceSet getExternalResourceSet();

	@NonNull org.eclipse.ocl.pivot.Class getPrimaryClass(@NonNull org.eclipse.ocl.pivot.Class pivotClass);
	
	@NonNull Operation getPrimaryOperation(@NonNull Operation pivotOperation);

	@NonNull org.eclipse.ocl.pivot.Package getPrimaryPackage(@NonNull org.eclipse.ocl.pivot.Package eObject);

	@NonNull Property getPrimaryProperty(@NonNull Property pivotProperty);
	
	@Deprecated // Use getEnvironmentFactory().getProjectManager()
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
	@Deprecated // contextElement is partially ignored in favor of specifucation ancestry
	@NonNull ExpressionInOCL parseSpecification(@NonNull EObject contextElement, @NonNull LanguageExpression specification) throws ParserException;
}
