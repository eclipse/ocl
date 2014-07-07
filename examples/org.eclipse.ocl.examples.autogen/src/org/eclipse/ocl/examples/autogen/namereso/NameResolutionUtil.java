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
import java.util.HashMap;
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
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;


public class NameResolutionUtil {
	
	public static Map<Type, List<Property>> computeType2EnvAddingFeatures(@NonNull Package nameResoPackage) {
		
		Map<Type, List<Property>> result = new HashMap<Type, List<Property>>();
		for (Type type : nameResoPackage.getOwnedType()) {
			for (Operation op : type.getOwnedOperation()) {
				if (isEnvOperation(op)) {
					OpaqueExpression opaqueExp = op.getBodyExpression();
					if (opaqueExp != null) {
						ExpressionInOCL exp = PivotUtil.getExpressionInOCL(op, opaqueExp);
						updateMapWithAddElementProperties(result, exp);
					}
				}
			}
		}
		return result;
	}
	
	
	/**
	 * Updates the map with the properties involved in the addElement operation call expression contained by
	 * the given ExpressionInOCL.
	 * 
	 * Although it's not checked, the provided {@link ExpressionInOCL} should be the body of an _env() operation
	 * involved in a name resolution description
	 *  
	 * @param map the map to update
	 * @param exp the expressionInOCL  
	 */
	private static void updateMapWithAddElementProperties(Map<Type, List<Property>> map, ExpressionInOCL exp) {

		TreeIterator<EObject> contents =  exp.eAllContents();
		while (contents.hasNext()) {
			EObject element = contents.next();
			if (element instanceof OperationCallExp){
				OperationCallExp opCall = (OperationCallExp) element;
				if (isAddingElementOperationCallExp(opCall)) {
					for (OCLExpression argument : opCall.getArgument()) {
						// We are interested in the last property call exp of a potentially complex navigation FIXME
						// TODO what if we have a final oclAsType() conversion ?
						// TODO what todo with the ScopeFilters
						if (argument instanceof PropertyCallExp) {
							Property referredProp = ((PropertyCallExp) argument).getReferredProperty();
							Type propOwningType = referredProp.getOwningType();
							List<Property> addElementProp = map.get(propOwningType);
							if (addElementProp == null) {
								addElementProp = new ArrayList<Property>();
								map.put(propOwningType, addElementProp);
							}
							if (!addElementProp.contains(referredProp)) {
								addElementProp.add(referredProp);
							}
						}
					}
				}
			}
		}
	}

	public static boolean isEnvOperation(Operation op) {
		String opName = op.getName();
		return opName != null && opName.contains("_env");
	}
	
	public static boolean isAddOperation(Operation op) {
		String opName = op.getName();
		if (opName == null || !opName.startsWith("AddElement")) {
			return false;
		}
		
		// Improving the heuristic by ensuring that the operation is from the 
		// Enviroment Class
		Type owningType = op.getOwningType();
		String typeName = owningType.getName();
		
		if (typeName == null || !opName.startsWith("Environment")) {
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
	
	
	private static boolean isAddingElementOperationCallExp(OperationCallExp opCallExp) {
		String opCallName = PivotUtil.getSafeName(opCallExp.getReferredOperation());
		return opCallName.equals("addElement") || opCallName.equals("addElements");
	}
}
