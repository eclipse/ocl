/*******************************************************************************
 * Copyright (c) 2007, 2012 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera - Bug 233673
 *   Zeligsoft - Bugs 233673, 261128
 *   E.D.Willink - Bug 242236
 *   Radek Dvorak - Bug 261128
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;

/**
 * Miscellaneous utilities for use by the OCL parser/interpreter and by clients.
 * 
 * @author Christian W. Damus (cdamus)
 */
public final class OCLUtil {
    /** Use weak references as the keys to avoid memory leaks. */
//	private static final @NonNull Map<Environment, Reference<BasicEnvironment>> environments = new java.util.WeakHashMap<Environment, Reference<BasicEnvironment>>();
   
	// prevent instantiation
	private OCLUtil() {
		super();
	}

	/**
	 * Obtains an adapter for the specified interface type.
	 * 
	 * @param <T> the requested adapter interface
	 * 
	 * @param env an environment to adapt
	 * @param adapterType the requested adapter interface
	 * @return an instance of the requested interface, or <code>null</code>
	 *     if this environment does not adapt to it
	 */
	public static @Nullable <T> T getAdapter(@NonNull Environment env, @NonNull java.lang.Class<T> adapterType) {
	    return env.getAdapter(adapterType);
	}
	
	/**
	 * Gets the lazily cached basic-environment adapter for the specified OCL
	 * environment.  The cache is doubly weak to avoid leaking environment
	 * instances.
	 * 
	 * @param env the environment for which to define an external adapter
	 * @return the external adapter
	 *
	private static BasicEnvironment getBasicEnvironment(
	        final Environment env) {
	    
	    BasicEnvironment result = null;
	    Reference<BasicEnvironment> ref = environments.get(env);
	    
	    if (ref != null) {
	        result = ref.get();
	    }
	    
	    if (result == null) {
	        result = new AbstractBasicEnvironment(null) {
                @SuppressWarnings("unchecked")
                @Override
                public <T> T getAdapter(java.lang.Class<T> adapterType) {
                    if (adapterType == Environment.class) {
                        return (T) env;  // the reverse adaptation
                    } else {
                        return super.getAdapter(adapterType);
                    }
                }
            };
            
            environments.put(env, new java.lang.ref.WeakReference<BasicEnvironment>(result));
	    }
	    
	    return result;
	} */

	/**
	 * Obtains an adapter for the specified interface type.
	 */
	@SuppressWarnings("unchecked")
	public static @Nullable <T> T getAdapter(@NonNull EnvironmentFactory factory, @NonNull java.lang.Class<T> adapterType) {
		T result;
		
		if (factory instanceof Adaptable) {
			result = ((Adaptable) factory).getAdapter(adapterType);
		} else if (adapterType.isInstance(factory)) {
			result = (T) factory;
		} else {
			result = null;
		}		
		return result;
	}

	/**
	 * Obtains an adapter for the specified interface type, if the evaluation
	 * environment is {@link Adaptable} to it.
	 * 
	 * @param <T> the requested adapter interface
	 * 
	 * @param env an evaluation environment to adapt
	 * @param adapterType the requested adapter interface
	 * @return an instance of the requested interface, or <code>null</code>
	 *     if this evaluation environment does not adapt to it
	 */
	public static <T> T getAdapter(EvaluationEnvironment env, java.lang.Class<T> adapterType) {
	    return env.getAdapter(adapterType);
	}
    
    /**
	 * Checks whether the specified environment's problem handler has any
	 * diagnostics of error severity or worse and, if so, throws a semantic
	 * exception encapsulating these diagnostics.
	 * 
	 * @param env an environment in which we have parsed some OCL
	 * 
	 * @throws SyntaxException if there are any errors in parsing the concrete
	 *    syntax
	 * @throws SemanticException if there are any errors in analyzing the
	 *    abstract syntax 
	 * 
	 * @see #checkForErrors(ProblemHandler)
	 */
	public static Diagnostic checkForErrors(@NonNull Environment env)
			throws SyntaxException, SemanticException {
		throw new UnsupportedOperationException();
//		return checkForErrors(getAdapter(env, ProblemHandler.class));
	}

