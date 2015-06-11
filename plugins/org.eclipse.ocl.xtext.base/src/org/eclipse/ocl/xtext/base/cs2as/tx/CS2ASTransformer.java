/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.cs2as.tx;

import java.util.List;

import org.eclipse.ocl.pivot.evaluation.tx.Transformer;

public interface CS2ASTransformer extends Transformer {

	public List<CS2ASDiagnostic> getErrors();
}
