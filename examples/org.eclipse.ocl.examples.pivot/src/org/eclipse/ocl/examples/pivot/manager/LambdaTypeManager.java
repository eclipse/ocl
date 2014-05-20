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
package org.eclipse.ocl.examples.pivot.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * LambdaTypeManager encapsulates the knowledge about known lambda types.
 */
public class LambdaTypeManager
{
	protected final @NonNull MetaModelManager metaModelManager;
	
	/**
	 * Map from from context type via first parameter type, which may be null, to list of lambda types sharing context and first parameter types. 
	 */
	private final @NonNull Map<Type, Map<Type, List<LambdaType>>> lambdaTypes = new HashMap<Type, Map<Type, List<LambdaType>>>();
// FIXME Why does a List map give a moniker test failure
//	private final @NonNull Map<Type, Map<List<? extends Type>, LambdaType>> lambdaTypes = new HashMap<Type, Map<List<? extends Type>, LambdaType>>();
	
	protected LambdaTypeManager(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
	}

	public void dispose() {
		lambdaTypes.clear();
	}
	
	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType) {
		Map<Type, List<LambdaType>> contextMap = lambdaTypes.get(contextType);
		if (contextMap == null) {
			contextMap = new HashMap<Type, List<LambdaType>>();
			lambdaTypes.put(contextType, contextMap);
		}
		int iMax = parameterTypes.size();
		Type firstParameterType = iMax > 0 ? parameterTypes.get(0) : null;
		List<LambdaType> lambdasList = contextMap.get(firstParameterType);
		if (lambdasList == null) {
			lambdasList = new ArrayList<LambdaType>();
			contextMap.put(firstParameterType, lambdasList);
		}
		for (LambdaType candidateLambda : lambdasList) {
			if (resultType == candidateLambda.getResultType()) {
				List<? extends Type> candidateTypes = candidateLambda.getParameterType();
				if (iMax == candidateTypes.size()) {
					boolean gotIt = true;
					for (int i = 1; i < iMax; i++) {
						Type requiredType = parameterTypes.get(i);
						Type candidateType = candidateTypes.get(i);
						if (requiredType != candidateType) {
							gotIt = false;
							break;
						}
					}
					if (gotIt) {
						return candidateLambda;
					}
				}
			}
		}			
		LambdaType lambdaType = PivotFactory.eINSTANCE.createLambdaType();
		lambdaType.setName(typeName);
		lambdaType.setContextType(contextType);
		lambdaType.getParameterType().addAll(parameterTypes);
		lambdaType.setResultType(resultType);
		lambdaType.getSuperClass().add(metaModelManager.getOclLambdaType());
		metaModelManager.addOrphanClass(lambdaType);
		lambdasList.add(lambdaType);
		return lambdaType;
	}
	   
/*	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType) {
		Map<List<? extends Type>, LambdaType> contextMap = lambdaTypes.get(contextType);
		if (contextMap == null) {
			contextMap = new HashMap<List<? extends Type>, LambdaType>();
			lambdaTypes.put(contextType, contextMap);
		}
		LambdaType lambdaType = contextMap.get(parameterTypes);
		if (lambdaType == null) {
			lambdaType = PivotFactory.eINSTANCE.createLambdaType();
			lambdaType.setName(typeName);
			lambdaType.setContextType(contextType);
			lambdaType.getParameterType().addAll(parameterTypes);
			lambdaType.setResultType(resultType);
			lambdaType.getSuperClass().add(metaModelManager.getOclLambdaType());
			metaModelManager.addOrphanClass(lambdaType);
			contextMap.put(parameterTypes, lambdaType);
		}
		return lambdaType;
	} */
	   
	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType,
			@Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		if (bindings == null) {
			return getLambdaType(typeName, contextType, parameterTypes, resultType);
		}
		else {
			Type specializedContextType = metaModelManager.getSpecializedType(contextType, bindings);
			List<Type> specializedParameterTypes = new ArrayList<Type>();
			for (Type parameterType : parameterTypes) {
				if (parameterType != null) {
					specializedParameterTypes.add(metaModelManager.getSpecializedType(parameterType, bindings));
				}
			}
			Type specializedResultType = metaModelManager.getSpecializedType(resultType, bindings);
			return getLambdaType(typeName, specializedContextType, specializedParameterTypes, specializedResultType);
		}
	}
}