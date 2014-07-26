/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.domain.elements.DomainFragment;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.ParametersId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.AbstractFragment;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ReflectiveType;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Region;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.StateMachine;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.Vertex;
import org.eclipse.ocl.examples.pivot.executor.PivotReflectiveFragment;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView.Disambiguator;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

/**
 * An AbstractTypeServer provides the co-ordinated operation, property and superclass lookup caches for one or more merged types.
 */
public abstract class AbstractTypeServer extends ReflectiveType implements TypeServer
{
	public static final @NonNull TracingOption ADD_BASE_PROPERTY = new TracingOption(PivotPlugin.PLUGIN_ID, "typeServer/addBaseProperty");
	public static final @NonNull TracingOption ADD_EXTENSION_PROPERTY = new TracingOption(PivotPlugin.PLUGIN_ID, "typeServer/addExtensionProperty");
	public static final @NonNull TracingOption INIT_MEMBER_OPERATIONS = new TracingOption(PivotPlugin.PLUGIN_ID, "typeServer/initMemberOperations");
	public static final @NonNull TracingOption INIT_MEMBER_PROPERTIES = new TracingOption(PivotPlugin.PLUGIN_ID, "typeServer/initMemberProperties");
	
	/**
	 * @since 3.5
	 */
	public static Function<Map<ParametersId, List<DomainOperation>>, Collection<List<DomainOperation>>> mergeFunction = 
			new Function<Map<ParametersId, List<DomainOperation>>, Collection<List<DomainOperation>>>() {

		public Collection<List<DomainOperation>> apply(Map<ParametersId, List<DomainOperation>> input) {
			return input.values();
		}
	};

	public static final class BestOperation implements Function<List<DomainOperation>, DomainOperation> {

		public DomainOperation apply(List<DomainOperation> operations) {
			return operations.get(0);
		}
	}

	public static final class MapValues implements Function<Map<ParametersId, List<DomainOperation>>, Iterable<List<DomainOperation>>> {

		public Iterable<List<DomainOperation>> apply(Map<ParametersId, List<DomainOperation>> operations) {
			return operations.values();
		}
	}
	
	public class PartialProperties implements Iterable<DomainProperty>
	{
		//resolution = null, partials = null or empty => empty
		// resolution = X, partials = null or empty or [X} => X
		// resolution = null, partials not empty => lazy unresolved 'ambiguity'
		private boolean isResolved = false;
		private @Nullable DomainProperty resolution = null;
		private @Nullable List<DomainProperty> partials = null;

		public synchronized void add(@NonNull DomainProperty pivotProperty) {
			List<DomainProperty> partials2 = partials;
			if (partials2 == null) {
				if (resolution == null) {
					resolution = pivotProperty;
					isResolved = true;
				}
				else {
					partials = partials2 = new ArrayList<DomainProperty>();
					partials2.add(resolution);
					if (resolution != pivotProperty) {
						partials2.add(pivotProperty);
					}
					resolution = null;
					isResolved = false;
				}
			}
			else if (partials2.isEmpty()) {
				if (resolution == null) {
					resolution = pivotProperty;
					isResolved = true;
				}
				else {
					partials2.add(resolution);
					if (resolution != pivotProperty) {
						partials2.add(pivotProperty);
					}
					resolution = null;
					isResolved = false;
				}
			}
			else {
				if (!partials2.contains(pivotProperty)) {
					partials2.add(pivotProperty);
				}
				resolution = null;
				isResolved = false;
			}
		}

		public synchronized @Nullable DomainProperty get() {
			if (isResolved) {
				return resolution;
			}
			resolve();
			if (isResolved) {
				return resolution;
			}
			List<DomainProperty> values = new ArrayList<DomainProperty>(partials);
			MetaModelManager metaModelManager = getStandardLibrary();
			Map<DomainType, DomainProperty> primaryProperties = new HashMap<DomainType, DomainProperty>();
			for (DomainProperty property : values) {
				if (property != null) {
					DomainType owningType = property.getOwningType();
					if (owningType != null) {
						DomainType domainType = metaModelManager.getPrimaryType(owningType);
						if (!primaryProperties.containsKey(domainType)) {
							primaryProperties.put(domainType, property);	// FIXME something more deterministic than first
						}
					}
				}
			}
			if (primaryProperties.size() == 1) {
				resolution = primaryProperties.values().iterator().next();
				isResolved = true;
				return resolution;
			}
			isResolved = true;
			resolution = null;
			return resolution;
		}

		public synchronized boolean isEmpty() {
			if (resolution != null) {
				return false;
			}
			List<DomainProperty> partials2 = partials;
			if (partials2 == null) {
				return true;
			}
			return partials2.size() <= 0;
		}

		@SuppressWarnings("null")
		public @NonNull Iterator<DomainProperty> iterator() {
			if (!isResolved) {
				resolve();
			}
			if (resolution != null) {
				return Iterators.singletonIterator(resolution);
			}
			else if (partials != null) {
				return partials.iterator();
			}
			else {
				return Iterators.emptyIterator();
			}
		}
		
		public synchronized void remove(@NonNull DomainProperty pivotProperty) {
			if (pivotProperty == resolution) {
				resolution = null;
			}
			if (partials != null) {
				partials.remove(pivotProperty);
			}
		}

		private void resolve() {
			assert !isResolved;
			List<DomainProperty> partials2 = partials;
			if (partials2 == null) {
				return;
			}
			int size = partials2.size();
			if (size <= 0) {
				return;
			}
			if (size == 1) {
				isResolved = true;
				resolution = partials2.get(0);
			}
			List<DomainProperty> values = new ArrayList<DomainProperty>(partials);
			for (int i = 0; i < values.size()-1;) {
				boolean iRemoved = false;
				@SuppressWarnings("null") @NonNull DomainProperty iValue = values.get(i);
				for (int j = i + 1; j < values.size();) {
					Class<? extends DomainProperty> iClass = iValue.getClass();
					@SuppressWarnings("null") @NonNull DomainProperty jValue = values.get(j);
					Class<? extends DomainProperty> jClass = jValue.getClass();
					int verdict = 0;
					for (Class<?> key : EnvironmentView.getDisambiguatorKeys()) {
						if (key.isAssignableFrom(iClass) && key.isAssignableFrom(jClass)) {
							List<Comparator<Object>> disambiguators = EnvironmentView.getDisambiguators(key);
							if (disambiguators != null) {
								for (Comparator<Object> comparator : disambiguators) {
									if (comparator instanceof Disambiguator<?>) {
										verdict = ((Disambiguator<Object>)comparator).compare(getStandardLibrary(), iValue, jValue);
									}
									else {
										verdict = comparator.compare(iValue, jValue);
									}
									if (verdict != 0) {
										break;
									}
								}
							}
							if (verdict != 0) {
								break;
							}
						}
					}
					if (verdict == 0) {
						j++;
					} else if (verdict < 0) {
						values.remove(i);
						iRemoved = true;
						break;
					} else {
						values.remove(j);
					}
				}
				if (!iRemoved) {
					i++;
				}
			}
			if (values.size() == 1) {
				resolution = values.get(0);
				isResolved = true;
				return;
			}
		}

