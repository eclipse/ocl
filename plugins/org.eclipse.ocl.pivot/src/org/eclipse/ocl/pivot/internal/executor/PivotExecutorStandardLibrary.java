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
package org.eclipse.ocl.pivot.internal.executor;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.library.LibraryConstants;
import org.eclipse.ocl.pivot.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.library.executor.ExecutableStandardLibrary;
import org.eclipse.ocl.pivot.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;

public class PivotExecutorStandardLibrary extends ExecutableStandardLibrary
{
//	public static final PivotExecutorStandardLibrary INSTANCE = new PivotExecutorStandardLibrary(new MetamodelManager(), OCLstdlib.STDLIB_URI);

	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	private Map<Type, org.eclipse.ocl.pivot.Class> typeMap = null;
	private Map<org.eclipse.ocl.pivot.Package, org.eclipse.ocl.pivot.Package> packageMap = null;
	
//	public PivotExecutorStandardLibrary(EnvironmentFactory environmentFactory, String stdlibURI) {
//		this.metamodelManager = metamodelManager;
//		metamodelManager.setDefaultStandardLibraryURI(stdlibURI);
//		PivotTables.PACKAGE.getClass();
//	}

	public PivotExecutorStandardLibrary(EcoreExecutorPackage... execPackages) {
		OCLstdlibTables.PACKAGE.getClass();
		this.environmentFactory = (EnvironmentFactoryInternal) OCL.createEnvironmentFactory(null);
		environmentFactory.getStandardLibrary().setDefaultStandardLibraryURI(LibraryConstants.STDLIB_URI);
		PivotTables.PACKAGE.getClass();
	}
	
//	@Override
//	public @NonNull Evaluator createEvaluator(@NonNull EObject contextObject, @Nullable Map<Object, Object> contextMap) {
//		return new PivotEcoreExecutorManager(contextObject, contextMap, this, getMetamodelManager());
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
		return environmentFactory.getStandardLibrary().getClassType();
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getEnumerationType() {
		return environmentFactory.getStandardLibrary().getEnumerationType();
	}

	@Override
	public @NonNull CompleteInheritance getInheritance(@NonNull org.eclipse.ocl.pivot.Class type) {
		return environmentFactory.getMetamodelManager().getInheritance(type);
	}

	public @NonNull MetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	@Override
	public @Nullable org.eclipse.ocl.pivot.Package getNsURIPackage(@NonNull String nsURI) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Operation getOclInvalidOperation() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Type getOclType(@NonNull String typeName) {
		ExecutorType type = PivotTables.PACKAGE.getOwnedClass(typeName);
		return type != null ? type.getType() : null;
	}
	
	@SuppressWarnings("null")
	protected org.eclipse.ocl.pivot.Class getType(Type typeType) {
		if (typeType instanceof CollectionType) {
			CollectionType domainCollectionType = (CollectionType)typeType;
			return environmentFactory.getCompleteEnvironment().getCollectionType(domainCollectionType.getContainerType(), domainCollectionType.getElementType(), null, null);
		}
		if (typeMap == null) {
			typeMap = new HashMap<Type, org.eclipse.ocl.pivot.Class>();
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
		MetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		if (pivotPackage == null) {
			String nsURI = domainPackage.getURI();
			if (nsURI != null) {
				pivotPackage = metamodelManager.getPrimaryPackage(nsURI);
			}
			if (pivotPackage == null) {
				pivotPackage = createPackage(domainPackage);
			}
		}
		@NonNull CompletePackage completePackage = metamodelManager.getCompletePackage(pivotPackage);
		return completePackage.getMemberType(typeType.getName());
	}

	public @NonNull Type getType(@NonNull EClassifier eClassifier) {
		Ecore2AS ecore2as = Ecore2AS.getAdapter(ClassUtil.nonNullEMF(eClassifier.eResource()), environmentFactory);
		Type pivotType = ecore2as.getCreated(Type.class, eClassifier);
		return ClassUtil.nonNullState(pivotType);
	}
}
