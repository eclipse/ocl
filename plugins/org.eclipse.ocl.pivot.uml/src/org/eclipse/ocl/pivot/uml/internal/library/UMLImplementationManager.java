/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.library;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ImplementationManager;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.library.LibraryProperty;

/**
 * ImplementationManager encapsulates the knowledge about known feature implementations.
 */
public class UMLImplementationManager extends ImplementationManager
{			
	public UMLImplementationManager(@NonNull MetamodelManager metamodelManager) {
		super(metamodelManager);
	}

	@Override
	public @NonNull LibraryProperty createBasePropertyImplementation(@NonNull Property property) {
		return new UMLBaseProperty(property);
	}

	@Override
	public @NonNull LibraryProperty createExplicitNavigationPropertyImplementation(@Nullable Object sourceValue, @NonNull Property property) {
		if (sourceValue instanceof org.eclipse.uml2.uml.InstanceSpecification) {
			EObject eTarget = property.getETarget();
			if  (eTarget instanceof org.eclipse.uml2.uml.Property) {
				TypeId typeId = property.getTypeId();
				CollectionTypeId collectionTypeId;
				if (typeId instanceof CollectionTypeId) {
					collectionTypeId = (CollectionTypeId)typeId;
				}
				else {
					collectionTypeId = null;
				}
				return new InstanceSlotNavigationProperty((org.eclipse.uml2.uml.Property)eTarget, collectionTypeId);
			}
		}
		return super.createExplicitNavigationPropertyImplementation(sourceValue, property);
	}

	@Override
	public @NonNull LibraryProperty createExtensionPropertyImplementation(@NonNull Property property) {
		return new UMLExtensionProperty(property);
	}

	@Override
	public @NonNull LibraryProperty createStereotypePropertyImplementation(@NonNull Property property) {
		return new UMLStereotypeProperty(property);
	}
}