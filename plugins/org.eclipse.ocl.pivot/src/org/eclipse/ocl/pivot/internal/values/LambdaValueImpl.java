/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.values;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.LambdaLiteralExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.LambdaValue;
import org.eclipse.ocl.pivot.values.ValuesPackage;

/**
 * @generated NOT
 */
public class LambdaValueImpl extends ValueImpl implements LambdaValue
{	
	/**
	 * Return true if the non-containment feature values of thisValue are identical to those of thatValue,
	 * using map to detect equivalent referenced EObjects. NamedEklement::name is ignored since parameters and
	 * variables may be renamed without affecting equality.
	 */
	private static boolean checkEquality(Map<EObject, EObject> map, @NonNull EObject thisObject, @NonNull EObject thatObject) {
		EClass eClass = thisObject.eClass();
		assert thatObject.eClass() == eClass;
		for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
			if (eStructuralFeature.isDerived() || eStructuralFeature.isTransient() || eStructuralFeature.isVolatile()) {
				continue;
			}
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				if ((eAttribute == PivotPackage.Literals.NAMED_ELEMENT__NAME)
				 && ((thisObject instanceof Parameter) || (thisObject instanceof Variable))) {
					continue;
				}
				if (!eAttribute.isMany()) {
					Object thisValue = thisObject.eGet(eAttribute);
					Object thatValue = thatObject.eGet(eAttribute);
					if (!ValueUtil.oclEquals(thisValue, thatValue)) {
						return false;
					}
				}
				else {
					@SuppressWarnings("unchecked")List<Object> theseValues = (List<Object>) thisObject.eGet(eAttribute);
					@SuppressWarnings("unchecked")List<Object> thoseValues = (List<Object>) thatObject.eGet(eAttribute);
					if ((theseValues == null) || (thoseValues == null)) {
						return false;
					}
					int size = theseValues.size();
					if (size != thoseValues.size()) {
						return false;
					}
					else if (size == 0) {
					}
					else if (size == 1) {
						Object thisValue = theseValues.get(0);
						Object thatValue = thoseValues.get(0);
						if (!ValueUtil.oclEquals(thisValue, thatValue)) {
							return false;
						}
					}
					else if (eAttribute.isOrdered()) {
						for (Iterator<Object> thisIterator = theseValues.iterator(), thatIterator = thoseValues.iterator(); thisIterator.hasNext() && thatIterator.hasNext(); ) {
							Object thisValue = thisIterator.next();
							Object thatValue = thatIterator.next();
							if (!ValueUtil.oclEquals(thisValue, thatValue)) {
								return false;
							}
						}
					}
					else {
						// There are no significant unordered properties of OCLExpression elements
						// throw new UnsupportedOperationException();
					}
				}
			}
			else if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				if (eReference.isContainment() || eReference.isContainment()) {
					continue;
				}
				if (!eReference.isMany()) {
					EObject thisValue = (EObject) thisObject.eGet(eReference);
					EObject thatValue = (EObject) thatObject.eGet(eReference);
					EObject thisThatValue = map.get(thisValue);
					if ((thisValue != thatValue) && (thisThatValue != thatValue)) {
						return false;
					}
				}
				else {
					@SuppressWarnings("unchecked")List<Object> theseValues = (List<Object>) thisObject.eGet(eReference);
					@SuppressWarnings("unchecked")List<Object> thoseValues = (List<Object>) thatObject.eGet(eReference);
					if ((theseValues == null) || (thoseValues == null)) {
						return false;
					}
					int size = theseValues.size();
					if (size != thoseValues.size()) {
						return false;
					}
					else if (size == 0) {
					}
					else if (size == 1) {
						Object thisValue = theseValues.get(0);
						Object thatValue = thoseValues.get(0);
						EObject thisThatValue = map.get(thisValue);
						if ((thisValue != thatValue) && (thisThatValue != thatValue)) {
							return false;
						}
					}
					else if (eReference.isOrdered()) {
						for (Iterator<Object> thisIterator = theseValues.iterator(), thatIterator = thoseValues.iterator(); thisIterator.hasNext() && thatIterator.hasNext(); ) {
							Object thisValue = thisIterator.next();
							Object thatValue = thatIterator.next();
							EObject thisThatValue = map.get(thisValue);
							if ((thisValue != thatValue) && (thisThatValue != thatValue)) {
								return false;
							}
						}
					}
					else {
						// There are no significant unordered properties of OCLExpression elements
						// throw new UnsupportedOperationException();
					}
				}
			}
		}
		return true;
	}

	/**
	 * Return a hashCode based on the containment hierarchy.
	 */
	private static long computeContainmentHashCode(@NonNull EObject eObject) {
		EClass eClass = eObject.eClass();
		long hashCode = eClass.hashCode();
		for (EReference eReference : eClass.getEAllContainments()) {
			if (!eReference.isMany()) {
				EObject eChild = (EObject) eObject.eGet(eReference);
				if (eChild != null) {
					hashCode += 3 * computeContainmentHashCode(eChild);
				}
			}
			else {
				@SuppressWarnings("unchecked")List<EObject> eChildren = (List<EObject>) eObject.eGet(eReference);
				if (eChildren != null) {
					if (eReference.isOrdered()) {
						long childHashCode = 0;
						for (EObject eChild : eChildren) {
							childHashCode += 2 * childHashCode;
							if (eChild != null) {
								childHashCode += computeContainmentHashCode(eChild);
							}
						}
						hashCode += 3 * childHashCode;
					}
					else {
						for (EObject eChild : eChildren) {
							if (eChild != null) {
								hashCode += 3 * computeContainmentHashCode(eChild);
							}
						}
					}
				}
			}
		}
		return hashCode;
	}
	
	/**
	 * Build a 1:1 Map of EObjects for the containmebt hierarchy of thisObect/thatObject.
	 * Returning false with an indeterminate map, if there is no precise 1:1 EClass containment equivalence.
	 * Return true with a complete 1:1 map if there is precise 1:1 EClass containment equivalence.
	 */
	private static boolean computeContainmentEquality(@NonNull Map<EObject,EObject> map, @Nullable EObject thisObject, @Nullable EObject thatObject) {
		if (thisObject == null) {
			return thatObject == null;
		}
		else if (thatObject == null) {
			return false;
		}
		EClass thisEClass = thisObject.eClass();
		EClass thatEClass = thatObject.eClass();
		if (thisEClass != thatEClass) {
			return false;
		}
		map.put(thisObject,  thatObject);
		for (EReference eReference : thisEClass.getEAllContainments()) {
			if (!eReference.isMany()) {
				EObject thisChild = (EObject) thisObject.eGet(eReference);
				EObject thatChild = (EObject) thatObject.eGet(eReference);
				if (!computeContainmentEquality(map, thisChild, thatChild)) {
					return false;
				}
			}
			else {
				@SuppressWarnings("unchecked")List<EObject> theseChildren = (List<EObject>) thisObject.eGet(eReference);
				@SuppressWarnings("unchecked")List<EObject> thoseChildren = (List<EObject>) thatObject.eGet(eReference);
				if ((theseChildren != null) && (thoseChildren != null)) {
					int size = theseChildren.size();
					if (size != thoseChildren.size()) {
						return false;
					}
					else if (size == 0) {
					}
					else if (size == 1) {
						EObject thisChild = theseChildren.get(0);
						EObject thatChild = thoseChildren.get(0);
						if (!computeContainmentEquality(map, thisChild, thatChild)) {
							return false;
						}
					}
					else if (eReference.isOrdered()) {
						for (Iterator<EObject> thisIterator = theseChildren.iterator(), thatIterator = thoseChildren.iterator(); thisIterator.hasNext() && thatIterator.hasNext(); ) {
							EObject thisChild = thisIterator.next();
							EObject thatChild = thatIterator.next();
							if (!computeContainmentEquality(map, thisChild, thatChild)) {
								return false;
							}
						}
					}
					else {
						// There are no significant unordered properties of OCLExpression elements
						// testConstruct_LambdaEqualsIsOrdered confirms that only the following are not ordered
						// PivotPackage.Literals.ELEMENT__ANNOTATING_COMMENTS
						// PivotPackage.Literals.ELEMENT__OWNED_COMMENTS
						// PivotPackage.Literals.ELEMENT__OWNED_EXTENSIONS
						// These should not be used in LambdaLiteralExps
						// throw new UnsupportedOperationException();
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.LAMBDA_VALUE;
	}

	protected @NonNull TypeId typeId;
	protected @NonNull LambdaLiteralExp lambdaLiteralExp;
	private /*@LazyNonNull*/ Integer hashCode = null;
	
	public LambdaValueImpl(@NonNull LambdaLiteralExp lambdaLiteralExp) {
		this.typeId = lambdaLiteralExp.getTypeId();
		this.lambdaLiteralExp = lambdaLiteralExp;
	}

	@Override
	public @Nullable List<?> asEcoreObject(@NonNull IdResolver idResolver, @Nullable Class<?> instanceClass) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Object asObject() {
		return lambdaLiteralExp;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof LambdaValue)) {
			return false;
		}
		LambdaValue that = (LambdaValue)obj;
		int thisHash = this.hashCode();
		int thatHash = that.hashCode();
		if (thisHash != thatHash) {
			return false;
		}
		Map<EObject, EObject> map = new HashMap<EObject, EObject>();
		if (!computeContainmentEquality(map, this.lambdaLiteralExp, that.getLambdaLiteralExp())) {
			return false;
		}
		for (Map.Entry<EObject, EObject> entry : map.entrySet()) {
			@SuppressWarnings("null")@NonNull EObject thisObject = entry.getKey();
			@SuppressWarnings("null")@NonNull EObject thatObject = entry.getValue();
			if (!checkEquality(map, thisObject, thatObject)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public @Nullable LambdaLiteralExp getLambdaLiteralExp() {
		return lambdaLiteralExp;
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return typeId;
	}

	@Override
	public int hashCode() {
		if (hashCode == null) {
			synchronized (this) {
				if (hashCode == null) {
					hashCode = 0x33333333 + (int)computeContainmentHashCode(lambdaLiteralExp);
				}
			}
		}
		return hashCode;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		toString(s, 100);
		return s.toString();
	}

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append(lambdaLiteralExp.toString());
	}
}
