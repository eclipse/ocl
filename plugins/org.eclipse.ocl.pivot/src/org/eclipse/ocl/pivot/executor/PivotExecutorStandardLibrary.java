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
package org.eclipse.ocl.pivot.executor;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.elements.DomainCollectionType;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.library.LibraryConstants;
import org.eclipse.ocl.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.library.executor.ExecutableStandardLibrary;
import org.eclipse.ocl.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ecore.Ecore2AS;
import org.eclipse.ocl.pivot.manager.MetaModelManageable;
import org.eclipse.ocl.pivot.manager.MetaModelManager;

public class PivotExecutorStandardLibrary extends ExecutableStandardLibrary implements MetaModelManageable
{
//	public static final PivotExecutorStandardLibrary INSTANCE = new PivotExecutorStandardLibrary(new MetaModelManager(), OCLstdlib.STDLIB_URI);

	protected final @NonNull MetaModelManager metaModelManager;
	private Map<DomainType, org.eclipse.ocl.pivot.Class> typeMap = null;
	private Map<org.eclipse.ocl.pivot.Package, org.eclipse.ocl.pivot.Package> packageMap = null;
	
//	public PivotExecutorStandardLibrary(MetaModelManager metaModelManager, String stdlibURI) {
//		this.metaModelManager = metaModelManager;
//		metaModelManager.setDefaultStandardLibraryURI(stdlibURI);
//		PivotTables.PACKAGE.getClass();
//	}

	public PivotExecutorStandardLibrary(EcoreExecutorPackage... execPackages) {
		OCLstdlibTables.PACKAGE.getClass();
		this.metaModelManager = new MetaModelManager();
		metaModelManager.getStandardLibrary().setDefaultStandardLibraryURI(LibraryConstants.STDLIB_URI);
		PivotTables.PACKAGE.getClass();
	}
	
//	@Override
//	public @NonNull DomainEvaluator createEvaluator(@NonNull EObject contextObject, @Nullable Map<Object, Object> contextMap) {
//		return new PivotEcoreExecutorManager(contextObject, contextMap, this, getMetaModelManager());
//	}

	protected @NonNull org.eclipse.ocl.pivot.Package createPackage(@NonNull org.eclipse.ocl.pivot.Package domainPackage) {
		org.eclipse.ocl.pivot.Package pivotPackage = PivotFactory.eINSTANCE.createPackage();
		pivotPackage.setName(domainPackage.getName());
		pivotPackage.setURI(domainPackage.getURI());
		for (org.eclipse.ocl.pivot.Class domainType : domainPackage.getOwnedClasses()) {
			if (domainType != null) {
				org.eclipse.ocl.pivot.Class pivotType = createType(domainType);
				pivotPackage.getOwnedClasses().add(pivotType);
			}
		}
		return pivotPackage;
	}

	protected @NonNull org.eclipse.ocl.pivot.Class createType(@NonNull org.eclipse.ocl.pivot.Class domainType) {
		org.eclipse.ocl.pivot.Class pivotType = PivotFactory.eINSTANCE.createClass();
		pivotType.setName(domainType.getName());
		return pivotType;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getClassType() {
		return metaModelManager.getStandardLibrary().getClassType();
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getEnumerationType() {
		return metaModelManager.getStandardLibrary().getEnumerationType();
	}

	@Override
	public @NonNull DomainInheritance getInheritance(@NonNull org.eclipse.ocl.pivot.Class type) {
		return metaModelManager.getInheritance(type);
	}

	@Override
	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	@Override
	public @NonNull Operation getOclInvalidOperation() {
		throw new UnsupportedOperationException();
	}

	@Override
	public DomainType getOclType(@NonNull String typeName) {
		return PivotTables.PACKAGE.getType(typeName).getType();
	}
	
	@SuppressWarnings("null")
	protected org.eclipse.ocl.pivot.Class getType(DomainType typeType) {
		if (typeType instanceof DomainCollectionType) {
			DomainCollectionType domainCollectionType = (DomainCollectionType)typeType;
			return metaModelManager.getCompleteEnvironment().getCollectionType(domainCollectionType.getContainerType(), domainCollectionType.getElementType(), null, null);
		}
		if (typeMap == null) {
			typeMap = new HashMap<DomainType, org.eclipse.ocl.pivot.Class>();
		}
		else {			
			org.eclipse.ocl.pivot.Class type = typeMap.get(typeType);
			if (type != null) {
				return type;
			}
		}
		if (packageMap == null) {
			packageMap = new HashMap<org.eclipse.ocl.pivot.Package, org.eclipse.ocl.pivot.Package>();
		}		
		org.eclipse.ocl.pivot.Package domainPackage = ((org.eclipse.ocl.pivot.Class)typeType).getOwningPackage();
		org.eclipse.ocl.pivot.Package pivotPackage = packageMap.get(domainPackage);
		if (pivotPackage == null) {
			String nsURI = domainPackage.getURI();
			if (nsURI != null) {
				pivotPackage = metaModelManager.getPrimaryPackage(nsURI);
			}
			if (pivotPackage == null) {
				pivotPackage = createPackage(domainPackage);
			}
		}
		@NonNull CompletePackage completePackage = metaModelManager.getCompletePackage(pivotPackage);
		return completePackage.getMemberType(typeType.getName());
	}

	public @NonNull DomainType getType(@NonNull EClassifier eClassifier) {
		Ecore2AS ecore2as = Ecore2AS.getAdapter(DomainUtil.nonNullEMF(eClassifier.eResource()), metaModelManager);
		Type pivotType = ecore2as.getCreated(Type.class, eClassifier);
		return DomainUtil.nonNullState(pivotType);
	}
}
