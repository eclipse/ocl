/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.manager;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A ConstrainingURI provides the unique identity of a Constraining Node, which is a meta-model node
 * and which typically forms the basis of a distinct tree node in the RH pane of the Validity View. 
 * <p>
 * Duplicate nodes such as multiple same-named contexts in CompleteOCL may be merged.
 */
public final class ConstrainingURI
{
	protected final @NonNull URI uri;
	
	public ConstrainingURI(@NonNull URI uri) {
		this.uri = uri;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ConstrainingURI)) {
			return false;
		}
		return uri.equals(((ConstrainingURI)obj).uri);
	}

	@Override
	public int hashCode() {
		return uri.hashCode();
	}

	public String toString() {
		return uri.toString();
	}
}