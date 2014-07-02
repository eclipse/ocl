package org.eclipse.ocl.examples.xtext.markup.ui.contentassist.antlr.internal; 

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
import org.eclipse.ocl.examples.xtext.markup.services.MarkupGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalMarkupParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_WORD", "RULE_INT", "RULE_WS", "RULE_STRING", "RULE_NL", "RULE_NUMBER", "RULE_LETTER", "RULE_ESCAPED", "RULE_VERTICAL_WS", "RULE_HORIZONTAL_WS", "RULE_ANY_OTHER", "'b'", "'e'", "'bullet'", "'figure'", "'figureRef'", "'footnote'", "'heading'", "'oclCode'", "'oclEval'", "'oclText'", "':'", "'#'", "','", "'['", "']'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int RULE_HORIZONTAL_WS=14;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_NL=9;
    public static final int EOF=-1;
    public static final int RULE_LETTER=11;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int RULE_STRING=8;
    public static final int T__16=16;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_NUMBER=10;
    public static final int RULE_VERTICAL_WS=13;
    public static final int RULE_ESCAPED=12;
    public static final int RULE_INT=6;
    public static final int RULE_WS=7;
    public static final int RULE_WORD=5;

    // delegates
    // delegators


        public InternalMarkupParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMarkupParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMarkupParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g"; }


     
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:61:1: entryRuleMarkup : ruleMarkup EOF ;
    public final void entryRuleMarkup() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:62:1: ( ruleMarkup EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:63:1: ruleMarkup EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:70:1: ruleMarkup : ( ( rule__Markup__ElementsAssignment )* ) ;
    public final void ruleMarkup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:74:2: ( ( ( rule__Markup__ElementsAssignment )* ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:75:1: ( ( rule__Markup__ElementsAssignment )* )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:75:1: ( ( rule__Markup__ElementsAssignment )* )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:76:1: ( rule__Markup__ElementsAssignment )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMarkupAccess().getElementsAssignment()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:77:1: ( rule__Markup__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_WS)||LA1_0==RULE_NL||(LA1_0>=16 && LA1_0<=29)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:77:2: rule__Markup__ElementsAssignment
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:89:1: entryRuleMarkupKeyword : ruleMarkupKeyword EOF ;
    public final void entryRuleMarkupKeyword() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:90:1: ( ruleMarkupKeyword EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:91:1: ruleMarkupKeyword EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:98:1: ruleMarkupKeyword : ( ( rule__MarkupKeyword__Alternatives ) ) ;
    public final void ruleMarkupKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:102:2: ( ( ( rule__MarkupKeyword__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:103:1: ( ( rule__MarkupKeyword__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:103:1: ( ( rule__MarkupKeyword__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:104:1: ( rule__MarkupKeyword__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMarkupKeywordAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:105:1: ( rule__MarkupKeyword__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:105:2: rule__MarkupKeyword__Alternatives
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:117:1: entryRuleMarkupElement : ruleMarkupElement EOF ;
    public final void entryRuleMarkupElement() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:118:1: ( ruleMarkupElement EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:119:1: ruleMarkupElement EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:126:1: ruleMarkupElement : ( ( rule__MarkupElement__Alternatives ) ) ;
    public final void ruleMarkupElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:130:2: ( ( ( rule__MarkupElement__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:131:1: ( ( rule__MarkupElement__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:131:1: ( ( rule__MarkupElement__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:132:1: ( rule__MarkupElement__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMarkupElementAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:133:1: ( rule__MarkupElement__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:133:2: rule__MarkupElement__Alternatives
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:145:1: entryRuleBulletElement : ruleBulletElement EOF ;
    public final void entryRuleBulletElement() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:146:1: ( ruleBulletElement EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:147:1: ruleBulletElement EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:154:1: ruleBulletElement : ( ( rule__BulletElement__Group__0 ) ) ;
    public final void ruleBulletElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:158:2: ( ( ( rule__BulletElement__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:159:1: ( ( rule__BulletElement__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:159:1: ( ( rule__BulletElement__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:160:1: ( rule__BulletElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:161:1: ( rule__BulletElement__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:161:2: rule__BulletElement__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:173:1: entryRuleFontElement : ruleFontElement EOF ;
    public final void entryRuleFontElement() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:174:1: ( ruleFontElement EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:175:1: ruleFontElement EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:182:1: ruleFontElement : ( ( rule__FontElement__Group__0 ) ) ;
    public final void ruleFontElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:186:2: ( ( ( rule__FontElement__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:187:1: ( ( rule__FontElement__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:187:1: ( ( rule__FontElement__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:188:1: ( rule__FontElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFontElementAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:189:1: ( rule__FontElement__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:189:2: rule__FontElement__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:201:1: entryRuleFigureElement : ruleFigureElement EOF ;
    public final void entryRuleFigureElement() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:202:1: ( ruleFigureElement EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:203:1: ruleFigureElement EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:210:1: ruleFigureElement : ( ( rule__FigureElement__Group__0 ) ) ;
    public final void ruleFigureElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:214:2: ( ( ( rule__FigureElement__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:215:1: ( ( rule__FigureElement__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:215:1: ( ( rule__FigureElement__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:216:1: ( rule__FigureElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:217:1: ( rule__FigureElement__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:217:2: rule__FigureElement__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:229:1: entryRuleFigureRefElement : ruleFigureRefElement EOF ;
    public final void entryRuleFigureRefElement() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:230:1: ( ruleFigureRefElement EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:231:1: ruleFigureRefElement EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:238:1: ruleFigureRefElement : ( ( rule__FigureRefElement__Group__0 ) ) ;
    public final void ruleFigureRefElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:242:2: ( ( ( rule__FigureRefElement__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:243:1: ( ( rule__FigureRefElement__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:243:1: ( ( rule__FigureRefElement__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:244:1: ( rule__FigureRefElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureRefElementAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:245:1: ( rule__FigureRefElement__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:245:2: rule__FigureRefElement__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:257:1: entryRuleFootnoteElement : ruleFootnoteElement EOF ;
    public final void entryRuleFootnoteElement() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:258:1: ( ruleFootnoteElement EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:259:1: ruleFootnoteElement EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:266:1: ruleFootnoteElement : ( ( rule__FootnoteElement__Group__0 ) ) ;
    public final void ruleFootnoteElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:270:2: ( ( ( rule__FootnoteElement__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:271:1: ( ( rule__FootnoteElement__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:271:1: ( ( rule__FootnoteElement__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:272:1: ( rule__FootnoteElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFootnoteElementAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:273:1: ( rule__FootnoteElement__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:273:2: rule__FootnoteElement__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:285:1: entryRuleHeadingElement : ruleHeadingElement EOF ;
    public final void entryRuleHeadingElement() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:286:1: ( ruleHeadingElement EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:287:1: ruleHeadingElement EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:294:1: ruleHeadingElement : ( ( rule__HeadingElement__Group__0 ) ) ;
    public final void ruleHeadingElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:298:2: ( ( ( rule__HeadingElement__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:299:1: ( ( rule__HeadingElement__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:299:1: ( ( rule__HeadingElement__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:300:1: ( rule__HeadingElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:301:1: ( rule__HeadingElement__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:301:2: rule__HeadingElement__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:313:1: entryRuleNewLineElement : ruleNewLineElement EOF ;
    public final void entryRuleNewLineElement() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:314:1: ( ruleNewLineElement EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:315:1: ruleNewLineElement EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:322:1: ruleNewLineElement : ( ( rule__NewLineElement__TextAssignment ) ) ;
    public final void ruleNewLineElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:326:2: ( ( ( rule__NewLineElement__TextAssignment ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:327:1: ( ( rule__NewLineElement__TextAssignment ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:327:1: ( ( rule__NewLineElement__TextAssignment ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:328:1: ( rule__NewLineElement__TextAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewLineElementAccess().getTextAssignment()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:329:1: ( rule__NewLineElement__TextAssignment )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:329:2: rule__NewLineElement__TextAssignment
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:341:1: entryRuleNullElement : ruleNullElement EOF ;
    public final void entryRuleNullElement() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:342:1: ( ruleNullElement EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:343:1: ruleNullElement EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:350:1: ruleNullElement : ( ( rule__NullElement__Group__0 ) ) ;
    public final void ruleNullElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:354:2: ( ( ( rule__NullElement__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:355:1: ( ( rule__NullElement__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:355:1: ( ( rule__NullElement__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:356:1: ( rule__NullElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullElementAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:357:1: ( rule__NullElement__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:357:2: rule__NullElement__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:369:1: entryRuleOCLCodeElement : ruleOCLCodeElement EOF ;
    public final void entryRuleOCLCodeElement() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:370:1: ( ruleOCLCodeElement EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:371:1: ruleOCLCodeElement EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:378:1: ruleOCLCodeElement : ( ( rule__OCLCodeElement__Group__0 ) ) ;
    public final void ruleOCLCodeElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:382:2: ( ( ( rule__OCLCodeElement__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:383:1: ( ( rule__OCLCodeElement__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:383:1: ( ( rule__OCLCodeElement__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:384:1: ( rule__OCLCodeElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLCodeElementAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:385:1: ( rule__OCLCodeElement__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:385:2: rule__OCLCodeElement__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:397:1: entryRuleOCLEvalElement : ruleOCLEvalElement EOF ;
    public final void entryRuleOCLEvalElement() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:398:1: ( ruleOCLEvalElement EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:399:1: ruleOCLEvalElement EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:406:1: ruleOCLEvalElement : ( ( rule__OCLEvalElement__Group__0 ) ) ;
    public final void ruleOCLEvalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:410:2: ( ( ( rule__OCLEvalElement__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:411:1: ( ( rule__OCLEvalElement__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:411:1: ( ( rule__OCLEvalElement__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:412:1: ( rule__OCLEvalElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLEvalElementAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:413:1: ( rule__OCLEvalElement__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:413:2: rule__OCLEvalElement__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:425:1: entryRuleOCLTextElement : ruleOCLTextElement EOF ;
    public final void entryRuleOCLTextElement() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:426:1: ( ruleOCLTextElement EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:427:1: ruleOCLTextElement EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:434:1: ruleOCLTextElement : ( ( rule__OCLTextElement__Group__0 ) ) ;
    public final void ruleOCLTextElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:438:2: ( ( ( rule__OCLTextElement__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:439:1: ( ( rule__OCLTextElement__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:439:1: ( ( rule__OCLTextElement__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:440:1: ( rule__OCLTextElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLTextElementAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:441:1: ( rule__OCLTextElement__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:441:2: rule__OCLTextElement__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:453:1: entryRuleTextElement : ruleTextElement EOF ;
    public final void entryRuleTextElement() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:454:1: ( ruleTextElement EOF )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:455:1: ruleTextElement EOF
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:462:1: ruleTextElement : ( ( rule__TextElement__Alternatives ) ) ;
    public final void ruleTextElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:466:2: ( ( ( rule__TextElement__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:467:1: ( ( rule__TextElement__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:467:1: ( ( rule__TextElement__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:468:1: ( rule__TextElement__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTextElementAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:469:1: ( rule__TextElement__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:469:2: rule__TextElement__Alternatives
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:481:1: rule__MarkupKeyword__Alternatives : ( ( 'b' ) | ( 'e' ) | ( 'bullet' ) | ( 'figure' ) | ( 'figureRef' ) | ( 'footnote' ) | ( 'heading' ) | ( 'oclCode' ) | ( 'oclEval' ) | ( 'oclText' ) );
    public final void rule__MarkupKeyword__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:485:1: ( ( 'b' ) | ( 'e' ) | ( 'bullet' ) | ( 'figure' ) | ( 'figureRef' ) | ( 'footnote' ) | ( 'heading' ) | ( 'oclCode' ) | ( 'oclEval' ) | ( 'oclText' ) )
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:486:1: ( 'b' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:486:1: ( 'b' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:487:1: 'b'
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:494:6: ( 'e' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:494:6: ( 'e' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:495:1: 'e'
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:502:6: ( 'bullet' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:502:6: ( 'bullet' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:503:1: 'bullet'
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:510:6: ( 'figure' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:510:6: ( 'figure' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:511:1: 'figure'
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:518:6: ( 'figureRef' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:518:6: ( 'figureRef' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:519:1: 'figureRef'
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:526:6: ( 'footnote' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:526:6: ( 'footnote' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:527:1: 'footnote'
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:534:6: ( 'heading' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:534:6: ( 'heading' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:535:1: 'heading'
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:542:6: ( 'oclCode' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:542:6: ( 'oclCode' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:543:1: 'oclCode'
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:550:6: ( 'oclEval' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:550:6: ( 'oclEval' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:551:1: 'oclEval'
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:558:6: ( 'oclText' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:558:6: ( 'oclText' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:559:1: 'oclText'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:571:1: rule__MarkupElement__Alternatives : ( ( ruleFontElement ) | ( ruleNewLineElement ) | ( ruleBulletElement ) | ( ruleFigureElement ) | ( ruleFigureRefElement ) | ( ruleFootnoteElement ) | ( ruleHeadingElement ) | ( ruleNullElement ) | ( ruleOCLCodeElement ) | ( ruleOCLEvalElement ) | ( ruleOCLTextElement ) | ( ruleTextElement ) );
    public final void rule__MarkupElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:575:1: ( ( ruleFontElement ) | ( ruleNewLineElement ) | ( ruleBulletElement ) | ( ruleFigureElement ) | ( ruleFigureRefElement ) | ( ruleFootnoteElement ) | ( ruleHeadingElement ) | ( ruleNullElement ) | ( ruleOCLCodeElement ) | ( ruleOCLEvalElement ) | ( ruleOCLTextElement ) | ( ruleTextElement ) )
            int alt3=12;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:576:1: ( ruleFontElement )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:576:1: ( ruleFontElement )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:577:1: ruleFontElement
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:582:6: ( ruleNewLineElement )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:582:6: ( ruleNewLineElement )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:583:1: ruleNewLineElement
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:588:6: ( ruleBulletElement )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:588:6: ( ruleBulletElement )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:589:1: ruleBulletElement
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:594:6: ( ruleFigureElement )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:594:6: ( ruleFigureElement )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:595:1: ruleFigureElement
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:600:6: ( ruleFigureRefElement )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:600:6: ( ruleFigureRefElement )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:601:1: ruleFigureRefElement
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:606:6: ( ruleFootnoteElement )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:606:6: ( ruleFootnoteElement )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:607:1: ruleFootnoteElement
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:612:6: ( ruleHeadingElement )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:612:6: ( ruleHeadingElement )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:613:1: ruleHeadingElement
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:618:6: ( ruleNullElement )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:618:6: ( ruleNullElement )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:619:1: ruleNullElement
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:624:6: ( ruleOCLCodeElement )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:624:6: ( ruleOCLCodeElement )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:625:1: ruleOCLCodeElement
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:630:6: ( ruleOCLEvalElement )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:630:6: ( ruleOCLEvalElement )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:631:1: ruleOCLEvalElement
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:636:6: ( ruleOCLTextElement )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:636:6: ( ruleOCLTextElement )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:637:1: ruleOCLTextElement
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:642:6: ( ruleTextElement )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:642:6: ( ruleTextElement )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:643:1: ruleTextElement
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:653:1: rule__FontElement__FontAlternatives_0_0 : ( ( 'b' ) | ( 'e' ) );
    public final void rule__FontElement__FontAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:657:1: ( ( 'b' ) | ( 'e' ) )
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:658:1: ( 'b' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:658:1: ( 'b' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:659:1: 'b'
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:666:6: ( 'e' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:666:6: ( 'e' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:667:1: 'e'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:679:1: rule__TextElement__Alternatives : ( ( ( ( rule__TextElement__TextAssignment_0 ) ) ( ( rule__TextElement__TextAssignment_0 )* ) ) | ( ( rule__TextElement__TextAssignment_1 ) ) );
    public final void rule__TextElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:683:1: ( ( ( ( rule__TextElement__TextAssignment_0 ) ) ( ( rule__TextElement__TextAssignment_0 )* ) ) | ( ( rule__TextElement__TextAssignment_1 ) ) )
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:684:1: ( ( ( rule__TextElement__TextAssignment_0 ) ) ( ( rule__TextElement__TextAssignment_0 )* ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:684:1: ( ( ( rule__TextElement__TextAssignment_0 ) ) ( ( rule__TextElement__TextAssignment_0 )* ) )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:685:1: ( ( rule__TextElement__TextAssignment_0 ) ) ( ( rule__TextElement__TextAssignment_0 )* )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:685:1: ( ( rule__TextElement__TextAssignment_0 ) )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:686:1: ( rule__TextElement__TextAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTextElementAccess().getTextAssignment_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:687:1: ( rule__TextElement__TextAssignment_0 )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:687:2: rule__TextElement__TextAssignment_0
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

                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:690:1: ( ( rule__TextElement__TextAssignment_0 )* )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:691:1: ( rule__TextElement__TextAssignment_0 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTextElementAccess().getTextAssignment_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:692:1: ( rule__TextElement__TextAssignment_0 )*
                    loop5:
                    do {
                        int alt5=2;
                        alt5 = dfa5.predict(input);
                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:692:2: rule__TextElement__TextAssignment_0
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:697:6: ( ( rule__TextElement__TextAssignment_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:697:6: ( ( rule__TextElement__TextAssignment_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:698:1: ( rule__TextElement__TextAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTextElementAccess().getTextAssignment_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:699:1: ( rule__TextElement__TextAssignment_1 )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:699:2: rule__TextElement__TextAssignment_1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:708:1: rule__TextElement__TextAlternatives_0_0 : ( ( RULE_ID ) | ( RULE_WORD ) | ( RULE_INT ) | ( RULE_WS ) | ( ':' ) | ( '#' ) | ( ',' ) );
    public final void rule__TextElement__TextAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:712:1: ( ( RULE_ID ) | ( RULE_WORD ) | ( RULE_INT ) | ( RULE_WS ) | ( ':' ) | ( '#' ) | ( ',' ) )
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:713:1: ( RULE_ID )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:713:1: ( RULE_ID )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:714:1: RULE_ID
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:719:6: ( RULE_WORD )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:719:6: ( RULE_WORD )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:720:1: RULE_WORD
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:725:6: ( RULE_INT )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:725:6: ( RULE_INT )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:726:1: RULE_INT
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:731:6: ( RULE_WS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:731:6: ( RULE_WS )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:732:1: RULE_WS
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:737:6: ( ':' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:737:6: ( ':' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:738:1: ':'
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:745:6: ( '#' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:745:6: ( '#' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:746:1: '#'
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
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:753:6: ( ',' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:753:6: ( ',' )
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:754:1: ','
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:768:1: rule__BulletElement__Group__0 : rule__BulletElement__Group__0__Impl rule__BulletElement__Group__1 ;
    public final void rule__BulletElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:772:1: ( rule__BulletElement__Group__0__Impl rule__BulletElement__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:773:2: rule__BulletElement__Group__0__Impl rule__BulletElement__Group__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:780:1: rule__BulletElement__Group__0__Impl : ( () ) ;
    public final void rule__BulletElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:784:1: ( ( () ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:785:1: ( () )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:785:1: ( () )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:786:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getBulletElementAction_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:787:1: ()
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:789:1: 
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:799:1: rule__BulletElement__Group__1 : rule__BulletElement__Group__1__Impl rule__BulletElement__Group__2 ;
    public final void rule__BulletElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:803:1: ( rule__BulletElement__Group__1__Impl rule__BulletElement__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:804:2: rule__BulletElement__Group__1__Impl rule__BulletElement__Group__2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:811:1: rule__BulletElement__Group__1__Impl : ( 'bullet' ) ;
    public final void rule__BulletElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:815:1: ( ( 'bullet' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:816:1: ( 'bullet' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:816:1: ( 'bullet' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:817:1: 'bullet'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:830:1: rule__BulletElement__Group__2 : rule__BulletElement__Group__2__Impl rule__BulletElement__Group__3 ;
    public final void rule__BulletElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:834:1: ( rule__BulletElement__Group__2__Impl rule__BulletElement__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:835:2: rule__BulletElement__Group__2__Impl rule__BulletElement__Group__3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:842:1: rule__BulletElement__Group__2__Impl : ( ( rule__BulletElement__Group_2__0 )? ) ;
    public final void rule__BulletElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:846:1: ( ( ( rule__BulletElement__Group_2__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:847:1: ( ( rule__BulletElement__Group_2__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:847:1: ( ( rule__BulletElement__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:848:1: ( rule__BulletElement__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:849:1: ( rule__BulletElement__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==26) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:849:2: rule__BulletElement__Group_2__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:859:1: rule__BulletElement__Group__3 : rule__BulletElement__Group__3__Impl rule__BulletElement__Group__4 ;
    public final void rule__BulletElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:863:1: ( rule__BulletElement__Group__3__Impl rule__BulletElement__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:864:2: rule__BulletElement__Group__3__Impl rule__BulletElement__Group__4
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:871:1: rule__BulletElement__Group__3__Impl : ( '[' ) ;
    public final void rule__BulletElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:875:1: ( ( '[' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:876:1: ( '[' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:876:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:877:1: '['
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:890:1: rule__BulletElement__Group__4 : rule__BulletElement__Group__4__Impl rule__BulletElement__Group__5 ;
    public final void rule__BulletElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:894:1: ( rule__BulletElement__Group__4__Impl rule__BulletElement__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:895:2: rule__BulletElement__Group__4__Impl rule__BulletElement__Group__5
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:902:1: rule__BulletElement__Group__4__Impl : ( ( rule__BulletElement__ElementsAssignment_4 )* ) ;
    public final void rule__BulletElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:906:1: ( ( ( rule__BulletElement__ElementsAssignment_4 )* ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:907:1: ( ( rule__BulletElement__ElementsAssignment_4 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:907:1: ( ( rule__BulletElement__ElementsAssignment_4 )* )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:908:1: ( rule__BulletElement__ElementsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getElementsAssignment_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:909:1: ( rule__BulletElement__ElementsAssignment_4 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_WS)||LA9_0==RULE_NL||(LA9_0>=16 && LA9_0<=29)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:909:2: rule__BulletElement__ElementsAssignment_4
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:919:1: rule__BulletElement__Group__5 : rule__BulletElement__Group__5__Impl ;
    public final void rule__BulletElement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:923:1: ( rule__BulletElement__Group__5__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:924:2: rule__BulletElement__Group__5__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:930:1: rule__BulletElement__Group__5__Impl : ( ']' ) ;
    public final void rule__BulletElement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:934:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:935:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:935:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:936:1: ']'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:961:1: rule__BulletElement__Group_2__0 : rule__BulletElement__Group_2__0__Impl rule__BulletElement__Group_2__1 ;
    public final void rule__BulletElement__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:965:1: ( rule__BulletElement__Group_2__0__Impl rule__BulletElement__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:966:2: rule__BulletElement__Group_2__0__Impl rule__BulletElement__Group_2__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:973:1: rule__BulletElement__Group_2__0__Impl : ( ':' ) ;
    public final void rule__BulletElement__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:977:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:978:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:978:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:979:1: ':'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:992:1: rule__BulletElement__Group_2__1 : rule__BulletElement__Group_2__1__Impl ;
    public final void rule__BulletElement__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:996:1: ( rule__BulletElement__Group_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:997:2: rule__BulletElement__Group_2__1__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1003:1: rule__BulletElement__Group_2__1__Impl : ( ( rule__BulletElement__LevelAssignment_2_1 ) ) ;
    public final void rule__BulletElement__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1007:1: ( ( ( rule__BulletElement__LevelAssignment_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1008:1: ( ( rule__BulletElement__LevelAssignment_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1008:1: ( ( rule__BulletElement__LevelAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1009:1: ( rule__BulletElement__LevelAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBulletElementAccess().getLevelAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1010:1: ( rule__BulletElement__LevelAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1010:2: rule__BulletElement__LevelAssignment_2_1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1024:1: rule__FontElement__Group__0 : rule__FontElement__Group__0__Impl rule__FontElement__Group__1 ;
    public final void rule__FontElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1028:1: ( rule__FontElement__Group__0__Impl rule__FontElement__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1029:2: rule__FontElement__Group__0__Impl rule__FontElement__Group__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1036:1: rule__FontElement__Group__0__Impl : ( ( rule__FontElement__FontAssignment_0 ) ) ;
    public final void rule__FontElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1040:1: ( ( ( rule__FontElement__FontAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1041:1: ( ( rule__FontElement__FontAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1041:1: ( ( rule__FontElement__FontAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1042:1: ( rule__FontElement__FontAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFontElementAccess().getFontAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1043:1: ( rule__FontElement__FontAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1043:2: rule__FontElement__FontAssignment_0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1053:1: rule__FontElement__Group__1 : rule__FontElement__Group__1__Impl rule__FontElement__Group__2 ;
    public final void rule__FontElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1057:1: ( rule__FontElement__Group__1__Impl rule__FontElement__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1058:2: rule__FontElement__Group__1__Impl rule__FontElement__Group__2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1065:1: rule__FontElement__Group__1__Impl : ( '[' ) ;
    public final void rule__FontElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1069:1: ( ( '[' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1070:1: ( '[' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1070:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1071:1: '['
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1084:1: rule__FontElement__Group__2 : rule__FontElement__Group__2__Impl rule__FontElement__Group__3 ;
    public final void rule__FontElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1088:1: ( rule__FontElement__Group__2__Impl rule__FontElement__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1089:2: rule__FontElement__Group__2__Impl rule__FontElement__Group__3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1096:1: rule__FontElement__Group__2__Impl : ( ( rule__FontElement__ElementsAssignment_2 )* ) ;
    public final void rule__FontElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1100:1: ( ( ( rule__FontElement__ElementsAssignment_2 )* ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1101:1: ( ( rule__FontElement__ElementsAssignment_2 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1101:1: ( ( rule__FontElement__ElementsAssignment_2 )* )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1102:1: ( rule__FontElement__ElementsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFontElementAccess().getElementsAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1103:1: ( rule__FontElement__ElementsAssignment_2 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=RULE_ID && LA10_0<=RULE_WS)||LA10_0==RULE_NL||(LA10_0>=16 && LA10_0<=29)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1103:2: rule__FontElement__ElementsAssignment_2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1113:1: rule__FontElement__Group__3 : rule__FontElement__Group__3__Impl ;
    public final void rule__FontElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1117:1: ( rule__FontElement__Group__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1118:2: rule__FontElement__Group__3__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1124:1: rule__FontElement__Group__3__Impl : ( ']' ) ;
    public final void rule__FontElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1128:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1129:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1129:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1130:1: ']'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1151:1: rule__FigureElement__Group__0 : rule__FigureElement__Group__0__Impl rule__FigureElement__Group__1 ;
    public final void rule__FigureElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1155:1: ( rule__FigureElement__Group__0__Impl rule__FigureElement__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1156:2: rule__FigureElement__Group__0__Impl rule__FigureElement__Group__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1163:1: rule__FigureElement__Group__0__Impl : ( 'figure' ) ;
    public final void rule__FigureElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1167:1: ( ( 'figure' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1168:1: ( 'figure' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1168:1: ( 'figure' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1169:1: 'figure'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1182:1: rule__FigureElement__Group__1 : rule__FigureElement__Group__1__Impl rule__FigureElement__Group__2 ;
    public final void rule__FigureElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1186:1: ( rule__FigureElement__Group__1__Impl rule__FigureElement__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1187:2: rule__FigureElement__Group__1__Impl rule__FigureElement__Group__2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1194:1: rule__FigureElement__Group__1__Impl : ( ( rule__FigureElement__Group_1__0 )? ) ;
    public final void rule__FigureElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1198:1: ( ( ( rule__FigureElement__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1199:1: ( ( rule__FigureElement__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1199:1: ( ( rule__FigureElement__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1200:1: ( rule__FigureElement__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1201:1: ( rule__FigureElement__Group_1__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1201:2: rule__FigureElement__Group_1__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1211:1: rule__FigureElement__Group__2 : rule__FigureElement__Group__2__Impl rule__FigureElement__Group__3 ;
    public final void rule__FigureElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1215:1: ( rule__FigureElement__Group__2__Impl rule__FigureElement__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1216:2: rule__FigureElement__Group__2__Impl rule__FigureElement__Group__3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1223:1: rule__FigureElement__Group__2__Impl : ( '[' ) ;
    public final void rule__FigureElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1227:1: ( ( '[' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1228:1: ( '[' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1228:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1229:1: '['
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1242:1: rule__FigureElement__Group__3 : rule__FigureElement__Group__3__Impl rule__FigureElement__Group__4 ;
    public final void rule__FigureElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1246:1: ( rule__FigureElement__Group__3__Impl rule__FigureElement__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1247:2: rule__FigureElement__Group__3__Impl rule__FigureElement__Group__4
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1254:1: rule__FigureElement__Group__3__Impl : ( ( rule__FigureElement__SrcAssignment_3 ) ) ;
    public final void rule__FigureElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1258:1: ( ( ( rule__FigureElement__SrcAssignment_3 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1259:1: ( ( rule__FigureElement__SrcAssignment_3 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1259:1: ( ( rule__FigureElement__SrcAssignment_3 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1260:1: ( rule__FigureElement__SrcAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getSrcAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1261:1: ( rule__FigureElement__SrcAssignment_3 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1261:2: rule__FigureElement__SrcAssignment_3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1271:1: rule__FigureElement__Group__4 : rule__FigureElement__Group__4__Impl rule__FigureElement__Group__5 ;
    public final void rule__FigureElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1275:1: ( rule__FigureElement__Group__4__Impl rule__FigureElement__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1276:2: rule__FigureElement__Group__4__Impl rule__FigureElement__Group__5
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1283:1: rule__FigureElement__Group__4__Impl : ( ( rule__FigureElement__Group_4__0 )? ) ;
    public final void rule__FigureElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1287:1: ( ( ( rule__FigureElement__Group_4__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1288:1: ( ( rule__FigureElement__Group_4__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1288:1: ( ( rule__FigureElement__Group_4__0 )? )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1289:1: ( rule__FigureElement__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getGroup_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1290:1: ( rule__FigureElement__Group_4__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1290:2: rule__FigureElement__Group_4__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1300:1: rule__FigureElement__Group__5 : rule__FigureElement__Group__5__Impl ;
    public final void rule__FigureElement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1304:1: ( rule__FigureElement__Group__5__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1305:2: rule__FigureElement__Group__5__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1311:1: rule__FigureElement__Group__5__Impl : ( ']' ) ;
    public final void rule__FigureElement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1315:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1316:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1316:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1317:1: ']'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1342:1: rule__FigureElement__Group_1__0 : rule__FigureElement__Group_1__0__Impl rule__FigureElement__Group_1__1 ;
    public final void rule__FigureElement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1346:1: ( rule__FigureElement__Group_1__0__Impl rule__FigureElement__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1347:2: rule__FigureElement__Group_1__0__Impl rule__FigureElement__Group_1__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1354:1: rule__FigureElement__Group_1__0__Impl : ( '#' ) ;
    public final void rule__FigureElement__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1358:1: ( ( '#' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1359:1: ( '#' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1359:1: ( '#' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1360:1: '#'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1373:1: rule__FigureElement__Group_1__1 : rule__FigureElement__Group_1__1__Impl ;
    public final void rule__FigureElement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1377:1: ( rule__FigureElement__Group_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1378:2: rule__FigureElement__Group_1__1__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1384:1: rule__FigureElement__Group_1__1__Impl : ( ( rule__FigureElement__DefAssignment_1_1 ) ) ;
    public final void rule__FigureElement__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1388:1: ( ( ( rule__FigureElement__DefAssignment_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1389:1: ( ( rule__FigureElement__DefAssignment_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1389:1: ( ( rule__FigureElement__DefAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1390:1: ( rule__FigureElement__DefAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getDefAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1391:1: ( rule__FigureElement__DefAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1391:2: rule__FigureElement__DefAssignment_1_1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1405:1: rule__FigureElement__Group_4__0 : rule__FigureElement__Group_4__0__Impl rule__FigureElement__Group_4__1 ;
    public final void rule__FigureElement__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1409:1: ( rule__FigureElement__Group_4__0__Impl rule__FigureElement__Group_4__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1410:2: rule__FigureElement__Group_4__0__Impl rule__FigureElement__Group_4__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1417:1: rule__FigureElement__Group_4__0__Impl : ( ',' ) ;
    public final void rule__FigureElement__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1421:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1422:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1422:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1423:1: ','
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1436:1: rule__FigureElement__Group_4__1 : rule__FigureElement__Group_4__1__Impl rule__FigureElement__Group_4__2 ;
    public final void rule__FigureElement__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1440:1: ( rule__FigureElement__Group_4__1__Impl rule__FigureElement__Group_4__2 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1441:2: rule__FigureElement__Group_4__1__Impl rule__FigureElement__Group_4__2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1448:1: rule__FigureElement__Group_4__1__Impl : ( ( rule__FigureElement__AltAssignment_4_1 ) ) ;
    public final void rule__FigureElement__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1452:1: ( ( ( rule__FigureElement__AltAssignment_4_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1453:1: ( ( rule__FigureElement__AltAssignment_4_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1453:1: ( ( rule__FigureElement__AltAssignment_4_1 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1454:1: ( rule__FigureElement__AltAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getAltAssignment_4_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1455:1: ( rule__FigureElement__AltAssignment_4_1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1455:2: rule__FigureElement__AltAssignment_4_1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1465:1: rule__FigureElement__Group_4__2 : rule__FigureElement__Group_4__2__Impl ;
    public final void rule__FigureElement__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1469:1: ( rule__FigureElement__Group_4__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1470:2: rule__FigureElement__Group_4__2__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1476:1: rule__FigureElement__Group_4__2__Impl : ( ( rule__FigureElement__Group_4_2__0 )? ) ;
    public final void rule__FigureElement__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1480:1: ( ( ( rule__FigureElement__Group_4_2__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1481:1: ( ( rule__FigureElement__Group_4_2__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1481:1: ( ( rule__FigureElement__Group_4_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1482:1: ( rule__FigureElement__Group_4_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getGroup_4_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1483:1: ( rule__FigureElement__Group_4_2__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==28) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1483:2: rule__FigureElement__Group_4_2__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1499:1: rule__FigureElement__Group_4_2__0 : rule__FigureElement__Group_4_2__0__Impl rule__FigureElement__Group_4_2__1 ;
    public final void rule__FigureElement__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1503:1: ( rule__FigureElement__Group_4_2__0__Impl rule__FigureElement__Group_4_2__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1504:2: rule__FigureElement__Group_4_2__0__Impl rule__FigureElement__Group_4_2__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1511:1: rule__FigureElement__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__FigureElement__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1515:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1516:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1516:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1517:1: ','
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1530:1: rule__FigureElement__Group_4_2__1 : rule__FigureElement__Group_4_2__1__Impl rule__FigureElement__Group_4_2__2 ;
    public final void rule__FigureElement__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1534:1: ( rule__FigureElement__Group_4_2__1__Impl rule__FigureElement__Group_4_2__2 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1535:2: rule__FigureElement__Group_4_2__1__Impl rule__FigureElement__Group_4_2__2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1542:1: rule__FigureElement__Group_4_2__1__Impl : ( ( rule__FigureElement__RequiredWidthAssignment_4_2_1 ) ) ;
    public final void rule__FigureElement__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1546:1: ( ( ( rule__FigureElement__RequiredWidthAssignment_4_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1547:1: ( ( rule__FigureElement__RequiredWidthAssignment_4_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1547:1: ( ( rule__FigureElement__RequiredWidthAssignment_4_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1548:1: ( rule__FigureElement__RequiredWidthAssignment_4_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getRequiredWidthAssignment_4_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1549:1: ( rule__FigureElement__RequiredWidthAssignment_4_2_1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1549:2: rule__FigureElement__RequiredWidthAssignment_4_2_1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1559:1: rule__FigureElement__Group_4_2__2 : rule__FigureElement__Group_4_2__2__Impl ;
    public final void rule__FigureElement__Group_4_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1563:1: ( rule__FigureElement__Group_4_2__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1564:2: rule__FigureElement__Group_4_2__2__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1570:1: rule__FigureElement__Group_4_2__2__Impl : ( ( rule__FigureElement__Group_4_2_2__0 )? ) ;
    public final void rule__FigureElement__Group_4_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1574:1: ( ( ( rule__FigureElement__Group_4_2_2__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1575:1: ( ( rule__FigureElement__Group_4_2_2__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1575:1: ( ( rule__FigureElement__Group_4_2_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1576:1: ( rule__FigureElement__Group_4_2_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getGroup_4_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1577:1: ( rule__FigureElement__Group_4_2_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==28) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1577:2: rule__FigureElement__Group_4_2_2__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1593:1: rule__FigureElement__Group_4_2_2__0 : rule__FigureElement__Group_4_2_2__0__Impl rule__FigureElement__Group_4_2_2__1 ;
    public final void rule__FigureElement__Group_4_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1597:1: ( rule__FigureElement__Group_4_2_2__0__Impl rule__FigureElement__Group_4_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1598:2: rule__FigureElement__Group_4_2_2__0__Impl rule__FigureElement__Group_4_2_2__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1605:1: rule__FigureElement__Group_4_2_2__0__Impl : ( ',' ) ;
    public final void rule__FigureElement__Group_4_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1609:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1610:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1610:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1611:1: ','
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1624:1: rule__FigureElement__Group_4_2_2__1 : rule__FigureElement__Group_4_2_2__1__Impl ;
    public final void rule__FigureElement__Group_4_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1628:1: ( rule__FigureElement__Group_4_2_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1629:2: rule__FigureElement__Group_4_2_2__1__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1635:1: rule__FigureElement__Group_4_2_2__1__Impl : ( ( rule__FigureElement__RequiredHeightAssignment_4_2_2_1 ) ) ;
    public final void rule__FigureElement__Group_4_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1639:1: ( ( ( rule__FigureElement__RequiredHeightAssignment_4_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1640:1: ( ( rule__FigureElement__RequiredHeightAssignment_4_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1640:1: ( ( rule__FigureElement__RequiredHeightAssignment_4_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1641:1: ( rule__FigureElement__RequiredHeightAssignment_4_2_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureElementAccess().getRequiredHeightAssignment_4_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1642:1: ( rule__FigureElement__RequiredHeightAssignment_4_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1642:2: rule__FigureElement__RequiredHeightAssignment_4_2_2_1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1656:1: rule__FigureRefElement__Group__0 : rule__FigureRefElement__Group__0__Impl rule__FigureRefElement__Group__1 ;
    public final void rule__FigureRefElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1660:1: ( rule__FigureRefElement__Group__0__Impl rule__FigureRefElement__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1661:2: rule__FigureRefElement__Group__0__Impl rule__FigureRefElement__Group__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1668:1: rule__FigureRefElement__Group__0__Impl : ( 'figureRef' ) ;
    public final void rule__FigureRefElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1672:1: ( ( 'figureRef' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1673:1: ( 'figureRef' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1673:1: ( 'figureRef' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1674:1: 'figureRef'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1687:1: rule__FigureRefElement__Group__1 : rule__FigureRefElement__Group__1__Impl rule__FigureRefElement__Group__2 ;
    public final void rule__FigureRefElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1691:1: ( rule__FigureRefElement__Group__1__Impl rule__FigureRefElement__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1692:2: rule__FigureRefElement__Group__1__Impl rule__FigureRefElement__Group__2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1699:1: rule__FigureRefElement__Group__1__Impl : ( '[' ) ;
    public final void rule__FigureRefElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1703:1: ( ( '[' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1704:1: ( '[' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1704:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1705:1: '['
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1718:1: rule__FigureRefElement__Group__2 : rule__FigureRefElement__Group__2__Impl rule__FigureRefElement__Group__3 ;
    public final void rule__FigureRefElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1722:1: ( rule__FigureRefElement__Group__2__Impl rule__FigureRefElement__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1723:2: rule__FigureRefElement__Group__2__Impl rule__FigureRefElement__Group__3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1730:1: rule__FigureRefElement__Group__2__Impl : ( ( rule__FigureRefElement__RefAssignment_2 ) ) ;
    public final void rule__FigureRefElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1734:1: ( ( ( rule__FigureRefElement__RefAssignment_2 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1735:1: ( ( rule__FigureRefElement__RefAssignment_2 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1735:1: ( ( rule__FigureRefElement__RefAssignment_2 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1736:1: ( rule__FigureRefElement__RefAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureRefElementAccess().getRefAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1737:1: ( rule__FigureRefElement__RefAssignment_2 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1737:2: rule__FigureRefElement__RefAssignment_2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1747:1: rule__FigureRefElement__Group__3 : rule__FigureRefElement__Group__3__Impl ;
    public final void rule__FigureRefElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1751:1: ( rule__FigureRefElement__Group__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1752:2: rule__FigureRefElement__Group__3__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1758:1: rule__FigureRefElement__Group__3__Impl : ( ']' ) ;
    public final void rule__FigureRefElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1762:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1763:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1763:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1764:1: ']'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1785:1: rule__FootnoteElement__Group__0 : rule__FootnoteElement__Group__0__Impl rule__FootnoteElement__Group__1 ;
    public final void rule__FootnoteElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1789:1: ( rule__FootnoteElement__Group__0__Impl rule__FootnoteElement__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1790:2: rule__FootnoteElement__Group__0__Impl rule__FootnoteElement__Group__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1797:1: rule__FootnoteElement__Group__0__Impl : ( () ) ;
    public final void rule__FootnoteElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1801:1: ( ( () ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1802:1: ( () )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1802:1: ( () )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1803:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFootnoteElementAccess().getFootnoteElementAction_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1804:1: ()
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1806:1: 
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1816:1: rule__FootnoteElement__Group__1 : rule__FootnoteElement__Group__1__Impl rule__FootnoteElement__Group__2 ;
    public final void rule__FootnoteElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1820:1: ( rule__FootnoteElement__Group__1__Impl rule__FootnoteElement__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1821:2: rule__FootnoteElement__Group__1__Impl rule__FootnoteElement__Group__2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1828:1: rule__FootnoteElement__Group__1__Impl : ( 'footnote' ) ;
    public final void rule__FootnoteElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1832:1: ( ( 'footnote' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1833:1: ( 'footnote' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1833:1: ( 'footnote' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1834:1: 'footnote'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1847:1: rule__FootnoteElement__Group__2 : rule__FootnoteElement__Group__2__Impl rule__FootnoteElement__Group__3 ;
    public final void rule__FootnoteElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1851:1: ( rule__FootnoteElement__Group__2__Impl rule__FootnoteElement__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1852:2: rule__FootnoteElement__Group__2__Impl rule__FootnoteElement__Group__3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1859:1: rule__FootnoteElement__Group__2__Impl : ( '[' ) ;
    public final void rule__FootnoteElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1863:1: ( ( '[' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1864:1: ( '[' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1864:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1865:1: '['
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1878:1: rule__FootnoteElement__Group__3 : rule__FootnoteElement__Group__3__Impl rule__FootnoteElement__Group__4 ;
    public final void rule__FootnoteElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1882:1: ( rule__FootnoteElement__Group__3__Impl rule__FootnoteElement__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1883:2: rule__FootnoteElement__Group__3__Impl rule__FootnoteElement__Group__4
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1890:1: rule__FootnoteElement__Group__3__Impl : ( ( rule__FootnoteElement__ElementsAssignment_3 )* ) ;
    public final void rule__FootnoteElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1894:1: ( ( ( rule__FootnoteElement__ElementsAssignment_3 )* ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1895:1: ( ( rule__FootnoteElement__ElementsAssignment_3 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1895:1: ( ( rule__FootnoteElement__ElementsAssignment_3 )* )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1896:1: ( rule__FootnoteElement__ElementsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFootnoteElementAccess().getElementsAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1897:1: ( rule__FootnoteElement__ElementsAssignment_3 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_WS)||LA15_0==RULE_NL||(LA15_0>=16 && LA15_0<=29)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1897:2: rule__FootnoteElement__ElementsAssignment_3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1907:1: rule__FootnoteElement__Group__4 : rule__FootnoteElement__Group__4__Impl ;
    public final void rule__FootnoteElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1911:1: ( rule__FootnoteElement__Group__4__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1912:2: rule__FootnoteElement__Group__4__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1918:1: rule__FootnoteElement__Group__4__Impl : ( ']' ) ;
    public final void rule__FootnoteElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1922:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1923:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1923:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1924:1: ']'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1947:1: rule__HeadingElement__Group__0 : rule__HeadingElement__Group__0__Impl rule__HeadingElement__Group__1 ;
    public final void rule__HeadingElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1951:1: ( rule__HeadingElement__Group__0__Impl rule__HeadingElement__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1952:2: rule__HeadingElement__Group__0__Impl rule__HeadingElement__Group__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1959:1: rule__HeadingElement__Group__0__Impl : ( () ) ;
    public final void rule__HeadingElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1963:1: ( ( () ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1964:1: ( () )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1964:1: ( () )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1965:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getHeadingElementAction_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1966:1: ()
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1968:1: 
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1978:1: rule__HeadingElement__Group__1 : rule__HeadingElement__Group__1__Impl rule__HeadingElement__Group__2 ;
    public final void rule__HeadingElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1982:1: ( rule__HeadingElement__Group__1__Impl rule__HeadingElement__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1983:2: rule__HeadingElement__Group__1__Impl rule__HeadingElement__Group__2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1990:1: rule__HeadingElement__Group__1__Impl : ( 'heading' ) ;
    public final void rule__HeadingElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1994:1: ( ( 'heading' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1995:1: ( 'heading' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1995:1: ( 'heading' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:1996:1: 'heading'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2009:1: rule__HeadingElement__Group__2 : rule__HeadingElement__Group__2__Impl rule__HeadingElement__Group__3 ;
    public final void rule__HeadingElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2013:1: ( rule__HeadingElement__Group__2__Impl rule__HeadingElement__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2014:2: rule__HeadingElement__Group__2__Impl rule__HeadingElement__Group__3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2021:1: rule__HeadingElement__Group__2__Impl : ( ( rule__HeadingElement__Group_2__0 )? ) ;
    public final void rule__HeadingElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2025:1: ( ( ( rule__HeadingElement__Group_2__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2026:1: ( ( rule__HeadingElement__Group_2__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2026:1: ( ( rule__HeadingElement__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2027:1: ( rule__HeadingElement__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2028:1: ( rule__HeadingElement__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2028:2: rule__HeadingElement__Group_2__0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2038:1: rule__HeadingElement__Group__3 : rule__HeadingElement__Group__3__Impl rule__HeadingElement__Group__4 ;
    public final void rule__HeadingElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2042:1: ( rule__HeadingElement__Group__3__Impl rule__HeadingElement__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2043:2: rule__HeadingElement__Group__3__Impl rule__HeadingElement__Group__4
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2050:1: rule__HeadingElement__Group__3__Impl : ( '[' ) ;
    public final void rule__HeadingElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2054:1: ( ( '[' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2055:1: ( '[' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2055:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2056:1: '['
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2069:1: rule__HeadingElement__Group__4 : rule__HeadingElement__Group__4__Impl rule__HeadingElement__Group__5 ;
    public final void rule__HeadingElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2073:1: ( rule__HeadingElement__Group__4__Impl rule__HeadingElement__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2074:2: rule__HeadingElement__Group__4__Impl rule__HeadingElement__Group__5
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2081:1: rule__HeadingElement__Group__4__Impl : ( ( rule__HeadingElement__ElementsAssignment_4 )* ) ;
    public final void rule__HeadingElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2085:1: ( ( ( rule__HeadingElement__ElementsAssignment_4 )* ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2086:1: ( ( rule__HeadingElement__ElementsAssignment_4 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2086:1: ( ( rule__HeadingElement__ElementsAssignment_4 )* )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2087:1: ( rule__HeadingElement__ElementsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getElementsAssignment_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2088:1: ( rule__HeadingElement__ElementsAssignment_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_ID && LA17_0<=RULE_WS)||LA17_0==RULE_NL||(LA17_0>=16 && LA17_0<=29)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2088:2: rule__HeadingElement__ElementsAssignment_4
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2098:1: rule__HeadingElement__Group__5 : rule__HeadingElement__Group__5__Impl ;
    public final void rule__HeadingElement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2102:1: ( rule__HeadingElement__Group__5__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2103:2: rule__HeadingElement__Group__5__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2109:1: rule__HeadingElement__Group__5__Impl : ( ']' ) ;
    public final void rule__HeadingElement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2113:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2114:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2114:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2115:1: ']'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2140:1: rule__HeadingElement__Group_2__0 : rule__HeadingElement__Group_2__0__Impl rule__HeadingElement__Group_2__1 ;
    public final void rule__HeadingElement__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2144:1: ( rule__HeadingElement__Group_2__0__Impl rule__HeadingElement__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2145:2: rule__HeadingElement__Group_2__0__Impl rule__HeadingElement__Group_2__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2152:1: rule__HeadingElement__Group_2__0__Impl : ( ':' ) ;
    public final void rule__HeadingElement__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2156:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2157:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2157:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2158:1: ':'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2171:1: rule__HeadingElement__Group_2__1 : rule__HeadingElement__Group_2__1__Impl ;
    public final void rule__HeadingElement__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2175:1: ( rule__HeadingElement__Group_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2176:2: rule__HeadingElement__Group_2__1__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2182:1: rule__HeadingElement__Group_2__1__Impl : ( ( rule__HeadingElement__LevelAssignment_2_1 ) ) ;
    public final void rule__HeadingElement__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2186:1: ( ( ( rule__HeadingElement__LevelAssignment_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2187:1: ( ( rule__HeadingElement__LevelAssignment_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2187:1: ( ( rule__HeadingElement__LevelAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2188:1: ( rule__HeadingElement__LevelAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHeadingElementAccess().getLevelAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2189:1: ( rule__HeadingElement__LevelAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2189:2: rule__HeadingElement__LevelAssignment_2_1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2203:1: rule__NullElement__Group__0 : rule__NullElement__Group__0__Impl rule__NullElement__Group__1 ;
    public final void rule__NullElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2207:1: ( rule__NullElement__Group__0__Impl rule__NullElement__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2208:2: rule__NullElement__Group__0__Impl rule__NullElement__Group__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2215:1: rule__NullElement__Group__0__Impl : ( () ) ;
    public final void rule__NullElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2219:1: ( ( () ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2220:1: ( () )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2220:1: ( () )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2221:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullElementAccess().getNullElementAction_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2222:1: ()
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2224:1: 
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2234:1: rule__NullElement__Group__1 : rule__NullElement__Group__1__Impl rule__NullElement__Group__2 ;
    public final void rule__NullElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2238:1: ( rule__NullElement__Group__1__Impl rule__NullElement__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2239:2: rule__NullElement__Group__1__Impl rule__NullElement__Group__2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2246:1: rule__NullElement__Group__1__Impl : ( '[' ) ;
    public final void rule__NullElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2250:1: ( ( '[' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2251:1: ( '[' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2251:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2252:1: '['
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2265:1: rule__NullElement__Group__2 : rule__NullElement__Group__2__Impl rule__NullElement__Group__3 ;
    public final void rule__NullElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2269:1: ( rule__NullElement__Group__2__Impl rule__NullElement__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2270:2: rule__NullElement__Group__2__Impl rule__NullElement__Group__3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2277:1: rule__NullElement__Group__2__Impl : ( ( rule__NullElement__ElementsAssignment_2 )* ) ;
    public final void rule__NullElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2281:1: ( ( ( rule__NullElement__ElementsAssignment_2 )* ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2282:1: ( ( rule__NullElement__ElementsAssignment_2 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2282:1: ( ( rule__NullElement__ElementsAssignment_2 )* )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2283:1: ( rule__NullElement__ElementsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullElementAccess().getElementsAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2284:1: ( rule__NullElement__ElementsAssignment_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_ID && LA18_0<=RULE_WS)||LA18_0==RULE_NL||(LA18_0>=16 && LA18_0<=29)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2284:2: rule__NullElement__ElementsAssignment_2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2294:1: rule__NullElement__Group__3 : rule__NullElement__Group__3__Impl ;
    public final void rule__NullElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2298:1: ( rule__NullElement__Group__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2299:2: rule__NullElement__Group__3__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2305:1: rule__NullElement__Group__3__Impl : ( ']' ) ;
    public final void rule__NullElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2309:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2310:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2310:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2311:1: ']'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2332:1: rule__OCLCodeElement__Group__0 : rule__OCLCodeElement__Group__0__Impl rule__OCLCodeElement__Group__1 ;
    public final void rule__OCLCodeElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2336:1: ( rule__OCLCodeElement__Group__0__Impl rule__OCLCodeElement__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2337:2: rule__OCLCodeElement__Group__0__Impl rule__OCLCodeElement__Group__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2344:1: rule__OCLCodeElement__Group__0__Impl : ( () ) ;
    public final void rule__OCLCodeElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2348:1: ( ( () ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2349:1: ( () )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2349:1: ( () )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2350:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLCodeElementAccess().getOCLCodeElementAction_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2351:1: ()
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2353:1: 
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2363:1: rule__OCLCodeElement__Group__1 : rule__OCLCodeElement__Group__1__Impl rule__OCLCodeElement__Group__2 ;
    public final void rule__OCLCodeElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2367:1: ( rule__OCLCodeElement__Group__1__Impl rule__OCLCodeElement__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2368:2: rule__OCLCodeElement__Group__1__Impl rule__OCLCodeElement__Group__2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2375:1: rule__OCLCodeElement__Group__1__Impl : ( 'oclCode' ) ;
    public final void rule__OCLCodeElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2379:1: ( ( 'oclCode' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2380:1: ( 'oclCode' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2380:1: ( 'oclCode' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2381:1: 'oclCode'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2394:1: rule__OCLCodeElement__Group__2 : rule__OCLCodeElement__Group__2__Impl rule__OCLCodeElement__Group__3 ;
    public final void rule__OCLCodeElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2398:1: ( rule__OCLCodeElement__Group__2__Impl rule__OCLCodeElement__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2399:2: rule__OCLCodeElement__Group__2__Impl rule__OCLCodeElement__Group__3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2406:1: rule__OCLCodeElement__Group__2__Impl : ( '[' ) ;
    public final void rule__OCLCodeElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2410:1: ( ( '[' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2411:1: ( '[' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2411:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2412:1: '['
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2425:1: rule__OCLCodeElement__Group__3 : rule__OCLCodeElement__Group__3__Impl rule__OCLCodeElement__Group__4 ;
    public final void rule__OCLCodeElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2429:1: ( rule__OCLCodeElement__Group__3__Impl rule__OCLCodeElement__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2430:2: rule__OCLCodeElement__Group__3__Impl rule__OCLCodeElement__Group__4
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2437:1: rule__OCLCodeElement__Group__3__Impl : ( ( rule__OCLCodeElement__ElementsAssignment_3 )* ) ;
    public final void rule__OCLCodeElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2441:1: ( ( ( rule__OCLCodeElement__ElementsAssignment_3 )* ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2442:1: ( ( rule__OCLCodeElement__ElementsAssignment_3 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2442:1: ( ( rule__OCLCodeElement__ElementsAssignment_3 )* )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2443:1: ( rule__OCLCodeElement__ElementsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLCodeElementAccess().getElementsAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2444:1: ( rule__OCLCodeElement__ElementsAssignment_3 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_WS)||LA19_0==RULE_NL||(LA19_0>=16 && LA19_0<=29)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2444:2: rule__OCLCodeElement__ElementsAssignment_3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2454:1: rule__OCLCodeElement__Group__4 : rule__OCLCodeElement__Group__4__Impl ;
    public final void rule__OCLCodeElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2458:1: ( rule__OCLCodeElement__Group__4__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2459:2: rule__OCLCodeElement__Group__4__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2465:1: rule__OCLCodeElement__Group__4__Impl : ( ']' ) ;
    public final void rule__OCLCodeElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2469:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2470:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2470:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2471:1: ']'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2494:1: rule__OCLEvalElement__Group__0 : rule__OCLEvalElement__Group__0__Impl rule__OCLEvalElement__Group__1 ;
    public final void rule__OCLEvalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2498:1: ( rule__OCLEvalElement__Group__0__Impl rule__OCLEvalElement__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2499:2: rule__OCLEvalElement__Group__0__Impl rule__OCLEvalElement__Group__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2506:1: rule__OCLEvalElement__Group__0__Impl : ( () ) ;
    public final void rule__OCLEvalElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2510:1: ( ( () ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2511:1: ( () )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2511:1: ( () )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2512:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLEvalElementAccess().getOCLEvalElementAction_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2513:1: ()
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2515:1: 
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2525:1: rule__OCLEvalElement__Group__1 : rule__OCLEvalElement__Group__1__Impl rule__OCLEvalElement__Group__2 ;
    public final void rule__OCLEvalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2529:1: ( rule__OCLEvalElement__Group__1__Impl rule__OCLEvalElement__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2530:2: rule__OCLEvalElement__Group__1__Impl rule__OCLEvalElement__Group__2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2537:1: rule__OCLEvalElement__Group__1__Impl : ( 'oclEval' ) ;
    public final void rule__OCLEvalElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2541:1: ( ( 'oclEval' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2542:1: ( 'oclEval' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2542:1: ( 'oclEval' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2543:1: 'oclEval'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2556:1: rule__OCLEvalElement__Group__2 : rule__OCLEvalElement__Group__2__Impl rule__OCLEvalElement__Group__3 ;
    public final void rule__OCLEvalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2560:1: ( rule__OCLEvalElement__Group__2__Impl rule__OCLEvalElement__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2561:2: rule__OCLEvalElement__Group__2__Impl rule__OCLEvalElement__Group__3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2568:1: rule__OCLEvalElement__Group__2__Impl : ( '[' ) ;
    public final void rule__OCLEvalElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2572:1: ( ( '[' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2573:1: ( '[' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2573:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2574:1: '['
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2587:1: rule__OCLEvalElement__Group__3 : rule__OCLEvalElement__Group__3__Impl rule__OCLEvalElement__Group__4 ;
    public final void rule__OCLEvalElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2591:1: ( rule__OCLEvalElement__Group__3__Impl rule__OCLEvalElement__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2592:2: rule__OCLEvalElement__Group__3__Impl rule__OCLEvalElement__Group__4
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2599:1: rule__OCLEvalElement__Group__3__Impl : ( ( rule__OCLEvalElement__ElementsAssignment_3 )* ) ;
    public final void rule__OCLEvalElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2603:1: ( ( ( rule__OCLEvalElement__ElementsAssignment_3 )* ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2604:1: ( ( rule__OCLEvalElement__ElementsAssignment_3 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2604:1: ( ( rule__OCLEvalElement__ElementsAssignment_3 )* )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2605:1: ( rule__OCLEvalElement__ElementsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLEvalElementAccess().getElementsAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2606:1: ( rule__OCLEvalElement__ElementsAssignment_3 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_WS)||LA20_0==RULE_NL||(LA20_0>=16 && LA20_0<=29)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2606:2: rule__OCLEvalElement__ElementsAssignment_3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2616:1: rule__OCLEvalElement__Group__4 : rule__OCLEvalElement__Group__4__Impl ;
    public final void rule__OCLEvalElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2620:1: ( rule__OCLEvalElement__Group__4__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2621:2: rule__OCLEvalElement__Group__4__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2627:1: rule__OCLEvalElement__Group__4__Impl : ( ']' ) ;
    public final void rule__OCLEvalElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2631:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2632:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2632:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2633:1: ']'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2656:1: rule__OCLTextElement__Group__0 : rule__OCLTextElement__Group__0__Impl rule__OCLTextElement__Group__1 ;
    public final void rule__OCLTextElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2660:1: ( rule__OCLTextElement__Group__0__Impl rule__OCLTextElement__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2661:2: rule__OCLTextElement__Group__0__Impl rule__OCLTextElement__Group__1
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2668:1: rule__OCLTextElement__Group__0__Impl : ( () ) ;
    public final void rule__OCLTextElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2672:1: ( ( () ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2673:1: ( () )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2673:1: ( () )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2674:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLTextElementAccess().getOCLTextElementAction_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2675:1: ()
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2677:1: 
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2687:1: rule__OCLTextElement__Group__1 : rule__OCLTextElement__Group__1__Impl rule__OCLTextElement__Group__2 ;
    public final void rule__OCLTextElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2691:1: ( rule__OCLTextElement__Group__1__Impl rule__OCLTextElement__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2692:2: rule__OCLTextElement__Group__1__Impl rule__OCLTextElement__Group__2
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2699:1: rule__OCLTextElement__Group__1__Impl : ( 'oclText' ) ;
    public final void rule__OCLTextElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2703:1: ( ( 'oclText' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2704:1: ( 'oclText' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2704:1: ( 'oclText' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2705:1: 'oclText'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2718:1: rule__OCLTextElement__Group__2 : rule__OCLTextElement__Group__2__Impl rule__OCLTextElement__Group__3 ;
    public final void rule__OCLTextElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2722:1: ( rule__OCLTextElement__Group__2__Impl rule__OCLTextElement__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2723:2: rule__OCLTextElement__Group__2__Impl rule__OCLTextElement__Group__3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2730:1: rule__OCLTextElement__Group__2__Impl : ( '[' ) ;
    public final void rule__OCLTextElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2734:1: ( ( '[' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2735:1: ( '[' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2735:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2736:1: '['
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2749:1: rule__OCLTextElement__Group__3 : rule__OCLTextElement__Group__3__Impl rule__OCLTextElement__Group__4 ;
    public final void rule__OCLTextElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2753:1: ( rule__OCLTextElement__Group__3__Impl rule__OCLTextElement__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2754:2: rule__OCLTextElement__Group__3__Impl rule__OCLTextElement__Group__4
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2761:1: rule__OCLTextElement__Group__3__Impl : ( ( rule__OCLTextElement__ElementsAssignment_3 )* ) ;
    public final void rule__OCLTextElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2765:1: ( ( ( rule__OCLTextElement__ElementsAssignment_3 )* ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2766:1: ( ( rule__OCLTextElement__ElementsAssignment_3 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2766:1: ( ( rule__OCLTextElement__ElementsAssignment_3 )* )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2767:1: ( rule__OCLTextElement__ElementsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOCLTextElementAccess().getElementsAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2768:1: ( rule__OCLTextElement__ElementsAssignment_3 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_WS)||LA21_0==RULE_NL||(LA21_0>=16 && LA21_0<=29)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2768:2: rule__OCLTextElement__ElementsAssignment_3
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2778:1: rule__OCLTextElement__Group__4 : rule__OCLTextElement__Group__4__Impl ;
    public final void rule__OCLTextElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2782:1: ( rule__OCLTextElement__Group__4__Impl )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2783:2: rule__OCLTextElement__Group__4__Impl
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2789:1: rule__OCLTextElement__Group__4__Impl : ( ']' ) ;
    public final void rule__OCLTextElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2793:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2794:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2794:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2795:1: ']'
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2819:1: rule__Markup__ElementsAssignment : ( ruleMarkupElement ) ;
    public final void rule__Markup__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2823:1: ( ( ruleMarkupElement ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2824:1: ( ruleMarkupElement )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2824:1: ( ruleMarkupElement )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2825:1: ruleMarkupElement
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2834:1: rule__BulletElement__LevelAssignment_2_1 : ( RULE_INT ) ;
    public final void rule__BulletElement__LevelAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2838:1: ( ( RULE_INT ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2839:1: ( RULE_INT )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2839:1: ( RULE_INT )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2840:1: RULE_INT
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2849:1: rule__BulletElement__ElementsAssignment_4 : ( ruleMarkupElement ) ;
    public final void rule__BulletElement__ElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2853:1: ( ( ruleMarkupElement ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2854:1: ( ruleMarkupElement )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2854:1: ( ruleMarkupElement )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2855:1: ruleMarkupElement
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2864:1: rule__FontElement__FontAssignment_0 : ( ( rule__FontElement__FontAlternatives_0_0 ) ) ;
    public final void rule__FontElement__FontAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2868:1: ( ( ( rule__FontElement__FontAlternatives_0_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2869:1: ( ( rule__FontElement__FontAlternatives_0_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2869:1: ( ( rule__FontElement__FontAlternatives_0_0 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2870:1: ( rule__FontElement__FontAlternatives_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFontElementAccess().getFontAlternatives_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2871:1: ( rule__FontElement__FontAlternatives_0_0 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2871:2: rule__FontElement__FontAlternatives_0_0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2880:1: rule__FontElement__ElementsAssignment_2 : ( ruleMarkupElement ) ;
    public final void rule__FontElement__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2884:1: ( ( ruleMarkupElement ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2885:1: ( ruleMarkupElement )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2885:1: ( ruleMarkupElement )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2886:1: ruleMarkupElement
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2895:1: rule__FigureElement__DefAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__FigureElement__DefAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2899:1: ( ( RULE_ID ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2900:1: ( RULE_ID )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2900:1: ( RULE_ID )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2901:1: RULE_ID
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2910:1: rule__FigureElement__SrcAssignment_3 : ( RULE_STRING ) ;
    public final void rule__FigureElement__SrcAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2914:1: ( ( RULE_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2915:1: ( RULE_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2915:1: ( RULE_STRING )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2916:1: RULE_STRING
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2925:1: rule__FigureElement__AltAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__FigureElement__AltAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2929:1: ( ( RULE_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2930:1: ( RULE_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2930:1: ( RULE_STRING )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2931:1: RULE_STRING
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2940:1: rule__FigureElement__RequiredWidthAssignment_4_2_1 : ( RULE_INT ) ;
    public final void rule__FigureElement__RequiredWidthAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2944:1: ( ( RULE_INT ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2945:1: ( RULE_INT )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2945:1: ( RULE_INT )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2946:1: RULE_INT
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2955:1: rule__FigureElement__RequiredHeightAssignment_4_2_2_1 : ( RULE_INT ) ;
    public final void rule__FigureElement__RequiredHeightAssignment_4_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2959:1: ( ( RULE_INT ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2960:1: ( RULE_INT )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2960:1: ( RULE_INT )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2961:1: RULE_INT
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2970:1: rule__FigureRefElement__RefAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__FigureRefElement__RefAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2974:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2975:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2975:1: ( ( RULE_ID ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2976:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFigureRefElementAccess().getRefFigureElementCrossReference_2_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2977:1: ( RULE_ID )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2978:1: RULE_ID
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2989:1: rule__FootnoteElement__ElementsAssignment_3 : ( ruleMarkupElement ) ;
    public final void rule__FootnoteElement__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2993:1: ( ( ruleMarkupElement ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2994:1: ( ruleMarkupElement )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2994:1: ( ruleMarkupElement )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:2995:1: ruleMarkupElement
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3004:1: rule__HeadingElement__LevelAssignment_2_1 : ( RULE_INT ) ;
    public final void rule__HeadingElement__LevelAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3008:1: ( ( RULE_INT ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3009:1: ( RULE_INT )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3009:1: ( RULE_INT )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3010:1: RULE_INT
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3019:1: rule__HeadingElement__ElementsAssignment_4 : ( ruleMarkupElement ) ;
    public final void rule__HeadingElement__ElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3023:1: ( ( ruleMarkupElement ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3024:1: ( ruleMarkupElement )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3024:1: ( ruleMarkupElement )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3025:1: ruleMarkupElement
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3034:1: rule__NewLineElement__TextAssignment : ( RULE_NL ) ;
    public final void rule__NewLineElement__TextAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3038:1: ( ( RULE_NL ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3039:1: ( RULE_NL )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3039:1: ( RULE_NL )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3040:1: RULE_NL
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3049:1: rule__NullElement__ElementsAssignment_2 : ( ruleMarkupElement ) ;
    public final void rule__NullElement__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3053:1: ( ( ruleMarkupElement ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3054:1: ( ruleMarkupElement )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3054:1: ( ruleMarkupElement )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3055:1: ruleMarkupElement
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3064:1: rule__OCLCodeElement__ElementsAssignment_3 : ( ruleMarkupElement ) ;
    public final void rule__OCLCodeElement__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3068:1: ( ( ruleMarkupElement ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3069:1: ( ruleMarkupElement )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3069:1: ( ruleMarkupElement )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3070:1: ruleMarkupElement
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3079:1: rule__OCLEvalElement__ElementsAssignment_3 : ( ruleMarkupElement ) ;
    public final void rule__OCLEvalElement__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3083:1: ( ( ruleMarkupElement ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3084:1: ( ruleMarkupElement )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3084:1: ( ruleMarkupElement )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3085:1: ruleMarkupElement
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3094:1: rule__OCLTextElement__ElementsAssignment_3 : ( ruleMarkupElement ) ;
    public final void rule__OCLTextElement__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3098:1: ( ( ruleMarkupElement ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3099:1: ( ruleMarkupElement )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3099:1: ( ruleMarkupElement )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3100:1: ruleMarkupElement
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3109:1: rule__TextElement__TextAssignment_0 : ( ( rule__TextElement__TextAlternatives_0_0 ) ) ;
    public final void rule__TextElement__TextAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3113:1: ( ( ( rule__TextElement__TextAlternatives_0_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3114:1: ( ( rule__TextElement__TextAlternatives_0_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3114:1: ( ( rule__TextElement__TextAlternatives_0_0 ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3115:1: ( rule__TextElement__TextAlternatives_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTextElementAccess().getTextAlternatives_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3116:1: ( rule__TextElement__TextAlternatives_0_0 )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3116:2: rule__TextElement__TextAlternatives_0_0
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
    // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3125:1: rule__TextElement__TextAssignment_1 : ( ruleMarkupKeyword ) ;
    public final void rule__TextElement__TextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3129:1: ( ( ruleMarkupKeyword ) )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3130:1: ( ruleMarkupKeyword )
            {
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3130:1: ( ruleMarkupKeyword )
            // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:3131:1: ruleMarkupKeyword
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
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:576:1: ( ( ruleFontElement ) )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:576:1: ( ruleFontElement )
        {
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:576:1: ( ruleFontElement )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:577:1: ruleFontElement
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
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:588:6: ( ( ruleBulletElement ) )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:588:6: ( ruleBulletElement )
        {
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:588:6: ( ruleBulletElement )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:589:1: ruleBulletElement
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
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:594:6: ( ( ruleFigureElement ) )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:594:6: ( ruleFigureElement )
        {
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:594:6: ( ruleFigureElement )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:595:1: ruleFigureElement
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
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:600:6: ( ( ruleFigureRefElement ) )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:600:6: ( ruleFigureRefElement )
        {
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:600:6: ( ruleFigureRefElement )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:601:1: ruleFigureRefElement
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
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:606:6: ( ( ruleFootnoteElement ) )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:606:6: ( ruleFootnoteElement )
        {
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:606:6: ( ruleFootnoteElement )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:607:1: ruleFootnoteElement
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
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:612:6: ( ( ruleHeadingElement ) )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:612:6: ( ruleHeadingElement )
        {
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:612:6: ( ruleHeadingElement )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:613:1: ruleHeadingElement
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
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:624:6: ( ( ruleOCLCodeElement ) )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:624:6: ( ruleOCLCodeElement )
        {
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:624:6: ( ruleOCLCodeElement )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:625:1: ruleOCLCodeElement
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
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:630:6: ( ( ruleOCLEvalElement ) )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:630:6: ( ruleOCLEvalElement )
        {
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:630:6: ( ruleOCLEvalElement )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:631:1: ruleOCLEvalElement
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
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:636:6: ( ( ruleOCLTextElement ) )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:636:6: ( ruleOCLTextElement )
        {
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:636:6: ( ruleOCLTextElement )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:637:1: ruleOCLTextElement
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
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:692:2: ( rule__TextElement__TextAssignment_0 )
        // ../org.eclipse.ocl.examples.xtext.markup.ui/src-gen/org/eclipse/ocl/examples/xtext/markup/ui/contentassist/antlr/internal/InternalMarkup.g:692:2: rule__TextElement__TextAssignment_0
        {
        pushFollow(FollowSets000.FOLLOW_rule__TextElement__TextAssignment_0_in_synpred23_InternalMarkup1480);
        rule__TextElement__TextAssignment_0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalMarkup

    // Delegated rules

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
            return "571:1: rule__MarkupElement__Alternatives : ( ( ruleFontElement ) | ( ruleNewLineElement ) | ( ruleBulletElement ) | ( ruleFigureElement ) | ( ruleFigureRefElement ) | ( ruleFootnoteElement ) | ( ruleHeadingElement ) | ( ruleNullElement ) | ( ruleOCLCodeElement ) | ( ruleOCLEvalElement ) | ( ruleOCLTextElement ) | ( ruleTextElement ) );";
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
        "\2\uffff\1\5\1\6\1\0\1\1\1\3\1\4\1\2\1\uffff}>";
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
            return "()* loopback of 692:1: ( rule__TextElement__TextAssignment_0 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_4 = input.LA(1);

                         
                        int index5_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_5 = input.LA(1);

                         
                        int index5_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_8 = input.LA(1);

                         
                        int index5_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_6 = input.LA(1);

                         
                        int index5_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA5_7 = input.LA(1);

                         
                        int index5_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA5_2 = input.LA(1);

                         
                        int index5_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_2);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA5_3 = input.LA(1);

                         
                        int index5_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_3);
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