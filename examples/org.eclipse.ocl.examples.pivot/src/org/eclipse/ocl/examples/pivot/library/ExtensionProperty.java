/*******************************************************************************
 * Copyright (c) 2011, 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.library;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.uml.UMLElementExtension;

/**
 * The static instance of ExplicitNavigationProperty supports evaluation of
 * a property call that navigates a relationship.
 */
public class ExtensionProperty extends AbstractProperty
{
	protected @NonNull Property property;
	
	public ExtensionProperty(@NonNull Property property) {
		this.property = property;
	}
	
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		DomainType staticType = property.getType();
		if (sourceValue instanceof org.eclipse.uml2.uml.Element) {
			if (staticType instanceof Stereotype) {
				return UMLElementExtension.getUMLElementExtension((Stereotype)staticType, (org.eclipse.uml2.uml.Element)sourceValue);
			}
		}
		Element element = null;
		if (sourceValue instanceof Element) {
			element = (Element)sourceValue;
		}
		else {
			try {
				element = ((MetaModelManager)evaluator.getStandardLibrary()).getPivotOf(Element.class, (EObject)sourceValue);
			} catch (ParserException e) {
				return new InvalidValueException(e, "Failed to parse " + property);
			}
		}
		if (element != null) {
			List<ElementExtension> selectedExtensions = null;
			for (ElementExtension elementExtension : element.getExtension()) {
				Stereotype dynamicStereotype = elementExtension.getStereotype();
				if (dynamicStereotype.conformsTo(evaluator.getStandardLibrary(), staticType)) {
					if (selectedExtensions == null) {
						selectedExtensions = new ArrayList<ElementExtension>();
					}
					selectedExtensions.add(elementExtension);
				}
			}
			if (selectedExtensions == null) {
				return null;
			}
			TypeId typeId = property.getTypeId();
			if (typeId instanceof CollectionTypeId) {
				return ValuesUtil.createSetValue((CollectionTypeId) typeId, selectedExtensions);
			}
			else if (selectedExtensions.size() == 1) {
				return selectedExtensions.get(0);
			}
			else {
				return new InvalidValueException("Multiple applied stereotypes for " + property);
			}
		}
		return staticType; 
	}
}