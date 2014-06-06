/*******************************************************************************
 * Copyright (c) 2007, 2012 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bugs 295166
 *   Borland - Bug 242880
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.options;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.BasicEnvironment;
import org.eclipse.ocl.examples.pivot.Customizable;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.OCLUtil;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * Options applicable to {@link Environment}s to
 * {@linkplain Customizable customize} their parsing behaviour.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ParsingOptions {

    /**
     * @deprecated This Classic OCL API is not used by the Pivot.
     */
    @Deprecated
    public static final @NonNull Option<Boolean> DEFINITION_CONSTRAINS_FEATURE =
        new BasicOption<Boolean>("definition.constraints.feature", false); //$NON-NLS-1$

    /**
     * @deprecated This Classic OCL API is not used by the Pivot.
     */
    @Deprecated
    public static final @NonNull Option<Boolean> USE_COMPARE_TO_OPERATION =
        new BasicOption<Boolean>("use.compare.to.operation", false); //$NON-NLS-1$

    /**
     * @deprecated This Classic OCL API is not used by the Pivot.
     */
    @Deprecated
    public static final @NonNull Option<Boolean> WARN_OF_XOR_OR_AND_PRECEDENCE_CHANGE =
        new BasicOption<Boolean>("warn.of.xor.or.and.precedence.change", false); //$NON-NLS-1$

    /**
     * @deprecated This Classic OCL API is not used by the Pivot.
     */
    @Deprecated
    public static final @NonNull Option<?> IMPLICIT_ROOT_CLASS =
        new BasicOption<Object>("implict.root.class", null); //$NON-NLS-1$

    /**
     * @deprecated This Classic OCL API is not used by the Pivot.
     */
    @Deprecated
    public static final @NonNull Option<Boolean> USE_BACKSLASH_ESCAPE_PROCESSING =
        new BasicOption<Boolean>("use.backslash.escape.processing", true); //$NON-NLS-1$

    /**
     * @deprecated This Classic OCL API is not used by the Pivot.
     */
    @Deprecated
    @SuppressWarnings("unchecked")
    public static @NonNull Option<Type> implicitRootClass(@NonNull Environment env) {
        return (Option<Type>) IMPLICIT_ROOT_CLASS;
    }

    /**
     * @deprecated This Classic OCL API is not used by the Pivot.
     */
    @Deprecated
    public static final @NonNull Option<Boolean> SUPPORT_STATIC_FEATURES =
        new BasicOption<Boolean>("support.static.features", true); //$NON-NLS-1$

    /**
     * Not instantiable by clients.
     */
    private ParsingOptions() {
        super();
    }

    /**
     * Add an option to apply to the specified environment, adapting it as
     * necessary to the {@link Customizable} API.
     * 
     * @param env an environment on which to set an option
     * @param option the option
     * @param value the option's value
     * 
     * @see Customizable#setOption(Option, Object)
     */
    public static <T> void setOption(@NonNull Environment env, @NonNull Option<T> option, @Nullable T value) {
        
        Customizable custom = OCLUtil.getAdapter(env, Customizable.class);
        if (custom == null) {
            // go for the external basic-environment adapter that we provide
            custom = OCLUtil.getAdapter(env, BasicEnvironment.class);
        }
        
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
     * @param env an environment on which to query an option
     * @param option an option to query
     * 
     * @return value of the option
     * 
     * @see Customizable#getValue(Option)
     */
    public static @Nullable <T> T getValue(@NonNull Environment env, @NonNull Option<T> option) {
        
        Customizable custom = OCLUtil.getAdapter(env, Customizable.class);
        if (custom == null) {
            // go for the external basic-environment adapter that we provide
            custom = OCLUtil.getAdapter(env, BasicEnvironment.class);
        }
        return custom != null ? custom.getValue(option) : null;
    }

}
