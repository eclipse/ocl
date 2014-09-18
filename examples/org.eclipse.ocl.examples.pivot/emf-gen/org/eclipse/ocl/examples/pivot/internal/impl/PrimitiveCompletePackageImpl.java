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
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PrimitiveCompletePackage;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.internal.complete.PrimitivePackageCompleteClasses;
import org.eclipse.ocl.examples.pivot.manager.PrimitiveTypeServer;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Complete Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrimitiveCompletePackageImpl extends RootCompletePackageImpl implements PrimitiveCompletePackage
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
	
	private static class PrimitiveCompleteClassImpl extends CompleteClassImpl
	{
		private final @NonNull PrimitiveType primitiveType;
		private PrimitiveTypeServer typeServer;

		private PrimitiveCompleteClassImpl(@NonNull PrimitiveType primitiveType) {
			this.primitiveType = primitiveType;
		}

		@Override
		public @NonNull PrimitiveTypeServer getTypeServer() {
			PrimitiveTypeServer typeServer2 = typeServer;
			if (typeServer2 == null) {
				typeServer = typeServer2 = new PrimitiveTypeServer(this, primitiveType);
			}
			return typeServer2;
		}
	}

	protected PrimitiveCompletePackageImpl()
	{
		super();
		init("$primitives$", "prim", PivotConstants.PRIMITIVES_URI, IdManager.METAMODEL);		// FIXME names
//		name2completeClass = new HashMap<String, CompleteClass>();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitPrimitiveCompletePackage(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull PrimitivePackageCompleteClasses getOwnedCompleteClasses()
	{
		PrimitivePackageCompleteClasses ownedCompleteClasses2 = (PrimitivePackageCompleteClasses) ownedCompleteClasses;
		if (ownedCompleteClasses2 == null)
		{
			ownedCompleteClasses = ownedCompleteClasses2 = new PrimitivePackageCompleteClasses(this);
		}
		return ownedCompleteClasses2;
	}

	@Override
	public @NonNull CompleteClass getCompleteClass(final @NonNull DomainClass primitiveType) {
		throw new UnsupportedOperationException();			// Should be PrimitiveType
	}

	public @NonNull CompleteClass getCompleteClass(final @NonNull PrimitiveType primitiveType) {
		String name = primitiveType.getName();
		CompleteClass completeClass = getOwnedCompleteClass(name);
		if (completeClass == null) {
			completeClass = new PrimitiveCompleteClassImpl(primitiveType);
			completeClass.setName(name);
			getOwnedCompleteClasses().add(completeClass);
			completeClass.getPartialClasses().add(primitiveType);
//			didAddClass(completeClass, primitiveType);
		}
		return completeClass;
	}
	
	public @NonNull PackageId getMetapackageId() {
		return IdManager.METAMODEL;
	}

	@Override
	public Package getPivotPackage() {			// Only used to construct a PrimitiveTypeServer
		for (CompleteClass completeClass : getOwnedCompleteClasses()) {
			for (org.eclipse.ocl.examples.pivot.Class partialClass : completeClass.getPartialClasses()) {
				org.eclipse.ocl.examples.pivot.Package partialPackage = partialClass.getOwningPackage();
				if (partialPackage != null) {
					return partialPackage;
				}
			}
		}
		return null;
	}
} //PrimitiveCompletePackageImpl
