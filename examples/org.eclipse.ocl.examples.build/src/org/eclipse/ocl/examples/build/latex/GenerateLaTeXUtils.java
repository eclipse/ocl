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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.xtext.markup.FontElement;
import org.eclipse.ocl.examples.xtext.markup.Markup;
import org.eclipse.ocl.examples.xtext.markup.MarkupElement;
import org.eclipse.ocl.examples.xtext.markup.MarkupUtils;
import org.eclipse.ocl.examples.xtext.markup.NewLineElement;
import org.eclipse.ocl.examples.xtext.markup.NullElement;
import org.eclipse.ocl.examples.xtext.markup.OCLCodeElement;
import org.eclipse.ocl.examples.xtext.markup.OCLTextElement;
import org.eclipse.ocl.examples.xtext.markup.TextElement;
import org.eclipse.ocl.examples.xtext.markup.util.MarkupSwitch;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;

public abstract class GenerateLaTeXUtils extends GenerateLaTeX
{
	protected final @NonNull Comparator<Nameable> nameableComparator = new Comparator<Nameable>()
	{
		public int compare(Nameable o1, Nameable o2) {
			String m1 = o1.getName(); 
			String m2 = o2.getName();
			if (m1 == null) m1 = "";
			if (m2 == null) m2 = "";
			return m1.compareTo(m2);
		}
	};

	protected final @NonNull Comparator<Iteration> iterationComparator = new Comparator<Iteration>()
	{
		public int compare(Iteration o1, Iteration o2) {
			String m1 = o1.getName(); 
			String m2 = o2.getName();
			if (m1 == null) m1 = "";
			if (m2 == null) m2 = "";
			int diff = m1.compareTo(m2);
			if (diff != 0) return diff;
			int s1 = o1.getOwnedIterator().size();
			int s2 = o2.getOwnedIterator().size();
			return s1 - s2;
		}
	};

	protected static final @NonNull Comparator<Operation> operationComparator = new OperationComparator();

	protected static final class OperationComparator implements Comparator<Operation>
	{
		public static Map<String,String> nameMap = new HashMap<String, String>();
		static {
			nameMap.put("=", " 1");
			nameMap.put("<>", " 2");
			nameMap.put("<", " 3");
			nameMap.put("<=", " 4");
			nameMap.put(">=", " 5");
			nameMap.put(">", " 6");
		}

		public int compare(Operation o1, Operation o2) {
			String m1 = o1.getName(); 
			String m2 = o2.getName();
			if (m1 == null) m1 = "";
			if (m2 == null) m2 = "";
			String k1 = nameMap.get(m1);
			String k2 = nameMap.get(m2);
			if (k1 != null) m1 = k1;
			if (k2 != null) m2 = k2;
			int diff = m1.compareTo(m2);
			if (diff != 0) return diff;
			int s1 = o1.getOwnedParameter().size();
			int s2 = o2.getOwnedParameter().size();
			return s1 - s2;
		}
	}

	protected static class MarkupToLaTeX extends MarkupSwitch<String>
	{
		@SuppressWarnings("unused") private final Namespace scope;
		private final StringBuilder s = new StringBuilder();
		
		public MarkupToLaTeX(Namespace scope) {
			this.scope = scope;
		}

		@Override
		public String caseFontElement(FontElement element) {
			String tag = element.getFont().equals("e") ? "textit" : "textrm";
			s.append("\\" + tag + "{");
			for (MarkupElement subElement : element.getElements()) {
				doSwitch(subElement);
			}
			s.append("}");
			return s.toString();
		}

		@Override
		public String caseMarkupElement(MarkupElement element) {
			s.append("$$");
			s.append(element.eClass().getName());
			return s.toString();
		}

		@Override
		public String caseNewLineElement(NewLineElement element) {
			s.append(element.getText());
			return s.toString();
		}

		@Override
		public String caseNullElement(NullElement object) {
			return s.toString();
		}

		@Override
		public String caseOCLCodeElement(OCLCodeElement element) {
			s.append("bc.. \n");
			for (MarkupElement subElement : element.getElements()) {
				doSwitch(subElement);
			}
			s.append("\n");
			s.append("p. \n");
			s.append("\n");
			return s.toString();
		}

		@Override
		public String caseOCLTextElement(OCLTextElement element) {
			s.append("#\\oclEmph#{");
			for (MarkupElement subElement : element.getElements()) {
				doSwitch(subElement);
			}
			s.append("#}");
			return s.toString();
		}

		@Override
		public String caseTextElement(TextElement element) {
			for (String text : element.getText()) {
				s.append(text);
			}
			return s.toString();
		}
	};
	
