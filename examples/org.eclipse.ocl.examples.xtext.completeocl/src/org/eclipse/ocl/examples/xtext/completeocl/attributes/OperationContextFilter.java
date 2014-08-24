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
package org.eclipse.ocl.examples.xtext.completeocl.attributes;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS;

public class OperationContextFilter implements ScopeFilter
{
	private final @NonNull OperationContextDeclCS csOperationContext;
	
	public OperationContextFilter(@NonNull OperationContextDeclCS csOperationContext) {
		this.csOperationContext = csOperationContext;
	}

	public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
		if (!(object instanceof Operation)) {
			return false;
		}
		Operation candidateOperation = (Operation) object;
		MetaModelManager metaModelManager = environmentView.getMetaModelManager();
//		Type context = metaModelManager.getPrimaryType(candidateOperation.getOwningType());
//		if (context != metaModelManager.getPrimaryElement(forType)) {
//			return false;
//		}
		List<ParameterCS> contextParameters = csOperationContext.getParameters();
		List<Parameter> candidateParameters = candidateOperation.getOwnedParameter();
		int iMax = contextParameters.size();
		if (iMax != candidateParameters.size()) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {
			ParameterCS contextParameter = contextParameters.get(i);
			Parameter candidateParameter = candidateParameters.get(i);
			Type contextType = PivotUtil.getPivot(Type.class, contextParameter.getOwnedType());
			Type candidateType = candidateParameter.getType();
			if (contextType != null) {
				contextType = metaModelManager.getPrimaryType(contextType);
			}
			if (candidateType != null) {
				candidateType = metaModelManager.getPrimaryType(candidateType);
			}
// FIXME Need to resolve parameter type pivots first
//			if (contextType != candidateType) {
//				return false;
//			}
		}
		return true;
	}
}