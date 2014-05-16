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
package org.eclipse.ocl.examples.debug.ui.pages;

import java.text.MessageFormat;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugEditorPresentation;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IDebugModelPresentationExtension;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.ocl.examples.debug.ui.OCLDebugUIPlugin;
import org.eclipse.ocl.examples.debug.ui.actions.OCLDebugImages;
import org.eclipse.ocl.examples.debug.ui.messages.DebugUIMessages;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugTarget;
import org.eclipse.ocl.examples.debug.vm.core.VMLineBreakpoint;
import org.eclipse.ocl.examples.debug.vm.core.VMStackFrame;
import org.eclipse.ocl.examples.debug.vm.core.VMThread;
import org.eclipse.ocl.examples.debug.vm.core.VMValue;
import org.eclipse.ocl.examples.debug.vm.core.VMVariable;
import org.eclipse.ocl.examples.debug.vm.data.VMLocationData;
import org.eclipse.ocl.examples.xtext.completeocl.ui.CompleteOCLEditor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.editor.XtextReadonlyEditorInput;


public class OCLDebugModelPresentation implements IDebugModelPresentation, IDebugEditorPresentation, IDebugModelPresentationExtension, IColorProvider, ILabelProvider {
	
	public OCLDebugModelPresentation() {
		super();
	}
	
	public void setAttribute(String attribute, Object value) {
	}

    public Image getImage(Object element) {
//    	System.out.println("getImage: " + element.getClass().getSimpleName() + " " + element);
    	if (element instanceof VMDebugTarget) {
    		return OCLDebugImages.getImage(OCLDebugImages.EXPRESSION_IN_OCL);
    	}
    	else if (element instanceof VMThread) {
        	return null;
        }
    	else if (element instanceof VMStackFrame) {
        	return null;
/*        	VMStackFrame frame = (VMStackFrame) element;
    		VMLocationData location = frame.getLocation();
    		String elementSignature = location.getElementSignature();
            if (elementSignature != null) {
    			return OCLDebugImages.getImage(OCLDebugImages.MAPPING);
            }
            else {
    			return OCLDebugImages.getImage(OCLDebugImages.EXPRESSION_IN_OCL);
            } */
        }
        else if(element instanceof VMVariable) {
    		VMVariable var = (VMVariable) element;
    		if (var.isModelParameter()) {
    			return OCLDebugImages.getImage(OCLDebugImages.MODEL_PARAMETER);
    		} else if (var.isReference()) {
    			return OCLDebugImages.getImage(OCLDebugImages.REFERENCE);
    		} else if (var.isAttribute()) {
    			return OCLDebugImages.getImage(OCLDebugImages.ATTRIBUTE);
    		} else if (var.isIntermProperty()) {
    			return OCLDebugImages.getImage(OCLDebugImages.INTERM_PROPERTY);
    		} else if (var.isLocalVariable()) {
    			return OCLDebugImages.getImage(OCLDebugImages.LOCAL_VARIABLE);
    		} else if (var.isPredefinedVariable()) {
    			// TODO - add special case for this
    			try {
					if("this".equals(var.getName())) { //$NON-NLS-1$
						return OCLDebugImages.getImage(OCLDebugImages.THIS_VARIABLE);
					}
				} catch (DebugException e) {
					// do nothing use the std image
				}
    			return OCLDebugImages.getImage(OCLDebugImages.PREDEFINED_VARIABLE);
    		} else if(var.isCollectionElement()) {
    			return OCLDebugImages.getImage(OCLDebugImages.COLLECTION_ELEMENT);
    		}
    		
    	} else if (element instanceof VMLineBreakpoint) {
            VMLineBreakpoint breakpoint = (VMLineBreakpoint) element;
            try {
                if (breakpoint.isConditionEnabled()) {                	
                    return breakpoint.isEnabled() ? 
                    		OCLDebugImages.getImage(OCLDebugImages.CONDITIONAL_BPNT_ENABLED) :
                    			OCLDebugImages.getImage(OCLDebugImages.CONDITIONAL_BPNT_DISABLED);
                } 
            } catch (CoreException ex) {
                OCLDebugUIPlugin.log(ex);
            }
    	}
        return null;
	}

	public String getText(Object element) {
//    	System.out.println("getText: " + element.getClass().getSimpleName() + " " + element);
		if (element instanceof VMDebugTarget) {
        	VMDebugTarget debugTarget = (VMDebugTarget) element;
			String moduleName = debugTarget.getMainModuleName();
			String launchConfigName = debugTarget.getLaunch().getLaunchConfiguration().getName();
			return NLS.bind(DebugUIMessages.OCLDebugModelPresentation_ExpressionInOCLLabel, moduleName, launchConfigName);
        }
        else if (element instanceof VMThread) {
        	VMThread thread = (VMThread) element;
        	String name = "main"; //$NON-NLS-1$
        	String state = thread.isSuspended() ? DebugUIMessages.OCLDebugModelPresentation_Suspended : DebugUIMessages.OCLDebugModelPresentation_Running;
        	return MessageFormat.format(DebugUIMessages.OCLDebugModelPresentation_ThreadLabel, name, state);
        } 
		else if (element instanceof VMStackFrame) {
        	VMStackFrame frame = (VMStackFrame) element;
    		VMLocationData location = frame.getLocation();
    		int line = frame.getLineNumber();
            StringBuilder s = new StringBuilder();
            String elementSignature = location.getElementSignature();
            if (elementSignature != null) {
            	s.append(elementSignature);
            	s.append(" - ");
            }
            s.append(location.getModule());
        	s.append(" line: ");
        	s.append(line);
            return s.toString();
        } 
        return null;
	}

    public void computeDetail(IValue value, IValueDetailListener listener) {
    	if(value instanceof VMValue) {
    		VMValue vmValue = (VMValue) value;
    		try {
				listener.detailComputed(value, vmValue.computeDetail());
			} catch (DebugException e) {
				OCLDebugUIPlugin.log(e.getStatus());
			}
    	} else {
    		listener.detailComputed(value, value.toString());
    	}
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public IEditorInput getEditorInput(Object element) {
		if (element instanceof IFile) {
			return new FileEditorInput((IFile) element);
		}
		else if (element instanceof ILineBreakpoint) {
			return new FileEditorInput((IFile) ((ILineBreakpoint) element).getMarker().getResource());
		}
		else if (element instanceof IStorage) {
			return new XtextReadonlyEditorInput((IStorage) element);
		}
		else {
			return null;
		}
	}

	public String getEditorId(IEditorInput input, Object element) {
		if (element instanceof IStorage || element instanceof ILineBreakpoint) {
			return CompleteOCLEditor.EDITOR_ID;
		}

		return null;
	}
	
    public Color getForeground(Object element) {
    	return null;
    }
    
    public Color getBackground(Object element) {
    	return null;
    }	

	public boolean addAnnotations(IEditorPart editorPart, IStackFrame frame) {
		return false;
	}

	public void removeAnnotations(IEditorPart editorPart, IThread thread) {
	}
    
    public void dispose() {
    }
        
    public boolean requiresUIThread(Object element) {    
    	return true;
    }    
    
    public void addListener(ILabelProviderListener listener) {
    }

    public void removeListener(ILabelProviderListener listener) {
	}    
}
