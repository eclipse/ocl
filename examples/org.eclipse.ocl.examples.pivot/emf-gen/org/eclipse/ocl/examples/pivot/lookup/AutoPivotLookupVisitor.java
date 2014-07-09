package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;


public class AutoPivotLookupVisitor extends AbstractExtendingVisitor<AutoIPivotLookupEnvironment, AutoILookupContext<Element>>
	implements AutoIPivotLookupVisitor {
		 
	@NonNull final protected MetaModelManager mmManager;
	@NonNull final protected AutoIPivotLookupEnvironment result;
	
	public AutoPivotLookupVisitor(@NonNull MetaModelManager mmManager, @NonNull AutoIPivotLookupEnvironment result, @NonNull AutoILookupContext<Element> context) {
		super(context);
		this.mmManager = mmManager;
		this.result = result;
	}

	@NonNull
	public AutoIPivotLookupEnvironment visiting(@NonNull Visitable visitable) {
		return lookupInParentIfNotComplete();
	}
	
	@NonNull
	protected final AutoIPivotLookupEnvironment lookupInNewContext(@Nullable AutoILookupContext<Element> newContext) {
		return newContext == null ? result // If we have reached the top element
			: DomainUtil.nonNullState((newContext.getTarget()).accept( 
				new AutoPivotLookupVisitor(mmManager, result, newContext))); 
	}
	@NonNull
	protected AutoIPivotLookupEnvironment lookupFromNewElement(Element element) {
		return DomainUtil.nonNullState(element.accept(this));
	}
	
	// Lookup propagation protocols 
	
	
	/**
	 * Used when looking up in local AND in parent environments if not found 
	 * in local -> outer scope/environment elements are occluded in nested 
	 * contexts
	 * @return the accumulated lookup result
	 */
	@NonNull
	protected AutoIPivotLookupEnvironment lookupInParentIfNotComplete() {
		return result.isComplete() ? result : lookupInNewContext(context.getParent());
	}
	
	// Generated from NameResolution description
	
	
	@Override
	public @Nullable
	AutoIPivotLookupEnvironment visitPackage(@NonNull Package object) {
		result.addPackage0_TypeElements(object);
		result.addPackage1_PackageElements(object);
		return lookupInParentIfNotComplete();
	}
		
	
	
	@Override
	public @Nullable
	AutoIPivotLookupEnvironment visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		result.addExpressionInOCL0_VariableElement(object);
		result.addExpressionInOCL1_VariableElement(object);
		return lookupInParentIfNotComplete();
	}
		
	
	
	@Override
	public @Nullable
	AutoIPivotLookupEnvironment visitOperation(@NonNull Operation object) {
		EReference containmentReference = context.getToChildReference();
		// TODO
		return lookupInParentIfNotComplete();
	}
		
	
	
	@Override
	public @Nullable
	AutoIPivotLookupEnvironment visitLibrary(@NonNull Library object) {
		result.addLibrary0_PrecedenceElements(object);
		result.addLibrary1_TypeElements(object);
		result.addLibrary2_PackageElements(object);
		return lookupInParentIfNotComplete();
	}
		
	
	
	@Override
	public @Nullable
	AutoIPivotLookupEnvironment visitClass(@NonNull Class object) {
		result.addClass0_BehaviorElements(object);
		result.addClass1_OperationElements(object);
		result.addClass2_PropertyElements(object);
		return lookupInParentIfNotComplete();
	}
		
	
	
	@Override
	public @Nullable
	AutoIPivotLookupEnvironment visitLetExp(@NonNull LetExp object) {
		result.addLetExp0_VariableElement(object);
		return lookupInParentIfNotComplete();
	}
		
	
	
	@Override
	public @Nullable
	AutoIPivotLookupEnvironment visitIteratorExp(@NonNull IteratorExp object) {
		EReference containmentReference = context.getToChildReference();
		// TODO
		return lookupInParentIfNotComplete();
	}
		
	
	
	@Override
	public @Nullable
	AutoIPivotLookupEnvironment visitMetaclass(@NonNull Metaclass object) {
		result.addMetaclass0_NamedElementElements(object);
		result.addMetaclass1_NamedElementElements(object);
		return lookupInParentIfNotComplete();
	}
		
	
	
	@Override
	public @Nullable
	AutoIPivotLookupEnvironment visitRoot(@NonNull Root object) {
		result.addRoot0_PackageElements(object);
		result.addRoot1_ImportElements(object);
		return lookupInParentIfNotComplete();
	}
		
	
	
	@Override
	public @Nullable
	AutoIPivotLookupEnvironment visitDataType(@NonNull DataType object) {
		return lookupInParentIfNotComplete();
	}
		
	
	
	@Override
	public @Nullable
	AutoIPivotLookupEnvironment visitEnumeration(@NonNull Enumeration object) {
		result.addEnumeration0_BehaviorElements(object);
		result.addEnumeration1_OperationElements(object);
		result.addEnumeration2_PropertyElements(object);
		result.addEnumeration3_EnumerationLiteralElements(object);
		return lookupInParentIfNotComplete();
	}
		
	
	
	@Override
	public @Nullable
	AutoIPivotLookupEnvironment visitIterateExp(@NonNull IterateExp object) {
		EReference containmentReference = context.getToChildReference();
		// TODO
		return lookupInParentIfNotComplete();
	}
		
}
