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
package org.eclipse.ocl.examples.xtext.essentialocl.formatting;

import org.eclipse.ocl.examples.xtext.base.formatting.AbstractBaseFormatter;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.CollectionLiteralExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.CollectionTypeCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.EssentialOCLNavigationOperatorCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.IfExpCSElements;
//import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.IndexExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.LetExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.MultiplicityBoundsCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.MultiplicityCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.MultiplicityStringCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.NavigatingCommaArgCSElements;
//import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.NavigatingExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.NavigatingSemiArgCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.NestedExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.PathNameCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.PrimaryExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.TupleLiteralExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.TupleTypeCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.URIPathNameCSElements;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public abstract class AbstractEssentialOCLFormatter extends AbstractBaseFormatter
{
	protected void configureCollectionLiteralExpCS(FormattingConfig c, CollectionLiteralExpCSElements a) {
		c.setNoSpace().around(a.getLeftCurlyBracketKeyword_1());
		c.setNoSpace().before(a.getCommaKeyword_2_1_0());
		c.setNoSpace().before(a.getRightCurlyBracketKeyword_3());
		c.setIndentation(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_3());
	}

	protected void configureCollectionTypeCS(FormattingConfig c, CollectionTypeCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_1_2());
	}

	protected void configureIfExpCS(FormattingConfig c, IfExpCSElements a) {
		c.setLinewrap().after(a.getConditionAssignment_1());
		c.setLinewrap().after(a.getThenExpressionAssignment_3());
		c.setLinewrap().after(a.getElseExpressionAssignment_5());
		c.setIndentation(a.getIfKeyword_0(), a.getThenKeyword_2());
		c.setIndentation(a.getThenKeyword_2(), a.getElseKeyword_4());
		c.setIndentation(a.getElseKeyword_4(), a.getEndifKeyword_6());
	}

	protected void configureLetExpCS(FormattingConfig c, LetExpCSElements a) {
		c.setIndentation(a.getLetKeyword_0(), a.getInKeyword_3());
		c.setLinewrap().before(a.getLetKeyword_0());
		c.setLinewrap().before(a.getInKeyword_3());
		c.setIndentation(a.getInKeyword_3(), a.getGroup());
	}

	protected void configureMultiplicityBoundsCS(FormattingConfig c, MultiplicityBoundsCSElements a) {
		c.setNoSpace().around(a.getFullStopFullStopKeyword_1_0());
    }

	protected void configureMultiplicityCS(FormattingConfig c, MultiplicityCSElements a) {
		c.setNoSpace().around(a.getLeftSquareBracketKeyword_0());	
		c.setNoSpace().before(a.getRightSquareBracketKeyword_2());	
	    c.setIndentation(a.getLeftSquareBracketKeyword_0(), a.getRightSquareBracketKeyword_2());
    }

	protected void configureMultiplicityStringCS(FormattingConfig c, MultiplicityStringCSElements a) {
		c.setNoSpace().around(a.getStringBoundsAsteriskKeyword_0_0());
		c.setNoSpace().around(a.getStringBoundsPlusSignKeyword_0_1());
		c.setNoSpace().around(a.getStringBoundsQuestionMarkKeyword_0_2());
    }

	protected void configureNavigatingCommaArgCS(FormattingConfig c, NavigatingCommaArgCSElements a) {
		c.setNoSpace().before(a.getPrefixCommaKeyword_0_0());
	}

	protected void configureNavigatingSemiArgCS(FormattingConfig c, NavigatingSemiArgCSElements a) {
		c.setNoSpace().before(a.getPrefixSemicolonKeyword_0_0());
	}

	protected void configureEssentialOCLNavigationOperatorCS(FormattingConfig c, EssentialOCLNavigationOperatorCSElements a) {
		c.setNoSpace().before(a.getNameFullStopKeyword_0_0());
		c.setNoSpace().after(a.getNameFullStopKeyword_0_0());
		c.setLinewrap().before(a.getNameHyphenMinusGreaterThanSignKeyword_0_1());
		c.setNoSpace().after(a.getNameHyphenMinusGreaterThanSignKeyword_0_1());
	}

	protected void configureNestedExpCS(FormattingConfig c, NestedExpCSElements a) {
		c.setNoSpace().after(a.getLeftParenthesisKeyword_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_2());
	}

	protected void configurePathNameCS(FormattingConfig c, PathNameCSElements a) {
	    c.setNoSpace().around(a.getColonColonKeyword_1_0());
	}

	protected void configurePrimaryExpCS(FormattingConfig c, PrimaryExpCSElements a) {
		c.setNoSpace().around(a.getLeftSquareBracketKeyword_7_2_0_1());
		c.setNoSpace().before(a.getCommaKeyword_7_2_0_3_0());
		c.setNoSpace().before(a.getRightSquareBracketKeyword_7_2_0_4());
	    c.setIndentation(a.getLeftSquareBracketKeyword_7_2_0_1(), a.getRightSquareBracketKeyword_7_2_0_4());
		c.setNoSpace().around(a.getLeftSquareBracketKeyword_7_2_0_5_0());
		c.setNoSpace().before(a.getCommaKeyword_7_2_0_5_2_0());
		c.setNoSpace().before(a.getRightSquareBracketKeyword_7_2_0_5_3());
	    c.setIndentation(a.getLeftSquareBracketKeyword_7_2_0_5_0(), a.getRightSquareBracketKeyword_7_2_0_5_3());
		c.setNoSpace().after(a.getAtPreCommercialAtKeyword_7_2_0_6_0_0());
		c.setNoSpace().around(a.getLeftCurlyBracketKeyword_7_2_1_1());
		c.setNoSpace().before(a.getCommaKeyword_7_2_1_2_0_1_0());
		c.setNoSpace().around(a.getRightCurlyBracketKeyword_7_2_1_3());
	    c.setIndentation(a.getLeftCurlyBracketKeyword_7_2_1_1(), a.getRightCurlyBracketKeyword_7_2_1_3());
		c.setNoSpace().after(a.getAtPreCommercialAtKeyword_7_2_2_0_0_0());
		c.setNoSpace().around(a.getLeftParenthesisKeyword_7_2_2_1_1());
		c.setNoSpace().before(a.getRightParenthesisKeyword_7_2_2_1_3());
	    c.setIndentation(a.getLeftParenthesisKeyword_7_2_2_1_1(), a.getRightParenthesisKeyword_7_2_2_1_3());
	}

	protected void configureTupleLiteralExpCS(FormattingConfig c, TupleLiteralExpCSElements a) {
		c.setNoSpace().around(a.getLeftCurlyBracketKeyword_1());
		c.setNoSpace().before(a.getCommaKeyword_3_0());
		c.setNoSpace().before(a.getRightCurlyBracketKeyword_4());
		c.setIndentation(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_4());
	}

	protected void configureTupleTypeCS(FormattingConfig c, TupleTypeCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1_0());
		c.setNoSpace().before(a.getCommaKeyword_1_1_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_1_2());
		c.setIndentation(a.getLeftParenthesisKeyword_1_0(), a.getRightParenthesisKeyword_1_2());
	}

	protected void configureURIPathNameCS(FormattingConfig c, URIPathNameCSElements a) {
	    c.setNoSpace().around(a.getColonColonKeyword_1_0());
	}
}
