/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.evaluator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.core.OCLDebugCore;
import org.eclipse.ocl.examples.debug.core.OCLEvaluationContext;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.VMVirtualMachine;
import org.eclipse.ocl.examples.debug.vm.VariableFinder;
import org.eclipse.ocl.examples.debug.vm.data.VMStackFrameData;
import org.eclipse.ocl.examples.debug.vm.data.VMVariableData;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.launching.DebuggableRunner;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;

public class OCLVMVirtualMachine extends VMVirtualMachine
{
	public static VMStackFrameData[] createStackFrame(List<UnitLocation> stack) {
		List<VMStackFrameData> result = new ArrayList<VMStackFrameData>();
		
		int i = 0;
		for (UnitLocation location : stack) {
			// include variables only for the current (top level) stack
			if (location != null) {
				result.add(createStackFrame(location, i++ == 0));
			}
		}

		return result.toArray(new VMStackFrameData[result.size()]);
	}
	
	public VMStackFrameData createStackFrame(@NonNull UnitLocation location) {
		return createStackFrame(location, true);
	}
	
	private static @NonNull VMStackFrameData createStackFrame(@NonNull UnitLocation location, boolean includeVars) {
		IVMEvaluationEnvironment<?> evalEnv = location.getEvalEnv();
		Root module = location.getModule();
		String moduleName = (module != null) ? DomainUtil.nonNullState(module.getName()) : "<null>"; //$NON-NLS-1$
		
		NamedElement operation = location.getOperation();
		String operSignature = (operation != null) ? getElementSignature(operation)
				: null; //MessageFormat.format("<{0}>", moduleName); //$NON-NLS-1$
		
		List<VMVariableData> vars = VariableFinder.getVariables(evalEnv);
		String uriString = DomainUtil.nonNullState(location.getURI().toString());
		@SuppressWarnings("null")@NonNull VMVariableData[] varsArray = vars.toArray(new VMVariableData[vars.size()]);
		VMStackFrameData vmStackFrame = new VMStackFrameData(evalEnv.getID(), uriString, moduleName, 
					operSignature, location.getLineNum(), location.getStartPosition(), location.getEndPosition(), varsArray);
		return vmStackFrame;
	}
	
	private static @NonNull String getElementSignature(@NonNull NamedElement operation) {
        StringBuilder buf = new StringBuilder();
        if (operation instanceof ExpressionInOCL) {
        	buf.append(PrettyPrinter.print(operation));
        }
        else if (operation instanceof OCLExpression) {
        	buf.append(PrettyPrinter.print(operation));
        }
        else {
	        buf.append(operation.getName());        
	        buf.append('(');
	        if (operation instanceof Operation) {
		        boolean isFirst = true;;
		        for (Parameter param : ((Operation)operation).getOwnedParameter()) {
		            if (!isFirst) {
		                buf.append(", ");
		            }
		            Type type = param.getType();
		            buf.append(type.getName());            
		            isFirst = false;
		        }
	        }
	//        else if (operation instanceof Mapping) {
	/*	        boolean isFirst = true;;
		        for (Variable param : ((Mapping)operation).getAllVariables()) {
		            if (!isFirst) {
		                buf.append(", ");
		            }
		            Type type = param.getType();
		            buf.append(type.getName());            
		            isFirst = false;
		        } */
	//        }
	        buf.append(')');
        }
        @SuppressWarnings("null")@NonNull String string = buf.toString();
		return string;
    }

	public OCLVMVirtualMachine(@NonNull DebuggableRunner runner, @NonNull OCLEvaluationContext evaluationContext) {
		super(runner, runner.createDebuggableAdapter(evaluationContext));
	}

	@Override
	public @NonNull OCLDebugCore getDebugCore() {
		return OCLDebugCore.INSTANCE;
	}	
}
