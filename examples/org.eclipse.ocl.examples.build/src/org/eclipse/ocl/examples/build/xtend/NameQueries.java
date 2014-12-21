/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.xtend;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class NameQueries
{
	public static final Logger logger = Logger.getLogger(NameQueries.class);
	public static @Nullable MetaModelManager metaModelManager = null;

	private static @NonNull Map<String, Integer> counters = new HashMap<String, Integer>();
	private static @NonNull Map<Object, String> definedSymbols = new HashMap<Object, String>();

/*	public static List<Integer> codePoints(String s) {
		List<Integer> results = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			results.add(c);
		}
		return results;
	}

	public static List<String> convertStrings(String s) {
		List<String> results = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			String c = s.substring(i, i+1);
			results.add(c);
		}
		return results;
	}
	
	public static String encodeName(@NonNull NamedElement element) {
		return AbstractGenModelHelper.encodeName(element);
	} */
	
	public static @NonNull String getEcoreLiteral(@NonNull EnumerationLiteral enumerationLiteral) {
		Enumeration enumeration = enumerationLiteral.getOwningEnumeration();
		String nsURI = ClassUtil.nonNullModel(enumeration.getOwningPackage().getURI());
		GenPackage genPackage = ClassUtil.nonNullState(metaModelManager).getGenPackage(nsURI);
		if (genPackage != null) {
			return /*genPackage.getInterfacePackageName() +*/ genPackage.getPackageInterfaceName() + ".Literals." + CodeGenUtil.upperName(enumeration.getName())
						+ ".getEEnumLiteral(" + enumeration.getName() + "." + CodeGenUtil.upperName(enumerationLiteral.getName()) + "_VALUE)";
		}
		return enumeration.getName() + "." + CodeGenUtil.upperName(enumerationLiteral.getName());
	}
	
	public static @NonNull String getEcoreLiteral(@NonNull Property property) {
		if (!property.isImplicit()) {
			org.eclipse.ocl.pivot.Class type = property.getOwningClass();
			if (type != null) {
				String nsURI = ClassUtil.nonNullModel(type.getOwningPackage().getURI());
				GenPackage genPackage = ClassUtil.nonNullState(metaModelManager).getGenPackage(nsURI);
				if (genPackage != null) {
					return /*genPackage.getInterfacePackageName() +*/genPackage
						.getPackageInterfaceName()
						+ ".Literals."
						+ CodeGenUtil.upperName(type.getName())
						+ "__"
						+ CodeGenUtil.upperName(property.getName());
				}
			}
		}
		return "\"" + property.getName() + "\"";
	}
	
	public static @NonNull String getEcoreLiteral(@NonNull org.eclipse.ocl.pivot.Class type) {
		String nsURI = ClassUtil.nonNullModel(type.getOwningPackage().getURI());
		GenPackage genPackage = ClassUtil.nonNullState(metaModelManager).getGenPackage(nsURI);
		if (genPackage != null) {
			return /*genPackage.getInterfacePackageName() +*/ genPackage.getPackageInterfaceName() + ".Literals." + CodeGenUtil.upperName(type.getName());
		}
		return "\"" + type.getName() + "\"";
	}
	
/*	public static String getMoniker(@NonNull Element element) {
		return AS2Moniker.toString(element);
	}
	
	/**
	 * Return a symbol name for an eObject. This method is invoked from an
	 * Acceleo script and so there is only one call per distinct object. Acceleo
	 * maintains the cache that returns the symbol for old objects.
	 * 
	 * @param eObject the object in question
	 * @return the symbol name
	 */
	public static String getSymbolName(@NonNull Object elem) {
		return getPrefixedSymbolName("symbol_", elem);
	}

	public static @NonNull String getPrefixedSymbolName(@NonNull String prefix, @NonNull Object elem) {
//		if (elem == null) {
//			logger.error("getPrefixedSymbolName for '" + prefix + "'and null");
//		}
		if ((elem instanceof CollectionType) && (((CollectionType)elem).getUnspecializedElement() != null)) {
		}
		else if (elem instanceof org.eclipse.ocl.pivot.Class) {
			if (metaModelManager != null) {
				elem = metaModelManager.getCompleteModel().getCompleteClass((Type)elem);
			}
		}
		String symbol = definedSymbols.get(elem);
		if (symbol == null) {
			Integer count = counters.get(prefix);
			Integer newCount = count != null ? count+1 : 0;
			counters.put(prefix, newCount);
			symbol = count != null ? prefix + "_" + newCount.toString() : prefix;
			definedSymbols.put(elem, symbol);
		}
		if ("symbol__1".equals(symbol)) {
			return symbol;			// FIXME Debugging
		}
		return symbol;
	}

	public static @NonNull String rawEncodeName(@NonNull String name, @NonNull Integer arity) {
		return AbstractGenModelHelper.rawEncodeName(name, arity);
	}
	
/*	public static void reset() {
		counters = new HashMap<String, Integer>();
		definedSymbols = new HashMap<Object, String>();
	} */
	
	public static void setMetaModelManager(@Nullable MetaModelManager metaModelManager) {
		NameQueries.metaModelManager = metaModelManager;
	}
}
