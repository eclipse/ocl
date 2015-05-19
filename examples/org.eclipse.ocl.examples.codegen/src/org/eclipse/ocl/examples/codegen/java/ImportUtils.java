/*******************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

public class ImportUtils
{
	public static final String IMPORTS_MARKER = "<%**imports**%>";
	public static final String IMPORTS_PREFIX = "<%";
	public static final String IMPORTS_SUFFIX = "%>";

	public static @NonNull String getAffixedName(@NonNull Class<?> javaClass) {
		return IMPORTS_PREFIX + javaClass.getName() + IMPORTS_SUFFIX;
	}

	public static @NonNull String getAffixedName(@NonNull String className) {
		return IMPORTS_PREFIX + className + IMPORTS_SUFFIX;
	}
	
	public static @NonNull Map<String, String> getLong2ShortImportNames(@NonNull Iterable<String> allImports) {
		Map<String, String> long2shortNames = new HashMap<String, String>();
		Map<String, String> shortables = new HashMap<String, String>();
		for (String longName : allImports) {
			int index = longName.lastIndexOf(".");
			String shortName = index >= 0 ? longName.substring(index+1) : longName;
			if (shortables.containsKey(shortName)) {
				String oldImport = shortables.get(shortName);
				long2shortNames.put(oldImport, null);
				long2shortNames.put(longName, null);
				shortables.put(shortName, null);
			}
			else {
				long2shortNames.put(longName, shortName);
				shortables.put(shortName, longName);
			}
		}
		Map<String, String> long2short = new HashMap<String, String>();
		for (String longName : long2shortNames.keySet()) {
			String shortName = long2shortNames.get(longName);
			long2short.put(longName, shortName != null ? shortName : null);
		}
		return long2short;
	}

	public static @NonNull String resolveImports(@NonNull String source, @NonNull Map<String, String> long2short)
	{
		int iMax = source.length();
		int iStart = source.indexOf(IMPORTS_MARKER);
		if (iStart < 0) {
			return source;
		}
		StringBuilder s = new StringBuilder();
		s.append(source, 0, iStart);
		List<String> sortedImports = new ArrayList<String>(long2short.keySet());
		Collections.sort(sortedImports);
		for (String anImport : sortedImports) {
			String shortname = long2short.get(anImport);
			if (!anImport.startsWith("java.lang.") && (shortname != null)) {
				s.append("import " + anImport +";\n");
			}
		}
		iStart += IMPORTS_MARKER.length();
		while (true) {
			int iPrefix = source.indexOf(IMPORTS_PREFIX, iStart);
			if (iPrefix < 0) {
				break;
			}
			int iSuffix = source.indexOf(IMPORTS_SUFFIX, iPrefix);
			if (iSuffix < 0) {
				break;
			}
			s.append(source, iStart, iPrefix);
			String longName = source.substring(iPrefix+IMPORTS_PREFIX.length(), iSuffix);
			String shortname = long2short.get(longName);
			s.append(shortname != null ? shortname : longName);
			iStart = iSuffix + IMPORTS_SUFFIX.length();
		}
		s.append(source, iStart, iMax);
		@SuppressWarnings("null")@NonNull String string = s.toString();
		return string;
	}
}
