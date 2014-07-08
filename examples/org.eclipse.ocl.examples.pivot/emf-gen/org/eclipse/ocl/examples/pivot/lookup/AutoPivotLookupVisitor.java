/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

public class AutoPivotLookupVisitor
	extends AbstractExtendingVisitor<AutoIPivotLookupEnvironment, AutoILookupContext<Element>>
	implements AutoIPivotLookupVisitor
{
    
    @NonNull protected final MetaModelManager mmManager;
    @NonNull protected final AutoIPivotLookupEnvironment result;
    
    public AutoPivotLookupVisitor(@NonNull MetaModelManager mmManager, @NonNull AutoIPivotLookupEnvironment result, @NonNull AutoILookupContext<Element> context) {
        super(context);
        this.mmManager = mmManager;
        this.result = result;
    }
    
    public @Nullable AutoIPivotLookupEnvironment visiting(@NonNull Visitable visitable) {
        return lookupInParentIfNotComplete();
    }
    @NonNull
    protected final AutoIPivotLookupEnvironment lookupInNewContext(@Nullable AutoILookupContext<Element>newContext) {
        return newContext == null ? result // If we have reached the top element
            : DomainUtil.nonNullState((newContext.getTarget()).accept(
            new AutoPivotLookupVisitor(mmManager, result, newContext)));
    }
    @NonNull
    protected AutoIPivotLookupEnvironment lookupFromNewElement(Element element) {
        return DomainUtil.nonNullState(element.accept(this));
    }
    /**
    	* If the environment is complete returns the current configured environment
     * otherwise, go on gathering more results from parent's context
     *
     * @return the configured lookup environment
     */
    @NonNull
    protected AutoIPivotLookupEnvironment lookupInParentIfNotComplete() {
        return result.isComplete() ? result : lookupInNewContext(context.getParent());
    }
    
    @Override 
    public @Nullable AutoIPivotLookupEnvironment visitIteratorExp(@NonNull IteratorExp self) {
        EReference containmentReference = context.getToChildReference();
        return lookupInParentIfNotComplete();
    }
    
    @Override 
    public @Nullable AutoIPivotLookupEnvironment visitIterateExp(@NonNull IterateExp self) {
        EReference containmentReference = context.getToChildReference();
        return lookupInParentIfNotComplete();
    }
    
    @Override 
    public @Nullable AutoIPivotLookupEnvironment visitLibrary(@NonNull Library self) {
        EReference containmentReference = context.getToChildReference();
        return lookupInParentIfNotComplete();
    }
    
    @Override 
    public @Nullable AutoIPivotLookupEnvironment visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package self) {
        EReference containmentReference = context.getToChildReference();
        return lookupInParentIfNotComplete();
    }
    
    @Override 
    public @Nullable AutoIPivotLookupEnvironment visitEnumeration(@NonNull Enumeration self) {
        EReference containmentReference = context.getToChildReference();
        return lookupInParentIfNotComplete();
    }
    
    @Override 
    public @Nullable AutoIPivotLookupEnvironment visitRoot(@NonNull Root self) {
        EReference containmentReference = context.getToChildReference();
        return lookupInParentIfNotComplete();
    }
    
    @Override 
    public @Nullable AutoIPivotLookupEnvironment visitOperation(@NonNull Operation self) {
        EReference containmentReference = context.getToChildReference();
        return lookupInParentIfNotComplete();
    }
    
    @Override 
    public @Nullable AutoIPivotLookupEnvironment visitClass(@NonNull Class self) {
        EReference containmentReference = context.getToChildReference();
        return lookupInParentIfNotComplete();
    }
    
    @Override 
    public @Nullable AutoIPivotLookupEnvironment visitLetExp(@NonNull LetExp self) {
        EReference containmentReference = context.getToChildReference();
        return lookupInParentIfNotComplete();
    }
    
    @Override 
    public @Nullable AutoIPivotLookupEnvironment visitExpressionInOCL(@NonNull ExpressionInOCL self) {
        EReference containmentReference = context.getToChildReference();
        return lookupInParentIfNotComplete();
    }
}
