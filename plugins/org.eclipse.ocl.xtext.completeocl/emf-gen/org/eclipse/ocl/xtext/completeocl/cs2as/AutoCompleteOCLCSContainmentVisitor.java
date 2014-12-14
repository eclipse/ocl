/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.ocl.xtext.completeocl.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.types.IdResolver;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.DefCS;
import org.eclipse.ocl.xtext.completeoclcs.DefOperationCS;
import org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS;
import org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.IncludeCS;
import org.eclipse.ocl.xtext.completeoclcs.OCLMessageArgCS;
import org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.util.CompleteOCLCSVisitor;
import org.eclipse.ocl.xtext.essentialocl.cs2as.NewEssentialOCLCSContainmentVisitor;

public class AutoCompleteOCLCSContainmentVisitor
	extends NewEssentialOCLCSContainmentVisitor
	implements CompleteOCLCSVisitor<Continuation<?>>
{
    protected final @NonNull CS2AS converter;
    protected final @NonNull IdResolver idResolver;
    
    /**
     * Initializes me with an initial value for my result.
     * 
     * @param context my initial result value
     */
    public AutoCompleteOCLCSContainmentVisitor(@NonNull CS2ASConversion context) {
        super(context);
        this.converter = context.getConverter();
        this.idResolver = converter.getMetaModelManager().getIdResolver();
    }
    
    @Override
    public @Nullable Continuation<?> visitClassifierContextDeclCS(@NonNull ClassifierContextDeclCS self) {
        throw new UnsupportedOperationException("visitClassifierContextDeclCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitCompleteOCLDocumentCS(@NonNull CompleteOCLDocumentCS self) {
        throw new UnsupportedOperationException("visitCompleteOCLDocumentCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitContextDeclCS(@NonNull ContextDeclCS self) {
        throw new UnsupportedOperationException("visitContextDeclCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitDefCS(@NonNull DefCS self) {
        throw new UnsupportedOperationException("visitDefCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitDefOperationCS(@NonNull DefOperationCS self) {
        throw new UnsupportedOperationException("visitDefOperationCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitDefPropertyCS(@NonNull DefPropertyCS self) {
        throw new UnsupportedOperationException("visitDefPropertyCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitFeatureContextDeclCS(@NonNull FeatureContextDeclCS self) {
        throw new UnsupportedOperationException("visitFeatureContextDeclCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitIncludeCS(@NonNull IncludeCS self) {
        throw new UnsupportedOperationException("visitIncludeCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitOCLMessageArgCS(@NonNull OCLMessageArgCS self) {
        throw new UnsupportedOperationException("visitOCLMessageArgCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitOperationContextDeclCS(@NonNull OperationContextDeclCS self) {
        throw new UnsupportedOperationException("visitOperationContextDeclCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPackageDeclarationCS(@NonNull PackageDeclarationCS self) {
        throw new UnsupportedOperationException("visitPackageDeclarationCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPathNameDeclCS(@NonNull PathNameDeclCS self) {
        throw new UnsupportedOperationException("visitPathNameDeclCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPropertyContextDeclCS(@NonNull PropertyContextDeclCS self) {
        throw new UnsupportedOperationException("visitPropertyContextDeclCS is not supported by " + getClass().getName());
    }
}
