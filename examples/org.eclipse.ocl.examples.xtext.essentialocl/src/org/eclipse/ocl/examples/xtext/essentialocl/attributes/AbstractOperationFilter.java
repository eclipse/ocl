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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.lookup.AutoIPivotLookupEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public abstract class AbstractOperationFilter implements ScopeFilter, ScopeFilter.ScopeFilter2
{
	protected final @Nullable Type sourceType;
	
	public AbstractOperationFilter(@Nullable Type sourceType) {
		this.sourceType = sourceType != null ? PivotUtil.getType(sourceType) : null;		// FIXME redundant
	}

	public int compareMatches(@NonNull MetaModelManager metaModelManager, @NonNull Object match1, @Nullable Map<TemplateParameter, ParameterableElement> bindings1,
			@NonNull Object match2, @Nullable Map<TemplateParameter, ParameterableElement> bindings2) {
		return metaModelManager.compareOperationMatches((Operation)match1, bindings1, (Operation)match2, bindings2);
	}

	protected @Nullable Map<TemplateParameter, ParameterableElement> getOperationBindings(@NonNull MetaModelManager metaModelManager, @NonNull Operation candidateOperation) {
		Type sourceType = this.sourceType;
		if (!(sourceType instanceof CollectionType) && (candidateOperation.getOwningType() instanceof CollectionType) && (sourceType != null)) {
			assert sourceType != null;
			sourceType = metaModelManager.getSetType(sourceType, null, null);		// Implicit oclAsSet()
		}			
		Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, sourceType);
//			PivotUtil.getAllTemplateParameterSubstitutions(bindings, candidateOperation);
		TemplateSignature templateSignature = candidateOperation.getOwnedTemplateSignature();
		if (templateSignature != null) {
			for (TemplateParameter templateParameter : templateSignature.getOwnedParameter()) {
				if (bindings == null) {
					bindings = new HashMap<TemplateParameter, ParameterableElement>();
				}
				bindings.put(templateParameter, null);
			}
		}
		return bindings;
	}

	protected void installBindings(@NonNull EnvironmentView environmentView, @NonNull Object object,
			@Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		environmentView.setBindings(object, bindings);
	}
	
	protected void installBindings(@NonNull AutoIPivotLookupEnvironment lookupResult, @NonNull Object object,
			@Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		lookupResult.setBindings(object, bindings);
	}
	
	
	
}
