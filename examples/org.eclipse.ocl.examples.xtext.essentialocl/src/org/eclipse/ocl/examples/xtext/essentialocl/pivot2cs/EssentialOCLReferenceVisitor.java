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
package org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSFactory;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.BaseReferenceVisitor;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSFactory;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS;

public class EssentialOCLReferenceVisitor extends BaseReferenceVisitor
{
	public static final Logger logger = Logger.getLogger(BaseReferenceVisitor.class);

	public EssentialOCLReferenceVisitor(@NonNull Pivot2CSConversion context) {
		super(context);		// NB this class is stateless since separate instances exist per CS package
	}

	@Override
	public ElementCS visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		return visitType(object);
	}

	@Override
	public ElementCS visitCollectionType(@NonNull CollectionType object) {
		CollectionTypeCS csRef = EssentialOCLCSFactory.eINSTANCE.createCollectionTypeCS();
		csRef.setPivot(object);	
		csRef.setName(object.getName());
		Type elementType = object.getElementType();
		if (elementType != null) {
			csRef.setOwnedType((TypedRefCS) elementType.accept(this));
			org.eclipse.ocl.examples.pivot.Package typePackage = elementType.getPackage();
			if (typePackage != null) {
				context.importNamespace(typePackage, null);
			}
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
		TypeNameExpCS csRef = EssentialOCLCSFactory.eINSTANCE.createTypeNameExpCS();
		csRef.setPivot(object);
//		csRef.setElement(object);
		PathNameCS csPathName = csRef.getPathName();
		if (csPathName == null) {
			csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			assert csPathName != null;
			csRef.setPathName(csPathName);
		}
		context.refreshPathName(csPathName, object, null);
		org.eclipse.ocl.examples.pivot.Package typePackage = object.getPackage();
		if (typePackage != null) {
			context.importNamespace(typePackage, null);
		}
		return csRef;
	}
}