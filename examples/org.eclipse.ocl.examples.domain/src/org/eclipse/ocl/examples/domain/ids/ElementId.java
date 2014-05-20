/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An ElementId provides a unique hierarchical identifier for a metamodel element. The identifier is structured in that it comprises nested scopes but
 * has no behavior. The identifier is used to compare metamodel elements by identifier equality allowing multiple actual representations
 * of a conceptual metamodel element to co-exist.
 * <p>
 * For instance 'Boolean' is a well-understood conceptual type, but it may have many 'actual' types as a result of Complete OCL
 * definitions merging additional features in to the 'actual' type. It may also have many representations, perhaps one from UML,
 * another from Ecore and another in the Pivot model.
 * <p>
 * A unique identifier provides a convenient mechanism for locating alternative representations, or pre-existing copies of
 * the same representation. The identifiers of for instance Collections and Tuples observe scope-independent semantics so
 * that equivalent collection and tuple types share the same element identifier.
 * 
 * @see EnumerationLiteralId
 * @see OperationId
 * @see PackageId
 * @see TypeId
 */
public interface ElementId
{
	@Nullable <R> R accept(@NonNull IdVisitor<R> visitor);
	
	/**
	 * Return a simple name for diagnostics.
	 */
	@NonNull String getDisplayName();
}