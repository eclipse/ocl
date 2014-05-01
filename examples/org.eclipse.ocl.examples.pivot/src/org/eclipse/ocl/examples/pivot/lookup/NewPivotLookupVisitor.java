package org.eclipse.ocl.examples.pivot.lookup;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
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

public class NewPivotLookupVisitor<C extends Element> extends AutoPivotLookupVisitor<C>{
	
	public NewPivotLookupVisitor(@NonNull MetaModelManager mmManager, @NonNull AutoIPivotLookupResult<C> result, @NonNull AutoILookupContext<Element> context) {
		super(mmManager, result, context);
	}
	
	@Override
	public @Nullable
	AutoIPivotLookupResult<C> visitOperation(@NonNull Operation object) {
		EReference containmentReference = context.getToChildReference();
		if (containmentReference == PivotPackage.Literals.OPERATION__OWNED_PARAMETER) {
			
		}
		else {
			result.addOwnedParameter(object);
		}
		result.addTypeTemplateParameterables(object);
		return lookupInParentIfNotComplete();
	}

	@Override
	public @NonNull
	AutoIPivotLookupResult<C> visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		
		assert !(object instanceof Metaclass<?>);
		if (object.getOwningTemplateParameter() != null) {
			org.eclipse.ocl.examples.pivot.Class type = mmManager.getOclAnyType(); // WIP use lowerbound
			result.addOwnedOperation(type, FeatureFilter.SELECT_NON_STATIC);
			result.addOwnedProperty(type, FeatureFilter.SELECT_NON_STATIC);
			result.addOwnedState(type);
			return result;
		}
		if (object.getTemplateBinding().size() == 0) {
			EObject scopeTarget = context.getTarget();
			if (scopeTarget instanceof Pivotable) {
				Element pivot = ((Pivotable)scopeTarget).getPivot();
				if (pivot == object) {		// Inherited template parameters are invisible.
					result.addTypeTemplateParameterables(object);
				}
			}
		}
		result.addOwnedOperation(object, null);
		result.addOwnedProperty(object, null);
		result.addOwnedState(object);
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @Nullable
	AutoIPivotLookupResult<C> visitDataType(@NonNull DataType object) {
		result.addTypeTemplateParameterables(object);
		Type behavioralType = object.getBehavioralType();
		if (behavioralType == null) {
			return visitClass(object);
		} else {
			if (! (behavioralType instanceof DataType)) { // FIXME
				return behavioralType.accept(this);
			} else {
				return lookupInParentIfNotComplete();
			}
		}
	};

	@Override
	public @NonNull
	AutoIPivotLookupResult<C> visitEnumeration(@NonNull Enumeration object) {
		result.addOwnedEnumerationLiteral(object);
		result.addOwnedOperation(object, FeatureFilter.SELECT_NON_STATIC);
		result.addOwnedProperty(object, FeatureFilter.SELECT_NON_STATIC);
		result.addTypeTemplateParameterables(object);
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupResult<C> visitPackage(@NonNull Package object) {
		Set<Package> allPackages = new HashSet<Package>();
		gatherAllPackages(mmManager, allPackages, object);
		for (@SuppressWarnings("null")@NonNull Package aPackage : allPackages) {
			result.addAllPackages(aPackage);
			result.addOwnedTypes(aPackage);
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
	AutoIPivotLookupResult<C> visitRoot(@NonNull Root object) {
		result.addNestedPackages(object);
		result.addRootPackages();
		return lookupInParentIfNotComplete();
		
	};
	
	@Override
	public @NonNull
	AutoIPivotLookupResult<C> visitUnspecifiedType(@NonNull UnspecifiedType object) {
		return lookupFromNewElement(object.getLowerBound());
	}
	
	@Override
	public @Nullable
	AutoIPivotLookupResult<C> visitLibrary(@NonNull Library object) {
		result.addOwnedPrecedence(object);
		return super.visitLibrary(object);

	}
	
	@Override
	public @Nullable
	AutoIPivotLookupResult<C> visitMetaclass(@NonNull Metaclass<?> object) {
		Type instanceType = object.getInstanceType();
		if (instanceType != null) {
			result.addOwnedOperation(instanceType, null);
			result.addOwnedProperty(instanceType, null);
		}
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @Nullable
	AutoIPivotLookupResult<C> visitIterateExp(@NonNull IterateExp object) {

		EStructuralFeature containmentFeature = context.getToChildReference();
		if (containmentFeature == PivotPackage.Literals.LOOP_EXP__BODY) {
			OCLExpression source = object.getSource();
			lookupFromNewElement(source.getType());
			result.addIterator(object);
			result.addResult(object);
			
		}
		else if (containmentFeature == PivotPackage.Literals.ITERATE_EXP__RESULT) {
			OCLExpression source = object.getSource();
			result.addIterator(object);
			lookupFromNewElement(source.getType());
		}
		else if (containmentFeature == PivotPackage.Literals.LOOP_EXP__ITERATOR) {
			OCLExpression source = object.getSource();			
			lookupFromNewElement(source.getType());
			//result.addIterator(object);
			
			int childIndex = object.getIterator().indexOf(context.getChild());
			for (int i = 0; i < childIndex; i++) {
				result.addIterator(object, i);
			}
		}
		return lookupInParentIfNotComplete();
	}

	@Override
	public @Nullable
	AutoIPivotLookupResult<C> visitIteratorExp(@NonNull IteratorExp object) {
		
		EStructuralFeature containmentFeature = context.getToChildReference();
		if (containmentFeature == PivotPackage.Literals.LOOP_EXP__BODY) {
			OCLExpression source = object.getSource();
			lookupFromNewElement(source.getType());
			result.addIterator(object);
		}
		else if (containmentFeature == PivotPackage.Literals.LOOP_EXP__ITERATOR) {
			OCLExpression source = object.getSource();
			lookupFromNewElement(source.getType());
			//result.addIterator(object);
			
			int childIndex = object.getIterator().indexOf(context.getChild());
			for (int i = 0; i < childIndex; i++) {
				result.addIterator(object, i);
			}
		}
		return lookupInParentIfNotComplete();
	}	
	
	@Override
	public @NonNull
	AutoIPivotLookupResult<C> visitLetExp(@NonNull LetExp object) {
		EStructuralFeature containmentFeature = context.getToChildReference();
		if (containmentFeature == PivotPackage.Literals.LET_EXP__IN) {
			result.addVariable(object);
		}
		return lookupInParentIfNotComplete();
	}
	
	@Override
	public @NonNull
	AutoIPivotLookupResult<C> visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		Variable contextVariable = object.getContextVariable();
		if (contextVariable != null) {
			lookupFromNewElement(contextVariable.getType());
		}
		result.addContextVariable(object);
		result.addResultVariable(object);
		return lookupInParentIfNotComplete();
	};
}
