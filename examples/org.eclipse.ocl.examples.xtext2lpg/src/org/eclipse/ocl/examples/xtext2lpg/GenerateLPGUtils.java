/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext2lpg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext2lpg.XBNF.AbstractRule;
import org.eclipse.ocl.examples.xtext2lpg.XBNF.Conjunction;
import org.eclipse.ocl.examples.xtext2lpg.XBNF.Disjunction;
import org.eclipse.ocl.examples.xtext2lpg.XBNF.Keyword;
import org.eclipse.ocl.examples.xtext2lpg.XBNF.ParserGrammar;
import org.eclipse.ocl.examples.xtext2lpg.XBNF.Syntax;
import org.eclipse.ocl.examples.xtext2lpg.XBNF.TerminalRule;
import org.eclipse.ocl.examples.xtext2lpg.XBNF.TypedRule;
import org.eclipse.ocl.examples.xtext2lpg.XBNF.UntypedRule;

//import org.eclipse.ocl.examples.build.acceleo.GenerateXBNF2LPG;

public abstract class GenerateLPGUtils extends GenerateLPG
{
	protected final @NonNull Comparator<AbstractRule> ruleComparator = new Comparator<AbstractRule>()
	{
		public int compare(AbstractRule o1, AbstractRule o2) {
			String m1 = o1.getName(); 
			String m2 = o2.getName();
			if (m1 == null) m1 = "";
			if (m2 == null) m2 = "";
			return m1.compareTo(m2);
		}
	};

	protected final @NonNull Comparator<Conjunction> conjunctionComparator = new Comparator<Conjunction>()
	{
		public int compare(Conjunction o1, Conjunction o2) {
			int m1 = o1.getElements().size(); 
			int m2 = o2.getElements().size();
			return m1 - m2;
		}
	};

	protected String emitKeyword(String keywordValue) {
		return keywordValue.replace("\\w","$0 ");
	}

	protected String emitLabel(String keywordValue) {
		if (keywordValue.matches("[0-9a-zA-Z]*")) {
			return keywordValue;
		}
		String label = keywordValue;
		label = label.replace("&", "AND");
		label = label.replace("@", "AT");
		label = label.replace("|", "BAR");
		label = label.replace("^", "CARET");
		label = label.replace(":", "COLON");
		label = label.replace(",", "COMMA");
		label = label.replace(".", "DOT");
		label = label.replace("=", "EQUALS");
		label = label.replace("#", "HASH");
		label = label.replace("<", "LANGLE");
		label = label.replace("{", "LBRACE");
		label = label.replace("(", "LPAREN");
		label = label.replace("[", "LSQUARE");
		label = label.replace("-", "MINUS");
		label = label.replace("!", "PLING");
		label = label.replace("+", "PLUS");
		label = label.replace("?", "QUERY");
		label = label.replace(">", "RANGLE");
		label = label.replace("}", "RBRACE");
		label = label.replace(")", "RPAREN");
		label = label.replace("]", "RSQUARE");
		label = label.replace(";", "SEMICOLON");
		label = label.replace("/", "SLASH");
		label = label.replace("*", "STAR");
		if (label.matches("[a-zA-Z]*")) {
			return label;
		}
		else {
			return "xx"; //keywordValue.codePoints()->iterate(c : Integer; acc : String = '' | acc + '_' + c.toString())
		}
	}

	protected String emitSyntaxName(Syntax syntax) { 
		String name = syntax.getName();
		int lastDot = name.lastIndexOf('.');
		int firstCharacter = lastDot > 0 ? lastDot+1 : 1;
		return name.substring(firstCharacter, name.length());
	}

	protected String emitSyntaxPackage(Syntax syntax) { 
		String name = syntax.getName();
		int lastDot = name.lastIndexOf('.');
		int lastCharacter = lastDot > 0 ? lastDot+1 : name.length();
		return name.substring(0, lastCharacter-1);
	}

