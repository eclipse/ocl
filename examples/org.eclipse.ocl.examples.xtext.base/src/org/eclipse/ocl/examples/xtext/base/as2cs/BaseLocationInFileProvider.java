/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.as2cs;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

public class BaseLocationInFileProvider extends DefaultLocationInFileProvider
{
	@Override
	protected ITextRegion getTextRegion(EObject obj, boolean isSignificant) {
		if (obj instanceof Element) {
			ModelElementCS csModelElement = ElementUtil.getCsElement((Element) obj);
			if (csModelElement != null) {
				return super.getTextRegion(csModelElement, isSignificant);
			}
		}
		else if (obj instanceof Comment) {
			EObject eContainer = obj.eContainer();
			if (eContainer instanceof Element) {
				ModelElementCS csModelElement = ElementUtil.getCsElement((Element) eContainer);
				if (csModelElement != null) {
					ICompositeNode node = NodeModelUtils.getNode(csModelElement);
					if (node != null) {
						List<ILeafNode> documentationNodes = CS2AS.getDocumentationNodes(node);
						ILeafNode first = documentationNodes.get(0);
						ILeafNode last = documentationNodes.get(documentationNodes.size()-1);
						int start = first.getOffset();
						int end = last.getOffset() + last.getLength();
						return new TextRegion(start, end-start);
					}
				}
			}
		}
		return super.getTextRegion(obj, isSignificant);
	}
}