		@Override
		public String toString() {
			if (resolution != null) {
				return resolution.toString();
			}
			List<DomainProperty> partials2 = partials;
			if (partials2 == null) {
				return "";
			}
			StringBuilder s = new StringBuilder();
			for (DomainProperty dProperty : partials2) {
				if (s.length() > 0) {
					s.append(",");
				}
				s.append(dProperty.toString());
			}
			return s.toString();
		}
	}

	public static final @NonNull BestOperation bestOperation = new BestOperation();
	public static final @NonNull MapValues MAP_VALUES = new MapValues();	

	protected static class QualifiedName2DomainInheritance implements Function<String, DomainInheritance>
	{
		protected final @NonNull Map<String, DomainInheritance> name2superclasses;
		
		protected QualifiedName2DomainInheritance(@NonNull Map<String, DomainInheritance> name2superclasses) {
			this.name2superclasses = name2superclasses;
		}

		public DomainInheritance apply(String qualifiedClassName) {
			return name2superclasses.get(qualifiedClassName);
		}
	}

	public static @NonNull TemplateParameterSubstitution createTemplateParameterSubstitution(@NonNull TemplateParameter formalParameter, @NonNull ParameterableElement type) {
		TemplateParameterSubstitution templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
		templateParameterSubstitution.setFormal(formalParameter);
		if (type.eResource() == null) {
			templateParameterSubstitution.setOwnedActual(type);
		}
		else {
			templateParameterSubstitution.setActual(type);
		}
		return templateParameterSubstitution;
	}

	protected final @NonNull PackageServer packageServer;
	protected final @NonNull PackageManager packageManager;

	/**
	 * Lazily created map from class name to the superclass. This is a map from unqualified name to
	 * class for the normal case when all superclass names are distinct. However if any two superclasses
	 * including this class share a name, all superclasses are mapped by qualified name, and the
	 * name2qualifiedNames provides an additional mapping of the ambiguities.
	 */
	private @Nullable Map<String, DomainInheritance> name2superclasses = null;

	/**
	 * Lazily created map from class name to the list of qualified names for same-named super-classes.
	 * This list is only non-null if a class has two same-named superclasses that need disambiguation..
	 */
	private @Nullable Map<String, List<String>> name2qualifiedNames = null;

	/**
	 * Lazily created map from operation name to map of parameter types to the list of partial operations to be treated as merged.
	 */
	private @Nullable Map<String, Map<ParametersId, List<DomainOperation>>> name2operations = null;

	/**
	 * Lazily created map from property name to the list of properties to be treated as merged. 
	 */
	private @Nullable Map<String, PartialProperties> name2properties = null;

	/**
	 * Lazily created map from state name to the known state. 
	 */
	private @Nullable Map<String, State> name2states = null;
	
	protected final @NonNull DomainType domainType;
	protected @Nullable TypeId typeId = null;
	

	protected AbstractTypeServer(@NonNull PackageServer packageServer, @NonNull DomainType domainType) {
		super(DomainUtil.nonNullModel(domainType.getName()), packageServer, computeFlags(domainType));
		this.packageServer = packageServer;
		this.packageManager = packageServer.getPackageManager();
		this.domainType = domainType;
	}

	void addedMemberOperation(@NonNull DomainOperation pivotOperation) {
		Map<String, Map<ParametersId, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 != null) {
			String operationName = pivotOperation.getName();
			Map<ParametersId, List<DomainOperation>> overloads = name2operations2.get(operationName);
			if (overloads == null) {
				overloads = new HashMap<ParametersId, List<DomainOperation>>();
				name2operations2.put(operationName, overloads);
			}
			ParametersId parametersId = pivotOperation.getParametersId();
			List<DomainOperation> partials = overloads.get(parametersId);
			if (partials == null) {
				partials = new ArrayList<DomainOperation>();
				overloads.put(parametersId, partials);
			}
			if (!partials.contains(pivotOperation)) {
				partials.add(pivotOperation);
			}
		}
	}

	void addedMemberProperty(@NonNull DomainProperty pivotProperty) {
		Map<String, PartialProperties> name2properties2 = name2properties;
		if (name2properties2 != null) {
			String propertyName = pivotProperty.getName();
			PartialProperties partials = name2properties2.get(propertyName);
			if (partials == null) {
				partials = new PartialProperties();
				name2properties2.put(propertyName, partials);
			}
			partials.add(pivotProperty);
		}
	}

	void changedInheritance() {
//		if (executorType != null) {
			/*executorType.*/uninstall();
//			executorType = null;
//		}
	}

	@Override
	protected @NonNull AbstractFragment createFragment(@NonNull DomainInheritance baseInheritance) {
		return new PivotReflectiveFragment(this, baseInheritance);
	}

	@Override
	public void dispose() {
		Map<String, PartialProperties> name2properties2 = name2properties;
		if (name2properties2 != null) {
			name2properties2.clear();
			name2properties = null;
		}
		Map<String, Map<ParametersId, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 != null) {
			name2operations2.clear();
			name2operations = null;
		}
//		if (executorType != null) {
//			executorType.dispose();
//			executorType = null;
//		}
	}
	
