/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.ui.outline;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

public class BaseOutlineNode extends EObjectNode
{
	protected final URI csURI;
	protected final boolean isImplicit;

	public BaseOutlineNode(@NonNull Element asElement, boolean isImplicit, @Nullable ElementCS csElement, IOutlineNode parent, Image image, Object text, boolean isLeaf) {
		super(asElement, parent, image, text, isLeaf);
		csURI = csElement != null ? EcoreUtil.getURI(csElement) : null;
		this.isImplicit = isImplicit;
 	}

	@Override
	public URI getEObjectURI() {
		return csURI;
	}
	
	public boolean isImplicit() {
		return isImplicit;
	}
}
