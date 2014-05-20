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

	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitAnnotationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS object) {
		return delegate.visitAnnotationCS(object);
	}

	public @Nullable R visitAnnotationElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS object) {
		return delegate.visitAnnotationElementCS(object);
	}

	public @Nullable R visitAttributeCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.AttributeCS object) {
		return delegate.visitAttributeCS(object);
	}

	public @Nullable R visitClassCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ClassCS object) {
		return delegate.visitClassCS(object);
	}

	public @Nullable R visitClassifierCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS object) {
		return delegate.visitClassifierCS(object);
	}

	public @Nullable R visitConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS object) {
		return delegate.visitConstraintCS(object);
	}

	public @Nullable R visitDataTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS object) {
		return delegate.visitDataTypeCS(object);
	}

	public @Nullable R visitDetailCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.DetailCS object) {
		return delegate.visitDetailCS(object);
	}

	public @Nullable R visitDocumentationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.DocumentationCS object) {
		return delegate.visitDocumentationCS(object);
	}

	public @Nullable R visitElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ElementCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitElementRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS object) {
		return delegate.visitElementRefCS(object);
	}

	public @Nullable R visitEnumerationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.EnumerationCS object) {
		return delegate.visitEnumerationCS(object);
	}

	public @Nullable R visitEnumerationLiteralCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.EnumerationLiteralCS object) {
		return delegate.visitEnumerationLiteralCS(object);
	}

	public @Nullable R visitImportCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ImportCS object) {
		return delegate.visitImportCS(object);
	}

	public @Nullable R visitLambdaTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS object) {
		return delegate.visitLambdaTypeCS(object);
	}

	public @Nullable R visitLibraryCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS object) {
		return delegate.visitLibraryCS(object);
	}

	public @Nullable R visitModelElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS object) {
		return delegate.visitModelElementCS(object);
	}

	public @Nullable R visitModelElementRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS object) {
		return delegate.visitModelElementRefCS(object);
	}

	public @Nullable R visitMultiplicityBoundsCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS object) {
		return delegate.visitMultiplicityBoundsCS(object);
	}

	public @Nullable R visitMultiplicityStringCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS object) {
		return delegate.visitMultiplicityStringCS(object);
	}

	public @Nullable R visitNamedElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public @Nullable R visitOperationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.OperationCS object) {
		return delegate.visitOperationCS(object);
	}

	public @Nullable R visitPackageCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PackageCS object) {
		return delegate.visitPackageCS(object);
	}

	public @Nullable R visitPackageOwnerCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS object) {
		return delegate.visitPackageOwnerCS(object);
	}

	public @Nullable R visitParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS object) {
		return delegate.visitParameterCS(object);
	}

	public @Nullable R visitPathElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS object) {
		return delegate.visitPathElementCS(object);
	}

	public @Nullable R visitPathElementWithURICS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PathElementWithURICS object) {
		return delegate.visitPathElementWithURICS(object);
	}

	public @Nullable R visitPathNameCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS object) {
		return delegate.visitPathNameCS(object);
	}

	public @Nullable R visitPivotableElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS object) {
		return delegate.visitPivotableElementCS(object);
	}

	public @Nullable R visitPrimitiveTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS object) {
		return delegate.visitPrimitiveTypeRefCS(object);
	}

	public @Nullable R visitReferenceCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS object) {
		return delegate.visitReferenceCS(object);
	}

	public @Nullable R visitRootPackageCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS object) {
		return delegate.visitRootPackageCS(object);
	}

	public @Nullable R visitSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS object) {
		return delegate.visitSpecificationCS(object);
	}

	public @Nullable R visitStructuralFeatureCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS object) {
		return delegate.visitStructuralFeatureCS(object);
	}

	public @Nullable R visitTemplateBindingCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS object) {
		return delegate.visitTemplateBindingCS(object);
	}

	public @Nullable R visitTemplateParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS object) {
		return delegate.visitTemplateParameterCS(object);
	}

	public @Nullable R visitTemplateParameterSubstitutionCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS object) {
		return delegate.visitTemplateParameterSubstitutionCS(object);
	}

	public @Nullable R visitTemplateSignatureCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS object) {
		return delegate.visitTemplateSignatureCS(object);
	}

	public @Nullable R visitTuplePartCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS object) {
		return delegate.visitTuplePartCS(object);
	}

	public @Nullable R visitTupleTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS object) {
		return delegate.visitTupleTypeCS(object);
	}

	public @Nullable R visitTypeParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypeParameterCS object) {
		return delegate.visitTypeParameterCS(object);
	}

	public @Nullable R visitTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS object) {
		return delegate.visitTypeRefCS(object);
	}

	public @Nullable R visitTypedElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public @Nullable R visitTypedRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS object) {
		return delegate.visitTypedRefCS(object);
	}

	public @Nullable R visitTypedTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS object) {
		return delegate.visitTypedTypeRefCS(object);
	}

	public @Nullable R visitWildcardTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS object) {
		return delegate.visitWildcardTypeRefCS(object);
	}
}