/*	private @Nullable List<DomainOperation> findOverload(@NonNull List<List<DomainOperation>> overloads, @NonNull DomainOperation requiredOperation) {
		if (requiredOperation instanceof Iteration) {
			List<Parameter> requiredParameters = ((Iteration)requiredOperation).getOwnedIterator();
			MetaModelManager metaModelManager = packageManager.getMetaModelManager();
			int requiredSize = requiredParameters.size();
			for (List<DomainOperation> overload : overloads) {
				if (overload.size() > 0) {
					DomainOperation operation = overload.get(0);
					List<Parameter> actualParameters = ((Iteration)operation).getOwnedIterator();
					if (requiredSize == actualParameters.size()) {
						boolean gotIt = true;
						for (int i = 0; i < requiredSize; i++) {
							Parameter requiredParameter = DomainUtil.nonNullEntry(requiredParameters.get(i));
							Parameter actualParameter = DomainUtil.nonNullEntry(actualParameters.get(i));
							Type requiredType = metaModelManager.getTypeWithMultiplicity(requiredParameter);
							Type actualType = metaModelManager.getTypeWithMultiplicity(actualParameter);
							if (requiredType != actualType) {
								gotIt = false;
								break;
							}
						}
						if (gotIt) {
							return overload;
						}
					}
				}
			}			
			return null;
		}
		else {
			IndexableDomainParameterTypes requiredParameters = requiredOperation.getParameterType();
			MetaModelManager metaModelManager = packageManager.getMetaModelManager();
			int requiredSize = requiredParameters.size();
			for (List<DomainOperation> overload : overloads) {
				if (overload.size() > 0) {
					DomainOperation operation = overload.get(0);
					IndexableDomainParameterTypes actualParameters = operation.getParameterType();
					if (requiredSize == actualParameters.size()) {
						boolean gotIt = true;
						for (int i = 0; i < requiredSize; i++) {
							DomainType requiredParameter = DomainUtil.nonNullEntry(requiredParameters.get(i));
							DomainType actualParameter = DomainUtil.nonNullEntry(actualParameters.get(i));
							Type requiredType = metaModelManager.getType/ *WithMultiplicity* /(requiredParameter);		// FIXME
							Type actualType = metaModelManager.getType/ *WithMultiplicity* /(actualParameter);
							if (requiredType != actualType) {
								gotIt = false;
								break;
							}
						}
						if (gotIt) {
							return overload;
						}
					}
				}
			}			
			return null;
		}
	} */

	public @NonNull Iterable<? extends DomainOperation> getAllOperations(final @Nullable FeatureFilter featureFilter) {
		Map<String, Map<ParametersId, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 == null) {
			name2operations2 = initMemberOperations();
		}
		Iterable<Map<ParametersId, List<DomainOperation>>> itMapListOps = name2operations2.values();
		@SuppressWarnings("null")@NonNull Iterable<Iterable<List<DomainOperation>>> itItListOps = Iterables.transform(itMapListOps, MAP_VALUES);
		@SuppressWarnings("null")@NonNull Iterable<List<DomainOperation>> itListOps = Iterables.concat(itItListOps);
		@SuppressWarnings("null")@NonNull Iterable<DomainOperation> itOps = Iterables.concat(itListOps);
		if (featureFilter == null) {
			return itOps;
		}
		@SuppressWarnings("null")@NonNull Iterable<DomainOperation> subItOps = Iterables.filter(itOps,
			new Predicate<DomainOperation>()
			{
				public boolean apply(DomainOperation domainOperation) {
					return (domainOperation != null) && featureFilter.accept(domainOperation);
				}
			});
		return subItOps;
	}
	

	public @NonNull Iterable<? extends DomainOperation> getAllOperations(final @Nullable FeatureFilter featureFilter, @NonNull String name) {
		Map<String, Map<ParametersId, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 == null) {
			name2operations2 = initMemberOperations();
		}
		Map<ParametersId, List<DomainOperation>> overloads = name2operations2.get(name);
		if ((overloads == null) || overloads.isEmpty()) {
			return MetaModelManager.EMPTY_OPERATION_LIST;
		}
		@SuppressWarnings("null")@NonNull Iterable<DomainOperation> transform = Iterables.concat(overloads.values()); //, bestOperation);
		if (featureFilter == null) {
			return transform;
		}
		@SuppressWarnings("null")@NonNull Iterable<DomainOperation> subItOps = Iterables.filter(transform,
			new Predicate<DomainOperation>()
			{
				public boolean apply(DomainOperation domainOperation) {
					return (domainOperation != null) && featureFilter.accept(domainOperation);
				}
			});
