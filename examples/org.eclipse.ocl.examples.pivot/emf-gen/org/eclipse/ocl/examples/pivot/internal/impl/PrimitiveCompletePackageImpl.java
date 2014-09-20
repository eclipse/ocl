/**
 * Copyright (c) 2010,2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PrimitiveCompletePackage;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Complete Package</b></em>'.
 * @extends org.eclipse.ocl.examples.pivot.PrimitiveCompletePackage.Internal
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrimitiveCompletePackageImpl extends RootCompletePackageImpl implements PrimitiveCompletePackage, org.eclipse.ocl.examples.pivot.PrimitiveCompletePackage.Internal
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.PRIMITIVE_COMPLETE_PACKAGE;
	}

	protected PrimitiveCompletePackageImpl()
	{
		super();
		init("$primitives$", "prim", PivotConstants.PRIMITIVES_URI, IdManager.METAMODEL);		// FIXME names
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitPrimitiveCompletePackage(this);
	}

	@Override
	public @NonNull CompleteClass.Internal getCompleteClass(final @NonNull DomainClass primitiveType) {
		String name = primitiveType.getName();
		CompleteClass.Internal completeClass = getOwnedCompleteClass(name);
		if (completeClass == null) {
			completeClass = (CompleteClass.Internal)PivotFactory.eINSTANCE.createCompleteClass();
			completeClass.setName(name);
			getOwnedCompleteClasses().add(completeClass);
			completeClass.getPartialClasses().add((PrimitiveType)primitiveType);
//			didAddClass(completeClass, primitiveType);
		}
		return completeClass;
	}
	
	public @NonNull PackageId getMetapackageId() {
		return IdManager.METAMODEL;
	}
} //PrimitiveCompletePackageImpl
