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

import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.OutlineWithEditorLinker;
import org.eclipse.xtext.util.ITextRegion;

public class BaseOutlineWithEditorLinker extends OutlineWithEditorLinker
{
	private int depth = 0;
	@Override
	protected IOutlineNode findBestNode(IOutlineNode input, ITextRegion selectedTextRegion) {
		int savedDepth = depth++;
		try {
			if (depth > 100) {
				System.out.println("FindBest limit at [" + selectedTextRegion.getOffset() + "," + selectedTextRegion.getLength() + "] " + DomainUtil.debugSimpleName(input));
				return null;
			}
			System.out.println("FindBest at [" + selectedTextRegion.getOffset() + "," + selectedTextRegion.getLength() + "] " + DomainUtil.debugSimpleName(input));
			return super.findBestNode(input, selectedTextRegion);
		}
		finally {
			depth = savedDepth;
		}
	}
}
