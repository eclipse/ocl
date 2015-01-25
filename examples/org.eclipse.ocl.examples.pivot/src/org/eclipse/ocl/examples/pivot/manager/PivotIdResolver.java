/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.ExternalCrossReferencer;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.DomainConstants;
import org.eclipse.ocl.examples.domain.compatibility.UML_4_2.UMLUtil;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainRoot;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.DomainInvalidTypeImpl;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.AbstractIdResolver;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.uml.UML2PivotUtil;
import org.eclipse.ocl.examples.pivot.uml.UMLElementExtension;
import org.eclipse.ocl.examples.pivot.utilities.PivotObjectImpl;
import org.eclipse.uml2.uml.UMLPackage;

public class PivotIdResolver extends AbstractIdResolver
{
	private static final Logger logger = Logger.getLogger(PivotIdResolver.class);

	protected final @NonNull MetaModelManager metaModelManager;
	private final @NonNull Set<EObject> directRoots = new HashSet<EObject>();
	private boolean directRootsProcessed = false;
	private boolean crossReferencedRootsProcessed = false;

	/**
	 * Mapping from package URI to corresponding Pivot Package. (used to resolve NsURIPackageId).
	 */
	private final @NonNull Map<String, DomainPackage> nsURI2package = new HashMap<String, DomainPackage>();

	/**
	 * Mapping from root package name to corresponding Pivot Package. (used to resolve RootPackageId).
	 */
	private final @NonNull Map<String, DomainPackage> roots2package = new HashMap<String, DomainPackage>();
	
	public PivotIdResolver(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
		this.metaModelManager = metaModelManager;
	}

