/**
 * <copyright>
 * 
 * Copyright (c) 2008, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: TracingOption.java,v 1.2 2010/04/08 06:27:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.utils;

import java.io.IOException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.plugin.OCLExamplesCommonPlugin;

public final class TracingOption implements Appendable
{
	public static final TracingOption DEBUG = new TracingOption(OCLExamplesCommonPlugin.PLUGIN_ID, "debug"); //$NON-NLS-1$

	/**
	 * Helper routine to append string to an appendable without throwing an exception.
	 * @param appendable
	 * @param string
	 */
	public static void println(@NonNull Appendable appendable, @NonNull String string) {
		try {
			appendable.append(string);
			appendable.append("\n");
		} catch (IOException e) {}
	}

	private final @NonNull String option;
	private boolean resolved = false;		// true once .options state determined by resolveState
	private boolean state = false;			// true/false once .options state determined resolveState
	
	public TracingOption(@NonNull String option) {
		this(OCLExamplesCommonPlugin.PLUGIN_ID, option);
	}
	
	public TracingOption(String pluginId, String option) {
		this.option = pluginId + "/" + option;
	}

	public @NonNull Appendable append(@NonNull CharSequence csq) {
		if (!resolved) {
			state = resolveState();
			resolved = true;
		}
		if (state)
			System.out.append(csq);
		return this;
	}

	public @NonNull Appendable append(@NonNull CharSequence csq, int start, int end) {
		if (!resolved) {
			state = resolveState();
			resolved = true;
		}
		if (state)
			System.out.append(csq, start, end);
		return this;
	}

	public @NonNull Appendable append(@NonNull char c) {
		if (!resolved) {
			state = resolveState();
			resolved = true;
		}
		if (state)
			System.out.append(c);
		return this;
	}

	public boolean isActive() {
		if (!resolved) {
			state = resolveState();
			resolved = true;
		}
		return state;
	}

	public void println(@NonNull String string) {
		if (!resolved) {
			state = resolveState();
			resolved = true;
		}
		if (state)
			System.out.println(option + " : " + string);		
	}

	public void println(@NonNull Class<?> clazz, @NonNull String string) {
		if (!resolved) {
			state = resolveState();
			resolved = true;
		}
		if (state)
			System.out.println(option + " : " + clazz.getSimpleName() + " : " + string);		
	}

	public boolean resolveState() {
		try {
			String debugOption = Platform.getDebugOption(option);
			return Boolean.TRUE.toString().equalsIgnoreCase(debugOption);
		}
		catch (Throwable e) {
			return false;
		}
	}

	/**
	 * Set the state explicitly, typically for use in a standalone environment
	 * such as a JUnit test that does not read the .options file.
	 */
	public void setState(boolean state) {
		this.state = state;
		resolved = true;
	}
}
