package org.eclipse.ocl.xtext.markup.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.ocl.xtext.markup.services.MarkupGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalMarkupParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_WORD", "RULE_INT", "RULE_WS", "RULE_STRING", "RULE_NL", "RULE_NUMBER", "RULE_LETTER", "RULE_ESCAPED", "RULE_VERTICAL_WS", "RULE_HORIZONTAL_WS", "RULE_ANY_OTHER", "'b'", "'e'", "'bullet'", "'figure'", "'figureRef'", "'footnote'", "'heading'", "'oclCode'", "'oclEval'", "'oclText'", "':'", "'#'", "','", "'['", "']'"
    };
    public static final int RULE_ESCAPED=12;
    public static final int RULE_WORD=5;
    public static final int RULE_STRING=8;
    public static final int RULE_VERTICAL_WS=13;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int RULE_ID=4;
    public static final int RULE_WS=7;
    public static final int RULE_HORIZONTAL_WS=14;
    public static final int RULE_ANY_OTHER=15;
    public static final int RULE_NUMBER=10;
    public static final int RULE_LETTER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int RULE_NL=9;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMarkupParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMarkupParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMarkupParser.tokenNames; }
    public String getGrammarFileName() { return "../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g"; }


     
     	private MarkupGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(MarkupGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleMarkup"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:68:1: entryRuleMarkup : ruleMarkup EOF ;
    public final void entryRuleMarkup() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:69:1: ( ruleMarkup EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:70:1: ruleMarkup EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMarkupRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkup_in_entryRuleMarkup67);
            ruleMarkup();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMarkupRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMarkup74); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMarkup"


    // $ANTLR start "ruleMarkup"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:77:1: ruleMarkup : ( ( rule__Markup__ElementsAssignment )* ) ;
    public final void ruleMarkup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:81:2: ( ( ( rule__Markup__ElementsAssignment )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:82:1: ( ( rule__Markup__ElementsAssignment )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:82:1: ( ( rule__Markup__ElementsAssignment )* )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:83:1: ( rule__Markup__ElementsAssignment )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMarkupAccess().getElementsAssignment()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:84:1: ( rule__Markup__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_WS)||LA1_0==RULE_NL||(LA1_0>=16 && LA1_0<=29)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:84:2: rule__Markup__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Markup__ElementsAssignment_in_ruleMarkup100);
            	    rule__Markup__ElementsAssignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMarkupAccess().getElementsAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMarkup"


    // $ANTLR start "entryRuleMarkupKeyword"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:96:1: entryRuleMarkupKeyword : ruleMarkupKeyword EOF ;
    public final void entryRuleMarkupKeyword() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:97:1: ( ruleMarkupKeyword EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:98:1: ruleMarkupKeyword EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMarkupKeywordRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupKeyword_in_entryRuleMarkupKeyword128);
            ruleMarkupKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMarkupKeywordRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMarkupKeyword135); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMarkupKeyword"


    // $ANTLR start "ruleMarkupKeyword"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:105:1: ruleMarkupKeyword : ( ( rule__MarkupKeyword__Alternatives ) ) ;
    public final void ruleMarkupKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:109:2: ( ( ( rule__MarkupKeyword__Alternatives ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:110:1: ( ( rule__MarkupKeyword__Alternatives ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:110:1: ( ( rule__MarkupKeyword__Alternatives ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:111:1: ( rule__MarkupKeyword__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMarkupKeywordAccess().getAlternatives()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:112:1: ( rule__MarkupKeyword__Alternatives )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:112:2: rule__MarkupKeyword__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__MarkupKeyword__Alternatives_in_ruleMarkupKeyword161);
            rule__MarkupKeyword__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMarkupKeywordAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMarkupKeyword"


    // $ANTLR start "entryRuleMarkupElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:124:1: entryRuleMarkupElement : ruleMarkupElement EOF ;
    public final void entryRuleMarkupElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:125:1: ( ruleMarkupElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:126:1: ruleMarkupElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMarkupElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_entryRuleMarkupElement188);
            ruleMarkupElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMarkupElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMarkupElement195); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMarkupElement"


    // $ANTLR start "ruleMarkupElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:133:1: ruleMarkupElement : ( ( rule__MarkupElement__Alternatives ) ) ;
    public final void ruleMarkupElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:137:2: ( ( ( rule__MarkupElement__Alternatives ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:138:1: ( ( rule__MarkupElement__Alternatives ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:138:1: ( ( rule__MarkupElement__Alternatives ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:139:1: ( rule__MarkupElement__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMarkupElementAccess().getAlternatives()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:140:1: ( rule__MarkupElement__Alternatives )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:140:2: rule__MarkupElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__MarkupElement__Alternatives_in_ruleMarkupElement221);
            rule__MarkupElement__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMarkupElementAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMarkupElement"


    // $ANTLR start "entryRuleBulletElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:152:1: entryRuleBulletElement : ruleBulletElement EOF ;
    public final void entryRuleBulletElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:153:1: ( ruleBulletElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:154:1: ruleBulletElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBulletElement_in_entryRuleBulletElement248);
            ruleBulletElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBulletElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBulletElement255); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBulletElement"


    // $ANTLR start "ruleBulletElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:161:1: ruleBulletElement : ( ( rule__BulletElement__Group__0 ) ) ;
    public final void ruleBulletElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:165:2: ( ( ( rule__BulletElement__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:166:1: ( ( rule__BulletElement__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:166:1: ( ( rule__BulletElement__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:167:1: ( rule__BulletElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:168:1: ( rule__BulletElement__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:168:2: rule__BulletElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group__0_in_ruleBulletElement281);
            rule__BulletElement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBulletElementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBulletElement"


    // $ANTLR start "entryRuleFontElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:180:1: entryRuleFontElement : ruleFontElement EOF ;
    public final void entryRuleFontElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:181:1: ( ruleFontElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:182:1: ruleFontElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFontElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFontElement_in_entryRuleFontElement308);
            ruleFontElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFontElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFontElement315); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFontElement"


    // $ANTLR start "ruleFontElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:189:1: ruleFontElement : ( ( rule__FontElement__Group__0 ) ) ;
    public final void ruleFontElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:193:2: ( ( ( rule__FontElement__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:194:1: ( ( rule__FontElement__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:194:1: ( ( rule__FontElement__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:195:1: ( rule__FontElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFontElementAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:196:1: ( rule__FontElement__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:196:2: rule__FontElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FontElement__Group__0_in_ruleFontElement341);
            rule__FontElement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFontElementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFontElement"


    // $ANTLR start "entryRuleFigureElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:208:1: entryRuleFigureElement : ruleFigureElement EOF ;
    public final void entryRuleFigureElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:209:1: ( ruleFigureElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:210:1: ruleFigureElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFigureElement_in_entryRuleFigureElement368);
            ruleFigureElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFigureElement375); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFigureElement"


    // $ANTLR start "ruleFigureElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:217:1: ruleFigureElement : ( ( rule__FigureElement__Group__0 ) ) ;
    public final void ruleFigureElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:221:2: ( ( ( rule__FigureElement__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:222:1: ( ( rule__FigureElement__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:222:1: ( ( rule__FigureElement__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:223:1: ( rule__FigureElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:224:1: ( rule__FigureElement__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:224:2: rule__FigureElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group__0_in_ruleFigureElement401);
            rule__FigureElement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFigureElement"


    // $ANTLR start "entryRuleFigureRefElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:236:1: entryRuleFigureRefElement : ruleFigureRefElement EOF ;
    public final void entryRuleFigureRefElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:237:1: ( ruleFigureRefElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:238:1: ruleFigureRefElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureRefElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFigureRefElement_in_entryRuleFigureRefElement428);
            ruleFigureRefElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureRefElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFigureRefElement435); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFigureRefElement"


    // $ANTLR start "ruleFigureRefElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:245:1: ruleFigureRefElement : ( ( rule__FigureRefElement__Group__0 ) ) ;
    public final void ruleFigureRefElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:249:2: ( ( ( rule__FigureRefElement__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:250:1: ( ( rule__FigureRefElement__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:250:1: ( ( rule__FigureRefElement__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:251:1: ( rule__FigureRefElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureRefElementAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:252:1: ( rule__FigureRefElement__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:252:2: rule__FigureRefElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureRefElement__Group__0_in_ruleFigureRefElement461);
            rule__FigureRefElement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureRefElementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFigureRefElement"


    // $ANTLR start "entryRuleFootnoteElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:264:1: entryRuleFootnoteElement : ruleFootnoteElement EOF ;
    public final void entryRuleFootnoteElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:265:1: ( ruleFootnoteElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:266:1: ruleFootnoteElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFootnoteElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFootnoteElement_in_entryRuleFootnoteElement488);
            ruleFootnoteElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFootnoteElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFootnoteElement495); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFootnoteElement"


    // $ANTLR start "ruleFootnoteElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:273:1: ruleFootnoteElement : ( ( rule__FootnoteElement__Group__0 ) ) ;
    public final void ruleFootnoteElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:277:2: ( ( ( rule__FootnoteElement__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:278:1: ( ( rule__FootnoteElement__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:278:1: ( ( rule__FootnoteElement__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:279:1: ( rule__FootnoteElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFootnoteElementAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:280:1: ( rule__FootnoteElement__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:280:2: rule__FootnoteElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FootnoteElement__Group__0_in_ruleFootnoteElement521);
            rule__FootnoteElement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFootnoteElementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFootnoteElement"


    // $ANTLR start "entryRuleHeadingElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:292:1: entryRuleHeadingElement : ruleHeadingElement EOF ;
    public final void entryRuleHeadingElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:293:1: ( ruleHeadingElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:294:1: ruleHeadingElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHeadingElement_in_entryRuleHeadingElement548);
            ruleHeadingElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHeadingElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHeadingElement555); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHeadingElement"


    // $ANTLR start "ruleHeadingElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:301:1: ruleHeadingElement : ( ( rule__HeadingElement__Group__0 ) ) ;
    public final void ruleHeadingElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:305:2: ( ( ( rule__HeadingElement__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:306:1: ( ( rule__HeadingElement__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:306:1: ( ( rule__HeadingElement__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:307:1: ( rule__HeadingElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:308:1: ( rule__HeadingElement__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:308:2: rule__HeadingElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group__0_in_ruleHeadingElement581);
            rule__HeadingElement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHeadingElementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHeadingElement"


    // $ANTLR start "entryRuleNewLineElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:320:1: entryRuleNewLineElement : ruleNewLineElement EOF ;
    public final void entryRuleNewLineElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:321:1: ( ruleNewLineElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:322:1: ruleNewLineElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewLineElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNewLineElement_in_entryRuleNewLineElement608);
            ruleNewLineElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewLineElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNewLineElement615); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNewLineElement"


    // $ANTLR start "ruleNewLineElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:329:1: ruleNewLineElement : ( ( rule__NewLineElement__TextAssignment ) ) ;
    public final void ruleNewLineElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:333:2: ( ( ( rule__NewLineElement__TextAssignment ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:334:1: ( ( rule__NewLineElement__TextAssignment ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:334:1: ( ( rule__NewLineElement__TextAssignment ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:335:1: ( rule__NewLineElement__TextAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewLineElementAccess().getTextAssignment()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:336:1: ( rule__NewLineElement__TextAssignment )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:336:2: rule__NewLineElement__TextAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__NewLineElement__TextAssignment_in_ruleNewLineElement641);
            rule__NewLineElement__TextAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewLineElementAccess().getTextAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNewLineElement"


    // $ANTLR start "entryRuleNullElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:348:1: entryRuleNullElement : ruleNullElement EOF ;
    public final void entryRuleNullElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:349:1: ( ruleNullElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:350:1: ruleNullElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullElement_in_entryRuleNullElement668);
            ruleNullElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNullElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullElement675); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNullElement"


    // $ANTLR start "ruleNullElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:357:1: ruleNullElement : ( ( rule__NullElement__Group__0 ) ) ;
    public final void ruleNullElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:361:2: ( ( ( rule__NullElement__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:362:1: ( ( rule__NullElement__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:362:1: ( ( rule__NullElement__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:363:1: ( rule__NullElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullElementAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:364:1: ( rule__NullElement__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:364:2: rule__NullElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullElement__Group__0_in_ruleNullElement701);
            rule__NullElement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNullElementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNullElement"


    // $ANTLR start "entryRuleOCLCodeElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:376:1: entryRuleOCLCodeElement : ruleOCLCodeElement EOF ;
    public final void entryRuleOCLCodeElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:377:1: ( ruleOCLCodeElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:378:1: ruleOCLCodeElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLCodeElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOCLCodeElement_in_entryRuleOCLCodeElement728);
            ruleOCLCodeElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLCodeElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOCLCodeElement735); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOCLCodeElement"


    // $ANTLR start "ruleOCLCodeElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:385:1: ruleOCLCodeElement : ( ( rule__OCLCodeElement__Group__0 ) ) ;
    public final void ruleOCLCodeElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:389:2: ( ( ( rule__OCLCodeElement__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:390:1: ( ( rule__OCLCodeElement__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:390:1: ( ( rule__OCLCodeElement__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:391:1: ( rule__OCLCodeElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLCodeElementAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:392:1: ( rule__OCLCodeElement__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:392:2: rule__OCLCodeElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLCodeElement__Group__0_in_ruleOCLCodeElement761);
            rule__OCLCodeElement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLCodeElementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOCLCodeElement"


    // $ANTLR start "entryRuleOCLEvalElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:404:1: entryRuleOCLEvalElement : ruleOCLEvalElement EOF ;
    public final void entryRuleOCLEvalElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:405:1: ( ruleOCLEvalElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:406:1: ruleOCLEvalElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLEvalElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOCLEvalElement_in_entryRuleOCLEvalElement788);
            ruleOCLEvalElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLEvalElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOCLEvalElement795); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOCLEvalElement"


    // $ANTLR start "ruleOCLEvalElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:413:1: ruleOCLEvalElement : ( ( rule__OCLEvalElement__Group__0 ) ) ;
    public final void ruleOCLEvalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:417:2: ( ( ( rule__OCLEvalElement__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:418:1: ( ( rule__OCLEvalElement__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:418:1: ( ( rule__OCLEvalElement__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:419:1: ( rule__OCLEvalElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLEvalElementAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:420:1: ( rule__OCLEvalElement__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:420:2: rule__OCLEvalElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLEvalElement__Group__0_in_ruleOCLEvalElement821);
            rule__OCLEvalElement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLEvalElementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOCLEvalElement"


    // $ANTLR start "entryRuleOCLTextElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:432:1: entryRuleOCLTextElement : ruleOCLTextElement EOF ;
    public final void entryRuleOCLTextElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:433:1: ( ruleOCLTextElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:434:1: ruleOCLTextElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLTextElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOCLTextElement_in_entryRuleOCLTextElement848);
            ruleOCLTextElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLTextElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOCLTextElement855); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOCLTextElement"


    // $ANTLR start "ruleOCLTextElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:441:1: ruleOCLTextElement : ( ( rule__OCLTextElement__Group__0 ) ) ;
    public final void ruleOCLTextElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:445:2: ( ( ( rule__OCLTextElement__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:446:1: ( ( rule__OCLTextElement__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:446:1: ( ( rule__OCLTextElement__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:447:1: ( rule__OCLTextElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLTextElementAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:448:1: ( rule__OCLTextElement__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:448:2: rule__OCLTextElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLTextElement__Group__0_in_ruleOCLTextElement881);
            rule__OCLTextElement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLTextElementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOCLTextElement"


    // $ANTLR start "entryRuleTextElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:460:1: entryRuleTextElement : ruleTextElement EOF ;
    public final void entryRuleTextElement() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:461:1: ( ruleTextElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:462:1: ruleTextElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTextElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTextElement_in_entryRuleTextElement908);
            ruleTextElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTextElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTextElement915); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTextElement"


    // $ANTLR start "ruleTextElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:469:1: ruleTextElement : ( ( rule__TextElement__Alternatives ) ) ;
    public final void ruleTextElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:473:2: ( ( ( rule__TextElement__Alternatives ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:474:1: ( ( rule__TextElement__Alternatives ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:474:1: ( ( rule__TextElement__Alternatives ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:475:1: ( rule__TextElement__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTextElementAccess().getAlternatives()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:476:1: ( rule__TextElement__Alternatives )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:476:2: rule__TextElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__TextElement__Alternatives_in_ruleTextElement941);
            rule__TextElement__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTextElementAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextElement"


    // $ANTLR start "rule__MarkupKeyword__Alternatives"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:488:1: rule__MarkupKeyword__Alternatives : ( ( 'b' ) | ( 'e' ) | ( 'bullet' ) | ( 'figure' ) | ( 'figureRef' ) | ( 'footnote' ) | ( 'heading' ) | ( 'oclCode' ) | ( 'oclEval' ) | ( 'oclText' ) );
    public final void rule__MarkupKeyword__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:492:1: ( ( 'b' ) | ( 'e' ) | ( 'bullet' ) | ( 'figure' ) | ( 'figureRef' ) | ( 'footnote' ) | ( 'heading' ) | ( 'oclCode' ) | ( 'oclEval' ) | ( 'oclText' ) )
            int alt2=10;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt2=1;
                }
                break;
            case 17:
                {
                alt2=2;
                }
                break;
            case 18:
                {
                alt2=3;
                }
                break;
            case 19:
                {
                alt2=4;
                }
                break;
            case 20:
                {
                alt2=5;
                }
                break;
            case 21:
                {
                alt2=6;
                }
                break;
            case 22:
                {
                alt2=7;
                }
                break;
            case 23:
                {
                alt2=8;
                }
                break;
            case 24:
                {
                alt2=9;
                }
                break;
            case 25:
                {
                alt2=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:493:1: ( 'b' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:493:1: ( 'b' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:494:1: 'b'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupKeywordAccess().getBKeyword_0()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__MarkupKeyword__Alternatives978); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupKeywordAccess().getBKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:501:6: ( 'e' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:501:6: ( 'e' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:502:1: 'e'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupKeywordAccess().getEKeyword_1()); 
                    }
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__MarkupKeyword__Alternatives998); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupKeywordAccess().getEKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:509:6: ( 'bullet' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:509:6: ( 'bullet' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:510:1: 'bullet'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupKeywordAccess().getBulletKeyword_2()); 
                    }
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__MarkupKeyword__Alternatives1018); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupKeywordAccess().getBulletKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:517:6: ( 'figure' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:517:6: ( 'figure' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:518:1: 'figure'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupKeywordAccess().getFigureKeyword_3()); 
                    }
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__MarkupKeyword__Alternatives1038); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupKeywordAccess().getFigureKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:525:6: ( 'figureRef' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:525:6: ( 'figureRef' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:526:1: 'figureRef'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupKeywordAccess().getFigureRefKeyword_4()); 
                    }
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__MarkupKeyword__Alternatives1058); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupKeywordAccess().getFigureRefKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:533:6: ( 'footnote' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:533:6: ( 'footnote' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:534:1: 'footnote'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupKeywordAccess().getFootnoteKeyword_5()); 
                    }
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__MarkupKeyword__Alternatives1078); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupKeywordAccess().getFootnoteKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:541:6: ( 'heading' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:541:6: ( 'heading' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:542:1: 'heading'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupKeywordAccess().getHeadingKeyword_6()); 
                    }
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__MarkupKeyword__Alternatives1098); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupKeywordAccess().getHeadingKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:549:6: ( 'oclCode' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:549:6: ( 'oclCode' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:550:1: 'oclCode'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupKeywordAccess().getOclCodeKeyword_7()); 
                    }
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__MarkupKeyword__Alternatives1118); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupKeywordAccess().getOclCodeKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:557:6: ( 'oclEval' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:557:6: ( 'oclEval' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:558:1: 'oclEval'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupKeywordAccess().getOclEvalKeyword_8()); 
                    }
                    match(input,24,FollowSets000.FOLLOW_24_in_rule__MarkupKeyword__Alternatives1138); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupKeywordAccess().getOclEvalKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:565:6: ( 'oclText' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:565:6: ( 'oclText' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:566:1: 'oclText'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupKeywordAccess().getOclTextKeyword_9()); 
                    }
                    match(input,25,FollowSets000.FOLLOW_25_in_rule__MarkupKeyword__Alternatives1158); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupKeywordAccess().getOclTextKeyword_9()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkupKeyword__Alternatives"


    // $ANTLR start "rule__MarkupElement__Alternatives"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:578:1: rule__MarkupElement__Alternatives : ( ( ruleFontElement ) | ( ruleNewLineElement ) | ( ruleBulletElement ) | ( ruleFigureElement ) | ( ruleFigureRefElement ) | ( ruleFootnoteElement ) | ( ruleHeadingElement ) | ( ruleNullElement ) | ( ruleOCLCodeElement ) | ( ruleOCLEvalElement ) | ( ruleOCLTextElement ) | ( ruleTextElement ) );
    public final void rule__MarkupElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:582:1: ( ( ruleFontElement ) | ( ruleNewLineElement ) | ( ruleBulletElement ) | ( ruleFigureElement ) | ( ruleFigureRefElement ) | ( ruleFootnoteElement ) | ( ruleHeadingElement ) | ( ruleNullElement ) | ( ruleOCLCodeElement ) | ( ruleOCLEvalElement ) | ( ruleOCLTextElement ) | ( ruleTextElement ) )
            int alt3=12;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:583:1: ( ruleFontElement )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:583:1: ( ruleFontElement )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:584:1: ruleFontElement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupElementAccess().getFontElementParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFontElement_in_rule__MarkupElement__Alternatives1192);
                    ruleFontElement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupElementAccess().getFontElementParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:589:6: ( ruleNewLineElement )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:589:6: ( ruleNewLineElement )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:590:1: ruleNewLineElement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupElementAccess().getNewLineElementParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNewLineElement_in_rule__MarkupElement__Alternatives1209);
                    ruleNewLineElement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupElementAccess().getNewLineElementParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:595:6: ( ruleBulletElement )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:595:6: ( ruleBulletElement )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:596:1: ruleBulletElement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupElementAccess().getBulletElementParserRuleCall_2()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBulletElement_in_rule__MarkupElement__Alternatives1226);
                    ruleBulletElement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupElementAccess().getBulletElementParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:601:6: ( ruleFigureElement )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:601:6: ( ruleFigureElement )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:602:1: ruleFigureElement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupElementAccess().getFigureElementParserRuleCall_3()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFigureElement_in_rule__MarkupElement__Alternatives1243);
                    ruleFigureElement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupElementAccess().getFigureElementParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:607:6: ( ruleFigureRefElement )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:607:6: ( ruleFigureRefElement )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:608:1: ruleFigureRefElement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupElementAccess().getFigureRefElementParserRuleCall_4()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFigureRefElement_in_rule__MarkupElement__Alternatives1260);
                    ruleFigureRefElement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupElementAccess().getFigureRefElementParserRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:613:6: ( ruleFootnoteElement )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:613:6: ( ruleFootnoteElement )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:614:1: ruleFootnoteElement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupElementAccess().getFootnoteElementParserRuleCall_5()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFootnoteElement_in_rule__MarkupElement__Alternatives1277);
                    ruleFootnoteElement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupElementAccess().getFootnoteElementParserRuleCall_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:619:6: ( ruleHeadingElement )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:619:6: ( ruleHeadingElement )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:620:1: ruleHeadingElement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupElementAccess().getHeadingElementParserRuleCall_6()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleHeadingElement_in_rule__MarkupElement__Alternatives1294);
                    ruleHeadingElement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupElementAccess().getHeadingElementParserRuleCall_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:625:6: ( ruleNullElement )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:625:6: ( ruleNullElement )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:626:1: ruleNullElement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupElementAccess().getNullElementParserRuleCall_7()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullElement_in_rule__MarkupElement__Alternatives1311);
                    ruleNullElement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupElementAccess().getNullElementParserRuleCall_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:631:6: ( ruleOCLCodeElement )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:631:6: ( ruleOCLCodeElement )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:632:1: ruleOCLCodeElement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupElementAccess().getOCLCodeElementParserRuleCall_8()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleOCLCodeElement_in_rule__MarkupElement__Alternatives1328);
                    ruleOCLCodeElement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupElementAccess().getOCLCodeElementParserRuleCall_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:637:6: ( ruleOCLEvalElement )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:637:6: ( ruleOCLEvalElement )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:638:1: ruleOCLEvalElement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupElementAccess().getOCLEvalElementParserRuleCall_9()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleOCLEvalElement_in_rule__MarkupElement__Alternatives1345);
                    ruleOCLEvalElement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupElementAccess().getOCLEvalElementParserRuleCall_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:643:6: ( ruleOCLTextElement )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:643:6: ( ruleOCLTextElement )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:644:1: ruleOCLTextElement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupElementAccess().getOCLTextElementParserRuleCall_10()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleOCLTextElement_in_rule__MarkupElement__Alternatives1362);
                    ruleOCLTextElement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupElementAccess().getOCLTextElementParserRuleCall_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:649:6: ( ruleTextElement )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:649:6: ( ruleTextElement )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:650:1: ruleTextElement
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMarkupElementAccess().getTextElementParserRuleCall_11()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTextElement_in_rule__MarkupElement__Alternatives1379);
                    ruleTextElement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMarkupElementAccess().getTextElementParserRuleCall_11()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkupElement__Alternatives"


    // $ANTLR start "rule__FontElement__FontAlternatives_0_0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:660:1: rule__FontElement__FontAlternatives_0_0 : ( ( 'b' ) | ( 'e' ) );
    public final void rule__FontElement__FontAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:664:1: ( ( 'b' ) | ( 'e' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==17) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:665:1: ( 'b' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:665:1: ( 'b' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:666:1: 'b'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFontElementAccess().getFontBKeyword_0_0_0()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__FontElement__FontAlternatives_0_01412); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFontElementAccess().getFontBKeyword_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:673:6: ( 'e' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:673:6: ( 'e' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:674:1: 'e'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFontElementAccess().getFontEKeyword_0_0_1()); 
                    }
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__FontElement__FontAlternatives_0_01432); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFontElementAccess().getFontEKeyword_0_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontElement__FontAlternatives_0_0"


    // $ANTLR start "rule__TextElement__Alternatives"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:686:1: rule__TextElement__Alternatives : ( ( ( ( rule__TextElement__TextAssignment_0 ) ) ( ( rule__TextElement__TextAssignment_0 )* ) ) | ( ( rule__TextElement__TextAssignment_1 ) ) );
    public final void rule__TextElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:690:1: ( ( ( ( rule__TextElement__TextAssignment_0 ) ) ( ( rule__TextElement__TextAssignment_0 )* ) ) | ( ( rule__TextElement__TextAssignment_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_WS)||(LA6_0>=26 && LA6_0<=28)) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=16 && LA6_0<=25)) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:691:1: ( ( ( rule__TextElement__TextAssignment_0 ) ) ( ( rule__TextElement__TextAssignment_0 )* ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:691:1: ( ( ( rule__TextElement__TextAssignment_0 ) ) ( ( rule__TextElement__TextAssignment_0 )* ) )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:692:1: ( ( rule__TextElement__TextAssignment_0 ) ) ( ( rule__TextElement__TextAssignment_0 )* )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:692:1: ( ( rule__TextElement__TextAssignment_0 ) )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:693:1: ( rule__TextElement__TextAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTextElementAccess().getTextAssignment_0()); 
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:694:1: ( rule__TextElement__TextAssignment_0 )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:694:2: rule__TextElement__TextAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TextElement__TextAssignment_0_in_rule__TextElement__Alternatives1468);
                    rule__TextElement__TextAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTextElementAccess().getTextAssignment_0()); 
                    }

                    }

                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:697:1: ( ( rule__TextElement__TextAssignment_0 )* )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:698:1: ( rule__TextElement__TextAssignment_0 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTextElementAccess().getTextAssignment_0()); 
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:699:1: ( rule__TextElement__TextAssignment_0 )*
                    loop5:
                    do {
                        int alt5=2;
                        alt5 = dfa5.predict(input);
                        switch (alt5) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:699:2: rule__TextElement__TextAssignment_0
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__TextElement__TextAssignment_0_in_rule__TextElement__Alternatives1480);
                    	    rule__TextElement__TextAssignment_0();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTextElementAccess().getTextAssignment_0()); 
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:704:6: ( ( rule__TextElement__TextAssignment_1 ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:704:6: ( ( rule__TextElement__TextAssignment_1 ) )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:705:1: ( rule__TextElement__TextAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTextElementAccess().getTextAssignment_1()); 
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:706:1: ( rule__TextElement__TextAssignment_1 )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:706:2: rule__TextElement__TextAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TextElement__TextAssignment_1_in_rule__TextElement__Alternatives1501);
                    rule__TextElement__TextAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTextElementAccess().getTextAssignment_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextElement__Alternatives"


    // $ANTLR start "rule__TextElement__TextAlternatives_0_0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:715:1: rule__TextElement__TextAlternatives_0_0 : ( ( RULE_ID ) | ( RULE_WORD ) | ( RULE_INT ) | ( RULE_WS ) | ( ':' ) | ( '#' ) | ( ',' ) );
    public final void rule__TextElement__TextAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:719:1: ( ( RULE_ID ) | ( RULE_WORD ) | ( RULE_INT ) | ( RULE_WS ) | ( ':' ) | ( '#' ) | ( ',' ) )
            int alt7=7;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt7=1;
                }
                break;
            case RULE_WORD:
                {
                alt7=2;
                }
                break;
            case RULE_INT:
                {
                alt7=3;
                }
                break;
            case RULE_WS:
                {
                alt7=4;
                }
                break;
            case 26:
                {
                alt7=5;
                }
                break;
            case 27:
                {
                alt7=6;
                }
                break;
            case 28:
                {
                alt7=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:720:1: ( RULE_ID )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:720:1: ( RULE_ID )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:721:1: RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTextElementAccess().getTextIDTerminalRuleCall_0_0_0()); 
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TextElement__TextAlternatives_0_01534); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTextElementAccess().getTextIDTerminalRuleCall_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:726:6: ( RULE_WORD )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:726:6: ( RULE_WORD )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:727:1: RULE_WORD
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTextElementAccess().getTextWORDTerminalRuleCall_0_0_1()); 
                    }
                    match(input,RULE_WORD,FollowSets000.FOLLOW_RULE_WORD_in_rule__TextElement__TextAlternatives_0_01551); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTextElementAccess().getTextWORDTerminalRuleCall_0_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:732:6: ( RULE_INT )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:732:6: ( RULE_INT )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:733:1: RULE_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTextElementAccess().getTextINTTerminalRuleCall_0_0_2()); 
                    }
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__TextElement__TextAlternatives_0_01568); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTextElementAccess().getTextINTTerminalRuleCall_0_0_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:738:6: ( RULE_WS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:738:6: ( RULE_WS )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:739:1: RULE_WS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTextElementAccess().getTextWSTerminalRuleCall_0_0_3()); 
                    }
                    match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_rule__TextElement__TextAlternatives_0_01585); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTextElementAccess().getTextWSTerminalRuleCall_0_0_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:744:6: ( ':' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:744:6: ( ':' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:745:1: ':'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTextElementAccess().getTextColonKeyword_0_0_4()); 
                    }
                    match(input,26,FollowSets000.FOLLOW_26_in_rule__TextElement__TextAlternatives_0_01603); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTextElementAccess().getTextColonKeyword_0_0_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:752:6: ( '#' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:752:6: ( '#' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:753:1: '#'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTextElementAccess().getTextNumberSignKeyword_0_0_5()); 
                    }
                    match(input,27,FollowSets000.FOLLOW_27_in_rule__TextElement__TextAlternatives_0_01623); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTextElementAccess().getTextNumberSignKeyword_0_0_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:760:6: ( ',' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:760:6: ( ',' )
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:761:1: ','
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTextElementAccess().getTextCommaKeyword_0_0_6()); 
                    }
                    match(input,28,FollowSets000.FOLLOW_28_in_rule__TextElement__TextAlternatives_0_01643); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTextElementAccess().getTextCommaKeyword_0_0_6()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextElement__TextAlternatives_0_0"


    // $ANTLR start "rule__BulletElement__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:775:1: rule__BulletElement__Group__0 : rule__BulletElement__Group__0__Impl rule__BulletElement__Group__1 ;
    public final void rule__BulletElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:779:1: ( rule__BulletElement__Group__0__Impl rule__BulletElement__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:780:2: rule__BulletElement__Group__0__Impl rule__BulletElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group__0__Impl_in_rule__BulletElement__Group__01675);
            rule__BulletElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group__1_in_rule__BulletElement__Group__01678);
            rule__BulletElement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group__0"


    // $ANTLR start "rule__BulletElement__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:787:1: rule__BulletElement__Group__0__Impl : ( () ) ;
    public final void rule__BulletElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:791:1: ( ( () ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:792:1: ( () )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:792:1: ( () )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:793:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getBulletElementAction_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:794:1: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:796:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBulletElementAccess().getBulletElementAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group__0__Impl"


    // $ANTLR start "rule__BulletElement__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:806:1: rule__BulletElement__Group__1 : rule__BulletElement__Group__1__Impl rule__BulletElement__Group__2 ;
    public final void rule__BulletElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:810:1: ( rule__BulletElement__Group__1__Impl rule__BulletElement__Group__2 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:811:2: rule__BulletElement__Group__1__Impl rule__BulletElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group__1__Impl_in_rule__BulletElement__Group__11736);
            rule__BulletElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group__2_in_rule__BulletElement__Group__11739);
            rule__BulletElement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group__1"


    // $ANTLR start "rule__BulletElement__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:818:1: rule__BulletElement__Group__1__Impl : ( 'bullet' ) ;
    public final void rule__BulletElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:822:1: ( ( 'bullet' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:823:1: ( 'bullet' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:823:1: ( 'bullet' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:824:1: 'bullet'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getBulletKeyword_1()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__BulletElement__Group__1__Impl1767); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBulletElementAccess().getBulletKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group__1__Impl"


    // $ANTLR start "rule__BulletElement__Group__2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:837:1: rule__BulletElement__Group__2 : rule__BulletElement__Group__2__Impl rule__BulletElement__Group__3 ;
    public final void rule__BulletElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:841:1: ( rule__BulletElement__Group__2__Impl rule__BulletElement__Group__3 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:842:2: rule__BulletElement__Group__2__Impl rule__BulletElement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group__2__Impl_in_rule__BulletElement__Group__21798);
            rule__BulletElement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group__3_in_rule__BulletElement__Group__21801);
            rule__BulletElement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group__2"


    // $ANTLR start "rule__BulletElement__Group__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:849:1: rule__BulletElement__Group__2__Impl : ( ( rule__BulletElement__Group_2__0 )? ) ;
    public final void rule__BulletElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:853:1: ( ( ( rule__BulletElement__Group_2__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:854:1: ( ( rule__BulletElement__Group_2__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:854:1: ( ( rule__BulletElement__Group_2__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:855:1: ( rule__BulletElement__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getGroup_2()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:856:1: ( rule__BulletElement__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==26) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:856:2: rule__BulletElement__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group_2__0_in_rule__BulletElement__Group__2__Impl1828);
                    rule__BulletElement__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBulletElementAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group__2__Impl"


    // $ANTLR start "rule__BulletElement__Group__3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:866:1: rule__BulletElement__Group__3 : rule__BulletElement__Group__3__Impl rule__BulletElement__Group__4 ;
    public final void rule__BulletElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:870:1: ( rule__BulletElement__Group__3__Impl rule__BulletElement__Group__4 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:871:2: rule__BulletElement__Group__3__Impl rule__BulletElement__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group__3__Impl_in_rule__BulletElement__Group__31859);
            rule__BulletElement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group__4_in_rule__BulletElement__Group__31862);
            rule__BulletElement__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group__3"


    // $ANTLR start "rule__BulletElement__Group__3__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:878:1: rule__BulletElement__Group__3__Impl : ( '[' ) ;
    public final void rule__BulletElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:882:1: ( ( '[' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:883:1: ( '[' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:883:1: ( '[' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:884:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getLeftSquareBracketKeyword_3()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__BulletElement__Group__3__Impl1890); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBulletElementAccess().getLeftSquareBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group__3__Impl"


    // $ANTLR start "rule__BulletElement__Group__4"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:897:1: rule__BulletElement__Group__4 : rule__BulletElement__Group__4__Impl rule__BulletElement__Group__5 ;
    public final void rule__BulletElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:901:1: ( rule__BulletElement__Group__4__Impl rule__BulletElement__Group__5 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:902:2: rule__BulletElement__Group__4__Impl rule__BulletElement__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group__4__Impl_in_rule__BulletElement__Group__41921);
            rule__BulletElement__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group__5_in_rule__BulletElement__Group__41924);
            rule__BulletElement__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group__4"


    // $ANTLR start "rule__BulletElement__Group__4__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:909:1: rule__BulletElement__Group__4__Impl : ( ( rule__BulletElement__ElementsAssignment_4 )* ) ;
    public final void rule__BulletElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:913:1: ( ( ( rule__BulletElement__ElementsAssignment_4 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:914:1: ( ( rule__BulletElement__ElementsAssignment_4 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:914:1: ( ( rule__BulletElement__ElementsAssignment_4 )* )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:915:1: ( rule__BulletElement__ElementsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getElementsAssignment_4()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:916:1: ( rule__BulletElement__ElementsAssignment_4 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_WS)||LA9_0==RULE_NL||(LA9_0>=16 && LA9_0<=29)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:916:2: rule__BulletElement__ElementsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__BulletElement__ElementsAssignment_4_in_rule__BulletElement__Group__4__Impl1951);
            	    rule__BulletElement__ElementsAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBulletElementAccess().getElementsAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group__4__Impl"


    // $ANTLR start "rule__BulletElement__Group__5"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:926:1: rule__BulletElement__Group__5 : rule__BulletElement__Group__5__Impl ;
    public final void rule__BulletElement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:930:1: ( rule__BulletElement__Group__5__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:931:2: rule__BulletElement__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group__5__Impl_in_rule__BulletElement__Group__51982);
            rule__BulletElement__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group__5"


    // $ANTLR start "rule__BulletElement__Group__5__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:937:1: rule__BulletElement__Group__5__Impl : ( ']' ) ;
    public final void rule__BulletElement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:941:1: ( ( ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:942:1: ( ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:942:1: ( ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:943:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getRightSquareBracketKeyword_5()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__BulletElement__Group__5__Impl2010); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBulletElementAccess().getRightSquareBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group__5__Impl"


    // $ANTLR start "rule__BulletElement__Group_2__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:968:1: rule__BulletElement__Group_2__0 : rule__BulletElement__Group_2__0__Impl rule__BulletElement__Group_2__1 ;
    public final void rule__BulletElement__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:972:1: ( rule__BulletElement__Group_2__0__Impl rule__BulletElement__Group_2__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:973:2: rule__BulletElement__Group_2__0__Impl rule__BulletElement__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group_2__0__Impl_in_rule__BulletElement__Group_2__02053);
            rule__BulletElement__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group_2__1_in_rule__BulletElement__Group_2__02056);
            rule__BulletElement__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group_2__0"


    // $ANTLR start "rule__BulletElement__Group_2__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:980:1: rule__BulletElement__Group_2__0__Impl : ( ':' ) ;
    public final void rule__BulletElement__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:984:1: ( ( ':' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:985:1: ( ':' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:985:1: ( ':' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:986:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getColonKeyword_2_0()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__BulletElement__Group_2__0__Impl2084); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBulletElementAccess().getColonKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group_2__0__Impl"


    // $ANTLR start "rule__BulletElement__Group_2__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:999:1: rule__BulletElement__Group_2__1 : rule__BulletElement__Group_2__1__Impl ;
    public final void rule__BulletElement__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1003:1: ( rule__BulletElement__Group_2__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1004:2: rule__BulletElement__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__Group_2__1__Impl_in_rule__BulletElement__Group_2__12115);
            rule__BulletElement__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group_2__1"


    // $ANTLR start "rule__BulletElement__Group_2__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1010:1: rule__BulletElement__Group_2__1__Impl : ( ( rule__BulletElement__LevelAssignment_2_1 ) ) ;
    public final void rule__BulletElement__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1014:1: ( ( ( rule__BulletElement__LevelAssignment_2_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1015:1: ( ( rule__BulletElement__LevelAssignment_2_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1015:1: ( ( rule__BulletElement__LevelAssignment_2_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1016:1: ( rule__BulletElement__LevelAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getLevelAssignment_2_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1017:1: ( rule__BulletElement__LevelAssignment_2_1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1017:2: rule__BulletElement__LevelAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__BulletElement__LevelAssignment_2_1_in_rule__BulletElement__Group_2__1__Impl2142);
            rule__BulletElement__LevelAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBulletElementAccess().getLevelAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__Group_2__1__Impl"


    // $ANTLR start "rule__FontElement__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1031:1: rule__FontElement__Group__0 : rule__FontElement__Group__0__Impl rule__FontElement__Group__1 ;
    public final void rule__FontElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1035:1: ( rule__FontElement__Group__0__Impl rule__FontElement__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1036:2: rule__FontElement__Group__0__Impl rule__FontElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FontElement__Group__0__Impl_in_rule__FontElement__Group__02176);
            rule__FontElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FontElement__Group__1_in_rule__FontElement__Group__02179);
            rule__FontElement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontElement__Group__0"


    // $ANTLR start "rule__FontElement__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1043:1: rule__FontElement__Group__0__Impl : ( ( rule__FontElement__FontAssignment_0 ) ) ;
    public final void rule__FontElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1047:1: ( ( ( rule__FontElement__FontAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1048:1: ( ( rule__FontElement__FontAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1048:1: ( ( rule__FontElement__FontAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1049:1: ( rule__FontElement__FontAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFontElementAccess().getFontAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1050:1: ( rule__FontElement__FontAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1050:2: rule__FontElement__FontAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FontElement__FontAssignment_0_in_rule__FontElement__Group__0__Impl2206);
            rule__FontElement__FontAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFontElementAccess().getFontAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontElement__Group__0__Impl"


    // $ANTLR start "rule__FontElement__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1060:1: rule__FontElement__Group__1 : rule__FontElement__Group__1__Impl rule__FontElement__Group__2 ;
    public final void rule__FontElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1064:1: ( rule__FontElement__Group__1__Impl rule__FontElement__Group__2 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1065:2: rule__FontElement__Group__1__Impl rule__FontElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FontElement__Group__1__Impl_in_rule__FontElement__Group__12236);
            rule__FontElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FontElement__Group__2_in_rule__FontElement__Group__12239);
            rule__FontElement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontElement__Group__1"


    // $ANTLR start "rule__FontElement__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1072:1: rule__FontElement__Group__1__Impl : ( '[' ) ;
    public final void rule__FontElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1076:1: ( ( '[' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1077:1: ( '[' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1077:1: ( '[' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1078:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFontElementAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__FontElement__Group__1__Impl2267); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFontElementAccess().getLeftSquareBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontElement__Group__1__Impl"


    // $ANTLR start "rule__FontElement__Group__2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1091:1: rule__FontElement__Group__2 : rule__FontElement__Group__2__Impl rule__FontElement__Group__3 ;
    public final void rule__FontElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1095:1: ( rule__FontElement__Group__2__Impl rule__FontElement__Group__3 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1096:2: rule__FontElement__Group__2__Impl rule__FontElement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FontElement__Group__2__Impl_in_rule__FontElement__Group__22298);
            rule__FontElement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FontElement__Group__3_in_rule__FontElement__Group__22301);
            rule__FontElement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontElement__Group__2"


    // $ANTLR start "rule__FontElement__Group__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1103:1: rule__FontElement__Group__2__Impl : ( ( rule__FontElement__ElementsAssignment_2 )* ) ;
    public final void rule__FontElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1107:1: ( ( ( rule__FontElement__ElementsAssignment_2 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1108:1: ( ( rule__FontElement__ElementsAssignment_2 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1108:1: ( ( rule__FontElement__ElementsAssignment_2 )* )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1109:1: ( rule__FontElement__ElementsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFontElementAccess().getElementsAssignment_2()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1110:1: ( rule__FontElement__ElementsAssignment_2 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=RULE_ID && LA10_0<=RULE_WS)||LA10_0==RULE_NL||(LA10_0>=16 && LA10_0<=29)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1110:2: rule__FontElement__ElementsAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FontElement__ElementsAssignment_2_in_rule__FontElement__Group__2__Impl2328);
            	    rule__FontElement__ElementsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFontElementAccess().getElementsAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontElement__Group__2__Impl"


    // $ANTLR start "rule__FontElement__Group__3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1120:1: rule__FontElement__Group__3 : rule__FontElement__Group__3__Impl ;
    public final void rule__FontElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1124:1: ( rule__FontElement__Group__3__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1125:2: rule__FontElement__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FontElement__Group__3__Impl_in_rule__FontElement__Group__32359);
            rule__FontElement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontElement__Group__3"


    // $ANTLR start "rule__FontElement__Group__3__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1131:1: rule__FontElement__Group__3__Impl : ( ']' ) ;
    public final void rule__FontElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1135:1: ( ( ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1136:1: ( ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1136:1: ( ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1137:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFontElementAccess().getRightSquareBracketKeyword_3()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__FontElement__Group__3__Impl2387); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFontElementAccess().getRightSquareBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontElement__Group__3__Impl"


    // $ANTLR start "rule__FigureElement__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1158:1: rule__FigureElement__Group__0 : rule__FigureElement__Group__0__Impl rule__FigureElement__Group__1 ;
    public final void rule__FigureElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1162:1: ( rule__FigureElement__Group__0__Impl rule__FigureElement__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1163:2: rule__FigureElement__Group__0__Impl rule__FigureElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group__0__Impl_in_rule__FigureElement__Group__02426);
            rule__FigureElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group__1_in_rule__FigureElement__Group__02429);
            rule__FigureElement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group__0"


    // $ANTLR start "rule__FigureElement__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1170:1: rule__FigureElement__Group__0__Impl : ( 'figure' ) ;
    public final void rule__FigureElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1174:1: ( ( 'figure' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1175:1: ( 'figure' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1175:1: ( 'figure' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1176:1: 'figure'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getFigureKeyword_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__FigureElement__Group__0__Impl2457); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getFigureKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group__0__Impl"


    // $ANTLR start "rule__FigureElement__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1189:1: rule__FigureElement__Group__1 : rule__FigureElement__Group__1__Impl rule__FigureElement__Group__2 ;
    public final void rule__FigureElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1193:1: ( rule__FigureElement__Group__1__Impl rule__FigureElement__Group__2 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1194:2: rule__FigureElement__Group__1__Impl rule__FigureElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group__1__Impl_in_rule__FigureElement__Group__12488);
            rule__FigureElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group__2_in_rule__FigureElement__Group__12491);
            rule__FigureElement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group__1"


    // $ANTLR start "rule__FigureElement__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1201:1: rule__FigureElement__Group__1__Impl : ( ( rule__FigureElement__Group_1__0 )? ) ;
    public final void rule__FigureElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1205:1: ( ( ( rule__FigureElement__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1206:1: ( ( rule__FigureElement__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1206:1: ( ( rule__FigureElement__Group_1__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1207:1: ( rule__FigureElement__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1208:1: ( rule__FigureElement__Group_1__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1208:2: rule__FigureElement__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_1__0_in_rule__FigureElement__Group__1__Impl2518);
                    rule__FigureElement__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group__1__Impl"


    // $ANTLR start "rule__FigureElement__Group__2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1218:1: rule__FigureElement__Group__2 : rule__FigureElement__Group__2__Impl rule__FigureElement__Group__3 ;
    public final void rule__FigureElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1222:1: ( rule__FigureElement__Group__2__Impl rule__FigureElement__Group__3 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1223:2: rule__FigureElement__Group__2__Impl rule__FigureElement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group__2__Impl_in_rule__FigureElement__Group__22549);
            rule__FigureElement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group__3_in_rule__FigureElement__Group__22552);
            rule__FigureElement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group__2"


    // $ANTLR start "rule__FigureElement__Group__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1230:1: rule__FigureElement__Group__2__Impl : ( '[' ) ;
    public final void rule__FigureElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1234:1: ( ( '[' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1235:1: ( '[' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1235:1: ( '[' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1236:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getLeftSquareBracketKeyword_2()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__FigureElement__Group__2__Impl2580); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getLeftSquareBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group__2__Impl"


    // $ANTLR start "rule__FigureElement__Group__3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1249:1: rule__FigureElement__Group__3 : rule__FigureElement__Group__3__Impl rule__FigureElement__Group__4 ;
    public final void rule__FigureElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1253:1: ( rule__FigureElement__Group__3__Impl rule__FigureElement__Group__4 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1254:2: rule__FigureElement__Group__3__Impl rule__FigureElement__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group__3__Impl_in_rule__FigureElement__Group__32611);
            rule__FigureElement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group__4_in_rule__FigureElement__Group__32614);
            rule__FigureElement__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group__3"


    // $ANTLR start "rule__FigureElement__Group__3__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1261:1: rule__FigureElement__Group__3__Impl : ( ( rule__FigureElement__SrcAssignment_3 ) ) ;
    public final void rule__FigureElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1265:1: ( ( ( rule__FigureElement__SrcAssignment_3 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1266:1: ( ( rule__FigureElement__SrcAssignment_3 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1266:1: ( ( rule__FigureElement__SrcAssignment_3 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1267:1: ( rule__FigureElement__SrcAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getSrcAssignment_3()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1268:1: ( rule__FigureElement__SrcAssignment_3 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1268:2: rule__FigureElement__SrcAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__SrcAssignment_3_in_rule__FigureElement__Group__3__Impl2641);
            rule__FigureElement__SrcAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getSrcAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group__3__Impl"


    // $ANTLR start "rule__FigureElement__Group__4"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1278:1: rule__FigureElement__Group__4 : rule__FigureElement__Group__4__Impl rule__FigureElement__Group__5 ;
    public final void rule__FigureElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1282:1: ( rule__FigureElement__Group__4__Impl rule__FigureElement__Group__5 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1283:2: rule__FigureElement__Group__4__Impl rule__FigureElement__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group__4__Impl_in_rule__FigureElement__Group__42671);
            rule__FigureElement__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group__5_in_rule__FigureElement__Group__42674);
            rule__FigureElement__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group__4"


    // $ANTLR start "rule__FigureElement__Group__4__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1290:1: rule__FigureElement__Group__4__Impl : ( ( rule__FigureElement__Group_4__0 )? ) ;
    public final void rule__FigureElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1294:1: ( ( ( rule__FigureElement__Group_4__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1295:1: ( ( rule__FigureElement__Group_4__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1295:1: ( ( rule__FigureElement__Group_4__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1296:1: ( rule__FigureElement__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getGroup_4()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1297:1: ( rule__FigureElement__Group_4__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1297:2: rule__FigureElement__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4__0_in_rule__FigureElement__Group__4__Impl2701);
                    rule__FigureElement__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group__4__Impl"


    // $ANTLR start "rule__FigureElement__Group__5"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1307:1: rule__FigureElement__Group__5 : rule__FigureElement__Group__5__Impl ;
    public final void rule__FigureElement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1311:1: ( rule__FigureElement__Group__5__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1312:2: rule__FigureElement__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group__5__Impl_in_rule__FigureElement__Group__52732);
            rule__FigureElement__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group__5"


    // $ANTLR start "rule__FigureElement__Group__5__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1318:1: rule__FigureElement__Group__5__Impl : ( ']' ) ;
    public final void rule__FigureElement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1322:1: ( ( ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1323:1: ( ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1323:1: ( ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1324:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getRightSquareBracketKeyword_5()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__FigureElement__Group__5__Impl2760); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getRightSquareBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group__5__Impl"


    // $ANTLR start "rule__FigureElement__Group_1__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1349:1: rule__FigureElement__Group_1__0 : rule__FigureElement__Group_1__0__Impl rule__FigureElement__Group_1__1 ;
    public final void rule__FigureElement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1353:1: ( rule__FigureElement__Group_1__0__Impl rule__FigureElement__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1354:2: rule__FigureElement__Group_1__0__Impl rule__FigureElement__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_1__0__Impl_in_rule__FigureElement__Group_1__02803);
            rule__FigureElement__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_1__1_in_rule__FigureElement__Group_1__02806);
            rule__FigureElement__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_1__0"


    // $ANTLR start "rule__FigureElement__Group_1__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1361:1: rule__FigureElement__Group_1__0__Impl : ( '#' ) ;
    public final void rule__FigureElement__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1365:1: ( ( '#' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1366:1: ( '#' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1366:1: ( '#' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1367:1: '#'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getNumberSignKeyword_1_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__FigureElement__Group_1__0__Impl2834); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getNumberSignKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_1__0__Impl"


    // $ANTLR start "rule__FigureElement__Group_1__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1380:1: rule__FigureElement__Group_1__1 : rule__FigureElement__Group_1__1__Impl ;
    public final void rule__FigureElement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1384:1: ( rule__FigureElement__Group_1__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1385:2: rule__FigureElement__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_1__1__Impl_in_rule__FigureElement__Group_1__12865);
            rule__FigureElement__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_1__1"


    // $ANTLR start "rule__FigureElement__Group_1__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1391:1: rule__FigureElement__Group_1__1__Impl : ( ( rule__FigureElement__DefAssignment_1_1 ) ) ;
    public final void rule__FigureElement__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1395:1: ( ( ( rule__FigureElement__DefAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1396:1: ( ( rule__FigureElement__DefAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1396:1: ( ( rule__FigureElement__DefAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1397:1: ( rule__FigureElement__DefAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getDefAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1398:1: ( rule__FigureElement__DefAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1398:2: rule__FigureElement__DefAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__DefAssignment_1_1_in_rule__FigureElement__Group_1__1__Impl2892);
            rule__FigureElement__DefAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getDefAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_1__1__Impl"


    // $ANTLR start "rule__FigureElement__Group_4__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1412:1: rule__FigureElement__Group_4__0 : rule__FigureElement__Group_4__0__Impl rule__FigureElement__Group_4__1 ;
    public final void rule__FigureElement__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1416:1: ( rule__FigureElement__Group_4__0__Impl rule__FigureElement__Group_4__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1417:2: rule__FigureElement__Group_4__0__Impl rule__FigureElement__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4__0__Impl_in_rule__FigureElement__Group_4__02926);
            rule__FigureElement__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4__1_in_rule__FigureElement__Group_4__02929);
            rule__FigureElement__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4__0"


    // $ANTLR start "rule__FigureElement__Group_4__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1424:1: rule__FigureElement__Group_4__0__Impl : ( ',' ) ;
    public final void rule__FigureElement__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1428:1: ( ( ',' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1429:1: ( ',' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1429:1: ( ',' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1430:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getCommaKeyword_4_0()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__FigureElement__Group_4__0__Impl2957); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getCommaKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4__0__Impl"


    // $ANTLR start "rule__FigureElement__Group_4__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1443:1: rule__FigureElement__Group_4__1 : rule__FigureElement__Group_4__1__Impl rule__FigureElement__Group_4__2 ;
    public final void rule__FigureElement__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1447:1: ( rule__FigureElement__Group_4__1__Impl rule__FigureElement__Group_4__2 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1448:2: rule__FigureElement__Group_4__1__Impl rule__FigureElement__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4__1__Impl_in_rule__FigureElement__Group_4__12988);
            rule__FigureElement__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4__2_in_rule__FigureElement__Group_4__12991);
            rule__FigureElement__Group_4__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4__1"


    // $ANTLR start "rule__FigureElement__Group_4__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1455:1: rule__FigureElement__Group_4__1__Impl : ( ( rule__FigureElement__AltAssignment_4_1 ) ) ;
    public final void rule__FigureElement__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1459:1: ( ( ( rule__FigureElement__AltAssignment_4_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1460:1: ( ( rule__FigureElement__AltAssignment_4_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1460:1: ( ( rule__FigureElement__AltAssignment_4_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1461:1: ( rule__FigureElement__AltAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getAltAssignment_4_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1462:1: ( rule__FigureElement__AltAssignment_4_1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1462:2: rule__FigureElement__AltAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__AltAssignment_4_1_in_rule__FigureElement__Group_4__1__Impl3018);
            rule__FigureElement__AltAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getAltAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4__1__Impl"


    // $ANTLR start "rule__FigureElement__Group_4__2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1472:1: rule__FigureElement__Group_4__2 : rule__FigureElement__Group_4__2__Impl ;
    public final void rule__FigureElement__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1476:1: ( rule__FigureElement__Group_4__2__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1477:2: rule__FigureElement__Group_4__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4__2__Impl_in_rule__FigureElement__Group_4__23048);
            rule__FigureElement__Group_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4__2"


    // $ANTLR start "rule__FigureElement__Group_4__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1483:1: rule__FigureElement__Group_4__2__Impl : ( ( rule__FigureElement__Group_4_2__0 )? ) ;
    public final void rule__FigureElement__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1487:1: ( ( ( rule__FigureElement__Group_4_2__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1488:1: ( ( rule__FigureElement__Group_4_2__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1488:1: ( ( rule__FigureElement__Group_4_2__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1489:1: ( rule__FigureElement__Group_4_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getGroup_4_2()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1490:1: ( rule__FigureElement__Group_4_2__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==28) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1490:2: rule__FigureElement__Group_4_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4_2__0_in_rule__FigureElement__Group_4__2__Impl3075);
                    rule__FigureElement__Group_4_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getGroup_4_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4__2__Impl"


    // $ANTLR start "rule__FigureElement__Group_4_2__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1506:1: rule__FigureElement__Group_4_2__0 : rule__FigureElement__Group_4_2__0__Impl rule__FigureElement__Group_4_2__1 ;
    public final void rule__FigureElement__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1510:1: ( rule__FigureElement__Group_4_2__0__Impl rule__FigureElement__Group_4_2__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1511:2: rule__FigureElement__Group_4_2__0__Impl rule__FigureElement__Group_4_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4_2__0__Impl_in_rule__FigureElement__Group_4_2__03112);
            rule__FigureElement__Group_4_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4_2__1_in_rule__FigureElement__Group_4_2__03115);
            rule__FigureElement__Group_4_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4_2__0"


    // $ANTLR start "rule__FigureElement__Group_4_2__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1518:1: rule__FigureElement__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__FigureElement__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1522:1: ( ( ',' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1523:1: ( ',' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1523:1: ( ',' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1524:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_0()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__FigureElement__Group_4_2__0__Impl3143); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4_2__0__Impl"


    // $ANTLR start "rule__FigureElement__Group_4_2__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1537:1: rule__FigureElement__Group_4_2__1 : rule__FigureElement__Group_4_2__1__Impl rule__FigureElement__Group_4_2__2 ;
    public final void rule__FigureElement__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1541:1: ( rule__FigureElement__Group_4_2__1__Impl rule__FigureElement__Group_4_2__2 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1542:2: rule__FigureElement__Group_4_2__1__Impl rule__FigureElement__Group_4_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4_2__1__Impl_in_rule__FigureElement__Group_4_2__13174);
            rule__FigureElement__Group_4_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4_2__2_in_rule__FigureElement__Group_4_2__13177);
            rule__FigureElement__Group_4_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4_2__1"


    // $ANTLR start "rule__FigureElement__Group_4_2__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1549:1: rule__FigureElement__Group_4_2__1__Impl : ( ( rule__FigureElement__RequiredWidthAssignment_4_2_1 ) ) ;
    public final void rule__FigureElement__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1553:1: ( ( ( rule__FigureElement__RequiredWidthAssignment_4_2_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1554:1: ( ( rule__FigureElement__RequiredWidthAssignment_4_2_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1554:1: ( ( rule__FigureElement__RequiredWidthAssignment_4_2_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1555:1: ( rule__FigureElement__RequiredWidthAssignment_4_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getRequiredWidthAssignment_4_2_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1556:1: ( rule__FigureElement__RequiredWidthAssignment_4_2_1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1556:2: rule__FigureElement__RequiredWidthAssignment_4_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__RequiredWidthAssignment_4_2_1_in_rule__FigureElement__Group_4_2__1__Impl3204);
            rule__FigureElement__RequiredWidthAssignment_4_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getRequiredWidthAssignment_4_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4_2__1__Impl"


    // $ANTLR start "rule__FigureElement__Group_4_2__2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1566:1: rule__FigureElement__Group_4_2__2 : rule__FigureElement__Group_4_2__2__Impl ;
    public final void rule__FigureElement__Group_4_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1570:1: ( rule__FigureElement__Group_4_2__2__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1571:2: rule__FigureElement__Group_4_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4_2__2__Impl_in_rule__FigureElement__Group_4_2__23234);
            rule__FigureElement__Group_4_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4_2__2"


    // $ANTLR start "rule__FigureElement__Group_4_2__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1577:1: rule__FigureElement__Group_4_2__2__Impl : ( ( rule__FigureElement__Group_4_2_2__0 )? ) ;
    public final void rule__FigureElement__Group_4_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1581:1: ( ( ( rule__FigureElement__Group_4_2_2__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1582:1: ( ( rule__FigureElement__Group_4_2_2__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1582:1: ( ( rule__FigureElement__Group_4_2_2__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1583:1: ( rule__FigureElement__Group_4_2_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getGroup_4_2_2()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1584:1: ( rule__FigureElement__Group_4_2_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==28) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1584:2: rule__FigureElement__Group_4_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4_2_2__0_in_rule__FigureElement__Group_4_2__2__Impl3261);
                    rule__FigureElement__Group_4_2_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getGroup_4_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4_2__2__Impl"


    // $ANTLR start "rule__FigureElement__Group_4_2_2__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1600:1: rule__FigureElement__Group_4_2_2__0 : rule__FigureElement__Group_4_2_2__0__Impl rule__FigureElement__Group_4_2_2__1 ;
    public final void rule__FigureElement__Group_4_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1604:1: ( rule__FigureElement__Group_4_2_2__0__Impl rule__FigureElement__Group_4_2_2__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1605:2: rule__FigureElement__Group_4_2_2__0__Impl rule__FigureElement__Group_4_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4_2_2__0__Impl_in_rule__FigureElement__Group_4_2_2__03298);
            rule__FigureElement__Group_4_2_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4_2_2__1_in_rule__FigureElement__Group_4_2_2__03301);
            rule__FigureElement__Group_4_2_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4_2_2__0"


    // $ANTLR start "rule__FigureElement__Group_4_2_2__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1612:1: rule__FigureElement__Group_4_2_2__0__Impl : ( ',' ) ;
    public final void rule__FigureElement__Group_4_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1616:1: ( ( ',' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1617:1: ( ',' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1617:1: ( ',' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1618:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_2_0()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__FigureElement__Group_4_2_2__0__Impl3329); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4_2_2__0__Impl"


    // $ANTLR start "rule__FigureElement__Group_4_2_2__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1631:1: rule__FigureElement__Group_4_2_2__1 : rule__FigureElement__Group_4_2_2__1__Impl ;
    public final void rule__FigureElement__Group_4_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1635:1: ( rule__FigureElement__Group_4_2_2__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1636:2: rule__FigureElement__Group_4_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__Group_4_2_2__1__Impl_in_rule__FigureElement__Group_4_2_2__13360);
            rule__FigureElement__Group_4_2_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4_2_2__1"


    // $ANTLR start "rule__FigureElement__Group_4_2_2__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1642:1: rule__FigureElement__Group_4_2_2__1__Impl : ( ( rule__FigureElement__RequiredHeightAssignment_4_2_2_1 ) ) ;
    public final void rule__FigureElement__Group_4_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1646:1: ( ( ( rule__FigureElement__RequiredHeightAssignment_4_2_2_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1647:1: ( ( rule__FigureElement__RequiredHeightAssignment_4_2_2_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1647:1: ( ( rule__FigureElement__RequiredHeightAssignment_4_2_2_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1648:1: ( rule__FigureElement__RequiredHeightAssignment_4_2_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getRequiredHeightAssignment_4_2_2_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1649:1: ( rule__FigureElement__RequiredHeightAssignment_4_2_2_1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1649:2: rule__FigureElement__RequiredHeightAssignment_4_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureElement__RequiredHeightAssignment_4_2_2_1_in_rule__FigureElement__Group_4_2_2__1__Impl3387);
            rule__FigureElement__RequiredHeightAssignment_4_2_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getRequiredHeightAssignment_4_2_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__Group_4_2_2__1__Impl"


    // $ANTLR start "rule__FigureRefElement__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1663:1: rule__FigureRefElement__Group__0 : rule__FigureRefElement__Group__0__Impl rule__FigureRefElement__Group__1 ;
    public final void rule__FigureRefElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1667:1: ( rule__FigureRefElement__Group__0__Impl rule__FigureRefElement__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1668:2: rule__FigureRefElement__Group__0__Impl rule__FigureRefElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureRefElement__Group__0__Impl_in_rule__FigureRefElement__Group__03421);
            rule__FigureRefElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureRefElement__Group__1_in_rule__FigureRefElement__Group__03424);
            rule__FigureRefElement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureRefElement__Group__0"


    // $ANTLR start "rule__FigureRefElement__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1675:1: rule__FigureRefElement__Group__0__Impl : ( 'figureRef' ) ;
    public final void rule__FigureRefElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1679:1: ( ( 'figureRef' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1680:1: ( 'figureRef' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1680:1: ( 'figureRef' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1681:1: 'figureRef'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureRefElementAccess().getFigureRefKeyword_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__FigureRefElement__Group__0__Impl3452); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureRefElementAccess().getFigureRefKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureRefElement__Group__0__Impl"


    // $ANTLR start "rule__FigureRefElement__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1694:1: rule__FigureRefElement__Group__1 : rule__FigureRefElement__Group__1__Impl rule__FigureRefElement__Group__2 ;
    public final void rule__FigureRefElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1698:1: ( rule__FigureRefElement__Group__1__Impl rule__FigureRefElement__Group__2 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1699:2: rule__FigureRefElement__Group__1__Impl rule__FigureRefElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureRefElement__Group__1__Impl_in_rule__FigureRefElement__Group__13483);
            rule__FigureRefElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureRefElement__Group__2_in_rule__FigureRefElement__Group__13486);
            rule__FigureRefElement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureRefElement__Group__1"


    // $ANTLR start "rule__FigureRefElement__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1706:1: rule__FigureRefElement__Group__1__Impl : ( '[' ) ;
    public final void rule__FigureRefElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1710:1: ( ( '[' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1711:1: ( '[' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1711:1: ( '[' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1712:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureRefElementAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__FigureRefElement__Group__1__Impl3514); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureRefElementAccess().getLeftSquareBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureRefElement__Group__1__Impl"


    // $ANTLR start "rule__FigureRefElement__Group__2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1725:1: rule__FigureRefElement__Group__2 : rule__FigureRefElement__Group__2__Impl rule__FigureRefElement__Group__3 ;
    public final void rule__FigureRefElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1729:1: ( rule__FigureRefElement__Group__2__Impl rule__FigureRefElement__Group__3 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1730:2: rule__FigureRefElement__Group__2__Impl rule__FigureRefElement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureRefElement__Group__2__Impl_in_rule__FigureRefElement__Group__23545);
            rule__FigureRefElement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FigureRefElement__Group__3_in_rule__FigureRefElement__Group__23548);
            rule__FigureRefElement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureRefElement__Group__2"


    // $ANTLR start "rule__FigureRefElement__Group__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1737:1: rule__FigureRefElement__Group__2__Impl : ( ( rule__FigureRefElement__RefAssignment_2 ) ) ;
    public final void rule__FigureRefElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1741:1: ( ( ( rule__FigureRefElement__RefAssignment_2 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1742:1: ( ( rule__FigureRefElement__RefAssignment_2 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1742:1: ( ( rule__FigureRefElement__RefAssignment_2 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1743:1: ( rule__FigureRefElement__RefAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureRefElementAccess().getRefAssignment_2()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1744:1: ( rule__FigureRefElement__RefAssignment_2 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1744:2: rule__FigureRefElement__RefAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureRefElement__RefAssignment_2_in_rule__FigureRefElement__Group__2__Impl3575);
            rule__FigureRefElement__RefAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureRefElementAccess().getRefAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureRefElement__Group__2__Impl"


    // $ANTLR start "rule__FigureRefElement__Group__3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1754:1: rule__FigureRefElement__Group__3 : rule__FigureRefElement__Group__3__Impl ;
    public final void rule__FigureRefElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1758:1: ( rule__FigureRefElement__Group__3__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1759:2: rule__FigureRefElement__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FigureRefElement__Group__3__Impl_in_rule__FigureRefElement__Group__33605);
            rule__FigureRefElement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureRefElement__Group__3"


    // $ANTLR start "rule__FigureRefElement__Group__3__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1765:1: rule__FigureRefElement__Group__3__Impl : ( ']' ) ;
    public final void rule__FigureRefElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1769:1: ( ( ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1770:1: ( ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1770:1: ( ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1771:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureRefElementAccess().getRightSquareBracketKeyword_3()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__FigureRefElement__Group__3__Impl3633); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureRefElementAccess().getRightSquareBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureRefElement__Group__3__Impl"


    // $ANTLR start "rule__FootnoteElement__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1792:1: rule__FootnoteElement__Group__0 : rule__FootnoteElement__Group__0__Impl rule__FootnoteElement__Group__1 ;
    public final void rule__FootnoteElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1796:1: ( rule__FootnoteElement__Group__0__Impl rule__FootnoteElement__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1797:2: rule__FootnoteElement__Group__0__Impl rule__FootnoteElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FootnoteElement__Group__0__Impl_in_rule__FootnoteElement__Group__03672);
            rule__FootnoteElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FootnoteElement__Group__1_in_rule__FootnoteElement__Group__03675);
            rule__FootnoteElement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FootnoteElement__Group__0"


    // $ANTLR start "rule__FootnoteElement__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1804:1: rule__FootnoteElement__Group__0__Impl : ( () ) ;
    public final void rule__FootnoteElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1808:1: ( ( () ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1809:1: ( () )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1809:1: ( () )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1810:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFootnoteElementAccess().getFootnoteElementAction_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1811:1: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1813:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFootnoteElementAccess().getFootnoteElementAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FootnoteElement__Group__0__Impl"


    // $ANTLR start "rule__FootnoteElement__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1823:1: rule__FootnoteElement__Group__1 : rule__FootnoteElement__Group__1__Impl rule__FootnoteElement__Group__2 ;
    public final void rule__FootnoteElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1827:1: ( rule__FootnoteElement__Group__1__Impl rule__FootnoteElement__Group__2 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1828:2: rule__FootnoteElement__Group__1__Impl rule__FootnoteElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FootnoteElement__Group__1__Impl_in_rule__FootnoteElement__Group__13733);
            rule__FootnoteElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FootnoteElement__Group__2_in_rule__FootnoteElement__Group__13736);
            rule__FootnoteElement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FootnoteElement__Group__1"


    // $ANTLR start "rule__FootnoteElement__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1835:1: rule__FootnoteElement__Group__1__Impl : ( 'footnote' ) ;
    public final void rule__FootnoteElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1839:1: ( ( 'footnote' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1840:1: ( 'footnote' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1840:1: ( 'footnote' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1841:1: 'footnote'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFootnoteElementAccess().getFootnoteKeyword_1()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__FootnoteElement__Group__1__Impl3764); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFootnoteElementAccess().getFootnoteKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FootnoteElement__Group__1__Impl"


    // $ANTLR start "rule__FootnoteElement__Group__2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1854:1: rule__FootnoteElement__Group__2 : rule__FootnoteElement__Group__2__Impl rule__FootnoteElement__Group__3 ;
    public final void rule__FootnoteElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1858:1: ( rule__FootnoteElement__Group__2__Impl rule__FootnoteElement__Group__3 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1859:2: rule__FootnoteElement__Group__2__Impl rule__FootnoteElement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FootnoteElement__Group__2__Impl_in_rule__FootnoteElement__Group__23795);
            rule__FootnoteElement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FootnoteElement__Group__3_in_rule__FootnoteElement__Group__23798);
            rule__FootnoteElement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FootnoteElement__Group__2"


    // $ANTLR start "rule__FootnoteElement__Group__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1866:1: rule__FootnoteElement__Group__2__Impl : ( '[' ) ;
    public final void rule__FootnoteElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1870:1: ( ( '[' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1871:1: ( '[' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1871:1: ( '[' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1872:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFootnoteElementAccess().getLeftSquareBracketKeyword_2()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__FootnoteElement__Group__2__Impl3826); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFootnoteElementAccess().getLeftSquareBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FootnoteElement__Group__2__Impl"


    // $ANTLR start "rule__FootnoteElement__Group__3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1885:1: rule__FootnoteElement__Group__3 : rule__FootnoteElement__Group__3__Impl rule__FootnoteElement__Group__4 ;
    public final void rule__FootnoteElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1889:1: ( rule__FootnoteElement__Group__3__Impl rule__FootnoteElement__Group__4 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1890:2: rule__FootnoteElement__Group__3__Impl rule__FootnoteElement__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__FootnoteElement__Group__3__Impl_in_rule__FootnoteElement__Group__33857);
            rule__FootnoteElement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FootnoteElement__Group__4_in_rule__FootnoteElement__Group__33860);
            rule__FootnoteElement__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FootnoteElement__Group__3"


    // $ANTLR start "rule__FootnoteElement__Group__3__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1897:1: rule__FootnoteElement__Group__3__Impl : ( ( rule__FootnoteElement__ElementsAssignment_3 )* ) ;
    public final void rule__FootnoteElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1901:1: ( ( ( rule__FootnoteElement__ElementsAssignment_3 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1902:1: ( ( rule__FootnoteElement__ElementsAssignment_3 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1902:1: ( ( rule__FootnoteElement__ElementsAssignment_3 )* )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1903:1: ( rule__FootnoteElement__ElementsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFootnoteElementAccess().getElementsAssignment_3()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1904:1: ( rule__FootnoteElement__ElementsAssignment_3 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_WS)||LA15_0==RULE_NL||(LA15_0>=16 && LA15_0<=29)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1904:2: rule__FootnoteElement__ElementsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FootnoteElement__ElementsAssignment_3_in_rule__FootnoteElement__Group__3__Impl3887);
            	    rule__FootnoteElement__ElementsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFootnoteElementAccess().getElementsAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FootnoteElement__Group__3__Impl"


    // $ANTLR start "rule__FootnoteElement__Group__4"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1914:1: rule__FootnoteElement__Group__4 : rule__FootnoteElement__Group__4__Impl ;
    public final void rule__FootnoteElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1918:1: ( rule__FootnoteElement__Group__4__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1919:2: rule__FootnoteElement__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FootnoteElement__Group__4__Impl_in_rule__FootnoteElement__Group__43918);
            rule__FootnoteElement__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FootnoteElement__Group__4"


    // $ANTLR start "rule__FootnoteElement__Group__4__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1925:1: rule__FootnoteElement__Group__4__Impl : ( ']' ) ;
    public final void rule__FootnoteElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1929:1: ( ( ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1930:1: ( ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1930:1: ( ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1931:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFootnoteElementAccess().getRightSquareBracketKeyword_4()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__FootnoteElement__Group__4__Impl3946); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFootnoteElementAccess().getRightSquareBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FootnoteElement__Group__4__Impl"


    // $ANTLR start "rule__HeadingElement__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1954:1: rule__HeadingElement__Group__0 : rule__HeadingElement__Group__0__Impl rule__HeadingElement__Group__1 ;
    public final void rule__HeadingElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1958:1: ( rule__HeadingElement__Group__0__Impl rule__HeadingElement__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1959:2: rule__HeadingElement__Group__0__Impl rule__HeadingElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group__0__Impl_in_rule__HeadingElement__Group__03987);
            rule__HeadingElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group__1_in_rule__HeadingElement__Group__03990);
            rule__HeadingElement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group__0"


    // $ANTLR start "rule__HeadingElement__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1966:1: rule__HeadingElement__Group__0__Impl : ( () ) ;
    public final void rule__HeadingElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1970:1: ( ( () ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1971:1: ( () )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1971:1: ( () )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1972:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getHeadingElementAction_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1973:1: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1975:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHeadingElementAccess().getHeadingElementAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group__0__Impl"


    // $ANTLR start "rule__HeadingElement__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1985:1: rule__HeadingElement__Group__1 : rule__HeadingElement__Group__1__Impl rule__HeadingElement__Group__2 ;
    public final void rule__HeadingElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1989:1: ( rule__HeadingElement__Group__1__Impl rule__HeadingElement__Group__2 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1990:2: rule__HeadingElement__Group__1__Impl rule__HeadingElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group__1__Impl_in_rule__HeadingElement__Group__14048);
            rule__HeadingElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group__2_in_rule__HeadingElement__Group__14051);
            rule__HeadingElement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group__1"


    // $ANTLR start "rule__HeadingElement__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1997:1: rule__HeadingElement__Group__1__Impl : ( 'heading' ) ;
    public final void rule__HeadingElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2001:1: ( ( 'heading' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2002:1: ( 'heading' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2002:1: ( 'heading' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2003:1: 'heading'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getHeadingKeyword_1()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__HeadingElement__Group__1__Impl4079); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHeadingElementAccess().getHeadingKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group__1__Impl"


    // $ANTLR start "rule__HeadingElement__Group__2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2016:1: rule__HeadingElement__Group__2 : rule__HeadingElement__Group__2__Impl rule__HeadingElement__Group__3 ;
    public final void rule__HeadingElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2020:1: ( rule__HeadingElement__Group__2__Impl rule__HeadingElement__Group__3 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2021:2: rule__HeadingElement__Group__2__Impl rule__HeadingElement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group__2__Impl_in_rule__HeadingElement__Group__24110);
            rule__HeadingElement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group__3_in_rule__HeadingElement__Group__24113);
            rule__HeadingElement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group__2"


    // $ANTLR start "rule__HeadingElement__Group__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2028:1: rule__HeadingElement__Group__2__Impl : ( ( rule__HeadingElement__Group_2__0 )? ) ;
    public final void rule__HeadingElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2032:1: ( ( ( rule__HeadingElement__Group_2__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2033:1: ( ( rule__HeadingElement__Group_2__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2033:1: ( ( rule__HeadingElement__Group_2__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2034:1: ( rule__HeadingElement__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getGroup_2()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2035:1: ( rule__HeadingElement__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2035:2: rule__HeadingElement__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group_2__0_in_rule__HeadingElement__Group__2__Impl4140);
                    rule__HeadingElement__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHeadingElementAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group__2__Impl"


    // $ANTLR start "rule__HeadingElement__Group__3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2045:1: rule__HeadingElement__Group__3 : rule__HeadingElement__Group__3__Impl rule__HeadingElement__Group__4 ;
    public final void rule__HeadingElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2049:1: ( rule__HeadingElement__Group__3__Impl rule__HeadingElement__Group__4 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2050:2: rule__HeadingElement__Group__3__Impl rule__HeadingElement__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group__3__Impl_in_rule__HeadingElement__Group__34171);
            rule__HeadingElement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group__4_in_rule__HeadingElement__Group__34174);
            rule__HeadingElement__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group__3"


    // $ANTLR start "rule__HeadingElement__Group__3__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2057:1: rule__HeadingElement__Group__3__Impl : ( '[' ) ;
    public final void rule__HeadingElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2061:1: ( ( '[' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2062:1: ( '[' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2062:1: ( '[' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2063:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getLeftSquareBracketKeyword_3()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__HeadingElement__Group__3__Impl4202); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHeadingElementAccess().getLeftSquareBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group__3__Impl"


    // $ANTLR start "rule__HeadingElement__Group__4"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2076:1: rule__HeadingElement__Group__4 : rule__HeadingElement__Group__4__Impl rule__HeadingElement__Group__5 ;
    public final void rule__HeadingElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2080:1: ( rule__HeadingElement__Group__4__Impl rule__HeadingElement__Group__5 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2081:2: rule__HeadingElement__Group__4__Impl rule__HeadingElement__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group__4__Impl_in_rule__HeadingElement__Group__44233);
            rule__HeadingElement__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group__5_in_rule__HeadingElement__Group__44236);
            rule__HeadingElement__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group__4"


    // $ANTLR start "rule__HeadingElement__Group__4__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2088:1: rule__HeadingElement__Group__4__Impl : ( ( rule__HeadingElement__ElementsAssignment_4 )* ) ;
    public final void rule__HeadingElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2092:1: ( ( ( rule__HeadingElement__ElementsAssignment_4 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2093:1: ( ( rule__HeadingElement__ElementsAssignment_4 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2093:1: ( ( rule__HeadingElement__ElementsAssignment_4 )* )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2094:1: ( rule__HeadingElement__ElementsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getElementsAssignment_4()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2095:1: ( rule__HeadingElement__ElementsAssignment_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_ID && LA17_0<=RULE_WS)||LA17_0==RULE_NL||(LA17_0>=16 && LA17_0<=29)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2095:2: rule__HeadingElement__ElementsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__ElementsAssignment_4_in_rule__HeadingElement__Group__4__Impl4263);
            	    rule__HeadingElement__ElementsAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHeadingElementAccess().getElementsAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group__4__Impl"


    // $ANTLR start "rule__HeadingElement__Group__5"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2105:1: rule__HeadingElement__Group__5 : rule__HeadingElement__Group__5__Impl ;
    public final void rule__HeadingElement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2109:1: ( rule__HeadingElement__Group__5__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2110:2: rule__HeadingElement__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group__5__Impl_in_rule__HeadingElement__Group__54294);
            rule__HeadingElement__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group__5"


    // $ANTLR start "rule__HeadingElement__Group__5__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2116:1: rule__HeadingElement__Group__5__Impl : ( ']' ) ;
    public final void rule__HeadingElement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2120:1: ( ( ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2121:1: ( ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2121:1: ( ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2122:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getRightSquareBracketKeyword_5()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__HeadingElement__Group__5__Impl4322); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHeadingElementAccess().getRightSquareBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group__5__Impl"


    // $ANTLR start "rule__HeadingElement__Group_2__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2147:1: rule__HeadingElement__Group_2__0 : rule__HeadingElement__Group_2__0__Impl rule__HeadingElement__Group_2__1 ;
    public final void rule__HeadingElement__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2151:1: ( rule__HeadingElement__Group_2__0__Impl rule__HeadingElement__Group_2__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2152:2: rule__HeadingElement__Group_2__0__Impl rule__HeadingElement__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group_2__0__Impl_in_rule__HeadingElement__Group_2__04365);
            rule__HeadingElement__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group_2__1_in_rule__HeadingElement__Group_2__04368);
            rule__HeadingElement__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group_2__0"


    // $ANTLR start "rule__HeadingElement__Group_2__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2159:1: rule__HeadingElement__Group_2__0__Impl : ( ':' ) ;
    public final void rule__HeadingElement__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2163:1: ( ( ':' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2164:1: ( ':' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2164:1: ( ':' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2165:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getColonKeyword_2_0()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__HeadingElement__Group_2__0__Impl4396); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHeadingElementAccess().getColonKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group_2__0__Impl"


    // $ANTLR start "rule__HeadingElement__Group_2__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2178:1: rule__HeadingElement__Group_2__1 : rule__HeadingElement__Group_2__1__Impl ;
    public final void rule__HeadingElement__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2182:1: ( rule__HeadingElement__Group_2__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2183:2: rule__HeadingElement__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__Group_2__1__Impl_in_rule__HeadingElement__Group_2__14427);
            rule__HeadingElement__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group_2__1"


    // $ANTLR start "rule__HeadingElement__Group_2__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2189:1: rule__HeadingElement__Group_2__1__Impl : ( ( rule__HeadingElement__LevelAssignment_2_1 ) ) ;
    public final void rule__HeadingElement__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2193:1: ( ( ( rule__HeadingElement__LevelAssignment_2_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2194:1: ( ( rule__HeadingElement__LevelAssignment_2_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2194:1: ( ( rule__HeadingElement__LevelAssignment_2_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2195:1: ( rule__HeadingElement__LevelAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getLevelAssignment_2_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2196:1: ( rule__HeadingElement__LevelAssignment_2_1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2196:2: rule__HeadingElement__LevelAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__HeadingElement__LevelAssignment_2_1_in_rule__HeadingElement__Group_2__1__Impl4454);
            rule__HeadingElement__LevelAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHeadingElementAccess().getLevelAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__Group_2__1__Impl"


    // $ANTLR start "rule__NullElement__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2210:1: rule__NullElement__Group__0 : rule__NullElement__Group__0__Impl rule__NullElement__Group__1 ;
    public final void rule__NullElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2214:1: ( rule__NullElement__Group__0__Impl rule__NullElement__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2215:2: rule__NullElement__Group__0__Impl rule__NullElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullElement__Group__0__Impl_in_rule__NullElement__Group__04488);
            rule__NullElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__NullElement__Group__1_in_rule__NullElement__Group__04491);
            rule__NullElement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullElement__Group__0"


    // $ANTLR start "rule__NullElement__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2222:1: rule__NullElement__Group__0__Impl : ( () ) ;
    public final void rule__NullElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2226:1: ( ( () ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2227:1: ( () )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2227:1: ( () )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2228:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullElementAccess().getNullElementAction_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2229:1: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2231:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNullElementAccess().getNullElementAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullElement__Group__0__Impl"


    // $ANTLR start "rule__NullElement__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2241:1: rule__NullElement__Group__1 : rule__NullElement__Group__1__Impl rule__NullElement__Group__2 ;
    public final void rule__NullElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2245:1: ( rule__NullElement__Group__1__Impl rule__NullElement__Group__2 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2246:2: rule__NullElement__Group__1__Impl rule__NullElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullElement__Group__1__Impl_in_rule__NullElement__Group__14549);
            rule__NullElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__NullElement__Group__2_in_rule__NullElement__Group__14552);
            rule__NullElement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullElement__Group__1"


    // $ANTLR start "rule__NullElement__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2253:1: rule__NullElement__Group__1__Impl : ( '[' ) ;
    public final void rule__NullElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2257:1: ( ( '[' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2258:1: ( '[' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2258:1: ( '[' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2259:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullElementAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__NullElement__Group__1__Impl4580); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNullElementAccess().getLeftSquareBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullElement__Group__1__Impl"


    // $ANTLR start "rule__NullElement__Group__2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2272:1: rule__NullElement__Group__2 : rule__NullElement__Group__2__Impl rule__NullElement__Group__3 ;
    public final void rule__NullElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2276:1: ( rule__NullElement__Group__2__Impl rule__NullElement__Group__3 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2277:2: rule__NullElement__Group__2__Impl rule__NullElement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullElement__Group__2__Impl_in_rule__NullElement__Group__24611);
            rule__NullElement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__NullElement__Group__3_in_rule__NullElement__Group__24614);
            rule__NullElement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullElement__Group__2"


    // $ANTLR start "rule__NullElement__Group__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2284:1: rule__NullElement__Group__2__Impl : ( ( rule__NullElement__ElementsAssignment_2 )* ) ;
    public final void rule__NullElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2288:1: ( ( ( rule__NullElement__ElementsAssignment_2 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2289:1: ( ( rule__NullElement__ElementsAssignment_2 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2289:1: ( ( rule__NullElement__ElementsAssignment_2 )* )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2290:1: ( rule__NullElement__ElementsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullElementAccess().getElementsAssignment_2()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2291:1: ( rule__NullElement__ElementsAssignment_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_ID && LA18_0<=RULE_WS)||LA18_0==RULE_NL||(LA18_0>=16 && LA18_0<=29)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2291:2: rule__NullElement__ElementsAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__NullElement__ElementsAssignment_2_in_rule__NullElement__Group__2__Impl4641);
            	    rule__NullElement__ElementsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNullElementAccess().getElementsAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullElement__Group__2__Impl"


    // $ANTLR start "rule__NullElement__Group__3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2301:1: rule__NullElement__Group__3 : rule__NullElement__Group__3__Impl ;
    public final void rule__NullElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2305:1: ( rule__NullElement__Group__3__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2306:2: rule__NullElement__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__NullElement__Group__3__Impl_in_rule__NullElement__Group__34672);
            rule__NullElement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullElement__Group__3"


    // $ANTLR start "rule__NullElement__Group__3__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2312:1: rule__NullElement__Group__3__Impl : ( ']' ) ;
    public final void rule__NullElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2316:1: ( ( ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2317:1: ( ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2317:1: ( ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2318:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullElementAccess().getRightSquareBracketKeyword_3()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__NullElement__Group__3__Impl4700); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNullElementAccess().getRightSquareBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullElement__Group__3__Impl"


    // $ANTLR start "rule__OCLCodeElement__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2339:1: rule__OCLCodeElement__Group__0 : rule__OCLCodeElement__Group__0__Impl rule__OCLCodeElement__Group__1 ;
    public final void rule__OCLCodeElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2343:1: ( rule__OCLCodeElement__Group__0__Impl rule__OCLCodeElement__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2344:2: rule__OCLCodeElement__Group__0__Impl rule__OCLCodeElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLCodeElement__Group__0__Impl_in_rule__OCLCodeElement__Group__04739);
            rule__OCLCodeElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OCLCodeElement__Group__1_in_rule__OCLCodeElement__Group__04742);
            rule__OCLCodeElement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLCodeElement__Group__0"


    // $ANTLR start "rule__OCLCodeElement__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2351:1: rule__OCLCodeElement__Group__0__Impl : ( () ) ;
    public final void rule__OCLCodeElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2355:1: ( ( () ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2356:1: ( () )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2356:1: ( () )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2357:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLCodeElementAccess().getOCLCodeElementAction_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2358:1: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2360:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLCodeElementAccess().getOCLCodeElementAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLCodeElement__Group__0__Impl"


    // $ANTLR start "rule__OCLCodeElement__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2370:1: rule__OCLCodeElement__Group__1 : rule__OCLCodeElement__Group__1__Impl rule__OCLCodeElement__Group__2 ;
    public final void rule__OCLCodeElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2374:1: ( rule__OCLCodeElement__Group__1__Impl rule__OCLCodeElement__Group__2 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2375:2: rule__OCLCodeElement__Group__1__Impl rule__OCLCodeElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLCodeElement__Group__1__Impl_in_rule__OCLCodeElement__Group__14800);
            rule__OCLCodeElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OCLCodeElement__Group__2_in_rule__OCLCodeElement__Group__14803);
            rule__OCLCodeElement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLCodeElement__Group__1"


    // $ANTLR start "rule__OCLCodeElement__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2382:1: rule__OCLCodeElement__Group__1__Impl : ( 'oclCode' ) ;
    public final void rule__OCLCodeElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2386:1: ( ( 'oclCode' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2387:1: ( 'oclCode' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2387:1: ( 'oclCode' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2388:1: 'oclCode'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLCodeElementAccess().getOclCodeKeyword_1()); 
            }
            match(input,23,FollowSets000.FOLLOW_23_in_rule__OCLCodeElement__Group__1__Impl4831); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLCodeElementAccess().getOclCodeKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLCodeElement__Group__1__Impl"


    // $ANTLR start "rule__OCLCodeElement__Group__2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2401:1: rule__OCLCodeElement__Group__2 : rule__OCLCodeElement__Group__2__Impl rule__OCLCodeElement__Group__3 ;
    public final void rule__OCLCodeElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2405:1: ( rule__OCLCodeElement__Group__2__Impl rule__OCLCodeElement__Group__3 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2406:2: rule__OCLCodeElement__Group__2__Impl rule__OCLCodeElement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLCodeElement__Group__2__Impl_in_rule__OCLCodeElement__Group__24862);
            rule__OCLCodeElement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OCLCodeElement__Group__3_in_rule__OCLCodeElement__Group__24865);
            rule__OCLCodeElement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLCodeElement__Group__2"


    // $ANTLR start "rule__OCLCodeElement__Group__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2413:1: rule__OCLCodeElement__Group__2__Impl : ( '[' ) ;
    public final void rule__OCLCodeElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2417:1: ( ( '[' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2418:1: ( '[' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2418:1: ( '[' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2419:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLCodeElementAccess().getLeftSquareBracketKeyword_2()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__OCLCodeElement__Group__2__Impl4893); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLCodeElementAccess().getLeftSquareBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLCodeElement__Group__2__Impl"


    // $ANTLR start "rule__OCLCodeElement__Group__3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2432:1: rule__OCLCodeElement__Group__3 : rule__OCLCodeElement__Group__3__Impl rule__OCLCodeElement__Group__4 ;
    public final void rule__OCLCodeElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2436:1: ( rule__OCLCodeElement__Group__3__Impl rule__OCLCodeElement__Group__4 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2437:2: rule__OCLCodeElement__Group__3__Impl rule__OCLCodeElement__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLCodeElement__Group__3__Impl_in_rule__OCLCodeElement__Group__34924);
            rule__OCLCodeElement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OCLCodeElement__Group__4_in_rule__OCLCodeElement__Group__34927);
            rule__OCLCodeElement__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLCodeElement__Group__3"


    // $ANTLR start "rule__OCLCodeElement__Group__3__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2444:1: rule__OCLCodeElement__Group__3__Impl : ( ( rule__OCLCodeElement__ElementsAssignment_3 )* ) ;
    public final void rule__OCLCodeElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2448:1: ( ( ( rule__OCLCodeElement__ElementsAssignment_3 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2449:1: ( ( rule__OCLCodeElement__ElementsAssignment_3 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2449:1: ( ( rule__OCLCodeElement__ElementsAssignment_3 )* )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2450:1: ( rule__OCLCodeElement__ElementsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLCodeElementAccess().getElementsAssignment_3()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2451:1: ( rule__OCLCodeElement__ElementsAssignment_3 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_WS)||LA19_0==RULE_NL||(LA19_0>=16 && LA19_0<=29)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2451:2: rule__OCLCodeElement__ElementsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OCLCodeElement__ElementsAssignment_3_in_rule__OCLCodeElement__Group__3__Impl4954);
            	    rule__OCLCodeElement__ElementsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLCodeElementAccess().getElementsAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLCodeElement__Group__3__Impl"


    // $ANTLR start "rule__OCLCodeElement__Group__4"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2461:1: rule__OCLCodeElement__Group__4 : rule__OCLCodeElement__Group__4__Impl ;
    public final void rule__OCLCodeElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2465:1: ( rule__OCLCodeElement__Group__4__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2466:2: rule__OCLCodeElement__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLCodeElement__Group__4__Impl_in_rule__OCLCodeElement__Group__44985);
            rule__OCLCodeElement__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLCodeElement__Group__4"


    // $ANTLR start "rule__OCLCodeElement__Group__4__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2472:1: rule__OCLCodeElement__Group__4__Impl : ( ']' ) ;
    public final void rule__OCLCodeElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2476:1: ( ( ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2477:1: ( ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2477:1: ( ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2478:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLCodeElementAccess().getRightSquareBracketKeyword_4()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__OCLCodeElement__Group__4__Impl5013); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLCodeElementAccess().getRightSquareBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLCodeElement__Group__4__Impl"


    // $ANTLR start "rule__OCLEvalElement__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2501:1: rule__OCLEvalElement__Group__0 : rule__OCLEvalElement__Group__0__Impl rule__OCLEvalElement__Group__1 ;
    public final void rule__OCLEvalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2505:1: ( rule__OCLEvalElement__Group__0__Impl rule__OCLEvalElement__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2506:2: rule__OCLEvalElement__Group__0__Impl rule__OCLEvalElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLEvalElement__Group__0__Impl_in_rule__OCLEvalElement__Group__05054);
            rule__OCLEvalElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OCLEvalElement__Group__1_in_rule__OCLEvalElement__Group__05057);
            rule__OCLEvalElement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLEvalElement__Group__0"


    // $ANTLR start "rule__OCLEvalElement__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2513:1: rule__OCLEvalElement__Group__0__Impl : ( () ) ;
    public final void rule__OCLEvalElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2517:1: ( ( () ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2518:1: ( () )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2518:1: ( () )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2519:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLEvalElementAccess().getOCLEvalElementAction_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2520:1: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2522:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLEvalElementAccess().getOCLEvalElementAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLEvalElement__Group__0__Impl"


    // $ANTLR start "rule__OCLEvalElement__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2532:1: rule__OCLEvalElement__Group__1 : rule__OCLEvalElement__Group__1__Impl rule__OCLEvalElement__Group__2 ;
    public final void rule__OCLEvalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2536:1: ( rule__OCLEvalElement__Group__1__Impl rule__OCLEvalElement__Group__2 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2537:2: rule__OCLEvalElement__Group__1__Impl rule__OCLEvalElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLEvalElement__Group__1__Impl_in_rule__OCLEvalElement__Group__15115);
            rule__OCLEvalElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OCLEvalElement__Group__2_in_rule__OCLEvalElement__Group__15118);
            rule__OCLEvalElement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLEvalElement__Group__1"


    // $ANTLR start "rule__OCLEvalElement__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2544:1: rule__OCLEvalElement__Group__1__Impl : ( 'oclEval' ) ;
    public final void rule__OCLEvalElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2548:1: ( ( 'oclEval' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2549:1: ( 'oclEval' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2549:1: ( 'oclEval' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2550:1: 'oclEval'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLEvalElementAccess().getOclEvalKeyword_1()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__OCLEvalElement__Group__1__Impl5146); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLEvalElementAccess().getOclEvalKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLEvalElement__Group__1__Impl"


    // $ANTLR start "rule__OCLEvalElement__Group__2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2563:1: rule__OCLEvalElement__Group__2 : rule__OCLEvalElement__Group__2__Impl rule__OCLEvalElement__Group__3 ;
    public final void rule__OCLEvalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2567:1: ( rule__OCLEvalElement__Group__2__Impl rule__OCLEvalElement__Group__3 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2568:2: rule__OCLEvalElement__Group__2__Impl rule__OCLEvalElement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLEvalElement__Group__2__Impl_in_rule__OCLEvalElement__Group__25177);
            rule__OCLEvalElement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OCLEvalElement__Group__3_in_rule__OCLEvalElement__Group__25180);
            rule__OCLEvalElement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLEvalElement__Group__2"


    // $ANTLR start "rule__OCLEvalElement__Group__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2575:1: rule__OCLEvalElement__Group__2__Impl : ( '[' ) ;
    public final void rule__OCLEvalElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2579:1: ( ( '[' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2580:1: ( '[' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2580:1: ( '[' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2581:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLEvalElementAccess().getLeftSquareBracketKeyword_2()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__OCLEvalElement__Group__2__Impl5208); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLEvalElementAccess().getLeftSquareBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLEvalElement__Group__2__Impl"


    // $ANTLR start "rule__OCLEvalElement__Group__3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2594:1: rule__OCLEvalElement__Group__3 : rule__OCLEvalElement__Group__3__Impl rule__OCLEvalElement__Group__4 ;
    public final void rule__OCLEvalElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2598:1: ( rule__OCLEvalElement__Group__3__Impl rule__OCLEvalElement__Group__4 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2599:2: rule__OCLEvalElement__Group__3__Impl rule__OCLEvalElement__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLEvalElement__Group__3__Impl_in_rule__OCLEvalElement__Group__35239);
            rule__OCLEvalElement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OCLEvalElement__Group__4_in_rule__OCLEvalElement__Group__35242);
            rule__OCLEvalElement__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLEvalElement__Group__3"


    // $ANTLR start "rule__OCLEvalElement__Group__3__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2606:1: rule__OCLEvalElement__Group__3__Impl : ( ( rule__OCLEvalElement__ElementsAssignment_3 )* ) ;
    public final void rule__OCLEvalElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2610:1: ( ( ( rule__OCLEvalElement__ElementsAssignment_3 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2611:1: ( ( rule__OCLEvalElement__ElementsAssignment_3 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2611:1: ( ( rule__OCLEvalElement__ElementsAssignment_3 )* )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2612:1: ( rule__OCLEvalElement__ElementsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLEvalElementAccess().getElementsAssignment_3()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2613:1: ( rule__OCLEvalElement__ElementsAssignment_3 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_WS)||LA20_0==RULE_NL||(LA20_0>=16 && LA20_0<=29)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2613:2: rule__OCLEvalElement__ElementsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OCLEvalElement__ElementsAssignment_3_in_rule__OCLEvalElement__Group__3__Impl5269);
            	    rule__OCLEvalElement__ElementsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLEvalElementAccess().getElementsAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLEvalElement__Group__3__Impl"


    // $ANTLR start "rule__OCLEvalElement__Group__4"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2623:1: rule__OCLEvalElement__Group__4 : rule__OCLEvalElement__Group__4__Impl ;
    public final void rule__OCLEvalElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2627:1: ( rule__OCLEvalElement__Group__4__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2628:2: rule__OCLEvalElement__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLEvalElement__Group__4__Impl_in_rule__OCLEvalElement__Group__45300);
            rule__OCLEvalElement__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLEvalElement__Group__4"


    // $ANTLR start "rule__OCLEvalElement__Group__4__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2634:1: rule__OCLEvalElement__Group__4__Impl : ( ']' ) ;
    public final void rule__OCLEvalElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2638:1: ( ( ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2639:1: ( ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2639:1: ( ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2640:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLEvalElementAccess().getRightSquareBracketKeyword_4()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__OCLEvalElement__Group__4__Impl5328); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLEvalElementAccess().getRightSquareBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLEvalElement__Group__4__Impl"


    // $ANTLR start "rule__OCLTextElement__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2663:1: rule__OCLTextElement__Group__0 : rule__OCLTextElement__Group__0__Impl rule__OCLTextElement__Group__1 ;
    public final void rule__OCLTextElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2667:1: ( rule__OCLTextElement__Group__0__Impl rule__OCLTextElement__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2668:2: rule__OCLTextElement__Group__0__Impl rule__OCLTextElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLTextElement__Group__0__Impl_in_rule__OCLTextElement__Group__05369);
            rule__OCLTextElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OCLTextElement__Group__1_in_rule__OCLTextElement__Group__05372);
            rule__OCLTextElement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLTextElement__Group__0"


    // $ANTLR start "rule__OCLTextElement__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2675:1: rule__OCLTextElement__Group__0__Impl : ( () ) ;
    public final void rule__OCLTextElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2679:1: ( ( () ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2680:1: ( () )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2680:1: ( () )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2681:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLTextElementAccess().getOCLTextElementAction_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2682:1: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2684:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLTextElementAccess().getOCLTextElementAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLTextElement__Group__0__Impl"


    // $ANTLR start "rule__OCLTextElement__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2694:1: rule__OCLTextElement__Group__1 : rule__OCLTextElement__Group__1__Impl rule__OCLTextElement__Group__2 ;
    public final void rule__OCLTextElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2698:1: ( rule__OCLTextElement__Group__1__Impl rule__OCLTextElement__Group__2 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2699:2: rule__OCLTextElement__Group__1__Impl rule__OCLTextElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLTextElement__Group__1__Impl_in_rule__OCLTextElement__Group__15430);
            rule__OCLTextElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OCLTextElement__Group__2_in_rule__OCLTextElement__Group__15433);
            rule__OCLTextElement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLTextElement__Group__1"


    // $ANTLR start "rule__OCLTextElement__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2706:1: rule__OCLTextElement__Group__1__Impl : ( 'oclText' ) ;
    public final void rule__OCLTextElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2710:1: ( ( 'oclText' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2711:1: ( 'oclText' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2711:1: ( 'oclText' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2712:1: 'oclText'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLTextElementAccess().getOclTextKeyword_1()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__OCLTextElement__Group__1__Impl5461); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLTextElementAccess().getOclTextKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLTextElement__Group__1__Impl"


    // $ANTLR start "rule__OCLTextElement__Group__2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2725:1: rule__OCLTextElement__Group__2 : rule__OCLTextElement__Group__2__Impl rule__OCLTextElement__Group__3 ;
    public final void rule__OCLTextElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2729:1: ( rule__OCLTextElement__Group__2__Impl rule__OCLTextElement__Group__3 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2730:2: rule__OCLTextElement__Group__2__Impl rule__OCLTextElement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLTextElement__Group__2__Impl_in_rule__OCLTextElement__Group__25492);
            rule__OCLTextElement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OCLTextElement__Group__3_in_rule__OCLTextElement__Group__25495);
            rule__OCLTextElement__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLTextElement__Group__2"


    // $ANTLR start "rule__OCLTextElement__Group__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2737:1: rule__OCLTextElement__Group__2__Impl : ( '[' ) ;
    public final void rule__OCLTextElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2741:1: ( ( '[' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2742:1: ( '[' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2742:1: ( '[' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2743:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLTextElementAccess().getLeftSquareBracketKeyword_2()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__OCLTextElement__Group__2__Impl5523); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLTextElementAccess().getLeftSquareBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLTextElement__Group__2__Impl"


    // $ANTLR start "rule__OCLTextElement__Group__3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2756:1: rule__OCLTextElement__Group__3 : rule__OCLTextElement__Group__3__Impl rule__OCLTextElement__Group__4 ;
    public final void rule__OCLTextElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2760:1: ( rule__OCLTextElement__Group__3__Impl rule__OCLTextElement__Group__4 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2761:2: rule__OCLTextElement__Group__3__Impl rule__OCLTextElement__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLTextElement__Group__3__Impl_in_rule__OCLTextElement__Group__35554);
            rule__OCLTextElement__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OCLTextElement__Group__4_in_rule__OCLTextElement__Group__35557);
            rule__OCLTextElement__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLTextElement__Group__3"


    // $ANTLR start "rule__OCLTextElement__Group__3__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2768:1: rule__OCLTextElement__Group__3__Impl : ( ( rule__OCLTextElement__ElementsAssignment_3 )* ) ;
    public final void rule__OCLTextElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2772:1: ( ( ( rule__OCLTextElement__ElementsAssignment_3 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2773:1: ( ( rule__OCLTextElement__ElementsAssignment_3 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2773:1: ( ( rule__OCLTextElement__ElementsAssignment_3 )* )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2774:1: ( rule__OCLTextElement__ElementsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLTextElementAccess().getElementsAssignment_3()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2775:1: ( rule__OCLTextElement__ElementsAssignment_3 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_WS)||LA21_0==RULE_NL||(LA21_0>=16 && LA21_0<=29)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2775:2: rule__OCLTextElement__ElementsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OCLTextElement__ElementsAssignment_3_in_rule__OCLTextElement__Group__3__Impl5584);
            	    rule__OCLTextElement__ElementsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLTextElementAccess().getElementsAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLTextElement__Group__3__Impl"


    // $ANTLR start "rule__OCLTextElement__Group__4"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2785:1: rule__OCLTextElement__Group__4 : rule__OCLTextElement__Group__4__Impl ;
    public final void rule__OCLTextElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2789:1: ( rule__OCLTextElement__Group__4__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2790:2: rule__OCLTextElement__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OCLTextElement__Group__4__Impl_in_rule__OCLTextElement__Group__45615);
            rule__OCLTextElement__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLTextElement__Group__4"


    // $ANTLR start "rule__OCLTextElement__Group__4__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2796:1: rule__OCLTextElement__Group__4__Impl : ( ']' ) ;
    public final void rule__OCLTextElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2800:1: ( ( ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2801:1: ( ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2801:1: ( ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2802:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLTextElementAccess().getRightSquareBracketKeyword_4()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__OCLTextElement__Group__4__Impl5643); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLTextElementAccess().getRightSquareBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLTextElement__Group__4__Impl"


    // $ANTLR start "rule__Markup__ElementsAssignment"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2826:1: rule__Markup__ElementsAssignment : ( ruleMarkupElement ) ;
    public final void rule__Markup__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2830:1: ( ( ruleMarkupElement ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2831:1: ( ruleMarkupElement )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2831:1: ( ruleMarkupElement )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2832:1: ruleMarkupElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMarkupAccess().getElementsMarkupElementParserRuleCall_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_rule__Markup__ElementsAssignment5689);
            ruleMarkupElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMarkupAccess().getElementsMarkupElementParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Markup__ElementsAssignment"


    // $ANTLR start "rule__BulletElement__LevelAssignment_2_1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2841:1: rule__BulletElement__LevelAssignment_2_1 : ( RULE_INT ) ;
    public final void rule__BulletElement__LevelAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2845:1: ( ( RULE_INT ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2846:1: ( RULE_INT )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2846:1: ( RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2847:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getLevelINTTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__BulletElement__LevelAssignment_2_15720); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBulletElementAccess().getLevelINTTerminalRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__LevelAssignment_2_1"


    // $ANTLR start "rule__BulletElement__ElementsAssignment_4"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2856:1: rule__BulletElement__ElementsAssignment_4 : ( ruleMarkupElement ) ;
    public final void rule__BulletElement__ElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2860:1: ( ( ruleMarkupElement ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2861:1: ( ruleMarkupElement )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2861:1: ( ruleMarkupElement )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2862:1: ruleMarkupElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getElementsMarkupElementParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_rule__BulletElement__ElementsAssignment_45751);
            ruleMarkupElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBulletElementAccess().getElementsMarkupElementParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BulletElement__ElementsAssignment_4"


    // $ANTLR start "rule__FontElement__FontAssignment_0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2871:1: rule__FontElement__FontAssignment_0 : ( ( rule__FontElement__FontAlternatives_0_0 ) ) ;
    public final void rule__FontElement__FontAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2875:1: ( ( ( rule__FontElement__FontAlternatives_0_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2876:1: ( ( rule__FontElement__FontAlternatives_0_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2876:1: ( ( rule__FontElement__FontAlternatives_0_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2877:1: ( rule__FontElement__FontAlternatives_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFontElementAccess().getFontAlternatives_0_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2878:1: ( rule__FontElement__FontAlternatives_0_0 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2878:2: rule__FontElement__FontAlternatives_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FontElement__FontAlternatives_0_0_in_rule__FontElement__FontAssignment_05782);
            rule__FontElement__FontAlternatives_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFontElementAccess().getFontAlternatives_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontElement__FontAssignment_0"


    // $ANTLR start "rule__FontElement__ElementsAssignment_2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2887:1: rule__FontElement__ElementsAssignment_2 : ( ruleMarkupElement ) ;
    public final void rule__FontElement__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2891:1: ( ( ruleMarkupElement ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2892:1: ( ruleMarkupElement )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2892:1: ( ruleMarkupElement )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2893:1: ruleMarkupElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFontElementAccess().getElementsMarkupElementParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_rule__FontElement__ElementsAssignment_25815);
            ruleMarkupElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFontElementAccess().getElementsMarkupElementParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontElement__ElementsAssignment_2"


    // $ANTLR start "rule__FigureElement__DefAssignment_1_1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2902:1: rule__FigureElement__DefAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__FigureElement__DefAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2906:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2907:1: ( RULE_ID )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2907:1: ( RULE_ID )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2908:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getDefIDTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FigureElement__DefAssignment_1_15846); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getDefIDTerminalRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__DefAssignment_1_1"


    // $ANTLR start "rule__FigureElement__SrcAssignment_3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2917:1: rule__FigureElement__SrcAssignment_3 : ( RULE_STRING ) ;
    public final void rule__FigureElement__SrcAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2921:1: ( ( RULE_STRING ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2922:1: ( RULE_STRING )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2922:1: ( RULE_STRING )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2923:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getSrcSTRINGTerminalRuleCall_3_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__FigureElement__SrcAssignment_35877); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getSrcSTRINGTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__SrcAssignment_3"


    // $ANTLR start "rule__FigureElement__AltAssignment_4_1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2932:1: rule__FigureElement__AltAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__FigureElement__AltAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2936:1: ( ( RULE_STRING ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2937:1: ( RULE_STRING )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2937:1: ( RULE_STRING )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2938:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getAltSTRINGTerminalRuleCall_4_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__FigureElement__AltAssignment_4_15908); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getAltSTRINGTerminalRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__AltAssignment_4_1"


    // $ANTLR start "rule__FigureElement__RequiredWidthAssignment_4_2_1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2947:1: rule__FigureElement__RequiredWidthAssignment_4_2_1 : ( RULE_INT ) ;
    public final void rule__FigureElement__RequiredWidthAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2951:1: ( ( RULE_INT ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2952:1: ( RULE_INT )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2952:1: ( RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2953:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getRequiredWidthINTTerminalRuleCall_4_2_1_0()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__FigureElement__RequiredWidthAssignment_4_2_15939); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getRequiredWidthINTTerminalRuleCall_4_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__RequiredWidthAssignment_4_2_1"


    // $ANTLR start "rule__FigureElement__RequiredHeightAssignment_4_2_2_1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2962:1: rule__FigureElement__RequiredHeightAssignment_4_2_2_1 : ( RULE_INT ) ;
    public final void rule__FigureElement__RequiredHeightAssignment_4_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2966:1: ( ( RULE_INT ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2967:1: ( RULE_INT )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2967:1: ( RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2968:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getRequiredHeightINTTerminalRuleCall_4_2_2_1_0()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__FigureElement__RequiredHeightAssignment_4_2_2_15970); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureElementAccess().getRequiredHeightINTTerminalRuleCall_4_2_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureElement__RequiredHeightAssignment_4_2_2_1"


    // $ANTLR start "rule__FigureRefElement__RefAssignment_2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2977:1: rule__FigureRefElement__RefAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__FigureRefElement__RefAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2981:1: ( ( ( RULE_ID ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2982:1: ( ( RULE_ID ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2982:1: ( ( RULE_ID ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2983:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureRefElementAccess().getRefFigureElementCrossReference_2_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2984:1: ( RULE_ID )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2985:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureRefElementAccess().getRefFigureElementIDTerminalRuleCall_2_0_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FigureRefElement__RefAssignment_26005); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureRefElementAccess().getRefFigureElementIDTerminalRuleCall_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFigureRefElementAccess().getRefFigureElementCrossReference_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FigureRefElement__RefAssignment_2"


    // $ANTLR start "rule__FootnoteElement__ElementsAssignment_3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2996:1: rule__FootnoteElement__ElementsAssignment_3 : ( ruleMarkupElement ) ;
    public final void rule__FootnoteElement__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3000:1: ( ( ruleMarkupElement ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3001:1: ( ruleMarkupElement )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3001:1: ( ruleMarkupElement )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3002:1: ruleMarkupElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFootnoteElementAccess().getElementsMarkupElementParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_rule__FootnoteElement__ElementsAssignment_36040);
            ruleMarkupElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFootnoteElementAccess().getElementsMarkupElementParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FootnoteElement__ElementsAssignment_3"


    // $ANTLR start "rule__HeadingElement__LevelAssignment_2_1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3011:1: rule__HeadingElement__LevelAssignment_2_1 : ( RULE_INT ) ;
    public final void rule__HeadingElement__LevelAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3015:1: ( ( RULE_INT ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3016:1: ( RULE_INT )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3016:1: ( RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3017:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getLevelINTTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__HeadingElement__LevelAssignment_2_16071); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHeadingElementAccess().getLevelINTTerminalRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__LevelAssignment_2_1"


    // $ANTLR start "rule__HeadingElement__ElementsAssignment_4"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3026:1: rule__HeadingElement__ElementsAssignment_4 : ( ruleMarkupElement ) ;
    public final void rule__HeadingElement__ElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3030:1: ( ( ruleMarkupElement ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3031:1: ( ruleMarkupElement )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3031:1: ( ruleMarkupElement )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3032:1: ruleMarkupElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getElementsMarkupElementParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_rule__HeadingElement__ElementsAssignment_46102);
            ruleMarkupElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHeadingElementAccess().getElementsMarkupElementParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HeadingElement__ElementsAssignment_4"


    // $ANTLR start "rule__NewLineElement__TextAssignment"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3041:1: rule__NewLineElement__TextAssignment : ( RULE_NL ) ;
    public final void rule__NewLineElement__TextAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3045:1: ( ( RULE_NL ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3046:1: ( RULE_NL )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3046:1: ( RULE_NL )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3047:1: RULE_NL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewLineElementAccess().getTextNLTerminalRuleCall_0()); 
            }
            match(input,RULE_NL,FollowSets000.FOLLOW_RULE_NL_in_rule__NewLineElement__TextAssignment6133); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewLineElementAccess().getTextNLTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NewLineElement__TextAssignment"


    // $ANTLR start "rule__NullElement__ElementsAssignment_2"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3056:1: rule__NullElement__ElementsAssignment_2 : ( ruleMarkupElement ) ;
    public final void rule__NullElement__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3060:1: ( ( ruleMarkupElement ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3061:1: ( ruleMarkupElement )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3061:1: ( ruleMarkupElement )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3062:1: ruleMarkupElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullElementAccess().getElementsMarkupElementParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_rule__NullElement__ElementsAssignment_26164);
            ruleMarkupElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNullElementAccess().getElementsMarkupElementParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullElement__ElementsAssignment_2"


    // $ANTLR start "rule__OCLCodeElement__ElementsAssignment_3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3071:1: rule__OCLCodeElement__ElementsAssignment_3 : ( ruleMarkupElement ) ;
    public final void rule__OCLCodeElement__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3075:1: ( ( ruleMarkupElement ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3076:1: ( ruleMarkupElement )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3076:1: ( ruleMarkupElement )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3077:1: ruleMarkupElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLCodeElementAccess().getElementsMarkupElementParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_rule__OCLCodeElement__ElementsAssignment_36195);
            ruleMarkupElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLCodeElementAccess().getElementsMarkupElementParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLCodeElement__ElementsAssignment_3"


    // $ANTLR start "rule__OCLEvalElement__ElementsAssignment_3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3086:1: rule__OCLEvalElement__ElementsAssignment_3 : ( ruleMarkupElement ) ;
    public final void rule__OCLEvalElement__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3090:1: ( ( ruleMarkupElement ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3091:1: ( ruleMarkupElement )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3091:1: ( ruleMarkupElement )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3092:1: ruleMarkupElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLEvalElementAccess().getElementsMarkupElementParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_rule__OCLEvalElement__ElementsAssignment_36226);
            ruleMarkupElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLEvalElementAccess().getElementsMarkupElementParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLEvalElement__ElementsAssignment_3"


    // $ANTLR start "rule__OCLTextElement__ElementsAssignment_3"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3101:1: rule__OCLTextElement__ElementsAssignment_3 : ( ruleMarkupElement ) ;
    public final void rule__OCLTextElement__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3105:1: ( ( ruleMarkupElement ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3106:1: ( ruleMarkupElement )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3106:1: ( ruleMarkupElement )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3107:1: ruleMarkupElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLTextElementAccess().getElementsMarkupElementParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_rule__OCLTextElement__ElementsAssignment_36257);
            ruleMarkupElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOCLTextElementAccess().getElementsMarkupElementParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OCLTextElement__ElementsAssignment_3"


    // $ANTLR start "rule__TextElement__TextAssignment_0"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3116:1: rule__TextElement__TextAssignment_0 : ( ( rule__TextElement__TextAlternatives_0_0 ) ) ;
    public final void rule__TextElement__TextAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3120:1: ( ( ( rule__TextElement__TextAlternatives_0_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3121:1: ( ( rule__TextElement__TextAlternatives_0_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3121:1: ( ( rule__TextElement__TextAlternatives_0_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3122:1: ( rule__TextElement__TextAlternatives_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTextElementAccess().getTextAlternatives_0_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3123:1: ( rule__TextElement__TextAlternatives_0_0 )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3123:2: rule__TextElement__TextAlternatives_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TextElement__TextAlternatives_0_0_in_rule__TextElement__TextAssignment_06288);
            rule__TextElement__TextAlternatives_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTextElementAccess().getTextAlternatives_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextElement__TextAssignment_0"


    // $ANTLR start "rule__TextElement__TextAssignment_1"
    // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3132:1: rule__TextElement__TextAssignment_1 : ( ruleMarkupKeyword ) ;
    public final void rule__TextElement__TextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3136:1: ( ( ruleMarkupKeyword ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3137:1: ( ruleMarkupKeyword )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3137:1: ( ruleMarkupKeyword )
            // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3138:1: ruleMarkupKeyword
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTextElementAccess().getTextMarkupKeywordParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupKeyword_in_rule__TextElement__TextAssignment_16321);
            ruleMarkupKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTextElementAccess().getTextMarkupKeywordParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextElement__TextAssignment_1"

    // $ANTLR start synpred11_InternalMarkup
    public final void synpred11_InternalMarkup_fragment() throws RecognitionException {   
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:583:1: ( ( ruleFontElement ) )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:583:1: ( ruleFontElement )
        {
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:583:1: ( ruleFontElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:584:1: ruleFontElement
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getMarkupElementAccess().getFontElementParserRuleCall_0()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleFontElement_in_synpred11_InternalMarkup1192);
        ruleFontElement();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalMarkup

    // $ANTLR start synpred13_InternalMarkup
    public final void synpred13_InternalMarkup_fragment() throws RecognitionException {   
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:595:6: ( ( ruleBulletElement ) )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:595:6: ( ruleBulletElement )
        {
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:595:6: ( ruleBulletElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:596:1: ruleBulletElement
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getMarkupElementAccess().getBulletElementParserRuleCall_2()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleBulletElement_in_synpred13_InternalMarkup1226);
        ruleBulletElement();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalMarkup

    // $ANTLR start synpred14_InternalMarkup
    public final void synpred14_InternalMarkup_fragment() throws RecognitionException {   
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:601:6: ( ( ruleFigureElement ) )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:601:6: ( ruleFigureElement )
        {
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:601:6: ( ruleFigureElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:602:1: ruleFigureElement
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getMarkupElementAccess().getFigureElementParserRuleCall_3()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleFigureElement_in_synpred14_InternalMarkup1243);
        ruleFigureElement();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalMarkup

    // $ANTLR start synpred15_InternalMarkup
    public final void synpred15_InternalMarkup_fragment() throws RecognitionException {   
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:607:6: ( ( ruleFigureRefElement ) )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:607:6: ( ruleFigureRefElement )
        {
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:607:6: ( ruleFigureRefElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:608:1: ruleFigureRefElement
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getMarkupElementAccess().getFigureRefElementParserRuleCall_4()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleFigureRefElement_in_synpred15_InternalMarkup1260);
        ruleFigureRefElement();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalMarkup

    // $ANTLR start synpred16_InternalMarkup
    public final void synpred16_InternalMarkup_fragment() throws RecognitionException {   
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:613:6: ( ( ruleFootnoteElement ) )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:613:6: ( ruleFootnoteElement )
        {
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:613:6: ( ruleFootnoteElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:614:1: ruleFootnoteElement
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getMarkupElementAccess().getFootnoteElementParserRuleCall_5()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleFootnoteElement_in_synpred16_InternalMarkup1277);
        ruleFootnoteElement();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred16_InternalMarkup

    // $ANTLR start synpred17_InternalMarkup
    public final void synpred17_InternalMarkup_fragment() throws RecognitionException {   
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:619:6: ( ( ruleHeadingElement ) )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:619:6: ( ruleHeadingElement )
        {
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:619:6: ( ruleHeadingElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:620:1: ruleHeadingElement
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getMarkupElementAccess().getHeadingElementParserRuleCall_6()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleHeadingElement_in_synpred17_InternalMarkup1294);
        ruleHeadingElement();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred17_InternalMarkup

    // $ANTLR start synpred19_InternalMarkup
    public final void synpred19_InternalMarkup_fragment() throws RecognitionException {   
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:631:6: ( ( ruleOCLCodeElement ) )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:631:6: ( ruleOCLCodeElement )
        {
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:631:6: ( ruleOCLCodeElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:632:1: ruleOCLCodeElement
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getMarkupElementAccess().getOCLCodeElementParserRuleCall_8()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleOCLCodeElement_in_synpred19_InternalMarkup1328);
        ruleOCLCodeElement();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalMarkup

    // $ANTLR start synpred20_InternalMarkup
    public final void synpred20_InternalMarkup_fragment() throws RecognitionException {   
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:637:6: ( ( ruleOCLEvalElement ) )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:637:6: ( ruleOCLEvalElement )
        {
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:637:6: ( ruleOCLEvalElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:638:1: ruleOCLEvalElement
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getMarkupElementAccess().getOCLEvalElementParserRuleCall_9()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleOCLEvalElement_in_synpred20_InternalMarkup1345);
        ruleOCLEvalElement();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalMarkup

    // $ANTLR start synpred21_InternalMarkup
    public final void synpred21_InternalMarkup_fragment() throws RecognitionException {   
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:643:6: ( ( ruleOCLTextElement ) )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:643:6: ( ruleOCLTextElement )
        {
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:643:6: ( ruleOCLTextElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:644:1: ruleOCLTextElement
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getMarkupElementAccess().getOCLTextElementParserRuleCall_10()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleOCLTextElement_in_synpred21_InternalMarkup1362);
        ruleOCLTextElement();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_InternalMarkup

    // $ANTLR start synpred23_InternalMarkup
    public final void synpred23_InternalMarkup_fragment() throws RecognitionException {   
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:699:2: ( rule__TextElement__TextAssignment_0 )
        // ../../plugins/org.eclipse.ocl.xtext.markup.ui/src-gen/org/eclipse/ocl/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:699:2: rule__TextElement__TextAssignment_0
        {
        pushFollow(FollowSets000.FOLLOW_rule__TextElement__TextAssignment_0_in_synpred23_InternalMarkup1480);
        rule__TextElement__TextAssignment_0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalMarkup

    // Delegated rules

    public final boolean synpred16_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA3_eotS =
        "\35\uffff";
    static final String DFA3_eofS =
        "\35\uffff";
    static final String DFA3_minS =
        "\1\4\2\0\1\uffff\5\0\1\uffff\3\0\20\uffff";
    static final String DFA3_maxS =
        "\1\35\2\0\1\uffff\5\0\1\uffff\3\0\20\uffff";
    static final String DFA3_acceptS =
        "\3\uffff\1\2\5\uffff\1\10\3\uffff\1\14\6\uffff\1\1\1\3\1\4\1\5"+
        "\1\6\1\7\1\11\1\12\1\13";
    static final String DFA3_specialS =
        "\1\uffff\1\0\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\1\10\1"+
        "\11\20\uffff}>";
    static final String[] DFA3_transitionS = {
            "\4\15\1\uffff\1\3\6\uffff\1\1\1\2\1\4\1\5\1\6\1\7\1\10\1\12"+
            "\1\13\1\14\3\15\1\11",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "578:1: rule__MarkupElement__Alternatives : ( ( ruleFontElement ) | ( ruleNewLineElement ) | ( ruleBulletElement ) | ( ruleFigureElement ) | ( ruleFigureRefElement ) | ( ruleFootnoteElement ) | ( ruleHeadingElement ) | ( ruleNullElement ) | ( ruleOCLCodeElement ) | ( ruleOCLEvalElement ) | ( ruleOCLTextElement ) | ( ruleTextElement ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_1 = input.LA(1);

                         
                        int index3_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalMarkup()) ) {s = 20;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA3_2 = input.LA(1);

                         
                        int index3_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalMarkup()) ) {s = 20;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA3_4 = input.LA(1);

                         
                        int index3_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMarkup()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA3_5 = input.LA(1);

                         
                        int index3_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalMarkup()) ) {s = 22;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA3_6 = input.LA(1);

                         
                        int index3_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalMarkup()) ) {s = 23;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA3_7 = input.LA(1);

                         
                        int index3_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalMarkup()) ) {s = 24;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA3_8 = input.LA(1);

                         
                        int index3_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalMarkup()) ) {s = 25;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA3_10 = input.LA(1);

                         
                        int index3_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalMarkup()) ) {s = 26;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_10);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA3_11 = input.LA(1);

                         
                        int index3_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalMarkup()) ) {s = 27;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_11);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA3_12 = input.LA(1);

                         
                        int index3_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalMarkup()) ) {s = 28;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA5_eotS =
        "\12\uffff";
    static final String DFA5_eofS =
        "\1\1\11\uffff";
    static final String DFA5_minS =
        "\1\4\1\uffff\7\0\1\uffff";
    static final String DFA5_maxS =
        "\1\36\1\uffff\7\0\1\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA5_specialS =
        "\2\uffff\1\4\1\0\1\2\1\3\1\5\1\1\1\6\1\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\1\3\1\4\1\5\1\uffff\1\1\6\uffff\12\1\1\6\1\7\1\10\2\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()* loopback of 699:1: ( rule__TextElement__TextAssignment_0 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_3 = input.LA(1);

                         
                        int index5_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_7 = input.LA(1);

                         
                        int index5_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_4 = input.LA(1);

                         
                        int index5_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_5 = input.LA(1);

                         
                        int index5_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA5_2 = input.LA(1);

                         
                        int index5_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA5_6 = input.LA(1);

                         
                        int index5_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA5_8 = input.LA(1);

                         
                        int index5_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMarkup_in_entryRuleMarkup67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMarkup74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Markup__ElementsAssignment_in_ruleMarkup100 = new BitSet(new long[]{0x000000003FFF02F2L});
        public static final BitSet FOLLOW_ruleMarkupKeyword_in_entryRuleMarkupKeyword128 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMarkupKeyword135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MarkupKeyword__Alternatives_in_ruleMarkupKeyword161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_entryRuleMarkupElement188 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMarkupElement195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MarkupElement__Alternatives_in_ruleMarkupElement221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBulletElement_in_entryRuleBulletElement248 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBulletElement255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BulletElement__Group__0_in_ruleBulletElement281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFontElement_in_entryRuleFontElement308 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFontElement315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FontElement__Group__0_in_ruleFontElement341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFigureElement_in_entryRuleFigureElement368 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFigureElement375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group__0_in_ruleFigureElement401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFigureRefElement_in_entryRuleFigureRefElement428 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFigureRefElement435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureRefElement__Group__0_in_ruleFigureRefElement461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFootnoteElement_in_entryRuleFootnoteElement488 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFootnoteElement495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FootnoteElement__Group__0_in_ruleFootnoteElement521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHeadingElement_in_entryRuleHeadingElement548 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHeadingElement555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group__0_in_ruleHeadingElement581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNewLineElement_in_entryRuleNewLineElement608 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNewLineElement615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NewLineElement__TextAssignment_in_ruleNewLineElement641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullElement_in_entryRuleNullElement668 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullElement675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullElement__Group__0_in_ruleNullElement701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLCodeElement_in_entryRuleOCLCodeElement728 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOCLCodeElement735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLCodeElement__Group__0_in_ruleOCLCodeElement761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLEvalElement_in_entryRuleOCLEvalElement788 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOCLEvalElement795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLEvalElement__Group__0_in_ruleOCLEvalElement821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLTextElement_in_entryRuleOCLTextElement848 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOCLTextElement855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLTextElement__Group__0_in_ruleOCLTextElement881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextElement_in_entryRuleTextElement908 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTextElement915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TextElement__Alternatives_in_ruleTextElement941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__MarkupKeyword__Alternatives978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__MarkupKeyword__Alternatives998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__MarkupKeyword__Alternatives1018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__MarkupKeyword__Alternatives1038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__MarkupKeyword__Alternatives1058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__MarkupKeyword__Alternatives1078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__MarkupKeyword__Alternatives1098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__MarkupKeyword__Alternatives1118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__MarkupKeyword__Alternatives1138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__MarkupKeyword__Alternatives1158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFontElement_in_rule__MarkupElement__Alternatives1192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNewLineElement_in_rule__MarkupElement__Alternatives1209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBulletElement_in_rule__MarkupElement__Alternatives1226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFigureElement_in_rule__MarkupElement__Alternatives1243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFigureRefElement_in_rule__MarkupElement__Alternatives1260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFootnoteElement_in_rule__MarkupElement__Alternatives1277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHeadingElement_in_rule__MarkupElement__Alternatives1294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullElement_in_rule__MarkupElement__Alternatives1311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLCodeElement_in_rule__MarkupElement__Alternatives1328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLEvalElement_in_rule__MarkupElement__Alternatives1345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLTextElement_in_rule__MarkupElement__Alternatives1362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextElement_in_rule__MarkupElement__Alternatives1379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__FontElement__FontAlternatives_0_01412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__FontElement__FontAlternatives_0_01432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TextElement__TextAssignment_0_in_rule__TextElement__Alternatives1468 = new BitSet(new long[]{0x000000001C0000F2L});
        public static final BitSet FOLLOW_rule__TextElement__TextAssignment_0_in_rule__TextElement__Alternatives1480 = new BitSet(new long[]{0x000000001C0000F2L});
        public static final BitSet FOLLOW_rule__TextElement__TextAssignment_1_in_rule__TextElement__Alternatives1501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TextElement__TextAlternatives_0_01534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WORD_in_rule__TextElement__TextAlternatives_0_01551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__TextElement__TextAlternatives_0_01568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WS_in_rule__TextElement__TextAlternatives_0_01585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__TextElement__TextAlternatives_0_01603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__TextElement__TextAlternatives_0_01623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__TextElement__TextAlternatives_0_01643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BulletElement__Group__0__Impl_in_rule__BulletElement__Group__01675 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__BulletElement__Group__1_in_rule__BulletElement__Group__01678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BulletElement__Group__1__Impl_in_rule__BulletElement__Group__11736 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_rule__BulletElement__Group__2_in_rule__BulletElement__Group__11739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__BulletElement__Group__1__Impl1767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BulletElement__Group__2__Impl_in_rule__BulletElement__Group__21798 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_rule__BulletElement__Group__3_in_rule__BulletElement__Group__21801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BulletElement__Group_2__0_in_rule__BulletElement__Group__2__Impl1828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BulletElement__Group__3__Impl_in_rule__BulletElement__Group__31859 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__BulletElement__Group__4_in_rule__BulletElement__Group__31862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__BulletElement__Group__3__Impl1890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BulletElement__Group__4__Impl_in_rule__BulletElement__Group__41921 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__BulletElement__Group__5_in_rule__BulletElement__Group__41924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BulletElement__ElementsAssignment_4_in_rule__BulletElement__Group__4__Impl1951 = new BitSet(new long[]{0x000000003FFF02F2L});
        public static final BitSet FOLLOW_rule__BulletElement__Group__5__Impl_in_rule__BulletElement__Group__51982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__BulletElement__Group__5__Impl2010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BulletElement__Group_2__0__Impl_in_rule__BulletElement__Group_2__02053 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__BulletElement__Group_2__1_in_rule__BulletElement__Group_2__02056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__BulletElement__Group_2__0__Impl2084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BulletElement__Group_2__1__Impl_in_rule__BulletElement__Group_2__12115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__BulletElement__LevelAssignment_2_1_in_rule__BulletElement__Group_2__1__Impl2142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FontElement__Group__0__Impl_in_rule__FontElement__Group__02176 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__FontElement__Group__1_in_rule__FontElement__Group__02179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FontElement__FontAssignment_0_in_rule__FontElement__Group__0__Impl2206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FontElement__Group__1__Impl_in_rule__FontElement__Group__12236 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__FontElement__Group__2_in_rule__FontElement__Group__12239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__FontElement__Group__1__Impl2267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FontElement__Group__2__Impl_in_rule__FontElement__Group__22298 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__FontElement__Group__3_in_rule__FontElement__Group__22301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FontElement__ElementsAssignment_2_in_rule__FontElement__Group__2__Impl2328 = new BitSet(new long[]{0x000000003FFF02F2L});
        public static final BitSet FOLLOW_rule__FontElement__Group__3__Impl_in_rule__FontElement__Group__32359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__FontElement__Group__3__Impl2387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group__0__Impl_in_rule__FigureElement__Group__02426 = new BitSet(new long[]{0x0000000028000000L});
        public static final BitSet FOLLOW_rule__FigureElement__Group__1_in_rule__FigureElement__Group__02429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__FigureElement__Group__0__Impl2457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group__1__Impl_in_rule__FigureElement__Group__12488 = new BitSet(new long[]{0x0000000028000000L});
        public static final BitSet FOLLOW_rule__FigureElement__Group__2_in_rule__FigureElement__Group__12491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_1__0_in_rule__FigureElement__Group__1__Impl2518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group__2__Impl_in_rule__FigureElement__Group__22549 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_rule__FigureElement__Group__3_in_rule__FigureElement__Group__22552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__FigureElement__Group__2__Impl2580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group__3__Impl_in_rule__FigureElement__Group__32611 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_rule__FigureElement__Group__4_in_rule__FigureElement__Group__32614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__SrcAssignment_3_in_rule__FigureElement__Group__3__Impl2641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group__4__Impl_in_rule__FigureElement__Group__42671 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_rule__FigureElement__Group__5_in_rule__FigureElement__Group__42674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4__0_in_rule__FigureElement__Group__4__Impl2701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group__5__Impl_in_rule__FigureElement__Group__52732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__FigureElement__Group__5__Impl2760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_1__0__Impl_in_rule__FigureElement__Group_1__02803 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_1__1_in_rule__FigureElement__Group_1__02806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__FigureElement__Group_1__0__Impl2834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_1__1__Impl_in_rule__FigureElement__Group_1__12865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__DefAssignment_1_1_in_rule__FigureElement__Group_1__1__Impl2892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4__0__Impl_in_rule__FigureElement__Group_4__02926 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4__1_in_rule__FigureElement__Group_4__02929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__FigureElement__Group_4__0__Impl2957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4__1__Impl_in_rule__FigureElement__Group_4__12988 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4__2_in_rule__FigureElement__Group_4__12991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__AltAssignment_4_1_in_rule__FigureElement__Group_4__1__Impl3018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4__2__Impl_in_rule__FigureElement__Group_4__23048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4_2__0_in_rule__FigureElement__Group_4__2__Impl3075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4_2__0__Impl_in_rule__FigureElement__Group_4_2__03112 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4_2__1_in_rule__FigureElement__Group_4_2__03115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__FigureElement__Group_4_2__0__Impl3143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4_2__1__Impl_in_rule__FigureElement__Group_4_2__13174 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4_2__2_in_rule__FigureElement__Group_4_2__13177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__RequiredWidthAssignment_4_2_1_in_rule__FigureElement__Group_4_2__1__Impl3204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4_2__2__Impl_in_rule__FigureElement__Group_4_2__23234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4_2_2__0_in_rule__FigureElement__Group_4_2__2__Impl3261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4_2_2__0__Impl_in_rule__FigureElement__Group_4_2_2__03298 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4_2_2__1_in_rule__FigureElement__Group_4_2_2__03301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__FigureElement__Group_4_2_2__0__Impl3329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__Group_4_2_2__1__Impl_in_rule__FigureElement__Group_4_2_2__13360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureElement__RequiredHeightAssignment_4_2_2_1_in_rule__FigureElement__Group_4_2_2__1__Impl3387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureRefElement__Group__0__Impl_in_rule__FigureRefElement__Group__03421 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__FigureRefElement__Group__1_in_rule__FigureRefElement__Group__03424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__FigureRefElement__Group__0__Impl3452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureRefElement__Group__1__Impl_in_rule__FigureRefElement__Group__13483 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FigureRefElement__Group__2_in_rule__FigureRefElement__Group__13486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__FigureRefElement__Group__1__Impl3514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureRefElement__Group__2__Impl_in_rule__FigureRefElement__Group__23545 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__FigureRefElement__Group__3_in_rule__FigureRefElement__Group__23548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureRefElement__RefAssignment_2_in_rule__FigureRefElement__Group__2__Impl3575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FigureRefElement__Group__3__Impl_in_rule__FigureRefElement__Group__33605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__FigureRefElement__Group__3__Impl3633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FootnoteElement__Group__0__Impl_in_rule__FootnoteElement__Group__03672 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__FootnoteElement__Group__1_in_rule__FootnoteElement__Group__03675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FootnoteElement__Group__1__Impl_in_rule__FootnoteElement__Group__13733 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__FootnoteElement__Group__2_in_rule__FootnoteElement__Group__13736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__FootnoteElement__Group__1__Impl3764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FootnoteElement__Group__2__Impl_in_rule__FootnoteElement__Group__23795 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__FootnoteElement__Group__3_in_rule__FootnoteElement__Group__23798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__FootnoteElement__Group__2__Impl3826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FootnoteElement__Group__3__Impl_in_rule__FootnoteElement__Group__33857 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__FootnoteElement__Group__4_in_rule__FootnoteElement__Group__33860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FootnoteElement__ElementsAssignment_3_in_rule__FootnoteElement__Group__3__Impl3887 = new BitSet(new long[]{0x000000003FFF02F2L});
        public static final BitSet FOLLOW_rule__FootnoteElement__Group__4__Impl_in_rule__FootnoteElement__Group__43918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__FootnoteElement__Group__4__Impl3946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group__0__Impl_in_rule__HeadingElement__Group__03987 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group__1_in_rule__HeadingElement__Group__03990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group__1__Impl_in_rule__HeadingElement__Group__14048 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group__2_in_rule__HeadingElement__Group__14051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__HeadingElement__Group__1__Impl4079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group__2__Impl_in_rule__HeadingElement__Group__24110 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group__3_in_rule__HeadingElement__Group__24113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group_2__0_in_rule__HeadingElement__Group__2__Impl4140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group__3__Impl_in_rule__HeadingElement__Group__34171 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group__4_in_rule__HeadingElement__Group__34174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__HeadingElement__Group__3__Impl4202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group__4__Impl_in_rule__HeadingElement__Group__44233 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group__5_in_rule__HeadingElement__Group__44236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__HeadingElement__ElementsAssignment_4_in_rule__HeadingElement__Group__4__Impl4263 = new BitSet(new long[]{0x000000003FFF02F2L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group__5__Impl_in_rule__HeadingElement__Group__54294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__HeadingElement__Group__5__Impl4322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group_2__0__Impl_in_rule__HeadingElement__Group_2__04365 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group_2__1_in_rule__HeadingElement__Group_2__04368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__HeadingElement__Group_2__0__Impl4396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__HeadingElement__Group_2__1__Impl_in_rule__HeadingElement__Group_2__14427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__HeadingElement__LevelAssignment_2_1_in_rule__HeadingElement__Group_2__1__Impl4454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullElement__Group__0__Impl_in_rule__NullElement__Group__04488 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__NullElement__Group__1_in_rule__NullElement__Group__04491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullElement__Group__1__Impl_in_rule__NullElement__Group__14549 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__NullElement__Group__2_in_rule__NullElement__Group__14552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__NullElement__Group__1__Impl4580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullElement__Group__2__Impl_in_rule__NullElement__Group__24611 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__NullElement__Group__3_in_rule__NullElement__Group__24614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NullElement__ElementsAssignment_2_in_rule__NullElement__Group__2__Impl4641 = new BitSet(new long[]{0x000000003FFF02F2L});
        public static final BitSet FOLLOW_rule__NullElement__Group__3__Impl_in_rule__NullElement__Group__34672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__NullElement__Group__3__Impl4700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLCodeElement__Group__0__Impl_in_rule__OCLCodeElement__Group__04739 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__OCLCodeElement__Group__1_in_rule__OCLCodeElement__Group__04742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLCodeElement__Group__1__Impl_in_rule__OCLCodeElement__Group__14800 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__OCLCodeElement__Group__2_in_rule__OCLCodeElement__Group__14803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__OCLCodeElement__Group__1__Impl4831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLCodeElement__Group__2__Impl_in_rule__OCLCodeElement__Group__24862 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__OCLCodeElement__Group__3_in_rule__OCLCodeElement__Group__24865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__OCLCodeElement__Group__2__Impl4893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLCodeElement__Group__3__Impl_in_rule__OCLCodeElement__Group__34924 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__OCLCodeElement__Group__4_in_rule__OCLCodeElement__Group__34927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLCodeElement__ElementsAssignment_3_in_rule__OCLCodeElement__Group__3__Impl4954 = new BitSet(new long[]{0x000000003FFF02F2L});
        public static final BitSet FOLLOW_rule__OCLCodeElement__Group__4__Impl_in_rule__OCLCodeElement__Group__44985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__OCLCodeElement__Group__4__Impl5013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLEvalElement__Group__0__Impl_in_rule__OCLEvalElement__Group__05054 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__OCLEvalElement__Group__1_in_rule__OCLEvalElement__Group__05057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLEvalElement__Group__1__Impl_in_rule__OCLEvalElement__Group__15115 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__OCLEvalElement__Group__2_in_rule__OCLEvalElement__Group__15118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__OCLEvalElement__Group__1__Impl5146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLEvalElement__Group__2__Impl_in_rule__OCLEvalElement__Group__25177 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__OCLEvalElement__Group__3_in_rule__OCLEvalElement__Group__25180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__OCLEvalElement__Group__2__Impl5208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLEvalElement__Group__3__Impl_in_rule__OCLEvalElement__Group__35239 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__OCLEvalElement__Group__4_in_rule__OCLEvalElement__Group__35242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLEvalElement__ElementsAssignment_3_in_rule__OCLEvalElement__Group__3__Impl5269 = new BitSet(new long[]{0x000000003FFF02F2L});
        public static final BitSet FOLLOW_rule__OCLEvalElement__Group__4__Impl_in_rule__OCLEvalElement__Group__45300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__OCLEvalElement__Group__4__Impl5328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLTextElement__Group__0__Impl_in_rule__OCLTextElement__Group__05369 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__OCLTextElement__Group__1_in_rule__OCLTextElement__Group__05372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLTextElement__Group__1__Impl_in_rule__OCLTextElement__Group__15430 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__OCLTextElement__Group__2_in_rule__OCLTextElement__Group__15433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__OCLTextElement__Group__1__Impl5461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLTextElement__Group__2__Impl_in_rule__OCLTextElement__Group__25492 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__OCLTextElement__Group__3_in_rule__OCLTextElement__Group__25495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__OCLTextElement__Group__2__Impl5523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLTextElement__Group__3__Impl_in_rule__OCLTextElement__Group__35554 = new BitSet(new long[]{0x000000007FFF02F0L});
        public static final BitSet FOLLOW_rule__OCLTextElement__Group__4_in_rule__OCLTextElement__Group__35557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OCLTextElement__ElementsAssignment_3_in_rule__OCLTextElement__Group__3__Impl5584 = new BitSet(new long[]{0x000000003FFF02F2L});
        public static final BitSet FOLLOW_rule__OCLTextElement__Group__4__Impl_in_rule__OCLTextElement__Group__45615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__OCLTextElement__Group__4__Impl5643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_rule__Markup__ElementsAssignment5689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__BulletElement__LevelAssignment_2_15720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_rule__BulletElement__ElementsAssignment_45751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FontElement__FontAlternatives_0_0_in_rule__FontElement__FontAssignment_05782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_rule__FontElement__ElementsAssignment_25815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FigureElement__DefAssignment_1_15846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__FigureElement__SrcAssignment_35877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__FigureElement__AltAssignment_4_15908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__FigureElement__RequiredWidthAssignment_4_2_15939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__FigureElement__RequiredHeightAssignment_4_2_2_15970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FigureRefElement__RefAssignment_26005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_rule__FootnoteElement__ElementsAssignment_36040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__HeadingElement__LevelAssignment_2_16071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_rule__HeadingElement__ElementsAssignment_46102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NL_in_rule__NewLineElement__TextAssignment6133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_rule__NullElement__ElementsAssignment_26164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_rule__OCLCodeElement__ElementsAssignment_36195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_rule__OCLEvalElement__ElementsAssignment_36226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_rule__OCLTextElement__ElementsAssignment_36257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TextElement__TextAlternatives_0_0_in_rule__TextElement__TextAssignment_06288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMarkupKeyword_in_rule__TextElement__TextAssignment_16321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFontElement_in_synpred11_InternalMarkup1192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBulletElement_in_synpred13_InternalMarkup1226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFigureElement_in_synpred14_InternalMarkup1243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFigureRefElement_in_synpred15_InternalMarkup1260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFootnoteElement_in_synpred16_InternalMarkup1277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHeadingElement_in_synpred17_InternalMarkup1294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLCodeElement_in_synpred19_InternalMarkup1328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLEvalElement_in_synpred20_InternalMarkup1345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLTextElement_in_synpred21_InternalMarkup1362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TextElement__TextAssignment_0_in_synpred23_InternalMarkup1480 = new BitSet(new long[]{0x0000000000000002L});
    }


}