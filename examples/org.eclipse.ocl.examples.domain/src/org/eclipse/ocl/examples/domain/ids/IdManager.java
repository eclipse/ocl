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
package org.eclipse.ocl.examples.domain.ids;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.DomainConstants;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainLambdaType;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.impl.BindingsIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.GeneralizedCollectionTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.GeneralizedLambdaTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.GeneralizedTupleTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.NsURIPackageIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.ParametersIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.PrimitiveTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.RootPackageIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.TemplateParameterIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.TuplePartIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.UnspecifiedIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.WeakHashMapOfListOfWeakReference2;
import org.eclipse.ocl.examples.domain.ids.impl.WeakHashMapOfListOfWeakReference3;
import org.eclipse.ocl.examples.domain.ids.impl.WeakHashMapOfListOfWeakReference4;
import org.eclipse.ocl.examples.domain.ids.impl.WeakHashMapOfWeakReference;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * IdManager supervises the thread-safe allocation of unique hierarchical identifier to each metamodel element.
 * 
 * @see ElementId
 */
public final class IdManager
{
	/*
	 * IdManager is final and the sole instance of IdManager is private and ElementId implementations need an IdManager
	 * for construction so ElementId uniqueness is guaranteed.
	 */
	private static @NonNull IdManager PRIVATE_INSTANCE = new IdManager();
	@Deprecated // or rather make this private
	public static @NonNull IdManager INSTANCE = PRIVATE_INSTANCE;

	/**
	 * @since 3.5
	 */
	public static final @NonNull RootPackageId METAMODEL = new RootPackageIdImpl(PRIVATE_INSTANCE, DomainConstants.METAMODEL_NAME);

	/**
	 * Map from the BindingsId hashCode to the elements with the same hash. 
	 */
	private static @Nullable WeakHashMapOfListOfWeakReference2<Integer, ElementId[], BindingsIdImpl> bindingsIds;

	/**
	 * Map from a Collection type name to the corresponding CollectionTypeId. 
	 */
	private static @NonNull WeakHashMapOfWeakReference<String, CollectionTypeId> collectionNames =
		new WeakHashMapOfWeakReference<String, CollectionTypeId>()
		{
			@Override
			protected @NonNull CollectionTypeId newId(@NonNull String name) {
				return new GeneralizedCollectionTypeIdImpl(PRIVATE_INSTANCE, name);
			}
		};

	/**
	 * Map from an nsURI to the corresponding NsURITypeId. 
	 */
	private static @NonNull WeakHashMapOfWeakReference<String, NsURIPackageId> nsURIs =
		new WeakHashMapOfWeakReference<String, NsURIPackageId>()
		{
			@Override
			protected @NonNull NsURIPackageId newId(@NonNull String nsURI) {
				return new NsURIPackageIdImpl(PRIVATE_INSTANCE, nsURI, null, null);
			}
		};
		
	/**
	 * Map from the Lambda hashCode to the lambda typeIds with the same hash. 
	 */
	private static @Nullable WeakHashMapOfListOfWeakReference3<Integer, String, ParametersId, GeneralizedLambdaTypeIdImpl> lambdaTypes = null;
	
	/**
	 * Map from the TuplePart hashCode to the tuplePartIds with the same hash. 
	 */
	private static @Nullable WeakHashMapOfListOfWeakReference4<Integer, Integer, String, TypeId, TuplePartIdImpl> tupleParts = null;

	/**
	 * Map from a name to the corresponding URI-less unnested RootPackageTypeId. 
	 */
	private static @NonNull WeakHashMapOfWeakReference<String, RootPackageId> roots =
		new WeakHashMapOfWeakReference<String, RootPackageId>()
		{
			@Override
			protected @NonNull RootPackageId newId(@NonNull String name) {
				return new RootPackageIdImpl(PRIVATE_INSTANCE, name);
			}
		};
		
