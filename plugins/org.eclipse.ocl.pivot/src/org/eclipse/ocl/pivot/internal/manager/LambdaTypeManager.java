/*******************************************************************************
 * Copyright (c) 2011, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.ParameterType;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;

/**
 * LambdaTypeManager encapsulates the knowledge about known lambda types.
 */
public class LambdaTypeManager
{
	protected final @NonNull CompleteEnvironmentInternal completeEnvironment;
	protected final @NonNull org.eclipse.ocl.pivot.Class oclLambdaType;
	
	/**
	 * Map from from ParametersId to the LamabdaType. 
	 */
	private final @NonNull Map<ParametersId, LambdaType> lambdaTypes = new HashMap<ParametersId, LambdaType>();
// FIXME Why does a List map give a moniker test failure
//	private final @NonNull Map<Type, Map<List<? extends Type>, LambdaType>> lambdaTypes = new HashMap<Type, Map<List<? extends Type>, LambdaType>>();
	
	public LambdaTypeManager(@NonNull CompleteEnvironmentInternal allCompleteClasses) {
		this.completeEnvironment = allCompleteClasses;
		this.oclLambdaType = allCompleteClasses.getOwnedStandardLibrary().getOclLambdaType();
	}

	public void dispose() {
		lambdaTypes.clear();
	}

	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull List<ParameterType> parameterTypes, @NonNull ParameterType resultType,
			@Nullable TemplateParameterSubstitutions bindings) {
		if (bindings == null) {
			return getLambdaType(typeName, parameterTypes, resultType);
		}
		else {
			List<ParameterType> specializedParameterTypes = new ArrayList<ParameterType>();
			for (ParameterType parameterType : parameterTypes) {
				if (parameterType != null) {
					ParameterType specializedParameterType = getSpecializedParameterType(parameterType, bindings);
					specializedParameterTypes.add(specializedParameterType);
				}
			}
			ParameterType specializedResultType = getSpecializedParameterType(resultType, bindings);
			return getLambdaType(typeName, specializedParameterTypes, specializedResultType);
		}
	}
	
	private @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull List<ParameterType> parameterTypes, @NonNull ParameterType resultType) {
		ParametersId parametersId = IdManager.getParametersId(parameterTypes, resultType);
		LambdaType lambdaType = lambdaTypes.get(parametersId);
		if (lambdaType != null) {
			return lambdaType;
		}			
		lambdaType = PivotFactory.eINSTANCE.createLambdaType();
		lambdaType.setName(typeName);
		lambdaType.getOwnedParameterTypes().addAll(parameterTypes);
		lambdaType.setOwnedResultType(resultType);
//		lambdaType.setParametersId(parametersId);
		lambdaType.getSuperClasses().add(oclLambdaType);
		completeEnvironment.addOrphanClass(lambdaType);
		lambdaTypes.put(parametersId, lambdaType);
		return lambdaType;
	}

	private @NonNull ParameterType getSpecializedParameterType(@NonNull ParameterType parameterType, @Nullable TemplateParameterSubstitutions bindings) {
		Type type = parameterType.getType();
		if (type == null) {
			type = completeEnvironment.getOwnedStandardLibrary().getOclInvalidType();
		}
		Type specializedType = completeEnvironment.getSpecializedType(type, bindings);
		return PivotUtil.createParameterType(specializedType, parameterType.isIsNonNull());
	}
}