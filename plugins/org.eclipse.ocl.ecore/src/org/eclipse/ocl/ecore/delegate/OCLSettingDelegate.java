/**
 * <copyright>
 * 
 * Copyright (c) 2010, 2014 E.D.Willink, CEA, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 *   Christian W. Damus (CEA) - 418716
 * 
 * </copyright>
 */
package org.eclipse.ocl.ecore.delegate;

import static org.eclipse.emf.ecore.EStructuralFeature.Internal.DynamicValueHolder.NIL;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.InternalSettingDelegateSingleData.NotificationCreator;
import org.eclipse.emf.ecore.util.BasicSettingDelegate;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.osgi.util.NLS;

/**
 * An implementation of a setting delegate that computes OCL derived features.
 * 
 * @since 3.0
 */
public class OCLSettingDelegate extends BasicSettingDelegate.Stateless
{
	protected final OCLDelegateDomain delegateDomain;
	private OCLExpression derivation;
	private ValueConverter converter;

	private final boolean isInitialValue;

	/**
	 * Initializes me with my structural feature.
	 * 
	 * @param structuralFeature
	 *            the structural feature that I handle
	 * 
	 * @throws ParserException
	 *             if the structural feature's OCL derivation is invalid
	 */
	public OCLSettingDelegate(OCLDelegateDomain delegateDomain, EStructuralFeature structuralFeature) {
		super(structuralFeature);
		this.delegateDomain = delegateDomain;
		this.converter = structuralFeature.isMany()
			? ValueConverter.LIST
			: ValueConverter.VERBATIM;
		this.isInitialValue = structuralFeature.isChangeable();
	}

