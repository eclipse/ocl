/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.locator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ConstrainingURI;
import org.eclipse.ocl.examples.emf.validation.validity.manager.TypeURI;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityModel;

public abstract class AbstractConstraintLocator implements ConstraintLocator, ConstraintLocator.Descriptor
{
	protected @NonNull Map<EObject, List<LeafConstrainingNode>> createLeafConstrainingNode(@Nullable Map<EObject, List<LeafConstrainingNode>> map,
			@NonNull ValidityModel validityModel, @NonNull EObject constrainingType, @NonNull Object constrainingObject, @NonNull String label) {
		LeafConstrainingNode constraint = validityModel.createLeafConstrainingNode();
		constraint.setConstraintLocator(this);
		constraint.setLabel(label);
		constraint.setConstrainingObject(constrainingObject);
		if (map == null) {
			map = new HashMap<EObject, List<LeafConstrainingNode>>();
		}
		List<LeafConstrainingNode> constraints = map.get(constrainingType);
		if (constraints == null) {
			constraints = new ArrayList<LeafConstrainingNode>();
			map.put(constrainingType, constraints);
		}
		constraints.add(constraint);
		return map;
	}

	public @NonNull Set<TypeURI> getAllTypes(@NonNull ValidityManager validityManager, @NonNull EObject constrainingObject) {
		Set<TypeURI> allTypes = new HashSet<TypeURI>();
		allTypes.add(validityManager.getTypeURI(constrainingObject));
		if (constrainingObject instanceof EClass) {
			for (EClass eSuperClass : ((EClass)constrainingObject).getEAllSuperTypes()) {
				if (eSuperClass != null) {
					allTypes.add(validityManager.getTypeURI(eSuperClass));
				}
			}
		}
		return allTypes;
	}

	@Override
	public @Nullable Set<ConstrainingURI> getConstrainingURIs(@NonNull ValidityManager validityManager, @NonNull EObject validatableObject) {
		return null;
	}

	public @NonNull ConstraintLocator getConstraintLocator() {
		return this;
	}

	public @Nullable Object getImage() {
		return null;
	}

	public @Nullable Collection<Resource> getImports(@NonNull EPackage ePackage, @NonNull Resource resource) {
		return null;
	}

	public @NonNull String getLabel(@NonNull EModelElement eObject) {
		StringBuilder s = new StringBuilder();
		if (eObject instanceof ENamedElement) {
			EObject eContainer = eObject.eContainer();
			if (eContainer instanceof ENamedElement) {
				s.append(((ENamedElement)eContainer).getName() + "::");
			}
			s.append(((ENamedElement)eObject).getName());
		}
		else {
			s.append(String.valueOf(eObject));
		}
		@SuppressWarnings("null") @NonNull String string = s.toString();
		return string;
	}

	protected @NonNull Severity getSeverity(@NonNull Diagnostic diagnostic) {
		Severity severity;
		switch (diagnostic.getSeverity()) {
			case Diagnostic.OK: severity = Severity.OK; break;
			case Diagnostic.INFO: severity = Severity.INFO; break;
			case Diagnostic.WARNING: severity = Severity.WARNING; break;
			case Diagnostic.ERROR: severity = Severity.ERROR; break;
			case Diagnostic.CANCEL: severity = Severity.FATAL; break;
			default: severity = Severity.UNKNOWN; break;
		}
		assert severity != null;
		return severity;
	}
	
	public @Nullable String getSourceExpression(@NonNull LeafConstrainingNode node) {
		return null;
	}

	public @Nullable Resource getSourceResource(@NonNull LeafConstrainingNode node) {
		return null;
	}

	public @Nullable URI getURI(@NonNull EObject eObject) {
		Resource resource = eObject.eResource();
		if (resource == null) {
			return null;
		}
		if (resource.getURI() == null) {
			return null;
		}
		return resource.getURI().appendFragment(resource.getURIFragment(eObject));
	}

	public void validate(@NonNull Result result, @NonNull ValidityManager validityManager, @Nullable Monitor monitor) {
		result.setDiagnostic("Unimplemented validate for " + getClass().getName());
		result.setSeverity(Severity.FATAL);
	}
}