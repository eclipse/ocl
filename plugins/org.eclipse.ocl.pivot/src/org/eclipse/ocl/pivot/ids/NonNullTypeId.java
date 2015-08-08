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
package org.eclipse.ocl.pivot.ids;

/**
 * A NonNullTypeId decorates a TypeId to indicate that its Type may not have a null value.
 * This is as part of the signature of a LambdaTypeId.
 */
public interface NonNullTypeId extends TypeId {

}
