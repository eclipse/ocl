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
package org.eclipse.ocl.examples.xtext.base.formatting;

import org.eclipse.ocl.examples.xtext.base.services.BaseGrammarAccess.MultiplicityBoundsCSElements;
import org.eclipse.ocl.examples.xtext.base.services.BaseGrammarAccess.MultiplicityCSElements;
import org.eclipse.ocl.examples.xtext.base.services.BaseGrammarAccess.MultiplicityStringCSElements;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 */
public abstract class AbstractBaseFormatter extends AbstractDeclarativeFormatter
{
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
	
	public void setBraces(FormattingConfig c, Keyword leftBrace, Keyword rightBrace) {
		c.setIndentation(leftBrace, rightBrace);
	    c.setLinewrap().before(leftBrace);
	    c.setLinewrap().after(leftBrace);
	    c.setLinewrap().before(rightBrace);
	    c.setLinewrap().after(rightBrace);
	}

	public void setAppendedBraces(FormattingConfig c, Keyword leftBrace, Keyword rightBrace) {
		c.setIndentation(leftBrace, rightBrace);
	    c.setNoLinewrap().before(leftBrace);
	    c.setLinewrap().after(leftBrace);
	    c.setLinewrap().before(rightBrace);
	    c.setLinewrap().after(rightBrace);
	}

	public void setNoSpaceLineWrap(FormattingConfig c, Keyword semicolon) {
		c.setNoSpace().before(semicolon);
	    c.setLinewrap().after(semicolon);
	}
}
