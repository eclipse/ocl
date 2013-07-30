/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.cse;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractAnalysis describes one or more occurrences of a structurally identical tree
 * of CGValuedElements.
 * <p>A SimpleAnalysis describes a single occurrence that may grow into:
 * <p>A SharedAnalysis describes a multiple occurrence.
 */
public abstract class AbstractAnalysis
{
	public abstract @NonNull CommonAnalysis addAnalysis(@NonNull AbstractAnalysis anAnalysis);

	public abstract @NonNull CommonAnalysis addCommonAnalysis(@NonNull CommonAnalysis commonAnalysis);
	
	public abstract @NonNull CommonAnalysis addSimpleAnalysis(@NonNull SimpleAnalysis simpleAnalysis);

	public abstract int getStructuralHashCode();
	
	public abstract boolean isStructurallyEqualTo(@NonNull AbstractAnalysis thatAnalysis);
	
	public abstract boolean isStructurallyEqualTo(@NonNull SimpleAnalysis anAnalysis);
}