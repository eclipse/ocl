/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.executor;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.LibraryConstants;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.examples.library.executor.ExecutableStandardLibrary;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManageable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;

public class PivotExecutorStandardLibrary extends ExecutableStandardLibrary implements MetaModelManageable
{
//	public static final PivotExecutorStandardLibrary INSTANCE = new PivotExecutorStandardLibrary(new MetaModelManager(), OCLstdlib.STDLIB_URI);

	protected final @NonNull MetaModelManager metaModelManager;
	private Map<DomainType, Type> typeMap = null;
	private Map<DomainPackage, org.eclipse.ocl.examples.pivot.Package> packageMap = null;
	
//	public PivotExecutorStandardLibrary(MetaModelManager metaModelManager, String stdlibURI) {
//		this.metaModelManager = metaModelManager;
//		metaModelManager.setDefaultStandardLibraryURI(stdlibURI);
//		PivotTables.PACKAGE.getClass();
//	}

	public PivotExecutorStandardLibrary(EcoreExecutorPackage... execPackages) {
		OCLstdlibTables.PACKAGE.getClass();
		this.metaModelManager = new MetaModelManager();
		metaModelManager.setDefaultStandardLibraryURI(LibraryConstants.STDLIB_URI);
		PivotTables.PACKAGE.getClass();
	}

	@Override
	protected @NonNull DomainMetaclass createMetaclass(@NonNull DomainType typeType) {
		Metaclass<?> metaclassType = getMetaclassType();
		Metaclass<?> metaclass = PivotFactory.eINSTANCE.createMetaclass();
		metaclass.setName(metaclassType.getName());
		metaclass.setUnspecializedElement(metaclassType);
		metaclass.setInstanceType(getType(typeType));
		return metaclass;
	}
	
//	@Override
//	public @NonNull DomainEvaluator createEvaluator(@NonNull EObject contextObject, @Nullable Map<Object, Object> contextMap) {
//		return new PivotEcoreExecutorManager(contextObject, contextMap, this, getMetaModelManager());
//	}

	protected @NonNull org.eclipse.ocl.examples.pivot.Package createPackage(@NonNull DomainPackage domainPackage) {
		org.eclipse.ocl.examples.pivot.Package pivotPackage = PivotFactory.eINSTANCE.createPackage();
		pivotPackage.setName(domainPackage.getName());
		pivotPackage.setNsURI(domainPackage.getNsURI());
		for (DomainType domainType : domainPackage.getOwnedType()) {
			if (domainType != null) {
				Type pivotType = createType(domainType);
				pivotPackage.getOwnedType().add(pivotType);
			}
		}
		return pivotPackage;
	}

	protected @NonNull Type createType(@NonNull DomainType domainType) {
		Type pivotType = PivotFactory.eINSTANCE.createType();
		pivotType.setName(domainType.getName());
		return pivotType;
	}

	public @NonNull org.eclipse.ocl.examples.pivot.Class getEnumerationType() {
		return metaModelManager.getEnumerationType();
	}

	public @NonNull Metaclass<?> getMetaclassType() {
		return metaModelManager.getMetaclassType();
	}

	public @NonNull DomainInheritance getInheritance(@NonNull DomainType type) {
		return metaModelManager.getInheritance(type);
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	public DomainType getOclType(@NonNull String typeName) {
		return PivotTables.PACKAGE.getType(typeName);
	}
	
	@SuppressWarnings("null")
	protected Type getType(DomainType typeType) {
		if (typeType instanceof DomainCollectionType) {
			DomainCollectionType domainCollectionType = (DomainCollectionType)typeType;
			return metaModelManager.getCollectionType(domainCollectionType.getContainerType(), domainCollectionType.getElementType(), null, null);
		}
		if (typeMap == null) {
			typeMap = new HashMap<DomainType, Type>();
		}
		else {			
			Type type = typeMap.get(typeType);
			if (type != null) {
				return type;
			}
		}
		if (packageMap == null) {
			packageMap = new HashMap<DomainPackage, org.eclipse.ocl.examples.pivot.Package>();
		}		
		DomainPackage domainPackage = typeType.getPackage();
		DomainPackage pivotPackage = packageMap.get(domainPackage);
		if (pivotPackage == null) {
			String nsURI = domainPackage.getNsURI();
			if (nsURI != null) {
				pivotPackage = metaModelManager.getPrimaryPackage(nsURI);
			}
			if (pivotPackage == null) {
				pivotPackage = createPackage(domainPackage);
			}
		}
		@NonNull PackageServer packageServer = metaModelManager.getPackageServer(pivotPackage);
		return packageServer.getMemberType(typeType.getName());
	}

	public @NonNull DomainType getType(@NonNull EClassifier eClassifier) {
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(DomainUtil.nonNullEMF(eClassifier.eResource()), metaModelManager);
		Type pivotType = ecore2Pivot.getCreated(Type.class, eClassifier);
		return DomainUtil.nonNullState(pivotType);
	}
}
