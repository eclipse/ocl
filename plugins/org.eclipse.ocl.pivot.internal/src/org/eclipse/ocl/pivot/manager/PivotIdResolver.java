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
package org.eclipse.ocl.pivot.manager;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.library.executor.AbstractIdResolver;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.compatibility.UML_4_2.UMLUtil;
import org.eclipse.ocl.pivot.ids.EnumerationLiteralId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.uml.UML2ASUtil;
import org.eclipse.ocl.pivot.uml.UMLElementExtension;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
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
	protected @NonNull org.eclipse.ocl.pivot.Package addEPackage(@NonNull EPackage ePackage) {
		String nsURI = ePackage.getNsURI();
		org.eclipse.ocl.pivot.Package asPackage = nsURI2package.get(nsURI);
		if (asPackage == null) {
			PackageId packageId = IdManager.getPackageId(ePackage);
			asPackage = metaModelManager.getPivotOfEcore(org.eclipse.ocl.pivot.Package.class, ePackage);
			assert asPackage != null;
			nsURI2package.put(nsURI, asPackage);
			if (packageId instanceof RootPackageId) {
				roots2package.put(((RootPackageId)packageId).getName(), asPackage);
			}
		}
		return asPackage;
	}

	@Override
	public @Nullable Object boxedValueOf(@Nullable Object unboxedValue) {
/*		if (unboxedValue instanceof org.eclipse.uml2.uml.EnumerationLiteral) {				// FIXME make extensible
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
		} */
		return super.boxedValueOf(unboxedValue);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getClass(@NonNull TypeId typeId, @Nullable Object context) {
		Element type = typeId.accept(this);
		assert type != null;
		return (org.eclipse.ocl.pivot.Class)type;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getDynamicTypeOf(@Nullable Object value) {
		if (value instanceof org.eclipse.uml2.uml.Element) {
			org.eclipse.ocl.pivot.Class metaType = UML2ASUtil.getMetaType(metaModelManager, (org.eclipse.uml2.uml.Element)value);
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
	public @NonNull CompleteInheritance getInheritance(@NonNull EClassifier eClassifier) {
		return metaModelManager.getInheritance(getType(eClassifier));
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value) {
		if (value instanceof org.eclipse.uml2.uml.Element) {
			try {				// FIXME Find a more efficient way to ensure Profiles are imported and applied
				org.eclipse.uml2.uml.Element umlElement = (org.eclipse.uml2.uml.Element)value;
				metaModelManager.getPivotOf(Element.class, umlElement); // Needed by test_stereotypes_Bug431638
				EClass umlEClass = umlElement.eClass();
				org.eclipse.ocl.pivot.Class umlAStype = metaModelManager.getPivotOf(org.eclipse.ocl.pivot.Class.class, umlEClass);
				if (umlAStype != null) {
					return umlAStype;
				}
				
			} catch (ParserException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			org.eclipse.ocl.pivot.Class metaType = UML2ASUtil.getMetaType(metaModelManager, (org.eclipse.uml2.uml.Element)value);
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

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getType(@NonNull EClassifier eClassifier) {
		EObject eType = eClassifier;
		EPackage ePackage = eClassifier.getEPackage();
		if (ePackage == UMLPackage.eINSTANCE) {
			// ?? getPivotOf to discover the pivoted type name, then getPivotType for the pivoted name
			String typeName = eClassifier.getName();
			if (typeName != null) {
				org.eclipse.ocl.pivot.Package asMetamodel = metaModelManager.getASMetamodel();
				if (asMetamodel != null) {
					CompletePackage completePackage = metaModelManager.getCompletePackage(asMetamodel);
					org.eclipse.ocl.pivot.Class pivotType = completePackage.getMemberType(typeName);
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
				org.eclipse.ocl.pivot.Package asMetamodel = metaModelManager.getASMetamodel();
				if (asMetamodel != null) {
					CompletePackage completePackage = metaModelManager.getCompletePackage(asMetamodel);
					org.eclipse.ocl.pivot.Class pivotType = completePackage.getMemberType(typeName);
					if (pivotType != null) {
						return pivotType;
					}
				}
			}
		}
		org.eclipse.ocl.pivot.Class pivotType;
		try {
			pivotType = metaModelManager.getPivotOf(org.eclipse.ocl.pivot.Class.class, eType);
			if (pivotType != null) {
				return metaModelManager.getPrimaryType(pivotType);
			}
		} catch (ParserException e) {
			logger.error("Failed to convert '" + eType + "'", e);
		}
//		return new DomainInvalidTypeImpl(standardLibrary, "No object created by Ecore2AS");
		return metaModelManager.getStandardLibrary().getOclInvalidType();
	}

	@Override
	public @NonNull Type getType(@NonNull TypeId typeId, @Nullable Object context) {
		Element type = typeId.accept(this);
		assert type != null;
		return (Type)type;
	}

	/**
	 * @since 3.5
	 */
	public @NonNull Object unboxedValueOfUML(@NonNull EnumerationLiteralId enumerationLiteralId) {		// FIXME BUG 448470 UML EnumerationLiterals should consistently unboxed
		EnumerationLiteral enumerationLiteral = (EnumerationLiteral) enumerationLiteralId.accept(this);
		if (enumerationLiteral != null) {
			EObject eTarget = enumerationLiteral.getETarget();
			if (eTarget != null) {
				return eTarget;
			}
		}
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public synchronized @NonNull org.eclipse.ocl.pivot.Package visitNsURIPackageId(@NonNull NsURIPackageId id) {
		String nsURI = id.getNsURI();
		org.eclipse.ocl.pivot.Package nsURIPackage = standardLibrary.getNsURIPackage(nsURI);
		if (nsURIPackage != null) {
			return nsURIPackage;
		}
		metaModelManager.setAutoLoadASMetamodel(true);
		org.eclipse.ocl.pivot.Package asMetamodel = metaModelManager.getASMetamodel();
		if ((asMetamodel != null) && PivotPackage.eNS_URI.equals(nsURI)) {
			return asMetamodel;
		}
		nsURIPackage = standardLibrary.getNsURIPackage(nsURI);
		if (nsURIPackage != null) {
			return nsURIPackage;
		}
		return super.visitNsURIPackageId(id);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Package visitRootPackageId(@NonNull RootPackageId id) {
		String completeURIorName = id.getName();
		org.eclipse.ocl.pivot.Package rootPackage = standardLibrary.getRootPackage(completeURIorName);
		if (rootPackage == null) {
			Orphanage orphanage = metaModelManager.getCompleteModel().getOrphanage();
			rootPackage = ClassUtil.getNamedElement(orphanage.getOwnedPackages(), completeURIorName);
			if (rootPackage == null) {
				throw new UnsupportedOperationException();
			}
		}
		return rootPackage;
	}
}
