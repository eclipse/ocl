/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.oclinecore;

import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Variable;

public final class OCLinEcoreAS2CGVisitor extends AS2CGVisitor
{
	protected final @NonNull OCLinEcoreGlobalContext globalContext;
	
	public OCLinEcoreAS2CGVisitor(@NonNull CodeGenAnalyzer analyzer, @NonNull OCLinEcoreGlobalContext globalContext) {
		super(analyzer);
		this.globalContext = globalContext;
	}

	@Override
	protected void addParameter(@NonNull Variable aParameter, @NonNull CGParameter cgParameter) {
		super.addParameter(aParameter, cgParameter);
		Parameter representedParameter = aParameter.getRepresentedParameter();
		if (representedParameter != null) {
			GenParameter genParameter = genModelHelper.getGenParameter(representedParameter);
			if (genParameter != null) {
				String name = DomainUtil.nonNullState(genParameter.getName());
				cgParameter.setValueName(name);
				// reserve name
			}
		}
	}

	@Override
	public @NonNull CGParameter getSelfParameter(@NonNull Variable aParameter) {
		CGParameter selfParameter = super.getSelfParameter(aParameter);
		selfParameter.setValueName("this");
		return selfParameter;
	}
}
