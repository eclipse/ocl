/*******************************************************************************
 * Copyright (c) 2007, 2012 IBM Corporation, Zeligsoft Inc., Borland Software Corp., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
 *             - Bugs 243976, 242236, 283509
 *   Zeligsoft - Bugs 245760, 243976, 242236
 *   Borland - Bug 266320
 *******************************************************************************/
package org.eclipse.ocl.pivot.elements;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BasicEnvironment;
import org.eclipse.ocl.pivot.EnvironmentFactory;
import org.eclipse.ocl.pivot.Option;

/**
 * Partial implementation of the {@link BasicEnvironment} interface, providing
 * default behaviours for most features.
 */
public abstract class AbstractBasicEnvironment<P extends BasicEnvironment> implements BasicEnvironment
{	
	private final @NonNull Map<Option<?>, Object> options = new java.util.HashMap<Option<?>, Object>();
	
	protected final @NonNull EnvironmentFactory environmentFactory;

	protected final @Nullable P parent;					// parent in environment hierarchy, null at root
    
    /**
     * Initializes me as an environment root.
     */
    protected AbstractBasicEnvironment(@NonNull EnvironmentFactory environmentFactory) {
		this.environmentFactory = environmentFactory;
		this.parent = null;
    }
    
    /**
     * Initializes me as a child of parent.
      */
    protected AbstractBasicEnvironment(@NonNull P parent) {      
		this.environmentFactory = parent.getEnvironmentFactory();
		this.parent = parent;
    }

	protected final @NonNull Map<Option<?>, Object> basicGetOptions() {
	    return options;
	}
	
	@Override
	public @NonNull Map<Option<?>, Object> clearOptions() {
		Map<Option<?>, Object> myOptions = options;
		
		Map<Option<?>, Object> result = new java.util.HashMap<Option<?>, Object>(
				myOptions);
		
		myOptions.clear();
		
		return result;
	}

	/**
	 * Dispose of any owned objects.
	 */
	@Override
	public void dispose() {}

	/**
	 * Implements the interface method by testing whether I am an instance of
	 * the requested adapter type.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T getAdapter(java.lang.Class<T> adapterType) {
		if (adapterType.isInstance(this)) {
			return (T) this;
		} 
		return null;
	}
	
	@Override
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}
	
	@Override
	public Map<Option<?>, Object> getOptions() {
		P parent2 = parent;
		Map<Option<?>, Object> result = (parent2 != null)
			? new HashMap<Option<?>, Object>(parent2.getOptions())
		    : new HashMap<Option<?>, Object>();
		
		result.putAll(options);
		
		return result;
	}

    // implements the interface method
	public final @Nullable P getParent() {
		return parent;
	}
	
	@Override
	public @Nullable <T> T getValue(@NonNull Option<T> option) {
		@SuppressWarnings("unchecked")
		T result = (T) getOptions().get(option);
		
		if (result == null) {
		    P parent2 = parent;
			result = (parent2 != null) ? parent2.getValue(option) : option.getDefaultValue();
		}		
		return result;
	}
	
	@Override
	public boolean isEnabled(@NonNull Option<Boolean> option) {
		Boolean result = getValue(option);
		return (result == null)? false : result.booleanValue();
	}
	
	@Override
	public <T> void putOptions(@NonNull Map<? extends Option<T>, ? extends T> newOptions) {
		Map<Option<?>, Object> myOptions = options;	
		myOptions.clear();
		myOptions.putAll(newOptions);
	}
	
	@Override
	public @Nullable <T> T removeOption(@NonNull Option<T> option) {
		T result = getValue(option);	
		options.remove(option);	
		return result;
	}
	
	@Override
	public @NonNull <T> Map<Option<T>, T> removeOptions(@NonNull Collection<Option<T>> unwantedOptions) {
		Map<Option<T>, T> result = new HashMap<Option<T>, T>();	
		Map<Option<?>, Object> myOptions = options;		
		for (Option<T> next : unwantedOptions) {
			if (next != null) {
				result.put(next, getValue(next));
				myOptions.remove(next);
			}
		}		
		return result;
	}
	
	@Override
	public <T> void setOption(@NonNull Option<T> option, @Nullable T value) {
		options.put(option, value);
	}
}