/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.completeocl.validation;

import org.eclipse.ocl.examples.pivot.validation.PivotEObjectValidator;

/**
 * A BasicCompleteOCLEObjectValidator validates CompleteOCL invariants during an EMF validation, for each
 * EPackage for which a/the BasicCompleteOCLEObjectValidator instance has been registered as a validator
 * in the EValidator.Registry.
 */
@Deprecated // Use PivotEObjectValidator
public class BasicCompleteOCLEObjectValidator extends PivotEObjectValidator
{
}