	/**
	 * List of template parameters; 0 index at least index ... up to most nested
	 */
	private static @NonNull List<TemplateParameterId> templateParameters = new ArrayList<TemplateParameterId>(10);

	/**
	 * Map from the Tuple hashCode to the tuple typeIds with the same hash. 
	 */
	private static @Nullable WeakHashMapOfListOfWeakReference3<Integer, String, TuplePartId[], GeneralizedTupleTypeIdImpl> tupleTypes = null;

	/**
	 * Map from the ParametersId hashCode to the parametersId with the same hash. 
	 */
	private static @Nullable WeakHashMapOfListOfWeakReference2<Integer, TypeId[], ParametersIdImpl> parametersIds;

	/**
	 * Map from a Primitive type name to the corresponding PrimitiveTypeId. 
	 */
	private static @NonNull WeakHashMapOfWeakReference<String, PrimitiveTypeId> primitiveTypes =
		new WeakHashMapOfWeakReference<String, PrimitiveTypeId>()
		{
			@Override
			protected @NonNull PrimitiveTypeId newId(@NonNull String name) {
				return new PrimitiveTypeIdImpl(PRIVATE_INSTANCE, name);
			}
		};

	public static @NonNull BindingsId getBindingsId(@NonNull DomainType... types) {
		ElementId[] elementIds = new ElementId[types.length];
		for (int i = 0; i < types.length; i++) {
			elementIds[i] = types[i].getTypeId();
		}
		return getBindingsId(elementIds);
	}

	/**
	 * Return the bindingsId for a given type list.
	 */
    public static @NonNull BindingsId getBindingsId(@NonNull ElementId... elementIds) {
		WeakHashMapOfListOfWeakReference2<Integer, ElementId[], BindingsIdImpl> bindingsIds2 = bindingsIds;
		if (bindingsIds2 == null) {
    		synchronized (IdManager.class) {
    			bindingsIds2 = bindingsIds;
    	    	if (bindingsIds2 == null) {
    	    		bindingsIds = bindingsIds2 = new WeakHashMapOfListOfWeakReference2<Integer, ElementId[], BindingsIdImpl>()
    				{
    	    			@Override
    	    			protected @NonNull BindingsIdImpl newId(@NonNull Integer hashCode, @NonNull ElementId[] elementIds) {
    	    			   	return new BindingsIdImpl(PRIVATE_INSTANCE, hashCode, elementIds);
    	    			}		
					};
	    	   }
    		}
    	}
		@SuppressWarnings("null")@NonNull Integer hashCode = IdHash.createParametersHash(BindingsId.class, elementIds);
		return bindingsIds2.getId(hashCode, elementIds);
	}

    /**
     * Return the classId for aType.
      */
	public static @NonNull ClassId getClassId(@NonNull DomainType aType) {
		String name = aType.getName();
		assert name != null;
		DomainPackage parentPackage = aType.getPackage();
		if (parentPackage != null) {
			DomainTypeParameters typeParameters = aType.getTypeParameters();
			PackageId packageId = parentPackage.getPackageId();
			return packageId.getClassId(name, typeParameters.parametersSize());
		}
		else {
			return getUnspecifiedTypeId(aType);		// FIXME This occurs for underspecified/wildcard types
		}
	}

	/**
	 * Return the named collection typeId.
	 */
	public static @NonNull CollectionTypeId getCollectionTypeId(@NonNull String collectionTypeName) {
		return collectionNames.getId(collectionTypeName);
	}

    /**
     * Return the dataTypeId for aType.
      */
	public static @NonNull DataTypeId getDataTypeId(@NonNull DomainType aType) {
		String name = aType.getName();
		assert name != null;
		DomainPackage parentPackage = aType.getPackage();
		if (parentPackage != null) {
			DomainTypeParameters typeParameters = aType.getTypeParameters();
			PackageId packageId = parentPackage.getPackageId();
			return packageId.getDataTypeId(name, typeParameters.parametersSize());
		}
		else {
			return new UnspecifiedIdImpl(PRIVATE_INSTANCE, aType);		// FIXME This occurs for underspecified/wildcard types
		}
	}

