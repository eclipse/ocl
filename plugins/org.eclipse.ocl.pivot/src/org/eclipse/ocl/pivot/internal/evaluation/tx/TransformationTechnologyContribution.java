/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.evaluation.tx;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.tx.TransformationTechnology;
import org.eclipse.ocl.pivot.internal.library.RegisteredContribution;

/**
 * @since 1.1
 */
public interface TransformationTechnologyContribution extends RegisteredContribution<TransformationTechnologyContribution>
{
	public static final class TransformationTechnologyRegistry extends AbstractRegistry<TransformationTechnologyContribution>
	{
		public void install(@NonNull TransformationTechnologyContribution transformationTechnologyContribution) {
			put(transformationTechnologyContribution.getName(), transformationTechnologyContribution);
		}
	}
	public static @NonNull TransformationTechnologyRegistry REGISTRY = new TransformationTechnologyRegistry();

	static class Descriptor extends AbstractDescriptor<TransformationTechnologyContribution> implements TransformationTechnologyContribution
	{
		protected final @NonNull String name;
//		private /*@LazyNonNull*/TransformationTechnologyContribution contribution;
		
		public Descriptor(@NonNull IConfigurationElement e, @NonNull String name, @NonNull String attrName) {
			super(e, attrName);
			this.name = name;
		}

		@Override
		protected TransformationTechnologyContribution createContribution() {
			Object createInstance = createInstance();
			return (TransformationTechnologyContribution) createInstance;
		}

		@Override
		public @NonNull String getName() {
			return name;
		}

		@Override
		public @NonNull TransformationTechnology getTransformationTechnology() {
			return getContribution().getTransformationTechnology();
		}
	}

/*	static final class Null implements TransformationTechnologyContribution
	{
		public TransformationTechnologyContribution getContribution() {
			return this;
		}

		public Resource getResource() {
			return null;
		}
	} */
	
	/**
	 * A Null contribution may be installed to exploit the manually loaded content
	 * as the standard library.
	 */
//	static TransformationTechnologyContribution NULL = new Null();

	@NonNull String getName();
	
	/**
	 * Return the resource containing the contribution to the standard library.
	 * 
	 * @return the contributing resource.
	 */
	@NonNull TransformationTechnology getTransformationTechnology();
}
