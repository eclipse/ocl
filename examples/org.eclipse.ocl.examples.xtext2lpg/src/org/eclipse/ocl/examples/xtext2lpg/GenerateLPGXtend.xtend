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
package org.eclipse.ocl.examples.xtext2lpg

import org.eclipse.jdt.annotation.NonNull
import org.eclipse.ocl.examples.xtext2lpg.XBNF.Syntax
import org.eclipse.ocl.examples.xtext2lpg.XBNF.LexerGrammar
import org.eclipse.ocl.examples.xtext2lpg.XBNF.ParserGrammar
import org.eclipse.ocl.examples.xtext2lpg.XBNF.TypedRule
import org.eclipse.ocl.examples.xtext2lpg.XBNF.AbstractRule
import org.eclipse.ocl.examples.xtext2lpg.XBNF.Disjunction
import org.eclipse.ocl.examples.xtext2lpg.XBNF.ActionAssignment
import org.eclipse.ocl.examples.xtext2lpg.XBNF.Epsilon
import org.eclipse.ocl.examples.xtext2lpg.XBNF.RuleCallAssignment
import org.eclipse.ocl.examples.xtext2lpg.XBNF.RuleCall
import org.eclipse.ocl.examples.xtext2lpg.XBNF.KeywordAssignment
import org.eclipse.ocl.examples.xtext2lpg.XBNF.Keyword
import org.eclipse.ocl.examples.xtext2lpg.XBNF.AbstractElement

public class GenerateLPGXtend extends GenerateLPGUtils
{
	@NonNull protected override String generateLPGKWLexer(@NonNull Syntax syntax) {
		generateKWLexer(syntax)
	}
	@NonNull protected override String generateLPGLexer(@NonNull Syntax syntax) {
		for (grammar : syntax.grammars) {
			if (grammar instanceof LexerGrammar) {
				return generateLexer(grammar);
			}
		}
		return "";
	}
	@NonNull protected override String generateLPGParser(@NonNull Syntax syntax) {
		for (grammar : syntax.grammars) {
			if (grammar instanceof ParserGrammar) {
				return generateParser(grammar);
			}
		}
		return "";
	}
	
 	protected def String generateKWLexer(Syntax syntax) {
		var keywordValues = syntax.getSortedKWValues();
		'''
		%options slr
		%options fp=«syntaxName»KWLexer,prefix=Char_
		%options noserialize
		%options package=«emitSyntaxPackage(syntax)»
		%options template=../lpg/KeywordTemplateF.gi
		%options export_terminals=("«syntaxName»Parsersym.java", "TK_")
		%options include_directory="../lpg"

		%Import
			KWLexerMapF.gi
		%End
		
		%Define

			--
			-- Definition of macros used in the template
			--
			$action_class /.$file_prefix./
			$eof_char /.Char_EOF./
			$copyright_contributions /.*./

		%End

		%Notice
			/./**
		 * «syntaxName» Keyword Lexer
		 * <copyright>
		 *******************************************************************************/
			./
		%End

		%Globals
			/../
		%End

		%Export
			«FOR keywordValue : keywordValues»
				«emitLabel(keywordValue)»
			«ENDFOR»
		%End

		%Start
			KeyWord
		%End

		%Rules

		-- The Goal for the parser is a single Keyword

			KeyWord ::=
				«FOR keywordValue : keywordValues SEPARATOR '\n\n| '»«FOR c : keywordValue.toCharArray() SEPARATOR ' '»«c»«ENDFOR»
				/.$BeginAction
					$setResult($_«emitLabel(keywordValue)»);
				  $EndAction
				./«ENDFOR»
		%End
		'''
	}

