package org.eclipse.ocl.examples.pivot.lookup;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.attributes.ClassAttribution;
import org.eclipse.ocl.examples.pivot.lookup.AutoILookupContext;
import org.eclipse.ocl.examples.pivot.lookup.AutoILookupResult;
import org.eclipse.ocl.examples.pivot.lookup.AutoPivotLookupVisitor;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class NewPivotLookupVisitor<C extends EObject> extends AutoPivotLookupVisitor<C>{
	
	public NewPivotLookupVisitor(@NonNull MetaModelManager mmManager, @NonNull AutoILookupResult<C> result, @NonNull AutoILookupContext context) {
		super(mmManager, result, context);
	}
	
	@Override
	public @Nullable
	AutoILookupResult<C> visitOperation(@NonNull Operation object) {
		EReference containmentReference = context.getToChildReference();
		if (containmentReference == PivotPackage.Literals.OPERATION__OWNED_PARAMETER) {
			
		}
		else {
			result.addOwnedParameter(object);
		}
		result.addTypeTemplateParameterables(object);
		return lookupInParent();
	}

	@Override
	public @NonNull
	AutoILookupResult<C> visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		
		assert !(object instanceof Metaclass<?>);
		if (object.getOwningTemplateParameter() != null) {
			org.eclipse.ocl.examples.pivot.Class type = mmManager.getOclAnyType(); // WIP use lowerbound
			result.addOwnedOperation(type, false);
			result.addOwnedProperty(type, false);
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
		result.addOwnedOperation(object, false);
		result.addOwnedProperty(object, false);
		result.addOwnedState(object);
		if (!result.isComplete()) {
			result.addOwnedOperation(object, true);
			result.addOwnedProperty(object, true);
		}
		return lookupInParent();
	}
	
	@Override
	public @Nullable
	AutoILookupResult<C> visitDataType(@NonNull DataType object) {
		result.addTypeTemplateParameterables(object);
		Type behavioralType = object.getBehavioralType();
		if (behavioralType == null) {
			return visitClass(object);
		} else {
			if (! (behavioralType instanceof DataType)) { // FIXME
				return behavioralType.accept(this);
			} else {
				return lookupInParent();
			}
		}
	};

	@Override
	public @Nullable
	AutoILookupResult<C> visitEnumeration(@NonNull Enumeration object) {
		result.addOwnedEnumerationLiteral(object);
		result.addOwnedOperation(object, false);
		result.addOwnedProperty(object, false);
		result.addTypeTemplateParameterables(object);
		return lookupInParent();
	}
}
