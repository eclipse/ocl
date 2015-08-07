/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.as2cs;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.base.as2cs.BaseReferenceVisitor;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.basecs.TupleTypeCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.PathTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSFactory;
import org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS;

public class EssentialOCLReferenceVisitor extends BaseReferenceVisitor
{
	public static final Logger logger = Logger.getLogger(BaseReferenceVisitor.class);
	
	protected final @Nullable Namespace scope;

	public EssentialOCLReferenceVisitor(@NonNull AS2CSConversion context, @Nullable Namespace scope) {
		super(context);		// NB this class is stateless since separate instances exist per CS package
		this.scope = scope;
	}

	protected void importNamespaceFor(@NonNull Type type) {
		if (type instanceof TemplateableElement) {
			type = (Type) PivotUtil.getUnspecializedTemplateableElement((TemplateableElement)type);
		}
		org.eclipse.ocl.pivot.Package typePackage = PivotUtil.getPackage(type);
		if (typePackage != null) {
			Type scope = context.getScope();
			org.eclipse.ocl.pivot.Package scopePackage = scope != null ? PivotUtil.getPackage(scope) : null;
			if ( (scopePackage != null) && typePackage.eResource() != scopePackage.eResource()) {
				context.importNamespace(typePackage, null);
			}
		}
	}

	@Override
	public ElementCS visitAnyType(@NonNull AnyType object) {
		PrimitiveTypeRefCS csRef = BaseCSFactory.eINSTANCE.createPrimitiveTypeRefCS();
		csRef.setPivot(object);	
		csRef.setName(object.getName());
		return csRef;
	}

//	@Override
//	public ElementCS visitClass(@NonNull org.eclipse.ocl.pivot.Class object) {
//		return visitType(object);
//	}

	@Override
	public ElementCS visitCollectionType(@NonNull CollectionType asCollectionType) {
		CollectionTypeCS csCollectionType = EssentialOCLCSFactory.eINSTANCE.createCollectionTypeCS();
		csCollectionType.setPivot(asCollectionType);	
		csCollectionType.setName(asCollectionType.getName());
		Type elementType = asCollectionType.getElementType();
		if (elementType != null) {
			csCollectionType.setOwnedType((TypedRefCS) elementType.accept(this));
			importNamespaceFor(elementType);
		}
/*		boolean isNullFree ;
		int lower;
		int upper;
		if (asCollectionType.getUnspecializedElement() != context.getStandardLibrary().getCollectionType()) {		// FIXME != null ??
			isNullFree = asCollectionType.isIsNullFree();
			lower = asCollectionType.getLower().intValue();
			Number upper2 = asCollectionType.getUpper();
			upper = upper2 instanceof Unlimited ? -1 : upper2.intValue();
//			List<String> qualifiers = csCollectionType.getQualifiers();
//			refreshQualifiers(qualifiers, "ordered", "!ordered", asCollectionType.isOrdered() ? Boolean.TRUE : null);
//			refreshQualifiers(qualifiers, "unique", "!unique", asCollectionType.isUnique() ? null : Boolean.FALSE);
		}
		else {
			isNullFree = false;
			lower = /*asCollectionType.isIsRequired() ? 1 :* / 0;
			upper = 1;
		}
		if ((lower == 0) && (upper == 1)) {
//			csTypeRef.setOwnedMultiplicity(null);
		}
		else {
				String stringValue = null;
			if (lower == 0) {
				if (upper == 1) {
					stringValue = "?";
				}
				else if (upper == -1) {
					stringValue = "*";				
				}
	//			else if (upper == -2) {
	//				stringValue = "0..?";				
	//			}
			}
			else if (lower == 1) {
				if (upper == -1) {
					stringValue = "+";				
				}
			}
			if (stringValue != null) {
				csCollectionType.setStringBounds(stringValue);
				csCollectionType.setIsNullFree(isNullFree);;
			}
			else {
				if (lower != 1) {
					csCollectionType.setLowerBound(lower);
				}
				if (upper != 1) {
					csCollectionType.setUpperBound(upper);
				}
				csCollectionType.setIsNullFree(isNullFree);
			}
//		}
	} */
		return csCollectionType;
	}

	@Override
	public ElementCS visitInvalidType(@NonNull InvalidType object) {
		PrimitiveTypeRefCS csRef = BaseCSFactory.eINSTANCE.createPrimitiveTypeRefCS();
		csRef.setPivot(object);	
		csRef.setName(object.getName());
		return csRef;
	}

	@Override
	public ElementCS visitMapType(@NonNull MapType object) {
		MapTypeCS csRef = EssentialOCLCSFactory.eINSTANCE.createMapTypeCS();
		csRef.setPivot(object);	
		csRef.setName(object.getName());
		Type keyType = object.getKeyType();
		Type valueType = object.getValueType();
		if ((keyType != null) && (valueType != null)) {
			csRef.setOwnedKeyType((TypedRefCS) keyType.accept(this));
			csRef.setOwnedValueType((TypedRefCS) valueType.accept(this));
			importNamespaceFor(keyType);
			importNamespaceFor(valueType);
		}
		return csRef;
	}

	@Override
	public ElementCS visitPrimitiveType(@NonNull PrimitiveType object) {
		PrimitiveTypeRefCS csRef = BaseCSFactory.eINSTANCE.createPrimitiveTypeRefCS();
		csRef.setPivot(object);	
		csRef.setName(object.getName());
		return csRef;
	}

	@Override
	public ElementCS visitTupleType(@NonNull TupleType object) {
		TupleTypeCS csRef = BaseCSFactory.eINSTANCE.createTupleTypeCS();
		csRef.setPivot(object);	
//		csRef.setType(object.getElementType());		// FIXME parts
		return csRef;
	}

	@Override
	public ElementCS visitType(@NonNull Type object) {
//		TypeNameExpCS csRef = EssentialOCLCSFactory.eINSTANCE.createTypeNameExpCS();
		PathTypeCS csRef = BaseCSFactory.eINSTANCE.createPathTypeCS();
		csRef.setPivot(object);
//		csRef.setElement(object);
		PathNameCS csPathName = csRef.getOwnedPathName();
		if (csPathName == null) {
			csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			assert csPathName != null;
			csRef.setOwnedPathName(csPathName);
		}
		context.refreshPathName(csPathName, object, scope);
		importNamespaceFor(object);
		return csRef;
	}

	@Override
	public ElementCS visitVoidType(@NonNull VoidType object) {
		PrimitiveTypeRefCS csRef = BaseCSFactory.eINSTANCE.createPrimitiveTypeRefCS();
		csRef.setPivot(object);	
		csRef.setName(object.getName());
		return csRef;
	}
}