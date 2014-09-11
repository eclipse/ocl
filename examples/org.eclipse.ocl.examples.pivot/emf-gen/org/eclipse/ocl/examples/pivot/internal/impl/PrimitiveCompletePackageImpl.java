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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PrimitiveCompletePackage;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
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

	/**
	 * Map from each primitive type name to the TypeServer that supervises its merge. 
	 */
	private final @NonNull Map<String, PrimitiveTypeServer> primitiveType2server = new HashMap<String, PrimitiveTypeServer>();

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
	protected void didAddCompleteClass(@NonNull CompleteClass completeClass) {			// FIXME lose unwanted inheritance
	}

	@Override
	protected void didAddPartialPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {			// FIXME lose unwanted inheritance
	}

	@Override
	protected void didRemoveCompleteClass(@NonNull CompleteClass completeClass) {			// FIXME lose unwanted inheritance
	}

	@Override
	protected void didRemovePartialPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {			// FIXME lose unwanted inheritance
	}
	
	public @NonNull PackageId getMetapackageId() {
		return IdManager.METAMODEL;
	}

	@Override
	public @Nullable CompleteClass getOwnedCompleteClass(String name) {
		PrimitiveTypeServer primitiveTypeServer = primitiveType2server.get(name);
		if (primitiveTypeServer != null) {
			return primitiveTypeServer.getCompleteClass();
		}
		return null;
	}

	public @NonNull PrimitiveTypeServer getTypeServer(@NonNull PrimitiveType primitiveType) {
		String name = primitiveType.getName();
		PrimitiveTypeServer primitiveTypeServer = primitiveType2server.get(name);
		if (primitiveTypeServer == null) {
			CompleteClass completeClass = PivotFactory.eINSTANCE.createCompleteClass();
			completeClass.setName(name);
			completeClass.getPartialClasses().add(primitiveType);
			getOwnedCompleteClasses().add(completeClass);
			org.eclipse.ocl.examples.pivot.Package primitivePackage = primitiveType.getOwningPackage();
			if (primitivePackage != null) {
				getPartialPackages().add(primitivePackage);
			}
			primitiveTypeServer = new PrimitiveTypeServer(completeClass, primitiveType);
			((CompleteClassImpl)completeClass).setTypeServer(primitiveTypeServer);
			primitiveType2server.put(name, primitiveTypeServer);
			primitiveTypeServer.getTypeTracker(primitiveType);
		}
		return primitiveTypeServer;
	}
} //PrimitiveCompletePackageImpl
