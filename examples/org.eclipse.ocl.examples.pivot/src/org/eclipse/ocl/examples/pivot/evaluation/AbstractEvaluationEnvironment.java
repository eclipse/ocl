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

package org.eclipse.ocl.examples.pivot.evaluation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.AbstractBasicEnvironment;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
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
	
    protected final @NonNull MetaModelManager metaModelManager;

    private final @NonNull Map<DomainTypedElement, Object> variableValues = new HashMap<DomainTypedElement, Object>();
    
    protected AbstractEvaluationEnvironment(@NonNull MetaModelManager metaModelManager) {
    	super(null);
    	this.metaModelManager = metaModelManager;
    }
    
    protected AbstractEvaluationEnvironment(@NonNull EvaluationEnvironment parent) {	
    	super(parent);
    	this.metaModelManager = parent.getMetaModelManager();
    }
    
	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}
    
    /**
     * Returns the value associated with the supplied referredVariable
     * 
     * @param referredVariable
     *            the referredVariable whose value is to be returned
     * @return the value associated with the referredVariable
     */
	public @Nullable Object getValueOf(@NonNull DomainTypedElement referredVariable) {
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
    
	@SuppressWarnings("null")
	public @NonNull Set<DomainTypedElement> getVariables() {
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
    public void replace(@NonNull DomainTypedElement referredVariable, @Nullable Object value) {
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
    public void add(@NonNull DomainTypedElement referredVariable, @Nullable Object value) {
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
    @Deprecated
    public Object remove(@NonNull DomainTypedElement referredVariable) {
    	return variableValues.remove(referredVariable);
    }

    /**
     * Clears the environment of variables.
     */
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
    
    /**
     * @deprecated This Classic OCL API is not used by the Pivot.
     */
    @Deprecated
    public boolean overrides(@NonNull Operation operation, int opcode) {
    	return (getParent() != null)? getParent().overrides(operation, opcode) : false;
    }

    /**
     * Implements the inherited method by attempting to find an appropriate
     * Java method in the actual type of the <tt>source</tt> object and invoking
     * it.  On failure to find or invoke the method (e.g., an exception), the
     * <tt>OclInvalid</tt> result is returned.
     * 
     * @return the result of the Java method invocation, or <tt>OclInvalid</tt>
     *    on failure of the method invocation
     *
    public Object callOperation(Operation operation, int opcode, Object source, Object[] args)
    
		throws IllegalArgumentException {
    	
    	if (getParent() != null) {
    		return getParent().callOperation(operation, opcode, source, args);
    	}
    	
    	Method method = getJavaMethodFor(operation, source);
    	
    	if (method != null) {
    		try {
    		    // coerce any collection arguments to EList as necessary
    		    Class<?>[] parmTypes = method.getParameterTypes();
    		    for (int i = 0; i < parmTypes.length; i++) {
    		        if (EList.class.isAssignableFrom(parmTypes[i])) {
    		            if (args[i] == null) {
    		                args[i] = ECollections.EMPTY_ELIST;
    		            } else if (!(args[i] instanceof Collection<?>)) {
    		                EList<Object> list = new BasicEList.FastCompare<Object>(1);
    		                list.add(args[i]);
    		                args[i] = list;
    		            } else if (!(args[i] instanceof EList<?>)) {
    		                args[i] = new BasicEList.FastCompare<Object>((Collection<?>) args[i]);
    		            }
    		        }
    		    }
    		    
				return method.invoke(source, args);
			} catch (Exception e) {
				OCLPlugin.catching(getClass(), "callOperation", e);//$NON-NLS-1$
				OCLPlugin.log(
					Diagnostic.ERROR,
					OCLStatusCodes.IGNORED_EXCEPTION_WARNING,
					OCLMessages.bind(
						OCLMessages.ErrorMessage_ERROR_,
						"calloperation", //$NON-NLS-1$
						e.getLocalizedMessage()),
					e);
				return getInvalidResult();
			}
    	}
    	
    	// maybe it's a comparison operation that is implemented implicitly
    	// via the Comparable interface?
    	switch (opcode) {
    	    case PredefinedType.LESS_THAN:
    	    case PredefinedType.GREATER_THAN:
    	    case PredefinedType.LESS_THAN_EQUAL:
    	    case PredefinedType.GREATER_THAN_EQUAL:
            if ((source instanceof Comparable<?>) && (args.length == 1)) {
                @SuppressWarnings("unchecked")
                Comparable<Object> comparable = (Comparable<Object>) source;
                Object other = args[0];
                
            	switch (opcode) {
                    case PredefinedType.LESS_THAN:
                        return comparable.compareTo(other) < 0;
                    case PredefinedType.GREATER_THAN:
                        return comparable.compareTo(other) > 0;
                    case PredefinedType.LESS_THAN_EQUAL:
                        return comparable.compareTo(other) <= 0;
                    case PredefinedType.GREATER_THAN_EQUAL:
                        return comparable.compareTo(other) >= 0;
            	}
            }
            break;
    	}
    	
    	throw new IllegalArgumentException();
    } */
    
	/**
	 * Returns the java method that corresponds to the supplied
	 * <code>EOperation</code>
	 * 
	 * @param operation
	 *            the operation
	 * @return a java method
	 */
//	@Deprecated
//	protected abstract Method getJavaMethodFor(Operation operation, Object receiver);
	
	/**
	 * Obtains the language-binding-specific representation of the predefined
	 * <tt>OclInvalid</tt> object.
	 * 
	 * @return <tt>OclInvalid</tt>
	 */
//	@Deprecated
//	protected abstract Object getInvalidResult();

/*	public NullValue throwInvalidEvaluation(Object value, OCLExpression expression,
			String message, Object object)
			throws InvalidEvaluationException {
		// TODO Auto-generated method stub
		return null;
	} */

//	public @NonNull NullValue throwInvalidEvaluation(InvalidValueException e) {
//		throw new InvalidEvaluationException(this, e);
//	}

//	public @NonNull NullValue throwInvalidEvaluation(String message) {
//		throw new InvalidEvaluationException(this, message, null, null, null);
//	}

//	public @NonNull NullValue throwInvalidEvaluation(String message, DomainExpression expression) {
//		throw new InvalidEvaluationException(this, message, null, expression, null);
//	}

//	public @NonNull NullValue throwInvalidEvaluation(String message, DomainExpression expression, Object context) {
//		throw new InvalidEvaluationException(this, message, null, expression, context);
//	}

//	public @NonNull NullValue throwInvalidEvaluation(Throwable e, DomainExpression expression, Object context, String message, Object... bindings) {
//		String boundMessage = NLS.bind(message, bindings);
//		throw new InvalidEvaluationException(this, boundMessage, e, expression, context);
//	}
}
