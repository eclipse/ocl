/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.attributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.lookup.AutoIPivotLookupEnvironment;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class ImplicitCollectFilter extends AbstractOperationFilter
{
	protected final @NonNull Type iteratorType;

	/**
	 * Configure an OperationFilter for an implicit collect.
	 */
	public ImplicitCollectFilter(@NonNull CollectionType sourceType, @NonNull Type iteratorType) {
		super(sourceType);
		this.iteratorType = iteratorType;
	}

	public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
		
		Map<TemplateParameter, ParameterableElement> bindings  = getBindings(object);
		if (bindings != null) {
			installBindings(environmentView, object, bindings);
			return true;
		}
		return false;
	}

	public boolean matches(@NonNull AutoIPivotLookupEnvironment lookupResult,
			@NonNull Object object) {
		
		Map<TemplateParameter, ParameterableElement> bindings  = getBindings(object);
		if (bindings != null) {
			installBindings(lookupResult, object, bindings);
			return true;
		}
		return false;
	}
	
	private Map<TemplateParameter, ParameterableElement> getBindings(@NonNull Object object) {
		
		if (!(object instanceof Iteration)) {
			return null;
		}
		Iteration candidateIteration = (Iteration)object;
		int iteratorCount = candidateIteration.getOwnedIterator().size();
		if (iteratorCount != 1) {
			return null;
		}
		int accumulatorCount = candidateIteration.getOwnedAccumulator().size();
		if (accumulatorCount != 0) {
			return null;
		}
		TemplateSignature templateSignature = candidateIteration.getOwningType().getOwnedTemplateSignature();
		if (templateSignature == null) {
			return null;
		}
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
		if (templateParameters.size() != 1) {
			return null;
		}
		Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, sourceType);
		TemplateParameter iteratorParameter = templateParameters.get(0);
		if (bindings != null) {
			bindings.put(iteratorParameter, iteratorType);
			return bindings;
		} else {
			return new HashMap<TemplateParameter, ParameterableElement>();
		}
	}
}
