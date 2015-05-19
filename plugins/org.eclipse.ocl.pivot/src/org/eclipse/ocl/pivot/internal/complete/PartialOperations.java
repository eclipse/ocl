/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.complete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

public class PartialOperations //extends HashMap<ParametersId, List<DomainOperation>>
{
//	private static final long serialVersionUID = 1L;
	public static final @NonNull Function<PartialOperations, Iterable<Iterable<Operation>>> partialOperations2allOperations =
			new Function<PartialOperations, Iterable<Iterable<Operation>>>() {

		@Override
		public Iterable<Iterable<Operation>> apply(PartialOperations partialOperations) {
			return partialOperations.getOperationsInternal(null);
		}
	};
	
	/**
	 * An OverloadsList is a non-empty list of Operations sharing the same name and parameter types.
	 * It can be sorted into most-derived first order.
	 */
	private static class OverloadsList extends ArrayList<Operation> implements Comparator<Integer>
	{
		private static final long serialVersionUID = 1L;

		private Integer[] keys;
		private Integer[] metrics;

		public OverloadsList() {
			super(4);
		}

		@Override
		public int compare(Integer o1, Integer o2) {
			Integer m1 = metrics[o1];
			Integer m2 = metrics[o2];
			return m2 - m1;
		}

		public void sort(@NonNull EnvironmentFactory environmentFactory) {
			StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
			int size = size();
			keys = new Integer[size];
			metrics = new Integer[size];
			Integer index = 0;
			for (Operation operation : this) {
				keys[index] = index;
				int metric = 0;
				if (operation != null) {
					org.eclipse.ocl.pivot.Class owningClass = operation.getOwningClass();
					CompleteInheritance inheritance = owningClass.getInheritance(standardLibrary);
					int depth = inheritance.getDepth();
//					int isRedefinition = (operation instanceof Operation) && (((Operation)operation).getRedefinedOperation().size() > 0) ? 1 : 0;
					metric = depth;
				}
				metrics[index] = metric;
				index++;
			}
			Arrays.sort(keys, this);
			List<Operation> savedOperations = new ArrayList<Operation>(this);
			clear();
			for (int i = 0; i < size; i++) {
				add(savedOperations.get(keys[i]));
			}
			keys = null;
			metrics = null;
		}
	}

	/**
	 * Overloads maintains the distinct OverloadsLists for static and non-static operations
	 * that share the same name and parameter types.
	 */
	private class Overloads implements Iterable<Operation>
	{
		private @Nullable OverloadsList staticOperations = null;
		private @Nullable OverloadsList nonStaticOperations = null;
		private boolean sorted = false;

		public void add(@NonNull Operation pivotOperation) {
			OverloadsList list;
			if (pivotOperation.isIsStatic()) {
				if (staticOperations == null) {
					staticOperations = new OverloadsList();
				}
				list = staticOperations;
			}
			else {
				if (nonStaticOperations == null) {
					nonStaticOperations = new OverloadsList();
				}
				list = nonStaticOperations;
			}
			assert list != null;
			if (!list.contains(pivotOperation)) {
				list.add(pivotOperation);
				sorted = false;
			}
		}

		public @NonNull Operation getBest() {
			OverloadsList list = nonStaticOperations != null ? nonStaticOperations : staticOperations;
			assert list != null;
			if ((list.size() > 1) && !sorted) {
				// FIXME redefinitions
				EnvironmentFactory environmentFactory = completeClass.getOwningCompletePackage().getCompleteModel().getEnvironmentFactory();
				if (nonStaticOperations != null) {
					nonStaticOperations.sort(environmentFactory);
				}
				if (staticOperations != null) {
					staticOperations.sort(environmentFactory);
				}
				sorted = true;
			}
			Operation bestOperation = list.get(0);
			assert bestOperation != null;
			return bestOperation;
		}

		@Override
		public Iterator<Operation> iterator() {
			OverloadsList staticOperations2 = staticOperations;
			OverloadsList nonStaticOperations2 = nonStaticOperations;
			if (staticOperations2 != null) {
				if (nonStaticOperations2 != null) {
					return Iterators.concat(nonStaticOperations2.iterator(), staticOperations2.iterator());
				}
				else {
					return staticOperations2.iterator();
				}
			}
			else {
				if (nonStaticOperations2 != null) {
					return nonStaticOperations2.iterator();
				}
				else {
					return Iterators.emptyIterator();
				}
			}
		}
		
		public boolean remove(@NonNull Operation pivotOperation) {
			if (pivotOperation.isIsStatic()) {
				OverloadsList staticOperations2 = staticOperations;
				if (staticOperations2 != null) {
					boolean remove = staticOperations2.remove(pivotOperation);
					if (staticOperations2.isEmpty()) {
						staticOperations = null;
					}
					return remove;
				}
			}
			else {
				OverloadsList nonStaticOperations2 = nonStaticOperations;
				if (nonStaticOperations2 != null) {
					boolean remove = nonStaticOperations2.remove(pivotOperation);
					if (nonStaticOperations2.isEmpty()) {
						nonStaticOperations = null;
					}
					return remove;
				}
			}
			return false;
		}
		
		public int size() {
			OverloadsList staticOperations2 = staticOperations;
			OverloadsList nonStaticOperations2 = nonStaticOperations;
			return (staticOperations2 != null ? staticOperations2.size() : 0) + (nonStaticOperations2 != null ? nonStaticOperations2.size() : 0);
		}
	}

