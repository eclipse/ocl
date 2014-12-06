/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.xtext.base/model/BaseCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.xtext.base.basecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface BaseCSVisitor<R>
{
	/**
	 * Returns an object which is an instance of the given class
	 * associated with this object. Returns <code>null</code> if
	 * no such object can be found.
	 *
	 * @param adapter the adapter class to look up
	 * @return an object of the given class, 
	 *    or <code>null</code> if this object does not
	 *    have an adapter for the given class
	 */
	@Nullable <A> A getAdapter(@NonNull Class<A> adapter);

	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	@Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS visitable);

	@Nullable R visitAnnotationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS object);
	@Nullable R visitAnnotationElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS object);
	@Nullable R visitAttributeCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.AttributeCS object);
	@Nullable R visitClassCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ClassCS object);
	@Nullable R visitConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS object);
	@Nullable R visitContextLessElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ContextLessElementCS object);
	@Nullable R visitDataTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS object);
	@Nullable R visitDetailCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.DetailCS object);
	@Nullable R visitDocumentationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.DocumentationCS object);
	@Nullable R visitElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ElementCS object);
	@Nullable R visitElementRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS object);
	@Nullable R visitEnumerationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.EnumerationCS object);
	@Nullable R visitEnumerationLiteralCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.EnumerationLiteralCS object);
	@Nullable R visitImportCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ImportCS object);
	@Nullable R visitLambdaTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS object);
	@Nullable R visitLibraryCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS object);
	@Nullable R visitModelElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS object);
	@Nullable R visitModelElementRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS object);
	@Nullable R visitMultiplicityBoundsCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS object);
	@Nullable R visitMultiplicityCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityCS object);
	@Nullable R visitMultiplicityStringCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS object);
	@Nullable R visitNamedElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS object);
	@Nullable R visitOperationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.OperationCS object);
	@Nullable R visitPackageCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PackageCS object);
	@Nullable R visitPackageOwnerCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS object);
	@Nullable R visitParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS object);
	@Nullable R visitPathElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS object);
	@Nullable R visitPathElementWithURICS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PathElementWithURICS object);
	@Nullable R visitPathNameCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS object);
	@Nullable R visitPivotableElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS object);
	@Nullable R visitPrimitiveTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS object);
	@Nullable R visitReferenceCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS object);
	@Nullable R visitRootCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.RootCS object);
	@Nullable R visitRootPackageCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS object);
	@Nullable R visitSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS object);
	@Nullable R visitStructuralFeatureCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS object);
	@Nullable R visitStructuredClassCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.StructuredClassCS object);
	@Nullable R visitTemplateBindingCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS object);
	@Nullable R visitTemplateParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS object);
	@Nullable R visitTemplateParameterSubstitutionCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS object);
	@Nullable R visitTemplateSignatureCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS object);
	@Nullable R visitTemplateableElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS object);
	@Nullable R visitTuplePartCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS object);
	@Nullable R visitTupleTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS object);
	@Nullable R visitTypeParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypeParameterCS object);
	@Nullable R visitTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS object);
	@Nullable R visitTypedElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS object);
	@Nullable R visitTypedRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS object);
	@Nullable R visitTypedTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS object);
	@Nullable R visitWildcardTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS object);
}
