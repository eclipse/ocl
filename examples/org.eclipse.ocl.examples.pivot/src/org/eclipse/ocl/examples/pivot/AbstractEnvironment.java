/*******************************************************************************
 * Copyright (c) 2006, 2012 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling 
 *   Zeligsoft - Bugs 243079, 244948, 244886, 246469, 233673
 *   Adolfo Sanchez-Barbudo Herrera - Bug 234354, 233673
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A partial implementation of the {@link Environment} interface providing
 * some useful common behavior for providers of metamodel bindings.  It is
 * recommended to extend this class rather than to implement the
 * <code>Environment</code> interface from scratch.
 * <p>
 * In particular, this class provides:
 * </p>
 * <ul>
 *   <li>maintenance of the context package, classifier, operation, and property</li>
 *   <li>tracking of variable declarations</li>
 *   <li>lookup of operations, attributes, etc. by delegation to the other
 *       model introspection methods</li>
 *   <li>determination of implicit source variables for operation calls,
 *       attribute navigations, etc.</li>
 *   <li>tracking of operation bodies and attribute initializers/derivations</li>
 *   <li>storage of additional attributes and operations</tt>
 * </ul>
 * <p>
 * along with some subclass hook methods and convenience methods.
 * </p>
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractEnvironment extends AbstractBasicEnvironment<Environment> implements Environment
{
	private org.eclipse.ocl.examples.pivot.Package contextPackage;
	private Operation contextOperation;
	private Property contextProperty;
	private Variable selfVariable;

    /**
     * Initializes me without a parent environment.
     */
	protected AbstractEnvironment() {
		this(null);
	}
    
    /**
     * Initializes me with the specified parent environment.
     * 
     * @param parent an environment (or <code>null</code>)
     */
    protected AbstractEnvironment(Environment parent) {      
		super(parent);
    }
	
    // implements the interface method
	public boolean addElement(@NonNull String name, @NonNull Variable elem, boolean isExplicit) {
		throw new UnsupportedOperationException();
/*		// FIXME this is now redundant
		if (name == null) {
			name = generateName();
			while (lookup(name) != null) {
				name = generateName();
			}
		} else if (lookupLocal(name) != null) {
			return false;
		}
		
		elem.setName(name);
		VariableEntry newelem = new VariableEntry(name, elem, isExplicit);
		namedElements.add(newelem);
		
		addedVariable(name, elem, isExplicit);
		
		return true; */
	}
	   
    /**
     * Dispose of any owned objects.
     */
    public void dispose() {
    }    
	
    // implements the interface method
	public @Nullable org.eclipse.ocl.examples.pivot.Package getContextPackage() {
		if (contextPackage != null) {
			return contextPackage;
		}
		Environment parent2 = parent;
		if (parent2 != null) {
			return parent2.getContextPackage();
		}		
		return null;
	}
	
    // implements the interface method
	public @Nullable Type getContextClassifier() {
		Variable selfVariable = getSelfVariable();
		return selfVariable != null ? selfVariable.getType() : null;
	}
	
    // implements the interface method
	public @Nullable Operation getContextOperation() {
		if (contextOperation != null) {
			return contextOperation;
		}
		Environment parent2 = parent;
		if (parent2 != null) {
			return parent2.getContextOperation();
		}
		return null;
	}
	
    // implements the interface method
	public @Nullable Property getContextProperty() {
		if (contextProperty != null) {
			return contextProperty;
		}
		Environment parent2 = parent;
		if (parent2 != null) {
			return parent2.getContextProperty();
		}	
		return null;
	}
	
    // implements the interface method
	public @Nullable Variable getSelfVariable() {
		Variable result = selfVariable;		
		if (result == null) {
			Environment parent2 = parent;
			if (parent2 != null) {
				result = parent2.getSelfVariable();
			}
		}		
		return result;
	}

    /**
     * Assigns my context operation.  This method does <em>not</em> create the
     * variables for parameters and the return result.
     * 
     * @param contextOperation my context operation
     */
	protected void setContextOperation(@Nullable Operation contextOperation) {
		this.contextOperation = contextOperation;
	}

    /**
     * Assigns my context package.
     * 
     * @param contextPackage my new context package
     */
	protected void setContextPackage(@Nullable org.eclipse.ocl.examples.pivot.Package contextPackage) {
		this.contextPackage = contextPackage;
	}

    /**
     * Assigns my context property.
     * 
     * @param contextProperty my context property
     */
	protected void setContextProperty(@Nullable Property contextProperty) {
		this.contextProperty = contextProperty;
	}

    // implements the interface method
	public void setSelfVariable(@NonNull Variable var) {
		selfVariable = var;
		
		// ensure that the environment knows its package context
		if (getContextPackage() == null) {
			Type contextClassifier = getContextClassifier();
			
			if (contextClassifier != null) {
				setContextPackage(contextClassifier.getPackage());
			}
		}
	}

	//
	// Nested classes
	//
	
    /**
     * Wrapper for OCL variable declarations that additionally tracks whether
     * they are explicit or implicit variables.
     * 
     * @author Christian W. Damus (cdamus)
	 */
	protected final class VariableEntry {
		final @NonNull String name;
		final @NonNull Variable variable;
		final boolean isExplicit;
		
		VariableEntry(@NonNull String name, @NonNull Variable variable, boolean isExplicit) {
			this.name = name;
			this.variable = variable;
			this.isExplicit = isExplicit;
		}
		
		@Override
		public String toString() {
			return "VariableEntry[" + name + ", "  //$NON-NLS-1$//$NON-NLS-2$
				+ (isExplicit? "explicit, " : "implicit, ") + variable + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
	}
}