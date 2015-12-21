/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.evaluation.tx;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractObjectManager;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformer;
import org.eclipse.ocl.pivot.evaluation.tx.InvocationManager;
import org.eclipse.ocl.pivot.evaluation.tx.SlotState;
import org.eclipse.ocl.pivot.internal.evaluation.tx.AbstractTransformerInternal.BasicSlotState;
import org.eclipse.ocl.pivot.internal.evaluation.tx.AbstractTransformerInternal.ManyToManySlotState;
import org.eclipse.ocl.pivot.internal.evaluation.tx.AbstractTransformerInternal.OneToManyAggregatorSlotState;
import org.eclipse.ocl.pivot.internal.evaluation.tx.AbstractTransformerInternal.OneToManyElementSlotState;
import org.eclipse.ocl.pivot.internal.evaluation.tx.AbstractTransformerInternal.OneToOneSlotState;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;

/**
 * @since 1.1
 */
public class LazyObjectManager extends AbstractObjectManager
{
	protected final boolean isIncremental;
	protected final boolean debugTracing = AbstractTransformer.INVOCATIONS.isActive();
	
	/**
	 * This unpleasant Map of Maps is a pathfinder before embarking on slotted objects that merge user and overhead
	 * in a single object. The first map is then a null lookup and the nested map is an index within the object. 
	 */
	private Map<EObject, Map<EStructuralFeature, SlotState>> object2feature2slotState = new HashMap<EObject, Map<EStructuralFeature, SlotState>>();
	
	public LazyObjectManager(@NonNull InvocationManager invocationManager, boolean isIncremental) {
		super(invocationManager);
		this.isIncremental = isIncremental;
	}

	@Override
	public synchronized void assigned(@NonNull EObject eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue) {
		assert eFeature != null;
		if (debugTracing) {
			AbstractTransformer.INVOCATIONS.println("assigned " + eFeature.getEContainingClass().getName() + "::" + eFeature.getName() + " for " + eObject + " = " + ecoreValue);
		}
		Map<EStructuralFeature, SlotState> objectState = getObjectState(eObject);
		SlotState slotState = objectState.get(eFeature);
		if (slotState != null) {
			slotState.assigned(this, eObject, eFeature, ecoreValue);		
		}
		else {
			if (eFeature instanceof EAttribute) {
				slotState = new BasicSlotState(eObject, eFeature, ecoreValue);
			}
			else {
				EReference eReference = (EReference)eFeature;
				EReference eOppositeReference = eReference.getEOpposite();
				if (eOppositeReference != null) {
//					if (ecoreValue != null) {
//						Map<EStructuralFeature, SlotState> oppositeObjectState = getObjectState((EObject) ecoreValue);
//						SlotState oppositeSlotState = oppositeObjectState.get(eOppositeReference);
//					}
					if (eReference.isMany()) {
						assert ecoreValue != null;
						if (eOppositeReference.isMany()) {
							slotState = AbstractTransformerInternal.ManyToManySlotState.create(this, eObject, eReference, eOppositeReference);
						}
						else {
							slotState = AbstractTransformerInternal.OneToManyAggregatorSlotState.create(this, eObject, eReference, eOppositeReference, ecoreValue);
						}
					}
					else if (ecoreValue != null) {
						if (eOppositeReference.isMany()) {
							slotState = AbstractTransformerInternal.OneToManyElementSlotState.create(this, eObject, eReference, eOppositeReference, (EObject)ecoreValue);
						}
						else if (isIncremental) {
							slotState = AbstractTransformerInternal.OneToOneSlotState.create(this, eObject, eReference, eOppositeReference, (EObject)ecoreValue);
						}
					}
				}
				else if (eReference.isContainment()) {
					assert ecoreValue != null;
					eOppositeReference = OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER;
					assert eOppositeReference != null;
					if (eReference.isMany()) {
						slotState = AbstractTransformerInternal.OneToManyAggregatorSlotState.create(this, eObject, eReference, eOppositeReference, ecoreValue);
					}
					else {
						Map<EStructuralFeature, SlotState> oppositeObjectState = getObjectState((EObject) ecoreValue);
						slotState = oppositeObjectState.get(eOppositeReference);
						if (slotState != null) {
							slotState.assigned(this, (EObject) ecoreValue, eOppositeReference, eObject);		
						}
						else {
							slotState = AbstractTransformerInternal.OneToOneSlotState.create(this, eObject, eReference, eOppositeReference, (EObject)ecoreValue);
						}
					}
				}
//				else if (eReference == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
//					slotState = OneToOneSlotState.create(this, eObject, eReference, eOppositeReference, (EObject)ecoreValue);
//				}
				else {						// Unidirectional non-containment EReference
					slotState = new BasicSlotState(eObject, eFeature, ecoreValue);
				}
			}
			objectState.put(eFeature, slotState);
		}
	}

	public @NonNull Map<EStructuralFeature, SlotState> getObjectState(@NonNull EObject eObject) {
		Map<EStructuralFeature, SlotState> feature2state = object2feature2slotState.get(eObject);
		if (feature2state == null) {
			feature2state = new HashMap<EStructuralFeature, SlotState>();
			object2feature2slotState.put(eObject, feature2state);
		}
		return feature2state;
	}

	public synchronized @NonNull SlotState getSlotState(@NonNull EObject eObject, @NonNull EStructuralFeature eFeature) {
		assert eFeature != null;
		Map<EStructuralFeature, SlotState> objectState = getObjectState(eObject);
		SlotState slotState = objectState.get(eFeature);
		if (slotState == null) {
			if (eFeature instanceof EAttribute) {
				slotState = new BasicSlotState(eObject, eFeature);
			}
			else {
				EReference eReference = (EReference)eFeature;
				EReference eOppositeReference = eReference.getEOpposite();			// FIXME there is always a Pivot opposite
				if (eOppositeReference != null) {
					if (eReference.isMany()) {
						if (eOppositeReference.isMany()) {
							slotState = new ManyToManySlotState(eObject, eReference);
						}
						else {
							slotState = new OneToManyAggregatorSlotState(eObject, eReference);
						}
					}
					else {
						if (eOppositeReference.isMany()) {
							slotState = new OneToManyElementSlotState(eObject, eReference);
						}
						else {
							slotState = new OneToOneSlotState(eObject, eReference);
						}
					}
				}
				else if (eReference.isContainment()) {
					if (eReference.isMany()) {
						slotState = new OneToManyAggregatorSlotState(eObject, eReference);
					}
					else {
						slotState = new OneToOneSlotState(eObject, eReference);
					}
				}
				else if (eReference == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
					slotState = new OneToManyElementSlotState(eObject, eReference); //FIXME may be many
				}
				else {						// Unidirectional non-containment EReference
					slotState = new BasicSlotState(eObject, eFeature);
				}
			}
			objectState.put(eFeature, slotState);
		}
		return slotState;
	}

	@Override
	public synchronized void getting(@NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature) {
		assert eFeature != null;
		if (debugTracing) {
			AbstractTransformer.INVOCATIONS.println("getting " + eFeature.getEContainingClass().getName() + "::" + eFeature.getName() + " for " + eObject);
		}
		SlotState slotState = getSlotState((EObject) eObject, eFeature);
		slotState.getting(this, (EObject) eObject, eFeature);
	}
}