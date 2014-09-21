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

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.compatibility.UML_4_2.UMLUtil;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.AbstractIdResolver;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.uml.UML2PivotUtil;
import org.eclipse.ocl.examples.pivot.uml.UMLElementExtension;
import org.eclipse.uml2.uml.UMLPackage;

public class PivotIdResolver extends AbstractIdResolver
{
	private static final Logger logger = Logger.getLogger(PivotIdResolver.class);

	protected final @NonNull MetaModelManager metaModelManager;
	
	public PivotIdResolver(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager.getCompleteEnvironment());
		this.metaModelManager = metaModelManager;
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
	public @NonNull org.eclipse.ocl.examples.pivot.Class getClass(@NonNull TypeId typeId, @Nullable Object context) {
		DomainElement type = typeId.accept(this);
		assert type != null;
		return (org.eclipse.ocl.examples.pivot.Class)type;
	}

	@Override
	public @NonNull DomainClass getDynamicTypeOf(@Nullable Object value) {
		if (value instanceof org.eclipse.uml2.uml.Element) {
			DomainClass metaType = UML2PivotUtil.getMetaType(metaModelManager, (org.eclipse.uml2.uml.Element)value);
			if (metaType != null) {
				return metaType;
			}
		}
		else if (value instanceof UMLElementExtension) {
			org.eclipse.uml2.uml.Stereotype umlStereotype = ((UMLElementExtension)value).getDynamicStereotype();
			try {
				Stereotype asStereotype = metaModelManager.getPivotOf(Stereotype.class, umlStereotype);
				return asStereotype != null ? asStereotype : metaModelManager.getStandardLibrary().getOclInvalidType();
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.getDynamicTypeOf(value);
	}

	@Override
	public @NonNull DomainPackage visitRootPackageId(@NonNull RootPackageId id) {
		String completeURIorName = id.getName();
		DomainPackage rootPackage = standardLibrary.getRootPackage(completeURIorName);
		if (rootPackage == null) {
			Orphanage orphanage = metaModelManager.getCompleteModel().getOrphanage();
			rootPackage = DomainUtil.getNamedElement(orphanage.getOwnedPackages(), completeURIorName);
			if (rootPackage == null) {
				throw new UnsupportedOperationException();
			}
		}
		return rootPackage;
	}

	public @NonNull DomainInheritance getInheritance(@NonNull EClassifier eClassifier) {
		return metaModelManager.getInheritance(getType(eClassifier));
	}

	@Override
	public @NonNull DomainClass getStaticTypeOf(@Nullable Object value) {
		if (value instanceof org.eclipse.uml2.uml.Element) {
			try {				// FIXME Find a more efficient way to ensure Profiles are imported and applied
				org.eclipse.uml2.uml.Element umlElement = (org.eclipse.uml2.uml.Element)value;
				metaModelManager.getPivotOf(Element.class, umlElement); // Needed by test_stereotypes_Bug431638
				EClass umlEClass = umlElement.eClass();
				org.eclipse.ocl.examples.pivot.Class umlAStype = metaModelManager.getPivotOf(org.eclipse.ocl.examples.pivot.Class.class, umlEClass);
				if (umlAStype != null) {
					return umlAStype;
				}
				
			} catch (ParserException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			DomainClass metaType = UML2PivotUtil.getMetaType(metaModelManager, (org.eclipse.uml2.uml.Element)value);
			if (metaType != null) {
				return metaType;
			}
		}
		else if (value instanceof UMLElementExtension) {
			org.eclipse.uml2.uml.Stereotype umlStereotype = ((UMLElementExtension)value).getStaticStereotype();
			try {
				Stereotype asStereotype = metaModelManager.getPivotOf(Stereotype.class, umlStereotype);
				return asStereotype != null ? asStereotype : metaModelManager.getStandardLibrary().getOclInvalidType();
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			return ((UMLElementExtension)value).getStaticType();
		}
		else if (value instanceof ElementExtension) {
			Stereotype asStereotype = ((ElementExtension)value).getStereotype();
			return asStereotype != null ? asStereotype : metaModelManager.getStandardLibrary().getOclInvalidType();
		}
		return super.getStaticTypeOf(value);
	}

	@Override
	public @NonNull TupleType getTupleType(@NonNull TupleTypeId typeId) {
		TupleTypeManager tupleManager = metaModelManager.getCompleteModel().getTupleManager();
		return tupleManager.getTupleType(this, typeId);
	}

	public @NonNull org.eclipse.ocl.examples.pivot.Class getType(@NonNull EClassifier eClassifier) {
		EObject eType = eClassifier;
		EPackage ePackage = eClassifier.getEPackage();
		if (ePackage == UMLPackage.eINSTANCE) {
			// ?? getPivotOf to discover the pivoted type name, then getPivotType for the pivoted name
			String typeName = eClassifier.getName();
			if (typeName != null) {
				DomainPackage asMetamodel = metaModelManager.getASMetamodel();
				if (asMetamodel != null) {
					CompletePackage completePackage = metaModelManager.getCompletePackage(asMetamodel);
					org.eclipse.ocl.examples.pivot.Class pivotType = completePackage.getMemberType(typeName);
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
					CompletePackage completePackage = metaModelManager.getCompletePackage(asMetamodel);
					org.eclipse.ocl.examples.pivot.Class pivotType = completePackage.getMemberType(typeName);
					if (pivotType != null) {
						return pivotType;
					}
				}
			}
		}
		org.eclipse.ocl.examples.pivot.Class pivotType;
		try {
			pivotType = metaModelManager.getPivotOf(org.eclipse.ocl.examples.pivot.Class.class, eType);
			if (pivotType != null) {
				return metaModelManager.getPrimaryType(pivotType);
			}
		} catch (ParserException e) {
			logger.error("Failed to convert '" + eType + "'", e);
		}
//		return new DomainInvalidTypeImpl(standardLibrary, "No object created by Ecore2Pivot");
		return metaModelManager.getStandardLibrary().getOclInvalidType();
	}

	@Override
	public @NonNull Type getType(@NonNull TypeId typeId, @Nullable Object context) {
		DomainElement type = typeId.accept(this);
		assert type != null;
		return (Type)type;
	}

	@Override
	public @NonNull DomainPackage visitNsURIPackageId(@NonNull NsURIPackageId id) {
		String nsURI = id.getNsURI();
		DomainPackage nsURIPackage = standardLibrary.getNsURIPackage(nsURI);
		if (nsURIPackage == null) {
			metaModelManager.setAutoLoadASMetamodel(true);
			DomainPackage asMetamodel = metaModelManager.getASMetamodel();
			if ((asMetamodel != null) && PivotPackage.eNS_URI.equals(nsURI)) {
				return asMetamodel;
			}
			nsURIPackage = standardLibrary.getNsURIPackage(nsURI);
			if (nsURIPackage == null) {
				throw new UnsupportedOperationException();
			}
		}
		return nsURIPackage;
	}
}