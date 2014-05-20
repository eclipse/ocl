/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   E.D.Willink - Initial API and implementation
 * 	 E.D.Willink - Bug 306079
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLCommon;
import org.eclipse.ocl.common.delegate.VirtualDelegateMapping;
import org.eclipse.ocl.common.internal.delegate.OCLDelegateException;
import org.eclipse.ocl.examples.domain.validation.DomainSubstitutionLabelProvider;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.EvaluationException;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.context.ClassContext;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * A basic implementation of a delegated behavior.
 */
public abstract class AbstractDelegatedBehavior<E extends EModelElement, R, F>
		implements DelegatedBehavior<E, R, F> {

	private static List<DelegatedBehavior<?, ?, ?>> delegatedBehaviors = null;

	public static @NonNull List<DelegatedBehavior<?, ?, ?>> getDelegatedBehaviors() {
		// FIXME Maybe use an extension point here (but need a common
		//  Factory, Registry supertype for a user-defined fourth behavior)
		List<DelegatedBehavior<?, ?, ?>> delegatedBehaviors2 = delegatedBehaviors;
		if (delegatedBehaviors2 == null) {
			delegatedBehaviors2 = delegatedBehaviors = new ArrayList<DelegatedBehavior<?, ?, ?>>();
			delegatedBehaviors2.add(InvocationBehavior.INSTANCE);
			delegatedBehaviors2.add(SettingBehavior.INSTANCE);
			delegatedBehaviors2.add(ValidationBehavior.INSTANCE);
		}
		return delegatedBehaviors2;
	};

/*	public @Nullable Constraint getConstraintForStereotype(@NonNull NamedElement namedElement, @NonNull String name) {
		for (Constraint constraint : namedElement.getOwnedRule()) {
			String stereotype = constraint.getStereotype();
			if (name.equals(stereotype)) {
				return constraint;
			}
		}
		return null;
	} */
	
	public List<DelegateDomain> getDelegateDomains(@NonNull E eObject) {
		EPackage ePackage = getEPackage(eObject);
		DelegateEPackageAdapter adapter = DelegateEPackageAdapter.getAdapter(ePackage);
		List<DelegateDomain> delegateDomains = new ArrayList<DelegateDomain>();
		for (DelegateDomain delegateDomain : adapter.getAllDelegateDomains()) {
			String uri = delegateDomain.getURI();
			if (hasDelegateAnnotation(eObject, ePackage, uri)) {
				delegateDomains.add(delegateDomain);
			}
		}
		return delegateDomains;
	}

	public @NonNull List<F> getFactories(@NonNull E eObject) {
		EPackage ePackage = getEPackage(eObject);
		DelegateEPackageAdapter adapter = DelegateEPackageAdapter.getAdapter(ePackage);
		List<F> factories = new ArrayList<F>();
		for (DelegateDomain delegateDomain : adapter.getAllDelegateDomains()) {
			String uri = delegateDomain.getURI();
			if (hasDelegateAnnotation(eObject, ePackage, uri)) {
				F factory = getFactory(delegateDomain, eObject);
				if (factory == null) {
					factory = getDefaultFactory();
				}
				if ((factory != null) && !factories.contains(factory)) {
					factories.add(factory);
				}
			}
		}
		return factories;
	}

	protected abstract @Nullable F getFactory(@NonNull DelegateDomain delegateDomain, @NonNull E eObject);

	public @Nullable F getFactory(@NonNull E eObject) {
		EPackage ePackage = getEPackage(eObject);
		DelegateEPackageAdapter adapter = DelegateEPackageAdapter.getAdapter(ePackage);
		for (DelegateDomain delegateDomain : adapter.getAllDelegateDomains()) {
			String uri = delegateDomain.getURI();
			if (eObject.getEAnnotation(uri) != null) {
				F factory = getFactory(delegateDomain, eObject);
				if (factory == null) {
					factory = getDefaultFactory();
				}
				return factory;
			}
		}
		return null;
	}

	protected ExpressionInOCL getExpressionInOCL(@NonNull ClassContext parserContext, @NonNull Constraint constraint) {
		OpaqueExpression valueSpecification = constraint.getSpecification();
		if (valueSpecification instanceof ExpressionInOCL) {
			return (ExpressionInOCL) valueSpecification;
		}
		if (valueSpecification != null) {
			try {
				String expression = PivotUtil.getBody(valueSpecification);
				if (expression != null) {
					ExpressionInOCL expressionInOCL = parserContext.parse(constraint, expression);
					constraint.setSpecification(expressionInOCL);
					return expressionInOCL;
				}
			} catch (ParserException e) {
				throw new OCLDelegateException(e);
			}
		}
		return null;
	}

	protected ExpressionInOCL getExpressionInOCL(@NonNull ClassContext parserContext, @NonNull OpaqueExpression specification) {
		if (specification instanceof ExpressionInOCL) {
			return (ExpressionInOCL) specification;
		}
		try {
			String expression = PivotUtil.getBody(specification);
			if (expression != null) {
				return parserContext.parse(specification.eContainer(), expression);
			}
		} catch (ParserException e) {
			throw new OCLDelegateException(e);
		}
		return null;
	}

	private boolean hasDelegateAnnotation(@NonNull E eObject, @NonNull EPackage ePackage, @NonNull String uri) {
		if (eObject.getEAnnotation(uri) != null) {
			return true;
		}
		EAnnotation delegateAnnotation = OCLCommon.getDelegateAnnotation(eObject);
		if (delegateAnnotation != null) {
			VirtualDelegateMapping registry = VirtualDelegateMapping.getRegistry(ePackage);
			String resolvedURI = registry.getPreferredValue();
			if (uri.equals(resolvedURI)) {
				return true;
			}
		}
		return false;
	}

	public void setDelegates(@NonNull EPackage ePackage, @Nullable List<String> delegateURIs) {
		final String name = getName();
		EAnnotation eAnnotation = ePackage.getEAnnotation(EcorePackage.eNS_URI);
		if (delegateURIs == null || delegateURIs.isEmpty()) {
			if (eAnnotation != null) {
				eAnnotation.getDetails().remove(name);
			}
		} else {
			if (eAnnotation == null) {
				eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(EcorePackage.eNS_URI);
				ePackage.getEAnnotations().add(eAnnotation);
			}
			StringBuilder value = new StringBuilder();
			for (Iterator<String> i = delegateURIs.iterator(); i.hasNext();) {
				value.append(i.next());
				if (i.hasNext()) {
					value.append(' ');
				}
			}
			eAnnotation.getDetails().put(name, value.toString());
		}
	}

	@Override
	public String toString() {
		return getName() + " => " + getFactoryClass().getName(); //$NON-NLS-1$
	}

	public void validate(EObject eObject) {
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		BasicDiagnostic diagnostics = Diagnostician.INSTANCE.createDefaultDiagnostic(eObject);
		if (!Diagnostician.INSTANCE.validate(eObject, diagnostics, validationContext)) {
			StringBuilder s = null;
			for (Diagnostic diagnostic : diagnostics.getChildren()) {
				if (s == null) {
					s = new StringBuilder();
				}
				else {
					s.append("\n");
				}
				s.append(diagnostic.getMessage());
			}
			if (s != null) {
				@SuppressWarnings("null")@NonNull String string = s.toString();
				throw new OCLDelegateException(new EvaluationException(string));
			}
		}
	}
}
