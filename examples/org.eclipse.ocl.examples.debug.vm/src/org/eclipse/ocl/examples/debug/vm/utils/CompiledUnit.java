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
package org.eclipse.ocl.examples.debug.vm.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Root;

public class CompiledUnit {
	
	private @NonNull List<NamedElement> modules = new ArrayList<NamedElement>();

	public CompiledUnit() {
	}

	public CompiledUnit(@NonNull Element element) {
		modules.add((NamedElement) EcoreUtil.getRootContainer(element));
	}

	public List<CompiledUnit> getCompiledImports() {
		// TODO Auto-generated method stub
		return null;
	}

	public URI getURI() {
		NamedElement namedElement = modules.get(0);
		if (namedElement instanceof Root) {
			return URI.createURI(((Root)namedElement).getExternalURI());
		}
		else {
			return EcoreUtil.getURI(namedElement);
		}
	}

	public @NonNull List<NamedElement> getModules() {
		return modules;
	}
}
