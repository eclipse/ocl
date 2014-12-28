/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.ocl.pivot.SemanticException;
import org.eclipse.ocl.pivot.internal.utilities.HTMLBuffer;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.xtext.markup.MarkupStandaloneSetup;
import org.eclipse.ocl.xtext.markup.MarkupToHTML;
import org.eclipse.ocl.xtext.markup.MarkupToString;
import org.eclipse.ocl.xtext.markup.MarkupToTree;
import org.eclipse.ocl.xtext.markup.MarkupUtils;
import org.eclipse.ocl.xtext.markupcs.Markup;
import org.eclipse.ocl.xtext.markupcs.MarkupElement;
import org.eclipse.ocl.xtext.markupcs.MarkupPackage;
import org.eclipse.ocl.xtext.markupcs.NewLineElement;

public class MarkupTests extends XtextTestCase
{	
	protected MetaModelManager metaModelManager = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		MarkupStandaloneSetup.doSetup();
		MarkupPackage.eINSTANCE.eClass();
		metaModelManager = new MetaModelManager();
	}

	@Override
	protected void tearDown() throws Exception {
		metaModelManager.dispose();
		metaModelManager = null;
		super.tearDown();
	}

	protected @NonNull Markup doDecode(@NonNull String testString) throws IOException {
		InputStream inputStream = new URIConverter.ReadableInputStream(testString, "UTF-8");
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI("string.markupocl"));
		resource.load(inputStream, null);
		@SuppressWarnings("null") @NonNull Markup markup = (Markup) resource.getContents().get(0);
		Iterable<Diagnostic> parseErrors = resource.getErrors();
		StringBuilder s = null;
		for (Diagnostic parseError : parseErrors) {
			if (s == null) {
				 s = new StringBuilder("Testing '" + toPrintable(testString) + "'");
			}
			String syntaxErrorMessage = parseError.getMessage();
			s.append("\n  " + syntaxErrorMessage);
		}
		if (s != null) {
			System.out.println(MarkupToTree.toString(markup));
			fail(s.toString());
		}
		return markup;
	}

	protected void doBadHtmlTest(@NonNull String testString, @NonNull Class<?> exceptionClass) throws Exception {
		try {
			Markup markup = doDecode(testString);
			@SuppressWarnings({"unused", "null"})
			String testResult = MarkupToHTML.toString(metaModelManager, null, markup);
			fail(toPrintable(testString) + " expected " + exceptionClass.getName());
		} catch (Exception e) {
			assertEquals(toPrintable(testString), exceptionClass, e.getClass());
		}
	}

	protected void doHtmlTest(Object context, @NonNull String expected, @NonNull String testString) throws Exception {
		Markup markup = doDecode(testString);
		//		System.out.println(MarkupToTree.toString(markup));
		@SuppressWarnings("null")
		String testResult = MarkupToHTML.toString(metaModelManager, context, markup);
		assertEquals(toPrintable(testString), expected, testResult);
	}

	protected void doNewlineCountTest(int expectedCount, @NonNull String testString) throws IOException {
		Markup markup = doDecode(testString);		
		List<MarkupElement> elements = markup.getElements();
		assert elements.size() == 1;
		NewLineElement newLineElement = (NewLineElement) elements.get(0);
		assert newLineElement != null;
		int actualCount = MarkupUtils.getNewlineCount(newLineElement);
		if (expectedCount != actualCount) {
			assertEquals(toPrintable(testString), expectedCount, actualCount);
		}
	}

	protected void doStringTest(@NonNull String testString) throws IOException {
		Markup markup = doDecode(testString);
		String testResult = MarkupToString.toString(markup);
		if (!testString.equals(testResult)) {
			String context = "Testing '" + toPrintable(testString) + "'\n";
			System.out.println(context + MarkupToTree.toString(markup));
			assertEquals(context, testString, testResult);
		}
	}

	protected String htmlEncode(@NonNull String string) {
		HTMLBuffer html = new HTMLBuffer();
		html.append(string);
		return html.toString();
	}

	protected String toPrintable(@NonNull String testString) {
		return testString.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
	}

	public void testFigures() throws Exception {
		doHtmlTest(null, "the <img src=\"x.png\"> title", "the figure[\"x.png\"] title");
		doHtmlTest(null, "the <img src=\"x.png\" alt=\"X\"> title", "the figure[\"x.png\",\"X\"] title");
		doHtmlTest(null, "the <img src=\"x.png\" alt=\"X\" width=\"22\"> title", "the figure[\"x.png\",\"X\",22] title");
	}

	public void testFigureRefs() throws Exception {
		doHtmlTest(null, "<a href=\"#FigName\"></a> <a name=\"FigName\"></a><img src=\"x.png\">", "figureRef[FigName] figure#FigName[\"x.png\"]");
		doBadHtmlTest("figureRef[FigName] figure#figname[\"x.png\"]", IllegalStateException.class);
	}

	public void testFonts() throws Exception {
		doHtmlTest(null, "a <b>c</b> d", "a b[c] d");
		doHtmlTest(null, "<b><i> g </i></b>", "b[e[ g ]]");
	}

	public void testFootnotes() throws Exception {
		doHtmlTest(null, "aa <footnote>xx\n<p>\nyy</footnote> bb", "aa footnote[xx\n\nyy] bb");
	}

	public void testHeadings() throws Exception {
		doHtmlTest(null, "<h1>xx</h1>", "heading[xx]");
		doHtmlTest(null, "<h4>xx</h4>", "heading:4[xx]");
		doHtmlTest(null, "<h2>xx <h3>yy</h3> zz</h2>", "heading:2[xx heading:3[yy] zz]");
	}

	public void testNewlines() throws IOException {
		doNewlineCountTest(1, "\r");
		doNewlineCountTest(1, "\n");
		doNewlineCountTest(1, "\n\r");
		doNewlineCountTest(1, "\r\n");
		doNewlineCountTest(2, "\n\t\r");
		doNewlineCountTest(2, "\r\t\n");
		doNewlineCountTest(2, "\n\r\n");
		doNewlineCountTest(2, "\r\n\r");
		doNewlineCountTest(2, "\n\r\n");
		doNewlineCountTest(2, "\r\n\r");
		doNewlineCountTest(2, "\n\r\n\r");
		doNewlineCountTest(2, "\r\n\r\n");
		doNewlineCountTest(2, "\n\r\n\r");
		doNewlineCountTest(2, "\r\n\r\n");
		doNewlineCountTest(2, "\n\r \n\r");
		doNewlineCountTest(2, "\r\n \r\n");
		doNewlineCountTest(2, "\n\r \n\r");
		doNewlineCountTest(2, "\r\n \r\n");
		doNewlineCountTest(3, "\n\r\n \r");
		doNewlineCountTest(3, "\r\n\r \n");
		doNewlineCountTest(3, "\n\r\n \r");
		doNewlineCountTest(3, "\r\n\r \n");
	}

	public void testOCLEval() throws Exception {
//		doHtmlTest(null, "45", "oclEval[5a9]");
		doHtmlTest(null, "45", "oclEval[5*9]");
		doHtmlTest(EcorePackage.Literals.EBIG_DECIMAL, "EBigDecimal", "oclEval[self.name]");
		doHtmlTest(null, "true", "oclEval[null->isEmpty()]");
		doHtmlTest(null, "true", "oclEval[null->isEmpty()]");
	}

	public void testOCLText() throws Exception {
		doHtmlTest(null, "<tt>" + htmlEncode("null->isEmpty()") + "</tt>", "oclText[null->isEmpty()]");
		doBadHtmlTest("oclText[null->isBad()]", SemanticException.class);
	}

	public void testStrings() throws IOException {
		doStringTest("a b[c] d");
		doStringTest("a\rb\n\rc\t\nd");
		doStringTest("oclEval[a.c[4]]");
		doStringTest("oclEval[a.b[4]]");
		doStringTest("\\[1234\\]");
	}
}