	public static @NonNull PrettyPrintOptions.Global createOptions(@Nullable Namespace scope) {
		PrettyPrintOptions.Global options = new PrettyPrintOptions.Global(scope)
		{
			@Override
			public @Nullable Set<String> getReservedNames() {
				return null;
			}

			@Override
			public @Nullable Set<String> getRestrictedNames() {
				return null;
			}			
		};
		return options;
	}

	public Markup decode(@NonNull Comment comment, @Nullable Namespace scope) {
		String body = comment.getBody();
		if (body == null) {
			throw new NullPointerException("Missing Comment body");
		}
		IParseResult parseResult = MarkupUtils.decode(body);
		if (parseResult == null) {
			throw new NullPointerException("Missing ParseResult for \"" + body + "\"");
		}
		Markup markup = (Markup) parseResult.getRootASTElement();
		for (INode parseError : parseResult.getSyntaxErrors()) {
			System.out.println(parseError);
		}
		if (markup == null) {
			throw new NullPointerException("Missing parsed content for \"" + body + "\"");
		}
		return markup;
	}
	
	protected String emitBeginDefinition() {
//		return "#\\begin#{oclDefinition#}";
		return "#\\begin#{verbatim#}";
	}
	
	protected String emitEmphasis(@NonNull String name) {
		return "#\\oclEmph#{" + encodeSectionText(name) + "#}";
	}
	
	protected String emitEndDefinition() {
//		return "#\\end#{oclDefinition#}";
		return "#\\end#{verbatim#}";
	}
	
	protected String emitHeading0a(String name) {
		return name != null ? "#\\oclHeadingZero#{" + encodeSectionText(name) + "#}" : "";
	}
	
	protected String emitHeading0b(String name) {
		return name != null ? "#\\oclHeadingZero#{" + encodeSectionText(name) + "#}" : "";
	}
	
	protected String emitHeading1(String name, @Nullable String label) {
		return name != null ? "#\\oclHeadingOne#{" + encodeSectionText(name) + "#}" + emitLabel(label) : "";
	}
	
	protected String emitHeading2(String name, @Nullable String label) {
		return name != null ? "#\\oclHeadingTwo#{" + encodeSectionText(name) + "#}" + emitLabel(label) : "";
	}
	
	protected String emitHeading3(String name, @Nullable String label) {
		return name != null ? "#\\oclHeadingThree#{" + encodeSectionText(name) + "#}" + emitLabel(label) : "";
	}
	
	protected String emitHeading4(String name, @Nullable String label) {
		return name != null ? "#\\oclHeadingFour#{" + encodeSectionText(name) + "#}" + emitLabel(label) : "";
	}
	
	protected String emitLabel(@Nullable String label) {
		return label != null ? "#\\label#{" + encodeLabelText(label) + "#}" : "";
	}

	/**
	 * Re-encode latexContent to ensure that it is intelligible to LaTeX.
	 * <p>
	 * In: all characters as their logical equivalents. Anything that needs to be handled specially by
	 * LaTeX needs to have a # escape to avoid the application of LaTeX escapes such as textbackslash
	 * for characters that must not be misinterpreted by LaTeX.
	 * <p>
	 * Use "##" for "#", "#anything else for anything else", e.g. "#{" for a LaTeX "{".
	 */
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

	protected @NonNull List<Property> getSortedAssociations(@NonNull org.eclipse.ocl.examples.pivot.Class asClass) {
		Set<Property> allElements = new HashSet<Property>();
		for (Property asProperty : asClass.getOwnedProperties()) {
//			[let pAssociations : Sequence(Property) = pClass.ownedAttribute->select(e | not e.type.oclIsKindOf(DataType) and e.type.owningTemplateParameter->isEmpty())->asSequence()]
			if (!(asProperty.getType() instanceof DataType)) {
				allElements.add(asProperty);
			}
		}
		List<Property> sortedElements = new ArrayList<Property>(allElements);
		Collections.sort(sortedElements, nameableComparator);
		return sortedElements;
	}

	protected @NonNull List<Property> getSortedAttributes(@NonNull org.eclipse.ocl.examples.pivot.Class asClass) {
		Set<Property> allElements = new HashSet<Property>();
		for (Property asProperty : asClass.getOwnedProperties()) {
			if (asProperty.getType() instanceof DataType) {
				allElements.add(asProperty);
			}
		}
		List<Property> sortedElements = new ArrayList<Property>(allElements);
		Collections.sort(sortedElements, nameableComparator);
		return sortedElements;
	}

