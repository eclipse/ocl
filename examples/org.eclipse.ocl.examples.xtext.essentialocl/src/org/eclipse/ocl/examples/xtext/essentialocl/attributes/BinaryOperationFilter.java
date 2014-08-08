/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.attributes;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;

public class BinaryOperationFilter extends AbstractOperationFilter
{
	protected final @NonNull Type argumentType;
	
	public BinaryOperationFilter(@NonNull Type sourceType, @NonNull Type argumentType) {
		super(sourceType);
		this.argumentType = argumentType;
	}

	public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
		if (object instanceof Iteration) {		
			return false;
		}
		else if (object instanceof Operation) {
			Operation candidateOperation = (Operation)object;
			List<Parameter> candidateParameters = candidateOperation.getOwnedParameter();
			if (candidateParameters.size() != 1) {
				return false;
			}
			Parameter candidateParameter = candidateParameters.get(0);
			Type candidateType = candidateParameter.getType();
			if (candidateType instanceof SelfType) {
				candidateType = candidateOperation.getOwningClass();
			}
			if (candidateType == null) {
				return false;
			}
			MetaModelManager metaModelManager = environmentView.getMetaModelManager();
			Map<TemplateParameter, ParameterableElement> bindings = getOperationBindings(metaModelManager, candidateOperation);
			if (!metaModelManager.conformsTo(argumentType, candidateType, bindings)) {
				return false;
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