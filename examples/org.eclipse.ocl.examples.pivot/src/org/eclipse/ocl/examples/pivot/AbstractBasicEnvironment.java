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
package org.eclipse.ocl.examples.pivot;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.options.Option;

/**
 * Partial implementation of the {@link BasicEnvironment} interface, providing
 * default behaviours for most features.
 */
public abstract class AbstractBasicEnvironment<P extends BasicEnvironment> implements BasicEnvironment
{	
	private final @NonNull Map<Option<?>, Object> options = new java.util.HashMap<Option<?>, Object>();
	
	protected @Nullable P parent;					// parent in environment hierarchy
    
    /**
     * Initializes me with the specified parent environment.
     * 
     * @param parent an environment (or <code>null</code>)
     */
    protected AbstractBasicEnvironment(P parent) {      
		this.parent = parent;
    }

	protected final @NonNull Map<Option<?>, Object> basicGetOptions() {
	    return options;
	}
	
	public @NonNull Map<Option<?>, Object> clearOptions() {
		Map<Option<?>, Object> myOptions = options;
		
		Map<Option<?>, Object> result = new java.util.HashMap<Option<?>, Object>(
				myOptions);
		
		myOptions.clear();
		
		return result;
	}

	/**
	 * Implements the interface method by testing whether I am an instance of
	 * the requested adapter type.
	 */
	@SuppressWarnings("unchecked")
	public <T> T getAdapter(java.lang.Class<T> adapterType) {
		if (adapterType.isInstance(this)) {
			return (T) this;
		} 
		return null;
	}
	
	public Map<Option<?>, Object> getOptions() {
		P parent2 = parent;
		Map<Option<?>, Object> result = (parent2 != null)
			? new HashMap<Option<?>, Object>(parent2.getOptions())
		    : new HashMap<Option<?>, Object>();
		
		result.putAll(options);
		
		return result;
	}

    // implements the interface method
	public final P getParent() {
		return parent;
	}
	
	public @Nullable <T> T getValue(@NonNull Option<T> option) {
		@SuppressWarnings("unchecked")
		T result = (T) getOptions().get(option);
		
		if (result == null) {
		    P parent2 = parent;
			result = (parent2 != null) ? parent2.getValue(option) : option.getDefaultValue();
		}		
		return result;
	}
	
	public boolean isEnabled(@NonNull Option<Boolean> option) {
		Boolean result = getValue(option);
		return (result == null)? false : result.booleanValue();
	}
    
    /**
     * Queries whether I have a non-OK setting for the specified problem option.
     * In such cases, I will need to be concerned with reporting the problem.
     * 
     * @param option the problem option
     * @return whether I have a setting for it that is not OK
     * 
     * @see ProblemHandler.Severity#OK
     */
    public boolean notOK(@NonNull Option<ProblemHandler.Severity> option) {
        ProblemHandler.Severity sev = getValue(option);
        return (sev != null) && !sev.isOK();
    }
	
	public <T> void putOptions(@NonNull Map<? extends Option<T>, ? extends T> newOptions) {
		Map<Option<?>, Object> myOptions = options;	
		myOptions.clear();
		myOptions.putAll(newOptions);
	}
	
	public @Nullable <T> T removeOption(@NonNull Option<T> option) {
		T result = getValue(option);	
		options.remove(option);	
		return result;
	}
	
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
	
	public <T> void setOption(@NonNull Option<T> option, @Nullable T value) {
		options.put(option, value);
	}

    /**
     * Assigns me a parent environment after construction.  It is not advisable
     * to set the parent to <code>null</code> if I previously had one.
     * 
     * @param parent my new parent
     */
	protected void setParent(P parent) {
		this.parent = parent;
	}
}