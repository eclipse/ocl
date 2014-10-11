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
 * An AbstractExtendingBaseCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingBaseCSVisitor<R, C>
	extends AbstractBaseCSVisitor<R, C>
	implements BaseCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingBaseCSVisitor(@NonNull C context) {
		super(context);
	}	

	public @Nullable R visitAnnotationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS object) {
		return visitAnnotationElementCS(object);
	}

	public @Nullable R visitAnnotationElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitAttributeCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.AttributeCS object) {
		return visitStructuralFeatureCS(object);
	}

	public @Nullable R visitClassCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ClassCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitContextLessElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ContextLessElementCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitDataTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS object) {
		return visitClassCS(object);
	}

	public @Nullable R visitDetailCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.DetailCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitDocumentationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.DocumentationCS object) {
		return visitAnnotationElementCS(object);
	}

	public @Nullable R visitElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ElementCS object) {
		return visiting(object);
	}

	public @Nullable R visitElementRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS object) {
		return visitPivotableElementCS(object);
	}

	public @Nullable R visitEnumerationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.EnumerationCS object) {
		return visitClassCS(object);
	}

	public @Nullable R visitEnumerationLiteralCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.EnumerationLiteralCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitImportCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ImportCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitLambdaTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitLibraryCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitModelElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS object) {
		return visitPivotableElementCS(object);
	}

	public @Nullable R visitModelElementRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS object) {
		return visitElementRefCS(object);
	}

	public @Nullable R visitMultiplicityBoundsCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitMultiplicityStringCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitNamedElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitOperationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.OperationCS object) {
		return visitTypedElementCS(object);
	}

	public @Nullable R visitPackageCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PackageCS object) {
		return visitPackageOwnerCS(object);
	}

	public @Nullable R visitPackageOwnerCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS object) {
		return visitTypedElementCS(object);
	}

	public @Nullable R visitPathElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitPathElementWithURICS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PathElementWithURICS object) {
		return visitPathElementCS(object);
	}

	public @Nullable R visitPathNameCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitPivotableElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitPrimitiveTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitReferenceCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS object) {
		return visitStructuralFeatureCS(object);
	}

	public @Nullable R visitRootPackageCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS object) {
		return visitPackageOwnerCS(object);
	}

	public @Nullable R visitSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitStructuralFeatureCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS object) {
		return visitTypedElementCS(object);
	}

	public @Nullable R visitStructuredClassCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.StructuredClassCS object) {
		return visitClassCS(object);
	}

	public @Nullable R visitTemplateBindingCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS object) {
		return visitElementRefCS(object);
	}

	public @Nullable R visitTemplateParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitTemplateParameterSubstitutionCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitTemplateSignatureCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitTuplePartCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS object) {
		return visitTypedElementCS(object);
	}

	public @Nullable R visitTupleTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitTypeParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypeParameterCS object) {
		return visitTemplateParameterCS(object);
	}

	public @Nullable R visitTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS object) {
		return visitElementRefCS(object);
	}

	public @Nullable R visitTypedElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitTypedRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS object) {
		return visitTypeRefCS(object);
	}

	public @Nullable R visitTypedTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitWildcardTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS object) {
		return visitTypeRefCS(object);
	}
}
