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
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainConstraint;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.AbstractFragment;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.AbstractReflectiveInheritanceType;
import org.eclipse.ocl.examples.library.executor.DomainProperties;

public class EcoreReflectiveType extends AbstractReflectiveInheritanceType
{
	@SuppressWarnings("null")
	public static final @NonNull List<DomainInheritance> EMPTY_INHERITANCES = Collections.emptyList();
	protected final @NonNull EcoreReflectivePackage evaluationPackage;
	protected final @NonNull EClassifier eClassifier;
	protected final @NonNull DomainTypeParameters typeParameters;
	private /*@LazyNonNull*/ DomainProperties allProperties;
	
	public EcoreReflectiveType(@NonNull EcoreReflectivePackage evaluationPackage, int flags, @NonNull EClassifier eClassifier, @NonNull DomainTemplateParameter... typeParameters) {
		super(DomainUtil.nonNullEMF(eClassifier.getName()), flags);
		this.evaluationPackage = evaluationPackage;
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
	
	public @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		if (this == type) {
			return this.getType();
		}
		DomainInheritance firstInheritance = this;
		DomainInheritance secondInheritance = type.getInheritance(idResolver.getStandardLibrary());
		DomainInheritance commonInheritance = firstInheritance.getCommonInheritance(secondInheritance);
		return commonInheritance.getType();
	}

	public final @NonNull EClassifier getEClassifier() {
		return eClassifier;
	}

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
							return evaluationPackage.getIdResolver().getInheritance(next);
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
	
	public @NonNull DomainPackage getOwningPackage() {
		return evaluationPackage;
	}

	public @NonNull List<? extends DomainClass> getSuperClasses() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @Nullable DomainOperation getMemberOperation(@NonNull OperationId operationId) {
		throw new UnsupportedOperationException();					// FIXME
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

	public @NonNull List<? extends DomainConstraint> getOwnedInvariants() {
		throw new UnsupportedOperationException();			// FIXME
	}

	public @NonNull List<? extends DomainProperty> getOwnedProperties() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull List<? extends DomainOperation> getOwnedOperations() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull List<? extends DomainConstraint> getOwnedRule() {
		throw new UnsupportedOperationException();			// FIXME
	}

	public @NonNull DomainClass getType() {
		return this;
	}

	public @NonNull TypeId getTypeId() {
		return getOwningPackage().getPackageId().getClassId(name, getType().getTypeParameters().parametersSize());			// FIXME DataTypeId alternative
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		return typeParameters;
	}

	public boolean isOrdered() {
		return (flags & ORDERED) != 0;
	}

	public boolean isUnique() {
		return (flags & UNIQUE) != 0;
	}
}