//		for (DomainOperation op : subItOps) {
//			if (op instanceof EObject) {
//				assert ((EObject)op).eResource() != null;
//			}
//		}
		return subItOps;
	}

	public @NonNull Iterable<? extends DomainProperty> getAllProperties(final @Nullable FeatureFilter featureFilter) {
		Map<String, PartialProperties> name2properties2 = name2properties;
		if (name2properties2 == null) {
			name2properties2 = initMemberProperties();
		}
		@SuppressWarnings("null")@NonNull Iterable<DomainProperty> transform = Iterables.transform(name2properties2.values(),
			new Function<PartialProperties, DomainProperty>()
			{
				public DomainProperty apply(PartialProperties properties) {
					return properties.get();
				}
			});
		if (featureFilter == null) {
			return transform;
		}
		@SuppressWarnings("null")
		@NonNull Iterable<DomainProperty> subItOps = Iterables.filter(transform,
			new Predicate<DomainProperty>()
			{
				public boolean apply(DomainProperty domainProperty) {
					return (domainProperty != null) && featureFilter.accept(domainProperty);
				}
			});
		return subItOps;
	}

	public @NonNull Iterable<? extends DomainProperty> getAllProperties(final @Nullable FeatureFilter featureFilter, @NonNull String name) {
		Map<String, PartialProperties> name2properties2 = name2properties;
		if (name2properties2 == null) {
			name2properties2 = initMemberProperties();
		}
		PartialProperties partials = name2properties2.get(name);
		if ((partials == null) || partials.isEmpty()) {
			return MetaModelManager.EMPTY_PROPERTY_LIST;
		}
//		@SuppressWarnings("null")
//		@NonNull List<DomainProperty> singletonList = partials; //Collections.singletonList(partials.get(0));
		if (featureFilter == null) {
			return partials;
		}
		@SuppressWarnings("null")@NonNull Iterable<DomainProperty> subItOps = Iterables.filter(partials,
			new Predicate<DomainProperty>()
			{
				public boolean apply(DomainProperty domainProperty) {
					return (domainProperty != null) && featureFilter.accept(domainProperty);
				}
			});
		return subItOps;
	}

	public @NonNull Iterable<? extends State> getAllStates() {
		Map<String, State> name2states2 = name2states;
		if (name2states2 == null) {
			name2states2 = initStates();
		}
		@SuppressWarnings("null")
		@NonNull Collection<State> values = name2states2.values();
		return values;
	}

	public @NonNull Iterable<? extends State> getAllStates(@NonNull String name) {
		Map<String, State> name2states2 = name2states;
		if (name2states2 == null) {
			name2states2 = initStates();
		}
		State state = name2states2.get(name);
		if (state == null) {
			return MetaModelManager.EMPTY_STATE_LIST;
		}
		else {
			@SuppressWarnings("null")@NonNull List<State> singletonList = Collections.singletonList(state);
			return singletonList;
		}
	}

	public @NonNull Iterable<? extends DomainInheritance> getAllSuperClasses() {
		Map<String, DomainInheritance> name2superclasses2 = name2superclasses;
		if (name2superclasses2 == null) {
			name2superclasses2 = initSuperClasses();
		}
		@SuppressWarnings("null")
		@NonNull Collection<DomainInheritance> values = name2superclasses2.values();
		return values;
	}

	public @NonNull Iterable<? extends DomainInheritance> getAllSuperClasses(@NonNull String className) {
		Map<String, DomainInheritance> name2superclasses2 = name2superclasses;
		if (name2superclasses2 == null) {
			name2superclasses2 = initSuperClasses();
		}
		final Map<String, List<String>> name2qualifiedNames2 = name2qualifiedNames;
		if (name2qualifiedNames2 == null) {
			DomainInheritance typeServer = name2superclasses2.get(className);
			if (typeServer == null) {
				return MetaModelManager.EMPTY_TYPE_SERVER_LIST;
			}
			@SuppressWarnings("null")
			@NonNull List<DomainInheritance> asList = Arrays.asList(typeServer);
			return asList;
		}
		else {
			List<String> qualifiedNames = name2qualifiedNames2.get(className);
			if (qualifiedNames == null) {
				return MetaModelManager.EMPTY_TYPE_SERVER_LIST;
			}
			else {
				@SuppressWarnings("null")
				@NonNull Iterable<DomainInheritance> transform = Iterables.transform(qualifiedNames, new QualifiedName2DomainInheritance(name2superclasses2));
				return transform;
			}
		}
	}

	protected @NonNull Map<String, State> initStates() {
		Map<String, State> name2states = new HashMap<String, State>();
		for (DomainInheritance superInheritance : getAllSuperClasses()) {
			TypeServer superTypeServer = null;
			if (superInheritance instanceof TypeServer) {
				superTypeServer = (TypeServer)superInheritance;
			}
			else if (superInheritance != null) {
				superTypeServer = packageManager.getTypeServer(superInheritance);
			}
			if (superTypeServer != null) {
				for (DomainType superType : superTypeServer.getPartialTypes()) {
					assert superType != null;
					if (superType instanceof org.eclipse.ocl.examples.pivot.Class) {
						org.eclipse.ocl.examples.pivot.Class superClass = (org.eclipse.ocl.examples.pivot.Class)superType;
						for (Behavior behavior : superClass.getOwnedBehavior()) {
							if (behavior instanceof StateMachine) {
								@SuppressWarnings("null")@NonNull List<Region> regions = ((StateMachine)behavior).getRegion();
								initStatesForRegions(name2states, regions);
							}
						}
					}
				}
			}
		}
		return name2states;
	}
	protected void initStatesForRegions(@NonNull Map<String, State> name2states, @NonNull List<Region> regions) {
		for (Region region : regions) {
			for (Vertex vertex : region.getSubvertex()) {
				if (vertex instanceof State) {
					State state = (State) vertex;
					name2states.put(vertex.getName(), state);
					@SuppressWarnings("null")@NonNull List<Region> nestedRegions = state.getRegion();
					initStatesForRegions(name2states, nestedRegions);
				}
			}
		}
	}

	@Override
	public @NonNull Iterable<? extends DomainInheritance> getInitialSuperInheritances() {
		final @NonNull MetaModelManager metaModelManager = packageManager.getMetaModelManager();
		final Iterator<Type> iterator = metaModelManager.getSuperClasses(getPivotType()).iterator();			// FIXME Use local cache
		return new Iterable<DomainInheritance>()
		{
			public Iterator<DomainInheritance> iterator() {
				return new Iterator<DomainInheritance>()
				{
					public boolean hasNext() {
						return iterator.hasNext();
					}

					public DomainInheritance next() {
						return iterator.next().getInheritance(metaModelManager);
					}

					public void remove() {
						throw new UnsupportedOperationException();
					}					
				};
			}			
		};
	}
	
	public @NonNull List<? extends DomainOperation> getLocalOperations() {
		return DomainUtil.nonNullEMF(getPivotType().getOwnedOperation());			// FIXME Use local cache
	}

	public @NonNull List<? extends DomainProperty> getLocalProperties() {
		return DomainUtil.nonNullEMF(getPivotType().getOwnedAttribute());			// FIXME Use local cache
	}

	public @NonNull List<? extends DomainType> getLocalSuperTypes() {
		return DomainUtil.nonNullEMF(getPivotType().getSuperClass());			// FIXME Use local cache
	}

	@Override
	public @Nullable DomainOperation getMemberOperation(@NonNull OperationId operationId) {
		Map<String, Map<ParametersId, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 == null) {
			name2operations2 = initMemberOperations();
		}
		String operationName = operationId.getName();
		Map<ParametersId, List<DomainOperation>> overloads = name2operations2.get(operationName);
		if (overloads == null) {
			return null;
		}
		ParametersId parametersId = operationId.getParametersId();
		List<DomainOperation> partials = overloads.get(parametersId);
		return (partials == null) || partials.isEmpty() ? null : partials.get(0);
	}

	public @Nullable DomainOperation getMemberOperation(@NonNull DomainOperation pivotOperation) {
		Map<String, Map<ParametersId, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 == null) {
			name2operations2 = initMemberOperations();
		}
		String operationName = pivotOperation.getName();
		Map<ParametersId, List<DomainOperation>> overloads = name2operations2.get(operationName);
		if (overloads == null) {
			return null;
		}
		ParametersId parametersId = pivotOperation.getParametersId();
		List<DomainOperation> partials = overloads.get(parametersId);
		return (partials == null) || partials.isEmpty() ? null : partials.get(0);
	}
	
	/**
	 * @since 3.5
	 */
	public @NonNull Iterable<String> getMemberOperationNames() {
		Map<String, Map<ParametersId, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 == null) {
			name2operations2 = initMemberOperations();
		}
		return name2operations2.keySet();
	}

	/**
	 * @since 3.5
	 */
	public @Nullable Iterable<DomainOperation> getMemberOperations(@NonNull DomainOperation pivotOperation) {
		Map<String, Map<ParametersId, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 == null) {
			name2operations2 = initMemberOperations();
		}
		String operationName = pivotOperation.getName();
		Map<ParametersId, List<DomainOperation>> overloads = name2operations2.get(operationName);
		if (overloads == null) {
			return null;
		}
		ParametersId parametersId = pivotOperation.getParametersId();
		return overloads.get(parametersId);
	}
	
	/**
	 * @since 3.5
	 */
	public @NonNull Iterable<DomainOperation> getMemberOperations() {
		Map<String, Map<ParametersId, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 == null) {
			name2operations2 = initMemberOperations();
		}
		Iterable<Collection<List<DomainOperation>>> transformed = Iterables.transform(name2operations2.values(), mergeFunction);
		Iterable<DomainOperation> concat = Iterables.concat(Iterables.concat(transformed));
		return concat;
	}

	public @Nullable Iterable<DomainProperty> getMemberProperties(@NonNull DomainProperty pivotProperty) {
		Map<String, PartialProperties> name2properties2 = name2properties;
		if (name2properties2 == null) {
			name2properties2 = initMemberProperties();
		}
		String propertyName = pivotProperty.getName();
		return name2properties2.get(propertyName);
	}

	public @Nullable Iterator<DomainProperty> getMemberProperties(@NonNull String propertyName) {
		Map<String, PartialProperties> name2properties2 = name2properties;
		if (name2properties2 == null) {
			name2properties2 = initMemberProperties();
		}
		PartialProperties partials = name2properties2.get(propertyName);
		if (partials == null) {
			return null;
		}
		return partials.iterator();
	}

	public @Nullable DomainProperty getMemberProperty(@NonNull String propertyName) {
		Map<String, PartialProperties> name2properties2 = name2properties;
		if (name2properties2 == null) {
			name2properties2 = initMemberProperties();
		}
		PartialProperties partials = name2properties2.get(propertyName);
		if (partials == null) {
			return null;
		}
		return partials.get();
	}

	public @NonNull String getMetaTypeName() {
		return getPivotType().getMetaTypeName();
	}

	public @NonNull List<? extends DomainProperty> getOwnedAttribute() {
		return DomainUtil.nonNullEMF(getPivotType().getOwnedAttribute());			// FIXME Use local cache
	}
	
	public @NonNull List<? extends DomainOperation> getOwnedOperation() {
		return DomainUtil.nonNullEMF(getPivotType().getOwnedOperation());			// FIXME Use local cache
	}

	public final @NonNull PackageManager getPackageManager() {
		return packageManager;
	}

	public PackageServer getPackageServer() {
		return packageServer;
	}

	public final @NonNull MetaModelManager getStandardLibrary() {
		return packageManager.getMetaModelManager();
	}
	
	@Override
	public final @NonNull TypeId getTypeId() {
		TypeId typeId2 = typeId;
		if (typeId2 == null) {
			typeId = typeId2 = domainType.getTypeId();
		}
		return typeId2;
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		return DomainTypeParameters.EMPTY_LIST;
	}

