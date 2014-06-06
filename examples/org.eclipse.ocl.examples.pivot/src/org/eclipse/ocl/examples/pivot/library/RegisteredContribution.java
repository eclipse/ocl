/*******************************************************************************
 * Copyright (c) 2010, 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.library;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.plugin.RegistryReader.PluginClassDescriptor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public interface RegisteredContribution<C extends RegisteredContribution<C>> {

	/**
	 * A registry of contributions.
	 */
	interface Registry<C extends RegisteredContribution<C>> {
		@Nullable C get(@NonNull String key);
		@Nullable C put(@NonNull String key, @NonNull C contribution);
		@Nullable C remove(@NonNull String key);
		int size();
	}
	/**
	 * A <code>Factory</code> wrapper that is used by the
	 * {@link Registry}.
	 */
	interface Descriptor<C extends RegisteredContribution<C>> extends RegisteredContribution<C> {

		IConfigurationElement getElement();
	}

	abstract class AbstractDescriptor<C extends RegisteredContribution<C>> extends PluginClassDescriptor implements Descriptor<C>
	{
		protected C contribution;

		public AbstractDescriptor(IConfigurationElement e, String attrName) {
			super(e, attrName);
		}

		protected abstract C createContribution();

		public IConfigurationElement getElement() {
			return element;
		}
		
		public C getContribution() {
			if (contribution == null) {
				contribution = createContribution();
			}
			return contribution;
		}
	}	

	class AbstractRegistry<C extends RegisteredContribution<C>> implements Registry<C>
	{
		private final @NonNull Map<String, C>  map = new HashMap<String, C>();

		public @Nullable C get(@NonNull String key) {
			C contribution = map.get(key);
			return contribution != null ? contribution.getContribution() : null;
		}

		public @Nullable C put(@NonNull String key, @NonNull C contribution) {
			return map.put(key, contribution);
		}

		public C remove(@NonNull String key) {
			return map.remove(key);
		}

		public int size() {
			return map.size();
		}
	}

	C getContribution();
}
