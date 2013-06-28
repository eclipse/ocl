/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.StringBufferLog;

public class QVToTransformationExecutor extends AbstractWorkflowComponent
{
	private static final Logger logger = Logger.getLogger(QVToTransformationExecutor.class);
	
	private ResourceSet resourceSet = null;	
	private String uri = null;	
	private List<String> ins = new ArrayList<String>();
	private String out = null;	
	private String trace = null;
	private String encoding = "UTF-8"; //$NON-NLS-1$
	
	public void addIn(String fileName) {
		ins.add(fileName);
	}

	@Override
	public void checkConfiguration(Issues issues) {
		if (getUri() == null) {
			issues.addError(this, "uri not specified.");
		}
	}

	public String getOut() {
		return out;
	}

	public ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	public String getTrace() {
		return trace;
	}

	public String getUri() {
		return uri;
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		String uri = getUri();
		URI txURI = URI.createURI(uri, true);
		logger.info("Loading '" + txURI + "'");
		TransformationExecutor transformationExecutor = new TransformationExecutor(txURI);
		Diagnostic diagnostic = transformationExecutor.loadTransformation();
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			StringBuilder s = new StringBuilder();
			s.append("Failed to load ");
			s.append(txURI);
			for (Diagnostic child : diagnostic.getChildren()) {
				s.append("\n  " + child.getMessage());
			}
			issues.addError(this, s.toString(), txURI, null, null);
			return;
		}
		
		ResourceSet resourceSet = getResourceSet();
		List<ModelExtent> modelExtents = new ArrayList<ModelExtent>();
		for (String in : ins) {
			URI inURI = URI.createURI(in, true);
			logger.info("Loading '" + inURI + "'");
			Resource inResource = resourceSet.getResource(inURI, true);
			if (inResource.getErrors().size() > 0) {
				issues.addError(this, "Failed to load", inURI, null, null);
				return;
			}
			modelExtents.add(new BasicModelExtent(inResource.getContents()));
		}
		
		if (out != null) {
			modelExtents.add(new BasicModelExtent());
		}

//		String traceUri = trace != null ? URI.createPlatformResourceURI(trace, true).toString() : null;
		
		
		StringBufferLog qvtoLog = new StringBufferLog();
		try {
			logger.info("Executing transformation '" + uri + "'");
			ExecutionContextImpl executionContext = new ExecutionContextImpl();
			executionContext.setLog(qvtoLog);
			initializeConfigurationProperties(executionContext);
//			executionContext.setMonitor();
			ExecutionDiagnostic executionDiagnostic = transformationExecutor.execute(executionContext, modelExtents.toArray(new ModelExtent[modelExtents.size()]));
			if (executionDiagnostic.getSeverity() != Diagnostic.OK) {
				StringBuilder s = new StringBuilder();
				s.append("Failed to execute ");
				s.append(txURI);
				s.append(": ");
				s.append(executionDiagnostic.getMessage());
				for (Diagnostic child : diagnostic.getChildren()) {
					s.append("\n  " + child.getMessage());
				}
				issues.addError(this, s.toString(), txURI, null, null);
				return;
			}
		} catch (Exception e) {
			issues.addError(this, "Failed to launch transformation", txURI, e, null);
			return;
		}
		
		if (out != null) {
			URI outURI = URI.createURI(out, true);
			try {
				logger.info("Creating output:  '" + outURI + "'\n" + qvtoLog.getContents());
				XMLResource outResource = (XMLResource) resourceSet.createResource(outURI, null);
				outResource.getContents().addAll(modelExtents.get(modelExtents.size()-1).getContents());
				outResource.setEncoding(getEncoding());
				Map<String, Object> options = new HashMap<String, Object>();
				options.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
				options.put(XMLResource.OPTION_LINE_WIDTH, 80);
				options.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
				options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
				outResource.save(options);
			} catch (IOException e) {
				issues.addError(this, "Failed to save ", outURI, e, null);
				return;
			}	
		}
	}

	public void setOut(String out) {
		this.out = out;
	}
	
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	/**
	 * @param uri the QVTo Transformations URI
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * Clients may override to do any configuration 
	 * properties initialization
	 * 
	 * @return creates a context to be used by the transformation
	 */
	protected void initializeConfigurationProperties(ExecutionContextImpl context) {
		// do nothing
	}
	

}
