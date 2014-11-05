/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.as2cs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.base.as2cs.BaseLocationInFileProvider;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

/**
 * EssentialOCLLocationInFileProvider ensure that the full text regions for OperatorCSes cover the full source and argument range.
 */
public class EssentialOCLLocationInFileProvider extends BaseLocationInFileProvider
{
	@Override		// FIXME Bug 434135 prevents outline selections working perfectly.
	public ITextRegion getFullTextRegion(EObject obj) {
		if (obj instanceof OperatorExpCS) {
			ExpCS firstCS = (OperatorExpCS)obj;
			ExpCS lastCS = (OperatorExpCS)obj;
			while (firstCS instanceof OperatorExpCS) {
				ExpCS expCS = ((OperatorExpCS)firstCS).getSource();
				if (expCS != null) {
					firstCS = expCS;
				}
				else {
					break;
				}
			}
			if (obj instanceof InfixExpCS) {
				while (lastCS instanceof InfixExpCS) {
					ExpCS expCS = ((InfixExpCS)lastCS).getArgument();
					if (expCS != null) {
						lastCS = expCS;
					}
					else {
						break;
					}
				}
			}
			else if (obj instanceof PrefixExpCS) {
				lastCS = firstCS;
				firstCS  = (OperatorExpCS)obj;
			}
			INode firstNode = NodeModelUtils.getNode(firstCS);
			INode lastNode = NodeModelUtils.getNode(lastCS);
			if ((firstNode != null) && (lastNode != null)) {
				int startOffset = firstNode.getOffset();
				int endOffset = ElementUtil.getEndOffset(lastNode);
				int length = endOffset - startOffset;
				if (startOffset < 0) {
					startOffset = 0;
				}
				if (length < 0) {
					length = 0;
				}
//				System.out.println("offset:" + startOffset + ":" + length + " " + obj.eClass().getName() + " \"" + obj.toString().replace("\n", "\\n") + "\"");
				return new TextRegion(startOffset, length);
			}
		}
		return super.getFullTextRegion(obj);
	}
}