//	protected void initExtensionProperties(@NonNull ElementExtension elementExtension) {
//		Property extensionProperty = createExtensionProperty(elementExtension);
		// TODO Auto-generated method stub
		
//	}

	protected void initMemberFeaturesFrom(@NonNull DomainType pivotType) {
		if (name2operations != null) {
			initMemberOperationsFrom(pivotType);
		}	
		if (name2properties != null) {
			initMemberPropertiesFrom(pivotType);		// FIXME invalidate is safer
		}
	}

	private @NonNull Map<String, Map<ParametersId, List<DomainOperation>>> initMemberOperations() {
		Map<String, Map<ParametersId, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 == null) {
			name2operations2 = name2operations = new HashMap<String, Map<ParametersId, List<DomainOperation>>>();
			for (DomainInheritance superClass : getAllSuperClasses()) {
				TypeServer superTypeServer = null;
				if (superClass instanceof TypeServer) {
					superTypeServer = (TypeServer)superClass;
				}
				else if (superClass != null) {
					superTypeServer = packageManager.getTypeServer(superClass);
				}
				if (superTypeServer != null) {
					for (DomainType superType : superTypeServer.getPartialTypes()) {
						assert superType != null;
						if (superType instanceof Type) {
							Type unspecializedType = PivotUtil.getUnspecializedTemplateableElement((Type) superType);
							TypeServer unspecializedTypeServer = packageManager.getTypeServer(unspecializedType);
							for (DomainType unspecializedPartialType : unspecializedTypeServer.getPartialTypes()) {
								assert unspecializedPartialType != null;
								initMemberOperationsFrom(unspecializedPartialType);
							}
						}
						else {							
							initMemberOperationsFrom(superType);
						}
					}
				}
			}
			for (Map<ParametersId, List<DomainOperation>> overloads : name2operations2.values()) {
				for (List<DomainOperation> operations : overloads.values()) {
					if (operations != null) {
						initMemberOperationsPostProcess(name, operations);
					}
				}
			}
		}	
		return name2operations2;
	}

	private void initMemberOperationsFrom(@NonNull DomainType type) {
		if (INIT_MEMBER_OPERATIONS.isActive()) {
			INIT_MEMBER_OPERATIONS.println(this + " from " + type);
		}
		for (DomainOperation pivotOperation : type.getLocalOperations()) {
			if ((pivotOperation != null) && (pivotOperation.getName() != null)) {		// name may be null for partially initialized Complete OCL document.
				addedMemberOperation(pivotOperation);
			}
		}
	}

	protected void initMemberOperationsPostProcess(@NonNull String name, @NonNull List<DomainOperation> operations) {
		// TODO Auto-generated method stub // FIXME Prune occlusions		
	}

	protected @NonNull Map<String, PartialProperties> initMemberProperties() {
		Map<String, PartialProperties> name2properties2 = name2properties;
		if (name2properties2 == null) {
			name2properties2 = name2properties = new HashMap<String, PartialProperties>();
			List<ElementExtension> allExtensions = null;
			Set<Stereotype> extendingStereotypes = null;
			Set<Type> extendedTypes = null;
			for (DomainInheritance superClass : getAllSuperClasses()) {
				TypeServer superTypeServer = null;
				if (superClass instanceof TypeServer) {
					superTypeServer = (TypeServer)superClass;
				}
				else if (superClass != null) {
					superTypeServer = packageManager.getTypeServer(superClass);
				}
				if (superTypeServer != null) {
					for (DomainType superType : superTypeServer.getPartialTypes()) {
						assert superType != null;
						if (superType instanceof Type) {
							Type unspecializedType = PivotUtil.getUnspecializedTemplateableElement((Type) superType);
							List<TypeExtension> extendedBys = unspecializedType.getExtendedBys();
							if (extendedBys.size() > 0) {
								if (extendingStereotypes == null) {
									extendingStereotypes = new HashSet<Stereotype>();
								}
								for (TypeExtension typeExtension : extendedBys) {
									Stereotype stereotype = typeExtension.getStereotype();
									if (stereotype != null) {
										extendingStereotypes.add(stereotype);
									}
								}
							}
							if (unspecializedType instanceof Stereotype) {
								List<TypeExtension> extensionOfs = ((Stereotype)unspecializedType).getExtensionOfs();
								if (extensionOfs.size() > 0) {
									if (extendedTypes == null) {
										extendedTypes = new HashSet<Type>();
									}
									for (TypeExtension typeExtension : extensionOfs) {
										Type type = typeExtension.getType();
										if (type != null) {
											extendedTypes.add(type);
										}
									}
								}
							}
							TypeServer unspecializedTypeServer = packageManager.getTypeServer(unspecializedType);
							for (DomainType unspecializedPartialType : unspecializedTypeServer.getPartialTypes()) {
								assert unspecializedPartialType != null;
								initMemberPropertiesFrom(unspecializedPartialType);
								if (unspecializedPartialType instanceof Type) {
									List<ElementExtension> extensions = ((Type)unspecializedPartialType).getExtension();
									if (extensions.size() > 0) {
										if (allExtensions == null) {
											allExtensions = new ArrayList<ElementExtension>();
										}
										allExtensions.addAll(extensions);
									}
								}
							}
						}
						else {							
							initMemberPropertiesFrom(superType);
							if (superType instanceof Type) {
								List<ElementExtension> extensions = ((Type)superType).getExtension();
								if (extensions.size() > 0) {
									if (allExtensions == null) {
										allExtensions = new ArrayList<ElementExtension>();
									}
									allExtensions.addAll(extensions);
								}
							}
						}
					}
				}
			}
			if (INIT_MEMBER_PROPERTIES.isActive()) {
				INIT_MEMBER_PROPERTIES.println(this + " for " + getPivotType() + " " + DomainUtil.debugSimpleName(getPivotType()));
			}
			if (extendingStereotypes != null) {
				Set<Stereotype> allStereotypes = new HashSet<Stereotype>();
				gatherAllStereotypes(allStereotypes, extendingStereotypes);
				for (@SuppressWarnings("null")@NonNull Stereotype stereotype : allStereotypes) {
					Type baseType = getPivotType();
					initExtensionPropertiesFrom(baseType, stereotype);
				}
			}
			@SuppressWarnings("null")@NonNull String metatypeName = getPivotType().eClass().getName();
			RootPackageServer rootPackageServer = getPackageServer().getRootPackageServer();
			PackageId metapackageId = rootPackageServer.getMetapackageId();
			MetaModelManager metaModelManager = packageManager.getMetaModelManager();
			DomainPackage metapackage = metaModelManager.getIdResolver().getPackage(metapackageId);
			PackageServer metapackageServer = metaModelManager.getPackageServer(metapackage);
			DomainType metatype = metapackageServer.getType(metatypeName);
			if (metatype != null) {
				TypeServer typeServer = metaModelManager.getTypeServer(metatype);
				for (DomainProperty property : typeServer.getAllProperties(FeatureFilter.SELECT_STATIC)) {
					if (property != null) {
						addedMemberProperty(property);
					}
				}
			}
			for (PartialProperties properties : name2properties2.values()) {
				if (properties != null) {
					initMemberPropertiesPostProcess(name, properties);
				}
			}
		}	
		return name2properties2;
	}

	private void gatherAllStereotypes(@NonNull Set<Stereotype> allStereotypes, @NonNull Iterable<Stereotype> moreStereotypes) {
		Set<Stereotype> newStereotypes = null;
		MetaModelManager metaModelManager = getPackageManager().getMetaModelManager();
		for (@SuppressWarnings("null")@NonNull Stereotype stereotype : moreStereotypes) {
			stereotype = metaModelManager.getPrimaryElement(stereotype);
			if (allStereotypes.add(stereotype)) {
				TypeServer superTypeServer = null;
				if (stereotype instanceof TypeServer) {
					superTypeServer = (TypeServer)stereotype;
				}
				else {
					superTypeServer = packageManager.getTypeServer(stereotype);
				}
				if (newStereotypes == null) {
					newStereotypes = new HashSet<Stereotype>();
				}
				for (DomainType partialType : superTypeServer.getPartialTypes()) {
					if (partialType instanceof Stereotype) {
						Stereotype partialStereotype = (Stereotype) partialType;
						newStereotypes.add(partialStereotype);
						for (DomainType superType : partialStereotype.getSuperClass()) {
							if (superType instanceof Stereotype) {
								Stereotype superStereotype = (Stereotype)superType;
								superType = metaModelManager.getPrimaryElement(superStereotype);
								newStereotypes.add(superStereotype);
							}
						}
					}
				}
			}
		}
		if (newStereotypes != null) {
			gatherAllStereotypes(allStereotypes, newStereotypes);
		}
	}

	protected void initMemberPropertiesFrom(@NonNull DomainType asType) {
		DomainType asPrimaryType;
		if (asType instanceof Type) {
			asPrimaryType = PivotUtil.getUnspecializedTemplateableElement((Type) asType);
		}
		else {
			asPrimaryType = asType;
		}
		if (INIT_MEMBER_PROPERTIES.isActive()) {
			INIT_MEMBER_PROPERTIES.println(this + " from " + asPrimaryType + " " + DomainUtil.debugSimpleName(asPrimaryType));
		}
		if (asPrimaryType instanceof Type) {
			for (ElementExtension extension : ((Type)asPrimaryType).getExtension()) {
				assert extension != null;
//				initStereotypePropertiesFrom((Type)asPrimaryType, extension);
			}
		}
		for (DomainProperty pivotProperty : asPrimaryType.getLocalProperties()) {
			if (pivotProperty != null) {
				addedMemberProperty(pivotProperty);
			}
		}
	}

	protected void initMemberPropertiesPostProcess(@NonNull String name, @NonNull PartialProperties properties) {
		// TODO Auto-generated method stub // FIXME Prune occlusions		
	}

