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
package org.eclipse.ocl.examples.library.ecore;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.domain.types.AbstractFragment;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.DomainProperties;
import org.eclipse.ocl.examples.library.executor.ReflectiveType;
//import org.eclipse.ocl.examples.domain.types.IdResolver;

public class EcoreReflectiveType extends ReflectiveType
{
	@SuppressWarnings("null")
	public static final @NonNull List<DomainInheritance> EMPTY_INHERITANCES = Collections.emptyList();
	protected final @NonNull EClassifier eClassifier;
	protected final @NonNull DomainTypeParameters typeParameters;
	private /*@LazyNonNull*/ DomainProperties allProperties;
	
	public EcoreReflectiveType(@NonNull EcoreReflectivePackage evaluationPackage, int flags, @NonNull EClassifier eClassifier, @NonNull DomainTemplateParameter... typeParameters) {
		super(DomainUtil.nonNullEMF(eClassifier.getName()), evaluationPackage, flags);
		this.eClassifier = eClassifier;
		this.typeParameters = new DomainTypeParameters(typeParameters);
	}

	@Override
	protected @NonNull AbstractFragment createFragment(@NonNull DomainInheritance baseInheritance) {
		return new EcoreReflectiveFragment(this, baseInheritance);
	}

	@Override
	public @NonNull Object createInstance() {
		if (eClassifier instanceof EClass) {
			EClass eClass = (EClass)eClassifier;
			EObject element = eClass.getEPackage().getEFactoryInstance().create(eClass);
//			TypeId typeId = IdManager.INSTANCE.getTypeId(eClass);
			return /*ValuesUtil.createObjectValue(typeId,*/ DomainUtil.nonNullEMF(element); //);
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Object createInstance(@NonNull String value) {
		if (eClassifier instanceof EDataType) {
			EDataType eDataType = (EDataType)eClassifier;
			Object element = eDataType.getEPackage().getEFactoryInstance().createFromString(eDataType, value);
			return DomainUtil.nonNullEMF(element);
		}
		throw new UnsupportedOperationException();
	}

	@NonNull
	public Iterable<? extends DomainOperation> getAllOperations(@Nullable FeatureFilter featureFilter) {
		throw new UnsupportedOperationException();
	}

	public @NonNull Iterable<? extends DomainProperty> getAllProperties(@Nullable FeatureFilter featureFilter) {
		DomainProperties allProperties2 = allProperties;
		if (allProperties2 == null) {
			allProperties = allProperties2 = new DomainProperties(this);
		}
		return allProperties2.getAllProperties(featureFilter);
	}

	public final @NonNull EClassifier getEClassifier() {
		return eClassifier;
	}

//	public @NonNull IdResolver getIdResolver() {
//		return ((EcoreReflectivePackage)getPackage()).getIdResolver();
//	}

	@Override
	public @NonNull Iterable<? extends DomainInheritance> getInitialSuperInheritances() {
		if (eClassifier instanceof EClass) {
			final Iterator<EClass> iterator = ((EClass)eClassifier).getESuperTypes().iterator();
			return new Iterable<DomainInheritance>()
			{
				public Iterator<DomainInheritance> iterator() {
					return new Iterator<DomainInheritance>()
					{
						public boolean hasNext() {
							return iterator.hasNext();
						}

						public DomainInheritance next() {
							EClass next = iterator.next();
							assert next != null;
							return ((EcoreReflectivePackage)evaluationPackage).getIdResolver().getType(next);
						}

						public void remove() {
							throw new UnsupportedOperationException();
						}					
					};
				}			
			};
		}
		else {
			return EMPTY_INHERITANCES;
		}
	}

	public @NonNull List<? extends DomainOperation> getLocalOperations() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull List<? extends DomainProperty> getLocalProperties() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull List<? extends DomainType> getLocalSuperTypes() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @Nullable DomainProperty getMemberProperty(@NonNull String name) {
		DomainProperties allProperties2 = allProperties;
		if (allProperties2 == null) {
			allProperties = allProperties2 = new DomainProperties(this);
		}
		return allProperties2.getMemberProperty(name);
	}

	public @NonNull String getMetaTypeName() {
		return DomainUtil.nonNullPivot(eClassifier.getName());
	}

	public @NonNull List<? extends DomainProperty> getOwnedAttribute() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull List<? extends DomainOperation> getOwnedOperation() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull DomainStandardLibrary getStandardLibrary() {
		return ((EcoreReflectivePackage)getPackage()).getStandardLibrary(); //OCLstdlibTables.LIBRARY;
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		return typeParameters;
	}
}
