/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.uml;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Stereotype;

/**
 * UMLElementExtension reifies the extension of a UML element by a Stereotype application as an EObject.
 */
public class UMLElementExtension extends DynamicEObjectImpl implements Adapter.Internal
{
	public static @Nullable Object /*UMLElementExtension*/ getUMLElementExtension(@NonNull Stereotype staticType, @NonNull org.eclipse.uml2.uml.Element umlElement) {
		EObject eTarget = staticType.getETarget();
		if (eTarget instanceof org.eclipse.uml2.uml.Stereotype) {
			org.eclipse.uml2.uml.Stereotype umlDynamicStereotype = null;
			org.eclipse.uml2.uml.Stereotype umlStaticStereotype = (org.eclipse.uml2.uml.Stereotype)eTarget;
			for (org.eclipse.uml2.uml.Stereotype appliedStereotype : umlElement.getAppliedStereotypes()) {
				if (appliedStereotype.conformsTo(umlStaticStereotype)) {
					if (umlDynamicStereotype != null) {
						throw new InvalidValueException("Ambiguous applied stereotype " + umlStaticStereotype);
					}
					umlDynamicStereotype = appliedStereotype;
				}
			}
			if (umlDynamicStereotype == null) {
				return null; //new InvalidValueException("No applied stereotype " + umlStaticStereotype);
			}
			UMLElementExtension umlElementExtension = null;
			for (Adapter adapter : umlElement.eAdapters()) {
				if (adapter instanceof UMLElementExtension) {
					UMLElementExtension extensionsAdapter = (UMLElementExtension) adapter;
					if (extensionsAdapter.getDynamicStereotype() == umlDynamicStereotype) {
						umlElementExtension = extensionsAdapter;
						break;
					}
				}
			}
			if (umlElementExtension == null) {
				umlElementExtension = new UMLElementExtension(umlElement, umlDynamicStereotype, umlStaticStereotype);
			}
			return umlElementExtension;
		}
		throw new InvalidValueException("Unable to resolve stereotype " + staticType);
	}

	protected final @NonNull org.eclipse.uml2.uml.Element umlElement;
	protected final @NonNull org.eclipse.uml2.uml.Stereotype umlDynamicStereotype;
	protected final @NonNull org.eclipse.uml2.uml.Stereotype umlStaticStereotype;
	
	public UMLElementExtension(@NonNull org.eclipse.uml2.uml.Element umlElement,
			@NonNull org.eclipse.uml2.uml.Stereotype umlDynamicStereotype,
			@NonNull org.eclipse.uml2.uml.Stereotype umlStaticStereotype) {
		this.umlElement = umlElement;
		this.umlDynamicStereotype = umlDynamicStereotype;
		this.umlStaticStereotype = umlStaticStereotype;
		// setEClass() - not yet needed
		umlElement.eAdapters().add(this);
	}

	public @NonNull org.eclipse.uml2.uml.Stereotype getDynamicStereotype() {
		return umlDynamicStereotype;
	}

	public @NonNull org.eclipse.uml2.uml.Stereotype getStaticStereotype() {
		return umlStaticStereotype;
	}

	public @NonNull org.eclipse.uml2.uml.Element getTarget() {
		return umlElement;
	}

	public Object getValue(IdResolver idResolver, @NonNull Property property) {
		Object value = umlElement.getValue(umlDynamicStereotype, property.getName());
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
		return type == umlDynamicStereotype;
	}

	public void notifyChanged(Notification notification) {}

	public void setTarget(Notifier newTarget) {
		assert newTarget == umlElement;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (umlElement instanceof org.eclipse.uml2.uml.NamedElement) {
			s.append(((org.eclipse.uml2.uml.NamedElement)umlElement).getName());
		}
		else {
			s.append("(");
			s.append(umlElement.eClass().getName());
			s.append(")");
		}
		s.append("«");
		s.append(umlDynamicStereotype.getName());
		if (umlDynamicStereotype != umlStaticStereotype) {
			s.append("(");
			s.append(umlStaticStereotype.getName());
			s.append(")");
		}
		s.append("»");
		return s.toString();
	}

	public void unsetTarget(Notifier oldTarget) {
		assert oldTarget == umlElement;
	}
}