	/**
	 * Checks whether the specified problem handler has any
	 * diagnostics of error severity or worse and, if so, throws a semantic
	 * exception encapsulating these diagnostics.
	 * 
	 * @param problemHandler a problem handler
	 * 
	 * @throws SyntaxException if there are any errors in parsing the concrete
	 *    syntax
	 * @throws SemanticException if there are any errors in analyzing the
	 *    abstract syntax 
	 */
	public static Diagnostic checkForErrors(@NonNull ProblemHandler problemHandler)
			throws SyntaxException, SemanticException {
		throw new UnsupportedOperationException();		
/*		Diagnostic result = null;
		
		if (problemHandler instanceof OCLProblemHandler) {
			result = ((OCLProblemHandler) problemHandler).getDiagnostic();
			
			if ((result != null) && (result.getSeverity() >= Diagnostic.ERROR)) {
				List<?> data = result.getData();
				
				if (data.contains(ProblemHandler.Phase.LEXER)
						|| data.contains(ProblemHandler.Phase.PARSER)) {
					throw new SyntaxException(result);
				} else {
					throw new SemanticException(result);
				}
			}
		}
		
		return result; */
	}
    
    /**
	 * Checks whether the specified environment's problem handler has any
	 * diagnostics of warnings severity or worse and, if so, throws a semantic
	 * exception encapsulating these diagnostics.
	 * 
	 * @param env an environment in which we have parsed some OCL
	 * 
	 * @throws SyntaxException if there are any errors in parsing the concrete
	 *    syntax
	 * @throws SemanticException if there are any errors in analyzing the
	 *    abstract syntax 
	 * 
	 * @see #checkForErrors(ProblemHandler)
     *
	public static Diagnostic checkForErrorsOrWarnings(
			PivotEnvironment env)
			throws SyntaxException, SemanticException {
		
		return checkForErrorsOrWarnings(getAdapter(env, ProblemHandler.class));
	} */

	/**
	 * Checks whether the specified problem handler has any
	 * diagnostics of warning severity or worse and, if so, throws a semantic
	 * exception encapsulating these diagnostics.
	 * 
	 * @param problemHandler a problem handler
	 * 
	 * @throws SyntaxException if there are any errors in parsing the concrete
	 *    syntax
	 * @throws SemanticException if there are any errors in analyzing the
	 *    abstract syntax 
	 */
	public static Diagnostic checkForErrorsOrWarnings(@NonNull ProblemHandler problemHandler)
			throws SyntaxException, SemanticException {
		throw new UnsupportedOperationException();
/*		
		Diagnostic result = null;
		
		if (problemHandler instanceof OCLProblemHandler) {
			result = ((OCLProblemHandler) problemHandler).getDiagnostic();
			
			if ((result != null) && (result.getSeverity() >= Diagnostic.WARNING)) {
				List<?> data = result.getData();
				
				if (data.contains(ProblemHandler.Phase.LEXER)
						|| data.contains(ProblemHandler.Phase.PARSER)) {
					throw new SyntaxException(result);
				} else {
					throw new SemanticException(result);
				}
			}
		}
		
		return result; */
	}
	
	/**
	 * Attempts to get an environment instance that is appropriate for introspection
	 * of the specified validation <tt>target</tt>.  If an environment is specified
	 * in the validation <tt>context</tt>, then it is used.  Otherwise, an
	 * environment is obtained from the registry.
	 * 
	 * @param target an object to be validated in an appropriate environment
	 * @param context the current validation context
	 * 
	 * @return the environment, or <code>null</code> if none can be found
	 * 
	 * @see Environment.Registry
	 */
	public static @Nullable Environment getValidationEnvironment(@NonNull Object target, @NonNull Map<Object, Object> context) {
		Environment result = (Environment) context.get(Environment.class);
		
		if (result == null) {
			// try the extension point
			result = Environment.Registry.INSTANCE.getEnvironmentFor(target);
			
			if (result != null) {
				context.put(Environment.class, result);
			}
		}
		
		return result;
	}
	
	/**
	 * Attempts to get evaluation problems available from the last evaluation of
	 * the given query.
	 * 
	 * @param query
	 *            a query to check for evaluation problems
	 * @return the diagnostic object encapsulating the problem details or
	 *         <code>null</code> if no problems are available
	 */
	public static @Nullable Diagnostic getEvaluationProblems(@NonNull Query query) {

		if (query instanceof ProblemAware) {
			ProblemAware problemAware = (ProblemAware) query;
			return problemAware.getProblems();
		}

		return null;
	}
}
