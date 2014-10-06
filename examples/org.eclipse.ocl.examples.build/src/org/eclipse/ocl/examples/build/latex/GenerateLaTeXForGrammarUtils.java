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
package org.eclipse.ocl.examples.build.latex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public abstract class GenerateLaTeXForGrammarUtils extends GenerateLaTeXForGrammar
{
	protected final @NonNull Comparator<AbstractMetamodelDeclaration> metamodelComparator = new Comparator<AbstractMetamodelDeclaration>()
	{
		public int compare(AbstractMetamodelDeclaration o1, AbstractMetamodelDeclaration o2) {
			String m1 = o1.getAlias(); 
			String m2 = o2.getAlias();
			if (m1 == null) m1 = "";
			if (m2 == null) m2 = "";
			return m1.compareTo(m2);
		}
	};
	
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

	protected String emitAllTT(String content) {
		StringBuilder s = new StringBuilder();
		s.append("#\\begin#{alltt#}");
		int col = 0;
		int lastSpace = s.length();
		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);
			if (c == '\n') {
				col = 0;
				lastSpace = s.length();
			}
			else if (c == ' ') {
				if (col > 70) {
					s.setCharAt(lastSpace, '\n');
					col = s.length() - lastSpace;
				}
				lastSpace = s.length();
			}
			s.append(c);
			col++;
		}
		s.append("#\\end#{alltt#}");
		return s.toString();
	}
	
	protected String emitCharacters(@NonNull String string) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '\b') {
				s.append("\\b");
			}
			else if (c == '\n') {
				s.append("\\n");
			}
			else if (c == '\r') {
				s.append("\\r");
			}
			else if (c == '\t') {
				s.append("\\t");
			}
			else if (c == '\\') {
				s.append("\\\\");
			}
			else if (c == '\'') {
				s.append("\\'");
			}
			else {
				s.append(c);
			}
		}
		return s.toString();
	}
	
	protected String emitComment(@NonNull EObject eObject) {
		ICompositeNode node = NodeModelUtils.getNode(eObject);
		List<ILeafNode> documentationNodes = null;
		for (ILeafNode leafNode : node.getLeafNodes()) {
			EObject grammarElement = leafNode.getGrammarElement();
			if (!(grammarElement instanceof TerminalRule)) {
				break;
			}
			TerminalRule terminalRule = (TerminalRule) grammarElement;
			String name = terminalRule.getName();
			if ("WS".equals(name)) {
			}
			else if ("SL_COMMENT".equals(name)) {
			}
			else if ("ML_COMMENT".equals(name)) {
				if (documentationNodes == null) {
					documentationNodes = new ArrayList<ILeafNode>();
				}
				documentationNodes.add(leafNode);
			}
			else {
				break;
			}
		}
		if (documentationNodes == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		for (ILeafNode documentationNode : documentationNodes) {
			String text = documentationNode.getText().replace("\r", "");
			if (text.startsWith("/*") && text.endsWith("*/")) {
				String contentString = text.substring(2, text.length()-2).trim();
				for (String string : contentString.split("\n")) {
					String trimmedString = string.trim();
					if (s.length() > 0) {
						s.append("\n");
					}
					s.append(trimmedString.startsWith("*") ? trimmedString.substring(1).trim() : trimmedString);
				}
			}
			else {
				s.append(text.trim());
			}
		}
		s.append("\n\n");
		return s.toString();
	}
	
	protected String emitLabel(@Nullable String label) {
		return label != null ? "#\\label#{" + encodeLabelText(label) + "#}" : "";
	}
	
	protected String emitSection(String name, @Nullable String label) {
		return name != null ? "#\\section#{" + encodeSectionText(name) + "#}" + emitLabel(label) : "";
	}
	
	protected String emitSubsection(String name, @Nullable String label) {
		return name != null ? "#\\subsection#{" + encodeSectionText(name) + "#}" + emitLabel(label) : "";
	}
	
	protected String emitSubsubsection(String name, @Nullable String label) {
		return name != null ? "#\\subsubsection#{" + encodeSectionText(name) + "#}" + emitLabel(label) : "";
	}

	@Override
	protected String encodeForLaTeX(String latexContent) {
		StringBuilder s = new StringBuilder();
		int length = latexContent.length();
		for (int i = 0; i < length; ) {
			char c = latexContent.charAt(i++);
			if (c == '#') {
				if (i < length) {
					c = latexContent.charAt(i++);
				}
				if (c == '#') {
					s.append("\\#");
				}
				else {
					s.append(c);
				}
			}
			else if (c == '\\') {
				s.append("\\textbackslash{}");
			}
			else if (c == '<') {
				s.append("\\textless{}");
			}
			else if (c == '>') {
				s.append("\\textgreater{}");
			}
			else if (c == '|') {
				s.append("\\textbar{}");
			}
			else if (c == '_') {
				s.append("\\_");
			}
			else if (c == '$') {
				s.append("\\$");
			}
			else if (c == '&') {
				s.append("\\&");
			}
			else if (c == '%') {
				s.append("\\%");
			}
			else if (c == '{') {
				s.append("\\{");
			}
			else if (c == '}') {
				s.append("\\}");
			}
			else if (c == '~') {
				s.append("\\~{}");
			}
			else if (c == '\'') {
				s.append("'");
			}
			else if (c == '"') {
				s.append("''");
			}
			else if (c == '<') {
				s.append("\\textless{}");
			}
			else {
				s.append(c);
			}
		}
		return s.toString();
	}
	
	protected String encodeLabelText(@NonNull String string) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '_') {
				s.append("#_");
			}
			else {
				s.append(c);
			}
		}
		return s.toString();
	}
	
	protected String encodeSectionText(@NonNull String string) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '_') {
				s.append("#\\#_");
			}
			else {
				s.append(c);
			}
		}
		return s.toString();
	}
	
	protected @NonNull List<ReferencedMetamodel> getSortedMetamodelDeclarations(@NonNull Grammar grammar) {
		List<ReferencedMetamodel> sortedMetamodels = new ArrayList<ReferencedMetamodel>();
		for (AbstractMetamodelDeclaration metamodelDeclaration : grammar.getMetamodelDeclarations()) {
			String alias = metamodelDeclaration.getAlias();
			if ((metamodelDeclaration instanceof ReferencedMetamodel) && (alias != null) && !alias.equals("ecore")) {
				sortedMetamodels.add((ReferencedMetamodel) metamodelDeclaration);
			}
		}
		Collections.sort(sortedMetamodels, metamodelComparator);
		return sortedMetamodels;
	}

	protected @NonNull List<ParserRule> getSortedParserRules(@NonNull Grammar grammar) {
		List<ParserRule> sortedRules = new ArrayList<ParserRule>();
		for (AbstractRule rule : grammar.getRules()) {
			if (rule instanceof ParserRule) {
				sortedRules.add((ParserRule) rule);
			}
		}
		Collections.sort(sortedRules, ruleComparator);
		return sortedRules;
	}

	protected @NonNull List<TerminalRule> getSortedTerminalRules(@NonNull Grammar grammar) {
		List<TerminalRule> sortedRules = new ArrayList<TerminalRule>();
		for (AbstractRule rule : grammar.getRules()) {
			if (rule instanceof TerminalRule) {
				sortedRules.add((TerminalRule) rule);
			}
		}
		Collections.sort(sortedRules, ruleComparator);
		return sortedRules;
	}
}
