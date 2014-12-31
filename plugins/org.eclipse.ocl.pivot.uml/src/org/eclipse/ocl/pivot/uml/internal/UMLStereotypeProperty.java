package org.eclipse.ocl.pivot.uml.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.StereotypeProperty;

/**
 * An instance of StereotypeProperty supports evaluation of a property call that accesses a stereotype extension property.
 */
public class UMLStereotypeProperty extends StereotypeProperty
{
	public UMLStereotypeProperty(@NonNull Property property) {
		super(property);
	}
	
	@Override
	public @Nullable Object evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		IdResolver idResolver = evaluator.getIdResolver();
		EObject eObject = asNavigableObject(sourceValue, property, evaluator);
		Object boxedValue = null;
		if (eObject instanceof UMLElementExtension) {
			Object unboxedValue = ((UMLElementExtension)eObject).getValue(idResolver, property);
			boxedValue = unboxedValue != null ? idResolver.boxedValueOf(unboxedValue/*, eFeature, returnTypeId*/) : null;
			return boxedValue;
		}
		else  {
			return super.evaluate(evaluator, returnTypeId, sourceValue);
		}
	}
}