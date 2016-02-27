package org.eclipse.ocl.xtext.base.compatibility;

import org.antlr.runtime.DFA;

public class XtextCompatibilityUtils
{
	/**
	 * Xtext 2.9
	 */
	public static short[][] unpackEncodedStringArray(String[] arr) {
		int numStates = arr.length;
		short[][] result = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			result[i] = DFA.unpackEncodedString(arr[i]);
		}
		return result;
	}
}
