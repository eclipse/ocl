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
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.OrphanCompletePackage;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.internal.complete.OrphanPackageCompleteClasses;
import org.eclipse.ocl.examples.pivot.manager.OrphanTypeServer;
import org.eclipse.ocl.examples.pivot.manager.Orphanage;
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
	
	private static class OrphanCompleteClassImpl extends CompleteClassImpl
	{
		private final @NonNull CompletePackage orphanCompletePackage;
		private final @NonNull org.eclipse.ocl.examples.pivot.Class orphanClass;
		private OrphanTypeServer typeServer;
		
		private OrphanCompleteClassImpl(@NonNull CompletePackage orphanCompletePackage, @NonNull org.eclipse.ocl.examples.pivot.Class orphanClass) {
			this.orphanCompletePackage = orphanCompletePackage;
			this.orphanClass = orphanClass;
		}
		
		@Override
		public CompletePackage getOwningCompletePackage() {
			return orphanCompletePackage;
		}
		
		@Override
		public @NonNull OrphanTypeServer getTypeServer() {
			OrphanTypeServer typeServer2 = typeServer;
			if (typeServer2 == null) {
				typeServer = typeServer2 = new OrphanTypeServer(this, orphanClass);
			}
			return typeServer2;
		}
	}
	
	private @NonNull Map<org.eclipse.ocl.examples.pivot.Class, WeakReference<OrphanCompleteClassImpl>> class2orphanCompleteClass
		= new WeakHashMap<org.eclipse.ocl.examples.pivot.Class, WeakReference<OrphanCompleteClassImpl>>();	
	
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
	public void assertSamePackage(@Nullable DomainPackage domainPackage) {
		assert domainPackage != null;
		DomainPackage parentPackage = domainPackage.getOwningPackage();
		assert parentPackage == null;
		assert Orphanage.isTypeOrphanage(domainPackage);
	}

	@Override
	public @NonNull CompleteClass getCompleteClass(@NonNull DomainClass type) {
		WeakReference<OrphanCompleteClassImpl> ref = class2orphanCompleteClass.get(type);
		if (ref != null) {
			OrphanCompleteClassImpl orphanCompleteClass = ref.get();
			if (orphanCompleteClass != null) {
				return orphanCompleteClass;
			}
		}
		final @NonNull org.eclipse.ocl.examples.pivot.Class orphanClass = (org.eclipse.ocl.examples.pivot.Class)type;	// FIXME cast
		OrphanCompleteClassImpl completeClass = new OrphanCompleteClassImpl(this, orphanClass);
		completeClass.setName(orphanClass.getName());
		completeClass.getPartialClasses().add(orphanClass);
		class2orphanCompleteClass.put(orphanClass, new WeakReference<OrphanCompleteClassImpl>(completeClass));
		return completeClass;
	}
	
	public @NonNull PackageId getMetapackageId() {
		return IdManager.METAMODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull OrphanPackageCompleteClasses getOwnedCompleteClasses()
	{
		OrphanPackageCompleteClasses ownedCompleteClasses2 = (OrphanPackageCompleteClasses) ownedCompleteClasses;
		if (ownedCompleteClasses2 == null)
		{
			ownedCompleteClasses = ownedCompleteClasses2 = new OrphanPackageCompleteClasses(this);
		}
		return ownedCompleteClasses2;
	}

	@Override
	public @Nullable CompleteClass getOwnedCompleteClass(String name) {
		return null;			// No orphan CompleteClasses
	}
} //OrphanCompletePackageImpl
