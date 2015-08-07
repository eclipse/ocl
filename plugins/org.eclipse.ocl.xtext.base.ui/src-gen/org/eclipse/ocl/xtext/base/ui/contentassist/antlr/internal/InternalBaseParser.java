package org.eclipse.ocl.xtext.base.ui.contentassist.antlr.internal; 

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
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBaseParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_SINGLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'*'", "'+'", "'?'", "'..'", "'::'", "'('", "')'", "','", "'extends'", "'&&'"
    };
    public static final int RULE_ML_SINGLE_QUOTED_STRING=11;
    public static final int T__25=25;
    public static final int RULE_ESCAPED_CHARACTER=7;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int RULE_SINGLE_QUOTED_STRING=10;
    public static final int T__20=20;
    public static final int RULE_ESCAPED_ID=6;
    public static final int RULE_DOUBLE_QUOTED_STRING=9;
    public static final int RULE_SL_COMMENT=13;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=12;
    public static final int RULE_LETTER_CHARACTER=8;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_SIMPLE_ID=5;
    public static final int RULE_INT=4;
    public static final int RULE_WS=14;

    // delegates
    // delegators


        public InternalBaseParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBaseParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBaseParser.tokenNames; }
    public String getGrammarFileName() { return "../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g"; }


     
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




    // $ANTLR start "entryRuleComplexTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:61:1: entryRuleComplexTypeCS : ruleComplexTypeCS EOF ;
    public final void entryRuleComplexTypeCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:62:1: ( ruleComplexTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:63:1: ruleComplexTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComplexTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_entryRuleComplexTypeCS67);
            ruleComplexTypeCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComplexTypeCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleComplexTypeCS74); if (state.failed) return ;

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
    // $ANTLR end "entryRuleComplexTypeCS"


    // $ANTLR start "ruleComplexTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:70:1: ruleComplexTypeCS : ( rulePathTypeCS ) ;
    public final void ruleComplexTypeCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:74:2: ( ( rulePathTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:75:1: ( rulePathTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:75:1: ( rulePathTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:76:1: rulePathTypeCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComplexTypeCSAccess().getPathTypeCSParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathTypeCS_in_ruleComplexTypeCS100);
            rulePathTypeCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComplexTypeCSAccess().getPathTypeCSParserRuleCall()); 
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
    // $ANTLR end "ruleComplexTypeCS"


    // $ANTLR start "entryRuleMultiplicityBoundsCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:89:1: entryRuleMultiplicityBoundsCS : ruleMultiplicityBoundsCS EOF ;
    public final void entryRuleMultiplicityBoundsCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:90:1: ( ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:91:1: ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS126);
            ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS133); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:98:1: ruleMultiplicityBoundsCS : ( ( rule__MultiplicityBoundsCS__Group__0 ) ) ;
    public final void ruleMultiplicityBoundsCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:102:2: ( ( ( rule__MultiplicityBoundsCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:103:1: ( ( rule__MultiplicityBoundsCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:103:1: ( ( rule__MultiplicityBoundsCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:104:1: ( rule__MultiplicityBoundsCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:105:1: ( rule__MultiplicityBoundsCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:105:2: rule__MultiplicityBoundsCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__0_in_ruleMultiplicityBoundsCS159);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:119:1: entryRuleMultiplicityStringCS : ruleMultiplicityStringCS EOF ;
    public final void entryRuleMultiplicityStringCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:120:1: ( ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:121:1: ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS188);
            ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityStringCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS195); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:128:1: ruleMultiplicityStringCS : ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) ) ;
    public final void ruleMultiplicityStringCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:132:2: ( ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:133:1: ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:133:1: ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:134:1: ( rule__MultiplicityStringCS__StringBoundsAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAssignment()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:135:1: ( rule__MultiplicityStringCS__StringBoundsAssignment )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:135:2: rule__MultiplicityStringCS__StringBoundsAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityStringCS__StringBoundsAssignment_in_ruleMultiplicityStringCS221);
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


    // $ANTLR start "entryRulePathNameCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:147:1: entryRulePathNameCS : rulePathNameCS EOF ;
    public final void entryRulePathNameCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:148:1: ( rulePathNameCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:149:1: rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS248);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS255); if (state.failed) return ;

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
    // $ANTLR end "entryRulePathNameCS"


    // $ANTLR start "rulePathNameCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:156:1: rulePathNameCS : ( ( rule__PathNameCS__Group__0 ) ) ;
    public final void rulePathNameCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:160:2: ( ( ( rule__PathNameCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:161:1: ( ( rule__PathNameCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:161:1: ( ( rule__PathNameCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:162:1: ( rule__PathNameCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:163:1: ( rule__PathNameCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:163:2: rule__PathNameCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__0_in_rulePathNameCS281);
            rule__PathNameCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getGroup()); 
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
    // $ANTLR end "rulePathNameCS"


    // $ANTLR start "entryRuleFirstPathElementCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:175:1: entryRuleFirstPathElementCS : ruleFirstPathElementCS EOF ;
    public final void entryRuleFirstPathElementCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:176:1: ( ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:177:1: ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS308);
            ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFirstPathElementCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS315); if (state.failed) return ;

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
    // $ANTLR end "entryRuleFirstPathElementCS"


    // $ANTLR start "ruleFirstPathElementCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:184:1: ruleFirstPathElementCS : ( ( rule__FirstPathElementCS__ReferredElementAssignment ) ) ;
    public final void ruleFirstPathElementCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:188:2: ( ( ( rule__FirstPathElementCS__ReferredElementAssignment ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:189:1: ( ( rule__FirstPathElementCS__ReferredElementAssignment ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:189:1: ( ( rule__FirstPathElementCS__ReferredElementAssignment ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:190:1: ( rule__FirstPathElementCS__ReferredElementAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementAssignment()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:191:1: ( rule__FirstPathElementCS__ReferredElementAssignment )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:191:2: rule__FirstPathElementCS__ReferredElementAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstPathElementCS__ReferredElementAssignment_in_ruleFirstPathElementCS341);
            rule__FirstPathElementCS__ReferredElementAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFirstPathElementCSAccess().getReferredElementAssignment()); 
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
    // $ANTLR end "ruleFirstPathElementCS"


    // $ANTLR start "entryRuleNextPathElementCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:203:1: entryRuleNextPathElementCS : ruleNextPathElementCS EOF ;
    public final void entryRuleNextPathElementCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:204:1: ( ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:205:1: ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS368);
            ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNextPathElementCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS375); if (state.failed) return ;

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
    // $ANTLR end "entryRuleNextPathElementCS"


    // $ANTLR start "ruleNextPathElementCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:212:1: ruleNextPathElementCS : ( ( rule__NextPathElementCS__ReferredElementAssignment ) ) ;
    public final void ruleNextPathElementCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:216:2: ( ( ( rule__NextPathElementCS__ReferredElementAssignment ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:217:1: ( ( rule__NextPathElementCS__ReferredElementAssignment ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:217:1: ( ( rule__NextPathElementCS__ReferredElementAssignment ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:218:1: ( rule__NextPathElementCS__ReferredElementAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementAssignment()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:219:1: ( rule__NextPathElementCS__ReferredElementAssignment )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:219:2: rule__NextPathElementCS__ReferredElementAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__NextPathElementCS__ReferredElementAssignment_in_ruleNextPathElementCS401);
            rule__NextPathElementCS__ReferredElementAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNextPathElementCSAccess().getReferredElementAssignment()); 
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
    // $ANTLR end "ruleNextPathElementCS"


    // $ANTLR start "entryRulePathTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:231:1: entryRulePathTypeCS : rulePathTypeCS EOF ;
    public final void entryRulePathTypeCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:232:1: ( rulePathTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:233:1: rulePathTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathTypeCS_in_entryRulePathTypeCS428);
            rulePathTypeCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathTypeCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathTypeCS435); if (state.failed) return ;

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
    // $ANTLR end "entryRulePathTypeCS"


    // $ANTLR start "rulePathTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:240:1: rulePathTypeCS : ( ( rule__PathTypeCS__Group__0 ) ) ;
    public final void rulePathTypeCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:244:2: ( ( ( rule__PathTypeCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:245:1: ( ( rule__PathTypeCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:245:1: ( ( rule__PathTypeCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:246:1: ( rule__PathTypeCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:247:1: ( rule__PathTypeCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:247:2: rule__PathTypeCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group__0_in_rulePathTypeCS461);
            rule__PathTypeCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathTypeCSAccess().getGroup()); 
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
    // $ANTLR end "rulePathTypeCS"


    // $ANTLR start "entryRuleSimpleTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:259:1: entryRuleSimpleTypeCS : ruleSimpleTypeCS EOF ;
    public final void entryRuleSimpleTypeCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:260:1: ( ruleSimpleTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:261:1: ruleSimpleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeCS_in_entryRuleSimpleTypeCS488);
            ruleSimpleTypeCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleTypeCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleTypeCS495); if (state.failed) return ;

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
    // $ANTLR end "entryRuleSimpleTypeCS"


    // $ANTLR start "ruleSimpleTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:268:1: ruleSimpleTypeCS : ( rulePathTypeCS ) ;
    public final void ruleSimpleTypeCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:272:2: ( ( rulePathTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:273:1: ( rulePathTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:273:1: ( rulePathTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:274:1: rulePathTypeCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleTypeCSAccess().getPathTypeCSParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathTypeCS_in_ruleSimpleTypeCS521);
            rulePathTypeCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleTypeCSAccess().getPathTypeCSParserRuleCall()); 
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
    // $ANTLR end "ruleSimpleTypeCS"


    // $ANTLR start "entryRuleTemplateBindingCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:287:1: entryRuleTemplateBindingCS : ruleTemplateBindingCS EOF ;
    public final void entryRuleTemplateBindingCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:288:1: ( ruleTemplateBindingCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:289:1: ruleTemplateBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS547);
            ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateBindingCS554); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTemplateBindingCS"


    // $ANTLR start "ruleTemplateBindingCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:296:1: ruleTemplateBindingCS : ( ( rule__TemplateBindingCS__Group__0 ) ) ;
    public final void ruleTemplateBindingCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:300:2: ( ( ( rule__TemplateBindingCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:301:1: ( ( rule__TemplateBindingCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:301:1: ( ( rule__TemplateBindingCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:302:1: ( rule__TemplateBindingCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:303:1: ( rule__TemplateBindingCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:303:2: rule__TemplateBindingCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__0_in_ruleTemplateBindingCS580);
            rule__TemplateBindingCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getGroup()); 
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
    // $ANTLR end "ruleTemplateBindingCS"


    // $ANTLR start "entryRuleTemplateParameterSubstitutionCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:315:1: entryRuleTemplateParameterSubstitutionCS : ruleTemplateParameterSubstitutionCS EOF ;
    public final void entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:316:1: ( ruleTemplateParameterSubstitutionCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:317:1: ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS607);
            ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS614); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTemplateParameterSubstitutionCS"


    // $ANTLR start "ruleTemplateParameterSubstitutionCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:324:1: ruleTemplateParameterSubstitutionCS : ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) ) ;
    public final void ruleTemplateParameterSubstitutionCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:328:2: ( ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:329:1: ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:329:1: ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:330:1: ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterAssignment()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:331:1: ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:331:2: rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment_in_ruleTemplateParameterSubstitutionCS640);
            rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterAssignment()); 
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
    // $ANTLR end "ruleTemplateParameterSubstitutionCS"


    // $ANTLR start "entryRuleTemplateParameterActualCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:343:1: entryRuleTemplateParameterActualCS : ruleTemplateParameterActualCS EOF ;
    public final void entryRuleTemplateParameterActualCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:344:1: ( ruleTemplateParameterActualCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:345:1: ruleTemplateParameterActualCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterActualCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterActualCS_in_entryRuleTemplateParameterActualCS667);
            ruleTemplateParameterActualCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateParameterActualCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateParameterActualCS674); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTemplateParameterActualCS"


    // $ANTLR start "ruleTemplateParameterActualCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:352:1: ruleTemplateParameterActualCS : ( ( rule__TemplateParameterActualCS__Alternatives ) ) ;
    public final void ruleTemplateParameterActualCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:356:2: ( ( ( rule__TemplateParameterActualCS__Alternatives ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:357:1: ( ( rule__TemplateParameterActualCS__Alternatives ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:357:1: ( ( rule__TemplateParameterActualCS__Alternatives ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:358:1: ( rule__TemplateParameterActualCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterActualCSAccess().getAlternatives()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:359:1: ( rule__TemplateParameterActualCS__Alternatives )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:359:2: rule__TemplateParameterActualCS__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateParameterActualCS__Alternatives_in_ruleTemplateParameterActualCS700);
            rule__TemplateParameterActualCS__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateParameterActualCSAccess().getAlternatives()); 
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
    // $ANTLR end "ruleTemplateParameterActualCS"


    // $ANTLR start "entryRuleTypeParameterCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:373:1: entryRuleTypeParameterCS : ruleTypeParameterCS EOF ;
    public final void entryRuleTypeParameterCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:374:1: ( ruleTypeParameterCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:375:1: ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS729);
            ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeParameterCS736); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTypeParameterCS"


    // $ANTLR start "ruleTypeParameterCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:382:1: ruleTypeParameterCS : ( ( rule__TypeParameterCS__Group__0 ) ) ;
    public final void ruleTypeParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:386:2: ( ( ( rule__TypeParameterCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:387:1: ( ( rule__TypeParameterCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:387:1: ( ( rule__TypeParameterCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:388:1: ( rule__TypeParameterCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:389:1: ( rule__TypeParameterCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:389:2: rule__TypeParameterCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__0_in_ruleTypeParameterCS762);
            rule__TypeParameterCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getGroup()); 
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
    // $ANTLR end "ruleTypeParameterCS"


    // $ANTLR start "entryRuleUnreservedName"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:403:1: entryRuleUnreservedName : ruleUnreservedName EOF ;
    public final void entryRuleUnreservedName() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:404:1: ( ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:405:1: ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName791);
            ruleUnreservedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnreservedNameRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName798); if (state.failed) return ;

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
    // $ANTLR end "entryRuleUnreservedName"


    // $ANTLR start "ruleUnreservedName"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:412:1: ruleUnreservedName : ( ruleUnrestrictedName ) ;
    public final void ruleUnreservedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:416:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:417:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:417:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:418:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnreservedNameAccess().getUnrestrictedNameParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName824);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnreservedNameAccess().getUnrestrictedNameParserRuleCall()); 
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
    // $ANTLR end "ruleUnreservedName"


    // $ANTLR start "entryRuleUnrestrictedName"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:431:1: entryRuleUnrestrictedName : ruleUnrestrictedName EOF ;
    public final void entryRuleUnrestrictedName() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:432:1: ( ruleUnrestrictedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:433:1: ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName850);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnrestrictedNameRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName857); if (state.failed) return ;

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
    // $ANTLR end "entryRuleUnrestrictedName"


    // $ANTLR start "ruleUnrestrictedName"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:440:1: ruleUnrestrictedName : ( ruleIdentifier ) ;
    public final void ruleUnrestrictedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:444:2: ( ( ruleIdentifier ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:445:1: ( ruleIdentifier )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:445:1: ( ruleIdentifier )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:446:1: ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleUnrestrictedName883);
            ruleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
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
    // $ANTLR end "ruleUnrestrictedName"


    // $ANTLR start "entryRuleWildcardTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:459:1: entryRuleWildcardTypeRefCS : ruleWildcardTypeRefCS EOF ;
    public final void entryRuleWildcardTypeRefCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:460:1: ( ruleWildcardTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:461:1: ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS909);
            ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcardTypeRefCS916); if (state.failed) return ;

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
    // $ANTLR end "entryRuleWildcardTypeRefCS"


    // $ANTLR start "ruleWildcardTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:468:1: ruleWildcardTypeRefCS : ( ( rule__WildcardTypeRefCS__Group__0 ) ) ;
    public final void ruleWildcardTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:472:2: ( ( ( rule__WildcardTypeRefCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:473:1: ( ( rule__WildcardTypeRefCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:473:1: ( ( rule__WildcardTypeRefCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:474:1: ( rule__WildcardTypeRefCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:475:1: ( rule__WildcardTypeRefCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:475:2: rule__WildcardTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__0_in_ruleWildcardTypeRefCS942);
            rule__WildcardTypeRefCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getGroup()); 
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
    // $ANTLR end "ruleWildcardTypeRefCS"


    // $ANTLR start "entryRuleID"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:487:1: entryRuleID : ruleID EOF ;
    public final void entryRuleID() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:488:1: ( ruleID EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:489:1: ruleID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID969);
            ruleID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID976); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:496:1: ruleID : ( ( rule__ID__Alternatives ) ) ;
    public final void ruleID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:500:2: ( ( ( rule__ID__Alternatives ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:501:1: ( ( rule__ID__Alternatives ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:501:1: ( ( rule__ID__Alternatives ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:502:1: ( rule__ID__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDAccess().getAlternatives()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:503:1: ( rule__ID__Alternatives )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:503:2: rule__ID__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ID__Alternatives_in_ruleID1002);
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


    // $ANTLR start "entryRuleIdentifier"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:515:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:516:1: ( ruleIdentifier EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:517:1: ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier1029);
            ruleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentifierRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier1036); if (state.failed) return ;

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
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:524:1: ruleIdentifier : ( ruleID ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:528:2: ( ( ruleID ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:529:1: ( ruleID )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:529:1: ( ruleID )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:530:1: ruleID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier1062);
            ruleID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
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
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleLOWER"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:543:1: entryRuleLOWER : ruleLOWER EOF ;
    public final void entryRuleLOWER() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:544:1: ( ruleLOWER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:545:1: ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER1088);
            ruleLOWER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLOWERRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER1095); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:552:1: ruleLOWER : ( RULE_INT ) ;
    public final void ruleLOWER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:556:2: ( ( RULE_INT ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:557:1: ( RULE_INT )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:557:1: ( RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:558:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER1121); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:575:1: entryRuleUPPER : ruleUPPER EOF ;
    public final void entryRuleUPPER() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:576:1: ( ruleUPPER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:577:1: ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER1151);
            ruleUPPER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUPPERRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER1158); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:584:1: ruleUPPER : ( ( rule__UPPER__Alternatives ) ) ;
    public final void ruleUPPER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:588:2: ( ( ( rule__UPPER__Alternatives ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:589:1: ( ( rule__UPPER__Alternatives ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:589:1: ( ( rule__UPPER__Alternatives ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:590:1: ( rule__UPPER__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUPPERAccess().getAlternatives()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:591:1: ( rule__UPPER__Alternatives )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:591:2: rule__UPPER__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__UPPER__Alternatives_in_ruleUPPER1184);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:607:1: rule__MultiplicityStringCS__StringBoundsAlternatives_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );
    public final void rule__MultiplicityStringCS__StringBoundsAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:611:1: ( ( '*' ) | ( '+' ) | ( '?' ) )
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
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:612:1: ( '*' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:612:1: ( '*' )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:613:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01225); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:620:6: ( '+' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:620:6: ( '+' )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:621:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); 
                    }
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01245); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:628:6: ( '?' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:628:6: ( '?' )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:629:1: '?'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2()); 
                    }
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01265); if (state.failed) return ;
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


    // $ANTLR start "rule__TemplateParameterActualCS__Alternatives"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:641:1: rule__TemplateParameterActualCS__Alternatives : ( ( ruleComplexTypeCS ) | ( ruleWildcardTypeRefCS ) );
    public final void rule__TemplateParameterActualCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:645:1: ( ( ruleComplexTypeCS ) | ( ruleWildcardTypeRefCS ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=RULE_SIMPLE_ID && LA2_0<=RULE_ESCAPED_ID)) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
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
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:646:1: ( ruleComplexTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:646:1: ( ruleComplexTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:647:1: ruleComplexTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTemplateParameterActualCSAccess().getComplexTypeCSParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_rule__TemplateParameterActualCS__Alternatives1299);
                    ruleComplexTypeCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTemplateParameterActualCSAccess().getComplexTypeCSParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:652:6: ( ruleWildcardTypeRefCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:652:6: ( ruleWildcardTypeRefCS )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:653:1: ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTemplateParameterActualCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_rule__TemplateParameterActualCS__Alternatives1316);
                    ruleWildcardTypeRefCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTemplateParameterActualCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
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
    // $ANTLR end "rule__TemplateParameterActualCS__Alternatives"


    // $ANTLR start "rule__ID__Alternatives"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:664:1: rule__ID__Alternatives : ( ( RULE_SIMPLE_ID ) | ( RULE_ESCAPED_ID ) );
    public final void rule__ID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:668:1: ( ( RULE_SIMPLE_ID ) | ( RULE_ESCAPED_ID ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_SIMPLE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ESCAPED_ID) ) {
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
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:669:1: ( RULE_SIMPLE_ID )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:669:1: ( RULE_SIMPLE_ID )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:670:1: RULE_SIMPLE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                    }
                    match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_rule__ID__Alternatives1349); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:675:6: ( RULE_ESCAPED_ID )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:675:6: ( RULE_ESCAPED_ID )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:676:1: RULE_ESCAPED_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1()); 
                    }
                    match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_rule__ID__Alternatives1366); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:686:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UPPER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:690:1: ( ( RULE_INT ) | ( '*' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_INT) ) {
                alt4=1;
            }
            else if ( (LA4_0==16) ) {
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
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:691:1: ( RULE_INT )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:691:1: ( RULE_INT )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:692:1: RULE_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1398); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:697:6: ( '*' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:697:6: ( '*' )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:698:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__UPPER__Alternatives1416); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:712:1: rule__MultiplicityBoundsCS__Group__0 : rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1 ;
    public final void rule__MultiplicityBoundsCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:716:1: ( rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:717:2: rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__0__Impl_in_rule__MultiplicityBoundsCS__Group__01448);
            rule__MultiplicityBoundsCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__1_in_rule__MultiplicityBoundsCS__Group__01451);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:724:1: rule__MultiplicityBoundsCS__Group__0__Impl : ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) ) ;
    public final void rule__MultiplicityBoundsCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:728:1: ( ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:729:1: ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:729:1: ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:730:1: ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:731:1: ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:731:2: rule__MultiplicityBoundsCS__LowerBoundAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__LowerBoundAssignment_0_in_rule__MultiplicityBoundsCS__Group__0__Impl1478);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:741:1: rule__MultiplicityBoundsCS__Group__1 : rule__MultiplicityBoundsCS__Group__1__Impl ;
    public final void rule__MultiplicityBoundsCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:745:1: ( rule__MultiplicityBoundsCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:746:2: rule__MultiplicityBoundsCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__1__Impl_in_rule__MultiplicityBoundsCS__Group__11508);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:752:1: rule__MultiplicityBoundsCS__Group__1__Impl : ( ( rule__MultiplicityBoundsCS__Group_1__0 )? ) ;
    public final void rule__MultiplicityBoundsCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:756:1: ( ( ( rule__MultiplicityBoundsCS__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:757:1: ( ( rule__MultiplicityBoundsCS__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:757:1: ( ( rule__MultiplicityBoundsCS__Group_1__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:758:1: ( rule__MultiplicityBoundsCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:759:1: ( rule__MultiplicityBoundsCS__Group_1__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:759:2: rule__MultiplicityBoundsCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__0_in_rule__MultiplicityBoundsCS__Group__1__Impl1535);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:773:1: rule__MultiplicityBoundsCS__Group_1__0 : rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1 ;
    public final void rule__MultiplicityBoundsCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:777:1: ( rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:778:2: rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__0__Impl_in_rule__MultiplicityBoundsCS__Group_1__01570);
            rule__MultiplicityBoundsCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__1_in_rule__MultiplicityBoundsCS__Group_1__01573);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:785:1: rule__MultiplicityBoundsCS__Group_1__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityBoundsCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:789:1: ( ( '..' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:790:1: ( '..' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:790:1: ( '..' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:791:1: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__MultiplicityBoundsCS__Group_1__0__Impl1601); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:804:1: rule__MultiplicityBoundsCS__Group_1__1 : rule__MultiplicityBoundsCS__Group_1__1__Impl ;
    public final void rule__MultiplicityBoundsCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:808:1: ( rule__MultiplicityBoundsCS__Group_1__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:809:2: rule__MultiplicityBoundsCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__1__Impl_in_rule__MultiplicityBoundsCS__Group_1__11632);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:815:1: rule__MultiplicityBoundsCS__Group_1__1__Impl : ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) ) ;
    public final void rule__MultiplicityBoundsCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:819:1: ( ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:820:1: ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:820:1: ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:821:1: ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:822:1: ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:822:2: rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1_in_rule__MultiplicityBoundsCS__Group_1__1__Impl1659);
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


    // $ANTLR start "rule__PathNameCS__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:837:1: rule__PathNameCS__Group__0 : rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 ;
    public final void rule__PathNameCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:841:1: ( rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:842:2: rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__0__Impl_in_rule__PathNameCS__Group__01694);
            rule__PathNameCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__1_in_rule__PathNameCS__Group__01697);
            rule__PathNameCS__Group__1();

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
    // $ANTLR end "rule__PathNameCS__Group__0"


    // $ANTLR start "rule__PathNameCS__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:849:1: rule__PathNameCS__Group__0__Impl : ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) ) ;
    public final void rule__PathNameCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:853:1: ( ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:854:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:854:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:855:1: ( rule__PathNameCS__OwnedPathElementsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:856:1: ( rule__PathNameCS__OwnedPathElementsAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:856:2: rule__PathNameCS__OwnedPathElementsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_0_in_rule__PathNameCS__Group__0__Impl1724);
            rule__PathNameCS__OwnedPathElementsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_0()); 
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
    // $ANTLR end "rule__PathNameCS__Group__0__Impl"


    // $ANTLR start "rule__PathNameCS__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:866:1: rule__PathNameCS__Group__1 : rule__PathNameCS__Group__1__Impl ;
    public final void rule__PathNameCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:870:1: ( rule__PathNameCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:871:2: rule__PathNameCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__1__Impl_in_rule__PathNameCS__Group__11754);
            rule__PathNameCS__Group__1__Impl();

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
    // $ANTLR end "rule__PathNameCS__Group__1"


    // $ANTLR start "rule__PathNameCS__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:877:1: rule__PathNameCS__Group__1__Impl : ( ( rule__PathNameCS__Group_1__0 )* ) ;
    public final void rule__PathNameCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:881:1: ( ( ( rule__PathNameCS__Group_1__0 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:882:1: ( ( rule__PathNameCS__Group_1__0 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:882:1: ( ( rule__PathNameCS__Group_1__0 )* )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:883:1: ( rule__PathNameCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:884:1: ( rule__PathNameCS__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:884:2: rule__PathNameCS__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__0_in_rule__PathNameCS__Group__1__Impl1781);
            	    rule__PathNameCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getGroup_1()); 
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
    // $ANTLR end "rule__PathNameCS__Group__1__Impl"


    // $ANTLR start "rule__PathNameCS__Group_1__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:898:1: rule__PathNameCS__Group_1__0 : rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 ;
    public final void rule__PathNameCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:902:1: ( rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:903:2: rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__0__Impl_in_rule__PathNameCS__Group_1__01816);
            rule__PathNameCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__1_in_rule__PathNameCS__Group_1__01819);
            rule__PathNameCS__Group_1__1();

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
    // $ANTLR end "rule__PathNameCS__Group_1__0"


    // $ANTLR start "rule__PathNameCS__Group_1__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:910:1: rule__PathNameCS__Group_1__0__Impl : ( '::' ) ;
    public final void rule__PathNameCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:914:1: ( ( '::' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:915:1: ( '::' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:915:1: ( '::' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:916:1: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__PathNameCS__Group_1__0__Impl1847); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0()); 
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
    // $ANTLR end "rule__PathNameCS__Group_1__0__Impl"


    // $ANTLR start "rule__PathNameCS__Group_1__1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:929:1: rule__PathNameCS__Group_1__1 : rule__PathNameCS__Group_1__1__Impl ;
    public final void rule__PathNameCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:933:1: ( rule__PathNameCS__Group_1__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:934:2: rule__PathNameCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__1__Impl_in_rule__PathNameCS__Group_1__11878);
            rule__PathNameCS__Group_1__1__Impl();

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
    // $ANTLR end "rule__PathNameCS__Group_1__1"


    // $ANTLR start "rule__PathNameCS__Group_1__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:940:1: rule__PathNameCS__Group_1__1__Impl : ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) ) ;
    public final void rule__PathNameCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:944:1: ( ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:945:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:945:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:946:1: ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:947:1: ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:947:2: rule__PathNameCS__OwnedPathElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_1_1_in_rule__PathNameCS__Group_1__1__Impl1905);
            rule__PathNameCS__OwnedPathElementsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); 
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
    // $ANTLR end "rule__PathNameCS__Group_1__1__Impl"


    // $ANTLR start "rule__PathTypeCS__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:961:1: rule__PathTypeCS__Group__0 : rule__PathTypeCS__Group__0__Impl rule__PathTypeCS__Group__1 ;
    public final void rule__PathTypeCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:965:1: ( rule__PathTypeCS__Group__0__Impl rule__PathTypeCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:966:2: rule__PathTypeCS__Group__0__Impl rule__PathTypeCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group__0__Impl_in_rule__PathTypeCS__Group__01939);
            rule__PathTypeCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group__1_in_rule__PathTypeCS__Group__01942);
            rule__PathTypeCS__Group__1();

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
    // $ANTLR end "rule__PathTypeCS__Group__0"


    // $ANTLR start "rule__PathTypeCS__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:973:1: rule__PathTypeCS__Group__0__Impl : ( ( rule__PathTypeCS__OwnedPathNameAssignment_0 ) ) ;
    public final void rule__PathTypeCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:977:1: ( ( ( rule__PathTypeCS__OwnedPathNameAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:978:1: ( ( rule__PathTypeCS__OwnedPathNameAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:978:1: ( ( rule__PathTypeCS__OwnedPathNameAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:979:1: ( rule__PathTypeCS__OwnedPathNameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getOwnedPathNameAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:980:1: ( rule__PathTypeCS__OwnedPathNameAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:980:2: rule__PathTypeCS__OwnedPathNameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__OwnedPathNameAssignment_0_in_rule__PathTypeCS__Group__0__Impl1969);
            rule__PathTypeCS__OwnedPathNameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathTypeCSAccess().getOwnedPathNameAssignment_0()); 
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
    // $ANTLR end "rule__PathTypeCS__Group__0__Impl"


    // $ANTLR start "rule__PathTypeCS__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:990:1: rule__PathTypeCS__Group__1 : rule__PathTypeCS__Group__1__Impl ;
    public final void rule__PathTypeCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:994:1: ( rule__PathTypeCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:995:2: rule__PathTypeCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group__1__Impl_in_rule__PathTypeCS__Group__11999);
            rule__PathTypeCS__Group__1__Impl();

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
    // $ANTLR end "rule__PathTypeCS__Group__1"


    // $ANTLR start "rule__PathTypeCS__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1001:1: rule__PathTypeCS__Group__1__Impl : ( ( rule__PathTypeCS__Group_1__0 )? ) ;
    public final void rule__PathTypeCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1005:1: ( ( ( rule__PathTypeCS__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1006:1: ( ( rule__PathTypeCS__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1006:1: ( ( rule__PathTypeCS__Group_1__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1007:1: ( rule__PathTypeCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1008:1: ( rule__PathTypeCS__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1008:2: rule__PathTypeCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group_1__0_in_rule__PathTypeCS__Group__1__Impl2026);
                    rule__PathTypeCS__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathTypeCSAccess().getGroup_1()); 
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
    // $ANTLR end "rule__PathTypeCS__Group__1__Impl"


    // $ANTLR start "rule__PathTypeCS__Group_1__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1022:1: rule__PathTypeCS__Group_1__0 : rule__PathTypeCS__Group_1__0__Impl rule__PathTypeCS__Group_1__1 ;
    public final void rule__PathTypeCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1026:1: ( rule__PathTypeCS__Group_1__0__Impl rule__PathTypeCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1027:2: rule__PathTypeCS__Group_1__0__Impl rule__PathTypeCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group_1__0__Impl_in_rule__PathTypeCS__Group_1__02061);
            rule__PathTypeCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group_1__1_in_rule__PathTypeCS__Group_1__02064);
            rule__PathTypeCS__Group_1__1();

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
    // $ANTLR end "rule__PathTypeCS__Group_1__0"


    // $ANTLR start "rule__PathTypeCS__Group_1__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1034:1: rule__PathTypeCS__Group_1__0__Impl : ( '(' ) ;
    public final void rule__PathTypeCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1038:1: ( ( '(' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1039:1: ( '(' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1039:1: ( '(' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1040:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getLeftParenthesisKeyword_1_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__PathTypeCS__Group_1__0__Impl2092); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathTypeCSAccess().getLeftParenthesisKeyword_1_0()); 
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
    // $ANTLR end "rule__PathTypeCS__Group_1__0__Impl"


    // $ANTLR start "rule__PathTypeCS__Group_1__1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1053:1: rule__PathTypeCS__Group_1__1 : rule__PathTypeCS__Group_1__1__Impl rule__PathTypeCS__Group_1__2 ;
    public final void rule__PathTypeCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1057:1: ( rule__PathTypeCS__Group_1__1__Impl rule__PathTypeCS__Group_1__2 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1058:2: rule__PathTypeCS__Group_1__1__Impl rule__PathTypeCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group_1__1__Impl_in_rule__PathTypeCS__Group_1__12123);
            rule__PathTypeCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group_1__2_in_rule__PathTypeCS__Group_1__12126);
            rule__PathTypeCS__Group_1__2();

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
    // $ANTLR end "rule__PathTypeCS__Group_1__1"


    // $ANTLR start "rule__PathTypeCS__Group_1__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1065:1: rule__PathTypeCS__Group_1__1__Impl : ( ( rule__PathTypeCS__OwnedBindingAssignment_1_1 ) ) ;
    public final void rule__PathTypeCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1069:1: ( ( ( rule__PathTypeCS__OwnedBindingAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1070:1: ( ( rule__PathTypeCS__OwnedBindingAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1070:1: ( ( rule__PathTypeCS__OwnedBindingAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1071:1: ( rule__PathTypeCS__OwnedBindingAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getOwnedBindingAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1072:1: ( rule__PathTypeCS__OwnedBindingAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1072:2: rule__PathTypeCS__OwnedBindingAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__OwnedBindingAssignment_1_1_in_rule__PathTypeCS__Group_1__1__Impl2153);
            rule__PathTypeCS__OwnedBindingAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathTypeCSAccess().getOwnedBindingAssignment_1_1()); 
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
    // $ANTLR end "rule__PathTypeCS__Group_1__1__Impl"


    // $ANTLR start "rule__PathTypeCS__Group_1__2"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1082:1: rule__PathTypeCS__Group_1__2 : rule__PathTypeCS__Group_1__2__Impl ;
    public final void rule__PathTypeCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1086:1: ( rule__PathTypeCS__Group_1__2__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1087:2: rule__PathTypeCS__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group_1__2__Impl_in_rule__PathTypeCS__Group_1__22183);
            rule__PathTypeCS__Group_1__2__Impl();

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
    // $ANTLR end "rule__PathTypeCS__Group_1__2"


    // $ANTLR start "rule__PathTypeCS__Group_1__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1093:1: rule__PathTypeCS__Group_1__2__Impl : ( ')' ) ;
    public final void rule__PathTypeCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1097:1: ( ( ')' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1098:1: ( ')' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1098:1: ( ')' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1099:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getRightParenthesisKeyword_1_2()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__PathTypeCS__Group_1__2__Impl2211); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathTypeCSAccess().getRightParenthesisKeyword_1_2()); 
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
    // $ANTLR end "rule__PathTypeCS__Group_1__2__Impl"


    // $ANTLR start "rule__TemplateBindingCS__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1118:1: rule__TemplateBindingCS__Group__0 : rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1 ;
    public final void rule__TemplateBindingCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1122:1: ( rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1123:2: rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__0__Impl_in_rule__TemplateBindingCS__Group__02248);
            rule__TemplateBindingCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__1_in_rule__TemplateBindingCS__Group__02251);
            rule__TemplateBindingCS__Group__1();

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
    // $ANTLR end "rule__TemplateBindingCS__Group__0"


    // $ANTLR start "rule__TemplateBindingCS__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1130:1: rule__TemplateBindingCS__Group__0__Impl : ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) ) ;
    public final void rule__TemplateBindingCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1134:1: ( ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1135:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1135:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1136:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1137:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1137:2: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0_in_rule__TemplateBindingCS__Group__0__Impl2278);
            rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_0()); 
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
    // $ANTLR end "rule__TemplateBindingCS__Group__0__Impl"


    // $ANTLR start "rule__TemplateBindingCS__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1147:1: rule__TemplateBindingCS__Group__1 : rule__TemplateBindingCS__Group__1__Impl ;
    public final void rule__TemplateBindingCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1151:1: ( rule__TemplateBindingCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1152:2: rule__TemplateBindingCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__1__Impl_in_rule__TemplateBindingCS__Group__12308);
            rule__TemplateBindingCS__Group__1__Impl();

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
    // $ANTLR end "rule__TemplateBindingCS__Group__1"


    // $ANTLR start "rule__TemplateBindingCS__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1158:1: rule__TemplateBindingCS__Group__1__Impl : ( ( rule__TemplateBindingCS__Group_1__0 )* ) ;
    public final void rule__TemplateBindingCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1162:1: ( ( ( rule__TemplateBindingCS__Group_1__0 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1163:1: ( ( rule__TemplateBindingCS__Group_1__0 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1163:1: ( ( rule__TemplateBindingCS__Group_1__0 )* )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1164:1: ( rule__TemplateBindingCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1165:1: ( rule__TemplateBindingCS__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==23) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1165:2: rule__TemplateBindingCS__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_1__0_in_rule__TemplateBindingCS__Group__1__Impl2335);
            	    rule__TemplateBindingCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getGroup_1()); 
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
    // $ANTLR end "rule__TemplateBindingCS__Group__1__Impl"


    // $ANTLR start "rule__TemplateBindingCS__Group_1__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1179:1: rule__TemplateBindingCS__Group_1__0 : rule__TemplateBindingCS__Group_1__0__Impl rule__TemplateBindingCS__Group_1__1 ;
    public final void rule__TemplateBindingCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1183:1: ( rule__TemplateBindingCS__Group_1__0__Impl rule__TemplateBindingCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1184:2: rule__TemplateBindingCS__Group_1__0__Impl rule__TemplateBindingCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_1__0__Impl_in_rule__TemplateBindingCS__Group_1__02370);
            rule__TemplateBindingCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_1__1_in_rule__TemplateBindingCS__Group_1__02373);
            rule__TemplateBindingCS__Group_1__1();

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
    // $ANTLR end "rule__TemplateBindingCS__Group_1__0"


    // $ANTLR start "rule__TemplateBindingCS__Group_1__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1191:1: rule__TemplateBindingCS__Group_1__0__Impl : ( ',' ) ;
    public final void rule__TemplateBindingCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1195:1: ( ( ',' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1196:1: ( ',' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1196:1: ( ',' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1197:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0()); 
            }
            match(input,23,FollowSets000.FOLLOW_23_in_rule__TemplateBindingCS__Group_1__0__Impl2401); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0()); 
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
    // $ANTLR end "rule__TemplateBindingCS__Group_1__0__Impl"


    // $ANTLR start "rule__TemplateBindingCS__Group_1__1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1210:1: rule__TemplateBindingCS__Group_1__1 : rule__TemplateBindingCS__Group_1__1__Impl ;
    public final void rule__TemplateBindingCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1214:1: ( rule__TemplateBindingCS__Group_1__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1215:2: rule__TemplateBindingCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_1__1__Impl_in_rule__TemplateBindingCS__Group_1__12432);
            rule__TemplateBindingCS__Group_1__1__Impl();

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
    // $ANTLR end "rule__TemplateBindingCS__Group_1__1"


    // $ANTLR start "rule__TemplateBindingCS__Group_1__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1221:1: rule__TemplateBindingCS__Group_1__1__Impl : ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) ) ;
    public final void rule__TemplateBindingCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1225:1: ( ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1226:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1226:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1227:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1228:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1228:2: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1_in_rule__TemplateBindingCS__Group_1__1__Impl2459);
            rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1_1()); 
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
    // $ANTLR end "rule__TemplateBindingCS__Group_1__1__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1244:1: rule__TypeParameterCS__Group__0 : rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1 ;
    public final void rule__TypeParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1248:1: ( rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1249:2: rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__0__Impl_in_rule__TypeParameterCS__Group__02495);
            rule__TypeParameterCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__1_in_rule__TypeParameterCS__Group__02498);
            rule__TypeParameterCS__Group__1();

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
    // $ANTLR end "rule__TypeParameterCS__Group__0"


    // $ANTLR start "rule__TypeParameterCS__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1256:1: rule__TypeParameterCS__Group__0__Impl : ( ( rule__TypeParameterCS__NameAssignment_0 ) ) ;
    public final void rule__TypeParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1260:1: ( ( ( rule__TypeParameterCS__NameAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1261:1: ( ( rule__TypeParameterCS__NameAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1261:1: ( ( rule__TypeParameterCS__NameAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1262:1: ( rule__TypeParameterCS__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getNameAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1263:1: ( rule__TypeParameterCS__NameAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1263:2: rule__TypeParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__NameAssignment_0_in_rule__TypeParameterCS__Group__0__Impl2525);
            rule__TypeParameterCS__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getNameAssignment_0()); 
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
    // $ANTLR end "rule__TypeParameterCS__Group__0__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1273:1: rule__TypeParameterCS__Group__1 : rule__TypeParameterCS__Group__1__Impl ;
    public final void rule__TypeParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1277:1: ( rule__TypeParameterCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1278:2: rule__TypeParameterCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__1__Impl_in_rule__TypeParameterCS__Group__12555);
            rule__TypeParameterCS__Group__1__Impl();

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
    // $ANTLR end "rule__TypeParameterCS__Group__1"


    // $ANTLR start "rule__TypeParameterCS__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1284:1: rule__TypeParameterCS__Group__1__Impl : ( ( rule__TypeParameterCS__Group_1__0 )? ) ;
    public final void rule__TypeParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1288:1: ( ( ( rule__TypeParameterCS__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1289:1: ( ( rule__TypeParameterCS__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1289:1: ( ( rule__TypeParameterCS__Group_1__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1290:1: ( rule__TypeParameterCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1291:1: ( rule__TypeParameterCS__Group_1__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1291:2: rule__TypeParameterCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__0_in_rule__TypeParameterCS__Group__1__Impl2582);
                    rule__TypeParameterCS__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getGroup_1()); 
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
    // $ANTLR end "rule__TypeParameterCS__Group__1__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1305:1: rule__TypeParameterCS__Group_1__0 : rule__TypeParameterCS__Group_1__0__Impl rule__TypeParameterCS__Group_1__1 ;
    public final void rule__TypeParameterCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1309:1: ( rule__TypeParameterCS__Group_1__0__Impl rule__TypeParameterCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1310:2: rule__TypeParameterCS__Group_1__0__Impl rule__TypeParameterCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__0__Impl_in_rule__TypeParameterCS__Group_1__02617);
            rule__TypeParameterCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__1_in_rule__TypeParameterCS__Group_1__02620);
            rule__TypeParameterCS__Group_1__1();

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
    // $ANTLR end "rule__TypeParameterCS__Group_1__0"


    // $ANTLR start "rule__TypeParameterCS__Group_1__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1317:1: rule__TypeParameterCS__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__TypeParameterCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1321:1: ( ( 'extends' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1322:1: ( 'extends' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1322:1: ( 'extends' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1323:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__TypeParameterCS__Group_1__0__Impl2648); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0()); 
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
    // $ANTLR end "rule__TypeParameterCS__Group_1__0__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1__1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1336:1: rule__TypeParameterCS__Group_1__1 : rule__TypeParameterCS__Group_1__1__Impl rule__TypeParameterCS__Group_1__2 ;
    public final void rule__TypeParameterCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1340:1: ( rule__TypeParameterCS__Group_1__1__Impl rule__TypeParameterCS__Group_1__2 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1341:2: rule__TypeParameterCS__Group_1__1__Impl rule__TypeParameterCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__1__Impl_in_rule__TypeParameterCS__Group_1__12679);
            rule__TypeParameterCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__2_in_rule__TypeParameterCS__Group_1__12682);
            rule__TypeParameterCS__Group_1__2();

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
    // $ANTLR end "rule__TypeParameterCS__Group_1__1"


    // $ANTLR start "rule__TypeParameterCS__Group_1__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1348:1: rule__TypeParameterCS__Group_1__1__Impl : ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) ) ;
    public final void rule__TypeParameterCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1352:1: ( ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1353:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1353:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1354:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1355:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1355:2: rule__TypeParameterCS__OwnedExtendsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_1_in_rule__TypeParameterCS__Group_1__1__Impl2709);
            rule__TypeParameterCS__OwnedExtendsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_1()); 
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
    // $ANTLR end "rule__TypeParameterCS__Group_1__1__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1__2"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1365:1: rule__TypeParameterCS__Group_1__2 : rule__TypeParameterCS__Group_1__2__Impl ;
    public final void rule__TypeParameterCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1369:1: ( rule__TypeParameterCS__Group_1__2__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1370:2: rule__TypeParameterCS__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__2__Impl_in_rule__TypeParameterCS__Group_1__22739);
            rule__TypeParameterCS__Group_1__2__Impl();

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
    // $ANTLR end "rule__TypeParameterCS__Group_1__2"


    // $ANTLR start "rule__TypeParameterCS__Group_1__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1376:1: rule__TypeParameterCS__Group_1__2__Impl : ( ( rule__TypeParameterCS__Group_1_2__0 )* ) ;
    public final void rule__TypeParameterCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1380:1: ( ( ( rule__TypeParameterCS__Group_1_2__0 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1381:1: ( ( rule__TypeParameterCS__Group_1_2__0 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1381:1: ( ( rule__TypeParameterCS__Group_1_2__0 )* )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1382:1: ( rule__TypeParameterCS__Group_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup_1_2()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1383:1: ( rule__TypeParameterCS__Group_1_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==25) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1383:2: rule__TypeParameterCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_2__0_in_rule__TypeParameterCS__Group_1__2__Impl2766);
            	    rule__TypeParameterCS__Group_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getGroup_1_2()); 
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
    // $ANTLR end "rule__TypeParameterCS__Group_1__2__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1_2__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1399:1: rule__TypeParameterCS__Group_1_2__0 : rule__TypeParameterCS__Group_1_2__0__Impl rule__TypeParameterCS__Group_1_2__1 ;
    public final void rule__TypeParameterCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1403:1: ( rule__TypeParameterCS__Group_1_2__0__Impl rule__TypeParameterCS__Group_1_2__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1404:2: rule__TypeParameterCS__Group_1_2__0__Impl rule__TypeParameterCS__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_2__0__Impl_in_rule__TypeParameterCS__Group_1_2__02803);
            rule__TypeParameterCS__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_2__1_in_rule__TypeParameterCS__Group_1_2__02806);
            rule__TypeParameterCS__Group_1_2__1();

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
    // $ANTLR end "rule__TypeParameterCS__Group_1_2__0"


    // $ANTLR start "rule__TypeParameterCS__Group_1_2__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1411:1: rule__TypeParameterCS__Group_1_2__0__Impl : ( '&&' ) ;
    public final void rule__TypeParameterCS__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1415:1: ( ( '&&' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1416:1: ( '&&' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1416:1: ( '&&' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1417:1: '&&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__TypeParameterCS__Group_1_2__0__Impl2834); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0()); 
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
    // $ANTLR end "rule__TypeParameterCS__Group_1_2__0__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1_2__1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1430:1: rule__TypeParameterCS__Group_1_2__1 : rule__TypeParameterCS__Group_1_2__1__Impl ;
    public final void rule__TypeParameterCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1434:1: ( rule__TypeParameterCS__Group_1_2__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1435:2: rule__TypeParameterCS__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_2__1__Impl_in_rule__TypeParameterCS__Group_1_2__12865);
            rule__TypeParameterCS__Group_1_2__1__Impl();

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
    // $ANTLR end "rule__TypeParameterCS__Group_1_2__1"


    // $ANTLR start "rule__TypeParameterCS__Group_1_2__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1441:1: rule__TypeParameterCS__Group_1_2__1__Impl : ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) ) ;
    public final void rule__TypeParameterCS__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1445:1: ( ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1446:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1446:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1447:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_2_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1448:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1448:2: rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1_in_rule__TypeParameterCS__Group_1_2__1__Impl2892);
            rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_2_1()); 
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
    // $ANTLR end "rule__TypeParameterCS__Group_1_2__1__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1462:1: rule__WildcardTypeRefCS__Group__0 : rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1 ;
    public final void rule__WildcardTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1466:1: ( rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1467:2: rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__0__Impl_in_rule__WildcardTypeRefCS__Group__02926);
            rule__WildcardTypeRefCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__1_in_rule__WildcardTypeRefCS__Group__02929);
            rule__WildcardTypeRefCS__Group__1();

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
    // $ANTLR end "rule__WildcardTypeRefCS__Group__0"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1474:1: rule__WildcardTypeRefCS__Group__0__Impl : ( () ) ;
    public final void rule__WildcardTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1478:1: ( ( () ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1479:1: ( () )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1479:1: ( () )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1480:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1481:1: ()
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1483:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group__0__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1493:1: rule__WildcardTypeRefCS__Group__1 : rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2 ;
    public final void rule__WildcardTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1497:1: ( rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1498:2: rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__1__Impl_in_rule__WildcardTypeRefCS__Group__12987);
            rule__WildcardTypeRefCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__2_in_rule__WildcardTypeRefCS__Group__12990);
            rule__WildcardTypeRefCS__Group__2();

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
    // $ANTLR end "rule__WildcardTypeRefCS__Group__1"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1505:1: rule__WildcardTypeRefCS__Group__1__Impl : ( '?' ) ;
    public final void rule__WildcardTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1509:1: ( ( '?' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1510:1: ( '?' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1510:1: ( '?' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1511:1: '?'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__WildcardTypeRefCS__Group__1__Impl3018); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); 
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
    // $ANTLR end "rule__WildcardTypeRefCS__Group__1__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__2"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1524:1: rule__WildcardTypeRefCS__Group__2 : rule__WildcardTypeRefCS__Group__2__Impl ;
    public final void rule__WildcardTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1528:1: ( rule__WildcardTypeRefCS__Group__2__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1529:2: rule__WildcardTypeRefCS__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__2__Impl_in_rule__WildcardTypeRefCS__Group__23049);
            rule__WildcardTypeRefCS__Group__2__Impl();

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
    // $ANTLR end "rule__WildcardTypeRefCS__Group__2"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1535:1: rule__WildcardTypeRefCS__Group__2__Impl : ( ( rule__WildcardTypeRefCS__Group_2__0 )? ) ;
    public final void rule__WildcardTypeRefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1539:1: ( ( ( rule__WildcardTypeRefCS__Group_2__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1540:1: ( ( rule__WildcardTypeRefCS__Group_2__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1540:1: ( ( rule__WildcardTypeRefCS__Group_2__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1541:1: ( rule__WildcardTypeRefCS__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1542:1: ( rule__WildcardTypeRefCS__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1542:2: rule__WildcardTypeRefCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2__0_in_rule__WildcardTypeRefCS__Group__2__Impl3076);
                    rule__WildcardTypeRefCS__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2()); 
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
    // $ANTLR end "rule__WildcardTypeRefCS__Group__2__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1558:1: rule__WildcardTypeRefCS__Group_2__0 : rule__WildcardTypeRefCS__Group_2__0__Impl rule__WildcardTypeRefCS__Group_2__1 ;
    public final void rule__WildcardTypeRefCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1562:1: ( rule__WildcardTypeRefCS__Group_2__0__Impl rule__WildcardTypeRefCS__Group_2__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1563:2: rule__WildcardTypeRefCS__Group_2__0__Impl rule__WildcardTypeRefCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2__0__Impl_in_rule__WildcardTypeRefCS__Group_2__03113);
            rule__WildcardTypeRefCS__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2__1_in_rule__WildcardTypeRefCS__Group_2__03116);
            rule__WildcardTypeRefCS__Group_2__1();

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
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2__0"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1570:1: rule__WildcardTypeRefCS__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__WildcardTypeRefCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1574:1: ( ( 'extends' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1575:1: ( 'extends' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1575:1: ( 'extends' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1576:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__WildcardTypeRefCS__Group_2__0__Impl3144); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0()); 
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
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2__0__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2__1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1589:1: rule__WildcardTypeRefCS__Group_2__1 : rule__WildcardTypeRefCS__Group_2__1__Impl ;
    public final void rule__WildcardTypeRefCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1593:1: ( rule__WildcardTypeRefCS__Group_2__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1594:2: rule__WildcardTypeRefCS__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2__1__Impl_in_rule__WildcardTypeRefCS__Group_2__13175);
            rule__WildcardTypeRefCS__Group_2__1__Impl();

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
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2__1"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1600:1: rule__WildcardTypeRefCS__Group_2__1__Impl : ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) ) ;
    public final void rule__WildcardTypeRefCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1604:1: ( ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1605:1: ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1605:1: ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1606:1: ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1607:1: ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1607:2: rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1_in_rule__WildcardTypeRefCS__Group_2__1__Impl3202);
            rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_1()); 
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
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2__1__Impl"


    // $ANTLR start "rule__MultiplicityBoundsCS__LowerBoundAssignment_0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1622:1: rule__MultiplicityBoundsCS__LowerBoundAssignment_0 : ( ruleLOWER ) ;
    public final void rule__MultiplicityBoundsCS__LowerBoundAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1626:1: ( ( ruleLOWER ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1627:1: ( ruleLOWER )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1627:1: ( ruleLOWER )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1628:1: ruleLOWER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_rule__MultiplicityBoundsCS__LowerBoundAssignment_03241);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1637:1: rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 : ( ruleUPPER ) ;
    public final void rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1641:1: ( ( ruleUPPER ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1642:1: ( ruleUPPER )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1642:1: ( ruleUPPER )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1643:1: ruleUPPER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_13272);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1653:1: rule__MultiplicityStringCS__StringBoundsAssignment : ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) ) ;
    public final void rule__MultiplicityStringCS__StringBoundsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1657:1: ( ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1658:1: ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1658:1: ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1659:1: ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1660:1: ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1660:2: rule__MultiplicityStringCS__StringBoundsAlternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityStringCS__StringBoundsAlternatives_0_in_rule__MultiplicityStringCS__StringBoundsAssignment3304);
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


    // $ANTLR start "rule__PathNameCS__OwnedPathElementsAssignment_0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1669:1: rule__PathNameCS__OwnedPathElementsAssignment_0 : ( ruleFirstPathElementCS ) ;
    public final void rule__PathNameCS__OwnedPathElementsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1673:1: ( ( ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1674:1: ( ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1674:1: ( ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1675:1: ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_03337);
            ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__PathNameCS__OwnedPathElementsAssignment_0"


    // $ANTLR start "rule__PathNameCS__OwnedPathElementsAssignment_1_1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1684:1: rule__PathNameCS__OwnedPathElementsAssignment_1_1 : ( ruleNextPathElementCS ) ;
    public final void rule__PathNameCS__OwnedPathElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1688:1: ( ( ruleNextPathElementCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1689:1: ( ruleNextPathElementCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1689:1: ( ruleNextPathElementCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1690:1: ruleNextPathElementCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_1_13368);
            ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__PathNameCS__OwnedPathElementsAssignment_1_1"


    // $ANTLR start "rule__FirstPathElementCS__ReferredElementAssignment"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1699:1: rule__FirstPathElementCS__ReferredElementAssignment : ( ( ruleUnrestrictedName ) ) ;
    public final void rule__FirstPathElementCS__ReferredElementAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1703:1: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1704:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1704:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1705:1: ( ruleUnrestrictedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1706:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1707:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_rule__FirstPathElementCS__ReferredElementAssignment3403);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
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
    // $ANTLR end "rule__FirstPathElementCS__ReferredElementAssignment"


    // $ANTLR start "rule__NextPathElementCS__ReferredElementAssignment"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1718:1: rule__NextPathElementCS__ReferredElementAssignment : ( ( ruleUnreservedName ) ) ;
    public final void rule__NextPathElementCS__ReferredElementAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1722:1: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1723:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1723:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1724:1: ( ruleUnreservedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1725:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1726:1: ruleUnreservedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementUnreservedNameParserRuleCall_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_rule__NextPathElementCS__ReferredElementAssignment3442);
            ruleUnreservedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementUnreservedNameParserRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
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
    // $ANTLR end "rule__NextPathElementCS__ReferredElementAssignment"


    // $ANTLR start "rule__PathTypeCS__OwnedPathNameAssignment_0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1737:1: rule__PathTypeCS__OwnedPathNameAssignment_0 : ( rulePathNameCS ) ;
    public final void rule__PathTypeCS__OwnedPathNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1741:1: ( ( rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1742:1: ( rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1742:1: ( rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1743:1: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_rule__PathTypeCS__OwnedPathNameAssignment_03477);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathTypeCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__PathTypeCS__OwnedPathNameAssignment_0"


    // $ANTLR start "rule__PathTypeCS__OwnedBindingAssignment_1_1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1752:1: rule__PathTypeCS__OwnedBindingAssignment_1_1 : ( ruleTemplateBindingCS ) ;
    public final void rule__PathTypeCS__OwnedBindingAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1756:1: ( ( ruleTemplateBindingCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1757:1: ( ruleTemplateBindingCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1757:1: ( ruleTemplateBindingCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1758:1: ruleTemplateBindingCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_rule__PathTypeCS__OwnedBindingAssignment_1_13508);
            ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathTypeCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__PathTypeCS__OwnedBindingAssignment_1_1"


    // $ANTLR start "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1767:1: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 : ( ruleTemplateParameterSubstitutionCS ) ;
    public final void rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1771:1: ( ( ruleTemplateParameterSubstitutionCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1772:1: ( ruleTemplateParameterSubstitutionCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1772:1: ( ruleTemplateParameterSubstitutionCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1773:1: ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_03539);
            ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0"


    // $ANTLR start "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1782:1: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 : ( ruleTemplateParameterSubstitutionCS ) ;
    public final void rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1786:1: ( ( ruleTemplateParameterSubstitutionCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1787:1: ( ruleTemplateParameterSubstitutionCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1787:1: ( ruleTemplateParameterSubstitutionCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1788:1: ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_13570);
            ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1"


    // $ANTLR start "rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1797:1: rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment : ( ruleTemplateParameterActualCS ) ;
    public final void rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1801:1: ( ( ruleTemplateParameterActualCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1802:1: ( ruleTemplateParameterActualCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1802:1: ( ruleTemplateParameterActualCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1803:1: ruleTemplateParameterActualCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTemplateParameterActualCSParserRuleCall_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterActualCS_in_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment3601);
            ruleTemplateParameterActualCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTemplateParameterActualCSParserRuleCall_0()); 
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
    // $ANTLR end "rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment"


    // $ANTLR start "rule__TypeParameterCS__NameAssignment_0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1814:1: rule__TypeParameterCS__NameAssignment_0 : ( ruleUnrestrictedName ) ;
    public final void rule__TypeParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1818:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1819:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1819:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1820:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_rule__TypeParameterCS__NameAssignment_03634);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__TypeParameterCS__NameAssignment_0"


    // $ANTLR start "rule__TypeParameterCS__OwnedExtendsAssignment_1_1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1829:1: rule__TypeParameterCS__OwnedExtendsAssignment_1_1 : ( ruleSimpleTypeCS ) ;
    public final void rule__TypeParameterCS__OwnedExtendsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1833:1: ( ( ruleSimpleTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1834:1: ( ruleSimpleTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1834:1: ( ruleSimpleTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1835:1: ruleSimpleTypeCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsSimpleTypeCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_13665);
            ruleSimpleTypeCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsSimpleTypeCSParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__TypeParameterCS__OwnedExtendsAssignment_1_1"


    // $ANTLR start "rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1844:1: rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 : ( ruleSimpleTypeCS ) ;
    public final void rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1848:1: ( ( ruleSimpleTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1849:1: ( ruleSimpleTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1849:1: ( ruleSimpleTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1850:1: ruleSimpleTypeCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsSimpleTypeCSParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_2_13696);
            ruleSimpleTypeCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsSimpleTypeCSParserRuleCall_1_2_1_0()); 
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
    // $ANTLR end "rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1"


    // $ANTLR start "rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1859:1: rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 : ( ruleSimpleTypeCS ) ;
    public final void rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1863:1: ( ( ruleSimpleTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1864:1: ( ruleSimpleTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1864:1: ( ruleSimpleTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1865:1: ruleSimpleTypeCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsSimpleTypeCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeCS_in_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_13727);
            ruleSimpleTypeCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsSimpleTypeCSParserRuleCall_2_1_0()); 
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
    // $ANTLR end "rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_entryRuleComplexTypeCS67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleComplexTypeCS74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathTypeCS_in_ruleComplexTypeCS100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS126 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__0_in_ruleMultiplicityBoundsCS159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS188 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityStringCS__StringBoundsAssignment_in_ruleMultiplicityStringCS221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS248 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__0_in_rulePathNameCS281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS308 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstPathElementCS__ReferredElementAssignment_in_ruleFirstPathElementCS341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS368 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextPathElementCS__ReferredElementAssignment_in_ruleNextPathElementCS401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathTypeCS_in_entryRulePathTypeCS428 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathTypeCS435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group__0_in_rulePathTypeCS461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleTypeCS_in_entryRuleSimpleTypeCS488 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleTypeCS495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathTypeCS_in_ruleSimpleTypeCS521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS547 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBindingCS554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__0_in_ruleTemplateBindingCS580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS607 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment_in_ruleTemplateParameterSubstitutionCS640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterActualCS_in_entryRuleTemplateParameterActualCS667 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateParameterActualCS674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateParameterActualCS__Alternatives_in_ruleTemplateParameterActualCS700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS729 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameterCS736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__0_in_ruleTypeParameterCS762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName791 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName850 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleUnrestrictedName883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS909 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcardTypeRefCS916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__0_in_ruleWildcardTypeRefCS942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID969 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ID__Alternatives_in_ruleID1002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier1029 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier1036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier1062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER1088 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER1095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER1121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER1151 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER1158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UPPER__Alternatives_in_ruleUPPER1184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_rule__TemplateParameterActualCS__Alternatives1299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_rule__TemplateParameterActualCS__Alternatives1316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_rule__ID__Alternatives1349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_rule__ID__Alternatives1366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__UPPER__Alternatives1416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__0__Impl_in_rule__MultiplicityBoundsCS__Group__01448 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__1_in_rule__MultiplicityBoundsCS__Group__01451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__LowerBoundAssignment_0_in_rule__MultiplicityBoundsCS__Group__0__Impl1478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__1__Impl_in_rule__MultiplicityBoundsCS__Group__11508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__0_in_rule__MultiplicityBoundsCS__Group__1__Impl1535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__0__Impl_in_rule__MultiplicityBoundsCS__Group_1__01570 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__1_in_rule__MultiplicityBoundsCS__Group_1__01573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__MultiplicityBoundsCS__Group_1__0__Impl1601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__1__Impl_in_rule__MultiplicityBoundsCS__Group_1__11632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1_in_rule__MultiplicityBoundsCS__Group_1__1__Impl1659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__0__Impl_in_rule__PathNameCS__Group__01694 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__1_in_rule__PathNameCS__Group__01697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_0_in_rule__PathNameCS__Group__0__Impl1724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__1__Impl_in_rule__PathNameCS__Group__11754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__0_in_rule__PathNameCS__Group__1__Impl1781 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__0__Impl_in_rule__PathNameCS__Group_1__01816 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__1_in_rule__PathNameCS__Group_1__01819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__PathNameCS__Group_1__0__Impl1847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__1__Impl_in_rule__PathNameCS__Group_1__11878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_1_1_in_rule__PathNameCS__Group_1__1__Impl1905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group__0__Impl_in_rule__PathTypeCS__Group__01939 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group__1_in_rule__PathTypeCS__Group__01942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__OwnedPathNameAssignment_0_in_rule__PathTypeCS__Group__0__Impl1969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group__1__Impl_in_rule__PathTypeCS__Group__11999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group_1__0_in_rule__PathTypeCS__Group__1__Impl2026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group_1__0__Impl_in_rule__PathTypeCS__Group_1__02061 = new BitSet(new long[]{0x0000000000040060L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group_1__1_in_rule__PathTypeCS__Group_1__02064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__PathTypeCS__Group_1__0__Impl2092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group_1__1__Impl_in_rule__PathTypeCS__Group_1__12123 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group_1__2_in_rule__PathTypeCS__Group_1__12126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__OwnedBindingAssignment_1_1_in_rule__PathTypeCS__Group_1__1__Impl2153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group_1__2__Impl_in_rule__PathTypeCS__Group_1__22183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__PathTypeCS__Group_1__2__Impl2211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__0__Impl_in_rule__TemplateBindingCS__Group__02248 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__1_in_rule__TemplateBindingCS__Group__02251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0_in_rule__TemplateBindingCS__Group__0__Impl2278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__1__Impl_in_rule__TemplateBindingCS__Group__12308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_1__0_in_rule__TemplateBindingCS__Group__1__Impl2335 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_1__0__Impl_in_rule__TemplateBindingCS__Group_1__02370 = new BitSet(new long[]{0x0000000000040060L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_1__1_in_rule__TemplateBindingCS__Group_1__02373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__TemplateBindingCS__Group_1__0__Impl2401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_1__1__Impl_in_rule__TemplateBindingCS__Group_1__12432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1_in_rule__TemplateBindingCS__Group_1__1__Impl2459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__0__Impl_in_rule__TypeParameterCS__Group__02495 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__1_in_rule__TypeParameterCS__Group__02498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__NameAssignment_0_in_rule__TypeParameterCS__Group__0__Impl2525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__1__Impl_in_rule__TypeParameterCS__Group__12555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__0_in_rule__TypeParameterCS__Group__1__Impl2582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__0__Impl_in_rule__TypeParameterCS__Group_1__02617 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__1_in_rule__TypeParameterCS__Group_1__02620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__TypeParameterCS__Group_1__0__Impl2648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__1__Impl_in_rule__TypeParameterCS__Group_1__12679 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__2_in_rule__TypeParameterCS__Group_1__12682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_1_in_rule__TypeParameterCS__Group_1__1__Impl2709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__2__Impl_in_rule__TypeParameterCS__Group_1__22739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_2__0_in_rule__TypeParameterCS__Group_1__2__Impl2766 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_2__0__Impl_in_rule__TypeParameterCS__Group_1_2__02803 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_2__1_in_rule__TypeParameterCS__Group_1_2__02806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__TypeParameterCS__Group_1_2__0__Impl2834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_2__1__Impl_in_rule__TypeParameterCS__Group_1_2__12865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1_in_rule__TypeParameterCS__Group_1_2__1__Impl2892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__0__Impl_in_rule__WildcardTypeRefCS__Group__02926 = new BitSet(new long[]{0x0000000000040060L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__1_in_rule__WildcardTypeRefCS__Group__02929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__1__Impl_in_rule__WildcardTypeRefCS__Group__12987 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__2_in_rule__WildcardTypeRefCS__Group__12990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__WildcardTypeRefCS__Group__1__Impl3018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__2__Impl_in_rule__WildcardTypeRefCS__Group__23049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2__0_in_rule__WildcardTypeRefCS__Group__2__Impl3076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2__0__Impl_in_rule__WildcardTypeRefCS__Group_2__03113 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2__1_in_rule__WildcardTypeRefCS__Group_2__03116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__WildcardTypeRefCS__Group_2__0__Impl3144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2__1__Impl_in_rule__WildcardTypeRefCS__Group_2__13175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1_in_rule__WildcardTypeRefCS__Group_2__1__Impl3202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_rule__MultiplicityBoundsCS__LowerBoundAssignment_03241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_13272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityStringCS__StringBoundsAlternatives_0_in_rule__MultiplicityStringCS__StringBoundsAssignment3304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_03337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_1_13368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_rule__FirstPathElementCS__ReferredElementAssignment3403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_rule__NextPathElementCS__ReferredElementAssignment3442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_rule__PathTypeCS__OwnedPathNameAssignment_03477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_rule__PathTypeCS__OwnedBindingAssignment_1_13508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_03539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_13570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterActualCS_in_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment3601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_rule__TypeParameterCS__NameAssignment_03634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleTypeCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_13665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleTypeCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_2_13696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleTypeCS_in_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_13727 = new BitSet(new long[]{0x0000000000000002L});
    }


}