	@Override
	protected Object get(InternalEObject owner, boolean resolve, boolean coreType) {
		final OCL ocl = delegateDomain.getOCL();

		if (isInitialValue) {
			// check for an explicit setting
			OCLSettingsAdapter adapter = getSettingsAdapter(owner, false);
			if (adapter != null) {
				Object setting = adapter.get(eStructuralFeature);
				if (setting == NIL) {
					return null;
				} else if (setting != null) {
					return converter.convert(ocl, setting);
				}
			}
		}

		if (derivation == null) {
			derivation = SettingBehavior.INSTANCE.getFeatureBody(ocl, eStructuralFeature);
		}
		if (derivation == null) {
			String message = NLS.bind(OCLMessages.MissingDerivationForSettingDelegate_ERROR_, getFeatureName());
			throw new org.eclipse.ocl.ecore.delegate.OCLDelegateException(message);
		}
		OCL.Query query = ocl.createQuery(derivation);
		Object result = query.evaluate(owner);
		if (ocl.isInvalid(result)) {
			String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, getFeatureName());
			throw new org.eclipse.ocl.ecore.delegate.OCLDelegateException(message);
		}
//		if ((result == null) /* || ocl.isInvalid(result) */) {
//			String message = NLS.bind(OCLMessages.EvaluationResultIsNull_ERROR_, getFeatureName());
//			throw new org.eclipse.ocl.ecore.delegate.OCLDelegateException(message);
//		}
		return converter.convert(ocl, result);
	}
	
	public String getFeatureName() {
		return eStructuralFeature.getEContainingClass().getEPackage().getName() + "::" + eStructuralFeature.getEContainingClass().getName() + "." + eStructuralFeature.getName();  //$NON-NLS-1$//$NON-NLS-2$
	}

	@Override
	protected boolean isSet(InternalEObject owner) {
		OCLSettingsAdapter adapter = getSettingsAdapter(owner, false);
		return (adapter != null) && adapter.isSet(eStructuralFeature);
	}

	@Override
	protected void set(InternalEObject owner, Object newValue) {
		OCLSettingsAdapter adapter = getSettingsAdapter(owner, true);
		if (adapter != null) {
			adapter.set(eStructuralFeature, newValue);
		} else {
			// this should throw UnsupportedOperationException
			super.set(owner, newValue);
		}
	}

	@Override
	protected void unset(InternalEObject owner) {
		OCLSettingsAdapter adapter = getSettingsAdapter(owner, true);
		if (adapter != null) {
			adapter.unset(eStructuralFeature);
		} else {
			// this should throw UnsupportedOperationException
			super.unset(owner);
		}
	}

	private OCLSettingsAdapter getSettingsAdapter(InternalEObject owner,
			boolean create) {

		OCLSettingsAdapter result = null;

		for (Object next : owner.eAdapters()) {
			if (next instanceof OCLSettingsAdapter) {
				result = (OCLSettingsAdapter) next;
				break;
			}
		}

		if ((result == null) && create) {
			result = new OCLSettingsAdapter(owner);
			owner.eAdapters().add(result);
		}

		return result;
	}

	@Override
	public String toString() {
		return "<" + delegateDomain.getURI() + ":setting> " + getFeatureName(); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * An adapter that caches settings for features that compute initial values
	 * that may be explicitly overridden.
	 */
	private static class OCLSettingsAdapter
			extends AdapterImpl {

		private final int[] featureIndex;

		private final Object[] settings;

		OCLSettingsAdapter(InternalEObject owner) {
			OCLInitialValueFeaturesIndexAdapter indexAdapter = getIndexAdapter(owner
				.eClass());
			featureIndex = indexAdapter.getFeatureIndex();
			settings = indexAdapter.createSettings();
		}

		boolean isSet(EStructuralFeature feature) {
			return settings[index(feature)] != null;
		}

		Object get(EStructuralFeature feature) {
			return settings[index(feature)];
		}

		void set(EStructuralFeature feature, Object value) {
			final int index = index(feature);
			final InternalEObject owner = getOwner();

			Object oldValue = settings[index];
			boolean wasSet = oldValue != null;
			if (oldValue == null) {
				// compute the default
				oldValue = owner.eGet(feature);
			}

			if ((value == null) && feature.isUnsettable()) {
				// explicit null value
				settings[index] = NIL;
			} else {
				settings[index] = value;
			}
			if (owner.eNotificationRequired()) {
				// if the new value is unset-ness, compute the default
				Object newValue = (value == null)
					? owner.eGet(feature)
					: value;
				owner.eNotify(NotificationCreator.get(
					feature.getEType().getClass()).createNotification(owner,
					Notification.SET, feature, oldValue, newValue, wasSet));
			}
		}

		void unset(EStructuralFeature feature) {
			final int index = index(feature);
			final InternalEObject owner = getOwner();

			Object oldValue = settings[index];
			boolean wasSet = oldValue != null;
			settings[index] = null;
			if (owner.eNotificationRequired()) {
				// compute the default
				Object newValue = owner.eGet(feature);
				if (oldValue == null) {
					// it was default, before
					oldValue = newValue;
				}

				owner.eNotify(NotificationCreator.get(
					feature.getEType().getClass()).createNotification(owner,
					feature.isUnsettable()
						? Notification.UNSET
						: Notification.SET, //
					feature, //
					(oldValue == NIL)
						? null
						: oldValue, //
					newValue, wasSet));
			}
		}

		private InternalEObject getOwner() {
			return (InternalEObject) getTarget();
		}

		private int index(EStructuralFeature feature) {
			return featureIndex[feature.getFeatureID()];
		}

		private OCLInitialValueFeaturesIndexAdapter getIndexAdapter(
				EClass eClass) {

			OCLInitialValueFeaturesIndexAdapter result = null;

			for (Object next : eClass.eAdapters()) {
				if (next instanceof OCLInitialValueFeaturesIndexAdapter) {
					result = (OCLInitialValueFeaturesIndexAdapter) next;
					break;
				}
			}

			if (result == null) {
				result = new OCLInitialValueFeaturesIndexAdapter(eClass);
				eClass.eAdapters().add(result);
			}

			return result;
		}
	}

	/**
	 * An adapter that caches, for an {@link EClass}, the index mappings of
	 * OCL-derived initial-value (changeable) features in the settings store for
	 * those features in the {@link OCLSettingsAdapter}.
	 */
	private static class OCLInitialValueFeaturesIndexAdapter
			extends AdapterImpl {

		private final int[] featureIndex;

		private final int settingsSize;

		OCLInitialValueFeaturesIndexAdapter(EClass eClass) {
			final List<EStructuralFeature> features = eClass
				.getEStructuralFeatures();
			final int featureCount = features.size();
			featureIndex = new int[featureCount];

			int index = 0;
			for (int i = 0; i < featureCount; i++) {
				EStructuralFeature feature = features.get(i);
				if (isInitialValueFeature(feature)) {
					featureIndex[i] = index++;
				} else {
					featureIndex[i] = -1;
				}
			}

			settingsSize = index;
		}

		int[] getFeatureIndex() {
			return featureIndex;
		}

		Object[] createSettings() {
			return new Object[settingsSize];
		}

		private boolean isInitialValueFeature(EStructuralFeature feature) {
			return feature.isChangeable()
				&& SettingBehavior.INSTANCE.hasCompileableFeatureBody(feature);
		}
	}
}
