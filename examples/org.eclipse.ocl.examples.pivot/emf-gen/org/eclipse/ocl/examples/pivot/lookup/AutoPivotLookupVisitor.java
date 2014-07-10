package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;


public class AutoPivotLookupVisitor extends AbstractExtendingVisitor<AutoIPivotLookupEnvironment, AutoILookupContext<Element>>
	implements AutoIPivotLookupVisitor {
		 
	@NonNull final protected MetaModelManager mmManager;
	@NonNull final protected AutoIPivotLookupEnvironment env;
	
	public AutoPivotLookupVisitor(@NonNull MetaModelManager mmManager, @NonNull AutoIPivotLookupEnvironment env, @NonNull AutoILookupContext<Element> context) {
		super(context);
		this.mmManager = mmManager;
		this.env = env;
	}

	@NonNull
	public AutoIPivotLookupEnvironment visiting(@NonNull Visitable visitable) {
		return lookupInParentIfNotComplete();
	}
	
	@NonNull
	protected final AutoIPivotLookupEnvironment lookupInNewContext(@Nullable AutoILookupContext<Element> newContext) {
		return newContext == null ? env // If we have reached the top element
			: DomainUtil.nonNullState((newContext.getTarget()).accept( 
				new AutoPivotLookupVisitor(mmManager, env, newContext))); 
	}
	@NonNull
	protected AutoIPivotLookupEnvironment lookupFromNewElement(Element element) {
		return DomainUtil.nonNullState(element.accept(this));
	}
	
	/**
	 * Used when looking up in local AND in parent environments if not found 
	 * in local -> outer scope/environment elements are occluded in nested 
	 * contexts
	 * @return the accumulated lookup env
	 */
	@NonNull
	protected AutoIPivotLookupEnvironment lookupInParentIfNotComplete() {
		return env.isComplete() ? env : lookupInNewContext(context.getParent());
	}
	
	// Generated from NameResolution description
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitLetExp(@NonNull LetExp object) {
		EReference containmentReference = context.getToChildReference();
		if (containmentReference == org.eclipse.ocl.examples.pivot.PivotPackage.Literals.LET_EXP__IN)
		{
			env.addLetExp0_VariableElement(object);
		}
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitLibrary(@NonNull Library object) {
		env.addLibrary0_PrecedenceElements(object);
		env.addLibrary1_TypeElements(object);
		env.addLibrary2_PackageElements(object);
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitPackage(@NonNull Package object) {
		env.addPackage0_TypeElements(object);
		env.addPackage1_PackageElements(object);
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitRoot(@NonNull Root object) {
		env.addRoot0_PackageElements(object);
		env.addRoot1_ImportElements(object);
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitMetaclass(@NonNull Metaclass object) {
		env.addMetaclass0_NamedElementElements(object);
		env.addMetaclass1_NamedElementElements(object);
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitOperation(@NonNull Operation object) {
		EReference containmentReference = context.getToChildReference();
		if (containmentReference == org.eclipse.ocl.examples.pivot.PivotPackage.Literals.OPERATION__OWNED_PARAMETER)
		{
		}
		else  
		{
			env.addOperation0_ParameterElements(object);
		}
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitEnumeration(@NonNull Enumeration object) {
		env.addEnumeration0_BehaviorElements(object);
		env.addEnumeration1_OperationElements(object);
		env.addEnumeration2_PropertyElements(object);
		env.addEnumeration3_EnumerationLiteralElements(object);
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitDataType(@NonNull DataType object) {
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitClass(@NonNull Class object) {
		env.addClass0_BehaviorElements(object);
		env.addClass1_OperationElements(object);
		env.addClass2_PropertyElements(object);
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitIteratorExp(@NonNull IteratorExp object) {
		EReference containmentReference = context.getToChildReference();
		if (containmentReference == org.eclipse.ocl.examples.pivot.PivotPackage.Literals.LOOP_EXP__ITERATOR)
		{
		}
		else  
		if (containmentReference == org.eclipse.ocl.examples.pivot.PivotPackage.Literals.LOOP_EXP__BODY)
		{
			env.addIteratorExp0_VariableElements(object);
		}
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitIterateExp(@NonNull IterateExp object) {
		EReference containmentReference = context.getToChildReference();
		if (containmentReference == org.eclipse.ocl.examples.pivot.PivotPackage.Literals.LOOP_EXP__ITERATOR)
		{
		}
		else  
		if (containmentReference == org.eclipse.ocl.examples.pivot.PivotPackage.Literals.ITERATE_EXP__RESULT)
		{
			env.addIterateExp0_VariableElements(object);
		}
		else  
		if (containmentReference == org.eclipse.ocl.examples.pivot.PivotPackage.Literals.LOOP_EXP__BODY)
		{
			env.addIterateExp1_VariableElement(object);
			env.addIterateExp2_VariableElements(object);
		}
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		EReference containmentReference = context.getToChildReference();
		if (containmentReference == org.eclipse.ocl.examples.pivot.PivotPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION)
		{
			env.addExpressionInOCL0_VariableElement(object);
			env.addExpressionInOCL1_VariableElement(object);
		}
		return lookupInParentIfNotComplete();
	}
}
