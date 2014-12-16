/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.ocl.xtext.base.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.basecs.AnnotationCS;
import org.eclipse.ocl.xtext.basecs.AnnotationElementCS;
import org.eclipse.ocl.xtext.basecs.AttributeCS;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ContextLessElementCS;
import org.eclipse.ocl.xtext.basecs.DataTypeCS;
import org.eclipse.ocl.xtext.basecs.DetailCS;
import org.eclipse.ocl.xtext.basecs.DocumentationCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ElementRefCS;
import org.eclipse.ocl.xtext.basecs.EnumerationCS;
import org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS;
import org.eclipse.ocl.xtext.basecs.FeatureCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.LambdaTypeCS;
import org.eclipse.ocl.xtext.basecs.LibraryCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.ModelElementRefCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.NamespaceCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.PackageOwnerCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.basecs.ReferenceCS;
import org.eclipse.ocl.xtext.basecs.RootCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.ocl.xtext.basecs.SpecificationCS;
import org.eclipse.ocl.xtext.basecs.StructuralFeatureCS;
import org.eclipse.ocl.xtext.basecs.StructuredClassCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TemplateableElementCS;
import org.eclipse.ocl.xtext.basecs.TuplePartCS;
import org.eclipse.ocl.xtext.basecs.TupleTypeCS;
import org.eclipse.ocl.xtext.basecs.TypeCS;
import org.eclipse.ocl.xtext.basecs.TypeParameterCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.xtext.basecs.util.AbstractBaseCSVisitor;
import org.eclipse.ocl.xtext.basecs.util.VisitableCS;

