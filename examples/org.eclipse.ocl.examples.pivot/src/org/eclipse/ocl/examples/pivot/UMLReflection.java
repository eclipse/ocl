/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *	 E.D.Willink Bug 298128
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot;

import org.eclipse.jdt.annotation.NonNull;


/**
 * An interface providing reflection service for the metaclasses that the
 * OCL borrows from UML.
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this interface. 
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface UMLReflection {

    /**
     * Stereotype applied to classifier invariant constraints.
     * 
     * @see #getStereotype
     */
	@NonNull String INVARIANT = "invariant"; //$NON-NLS-1$

    /**
     * Stereotype applied to operation precondition constraints.
     * 
     * @see #getStereotype
     */
    @NonNull String PRECONDITION = "precondition"; //$NON-NLS-1$

    /**
     * Stereotype applied to operation postcondition constraints.
     * 
     * @see #getStereotype
     */
    @NonNull String POSTCONDITION = "postcondition"; //$NON-NLS-1$

    /**
     * Stereotype applied to operation body conditions.
     * 
     * @see #getStereotype
     */
    @NonNull String BODY = "body"; //$NON-NLS-1$

    /**
     * Stereotype applied definition expressions.
     * 
     * @see #getStereotype
     */
    @NonNull String DEFINITION = "definition"; //$NON-NLS-1$

    /**
     * Stereotype applied initial value expressions.
     * 
     * @see #getStereotype
     */
    @NonNull String INITIAL = "initial"; //$NON-NLS-1$

    /**
     * Stereotype applied derived value expressions.
     * 
     * @see #getStereotype
     */
    @NonNull String DERIVATION = "derivation"; //$NON-NLS-1$
}
