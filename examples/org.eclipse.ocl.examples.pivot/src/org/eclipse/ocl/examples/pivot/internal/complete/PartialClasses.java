/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.internal.complete;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.CompleteModel;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Region;
import org.eclipse.ocl.examples.pivot.RootCompletePackage;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.StateMachine;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.Vertex;
import org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteClassImpl;
import org.eclipse.ocl.examples.pivot.manager.CompleteInheritance;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.Orphanage;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class PartialClasses extends EObjectResolvingEList<org.eclipse.ocl.examples.pivot.Class> implements ClassListeners.IClassListener
{
	private static final long serialVersionUID = 1L;
	public static final @NonNull TracingOption PARTIAL_CLASSES = new TracingOption(PivotPlugin.PLUGIN_ID, "partialClasses");
//	static { PARTIAL_CLASSES.setState(true); }

	public static final @NonNull TracingOption ADD_BASE_PROPERTY = new TracingOption(PivotPlugin.PLUGIN_ID, "partialClasses/addBaseProperty");
	public static final @NonNull TracingOption ADD_EXTENSION_PROPERTY = new TracingOption(PivotPlugin.PLUGIN_ID, "partialClasses/addExtensionProperty");
	public static final @NonNull TracingOption INIT_MEMBER_OPERATIONS = new TracingOption(PivotPlugin.PLUGIN_ID, "partialClasses/initMemberOperations");	
	public static final @NonNull TracingOption INIT_MEMBER_PROPERTIES = new TracingOption(PivotPlugin.PLUGIN_ID, "partialClasses/initMemberProperties");

/*	protected static class QualifiedName2DomainInheritance implements Function<String, DomainInheritance>
	{
		protected final @NonNull Map<String, DomainInheritance> name2superclasses;
		
		protected QualifiedName2DomainInheritance(@NonNull Map<String, DomainInheritance> name2superclasses) {
			this.name2superclasses = name2superclasses;
		}

		public DomainInheritance apply(String qualifiedClassName) {
			return name2superclasses.get(qualifiedClassName);
		}
	} */

	/**
	 * Lazily created map from operation name to map of parameter types to the list of partial operations to be treated as merged.
	 */
	private @Nullable Map<String, PartialOperations> name2partialOperations = null;

	/**
	 * Lazily created map from property name to the list of properties to be treated as merged. 
	 */
	private @Nullable Map<String, PartialProperties> name2partialProperties = null;
	
	private Set<CompleteClass> superCompleteClasses = null;

	/**
	 * Lazily created map from class name to the superclass. This is a map from unqualified name to
	 * class for the normal case when all superclass names are distinct. However if any two superclasses
	 * including this class share a name, all superclasses are mapped by qualified name, and the
	 * name2qualifiedNames provides an additional mapping of the ambiguities.
	 */
//	private @Nullable Map<String, DomainInheritance> name2superclasses = null;		// FIXME duplicates superCompleteClasses

	/**
	 * Lazily created map from class name to the list of qualified names for same-named super-classes.
	 * This list is only non-null if a class has two same-named superclasses that need disambiguation..
	 */
//	private @Nullable Map<String, List<String>> name2qualifiedNames = null;

	/**
	 * Lazily created map from state name to the known state. 
	 */
	private @Nullable Map<String, State> name2states = null;

	protected /*@NonNull*/ CompleteInheritance completeInheritance;

	/**
	 * Map from actual types to specialization.
	 * <br>
	 * The specializations are weakly referenced so that stale specializations are garbage collected.
	 */
	// FIXME tests fail if keys are weak since GC is too aggressive across tests
	// The actual types are weak keys so that parameterizations using stale types are garbage collected. 
	//
	private @Nullable /*WeakHash*/Map<DomainTypeParameters, WeakReference<org.eclipse.ocl.examples.pivot.Class>> specializations = null;

	public PartialClasses(@NonNull CompleteClassImpl completeClass) {
		super(org.eclipse.ocl.examples.pivot.Class.class, completeClass, PivotPackage.COMPLETE_CLASS__PARTIAL_CLASSES);
	}

	@Override
	public void addUnique(org.eclipse.ocl.examples.pivot.Class partialClass) {
		assert partialClass != null;
		didAdd(partialClass);
		super.addUnique(partialClass);
	}

	@Override
	public void addUnique(int index, org.eclipse.ocl.examples.pivot.Class partialClass) {
		assert partialClass != null;
		didAdd(partialClass);
		super.addUnique(index, partialClass);
	}

	public @NonNull Set<CompleteClass> computeSuperCompleteClasses() {
		Set<CompleteClass> superCompleteClasses2 = superCompleteClasses;
		if (superCompleteClasses2 == null) {
			CompleteModel.Internal completeModel = getCompleteModel();
			superCompleteClasses2 = superCompleteClasses = new HashSet<CompleteClass>();
			for (org.eclipse.ocl.examples.pivot.Class partialClass : this) {
				for (org.eclipse.ocl.examples.pivot.Class partialSuperClass : partialClass.getSuperClasses()) {
					if (partialSuperClass != null) {
						CompleteClass.Internal superCompleteClass = completeModel.getCompleteClass(PivotUtil.getUnspecializedTemplateableElement(partialSuperClass));
						superCompleteClasses2.add(superCompleteClass);
						superCompleteClasses2.addAll(superCompleteClass.getPartialClasses().computeSuperCompleteClasses());
					}
				}
			}
			if (superCompleteClasses2.isEmpty()) {
				CompleteClass oclAnyCompleteClass = completeModel.getCompleteClass(completeModel.getMetaModelManager().getOclAnyType());
				if (getCompleteClass() != oclAnyCompleteClass) {
					superCompleteClasses2.add(oclAnyCompleteClass);
				}
			}
		}
		return superCompleteClasses2;
	}

	protected @NonNull Property createExtensionProperty(@NonNull ElementExtension stereotypeInstance, @NonNull org.eclipse.ocl.examples.pivot.Class baseType) {
		Stereotype stereotype = stereotypeInstance.getStereotype();
		Map<String, PartialProperties> name2partialProperties2 = name2partialProperties;
		assert name2partialProperties2 != null;
		String extensionPropertyName = UML2Pivot.STEREOTYPE_EXTENSION_PREFIX + stereotype.getName();
		Property extensionProperty = null;
		PartialProperties partialProperties = name2partialProperties2.get(extensionPropertyName);
		if (partialProperties == null) {
			partialProperties = new PartialProperties(getMetaModelManager());
			name2partialProperties2.put(extensionPropertyName, partialProperties);
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
			baseType.getOwnedProperties().add(extensionProperty);
		}
		extensionProperty.setType(stereotype);
		boolean isRequired = false;
		for (TypeExtension typeExtension : stereotype.getExtensionOfs()) {
			Type metatype = typeExtension.getType();
			if ((metatype != null) && baseType.conformsTo(getMetaModelManager(), metatype)) {
				isRequired = true;
				break;
			}
		}
		extensionProperty.setIsRequired(isRequired);
		extensionProperty.setIsStatic(true);
		return extensionProperty;
	}
	
	protected @NonNull org.eclipse.ocl.examples.pivot.Class createSpecialization(@NonNull DomainTypeParameters templateArguments) {
		org.eclipse.ocl.examples.pivot.Class unspecializedType = getCompleteClass().getPivotClass();
		String typeName = unspecializedType.getName();
		TemplateSignature templateSignature = unspecializedType.getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedTemplateParameters();
		EClass eClass = unspecializedType.eClass();
		EFactory eFactoryInstance = eClass.getEPackage().getEFactoryInstance();
		org.eclipse.ocl.examples.pivot.Class specializedType = (org.eclipse.ocl.examples.pivot.Class) eFactoryInstance.create(eClass);		
		specializedType.setName(typeName);
		TemplateBinding templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
		for (int i = 0; i < templateParameters.size(); i++) {
			TemplateParameter formalParameter = templateParameters.get(i);
			if (formalParameter != null) {
				DomainElement templateArgument = templateArguments.get(i);
				if (templateArgument instanceof Type) {
					Type actualType = (Type) templateArgument;
					TemplateParameterSubstitution templateParameterSubstitution = CompleteInheritance.createTemplateParameterSubstitution(formalParameter, actualType);
					templateBinding.getOwnedTemplateParameterSubstitutions().add(templateParameterSubstitution);
				}
			}
		}
		specializedType.getOwnedTemplateBindings().add(templateBinding);
		getCompleteModel().resolveSuperClasses(specializedType, unspecializedType);
//		if (specializedType instanceof Metaclass) {
//			Type instanceType = (Type) templateArguments.get(0);
//			Metaclass specializedMetaclass = (Metaclass)specializedType;
//			specializedMetaclass.setInstanceType(instanceType);
//		}
		specializedType.setUnspecializedElement(unspecializedType);
		MetaModelManager metaModelManager = getCompleteModel().getMetaModelManager();
		Orphanage orphanage = Orphanage.getOrphanage(metaModelManager.getASResourceSet());
		specializedType.setOwningPackage(orphanage);
		return specializedType;
	}

	protected void didAdd(org.eclipse.ocl.examples.pivot.Class partialClass) {
		if (PARTIAL_CLASSES.isActive()) {
			PARTIAL_CLASSES.println("Do-didAdd " + this + " " + partialClass);
		}
		((ClassImpl)partialClass).addClassListener(this);
		if (partialClass.getUnspecializedElement() == null) {
			getCompleteModel().didAddClass(partialClass, getCompleteClass());
		}
//		if (name2partialProperties != null) {
//			doRefreshPartialProperties(partialClass);
//		}
//		if (name2partialOperations != null) {
//			doRefreshPartialOperations(partialClass);
//		}
		dispose();			// Force lazy recomputation
	}

	@Override
	protected void didRemove(int index, org.eclipse.ocl.examples.pivot.Class partialClass) {
		assert partialClass != null;
		if (PARTIAL_CLASSES.isActive()) {
			PARTIAL_CLASSES.println("Do-didRemove " + this + " " + partialClass);
		}
		super.didRemove(index, partialClass);
		((ClassImpl)partialClass).removeClassListener(this);
		dispose();			// Force lazy recomputation
	}

	public void didAddOperation(@NonNull Operation pivotOperation) {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 != null) {
			String operationName = pivotOperation.getName();
			if (operationName != null) {
				PartialOperations partialOperations = name2partialOperations2.get(operationName);
				if (partialOperations == null) {
					partialOperations = new PartialOperations(getCompleteClass(), operationName);
					name2partialOperations2.put(operationName, partialOperations);
				}
				partialOperations.didAddOperation(pivotOperation);
			}
		}
	}

	public void didAddProperty(@NonNull Property pivotProperty) {
		Map<String, PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 != null) {
			String propertyName = pivotProperty.getName();
			PartialProperties partials = name2partialProperties2.get(propertyName);
			if (partials == null) {
				partials = new PartialProperties(getMetaModelManager());
				name2partialProperties2.put(propertyName, partials);
			}
			partials.didAddProperty(pivotProperty);
		}
	}

	public void didAddSuperClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass) {
		if (completeInheritance != null) {
			completeInheritance.uninstall();
		}
	}

	public void didRemoveOperation(@NonNull Operation pivotOperation) {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 != null) {
			String operationName = pivotOperation.getName();
			PartialOperations partialOperations = name2partialOperations2.get(operationName);
			if (partialOperations != null) {
				if (partialOperations.didRemoveOperation(pivotOperation)) {
					name2partialOperations2.remove(operationName);
				}
			}
		}
	}

	public void didRemoveProperty(@NonNull Property pivotProperty) {
		Map<String, PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 != null) {
			String propertyName = pivotProperty.getName();
			PartialProperties partials = name2partialProperties2.get(propertyName);
			if (partials != null) {
				if (partials.didRemoveProperty(pivotProperty)) {
					name2partialProperties2.remove(propertyName);
				}
			}
		}
	}

	public void didRemoveSuperClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass) {
		if (completeInheritance != null) {
			completeInheritance.uninstall();
		}
	}

	public void dispose() {
		completeInheritance = null;
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 != null) {
			name2partialOperations2.clear();
			name2partialOperations = null;
		}
		Map<String, PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 != null) {
			name2partialProperties2.clear();
			name2partialProperties = null;
		}
