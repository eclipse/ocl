/*******************************************************************************
 * Copyright (c) 2007, 2013 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.evaluation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Environment;
import org.eclipse.ocl.pivot.EnvironmentFactory;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.elements.AbstractBasicEnvironment;
import org.eclipse.ocl.pivot.messages.OCLMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.osgi.util.NLS;

/**
 * A partial implementation of the {@link EvaluationEnvironment} interface,
 * providing some useful common behaviors.  Implementors of metamodel-specific
 * environments are encourage to extend this class rather than implement
 * an evaluation environment "from scratch."
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractEvaluationEnvironment extends AbstractBasicEnvironment<EvaluationEnvironment>
		implements EvaluationEnvironment {
	
    private final @NonNull Map<TypedElement, Object> variableValues = new HashMap<TypedElement, Object>();
    
    protected AbstractEvaluationEnvironment(@NonNull EnvironmentFactory environmentFactory) {
    	super(environmentFactory);
    }
    
    protected AbstractEvaluationEnvironment(@NonNull EvaluationEnvironment parent) {	
    	super(parent);
    }
    
    /**
     * Returns the value associated with the supplied referredVariable
     * 
     * @param referredVariable
     *            the referredVariable whose value is to be returned
     * @return the value associated with the referredVariable
     */
	@Override
	public @Nullable Object getValueOf(@NonNull TypedElement referredVariable) {
    	Object object = variableValues.get(referredVariable);
        if (object == null) {
			if (!variableValues.containsKey(referredVariable)) {
	            EvaluationEnvironment parent2 = parent;
				if (parent2 != null) {
	            	object = parent2.getValueOf(referredVariable);
	            }
				else {
					throw new InvalidValueException("Undefined Variable " + referredVariable);
				}
            }
        }
        return object;
	}
    
	@Override
	@SuppressWarnings("null")
	public @NonNull Set<TypedElement> getVariables() {
		return variableValues.keySet();
	}

    /**
     * Replaces the current value of the supplied referredVariable with the supplied value.
     * 
     * @param referredVariable
     *            the referredVariable
     * @param value
     *            the new value
     */
    @Override
	public void replace(@NonNull TypedElement referredVariable, @Nullable Object value) {
    	variableValues.put(referredVariable, value);
    }

    /**
     * Adds the supplied referredVariable and value binding to the environment
     * 
     * @param referredVariable
     *            the referredVariable to add
     * @param value
     *            the associated binding
     */
    @Override
	public void add(@NonNull TypedElement referredVariable, @Nullable Object value) {
        if (variableValues.containsKey(referredVariable)) {
        	Object oldValue = variableValues.get(referredVariable);
        	if ((oldValue != value) && ((oldValue == null) || !oldValue.equals(value))) {
	            String message = NLS.bind(
	            		OCLMessages.BindingExist_ERROR_,
	            		referredVariable,
	            		oldValue);
	            throw new IllegalArgumentException(message);
        	}
        }
        variableValues.put(referredVariable, value);
    }

    /**
     * Removes the supplied referredVariable and binding from the environment (if it exists)
     * and returns it.
     * 
     * @param referredVariable
     *            the referredVariable to remove
     * @return the value associated with the removed referredVariable
     */
    @Override
   public @Nullable Object remove(@NonNull TypedElement referredVariable) {
    	return variableValues.remove(referredVariable);
    }

    /**
     * Clears the environment of variables.
     */
    @Override
	public void clear() {
    	variableValues.clear();
    }

    /**
     * Returns a string representation of the bindings
     */
    @Override
    public String toString() {
        return variableValues.toString();
    }
}
