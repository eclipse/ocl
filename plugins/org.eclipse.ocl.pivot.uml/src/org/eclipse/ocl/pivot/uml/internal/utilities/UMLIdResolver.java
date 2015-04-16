package org.eclipse.ocl.pivot.uml.internal.utilities;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.internal.manager.PivotIdResolver;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.uml.internal.es2as.UML2ASUtil;
import org.eclipse.ocl.pivot.uml.internal.library.UMLElementExtension;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.uml2.uml.UMLPackage;

public class UMLIdResolver extends PivotIdResolver
{
//	private static final Logger logger = Logger.getLogger(UMLIdResolver.class);
	
	public UMLIdResolver(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
	}

	@Override
	public @Nullable Object boxedValueOf(@Nullable Object unboxedValue) {
		if (unboxedValue instanceof org.eclipse.uml2.uml.EnumerationLiteral) {				// FIXME make extensible
			org.eclipse.uml2.uml.EnumerationLiteral umlEnumerationLiteral = (org.eclipse.uml2.uml.EnumerationLiteral) unboxedValue;
			try {
				EnumerationLiteral asEnumerationLiteral = metamodelManager.getASOf(EnumerationLiteral.class, umlEnumerationLiteral);
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
	public @NonNull org.eclipse.ocl.pivot.Class getDynamicTypeOf(@Nullable Object value) {
		if (value instanceof org.eclipse.uml2.uml.Element) {
			org.eclipse.ocl.pivot.Class metaType = UML2ASUtil.getMetaType(metamodelManager.getEnvironmentFactory(), (org.eclipse.uml2.uml.Element)value);
			if (metaType != null) {
				return metaType;
			}
		}
		else if (value instanceof UMLElementExtension) {
			org.eclipse.uml2.uml.Stereotype umlStereotype = ((UMLElementExtension)value).getDynamicStereotype();
			try {
				Stereotype asStereotype = metamodelManager.getASOf(Stereotype.class, umlStereotype);
				return asStereotype != null ? asStereotype : metamodelManager.getStandardLibrary().getOclInvalidType();
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.getDynamicTypeOf(value);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value) {
		if (value instanceof org.eclipse.uml2.uml.Element) {
			try {				// FIXME Find a more efficient way to ensure Profiles are imported and applied
				org.eclipse.uml2.uml.Element umlElement = (org.eclipse.uml2.uml.Element)value;
				metamodelManager.getASOf(Element.class, umlElement); // Needed by test_stereotypes_Bug431638
				EClass umlEClass = umlElement.eClass();
				org.eclipse.ocl.pivot.Class umlAStype = metamodelManager.getASOf(org.eclipse.ocl.pivot.Class.class, umlEClass);
				if (umlAStype != null) {
					return umlAStype;
				}
				
			} catch (ParserException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			org.eclipse.ocl.pivot.Class metaType = UML2ASUtil.getMetaType(metamodelManager.getEnvironmentFactory(), (org.eclipse.uml2.uml.Element)value);
			if (metaType != null) {
				return metaType;
			}
		}
		else if (value instanceof UMLElementExtension) {
			org.eclipse.uml2.uml.Stereotype umlStereotype = ((UMLElementExtension)value).getStaticStereotype();
			try {
				Stereotype asStereotype = metamodelManager.getASOf(Stereotype.class, umlStereotype);
				return asStereotype != null ? asStereotype : metamodelManager.getStandardLibrary().getOclInvalidType();
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			return ((UMLElementExtension)value).getStaticType();
		}
		return super.getStaticTypeOf(value);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getType(@NonNull EClassifier eClassifier) {
		EPackage ePackage = eClassifier.getEPackage();
		if (ePackage == UMLPackage.eINSTANCE) {
			// ?? getPivotOf to discover the pivoted type name, then getPivotType for the pivoted name
			String typeName = eClassifier.getName();
			if (typeName != null) {
				org.eclipse.ocl.pivot.Package asMetamodel = metamodelManager.getASmetamodel();
				if (asMetamodel != null) {
					CompletePackage completePackage = metamodelManager.getCompletePackage(asMetamodel);
					org.eclipse.ocl.pivot.Class pivotType = completePackage.getMemberType(typeName);
					if (pivotType != null) {
						return pivotType;
					}
				}
			}
/*			URI umlMetamodelURI = URI.createURI(UMLResource.UML_METAMODEL_URI).appendFragment("/");
			EObject umlMetaPackage = metamodelManager.getExternalResourceSet().getEObject(umlMetamodelURI, true);		// FIXME cache me
			if (umlMetaPackage instanceof org.eclipse.uml2.uml.Package) {
				org.eclipse.uml2.uml.Type umlClassifier = ((org.eclipse.uml2.uml.Package)umlMetaPackage).getOwnedType(eClassifier.getName());
				if (umlClassifier != null) {
					eType = umlClassifier;
				}
			} */
		}
		else if ((ePackage.eContainer() instanceof EAnnotation) && (ePackage.eContainer().eContainer() instanceof org.eclipse.uml2.uml.Profile)) {
			org.eclipse.uml2.uml.Profile umlProfile = (org.eclipse.uml2.uml.Profile)ePackage.eContainer().eContainer();
			String stereotypeName = NameUtil.getOriginalName(eClassifier);
			org.eclipse.uml2.uml.Stereotype umlStereotype = umlProfile.getOwnedStereotype(stereotypeName);
			try {
				Stereotype stereotype = metamodelManager.getASOf(Stereotype.class, umlStereotype);
				if (stereotype != null) {
					return stereotype;
				}
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.getType(eClassifier);
	}

	@Override
	protected @NonNull String handlePivotlessEPackage(@NonNull EPackage ePackage) {
		if (ePackage.eContainer() instanceof EAnnotation) {
			return "EPackage " + ePackage.getName() + " : " + ePackage.getNsURI() + " has no Pivot counterpart.\nCheck that all UML packages have sensible URIs.";
		}
		else {
			return super.handlePivotlessEPackage(ePackage);
		}
	}
}