	protected final @NonNull CompleteClassInternal completeClass;
	protected final @NonNull String name;
	private final @NonNull Map<ParametersId, Object> map = new HashMap<ParametersId, Object>();
	
	public PartialOperations(@NonNull CompleteClassInternal completeClass, @NonNull String name) {
		this.completeClass = completeClass;
		this.name = name;
	}

	public void didAddOperation(@NonNull Operation pivotOperation) {
		ParametersId parametersId = pivotOperation.getParametersId();
		Object partials = map.get(parametersId);
		if (partials instanceof Overloads) {
			Overloads overloads = (Overloads)partials;
			overloads.add(pivotOperation);
		}
		else if (partials != null) {		// Must be an Operation
			if (partials != pivotOperation) {
				Overloads overloads = new Overloads();
				map.put(parametersId, overloads);
				overloads.add((Operation)partials);
				overloads.add(pivotOperation);
			}
		}
		else {
			map.put(parametersId, pivotOperation);
		}
	}

	public boolean didRemoveOperation(@NonNull Operation pivotOperation) {
		ParametersId parametersId = pivotOperation.getParametersId();
		Object partials = map.get(parametersId);
		if (partials instanceof Overloads) {
			Overloads overloads = (Overloads)partials;
			overloads.remove(pivotOperation);
			if (overloads.size() == 1) {
				map.put(parametersId, overloads.getBest());
			}
			else if (overloads.size() <= 0) {
				map.remove(parametersId);		// Never happens
			}
		}
		else if (partials != null) {			// Must be an Operation
			map.remove(parametersId);
		}
		else {
			map.put(parametersId, pivotOperation);
		}
		return map.isEmpty();
	}

	public @Nullable Operation getOperation(@NonNull ParametersId parametersId, @Nullable FeatureFilter featureFilter) {
		Object partials = map.get(parametersId);
		if (partials instanceof Overloads) {
			Overloads overloads = (Overloads)partials;
			Operation bestOperation = overloads.getBest();
			if (featureFilter == null) {
				return bestOperation;
			}
			for (Operation operation : overloads) {
				if ((operation != null) && featureFilter.accept(operation)) {
					return operation;
				}
			}
			return null;
		}
		else if (partials != null) {			// Must be an Operation
			Operation operation = (Operation) partials;
			return (featureFilter == null) || featureFilter.accept(operation) ? operation : null;
		}
		else {
			return null;
		}
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<Operation> getOperationOverloads(@NonNull ParametersId parametersId, final @Nullable FeatureFilter featureFilter) {
		Object partials = map.get(parametersId);
		if (partials instanceof Overloads) {
			Overloads overloads = (Overloads)partials;
			overloads.getBest();
			if (featureFilter == null) {
				return overloads;
			}
			return Iterables.filter(overloads, new Predicate<Operation>()
				{
					@Override
					public boolean apply(Operation input) {
						return featureFilter.accept(input);
					}
				});
		}
		else if (partials != null) {			// Must be an Operation
			Operation operation = (Operation) partials;
			if ((featureFilter == null) || featureFilter.accept(operation)) {
				return Collections.singletonList((Operation)partials);
			}
		}
		return Collections.emptyList();
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<Operation> getOperationOverloads(final @Nullable FeatureFilter featureFilter) {
		Iterable<Operation> unfilteredOverloads = Iterables.concat(Iterables.transform(map.keySet(), new Function<ParametersId, Iterable<Operation>>()
		{
			@Override
			public Iterable<Operation> apply(ParametersId parametersId) {
				assert parametersId != null;
				return getOperationOverloads(parametersId, featureFilter);
			}
		}));
		if (featureFilter == null) {
			return unfilteredOverloads;
		}
		return Iterables.filter(unfilteredOverloads, new Predicate<Operation>()
		{
			@Override
			public boolean apply(Operation input) {
				return featureFilter.accept(input);
			}
		});
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<? extends Operation> getOperations(final @Nullable FeatureFilter featureFilter) {
//		if (featureFilter == FeatureFilter.SELECT_NON_STATIC) {
//			return 
//		}
		return Iterables.transform(map.keySet(), new Function<ParametersId, Operation>()
		{
			@Override
			public Operation apply(ParametersId parametersId) {
				return getOperation(parametersId, featureFilter);
			}
		});
	}

	@SuppressWarnings("null")
	private @NonNull Iterable<Iterable<Operation>> getOperationsInternal(final @Nullable FeatureFilter featureFilter) {
		return Iterables.transform(map.keySet(), new Function<ParametersId, Iterable<Operation>>()
		{
			@Override
			public Iterable<Operation> apply(ParametersId parametersId) {
				assert parametersId != null;
				return getOperationOverloads(parametersId, featureFilter);
			}
		});
	}

	public void initMemberOperationsPostProcess() {
		for (Object partials : map.values()) {
			if (partials instanceof Overloads) {
				Overloads overloads = (Overloads)partials;
				initMemberOperationsPostProcess(completeClass.getName(), overloads);
			}
		}
	}

	protected void initMemberOperationsPostProcess(String name, @NonNull Overloads operations) {
		if (operations.size() > 1) {
			
		}
	}
}