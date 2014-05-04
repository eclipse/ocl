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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class CompiledUnit {
	
	private List<Root> modules = new ArrayList<Root>();

	public CompiledUnit() {
	}

	public CompiledUnit(@NonNull Element element) {
		modules.add(PivotUtil.getContainingRoot(element));
	}

	public List<CompiledUnit> getCompiledImports() {
		// TODO Auto-generated method stub
		return null;
	}

	public URI getURI() {
		return URI.createURI(modules.get(0).getExternalURI());
	}

	public @NonNull List<Root> getModules() {
		return modules;
	}
}