public class AutoBaseCSContainmentVisitor
	extends AbstractBaseCSVisitor<Continuation<?>, CS2ASConversion>
{
    protected final @NonNull CS2AS converter;
    protected final @NonNull IdResolver idResolver;
    
    /**
     * Initializes me with an initial value for my result.
     * 
     * @param context my initial result value
     */
    public AutoBaseCSContainmentVisitor(@NonNull CS2ASConversion context) {
        super(context);
        this.converter = context.getConverter();
        this.idResolver = converter.getMetaModelManager().getIdResolver();
    }
    
    @Override
    public @Nullable Continuation<?> visiting(@NonNull VisitableCS visitable) {
        throw new UnsupportedOperationException("AutoBaseCSContainmentVisitor is not supported by \"" + getClass().getName() + "\"");
    }
    
    @Override
    public @Nullable Continuation<?> visitAnnotationCS(@NonNull AnnotationCS self) {
        throw new UnsupportedOperationException("visitAnnotationCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitAnnotationElementCS(@NonNull AnnotationElementCS self) {
        throw new UnsupportedOperationException("visitAnnotationElementCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitAttributeCS(@NonNull AttributeCS self) {
        throw new UnsupportedOperationException("visitAttributeCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitClassCS(@NonNull ClassCS self) {
        throw new UnsupportedOperationException("visitClassCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitConstraintCS(@NonNull ConstraintCS self) {
        throw new UnsupportedOperationException("visitConstraintCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitContextLessElementCS(@NonNull ContextLessElementCS self) {
        throw new UnsupportedOperationException("visitContextLessElementCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitDataTypeCS(@NonNull DataTypeCS self) {
        throw new UnsupportedOperationException("visitDataTypeCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitDetailCS(@NonNull DetailCS self) {
        throw new UnsupportedOperationException("visitDetailCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitDocumentationCS(@NonNull DocumentationCS self) {
        throw new UnsupportedOperationException("visitDocumentationCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitElementCS(@NonNull ElementCS self) {
        throw new UnsupportedOperationException("visitElementCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitElementRefCS(@NonNull ElementRefCS self) {
        throw new UnsupportedOperationException("visitElementRefCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitEnumerationCS(@NonNull EnumerationCS self) {
        throw new UnsupportedOperationException("visitEnumerationCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitEnumerationLiteralCS(@NonNull EnumerationLiteralCS self) {
        throw new UnsupportedOperationException("visitEnumerationLiteralCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitFeatureCS(@NonNull FeatureCS self) {
        throw new UnsupportedOperationException("visitFeatureCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitImportCS(@NonNull ImportCS self) {
        throw new UnsupportedOperationException("visitImportCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitLambdaTypeCS(@NonNull LambdaTypeCS self) {
        throw new UnsupportedOperationException("visitLambdaTypeCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitLibraryCS(@NonNull LibraryCS self) {
        throw new UnsupportedOperationException("visitLibraryCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitModelElementCS(@NonNull ModelElementCS self) {
        throw new UnsupportedOperationException("visitModelElementCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitModelElementRefCS(@NonNull ModelElementRefCS self) {
        throw new UnsupportedOperationException("visitModelElementRefCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitMultiplicityBoundsCS(@NonNull MultiplicityBoundsCS self) {
        throw new UnsupportedOperationException("visitMultiplicityBoundsCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitMultiplicityCS(@NonNull MultiplicityCS self) {
        throw new UnsupportedOperationException("visitMultiplicityCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitMultiplicityStringCS(@NonNull MultiplicityStringCS self) {
        throw new UnsupportedOperationException("visitMultiplicityStringCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitNamedElementCS(@NonNull NamedElementCS self) {
        throw new UnsupportedOperationException("visitNamedElementCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitNamespaceCS(@NonNull NamespaceCS self) {
        throw new UnsupportedOperationException("visitNamespaceCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitOperationCS(@NonNull OperationCS self) {
        throw new UnsupportedOperationException("visitOperationCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPackageCS(@NonNull PackageCS self) {
        throw new UnsupportedOperationException("visitPackageCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPackageOwnerCS(@NonNull PackageOwnerCS self) {
        throw new UnsupportedOperationException("visitPackageOwnerCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitParameterCS(@NonNull ParameterCS self) {
        throw new UnsupportedOperationException("visitParameterCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPathElementCS(@NonNull PathElementCS self) {
        throw new UnsupportedOperationException("visitPathElementCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPathElementWithURICS(@NonNull PathElementWithURICS self) {
        throw new UnsupportedOperationException("visitPathElementWithURICS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPathNameCS(@NonNull PathNameCS self) {
        throw new UnsupportedOperationException("visitPathNameCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPivotableElementCS(@NonNull PivotableElementCS self) {
        throw new UnsupportedOperationException("visitPivotableElementCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPrimitiveTypeRefCS(@NonNull PrimitiveTypeRefCS self) {
        throw new UnsupportedOperationException("visitPrimitiveTypeRefCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitReferenceCS(@NonNull ReferenceCS self) {
        throw new UnsupportedOperationException("visitReferenceCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitRootCS(@NonNull RootCS self) {
        throw new UnsupportedOperationException("visitRootCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitRootPackageCS(@NonNull RootPackageCS self) {
        throw new UnsupportedOperationException("visitRootPackageCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitSpecificationCS(@NonNull SpecificationCS self) {
        throw new UnsupportedOperationException("visitSpecificationCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitStructuralFeatureCS(@NonNull StructuralFeatureCS self) {
        throw new UnsupportedOperationException("visitStructuralFeatureCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitStructuredClassCS(@NonNull StructuredClassCS self) {
        throw new UnsupportedOperationException("visitStructuredClassCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTemplateBindingCS(@NonNull TemplateBindingCS self) {
        throw new UnsupportedOperationException("visitTemplateBindingCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTemplateParameterCS(@NonNull TemplateParameterCS self) {
        throw new UnsupportedOperationException("visitTemplateParameterCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTemplateParameterSubstitutionCS(@NonNull TemplateParameterSubstitutionCS self) {
        throw new UnsupportedOperationException("visitTemplateParameterSubstitutionCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTemplateSignatureCS(@NonNull TemplateSignatureCS self) {
        throw new UnsupportedOperationException("visitTemplateSignatureCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTemplateableElementCS(@NonNull TemplateableElementCS self) {
        throw new UnsupportedOperationException("visitTemplateableElementCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTuplePartCS(@NonNull TuplePartCS self) {
        throw new UnsupportedOperationException("visitTuplePartCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTupleTypeCS(@NonNull TupleTypeCS self) {
        throw new UnsupportedOperationException("visitTupleTypeCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTypeCS(@NonNull TypeCS self) {
        throw new UnsupportedOperationException("visitTypeCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTypeParameterCS(@NonNull TypeParameterCS self) {
        throw new UnsupportedOperationException("visitTypeParameterCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTypeRefCS(@NonNull TypeRefCS self) {
        throw new UnsupportedOperationException("visitTypeRefCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTypedElementCS(@NonNull TypedElementCS self) {
        throw new UnsupportedOperationException("visitTypedElementCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTypedRefCS(@NonNull TypedRefCS self) {
        throw new UnsupportedOperationException("visitTypedRefCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTypedTypeRefCS(@NonNull TypedTypeRefCS self) {
        throw new UnsupportedOperationException("visitTypedTypeRefCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitWildcardTypeRefCS(@NonNull WildcardTypeRefCS self) {
        throw new UnsupportedOperationException("visitWildcardTypeRefCS is not supported by " + getClass().getName());
    }
}
