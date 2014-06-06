/*******************************************************************************
 * Copyright (c) 2006, 2012 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.domain.values;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

/**
 * Interface of a tuple instance value.  OCL expressions resulting in tuples
 * yield instances of this interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface TupleValue extends Value {
    /**
     * Obtains the tuple's type.
     * 
     * @return its type
	 * @generated NOT
     */
//	@NonNull DomainType getType();
	@NonNull TupleTypeId getTypeId();
	
    /**
     * Queries the value of the specified tuple part.
     * 
     * @param partName the name of the part
     * @return the corresponding value
     * @throws InvalidValueException 
	 * @generated NOT
     */
//	@Nullable Object getValue(@NonNull String partName);
    
    /**
     * Queries the value of the specified tuple part.
     * 
     * @param partId the tuple part (as an attribute)
     * @return the corresponding value
     * @throws InvalidValueException 
	 * @generated NOT
     */
	@Nullable Object getValue(@NonNull TuplePartId partId);
    
    /**
     * Queries the value of the specified tuple part at 0-based index corresponding to the position of the
     * required part-name in the alphabetically sorted list of all part-names.
     */
	@Nullable Object getValue(int index);
}
