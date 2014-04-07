/**
 * <copyright>
 *
 * Copyright (c) 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.standalone;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.standalone.messages.StandaloneMessages;

/**
 * The HelpCommand provides interactive help.
 */
public class HelpCommand extends StandaloneCommand
{
	private static final Logger logger = Logger.getLogger(HelpCommand.class);

	public HelpCommand(@NonNull StandaloneApplication standaloneApplication) {
		super(standaloneApplication, "help", "Provide help");
	}
	
	public @NonNull StandaloneResponse execute(@NonNull Map<CommandToken, List<String>> tokens) {
        System.out.println(StandaloneMessages.OCLArgumentAnalyzer_help);
		return StandaloneResponse.OK;
	}

	@Override
	public @Nullable Map<CommandToken, List<String>> parse(@NonNull String[] arguments) {
		Map<CommandToken, List<String>> tokens = super.parse(arguments);
		if (tokens.size() > 0) {
			logger.error("Bad help command");
			return null;
		}
		return tokens;
	}
}
