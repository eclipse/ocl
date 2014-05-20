/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainLambdaType;
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;

/**
 * A TemplateSpecialisation supports resolution of template parameter within an element referenced from an OCL expression.
 * For instance a PropertyCallExp.referredProperty references the unspecialised Property and consequently the type and owningType
 * of the referredProperty may have unresolved template parameters. These may be resolved by exploiting the bindings of
 * the ProperyCallExp.source.
 * <p>
 * Invocation should first invoke needsSpecialisation() to discover whether the cost of constructing a TemplateSpecialisation
 * can be bypassed. If specialisation is needed a TemplateSpecialisation should be constructed for the prevailing OCL Standard
 * Library, and known type equivalences installed by invoking installEquivalence() for each. getSpecialisation may then be used
 * to resolve the type.
 */
public class TemplateSpecialisation
{
	/**
	 * Return true if a referencedType needs specialisation to resolve a template parameter.
	 */
	public static boolean needsSpecialisation(@Nullable DomainType referencedType)
	{
		if (referencedType == null) {
			return true;
		}
		if (referencedType instanceof DomainTemplateParameter) {
			return true;
		}
		if (referencedType instanceof ParameterableElement) {
			TemplateParameter templateParameter = ((ParameterableElement)referencedType).getOwningTemplateParameter();
			if (templateParameter != null) {
				return true;
			}
		}
		if (referencedType instanceof DomainCollectionType) {
			DomainType elementType = ((DomainCollectionType)referencedType).getElementType();
			return needsSpecialisation(elementType);
		}
		if (referencedType instanceof DomainMetaclass) {
			DomainType elementType = ((DomainMetaclass)referencedType).getInstanceType();
			return needsSpecialisation(elementType);
		}
		if (referencedType instanceof DomainTupleType) {
			DomainTupleType tupleType = (DomainTupleType)referencedType;
			for (DomainProperty tuplePart : tupleType.getLocalProperties()) {
				DomainType tuplePartType = tuplePart.getType();
				if (needsSpecialisation(tuplePartType)) {
					return true;
				}
			}
			return false;
		}
		if (referencedType instanceof DomainLambdaType) {
			DomainLambdaType lambdaType = (DomainLambdaType)referencedType;
			DomainType contextType = lambdaType.getContextType();
			if (needsSpecialisation(contextType)) {
				return true;
			}
			DomainType resultType = lambdaType.getResultType();
			if (needsSpecialisation(resultType)) {
				return true;
			}
			for (DomainType parameterType : lambdaType.getParameterTypes()) {
				if (needsSpecialisation(parameterType)) {
					return true;
				}
			}
			return false;
		}
		if (referencedType instanceof org.eclipse.ocl.examples.pivot.Class) {
			TemplateSignature templateSignature = ((org.eclipse.ocl.examples.pivot.Class)referencedType).getOwnedTemplateSignature();
			if (templateSignature != null) {
				return true;
			}
		}
		return false;
	}

	protected final @NonNull DomainStandardLibrary standardLibrary;
	protected /*@LazyNonNull*/ Map<DomainTemplateParameter, DomainType> bindings = null;

	public TemplateSpecialisation(@NonNull DomainStandardLibrary standardLibrary) {
		this.standardLibrary = standardLibrary;
	}
	
	/**
	 * Return the specialisation of referencedType if distinct from referencedType.
	 * Returns null if specialisation not available or not distinct from referencedType.
	 */
	private @Nullable DomainType getResolution(@Nullable DomainType referencedType) {
		if (referencedType instanceof DomainTemplateParameter) {
			return bindings != null ? bindings.get(referencedType) : null;
		}
		if (referencedType instanceof ParameterableElement) {
			DomainTemplateParameter templateParameter = ((ParameterableElement)referencedType).getOwningTemplateParameter();
			if (templateParameter != null) {
				return bindings != null ? bindings.get(templateParameter) : null;
			}
		}
		if (referencedType instanceof DomainCollectionType) {
			DomainCollectionType collectionType = (DomainCollectionType)referencedType;
			DomainType elementType = getResolution(collectionType.getElementType());
			if (elementType == null) {
				elementType = standardLibrary.getOclAnyType();
			}
			DomainType containerType = DomainUtil.nonNullState(collectionType.getContainerType());
			return standardLibrary.getCollectionType(containerType, elementType, collectionType.getLowerValue(), collectionType.getUpperValue());
		}
		if (referencedType instanceof DomainMetaclass) {
			DomainMetaclass metaclass = (DomainMetaclass)referencedType;
			DomainType instanceType = getResolution(metaclass.getInstanceType());
			if (instanceType == null) {
				instanceType = standardLibrary.getOclAnyType();
			}
			return standardLibrary.getMetaclass(instanceType);
		}
		if (referencedType instanceof DomainTupleType) {
//			DomainTupleType tupleType = (DomainTupleType)referencedType;
			throw new UnsupportedOperationException();
		}
		if (referencedType instanceof DomainLambdaType) {
//			DomainLambdaType lambdaType = (DomainLambdaType)referencedType;
			throw new UnsupportedOperationException();
		}
		return null;
	}

