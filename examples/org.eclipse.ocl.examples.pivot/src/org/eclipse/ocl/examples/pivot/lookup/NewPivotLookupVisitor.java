package org.eclipse.ocl.examples.pivot.lookup;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UnspecifiedType;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.Pivotable;

public class NewPivotLookupVisitor extends AutoPivotLookupVisitor{
	
	public NewPivotLookupVisitor(@NonNull MetaModelManager mmManager, @NonNull AutoIPivotLookupEnvironment env, @NonNull AutoILookupContext<Element> context) {
		super(mmManager, env, context);
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitOperation(@NonNull Operation object) {
		EReference containmentReference = context.getToChildReference();
		if (containmentReference == PivotPackage.Literals.OPERATION__OWNED_PARAMETER) {
			
		}
		else {
			env.addOperation0_ParameterElements(object);
		}
		
		return lookupInParentIfNotComplete();
	}

	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		
		assert !(object instanceof Metaclass<?>);
		if (object.getOwningTemplateParameter() != null) {
			org.eclipse.ocl.examples.pivot.Class type = mmManager.getOclAnyType(); // WIP use lowerbound
			env.addClass1_OperationElements(type);
			env.addClass2_PropertyElements(type);
			env.addClass0_BehaviorElements(type);
			return env;
		}
		if (object.getTemplateBinding().size() == 0) {
			EObject scopeTarget = context.getTarget();
			if (scopeTarget instanceof Pivotable) {
				Element pivot = ((Pivotable)scopeTarget).getPivot();
				if (pivot == object) {		// Inherited template parameters are invisible.
					env.addTypeTemplateParameterables(object);
				}
			}
		}
		env.addClass1_OperationElements(object);
		env.addClass2_PropertyElements(object);
		env.addClass0_BehaviorElements(object);
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitDataType(@NonNull DataType object) {
		env.addTypeTemplateParameterables(object);
		Type behavioralType = object.getBehavioralType();
		if (behavioralType == null) {
			return visitClass(object);
		} else {
			if (! (behavioralType instanceof DataType)) { // FIXME
				AutoIPivotLookupEnvironment env = behavioralType.accept(this);
				assert(env != null);
				return env;
			} else {
				return lookupInParentIfNotComplete();
			}
		}
	};

	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitEnumeration(@NonNull Enumeration object) {
		env.addEnumeration3_EnumerationLiteralElements(object);
		env.addEnumeration2_PropertyElements(object);
		env.addEnumeration1_OperationElements(object);
		env.addEnumeration0_BehaviorElements(object);
		env.addTypeTemplateParameterables(object);
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitPackage(@NonNull Package object) {
		Set<Package> allPackages = new HashSet<Package>();
		gatherAllPackages(mmManager, allPackages, object);
		for (@SuppressWarnings("null")@NonNull Package aPackage : allPackages) {
			env.addPackage0_TypeElements(aPackage);
			env.addPackage1_PackageElements(aPackage);
		}
		return lookupInParentIfNotComplete();
	}

	private void gatherAllPackages(@NonNull MetaModelManager metaModelManager, @NonNull Set<org.eclipse.ocl.examples.pivot.Package> allPackages,
				@NonNull org.eclipse.ocl.examples.pivot.Package targetPackage) {
			org.eclipse.ocl.examples.pivot.Package primaryPackage = metaModelManager.getPrimaryElement(targetPackage);
		if (allPackages.add(primaryPackage)) {
			for (@SuppressWarnings("null")@NonNull DomainPackage partialPackage : metaModelManager.getPartialPackages(primaryPackage, false)) {
				if (partialPackage instanceof org.eclipse.ocl.examples.pivot.Package) {
					for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.examples.pivot.Package importedPackage : ((org.eclipse.ocl.examples.pivot.Package)partialPackage).getImportedPackage()) {
						gatherAllPackages(metaModelManager, allPackages, importedPackage);
					}
				}
			}
		}
	}

	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitRoot(@NonNull Root object) {
		env.addRoot0_PackageElements(object);
		env.addRoot1_ImportElements(object);
		return lookupInParentIfNotComplete();
		
	};
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitUnspecifiedType(@NonNull UnspecifiedType object) {
		return lookupFromNewElement(object.getLowerBound());
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitLibrary(@NonNull Library object) {
		env.addLibrary0_PrecedenceElements(object);
		return super.visitLibrary(object);

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
	AutoIPivotLookupEnvironment visitIterateExp(@NonNull IterateExp object) {

		EStructuralFeature containmentFeature = context.getToChildReference();
		if (containmentFeature == PivotPackage.Literals.LOOP_EXP__BODY) {
			OCLExpression source = object.getSource();
			lookupFromNewElement(source.getType());
			env.addIterateExp0_VariableElements(object);
			env.addIterateExp1_VariableElement(object);
			
		}
		else if (containmentFeature == PivotPackage.Literals.ITERATE_EXP__RESULT) {
			OCLExpression source = object.getSource();
			env.addIterateExp2_VariableElements(object);
			lookupFromNewElement(source.getType());
		}
		else if (containmentFeature == PivotPackage.Literals.LOOP_EXP__ITERATOR) {
			OCLExpression source = object.getSource();
			lookupFromNewElement(source.getType());
						
			int childIndex = object.getIterator().indexOf(context.getChild());
			env.addIterateExp3_VariableElements(object, childIndex);
		}
		return lookupInParentIfNotComplete();
	}

	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitIteratorExp(@NonNull IteratorExp object) {
		
		EStructuralFeature containmentFeature = context.getToChildReference();
		if (containmentFeature == PivotPackage.Literals.LOOP_EXP__BODY) {
			OCLExpression source = object.getSource();
			lookupFromNewElement(source.getType());
			env.addIteratorExp0_VariableElements(object);
		}
		else if (containmentFeature == PivotPackage.Literals.LOOP_EXP__ITERATOR) {
			OCLExpression source = object.getSource();
			lookupFromNewElement(source.getType());
			
			int childIndex = object.getIterator().indexOf(context.getChild());
			env.addIteratorExp1_VariableElements(object, childIndex);
		}
		return lookupInParentIfNotComplete();
	}
	
//  This is not used by test cases
//	@Override
//	public @NonNull
//	AutoIPivotLookupenv<C> visitLetExp(@NonNull LetExp object) {
//		EStructuralFeature containmentFeature = context.getToChildReference();
//		if (containmentFeature == PivotPackage.Literals.LET_EXP__IN) {
//			env.addVariable(object);
//		}
//		return lookupInParentIfNotComplete();
//	}
	
	@Override
	public @NonNull
	AutoIPivotLookupEnvironment visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		Variable contextVariable = object.getContextVariable();
		if (contextVariable != null) {
			lookupFromNewElement(contextVariable.getType());
		}
		env.addExpressionInOCL0_VariableElement(object);
		env.addExpressionInOCL1_VariableElement(object);
		return lookupInParentIfNotComplete();
	};
}
