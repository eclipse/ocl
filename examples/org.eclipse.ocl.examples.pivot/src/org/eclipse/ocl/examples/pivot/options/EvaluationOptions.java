/*******************************************************************************
 * Copyright (c) 2007, 2012 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 253252
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.options;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Customizable;
import org.eclipse.ocl.examples.pivot.OCLUtil;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;

/**
 * Options applicable to {@link EvaluationEnvironment}s to
 * {@linkplain Customizable customize} their evaluation behaviour.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class EvaluationOptions {

    /**
     * <p>
     * Evaluation option indicating whether to implement lax handling of null
     * values in certain <tt>OclAny</tt>-defined operations.  When <tt>true</tt>,
     * the <tt>null.oclIsKindOf(OclType)</tt> and <tt>null.oclIsTypeOf(OclType)</tt>
     * operations will return <tt>true</tt> for any OCL type instead of
     * returning <tt>OclInvalid</tt>, as <tt>OclVoid</tt> is defined as
     * conforming to all other types.  Similarly, <tt>null.oclAsType(OclType)</tt>
     * will return <tt>null</tt> for any OCL type instead of <tt>OclInvalid</tt>
     * as prescribed by the OCL 2.0 Specification.
     * </p><p>
     * For backward compatibility with the 1.1 release behaviour, the default
     * value of this option is <tt>true</tt>.  For strict conformance to the
     * specification, use <tt>false</tt>.
     * </p>
     */
    public static final @NonNull Option<Boolean> LAX_NULL_HANDLING = new BasicOption<Boolean>(
            "lax.null.handling", true); //$NON-NLS-1$

    /**
     * Not instantiable by clients.
     */
    private EvaluationOptions() {
        super();
    }

    /**
     * Add an option to apply to the specified environment, adapting it as
     * necessary to the {@link Customizable} API.
     * 
     * @param env an evaluation environment on which to set an option
     * @param option the option
     * @param value the option's value
     * 
     * @see Customizable#setOption(Option, Object)
     */
    public static <T> void setOption(@NonNull EvaluationEnvironment env, @NonNull Option<T> option, @Nullable T value) {
        
        Customizable custom = OCLUtil.getAdapter(env, Customizable.class);
        if (custom != null) {
            custom.setOption(option, value);
        }
    }

    /**
     * Obtains the value of the specified option's setting in the the given
     * environment's options map, adapting the environment as necessary to the
     * {@link Customizable} API.  If not already set, return the option's
     * {@linkplain Option#getDefaultValue() default value}.
     * 
     * @param env an evaluation environment on which to query an option
     * @param option an option to query
     * 
     * @return value of the option
     * 
     * @see Customizable#getValue(Option)
     */
    public static @Nullable <T> T getValue(@NonNull EvaluationEnvironment env, @NonNull Option<T> option) {
        
        Customizable custom = OCLUtil.getAdapter(env, Customizable.class);
        if (custom != null) {
            return custom.getValue(option);
        }
        
        return option.getDefaultValue();
    }

}
