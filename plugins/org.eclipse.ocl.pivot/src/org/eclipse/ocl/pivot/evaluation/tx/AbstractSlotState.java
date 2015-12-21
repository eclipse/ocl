/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.evaluation.tx;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;

/**
 * The abstract implementation of a SlotState provides the mandatory shared functionality for maintaining
 * the state of an object slot.
 * 
 * @since 1.1
 */
public abstract class AbstractSlotState implements SlotState
{
	public abstract static class Incremental extends AbstractSlotState implements SlotState.Incremental
	{
		private Set<Invocation.Incremental> sources = null;
		private Set<Invocation.Incremental> targets = null;

		@Override
		public void addSourceInternal(Invocation.@NonNull Incremental invocation) {
			if (sources == null) {
				sources = new HashSet<Invocation.Incremental>();
			}
			sources.add(invocation);
		}

		@Override
		public void addTargetInternal(Invocation.@NonNull Incremental invocation) {
			if (targets == null) {
				targets = new HashSet<Invocation.Incremental>();
			}
			targets.add(invocation);
		}
	}
}
