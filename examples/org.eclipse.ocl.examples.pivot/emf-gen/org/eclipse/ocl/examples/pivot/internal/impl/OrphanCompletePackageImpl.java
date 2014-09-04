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

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.OrphanCompletePackage;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.manager.OrphanTypeServer;
import org.eclipse.ocl.examples.pivot.manager.PrimitiveTypeServer;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Orphan Complete Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OrphanCompletePackageImpl extends RootCompletePackageImpl implements OrphanCompletePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrphanCompletePackageImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.ORPHAN_COMPLETE_PACKAGE;
	}

	/**
	 * Map from each primitive type name to the TypeServer that supervises its merge. 
	 */
	private final @NonNull Map<String, PrimitiveTypeServer> primitiveType2server = new HashMap<String, PrimitiveTypeServer>();

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitOrphanCompletePackage(this);
	}
	
	private @NonNull Map<DomainType, WeakReference<OrphanTypeServer>> servers = new WeakHashMap<DomainType, WeakReference<OrphanTypeServer>>();	
	
/*	public OrphanPackageServer(@NonNull PackageManager packageManager, @NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId) {
		super(packageManager, name, nsPrefix, nsURI, packageId, IdManager.METAMODEL);
	} */

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

	@Override
	public @Nullable CompleteClass getCompleteClass(String name) {
		throw new UnsupportedOperationException();			// FIXME lose unwanted inheritance
	}

	public @NonNull OrphanTypeServer getOrphanTypeServer(@NonNull org.eclipse.ocl.examples.pivot.Class orphanType) {
		CompleteClass completeClass = PivotFactory.eINSTANCE.createCompleteClass();
		completeClass.setName(orphanType.getName());
		completeClass.getPartialClasses().add(orphanType);
		getOwnedCompleteClasses().add(completeClass);
		OrphanTypeServer orphanTypeServer = new OrphanTypeServer(completeClass, orphanType);
		((CompleteClassImpl)completeClass).setTypeServer(orphanTypeServer);
		return orphanTypeServer;
	}

	@Override
	public @Nullable CompleteClass getOwnedCompleteClass(@NonNull String name) {
		PrimitiveTypeServer primitiveTypeServer = primitiveType2server.get(name);
		if (primitiveTypeServer != null) {
			return primitiveTypeServer.getCompleteClass();
		}
		return super.getOwnedCompleteClass(name);
	}

	public @NonNull PrimitiveTypeServer getPrimitiveTypeServer(@NonNull PrimitiveType primitiveType) {
		String name = primitiveType.getName();
		PrimitiveTypeServer primitiveTypeServer = primitiveType2server.get(name);
		if (primitiveTypeServer == null) {
			CompleteClass completeClass = PivotFactory.eINSTANCE.createCompleteClass();
			completeClass.setName(name);
			completeClass.getPartialClasses().add(primitiveType);
			getOwnedCompleteClasses().add(completeClass);
			primitiveTypeServer = new PrimitiveTypeServer(completeClass, primitiveType);
			((CompleteClassImpl)completeClass).setTypeServer(primitiveTypeServer);
			primitiveType2server.put(name, primitiveTypeServer);
		}
		return primitiveTypeServer;
	}

//	@Override
	public @NonNull TypeServer getTypeServer(/*@NonNull*/ DomainType type) {
		WeakReference<OrphanTypeServer> ref = servers.get(type);
		if (ref != null) {
			OrphanTypeServer orphanTypeServer = ref.get();
			if (orphanTypeServer != null) {
				return orphanTypeServer;
			}
		}
		OrphanTypeServer orphanTypeServer = getOrphanTypeServer((org.eclipse.ocl.examples.pivot.Class)type);	// FIXME cast
//		OrphanTypeServer orphanTypeServer = new OrphanTypeServer(this, (org.eclipse.ocl.examples.pivot.Class)type);	// FIXME cast
		servers.put(type, new WeakReference<OrphanTypeServer>(orphanTypeServer));
		return orphanTypeServer;
	}

	@Override
	public void init(@NonNull String name, @Nullable String nsPrefix,
			@Nullable String nsURI, @NonNull PackageId packageId,
			@NonNull PackageId metapackageId) {
		// TODO Auto-generated method stub
		super.init(name, nsPrefix, nsURI, packageId, metapackageId);
	}

	@Override
	public void init(@NonNull String name, @Nullable String nsPrefix,
			@Nullable String nsURI, @NonNull PackageId packageId) {
		// TODO Auto-generated method stub
		super.init(name, nsPrefix, nsURI, packageId);
	}
} //OrphanCompletePackageImpl
