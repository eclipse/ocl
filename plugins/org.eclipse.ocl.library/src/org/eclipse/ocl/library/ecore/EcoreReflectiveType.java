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
package org.eclipse.ocl.library.ecore;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.domain.ids.OperationId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.types.AbstractFragment;
import org.eclipse.ocl.domain.types.IdResolver;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.library.executor.AbstractReflectiveInheritanceType;
import org.eclipse.ocl.library.executor.DomainProperties;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.Type;

public class EcoreReflectiveType extends AbstractReflectiveInheritanceType
{
	@SuppressWarnings("null")
	public static final @NonNull List<CompleteInheritance> EMPTY_INHERITANCES = Collections.emptyList();
	protected final @NonNull EcoreReflectivePackage evaluationPackage;
	protected final @NonNull EClassifier eClassifier;
	protected final @NonNull DomainTypeParameters typeParameters;
	private /*@LazyNonNull*/ DomainProperties allProperties;
	
	public EcoreReflectiveType(@NonNull EcoreReflectivePackage evaluationPackage, int flags, @NonNull EClassifier eClassifier, @NonNull TemplateParameter... typeParameters) {
		super(DomainUtil.nonNullEMF(eClassifier.getName()), flags);
		this.evaluationPackage = evaluationPackage;
		this.eClassifier = eClassifier;
		this.typeParameters = new DomainTypeParameters(typeParameters);
	}

	@Override
	protected @NonNull AbstractFragment createFragment(@NonNull CompleteInheritance baseInheritance) {
		return new EcoreReflectiveFragment(this, baseInheritance);
	}

	@Override
	public @NonNull EObject createInstance() {
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
	
	@Override
	public @NonNull Type getCommonType(@NonNull IdResolver idResolver, @NonNull Type type) {
		if (this == type) {
			return this.getType();
		}
		CompleteInheritance firstInheritance = this;
		CompleteInheritance secondInheritance = type.getInheritance(idResolver.getStandardLibrary());
		CompleteInheritance commonInheritance = firstInheritance.getCommonInheritance(secondInheritance);
		return commonInheritance.getType();
	}

	public final @NonNull EClassifier getEClassifier() {
		return eClassifier;
	}

	@Override
	public @NonNull Iterable<? extends CompleteInheritance> getInitialSuperInheritances() {
		List<EClass> eSuperTypes = eClassifier instanceof EClass ? ((EClass)eClassifier).getESuperTypes() : Collections.<EClass>emptyList();
		final Iterator<EClass> iterator = eSuperTypes.iterator();
		return new Iterable<CompleteInheritance>()
		{
			@Override
			public Iterator<CompleteInheritance> iterator() {
				return new Iterator<CompleteInheritance>()
				{
					private boolean gotOne = false;
					
					@Override
					public boolean hasNext() {
						return !gotOne || iterator.hasNext();
					}

					@Override
					public CompleteInheritance next() {
						if (!gotOne) {
							gotOne = true;
							if (!iterator.hasNext()) {
								DomainStandardLibrary standardLibrary = evaluationPackage.getStandardLibrary();
								org.eclipse.ocl.pivot.Class oclAnyType = standardLibrary.getOclAnyType();
								return standardLibrary.getInheritance(oclAnyType);
							}
						}
						EClass next = iterator.next();
						assert next != null;
						EcoreIdResolver idResolver = evaluationPackage.getIdResolver();
						return idResolver.getInheritance(next);
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}					
				};
			}			
		};
	}
	
	@Override
	public @NonNull org.eclipse.ocl.pivot.Package getOwningPackage() {
		return evaluationPackage;
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Class> getSuperClasses() {
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @Nullable Operation getMemberOperation(@NonNull OperationId operationId) {
		throw new UnsupportedOperationException();					// FIXME
	}

	@Override
	public @Nullable Property getMemberProperty(@NonNull String name) {
		DomainProperties allProperties2 = allProperties;
		if (allProperties2 == null) {
			allProperties = allProperties2 = new DomainProperties(this);
		}
		return allProperties2.getMemberProperty(name);
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return DomainUtil.nonNullPivot(eClassifier.getName());
	}

	@Override
	public @NonNull List<Constraint> getOwnedInvariants() {
		throw new UnsupportedOperationException();			// FIXME
	}

	@Override
	public @NonNull List<Property> getOwnedProperties() {
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull List<Operation> getOwnedOperations() {
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull List<Constraint> getOwnedRule() {
		throw new UnsupportedOperationException();			// FIXME
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getType() {
		return this;
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return getOwningPackage().getPackageId().getClassId(name, getType().getTypeParameters().parametersSize());			// FIXME DataTypeId alternative
	}

	@Override
	public @NonNull DomainTypeParameters getTypeParameters() {
		return typeParameters;
	}

	@Override
	public boolean isOrdered() {
		return (flags & ORDERED) != 0;
	}

	@Override
	public boolean isUnique() {
		return (flags & UNIQUE) != 0;
	}
}
