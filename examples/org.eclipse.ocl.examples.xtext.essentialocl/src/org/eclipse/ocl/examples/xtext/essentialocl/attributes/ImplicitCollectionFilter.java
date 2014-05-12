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
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.lookup.AutoILookupResult;
import org.eclipse.ocl.examples.pivot.lookup.AutoIPivotLookupResult;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class ImplicitCollectionFilter extends AbstractOperationFilter<Operation>
{
	public ImplicitCollectionFilter(@NonNull Type sourceType) {
		super(sourceType);
	}

	public boolean matches(@NonNull EnvironmentView environmentView, 
			@NonNull Object object) {
		
		Map<TemplateParameter, ParameterableElement> bindings  = getBindings(object);
		if (bindings != null) {
			installBindings(environmentView, object, bindings);
			return true;
		}
		return false;
	}

	public boolean matches(@NonNull AutoILookupResult<Operation> lookupResult,
			@NonNull Operation object) {
		
		AutoIPivotLookupResult<Operation> lookupResult2 = (AutoIPivotLookupResult<Operation>)lookupResult;
		Map<TemplateParameter, ParameterableElement> bindings  = getBindings(object);
		if (bindings != null) {
			installBindings(lookupResult2, object, bindings);
			return true;
		}
		return false;
	}
	
	private Map<TemplateParameter, ParameterableElement> getBindings(@NonNull Object object) {
		if (object instanceof Iteration) {		
			return null;
		}
		else if (object instanceof Operation) {
			Operation candidateOperation = (Operation)object;
			List<Parameter> candidateParameters = candidateOperation.getOwnedParameter();
			if (candidateParameters.size() != 0) {
				return null;
			}
			Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, sourceType);
			TemplateSignature templateSignature = candidateOperation.getOwnedTemplateSignature();
			if (templateSignature != null) {
				for (TemplateParameter templateParameter : templateSignature.getOwnedParameter()) {
					if (bindings == null) {
						bindings = new HashMap<TemplateParameter, ParameterableElement>();
					}
					bindings.put(templateParameter, null);
				}
			}			
			return bindings == null ? new HashMap<TemplateParameter, ParameterableElement>() : bindings;
		}
		else {
			return null;
		}
	}
}
