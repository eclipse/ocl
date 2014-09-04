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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.PrimitiveType;

/**
 * An ExtensibleTypeServer supports one or more merged types as the source for operations, properties or superclasses.
 */
public abstract class ExtensibleTypeServer extends AbstractTypeServer
{	
	private final @NonNull List<TypeTracker> trackers = new ArrayList<TypeTracker>();
	
	/**
	 * Lazily cached best type representation.
	 */
	private @Nullable org.eclipse.ocl.examples.pivot.Class representativeType = null;
	
	protected ExtensibleTypeServer(@NonNull CompleteClass completeClass, @NonNull DomainClass domainType) {
		super(completeClass, domainType);
		if (!(domainType instanceof PrimitiveType)) {		// FIXME why are primitives in mismatched packages? use testLoad_Internationalized_profile_uml 
			completePackage.assertSamePackage(domainType.getOwningPackage());
		}
	}

	@Override
	public void dispose() {
		if (!trackers.isEmpty()) {
			Collection<TypeTracker> savedTypeTrackers = new ArrayList<TypeTracker>(trackers);
			trackers.clear();
			for (TypeTracker typeTracker : savedTypeTrackers) {
				typeTracker.dispose();
			}
		}
		super.dispose();
//		packageServer.disposedTypeServer(this);
	}
	
	void disposedTypeTracker(@NonNull TypeTracker typeTracker) {
		trackers.remove(typeTracker);
		representativeType = null;		// Force recomputation
		uninstall();
		if (trackers.size() <= 0) {
			dispose();
		}
		completeModel.disposedTypeTracker(typeTracker);
	}

	/**
	 * Return the Type to represent this type merge.
	 */
	@Nullable org.eclipse.ocl.examples.pivot.Class findPivotType() {
		for (TypeTracker typeTracker : trackers) {
			DomainType trackedType = typeTracker.getType();
			if (trackedType instanceof org.eclipse.ocl.examples.pivot.Class) {
				return (org.eclipse.ocl.examples.pivot.Class)trackedType;
			}
		}
		return null;
	}

	public @NonNull org.eclipse.ocl.examples.pivot.Class getPivotType() {
		org.eclipse.ocl.examples.pivot.Class representativeType2 = representativeType;
		if (representativeType2 == null) {
			representativeType2 = representativeType = findPivotType();
			if (representativeType2 == null) {
				throw new IllegalStateException("Missing pivot type");
			}
		}
		return representativeType2;
	}

	public @NonNull TypeTracker getTypeTracker(@NonNull DomainClass pivotType) {
		for (TypeTracker typeTracker : trackers) {
			if (typeTracker.getTarget() == pivotType) {
				return typeTracker;
			}
		}
		TypeTracker typeTracker = new TypeTracker(this, pivotType);
		initMemberFeaturesFrom((org.eclipse.ocl.examples.pivot.Class)pivotType);	
		trackers.add(typeTracker);
		completeModel.addTypeTracker(pivotType, typeTracker);
		return typeTracker;
	}

	public @NonNull List<TypeTracker> getTypeTrackers() {
		return trackers;
	}

	@Override
	public String toString() {
		if (trackers.size() > 0) {
			return String.valueOf(trackers.get(0).getType());
		}
		else {
			return "<<null>>";
		}
	}

	@Override
	public void uninstall() {
		representativeType = null;
		super.uninstall();
	}
}
