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
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.library.executor.CollectionTypeParameters;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.OrphanCompletePackage;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.internal.complete.OrphanPackageCompleteClasses;
import org.eclipse.ocl.examples.pivot.manager.CompleteInheritance;
import org.eclipse.ocl.examples.pivot.manager.OrphanInheritance;
import org.eclipse.ocl.examples.pivot.manager.Orphanage;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Orphan Complete Package</b></em>'.
 * @extends org.eclipse.ocl.examples.pivot.OrphanCompletePackage.Internal
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OrphanCompletePackageImpl extends RootCompletePackageImpl implements OrphanCompletePackage, org.eclipse.ocl.examples.pivot.OrphanCompletePackage.Internal
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
		private final @NonNull OrphanCompletePackage.Internal orphanCompletePackage;
		private final @NonNull org.eclipse.ocl.examples.pivot.Class orphanClass;
		
		private OrphanCompleteClassImpl(@NonNull OrphanCompletePackage.Internal orphanCompletePackage, @NonNull org.eclipse.ocl.examples.pivot.Class orphanClass) {
			this.orphanCompletePackage = orphanCompletePackage;
			this.orphanClass = orphanClass;
		}
		
		@Override
		public OrphanCompletePackage.Internal getOwningCompletePackage() {
			return orphanCompletePackage;
		}
		
		@Override
		public @NonNull CompleteInheritance getCompleteInheritance() {
			CompleteInheritance typeServer2 = completeInheritance;
			if (typeServer2 == null) {
				completeInheritance = typeServer2 = new OrphanInheritance(this, orphanClass);
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

	public @NonNull <T extends CollectionType> T getCollectionType(@NonNull T containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		assert containerType == PivotUtil.getUnspecializedTemplateableElement(containerType);
		TemplateSignature templateSignature = containerType.getOwnedTemplateSignature();
		if (templateSignature == null) {
			throw new IllegalArgumentException("Collection type must have a template signature");
		}
		List<TemplateParameter> templateParameters = templateSignature.getOwnedTemplateParameters();
		if (templateParameters.size() != 1) {
			throw new IllegalArgumentException("Collection type must have exactly one template parameter");
		}
		boolean isUnspecialized = elementType == templateParameters.get(0);
		if (isUnspecialized) {
			return containerType;	
		}
		org.eclipse.ocl.examples.pivot.CompleteClass.Internal completeClass = getCompleteModel().getCompleteClass(containerType);
		@SuppressWarnings("unchecked")
		T specializedType = (T) getCompleteModel().getCollectionType(completeClass, new CollectionTypeParameters<Type>(elementType, lower, upper));
		return specializedType;
	}

	@Override
	public @NonNull CompleteClass.Internal getCompleteClass(@NonNull DomainClass type) {
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
	public @Nullable CompleteClass.Internal getOwnedCompleteClass(String name) {
		return null;			// No orphan CompleteClasses
	}
} //OrphanCompletePackageImpl