/*	protected void initStereotypePropertiesFrom(@NonNull Type baseType, @NonNull ElementExtension extensionType) {
		MetaModelManager metaModelManager = packageManager.getMetaModelManager();
		Map<String, PartialProperties> name2properties2 = name2properties;
		assert name2properties2 != null;
		Type stereotype = extensionType.getStereotype();
		List<Property> newExtensionProperties = new ArrayList<Property>();
		List<Property> oldExtensionProperties = extensionType.getOwnedAttribute();

		Property extensionProperty = createExtensionProperty(baseType,
			extensionType, name2properties2, stereotype);

		String basePropertyName = UML2Pivot.STEREOTYPE_BASE_PREFIX + baseType.eClass().getName();
		Property baseProperty = DomainUtil.getNamedElement(extensionType.getOwnedAttribute(), basePropertyName);
		if (baseProperty == null) {
			baseProperty = PivotFactory.eINSTANCE.createProperty();
			baseProperty.setName(basePropertyName);
		}
		baseProperty.setType(getPivotType());
		baseProperty.setIsRequired(false);
		baseProperty.setIsStatic(true);
		newExtensionProperties.add(baseProperty);
		
		baseProperty.setOpposite(extensionProperty);
		extensionProperty.setOpposite(baseProperty);
		if (ADD_BASE_PROPERTY.isActive()) {
			ADD_BASE_PROPERTY.println(EcoreUtils.qualifiedNameFor(getPivotType()) + "::" + baseProperty.getName() + " => " + EcoreUtils.qualifiedNameFor(baseProperty.getType()));
		}
		if (ADD_EXTENSION_PROPERTY.isActive()) {
			ADD_EXTENSION_PROPERTY.println(EcoreUtils.qualifiedNameFor(extensionProperty) + " => " + EcoreUtils.qualifiedNameFor(extensionProperty.getType()));
		}

/*		String stereotypePropertyName = UML2Pivot.STEREOTYPE; -- needs special ImplementationManager support to distinguish property
		Property stereotypeProperty = DomainUtil.getNamedElement(extensionType.getOwnedAttribute(), stereotypePropertyName);
		if (stereotypeProperty == null) {
			stereotypeProperty = PivotFactory.eINSTANCE.createProperty();
			stereotypeProperty.setName(stereotypePropertyName);
		}
		stereotypeProperty.setType(metaModelManager.getPivotType("Stereotype"));
		stereotypeProperty.setIsRequired(false);
		stereotypeProperty.setIsStatic(false);
		newExtensionProperties.add(stereotypeProperty); * /
		
		EObject umlStereotypeApplication = extensionType.getETarget();
		if (umlStereotypeApplication != null) {
			EClass eClass = umlStereotypeApplication.eClass();
			for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
				String featureName = eStructuralFeature.getName();
				if ((featureName != null) && !featureName.startsWith(UML2Pivot.STEREOTYPE_BASE_PREFIX)
	//			  && (eStructuralFeature instanceof EReference)
				  /*&& umlStereotypeApplication.eIsSet(eStructuralFeature)* /) {						// Unset for an applicable stereotype that has not been applied
					Object umlStereotypedElement = umlStereotypeApplication.eGet(eStructuralFeature);
	//				System.out.println("Element " + featureName + " => " + String.valueOf(umlStereotypedElement));
					Property referenceProperty = null;
					for (DomainProperty aProperty : metaModelManager.getAllProperties(stereotype, false, featureName)) {
						if (aProperty instanceof Property) {
							referenceProperty = (Property) aProperty;
							break;
						}
					}
					Property property = DomainUtil.getNamedElement(oldExtensionProperties, featureName);
					if (property == null) {
						property = PivotFactory.eINSTANCE.createProperty();
						property.setName(featureName);
					}
					property.setReferredProperty(referenceProperty);
					if (referenceProperty != null) {
						property.setDefault(String.valueOf(umlStereotypedElement));
						property.setIsRequired(referenceProperty.isRequired());
						property.setIsStatic(referenceProperty.isStatic());
						property.setType(referenceProperty.getType());
					}
					newExtensionProperties.add(property);
				}
			}
		}
		else {
			for (DomainProperty aProperty : metaModelManager.getAllProperties(stereotype, false)) {
				Property referenceProperty = (Property)aProperty;
				String featureName = referenceProperty.getName();
				Property property = DomainUtil.getNamedElement(oldExtensionProperties, featureName);
				if (property == null) {
					property = PivotFactory.eINSTANCE.createProperty();
					property.setName(featureName);
				}
				property.setReferredProperty((Property) referenceProperty);
				if (referenceProperty != null) {
//					property.setDefault(String.valueOf(umlStereotypedElement));
					property.setIsRequired(referenceProperty.isRequired());
					property.setIsStatic(referenceProperty.isStatic());
					property.setType(referenceProperty.getType());
				}
				newExtensionProperties.add(property);
			}
		}
		PivotUtil.refreshList(oldExtensionProperties, newExtensionProperties);
	} */

