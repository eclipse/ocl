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
package org.eclipse.ocl.examples.build.acceleo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.utilities.AS2Moniker;

public class NameQueries
{
	public static final Logger logger = Logger.getLogger(NameQueries.class);
	public static MetaModelManager metaModelManager = null;

	private static Map<String, Integer> counters = new HashMap<String, Integer>();
	private static Map<Object, String> definedSymbols = new HashMap<Object, String>();

	public static List<Integer> codePoints(String s) {
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
	}
	
	public static String getEcoreLiteral(@NonNull EnumerationLiteral enumerationLiteral) {
		Enumeration enumeration = enumerationLiteral.getEnumeration();
		String nsURI = DomainUtil.nonNullModel(enumeration.getPackage().getNsURI());
		GenPackage genPackage = metaModelManager.getGenPackage(nsURI);
		if (genPackage != null) {
			return /*genPackage.getInterfacePackageName() +*/ genPackage.getPackageInterfaceName() + ".Literals." + CodeGenUtil.upperName(enumeration.getName())
						+ ".getEEnumLiteral(" + enumeration.getName() + "." + CodeGenUtil.upperName(enumerationLiteral.getName()) + "_VALUE)";
		}
		return enumeration.getName() + "." + CodeGenUtil.upperName(enumerationLiteral.getName());
	}
	
	public static String getEcoreLiteral(@NonNull Property property) {
		if (!property.isImplicit()) {
			Type type = property.getOwningType();
			if (type != null) {
				String nsURI = DomainUtil.nonNullModel(type.getPackage().getNsURI());
				GenPackage genPackage = metaModelManager.getGenPackage(nsURI);
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
	
	public static String getEcoreLiteral(@NonNull Type type) {
		if (type.getOwningTemplateParameter() == null) {
			String nsURI = DomainUtil.nonNullModel(type.getPackage().getNsURI());
			GenPackage genPackage = metaModelManager.getGenPackage(nsURI);
			if (genPackage != null) {
				return /*genPackage.getInterfacePackageName() +*/ genPackage.getPackageInterfaceName() + ".Literals." + CodeGenUtil.upperName(type.getName());
			}
		}
		return "\"" + type.getName() + "\"";
	}
	
	public static String getMoniker(@NonNull Element element) {
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
	public static String getSymbolName(Object elem) {
		return getPrefixedSymbolName("symbol_", elem);
	}

	public static String getPrefixedSymbolName(String prefix, Object elem) {
		if (elem == null) {
			logger.error("getPrefixedSymbolName for '" + prefix + "'and null");
		}
		if ((elem instanceof CollectionType) && (((CollectionType)elem).getUnspecializedElement() != null)) {
		}
		else if (elem instanceof Type) {
			if (metaModelManager != null) {
				TypeServer typeServer = metaModelManager.getPackageManager().findTypeServer((Type)elem);
				if (typeServer != null) {
					elem = typeServer;
				}
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
	
	public static void reset() {
		counters = new HashMap<String, Integer>();
		definedSymbols = new HashMap<Object, String>();
	}
	
	public static void setMetaModelManager(MetaModelManager metaModelManager) {
		NameQueries.metaModelManager = metaModelManager;
	}
}
