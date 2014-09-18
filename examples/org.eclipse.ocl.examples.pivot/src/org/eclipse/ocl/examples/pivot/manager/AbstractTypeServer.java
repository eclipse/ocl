/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import java.util.Iterator;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainFragment;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.AbstractFragment;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ReflectiveType;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.executor.PivotReflectiveFragment;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteClassImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteModelImpl;
import com.google.common.base.Function;

/**
 * An AbstractTypeServer provides the co-ordinated operation, property and superclass lookup caches for one or more merged types.
 */
public abstract class AbstractTypeServer extends ReflectiveType implements TypeServer
{

	public static final class BestOperation implements Function<List<DomainOperation>, DomainOperation> {

		public DomainOperation apply(List<DomainOperation> operations) {
			return operations.get(0);
		}
	}
	
	public static final @NonNull BestOperation bestOperation = new BestOperation();

	public static @NonNull TemplateParameterSubstitution createTemplateParameterSubstitution(@NonNull TemplateParameter formalParameter, @NonNull Type type) {
		TemplateParameterSubstitution templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
		templateParameterSubstitution.setFormal(formalParameter);
		templateParameterSubstitution.setActual(type);
		return templateParameterSubstitution;
	}

	protected final @NonNull CompleteClassImpl completeClass;
	protected final @NonNull CompletePackage completePackage;
	protected final @NonNull CompleteModelImpl completeModel;
	
	protected final @NonNull DomainType domainType;
	protected @Nullable TypeId typeId = null;

	protected AbstractTypeServer(@NonNull CompleteClassImpl completeClass, @NonNull DomainType domainType) {
		super(DomainUtil.nonNullModel(domainType.getName()), DomainUtil.nonNullModel(completeClass.getOwningCompletePackage().getPivotPackage()), computeFlags(domainType));
		this.completeClass = completeClass;
		this.completePackage = completeClass.getOwningCompletePackage();
		this.completeModel = completePackage.getCompleteModel();
		this.domainType = domainType;
		completeClass.setTypeServer(this);
	}

	@Override
	protected @NonNull AbstractFragment createFragment(@NonNull DomainInheritance baseInheritance) {
		return new PivotReflectiveFragment(this, baseInheritance);
	}

	@Override
	public void dispose() {
		completeClass.dispose();
	}

	public @NonNull CompleteClassImpl getCompleteClass() {
		return completeClass;
	}

	public @NonNull CompleteModelImpl getCompleteModel() {
		return completeModel;
	}

	@Override
	public @NonNull DomainFragment[] getFragments() {
		return super.getFragments();
	}

	@Override
	public @NonNull Iterable<? extends DomainInheritance> getInitialSuperInheritances() {
		return completeClass.getInitialSuperInheritances();
	}
	
	public @NonNull List<? extends DomainOperation> getLocalOperations() {
		return DomainUtil.nonNullEMF(getCompleteClass().getPivotClass().getOwnedOperations());			// FIXME Use local cache
	}

	public @NonNull List<? extends DomainProperty> getLocalProperties() {
		return DomainUtil.nonNullEMF(getCompleteClass().getPivotClass().getOwnedProperties());			// FIXME Use local cache
	}

	public @NonNull Iterable<? extends DomainClass> getSuperClasses() {
		return completeClass.getProperSuperClasses();
	}

	public @NonNull Iterable<? extends DomainOperation> getAllOperations(@Nullable FeatureFilter featureFilter) {
		return completeClass.getAllOperations(featureFilter);
	}

	public @NonNull Iterable<? extends DomainOperation> getAllOperations(@Nullable FeatureFilter featureFilter, @NonNull String name) {
		return completeClass.getAllOperations(featureFilter, name);
	}

	public @Nullable DomainOperation getMemberOperation(@NonNull DomainOperation pivotOperation) {
		return completeClass.getMemberOperation(pivotOperation);
	}

	public @Nullable Iterable<? extends DomainOperation> getOperationOverloads(@NonNull DomainOperation pivotOperation) {
		return completeClass.getOperationOverloads(pivotOperation);
	}

	public @NonNull Iterable<? extends DomainProperty> getAllProperties(@Nullable FeatureFilter featureFilter) {
		return completeClass.getAllProperties(featureFilter);
	}

	public @NonNull Iterable<? extends DomainProperty> getAllProperties(@Nullable FeatureFilter featureFilter, @NonNull String name) {
		return completeClass.getAllProperties(featureFilter, name);
	}

	@Override
	public @NonNull Iterable<String> getMemberOperationNames() {
		return completeClass.getMemberOperationNames();
	}

	@Override
	public @NonNull Iterable<DomainOperation> getMemberOperations() {
		return completeClass.getMemberOperations();
	}

	public @Nullable Iterable<? extends DomainProperty> getMemberProperties(@NonNull DomainProperty pivotProperty) {
		return completeClass.getMemberProperties(pivotProperty);
	}

	public @Nullable Iterator<DomainProperty> getMemberProperties(@NonNull String propertyName) {
		return completeClass.getMemberProperties(propertyName);
	}

	public @Nullable DomainProperty getMemberProperty(@NonNull String propertyName) {
		return completeClass.getMemberProperty(propertyName);
	}

	public @NonNull String getMetaTypeName() {
		return getCompleteClass().getPivotClass().getMetaTypeName();
	}

	public @NonNull List<? extends DomainProperty> getOwnedProperties() {
		return DomainUtil.nonNullEMF(getCompleteClass().getPivotClass().getOwnedProperties());			// FIXME Use local cache
	}
	
	public @NonNull List<? extends DomainOperation> getOwnedOperations() {
		return DomainUtil.nonNullEMF(getCompleteClass().getPivotClass().getOwnedOperations());			// FIXME Use local cache
	}

	public final @NonNull MetaModelManager getStandardLibrary() {
		return completeModel.getMetaModelManager();
	}
	
	@Override
	public final @NonNull TypeId getTypeId() {
		TypeId typeId2 = typeId;
		if (typeId2 == null) {
			typeId = typeId2 = domainType.getTypeId();
		}
		return typeId2;
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		return DomainTypeParameters.EMPTY_LIST;
	}

	@Override
	public void uninstall() {
//		System.out.println("uninstall " + toString());
		completeClass.uninstall();
		super.uninstall();
//		((CompletePackageImpl)completePackage).disposedTypeServer(this);
	}
}
