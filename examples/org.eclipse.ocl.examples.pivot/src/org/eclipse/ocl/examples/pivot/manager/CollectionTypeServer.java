/*******************************************************************************
 * Copyright (c) 2011, 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.executor.CollectionTypeParameters;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * An CollectionTypeServer supports one or more merged collection types as the source for operations, properties or superclasses
 * and additionally supports their specializations.
 */
public class CollectionTypeServer extends ExtensibleTypeServer
{
	private static final Logger logger = Logger.getLogger(CollectionTypeServer.class);

	/**
	 * Map from actual types to specialization.
	 * <br>
	 * The specializations are weakly referenced so that stale specializations are garbage collected.
	 */
	// FIXME tests fail if keys are weak since GC is too aggressive across tests
	// The actual types are weak keys so that parameterizations using stale types are garbage collected. 
	//
	private @Nullable /*WeakHash*/Map<CollectionTypeParameters<Type>, WeakReference<Type>> specializations = null;

	protected CollectionTypeServer(@NonNull PackageServer packageServer, @NonNull DomainCollectionType domainType) {
		super(packageServer, domainType);
	}
	
	protected @NonNull Type createSpecialization(@NonNull CollectionTypeParameters<Type> typeParameters) {
		Type unspecializedType = getPivotType();
		String typeName = unspecializedType.getName();
		TemplateSignature templateSignature = unspecializedType.getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
		EClass eClass = unspecializedType.eClass();
		EFactory eFactoryInstance = eClass.getEPackage().getEFactoryInstance();
		CollectionType specializedType = (CollectionType) eFactoryInstance.create(eClass);		
		specializedType.setName(typeName);
		TemplateBinding templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
		templateBinding.setSignature(templateSignature);
		Map<TemplateParameter, ParameterableElement> allBindings = new HashMap<TemplateParameter, ParameterableElement>();
		TemplateParameter formalParameter = templateParameters.get(0);
		assert formalParameter != null;
		Type elementType = typeParameters.getElementType();
		allBindings.put(formalParameter, elementType);
		TemplateParameterSubstitution templateParameterSubstitution = createTemplateParameterSubstitution(formalParameter, elementType);
		templateBinding.getParameterSubstitution().add(templateParameterSubstitution);
		specializedType.getTemplateBinding().add(templateBinding);
		packageManager.resolveSuperClasses(specializedType, unspecializedType, allBindings);
		CollectionType specializedCollectionType = specializedType;
		specializedCollectionType.setElementType(typeParameters.getElementType());
		try {
			specializedCollectionType.setLowerValue(typeParameters.getLower());
		} catch (InvalidValueException e) {
			logger.error("Out of range lower bound", e);
		}
		try {
			specializedCollectionType.setUpperValue(typeParameters.getUpper());
		} catch (InvalidValueException e) {
			logger.error("Out of range upper bound", e);
		}
		specializedType.setUnspecializedElement(unspecializedType);
		MetaModelManager metaModelManager = packageManager.getMetaModelManager();
		Orphanage orphanage = Orphanage.getOrphanage(metaModelManager.getASResourceSet());
		specializedType.setPackage(orphanage);
		return specializedType;
	}

	public synchronized @Nullable Type findSpecializedType(@NonNull CollectionTypeParameters<Type> typeParameters) {
		TemplateSignature templateSignature = getPivotType().getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
		if (templateParameters.size() != 1) {
			return null;
		}
		Map<CollectionTypeParameters<Type>, WeakReference<Type>> specializations2 = specializations;
		if (specializations2 == null) {
			return null;
		}
		WeakReference<Type> weakReference = specializations2.get(typeParameters);
		if (weakReference == null) {
			return null;
		}
		Type type = weakReference.get();
		if (type == null) {
			synchronized (specializations2) {
				type = weakReference.get();
				if (type == null) {
					specializations2.remove(typeParameters);
				}
			}
		}
		return type;
	}

	public synchronized @NonNull Type getSpecializedType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		assert getPivotType() instanceof CollectionType;
		IntegerValue lower2 = lower;
		IntegerValue upper2 = upper;
		if (lower2 == null) {
			lower2 = ValuesUtil.ZERO_VALUE;
		}
		if (upper2 == null) {
			upper2 = ValuesUtil.UNLIMITED_VALUE;
		}
		CollectionTypeParameters<Type> typeParameters = new CollectionTypeParameters<Type>(elementType, lower2, upper2);
		Map<CollectionTypeParameters<Type>, WeakReference<Type>> specializations2 = specializations;
		if (specializations2 == null) {
			synchronized(this) {
				specializations2 = specializations;
				if (specializations2 == null) {
					specializations2 = specializations = new /*Weak*/HashMap<CollectionTypeParameters<Type>, WeakReference<Type>>();
				}
			}
		}
		synchronized (specializations2) {
			Type specializedType = null;
			WeakReference<Type> weakReference = specializations2.get(typeParameters);
			if (weakReference != null) {
				specializedType = weakReference.get();
			}
			if (specializedType == null) {
				specializedType = createSpecialization(typeParameters);
				specializations2.put(typeParameters, new WeakReference<Type>(specializedType));
			}
			return specializedType;
		}
	}
}
