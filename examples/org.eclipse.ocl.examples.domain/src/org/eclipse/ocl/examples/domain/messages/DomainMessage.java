/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.messages;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.osgi.util.NLS;

/**
 * A DomainMessage captures an unbound message so that the code generator can defer
 * binding to the execution time.
 */
public class DomainMessage
{
	public static final @NonNull DomainMessage INVALID = new DomainMessage("Invalid Lirteral");
	public static final @NonNull DomainMessage NULL = new DomainMessage("Null Literal");

	protected final @NonNull String template;
	protected final  @NonNull Object[] bindings;
	
	public DomainMessage(/*@NonNull*/ String messageTemplate, @NonNull Object... bindings) {
		this.template = DomainUtil.nonNullState(messageTemplate);
		this.bindings = bindings;
	}
	
	public @NonNull Object[] getBindings() {
		return bindings;
	}
	
	public @NonNull String getTemplate() {
		return template;
	}
	
	@Override
	public String toString() {
		return NLS.bind(template, bindings);
	}
}