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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * A MetaclassServer supports one or more merged types as the source for operations, properties or superclasses
 * and additionally supports their specializations.
 * <br>
 * The main MetaclassServer for the OCl Standard Library metaclass type supports noprmal usage.
 * <br>
 * Additional Package-specific MetaclassServers support the additional base_XXX, extension_YYY property accesses
 * associated with the application of profile to types within the package.
 */
public class MetaclassServer extends ExtensibleTypeServer
{
	/**
	 * Map from actual types to specialization.
	 * <br>
	 * The specializations are weakly referenced so that stale specializations are garbage collected.
	 */
	// FIXME tests fail if keys are weak since GC is too aggressive across tests
	// The actual types are weak keys so that parameterizations using stale types are garbage collected. 
	//
	private @Nullable /*WeakHash*/Map<Type, WeakReference<Metaclass<?>>> metaclasses = null;

	public MetaclassServer(@NonNull PackageServer packageServer, @NonNull Metaclass<?> domainType) {
		super(packageServer, domainType);
// -- too soon		assert domainType == packageManager.getMetaModelManager().getMetaclassType();
	}
	
	protected @NonNull Metaclass<?> createMetaclass(@NonNull Type type) {
		MetaModelManager metaModelManager = packageManager.getMetaModelManager();
		Metaclass<?> metaclassType = metaModelManager.getMetaclassType();
		Metaclass<?> metaclass = PivotFactory.eINSTANCE.createMetaclass();		
		metaclass.setName(metaclassType.getName());
		metaclass.setInstanceType(type);
		metaclass.setUnspecializedElement(metaclassType);
		//
		TemplateSignature templateSignature = metaclassType.getOwnedTemplateSignature();
		TemplateBinding templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
		templateBinding.setSignature(templateSignature);
		Map<TemplateParameter, ParameterableElement> allBindings = new HashMap<TemplateParameter, ParameterableElement>();
		@SuppressWarnings("null")@NonNull TemplateParameter formalParameter = templateSignature.getOwnedParameter().get(0);
		allBindings.put(formalParameter, type);
		TemplateParameterSubstitution templateParameterSubstitution = createTemplateParameterSubstitution(formalParameter, type);
		templateBinding.getParameterSubstitution().add(templateParameterSubstitution);
		metaclass.getTemplateBinding().add(templateBinding);
		//
		packageManager.resolveSuperClasses(metaclass, metaclassType, allBindings);
		//
		Orphanage orphanage = Orphanage.getOrphanage(metaModelManager.getASResourceSet());
		metaclass.setPackage(orphanage);
		return metaclass;
	}

/*	public synchronized @Nullable Metaclass<?> findSpecializedType(@NonNull Type type) {
		TemplateSignature templateSignature = getPivotType().getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getParameter();
		int iMax = templateParameters.size();
		if (iMax != 1) {
			return null;
		}
		Map<Type, WeakReference<Metaclass>> specializations2 = specializations;
		if (specializations2 == null) {
			return null;
		}
		WeakReference<Metaclass> weakReference = specializations2.get(type);
		if (weakReference == null) {
			return null;
		}
		Metaclass<?> metaclass = weakReference.get();
		if (metaclass == null) {
			synchronized (specializations2) {
				metaclass = weakReference.get();
				if (metaclass == null) {
					specializations2.remove(type);
				}
			}
		}
		return metaclass;
	} */

	@Override
	@Nullable Type findPivotType() {
		for (TypeTracker typeTracker : getTypeTrackers()) {
			DomainType trackedType = typeTracker.getType();
			if (trackedType instanceof Metaclass) {
				return (Metaclass<?>)trackedType;
			}
		}
		return super.findPivotType();
	}

	public synchronized @NonNull Metaclass<?> getMetaclass(@NonNull Type type) {
		Type pivotType = getPivotType();
		assert pivotType instanceof Metaclass;
		TemplateSignature templateSignature = pivotType.getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
		if (templateParameters.size() != 1) {
			throw new IllegalArgumentException("Incompatible metaclass template argument count");
		}
		Map<Type, WeakReference<Metaclass<?>>> metaclasses2 = metaclasses;
		if (metaclasses2 == null) {
			synchronized(this) {
				metaclasses2 = metaclasses;
				if (metaclasses2 == null) {
					metaclasses2 = metaclasses = new /*Weak*/HashMap<Type, WeakReference<Metaclass<?>>>();
				}
			}
		}
		synchronized (metaclasses2) {
			Metaclass<?> metaclass = null;
			WeakReference<Metaclass<?>> weakReference = metaclasses2.get(type);
			if (weakReference != null) {
				metaclass = weakReference.get();
			}
			if (metaclass == null) {
				metaclass = createMetaclass(type);
				metaclasses2.put(type, new WeakReference<Metaclass<?>>(metaclass));
			}
			return metaclass;
		}
	}
}
