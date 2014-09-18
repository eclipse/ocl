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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteClassImpl;

/**
 * An ExtensibleTypeServer supports one or more merged types as the source for operations, properties or superclasses.
 */
public abstract class ExtensibleTypeServer extends AbstractTypeServer
{	
	protected ExtensibleTypeServer(@NonNull CompleteClassImpl completeClass, @NonNull DomainClass domainType) {
		super(completeClass, domainType);
		if (!(domainType instanceof PrimitiveType)) {		// FIXME why are primitives in mismatched packages? use testLoad_Internationalized_profile_uml 
			completePackage.assertSamePackage(domainType.getOwningPackage());
		}
	}
}
