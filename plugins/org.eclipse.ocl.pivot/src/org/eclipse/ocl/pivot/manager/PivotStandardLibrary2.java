/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.manager;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.DomainConstants;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainElement;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainOperation;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

public class PivotStandardLibrary2 extends PivotStandardLibrary
{
	protected final @NonNull CompleteModel.Internal completeModel;
	protected final @NonNull MetaModelManager metaModelManager;
	
	public PivotStandardLibrary2(@NonNull CompleteModel.Internal completeModel) {
		this.completeModel = completeModel;
		this.metaModelManager = completeModel.getMetaModelManager();
	}

	@Override
	public @NonNull Iterable<? extends CompletePackage> getAllCompletePackages() {
		return metaModelManager.getAllCompletePackages();
	}

	public @NonNull CompleteModel.Internal getCompleteModel() {
		return completeModel;
	}

	public @NonNull String getDefaultStandardLibraryURI() {
		return defaultStandardLibraryURI;
	}

	@Override
	@NonNull
	public DomainInheritance getInheritance(@NonNull DomainClass type) {
		return metaModelManager.getInheritance(type);
	}

	@Override
	public @NonNull DomainClass getMetaclass(@NonNull DomainType classType) {
		return metaModelManager.getMetaclass(classType);
	}

	@Override
	public DomainType getMetaType(@NonNull DomainType instanceType) {
		if (instanceType instanceof PrimitiveType) {
			return getPivotType(TypeId.PRIMITIVE_TYPE_NAME);
		}
//		throw new UnsupportedOperationException();
		return getMetaclass(instanceType);
	}

	@Override
	public org.eclipse.ocl.pivot.Package getNsURIPackage(@NonNull String nsURI) {
		CompletePackage completePackage = completeModel.getCompletePackageByURI(nsURI);
		return completePackage != null ? completePackage.getPivotPackage() : null;
	}

	@Override
	public DomainType getOclType(@NonNull String typeName) {
		return metaModelManager.getOclType(typeName);
	}

	@Override
	public @Nullable DomainElement getOperationTemplateParameter(@NonNull DomainOperation anOperation, int index) {
		if (anOperation instanceof Operation) {
			anOperation = PivotUtil.getUnspecializedTemplateableElement((Operation)anOperation);
		}
		return anOperation.getTypeParameters().get(index);
	}

	/**
	 * Return the pivot model class for className with the Pivot Model.
	 */
	public @Nullable org.eclipse.ocl.pivot.Class getPivotType(@NonNull String className) {
		return metaModelManager.getPivotType(className);
	}	

	@Override
	public @Nullable org.eclipse.ocl.pivot.Package getRootPackage(@NonNull String completeURIorName) {
		Package rootPackage = completeModel.getRootPackage(completeURIorName);
		if (rootPackage == null) {
			if (DomainConstants.METAMODEL_NAME.equals(completeURIorName)) {
				metaModelManager.getASMetamodel();
				rootPackage = completeModel.getRootPackage(completeURIorName);
			}
		}
		return rootPackage;
	}

	@Override
	protected @Nullable Resource loadDefaultLibrary(@Nullable String uri) {
		return metaModelManager.loadDefaultLibrary(uri);
	}

	public void setDefaultStandardLibraryURI(@NonNull String defaultStandardLibraryURI) {
		assert !PivotUtil.isASURI(defaultStandardLibraryURI);
		this.defaultStandardLibraryURI = defaultStandardLibraryURI;
	}
}