/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.ecore;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorEnumerationLiteral;

public class EcoreExecutorEnumerationLiteral extends ExecutorEnumerationLiteral
{
	protected final EEnumLiteral eEnumLiteral;
	
	public EcoreExecutorEnumerationLiteral(/*@NonNull*/ EEnumLiteral eEnumLiteral, @NonNull DomainEnumeration enumeration, int ordinal) {
		super(DomainUtil.nonNullEMF(eEnumLiteral.getName()), enumeration, ordinal);
		this.eEnumLiteral = eEnumLiteral;
	}

//	@Override
	@Override
	public @NonNull Enumerator getEnumerator() {
		return DomainUtil.nonNullEMF(DomainUtil.nonNullState(eEnumLiteral).getInstance());
	}
}