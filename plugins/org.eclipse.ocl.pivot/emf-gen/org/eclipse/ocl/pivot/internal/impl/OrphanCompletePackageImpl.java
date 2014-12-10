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
package org.eclipse.ocl.pivot.internal.impl;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainPackage;
import org.eclipse.ocl.domain.ids.IdManager;
import org.eclipse.ocl.domain.ids.PackageId;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.UnlimitedNaturalValue;
import org.eclipse.ocl.domain.values.impl.CollectionTypeParametersImpl;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OrphanCompletePackage;
import org.eclipse.ocl.pivot.PivotConstants;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteInheritanceInternal;
import org.eclipse.ocl.pivot.internal.complete.OrphanCompletePackageInternal;
import org.eclipse.ocl.pivot.manager.Orphanage;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Orphan Complete Package</b></em>'.
 * @extends org.eclipse.ocl.pivot.OrphanCompletePackageInternal
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OrphanCompletePackageImpl extends RootCompletePackageImpl implements OrphanCompletePackage, org.eclipse.ocl.pivot.internal.complete.OrphanCompletePackageInternal
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
		private final @NonNull OrphanCompletePackageInternal orphanCompletePackage;
//		private final @NonNull org.eclipse.ocl.pivot.Class orphanClass;
		
		private OrphanCompleteClassImpl(@NonNull OrphanCompletePackageInternal orphanCompletePackage, @NonNull org.eclipse.ocl.pivot.Class orphanClass) {
			this.orphanCompletePackage = orphanCompletePackage;
//			this.orphanClass = orphanClass;
		}
		
		@Override
		public OrphanCompletePackageInternal getOwningCompletePackage() {
			return orphanCompletePackage;
		}
	}
	
	private @NonNull Map<org.eclipse.ocl.pivot.Class, WeakReference<OrphanCompleteClassImpl>> class2orphanCompleteClass
		= new WeakHashMap<org.eclipse.ocl.pivot.Class, WeakReference<OrphanCompleteClassImpl>>();	
	
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

	public @NonNull <T extends CollectionType> T getCollectionType(@NonNull T containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
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
		org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal completeClass = getCompleteModel().getCompleteClass(containerType);
		@SuppressWarnings("unchecked")
		T specializedType = (T) getCompleteModel().getCollectionType(completeClass, new CollectionTypeParametersImpl<Type>(elementType, lower, upper));
		return specializedType;
	}

	@Override
	public @NonNull CompleteClassInternal getCompleteClass(@NonNull DomainClass type) {
		WeakReference<OrphanCompleteClassImpl> ref = class2orphanCompleteClass.get(type);
		if (ref != null) {
			OrphanCompleteClassImpl orphanCompleteClass = ref.get();
			if (orphanCompleteClass != null) {
				return orphanCompleteClass;
			}
		}
		final @NonNull org.eclipse.ocl.pivot.Class orphanClass = (org.eclipse.ocl.pivot.Class)type;	// FIXME cast
		OrphanCompleteClassImpl completeClass = new OrphanCompleteClassImpl(this, orphanClass);
		completeClass.setName(orphanClass.getName());
		completeClass.getPartialClasses().add(orphanClass);
		class2orphanCompleteClass.put(orphanClass, new WeakReference<OrphanCompleteClassImpl>(completeClass));
		return completeClass;
	}

	@Override
	public @NonNull CompleteInheritanceInternal getCompleteInheritance(@NonNull CompleteClassInternal completeClass) {
		return new CompleteInheritanceInternal(completeClass);
	}
	
	@Override
	public @NonNull PackageId getMetapackageId() {
		return IdManager.METAMODEL;
	}

	@Override
	public @Nullable CompleteClassInternal getOwnedCompleteClass(String name) {
		return null;			// No orphan CompleteClasses
	}
} //OrphanCompletePackageImpl