//		name2superclasses = null;
		superCompleteClasses = null;
	}

	public synchronized @Nullable Type findSpecializedType(@NonNull DomainTypeParameters templateArguments) {
		TemplateSignature templateSignature = getCompleteClass().getPivotClass().getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedTemplateParameters();
		int iMax = templateParameters.size();
		if (templateArguments.parametersSize() != iMax) {
			return null;
		}
		Map<DomainTypeParameters, WeakReference<org.eclipse.ocl.examples.pivot.Class>> specializations2 = specializations;
		if (specializations2 == null) {
			return null;
		}
		WeakReference<org.eclipse.ocl.examples.pivot.Class> weakReference = specializations2.get(templateArguments);
		if (weakReference == null) {
			return null;
		}
		org.eclipse.ocl.examples.pivot.Class type = weakReference.get();
		if (type == null) {
			synchronized (specializations2) {
				type = weakReference.get();
				if (type == null) {
					specializations2.remove(templateArguments);
				}
			}
		}
		return type;
	}

	private void gatherAllStereotypes(@NonNull Set<Stereotype> allStereotypes, @NonNull Iterable<Stereotype> moreStereotypes) {
		Set<Stereotype> newStereotypes = null;
		MetaModelManager metaModelManager = getMetaModelManager();
		for (@SuppressWarnings("null")@NonNull Stereotype stereotype : moreStereotypes) {
			stereotype = metaModelManager.getPrimaryElement(stereotype);
			if (allStereotypes.add(stereotype)) {
				CompleteClass superCompleteClass = null;
				if (stereotype instanceof CompleteInheritance) {
					superCompleteClass = ((CompleteInheritance)stereotype).getCompleteClass();
				}
				else {
					superCompleteClass = getCompleteModel().getCompleteClass(stereotype);
				}
				if (newStereotypes == null) {
					newStereotypes = new HashSet<Stereotype>();
				}
				for (DomainClass partialType : superCompleteClass.getPartialClasses()) {
					if (partialType instanceof Stereotype) {
						Stereotype partialStereotype = (Stereotype) partialType;
						newStereotypes.add(partialStereotype);
						for (DomainClass superType : partialStereotype.getSuperClasses()) {
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

	@SuppressWarnings("null")
	public @NonNull CompleteClass.Internal getCompleteClass() {
		return (CompleteClassImpl) owner;
	}

	public final @NonNull CompleteInheritance getCompleteInheritance() {
		CompleteInheritance completeInheritance2 = completeInheritance;
		if (completeInheritance2 == null) {
			CompleteClass.Internal completeClass = getCompleteClass();
			completeInheritance2 = completeClass.createCompleteInheritance();
			completeInheritance = completeInheritance2;
		}
		return completeInheritance2;
	}

	public @NonNull CompleteModel.Internal getCompleteModel() {
		return getCompleteClass().getCompleteModel();
	}

	public @NonNull Iterable<? extends DomainInheritance> getInitialSuperInheritances() {
		final @NonNull MetaModelManager metaModelManager = getMetaModelManager();
		final Iterator<CompleteClass> iterator = computeSuperCompleteClasses().iterator();			// FIXME Use local cache
		return new Iterable<DomainInheritance>()
		{
			public Iterator<DomainInheritance> iterator() {
				return new Iterator<DomainInheritance>()
				{
					public boolean hasNext() {
						return iterator.hasNext();
					}

					public DomainInheritance next() {
						CompleteClass next = iterator.next();
						CompleteInheritance completeInheritance = next.getCompleteInheritance();
						return completeInheritance.getInheritance(metaModelManager);
					}

					public void remove() {
						throw new UnsupportedOperationException();
					}					
				};
			}			
		};
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return getCompleteClass().getMetaModelManager();
	}

	public @Nullable DomainOperation getOperation(@NonNull OperationId operationId) {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		String operationName = operationId.getName();
		PartialOperations partialOperations = name2partialOperations2.get(operationName);
		if (partialOperations == null) {
			return null;
		}
		return partialOperations.getOperation(operationId.getParametersId(), null);
	}

	public @Nullable DomainOperation getOperation(@NonNull DomainOperation pivotOperation) {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		String operationName = pivotOperation.getName();
		PartialOperations partialOperations = name2partialOperations2.get(operationName);
		if (partialOperations == null) {
			return null;
		}
		return partialOperations.getOperation(pivotOperation.getParametersId(), pivotOperation.isStatic() ? FeatureFilter.SELECT_STATIC : FeatureFilter.SELECT_NON_STATIC);
	}
	
	public @NonNull Iterable<String> getOperationNames() {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		@SuppressWarnings("null")@NonNull Set<String> keySet = name2partialOperations2.keySet();
		return keySet;
	}

	public @Nullable Iterable<DomainOperation> getOperationOverloads(@NonNull DomainOperation pivotOperation) {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		String operationName = pivotOperation.getName();
		PartialOperations partialOperations = name2partialOperations2.get(operationName);
		if (partialOperations == null) {
			return null;
		}
		ParametersId parametersId = pivotOperation.getParametersId();
		return partialOperations.getOperationOverloads(parametersId, pivotOperation.isStatic() ? FeatureFilter.SELECT_STATIC : FeatureFilter.SELECT_NON_STATIC);
	}

	public @NonNull Iterable<? extends DomainOperation> getOperationOverloads(final @Nullable FeatureFilter featureFilter, @Nullable String name) {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		PartialOperations partialOperations = name2partialOperations2.get(name);
		if (partialOperations == null) {
			return MetaModelManager.EMPTY_OPERATION_LIST;
		}
		return partialOperations.getOperationOverloads(featureFilter);
	}
	
	public @NonNull Iterable<DomainOperation> getOperations() {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		Iterable<Iterable<Iterable<DomainOperation>>> transformed = Iterables.transform(name2partialOperations2.values(), PartialOperations.partialOperations2allOperations);
		@SuppressWarnings("null")@NonNull Iterable<DomainOperation> concat = Iterables.concat(Iterables.concat(transformed));
		return concat;
	}

	public @NonNull Iterable<? extends DomainOperation> getOperations(final @Nullable FeatureFilter featureFilter) {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = initMemberOperations();
		}
		Iterable<PartialOperations> itMapListOps = name2partialOperations2.values();
		@SuppressWarnings("null")@NonNull Iterable<Iterable<Iterable<DomainOperation>>> itItListOps = Iterables.transform(itMapListOps, PartialOperations.partialOperations2allOperations);
		@SuppressWarnings("null")@NonNull Iterable<Iterable<DomainOperation>> itListOps = Iterables.concat(itItListOps);
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

	public @NonNull Iterable<? extends DomainProperty> getProperties(final @Nullable FeatureFilter featureFilter) {
		Map<String, PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 == null) {
			name2partialProperties2 = initMemberProperties();
		}
		@SuppressWarnings("null")@NonNull Iterable<DomainProperty> transform = Iterables.transform(name2partialProperties2.values(),
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

	public @NonNull Iterable<? extends DomainProperty> getProperties(final @Nullable FeatureFilter featureFilter, @Nullable String name) {
		Map<String, PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 == null) {
			name2partialProperties2 = initMemberProperties();
		}
		PartialProperties partials = name2partialProperties2.get(name);
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

	public @Nullable Iterable<DomainProperty> getProperties(@NonNull DomainProperty pivotProperty) {
		Map<String, PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 == null) {
			name2partialProperties2 = initMemberProperties();
		}
		String propertyName = pivotProperty.getName();
		return name2partialProperties2.get(propertyName);
	}

	public @Nullable Iterable<DomainProperty> getProperties(@Nullable String propertyName) {
		Map<String, PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 == null) {
			name2partialProperties2 = initMemberProperties();
		}
		return name2partialProperties2.get(propertyName);
	}

	public @Nullable DomainProperty getProperty(@Nullable String propertyName) {
		Map<String, PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 == null) {
			name2partialProperties2 = initMemberProperties();
		}
		PartialProperties partials = name2partialProperties2.get(propertyName);
		if (partials == null) {
			return null;
		}
		return partials.get();
	}

	public synchronized @NonNull org.eclipse.ocl.examples.pivot.Class getSpecializedType(@NonNull List<? extends DomainType> templateArguments) {
		return getSpecializedType(new DomainTypeParameters(templateArguments));
	}

	public synchronized @NonNull org.eclipse.ocl.examples.pivot.Class getSpecializedType(@NonNull DomainTypeParameters templateArguments) {
		TemplateSignature templateSignature = getCompleteClass().getPivotClass().getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedTemplateParameters();
		int iMax = templateParameters.size();
		if (templateArguments.parametersSize() != iMax) {
			throw new IllegalArgumentException("Incompatible template argument count");
		}
		Map<DomainTypeParameters, WeakReference<org.eclipse.ocl.examples.pivot.Class>> specializations2 = specializations;
		if (specializations2 == null) {
			synchronized(this) {
				specializations2 = specializations;
				if (specializations2 == null) {
					specializations2 = specializations = new /*Weak*/HashMap<DomainTypeParameters, WeakReference<org.eclipse.ocl.examples.pivot.Class>>();
				}
			}
		}
		synchronized (specializations2) {
			org.eclipse.ocl.examples.pivot.Class specializedType = null;
			WeakReference<org.eclipse.ocl.examples.pivot.Class> weakReference = specializations2.get(templateArguments);
			if (weakReference != null) {
				specializedType = weakReference.get();
			}
			if (specializedType == null) {
				specializedType = createSpecialization(templateArguments);
				specializations2.put(templateArguments, new WeakReference<org.eclipse.ocl.examples.pivot.Class>(specializedType));
			}
			return specializedType;
		}
	}

	public @NonNull Iterable<? extends State> getStates() {
		Map<String, State> name2states2 = name2states;
		if (name2states2 == null) {
			name2states2 = initStates();
		}
		@SuppressWarnings("null")
		@NonNull Collection<State> values = name2states2.values();
		return values;
	}

	public @NonNull Iterable<? extends State> getStates(@Nullable String name) {
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
	
	@SuppressWarnings("null")
	public @NonNull Iterable<CompleteClass> getSuperCompleteClasses() {
		DomainInheritance inheritance = getCompleteClass().getCompleteInheritance();
		return Iterables.transform(inheritance.getAllSuperFragments(), new Function<DomainFragment, CompleteClass>()
		{
			public CompleteClass apply(DomainFragment input) {
				return ((CompleteInheritance)input.getBaseInheritance()).getCompleteClass();
			}
		});
	}

	protected void initExtensionPropertiesFrom(@NonNull org.eclipse.ocl.examples.pivot.Class baseType, @NonNull Stereotype stereotype) {
		MetaModelManager metaModelManager = getMetaModelManager();
		ElementExtension elementExtension = metaModelManager.getElementExtension(baseType, stereotype);
		Map<String, PartialProperties> name2partialProperties2 = name2partialProperties;
		assert name2partialProperties2 != null;

		Property extensionProperty = createExtensionProperty(elementExtension, baseType);
		didAddProperty(extensionProperty);
		if (ADD_EXTENSION_PROPERTY.isActive()) {
			ADD_EXTENSION_PROPERTY.println(EcoreUtils.qualifiedNameFor(extensionProperty) + " => " + EcoreUtils.qualifiedNameFor(extensionProperty.getType()));
		}
	}

	public void initMemberFeaturesFrom(@NonNull org.eclipse.ocl.examples.pivot.Class pivotType) {
		if (name2partialOperations != null) {
			initMemberOperationsFrom(pivotType);
		}	
		if (name2partialProperties != null) {
			initMemberPropertiesFrom(pivotType);		// FIXME invalidate is safer
		}
	}

	private @NonNull Map<String, PartialOperations> initMemberOperations() {
		Map<String, PartialOperations> name2partialOperations2 = name2partialOperations;
		if (name2partialOperations2 == null) {
			name2partialOperations2 = name2partialOperations = new HashMap<String, PartialOperations>();
//			Set<CompleteClass> allSuperCompleteClasses = new HashSet<CompleteClass>();
//			allSuperCompleteClasses.add(completeClass);
//			for (CompleteClass superCompleteClass : completeClass.getSuperCompleteClasses()) {
//				allSuperCompleteClasses.add(superCompleteClass);
//			}
			for (CompleteClass superCompleteClass : getSuperCompleteClasses()) {
				if (superCompleteClass != null) {
					for (DomainClass superType : superCompleteClass.getPartialClasses()) {
						assert superType != null;
						if (superType instanceof org.eclipse.ocl.examples.pivot.Class) {
							org.eclipse.ocl.examples.pivot.Class unspecializedType = PivotUtil.getUnspecializedTemplateableElement((org.eclipse.ocl.examples.pivot.Class) superType);
							CompleteClass unspecializedCompleteClass = getCompleteModel().getCompleteClass(unspecializedType);
							for (DomainClass unspecializedPartialType : unspecializedCompleteClass.getPartialClasses()) {
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
			for (PartialOperations partialOperations : name2partialOperations2.values()) {
				partialOperations.initMemberOperationsPostProcess();
			}
		}	
		return name2partialOperations2;
	}

	private void initMemberOperationsFrom(@NonNull DomainClass type) {
		if (INIT_MEMBER_OPERATIONS.isActive()) {
			INIT_MEMBER_OPERATIONS.println(this + " from " + type);
		}
		for (DomainOperation pivotOperation : type.getOwnedOperations()) {
			if ((pivotOperation instanceof Operation) && (pivotOperation.getName() != null)) {		// name may be null for partially initialized Complete OCL document.
				didAddOperation((Operation)pivotOperation);
			}
		}
	}

	protected @NonNull Map<String, PartialProperties> initMemberProperties() {
		Map<String, PartialProperties> name2partialProperties2 = name2partialProperties;
		if (name2partialProperties2 == null) {
			name2partialProperties2 = name2partialProperties = new HashMap<String, PartialProperties>();
			List<ElementExtension> allExtensions = null;
			Set<Stereotype> extendingStereotypes = null;
			Set<Type> extendedTypes = null;
			for (CompleteClass superCompleteClass : getSuperCompleteClasses()) {
				if (superCompleteClass != null) {
					for (DomainClass superType : superCompleteClass.getPartialClasses()) {
						assert superType != null;
						if (superType instanceof org.eclipse.ocl.examples.pivot.Class) {
							org.eclipse.ocl.examples.pivot.Class unspecializedType = PivotUtil.getUnspecializedTemplateableElement((org.eclipse.ocl.examples.pivot.Class) superType);
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
							CompleteClass unspecializedCompleteClass = getCompleteModel().getCompleteClass(unspecializedType);
							for (DomainClass unspecializedPartialType : unspecializedCompleteClass.getPartialClasses()) {
								assert unspecializedPartialType != null;
								initMemberPropertiesFrom(unspecializedPartialType);
								if (unspecializedPartialType instanceof org.eclipse.ocl.examples.pivot.Class) {
									List<ElementExtension> extensions = ((org.eclipse.ocl.examples.pivot.Class)unspecializedPartialType).getExtension();
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
			Class pivotClass = getCompleteClass().getPivotClass();
			if (INIT_MEMBER_PROPERTIES.isActive()) {
				INIT_MEMBER_PROPERTIES.println(this + " for " + pivotClass + " " + DomainUtil.debugSimpleName(pivotClass));
			}
			if (extendingStereotypes != null) {
				Set<Stereotype> allStereotypes = new HashSet<Stereotype>();
				gatherAllStereotypes(allStereotypes, extendingStereotypes);
				for (@SuppressWarnings("null")@NonNull Stereotype stereotype : allStereotypes) {
					@NonNull org.eclipse.ocl.examples.pivot.Class baseType = pivotClass;
					initExtensionPropertiesFrom(baseType, stereotype);
				}
			}
			@SuppressWarnings("null")@NonNull String metatypeName = pivotClass.eClass().getName();
			RootCompletePackage rootCompletePackage = getCompleteClass().getOwningCompletePackage().getRootCompletePackage();
			PackageId metapackageId = rootCompletePackage.getMetapackageId();
			MetaModelManager metaModelManager = getMetaModelManager();
			DomainPackage metapackage = metaModelManager.getIdResolver().getPackage(metapackageId);
			CompletePackage metaCompletePackage = metaModelManager.getCompletePackage(metapackage);
			DomainType metatype = metaCompletePackage.getType(metatypeName);
			if (metatype != null) {
				CompleteClass metaCompleteClass = getCompleteModel().getCompleteClass(metatype);
				for (DomainProperty property : metaCompleteClass.getProperties(FeatureFilter.SELECT_STATIC)) {
					if (property instanceof Property) {
						didAddProperty((Property) property);
					}
				}
			}
			for (PartialProperties properties : name2partialProperties2.values()) {
				if (properties != null) {
					initMemberPropertiesPostProcess(getCompleteClass().getName(), properties);
				}
			}
		}	
		return name2partialProperties2;
	}

	protected void initMemberPropertiesFrom(@NonNull DomainClass asType) {
		DomainClass asPrimaryType;
		if (asType instanceof org.eclipse.ocl.examples.pivot.Class) {
			asPrimaryType = PivotUtil.getUnspecializedTemplateableElement((org.eclipse.ocl.examples.pivot.Class) asType);
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
		for (DomainProperty pivotProperty : asPrimaryType.getOwnedProperties()) {
			if (pivotProperty instanceof Property) {
				didAddProperty((Property) pivotProperty);
			}
		}
	}

	protected void initMemberPropertiesPostProcess(String name, @NonNull PartialProperties properties) {
		// TODO Auto-generated method stub // FIXME Prune occlusions		
	}

	protected @NonNull Map<String, State> initStates() {
		Map<String, State> name2states = new HashMap<String, State>();
		for (CompleteClass superCompleteClass : getSuperCompleteClasses()) {
			if (superCompleteClass != null) {
				for (org.eclipse.ocl.examples.pivot.Class superPartialClass : superCompleteClass.getPartialClasses()) {
					assert superPartialClass != null;
					for (Behavior behavior : superPartialClass.getOwnedBehavior()) {
						if (behavior instanceof StateMachine) {
							@SuppressWarnings("null")@NonNull List<Region> regions = ((StateMachine)behavior).getRegion();
							initStatesForRegions(name2states, regions);
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

/*	protected @NonNull Map<String, DomainInheritance> initSuperClasses() {
//		System.out.println("initSuperClasses " + toString());
		Map<String, DomainInheritance> name2superclasses2 = name2superclasses = new HashMap<String, DomainInheritance>();
		name2qualifiedNames = null;
		for (DomainFragment fragment : ((AbstractTypeServer)getTypeServer()).getFragments()) {
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
	} */

/*	protected Map<String, List<String>> initSuperClassesWithAmbiguousNames(Map<String, DomainInheritance> name2superclasses2, Map<String, List<String>> name2qualifiedNames2) {
		int counter = 0;
		for (DomainFragment fragment : getCompleteClass().getCompleteInheritance().getFragments()) {
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
	} */
}