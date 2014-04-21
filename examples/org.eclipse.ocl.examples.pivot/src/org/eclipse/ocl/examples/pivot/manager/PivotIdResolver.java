/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.manager;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.DomainInvalidTypeImpl;
import org.eclipse.ocl.examples.library.executor.AbstractIdResolver;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.uml2.uml.UMLPackage;

public class PivotIdResolver extends AbstractIdResolver
{
	private static final Logger logger = Logger.getLogger(PivotIdResolver.class);

	protected final @NonNull MetaModelManager metaModelManager;
	
	public PivotIdResolver(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
		this.metaModelManager = metaModelManager;
	}

	@Override
	public @NonNull
	DomainType getStaticTypeOf(@Nullable Object value) {
		if (value instanceof org.eclipse.uml2.uml.Element) {
			try {				// FIXME Find a more efficient way to ensure Profiles are imported and applied
				metaModelManager.getPivotOf(Element.class, (org.eclipse.uml2.uml.Element)value);
			} catch (ParserException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
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

	@Override
	public @NonNull DomainPackage visitNsURIPackageId(@NonNull NsURIPackageId id) {
		String nsURI = id.getNsURI();
		DomainPackage nsURIPackage = metaModelManager.getNsURIPackage(nsURI);
		if (nsURIPackage == null) {
			metaModelManager.getASMetamodel();
			nsURIPackage = metaModelManager.getNsURIPackage(nsURI);
			if (nsURIPackage == null) {
				throw new UnsupportedOperationException();
			}
		}
		return nsURIPackage;
	}
}