 	protected def String generateLexer(LexerGrammar grammar) {
		var syntax = grammar.syntax;
		var syntaxName = emitSyntaxName(syntax);
		var punctValues = getSortedPunctValues(syntax);
		var terminalRules = getSortedTerminalRules(syntax);
		var alphaChars = getSortedAlphaChars(syntax);
		var punctChars = getSortedPunctChars(syntax);
		'''
		%options escape=$
		%options la=2
		%options fp=«syntaxName»Lexer,prefix=Char_
		%options single-productions
		%options noserialize
		%options package=«emitSyntaxPackage(grammar.syntax)»
		%options template=../lpg/LexerTemplateF.gi
		%options filter=«syntaxName»KWLexer.gi
		%options export_terminals=("«syntaxName»Parsersym.java", "TK_")
		%options include_directory="../lpg"
		
		%Define
		
			--
			-- Definition of macro used in the included file LexerBasicMap.g
			-- We redefine that one defined by EssentialOCLLexer
			--
			$kw_lexer_class /.«syntaxName»KWLexer./
		
		%End
		
		%Export
			«FOR terminalRule : terminalRules»
				«terminalRule.name»
			«ENDFOR»
		
			«FOR keywordValue : punctValues»
				«emitLabel(keywordValue)»
			«ENDFOR»
		%End
		
		%Terminals
			«FOR c : alphaChars SEPARATOR ' '»«c»«ENDFOR»
			
			«FOR c : punctChars»
				«emitLabel(c)» ::= '«c»'
			«ENDFOR»
		%End
		
		%Start
			Token
		%End
		
		%Rules
		«FOR keywordValue : punctValues»
				Token ::= «FOR c : keywordValue.toCharArray() SEPARATOR ' '»'«c»'«ENDFOR»
					/.$BeginAction
								makeToken($_«emitLabel(keywordValue)»);
					  $EndAction
					./

		«ENDFOR»
		«FOR terminalRule : terminalRules»
				«terminalRule.name» ::= '#'
					/.$BeginAction
									makeToken($_«terminalRule.name»);
					  $EndAction
					./

		«ENDFOR»
		%End
		'''
	}

 	protected def String generateParser(ParserGrammar parser) {
		var syntax = parser.syntax;
		var syntaxName = emitSyntaxName(syntax);
		'''
		%options escape=$
		%options la=1
		%options fp=«syntaxName»Parser,prefix=TK_
		%options noserialize
		%options package=«emitSyntaxPackage(syntax)»
		%options import_terminals=«syntaxName»Lexer.gi
		%options ast_type=CSTNode
		%options template=dtParserTemplateF.gi
		%options include_directory=".;../lpg"
		
		%Start
		«FOR rule : parser.goals»
			«rule.name»
		«ENDFOR»
		%End
		
		%Notice
			/./**
		 *******************************************************************************/
			./
		%End
		
		%Globals
			/.
			/* imports */
			./
		%End
		
		--%KeyWords
		-- Reserved keywords
		--	body context def derive endpackage init inv package post pre static
		
		-- Restricted keywords
		--	OclMessage
		--%End
		
		%Terminals
			«FOR terminalRule : getSortedTerminalRules(syntax)»
				«terminalRule.name»
			«ENDFOR»
			
			«FOR keywordValue : getSortedPunctValues(syntax)»
				«emitLabel(keywordValue)» ::= '«keywordValue»'
			«ENDFOR»
		%End
		
		%Rules
		«FOR parserRule : getSortedParserRules(parser) SEPARATOR '\n'»
			«FOR rule : selectRules(parser.rules, parserRule.name)»
				«generateRule(rule)»
			«ENDFOR»
		«ENDFOR»
		%End
		'''
	}

	protected def String generateRule(TypedRule rule) {
		'''
		«generateDisjunction(rule)»
		«FOR subrule : getSortedSubRules(rule.subrules)»
			«generateDisjunction(subrule)»
		«ENDFOR»
		'''
	}

	protected def String generateDisjunction(AbstractRule rule) {
		'''
		«FOR conjunction : getSortedConjunctions(rule.element as Disjunction)»
		«rule.name» ::=«IF conjunction.elements.isEmpty()» %empty«ELSE»«FOR element : conjunction.elements» «generateTerm(element)»«ENDFOR»«ENDIF»
		«ENDFOR»
		'''
	}

	protected def String generateTerm(AbstractElement element) {
		switch element {
			ActionAssignment: return ""
			Epsilon: return "%empty"
			RuleCallAssignment: return element.referredRule.name
			RuleCall: return element.referredRule.name
			KeywordAssignment: return emitLabel(element.value)
			Keyword: return emitLabel(element.value)
			default: return "<<<" + element.eClass.name + ">>>"
		}		
	}
}
