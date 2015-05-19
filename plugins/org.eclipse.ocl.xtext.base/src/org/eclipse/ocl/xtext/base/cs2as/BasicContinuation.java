/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.cs2as;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * A BasicContinuation defines a conversion activity that needs to be performed once
 * its dependencies have been satisfied. All BasicContinuations are implicitly dependent
 * on the end of the pre and posrt order traversals.
 *
 * @param <T>
 */
public abstract class BasicContinuation<T> implements Continuation<T>
{
	static final Logger logger = Logger.getLogger(BasicContinuation.class);

	protected final @NonNull CS2ASConversion context;
	protected final Element pivotParent;
	protected final EStructuralFeature pivotFeature;	
	protected final @NonNull T csElement;
	protected final Dependency[] dependencies;
	
	public BasicContinuation(@NonNull CS2ASConversion context,
			Element pivotParent, EStructuralFeature pivotFeature,
			@NonNull T csElement, Dependency... dependencies) {
		this.context = context;
		this.pivotParent = pivotParent;
		this.pivotFeature = pivotFeature;
		this.csElement = csElement;
		this.dependencies = dependencies != null ? dependencies : new Dependency[0];
		assert csElement != null;
	}

	public void addError(@NonNull String message) {
		if (csElement instanceof ModelElementCS) {
			ModelElementCS csModelElement = (ModelElementCS) csElement;
			INode node = NodeModelUtils.getNode(csModelElement);
			Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, message);
			csModelElement.eResource().getErrors().add(resourceDiagnostic);
		}
		else {
			logger.error(message);
		}
	}
	
	@Override
	public void addTo(@NonNull List<BasicContinuation<?>> simpleContinuations) {
		simpleContinuations.add(this);
	}

	public boolean canExecute() {
		for (Dependency dependency : dependencies) {
			if (!dependency.canExecute()) {
				return false;
			}
		}
		return true;
	}		

	public abstract BasicContinuation<?> execute();

	public Dependency[] getDependencies() {
		return dependencies;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName());		
		s.append("@");		
		s.append(Integer.toHexString(hashCode()));		
		s.append(" : ");		
		if (pivotParent != null) {
			s.append(pivotParent.eClass().getName());		
		}
		else if (csElement instanceof EObject) {
			s.append(((EObject) csElement).eClass().getName());		
		}
		else {
			s.append("???");		
		}
		s.append(".");
		s.append(pivotFeature != null ? pivotFeature.getName() : "*");
		s.append(" : ");
		s.append(csElement.toString());
		return s.toString();
	}
}