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
package org.eclipse.ocl.pivot.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.IdManager;
import org.eclipse.ocl.domain.ids.TemplateParameterId;
import org.eclipse.ocl.domain.ids.TuplePartId;
import org.eclipse.ocl.domain.ids.TupleTypeId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.types.IdResolver;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.domain.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.impl.TuplePartImpl;
import org.eclipse.ocl.pivot.internal.impl.TupleTypeImpl;
import org.eclipse.ocl.pivot.internal.impl.TypedElementImpl;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * TupleTypeManager encapsulates the knowledge about known tuple types.
 */
public class TupleTypeManager
{
	protected static class TupleIdResolver extends PivotIdResolver
	{
		private final TemplateParameterReferencesVisitor referencesVisitor;

		private TupleIdResolver(@NonNull MetaModelManager metaModelManager,
				TemplateParameterReferencesVisitor referencesVisitor) {
			super(metaModelManager);
			this.referencesVisitor = referencesVisitor;
		}

		@Override
		public @NonNull Element visitTemplateParameterId(@NonNull TemplateParameterId id) {
			int index = id.getIndex();
			TemplateParameter templateParameter = referencesVisitor.templateParameters.get(index);
			if (templateParameter != null) {
				return templateParameter;
			}
			return super.visitTemplateParameterId(id);
		}
	}

	/**
	 * TuplePart provides a convenient descriptor for a tuple part complying with the full EMF model protocols.
	 */
	public static class TuplePart extends TypedElementImpl
	{
		protected final @NonNull TuplePartId partId;
		
		public TuplePart(@NonNull TuplePartId partId) {
			this.partId = partId;
			setName(partId.getName());
		}

		@Override
		public @NonNull TypeId getTypeId() {
			return partId.getTypeId();
		}

		@Override
		public String toString() {
			return String.valueOf(name) + " : " + String.valueOf(type);
		}
	}
	
	/**
	 * The TemplateParameterReferencesVisitor remembers the formal TemplateParameter for re-uyse during Tuple instantiation.
	 */
	protected static class TemplateParameterReferencesVisitor extends TemplateParameterSubstitutionVisitor
	{
		protected final @NonNull Map<Integer, TemplateParameter> templateParameters = new HashMap<Integer, TemplateParameter>();
		
		public TemplateParameterReferencesVisitor(@NonNull MetaModelManager metaModelManager, Collection<? extends Type> partValues) {
			super(metaModelManager, null, null);
			for (Type partValue : partValues) {
				analyzeType(partValue, partValue);
			}
		}

		@Override
		public @NonNull Type put(@NonNull TemplateParameter formalTemplateParameter, @NonNull Type actualType) {
			templateParameters.put(formalTemplateParameter.getTemplateParameterId().getIndex(), formalTemplateParameter);
			return super.put(formalTemplateParameter, actualType);
		}
	}

	protected final @NonNull CompleteEnvironmentInternal completeEnvironment;
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull org.eclipse.ocl.pivot.Class oclTupleType;
	
	/**
	 * Map from the tuple typeId to the tuple type. 
	 */
	private @Nullable Map<TupleTypeId, TupleType> tupleid2tuple = null;
	
	public TupleTypeManager(@NonNull CompleteEnvironmentInternal allCompleteClasses) {
		this.completeEnvironment = allCompleteClasses;
		this.metaModelManager = allCompleteClasses.getMetaModelManager();
		this.oclTupleType = metaModelManager.getStandardLibrary().getOclTupleType();
	}

	public void dispose() {
		tupleid2tuple = null;
	}

    public @Nullable Type getCommonType(@NonNull TupleType leftType, @NonNull TemplateParameterSubstitutions leftSubstitutions,
    		@NonNull TupleType rightType, @NonNull TemplateParameterSubstitutions rightSubstitutions) {
		List<Property> leftProperties = leftType.getOwnedProperties();
		List<Property> rightProperties = rightType.getOwnedProperties();
		int iSize = leftProperties.size();
		if (iSize != rightProperties.size()) {
			return null;
		}
		List<TuplePartId> commonPartIds = new ArrayList<TuplePartId>(iSize);
		for (int i = 0; i < iSize; i++) {
			Property leftProperty = leftProperties.get(i);
			if (leftProperty == null) {
				return null;				// Never happens
			}
			String name = leftProperty.getName();
			if (name == null) {
				return null;				// Never happens
			}
			Property rightProperty = DomainUtil.getNamedElement(rightProperties, name);
			if (rightProperty == null) {
				return null;				// Happens for inconsistent tuples
			}
			Type leftPropertyType = leftProperty.getType();
			if (leftPropertyType == null) {
				return null;				// Never happens
			}
			Type rightPropertyType = rightProperty.getType();
			if (rightPropertyType == null) {
				return null;				// Never happens
			}
			Type commonType = metaModelManager.getCommonType(leftPropertyType, leftSubstitutions, rightPropertyType, rightSubstitutions);
			TuplePartId commonPartId = IdManager.getTuplePartId(i, name, commonType.getTypeId());
			commonPartIds.add(commonPartId);
		}
		TupleTypeId commonTupleTypeId = IdManager.getTupleTypeId(TypeId.TUPLE_NAME, commonPartIds);
		return getTupleType(metaModelManager.getIdResolver(), commonTupleTypeId);
	}