/*	protected @NonNull Property createBaseProperty(@NonNull ElementExtension stereotypeInstance, @NonNull Type baseType) {
		String basePropertyName = UML2Pivot.STEREOTYPE_BASE_PREFIX + baseType.eClass().getName();
		Property baseProperty = DomainUtil.getNamedElement(stereotypeInstance.getOwnedAttribute(), basePropertyName);
		if (baseProperty == null) {
			baseProperty = PivotFactory.eINSTANCE.createProperty();
			baseProperty.setName(basePropertyName);
		}
		baseProperty.setType(baseType);
		baseProperty.setIsRequired(true);
		baseProperty.setIsStatic(true);
//		newExtensionProperties.add(baseProperty);
//		addedMemberProperty(baseProperty);
		stereotypeInstance.getOwnedAttribute().add(baseProperty);
		return baseProperty;
	} */

	protected @NonNull Property createExtensionProperty(@NonNull ElementExtension stereotypeInstance, @NonNull Type baseType) {
		Stereotype stereotype = stereotypeInstance.getStereotype();
		Map<String, PartialProperties> name2properties2 = name2properties;
		assert name2properties2 != null;
		String extensionPropertyName = UML2Pivot.STEREOTYPE_EXTENSION_PREFIX + stereotype.getName();
		Property extensionProperty = null;
		PartialProperties partialProperties = name2properties2.get(extensionPropertyName);
		if (partialProperties == null) {
			partialProperties = new PartialProperties();
			name2properties2.put(extensionPropertyName, partialProperties);
		}
		for (DomainProperty partialProperty : partialProperties) {
			if (partialProperty instanceof Property) {
				extensionProperty = (Property)partialProperty;
				break;
			}
		}
		if (extensionProperty == null) {
			extensionProperty = PivotFactory.eINSTANCE.createProperty();
			extensionProperty.setName(extensionPropertyName);
			baseType.getOwnedAttribute().add(extensionProperty);
		}
		extensionProperty.setType(stereotype);
		boolean isRequired = false;
		for (TypeExtension typeExtension : stereotype.getExtensionOfs()) {
			Type metatype = typeExtension.getType();
			if ((metatype != null) && baseType.conformsTo(packageManager.getMetaModelManager(), metatype)) {
				isRequired = true;
				break;
			}
		}
		extensionProperty.setIsRequired(isRequired);
		extensionProperty.setIsStatic(true);
		return extensionProperty;
	}

	protected void initExtensionPropertiesFrom(@NonNull Type baseType, @NonNull Stereotype stereotype) {
		MetaModelManager metaModelManager = packageManager.getMetaModelManager();
		ElementExtension elementExtension = metaModelManager.getElementExtension(baseType, stereotype);
//		for (ElementExtension elementExtension : baseType.getExtensions())
		Map<String, PartialProperties> name2properties2 = name2properties;
		assert name2properties2 != null;
//		Type stereotype = extensionType.getStereotype();
//		List<Property> newExtensionProperties = new ArrayList<Property>();
//		List<Property> oldExtensionProperties = extensionType.getOwnedAttribute();

		Property extensionProperty = createExtensionProperty(elementExtension, baseType);
//		Property baseProperty = createBaseProperty(elementExtension, baseType);
		addedMemberProperty(extensionProperty);
//		baseProperty.setOpposite(extensionProperty);
//		extensionProperty.setOpposite(baseProperty);
//		if (ADD_BASE_PROPERTY.isActive()) {
//			ADD_BASE_PROPERTY.println(EcoreUtils.qualifiedNameFor(baseProperty) + " => " + EcoreUtils.qualifiedNameFor(baseProperty.getType()));
//			ADD_BASE_PROPERTY.println(EcoreUtils.qualifiedNameFor(getPivotType()) + "::" + baseProperty.getName() + " => " + EcoreUtils.qualifiedNameFor(baseProperty.getType()));
//		}
		if (ADD_EXTENSION_PROPERTY.isActive()) {
			ADD_EXTENSION_PROPERTY.println(EcoreUtils.qualifiedNameFor(extensionProperty) + " => " + EcoreUtils.qualifiedNameFor(extensionProperty.getType()));
		}

/*		String stereotypePropertyName = UML2Pivot.STEREOTYPE; -- needs special ImplementationManager support to distinguish property
		Property stereotypeProperty = DomainUtil.getNamedElement(extensionType.getOwnedAttribute(), stereotypePropertyName);
		if (stereotypeProperty == null) {
			stereotypeProperty = PivotFactory.eINSTANCE.createProperty();
			stereotypeProperty.setName(stereotypePropertyName);
		}
		stereotypeProperty.setType(metaModelManager.getPivotType("Stereotype"));
		stereotypeProperty.setIsRequired(false);
		stereotypeProperty.setIsStatic(false);
		newExtensionProperties.add(stereotypeProperty); */
		
/*		EObject umlStereotypeApplication = elementExtension.getETarget();
		if (umlStereotypeApplication != null) {
			EClass eClass = umlStereotypeApplication.eClass();
			for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
				String featureName = eStructuralFeature.getName();
				if ((featureName != null) && !featureName.startsWith(UML2Pivot.STEREOTYPE_BASE_PREFIX)
	//			  && (eStructuralFeature instanceof EReference)
				  /*&& umlStereotypeApplication.eIsSet(eStructuralFeature)* /) {						// Unset for an applicable stereotype that has not been applied
					Object umlStereotypedElement = umlStereotypeApplication.eGet(eStructuralFeature);
	//				System.out.println("Element " + featureName + " => " + String.valueOf(umlStereotypedElement));
					Property referenceProperty = null;
					for (DomainProperty aProperty : metaModelManager.getAllProperties(stereotype, FeatureFilter.SELECT_NON_STATIC, featureName)) {
						if (aProperty instanceof Property) {
							referenceProperty = (Property) aProperty;
							break;
						}
					}
					Property property = null; //DomainUtil.getNamedElement(oldExtensionProperties, featureName);
					if (property == null) {
						property = PivotFactory.eINSTANCE.createProperty();
						property.setName(featureName);
					}
					property.setReferredProperty(referenceProperty);
					if (referenceProperty != null) {
						property.setDefault(String.valueOf(umlStereotypedElement));
						property.setIsRequired(referenceProperty.isRequired());
						property.setIsStatic(referenceProperty.isStatic());
						property.setType(referenceProperty.getType());
					}
//					newExtensionProperties.add(property);
					addedMemberProperty(property);
				}
			}
		}
		else {
			for (DomainProperty aProperty : metaModelManager.getAllProperties(stereotype, FeatureFilter.SELECT_NON_STATIC)) {
				Property referenceProperty = (Property)aProperty;
				String featureName = referenceProperty.getName();
				Property property = null; //DomainUtil.getNamedElement(oldExtensionProperties, featureName);
				if (property == null) {
					property = PivotFactory.eINSTANCE.createProperty();
					property.setName(featureName);
				}
				property.setReferredProperty(referenceProperty);
				if (referenceProperty != null) {
//					property.setDefault(String.valueOf(umlStereotypedElement));
					property.setIsRequired(referenceProperty.isRequired());
					property.setIsStatic(referenceProperty.isStatic());
					property.setType(referenceProperty.getType());
				}
//				newExtensionProperties.add(property);
//				addedMemberProperty(property);
			}
		} */
//		PivotUtil.refreshList(oldExtensionProperties, newExtensionProperties);
	}

	protected @NonNull Map<String, DomainInheritance> initSuperClasses() {
//		System.out.println("initSuperClasses " + toString());
		Map<String, DomainInheritance> name2superclasses2 = name2superclasses = new HashMap<String, DomainInheritance>();
		name2qualifiedNames = null;
		for (DomainFragment fragment : getFragments()) {
			DomainInheritance baseInheritance = fragment.getBaseInheritance();
			String name = baseInheritance.getName();
			DomainInheritance oldInheritance = name2superclasses2.put(name, baseInheritance);
			if (oldInheritance != null) {
				name2superclasses2.clear();
				name2qualifiedNames = initSuperClassesWithAmbiguousNames(name2superclasses2, new HashMap<String, List<String>>());
				break;
			}
		}
		return name2superclasses2;
	}

	protected Map<String, List<String>> initSuperClassesWithAmbiguousNames(Map<String, DomainInheritance> name2superclasses2, Map<String, List<String>> name2qualifiedNames2) {
		int counter = 0;
		for (DomainFragment fragment : getFragments()) {
			DomainInheritance baseInheritance = fragment.getBaseInheritance();
			String name = baseInheritance.getName();
			String qualifiedName = Integer.toString(counter++);
			name2superclasses2.put(qualifiedName, baseInheritance);
			List<String> names = name2qualifiedNames2.get(name);
			if (names == null) {
				names = new ArrayList<String>();
				name2qualifiedNames2.put(name, names);
			}
			names.add(name);
		}
		return name2qualifiedNames2;
	}

	void removedMemberOperation(@NonNull DomainOperation pivotOperation) {
		Map<String, Map<ParametersId, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 != null) {
			String operationName = pivotOperation.getName();
			Map<ParametersId, List<DomainOperation>> overloads = name2operations2.get(operationName);
			if (overloads != null) {
				ParametersId parametersId = pivotOperation.getParametersId();
				List<DomainOperation> partials = overloads.get(parametersId);
				if (partials != null) {
					partials.add(pivotOperation);
					if (partials.isEmpty()) {
						overloads.remove(parametersId);
						if (overloads.isEmpty()) {
							name2operations2.remove(operationName);
						}
					}
				}
			}
		}
	}

