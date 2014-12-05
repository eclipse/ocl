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
package org.eclipse.ocl.domain.elements;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.ids.CollectionTypeId;
import org.eclipse.ocl.domain.values.IntegerValue;

public interface DomainCollectionType extends DomainClass
{
	/*@NonNull*/ DomainClass getContainerType();		
	/*@NonNull*/ DomainType getElementType();
	@NonNull IntegerValue getLowerValue();		
	@Override
	@NonNull CollectionTypeId getTypeId();
	@NonNull IntegerValue getUpperValue();
	@Override
	boolean isOrdered();
	@Override
	boolean isUnique();
}