	public @NonNull TupleType getTupleType(@NonNull IdResolver idResolver, @NonNull TupleTypeId tupleTypeId) {
		Map<TupleTypeId, TupleType> tupleid2tuple2 = tupleid2tuple;
		if (tupleid2tuple2 == null) {
			synchronized (this) {
				tupleid2tuple2 = tupleid2tuple;
				if (tupleid2tuple2 == null) {
					tupleid2tuple2 = tupleid2tuple = new HashMap<TupleTypeId, TupleType>();
				}
			}
		}
		TupleType tupleType = tupleid2tuple2.get(tupleTypeId);
		if (tupleType == null) {
			synchronized (tupleid2tuple2) {
				tupleType = tupleid2tuple2.get(tupleTypeId);
				if (tupleType == null) {
					tupleType = new TupleTypeImpl(tupleTypeId);
					TuplePartId[] partIds = tupleTypeId.getPartIds();
					List<Property> ownedAttributes = tupleType.getOwnedProperties();
					for (TuplePartId partId : partIds) {
						Type partType = idResolver.getType(partId.getTypeId(), tupleType);
						Type partType2 = metaModelManager.getType(partType);
						ownedAttributes.add(new TuplePartImpl(partId, partType2));
					}
					tupleType.getSuperClasses().add(oclTupleType);
					tupleid2tuple2.put(tupleTypeId, tupleType);
					completeEnvironment.addOrphanClass(tupleType);
				}
			}
		}
		return tupleType;
	}

	public @NonNull TupleType getTupleType(@NonNull String tupleName, @NonNull Collection<? extends TypedElement> parts,
			@Nullable TemplateParameterSubstitutions usageBindings) {
		Map<String, Type> partMap = new HashMap<String, Type>();
		for (TypedElement part : parts) {
			Type type1 = part.getType();
			if (type1 != null) {
				Type type2 = metaModelManager.getType(type1);
				Type type3 = completeEnvironment.getSpecializedType(type2, usageBindings);
				partMap.put(part.getName(), type3);
			}
		}
		return getTupleType(tupleName, partMap);
	}
	
	/**
	 * Return the named tuple typeId with the defined parts (which need not be alphabetically ordered).
	 */
	public @NonNull TupleType getTupleType(@NonNull String tupleName, @NonNull Map<String, ? extends Type> parts) {
		//
		//	Find the outgoing template parameter references
		// FIXME this should be more readily and reliably computed in the caller
		@SuppressWarnings("null")@NonNull Collection<? extends Type> partValues = parts.values();
		final TemplateParameterReferencesVisitor referencesVisitor = new TemplateParameterReferencesVisitor(metaModelManager, partValues);	// FIXME this isn't realistically extensible
		//
		//	Create the tuple part ids
		//
		int partsCount = parts.size();
		TuplePartId[] newPartIds = new TuplePartId[partsCount];
		List<String> sortedPartNames = new ArrayList<String>(parts.keySet());
		Collections.sort(sortedPartNames);
		for (int i = 0; i < partsCount; i++) {
			@SuppressWarnings("null")@NonNull String partName = sortedPartNames.get(i);
			Type partType = parts.get(partName);
			if (partType != null) {
				TypeId partTypeId = partType.getTypeId();
				TuplePartId tuplePartId = IdManager.getTuplePartId(i, partName, partTypeId);
				newPartIds[i] = tuplePartId;
			}
		}
		//
		//	Create the tuple type id (and then specialize it)
		//
		TupleTypeId tupleTypeId = IdManager.getOrderedTupleTypeId(tupleName, newPartIds);
		PivotIdResolver pivotIdResolver = new TupleIdResolver(metaModelManager, referencesVisitor);
		//
		//	Finally create the (specialize) tuple type
		//
		TupleType tupleType = getTupleType(pivotIdResolver /*metaModelManager.getIdResolver()*/, tupleTypeId);
		return tupleType;
	}

	public @NonNull TupleType getTupleType(@NonNull TupleType type, @Nullable TemplateParameterSubstitutions usageBindings) {	// FIXME Remove duplication, unify type/multiplicity
//		return getTupleType(type.getName(), type.getOwnedAttribute(), usageBindings);
		TupleType specializedTupleType = type;
		Map<String, Type> resolutions =  null;
		List<Property> parts = specializedTupleType.getOwnedProperties();
		for (Property part : parts) {
			if (part != null) {
				Type propertyType = PivotUtil.getType(part);
				if (propertyType != null) {
					Type resolvedPropertyType = completeEnvironment.getSpecializedType(propertyType, usageBindings);
					if (resolvedPropertyType != propertyType) {
						if (resolutions == null) {
							resolutions = new HashMap<String, Type>();
						}
						resolutions.put(DomainUtil.getSafeName(part), resolvedPropertyType);
					}
				}
			}
		}
		if (resolutions != null) {
			List<TuplePartId> partIds = new ArrayList<TuplePartId>(parts.size());
			for (int i = 0; i < parts.size(); i++) {
				@SuppressWarnings("null") @NonNull Property part = parts.get(i);
				String partName = DomainUtil.getSafeName(part);
				Type resolvedPropertyType = resolutions.get(partName);
				TypeId partTypeId = resolvedPropertyType != null ? resolvedPropertyType.getTypeId() : part.getTypeId();
				TuplePartId tuplePartId = IdManager.getTuplePartId(i, partName, partTypeId);
				partIds.add(tuplePartId);
			}
			TupleTypeId tupleTypeId = IdManager.getTupleTypeId(DomainUtil.nonNullModel(type.getName()), partIds);
			specializedTupleType = getTupleType(metaModelManager.getIdResolver(), tupleTypeId);
			return specializedTupleType;
		}
		else {
			return getTupleType(DomainUtil.getSafeName(type), type.getOwnedProperties(), usageBindings);
		}
	}
}