package org.eclipse.ocl.examples.xtext.base.ui.contentassist.antlr.internal; 

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
import org.eclipse.ocl.examples.xtext.base.services.BaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBaseParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_SINGLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'*'", "'+'", "'?'", "'..'"
    };
    public static final int T__19=19;
    public static final int RULE_ML_SINGLE_QUOTED_STRING=11;
    public static final int T__16=16;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_ESCAPED_CHARACTER=7;
    public static final int RULE_ANY_OTHER=15;
    public static final int RULE_SINGLE_QUOTED_STRING=10;
    public static final int RULE_ESCAPED_ID=6;
    public static final int RULE_DOUBLE_QUOTED_STRING=9;
    public static final int RULE_SIMPLE_ID=5;
    public static final int RULE_INT=4;
    public static final int RULE_WS=14;
    public static final int RULE_SL_COMMENT=13;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=12;
    public static final int RULE_LETTER_CHARACTER=8;

    // delegates
    // delegators


        public InternalBaseParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBaseParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBaseParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g"; }


     
     	private BaseGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(BaseGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleMultiplicityBoundsCS"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:61:1: entryRuleMultiplicityBoundsCS : ruleMultiplicityBoundsCS EOF ;
    public final void entryRuleMultiplicityBoundsCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:62:1: ( ruleMultiplicityBoundsCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:63:1: ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS67);
            ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS74); if (state.failed) return ;

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
    // $ANTLR end "entryRuleMultiplicityBoundsCS"


    // $ANTLR start "ruleMultiplicityBoundsCS"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:70:1: ruleMultiplicityBoundsCS : ( ( rule__MultiplicityBoundsCS__Group__0 ) ) ;
    public final void ruleMultiplicityBoundsCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:74:2: ( ( ( rule__MultiplicityBoundsCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:75:1: ( ( rule__MultiplicityBoundsCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:75:1: ( ( rule__MultiplicityBoundsCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:76:1: ( rule__MultiplicityBoundsCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:77:1: ( rule__MultiplicityBoundsCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:77:2: rule__MultiplicityBoundsCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__0_in_ruleMultiplicityBoundsCS100);
            rule__MultiplicityBoundsCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getGroup()); 
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
    // $ANTLR end "ruleMultiplicityBoundsCS"


    // $ANTLR start "entryRuleMultiplicityStringCS"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:91:1: entryRuleMultiplicityStringCS : ruleMultiplicityStringCS EOF ;
    public final void entryRuleMultiplicityStringCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:92:1: ( ruleMultiplicityStringCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:93:1: ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS129);
            ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityStringCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS136); if (state.failed) return ;

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
    // $ANTLR end "entryRuleMultiplicityStringCS"


    // $ANTLR start "ruleMultiplicityStringCS"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:100:1: ruleMultiplicityStringCS : ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) ) ;
    public final void ruleMultiplicityStringCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:104:2: ( ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:105:1: ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:105:1: ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:106:1: ( rule__MultiplicityStringCS__StringBoundsAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAssignment()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:107:1: ( rule__MultiplicityStringCS__StringBoundsAssignment )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:107:2: rule__MultiplicityStringCS__StringBoundsAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityStringCS__StringBoundsAssignment_in_ruleMultiplicityStringCS162);
            rule__MultiplicityStringCS__StringBoundsAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAssignment()); 
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
    // $ANTLR end "ruleMultiplicityStringCS"


    // $ANTLR start "entryRuleID"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:119:1: entryRuleID : ruleID EOF ;
    public final void entryRuleID() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:120:1: ( ruleID EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:121:1: ruleID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID189);
            ruleID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID196); if (state.failed) return ;

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
    // $ANTLR end "entryRuleID"


    // $ANTLR start "ruleID"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:128:1: ruleID : ( ( rule__ID__Alternatives ) ) ;
    public final void ruleID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:132:2: ( ( ( rule__ID__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:133:1: ( ( rule__ID__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:133:1: ( ( rule__ID__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:134:1: ( rule__ID__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:135:1: ( rule__ID__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:135:2: rule__ID__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ID__Alternatives_in_ruleID222);
            rule__ID__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDAccess().getAlternatives()); 
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
    // $ANTLR end "ruleID"


    // $ANTLR start "entryRuleLOWER"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:149:1: entryRuleLOWER : ruleLOWER EOF ;
    public final void entryRuleLOWER() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:150:1: ( ruleLOWER EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:151:1: ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER251);
            ruleLOWER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLOWERRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER258); if (state.failed) return ;

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
    // $ANTLR end "entryRuleLOWER"


    // $ANTLR start "ruleLOWER"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:158:1: ruleLOWER : ( RULE_INT ) ;
    public final void ruleLOWER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:162:2: ( ( RULE_INT ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:163:1: ( RULE_INT )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:163:1: ( RULE_INT )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:164:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER284); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); 
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
    // $ANTLR end "ruleLOWER"


    // $ANTLR start "entryRuleUPPER"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:181:1: entryRuleUPPER : ruleUPPER EOF ;
    public final void entryRuleUPPER() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:182:1: ( ruleUPPER EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:183:1: ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER314);
            ruleUPPER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUPPERRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER321); if (state.failed) return ;

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
    // $ANTLR end "entryRuleUPPER"


    // $ANTLR start "ruleUPPER"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:190:1: ruleUPPER : ( ( rule__UPPER__Alternatives ) ) ;
    public final void ruleUPPER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:194:2: ( ( ( rule__UPPER__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:195:1: ( ( rule__UPPER__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:195:1: ( ( rule__UPPER__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:196:1: ( rule__UPPER__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUPPERAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:197:1: ( rule__UPPER__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:197:2: rule__UPPER__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__UPPER__Alternatives_in_ruleUPPER347);
            rule__UPPER__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUPPERAccess().getAlternatives()); 
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
    // $ANTLR end "ruleUPPER"


    // $ANTLR start "rule__MultiplicityStringCS__StringBoundsAlternatives_0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:212:1: rule__MultiplicityStringCS__StringBoundsAlternatives_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );
    public final void rule__MultiplicityStringCS__StringBoundsAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:216:1: ( ( '*' ) | ( '+' ) | ( '?' ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt1=1;
                }
                break;
            case 17:
                {
                alt1=2;
                }
                break;
            case 18:
                {
                alt1=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:217:1: ( '*' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:217:1: ( '*' )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:218:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__MultiplicityStringCS__StringBoundsAlternatives_0387); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:225:6: ( '+' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:225:6: ( '+' )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:226:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); 
                    }
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__MultiplicityStringCS__StringBoundsAlternatives_0407); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:233:6: ( '?' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:233:6: ( '?' )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:234:1: '?'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2()); 
                    }
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__MultiplicityStringCS__StringBoundsAlternatives_0427); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2()); 
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
    // $ANTLR end "rule__MultiplicityStringCS__StringBoundsAlternatives_0"


    // $ANTLR start "rule__ID__Alternatives"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:246:1: rule__ID__Alternatives : ( ( RULE_SIMPLE_ID ) | ( RULE_ESCAPED_ID ) );
    public final void rule__ID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:250:1: ( ( RULE_SIMPLE_ID ) | ( RULE_ESCAPED_ID ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_SIMPLE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ESCAPED_ID) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:251:1: ( RULE_SIMPLE_ID )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:251:1: ( RULE_SIMPLE_ID )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:252:1: RULE_SIMPLE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                    }
                    match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_rule__ID__Alternatives461); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:257:6: ( RULE_ESCAPED_ID )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:257:6: ( RULE_ESCAPED_ID )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:258:1: RULE_ESCAPED_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1()); 
                    }
                    match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_rule__ID__Alternatives478); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1()); 
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
    // $ANTLR end "rule__ID__Alternatives"


    // $ANTLR start "rule__UPPER__Alternatives"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:268:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UPPER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:272:1: ( ( RULE_INT ) | ( '*' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            else if ( (LA3_0==16) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:273:1: ( RULE_INT )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:273:1: ( RULE_INT )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:274:1: RULE_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__UPPER__Alternatives510); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:279:6: ( '*' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:279:6: ( '*' )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:280:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__UPPER__Alternatives528); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); 
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
    // $ANTLR end "rule__UPPER__Alternatives"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group__0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:294:1: rule__MultiplicityBoundsCS__Group__0 : rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1 ;
    public final void rule__MultiplicityBoundsCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:298:1: ( rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:299:2: rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__0__Impl_in_rule__MultiplicityBoundsCS__Group__0560);
            rule__MultiplicityBoundsCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__1_in_rule__MultiplicityBoundsCS__Group__0563);
            rule__MultiplicityBoundsCS__Group__1();

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
    // $ANTLR end "rule__MultiplicityBoundsCS__Group__0"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group__0__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:306:1: rule__MultiplicityBoundsCS__Group__0__Impl : ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) ) ;
    public final void rule__MultiplicityBoundsCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:310:1: ( ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:311:1: ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:311:1: ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:312:1: ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:313:1: ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:313:2: rule__MultiplicityBoundsCS__LowerBoundAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__LowerBoundAssignment_0_in_rule__MultiplicityBoundsCS__Group__0__Impl590);
            rule__MultiplicityBoundsCS__LowerBoundAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0()); 
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
    // $ANTLR end "rule__MultiplicityBoundsCS__Group__0__Impl"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group__1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:323:1: rule__MultiplicityBoundsCS__Group__1 : rule__MultiplicityBoundsCS__Group__1__Impl ;
    public final void rule__MultiplicityBoundsCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:327:1: ( rule__MultiplicityBoundsCS__Group__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:328:2: rule__MultiplicityBoundsCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__1__Impl_in_rule__MultiplicityBoundsCS__Group__1620);
            rule__MultiplicityBoundsCS__Group__1__Impl();

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
    // $ANTLR end "rule__MultiplicityBoundsCS__Group__1"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group__1__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:334:1: rule__MultiplicityBoundsCS__Group__1__Impl : ( ( rule__MultiplicityBoundsCS__Group_1__0 )? ) ;
    public final void rule__MultiplicityBoundsCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:338:1: ( ( ( rule__MultiplicityBoundsCS__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:339:1: ( ( rule__MultiplicityBoundsCS__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:339:1: ( ( rule__MultiplicityBoundsCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:340:1: ( rule__MultiplicityBoundsCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:341:1: ( rule__MultiplicityBoundsCS__Group_1__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:341:2: rule__MultiplicityBoundsCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__0_in_rule__MultiplicityBoundsCS__Group__1__Impl647);
                    rule__MultiplicityBoundsCS__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1()); 
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
    // $ANTLR end "rule__MultiplicityBoundsCS__Group__1__Impl"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group_1__0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:355:1: rule__MultiplicityBoundsCS__Group_1__0 : rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1 ;
    public final void rule__MultiplicityBoundsCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:359:1: ( rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:360:2: rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__0__Impl_in_rule__MultiplicityBoundsCS__Group_1__0682);
            rule__MultiplicityBoundsCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__1_in_rule__MultiplicityBoundsCS__Group_1__0685);
            rule__MultiplicityBoundsCS__Group_1__1();

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
    // $ANTLR end "rule__MultiplicityBoundsCS__Group_1__0"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group_1__0__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:367:1: rule__MultiplicityBoundsCS__Group_1__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityBoundsCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:371:1: ( ( '..' ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:372:1: ( '..' )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:372:1: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:373:1: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__MultiplicityBoundsCS__Group_1__0__Impl713); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0()); 
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
    // $ANTLR end "rule__MultiplicityBoundsCS__Group_1__0__Impl"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group_1__1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:386:1: rule__MultiplicityBoundsCS__Group_1__1 : rule__MultiplicityBoundsCS__Group_1__1__Impl ;
    public final void rule__MultiplicityBoundsCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:390:1: ( rule__MultiplicityBoundsCS__Group_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:391:2: rule__MultiplicityBoundsCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__1__Impl_in_rule__MultiplicityBoundsCS__Group_1__1744);
            rule__MultiplicityBoundsCS__Group_1__1__Impl();

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
    // $ANTLR end "rule__MultiplicityBoundsCS__Group_1__1"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group_1__1__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:397:1: rule__MultiplicityBoundsCS__Group_1__1__Impl : ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) ) ;
    public final void rule__MultiplicityBoundsCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:401:1: ( ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:402:1: ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:402:1: ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:403:1: ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:404:1: ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:404:2: rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1_in_rule__MultiplicityBoundsCS__Group_1__1__Impl771);
            rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1()); 
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
    // $ANTLR end "rule__MultiplicityBoundsCS__Group_1__1__Impl"


    // $ANTLR start "rule__MultiplicityBoundsCS__LowerBoundAssignment_0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:420:1: rule__MultiplicityBoundsCS__LowerBoundAssignment_0 : ( ruleLOWER ) ;
    public final void rule__MultiplicityBoundsCS__LowerBoundAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:424:1: ( ( ruleLOWER ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:425:1: ( ruleLOWER )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:425:1: ( ruleLOWER )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:426:1: ruleLOWER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_rule__MultiplicityBoundsCS__LowerBoundAssignment_0811);
            ruleLOWER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__MultiplicityBoundsCS__LowerBoundAssignment_0"


    // $ANTLR start "rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:435:1: rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 : ( ruleUPPER ) ;
    public final void rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:439:1: ( ( ruleUPPER ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:440:1: ( ruleUPPER )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:440:1: ( ruleUPPER )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:441:1: ruleUPPER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1842);
            ruleUPPER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1"


    // $ANTLR start "rule__MultiplicityStringCS__StringBoundsAssignment"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:450:1: rule__MultiplicityStringCS__StringBoundsAssignment : ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) ) ;
    public final void rule__MultiplicityStringCS__StringBoundsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:454:1: ( ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:455:1: ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:455:1: ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:456:1: ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:457:1: ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:457:2: rule__MultiplicityStringCS__StringBoundsAlternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityStringCS__StringBoundsAlternatives_0_in_rule__MultiplicityStringCS__StringBoundsAssignment873);
            rule__MultiplicityStringCS__StringBoundsAlternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0()); 
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
    // $ANTLR end "rule__MultiplicityStringCS__StringBoundsAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__0_in_ruleMultiplicityBoundsCS100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS129 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityStringCS__StringBoundsAssignment_in_ruleMultiplicityStringCS162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ID__Alternatives_in_ruleID222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER251 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER314 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UPPER__Alternatives_in_ruleUPPER347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__MultiplicityStringCS__StringBoundsAlternatives_0387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__MultiplicityStringCS__StringBoundsAlternatives_0407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__MultiplicityStringCS__StringBoundsAlternatives_0427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_rule__ID__Alternatives461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_rule__ID__Alternatives478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__UPPER__Alternatives510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__UPPER__Alternatives528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__0__Impl_in_rule__MultiplicityBoundsCS__Group__0560 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__1_in_rule__MultiplicityBoundsCS__Group__0563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__LowerBoundAssignment_0_in_rule__MultiplicityBoundsCS__Group__0__Impl590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__1__Impl_in_rule__MultiplicityBoundsCS__Group__1620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__0_in_rule__MultiplicityBoundsCS__Group__1__Impl647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__0__Impl_in_rule__MultiplicityBoundsCS__Group_1__0682 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__1_in_rule__MultiplicityBoundsCS__Group_1__0685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__MultiplicityBoundsCS__Group_1__0__Impl713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__1__Impl_in_rule__MultiplicityBoundsCS__Group_1__1744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1_in_rule__MultiplicityBoundsCS__Group_1__1__Impl771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_rule__MultiplicityBoundsCS__LowerBoundAssignment_0811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityStringCS__StringBoundsAlternatives_0_in_rule__MultiplicityStringCS__StringBoundsAssignment873 = new BitSet(new long[]{0x0000000000000002L});
    }


}