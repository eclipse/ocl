/*******************************************************************************
 * Copyright (c) 2010,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA List) - Bug 424057 - UML 2.5 CG *******************************************************************************/
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.compatibility.UML_4_2;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.AbstractConversion;
import org.eclipse.ocl.examples.pivot.utilities.External2Pivot;

public abstract class AbstractEcore2Pivot extends AbstractConversion implements External2Pivot, PivotConstants
{
	protected AbstractEcore2Pivot(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
	}
	
	public abstract void addGenericType(@NonNull EGenericType eObject);

	public abstract void addMapping(@NonNull EObject eObject, @NonNull Element pivotElement);
	
	public abstract void error(@NonNull String message);

	public static @Nullable String getOriginalName(ENamedElement eNamedElement) {
		if (eNamedElement == null) {
			return null;
		}
		EAnnotation eAnnotation = eNamedElement.getEAnnotation(PivotConstants.REDEFINES_ANNOTATION_SOURCE);
		if (eAnnotation != null) {
			EObject eContainer = eNamedElement.eContainer();
			if (eContainer instanceof EAnnotation) {   // duplicates ... redefines
				List<EObject> eReferences = eAnnotation.getReferences();
				if ((eReferences != null) && (eReferences.size() > 0)) {
					EObject eObject = eReferences.get(0);
					if (eObject instanceof ENamedElement) {
						String originalName = getOriginalName((ENamedElement) eObject);
						return originalName;
					}
				}
			}
			else if (eContainer instanceof EClassifier) {
				String prefix = ((EClassifier)eContainer).getName() + "_";		// FIXME Bug 405061 workaround
				String originalName = UML_4_2.UMLUtil.getOriginalName(eNamedElement);
				if (originalName.startsWith(prefix)) {
					originalName = originalName.substring(prefix.length());
				}
				return originalName;
			}
		}
		String originalName = UML_4_2.UMLUtil.getOriginalName(eNamedElement);
		return originalName;
	}

	/**
	 * Return true if eOperation can be handled as an OCL invariant. In addition to the EcoreUtil.isInvariant()
	 * checks we also require either no GenModel documentation or a GenModel documentation with no additional
	 * content such as a Java body.
	 */
	public boolean isInvariant(@NonNull EOperation eOperation) {
		if (!EcoreUtil.isInvariant(eOperation)) {
			return false;
		}
		EAnnotation eAnnotation = eOperation.getEAnnotation(PivotConstants.DOCUMENTATION_ANNOTATION_SOURCE);
		if (eAnnotation != null) {
			@SuppressWarnings("null")@NonNull EMap<String, String> details = eAnnotation.getDetails();
			if ((details.size() != 1) ||  details.containsKey(PivotConstants.DOCUMENTATION_ANNOTATION_KEY)) {
				return false;
			}
		}
		return true;
	}

	public abstract void queueReference(@NonNull EObject eObject);

	public @NonNull <T extends NamedElement> T refreshElement(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @NonNull EModelElement eModelElement) {
		assert pivotEClass != null;
		EFactory eFactoryInstance = pivotEClass.getEPackage().getEFactoryInstance();
		EObject pivotElement = eFactoryInstance.create(pivotEClass);
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException();
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}

	public @NonNull <T extends NamedElement> T refreshNamedElement(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @NonNull ENamedElement eNamedElement) {
		T castElement = refreshElement(pivotClass, pivotEClass, eNamedElement);
		castElement.setName(getOriginalName(eNamedElement));
		return castElement;
	}
}