/*	protected void initMemberPropertiesFrom(@NonNull DomainType asType) {
		DomainType asPrimaryType;
		if (asType instanceof Type) {
			asPrimaryType = PivotUtil.getUnspecializedTemplateableElement((Type) asType);
		}
		else {
			asPrimaryType = asType;
		}
		if (INIT_MEMBER_PROPERTIES.isActive()) {
			INIT_MEMBER_PROPERTIES.println(this + " from " + asPrimaryType + " " + DomainUtil.debugSimpleName(asPrimaryType));
		}
		if (asPrimaryType instanceof Type) {
			for (ElementExtension extension : ((Type)asPrimaryType).getExtensions()) {
				assert extension != null;
//				initStereotypePropertiesFrom((Type)asPrimaryType, extension);
			}
		}
		for (DomainProperty pivotProperty : asPrimaryType.getLocalProperties()) {
			if (pivotProperty != null) {
				addedMemberProperty(pivotProperty);
			}
		}
	} */

	void removedMemberProperty(@NonNull DomainProperty pivotProperty) {
		Map<String, PartialProperties> name2properties2 = name2properties;
		if (name2properties2 != null) {
			String propertyName = pivotProperty.getName();
			PartialProperties partials = name2properties2.get(propertyName);
			if (partials != null) {
				partials.remove(pivotProperty);
				if (partials.isEmpty()) {
					name2properties2.remove(propertyName);
				}
			}
		}
	}

	@Override
	public void uninstall() {
//		System.out.println("uninstall " + toString());
		name2superclasses = null;
		name2properties = null;
		name2operations = null;
		super.uninstall();
	}
}
