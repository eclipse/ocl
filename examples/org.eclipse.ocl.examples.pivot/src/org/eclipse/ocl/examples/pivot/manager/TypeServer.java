/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * A TypeServer serves coordinated behavior of one or more
 * merged Types as required for Complete OCL type extension.
 */
public interface TypeServer extends DomainInheritance 
{
	void dispose();
	@NonNull Iterable<? extends State>  getAllStates();
	@NonNull Iterable<? extends State>  getAllStates(@NonNull String name);
	@NonNull Iterable<? extends DomainInheritance> getAllSuperClasses();
	@NonNull Iterable<? extends DomainInheritance> getAllSuperClasses(@NonNull String className);
	@NonNull Iterable<? extends DomainOperation> getAllOperations(@Nullable FeatureFilter featureFilter);
	@NonNull Iterable<? extends DomainOperation> getAllOperations(@Nullable FeatureFilter featureFilter, @NonNull String name);
	@NonNull Iterable<? extends DomainProperty> getAllProperties(@Nullable FeatureFilter featureFilter);
	@NonNull Iterable<? extends DomainProperty> getAllProperties(@Nullable FeatureFilter featureFilter, @NonNull String name);
	@Nullable DomainOperation getMemberOperation(@NonNull DomainOperation pivotOperation);
	@Nullable Iterable<? extends DomainOperation> getMemberOperations(@NonNull DomainOperation pivotOperation);
	@Nullable Iterable<? extends DomainProperty> getMemberProperties(@NonNull DomainProperty pivotProperty);
	@Nullable Iterator<DomainProperty> getMemberProperties(@NonNull String propertyName);
	@Nullable DomainProperty getMemberProperty(@NonNull String propertyName);
	@NonNull Iterable<? extends DomainType> getPartialTypes();
	
	/**
	 * Return a Type that represents this type merge.
	 */
	@NonNull Type getPivotType();
}
