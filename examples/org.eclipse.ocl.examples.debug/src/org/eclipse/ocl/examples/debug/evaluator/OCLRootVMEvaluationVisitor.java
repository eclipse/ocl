/*******************************************************************************
 * Copyright (c) 2009,2012 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *     Christopher Gerking - bug 394498
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.evaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.core.OCLDebugCore;
import org.eclipse.ocl.examples.debug.stepper.OCLStepperVisitor;
import org.eclipse.ocl.examples.debug.vm.ConditionChecker;
import org.eclipse.ocl.examples.debug.vm.IVMDebuggerShell;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.VMBreakpoint;
import org.eclipse.ocl.examples.debug.vm.VMBreakpointManager;
import org.eclipse.ocl.examples.debug.vm.VMVirtualMachine;
import org.eclipse.ocl.examples.debug.vm.data.VMStackFrameData;
import org.eclipse.ocl.examples.debug.vm.evaluator.IRootVMEvaluationVisitor;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepperVisitor;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.event.VMResumeEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMStartEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMSuspendEvent;
import org.eclipse.ocl.examples.debug.vm.request.VMRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMResumeRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMSuspendRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMTerminateRequest;
import org.eclipse.ocl.examples.debug.vm.utils.ASTBindingHelper;
import org.eclipse.ocl.examples.debug.vm.utils.CompiledUnit;
import org.eclipse.ocl.examples.debug.vm.utils.DebugOptions;
import org.eclipse.ocl.examples.debug.vm.utils.VMInterruptedExecutionException;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.LoopExp;

public class OCLRootVMEvaluationVisitor extends OCLVMEvaluationVisitor implements IRootVMEvaluationVisitor<ExpressionInOCL>
{
	private final IVMDebuggerShell fDebugShell;
	private final @NonNull VMBreakpointManager fBPM;
	private UnitLocation fCurrentLocation;
	private final IterateBreakpointHelper fIterateBPHelper;
//	private final List<UnitLocation> fLocationStack;
	private int fCurrentStepMode;
	private @NonNull Stack<OCLVMEvaluationVisitor> visitorStack = new Stack<OCLVMEvaluationVisitor>();
	private @NonNull Stack<IStepper> stepperStack = new Stack<IStepper>();

	public OCLRootVMEvaluationVisitor(@NonNull OCLVMEnvironment env, @NonNull IOCLVMEvaluationEnvironment evalEnv, IVMDebuggerShell shell) {
		super(new OCLVMEvaluationVisitorImpl(env, evalEnv));
		fDebugShell = shell;
		fBPM = shell.getBreakPointManager();
		fIterateBPHelper = new IterateBreakpointHelper(fBPM);
//		fLocationStack = new ArrayList<UnitLocation>();
		fCurrentStepMode = DebugEvent.UNSPECIFIED;
		pushVisitor(this);
		fCurrentLocation = null; //getCurrentLocation();
//		UnitLocation newLocation = newLocalLocation((IDebugEvaluationEnvironment) evalEnv, transformation, ASTBindingHelper.getStartPosition(transformation)); //, getNodeLength(element));
//		setCurrentLocation(transformation, newLocation, false);

		fDebugShell.sessionStarted(this);

		VMRequest request = null; 
		try {
			// suspend to let others to wake up us on demand
			OCLDebugCore.TRACE.trace(DebugOptions.EVALUATOR,
			"Debug evaluator going to initial SUSPEND state"); //$NON-NLS-1$
			
			request = shell.waitAndPopRequest(new VMStartEvent(getMainModuleName(), true));
		} catch (InterruptedException e) {
			Thread.interrupted();
			terminate();
		}
		
		if (request instanceof VMResumeRequest) {
			fCurrentStepMode = ((VMResumeRequest)request).detail;
		}
		else {
			// TODO - decide a set of request we can handle during initial SUSPEND mode,
			// or report fError
			terminate();
		}
	}

	@Override
	protected @Nullable Object badVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv,
			@NonNull Element element, Object preState, @NonNull Throwable e) {
		if (!stepperStack.isEmpty()) {
			stepperStack.pop();
		}
		int endPosition = ASTBindingHelper.getEndPosition(element);
		UnitLocation endLocation = newLocalLocation(evalEnv, element, endPosition, endPosition); //, 1);
		setCurrentLocation(element, endLocation, true);
		suspendAndWaitForResume(endLocation, DebugEvent.BREAKPOINT);	// FIXME see if Interrupt BPt set
		if (e instanceof Exception) {
			throw (RuntimeException)e;
		}
		else {
			throw new RuntimeException(e);
		}
	}

	private @NonNull VMSuspendEvent createVMSuspendEvent(int eventDetail) {
		// build the VM stack frames
		VMStackFrameData[] vmStack = OCLVMVirtualMachine.createStackFrame(getLocationStack());		
		assert vmStack.length > 0;
		return new VMSuspendEvent(vmStack, eventDetail);
	}

	@Override
	public void dispose() {
		throw new UnsupportedOperationException();			// Root visitor never gets disposed.
	}
	
	private void doProcessRequest(UnitLocation location, VMRequest request) {
		if (VMVirtualMachine.VM_REQUEST.isActive()) {
			VMVirtualMachine.VM_REQUEST.println(">[" + Thread.currentThread().getName() + "] " + location.toString() + " " + request);
		}
		if (request instanceof VMResumeRequest) {
			VMResumeRequest resumeRequest = (VMResumeRequest) request;
			fCurrentLocation = getCurrentLocation();
			fCurrentStepMode = resumeRequest.detail;
			if (fCurrentStepMode == DebugEvent.UNSPECIFIED) {
				fIterateBPHelper.removeAllIterateBreakpoints();
			}
		} else if (request instanceof VMSuspendRequest) {
			VMSuspendRequest suspendRequest = (VMSuspendRequest) request;
			suspendAndWaitForResume(location, suspendRequest.detail);
		} else if (request instanceof VMTerminateRequest) {
			terminate();
		} else {
			throw new IllegalArgumentException("Unsupported debug request: " + request); //$NON-NLS-1$
		}
	}

	public @NonNull UnitLocation getCurrentLocation() {
		OCLVMEvaluationVisitor currentVisitor = visitorStack.peek();
		IVMEvaluationEnvironment<?> evaluationEnvironment = currentVisitor.getEvaluationEnvironment();
		return evaluationEnvironment.getCurrentLocation();
//		return fCurrentLocation;
	}

	public int getDepth() {
		return 1;
	}

	@Override
	public @NonNull IOCLVMEvaluationEnvironment getEvaluationEnvironment() {
		return (IOCLVMEvaluationEnvironment) super.getEvaluationEnvironment();
	}

	public @NonNull List<UnitLocation> getLocationStack() {
		List<UnitLocation> fLocationStack = new ArrayList<UnitLocation>();
		IVMEvaluationEnvironment<?> leafEvaluationEnvironment = visitorStack.peek().getEvaluationEnvironment();
		for (IVMEvaluationEnvironment<?> evaluationEnvironment = leafEvaluationEnvironment; evaluationEnvironment != null; evaluationEnvironment = evaluationEnvironment.getParentEvaluationEnvironment()) {
			Element element = evaluationEnvironment.getCurrentIP();
			IStepper stepper = getStepperVisitor().getStepper(element);
			UnitLocation unitLocation = stepper.createUnitLocation(evaluationEnvironment, element);
			fLocationStack.add(unitLocation);
		}
		return fLocationStack;
	}
	
	private @NonNull String getMainModuleName() {
		CompiledUnit mainUnit = fBPM.getUnitManager().getMainUnit();
		if (mainUnit.getModules().isEmpty()) {
			return "<null>"; //$NON-NLS-1$
		}
		return DomainUtil.nonNullState(mainUnit.getModules().get(0).getName());
	}

	public @NonNull OCLRootVMEvaluationVisitor getRootEvaluationVisitor() {
		return this;
	}

	@Override
	public @NonNull IStepperVisitor getStepperVisitor() {
		return OCLStepperVisitor.INSTANCE;
	}

	protected void handleLocationChanged(@NonNull Element  element, UnitLocation location, boolean isElementEnd) {
		if (VMVirtualMachine.LOCATION.isActive()) {
			VMVirtualMachine.LOCATION.println("[" + Thread.currentThread().getName() + "] " + element.eClass().getName() + ": " + element.toString() + " @ " + location + " " + (isElementEnd ? "start" : "end"));
		}
//		OCLVMEvaluationVisitor currentVisitor = visitorStack.peek();
//		UnitLocation fCurrentLocation = currentVisitor.getEvaluationEnvironment().getCurrentLocation();
//		if (fCurrentLocation == null) {
//			return;
//		}
		
//		ValidBreakpointLocator validbreakpointlocator = OCLDebuggableRunnerFactory.validBreakpointLocator;
//		if(false == (!isElementEnd ? validbreakpointlocator.isBreakpointableElementStart(element) : 
//			validbreakpointlocator.isBreakpointableElementEnd(element))) {
//			return;
//		}
		
		switch (fCurrentStepMode) {
		case DebugEvent.STEP_OVER:
			if (location.getStackDepth() <= fCurrentLocation.getStackDepth()
					&& (!location.isTheSameLine(fCurrentLocation)
						/*|| repeatedInIterator(location, fCurrentLocation)*/ )) {
				fCurrentLocation = null;
				suspendAndWaitForResume(location, fCurrentStepMode);
				return;
			}
			break;
		case DebugEvent.STEP_INTO:
			if (!location.isTheSameLocation(fCurrentLocation) /*|| repeatedInIterator(location, fCurrentLocation)*/) {
				fCurrentLocation = null;
				suspendAndWaitForResume(location, fCurrentStepMode);
				return;
			}
			break;
		case DebugEvent.STEP_RETURN:
			if (location.getStackDepth() < fCurrentLocation.getStackDepth()) {
				fCurrentLocation = null;
				suspendAndWaitForResume(location, fCurrentStepMode);
				return;
			}
			break;
		}

		// check if we trigger a registered breakpoint
		for (VMBreakpoint breakpoint : fBPM.getBreakpoints(element)) {	// FIXME Use Adapters to avoid potentially long loop
			if (breakpoint.getLineNumber() != location.getLineNum()) {
				 //TODO - faster to indicate in and or beginning enablement in VMBreakpoint ?
				//|| !((!isElementEnd) ? ValidBreakpointLocator.isBreakpointableElementStart(element) : 
					//ValidBreakpointLocator.isBreakpointableElementEnd(element))) {
				// no breakpoint can be triggered
				continue;
			}
					
			Boolean isTriggered = null;
			try {
				isTriggered = Boolean.valueOf(breakpoint.hitAndCheckIfTriggered(this));
			} catch(CoreException e) {
				IStatus status = e.getStatus();
				String reason = null; //$NON-NLS-1$
				if(status.getCode() == ConditionChecker.ERR_CODE_COMPILATION) {
					reason = "Breakpoint condition compilation failed";
				} else if(status.getCode() == ConditionChecker.ERR_CODE_EVALUATION) {
					reason = "Breakpoint condition evaluation failed";
				}
				
				if(reason != null) {
					// breakpoint condition parsing or evaluation failed, notify the debug client
					VMSuspendEvent suspendOnBpConditionErrr = createVMSuspendEvent(VMSuspendEvent.BREAKPOINT_CONDITION_ERR);
					suspendOnBpConditionErrr.setBreakpointID(breakpoint.getID());
					suspendOnBpConditionErrr.setReason(reason, status.getMessage());
					// suspend VM and wait for resolution by the debug client
					suspendAndWaitForResume(location, suspendOnBpConditionErrr);
				} else {
					OCLDebugCore.INSTANCE.log(e.getStatus());
				}
				
				continue;
			}
			
			if (Boolean.TRUE.equals(isTriggered)) {
				boolean isIterateBp = fIterateBPHelper.isIterateBreakpoint(breakpoint);
				int eventDetail = isIterateBp ? fCurrentStepMode : DebugEvent.BREAKPOINT;
				
				// let the VM suspend and wait for resume request
				suspendAndWaitForResume(location, eventDetail);

				if (isIterateBp) {
					fBPM.removeBreakpoint(breakpoint);
				}
			}
		}
		
	}

	private UnitLocation newLocalLocation(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element node, int startPosition, int endPosition) {
		return new UnitLocation(startPosition, endPosition, evalEnv, node);
	}

	public void popVisitor(@NonNull OCLNestedVMEvaluationVisitor evaluationVisitor) {
		if (VMVirtualMachine.VISITOR_STACK.isActive()) {
			VMVirtualMachine.VISITOR_STACK.println("[" + Thread.currentThread().getName() + "] " + "Pop " + evaluationVisitor.toString());
		}
		OCLVMEvaluationVisitor poppedVisitor = visitorStack.pop();
		assert poppedVisitor == evaluationVisitor;
	}

	public void postIterate(@NonNull LoopExp loopExp/*, Object preState */) {
//		if (preState instanceof VMBreakpoint) {
//			fIterateBPHelper.removeIterateBreakpoint((VMBreakpoint) preState);
//		}
	}

	protected void postVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element, @Nullable Element preState) {
		if (stepperStack.isEmpty()) {
			return;
		}
		stepperStack.pop();
		if (stepperStack.isEmpty()) {
			return;
		}
		IStepper parentStepper = stepperStack.peek();
		Element postElement = parentStepper.isPostStoppable(this, element, preState);
		if (postElement != null) {
			UnitLocation unitLocation = parentStepper.createUnitLocation(evalEnv, postElement);
			setCurrentLocation(postElement, unitLocation, false);
			processDebugRequest(unitLocation);
		}
/*		if (element instanceof ExpressionInOCL) {
			// 
		} else if (element instanceof LoopExp) {
			if (preState instanceof VMBreakpoint) {
				fIterateBPHelper.removeIterateBreakpoint((VMBreakpoint) preState);
			}
		} else {
			int endPosition = ASTBindingHelper.getEndPosition(element);
			UnitLocation el = newLocalLocation(evalEnv, element, endPosition - 1, endPosition); //, 1);
			
			setCurrentLocation(element, el, true);
		} */
	}

	public void preIterate(@NonNull LoopExp loopExp) {
		UnitLocation topLocation = getCurrentLocation();
		boolean skipIterate = (fCurrentStepMode == DebugEvent.UNSPECIFIED)
				|| ((fCurrentStepMode == DebugEvent.STEP_OVER) && 
					(topLocation.getStackDepth() > fCurrentLocation.getStackDepth()));

		if (!skipIterate) {
			/*return*/ fIterateBPHelper.stepIterateElement(loopExp, topLocation);
		}
	}

	protected @Nullable Element preVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element) {
		IStepper stepper = getStepperVisitor().getStepper(element);
		stepperStack.push(stepper);
		if (stepper.isPreStoppable(this, element)) {
			UnitLocation unitLocation = stepper.createUnitLocation(evalEnv, element);
			setCurrentLocation(element, unitLocation, false);
			processDebugRequest(unitLocation);
		}//?? peek terminate
		return null;
	}

	private void processDebugRequest(UnitLocation location) {
		VMRequest event = fDebugShell.popRequest();
		if (event == null) {
			return;
		}
		
		doProcessRequest(location, event);
	}

	public void pushVisitor(@NonNull OCLVMEvaluationVisitor evaluationVisitor) {
		if (VMVirtualMachine.VISITOR_STACK.isActive()) {
			VMVirtualMachine.VISITOR_STACK.println("[" + Thread.currentThread().getName() + "] " + "Push " + evaluationVisitor.toString());
		}
		assert !visitorStack.contains(evaluationVisitor);
		visitorStack.push(evaluationVisitor);
	}

	private void setCurrentLocation(@NonNull Element element, UnitLocation newLocation, boolean atEnd) {
//		if (fLocationStack.isEmpty()) {
//			return;
//		}

		// do not change to position-less locations
		if (newLocation.getStartPosition() < 0) {
			return;
		}

//		fLocationStack.set(0, newLocation);
		handleLocationChanged(element, newLocation, atEnd);
	}
	
	private void suspendAndWaitForResume(UnitLocation location, int eventDetail) {
		suspendAndWaitForResume(location, createVMSuspendEvent(eventDetail));
	}
	
	private void suspendAndWaitForResume(UnitLocation location, @NonNull VMSuspendEvent suspendEvent) {		
		try {			
			VMSuspendEvent vmSuspend = suspendEvent;
			
			// send to the client runner, wait for resume
			VMRequest nextRequest = fDebugShell.waitAndPopRequest(vmSuspend);			
			assert nextRequest != null;
			
			if(nextRequest instanceof VMResumeRequest) {
				fDebugShell.handleVMEvent(new VMResumeEvent());
			}

			doProcessRequest(location, nextRequest);
			
		} catch (InterruptedException e) {
			terminate();
		}
	}

	private void terminate() throws VMInterruptedExecutionException {
		IVMEvaluationEnvironment<?> evalEnv = getEvaluationEnvironment();
		evalEnv.throwVMException(new VMInterruptedExecutionException("User termination request"));
	}
}
