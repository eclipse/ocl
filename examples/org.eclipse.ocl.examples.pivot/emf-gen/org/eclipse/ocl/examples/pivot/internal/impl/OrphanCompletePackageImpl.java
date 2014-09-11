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
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.OrphanCompletePackage;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.manager.OrphanTypeServer;
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
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.ORPHAN_COMPLETE_PACKAGE;
	}
	
	private @NonNull Map<DomainType, WeakReference<OrphanTypeServer>> servers = new WeakHashMap<DomainType, WeakReference<OrphanTypeServer>>();	
	
	protected OrphanCompletePackageImpl()
	{
		super();
		init("$orphans$", "orph", PivotConstants.ORPHANAGE_URI, IdManager.METAMODEL);		// FIXME names
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitOrphanCompletePackage(this);
	}

	@Override
	protected void didAddCompleteClass(@NonNull CompleteClass completeClass) {
		/* No orphan CompleteClasses */
	}

	@Override
	protected void didAddPartialPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		/* No orphan CompleteClasses */
	}

	@Override
	protected void didRemoveCompleteClass(@NonNull CompleteClass completeClass) {
		/* No orphan CompleteClasses */
	}

	@Override
	protected void didRemovePartialPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		/* No orphan CompleteClasses */
	}
	
	public @NonNull PackageId getMetapackageId() {
		return IdManager.METAMODEL;
	}

	@Override
	public @Nullable CompleteClass getOwnedCompleteClass(String name) {
		return null;			// No orphan CompleteClasses
	}

	@Override
	public @NonNull TypeServer getTypeServer(/*@NonNull*/ DomainType type) {
		WeakReference<OrphanTypeServer> ref = servers.get(type);
		if (ref != null) {
			OrphanTypeServer orphanTypeServer = ref.get();
			if (orphanTypeServer != null) {
				return orphanTypeServer;
			}
		}
		@NonNull org.eclipse.ocl.examples.pivot.Class orphanClass = (org.eclipse.ocl.examples.pivot.Class)type;	// FIXME cast
		CompleteClass completeClass = new CompleteClassImpl()
		{
			@Override
			public CompletePackage getOwningCompletePackage() {
				return OrphanCompletePackageImpl.this;
			}
		};
		completeClass.setName(orphanClass.getName());
		completeClass.getPartialClasses().add(orphanClass);
//		getOwnedCompleteClasses().add(completeClass);
		OrphanTypeServer orphanTypeServer = new OrphanTypeServer(completeClass, orphanClass);
		((CompleteClassImpl)completeClass).setTypeServer(orphanTypeServer);
		servers.put(type, new WeakReference<OrphanTypeServer>(orphanTypeServer));
		return orphanTypeServer;
	}
} //OrphanCompletePackageImpl
