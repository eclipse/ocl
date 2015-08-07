/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.xtext.base/model/BaseCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.basecs.util;

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

	@Override
	public @Nullable R visitAnnotationCS(@NonNull org.eclipse.ocl.xtext.basecs.AnnotationCS object) {
		return visitAnnotationElementCS(object);
	}

	@Override
	public @Nullable R visitAnnotationElementCS(@NonNull org.eclipse.ocl.xtext.basecs.AnnotationElementCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitAttributeCS(@NonNull org.eclipse.ocl.xtext.basecs.AttributeCS object) {
		return visitStructuralFeatureCS(object);
	}

	@Override
	public @Nullable R visitClassCS(@NonNull org.eclipse.ocl.xtext.basecs.ClassCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitConstraintCS(@NonNull org.eclipse.ocl.xtext.basecs.ConstraintCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitContextLessElementCS(@NonNull org.eclipse.ocl.xtext.basecs.ContextLessElementCS object) {
		return visitElementCS(object);
	}

	@Override
	public @Nullable R visitDataTypeCS(@NonNull org.eclipse.ocl.xtext.basecs.DataTypeCS object) {
		return visitClassCS(object);
	}

	@Override
	public @Nullable R visitDetailCS(@NonNull org.eclipse.ocl.xtext.basecs.DetailCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitDocumentationCS(@NonNull org.eclipse.ocl.xtext.basecs.DocumentationCS object) {
		return visitAnnotationElementCS(object);
	}

	@Override
	public @Nullable R visitElementCS(@NonNull org.eclipse.ocl.xtext.basecs.ElementCS object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitElementRefCS(@NonNull org.eclipse.ocl.xtext.basecs.ElementRefCS object) {
		return visitPivotableElementCS(object);
	}

	@Override
	public @Nullable R visitEnumerationCS(@NonNull org.eclipse.ocl.xtext.basecs.EnumerationCS object) {
		return visitClassCS(object);
	}

	@Override
	public @Nullable R visitEnumerationLiteralCS(@NonNull org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitFeatureCS(@NonNull org.eclipse.ocl.xtext.basecs.FeatureCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public @Nullable R visitImportCS(@NonNull org.eclipse.ocl.xtext.basecs.ImportCS object) {
		return visitNamespaceCS(object);
	}

	@Override
	public @Nullable R visitLambdaTypeCS(@NonNull org.eclipse.ocl.xtext.basecs.LambdaTypeCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public @Nullable R visitModelElementCS(@NonNull org.eclipse.ocl.xtext.basecs.ModelElementCS object) {
		return visitPivotableElementCS(object);
	}

	@Override
	public @Nullable R visitModelElementRefCS(@NonNull org.eclipse.ocl.xtext.basecs.ModelElementRefCS object) {
		return visitElementRefCS(object);
	}

	@Override
	public @Nullable R visitMultiplicityBoundsCS(@NonNull org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS object) {
		return visitMultiplicityCS(object);
	}

	@Override
	public @Nullable R visitMultiplicityCS(@NonNull org.eclipse.ocl.xtext.basecs.MultiplicityCS object) {
		return visitElementCS(object);
	}

	@Override
	public @Nullable R visitMultiplicityStringCS(@NonNull org.eclipse.ocl.xtext.basecs.MultiplicityStringCS object) {
		return visitMultiplicityCS(object);
	}

	@Override
	public @Nullable R visitNamedElementCS(@NonNull org.eclipse.ocl.xtext.basecs.NamedElementCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitNamespaceCS(@NonNull org.eclipse.ocl.xtext.basecs.NamespaceCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitOperationCS(@NonNull org.eclipse.ocl.xtext.basecs.OperationCS object) {
		return visitFeatureCS(object);
	}

	@Override
	public @Nullable R visitPackageCS(@NonNull org.eclipse.ocl.xtext.basecs.PackageCS object) {
		return visitPackageOwnerCS(object);
	}

	@Override
	public @Nullable R visitPackageOwnerCS(@NonNull org.eclipse.ocl.xtext.basecs.PackageOwnerCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitParameterCS(@NonNull org.eclipse.ocl.xtext.basecs.ParameterCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public @Nullable R visitPathElementCS(@NonNull org.eclipse.ocl.xtext.basecs.PathElementCS object) {
		return visitElementCS(object);
	}

	@Override
	public @Nullable R visitPathElementWithURICS(@NonNull org.eclipse.ocl.xtext.basecs.PathElementWithURICS object) {
		return visitPathElementCS(object);
	}

	@Override
	public @Nullable R visitPathNameCS(@NonNull org.eclipse.ocl.xtext.basecs.PathNameCS object) {
		return visitElementCS(object);
	}

	@Override
	public @Nullable R visitPathTypeCS(@NonNull org.eclipse.ocl.xtext.basecs.PathTypeCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public @Nullable R visitPivotableElementCS(@NonNull org.eclipse.ocl.xtext.basecs.PivotableElementCS object) {
		return visitElementCS(object);
	}

	@Override
	public @Nullable R visitPrimitiveTypeRefCS(@NonNull org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public @Nullable R visitReferenceCS(@NonNull org.eclipse.ocl.xtext.basecs.ReferenceCS object) {
		return visitStructuralFeatureCS(object);
	}

	@Override
	public @Nullable R visitRootCS(@NonNull org.eclipse.ocl.xtext.basecs.RootCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitRootPackageCS(@NonNull org.eclipse.ocl.xtext.basecs.RootPackageCS object) {
		return visitPackageOwnerCS(object);
	}

	@Override
	public @Nullable R visitSpecificationCS(@NonNull org.eclipse.ocl.xtext.basecs.SpecificationCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitStructuralFeatureCS(@NonNull org.eclipse.ocl.xtext.basecs.StructuralFeatureCS object) {
		return visitFeatureCS(object);
	}

	@Override
	public @Nullable R visitStructuredClassCS(@NonNull org.eclipse.ocl.xtext.basecs.StructuredClassCS object) {
		return visitClassCS(object);
	}

	@Override
	public @Nullable R visitTemplateBindingCS(@NonNull org.eclipse.ocl.xtext.basecs.TemplateBindingCS object) {
		return visitElementRefCS(object);
	}

	@Override
	public @Nullable R visitTemplateParameterCS(@NonNull org.eclipse.ocl.xtext.basecs.TemplateParameterCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitTemplateParameterSubstitutionCS(@NonNull org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitTemplateSignatureCS(@NonNull org.eclipse.ocl.xtext.basecs.TemplateSignatureCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitTemplateableElementCS(@NonNull org.eclipse.ocl.xtext.basecs.TemplateableElementCS object) {
		return visitElementCS(object);
	}

	@Override
	public @Nullable R visitTuplePartCS(@NonNull org.eclipse.ocl.xtext.basecs.TuplePartCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public @Nullable R visitTupleTypeCS(@NonNull org.eclipse.ocl.xtext.basecs.TupleTypeCS object) {
		return visitTypedRefCS(object);
	}

	@Override
	public @Nullable R visitTypeCS(@NonNull org.eclipse.ocl.xtext.basecs.TypeCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitTypeParameterCS(@NonNull org.eclipse.ocl.xtext.basecs.TypeParameterCS object) {
		return visitTemplateParameterCS(object);
	}

	@Override
	public @Nullable R visitTypeRefCS(@NonNull org.eclipse.ocl.xtext.basecs.TypeRefCS object) {
		return visitElementRefCS(object);
	}

	@Override
	public @Nullable R visitTypedElementCS(@NonNull org.eclipse.ocl.xtext.basecs.TypedElementCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitTypedRefCS(@NonNull org.eclipse.ocl.xtext.basecs.TypedRefCS object) {
		return visitTypeRefCS(object);
	}

	@Override
	public @Nullable R visitWildcardTypeRefCS(@NonNull org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS object) {
		return visitTypeRefCS(object);
	}
}
