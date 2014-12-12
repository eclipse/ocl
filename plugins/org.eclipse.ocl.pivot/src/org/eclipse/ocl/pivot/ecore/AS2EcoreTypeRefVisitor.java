/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA List) - Bug 424057 - UML 2.5 CG
 *******************************************************************************/
package org.eclipse.ocl.pivot.ecore;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.manager.PivotStandardLibrary;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

public class AS2EcoreTypeRefVisitor
	extends AbstractExtendingVisitor<EObject, AS2Ecore>
{
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull PivotStandardLibrary standardLibrary;
	
	public AS2EcoreTypeRefVisitor(@NonNull AS2Ecore context) {
		super(context);
		this.metaModelManager = context.getMetaModelManager();
		this.standardLibrary = context.getStandardLibrary();
	}

	public EGenericType resolveEGenericType(@NonNull org.eclipse.ocl.pivot.Class type) {
		EObject eType = safeVisit(type);
		if (eType instanceof EGenericType) {
			return (EGenericType) eType;
		}
		else {
			EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
			eGenericType.setEClassifier((EClassifier) eType);
			return eGenericType;
		}
	}

	@Override
	public EObject safeVisit(@Nullable Visitable v) {
		if (v instanceof Type) {
			v = metaModelManager.getPrimaryType((Type)v);
		}
		return (v == null) ? null : v.accept(this);
	}

	public <T extends EObject> void safeVisitAll(List<T> eObjects, List<? extends Element> pivotObjects) {
		for (Element pivotObject : pivotObjects) {
			@SuppressWarnings("unchecked")
			T eObject = (T) safeVisit(pivotObject);
			if (eObject != null) {
				eObjects.add(eObject);
			}
			// else error
		}
	}

	@Override
	public EClassifier visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for AS2Ecore TypeRef pass");
	}

	@Override
	public EObject visitAnyType(@NonNull AnyType object) {
		return OCLstdlibPackage.Literals.OCL_ANY;
	}

	@Override
	public EObject visitClass(@NonNull org.eclipse.ocl.pivot.Class pivotType) {
		if (pivotType.getOwnedTemplateBindings().size() == 0) {
			EClassifier eClassifier = context.getCreated(EClassifier.class, pivotType);
			if (eClassifier != null) {
				return eClassifier;
			}
			if (metaModelManager.isTypeServeable(pivotType)) {
				for (org.eclipse.ocl.pivot.Class type : metaModelManager.getPartialClasses(pivotType)) {
					if (type instanceof PivotObjectImpl) {
						EObject eTarget = ((PivotObjectImpl)type).getETarget();
						if (eTarget != null) {
							return eTarget;
						}
					}
				}
			}
			else {
				if (pivotType instanceof PivotObjectImpl) {
					EObject eTarget = ((PivotObjectImpl)pivotType).getETarget();
					if (eTarget != null) {
						return eTarget;
					}
				}
			}
			return null;	// FIXME may be null if not from Ecore
		}
		List<TemplateBinding> templateBindings = ((TemplateableElement)pivotType).getOwnedTemplateBindings();
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		EObject rawType = safeVisit(PivotUtil.getUnspecializedTemplateableElement((TemplateableElement)pivotType));
		eGenericType.setEClassifier((EClassifier) rawType);
		// FIXME signature ordering, multiple bindings
		safeVisitAll(eGenericType.getETypeArguments(), templateBindings.get(0).getOwnedTemplateParameterSubstitutions());
		return eGenericType;
	}

	@Override
	public EObject visitCollectionType(@NonNull CollectionType object) {
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		EClassifier eClassifier = EcoreUtils.getNamedElement(OCLstdlibPackage.eINSTANCE.getEClassifiers(), object.getName());
		eGenericType.setEClassifier(eClassifier);
		safeVisitAll(eGenericType.getETypeArguments(), object.getOwnedTemplateBindings().get(0).getOwnedTemplateParameterSubstitutions());
		// FIXME bounds, supers
		return eGenericType;
	}

	@Override
	public EObject visitInvalidType(@NonNull InvalidType object) {
		return OCLstdlibPackage.Literals.OCL_INVALID;
	}	

	@Override
	public EObject visitPrimitiveType(@NonNull PrimitiveType pivotType) {
		EDataType eClassifier = context.getCreated(EDataType.class, pivotType);
		if (eClassifier != null) {
			return eClassifier;
		}
		String uri = context.getPrimitiveTypesUriPrefix();
		if (uri != null) {
			URI proxyURI = URI.createURI(uri + pivotType.getName());
			eClassifier = EcoreFactory.eINSTANCE.createEDataType();
			((InternalEObject) eClassifier).eSetProxyURI(proxyURI);
			context.putCreated(pivotType, eClassifier);
			return eClassifier;
		}
		CompleteClass completeClass = metaModelManager.getCompleteClass(pivotType);
		for (org.eclipse.ocl.pivot.Class aType : completeClass.getPartialClasses()) {
			if (!(aType instanceof PrimitiveType)) {
				eClassifier = context.getCreated(EDataType.class, pivotType);
				if (eClassifier != null) {
					return eClassifier;
				}
			}
		}
		if (pivotType == standardLibrary.getBooleanType()) {
			return EcorePackage.Literals.EBOOLEAN;
		}
		else if (pivotType == standardLibrary.getIntegerType()) {
			return EcorePackage.Literals.EBIG_INTEGER;
		}
		else if (pivotType == standardLibrary.getRealType()) {
			return EcorePackage.Literals.EBIG_DECIMAL;
		}
		else if (pivotType == standardLibrary.getStringType()) {
			return EcorePackage.Literals.ESTRING;
		}
		else if (pivotType == standardLibrary.getUnlimitedNaturalType()) {
			return EcorePackage.Literals.EBIG_INTEGER;
		}
		else {
			throw new IllegalArgumentException("Unsupported primitive type '" + pivotType + "' in AS2Ecore TypeRef pass");
		}
	}

	@Override
	public EObject visitTemplateBinding(@NonNull TemplateBinding object) {
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		return eGenericType;
	}

	@Override
	public EObject visitTemplateParameter(@NonNull TemplateParameter pivotType) {
		ETypeParameter eTypeParameter = context.getCreated(ETypeParameter.class, pivotType);
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericType.setETypeParameter(eTypeParameter);
		return eGenericType;
	}

	@Override
	public EObject visitTemplateParameterSubstitution(@NonNull TemplateParameterSubstitution pivotTemplateParameterSubstitution) {
		EObject actualType = safeVisit(pivotTemplateParameterSubstitution.getActual());
		if (actualType instanceof EGenericType) {
			return actualType;
		}
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericType.setEClassifier((EClassifier) actualType);
		return eGenericType;
	}

//	@Override
//	public EObject visitTupleType(@NonNull TupleType object) {
//		return getOCLstdlibType(/*TypeId.OCL_VOID_NAME*/"OclTuple", object);
//	}	

	@Override
	public EObject visitVoidType(@NonNull VoidType object) {
		return OCLstdlibPackage.Literals.OCL_VOID;
	}	
}
