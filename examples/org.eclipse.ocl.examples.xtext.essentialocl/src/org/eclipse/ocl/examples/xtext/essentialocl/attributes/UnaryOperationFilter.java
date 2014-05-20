/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.essentialocl.attributes;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;

public class UnaryOperationFilter extends AbstractOperationFilter
{
	public UnaryOperationFilter(@NonNull Type sourceType) {
		super(sourceType);
	}

	public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
		if (object instanceof Iteration) {		
			return false;
		}
		else if (object instanceof Operation) {
			Operation candidateOperation = (Operation)object;
			List<Parameter> candidateParameters = candidateOperation.getOwnedParameter();
			if (candidateParameters.size() != 0) {
				return false;
			}
			Map<TemplateParameter, ParameterableElement> bindings = getOperationBindings(environmentView.getMetaModelManager(), candidateOperation);
			if (bindings != null) {
				installBindings(environmentView, object, bindings);
			}
			return true;
		}
		else {
			return false;
		}
	}
}