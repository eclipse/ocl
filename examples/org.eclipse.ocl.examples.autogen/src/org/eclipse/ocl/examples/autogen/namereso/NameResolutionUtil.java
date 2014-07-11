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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
	
	/**
	 * Class used to compute the name of the API methods to add element to the environments
	 * 
	 * It will comprise the type of the argument of an adding operation (see {@link NameResolutionUtil#isAddOperation(Operation)}) 
	 * call expression and a number associated with the number the adding call expression
	 * present in any _env operation of the the corresponding context type
	 * 
	 * The third constructor argument hasChildren indicates enacts the index based children environment configuration
	 * whose description will take into account the position of the child when making named elements available
	 * in the environment at that point.   
	 * 
	 */
	static public class AddingCallArgExpType {
		
		private Type type;
		private int number;
		private boolean hasChildIndex;
		
		public AddingCallArgExpType(Type addingExpType, int number, boolean hasChildIndex){
			this.type = addingExpType;
			this.number = number;
			this.hasChildIndex = hasChildIndex;
		}

		public Type getType() {
			return type;
		}

		public int getNumber() {
			return number;
		}

		public boolean isHasChildIndex() {
			return hasChildIndex;
		}
	}
	
	/**
	 * 
	 * @param nameResoPackage the name resolution description {@link Package} 
	 * @return map associating context types and the contained {@link AddingCallArgExpType}s
	 */
	public static Map<Type, List<AddingCallArgExpType>> computeType2EnvAddingExps(@NonNull Package nameResoPackage) {
		
		
		Map<Type, List<AddingCallArgExpType>> result = new LinkedHashMap<Type, List<AddingCallArgExpType>>();
		for (Type type : nameResoPackage.getOwnedType()) {
			List<AddingCallArgExpType> addingExpTypes = getEnvOpAddingExpTypes(type, type.getOwnedOperation());
			result.put(type, addingExpTypes);
		}
		return result;
	}
	
	/**
	 * @param envOp An _env operation . It's checked that the provided operation is really an _env operation {@link NameResolutionUtil#isEnvOperation(Operation)} 
	 * @return the {@link AddingCallArgExpType} contained by the provided _env operation
	 */
	public static List<AddingCallArgExpType> computeEnvOperation2EnvAddingExpTypes(@NonNull Operation envOp) {
		return isEnvOperation(envOp) ? getEnvOpAddingExpTypes(envOp.getOwningType(), Collections.singletonList(envOp)) 
			: Collections.<AddingCallArgExpType>emptyList();
	}
	
	
	/**
	 * @param nameResoPackage
	 * @return map associating context types and the contained _env operations
	 */
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
	 * Returns the list of types of the expressions involved in the addElement operation call expression contained by
	 * any of the given environment ops.
	 * 
	 * Although it's not checked, the provided {@link Operation} should be an _env() operation
	 * involved in a name resolution description.
	 * 
	 * The context is needed because all the operations need to be traversed to use the proper number
	 * for the {@link AddingCallArgExpType} to create
	 * 
	 * If the type of two different "adding" ocl expressions appears twice, such a type would be added twice
	 *  
	 * @param context the context in which adding call expressions will be added
	 * @param envOps a list of operations for which 
	 */
	private static List<AddingCallArgExpType> getEnvOpAddingExpTypes(Type context, List<Operation> envOps) {
		
		
		List<AddingCallArgExpType> addingExpTypes = new ArrayList<AddingCallArgExpType>();
		int addingCallExpNumber = 0;
		for (Operation envOp : context.getOwnedOperation()) {
			OpaqueExpression opaqueExp = envOp.getBodyExpression();
			if (opaqueExp != null) {			
				ExpressionInOCL exp = PivotUtil.getExpressionInOCL(envOp, opaqueExp);
				if (exp != null) {
					boolean opHasChildIndexArg = envOp.getOwnedParameter().size() == 2; // TODO check other cases ?
					TreeIterator<EObject> contents =  exp.eAllContents();
					while (contents.hasNext()) {
						EObject element = contents.next();
						if (element instanceof OperationCallExp){
							OperationCallExp opCall = (OperationCallExp) element;
							if (isAddingElementOperationCallExp(opCall)) {								
								if (envOps.contains(envOp)) { // If the envOp if our interest
									for (OCLExpression argument : opCall.getArgument()) { // FIXME Should only have one. Check if many ?
										// note that the same type could be correctly added many times.
										addingExpTypes.add(new AddingCallArgExpType(argument.getType(),addingCallExpNumber, opHasChildIndexArg)); 
									}
								}
								addingCallExpNumber++;
							}
						}
					}	
				}
			}
		}
		
				
		
		return addingExpTypes;		
	}

	/**
	 * To check if an operation correspond to environment operation (aka _env), that is,
	 * with a description to describe how the owning context element
	 * configures the enviroment for name resolution. 
	 * 
	 * Logic to determine if the provided operation is an _env one: 
	 * <ol> 
	 * <li> the name of the provided operation contains the string _env
	 * </ol>
	 * 
	 * @param op any {@link Operation}
	 * @return true if the provided operation is an _env one
	 */
	public static boolean isEnvOperation(Operation op) {
		String opName = op.getName();
		return opName != null && opName.contains("_env");
	}
	

	/**
	 * Logic to determine if the provided operation is an environment adding operation: 
	 * <ol> 
	 * <li> the name of the provided operation startis with the string addElement </li>
	 * <li> It's contained by a Class whose name is "Environment" </li>
	 * </ol>
	 * @param op
	 * @return
	 */
	public static boolean isAddOperation(Operation op) {
		String opName = op.getName();
		if (opName == null || !opName.startsWith("addElement")) {
			return false;
		}
		
		// Improving the Logic by ensuring that the operation is from an 
		// Enviroment Class (TB Improved)
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
		
	public static boolean hasNestedEnvCall(Operation op) {
	
		if (isEnvOperation(op)) {
			OpaqueExpression opaqueExp = op.getBodyExpression();
			if (opaqueExp != null) {			
				ExpressionInOCL exp = PivotUtil.getExpressionInOCL(op, opaqueExp);
				if (exp != null) {
					TreeIterator<EObject> it = EcoreUtil.getAllContents(exp, true); 
					while (it.hasNext()) {
						EObject child = it.next();
						if (child instanceof OperationCallExp) {
							if (isNestedEnvOperationCallExp((OperationCallExp) child)) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
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
		TreeIterator<EObject> it = EcoreUtil.getAllContents(oclExp, true); 
		while (it.hasNext()) {
			EObject child = it.next();
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
	
	private static boolean isNestedEnvOperationCallExp(OperationCallExp opCallExp) {
		Operation op = opCallExp.getReferredOperation();
		return op == null ? false : isNestedEnvOperation(op);		
	}
	
	/**
	 * Logic to determine if the provided operation is an environment adding operation: 
	 * <ol> 
	 * <li> the name of the provided operation is "nestedEnv" </li>
	 * <li> It's contained by a Class whose name is "Environment" </li>
	 * </ol>
	 * @param op
	 * @return
	 */
	private static boolean isNestedEnvOperation(Operation op) {
		
		String opName = op.getName();
		if (!"nestedEnv".equals(opName)){
			return false;
		}
		
		// Improving the Logic by ensuring that the operation is from an 
		// Enviroment Class (TB Improved)
		Type owningType = op.getOwningType();
		String typeName = owningType.getName();
		
		if (!"Environment".equals(typeName)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * In a name resolution description, the context type may contain different
	 * _env operations. If the  _env operation name is prefixed with a name (e.g xxxx_env),
	 * it means that the context type will configure the enviroment when a lookup propagation
	 * comes from a children element contained via a xxxx containment reference of the context
	 * element which is configuring the environment.
	 * 
	 * This function will check if any of the provided operations follow this xxxx_env pattern
	 * 
	 */
	public static boolean isChildrenBasedEnvOperations(@NonNull List<Operation> operations) {
		for (Operation operation : operations) {
			if (operation != null) {
				if (isChildBasedEnvOperation(operation)) {
					return true;
				}	
			}
		}
		return false;
	}
	
//	public static boolean hasGenericEnvOperations(@NonNull List<Operation> operations) {
//		for (Operation operation : operations) {
//			if (operation != null) {
//				if (isGenericEnvOperation(operation)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	
	/**
	 * In a name resolution description, the context type may contain different
	 * _env operations. If the  _env operation name is prefixed with a name (e.g xxxx_env),
	 * it means that the context type will configure the enviroment when a lookup propagation
	 * comes from a children element contained via a xxxx containment reference of the context
	 * element which is configuring the environment.
	 * 
	 * This function will check that the provided operation follows this xxxx_env pattern 
     *
	 */
	public static boolean isChildBasedEnvOperation(@NonNull Operation operation) {
		String opName = operation.getName();
		if (opName == null) {
			return false;
		}
		int _envIndex = opName.indexOf("_env");
		return _envIndex > 0;
	}
	
	
	public static boolean isGenericEnvOperation(@NonNull Operation operation) {
		String opName = operation.getName();
		if (opName == null) {
			return false;
		}
		int _envIndex = opName.indexOf("_env");
		return _envIndex == 0;
	}
}
