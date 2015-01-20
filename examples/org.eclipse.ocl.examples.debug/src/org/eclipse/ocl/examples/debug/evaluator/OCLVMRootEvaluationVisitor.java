/*******************************************************************************
 * Copyright (c) 2009, 2014 R.Dvorak and others.
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.core.OCLDebugCore;
import org.eclipse.ocl.examples.debug.stepper.AbstractStepper;
import org.eclipse.ocl.examples.debug.stepper.OCLStepperVisitor;
import org.eclipse.ocl.examples.debug.vm.ConditionChecker;
import org.eclipse.ocl.examples.debug.vm.IVMDebuggerShell;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.VMBreakpoint;
import org.eclipse.ocl.examples.debug.vm.VMBreakpointManager;
import org.eclipse.ocl.examples.debug.vm.VMVirtualMachine;
import org.eclipse.ocl.examples.debug.vm.data.VMStackFrameData;
import org.eclipse.ocl.examples.debug.vm.data.VMSuspension;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepperVisitor;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMRootEvaluationVisitor;
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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class OCLVMRootEvaluationVisitor extends AbstractOCLVMEvaluationVisitor implements IVMRootEvaluationVisitor<ExpressionInOCL>
{
	private final @NonNull IVMDebuggerShell fDebugShell;
	private final @NonNull VMBreakpointManager fBPM;
	
	/**
	 * The location currently displayed at the top of the stack.
	 * Updated when handleLocationChanged invokes suspendAndWaitForResume.
	 */
	private @NonNull UnitLocation fCurrentLocation;
	private final @NonNull IterateBreakpointHelper fIterateBPHelper;
