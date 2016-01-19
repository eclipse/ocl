/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.lookup;/*******************************************************************************

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *******************************************************************************/


import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.util.PivotUnqualifiedLookupVisitor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;


/**
 * @since 1.1
 */
public class PivotNameResolver  extends AbstractPivotNameResolver {

	
	public PivotNameResolver(@NonNull EnvironmentFactory mmManager) {
		super(mmManager);
	}

	@Override
	protected @NonNull
	PivotUnqualifiedLookupVisitor createLookupVisitor(@NonNull LookupEnvironment env) {
		return new PivotLookupVisitor(envFactory, env);
	};
	
	@Override
	public @NonNull
	SingleResultEnvironment computeReferredOperationLookup(@NonNull OperationCallExp opCallExp) {
		//@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION;
		String name = opCallExp.getName();
		Type sourceType = PivotUtilInternal.getType(opCallExp.getOwnedSource());
		
		if (name == null // FIXME adolfosbh can we assume well-formedness of the opCallExp ?
			|| sourceType == null ) {
			return createLookupEnvironment(envFactory,  opCallExp, "") ; // Empty result
		}
		SingleResultLookupEnvironment env = createLookupEnvironment(envFactory, opCallExp, name);
		// env.addFilter(filter);
		return computeNamedResult(sourceType, env);
	}
	
	@Override
	public 	@NonNull
	SingleResultEnvironment computeReferredIterationLookup(@NonNull IteratorExp iteratorExp) {
		//@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.LOOP_EXP__REFERRED_ITERATION;;
		String name =  iteratorExp.getName();
		Type sourceType = PivotUtilInternal.getType(iteratorExp.getOwnedSource());
		if (name == null // FIXME adolfosbh can we assume well-formedness of the iteratorExp ?
			|| !(sourceType instanceof CollectionType)) { 
			return createLookupEnvironment(envFactory, iteratorExp, "") ; // Empty result
		}
		SingleResultLookupEnvironment env = createLookupEnvironment(envFactory, iteratorExp, name);
		// env.addFilter(filter);
		return computeNamedResult(sourceType, env);
	}

	@Override
	
	public @NonNull
	SingleResultEnvironment computeReferredVariableLookup(
			@NonNull VariableExp variableExp) {
		String name = variableExp.getName();
		if (name == null) {  // FIXME adolfosbh can we assume well-formedness of the expression ?
			return createLookupEnvironment(envFactory, variableExp, "") ; // Empty result
		}
		SingleResultLookupEnvironment env = createLookupEnvironment(envFactory, variableExp, name);
		return computeNamedResult(variableExp, env);		
	}
	
}
