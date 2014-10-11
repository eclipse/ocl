/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.ocl.examples.xtext.oclstdlib.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.NewEssentialOCLCSContainmentVisitor;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaImplementationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibConstraintCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibRootPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaclassNameCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.util.OCLstdlibCSVisitor;

public class AutoOCLstdlibCSContainmentVisitor
	extends NewEssentialOCLCSContainmentVisitor
	implements OCLstdlibCSVisitor<Continuation<?>>
{
    protected final @NonNull CS2Pivot converter;
    protected final @NonNull IdResolver idResolver;
    
    /**
     * Initializes me with an initial value for my result.
     * 
     * @param context my initial result value
     */
    public AutoOCLstdlibCSContainmentVisitor(@NonNull CS2PivotConversion context) {
        super(context);
        this.converter = context.getConverter();
        this.idResolver = converter.getMetaModelManager().getIdResolver();
    }
    
    public @Nullable Continuation<?> visitJavaClassCS(@NonNull JavaClassCS self) {
        throw new UnsupportedOperationException("visitJavaClassCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitJavaImplementationCS(@NonNull JavaImplementationCS self) {
        throw new UnsupportedOperationException("visitJavaImplementationCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitLibClassCS(@NonNull LibClassCS self) {
        throw new UnsupportedOperationException("visitLibClassCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitLibConstraintCS(@NonNull LibConstraintCS self) {
        throw new UnsupportedOperationException("visitLibConstraintCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitLibIterationCS(@NonNull LibIterationCS self) {
        throw new UnsupportedOperationException("visitLibIterationCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitLibOperationCS(@NonNull LibOperationCS self) {
        throw new UnsupportedOperationException("visitLibOperationCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitLibPackageCS(@NonNull LibPackageCS self) {
        throw new UnsupportedOperationException("visitLibPackageCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitLibPropertyCS(@NonNull LibPropertyCS self) {
        throw new UnsupportedOperationException("visitLibPropertyCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitLibRootPackageCS(@NonNull LibRootPackageCS self) {
        throw new UnsupportedOperationException("visitLibRootPackageCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitMetaclassNameCS(@NonNull MetaclassNameCS self) {
        throw new UnsupportedOperationException("visitMetaclassNameCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitPrecedenceCS(@NonNull PrecedenceCS self) {
        throw new UnsupportedOperationException("visitPrecedenceCS is not supported by " + getClass().getName());
    }
}
