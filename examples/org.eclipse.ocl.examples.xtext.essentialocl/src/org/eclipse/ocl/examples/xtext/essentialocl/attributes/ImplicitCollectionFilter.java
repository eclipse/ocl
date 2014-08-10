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
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class ImplicitCollectionFilter extends AbstractOperationFilter
{
	public ImplicitCollectionFilter(@NonNull Type sourceType) {
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
			Map<TemplateParameter, Type> bindings = sourceType instanceof TemplateableElement ? PivotUtil.getAllTemplateParameterSubstitutions(null, (TemplateableElement)sourceType) : null;
			TemplateSignature templateSignature = candidateOperation.getOwnedTemplateSignature();
			if (templateSignature != null) {
				for (TemplateParameter templateParameter : templateSignature.getOwnedParameter()) {
					if (bindings == null) {
						bindings = new HashMap<TemplateParameter, Type>();
					}
					bindings.put(templateParameter, null);
				}
			}
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