package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * @since 3.5
 */
public class NewPivotLookupVisitor extends AutoPivotLookupVisitor{
		
	protected final  MetaModelManager mmManager;
	public NewPivotLookupVisitor(@NonNull MetaModelManager mmManager, @NonNull Environment env) {
		super(env);
		this.mmManager = mmManager;
	}
	
//	@Override
//	public @NonNull
//	Environment visitOperation(@NonNull Operation object) {
//		EReference containmentReference = context.getToChildReference();
//		if (containmentReference == PivotPackage.Literals.OPERATION__OWNED_PARAMETER) {
//			
//		}
//		else {
//			env.addOperation0_ParameterElements(object);
//		}
//		env.addTypeTemplateParameterables(object);
//		return this.parentEnv(object);
//	}
//
//	@Override
//	public @NonNull
//	Environment visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
//		
//		assert !(object instanceof Metaclass<?>);
//		if (object.getOwningTemplateParameter() != null) {
//			org.eclipse.ocl.examples.pivot.Class type = mmManager.getOclAnyType(); // WIP use lowerbound
//			env.addClass1_OperationElements(type);
//			env.addClass2_PropertyElements(type);
//			env.addClass0_BehaviorElements(type);
//			return env;
//		}
//		if (object.getTemplateBinding().size() == 0) {
//			EObject scopeTarget = context.getTarget();
//			if (scopeTarget instanceof Pivotable) {
//				Element pivot = ((Pivotable)scopeTarget).getPivot();
//				if (pivot == object) {		// Inherited template parameters are invisible.
//					env.addTypeTemplateParameterables(object);
//				}
//			}
//		}
//		env.addClass1_OperationElements(object);
//		env.addClass2_PropertyElements(object);
//		env.addClass0_BehaviorElements(object);
//		return lookupInParentIfEnvNoComplete();
//	}
//	
//	@Override
//	public @NonNull
//	Environment visitDataType(@NonNull DataType object) {
//		env.addTypeTemplateParameterables(object);
//		Type behavioralType = object.getBehavioralType();
//		if (behavioralType == null) {
//			return visitClass(object);
//		} else {
//			if (! (behavioralType instanceof DataType)) { // FIXME
//				Environment env = behavioralType.accept(this);
//				assert(env != null);
//				return env;
//			} else {
//				return lookupInParentIfEnvNoComplete();
//			}
//		}
//	};
//
//	@Override
//	public @NonNull
//	Environment visitEnumeration(@NonNull Enumeration object) {
//		env.addEnumeration3_EnumerationLiteralElements(object);
//		env.addEnumeration2_PropertyElements(object);
//		env.addEnumeration1_OperationElements(object);
//		env.addEnumeration0_BehaviorElements(object);
//		env.addTypeTemplateParameterables(object);
//		return lookupInParentIfEnvNoComplete();
//	}
//	
//	@Override
//	public @NonNull
//	Environment visitPackage(@NonNull Package object) {
//		Set<Package> allPackages = new HashSet<Package>();
//		gatherAllPackages(mmManager, allPackages, object);
//		for (@SuppressWarnings("null")@NonNull Package aPackage : allPackages) {
//			env.addPackage0_TypeElements(aPackage);
//			env.addPackage1_PackageElements(aPackage);
//		}
//		return lookupInParentIfEnvNoComplete();
//	}
//
//	private void gatherAllPackages(@NonNull MetaModelManager metaModelManager, @NonNull Set<org.eclipse.ocl.examples.pivot.Package> allPackages,
//				@NonNull org.eclipse.ocl.examples.pivot.Package targetPackage) {
//			org.eclipse.ocl.examples.pivot.Package primaryPackage = metaModelManager.getPrimaryElement(targetPackage);
//		if (allPackages.add(primaryPackage)) {
//			for (@SuppressWarnings("null")@NonNull DomainPackage partialPackage : metaModelManager.getPartialPackages(primaryPackage, false)) {
//				if (partialPackage instanceof org.eclipse.ocl.examples.pivot.Package) {
//					for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.examples.pivot.Package importedPackage : ((org.eclipse.ocl.examples.pivot.Package)partialPackage).getImportedPackage()) {
//						gatherAllPackages(metaModelManager, allPackages, importedPackage);
//					}
//				}
//			}
//		}
//	}
//	
//	@Override
//	public @NonNull
//	Environment visitUnspecifiedType(@NonNull UnspecifiedType object) {
//		return lookupFromNewElement(object.getLowerBound());
//	}
//	
//	@Override
//	public @NonNull
//	Environment visitLibrary(@NonNull Library object) {
//		env.addLibrary0_PrecedenceElements(object);
//		return super.visitLibrary(object);
//
//	}
//	
//	@Override
//	public @NonNull
//	Environment visitMetaclass(@NonNull Metaclass object) {
//		env.addMetaclass0_NamedElementElements(object);
//		env.addMetaclass1_NamedElementElements(object);		
//		return lookupInParentIfEnvNoComplete();
//	}
//	
//	@Override
//	public @NonNull
//	Environment visitIterateExp(@NonNull IterateExp object) {
//
//		EStructuralFeature containmentFeature = context.getToChildReference();
//		if (containmentFeature == PivotPackage.Literals.LOOP_EXP__BODY) {
//			OCLExpression source = object.getSource();
//			lookupFromNewElement(source.getType());
//			env.addIterateExp0_VariableElements(object);
//			env.addIterateExp1_VariableElement(object);
//			
//		}
//		else if (containmentFeature == PivotPackage.Literals.ITERATE_EXP__RESULT) {
//			OCLExpression source = object.getSource();
//			env.addIterateExp2_VariableElements(object);
//			lookupFromNewElement(source.getType());
//		}
//		else if (containmentFeature == PivotPackage.Literals.LOOP_EXP__ITERATOR) {
//			OCLExpression source = object.getSource();
//			lookupFromNewElement(source.getType());
//						
//			int childIndex = object.getIterator().indexOf(context.getChild());
//			env.addIterateExp3_VariableElements(object, childIndex);
//		}
//		return lookupInParentIfEnvNoComplete();
//	}
//
//	@Override
//	public @NonNull
//	Environment visitIteratorExp(@NonNull IteratorExp object) {
//		
//		EStructuralFeature containmentFeature = context.getToChildReference();
//		if (containmentFeature == PivotPackage.Literals.LOOP_EXP__BODY) {
//			OCLExpression source = object.getSource();
//			lookupFromNewElement(source.getType());
//			env.addIteratorExp0_VariableElements(object);
//		}
//		else if (containmentFeature == PivotPackage.Literals.LOOP_EXP__ITERATOR) {
//			OCLExpression source = object.getSource();
//			lookupFromNewElement(source.getType());
//			
//			int childIndex = object.getIterator().indexOf(context.getChild());
//			env.addIteratorExp1_VariableElements(object, childIndex);
//		}
//		return lookupInParentIfEnvNoComplete();
//	}
//	
////  This is not used by test cases
////	@Override
////	public @NonNull
////	AutoIPivotLookupenv<C> visitLetExp(@NonNull LetExp object) {
////		EStructuralFeature containmentFeature = context.getToChildReference();
////		if (containmentFeature == PivotPackage.Literals.LET_EXP__IN) {
////			env.addVariable(object);
////		}
////		return lookupInParentIfEnvNoComplete();
////	}
//	
//	@Override
//	public @NonNull
//	Environment visitExpressionInOCL(@NonNull ExpressionInOCL object) {
//		Variable contextVariable = object.getContextVariable();
//		if (contextVariable != null) {
//			lookupFromNewElement(contextVariable.getType());
//		}
//		env.addExpressionInOCL0_VariableElement(object);
//		env.addExpressionInOCL1_VariableElement(object);
//		return lookupInParentIfEnvNoComplete();
//	};
}
