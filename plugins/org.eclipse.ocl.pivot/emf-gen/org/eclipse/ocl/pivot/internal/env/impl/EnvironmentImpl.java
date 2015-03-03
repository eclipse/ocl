/**
 */
package org.eclipse.ocl.pivot.internal.env.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.internal.env.EnvPackage;
import org.eclipse.ocl.pivot.internal.lookup.IEnvironment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.env.impl.EnvironmentImpl#getNamedElements <em>Named Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnvironmentImpl extends MinimalEObjectImpl.Container implements IEnvironment {
	/**
	 * The cached value of the '{@link #getNamedElements() <em>Named Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> namedElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvPackage.Literals.ENVIRONMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getNamedElements() {
		if (namedElements == null) {
			namedElements = new EObjectResolvingEList<NamedElement>(NamedElement.class, this, EnvPackage.ENVIRONMENT__NAMED_ELEMENTS);
		}
		return namedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEnvironment addElementsOf(Namespace elements) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean hasFinalResult() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEnvironment nestedEnv() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EnvPackage.ENVIRONMENT__NAMED_ELEMENTS:
				return getNamedElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EnvPackage.ENVIRONMENT__NAMED_ELEMENTS:
				getNamedElements().clear();
				getNamedElements().addAll((Collection<? extends NamedElement>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EnvPackage.ENVIRONMENT__NAMED_ELEMENTS:
				getNamedElements().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EnvPackage.ENVIRONMENT__NAMED_ELEMENTS:
				return namedElements != null && !namedElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EnvPackage.ENVIRONMENT___ADD_ELEMENT__NAMEDELEMENT_1:
				return addElement((NamedElement)arguments.get(0));
			case EnvPackage.ENVIRONMENT___ADD_ELEMENT__STRING_NAMEDELEMENT_1:
				return addElement((String)arguments.get(0), (NamedElement)arguments.get(1));
			case EnvPackage.ENVIRONMENT___ADD_ELEMENTS__COLLECTION_1:
				return addElements((Collection<NamedElement>)arguments.get(0));
			case EnvPackage.ENVIRONMENT___ADD_ELEMENTS_OF__NAMESPACE:
				return addElementsOf((Namespace)arguments.get(0));
			case EnvPackage.ENVIRONMENT___HAS_FINAL_RESULT:
				return hasFinalResult();
			case EnvPackage.ENVIRONMENT___NESTED_ENV:
				return nestedEnv();
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	@NonNull
	public IEnvironment addElement(@Nullable NamedElement namedElement) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEnvironment addElement(String name, NamedElement element) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull IEnvironment addElements(@Nullable Collection<NamedElement> elements) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public Evaluator getEvaluator() {
		throw new UnsupportedOperationException();

	}

	@Override
	public int getSize() {
		throw new UnsupportedOperationException();

	}

} //EnvironmentImpl
