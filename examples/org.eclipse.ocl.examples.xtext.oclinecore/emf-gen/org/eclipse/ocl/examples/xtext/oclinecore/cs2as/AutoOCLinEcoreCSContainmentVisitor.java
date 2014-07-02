/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.ocl.examples.xtext.oclinecore.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.NewEssentialOCLCSContainmentVisitor;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.SysMLCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.TopLevelCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.util.OCLinEcoreCSVisitor;

public class AutoOCLinEcoreCSContainmentVisitor
	extends NewEssentialOCLCSContainmentVisitor
	implements OCLinEcoreCSVisitor<Continuation<?>>
{
    
    protected final @NonNull CS2Pivot converter;
    protected final @NonNull IdResolver idResolver;
    
    /**
     * Initializes me with an initial value for my result.
     * 
     * @param context my initial result value
     */
    public AutoOCLinEcoreCSContainmentVisitor(@NonNull CS2PivotConversion context) {
        super(context);
        this.converter = context.getConverter();
        this.idResolver = converter.getMetaModelManager().getIdResolver();
    }
    
    public @Nullable Continuation<?> visitOCLinEcoreConstraintCS(@NonNull OCLinEcoreConstraintCS self) {
        throw new UnsupportedOperationException("visitOCLinEcoreConstraintCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitSysMLCS(@NonNull SysMLCS self) {
        throw new UnsupportedOperationException("visitSysMLCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitTopLevelCS(@NonNull TopLevelCS self) {
        throw new UnsupportedOperationException("visitTopLevelCS is not supported by " + getClass().getName());
    }
}