	public DomainType getSpecialisation(@NonNull DomainType referredType) {
		DomainType specialisation = getResolution(referredType);
		return specialisation != null ? specialisation : referredType;
	}
	
	public void installEquivalence(@Nullable DomainType resolvedType, @Nullable DomainType referencedType) {
		if (resolvedType == null) {
			return;
		}
		if (referencedType == null) {
			return;
		}
		if (referencedType instanceof DomainMetaclass) {
			referencedType = DomainUtil.nonNullState(((DomainMetaclass)referencedType).getInstanceType());			// FIXME must be a more regular way
		}
		if (referencedType instanceof DomainTemplateParameter) {
			DomainTemplateParameter templateParameter = (DomainTemplateParameter) referencedType;
			if (bindings == null) {
				bindings = new HashMap<DomainTemplateParameter, DomainType>();
			}
			if (bindings.put(templateParameter, resolvedType) != null) {
				bindings.put(templateParameter, null);
			}
			return;
		}
		if (referencedType instanceof ParameterableElement) {
			DomainTemplateParameter templateParameter = ((ParameterableElement)referencedType).getOwningTemplateParameter();
			if (templateParameter != null) {
				if (bindings == null) {
					bindings = new HashMap<DomainTemplateParameter, DomainType>();
				}
				if (bindings.put(templateParameter, resolvedType) != null) {
					bindings.put(templateParameter, null);
				}
				return;
			}
		}
		if (referencedType instanceof DomainCollectionType) {
			if (resolvedType instanceof DomainCollectionType) {
				DomainType resolvedElementType = ((DomainCollectionType)resolvedType).getElementType();
				DomainType referencedElementType = ((DomainCollectionType)referencedType).getElementType();
				installEquivalence(resolvedElementType, referencedElementType);
			}
			return;
		}
		if (referencedType instanceof DomainTupleType) {
			if (resolvedType instanceof DomainTupleType) {
				DomainTupleType referencedTupleType = (DomainTupleType)referencedType;
				DomainTupleType resolvedTupleType = (DomainTupleType)resolvedType;
				Iterable<? extends DomainProperty> referencedTupleParts = referencedTupleType.getLocalProperties();
				for (DomainProperty resolvedTuplePart : resolvedTupleType.getLocalProperties()) {
					DomainProperty referencedTuplePart = DomainUtil.getNamedElement(referencedTupleParts, resolvedTuplePart.getName());
					if (referencedTuplePart != null) {
						DomainType resolvedTuplePartType = resolvedTuplePart.getType();
						DomainType referencedTuplePartType = referencedTuplePart.getType();
						installEquivalence(resolvedTuplePartType, referencedTuplePartType);
					}
				}
			}
			return;
		}
		if (referencedType instanceof DomainLambdaType) {
			if (resolvedType instanceof DomainLambdaType) {
				DomainLambdaType referencedLambdaType = (DomainLambdaType)referencedType;
				DomainLambdaType resolvedLambdaType = (DomainLambdaType)resolvedType;
				installEquivalence(resolvedLambdaType.getContextType(), referencedLambdaType.getContextType());
				installEquivalence(resolvedLambdaType.getResultType(), referencedLambdaType.getResultType());
				List<? extends DomainType> resolvedParameterTypes = resolvedLambdaType.getParameterTypes();
				List<? extends DomainType> referencedParameterTypes = referencedLambdaType.getParameterTypes();
				for (int i = 0; i < Math.min(resolvedParameterTypes.size(), referencedParameterTypes.size()); i++) {
					DomainType resolvedParameterType = resolvedParameterTypes.get(i);
					DomainType referencedParameterType = referencedParameterTypes.get(i);
					installEquivalence(resolvedParameterType, referencedParameterType);
				}
			}
			return;
		}
		return;
	}
}