    /**
     * Return the typeId for aType.
      */
	public static @NonNull EnumerationId getEnumerationId(@NonNull DomainEnumeration anEnumeration) {
		String name = anEnumeration.getName();
		assert name != null;
		DomainPackage parentPackage = anEnumeration.getPackage();
		assert parentPackage != null;
		return parentPackage.getPackageId().getEnumerationId(name);
	}

    /**
     * Return the typeId for an EEnum.
      */
	public static @NonNull EnumerationId getEnumerationId(@NonNull EEnum eEnum) {
		String name = eEnum.getName();
		assert name != null;
		EPackage parentPackage = eEnum.getEPackage();
		assert parentPackage != null;
		return getPackageId(parentPackage).getEnumerationId(name);
	}

	public static @NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull EEnumLiteral eEnumLiteral) {
		EEnum eEnum = DomainUtil.nonNullModel(eEnumLiteral.getEEnum());
		String name = DomainUtil.nonNullModel(eEnumLiteral.getName());
		EnumerationId enumerationId = getEnumerationId(eEnum);
		EnumerationLiteralId enumerationLiteralId = enumerationId.getEnumerationLiteralId(name);
		return enumerationLiteralId;
	}

    /**
     * Return the typeId for aLambdaType.
      */
	public static @NonNull LambdaTypeId getLambdaTypeId(@NonNull DomainLambdaType lambdaType) {
		String name = DomainUtil.getSafeName(lambdaType);
		return getLambdaTypeId(name, lambdaType.getParametersId());
	}

	/**
	 * Return the named lambda typeId with the defined type parameters.
	 */
	public static @NonNull LambdaTypeId getLambdaTypeId(@NonNull String name, @NonNull TypeId... typeIds) {
    	return getLambdaTypeId(name, getParametersId(typeIds));
	}

	/**
	 * Return the named lambda typeId with the defined type parameters.
	 */
	public static @NonNull LambdaTypeId getLambdaTypeId(@NonNull String name, @NonNull ParametersId parametersId) {
		WeakHashMapOfListOfWeakReference3<Integer, String, ParametersId, GeneralizedLambdaTypeIdImpl> lambdaTypes2 = lambdaTypes;
		if (lambdaTypes2 == null) {
    		synchronized (IdManager.class) {
    			lambdaTypes2 = lambdaTypes;
    	    	if (lambdaTypes2 == null) {
    	    		lambdaTypes = lambdaTypes2 = new WeakHashMapOfListOfWeakReference3<Integer, String, ParametersId, GeneralizedLambdaTypeIdImpl>()
    				{
    	    			@Override
    	    			protected @NonNull GeneralizedLambdaTypeIdImpl newId(@NonNull Integer hashCode, @NonNull String name, @NonNull ParametersId parametersId) {
    	    				return new GeneralizedLambdaTypeIdImpl(hashCode, name, parametersId);
    	    			}		
					};
	    	   }
    		}
    	}
		int childHash = IdHash.createGlobalHash(LambdaTypeId.class, name);
		Integer hashCode = childHash + parametersId.hashCode();
    	return lambdaTypes2.getId(hashCode, name, parametersId);
	}

	/**
	 * Return the URIed package typeId.
	 */
	@Deprecated
    public static @NonNull NsURIPackageId getNsURIPackageId(@NonNull String nsURI, @Nullable EPackage ePackage) {
    	return getNsURIPackageId(nsURI, null, ePackage);
    }
    public static @NonNull NsURIPackageId getNsURIPackageId(@NonNull String nsURI, @Nullable String nsPrefix, @Nullable EPackage ePackage) {
		WeakReference<NsURIPackageId> ref = nsURIs.get(nsURI);
		if (ref != null) {
			NsURIPackageId oldTypeId = ref.get();
			if (oldTypeId != null) {
				if ((ePackage != null) && (oldTypeId.getEPackage() == null)) {
					oldTypeId.setEPackage(ePackage);
				}
				return oldTypeId;
			}
		}
		synchronized (nsURIs) {
			ref = nsURIs.get(nsURI);
			if (ref != null) {
				NsURIPackageId oldTypeId = ref.get();
				if (oldTypeId != null) {
					return oldTypeId;
				}
			}
			NsURIPackageId newTypeId = new NsURIPackageIdImpl(PRIVATE_INSTANCE, nsURI, nsPrefix, ePackage);
			nsURIs.put(nsURI, new WeakReference<NsURIPackageId>(newTypeId));
			return newTypeId;
		}
    }

    /**
     * Return the OperationId for anOperation.
      */
	public static @NonNull OperationId getOperationId(@NonNull DomainOperation anOperation) {
		String name = DomainUtil.getSafeName(anOperation);
		DomainType parentType = anOperation.getOwningType();
		TypeId parentTypeId = parentType.getTypeId();
		DomainType[] parameterTypes = DomainUtil.getOperationParameterTypes(anOperation);
		DomainTypeParameters typeParameters = anOperation.getTypeParameters();
		ParametersId parametersId = getParametersId(parameterTypes);
		return parentTypeId.getOperationId(typeParameters.parametersSize(), name, parametersId);
	}

	/**
	 * Return the named tuple typeId with the defined parts (which are alphabetically ordered by part name).
	 */
    public static @NonNull TupleTypeId getOrderedTupleTypeId(@NonNull String name, @NonNull TuplePartId[] parts) {
		WeakHashMapOfListOfWeakReference3<Integer, String, TuplePartId[], GeneralizedTupleTypeIdImpl> tupleTypes2 = tupleTypes;
		if (tupleTypes2 == null) {
    		synchronized (IdManager.class) {
    			tupleTypes2 = tupleTypes;
    	    	if (tupleTypes2 == null) {
    	    		tupleTypes = tupleTypes2 = new WeakHashMapOfListOfWeakReference3<Integer, String, TuplePartId[], GeneralizedTupleTypeIdImpl>()
    				{
    	    			@Override
    	    			protected @NonNull GeneralizedTupleTypeIdImpl newId(@NonNull Integer hashCode, @NonNull String name, @NonNull TuplePartId[] parts) {
    	    				return new GeneralizedTupleTypeIdImpl(PRIVATE_INSTANCE, hashCode, name, parts);
    	    			}		
					};
	    	   }
    		}
    	}
		int hash = IdHash.createTupleHash(name, parts);
		return tupleTypes2.getId(hash, name, parts);
	}

    /**
     * Return the typeId for aPackage.
     */
	public static @NonNull PackageId getPackageId(@NonNull DomainPackage aPackage) {
		String nsURI = aPackage.getNsURI();
		if (nsURI != null) {
			return getNsURIPackageId(nsURI, aPackage.getNsPrefix(), aPackage.getEPackage());
		}
		String name = aPackage.getName();
		assert name != null;
		DomainPackage parentPackage = aPackage.getNestingPackage();
		if (parentPackage != null) {
			return parentPackage.getPackageId().getNestedPackageId(name);
		}
		else {
			return getRootPackageId(name);
		}
	}

    /**
     * Return the typeId for ePackage.
     */
	public static @NonNull PackageId getPackageId(@NonNull EPackage aPackage) {
		if (DomainUtil.basicGetMetamodelAnnotation(aPackage) != null) {
			return METAMODEL;
		}
		String nsURI = aPackage.getNsURI();
		if (nsURI != null) {
			if (nsURI.equals(UMLPackage.eNS_URI)) {		// FIXME use extension point
				return getRootPackageId(DomainConstants.UML_METAMODEL_NAME);
			}
			else if (nsURI.equals(TypesPackage.eNS_URI)) {		// FIXME use extension point
				return getRootPackageId(DomainConstants.TYPES_METAMODEL_NAME);
			}
			else {
				return getNsURIPackageId(nsURI, aPackage.getNsPrefix(), aPackage);
			}
		}
		String name = aPackage.getName();
		assert name != null;
		EPackage parentPackage = aPackage.getESuperPackage();
		if (parentPackage != null) {
			return getPackageId(parentPackage).getNestedPackageId(name);
		}
		return getNsURIPackageId(name, aPackage.getNsPrefix(), null);
	}
	
	public static @NonNull ParametersId getParametersId(@NonNull DomainType[] parameterTypes) {
		int iSize = parameterTypes.length;
		TypeId[] typeIds = new TypeId[iSize];
		for (int i = 0; i < iSize; i++) {
			DomainType parameterType = parameterTypes[i];
			typeIds[i] = parameterType != null ? parameterType.getTypeId() : TypeId.OCL_INVALID;		// Never happens NPE guard
		}
		return getParametersId(typeIds);
	}

	/**
	 * Return the parametersId for a given type list.
	 */
    public static @NonNull ParametersId getParametersId(@NonNull TypeId... typeIds) {
		WeakHashMapOfListOfWeakReference2<Integer, TypeId[], ParametersIdImpl> parametersIds2 = parametersIds;
		if (parametersIds2 == null) {
    		synchronized (IdManager.class) {
    			parametersIds2 = parametersIds;
    	    	if (parametersIds2 == null) {
    	    		parametersIds = parametersIds2 = new WeakHashMapOfListOfWeakReference2<Integer, TypeId[], ParametersIdImpl>()
    				{
    	    			@Override
    	    			protected @NonNull ParametersIdImpl newId(@NonNull Integer hashCode, @NonNull TypeId[] typeIds) {
    	    			   	return new ParametersIdImpl(PRIVATE_INSTANCE, hashCode, typeIds);
    	    			}		
					};
	    	   }
    		}
    	}
		@SuppressWarnings("null")@NonNull Integer hashCode = IdHash.createParametersHash(ParametersId.class, typeIds);
		return parametersIds2.getId(hashCode, typeIds);
	}

	/**
	 * Return the named primitive typeId.
	 */
	public static @NonNull PrimitiveTypeId getPrimitiveTypeId(@NonNull String name) {
		return primitiveTypes.getId(name);
	}

    /**
     * Return the propertyId for an EStructuralFeature.
     */
	public static @NonNull PropertyId getPropertyId(@NonNull EStructuralFeature eFeature) {
		String name = eFeature.getName();
		assert name != null;
		EClass parentClass = eFeature.getEContainingClass();
		assert parentClass != null;
		TypeId typeId = getTypeId(parentClass);
		return typeId.getPropertyId(name);
	}

	/**
	 * Return the URI-less unnested package typeId.
	 */
    public static @NonNull RootPackageId getRootPackageId(@NonNull String name) {
    	if (DomainConstants.METAMODEL_NAME.equals(name)) {
    		return METAMODEL;
    	}
		WeakReference<RootPackageId> ref = roots.get(name);
		if (ref != null) {
			RootPackageId oldTypeId = ref.get();
			if (oldTypeId != null) {
				return oldTypeId;
			}
		}
		synchronized (roots) {
			ref = roots.get(name);
			if (ref != null) {
				RootPackageId oldTypeId = ref.get();
				if (oldTypeId != null) {
					return oldTypeId;
				}
			}
			RootPackageId newTypeId = new RootPackageIdImpl(PRIVATE_INSTANCE, name);
			roots.put(name, new WeakReference<RootPackageId>(newTypeId));
			return newTypeId;
		}
    }

	public static @NonNull TemplateParameterId getTemplateParameterId(int index) {
		if (index >= templateParameters.size()) {
			synchronized (templateParameters) {
				while (index >= templateParameters.size()) {
					templateParameters.add(new TemplateParameterIdImpl(PRIVATE_INSTANCE, templateParameters.size()));
				}
			}
		}
		TemplateParameterId templateParameterId = templateParameters.get(index);
		assert templateParameterId != null;
		return templateParameterId;
    }

	/**
	 * Return the named tuplePartId with the defined name and type.
	 */
    public static @NonNull TuplePartId getTuplePartId(int index, @NonNull String name, @NonNull TypeId typeId) {
		WeakHashMapOfListOfWeakReference4<Integer, Integer, String, TypeId, TuplePartIdImpl> tupleParts2 = tupleParts;
		if (tupleParts2 == null) {
    		synchronized (IdManager.class) {
    			tupleParts2 = tupleParts;
    	    	if (tupleParts2 == null) {
    	    		tupleParts = tupleParts2 = new WeakHashMapOfListOfWeakReference4<Integer, Integer, String, TypeId, TuplePartIdImpl>()
    				{
    	    			@Override
    	    			protected @NonNull TuplePartIdImpl newId(@NonNull Integer hashCode, @NonNull Integer index, @NonNull String name, @NonNull TypeId typeId) {
    	    			   	return new TuplePartIdImpl(PRIVATE_INSTANCE, hashCode, index, name, typeId);
    	    			}		
					};
	    	   }
    		}
    	}
		Integer hashCode = name.hashCode() + 7 * typeId.hashCode() + 989 * index;
		return tupleParts2.getId(hashCode, index, name, typeId);
	}

	/**
	 * Return the named tuple typeId with the defined parts (which need not be alphabetically ordered).
	 */
	public static @NonNull TupleTypeId getTupleTypeId(@NonNull String name, @NonNull Collection<? extends TuplePartId> parts) {
		TuplePartId[] orderedParts = new TuplePartId[parts.size()];
		int i = 0;
		for (TuplePartId part : parts) {
			orderedParts[i++] = part;
		}
		Arrays.sort(orderedParts);
		return getOrderedTupleTypeId(name, orderedParts);
	}

	public static @NonNull TupleTypeId getTupleTypeId(@NonNull String name, @NonNull TuplePartId... parts) {
		TuplePartId[] orderedParts = new TuplePartId[parts.length];
		int i = 0;
		for (TuplePartId part : parts) {
			orderedParts[i++] = part;
		}
		Arrays.sort(orderedParts);
		return getOrderedTupleTypeId(name, orderedParts);
	}

    /**
     * Return the typeId for an EClassifier.
     */
	public static @NonNull TypeId getTypeId(@NonNull EClassifier eClassifier) {
		String name = eClassifier.getName();
		assert name != null;
		EPackage parentPackage = eClassifier.getEPackage();
		assert parentPackage != null;
		List<ETypeParameter> eTypeParameters = eClassifier.getETypeParameters();
		assert eTypeParameters != null;
		PackageId packageId = getPackageId(parentPackage);
		int eTypeParameterCount = eTypeParameters.size();
		if (eClassifier instanceof EEnum) {
			return packageId.getEnumerationId(name);
		}
		else if (eClassifier instanceof EDataType) {
			return packageId.getDataTypeId(name, eTypeParameterCount);
		}
		else {
			return packageId.getClassId(name, eTypeParameterCount);
		}
	}

    /**
     * Return the typeId for aType.
      */
	public static @NonNull UnspecifiedIdImpl getUnspecifiedTypeId(@NonNull DomainType aType) {
		UnspecifiedIdImpl newId = new UnspecifiedIdImpl(PRIVATE_INSTANCE, aType);
//		System.out.println("Create " + newId.getClass().getSimpleName() + " " + newId + " => @" + Integer.toHexString(newId.hashCode()));
		return newId;
	}
	
	private IdManager() {}
}