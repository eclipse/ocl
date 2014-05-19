/**
 * <copyright>
 *
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.uml;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * UMLElementExtension reifies the extension of a UML element by a Stereotype application as an EObject.
 */
public class UMLElementExtension extends DynamicEObjectImpl implements Adapter.Internal
{
	public static Object getUMLElementExtension(@NonNull IdResolver idResolver, @NonNull Stereotype staticType, @NonNull org.eclipse.uml2.uml.Element umlElement) {
		EObject eTarget = staticType.getETarget();
		if (eTarget instanceof org.eclipse.uml2.uml.Stereotype) {
			org.eclipse.uml2.uml.Stereotype umlAppliedStereotype = null;
			org.eclipse.uml2.uml.Stereotype umlRequiredStereotype = (org.eclipse.uml2.uml.Stereotype)eTarget;
			for (org.eclipse.uml2.uml.Stereotype appliedStereotype : umlElement.getAppliedStereotypes()) {
				if (appliedStereotype.conformsTo(umlRequiredStereotype)) {
					if (umlAppliedStereotype != null) {
						return new InvalidValueException("Ambiguous applied stereotype " + umlRequiredStereotype);
					}
					umlAppliedStereotype = appliedStereotype;
				}
			}
			if (umlAppliedStereotype == null) {
				return new InvalidValueException("No applied stereotype " + umlRequiredStereotype);
			}
			UMLElementExtension umlElementExtension = null;
			for (Adapter adapter : umlElement.eAdapters()) {
				if (adapter instanceof UMLElementExtension) {
					UMLElementExtension extensionsAdapter = (UMLElementExtension) adapter;
					if (extensionsAdapter.getStereotype() == umlAppliedStereotype) {
						umlElementExtension = extensionsAdapter;
						break;
					}
				}
			}
			if (umlElementExtension == null) {
				try {
					Stereotype dynamicType = ((MetaModelManager)idResolver.getStandardLibrary()).getPivotOf(Stereotype.class, umlAppliedStereotype);
					if (dynamicType != null) {
						umlElementExtension = new UMLElementExtension(umlElement, umlAppliedStereotype, staticType, dynamicType);
					}
					else {
						return new InvalidValueException("Unable to resolve stereotype " + umlRequiredStereotype);
					}
				} catch (ParserException e) {
					return new InvalidValueException(e, "Unable to resolve stereotype " + umlRequiredStereotype);
				}
			}
			return umlElementExtension;
		}
		return new InvalidValueException("Unable to resolve stereotype " + staticType);
	}

	protected final @NonNull org.eclipse.uml2.uml.Element umlElement;
	protected final @NonNull org.eclipse.uml2.uml.Stereotype umlStereotype;
	protected final @NonNull Stereotype staticType;
	protected final @NonNull Stereotype dynamicType;
	
	public UMLElementExtension(@NonNull org.eclipse.uml2.uml.Element umlElement, @NonNull org.eclipse.uml2.uml.Stereotype umlStereotype, @NonNull Stereotype staticType, @NonNull Stereotype dynamicType) {
		this.umlElement = umlElement;
		this.umlStereotype = umlStereotype;
		this.staticType = staticType;
		this.dynamicType = dynamicType;
		// setEClass() - not yet needed
		umlElement.eAdapters().add(this);
	}

	public @NonNull Stereotype getDynamicType() {
		return dynamicType;
	}

	public @NonNull Stereotype getStaticType() {
		return staticType;
	}

	public @NonNull org.eclipse.uml2.uml.Stereotype getStereotype() {
		return umlStereotype;
	}

	public @NonNull org.eclipse.uml2.uml.Element getTarget() {
		return umlElement;
	}

	public Object getValue(IdResolver idResolver, @NonNull Property property) {
		Object value = umlElement.getValue(umlStereotype, property.getName());
		if (property.isMany()) {
			if (value instanceof List<?>) {
				return idResolver.createCollectionOfAll((CollectionTypeId) property.getTypeId(), (List<?>)value);
			}
			else {
				throw new InvalidValueException("List value required for " + property);
			}
		}
		else {
			return idResolver.boxedValueOf(value);
		}
	}
	
	public boolean isAdapterForType(Object type) {
		return type == umlStereotype;
	}

	public void notifyChanged(Notification notification) {}

	public void setTarget(Notifier newTarget) {
		assert newTarget == umlElement;
	}

	public void unsetTarget(Notifier oldTarget) {
		assert oldTarget == umlElement;
	}
}