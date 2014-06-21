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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.UnsupportedOperation;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.library.BaseProperty;
import org.eclipse.ocl.examples.pivot.library.CompositionProperty;
import org.eclipse.ocl.examples.pivot.library.ConstrainedOperation;
import org.eclipse.ocl.examples.pivot.library.ConstrainedProperty;
import org.eclipse.ocl.examples.pivot.library.ExplicitNavigationProperty;
import org.eclipse.ocl.examples.pivot.library.ExtensionProperty;
import org.eclipse.ocl.examples.pivot.library.ImplicitNonCompositionProperty;
import org.eclipse.ocl.examples.pivot.library.StaticProperty;
import org.eclipse.ocl.examples.pivot.library.StereotypeProperty;
import org.eclipse.ocl.examples.pivot.library.TuplePartProperty;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;

/**
 * ImplementationManager encapsulates the knowledge about known feature implementations.
 */
public class ImplementationManager
{			
	private static final Logger logger = Logger.getLogger(ImplementationManager.class);
	
	public static interface ExplicitNavigator {
		@Nullable LibraryProperty getPropertyImplementation(@Nullable Object sourceValue, @NonNull Property property);
	}
	
	private static @NonNull List<ExplicitNavigator> explicitNavigators = new ArrayList<ExplicitNavigator>();
	
	public static void addExplicitNavgator(@NonNull ExplicitNavigator explicitNavigator) {
		if (!explicitNavigators.contains(explicitNavigator)) {
			explicitNavigators.add(explicitNavigator);
		}
	}

	protected final @NonNull MetaModelManager metaModelManager;

	/**
	 * ClassLoaders that may be able to load a library implementation.
	 */
	private List<ClassLoader> classLoaders = null;
	
	protected ImplementationManager(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
	}

	public void addClassLoader(@NonNull ClassLoader classLoader) {
		List<ClassLoader> classLoaders = getClassLoaders();
		if (!classLoaders.contains(classLoader)) {
			classLoaders.add(classLoader);
		}
	}

	public @NonNull List<ClassLoader> getClassLoaders() {
		List<ClassLoader> classLoaders2 = classLoaders;
		if (classLoaders2 == null) {
			classLoaders2 = classLoaders = new ArrayList<ClassLoader>();
			classLoaders2.add(metaModelManager.getClass().getClassLoader());
		}
		return classLoaders2;
	}

	protected @NonNull LibraryOperation getOperationImplementation(@NonNull Operation operation) {
		LibraryFeature implementation = operation.getImplementation();
		String implementationClassName = operation.getImplementationClass();
		if (implementationClassName != null) {
			if ((implementation == null) || !implementation.getClass().getName().equals(implementationClassName)) {
				try {
					implementation = loadImplementation(operation);
					if (implementation instanceof LibraryOperation) {
						return (LibraryOperation)implementation;
					}
				} catch (Exception e) {
					logger.error("Failed to load implementation of '" + operation + "'", e);
				}
				return UnsupportedOperation.INSTANCE;
			}
		}
		OpaqueExpression specification = metaModelManager.getBodyExpression(operation);
		if (specification instanceof ExpressionInOCL) {
			return new ConstrainedOperation((ExpressionInOCL) specification);
		}
		return UnsupportedOperation.INSTANCE;
	}

