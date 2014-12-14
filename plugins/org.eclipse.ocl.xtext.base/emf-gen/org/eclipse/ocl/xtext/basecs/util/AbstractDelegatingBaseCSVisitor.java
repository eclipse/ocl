/*******************************************************************************
 * Copyright (c) 2010,2015 E.D.Willink and others.
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
 * An AbstractDelegatingBaseCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingBaseCSVisitor<R, C, D extends BaseCSVisitor<R>>
	extends AbstractBaseCSVisitor<R, C>
	implements BaseCSVisitor<R>
{
	protected final D delegate;
	
	protected AbstractDelegatingBaseCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(context);
	//	assert delegate != null : "cannot decorate a null visitor"; //$NON-NLS-1$
		this.delegate = delegate;		
	//	delegate.setUndecoratedVisitor(this);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	//	public @NonNull DecorableBaseCSVisitor<R> createNestedVisitor() {
	//		return delegate.createNestedVisitor();
	//	}

	/**
	 * Obtains the visitor that I decorate.
	 * 
	 * @return my decorated visitor
	 */
	@SuppressWarnings("null")
	protected final @NonNull D getDelegate() {
		return delegate;
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.xtext.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public @Nullable R visitAnnotationCS(@NonNull org.eclipse.ocl.xtext.basecs.AnnotationCS object) {
		return delegate.visitAnnotationCS(object);
	}

	@Override
	public @Nullable R visitAnnotationElementCS(@NonNull org.eclipse.ocl.xtext.basecs.AnnotationElementCS object) {
		return delegate.visitAnnotationElementCS(object);
	}

	@Override
	public @Nullable R visitAttributeCS(@NonNull org.eclipse.ocl.xtext.basecs.AttributeCS object) {
		return delegate.visitAttributeCS(object);
	}

	@Override
	public @Nullable R visitClassCS(@NonNull org.eclipse.ocl.xtext.basecs.ClassCS object) {
		return delegate.visitClassCS(object);
	}

	@Override
	public @Nullable R visitConstraintCS(@NonNull org.eclipse.ocl.xtext.basecs.ConstraintCS object) {
		return delegate.visitConstraintCS(object);
	}

	@Override
	public @Nullable R visitContextLessElementCS(@NonNull org.eclipse.ocl.xtext.basecs.ContextLessElementCS object) {
		return delegate.visitContextLessElementCS(object);
	}

	@Override
	public @Nullable R visitDataTypeCS(@NonNull org.eclipse.ocl.xtext.basecs.DataTypeCS object) {
		return delegate.visitDataTypeCS(object);
	}

	@Override
	public @Nullable R visitDetailCS(@NonNull org.eclipse.ocl.xtext.basecs.DetailCS object) {
		return delegate.visitDetailCS(object);
	}

	@Override
	public @Nullable R visitDocumentationCS(@NonNull org.eclipse.ocl.xtext.basecs.DocumentationCS object) {
		return delegate.visitDocumentationCS(object);
	}

	@Override
	public @Nullable R visitElementCS(@NonNull org.eclipse.ocl.xtext.basecs.ElementCS object) {
		return delegate.visitElementCS(object);
	}

	@Override
	public @Nullable R visitElementRefCS(@NonNull org.eclipse.ocl.xtext.basecs.ElementRefCS object) {
		return delegate.visitElementRefCS(object);
	}

	@Override
	public @Nullable R visitEnumerationCS(@NonNull org.eclipse.ocl.xtext.basecs.EnumerationCS object) {
		return delegate.visitEnumerationCS(object);
	}

	@Override
	public @Nullable R visitEnumerationLiteralCS(@NonNull org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS object) {
		return delegate.visitEnumerationLiteralCS(object);
	}

	@Override
	public @Nullable R visitFeatureCS(@NonNull org.eclipse.ocl.xtext.basecs.FeatureCS object) {
		return delegate.visitFeatureCS(object);
	}

	@Override
	public @Nullable R visitImportCS(@NonNull org.eclipse.ocl.xtext.basecs.ImportCS object) {
		return delegate.visitImportCS(object);
	}

	@Override
	public @Nullable R visitLambdaTypeCS(@NonNull org.eclipse.ocl.xtext.basecs.LambdaTypeCS object) {
		return delegate.visitLambdaTypeCS(object);
	}

	@Override
	public @Nullable R visitLibraryCS(@NonNull org.eclipse.ocl.xtext.basecs.LibraryCS object) {
		return delegate.visitLibraryCS(object);
	}

	@Override
	public @Nullable R visitModelElementCS(@NonNull org.eclipse.ocl.xtext.basecs.ModelElementCS object) {
		return delegate.visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitModelElementRefCS(@NonNull org.eclipse.ocl.xtext.basecs.ModelElementRefCS object) {
		return delegate.visitModelElementRefCS(object);
	}

	@Override
	public @Nullable R visitMultiplicityBoundsCS(@NonNull org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS object) {
		return delegate.visitMultiplicityBoundsCS(object);
	}

	@Override
	public @Nullable R visitMultiplicityCS(@NonNull org.eclipse.ocl.xtext.basecs.MultiplicityCS object) {
		return delegate.visitMultiplicityCS(object);
	}

	@Override
	public @Nullable R visitMultiplicityStringCS(@NonNull org.eclipse.ocl.xtext.basecs.MultiplicityStringCS object) {
		return delegate.visitMultiplicityStringCS(object);
	}

	@Override
	public @Nullable R visitNamedElementCS(@NonNull org.eclipse.ocl.xtext.basecs.NamedElementCS object) {
		return delegate.visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitNamespaceCS(@NonNull org.eclipse.ocl.xtext.basecs.NamespaceCS object) {
		return delegate.visitNamespaceCS(object);
	}

	@Override
	public @Nullable R visitOperationCS(@NonNull org.eclipse.ocl.xtext.basecs.OperationCS object) {
		return delegate.visitOperationCS(object);
	}

	@Override
	public @Nullable R visitPackageCS(@NonNull org.eclipse.ocl.xtext.basecs.PackageCS object) {
		return delegate.visitPackageCS(object);
	}

	@Override
	public @Nullable R visitPackageOwnerCS(@NonNull org.eclipse.ocl.xtext.basecs.PackageOwnerCS object) {
		return delegate.visitPackageOwnerCS(object);
	}

	@Override
	public @Nullable R visitParameterCS(@NonNull org.eclipse.ocl.xtext.basecs.ParameterCS object) {
		return delegate.visitParameterCS(object);
	}

	@Override
	public @Nullable R visitPathElementCS(@NonNull org.eclipse.ocl.xtext.basecs.PathElementCS object) {
		return delegate.visitPathElementCS(object);
	}

	@Override
	public @Nullable R visitPathElementWithURICS(@NonNull org.eclipse.ocl.xtext.basecs.PathElementWithURICS object) {
		return delegate.visitPathElementWithURICS(object);
	}

	@Override
	public @Nullable R visitPathNameCS(@NonNull org.eclipse.ocl.xtext.basecs.PathNameCS object) {
		return delegate.visitPathNameCS(object);
	}

	@Override
	public @Nullable R visitPivotableElementCS(@NonNull org.eclipse.ocl.xtext.basecs.PivotableElementCS object) {
		return delegate.visitPivotableElementCS(object);
	}

	@Override
	public @Nullable R visitPrimitiveTypeRefCS(@NonNull org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS object) {
		return delegate.visitPrimitiveTypeRefCS(object);
	}

	@Override
	public @Nullable R visitReferenceCS(@NonNull org.eclipse.ocl.xtext.basecs.ReferenceCS object) {
		return delegate.visitReferenceCS(object);
	}

	@Override
	public @Nullable R visitRootCS(@NonNull org.eclipse.ocl.xtext.basecs.RootCS object) {
		return delegate.visitRootCS(object);
	}

	@Override
	public @Nullable R visitRootPackageCS(@NonNull org.eclipse.ocl.xtext.basecs.RootPackageCS object) {
		return delegate.visitRootPackageCS(object);
	}

	@Override
	public @Nullable R visitSpecificationCS(@NonNull org.eclipse.ocl.xtext.basecs.SpecificationCS object) {
		return delegate.visitSpecificationCS(object);
	}

	@Override
	public @Nullable R visitStructuralFeatureCS(@NonNull org.eclipse.ocl.xtext.basecs.StructuralFeatureCS object) {
		return delegate.visitStructuralFeatureCS(object);
	}

	@Override
	public @Nullable R visitStructuredClassCS(@NonNull org.eclipse.ocl.xtext.basecs.StructuredClassCS object) {
		return delegate.visitStructuredClassCS(object);
	}

	@Override
	public @Nullable R visitTemplateBindingCS(@NonNull org.eclipse.ocl.xtext.basecs.TemplateBindingCS object) {
		return delegate.visitTemplateBindingCS(object);
	}

	@Override
	public @Nullable R visitTemplateParameterCS(@NonNull org.eclipse.ocl.xtext.basecs.TemplateParameterCS object) {
		return delegate.visitTemplateParameterCS(object);
	}

	@Override
	public @Nullable R visitTemplateParameterSubstitutionCS(@NonNull org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS object) {
		return delegate.visitTemplateParameterSubstitutionCS(object);
	}

	@Override
	public @Nullable R visitTemplateSignatureCS(@NonNull org.eclipse.ocl.xtext.basecs.TemplateSignatureCS object) {
		return delegate.visitTemplateSignatureCS(object);
	}

	@Override
	public @Nullable R visitTemplateableElementCS(@NonNull org.eclipse.ocl.xtext.basecs.TemplateableElementCS object) {
		return delegate.visitTemplateableElementCS(object);
	}

	@Override
	public @Nullable R visitTuplePartCS(@NonNull org.eclipse.ocl.xtext.basecs.TuplePartCS object) {
		return delegate.visitTuplePartCS(object);
	}

	@Override
	public @Nullable R visitTupleTypeCS(@NonNull org.eclipse.ocl.xtext.basecs.TupleTypeCS object) {
		return delegate.visitTupleTypeCS(object);
	}

	@Override
	public @Nullable R visitTypeCS(@NonNull org.eclipse.ocl.xtext.basecs.TypeCS object) {
		return delegate.visitTypeCS(object);
	}

	@Override
	public @Nullable R visitTypeParameterCS(@NonNull org.eclipse.ocl.xtext.basecs.TypeParameterCS object) {
		return delegate.visitTypeParameterCS(object);
	}

	@Override
	public @Nullable R visitTypeRefCS(@NonNull org.eclipse.ocl.xtext.basecs.TypeRefCS object) {
		return delegate.visitTypeRefCS(object);
	}

	@Override
	public @Nullable R visitTypedElementCS(@NonNull org.eclipse.ocl.xtext.basecs.TypedElementCS object) {
		return delegate.visitTypedElementCS(object);
	}

	@Override
	public @Nullable R visitTypedRefCS(@NonNull org.eclipse.ocl.xtext.basecs.TypedRefCS object) {
		return delegate.visitTypedRefCS(object);
	}

	@Override
	public @Nullable R visitTypedTypeRefCS(@NonNull org.eclipse.ocl.xtext.basecs.TypedTypeRefCS object) {
		return delegate.visitTypedTypeRefCS(object);
	}

	@Override
	public @Nullable R visitWildcardTypeRefCS(@NonNull org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS object) {
		return delegate.visitWildcardTypeRefCS(object);
	}
}
