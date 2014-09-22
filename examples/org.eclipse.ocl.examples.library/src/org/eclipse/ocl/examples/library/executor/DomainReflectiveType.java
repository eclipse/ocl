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
package org.eclipse.ocl.examples.library.executor;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainConstraint;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.AbstractFragment;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

public class DomainReflectiveType extends AbstractReflectiveInheritanceType
{
	protected final @NonNull DomainReflectivePackage evaluationPackage;
	protected final @NonNull DomainClass domainClass;
	private /*@LazyNonNull*/ DomainProperties allProperties;

	public DomainReflectiveType(@NonNull DomainReflectivePackage evaluationPackage, @NonNull DomainClass domainClass) {
		super(DomainUtil.nonNullModel(domainClass.getName()), computeFlags(domainClass));
		this.evaluationPackage = evaluationPackage;
		this.domainClass = domainClass;
	}

	@Override
	protected @NonNull AbstractFragment createFragment(@NonNull DomainInheritance baseInheritance) {
		return new DomainReflectiveFragment(this, baseInheritance);
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

	@Override
	public @NonNull Iterable<? extends DomainInheritance> getInitialSuperInheritances() {
		Iterable<? extends DomainClass> superClasses = domainClass.getSuperClasses();
		final Iterator<? extends DomainClass> iterator = superClasses.iterator();
		return new Iterable<DomainInheritance>()
		{
			public Iterator<DomainInheritance> iterator() {
				return new Iterator<DomainInheritance>()
				{
					private @NonNull DomainStandardLibrary standardLibrary = evaluationPackage.getStandardLibrary();
					private boolean gotOne = false;
					
					public boolean hasNext() {
						return !gotOne || iterator.hasNext();
					}

					public DomainInheritance next() {
						DomainClass next = null;
						if (!gotOne) {
							gotOne = true;
							if (!iterator.hasNext()) {
								next = standardLibrary.getOclAnyType();
							}
						}
						if (next == null) {
							next = iterator.next();
						}
						return next.getInheritance(standardLibrary);
					}

					public void remove() {
						throw new UnsupportedOperationException();
					}					
				};
			}			
		};
	}

	public @NonNull Iterable<? extends DomainClass> getSuperClasses() {
		return domainClass.getSuperClasses();
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
		return domainClass.getMetaTypeName();
	}

	public @NonNull List<? extends DomainConstraint> getOwnedInvariants() {
		return domainClass.getOwnedInvariants();
	}

	public @NonNull List<? extends DomainOperation> getOwnedOperations() {
		return domainClass.getOwnedOperations();
	}

	public @NonNull List<? extends DomainProperty> getOwnedProperties() {
		return domainClass.getOwnedProperties();
	}

	public @NonNull List<? extends DomainConstraint> getOwnedRule() {
		throw new UnsupportedOperationException();			// FIXME
	}
	
	public @NonNull DomainPackage getOwningPackage() {
		return evaluationPackage;
	}

	public @NonNull DomainClass getType() {
		return domainClass;
	}

	public @NonNull TypeId getTypeId() {
		return domainClass.getTypeId();
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		return domainClass.getTypeParameters();
	}

	public boolean isOrdered() {
		return domainClass.isOrdered();
	}

	public boolean isUnique() {
		return domainClass.isUnique();
	}
	
	@Override
	public String toString() {
		return String.valueOf(evaluationPackage) + "::" + String.valueOf(name); //$NON-NLS-1$
	}
}