	protected @NonNull List<String> getSortedAlphaChars(@NonNull Syntax syntax) {
		Set<Character> allElements = new HashSet<Character>();
		for (TreeIterator<EObject> tit = syntax.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Keyword) {
				String keywordValue = ((Keyword) eObject).getValue();
				if (keywordValue.matches("[a-zA-Z]+")) {
					for (char c : keywordValue.toCharArray()) {
						allElements.add(c);
					}
				}
			}
		}
		List<String> sortedElements = new ArrayList<String>();
		for (Character c : allElements) {
			sortedElements.add(c.toString());
		}
		Collections.sort(sortedElements);
		return sortedElements;
	}

	protected @NonNull List<Conjunction> getSortedConjunctions(@NonNull Disjunction disjunction) {
		List<Conjunction> sortedConjunctions = new ArrayList<Conjunction>(disjunction.getConjunctions());
		Collections.sort(sortedConjunctions, conjunctionComparator);
		return sortedConjunctions;
	}

	protected @NonNull List<String> getSortedPunctChars(@NonNull Syntax syntax) {
		Set<Character> allElements = new HashSet<Character>();
		for (TreeIterator<EObject> tit = syntax.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Keyword) {
				String keywordValue = ((Keyword) eObject).getValue();
				if (!keywordValue.matches("[a-zA-Z]+")) {
					for (char c : keywordValue.toCharArray()) {
						allElements.add(c);
					}
				}
			}
		}
		List<String> sortedElements = new ArrayList<String>();
		for (Character c : allElements) {
			sortedElements.add(c.toString());
		}
		Collections.sort(sortedElements);
		return sortedElements;
	}

	protected @NonNull List<String> getSortedKWValues(@NonNull Syntax syntax) {
		Set<String> allElements = new HashSet<String>();
		for (TreeIterator<EObject> tit = syntax.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Keyword) {
				String keywordValue = ((Keyword) eObject).getValue();
				if (keywordValue.matches("[a-zA-Z]+")) {
					allElements.add(keywordValue);
				}
			}
		}
		List<String> sortedElements = new ArrayList<String>(allElements);
		Collections.sort(sortedElements);
		return sortedElements;
	}

	protected @NonNull List<TypedRule> getSortedParserRules(@NonNull ParserGrammar parser) {
		Set<TypedRule> allElements = new HashSet<TypedRule>();
		for (TypedRule subRule : parser.getRules()) {
			if (!(subRule instanceof TerminalRule)) {
				allElements.add(subRule);
			}
		}
		List<TypedRule> sortedElements = new ArrayList<TypedRule>(allElements);
		Collections.sort(sortedElements, ruleComparator);
		return sortedElements;
	}

	protected @NonNull List<String> getSortedPunctValues(@NonNull Syntax syntax) {
		Set<String> allElements = new HashSet<String>();
		for (TreeIterator<EObject> tit = syntax.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Keyword) {
				String keywordValue = ((Keyword) eObject).getValue();
				if (!keywordValue.matches("[a-zA-Z]+")) {
					allElements.add(keywordValue);
				}
			}
		}
		List<String> sortedElements = new ArrayList<String>(allElements);
		Collections.sort(sortedElements);
		return sortedElements;
	}

	protected @NonNull List<UntypedRule> getSortedSubRules(@NonNull Iterable<UntypedRule> subRules) {
		List<UntypedRule> allElements = new ArrayList<UntypedRule>();
		for (UntypedRule subRule : subRules) {
			allElements.add(subRule);
		}
		Collections.sort(allElements, ruleComparator);
		return allElements;
	}

	protected @NonNull List<TerminalRule> getSortedTerminalRules(@NonNull Syntax syntax) {
		Set<TerminalRule> allElements = new HashSet<TerminalRule>();
		for (TreeIterator<EObject> tit = syntax.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof TerminalRule) {
				allElements.add((TerminalRule)eObject);
			}
		}
		List<TerminalRule> sortedElements = new ArrayList<TerminalRule>(allElements);
		Collections.sort(sortedElements, ruleComparator);
		return sortedElements;
	}

	protected @NonNull <T extends AbstractRule> List<T> selectRules(@NonNull Iterable<T> rules, String name) {
		List<T> selectedRules = new ArrayList<T>();
		for (T rule : rules) {
			if (name.equals(rule.getName())) {
				selectedRules.add(rule);
			}
		}
		return selectedRules;
	}
}
