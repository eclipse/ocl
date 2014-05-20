/*******************************************************************************
 * Copyright (c) 2013, 2014 CEA List and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink (CEA List) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.compatibility;

import java.lang.reflect.Method;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.jdt.annotation.NonNull;

/**
 * UML_4_2 provides backwards compatible implementations of functionality first available in UML 4.2.
 */
public class UML_4_2
{
	private static final Method UML2ECORE_CONVERTER_GET_ORIGINAL_NAME_METHOD;

	static {
		Method uml2EcoreConverter_getOriginalName_Method = null;

		try {
			Class<?> uml2EcoreConverterClass = CommonPlugin.loadClass("org.eclipse.ocl.examples.domain","org.eclipse.uml2.uml.util.UMLUtil$UML2EcoreConverter");
			uml2EcoreConverter_getOriginalName_Method = uml2EcoreConverterClass.getMethod("getOriginalName", ENamedElement.class);
		} catch (Throwable exception) {
			// Ignore.
		}

		UML2ECORE_CONVERTER_GET_ORIGINAL_NAME_METHOD = uml2EcoreConverter_getOriginalName_Method;
	}
	  
	public static class UMLUtil {

		/**
		 * UML 4.2M4 introduces getOriginalname(). If it is missing then fall back to plain getName()..
		 */
		public static String getOriginalName(@NonNull ENamedElement eObject) {
			if (UML2ECORE_CONVERTER_GET_ORIGINAL_NAME_METHOD != null) {
				try {
					return (String) UML2ECORE_CONVERTER_GET_ORIGINAL_NAME_METHOD.invoke(null, eObject);
				} catch (Exception e) {
				}
			}
			return eObject.getName();
		}
	}
}
