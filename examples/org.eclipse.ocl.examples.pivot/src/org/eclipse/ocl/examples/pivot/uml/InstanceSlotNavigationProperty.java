/*
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink (CEA LIST) - initial API and implementation
 */
package org.eclipse.ocl.examples.pivot.uml;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * An instance of InstanceSlotNavigationProperty supports evaluation of
 * a property call that navigates a relationship to a UML InstanceSpecification slot.
 */
public class InstanceSlotNavigationProperty extends AbstractProperty
{
	protected final @NonNull org.eclipse.uml2.uml.Property property;
	protected final @Nullable CollectionTypeId collectionTypeId;				// Non null for a Collection value
	
	public InstanceSlotNavigationProperty(@NonNull org.eclipse.uml2.uml.Property property, @Nullable CollectionTypeId collectionTypeId) {
		this.property = property;
		this.collectionTypeId = collectionTypeId;
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		if (sourceValue != null) {
			InstanceSpecification instanceSpecification = (InstanceSpecification)sourceValue; 
			for (Slot slot : instanceSpecification.getSlots()) {
				if (slot.getDefiningFeature() == property) {
					List<ValueSpecification> values = slot.getValues();
					CollectionTypeId collectionTypeId2 = collectionTypeId;
					int size = values.size();
					if (collectionTypeId2 != null) {
						List<Object> unboxedValues = new ArrayList<Object>(size);
						for (ValueSpecification value : values) {
							unboxedValues.add(valueOf(value));
						}
						IdResolver idResolver = evaluator.getIdResolver();
						return idResolver.createCollectionOfAll(collectionTypeId2, unboxedValues);
					}
					else if (size >= 1) {
						ValueSpecification valueSpecification = values.get(0);
						if (valueSpecification instanceof OpaqueExpression) {
							try {
								MetaModelManager metaModelManager = ((EvaluationVisitorImpl)evaluator).getMetaModelManager();
								ExpressionInOCL specification = metaModelManager.getPivotOf(ExpressionInOCL.class, valueSpecification);
								if (specification == null) {
									throw new InvalidValueException("Missing spec for " + specification);
								}
								ExpressionInOCL query = metaModelManager.getQueryOrThrow(specification);
								Object umlValue = evaluator.evaluate(query);
								return metaModelManager.getIdResolver().boxedValueOf(umlValue);
							} catch (ParserException e) {
								throw new InvalidValueException(e, "Parse fail for " + valueSpecification);
							}
						}
						else {
							return valueOf(valueSpecification);
						}
					}
					else {
						throw new InvalidValueException("no ValueSpecification in Slot");
					}
				}
			}
		}
		return null;
	}

	private @Nullable Object valueOf(@Nullable ValueSpecification valueSpecification) {
		if (valueSpecification == null) {
			throw new InvalidValueException("null ValueSpecification in Slot");
		}
		if (valueSpecification instanceof LiteralBoolean) {
			return ((LiteralBoolean)valueSpecification).booleanValue();
		}
		if (valueSpecification instanceof LiteralInteger) {
			return ValuesUtil.integerValueOf(((LiteralInteger)valueSpecification).getValue());
		}
		if (valueSpecification instanceof LiteralNull) {
			return null;
		}
		if (valueSpecification instanceof LiteralReal) {
			return ValuesUtil.realValueOf(((LiteralReal)valueSpecification).getValue());
		}
		if (valueSpecification instanceof LiteralString) {
			return ((LiteralString)valueSpecification).getValue();
		}
		if (valueSpecification instanceof LiteralUnlimitedNatural) {
			int unlimitedValue = ((LiteralUnlimitedNatural)valueSpecification).unlimitedValue();
			return unlimitedValue < 0 ? ValuesUtil.UNLIMITED_VALUE : ValuesUtil.integerValueOf(unlimitedValue);
		}
		if (valueSpecification instanceof InstanceValue) {
			return ((InstanceValue)valueSpecification).getInstance();
		}
		throw new UnsupportedOperationException(getClass().getSimpleName() + ".valueOf " + valueSpecification.eClass().getName());
	}
}