//	private final List<UnitLocation> fLocationStack;
	private @NonNull VMSuspension fCurrentStepMode;
	private final @NonNull Stack<AbstractOCLVMEvaluationVisitor> visitorStack = new Stack<AbstractOCLVMEvaluationVisitor>();
	private final @NonNull Variable invalidVariable;

	public OCLVMRootEvaluationVisitor(@NonNull IOCLVMEvaluationEnvironment evalEnv, @NonNull IVMDebuggerShell shell) {
		super(new OCLVMEvaluationVisitor(evalEnv));
		fDebugShell = shell;
		fBPM = shell.getBreakPointManager();
		fIterateBPHelper = new IterateBreakpointHelper(fBPM);
//		fLocationStack = new ArrayList<UnitLocation>();
		fCurrentStepMode = VMSuspension.UNSPECIFIED;
		pushVisitor(this);
		fCurrentLocation = getCurrentLocation();
		invalidVariable = ClassUtil.nonNullEMF(PivotFactory.eINSTANCE.createVariable());
		invalidVariable.setName("$invalid");
		String typeName = ClassUtil.nonNullEMF(PivotPackage.Literals.OCL_EXPRESSION.getName());
		invalidVariable.setType(getEnvironmentFactory().getMetamodelManager().getASClass(typeName));
	}

	@Override
	protected @Nullable Object badVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv,
			@NonNull Element element, Object preState, @NonNull Throwable e) {
		Stack<IVMEvaluationEnvironment.StepperEntry> stepperStack = evalEnv.getStepperStack();
		if (!stepperStack.isEmpty()) {
			stepperStack.pop();
		}
		evalEnv.add(invalidVariable, e);
		int endPosition = ASTBindingHelper.getEndPosition(element);
		UnitLocation endLocation = newLocalLocation(evalEnv, element, endPosition, endPosition); //, 1);
		setCurrentLocation(element, endLocation, true);
		suspendAndWaitForResume(endLocation, VMSuspension.BREAKPOINT);	// FIXME see if Interrupt BPt set
		if (e instanceof Exception) {
			throw (RuntimeException)e;
		}
		else {
			throw new RuntimeException(e);
		}
	}

	private @NonNull VMSuspendEvent createVMSuspendEvent(@NonNull VMSuspension suspension) {
		// build the VM stack frames
		VMStackFrameData[] vmStack = OCLVMVirtualMachine.createStackFrame(getLocationStack());		
		assert vmStack.length > 0;
		return new VMSuspendEvent(vmStack, suspension);
	}

	@Override
	public void dispose() {
		throw new UnsupportedOperationException();			// Root visitor never gets disposed.
	}
	
	private void doProcessRequest(@NonNull UnitLocation location, @NonNull VMRequest request) {
		if (VMVirtualMachine.VM_REQUEST.isActive()) {
			VMVirtualMachine.VM_REQUEST.println(">[" + Thread.currentThread().getName() + "] " + location.toString() + " " + request);
		}
		if (request instanceof VMResumeRequest) {
			VMResumeRequest resumeRequest = (VMResumeRequest) request;
//			fCurrentLocation = getCurrentLocation();
//			fCurrentLocation = fCurrentStepMode == VMSuspension.STEP_INTO ? null : getCurrentLocation();
			fCurrentStepMode = resumeRequest.suspension;
			if (fCurrentStepMode == VMSuspension.UNSPECIFIED) {
				fIterateBPHelper.removeAllIterateBreakpoints();
			}
		} else if (request instanceof VMSuspendRequest) {
			VMSuspendRequest suspendRequest = (VMSuspendRequest) request;
			suspendAndWaitForResume(location, suspendRequest.suspension);
		} else if (request instanceof VMTerminateRequest) {
			terminate();
		} else {
			throw new IllegalArgumentException("Unsupported debug request: " + request); //$NON-NLS-1$
		}
	}

	public @NonNull UnitLocation getCurrentLocation() {
		AbstractOCLVMEvaluationVisitor currentVisitor = visitorStack.peek();
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
		List<NamedElement> modules = mainUnit.getModules();
		if (modules.isEmpty()) {
			return "<null>"; //$NON-NLS-1$
		}
		String name = modules.get(0).getName();
		if (name == null) {
			return "<null>"; //$NON-NLS-1$
		}
		return ClassUtil.nonNullState(name);
	}

	public @NonNull OCLVMRootEvaluationVisitor getRootEvaluationVisitor() {
		return this;
	}

	@Override
	public @NonNull IStepperVisitor getStepperVisitor() {
		return OCLStepperVisitor.INSTANCE;
	}

	protected void handleLocationChanged(@NonNull Element  element, @NonNull UnitLocation location, boolean isElementEnd) {
		if (VMVirtualMachine.LOCATION.isActive()) {
			VMVirtualMachine.LOCATION.println("[" + Thread.currentThread().getName() + "] " + element.eClass().getName() + ": " + element.toString() + " @ " + location + " " + (isElementEnd ? "start" : "end"));
		}
//		UnitLocation fCurrentLocation = this.fCurrentLocation;;
//		if (fCurrentLocation == null) {
//			OCLVMEvaluationVisitor currentVisitor = visitorStack.peek();
//			fCurrentLocation = currentVisitor.getEvaluationEnvironment().getCurrentLocation();
//		}
//		if (fCurrentLocation == null) {
//			return;
//		}
		
//		ValidBreakpointLocator validbreakpointlocator = OCLDebuggableRunnerFactory.validBreakpointLocator;
//		if(false == (!isElementEnd ? validbreakpointlocator.isBreakpointableElementStart(element) : 
//			validbreakpointlocator.isBreakpointableElementEnd(element))) {
//			return;
//		}
		boolean doSuspendAndResume = false;
		if (fCurrentStepMode == VMSuspension.STEP_INTO) {
			doSuspendAndResume = true;
		}
		else if (fCurrentStepMode == VMSuspension.STEP_OVER) {
			if (isSmallerStackDepth(location) || isNewLine(location) /*|| repeatedInIterator(location, fCurrentLocation)*/ ) {
				doSuspendAndResume = true;
			}
		}
		else if (fCurrentStepMode == VMSuspension.STEP_RETURN) {
			if (isSmallerStackDepth(location)) {
				doSuspendAndResume = true;
			}
		}
		if (doSuspendAndResume) {
			suspendAndWaitForResume(location, fCurrentStepMode);
			return;
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
					VMSuspendEvent suspendOnBpConditionErrr = createVMSuspendEvent(VMSuspension.BREAKPOINT_CONDITION_ERR);
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
				VMSuspension vmSuspension = isIterateBp ? fCurrentStepMode : VMSuspension.BREAKPOINT;
				
				// let the VM suspend and wait for resume request
				suspendAndWaitForResume(location, vmSuspension);

				if (isIterateBp) {
					fBPM.removeBreakpoint(breakpoint);
				}
			}
		}
		
	}

	/**
	 * Return true if a call (stack push) has occurred on location wrt the last displayed location.
	 */
	protected boolean isLargerStackDepth(@NonNull UnitLocation location) {
		return location.getStackDepth() > fCurrentLocation.getStackDepth();
	}

	/**
	 * Return true if a line change has occurred on location wrt the last displayed location.
	 */
	protected boolean isNewLine(@NonNull UnitLocation location) {
		return !location.isTheSameLine(fCurrentLocation);
	}

	/**
	 * Return true if a position change has occurred on location wrrt the last displayed location.
	 */
	protected boolean isNewLocation(@NonNull UnitLocation location) {
		return !location.isTheSameLocation(fCurrentLocation);
	}

	/**
	 * Return true if a return (stack pop) has occurred on location wrt the last displayed location.
	 */
	protected boolean isSmallerStackDepth(@NonNull UnitLocation location) {
		return location.getStackDepth() < fCurrentLocation.getStackDepth();
	}

	private @NonNull UnitLocation newLocalLocation(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element node, int startPosition, int endPosition) {
		return new UnitLocation(startPosition, endPosition, evalEnv, node);
	}

	public void popVisitor(@NonNull OCLVMNestedEvaluationVisitor evaluationVisitor) {
		if (VMVirtualMachine.VISITOR_STACK.isActive()) {
			VMVirtualMachine.VISITOR_STACK.println("[" + Thread.currentThread().getName() + "] " + "Pop " + evaluationVisitor.toString());
		}
		AbstractOCLVMEvaluationVisitor poppedVisitor = visitorStack.pop();
		assert poppedVisitor == evaluationVisitor;
	}

	public void postIterate(@NonNull LoopExp loopExp/*, Object preState */) {
//		if (preState instanceof VMBreakpoint) {
//			fIterateBPHelper.removeIterateBreakpoint((VMBreakpoint) preState);
//		}
	}

	protected void postVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element, @Nullable Object result) {
		Stack<IVMEvaluationEnvironment.StepperEntry> stepperStack = evalEnv.getStepperStack();
		if (stepperStack.isEmpty()) {
			return;
		}
		IStepper parentStepper = null;
		EObject eContainer = element.eContainer();
		Element parentElement = eContainer instanceof Element ? (Element)eContainer : null;
		IVMEvaluationEnvironment.StepperEntry childStepperEntry = stepperStack.pop();
		childStepperEntry.popFrom(evalEnv);
		if (!stepperStack.isEmpty()) {
			IVMEvaluationEnvironment.StepperEntry parentStepperEntry = stepperStack.peek();
			if (element instanceof OCLExpression) { // NB not Variable
				parentStepperEntry.pushTo(evalEnv, (TypedElement) element, result);
			}
			parentStepper = parentStepperEntry.stepper;
		}
		else if (evalEnv != getEvaluationEnvironment()) {		// Looping
			if (parentElement != null) {
				parentStepper = getStepperVisitor().getStepper(parentElement);
			}
		}
		if (parentStepper != null) {
			Element postElement = parentStepper.isPostStoppable(this, element, result);
			if (postElement != null) {
				evalEnv.setCurrentIP(postElement);
				evalEnv.replace(evalEnv.getPCVariable(), postElement);
				evalEnv.remove(invalidVariable);
				UnitLocation unitLocation = parentStepper.createUnitLocation(evalEnv, postElement);
				setCurrentLocation(postElement, unitLocation, false);
				processDebugRequest(unitLocation);
			}
		}
	}

	public void preIterate(@NonNull LoopExp loopExp) {
		UnitLocation topLocation = getCurrentLocation();
		boolean skipIterate = (fCurrentStepMode == VMSuspension.UNSPECIFIED)
				|| ((fCurrentStepMode == VMSuspension.STEP_OVER) && isLargerStackDepth(topLocation));

		if (!skipIterate) {
			/*return*/ fIterateBPHelper.stepIterateElement(loopExp, topLocation);
		}
	}

	protected @Nullable Element preVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element) {
		Stack<IVMEvaluationEnvironment.StepperEntry> stepperStack = evalEnv.getStepperStack();
		IStepper stepper = getStepperVisitor().getStepper(element);
		stepperStack.push(new IVMEvaluationEnvironment.StepperEntry(stepper, element));
		if (stepper.isPreStoppable(this, element)) {
			if (stepper instanceof AbstractStepper) {
				Element firstElement = ((AbstractStepper)stepper).getFirstElement(this, element);
				if (firstElement != null) {
					element = firstElement;
				}
			}
			evalEnv.setCurrentIP(element);
			evalEnv.replace(evalEnv.getPCVariable(), element);
			evalEnv.remove(invalidVariable);
			UnitLocation unitLocation = stepper.createUnitLocation(evalEnv, element);
			setCurrentLocation(element, unitLocation, false);
			processDebugRequest(unitLocation);
		}//?? peek terminate
		return null;
	}

	private void processDebugRequest(@NonNull UnitLocation location) {
		VMRequest event = fDebugShell.popRequest();
		if (event == null) {
			return;
		}
		
		doProcessRequest(location, event);
	}

	public void pushVisitor(@NonNull AbstractOCLVMEvaluationVisitor evaluationVisitor) {
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

	public void start(boolean suspendOnStartup) {
//		UnitLocation newLocation = newLocalLocation((IDebugEvaluationEnvironment) evalEnv, transformation, ASTBindingHelper.getStartPosition(transformation)); //, getNodeLength(element));
//		setCurrentLocation(transformation, newLocation, false);

		fDebugShell.sessionStarted(this);

		VMRequest request = null; 
		try {
			// suspend to let others to wake up us on demand
			OCLDebugCore.TRACE.trace(DebugOptions.EVALUATOR,
			"Debug evaluator going to initial SUSPEND state"); //$NON-NLS-1$
			
			request = fDebugShell.waitAndPopRequest(new VMStartEvent(getMainModuleName(), suspendOnStartup));
		} catch (InterruptedException e) {
			Thread.interrupted();
			terminate();
		}
		
		if (request instanceof VMResumeRequest) {
			fCurrentStepMode = ((VMResumeRequest)request).suspension;
		}
		else {
			// TODO - decide a set of request we can handle during initial SUSPEND mode,
			// or report fError
			terminate();
		}
	}
	
	private void suspendAndWaitForResume(@NonNull UnitLocation location, @NonNull VMSuspension suspension) {
		suspendAndWaitForResume(location, createVMSuspendEvent(suspension));
	}
	
	private void suspendAndWaitForResume(@NonNull UnitLocation location, @NonNull VMSuspendEvent suspendEvent) {		
		fCurrentLocation = location;
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
