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
package org.eclipse.ocl.examples.xtext.completeocl.formatting;

import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.ClassifierContextDeclCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.CompleteOCLNavigationOperatorCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.ConstraintCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.DefOperationCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.DefPropertyCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.ImportCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.OperationContextDeclCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.PackageDeclarationCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.PropertyContextDeclCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.formatting.AbstractEssentialOCLFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 */
public class CompleteOCLFormatter extends AbstractEssentialOCLFormatter
{
	@Override
	protected void configureFormatting(FormattingConfig c) {

	    c.setAutoLinewrap(120);

		CompleteOCLGrammarAccess f = (CompleteOCLGrammarAccess) getGrammarAccess();
	    
		configureCollectionLiteralExpCS(c, f.getCollectionLiteralExpCSAccess());
		configureCollectionTypeCS(c, f.getCollectionTypeCSAccess());
		configureCurlyBracketedClauseCS(c, f.getCurlyBracketedClauseCSAccess());
	    configureEssentialOCLNavigationOperatorCS(c, f.getEssentialOCLNavigationOperatorCSAccess());
		configureIfExpCS(c, f.getIfExpCSAccess());
		configureLetExpCS(c, f.getLetExpCSAccess());
		configureMultiplicityBoundsCS(c, f.getMultiplicityBoundsCSAccess());
		configureMultiplicityCS(c, f.getMultiplicityCSAccess());
		configureMultiplicityStringCS(c, f.getMultiplicityStringCSAccess());
	    configureNameExpCS(c, f.getNameExpCSAccess());
	    configureNavigatingCommaArgCS(c, f.getNavigatingCommaArgCSAccess());
	    configureNavigatingSemiArgCS(c, f.getNavigatingSemiArgCSAccess());
	    configureNestedExpCS(c, f.getNestedExpCSAccess());
	    configurePathNameCS(c, f.getPathNameCSAccess());
	    configurePrimaryExpCS(c, f.getPrimaryExpCSAccess());
		configureRoundBracketedClauseCS(c, f.getRoundBracketedClauseCSAccess());
		configureSquareBracketedClauseCS(c, f.getSquareBracketedClauseCSAccess());
	    configureTupleLiteralExpCS(c, f.getTupleLiteralExpCSAccess());
	    configureTupleTypeCS(c, f.getTupleTypeCSAccess());
	    configureURIPathNameCS(c, f.getURIPathNameCSAccess());

	    c.setLinewrap(2).before(f.getML_COMMENTRule());
	    c.setLinewrap(1).after(f.getML_COMMENTRule());

	    {
			ClassifierContextDeclCSElements a = f.getClassifierContextDeclCSAccess();
		    c.setLinewrap(2).before(a.getContextKeyword_0());
			c.setLinewrap(2).before(a.getInvKeyword_3_0_0());
	    }
	    {
			CompleteOCLNavigationOperatorCSElements a = f.getCompleteOCLNavigationOperatorCSAccess();
			c.setNoSpace().before(a.getNameCircumflexAccentKeyword_0_0());
			c.setNoSpace().after(a.getNameCircumflexAccentKeyword_0_0());
			c.setLinewrap().before(a.getNameCircumflexAccentCircumflexAccentKeyword_0_1());
			c.setNoSpace().after(a.getNameCircumflexAccentCircumflexAccentKeyword_0_1());
		}
	    {
			ConstraintCSElements a = f.getConstraintCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_0_1_0());
			c.setNoSpace().around(a.getRightParenthesisKeyword_0_1_2());
			setNoSpaceLineWrap(c, a.getColonKeyword_1());
		    c.setLinewrap(2).after(a.getSpecificationAssignment_2());
//		    c.setIndentation(a.getColonKeyword_2(), a.getWSTerminalRuleCall_4());
	    }
	    {
			DefOperationCSElements a = f.getDefOperationCSAccess();
		    c.setLinewrap(2).before(a.getDefKeyword_1());
			setNoSpaceLineWrap(c, a.getColonKeyword_3());
		    c.setNoSpace().around(a.getLeftParenthesisKeyword_5());
		    c.setNoSpace().before(a.getCommaKeyword_6_1_0());
		    c.setNoSpace().before(a.getRightParenthesisKeyword_7());
			setNoSpaceLineWrap(c, a.getColonKeyword_8());
		    c.setLinewrap(2).after(a.getSpecificationAssignment_11());
	    }
	    {
			DefPropertyCSElements a = f.getDefPropertyCSAccess();
		    c.setLinewrap(2).before(a.getDefKeyword_1());
			setNoSpaceLineWrap(c, a.getColonKeyword_3());
		    c.setLinewrap(2).after(a.getSpecificationAssignment_8());
	    }
	    {
	    }
	    {
			ImportCSElements a = f.getImportCSAccess();
		    c.setLinewrap().before(a.getImportKeyword_0());
			c.setNoSpace().around(a.getAllColonColonKeyword_3_0_0());	
			c.setNoSpace().around(a.getAsteriskKeyword_3_1());	
		    c.setLinewrap().after(a.getAllAssignment_3_0());
	    }
	    {
			OperationContextDeclCSElements a = f.getOperationContextDeclCSAccess();
		    c.setLinewrap(2).before(a.getContextKeyword_0());
			c.setNoSpace().around(a.getLeftParenthesisKeyword_2());
			c.setNoSpace().before(a.getCommaKeyword_3_1_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_4());
		    c.setLinewrap(1).after(a.getOwnedTypeAssignment_6());
		    c.setIndentation(a.getLeftParenthesisKeyword_2(), a.getRightParenthesisKeyword_4());
			c.setLinewrap(2).before(a.getPreKeyword_7_0_0());
			c.setLinewrap(2).before(a.getPostKeyword_7_1_0());
			c.setLinewrap(2).before(a.getBodyKeyword_7_2_0());
			setNoSpaceLineWrap(c, a.getColonKeyword_7_2_2());
		    c.setLinewrap(2).after(a.getBodiesAssignment_7_2_3());
	    }
	    {
	    	PackageDeclarationCSElements a = f.getPackageDeclarationCSAccess();
		    c.setLinewrap(2).before(a.getPackageKeyword_0());
		    c.setLinewrap(2).before(a.getEndpackageKeyword_3());
		    c.setLinewrap(2).after(a.getEndpackageKeyword_3());
			c.setIndentation(a.getPackageKeyword_0(), a.getEndpackageKeyword_3());
	    }
	    {
	    	PropertyContextDeclCSElements a = f.getPropertyContextDeclCSAccess();
		    c.setLinewrap(2).before(a.getContextKeyword_0());
		    c.setLinewrap(1).after(a.getOwnedTypeAssignment_3());
			c.setLinewrap(2).before(a.getDeriveKeyword_4_0_0());
			c.setLinewrap(2).before(a.getInitKeyword_4_1_0());
			setNoSpaceLineWrap(c, a.getColonKeyword_4_1_1());
		    c.setLinewrap(2).after(a.getDefaultExpressionsAssignment_4_1_2());
//		    c.setLinewrap(2).before(a.getDeriveKeyword_0());
	    }
	    {	// comments
	    	c.setNoLinewrap().before(f.getSL_COMMENTRule());
	    }
	}
}
