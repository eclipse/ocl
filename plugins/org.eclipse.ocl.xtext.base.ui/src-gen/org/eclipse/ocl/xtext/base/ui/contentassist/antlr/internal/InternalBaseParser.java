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


    // $ANTLR start "entryRuleTypeParameterCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:345:1: entryRuleTypeParameterCS : ruleTypeParameterCS EOF ;
    public final void entryRuleTypeParameterCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:346:1: ( ruleTypeParameterCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:347:1: ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS669);
            ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeParameterCS676); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:354:1: ruleTypeParameterCS : ( ( rule__TypeParameterCS__Group__0 ) ) ;
    public final void ruleTypeParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:358:2: ( ( ( rule__TypeParameterCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:359:1: ( ( rule__TypeParameterCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:359:1: ( ( rule__TypeParameterCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:360:1: ( rule__TypeParameterCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:361:1: ( rule__TypeParameterCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:361:2: rule__TypeParameterCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__0_in_ruleTypeParameterCS702);
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


    // $ANTLR start "entryRuleTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:373:1: entryRuleTypeRefCS : ruleTypeRefCS EOF ;
    public final void entryRuleTypeRefCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:374:1: ( ruleTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:375:1: ruleTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS729);
            ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRefCS736); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTypeRefCS"


    // $ANTLR start "ruleTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:382:1: ruleTypeRefCS : ( ( rule__TypeRefCS__Alternatives ) ) ;
    public final void ruleTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:386:2: ( ( ( rule__TypeRefCS__Alternatives ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:387:1: ( ( rule__TypeRefCS__Alternatives ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:387:1: ( ( rule__TypeRefCS__Alternatives ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:388:1: ( rule__TypeRefCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefCSAccess().getAlternatives()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:389:1: ( rule__TypeRefCS__Alternatives )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:389:2: rule__TypeRefCS__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRefCS__Alternatives_in_ruleTypeRefCS762);
            rule__TypeRefCS__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefCSAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeRefCS"


    // $ANTLR start "entryRuleUnreservedName"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:401:1: entryRuleUnreservedName : ruleUnreservedName EOF ;
    public final void entryRuleUnreservedName() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:402:1: ( ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:403:1: ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName789);
            ruleUnreservedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnreservedNameRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName796); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:410:1: ruleUnreservedName : ( ruleUnrestrictedName ) ;
    public final void ruleUnreservedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:414:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:415:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:415:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:416:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnreservedNameAccess().getUnrestrictedNameParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName822);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:429:1: entryRuleUnrestrictedName : ruleUnrestrictedName EOF ;
    public final void entryRuleUnrestrictedName() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:430:1: ( ruleUnrestrictedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:431:1: ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName848);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnrestrictedNameRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName855); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:438:1: ruleUnrestrictedName : ( ruleIdentifier ) ;
    public final void ruleUnrestrictedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:442:2: ( ( ruleIdentifier ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:443:1: ( ruleIdentifier )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:443:1: ( ruleIdentifier )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:444:1: ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleUnrestrictedName881);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:457:1: entryRuleWildcardTypeRefCS : ruleWildcardTypeRefCS EOF ;
    public final void entryRuleWildcardTypeRefCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:458:1: ( ruleWildcardTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:459:1: ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS907);
            ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcardTypeRefCS914); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:466:1: ruleWildcardTypeRefCS : ( ( rule__WildcardTypeRefCS__Group__0 ) ) ;
    public final void ruleWildcardTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:470:2: ( ( ( rule__WildcardTypeRefCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:471:1: ( ( rule__WildcardTypeRefCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:471:1: ( ( rule__WildcardTypeRefCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:472:1: ( rule__WildcardTypeRefCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:473:1: ( rule__WildcardTypeRefCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:473:2: rule__WildcardTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__0_in_ruleWildcardTypeRefCS940);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:485:1: entryRuleID : ruleID EOF ;
    public final void entryRuleID() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:486:1: ( ruleID EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:487:1: ruleID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID967);
            ruleID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID974); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:494:1: ruleID : ( ( rule__ID__Alternatives ) ) ;
    public final void ruleID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:498:2: ( ( ( rule__ID__Alternatives ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:499:1: ( ( rule__ID__Alternatives ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:499:1: ( ( rule__ID__Alternatives ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:500:1: ( rule__ID__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDAccess().getAlternatives()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:501:1: ( rule__ID__Alternatives )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:501:2: rule__ID__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ID__Alternatives_in_ruleID1000);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:513:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:514:1: ( ruleIdentifier EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:515:1: ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier1027);
            ruleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentifierRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier1034); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:522:1: ruleIdentifier : ( ruleID ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:526:2: ( ( ruleID ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:527:1: ( ruleID )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:527:1: ( ruleID )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:528:1: ruleID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier1060);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:541:1: entryRuleLOWER : ruleLOWER EOF ;
    public final void entryRuleLOWER() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:542:1: ( ruleLOWER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:543:1: ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER1086);
            ruleLOWER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLOWERRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER1093); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:550:1: ruleLOWER : ( RULE_INT ) ;
    public final void ruleLOWER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:554:2: ( ( RULE_INT ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:555:1: ( RULE_INT )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:555:1: ( RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:556:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER1119); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:573:1: entryRuleUPPER : ruleUPPER EOF ;
    public final void entryRuleUPPER() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:574:1: ( ruleUPPER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:575:1: ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER1149);
            ruleUPPER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUPPERRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER1156); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:582:1: ruleUPPER : ( ( rule__UPPER__Alternatives ) ) ;
    public final void ruleUPPER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:586:2: ( ( ( rule__UPPER__Alternatives ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:587:1: ( ( rule__UPPER__Alternatives ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:587:1: ( ( rule__UPPER__Alternatives ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:588:1: ( rule__UPPER__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUPPERAccess().getAlternatives()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:589:1: ( rule__UPPER__Alternatives )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:589:2: rule__UPPER__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__UPPER__Alternatives_in_ruleUPPER1182);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:605:1: rule__MultiplicityStringCS__StringBoundsAlternatives_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );
    public final void rule__MultiplicityStringCS__StringBoundsAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:609:1: ( ( '*' ) | ( '+' ) | ( '?' ) )
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
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:610:1: ( '*' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:610:1: ( '*' )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:611:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01223); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:618:6: ( '+' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:618:6: ( '+' )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:619:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); 
                    }
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01243); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:626:6: ( '?' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:626:6: ( '?' )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:627:1: '?'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2()); 
                    }
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01263); if (state.failed) return ;
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


    // $ANTLR start "rule__TypeRefCS__Alternatives"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:639:1: rule__TypeRefCS__Alternatives : ( ( ruleSimpleTypeCS ) | ( ruleWildcardTypeRefCS ) );
    public final void rule__TypeRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:643:1: ( ( ruleSimpleTypeCS ) | ( ruleWildcardTypeRefCS ) )
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
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:644:1: ( ruleSimpleTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:644:1: ( ruleSimpleTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:645:1: ruleSimpleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRefCSAccess().getSimpleTypeCSParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeCS_in_rule__TypeRefCS__Alternatives1297);
                    ruleSimpleTypeCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRefCSAccess().getSimpleTypeCSParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:650:6: ( ruleWildcardTypeRefCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:650:6: ( ruleWildcardTypeRefCS )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:651:1: ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_rule__TypeRefCS__Alternatives1314);
                    ruleWildcardTypeRefCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
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
    // $ANTLR end "rule__TypeRefCS__Alternatives"


    // $ANTLR start "rule__ID__Alternatives"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:661:1: rule__ID__Alternatives : ( ( RULE_SIMPLE_ID ) | ( RULE_ESCAPED_ID ) );
    public final void rule__ID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:665:1: ( ( RULE_SIMPLE_ID ) | ( RULE_ESCAPED_ID ) )
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
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:666:1: ( RULE_SIMPLE_ID )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:666:1: ( RULE_SIMPLE_ID )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:667:1: RULE_SIMPLE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                    }
                    match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_rule__ID__Alternatives1346); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:672:6: ( RULE_ESCAPED_ID )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:672:6: ( RULE_ESCAPED_ID )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:673:1: RULE_ESCAPED_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1()); 
                    }
                    match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_rule__ID__Alternatives1363); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:683:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UPPER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:687:1: ( ( RULE_INT ) | ( '*' ) )
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
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:688:1: ( RULE_INT )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:688:1: ( RULE_INT )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:689:1: RULE_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1395); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:694:6: ( '*' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:694:6: ( '*' )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:695:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__UPPER__Alternatives1413); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:709:1: rule__MultiplicityBoundsCS__Group__0 : rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1 ;
    public final void rule__MultiplicityBoundsCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:713:1: ( rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:714:2: rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__0__Impl_in_rule__MultiplicityBoundsCS__Group__01445);
            rule__MultiplicityBoundsCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__1_in_rule__MultiplicityBoundsCS__Group__01448);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:721:1: rule__MultiplicityBoundsCS__Group__0__Impl : ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) ) ;
    public final void rule__MultiplicityBoundsCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:725:1: ( ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:726:1: ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:726:1: ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:727:1: ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:728:1: ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:728:2: rule__MultiplicityBoundsCS__LowerBoundAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__LowerBoundAssignment_0_in_rule__MultiplicityBoundsCS__Group__0__Impl1475);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:738:1: rule__MultiplicityBoundsCS__Group__1 : rule__MultiplicityBoundsCS__Group__1__Impl ;
    public final void rule__MultiplicityBoundsCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:742:1: ( rule__MultiplicityBoundsCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:743:2: rule__MultiplicityBoundsCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__1__Impl_in_rule__MultiplicityBoundsCS__Group__11505);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:749:1: rule__MultiplicityBoundsCS__Group__1__Impl : ( ( rule__MultiplicityBoundsCS__Group_1__0 )? ) ;
    public final void rule__MultiplicityBoundsCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:753:1: ( ( ( rule__MultiplicityBoundsCS__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:754:1: ( ( rule__MultiplicityBoundsCS__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:754:1: ( ( rule__MultiplicityBoundsCS__Group_1__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:755:1: ( rule__MultiplicityBoundsCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:756:1: ( rule__MultiplicityBoundsCS__Group_1__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:756:2: rule__MultiplicityBoundsCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__0_in_rule__MultiplicityBoundsCS__Group__1__Impl1532);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:770:1: rule__MultiplicityBoundsCS__Group_1__0 : rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1 ;
    public final void rule__MultiplicityBoundsCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:774:1: ( rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:775:2: rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__0__Impl_in_rule__MultiplicityBoundsCS__Group_1__01567);
            rule__MultiplicityBoundsCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__1_in_rule__MultiplicityBoundsCS__Group_1__01570);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:782:1: rule__MultiplicityBoundsCS__Group_1__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityBoundsCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:786:1: ( ( '..' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:787:1: ( '..' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:787:1: ( '..' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:788:1: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__MultiplicityBoundsCS__Group_1__0__Impl1598); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:801:1: rule__MultiplicityBoundsCS__Group_1__1 : rule__MultiplicityBoundsCS__Group_1__1__Impl ;
    public final void rule__MultiplicityBoundsCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:805:1: ( rule__MultiplicityBoundsCS__Group_1__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:806:2: rule__MultiplicityBoundsCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__1__Impl_in_rule__MultiplicityBoundsCS__Group_1__11629);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:812:1: rule__MultiplicityBoundsCS__Group_1__1__Impl : ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) ) ;
    public final void rule__MultiplicityBoundsCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:816:1: ( ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:817:1: ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:817:1: ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:818:1: ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:819:1: ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:819:2: rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1_in_rule__MultiplicityBoundsCS__Group_1__1__Impl1656);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:834:1: rule__PathNameCS__Group__0 : rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 ;
    public final void rule__PathNameCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:838:1: ( rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:839:2: rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__0__Impl_in_rule__PathNameCS__Group__01691);
            rule__PathNameCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__1_in_rule__PathNameCS__Group__01694);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:846:1: rule__PathNameCS__Group__0__Impl : ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) ) ;
    public final void rule__PathNameCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:850:1: ( ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:851:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:851:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:852:1: ( rule__PathNameCS__OwnedPathElementsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:853:1: ( rule__PathNameCS__OwnedPathElementsAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:853:2: rule__PathNameCS__OwnedPathElementsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_0_in_rule__PathNameCS__Group__0__Impl1721);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:863:1: rule__PathNameCS__Group__1 : rule__PathNameCS__Group__1__Impl ;
    public final void rule__PathNameCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:867:1: ( rule__PathNameCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:868:2: rule__PathNameCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__1__Impl_in_rule__PathNameCS__Group__11751);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:874:1: rule__PathNameCS__Group__1__Impl : ( ( rule__PathNameCS__Group_1__0 )* ) ;
    public final void rule__PathNameCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:878:1: ( ( ( rule__PathNameCS__Group_1__0 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:879:1: ( ( rule__PathNameCS__Group_1__0 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:879:1: ( ( rule__PathNameCS__Group_1__0 )* )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:880:1: ( rule__PathNameCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:881:1: ( rule__PathNameCS__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:881:2: rule__PathNameCS__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__0_in_rule__PathNameCS__Group__1__Impl1778);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:895:1: rule__PathNameCS__Group_1__0 : rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 ;
    public final void rule__PathNameCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:899:1: ( rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:900:2: rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__0__Impl_in_rule__PathNameCS__Group_1__01813);
            rule__PathNameCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__1_in_rule__PathNameCS__Group_1__01816);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:907:1: rule__PathNameCS__Group_1__0__Impl : ( '::' ) ;
    public final void rule__PathNameCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:911:1: ( ( '::' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:912:1: ( '::' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:912:1: ( '::' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:913:1: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__PathNameCS__Group_1__0__Impl1844); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:926:1: rule__PathNameCS__Group_1__1 : rule__PathNameCS__Group_1__1__Impl ;
    public final void rule__PathNameCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:930:1: ( rule__PathNameCS__Group_1__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:931:2: rule__PathNameCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__1__Impl_in_rule__PathNameCS__Group_1__11875);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:937:1: rule__PathNameCS__Group_1__1__Impl : ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) ) ;
    public final void rule__PathNameCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:941:1: ( ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:942:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:942:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:943:1: ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:944:1: ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:944:2: rule__PathNameCS__OwnedPathElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_1_1_in_rule__PathNameCS__Group_1__1__Impl1902);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:958:1: rule__PathTypeCS__Group__0 : rule__PathTypeCS__Group__0__Impl rule__PathTypeCS__Group__1 ;
    public final void rule__PathTypeCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:962:1: ( rule__PathTypeCS__Group__0__Impl rule__PathTypeCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:963:2: rule__PathTypeCS__Group__0__Impl rule__PathTypeCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group__0__Impl_in_rule__PathTypeCS__Group__01936);
            rule__PathTypeCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group__1_in_rule__PathTypeCS__Group__01939);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:970:1: rule__PathTypeCS__Group__0__Impl : ( ( rule__PathTypeCS__OwnedPathNameAssignment_0 ) ) ;
    public final void rule__PathTypeCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:974:1: ( ( ( rule__PathTypeCS__OwnedPathNameAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:975:1: ( ( rule__PathTypeCS__OwnedPathNameAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:975:1: ( ( rule__PathTypeCS__OwnedPathNameAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:976:1: ( rule__PathTypeCS__OwnedPathNameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getOwnedPathNameAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:977:1: ( rule__PathTypeCS__OwnedPathNameAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:977:2: rule__PathTypeCS__OwnedPathNameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__OwnedPathNameAssignment_0_in_rule__PathTypeCS__Group__0__Impl1966);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:987:1: rule__PathTypeCS__Group__1 : rule__PathTypeCS__Group__1__Impl ;
    public final void rule__PathTypeCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:991:1: ( rule__PathTypeCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:992:2: rule__PathTypeCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group__1__Impl_in_rule__PathTypeCS__Group__11996);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:998:1: rule__PathTypeCS__Group__1__Impl : ( ( rule__PathTypeCS__Group_1__0 )? ) ;
    public final void rule__PathTypeCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1002:1: ( ( ( rule__PathTypeCS__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1003:1: ( ( rule__PathTypeCS__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1003:1: ( ( rule__PathTypeCS__Group_1__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1004:1: ( rule__PathTypeCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1005:1: ( rule__PathTypeCS__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1005:2: rule__PathTypeCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group_1__0_in_rule__PathTypeCS__Group__1__Impl2023);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1019:1: rule__PathTypeCS__Group_1__0 : rule__PathTypeCS__Group_1__0__Impl rule__PathTypeCS__Group_1__1 ;
    public final void rule__PathTypeCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1023:1: ( rule__PathTypeCS__Group_1__0__Impl rule__PathTypeCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1024:2: rule__PathTypeCS__Group_1__0__Impl rule__PathTypeCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group_1__0__Impl_in_rule__PathTypeCS__Group_1__02058);
            rule__PathTypeCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group_1__1_in_rule__PathTypeCS__Group_1__02061);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1031:1: rule__PathTypeCS__Group_1__0__Impl : ( '(' ) ;
    public final void rule__PathTypeCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1035:1: ( ( '(' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1036:1: ( '(' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1036:1: ( '(' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1037:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getLeftParenthesisKeyword_1_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__PathTypeCS__Group_1__0__Impl2089); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1050:1: rule__PathTypeCS__Group_1__1 : rule__PathTypeCS__Group_1__1__Impl rule__PathTypeCS__Group_1__2 ;
    public final void rule__PathTypeCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1054:1: ( rule__PathTypeCS__Group_1__1__Impl rule__PathTypeCS__Group_1__2 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1055:2: rule__PathTypeCS__Group_1__1__Impl rule__PathTypeCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group_1__1__Impl_in_rule__PathTypeCS__Group_1__12120);
            rule__PathTypeCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group_1__2_in_rule__PathTypeCS__Group_1__12123);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1062:1: rule__PathTypeCS__Group_1__1__Impl : ( ( rule__PathTypeCS__OwnedBindingAssignment_1_1 ) ) ;
    public final void rule__PathTypeCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1066:1: ( ( ( rule__PathTypeCS__OwnedBindingAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1067:1: ( ( rule__PathTypeCS__OwnedBindingAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1067:1: ( ( rule__PathTypeCS__OwnedBindingAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1068:1: ( rule__PathTypeCS__OwnedBindingAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getOwnedBindingAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1069:1: ( rule__PathTypeCS__OwnedBindingAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1069:2: rule__PathTypeCS__OwnedBindingAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__OwnedBindingAssignment_1_1_in_rule__PathTypeCS__Group_1__1__Impl2150);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1079:1: rule__PathTypeCS__Group_1__2 : rule__PathTypeCS__Group_1__2__Impl ;
    public final void rule__PathTypeCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1083:1: ( rule__PathTypeCS__Group_1__2__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1084:2: rule__PathTypeCS__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathTypeCS__Group_1__2__Impl_in_rule__PathTypeCS__Group_1__22180);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1090:1: rule__PathTypeCS__Group_1__2__Impl : ( ')' ) ;
    public final void rule__PathTypeCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1094:1: ( ( ')' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1095:1: ( ')' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1095:1: ( ')' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1096:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getRightParenthesisKeyword_1_2()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__PathTypeCS__Group_1__2__Impl2208); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1115:1: rule__TemplateBindingCS__Group__0 : rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1 ;
    public final void rule__TemplateBindingCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1119:1: ( rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1120:2: rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__0__Impl_in_rule__TemplateBindingCS__Group__02245);
            rule__TemplateBindingCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__1_in_rule__TemplateBindingCS__Group__02248);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1127:1: rule__TemplateBindingCS__Group__0__Impl : ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) ) ;
    public final void rule__TemplateBindingCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1131:1: ( ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1132:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1132:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1133:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1134:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1134:2: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0_in_rule__TemplateBindingCS__Group__0__Impl2275);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1144:1: rule__TemplateBindingCS__Group__1 : rule__TemplateBindingCS__Group__1__Impl ;
    public final void rule__TemplateBindingCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1148:1: ( rule__TemplateBindingCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1149:2: rule__TemplateBindingCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__1__Impl_in_rule__TemplateBindingCS__Group__12305);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1155:1: rule__TemplateBindingCS__Group__1__Impl : ( ( rule__TemplateBindingCS__Group_1__0 )* ) ;
    public final void rule__TemplateBindingCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1159:1: ( ( ( rule__TemplateBindingCS__Group_1__0 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1160:1: ( ( rule__TemplateBindingCS__Group_1__0 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1160:1: ( ( rule__TemplateBindingCS__Group_1__0 )* )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1161:1: ( rule__TemplateBindingCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1162:1: ( rule__TemplateBindingCS__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==23) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1162:2: rule__TemplateBindingCS__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_1__0_in_rule__TemplateBindingCS__Group__1__Impl2332);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1176:1: rule__TemplateBindingCS__Group_1__0 : rule__TemplateBindingCS__Group_1__0__Impl rule__TemplateBindingCS__Group_1__1 ;
    public final void rule__TemplateBindingCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1180:1: ( rule__TemplateBindingCS__Group_1__0__Impl rule__TemplateBindingCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1181:2: rule__TemplateBindingCS__Group_1__0__Impl rule__TemplateBindingCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_1__0__Impl_in_rule__TemplateBindingCS__Group_1__02367);
            rule__TemplateBindingCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_1__1_in_rule__TemplateBindingCS__Group_1__02370);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1188:1: rule__TemplateBindingCS__Group_1__0__Impl : ( ',' ) ;
    public final void rule__TemplateBindingCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1192:1: ( ( ',' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1193:1: ( ',' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1193:1: ( ',' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1194:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0()); 
            }
            match(input,23,FollowSets000.FOLLOW_23_in_rule__TemplateBindingCS__Group_1__0__Impl2398); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1207:1: rule__TemplateBindingCS__Group_1__1 : rule__TemplateBindingCS__Group_1__1__Impl ;
    public final void rule__TemplateBindingCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1211:1: ( rule__TemplateBindingCS__Group_1__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1212:2: rule__TemplateBindingCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_1__1__Impl_in_rule__TemplateBindingCS__Group_1__12429);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1218:1: rule__TemplateBindingCS__Group_1__1__Impl : ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) ) ;
    public final void rule__TemplateBindingCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1222:1: ( ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1223:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1223:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1224:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1225:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1225:2: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1_in_rule__TemplateBindingCS__Group_1__1__Impl2456);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1241:1: rule__TypeParameterCS__Group__0 : rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1 ;
    public final void rule__TypeParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1245:1: ( rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1246:2: rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__0__Impl_in_rule__TypeParameterCS__Group__02492);
            rule__TypeParameterCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__1_in_rule__TypeParameterCS__Group__02495);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1253:1: rule__TypeParameterCS__Group__0__Impl : ( ( rule__TypeParameterCS__NameAssignment_0 ) ) ;
    public final void rule__TypeParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1257:1: ( ( ( rule__TypeParameterCS__NameAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1258:1: ( ( rule__TypeParameterCS__NameAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1258:1: ( ( rule__TypeParameterCS__NameAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1259:1: ( rule__TypeParameterCS__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getNameAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1260:1: ( rule__TypeParameterCS__NameAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1260:2: rule__TypeParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__NameAssignment_0_in_rule__TypeParameterCS__Group__0__Impl2522);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1270:1: rule__TypeParameterCS__Group__1 : rule__TypeParameterCS__Group__1__Impl ;
    public final void rule__TypeParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1274:1: ( rule__TypeParameterCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1275:2: rule__TypeParameterCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__1__Impl_in_rule__TypeParameterCS__Group__12552);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1281:1: rule__TypeParameterCS__Group__1__Impl : ( ( rule__TypeParameterCS__Group_1__0 )? ) ;
    public final void rule__TypeParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1285:1: ( ( ( rule__TypeParameterCS__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1286:1: ( ( rule__TypeParameterCS__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1286:1: ( ( rule__TypeParameterCS__Group_1__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1287:1: ( rule__TypeParameterCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1288:1: ( rule__TypeParameterCS__Group_1__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1288:2: rule__TypeParameterCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__0_in_rule__TypeParameterCS__Group__1__Impl2579);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1302:1: rule__TypeParameterCS__Group_1__0 : rule__TypeParameterCS__Group_1__0__Impl rule__TypeParameterCS__Group_1__1 ;
    public final void rule__TypeParameterCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1306:1: ( rule__TypeParameterCS__Group_1__0__Impl rule__TypeParameterCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1307:2: rule__TypeParameterCS__Group_1__0__Impl rule__TypeParameterCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__0__Impl_in_rule__TypeParameterCS__Group_1__02614);
            rule__TypeParameterCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__1_in_rule__TypeParameterCS__Group_1__02617);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1314:1: rule__TypeParameterCS__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__TypeParameterCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1318:1: ( ( 'extends' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1319:1: ( 'extends' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1319:1: ( 'extends' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1320:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__TypeParameterCS__Group_1__0__Impl2645); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1333:1: rule__TypeParameterCS__Group_1__1 : rule__TypeParameterCS__Group_1__1__Impl rule__TypeParameterCS__Group_1__2 ;
    public final void rule__TypeParameterCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1337:1: ( rule__TypeParameterCS__Group_1__1__Impl rule__TypeParameterCS__Group_1__2 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1338:2: rule__TypeParameterCS__Group_1__1__Impl rule__TypeParameterCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__1__Impl_in_rule__TypeParameterCS__Group_1__12676);
            rule__TypeParameterCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__2_in_rule__TypeParameterCS__Group_1__12679);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1345:1: rule__TypeParameterCS__Group_1__1__Impl : ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) ) ;
    public final void rule__TypeParameterCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1349:1: ( ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1350:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1350:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1351:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1352:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1352:2: rule__TypeParameterCS__OwnedExtendsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_1_in_rule__TypeParameterCS__Group_1__1__Impl2706);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1362:1: rule__TypeParameterCS__Group_1__2 : rule__TypeParameterCS__Group_1__2__Impl ;
    public final void rule__TypeParameterCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1366:1: ( rule__TypeParameterCS__Group_1__2__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1367:2: rule__TypeParameterCS__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__2__Impl_in_rule__TypeParameterCS__Group_1__22736);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1373:1: rule__TypeParameterCS__Group_1__2__Impl : ( ( rule__TypeParameterCS__Group_1_2__0 )* ) ;
    public final void rule__TypeParameterCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1377:1: ( ( ( rule__TypeParameterCS__Group_1_2__0 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1378:1: ( ( rule__TypeParameterCS__Group_1_2__0 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1378:1: ( ( rule__TypeParameterCS__Group_1_2__0 )* )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1379:1: ( rule__TypeParameterCS__Group_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup_1_2()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1380:1: ( rule__TypeParameterCS__Group_1_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==25) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1380:2: rule__TypeParameterCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_2__0_in_rule__TypeParameterCS__Group_1__2__Impl2763);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1396:1: rule__TypeParameterCS__Group_1_2__0 : rule__TypeParameterCS__Group_1_2__0__Impl rule__TypeParameterCS__Group_1_2__1 ;
    public final void rule__TypeParameterCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1400:1: ( rule__TypeParameterCS__Group_1_2__0__Impl rule__TypeParameterCS__Group_1_2__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1401:2: rule__TypeParameterCS__Group_1_2__0__Impl rule__TypeParameterCS__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_2__0__Impl_in_rule__TypeParameterCS__Group_1_2__02800);
            rule__TypeParameterCS__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_2__1_in_rule__TypeParameterCS__Group_1_2__02803);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1408:1: rule__TypeParameterCS__Group_1_2__0__Impl : ( '&&' ) ;
    public final void rule__TypeParameterCS__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1412:1: ( ( '&&' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1413:1: ( '&&' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1413:1: ( '&&' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1414:1: '&&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__TypeParameterCS__Group_1_2__0__Impl2831); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1427:1: rule__TypeParameterCS__Group_1_2__1 : rule__TypeParameterCS__Group_1_2__1__Impl ;
    public final void rule__TypeParameterCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1431:1: ( rule__TypeParameterCS__Group_1_2__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1432:2: rule__TypeParameterCS__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_2__1__Impl_in_rule__TypeParameterCS__Group_1_2__12862);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1438:1: rule__TypeParameterCS__Group_1_2__1__Impl : ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) ) ;
    public final void rule__TypeParameterCS__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1442:1: ( ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1443:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1443:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1444:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_2_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1445:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1445:2: rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1_in_rule__TypeParameterCS__Group_1_2__1__Impl2889);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1459:1: rule__WildcardTypeRefCS__Group__0 : rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1 ;
    public final void rule__WildcardTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1463:1: ( rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1464:2: rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__0__Impl_in_rule__WildcardTypeRefCS__Group__02923);
            rule__WildcardTypeRefCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__1_in_rule__WildcardTypeRefCS__Group__02926);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1471:1: rule__WildcardTypeRefCS__Group__0__Impl : ( () ) ;
    public final void rule__WildcardTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1475:1: ( ( () ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1476:1: ( () )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1476:1: ( () )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1477:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1478:1: ()
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1480:1: 
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1490:1: rule__WildcardTypeRefCS__Group__1 : rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2 ;
    public final void rule__WildcardTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1494:1: ( rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1495:2: rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__1__Impl_in_rule__WildcardTypeRefCS__Group__12984);
            rule__WildcardTypeRefCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__2_in_rule__WildcardTypeRefCS__Group__12987);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1502:1: rule__WildcardTypeRefCS__Group__1__Impl : ( '?' ) ;
    public final void rule__WildcardTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1506:1: ( ( '?' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1507:1: ( '?' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1507:1: ( '?' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1508:1: '?'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__WildcardTypeRefCS__Group__1__Impl3015); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1521:1: rule__WildcardTypeRefCS__Group__2 : rule__WildcardTypeRefCS__Group__2__Impl ;
    public final void rule__WildcardTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1525:1: ( rule__WildcardTypeRefCS__Group__2__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1526:2: rule__WildcardTypeRefCS__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__2__Impl_in_rule__WildcardTypeRefCS__Group__23046);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1532:1: rule__WildcardTypeRefCS__Group__2__Impl : ( ( rule__WildcardTypeRefCS__Group_2__0 )? ) ;
    public final void rule__WildcardTypeRefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1536:1: ( ( ( rule__WildcardTypeRefCS__Group_2__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1537:1: ( ( rule__WildcardTypeRefCS__Group_2__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1537:1: ( ( rule__WildcardTypeRefCS__Group_2__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1538:1: ( rule__WildcardTypeRefCS__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1539:1: ( rule__WildcardTypeRefCS__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1539:2: rule__WildcardTypeRefCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2__0_in_rule__WildcardTypeRefCS__Group__2__Impl3073);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1555:1: rule__WildcardTypeRefCS__Group_2__0 : rule__WildcardTypeRefCS__Group_2__0__Impl rule__WildcardTypeRefCS__Group_2__1 ;
    public final void rule__WildcardTypeRefCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1559:1: ( rule__WildcardTypeRefCS__Group_2__0__Impl rule__WildcardTypeRefCS__Group_2__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1560:2: rule__WildcardTypeRefCS__Group_2__0__Impl rule__WildcardTypeRefCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2__0__Impl_in_rule__WildcardTypeRefCS__Group_2__03110);
            rule__WildcardTypeRefCS__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2__1_in_rule__WildcardTypeRefCS__Group_2__03113);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1567:1: rule__WildcardTypeRefCS__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__WildcardTypeRefCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1571:1: ( ( 'extends' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1572:1: ( 'extends' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1572:1: ( 'extends' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1573:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__WildcardTypeRefCS__Group_2__0__Impl3141); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1586:1: rule__WildcardTypeRefCS__Group_2__1 : rule__WildcardTypeRefCS__Group_2__1__Impl ;
    public final void rule__WildcardTypeRefCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1590:1: ( rule__WildcardTypeRefCS__Group_2__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1591:2: rule__WildcardTypeRefCS__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2__1__Impl_in_rule__WildcardTypeRefCS__Group_2__13172);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1597:1: rule__WildcardTypeRefCS__Group_2__1__Impl : ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) ) ;
    public final void rule__WildcardTypeRefCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1601:1: ( ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1602:1: ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1602:1: ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1603:1: ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1604:1: ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1604:2: rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1_in_rule__WildcardTypeRefCS__Group_2__1__Impl3199);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1619:1: rule__MultiplicityBoundsCS__LowerBoundAssignment_0 : ( ruleLOWER ) ;
    public final void rule__MultiplicityBoundsCS__LowerBoundAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1623:1: ( ( ruleLOWER ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1624:1: ( ruleLOWER )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1624:1: ( ruleLOWER )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1625:1: ruleLOWER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_rule__MultiplicityBoundsCS__LowerBoundAssignment_03238);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1634:1: rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 : ( ruleUPPER ) ;
    public final void rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1638:1: ( ( ruleUPPER ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1639:1: ( ruleUPPER )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1639:1: ( ruleUPPER )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1640:1: ruleUPPER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_13269);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1650:1: rule__MultiplicityStringCS__StringBoundsAssignment : ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) ) ;
    public final void rule__MultiplicityStringCS__StringBoundsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1654:1: ( ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1655:1: ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1655:1: ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1656:1: ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1657:1: ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1657:2: rule__MultiplicityStringCS__StringBoundsAlternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityStringCS__StringBoundsAlternatives_0_in_rule__MultiplicityStringCS__StringBoundsAssignment3301);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1666:1: rule__PathNameCS__OwnedPathElementsAssignment_0 : ( ruleFirstPathElementCS ) ;
    public final void rule__PathNameCS__OwnedPathElementsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1670:1: ( ( ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1671:1: ( ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1671:1: ( ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1672:1: ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_03334);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1681:1: rule__PathNameCS__OwnedPathElementsAssignment_1_1 : ( ruleNextPathElementCS ) ;
    public final void rule__PathNameCS__OwnedPathElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1685:1: ( ( ruleNextPathElementCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1686:1: ( ruleNextPathElementCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1686:1: ( ruleNextPathElementCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1687:1: ruleNextPathElementCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_1_13365);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1696:1: rule__FirstPathElementCS__ReferredElementAssignment : ( ( ruleUnrestrictedName ) ) ;
    public final void rule__FirstPathElementCS__ReferredElementAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1700:1: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1701:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1701:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1702:1: ( ruleUnrestrictedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1703:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1704:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_rule__FirstPathElementCS__ReferredElementAssignment3400);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1715:1: rule__NextPathElementCS__ReferredElementAssignment : ( ( ruleUnreservedName ) ) ;
    public final void rule__NextPathElementCS__ReferredElementAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1719:1: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1720:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1720:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1721:1: ( ruleUnreservedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1722:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1723:1: ruleUnreservedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementUnreservedNameParserRuleCall_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_rule__NextPathElementCS__ReferredElementAssignment3439);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1734:1: rule__PathTypeCS__OwnedPathNameAssignment_0 : ( rulePathNameCS ) ;
    public final void rule__PathTypeCS__OwnedPathNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1738:1: ( ( rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1739:1: ( rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1739:1: ( rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1740:1: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_rule__PathTypeCS__OwnedPathNameAssignment_03474);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1749:1: rule__PathTypeCS__OwnedBindingAssignment_1_1 : ( ruleTemplateBindingCS ) ;
    public final void rule__PathTypeCS__OwnedBindingAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1753:1: ( ( ruleTemplateBindingCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1754:1: ( ruleTemplateBindingCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1754:1: ( ruleTemplateBindingCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1755:1: ruleTemplateBindingCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathTypeCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_rule__PathTypeCS__OwnedBindingAssignment_1_13505);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1764:1: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 : ( ruleTemplateParameterSubstitutionCS ) ;
    public final void rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1768:1: ( ( ruleTemplateParameterSubstitutionCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1769:1: ( ruleTemplateParameterSubstitutionCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1769:1: ( ruleTemplateParameterSubstitutionCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1770:1: ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_03536);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1779:1: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 : ( ruleTemplateParameterSubstitutionCS ) ;
    public final void rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1783:1: ( ( ruleTemplateParameterSubstitutionCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1784:1: ( ruleTemplateParameterSubstitutionCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1784:1: ( ruleTemplateParameterSubstitutionCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1785:1: ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_13567);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1794:1: rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment : ( ruleTypeRefCS ) ;
    public final void rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1798:1: ( ( ruleTypeRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1799:1: ( ruleTypeRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1799:1: ( ruleTypeRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1800:1: ruleTypeRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment3598);
            ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); 
            }

            }


            }

        }
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1811:1: rule__TypeParameterCS__NameAssignment_0 : ( ruleUnrestrictedName ) ;
    public final void rule__TypeParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1815:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1816:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1816:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1817:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_rule__TypeParameterCS__NameAssignment_03631);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1826:1: rule__TypeParameterCS__OwnedExtendsAssignment_1_1 : ( ruleSimpleTypeCS ) ;
    public final void rule__TypeParameterCS__OwnedExtendsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1830:1: ( ( ruleSimpleTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1831:1: ( ruleSimpleTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1831:1: ( ruleSimpleTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1832:1: ruleSimpleTypeCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsSimpleTypeCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_13662);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1841:1: rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 : ( ruleSimpleTypeCS ) ;
    public final void rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1845:1: ( ( ruleSimpleTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1846:1: ( ruleSimpleTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1846:1: ( ruleSimpleTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1847:1: ruleSimpleTypeCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsSimpleTypeCSParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_2_13693);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1856:1: rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 : ( ruleSimpleTypeCS ) ;
    public final void rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1860:1: ( ( ruleSimpleTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1861:1: ( ruleSimpleTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1861:1: ( ruleSimpleTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1862:1: ruleSimpleTypeCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsSimpleTypeCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeCS_in_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_13724);
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
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS669 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameterCS676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__0_in_ruleTypeParameterCS702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS729 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRefCS736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRefCS__Alternatives_in_ruleTypeRefCS762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName789 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName848 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleUnrestrictedName881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS907 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcardTypeRefCS914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__0_in_ruleWildcardTypeRefCS940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID967 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ID__Alternatives_in_ruleID1000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier1027 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier1034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier1060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER1086 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER1093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER1119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER1149 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER1156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UPPER__Alternatives_in_ruleUPPER1182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleTypeCS_in_rule__TypeRefCS__Alternatives1297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_rule__TypeRefCS__Alternatives1314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_rule__ID__Alternatives1346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_rule__ID__Alternatives1363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__UPPER__Alternatives1413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__0__Impl_in_rule__MultiplicityBoundsCS__Group__01445 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__1_in_rule__MultiplicityBoundsCS__Group__01448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__LowerBoundAssignment_0_in_rule__MultiplicityBoundsCS__Group__0__Impl1475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__1__Impl_in_rule__MultiplicityBoundsCS__Group__11505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__0_in_rule__MultiplicityBoundsCS__Group__1__Impl1532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__0__Impl_in_rule__MultiplicityBoundsCS__Group_1__01567 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__1_in_rule__MultiplicityBoundsCS__Group_1__01570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__MultiplicityBoundsCS__Group_1__0__Impl1598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__1__Impl_in_rule__MultiplicityBoundsCS__Group_1__11629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1_in_rule__MultiplicityBoundsCS__Group_1__1__Impl1656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__0__Impl_in_rule__PathNameCS__Group__01691 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__1_in_rule__PathNameCS__Group__01694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_0_in_rule__PathNameCS__Group__0__Impl1721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__1__Impl_in_rule__PathNameCS__Group__11751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__0_in_rule__PathNameCS__Group__1__Impl1778 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__0__Impl_in_rule__PathNameCS__Group_1__01813 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__1_in_rule__PathNameCS__Group_1__01816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__PathNameCS__Group_1__0__Impl1844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__1__Impl_in_rule__PathNameCS__Group_1__11875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_1_1_in_rule__PathNameCS__Group_1__1__Impl1902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group__0__Impl_in_rule__PathTypeCS__Group__01936 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group__1_in_rule__PathTypeCS__Group__01939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__OwnedPathNameAssignment_0_in_rule__PathTypeCS__Group__0__Impl1966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group__1__Impl_in_rule__PathTypeCS__Group__11996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group_1__0_in_rule__PathTypeCS__Group__1__Impl2023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group_1__0__Impl_in_rule__PathTypeCS__Group_1__02058 = new BitSet(new long[]{0x0000000000040060L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group_1__1_in_rule__PathTypeCS__Group_1__02061 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__PathTypeCS__Group_1__0__Impl2089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group_1__1__Impl_in_rule__PathTypeCS__Group_1__12120 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group_1__2_in_rule__PathTypeCS__Group_1__12123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__OwnedBindingAssignment_1_1_in_rule__PathTypeCS__Group_1__1__Impl2150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathTypeCS__Group_1__2__Impl_in_rule__PathTypeCS__Group_1__22180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__PathTypeCS__Group_1__2__Impl2208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__0__Impl_in_rule__TemplateBindingCS__Group__02245 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__1_in_rule__TemplateBindingCS__Group__02248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0_in_rule__TemplateBindingCS__Group__0__Impl2275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__1__Impl_in_rule__TemplateBindingCS__Group__12305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_1__0_in_rule__TemplateBindingCS__Group__1__Impl2332 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_1__0__Impl_in_rule__TemplateBindingCS__Group_1__02367 = new BitSet(new long[]{0x0000000000040060L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_1__1_in_rule__TemplateBindingCS__Group_1__02370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__TemplateBindingCS__Group_1__0__Impl2398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_1__1__Impl_in_rule__TemplateBindingCS__Group_1__12429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1_in_rule__TemplateBindingCS__Group_1__1__Impl2456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__0__Impl_in_rule__TypeParameterCS__Group__02492 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__1_in_rule__TypeParameterCS__Group__02495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__NameAssignment_0_in_rule__TypeParameterCS__Group__0__Impl2522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__1__Impl_in_rule__TypeParameterCS__Group__12552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__0_in_rule__TypeParameterCS__Group__1__Impl2579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__0__Impl_in_rule__TypeParameterCS__Group_1__02614 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__1_in_rule__TypeParameterCS__Group_1__02617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__TypeParameterCS__Group_1__0__Impl2645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__1__Impl_in_rule__TypeParameterCS__Group_1__12676 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__2_in_rule__TypeParameterCS__Group_1__12679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_1_in_rule__TypeParameterCS__Group_1__1__Impl2706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__2__Impl_in_rule__TypeParameterCS__Group_1__22736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_2__0_in_rule__TypeParameterCS__Group_1__2__Impl2763 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_2__0__Impl_in_rule__TypeParameterCS__Group_1_2__02800 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_2__1_in_rule__TypeParameterCS__Group_1_2__02803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__TypeParameterCS__Group_1_2__0__Impl2831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_2__1__Impl_in_rule__TypeParameterCS__Group_1_2__12862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1_in_rule__TypeParameterCS__Group_1_2__1__Impl2889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__0__Impl_in_rule__WildcardTypeRefCS__Group__02923 = new BitSet(new long[]{0x0000000000040060L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__1_in_rule__WildcardTypeRefCS__Group__02926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__1__Impl_in_rule__WildcardTypeRefCS__Group__12984 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__2_in_rule__WildcardTypeRefCS__Group__12987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__WildcardTypeRefCS__Group__1__Impl3015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__2__Impl_in_rule__WildcardTypeRefCS__Group__23046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2__0_in_rule__WildcardTypeRefCS__Group__2__Impl3073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2__0__Impl_in_rule__WildcardTypeRefCS__Group_2__03110 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2__1_in_rule__WildcardTypeRefCS__Group_2__03113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__WildcardTypeRefCS__Group_2__0__Impl3141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2__1__Impl_in_rule__WildcardTypeRefCS__Group_2__13172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1_in_rule__WildcardTypeRefCS__Group_2__1__Impl3199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_rule__MultiplicityBoundsCS__LowerBoundAssignment_03238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_13269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityStringCS__StringBoundsAlternatives_0_in_rule__MultiplicityStringCS__StringBoundsAssignment3301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_03334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_1_13365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_rule__FirstPathElementCS__ReferredElementAssignment3400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_rule__NextPathElementCS__ReferredElementAssignment3439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_rule__PathTypeCS__OwnedPathNameAssignment_03474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_rule__PathTypeCS__OwnedBindingAssignment_1_13505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_03536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_13567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment3598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_rule__TypeParameterCS__NameAssignment_03631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleTypeCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_13662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleTypeCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_2_13693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleTypeCS_in_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_13724 = new BitSet(new long[]{0x0000000000000002L});
    }


}