/*******************************************************************************
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.validation;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.osgi.util.NLS;

public class ValidationWarning extends BasicDiagnostic
{
	public ValidationWarning(String messageTemplate, Object... bindings) {
		super(EvaluatorMessages.Validation, WARNING, NLS.bind(messageTemplate, bindings), null);
	}
}