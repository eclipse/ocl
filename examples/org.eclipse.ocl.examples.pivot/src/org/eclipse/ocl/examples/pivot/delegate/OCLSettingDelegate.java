/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.delegate;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicSettingDelegate;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.common.internal.delegate.OCLDelegateException;
import org.eclipse.ocl.examples.domain.evaluation.DomainException;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.EvaluationException;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Query;
import org.eclipse.ocl.examples.pivot.SemanticException;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;

/**
 * An implementation of a setting delegate that computes OCL derived features.
 * 
 * @since 3.0
 */
public class OCLSettingDelegate extends BasicSettingDelegate.Stateless
{
	protected final OCLDelegateDomain delegateDomain;
	private Property property;
	private ExpressionInOCL specification;

	/**
	 * Initializes me with my structural feature.
	 * 
	 * @param structuralFeature
	 *            the structural feature that I handle
	 */
	public OCLSettingDelegate(@NonNull OCLDelegateDomain delegateDomain, @NonNull EStructuralFeature structuralFeature) {
		super(structuralFeature);
		this.delegateDomain = delegateDomain;
	}

	@Override
	protected Object get(InternalEObject owner, boolean resolve, boolean coreType) {
		try {
			OCL ocl = delegateDomain.getOCL();
			MetaModelManager metaModelManager = ocl.getEnvironment().getMetaModelManager();
			IdResolver idResolver = metaModelManager.getIdResolver();
			ExpressionInOCL specification2 = specification;
			if (specification2 == null) {
				Property property2 = getProperty();
				specification2 = specification = SettingBehavior.INSTANCE.getExpressionInOCL(metaModelManager, property2);
				SettingBehavior.INSTANCE.validate(property2);
			}
			Query query = ocl.createQuery(specification2);
			Object result = query.evaluate(owner);
//			if (result == null) {
//				String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, property);
//				throw new OCLDelegateException(message);
//			}
			Object unboxedValue = idResolver.unboxedValueOf(result);
			if (unboxedValue instanceof Number) {
				return ValuesUtil.getEcoreNumber((Number)unboxedValue, eStructuralFeature.getEType().getInstanceClass());
			}
			else {
				return unboxedValue;
			}
		}
		catch (DomainException e) {
			String message = DomainUtil.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, property);
			throw new OCLDelegateException(new EvaluationException(message, e));
		}
	}

	public @NonNull Property getProperty() {
		Property property2 = property;
		if (property2 == null) {
			property2 = property = delegateDomain.getPivot(Property.class, DomainUtil.nonNullEMF(eStructuralFeature));
			if (property2 == null) {
				throw new OCLDelegateException(new SemanticException("No pivot property for " + eStructuralFeature)) ;
			}
		}
		return property2;
	}

	@Override
	protected boolean isSet(InternalEObject owner) {
		return false; // derived features are, implicitly, never set
	}

	@Override
	public String toString() {
		if (property != null) {
			return "<" + delegateDomain.getURI() + ":setting> " + property; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			String name = eStructuralFeature.getEContainingClass().getEPackage().getName()
			+ "::" + eStructuralFeature.getEContainingClass().getName()
			+ "." + eStructuralFeature.getName();
			return "<" + delegateDomain.getURI() + ":setting> " + name; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
