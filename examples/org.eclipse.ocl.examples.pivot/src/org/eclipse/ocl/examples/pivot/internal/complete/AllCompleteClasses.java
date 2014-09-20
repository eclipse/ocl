/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.internal.complete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.library.executor.CollectionTypeParameters;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.CompleteModel;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.OrphanCompletePackage;
import org.eclipse.ocl.examples.pivot.PrimitiveCompletePackage;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.CompleteInheritance;
import org.eclipse.ocl.examples.pivot.manager.LambdaTypeManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.TemplateParameterSubstitutions;
import org.eclipse.ocl.examples.pivot.manager.TupleTypeManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class AllCompleteClasses
{
	protected final @NonNull Map<DomainClass, CompleteClass.Internal> class2completeClass = new WeakHashMap<DomainClass, CompleteClass.Internal>();
	protected final @NonNull CompleteModel.Internal completeModel;
	
	/**
	 * The known lambda types.
	 */
	private LambdaTypeManager lambdaManager = null;			// Lazily created
	
	/**
	 * The known tuple types.
	 */
	private @Nullable TupleTypeManager tupleManager = null;			// Lazily created

	public AllCompleteClasses(@NonNull CompleteModel.Internal completeModel) {
		this.completeModel = completeModel;
	}
	
	public void addOrphanClass(@NonNull org.eclipse.ocl.examples.pivot.Class pivotElement) {
		if (pivotElement.getUnspecializedElement() != null) {
			assert pivotElement.getUnspecializedElement().getUnspecializedElement() == null;
		}
		else {
			assert (pivotElement instanceof LambdaType)
				|| (pivotElement instanceof TupleType);
		}
		pivotElement.setOwningPackage(completeModel.getMetaModelManager().getOrphanage());
	}

	public void didAddClass(@NonNull DomainClass partialClass, @NonNull CompleteClass.Internal completeClass) {
//		assert partialClass.getUnspecializedElement() == null;
		CompleteClass oldCompleteClass = class2completeClass.put(partialClass, completeClass);
		assert (oldCompleteClass == null) ||(oldCompleteClass == completeClass);
	}
	
	public void didRemoveClass(@NonNull DomainClass pivotType) {
		class2completeClass.remove(pivotType);
	}

	public void dispose() {
		class2completeClass.clear();
		if (lambdaManager != null) {
			lambdaManager.dispose();
			lambdaManager = null;
		}
		if (tupleManager != null) {
			tupleManager.dispose();
			tupleManager = null;
		}
	}

	public @Nullable CollectionType findCollectionType(@NonNull CompleteClass.Internal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters) {
		return completeClass.findCollectionType(typeParameters);
	}

	public @NonNull CollectionType getCollectionType(@NonNull CompleteClass.Internal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters) {
		return completeClass.getCollectionType(typeParameters);
	}

	public @NonNull <T extends CollectionType> T getCollectionType(@NonNull T containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		assert containerType == PivotUtil.getUnspecializedTemplateableElement(containerType);
		TemplateSignature templateSignature = containerType.getOwnedTemplateSignature();
		if (templateSignature == null) {
			throw new IllegalArgumentException("Collection type must have a template signature");
		}
		List<TemplateParameter> templateParameters = templateSignature.getOwnedTemplateParameters();
		if (templateParameters.size() != 1) {
			throw new IllegalArgumentException("Collection type must have exactly one template parameter");
		}
		boolean isUnspecialized = elementType == templateParameters.get(0);
		if (isUnspecialized) {
			return containerType;	
		}
		@SuppressWarnings("unchecked")
		T specializedType = (T) getCollectionType(getCompleteClass(containerType), new CollectionTypeParameters<Type>(elementType, lower, upper));
		return specializedType;
	}
	
	public @NonNull CompleteClass.Internal getCompleteClass(@NonNull DomainType pivotType) {
		if (pivotType instanceof ElementExtension) {
			Stereotype stereotype = ((ElementExtension)pivotType).getStereotype();
			if (stereotype != null) {
				pivotType = stereotype;
			}
		}
		if (pivotType instanceof CompleteInheritance) {
			return ((CompleteInheritance)pivotType).getCompleteClass();
		}
		CompleteClass.Internal completeClass = class2completeClass.get(pivotType);
		if (completeClass != null) {
			return completeClass;
		}
		else if (pivotType instanceof PrimitiveType) {
			PrimitiveCompletePackage.Internal primitiveCompletePackage = completeModel.getPrimitiveCompletePackage();
			return primitiveCompletePackage.getCompleteClass((PrimitiveType)pivotType);
		}
		else if ((pivotType instanceof CollectionType) && (((CollectionType)pivotType).getUnspecializedElement() != null)) {
			OrphanCompletePackage.Internal orphanCompletePackage = completeModel.getOrphanCompletePackage();
			return orphanCompletePackage.getCompleteClass((CollectionType)pivotType);
		}
		else if (pivotType instanceof DomainClass) {
			DomainPackage pivotPackage = ((DomainClass)pivotType).getOwningPackage();
			if (pivotPackage == null) {
				throw new IllegalStateException("type has no package");
			}
			CompletePackage.Internal completePackage = completeModel.getCompletePackage(pivotPackage);
			return completePackage.getCompleteClass((DomainClass) pivotType);
		}
		else {
			throw new UnsupportedOperationException("TemplateType");
		}
	}

	public @NonNull LambdaTypeManager getLambdaManager() {
		LambdaTypeManager lambdaManager2 = lambdaManager;
		if (lambdaManager2 == null) {
			lambdaManager2 = lambdaManager = new LambdaTypeManager(this);
		}
		return lambdaManager2;
	}

	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType,
			@Nullable TemplateParameterSubstitutions bindings) {
		LambdaTypeManager lambdaManager = getLambdaManager();
		return lambdaManager.getLambdaType(typeName, contextType, parameterTypes, resultType, bindings);
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return completeModel.getMetaModelManager();
	}

	public @NonNull Type getSpecializedType(@NonNull Type type, @Nullable TemplateParameterSubstitutions substitutions) {
		if ((substitutions == null) || substitutions.isEmpty()) {
			return type;
		}
		TemplateParameter asTemplateParameter = type.isTemplateParameter();
		if (asTemplateParameter != null) {
			Type boundType = substitutions.get(asTemplateParameter);
			org.eclipse.ocl.examples.pivot.Class asClass = boundType != null ? boundType.isClass() : null;
			return asClass != null ? asClass : type;
		}
		else if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)type;
			CollectionType unspecializedType = PivotUtil.getUnspecializedTemplateableElement(collectionType);
			if (!substitutions.isEmpty()) {
				TemplateParameter templateParameter = unspecializedType.getOwnedTemplateSignature().getOwnedTemplateParameters().get(0);
				Type templateArgument = substitutions.get(templateParameter);
				if (templateArgument == null) {
					templateArgument = templateParameter;
				}
				if (templateArgument != null) {
					return getMetaModelManager().getCollectionType(unspecializedType, templateArgument, null, null);
				}
			}
			return collectionType;
		}
		else if (type instanceof TupleType) {
			return getTupleManager().getTupleType((TupleType) type, substitutions);
		}
		else if (type instanceof LambdaType) {
			LambdaType lambdaType = (LambdaType)type;
			String typeName = DomainUtil.nonNullModel(lambdaType.getName());
			Type contextType = DomainUtil.nonNullModel(lambdaType.getContextType());
			@NonNull List<Type> parameterType = lambdaType.getParameterType();
			Type resultType = DomainUtil.nonNullModel(lambdaType.getResultType());
			return getLambdaManager().getLambdaType(typeName, contextType, parameterType, resultType, substitutions);
		}
		else if (type instanceof org.eclipse.ocl.examples.pivot.Class) {
			//
			//	Get the bindings of the type.
			//
			org.eclipse.ocl.examples.pivot.Class unspecializedType = PivotUtil.getUnspecializedTemplateableElement((org.eclipse.ocl.examples.pivot.Class)type);
			//
			//	Prepare the template argument list, one template argument per template parameter.
			//
			TemplateSignature templateSignature = unspecializedType.getOwnedTemplateSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getOwnedTemplateParameters();
				List<Type> templateArguments = new ArrayList<Type>(templateParameters.size());
				for (TemplateParameter templateParameter : templateParameters) {
					Type templateArgument = substitutions.get(templateParameter);
					templateArguments.add(templateArgument != null ? templateArgument : templateParameter);
				}
				return getMetaModelManager().getLibraryType(unspecializedType, templateArguments);
			}
		}
		return type;
	}

	public @NonNull TupleTypeManager getTupleManager() {
		TupleTypeManager tupleManager2 = tupleManager;
		if (tupleManager2 == null) {
			tupleManager = tupleManager2 = new TupleTypeManager(this);
		}
		return tupleManager2;
	}

	public @NonNull TupleType getTupleType(@NonNull String typeName, @NonNull Collection<? extends DomainTypedElement> parts,
			@Nullable TemplateParameterSubstitutions bindings) {
		return getTupleManager().getTupleType(typeName, parts, bindings);
	}
}