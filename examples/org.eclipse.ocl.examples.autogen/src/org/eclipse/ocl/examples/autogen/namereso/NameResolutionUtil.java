/**
 * Copyright (c) 2014 Willink Transformations, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		 Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation
 */
package org.eclipse.ocl.examples.autogen.namereso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


public class NameResolutionUtil {
	
	static public class AddingCallExp {
		
		private Type type;
		private int number;
		
		public AddingCallExp(Type addingExpType, int number){
			this.type = addingExpType;
			this.number = number;
			
		}

		public Type getType() {
			return type;
		}

		public int getNumber() {
			return number;
		}
	}
	public static Map<Type, List<AddingCallExp>> computeType2EnvAddingExps(@NonNull Package nameResoPackage) {
		
		
		Map<Type, List<AddingCallExp>> result = new LinkedHashMap<Type, List<AddingCallExp>>();
		for (Type type : nameResoPackage.getOwnedType()) {
			for (Operation op : type.getOwnedOperation()) {
				@SuppressWarnings("null")
				List<AddingCallExp> addingExpTypes = computeEnvOperation2EnvAddingExpTypes(op);
				result.put(type, addingExpTypes);
			}
		}
		return result;
	}
	
	public static List<AddingCallExp> computeEnvOperation2EnvAddingExpTypes(@NonNull Operation envOp) {
		return isEnvOperation(envOp) ? getEnvOpAddingExpTypes(envOp) : Collections.<AddingCallExp>emptyList();
	}
	
	
	public static Map<Type, List<Operation>> computeType2EnvOperations(@NonNull Package nameResoPackage) {
		
		Map<Type, List<Operation>> result = new LinkedHashMap<Type, List<Operation>>();
		for (Type type : nameResoPackage.getOwnedType()) {
			for (Operation op : type.getOwnedOperation()) {
				if (isEnvOperation(op)) {
					List<Operation> envOps = result.get(type);					
					if (envOps == null) {
						envOps = new ArrayList<Operation>();
						result.put(type, envOps);
					}
					envOps.add(op);
				}
			}
		}
		return result;
	}
	
	
	/**
	 * returns the list of types of the expressions involved in the addElement operation call expression contained by
	 * the given ExpressionInOCL.
	 * 
	 * Although it's not checked, the provided {@link Operation} should be an _env() operation
	 * involved in a name resolution description.
	 * 
	 * If the type of two different "adding" ocl expressions appears twice, such a type would be added twice
	 *  
	 * @param map the map to update
	 * @param exp the expressionInOCL  
	 */
	private static List<AddingCallExp> getEnvOpAddingExpTypes(Operation envOp) {
		
		List<AddingCallExp> addingExpTypes = new ArrayList<AddingCallExp>();		
		OpaqueExpression opaqueExp = envOp.getBodyExpression();
		if (opaqueExp != null) {			
			ExpressionInOCL exp = PivotUtil.getExpressionInOCL(envOp, opaqueExp);
			if (exp != null) {
				TreeIterator<EObject> contents =  exp.eAllContents();
				int addingCallExpNumber = 0;
				while (contents.hasNext()) {
					EObject element = contents.next();
					if (element instanceof OperationCallExp){
						OperationCallExp opCall = (OperationCallExp) element;
						if (isAddingElementOperationCallExp(opCall)) {
							for (OCLExpression argument : opCall.getArgument()) { // FIXME Should only have one. Check if many ?
								// note that the same type could be correctly added many times.
								addingExpTypes.add(new AddingCallExp(argument.getType(), addingCallExpNumber++)); 
							}
						}
					}
				}	
			}
		}
		return addingExpTypes;		
	}

	public static boolean isEnvOperation(Operation op) {
		String opName = op.getName();
		return opName != null && opName.contains("_env");
	}
	
	public static boolean isAddOperation(Operation op) {
		String opName = op.getName();
		if (opName == null || !opName.startsWith("addElement")) {
			return false;
		}
		
		// Improving the heuristic by ensuring that the operation is from the 
		// Enviroment Class
		Type owningType = op.getOwningType();
		String typeName = owningType.getName();
		
		if (!"Environment".equals(typeName)) {
			return false;
		}
		
		return true;
	}
	
	@SuppressWarnings("null")
	@NonNull
	public static String getEnvOpPropertyName(Operation op) {
		
		String opName = op.getName();
		int _envIndex = opName.indexOf("_env");
		return _envIndex <= 0 ? "" : opName.substring(0, _envIndex);
		
	}
	
	/**
	 * Iterates the content tree of the given {@link OCLExpression} and returns
	 * an iterable of all {@link OperationCallExp} corresponding to the addElement/s
	 * operation
	 * @param oclExp
	 * @return
	 */
	public static Iterable<OperationCallExp> getAddElementCallExps(OCLExpression oclExp) {
		ArrayList<OperationCallExp> result = new ArrayList<OperationCallExp>();
		for (EObject child : oclExp.eContents()) {
			if (child instanceof OperationCallExp) {
				OperationCallExp opCall = (OperationCallExp) child;
				if (isAddingElementOperationCallExp(opCall)) {
					result.add(opCall);
				}
			}
		}
		return result;
	}
	
	private static boolean isAddingElementOperationCallExp(OperationCallExp opCallExp) {
		Operation op = opCallExp.getReferredOperation();
		return op == null ? false : isAddOperation(op);		
	}
}