	private @NonNull DomainPackage addEPackage(@NonNull EPackage ePackage) {
		String nsURI = ePackage.getNsURI();
		DomainPackage asPackage = nsURI2package.get(nsURI);
		if (asPackage == null) {
			PackageId packageId = IdManager.getPackageId(ePackage);
			asPackage = metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Package.class, ePackage);
			assert asPackage != null;
			nsURI2package.put(nsURI, asPackage);
			if (packageId instanceof RootPackageId) {
				roots2package.put(((RootPackageId)packageId).getName(), asPackage);
			}
		}
		return asPackage;
	}

	private void addPackage(@NonNull DomainPackage userPackage) {
		String nsURI = userPackage.getNsURI();
		if (nsURI != null) {
			nsURI2package.put(nsURI, userPackage);
			EPackage ePackage = userPackage.getEPackage();
			if (ePackage != null) {
				if (DomainUtil.basicGetMetamodelAnnotation(ePackage) != null) {
					if (roots2package.get(DomainConstants.METAMODEL_NAME) == null) {
						roots2package.put(DomainConstants.METAMODEL_NAME, userPackage);
					}
				}
			}
			else {
				for (DomainType asType : userPackage.getOwnedType()) {
					if ("Boolean".equals(asType.getName())) {			// FIXME Check PrimitiveType //$NON-NLS-1$
						if (roots2package.get(DomainConstants.METAMODEL_NAME) == null) {
							roots2package.put(DomainConstants.METAMODEL_NAME, userPackage);
						}
						break;
					}
				}
			}
		}
		else {
			String name = userPackage.getName();
			if (name != null) {
				roots2package.put(name, userPackage);
			}
		}
		addPackages(userPackage.getNestedPackage());
	}

	private void addPackages(/*@NonNull*/ Iterable<? extends DomainPackage> userPackages) {
		for (DomainPackage userPackage : userPackages) {
			assert userPackage != null;
			addPackage(userPackage);
		}
	}

	@Override
	public @Nullable Object boxedValueOf(@Nullable Object unboxedValue) {
		if (unboxedValue instanceof org.eclipse.uml2.uml.EnumerationLiteral) {				// FIXME make extensible
			org.eclipse.uml2.uml.EnumerationLiteral umlEnumerationLiteral = (org.eclipse.uml2.uml.EnumerationLiteral) unboxedValue;
			try {
				EnumerationLiteral asEnumerationLiteral = metaModelManager.getPivotOf(EnumerationLiteral.class, umlEnumerationLiteral);
				if (asEnumerationLiteral != null) {
					return asEnumerationLiteral.getEnumerationLiteralId();
				}
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.boxedValueOf(unboxedValue);
	}

	@Override
	public @NonNull DomainType getDynamicTypeOf(@Nullable Object value) {
		if (value instanceof org.eclipse.uml2.uml.Element) {
			DomainType metaType = UML2PivotUtil.getMetaType(metaModelManager, (org.eclipse.uml2.uml.Element)value);
			if (metaType != null) {
				return metaType;
			}
		}
		else if (value instanceof UMLElementExtension) {
			org.eclipse.uml2.uml.Stereotype umlStereotype = ((UMLElementExtension)value).getDynamicStereotype();
			try {
				Stereotype asStereotype = metaModelManager.getPivotOf(Stereotype.class, umlStereotype);
				return asStereotype != null ? asStereotype : metaModelManager.getOclInvalidType();
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.getDynamicTypeOf(value);
	}

	@Override
	public @NonNull DomainType getStaticTypeOf(@Nullable Object value) {
		if (value instanceof org.eclipse.uml2.uml.Element) {
			try {				// FIXME Find a more efficient way to ensure Profiles are imported and applied
				org.eclipse.uml2.uml.Element umlElement = (org.eclipse.uml2.uml.Element)value;
				metaModelManager.getPivotOf(Element.class, umlElement); // Needed by test_stereotypes_Bug431638
				EClass umlEClass = umlElement.eClass();
				Type umlAStype = metaModelManager.getPivotOf(Type.class, umlEClass);
				if (umlAStype != null) {
					return umlAStype;
				}
				
			} catch (ParserException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			DomainType metaType = UML2PivotUtil.getMetaType(metaModelManager, (org.eclipse.uml2.uml.Element)value);
			if (metaType != null) {
				return metaType;
			}
		}
		else if (value instanceof UMLElementExtension) {
			org.eclipse.uml2.uml.Stereotype umlStereotype = ((UMLElementExtension)value).getStaticStereotype();
			try {
				Stereotype asStereotype = metaModelManager.getPivotOf(Stereotype.class, umlStereotype);
				return asStereotype != null ? asStereotype : metaModelManager.getOclInvalidType();
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			return ((UMLElementExtension)value).getStaticType();
		}
		return super.getStaticTypeOf(value);
	}

	@Override
	public @NonNull TupleType getTupleType(@NonNull TupleTypeId typeId) {
		TupleTypeManager tupleManager = metaModelManager.getTupleManager();
		return tupleManager.getTupleType(this, typeId);
	}

	@Override
	public @NonNull DomainType getType(@NonNull EClassifier eClassifier) {
		EObject eType = eClassifier;
		EPackage ePackage = eClassifier.getEPackage();
		if (ePackage == UMLPackage.eINSTANCE) {
			// ?? getPivotOf to discover the pivoted type name, then getPivotType for the pivoted name
			String typeName = eClassifier.getName();
			if (typeName != null) {
				DomainPackage asMetamodel = metaModelManager.getASMetamodel();
				if (asMetamodel != null) {
					PackageServer packageServer = metaModelManager.getPackageServer(asMetamodel);
					Type pivotType = packageServer.getMemberType(typeName);
					if (pivotType != null) {
						return pivotType;
					}
				}
			}
/*			URI umlMetaModelURI = URI.createURI(UMLResource.UML_METAMODEL_URI).appendFragment("/");
			EObject umlMetaPackage = metaModelManager.getExternalResourceSet().getEObject(umlMetaModelURI, true);		// FIXME cache me
			if (umlMetaPackage instanceof org.eclipse.uml2.uml.Package) {
				org.eclipse.uml2.uml.Type umlClassifier = ((org.eclipse.uml2.uml.Package)umlMetaPackage).getOwnedType(eClassifier.getName());
				if (umlClassifier != null) {
					eType = umlClassifier;
				}
			} */
		}
		else if ((ePackage.eContainer() instanceof EAnnotation) && (ePackage.eContainer().eContainer() instanceof org.eclipse.uml2.uml.Profile)) {
			org.eclipse.uml2.uml.Profile umlProfile = (org.eclipse.uml2.uml.Profile)ePackage.eContainer().eContainer();
			String stereotypeName = UMLUtil.getOriginalName(eClassifier);
			org.eclipse.uml2.uml.Stereotype umlStereotype = umlProfile.getOwnedStereotype(stereotypeName);
			try {
				Stereotype stereotype = metaModelManager.getPivotOf(Stereotype.class, umlStereotype);
				if (stereotype != null) {
					return stereotype;
				}
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ePackage == PivotPackage.eINSTANCE){
			String typeName = eClassifier.getName();
			if (typeName != null) {
				DomainPackage asMetamodel = metaModelManager.getASMetamodel();
				if (asMetamodel != null) {
					PackageServer packageServer = metaModelManager.getPackageServer(asMetamodel);
					Type pivotType = packageServer.getMemberType(typeName);
					if (pivotType != null) {
						return pivotType;
					}
				}
			}
		}
		Type pivotType;
		try {
			pivotType = metaModelManager.getPivotOf(Type.class, eType);
			if (pivotType != null) {
				return metaModelManager.getPrimaryType(pivotType);
			}
		} catch (ParserException e) {
			logger.error("Failed to convert '" + eType + "'", e);
		}
		return new DomainInvalidTypeImpl(standardLibrary, "No object created by Ecore2Pivot");
	}

	@Override
	public @NonNull Type getType(@NonNull TypeId typeId, @Nullable Object context) {
		DomainElement type = typeId.accept(this);
		if (type instanceof TemplateParameter) {
			type = ((TemplateParameter)type).getParameteredElement();
		}
		assert type != null;
		return (Type)type;
	}

	private synchronized void processCrossReferencedRoots() {
		if (crossReferencedRootsProcessed ) {
			return;
		}
		crossReferencedRootsProcessed = true;
		new ExternalCrossReferencer(directRoots)
		{
			private static final long serialVersionUID = 1L;
			
			private Set<EObject> moreRoots = new HashSet<EObject>();

			{ findExternalCrossReferences(); }

			@Override
			protected boolean crossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject) {
				EObject root = EcoreUtil.getRootContainer(crossReferencedEObject);
				if (moreRoots.add(root) && !directRoots.contains(root)) {
					if (root instanceof DomainRoot) {
						addPackages(((DomainRoot)root).getNestedPackage());
					}
					else if (root instanceof DomainPackage) {					// Perhaps this is only needed for a lazy JUnit test
						addPackage((DomainPackage)root);
					}
				}
				return false;
			}
		};
	}

	private synchronized void processDirectRoots() {
		if (directRootsProcessed) {
			return;
		}
		directRootsProcessed = true;
		Set<EPackage> ePackages = new HashSet<EPackage>();
		for (EObject eObject : directRoots) {
			if (eObject instanceof DomainRoot) {
				addPackages(((DomainRoot)eObject).getNestedPackage());
			}
//			else if (eObject instanceof DomainPackage) {							// Perhaps this is only needed for a lazy JUnit test
//				addPackage((DomainPackage)eObject);
//			}
			ePackages.add(eObject.eClass().getEPackage());
		}
		for (EPackage ePackage : ePackages) {
			if (ePackage !=null) {
				addEPackage(ePackage);
			}
		}
	}

	@Override
	public @Nullable Object unboxedValueOf(@Nullable Object boxedValue) {
		if (boxedValue instanceof EnumerationLiteralId) {
			DomainEnumerationLiteral enumerationLiteral = visitEnumerationLiteralId((EnumerationLiteralId)boxedValue);
			if (enumerationLiteral instanceof PivotObjectImpl) {
				EObject eTarget = ((PivotObjectImpl)enumerationLiteral).getETarget();
//				if (eTarget instanceof EEnumLiteral) {				// Ecore unboxes to the Enumerator
//					return ((EEnumLiteral)eTarget).getInstance();
//				}
//				else {												// UML unboxes to UML's EnumerationLiteral
					return eTarget;
//				}
			}
			else {
				return enumerationLiteral;
			}
		}
		else {
			return super.unboxedValueOf(boxedValue);
		}
	}

	public @NonNull Object unboxedValueOfUML(@NonNull EnumerationLiteralId enumerationLiteralId) {		// FIXME BUG 448470 UML EnumerationLiterals should consistently unboxed
		DomainEnumerationLiteral enumerationLiteral = (DomainEnumerationLiteral) enumerationLiteralId.accept(this);
		if (enumerationLiteral instanceof EnumerationLiteral) {
			EObject eTarget = ((EnumerationLiteral)enumerationLiteral).getETarget();
			if (eTarget != null) {
				return eTarget;
			}
		}
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull synchronized DomainPackage visitNsURIPackageId(@NonNull NsURIPackageId id) {
		String nsURI = id.getNsURI();
		DomainPackage nsURIPackage = metaModelManager.getNsURIPackage(nsURI);
		if (nsURIPackage != null) {
			return nsURIPackage;
		}
		metaModelManager.setAutoLoadASMetamodel(true);
		DomainPackage asMetamodel = metaModelManager.getASMetamodel();
		if ((asMetamodel != null) && PivotPackage.eNS_URI.equals(nsURI)) {
			return asMetamodel;
		}
		nsURIPackage = metaModelManager.getNsURIPackage(nsURI);
		if (nsURIPackage != null) {
			return nsURIPackage;
		}
		DomainPackage knownPackage = nsURI2package.get(nsURI);
		if (knownPackage != null) {
			return knownPackage;
		}
		DomainPackage libraryPackage = standardLibrary.getNsURIPackage(nsURI);
		if (libraryPackage != null) {
			nsURI2package.put(nsURI, libraryPackage);
			return libraryPackage;
		}
		if (!directRootsProcessed) {
			processDirectRoots();
			knownPackage = nsURI2package.get(nsURI);
			if (knownPackage != null) {
				return knownPackage;
			}
		}
		if (!crossReferencedRootsProcessed) {
			processCrossReferencedRoots();
			knownPackage = nsURI2package.get(nsURI);
			if (knownPackage != null) {
				return knownPackage;
			}
		}
		EPackage ePackage = id.getEPackage();
		if (ePackage != null) {
			DomainPackage asPackage = addEPackage(ePackage);
/*			EcoreReflectivePackage ecoreExecutorPackage = new EcoreReflectivePackage(ePackage, this, id);
//			EList<EClassifier> eClassifiers = ePackage.getEClassifiers();
//			EcoreReflectiveType[] types = new EcoreReflectiveType[eClassifiers.size()];
//			for (int i = 0; i < types.length; i++) {
//				types[i] = new EcoreReflectiveType(eClassifiers.get(i), ecoreExecutorPackage, 0);
//			}
//			ecoreExecutorPackage.init((ExecutorStandardLibrary) standardLibrary, types);
			nsURI2package.put(nsURI, ecoreExecutorPackage); */
			return asPackage;
		}
		throw new UnsupportedOperationException();
	}


	@Override
	public @NonNull DomainPackage visitRootPackageId(@NonNull RootPackageId id) {
		String completeURIorName = id.getName();
		DomainPackage rootPackage = standardLibrary.getRootPackage(completeURIorName);
		if (rootPackage == null) {
			Orphanage orphanage = metaModelManager.getOrphanage();
			rootPackage = DomainUtil.getNamedElement(orphanage.getNestedPackage(), completeURIorName);
			if (rootPackage == null) {
//				return super.visitRootPackageId(id);
				throw new UnsupportedOperationException();
			}
		}
		return rootPackage;
	}
}
