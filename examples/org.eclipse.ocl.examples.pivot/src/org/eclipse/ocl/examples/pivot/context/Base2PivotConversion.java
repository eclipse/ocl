/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.context;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Type;

public interface Base2PivotConversion
{
	void setContextVariable(@NonNull ExpressionInOCL pivotSpecification, @NonNull String selfVariableName, @NonNull Type contextType);
	void setClassifierContext(@NonNull ExpressionInOCL pivotSpecification, @NonNull Type contextType);
	void setParameterVariables(@NonNull ExpressionInOCL pivotSpecification, @NonNull List<Parameter> parameters);
	void setParameterVariables(@NonNull ExpressionInOCL pivotSpecification, @NonNull Map<String, Type> parameters);
	void setResultVariable(@NonNull ExpressionInOCL pivotSpecification, @NonNull Operation contextOperation, @NonNull String resultName);
}