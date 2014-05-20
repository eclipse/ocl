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

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * An TemplateableTypeServer supports one or more merged types as the source for operations, properties or superclasses
 * and additionally supports their specializations.
 */
public class TemplateableTypeServer extends ExtensibleTypeServer
{
	/**
	 * Map from actual types to specialization.
	 * <br>
	 * The specializations are weakly referenced so that stale specializations are garbage collected.
	 */
	// FIXME tests fail if keys are weak since GC is too aggressive across tests
	// The actual types are weak keys so that parameterizations using stale types are garbage collected. 
	//
	private @Nullable /*WeakHash*/Map<DomainTypeParameters, WeakReference<Type>> specializations = null;

	protected TemplateableTypeServer(@NonNull PackageServer packageServer, @NonNull DomainType domainType) {
		super(packageServer, domainType);
	}
	
	protected @NonNull Type createSpecialization(@NonNull DomainTypeParameters templateArguments) {
		Type unspecializedType = getPivotType();
		String typeName = unspecializedType.getName();
		TemplateSignature templateSignature = unspecializedType.getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
		EClass eClass = unspecializedType.eClass();
		EFactory eFactoryInstance = eClass.getEPackage().getEFactoryInstance();
		Type specializedType = (Type) eFactoryInstance.create(eClass);		
		specializedType.setName(typeName);
		TemplateBinding templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
		templateBinding.setSignature(templateSignature);
		Map<TemplateParameter, ParameterableElement> allBindings = new HashMap<TemplateParameter, ParameterableElement>();
		for (int i = 0; i < templateParameters.size(); i++) {
			TemplateParameter formalParameter = templateParameters.get(i);
			if (formalParameter != null) {
				Object templateArgument = templateArguments.get(i);
				if (templateArgument instanceof ParameterableElement) {
					ParameterableElement actualType = (ParameterableElement) templateArgument;
					allBindings.put(formalParameter, actualType);
					TemplateParameterSubstitution templateParameterSubstitution = AbstractTypeServer
						.createTemplateParameterSubstitution(formalParameter,
							actualType);
					templateBinding.getParameterSubstitution().add(
						templateParameterSubstitution);
				}
			}
		}
		specializedType.getTemplateBinding().add(templateBinding);
		packageManager.resolveSuperClasses(specializedType, unspecializedType, allBindings);
//		if (specializedType instanceof Metaclass) {
//			Type instanceType = (Type) templateArguments.get(0);
//			Metaclass specializedMetaclass = (Metaclass)specializedType;
//			specializedMetaclass.setInstanceType(instanceType);
//		}
		specializedType.setUnspecializedElement(unspecializedType);
		MetaModelManager metaModelManager = packageManager.getMetaModelManager();
		Orphanage orphanage = Orphanage.getOrphanage(metaModelManager.getASResourceSet());
		specializedType.setPackage(orphanage);
		return specializedType;
	}

	public synchronized @Nullable Type findSpecializedType(@NonNull DomainTypeParameters templateArguments) {
		TemplateSignature templateSignature = getPivotType().getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
		int iMax = templateParameters.size();
		if (templateArguments.parametersSize() != iMax) {
			return null;
		}
		Map<DomainTypeParameters, WeakReference<Type>> specializations2 = specializations;
		if (specializations2 == null) {
			return null;
		}
		WeakReference<Type> weakReference = specializations2.get(templateArguments);
		if (weakReference == null) {
			return null;
		}
		Type type = weakReference.get();
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

	public synchronized @NonNull Type getSpecializedType(@NonNull List<? extends DomainElement> templateArguments) {
		return getSpecializedType(new DomainTypeParameters(templateArguments));
	}

	public synchronized @NonNull Type getSpecializedType(@NonNull DomainTypeParameters templateArguments) {
		TemplateSignature templateSignature = getPivotType().getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
		int iMax = templateParameters.size();
		if (templateArguments.parametersSize() != iMax) {
			throw new IllegalArgumentException("Incompatible template argument count");
		}
		Map<DomainTypeParameters, WeakReference<Type>> specializations2 = specializations;
		if (specializations2 == null) {
			synchronized(this) {
				specializations2 = specializations;
				if (specializations2 == null) {
					specializations2 = specializations = new /*Weak*/HashMap<DomainTypeParameters, WeakReference<Type>>();
				}
			}
		}
		synchronized (specializations2) {
			Type specializedType = null;
			WeakReference<Type> weakReference = specializations2.get(templateArguments);
			if (weakReference != null) {
				specializedType = weakReference.get();
			}
			if (specializedType == null) {
				specializedType = createSpecialization(templateArguments);
				specializations2.put(templateArguments, new WeakReference<Type>(specializedType));
			}
			return specializedType;
		}
	}
}
