/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.completeocl.ui.outline;

import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.outline.EssentialOCLOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * customization of the default outline structure
 * 
 */
public class CompleteOCLOutlineTreeProvider extends EssentialOCLOutlineTreeProvider
{
//	protected void createNode(IOutlineNode parentNode, PackageDeclarationCS ele) {
//		for (EObject childElement : ele.getContexts())
//			createNode(parentNode, childElement);
//	}	
	protected void _createNode(IOutlineNode parentNode, PathNameCS ele) {}	
}