	protected @NonNull LibraryProperty getPropertyImplementation(@Nullable Object sourceValue, @NonNull Property property) {
		LibraryFeature implementation = property.getImplementation();
		String implementationClassName = property.getImplementationClass();
		if (implementationClassName != null) {
			if ((implementation == null) || !implementation.getClass().getName().equals(implementationClassName)) {
				try {
					implementation = loadImplementation(property);
					if (implementation instanceof LibraryProperty) {
						return (LibraryProperty) implementation;
					}
				} catch (Exception e) {
					logger.error("Failed to load implementation of '" + property + "'", e);
				}
				return UnsupportedOperation.INSTANCE;
			}
		}
		Type type = property.getType();
		if ((type instanceof Stereotype) && property.getName().startsWith(UML2Pivot.STEREOTYPE_EXTENSION_PREFIX)) {
			return new ExtensionProperty(property);
		}
//		if (property.getOwningType() instanceof Stereotype) {
//			return new BaseProperty(property);
//		}
		OpaqueExpression specification = metaModelManager.getDefaultExpression(property);
		if (property.isDerived() && (specification != null)) {
			return new ConstrainedProperty(property);
		}
		Property opposite = property.getOpposite();
		if ((opposite != null) && opposite.isComposite()) {
			if (property.eContainer() instanceof Stereotype) {
				return new BaseProperty(property);
			}
			if (type != null) {
				EObject eTarget = opposite.getETarget();
				if (eTarget instanceof EReference) {
					return new CompositionProperty((EReference) eTarget, opposite.getPropertyId());
				}
				if (eTarget != null) {
					Resource resource = opposite.eResource();
					if (resource instanceof ASResource) {
						ASResource asResource = (ASResource)resource;
						EReference eReference = asResource.getASResourceFactory().getEReference(asResource, eTarget);
						if (eReference != null) {
							return new CompositionProperty(eReference, opposite.getPropertyId());
						}
					}
				}
/*				eTarget = type.getETarget();
				if (eTarget != null) {
					EClass eOwningClass = eTarget.eClass();
					EClass eOwnedClass = property.getOwningType().getETarget().eClass();
					EList<EStructuralFeature> ownerStructuralFeatures = eOwningClass.getEAllStructuralFeatures();
					EList<EStructuralFeature> ownedStructuralFeatures = eOwnedClass.getEAllStructuralFeatures();
					EStructuralFeature eFeature = EcoreUtils.getNamedElement(ownerStructuralFeatures, opposite.getName());
					if (eFeature instanceof EReference) {
						return new CompositionProperty((EReference) eFeature, opposite.getPropertyId());
					}
				} */
			}
		}
		if (property.isImplicit()) {
			return new ImplicitNonCompositionProperty(property);
		}
		if (property.getOwningType() instanceof TupleType) {
			TupleType tupleType = (TupleType)property.getOwningType();
			String name = property.getName();
			assert name != null;
			TuplePartId tuplePartId = tupleType.getTypeId().getPartId(name);
			assert tuplePartId != null;
			return new TuplePartProperty(tuplePartId);
		}
		if (property.isStatic()) {
			return new StaticProperty(property);
		}
		if ((property.getOwningType() instanceof ElementExtension)			// direct access to extension property
			  || (property.getOwningType() instanceof Stereotype)) {			// indirect access from a Stereotype operation
			return new StereotypeProperty(property);
		}
		for (ExplicitNavigator explicitNavigator : explicitNavigators) {
			LibraryProperty libraryProperty = explicitNavigator.getPropertyImplementation(sourceValue, property);
			if (libraryProperty != null) {
				return libraryProperty;
			}
		}
		return new ExplicitNavigationProperty(property);
	}
	
	public void dispose() {
		classLoaders = null;
	}

	/**
	 * Return the implementation of a feature.
	 * 
	 * @param feature to be implemented.
	 * @return the implementation, or null if the feature has no implementation
	 * as is the case for a normal model feature
	 * @throws ClassNotFoundException if the implementation class realising
	 * the implementation is not loadable 
	 * @throws NoSuchFieldException if the implementation class realising
	 * the implementation does not provide a static INSTANCE field
	 * @throws SecurityException if the implementation class is not accessible
	 * @throws IllegalAccessException if the implementation class is not accessible
	 * @throws IllegalArgumentException if the implementation class is not accessible
	 */
	public @Nullable LibraryFeature loadImplementation(@NonNull Feature feature) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		LibraryFeature implementation = feature.getImplementation();
		if (implementation == null) {
			String implementationClassName = feature.getImplementationClass();
			if (implementationClassName != null) {
				Class<?> theClass = null;
				ClassLoader featureClassLoader = feature.getClass().getClassLoader();
				if (featureClassLoader != null) {
					addClassLoader(featureClassLoader);
				}
				ClassNotFoundException e = null;
				for (ClassLoader classLoader : getClassLoaders()) {
					try {
						theClass = classLoader.loadClass(implementationClassName);
						e = null;
						break;
					} catch (ClassNotFoundException e1) {
						if (e == null) {
							e = e1;
						}
					}						
				}
				if (e != null) {
					throw e;
				}
				if (theClass != null) {
					Field field = theClass.getField("INSTANCE");
					implementation = (LibraryFeature) field.get(null);
				}
			}
		}
		return implementation;
	}
}