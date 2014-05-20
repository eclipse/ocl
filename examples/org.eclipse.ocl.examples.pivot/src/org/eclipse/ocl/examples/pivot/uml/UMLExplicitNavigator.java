/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.uml;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.manager.ImplementationManager;
import org.eclipse.ocl.examples.pivot.manager.ImplementationManager.ExplicitNavigator;

/**
 * ImplementationManager encapsulates the knowledge about known feature implementations.
 */
public class UMLExplicitNavigator implements ImplementationManager.ExplicitNavigator
{			
	public static final@NonNull  ExplicitNavigator INSTANCE = new UMLExplicitNavigator();

	public @Nullable LibraryProperty getPropertyImplementation(@Nullable Object sourceValue, @NonNull Property property) {
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
		return null;
	}
}