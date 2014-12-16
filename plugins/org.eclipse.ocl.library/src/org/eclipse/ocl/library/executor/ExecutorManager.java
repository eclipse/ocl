/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.library.executor;

import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.DomainEvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.DomainEvaluator;
import org.eclipse.ocl.pivot.evaluation.DomainLogger;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.Value;

public abstract class ExecutorManager implements DomainEvaluator
{	
	// This is the same as HashMap's default initial capacity
	private static final int DEFAULT_REGEX_CACHE_LIMIT = 16;

	// this is the same as HashMap's default load factor
	private static final float DEFAULT_REGEX_CACHE_LOAD_FACTOR = 0.75f;

	protected final @NonNull CompleteEnvironment environment;
	protected final @NonNull StandardLibrary standardLibrary;

    /**
     * Set true by {@link #setCanceled} to terminate execution at next call to {@link #getValuefactory()}.
     */
	private boolean isCanceled = false;
	
	/**
	 * Lazily-created cache of reusable regex patterns to avoid
	 * repeatedly parsing the same regexes.
	 */
	private /*@LazyNonNull*/ Map<String, Pattern> regexPatterns = null;
	
	public ExecutorManager(@NonNull CompleteEnvironment environment) {
		this.environment = environment;
		this.standardLibrary = environment.getOwnedStandardLibrary();
	}
	
	/**
	 * Creates (on demand) the regular-expression matcher cache. The default
	 * implementation creates an access-ordered LRU cache with a limit of 16
	 * entries. Subclasses may override to create a map with whatever different
	 * performance characteristics may be required.
	 * 
	 * @return the new regular-expression matcher cache
	 * 
	 * @see #getRegexPattern(String)
	 */
	protected @NonNull Map<String, Pattern> createRegexCache() {
		return new java.util.LinkedHashMap<String, Pattern>(
			DEFAULT_REGEX_CACHE_LIMIT, DEFAULT_REGEX_CACHE_LOAD_FACTOR, true) {

			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(
					Map.Entry<String, Pattern> eldest) {
				return size() > DEFAULT_REGEX_CACHE_LIMIT;
			}
		};
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public @NonNull Value evaluate(@NonNull OCLExpression body) {
		throw new UnsupportedOperationException();
//		try {
//			return ((LibraryUnaryOperation)body).evaluate(this, null, null);		// WIP
//		} catch (InvalidValueException e) {
//			return throwInvalidEvaluation(e);
//		}
	}

	public Value evaluateIteration(Type returnType, CollectionValue sourceVal, TypedElement accumulator,
			OCLExpression body, TypedElement[] iterators) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CompleteEnvironment getCompleteEnvironment() {
		return environment;
	}

	public @NonNull Type getDynamicTypeOf(@Nullable Object value) {
		return getIdResolver().getDynamicTypeOf(value);
	}

	@Override
	public @NonNull DomainEvaluationEnvironment getEvaluationEnvironment() {
		throw new UnsupportedOperationException();
	}

//	public @NonNull IdResolver getIdResolver() {
//		return standardLibrary.getIdResolver();
//	}

	@Override
	public @Nullable DomainLogger getLogger() {
		return null;
	}

	/**
	 * Return a cached matcher for a give regular expression.
	 */
	@Override
	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
		if (regexPatterns == null) {
			synchronized (this) {
				if (regexPatterns == null) {
					regexPatterns = createRegexCache();
				}
			}
		}
		synchronized (regexPatterns) {
			Pattern pattern = regexPatterns.get(regex);
			if (pattern == null) {
//				System.out.println("Compile " + regex);
				pattern = Pattern.compile(regex);
				assert pattern != null;
				regexPatterns.put(regex, pattern);
			}
//			else {
//				System.out.println("Re-use " + regex);
//			}
			return pattern;
		}
	}

	@Override
	public @NonNull StandardLibrary getStandardLibrary() {
		return standardLibrary;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value) {
		return getIdResolver().getStaticTypeOf(value);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
		return getIdResolver().getStaticTypeOf(value, values);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
		return getIdResolver().getStaticTypeOf(value, values);
	}

//	public @NonNull ValueFactory getValueFactory() {
//		if (isCanceled) {
//			throw new EvaluationHaltedException("Canceled"); //$NON-NLS-1$
//		}
//		return valueFactory;
//	}

	@Override
	public boolean isCanceled() {
		return isCanceled;
	}

	@Override
	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	@Override
	public void setLogger(@Nullable DomainLogger logger) {
		/* ignored */;
	}
	
/*	public DomainType typeOf(Value value, Value... values) {
		DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
		DomainType type = value.getType(standardLibrary);
		for (Value anotherValue : values) {
			DomainType anotherType = anotherValue.getType(standardLibrary);
			type = type.getCommonType(standardLibrary, anotherType);
		}
		return type;
	} */

//	public @NonNull NullValue throwInvalidEvaluation(InvalidValueException e) {
//		throw new InvalidEvaluationException(null, e);
//	}

//	public @NonNull NullValue throwInvalidEvaluation(Throwable e, DomainExpression expression, Object context,
//			String message, Object... bindings) {
//		throw new InvalidEvaluationException(null, NLS.bind(message, bindings), e, expression, context);
//	}
}
