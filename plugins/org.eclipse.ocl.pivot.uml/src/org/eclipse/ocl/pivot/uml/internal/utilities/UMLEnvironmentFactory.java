/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.utilities;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DynamicElement;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.internal.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.library.ImplementationManager;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.uml.UMLStandaloneSetup;
import org.eclipse.ocl.pivot.uml.internal.library.UMLImplementationManager;
import org.eclipse.ocl.pivot.util.DerivedConstants;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;

public class UMLEnvironmentFactory extends PivotEnvironmentFactory
{
	/**
	 * Initializes me with an optional <code>StandaloneProjectMap</code> of accessible resources and
	 * an optional <code>ModelManager</code> for loaded instances.
	 */
	public UMLEnvironmentFactory(@Nullable ProjectManager projectManager) {
		super(projectManager);
		UMLStandaloneSetup.assertInitialized();
	}

	@Override
	public  @NonNull UMLIdResolver createIdResolver() {
		return new UMLIdResolver(this);
	}
	
	@Override
	public @NonNull ImplementationManager createImplementationManager() {
		return new UMLImplementationManager(this);
	}

	@Override
	public String getExtensionName(@NonNull Element asStereotypedElement) {
		String name = "????";
		if (asStereotypedElement instanceof NamedElement) {
			name = ((NamedElement)asStereotypedElement).getName();
		}
		else if (asStereotypedElement instanceof DynamicElement) {
			EObject eObject = ((DynamicElement)asStereotypedElement).getETarget();
			if (eObject instanceof org.eclipse.uml2.uml.NamedElement) {
				name = ((org.eclipse.uml2.uml.NamedElement)eObject).getName();
			}
		}
		return name;
	}

	@Override
	public RootPackageId getMetamodelId(@NonNull EPackage eObject2) {
		RootPackageId metamodel = null;
		if (ClassUtil.basicGetMetamodelAnnotation(eObject2) != null) {
			metamodel = IdManager.METAMODEL;
		}
		else if (eObject2 instanceof UMLPackage) {
			@SuppressWarnings("null")@NonNull String nsUri = UMLPackage.eNS_URI;
			getMetamodelManager().getCompleteModel().addPackageURI2completeURI(nsUri, PivotConstants.UML_METAMODEL_NAME);
			metamodel = IdManager.getRootPackageId(PivotConstants.UML_METAMODEL_NAME);
		}
		else if (eObject2 instanceof TypesPackage) {
			@SuppressWarnings("null")@NonNull String nsUri = TypesPackage.eNS_URI;
			getMetamodelManager().getCompleteModel().addPackageURI2completeURI(nsUri, PivotConstants.TYPES_METAMODEL_NAME);
			metamodel = IdManager.getRootPackageId(PivotConstants.TYPES_METAMODEL_NAME);
		}
		else {
			String nsURI = eObject2.getNsURI();
			String sharedNsURI = getMetamodelManager().getCompleteModel().getCompleteURI(nsURI);
			if ((sharedNsURI != null) && !sharedNsURI.equals(nsURI)) {
				metamodel = IdManager.getRootPackageId(sharedNsURI);
			}
		}
		return metamodel;
	}

	@Override
	public @NonNull PackageId getMetapackageId(@NonNull org.eclipse.ocl.pivot.Package asPackage) {
		if (asPackage instanceof PivotObjectImpl) {
			EObject eTarget = ((PivotObjectImpl)asPackage).getETarget();
			if (eTarget != null) {
				EClass eClass = eTarget.eClass();
				if (eClass != null) {
					EPackage ePackage = eClass.getEPackage();
					if (ePackage instanceof UMLPackage) {
						return IdManager.getRootPackageId(PivotConstants.UML_METAMODEL_NAME);
					}
					else if (ePackage instanceof TypesPackage) {
						return IdManager.getRootPackageId(PivotConstants.TYPES_METAMODEL_NAME);
					}
				}
			}
		}
		return super.getMetapackageId(asPackage);
	}

	@Override
	public @Nullable String getOriginalName(@NonNull ENamedElement eNamedElement) {
		EAnnotation eAnnotation = eNamedElement.getEAnnotation(PivotConstantsInternal.REDEFINES_ANNOTATION_SOURCE);
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
				String originalName = NameUtil.getOriginalName(eNamedElement);
				if (originalName.startsWith(prefix)) {
					originalName = originalName.substring(prefix.length());
				}
				return originalName;
			}
		}
		String originalName = NameUtil.getOriginalName(eNamedElement);
		return originalName;
	}

	@Override
	public @Nullable Element getParseableElement(@NonNull EObject eObject) throws ParserException {
		Element pivotElement;
		if (eObject instanceof Element) {
			return (Element) eObject;
		}
		PivotMetamodelManager metamodelManager = getMetamodelManager();
		pivotElement = metamodelManager.getASOf(Element.class, eObject);
		if ((eObject instanceof org.eclipse.uml2.uml.Constraint) && (pivotElement instanceof Constraint) && (pivotElement.eContainer() == null)) {
			pivotElement = metamodelManager.getASOf(Element.class, ((org.eclipse.uml2.uml.Constraint)eObject).getSpecification());
		}
		return pivotElement;
	}

	@Override
	public boolean isStereotype(@NonNull EClass eClass) {
		for (EStructuralFeature eFeature : eClass.getEAllStructuralFeatures()) {
			EClassifier eType = eFeature.getEType();
			if (eType != null) {
				EPackage ePackage = eType.getEPackage();
				if (ePackage == UMLPackage.eINSTANCE) {					// ?? is this too narrow ?? SysML ??
					String name = eFeature.getName();
					if ((name != null) && name.startsWith(DerivedConstants.STEREOTYPE_BASE_PREFIX)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
