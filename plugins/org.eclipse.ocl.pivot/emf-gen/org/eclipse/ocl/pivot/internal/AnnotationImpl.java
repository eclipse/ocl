/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import java.util.Map;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.AnnotationImpl#getOwnedContents <em>Owned Contents</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.AnnotationImpl#getOwnedDetails <em>Owned Details</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.AnnotationImpl#getReferences <em>References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnnotationImpl
		extends NamedElementImpl
		implements Annotation {

	/**
	 * The cached value of the '{@link #getOwnedContents() <em>Owned Contents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedContents()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> ownedContents;

	/**
	 * The cached value of the '{@link #getOwnedDetails() <em>Owned Details</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDetails()
	 * @generated
	 * @ordered
	 */
	protected EList<Detail> ownedDetails;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> references;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<Element> getOwnedContents()
	{
		if (ownedContents == null)
		{
			ownedContents = new EObjectContainmentEList<Element>(Element.class, this, PivotPackage.ANNOTATION__OWNED_CONTENTS);
		}
		return ownedContents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Detail> getOwnedDetails()
	{
		if (ownedDetails == null)
		{
			ownedDetails = new EObjectContainmentEList<Detail>(Detail.class, this, PivotPackage.ANNOTATION__OWNED_DETAILS);
		}
		return ownedDetails;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Element> getReferences()
	{
		if (references == null)
		{
			references = new EObjectResolvingEList<Element>(Element.class, this, PivotPackage.ANNOTATION__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateDetailNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateDetailNamesAreUnique:
		 *   let severity : Integer[1] = 'Annotation::DetailNamesAreUnique'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[1] = ownedDetails->isUnique(detail | detail.name)
		 *       in
		 *         'Annotation::DetailNamesAreUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_Annotation_c_c_DetailNamesAreUnique);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @NonNull /*@Caught*/ Object CAUGHT_status;
		    try {
		        @SuppressWarnings("null")
		        final @NonNull /*@Thrown*/ List<Detail> ownedDetails = this.getOwnedDetails();
		        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedDetails = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Detail, ownedDetails);
		        @NonNull /*@Thrown*/ SetValue.Accumulator accumulator = ValueUtil.createSetAccumulatorValue(PivotTables.ORD_CLSSid_Detail);
		        @Nullable Iterator<?> ITERATOR_detail = BOXED_ownedDetails.iterator();
		        /*@Thrown*/ boolean status;
		        while (true) {
		            if (!ITERATOR_detail.hasNext()) {
		                status = ValueUtil.TRUE_VALUE;
		                break;
		            }
		            @Nullable /*@NonInvalid*/ Detail detail = (Detail)ITERATOR_detail.next();
		            /**
		             * detail.name
		             */
		            if (detail == null) {
		                throw new InvalidValueException("Null source for \'NamedElement::name\'");
		            }
		            final @Nullable /*@Thrown*/ String name = detail.getName();
		            //
		            if (accumulator.includes(name) == ValueUtil.TRUE_VALUE) {
		                status = ValueUtil.FALSE_VALUE;			// Abort after second find
		                break;
		            }
		            else {
		                accumulator.add(name);
		            }
		        }
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_Annotation_c_c_DetailNamesAreUnique, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.ANNOTATION__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.ANNOTATION__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.ANNOTATION__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.ANNOTATION__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.ANNOTATION__OWNED_CONTENTS:
				return ((InternalEList<?>)getOwnedContents()).basicRemove(otherEnd, msgs);
			case PivotPackage.ANNOTATION__OWNED_DETAILS:
				return ((InternalEList<?>)getOwnedDetails()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case PivotPackage.ANNOTATION__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.ANNOTATION__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.ANNOTATION__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.ANNOTATION__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.ANNOTATION__NAME:
				return getName();
			case PivotPackage.ANNOTATION__OWNED_CONTENTS:
				return getOwnedContents();
			case PivotPackage.ANNOTATION__OWNED_DETAILS:
				return getOwnedDetails();
			case PivotPackage.ANNOTATION__REFERENCES:
				return getReferences();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case PivotPackage.ANNOTATION__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ANNOTATION__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.ANNOTATION__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ANNOTATION__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.ANNOTATION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ANNOTATION__OWNED_CONTENTS:
				getOwnedContents().clear();
				getOwnedContents().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.ANNOTATION__OWNED_DETAILS:
				getOwnedDetails().clear();
				getOwnedDetails().addAll((Collection<? extends Detail>)newValue);
				return;
			case PivotPackage.ANNOTATION__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends Element>)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.ANNOTATION__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.ANNOTATION__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.ANNOTATION__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.ANNOTATION__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.ANNOTATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ANNOTATION__OWNED_CONTENTS:
				getOwnedContents().clear();
				return;
			case PivotPackage.ANNOTATION__OWNED_DETAILS:
				getOwnedDetails().clear();
				return;
			case PivotPackage.ANNOTATION__REFERENCES:
				getReferences().clear();
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.ANNOTATION__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.ANNOTATION__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.ANNOTATION__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.ANNOTATION__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.ANNOTATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ANNOTATION__OWNED_CONTENTS:
				return ownedContents != null && !ownedContents.isEmpty();
			case PivotPackage.ANNOTATION__OWNED_DETAILS:
				return ownedDetails != null && !ownedDetails.isEmpty();
			case PivotPackage.ANNOTATION__REFERENCES:
				return references != null && !references.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case PivotPackage.ANNOTATION___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.ANNOTATION___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.ANNOTATION___MAY_HAVE_NULL_NAME:
				return mayHaveNullName();
			case PivotPackage.ANNOTATION___VALIDATE_DETAIL_NAMES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP:
				return validateDetailNamesAreUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitAnnotation(this);
	}
} //AnnotationImpl
