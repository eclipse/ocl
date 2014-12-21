/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.DomainEvaluator;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.uml.UMLElementExtension;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * An instance of StereotypeProperty supports evaluation of a property call that accesses a stereotype extension property.
 */
public class StereotypeProperty extends ConstrainedProperty
{
	public StereotypeProperty(@NonNull Property property) {
		super(property);
	}
	
	@Override
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		IdResolver idResolver = evaluator.getIdResolver();
		EObject eObject = asNavigableObject(sourceValue, property, evaluator);
//		if (eObject instanceof Metaclass<?>) {
//			eObject = ((Metaclass<?>)eObject).getInstanceType();
//		}
		Object boxedValue = null;
		if (eObject instanceof UMLElementExtension) {
			Object unboxedValue = ((UMLElementExtension)eObject).getValue(idResolver, property);
			boxedValue = unboxedValue != null ? idResolver.boxedValueOf(unboxedValue/*, eFeature, returnTypeId*/) : null;
			return boxedValue;
		}
		else if (eObject instanceof ElementExtension) {
			ElementExtension elementExtension = (ElementExtension)eObject;
			String propertyName = property.getName();
			Property extensionProperty = ClassUtil.getNamedElement(elementExtension.getOwnedProperties(), propertyName);
			if (extensionProperty == null) {
				boolean gotIt = false;
				Object defaultValue = null;
				LanguageExpression defaultExpression = null;
				if (elementExtension.isApplied()) {
					EObject umlStereotypeApplication = elementExtension.getETarget();
					if (umlStereotypeApplication != null) {
						EClass eClass = umlStereotypeApplication.eClass();
						EStructuralFeature eStructuralFeature = LabelUtil.getNamedElement(eClass.getEAllStructuralFeatures(), propertyName);
						if (eStructuralFeature != null) {
							defaultValue = idResolver.boxedValueOf(umlStereotypeApplication.eGet(eStructuralFeature));
							gotIt = true;
						}
					}
				}
				if (!gotIt && (elementExtension.isApplied() || elementExtension.isRequired())) {
					Property theProperty = ClassUtil.getNamedElement(elementExtension.getStereotype().getOwnedProperties(), propertyName);
					defaultValue = theProperty.getDefaultValue();
					defaultExpression = theProperty.getOwnedExpression();
					gotIt = true;
				}
				extensionProperty = PivotFactory.eINSTANCE.createProperty();
				extensionProperty.setName(propertyName);
				extensionProperty.setIsRequired(property.isRequired());
				extensionProperty.setIsStatic(property.isStatic());
				extensionProperty.setType(property.getType());
				extensionProperty.setDefaultValue(defaultValue);
				extensionProperty.setOwnedExpression(defaultExpression);
				elementExtension.getOwnedProperties().add(extensionProperty);
			}
/*			Property extensionProperty = ClassUtil.getNamedElement(elementExtension.getOwnedAttribute(), propertyName);
			if (extensionProperty == null) {
				boolean gotIt = false;
				EObject umlStereotypeApplication = elementExtension.getETarget();
				if (umlStereotypeApplication != null) {
					EClass eClass = umlStereotypeApplication.eClass();
					EStructuralFeature eStructuralFeature = EcoreUtils.getNamedElement(eClass.getEAllStructuralFeatures(), propertyName);
					if (eStructuralFeature != null) {
						Object value = umlStereotypeApplication.eGet(eStructuralFeature);
						gotIt = true;
					}
				}
				if (!gotIt && )
					if (elementExtension.isApplied() && !elementExtension.isRequired()) {
						return null;
					}
			} */
//			Property theProperty = ClassUtil.getNamedElement(elementExtension.getStereotype().getOwnedAttribute(), property.getName());
//			if (theProperty == null) {
//				return super.evaluate(evaluator, returnTypeId, sourceValue);
//			}
			Object defaultValue = extensionProperty.getDefaultValue();
			LanguageExpression defaultExpression = extensionProperty.getOwnedExpression();
			if (!extensionProperty.isDerived()) {
				boxedValue = defaultValue; //idResolver.createInstance(property.getTypeId(), defaultValueLiteral);
			}
			else if (defaultExpression != null) {
				String body = defaultExpression.getBody();
				if (body != null) {
					try {
						MetaModelManager metaModelManager = ((EvaluationVisitorImpl)evaluator).getMetaModelManager();
						ExpressionInOCL expr = metaModelManager.getQueryOrThrow(defaultExpression);
						OCLExpression bodyExpression = expr.getOwnedBody();
						if (bodyExpression != null) {
							boxedValue = evaluator.evaluate(bodyExpression);		// FIXME errors
						}
					} catch (ParserException e) {
						throw new InvalidValueException(e, "Bad defaultExpression for '{0}'", property);
					}
				}
			}
		}
		else {
			EClass eClass = eObject.eClass();
			EStructuralFeature eFeature = LabelUtil.getNamedElement(eClass.getEAllStructuralFeatures(), property.getName());
			if (eFeature != null) {
				Object value = eObject.eGet(eFeature);
				boxedValue = value != null ? idResolver.boxedValueOf(value, eFeature, returnTypeId) : null;
			}
		}
		return boxedValue;
	}
}