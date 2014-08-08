/*******************************************************************************
 * Copyright (c) 2010, 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainConstraint;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.OCLValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeImpl#getExtendedBys <em>Extended Bys</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeImpl#getInstanceClassName <em>Instance Class Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeImpl#getOwnedInvariant <em>Owned Invariant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings({"null","cast"})
public abstract class TypeImpl
		extends PackageableElementImpl
		implements Type {

	/**
	 * The cached value of the '{@link #getExtendedBys() <em>Extended Bys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedBys()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeExtension> extendedBys;

	/**
	 * The default value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceClassName()
	 * @generated
	 * @ordered
	 */
	protected String instanceClassName = INSTANCE_CLASS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedInvariant() <em>Owned Invariant</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInvariant()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> ownedInvariant;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull List<Constraint> getOwnedInvariant()
	{
		if (ownedInvariant == null)
		{
			ownedInvariant = new EObjectContainmentEList<Constraint>(Constraint.class, this, PivotPackage.TYPE__OWNED_INVARIANT);
		}
		return ownedInvariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstanceClassName()
	{
		return instanceClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceClassName(String newInstanceClassName)
	{
		String oldInstanceClassName = instanceClassName;
		instanceClassName = newInstanceClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TYPE__INSTANCE_CLASS_NAME, oldInstanceClassName, instanceClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<TypeExtension> getExtendedBys()
	{
		if (extendedBys == null)
		{
			extendedBys = new EObjectWithInverseResolvingEList<TypeExtension>(TypeExtension.class, this, PivotPackage.TYPE__EXTENDED_BYS, PivotPackage.TYPE_EXTENSION__TYPE);
		}
		return extendedBys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.TYPE__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.TYPE__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.TYPE__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.TYPE__OWNING_TEMPLATE_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.TYPE__TEMPLATE_PARAMETER:
				if (templateParameter != null)
					msgs = ((InternalEObject)templateParameter).eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
				return basicSetTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.TYPE__EXTENDED_BYS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtendedBys()).basicAdd(otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
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
			case PivotPackage.TYPE__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE__OWNING_TEMPLATE_PARAMETER:
				return basicSetOwningTemplateParameter(null, msgs);
			case PivotPackage.TYPE__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case PivotPackage.TYPE__EXTENDED_BYS:
				return ((InternalEList<?>)getExtendedBys()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE__OWNED_INVARIANT:
				return ((InternalEList<?>)getOwnedInvariant()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.TYPE__COMMENT:
				return getComment();
			case PivotPackage.TYPE__EXTENSION:
				return getExtension();
			case PivotPackage.TYPE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.TYPE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.TYPE__NAME:
				return getName();
			case PivotPackage.TYPE__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.TYPE__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.TYPE__EXTENDED_BYS:
				return getExtendedBys();
			case PivotPackage.TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.TYPE__OWNED_INVARIANT:
				return getOwnedInvariant();
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
			case PivotPackage.TYPE__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
				getExtendedBys().addAll((Collection<? extends TypeExtension>)newValue);
				return;
			case PivotPackage.TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.TYPE__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				getOwnedInvariant().addAll((Collection<? extends Constraint>)newValue);
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
			case PivotPackage.TYPE__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.TYPE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.TYPE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.TYPE__EXTENDED_BYS:
				getExtendedBys().clear();
				return;
			case PivotPackage.TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.TYPE__OWNED_INVARIANT:
				getOwnedInvariant().clear();
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
			case PivotPackage.TYPE__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.TYPE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.TYPE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.TYPE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.TYPE__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.TYPE__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.TYPE__EXTENDED_BYS:
				return extendedBys != null && !extendedBys.isEmpty();
			case PivotPackage.TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case PivotPackage.TYPE__OWNED_INVARIANT:
				return ownedInvariant != null && !ownedInvariant.isEmpty();
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
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID)
		{
			case PivotPackage.TYPE___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.TYPE___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT:
				return isCompatibleWith((ParameterableElement)arguments.get(0));
			case PivotPackage.TYPE___IS_TEMPLATE_PARAMETER:
				return isTemplateParameter();
			case PivotPackage.TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP:
				return validateUniqueInvariantName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE:
				return specializeIn((OCLExpression)arguments.get(0), (Type)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		TemplateParameter owningTemplateParameter = getOwningTemplateParameter();
		if (owningTemplateParameter != null) {
			return owningTemplateParameter.toString();
		}
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitType(this);
	}
	
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		DomainInheritance thisInheritance;
		if (getOwningTemplateParameter() != null) {
			thisInheritance = standardLibrary.getOclAnyType().getInheritance(standardLibrary);
		}
		else {
			thisInheritance = this.getInheritance(standardLibrary);
		}
		DomainInheritance thatInheritance = type.getInheritance(standardLibrary);
		return thisInheritance.isSubInheritanceOf(thatInheritance);
	}

	public @NonNull EObject createInstance() {
		EObject eTarget = getETarget();
		if (eTarget instanceof EClass) {
			EClass eClass = (EClass) eTarget;
			EObject element = eClass.getEPackage().getEFactoryInstance().create(eClass);
//			TypeId typeId = IdManager.getTypeId(eClass);
			return /*ValuesUtil.createObjectValue(typeId, */element;//);
		}
		throw new UnsupportedOperationException();
	}

	public @Nullable Object createInstance(@NonNull String value) {
		EObject eTarget = getETarget();
		if (eTarget instanceof EDataType) {
			EDataType eDataType = (EDataType) eTarget;
			Object element = eDataType.getEPackage().getEFactoryInstance().createFromString(eDataType, value);
//			TypeId typeId = IdManager.getTypeId(eDataType);
			return /*ValuesUtil.createObjectValue(typeId, */element;//);
//			return ValuesUtil.valueOf(element);
		}
		throw new UnsupportedOperationException();
	}

	public @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		if (type == this) {
			return this;
		}
		DomainStandardLibrary standardLibrary = idResolver.getStandardLibrary();
		DomainInheritance thisInheritance = this.getInheritance(standardLibrary);
		DomainInheritance thatInheritance = type.getInheritance(standardLibrary);
		return thisInheritance.getCommonInheritance(thatInheritance);
	}

	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		return standardLibrary.getInheritance(this);
	}

	public @NonNull DomainType getNormalizedType(@NonNull DomainStandardLibrary standardLibrary) {
		try {
			return standardLibrary.getInheritance(this);
		}
		catch (Throwable e) {
			return this;			// WIP FIXME should never happen
		}
	}

	public @NonNull String getMetaTypeName() {
		return eClass().getName();
	}

	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		DomainType thisType = this.getNormalizedType(standardLibrary);
		DomainType thatType = type.getNormalizedType(standardLibrary);
		return thisType == thatType;
	}

	public boolean isEqualToUnspecializedType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		return false;
	}

	public boolean isInvalid() {
		return false;
	}

	public boolean isOrdered() {
		return false;
	}

	public boolean isUnique() {
		return false;
	}

	public @NonNull DomainOperation lookupActualOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		DomainInheritance inheritance = getInheritance(standardLibrary);
		return inheritance.lookupActualOperation(standardLibrary, apparentOperation);
	}

	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		DomainInheritance inheritance = getInheritance(standardLibrary);
		return inheritance.lookupImplementation(standardLibrary, apparentOperation);
	}

	public boolean oclEquals(@NonNull OCLValue thatValue) {
		if (!(thatValue instanceof DomainType)) {
			return false;
		}
		TypeId thisTypeId = getTypeId();
		TypeId thatTypeId = ((DomainType)thatValue).getTypeId();
		return thisTypeId.equals(thatTypeId);
	}

	public int oclHashCode() {
		return getTypeId().hashCode();
	}

	public Type specializeIn(final OCLExpression expr, final Type selfType)
	{
		return (Type) specializeIn(DomainUtil.nonNullState((DomainCallExp)expr), (DomainType)selfType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUniqueInvariantName(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv UniqueInvariantName: ownedInvariant->isUnique(name)
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object CAUGHT_isUnique;
		try {
		    final @NonNull /*@Thrown*/ List<? extends DomainConstraint> ownedInvariant = this.getOwnedInvariant();
		    final @NonNull /*@Thrown*/ SetValue BOXED_ownedInvariant = idResolver.createSetOfAll(PivotTables.SET_CLSSid_Constraint, ownedInvariant);
		    @NonNull /*@Thrown*/ SetValue.Accumulator accumulator = ValuesUtil.createSetAccumulatorValue(PivotTables.SET_CLSSid_Constraint);
		    @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedInvariant.iterator();
		    /*@Thrown*/ boolean isUnique;
		    while (true) {
		        if (!ITERATOR__1.hasNext()) {
		            isUnique = ValuesUtil.TRUE_VALUE;
		            break;
		        }
		        @Nullable /*@NonInvalid*/ DomainConstraint _1 = (DomainConstraint)ITERATOR__1.next();
		        /**
		         * name
		         */
		        if (_1 == null) {
		            throw new InvalidValueException("Null source for \'pivot::NamedElement::name\'");
		        }
		        final @Nullable /*@Thrown*/ String name = _1.getName();
		        //
		        if (accumulator.includes(name) == ValuesUtil.TRUE_VALUE) {
		            isUnique = ValuesUtil.FALSE_VALUE;			// Abort after second find
		            break;
		        }
		        else {
		            accumulator.add(name);
		        }
		    }
		    CAUGHT_isUnique = isUnique;
		}
		catch (Exception e) {
		    CAUGHT_isUnique = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_isUnique == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"Type", "UniqueInvariantName", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.TYPE__UNIQUE_INVARIANT_NAME, message, new Object [] { this }));
		}
		return false;
	}

	@NonNull
	public List<? extends DomainConstraint> getOwnedRule() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public DomainPackage getPackage() {
		throw new UnsupportedOperationException();		// FIXME
	}

	@NonNull
	public List<? extends DomainProperty> getOwnedProperties() {
		throw new UnsupportedOperationException();		// FIXME
	}

	@NonNull
	public List<? extends DomainOperation> getOwnedOperations() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public DomainType specializeIn(@NonNull DomainCallExp expr, DomainType selfType) {
		throw new UnsupportedOperationException();		// FIXME
	}
} //TypeImpl
