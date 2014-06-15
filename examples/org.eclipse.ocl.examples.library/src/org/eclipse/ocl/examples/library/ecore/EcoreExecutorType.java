/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.BuiltInTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorFragment;
import org.eclipse.ocl.examples.library.executor.ExecutorPackage;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.executor.ExecutorTypeParameter;

public class EcoreExecutorType extends ExecutorType
{
	protected @Nullable EClassifier eClassifier;
	private @Nullable TypeId typeId = null;
	
	/**
	 * Construct an executable type descriptor in the absence of a known EClassifier. A subsequent
	 * call of {@link #initFragments(ExecutorFragment[], int[], EClassifier)} may define an EClassifier.
	 */
	public EcoreExecutorType(@NonNull String name, @NonNull ExecutorPackage evaluationPackage, int flags, @NonNull ExecutorTypeParameter... typeParameters) {
		super(name, evaluationPackage, flags, typeParameters);
		this.eClassifier = null;		
	}
	
	/**
	 * Construct an executable type descriptor in the absence of a known EClassifier. A subsequent
	 * call of {@link #initFragments(ExecutorFragment[], int[], EClassifier)} may define an EClassifier.
	 */
	public EcoreExecutorType(@NonNull BuiltInTypeId typeId, @NonNull ExecutorPackage evaluationPackage, int flags, @NonNull ExecutorTypeParameter... typeParameters) {
		super(typeId.getName(), evaluationPackage, flags, typeParameters);
		this.eClassifier = null;		
		this.typeId = typeId;		
	}
	
	/**
	 * Construct an executable type descriptor for a known EClassifier.
	 */
	public EcoreExecutorType(/*@NonNull*/ EClassifier eClassifier, @NonNull EcoreExecutorPackage evaluationPackage, int flags, @NonNull ExecutorTypeParameter... typeParameters) {
		super(DomainUtil.nonNullModel(eClassifier.getName()), evaluationPackage, flags, typeParameters);
		this.eClassifier = eClassifier;		
	}

	public @NonNull Object createInstance() {
		EClassifier eClassifier2 = eClassifier;
		if (eClassifier2 instanceof EClass) {
			EClass eClass = (EClass)eClassifier2;
			EObject element = eClass.getEPackage().getEFactoryInstance().create(eClass);
//			TypeId typeId = IdManager.getTypeId(eClass);
			return /*ValuesUtil.createObjectValue(typeId, */DomainUtil.nonNullEMF(element); //);
		}
		throw new UnsupportedOperationException();
	}

	public @Nullable Object createInstance(@NonNull String value) {
		EClassifier eClassifier2 = eClassifier;
		if (eClassifier2 instanceof EDataType) {
			EDataType eDataType = (EDataType) eClassifier2;
			Object element = eDataType.getEPackage().getEFactoryInstance().createFromString(eDataType, value);
			return /*ValuesUtil.valueOf(*/DomainUtil.nonNullEMF(element); //);
		}
		throw new UnsupportedOperationException();
	}

	public final EClassifier getEClassifier() {
		return eClassifier;
	}

	@Override
	public @NonNull String getMetaTypeName() {
		if (eClassifier != null) {					// FIXME Enforce @NonNull
			return DomainUtil.nonNullModel(DomainUtil.nonNullState(eClassifier).getName());
		}
		else {
			return getTypeId().getMetaTypeName();
		}
	}
	
	@Override
	public @NonNull TypeId getTypeId() {
		TypeId typeId2 = typeId;
		if (typeId2 == null) {
			synchronized (this) {
				typeId2 = typeId;
				if (typeId2 == null) {
					EClassifier eClassifier2 = eClassifier;
					if (eClassifier2 != null) {
						typeId2 = IdManager.getTypeId(eClassifier2);
					}
					else {
						if (TypeId.METACLASS_NAME.equals(name)) {
							typeId2 = TypeId.METACLASS;
						}
						else {
							PackageId packageTypeId = evaluationPackage.getPackageId(); //IdManager.getPackageId(evaluationPackage);
							DomainTypeParameters typeParameters = getTypeParameters();
							if (eClassifier instanceof EDataType) {
								typeId2 = packageTypeId.getDataTypeId(name, typeParameters.parametersSize());
							}
							else {
								typeId2 = packageTypeId.getClassId(name, typeParameters.parametersSize());
							}
						}
					}
					typeId = typeId2;
				}
			}
		}
		return typeId2;
	}

	/**
	 * Define the EClassifier associated with an executable type. This initialization may
	 * be performed once to allow an Ecore-aware package of type descriptors to re-use and
	 * enhance an Ecore-unaware package. This occurs for the PivotTables that enhance the
	 * OCLstdlibTables.
	 */
	public @NonNull EcoreExecutorType initFragments(@NonNull ExecutorFragment[] fragments, int[] depthCounts, /*@NonNull*/ EClassifier eClassifier) {
		assert eClassifier != null;
		assert this.eClassifier == null;
		assert name.equals(eClassifier.getName());
		this.eClassifier = DomainUtil.nonNullState(eClassifier);		
		initFragments(fragments, depthCounts);
		return this;
	}
}