	protected @NonNull List<org.eclipse.ocl.examples.pivot.Class> getSortedClasses(@NonNull org.eclipse.ocl.examples.pivot.Package asPackage) {
		Set<org.eclipse.ocl.examples.pivot.Class> allElements = new HashSet<org.eclipse.ocl.examples.pivot.Class>();
		allElements.addAll(asPackage.getOwnedClasses());
		List<org.eclipse.ocl.examples.pivot.Class> sortedElements = new ArrayList<org.eclipse.ocl.examples.pivot.Class>(allElements);
		Collections.sort(sortedElements, nameableComparator);
		return sortedElements;
	}

	protected @NonNull List<Constraint> getSortedConstraints(@NonNull Operation asOperation) {
		Set<Constraint> allElements = new HashSet<Constraint>();
		for (Constraint asConstraint : asOperation.getOwnedRule()) {
			allElements.add(asConstraint);
		}
		List<Constraint> sortedElements = new ArrayList<Constraint>(allElements);
		Collections.sort(sortedElements, nameableComparator);
		return sortedElements;
	}

	protected @NonNull List<Iteration> getSortedIterations(@NonNull org.eclipse.ocl.examples.pivot.Class asClass) {
		Set<Iteration> allElements = new HashSet<Iteration>();
		for (Operation asOperation : asClass.getOwnedOperations()) {
			if (asOperation instanceof Iteration) {
				allElements.add((Iteration) asOperation);
			}
		}
		List<Iteration> sortedElements = new ArrayList<Iteration>(allElements);
		Collections.sort(sortedElements, iterationComparator);
		return sortedElements;
	}

	protected @NonNull List<Operation> getSortedOperations(@NonNull org.eclipse.ocl.examples.pivot.Class asClass) {
		Set<Operation> allElements = new HashSet<Operation>();
		for (Operation asOperation : asClass.getOwnedOperations()) {
			if (!(asOperation instanceof Iteration)) {
				allElements.add(asOperation);
			}
		}
		List<Operation> sortedElements = new ArrayList<Operation>(allElements);
		Collections.sort(sortedElements, operationComparator);
		return sortedElements;
	}

	protected @NonNull List<Constraint> getSortedPostconditions(@NonNull Operation asOperation) {
		Set<Constraint> allElements = new HashSet<Constraint>(asOperation.getPostcondition());
		List<Constraint> sortedElements = new ArrayList<Constraint>(allElements);
		Collections.sort(sortedElements, nameableComparator);
		return sortedElements;
	}

	protected @NonNull List<Constraint> getSortedPreconditions(@NonNull Operation asOperation) {
		Set<Constraint> allElements = new HashSet<Constraint>(asOperation.getPrecondition());
		List<Constraint> sortedElements = new ArrayList<Constraint>(allElements);
		Collections.sort(sortedElements, nameableComparator);
		return sortedElements;
	}

	protected String prettyPrint(@NonNull Comment comment, Namespace scope) {
		Markup markup = decode(comment, scope);
		StringBuilder s = new StringBuilder();
		for (MarkupElement element : markup.getElements()) {
			s.append(prettyPrint(element, scope));
		}
		return s.toString();
	}
	
	protected String prettyPrint(@NonNull Constraint constraint, Namespace scope) {
		PrettyPrintOptions options = createOptions(scope);
//		PrettyPrintExprVisitor visitor = new PrettyPrintExprVisitor(options);
		PrettyPrinter printer = PrettyPrinter.createPrinter(constraint, options);
		try {
			printer.appendElement(constraint);
			String string = printer.toString(options.getIndentStep(), options.getLinelength());
			//				System.out.println("Expr-prettyPrint : " + element.eClass().getName() + "/" + element.eClass().getName() + " => " + string);
			return string;
		}
		catch (Exception e) {
			e.printStackTrace();
			return printer.toString() + " ... " + e.getClass().getName() + " - " + e.getLocalizedMessage();
		}
	}

	protected String prettyPrint(@NonNull Element element, Namespace scope) {
		PrettyPrintOptions options = createOptions(scope);
		PrettyPrinter printer = PrettyPrinter.createNamePrinter(element, options);
		try {
			printer.appendElement(element);
			String string = printer.toString(options.getIndentStep(), options.getLinelength());
//			System.out.println("Name-prettyPrint : " + element.eClass().getName() + "/" + element.eClass().getName() + " => " + string);
			return string;
		}
		catch (Exception e) {
			e.printStackTrace();
			return printer.toString() + " ... " + e.getClass().getName() + " - " + e.getLocalizedMessage();
		}
	}

	protected String prettyPrint(MarkupElement element, Namespace scope) {
		return new MarkupToLaTeX(scope).doSwitch(element);
	}
}
