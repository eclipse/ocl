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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_SINGLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'*'", "'+'", "'?'", "'..'", "'::'", "'('", "')'", "','", "'extends'", "'&&'", "'super'"
    };
    public static final int RULE_ML_SINGLE_QUOTED_STRING=11;
    public static final int T__26=26;
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


    // $ANTLR start "entryRulePathNameCS"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:119:1: entryRulePathNameCS : rulePathNameCS EOF ;
    public final void entryRulePathNameCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:120:1: ( rulePathNameCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:121:1: rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS189);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS196); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:128:1: rulePathNameCS : ( ( rule__PathNameCS__Group__0 ) ) ;
    public final void rulePathNameCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:132:2: ( ( ( rule__PathNameCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:133:1: ( ( rule__PathNameCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:133:1: ( ( rule__PathNameCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:134:1: ( rule__PathNameCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:135:1: ( rule__PathNameCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:135:2: rule__PathNameCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__0_in_rulePathNameCS222);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:147:1: entryRuleFirstPathElementCS : ruleFirstPathElementCS EOF ;
    public final void entryRuleFirstPathElementCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:148:1: ( ruleFirstPathElementCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:149:1: ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS249);
            ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFirstPathElementCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS256); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:156:1: ruleFirstPathElementCS : ( ( rule__FirstPathElementCS__ReferredElementAssignment ) ) ;
    public final void ruleFirstPathElementCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:160:2: ( ( ( rule__FirstPathElementCS__ReferredElementAssignment ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:161:1: ( ( rule__FirstPathElementCS__ReferredElementAssignment ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:161:1: ( ( rule__FirstPathElementCS__ReferredElementAssignment ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:162:1: ( rule__FirstPathElementCS__ReferredElementAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementAssignment()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:163:1: ( rule__FirstPathElementCS__ReferredElementAssignment )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:163:2: rule__FirstPathElementCS__ReferredElementAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstPathElementCS__ReferredElementAssignment_in_ruleFirstPathElementCS282);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:175:1: entryRuleNextPathElementCS : ruleNextPathElementCS EOF ;
    public final void entryRuleNextPathElementCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:176:1: ( ruleNextPathElementCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:177:1: ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS309);
            ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNextPathElementCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS316); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:184:1: ruleNextPathElementCS : ( ( rule__NextPathElementCS__ReferredElementAssignment ) ) ;
    public final void ruleNextPathElementCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:188:2: ( ( ( rule__NextPathElementCS__ReferredElementAssignment ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:189:1: ( ( rule__NextPathElementCS__ReferredElementAssignment ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:189:1: ( ( rule__NextPathElementCS__ReferredElementAssignment ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:190:1: ( rule__NextPathElementCS__ReferredElementAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementAssignment()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:191:1: ( rule__NextPathElementCS__ReferredElementAssignment )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:191:2: rule__NextPathElementCS__ReferredElementAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__NextPathElementCS__ReferredElementAssignment_in_ruleNextPathElementCS342);
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


    // $ANTLR start "entryRuleTemplateBindingCS"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:203:1: entryRuleTemplateBindingCS : ruleTemplateBindingCS EOF ;
    public final void entryRuleTemplateBindingCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:204:1: ( ruleTemplateBindingCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:205:1: ruleTemplateBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS369);
            ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateBindingCS376); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:212:1: ruleTemplateBindingCS : ( ( rule__TemplateBindingCS__Group__0 ) ) ;
    public final void ruleTemplateBindingCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:216:2: ( ( ( rule__TemplateBindingCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:217:1: ( ( rule__TemplateBindingCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:217:1: ( ( rule__TemplateBindingCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:218:1: ( rule__TemplateBindingCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:219:1: ( rule__TemplateBindingCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:219:2: rule__TemplateBindingCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__0_in_ruleTemplateBindingCS402);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:231:1: entryRuleTemplateParameterSubstitutionCS : ruleTemplateParameterSubstitutionCS EOF ;
    public final void entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:232:1: ( ruleTemplateParameterSubstitutionCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:233:1: ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS429);
            ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS436); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:240:1: ruleTemplateParameterSubstitutionCS : ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) ) ;
    public final void ruleTemplateParameterSubstitutionCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:244:2: ( ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:245:1: ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:245:1: ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:246:1: ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterAssignment()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:247:1: ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:247:2: rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment_in_ruleTemplateParameterSubstitutionCS462);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:261:1: entryRuleTypeParameterCS : ruleTypeParameterCS EOF ;
    public final void entryRuleTypeParameterCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:262:1: ( ruleTypeParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:263:1: ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS491);
            ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeParameterCS498); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:270:1: ruleTypeParameterCS : ( ( rule__TypeParameterCS__Group__0 ) ) ;
    public final void ruleTypeParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:274:2: ( ( ( rule__TypeParameterCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:275:1: ( ( rule__TypeParameterCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:275:1: ( ( rule__TypeParameterCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:276:1: ( rule__TypeParameterCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:277:1: ( rule__TypeParameterCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:277:2: rule__TypeParameterCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__0_in_ruleTypeParameterCS524);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:289:1: entryRuleTypeRefCS : ruleTypeRefCS EOF ;
    public final void entryRuleTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:290:1: ( ruleTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:291:1: ruleTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS551);
            ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRefCS558); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:298:1: ruleTypeRefCS : ( ( rule__TypeRefCS__Alternatives ) ) ;
    public final void ruleTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:302:2: ( ( ( rule__TypeRefCS__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:303:1: ( ( rule__TypeRefCS__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:303:1: ( ( rule__TypeRefCS__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:304:1: ( rule__TypeRefCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefCSAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:305:1: ( rule__TypeRefCS__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:305:2: rule__TypeRefCS__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRefCS__Alternatives_in_ruleTypeRefCS584);
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


    // $ANTLR start "entryRuleTypedRefCS"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:317:1: entryRuleTypedRefCS : ruleTypedRefCS EOF ;
    public final void entryRuleTypedRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:318:1: ( ruleTypedRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:319:1: ruleTypedRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS611);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedRefCS618); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTypedRefCS"


    // $ANTLR start "ruleTypedRefCS"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:326:1: ruleTypedRefCS : ( ruleTypedTypeRefCS ) ;
    public final void ruleTypedRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:330:2: ( ( ruleTypedTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:331:1: ( ruleTypedTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:331:1: ( ruleTypedTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:332:1: ruleTypedTypeRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS644);
            ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypedRefCS"


    // $ANTLR start "entryRuleTypedTypeRefCS"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:345:1: entryRuleTypedTypeRefCS : ruleTypedTypeRefCS EOF ;
    public final void entryRuleTypedTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:346:1: ( ruleTypedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:347:1: ruleTypedTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS670);
            ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedTypeRefCS677); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTypedTypeRefCS"


    // $ANTLR start "ruleTypedTypeRefCS"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:354:1: ruleTypedTypeRefCS : ( ( rule__TypedTypeRefCS__Group__0 ) ) ;
    public final void ruleTypedTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:358:2: ( ( ( rule__TypedTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:359:1: ( ( rule__TypedTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:359:1: ( ( rule__TypedTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:360:1: ( rule__TypedTypeRefCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:361:1: ( rule__TypedTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:361:2: rule__TypedTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group__0_in_ruleTypedTypeRefCS703);
            rule__TypedTypeRefCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypedTypeRefCS"


    // $ANTLR start "entryRuleUnreservedName"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:373:1: entryRuleUnreservedName : ruleUnreservedName EOF ;
    public final void entryRuleUnreservedName() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:374:1: ( ruleUnreservedName EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:375:1: ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName730);
            ruleUnreservedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnreservedNameRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName737); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:382:1: ruleUnreservedName : ( ruleUnrestrictedName ) ;
    public final void ruleUnreservedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:386:2: ( ( ruleUnrestrictedName ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:387:1: ( ruleUnrestrictedName )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:387:1: ( ruleUnrestrictedName )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:388:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnreservedNameAccess().getUnrestrictedNameParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName763);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:401:1: entryRuleUnrestrictedName : ruleUnrestrictedName EOF ;
    public final void entryRuleUnrestrictedName() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:402:1: ( ruleUnrestrictedName EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:403:1: ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName789);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnrestrictedNameRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName796); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:410:1: ruleUnrestrictedName : ( ruleIdentifier ) ;
    public final void ruleUnrestrictedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:414:2: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:415:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:415:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:416:1: ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleUnrestrictedName822);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:429:1: entryRuleWildcardTypeRefCS : ruleWildcardTypeRefCS EOF ;
    public final void entryRuleWildcardTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:430:1: ( ruleWildcardTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:431:1: ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS848);
            ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcardTypeRefCS855); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:438:1: ruleWildcardTypeRefCS : ( ( rule__WildcardTypeRefCS__Group__0 ) ) ;
    public final void ruleWildcardTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:442:2: ( ( ( rule__WildcardTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:443:1: ( ( rule__WildcardTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:443:1: ( ( rule__WildcardTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:444:1: ( rule__WildcardTypeRefCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:445:1: ( rule__WildcardTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:445:2: rule__WildcardTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__0_in_ruleWildcardTypeRefCS881);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:457:1: entryRuleID : ruleID EOF ;
    public final void entryRuleID() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:458:1: ( ruleID EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:459:1: ruleID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID908);
            ruleID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID915); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:466:1: ruleID : ( ( rule__ID__Alternatives ) ) ;
    public final void ruleID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:470:2: ( ( ( rule__ID__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:471:1: ( ( rule__ID__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:471:1: ( ( rule__ID__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:472:1: ( rule__ID__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:473:1: ( rule__ID__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:473:2: rule__ID__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ID__Alternatives_in_ruleID941);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:485:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:486:1: ( ruleIdentifier EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:487:1: ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier968);
            ruleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentifierRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier975); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:494:1: ruleIdentifier : ( ruleID ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:498:2: ( ( ruleID ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:499:1: ( ruleID )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:499:1: ( ruleID )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:500:1: ruleID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier1001);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:513:1: entryRuleLOWER : ruleLOWER EOF ;
    public final void entryRuleLOWER() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:514:1: ( ruleLOWER EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:515:1: ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER1027);
            ruleLOWER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLOWERRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER1034); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:522:1: ruleLOWER : ( RULE_INT ) ;
    public final void ruleLOWER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:526:2: ( ( RULE_INT ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:527:1: ( RULE_INT )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:527:1: ( RULE_INT )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:528:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER1060); if (state.failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:545:1: entryRuleUPPER : ruleUPPER EOF ;
    public final void entryRuleUPPER() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:546:1: ( ruleUPPER EOF )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:547:1: ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER1090);
            ruleUPPER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUPPERRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER1097); if (state.failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:554:1: ruleUPPER : ( ( rule__UPPER__Alternatives ) ) ;
    public final void ruleUPPER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:558:2: ( ( ( rule__UPPER__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:559:1: ( ( rule__UPPER__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:559:1: ( ( rule__UPPER__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:560:1: ( rule__UPPER__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUPPERAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:561:1: ( rule__UPPER__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:561:2: rule__UPPER__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__UPPER__Alternatives_in_ruleUPPER1123);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:576:1: rule__MultiplicityStringCS__StringBoundsAlternatives_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );
    public final void rule__MultiplicityStringCS__StringBoundsAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:580:1: ( ( '*' ) | ( '+' ) | ( '?' ) )
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
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:581:1: ( '*' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:581:1: ( '*' )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:582:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01163); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:589:6: ( '+' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:589:6: ( '+' )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:590:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); 
                    }
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01183); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:597:6: ( '?' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:597:6: ( '?' )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:598:1: '?'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2()); 
                    }
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01203); if (state.failed) return ;
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


    // $ANTLR start "rule__TypeParameterCS__Alternatives_1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:610:1: rule__TypeParameterCS__Alternatives_1 : ( ( ( rule__TypeParameterCS__Group_1_0__0 ) ) | ( ( rule__TypeParameterCS__Group_1_1__0 ) ) );
    public final void rule__TypeParameterCS__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:614:1: ( ( ( rule__TypeParameterCS__Group_1_0__0 ) ) | ( ( rule__TypeParameterCS__Group_1_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==24) ) {
                alt2=1;
            }
            else if ( (LA2_0==26) ) {
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
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:615:1: ( ( rule__TypeParameterCS__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:615:1: ( ( rule__TypeParameterCS__Group_1_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:616:1: ( rule__TypeParameterCS__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeParameterCSAccess().getGroup_1_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:617:1: ( rule__TypeParameterCS__Group_1_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:617:2: rule__TypeParameterCS__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_0__0_in_rule__TypeParameterCS__Alternatives_11237);
                    rule__TypeParameterCS__Group_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeParameterCSAccess().getGroup_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:621:6: ( ( rule__TypeParameterCS__Group_1_1__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:621:6: ( ( rule__TypeParameterCS__Group_1_1__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:622:1: ( rule__TypeParameterCS__Group_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeParameterCSAccess().getGroup_1_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:623:1: ( rule__TypeParameterCS__Group_1_1__0 )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:623:2: rule__TypeParameterCS__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_1__0_in_rule__TypeParameterCS__Alternatives_11255);
                    rule__TypeParameterCS__Group_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeParameterCSAccess().getGroup_1_1()); 
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
    // $ANTLR end "rule__TypeParameterCS__Alternatives_1"


    // $ANTLR start "rule__TypeRefCS__Alternatives"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:632:1: rule__TypeRefCS__Alternatives : ( ( ruleTypedRefCS ) | ( ruleWildcardTypeRefCS ) );
    public final void rule__TypeRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:636:1: ( ( ruleTypedRefCS ) | ( ruleWildcardTypeRefCS ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_SIMPLE_ID && LA3_0<=RULE_ESCAPED_ID)) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
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
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:637:1: ( ruleTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:637:1: ( ruleTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:638:1: ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_rule__TypeRefCS__Alternatives1288);
                    ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:643:6: ( ruleWildcardTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:643:6: ( ruleWildcardTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:644:1: ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_rule__TypeRefCS__Alternatives1305);
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


    // $ANTLR start "rule__WildcardTypeRefCS__Alternatives_2"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:654:1: rule__WildcardTypeRefCS__Alternatives_2 : ( ( ( rule__WildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__WildcardTypeRefCS__Group_2_1__0 ) ) );
    public final void rule__WildcardTypeRefCS__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:658:1: ( ( ( rule__WildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__WildcardTypeRefCS__Group_2_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==24) ) {
                alt4=1;
            }
            else if ( (LA4_0==26) ) {
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
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:659:1: ( ( rule__WildcardTypeRefCS__Group_2_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:659:1: ( ( rule__WildcardTypeRefCS__Group_2_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:660:1: ( rule__WildcardTypeRefCS__Group_2_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:661:1: ( rule__WildcardTypeRefCS__Group_2_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:661:2: rule__WildcardTypeRefCS__Group_2_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2_0__0_in_rule__WildcardTypeRefCS__Alternatives_21337);
                    rule__WildcardTypeRefCS__Group_2_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:665:6: ( ( rule__WildcardTypeRefCS__Group_2_1__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:665:6: ( ( rule__WildcardTypeRefCS__Group_2_1__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:666:1: ( rule__WildcardTypeRefCS__Group_2_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:667:1: ( rule__WildcardTypeRefCS__Group_2_1__0 )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:667:2: rule__WildcardTypeRefCS__Group_2_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2_1__0_in_rule__WildcardTypeRefCS__Alternatives_21355);
                    rule__WildcardTypeRefCS__Group_2_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2_1()); 
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
    // $ANTLR end "rule__WildcardTypeRefCS__Alternatives_2"


    // $ANTLR start "rule__ID__Alternatives"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:676:1: rule__ID__Alternatives : ( ( RULE_SIMPLE_ID ) | ( RULE_ESCAPED_ID ) );
    public final void rule__ID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:680:1: ( ( RULE_SIMPLE_ID ) | ( RULE_ESCAPED_ID ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_SIMPLE_ID) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ESCAPED_ID) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:681:1: ( RULE_SIMPLE_ID )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:681:1: ( RULE_SIMPLE_ID )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:682:1: RULE_SIMPLE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                    }
                    match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_rule__ID__Alternatives1388); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:687:6: ( RULE_ESCAPED_ID )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:687:6: ( RULE_ESCAPED_ID )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:688:1: RULE_ESCAPED_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1()); 
                    }
                    match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_rule__ID__Alternatives1405); if (state.failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:698:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UPPER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:702:1: ( ( RULE_INT ) | ( '*' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_INT) ) {
                alt6=1;
            }
            else if ( (LA6_0==16) ) {
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
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:703:1: ( RULE_INT )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:703:1: ( RULE_INT )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:704:1: RULE_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1437); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:709:6: ( '*' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:709:6: ( '*' )
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:710:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__UPPER__Alternatives1455); if (state.failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:724:1: rule__MultiplicityBoundsCS__Group__0 : rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1 ;
    public final void rule__MultiplicityBoundsCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:728:1: ( rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:729:2: rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__0__Impl_in_rule__MultiplicityBoundsCS__Group__01487);
            rule__MultiplicityBoundsCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__1_in_rule__MultiplicityBoundsCS__Group__01490);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:736:1: rule__MultiplicityBoundsCS__Group__0__Impl : ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) ) ;
    public final void rule__MultiplicityBoundsCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:740:1: ( ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:741:1: ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:741:1: ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:742:1: ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:743:1: ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:743:2: rule__MultiplicityBoundsCS__LowerBoundAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__LowerBoundAssignment_0_in_rule__MultiplicityBoundsCS__Group__0__Impl1517);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:753:1: rule__MultiplicityBoundsCS__Group__1 : rule__MultiplicityBoundsCS__Group__1__Impl ;
    public final void rule__MultiplicityBoundsCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:757:1: ( rule__MultiplicityBoundsCS__Group__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:758:2: rule__MultiplicityBoundsCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__1__Impl_in_rule__MultiplicityBoundsCS__Group__11547);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:764:1: rule__MultiplicityBoundsCS__Group__1__Impl : ( ( rule__MultiplicityBoundsCS__Group_1__0 )? ) ;
    public final void rule__MultiplicityBoundsCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:768:1: ( ( ( rule__MultiplicityBoundsCS__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:769:1: ( ( rule__MultiplicityBoundsCS__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:769:1: ( ( rule__MultiplicityBoundsCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:770:1: ( rule__MultiplicityBoundsCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:771:1: ( rule__MultiplicityBoundsCS__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:771:2: rule__MultiplicityBoundsCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__0_in_rule__MultiplicityBoundsCS__Group__1__Impl1574);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:785:1: rule__MultiplicityBoundsCS__Group_1__0 : rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1 ;
    public final void rule__MultiplicityBoundsCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:789:1: ( rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:790:2: rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__0__Impl_in_rule__MultiplicityBoundsCS__Group_1__01609);
            rule__MultiplicityBoundsCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__1_in_rule__MultiplicityBoundsCS__Group_1__01612);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:797:1: rule__MultiplicityBoundsCS__Group_1__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityBoundsCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:801:1: ( ( '..' ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:802:1: ( '..' )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:802:1: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:803:1: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__MultiplicityBoundsCS__Group_1__0__Impl1640); if (state.failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:816:1: rule__MultiplicityBoundsCS__Group_1__1 : rule__MultiplicityBoundsCS__Group_1__1__Impl ;
    public final void rule__MultiplicityBoundsCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:820:1: ( rule__MultiplicityBoundsCS__Group_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:821:2: rule__MultiplicityBoundsCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__1__Impl_in_rule__MultiplicityBoundsCS__Group_1__11671);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:827:1: rule__MultiplicityBoundsCS__Group_1__1__Impl : ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) ) ;
    public final void rule__MultiplicityBoundsCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:831:1: ( ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:832:1: ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:832:1: ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:833:1: ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:834:1: ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:834:2: rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1_in_rule__MultiplicityBoundsCS__Group_1__1__Impl1698);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:849:1: rule__PathNameCS__Group__0 : rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 ;
    public final void rule__PathNameCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:853:1: ( rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:854:2: rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__0__Impl_in_rule__PathNameCS__Group__01733);
            rule__PathNameCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__1_in_rule__PathNameCS__Group__01736);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:861:1: rule__PathNameCS__Group__0__Impl : ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) ) ;
    public final void rule__PathNameCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:865:1: ( ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:866:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:866:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:867:1: ( rule__PathNameCS__OwnedPathElementsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:868:1: ( rule__PathNameCS__OwnedPathElementsAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:868:2: rule__PathNameCS__OwnedPathElementsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_0_in_rule__PathNameCS__Group__0__Impl1763);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:878:1: rule__PathNameCS__Group__1 : rule__PathNameCS__Group__1__Impl ;
    public final void rule__PathNameCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:882:1: ( rule__PathNameCS__Group__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:883:2: rule__PathNameCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__1__Impl_in_rule__PathNameCS__Group__11793);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:889:1: rule__PathNameCS__Group__1__Impl : ( ( rule__PathNameCS__Group_1__0 )* ) ;
    public final void rule__PathNameCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:893:1: ( ( ( rule__PathNameCS__Group_1__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:894:1: ( ( rule__PathNameCS__Group_1__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:894:1: ( ( rule__PathNameCS__Group_1__0 )* )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:895:1: ( rule__PathNameCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:896:1: ( rule__PathNameCS__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==20) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:896:2: rule__PathNameCS__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__0_in_rule__PathNameCS__Group__1__Impl1820);
            	    rule__PathNameCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:910:1: rule__PathNameCS__Group_1__0 : rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 ;
    public final void rule__PathNameCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:914:1: ( rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:915:2: rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__0__Impl_in_rule__PathNameCS__Group_1__01855);
            rule__PathNameCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__1_in_rule__PathNameCS__Group_1__01858);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:922:1: rule__PathNameCS__Group_1__0__Impl : ( '::' ) ;
    public final void rule__PathNameCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:926:1: ( ( '::' ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:927:1: ( '::' )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:927:1: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:928:1: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__PathNameCS__Group_1__0__Impl1886); if (state.failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:941:1: rule__PathNameCS__Group_1__1 : rule__PathNameCS__Group_1__1__Impl ;
    public final void rule__PathNameCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:945:1: ( rule__PathNameCS__Group_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:946:2: rule__PathNameCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__1__Impl_in_rule__PathNameCS__Group_1__11917);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:952:1: rule__PathNameCS__Group_1__1__Impl : ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) ) ;
    public final void rule__PathNameCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:956:1: ( ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:957:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:957:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:958:1: ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:959:1: ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:959:2: rule__PathNameCS__OwnedPathElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_1_1_in_rule__PathNameCS__Group_1__1__Impl1944);
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


    // $ANTLR start "rule__TemplateBindingCS__Group__0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:973:1: rule__TemplateBindingCS__Group__0 : rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1 ;
    public final void rule__TemplateBindingCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:977:1: ( rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:978:2: rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__0__Impl_in_rule__TemplateBindingCS__Group__01978);
            rule__TemplateBindingCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__1_in_rule__TemplateBindingCS__Group__01981);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:985:1: rule__TemplateBindingCS__Group__0__Impl : ( '(' ) ;
    public final void rule__TemplateBindingCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:989:1: ( ( '(' ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:990:1: ( '(' )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:990:1: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:991:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__TemplateBindingCS__Group__0__Impl2009); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getLeftParenthesisKeyword_0()); 
            }

            }


            }

        }
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1004:1: rule__TemplateBindingCS__Group__1 : rule__TemplateBindingCS__Group__1__Impl rule__TemplateBindingCS__Group__2 ;
    public final void rule__TemplateBindingCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1008:1: ( rule__TemplateBindingCS__Group__1__Impl rule__TemplateBindingCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1009:2: rule__TemplateBindingCS__Group__1__Impl rule__TemplateBindingCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__1__Impl_in_rule__TemplateBindingCS__Group__12040);
            rule__TemplateBindingCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__2_in_rule__TemplateBindingCS__Group__12043);
            rule__TemplateBindingCS__Group__2();

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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1016:1: rule__TemplateBindingCS__Group__1__Impl : ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1 ) ) ;
    public final void rule__TemplateBindingCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1020:1: ( ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1021:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1021:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1022:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1023:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1023:2: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_in_rule__TemplateBindingCS__Group__1__Impl2070);
            rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__TemplateBindingCS__Group__2"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1033:1: rule__TemplateBindingCS__Group__2 : rule__TemplateBindingCS__Group__2__Impl rule__TemplateBindingCS__Group__3 ;
    public final void rule__TemplateBindingCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1037:1: ( rule__TemplateBindingCS__Group__2__Impl rule__TemplateBindingCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1038:2: rule__TemplateBindingCS__Group__2__Impl rule__TemplateBindingCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__2__Impl_in_rule__TemplateBindingCS__Group__22100);
            rule__TemplateBindingCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__3_in_rule__TemplateBindingCS__Group__22103);
            rule__TemplateBindingCS__Group__3();

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
    // $ANTLR end "rule__TemplateBindingCS__Group__2"


    // $ANTLR start "rule__TemplateBindingCS__Group__2__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1045:1: rule__TemplateBindingCS__Group__2__Impl : ( ( rule__TemplateBindingCS__Group_2__0 )* ) ;
    public final void rule__TemplateBindingCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1049:1: ( ( ( rule__TemplateBindingCS__Group_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1050:1: ( ( rule__TemplateBindingCS__Group_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1050:1: ( ( rule__TemplateBindingCS__Group_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1051:1: ( rule__TemplateBindingCS__Group_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1052:1: ( rule__TemplateBindingCS__Group_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1052:2: rule__TemplateBindingCS__Group_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_2__0_in_rule__TemplateBindingCS__Group__2__Impl2130);
            	    rule__TemplateBindingCS__Group_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group__2__Impl"


    // $ANTLR start "rule__TemplateBindingCS__Group__3"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1062:1: rule__TemplateBindingCS__Group__3 : rule__TemplateBindingCS__Group__3__Impl ;
    public final void rule__TemplateBindingCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1066:1: ( rule__TemplateBindingCS__Group__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1067:2: rule__TemplateBindingCS__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__3__Impl_in_rule__TemplateBindingCS__Group__32161);
            rule__TemplateBindingCS__Group__3__Impl();

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
    // $ANTLR end "rule__TemplateBindingCS__Group__3"


    // $ANTLR start "rule__TemplateBindingCS__Group__3__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1073:1: rule__TemplateBindingCS__Group__3__Impl : ( ')' ) ;
    public final void rule__TemplateBindingCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1077:1: ( ( ')' ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1078:1: ( ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1078:1: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1079:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__TemplateBindingCS__Group__3__Impl2189); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getRightParenthesisKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group__3__Impl"


    // $ANTLR start "rule__TemplateBindingCS__Group_2__0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1100:1: rule__TemplateBindingCS__Group_2__0 : rule__TemplateBindingCS__Group_2__0__Impl rule__TemplateBindingCS__Group_2__1 ;
    public final void rule__TemplateBindingCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1104:1: ( rule__TemplateBindingCS__Group_2__0__Impl rule__TemplateBindingCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1105:2: rule__TemplateBindingCS__Group_2__0__Impl rule__TemplateBindingCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_2__0__Impl_in_rule__TemplateBindingCS__Group_2__02228);
            rule__TemplateBindingCS__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_2__1_in_rule__TemplateBindingCS__Group_2__02231);
            rule__TemplateBindingCS__Group_2__1();

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
    // $ANTLR end "rule__TemplateBindingCS__Group_2__0"


    // $ANTLR start "rule__TemplateBindingCS__Group_2__0__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1112:1: rule__TemplateBindingCS__Group_2__0__Impl : ( ',' ) ;
    public final void rule__TemplateBindingCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1116:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1117:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1117:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1118:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_2_0()); 
            }
            match(input,23,FollowSets000.FOLLOW_23_in_rule__TemplateBindingCS__Group_2__0__Impl2259); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group_2__0__Impl"


    // $ANTLR start "rule__TemplateBindingCS__Group_2__1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1131:1: rule__TemplateBindingCS__Group_2__1 : rule__TemplateBindingCS__Group_2__1__Impl ;
    public final void rule__TemplateBindingCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1135:1: ( rule__TemplateBindingCS__Group_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1136:2: rule__TemplateBindingCS__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_2__1__Impl_in_rule__TemplateBindingCS__Group_2__12290);
            rule__TemplateBindingCS__Group_2__1__Impl();

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
    // $ANTLR end "rule__TemplateBindingCS__Group_2__1"


    // $ANTLR start "rule__TemplateBindingCS__Group_2__1__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1142:1: rule__TemplateBindingCS__Group_2__1__Impl : ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1 ) ) ;
    public final void rule__TemplateBindingCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1146:1: ( ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1147:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1147:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1148:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1149:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1149:2: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1_in_rule__TemplateBindingCS__Group_2__1__Impl2317);
            rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group_2__1__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group__0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1165:1: rule__TypeParameterCS__Group__0 : rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1 ;
    public final void rule__TypeParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1169:1: ( rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1170:2: rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__0__Impl_in_rule__TypeParameterCS__Group__02353);
            rule__TypeParameterCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__1_in_rule__TypeParameterCS__Group__02356);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1177:1: rule__TypeParameterCS__Group__0__Impl : ( ( rule__TypeParameterCS__NameAssignment_0 ) ) ;
    public final void rule__TypeParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1181:1: ( ( ( rule__TypeParameterCS__NameAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1182:1: ( ( rule__TypeParameterCS__NameAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1182:1: ( ( rule__TypeParameterCS__NameAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1183:1: ( rule__TypeParameterCS__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1184:1: ( rule__TypeParameterCS__NameAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1184:2: rule__TypeParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__NameAssignment_0_in_rule__TypeParameterCS__Group__0__Impl2383);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1194:1: rule__TypeParameterCS__Group__1 : rule__TypeParameterCS__Group__1__Impl ;
    public final void rule__TypeParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1198:1: ( rule__TypeParameterCS__Group__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1199:2: rule__TypeParameterCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__1__Impl_in_rule__TypeParameterCS__Group__12413);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1205:1: rule__TypeParameterCS__Group__1__Impl : ( ( rule__TypeParameterCS__Alternatives_1 )? ) ;
    public final void rule__TypeParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1209:1: ( ( ( rule__TypeParameterCS__Alternatives_1 )? ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1210:1: ( ( rule__TypeParameterCS__Alternatives_1 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1210:1: ( ( rule__TypeParameterCS__Alternatives_1 )? )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1211:1: ( rule__TypeParameterCS__Alternatives_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1212:1: ( rule__TypeParameterCS__Alternatives_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==24||LA10_0==26) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1212:2: rule__TypeParameterCS__Alternatives_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Alternatives_1_in_rule__TypeParameterCS__Group__1__Impl2440);
                    rule__TypeParameterCS__Alternatives_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getAlternatives_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__TypeParameterCS__Group_1_0__0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1226:1: rule__TypeParameterCS__Group_1_0__0 : rule__TypeParameterCS__Group_1_0__0__Impl rule__TypeParameterCS__Group_1_0__1 ;
    public final void rule__TypeParameterCS__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1230:1: ( rule__TypeParameterCS__Group_1_0__0__Impl rule__TypeParameterCS__Group_1_0__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1231:2: rule__TypeParameterCS__Group_1_0__0__Impl rule__TypeParameterCS__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_0__0__Impl_in_rule__TypeParameterCS__Group_1_0__02475);
            rule__TypeParameterCS__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_0__1_in_rule__TypeParameterCS__Group_1_0__02478);
            rule__TypeParameterCS__Group_1_0__1();

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
    // $ANTLR end "rule__TypeParameterCS__Group_1_0__0"


    // $ANTLR start "rule__TypeParameterCS__Group_1_0__0__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1238:1: rule__TypeParameterCS__Group_1_0__0__Impl : ( 'extends' ) ;
    public final void rule__TypeParameterCS__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1242:1: ( ( 'extends' ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1243:1: ( 'extends' )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1243:1: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1244:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0_0()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__TypeParameterCS__Group_1_0__0__Impl2506); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1_0__0__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1_0__1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1257:1: rule__TypeParameterCS__Group_1_0__1 : rule__TypeParameterCS__Group_1_0__1__Impl rule__TypeParameterCS__Group_1_0__2 ;
    public final void rule__TypeParameterCS__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1261:1: ( rule__TypeParameterCS__Group_1_0__1__Impl rule__TypeParameterCS__Group_1_0__2 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1262:2: rule__TypeParameterCS__Group_1_0__1__Impl rule__TypeParameterCS__Group_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_0__1__Impl_in_rule__TypeParameterCS__Group_1_0__12537);
            rule__TypeParameterCS__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_0__2_in_rule__TypeParameterCS__Group_1_0__12540);
            rule__TypeParameterCS__Group_1_0__2();

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
    // $ANTLR end "rule__TypeParameterCS__Group_1_0__1"


    // $ANTLR start "rule__TypeParameterCS__Group_1_0__1__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1269:1: rule__TypeParameterCS__Group_1_0__1__Impl : ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1 ) ) ;
    public final void rule__TypeParameterCS__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1273:1: ( ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1274:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1274:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1275:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1276:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1276:2: rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1_in_rule__TypeParameterCS__Group_1_0__1__Impl2567);
            rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1_0__1__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1_0__2"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1286:1: rule__TypeParameterCS__Group_1_0__2 : rule__TypeParameterCS__Group_1_0__2__Impl ;
    public final void rule__TypeParameterCS__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1290:1: ( rule__TypeParameterCS__Group_1_0__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1291:2: rule__TypeParameterCS__Group_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_0__2__Impl_in_rule__TypeParameterCS__Group_1_0__22597);
            rule__TypeParameterCS__Group_1_0__2__Impl();

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
    // $ANTLR end "rule__TypeParameterCS__Group_1_0__2"


    // $ANTLR start "rule__TypeParameterCS__Group_1_0__2__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1297:1: rule__TypeParameterCS__Group_1_0__2__Impl : ( ( rule__TypeParameterCS__Group_1_0_2__0 )* ) ;
    public final void rule__TypeParameterCS__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1301:1: ( ( ( rule__TypeParameterCS__Group_1_0_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1302:1: ( ( rule__TypeParameterCS__Group_1_0_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1302:1: ( ( rule__TypeParameterCS__Group_1_0_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1303:1: ( rule__TypeParameterCS__Group_1_0_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup_1_0_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1304:1: ( rule__TypeParameterCS__Group_1_0_2__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1304:2: rule__TypeParameterCS__Group_1_0_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_0_2__0_in_rule__TypeParameterCS__Group_1_0__2__Impl2624);
            	    rule__TypeParameterCS__Group_1_0_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getGroup_1_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1_0__2__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1_0_2__0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1320:1: rule__TypeParameterCS__Group_1_0_2__0 : rule__TypeParameterCS__Group_1_0_2__0__Impl rule__TypeParameterCS__Group_1_0_2__1 ;
    public final void rule__TypeParameterCS__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1324:1: ( rule__TypeParameterCS__Group_1_0_2__0__Impl rule__TypeParameterCS__Group_1_0_2__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1325:2: rule__TypeParameterCS__Group_1_0_2__0__Impl rule__TypeParameterCS__Group_1_0_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_0_2__0__Impl_in_rule__TypeParameterCS__Group_1_0_2__02661);
            rule__TypeParameterCS__Group_1_0_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_0_2__1_in_rule__TypeParameterCS__Group_1_0_2__02664);
            rule__TypeParameterCS__Group_1_0_2__1();

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
    // $ANTLR end "rule__TypeParameterCS__Group_1_0_2__0"


    // $ANTLR start "rule__TypeParameterCS__Group_1_0_2__0__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1332:1: rule__TypeParameterCS__Group_1_0_2__0__Impl : ( '&&' ) ;
    public final void rule__TypeParameterCS__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1336:1: ( ( '&&' ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1337:1: ( '&&' )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1337:1: ( '&&' )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1338:1: '&&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__TypeParameterCS__Group_1_0_2__0__Impl2692); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1_0_2__0__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1_0_2__1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1351:1: rule__TypeParameterCS__Group_1_0_2__1 : rule__TypeParameterCS__Group_1_0_2__1__Impl ;
    public final void rule__TypeParameterCS__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1355:1: ( rule__TypeParameterCS__Group_1_0_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1356:2: rule__TypeParameterCS__Group_1_0_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_0_2__1__Impl_in_rule__TypeParameterCS__Group_1_0_2__12723);
            rule__TypeParameterCS__Group_1_0_2__1__Impl();

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
    // $ANTLR end "rule__TypeParameterCS__Group_1_0_2__1"


    // $ANTLR start "rule__TypeParameterCS__Group_1_0_2__1__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1362:1: rule__TypeParameterCS__Group_1_0_2__1__Impl : ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1 ) ) ;
    public final void rule__TypeParameterCS__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1366:1: ( ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1367:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1367:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1368:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_0_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1369:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1369:2: rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1_in_rule__TypeParameterCS__Group_1_0_2__1__Impl2750);
            rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_0_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1_0_2__1__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1_1__0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1383:1: rule__TypeParameterCS__Group_1_1__0 : rule__TypeParameterCS__Group_1_1__0__Impl rule__TypeParameterCS__Group_1_1__1 ;
    public final void rule__TypeParameterCS__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1387:1: ( rule__TypeParameterCS__Group_1_1__0__Impl rule__TypeParameterCS__Group_1_1__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1388:2: rule__TypeParameterCS__Group_1_1__0__Impl rule__TypeParameterCS__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_1__0__Impl_in_rule__TypeParameterCS__Group_1_1__02784);
            rule__TypeParameterCS__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_1__1_in_rule__TypeParameterCS__Group_1_1__02787);
            rule__TypeParameterCS__Group_1_1__1();

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
    // $ANTLR end "rule__TypeParameterCS__Group_1_1__0"


    // $ANTLR start "rule__TypeParameterCS__Group_1_1__0__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1395:1: rule__TypeParameterCS__Group_1_1__0__Impl : ( 'super' ) ;
    public final void rule__TypeParameterCS__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1399:1: ( ( 'super' ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1400:1: ( 'super' )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1400:1: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1401:1: 'super'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getSuperKeyword_1_1_0()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__TypeParameterCS__Group_1_1__0__Impl2815); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getSuperKeyword_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1_1__0__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1_1__1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1414:1: rule__TypeParameterCS__Group_1_1__1 : rule__TypeParameterCS__Group_1_1__1__Impl ;
    public final void rule__TypeParameterCS__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1418:1: ( rule__TypeParameterCS__Group_1_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1419:2: rule__TypeParameterCS__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_1__1__Impl_in_rule__TypeParameterCS__Group_1_1__12846);
            rule__TypeParameterCS__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__TypeParameterCS__Group_1_1__1"


    // $ANTLR start "rule__TypeParameterCS__Group_1_1__1__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1425:1: rule__TypeParameterCS__Group_1_1__1__Impl : ( ( rule__TypeParameterCS__OwnedSuperAssignment_1_1_1 ) ) ;
    public final void rule__TypeParameterCS__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1429:1: ( ( ( rule__TypeParameterCS__OwnedSuperAssignment_1_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1430:1: ( ( rule__TypeParameterCS__OwnedSuperAssignment_1_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1430:1: ( ( rule__TypeParameterCS__OwnedSuperAssignment_1_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1431:1: ( rule__TypeParameterCS__OwnedSuperAssignment_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedSuperAssignment_1_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1432:1: ( rule__TypeParameterCS__OwnedSuperAssignment_1_1_1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1432:2: rule__TypeParameterCS__OwnedSuperAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__OwnedSuperAssignment_1_1_1_in_rule__TypeParameterCS__Group_1_1__1__Impl2873);
            rule__TypeParameterCS__OwnedSuperAssignment_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedSuperAssignment_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1_1__1__Impl"


    // $ANTLR start "rule__TypedTypeRefCS__Group__0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1446:1: rule__TypedTypeRefCS__Group__0 : rule__TypedTypeRefCS__Group__0__Impl rule__TypedTypeRefCS__Group__1 ;
    public final void rule__TypedTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1450:1: ( rule__TypedTypeRefCS__Group__0__Impl rule__TypedTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1451:2: rule__TypedTypeRefCS__Group__0__Impl rule__TypedTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group__0__Impl_in_rule__TypedTypeRefCS__Group__02907);
            rule__TypedTypeRefCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group__1_in_rule__TypedTypeRefCS__Group__02910);
            rule__TypedTypeRefCS__Group__1();

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
    // $ANTLR end "rule__TypedTypeRefCS__Group__0"


    // $ANTLR start "rule__TypedTypeRefCS__Group__0__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1458:1: rule__TypedTypeRefCS__Group__0__Impl : ( ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 ) ) ;
    public final void rule__TypedTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1462:1: ( ( ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1463:1: ( ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1463:1: ( ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1464:1: ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1465:1: ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1465:2: rule__TypedTypeRefCS__OwnedPathNameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__OwnedPathNameAssignment_0_in_rule__TypedTypeRefCS__Group__0__Impl2937);
            rule__TypedTypeRefCS__OwnedPathNameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group__0__Impl"


    // $ANTLR start "rule__TypedTypeRefCS__Group__1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1475:1: rule__TypedTypeRefCS__Group__1 : rule__TypedTypeRefCS__Group__1__Impl ;
    public final void rule__TypedTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1479:1: ( rule__TypedTypeRefCS__Group__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1480:2: rule__TypedTypeRefCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group__1__Impl_in_rule__TypedTypeRefCS__Group__12967);
            rule__TypedTypeRefCS__Group__1__Impl();

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
    // $ANTLR end "rule__TypedTypeRefCS__Group__1"


    // $ANTLR start "rule__TypedTypeRefCS__Group__1__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1486:1: rule__TypedTypeRefCS__Group__1__Impl : ( ( rule__TypedTypeRefCS__OwnedBindingAssignment_1 )? ) ;
    public final void rule__TypedTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1490:1: ( ( ( rule__TypedTypeRefCS__OwnedBindingAssignment_1 )? ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1491:1: ( ( rule__TypedTypeRefCS__OwnedBindingAssignment_1 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1491:1: ( ( rule__TypedTypeRefCS__OwnedBindingAssignment_1 )? )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1492:1: ( rule__TypedTypeRefCS__OwnedBindingAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1493:1: ( rule__TypedTypeRefCS__OwnedBindingAssignment_1 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==21) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1493:2: rule__TypedTypeRefCS__OwnedBindingAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__OwnedBindingAssignment_1_in_rule__TypedTypeRefCS__Group__1__Impl2994);
                    rule__TypedTypeRefCS__OwnedBindingAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group__1__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1507:1: rule__WildcardTypeRefCS__Group__0 : rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1 ;
    public final void rule__WildcardTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1511:1: ( rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1512:2: rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__0__Impl_in_rule__WildcardTypeRefCS__Group__03029);
            rule__WildcardTypeRefCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__1_in_rule__WildcardTypeRefCS__Group__03032);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1519:1: rule__WildcardTypeRefCS__Group__0__Impl : ( () ) ;
    public final void rule__WildcardTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1523:1: ( ( () ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1524:1: ( () )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1524:1: ( () )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1525:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1526:1: ()
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1528:1: 
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1538:1: rule__WildcardTypeRefCS__Group__1 : rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2 ;
    public final void rule__WildcardTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1542:1: ( rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1543:2: rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__1__Impl_in_rule__WildcardTypeRefCS__Group__13090);
            rule__WildcardTypeRefCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__2_in_rule__WildcardTypeRefCS__Group__13093);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1550:1: rule__WildcardTypeRefCS__Group__1__Impl : ( '?' ) ;
    public final void rule__WildcardTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1554:1: ( ( '?' ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1555:1: ( '?' )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1555:1: ( '?' )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1556:1: '?'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__WildcardTypeRefCS__Group__1__Impl3121); if (state.failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1569:1: rule__WildcardTypeRefCS__Group__2 : rule__WildcardTypeRefCS__Group__2__Impl ;
    public final void rule__WildcardTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1573:1: ( rule__WildcardTypeRefCS__Group__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1574:2: rule__WildcardTypeRefCS__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__2__Impl_in_rule__WildcardTypeRefCS__Group__23152);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1580:1: rule__WildcardTypeRefCS__Group__2__Impl : ( ( rule__WildcardTypeRefCS__Alternatives_2 )? ) ;
    public final void rule__WildcardTypeRefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1584:1: ( ( ( rule__WildcardTypeRefCS__Alternatives_2 )? ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1585:1: ( ( rule__WildcardTypeRefCS__Alternatives_2 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1585:1: ( ( rule__WildcardTypeRefCS__Alternatives_2 )? )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1586:1: ( rule__WildcardTypeRefCS__Alternatives_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getAlternatives_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1587:1: ( rule__WildcardTypeRefCS__Alternatives_2 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24||LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1587:2: rule__WildcardTypeRefCS__Alternatives_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Alternatives_2_in_rule__WildcardTypeRefCS__Group__2__Impl3179);
                    rule__WildcardTypeRefCS__Alternatives_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getAlternatives_2()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2_0__0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1603:1: rule__WildcardTypeRefCS__Group_2_0__0 : rule__WildcardTypeRefCS__Group_2_0__0__Impl rule__WildcardTypeRefCS__Group_2_0__1 ;
    public final void rule__WildcardTypeRefCS__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1607:1: ( rule__WildcardTypeRefCS__Group_2_0__0__Impl rule__WildcardTypeRefCS__Group_2_0__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1608:2: rule__WildcardTypeRefCS__Group_2_0__0__Impl rule__WildcardTypeRefCS__Group_2_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2_0__0__Impl_in_rule__WildcardTypeRefCS__Group_2_0__03216);
            rule__WildcardTypeRefCS__Group_2_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2_0__1_in_rule__WildcardTypeRefCS__Group_2_0__03219);
            rule__WildcardTypeRefCS__Group_2_0__1();

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
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2_0__0"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2_0__0__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1615:1: rule__WildcardTypeRefCS__Group_2_0__0__Impl : ( 'extends' ) ;
    public final void rule__WildcardTypeRefCS__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1619:1: ( ( 'extends' ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1620:1: ( 'extends' )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1620:1: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1621:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__WildcardTypeRefCS__Group_2_0__0__Impl3247); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2_0__0__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2_0__1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1634:1: rule__WildcardTypeRefCS__Group_2_0__1 : rule__WildcardTypeRefCS__Group_2_0__1__Impl ;
    public final void rule__WildcardTypeRefCS__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1638:1: ( rule__WildcardTypeRefCS__Group_2_0__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1639:2: rule__WildcardTypeRefCS__Group_2_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2_0__1__Impl_in_rule__WildcardTypeRefCS__Group_2_0__13278);
            rule__WildcardTypeRefCS__Group_2_0__1__Impl();

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
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2_0__1"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2_0__1__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1645:1: rule__WildcardTypeRefCS__Group_2_0__1__Impl : ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1 ) ) ;
    public final void rule__WildcardTypeRefCS__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1649:1: ( ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1650:1: ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1650:1: ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1651:1: ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1652:1: ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1652:2: rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1_in_rule__WildcardTypeRefCS__Group_2_0__1__Impl3305);
            rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2_0__1__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2_1__0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1666:1: rule__WildcardTypeRefCS__Group_2_1__0 : rule__WildcardTypeRefCS__Group_2_1__0__Impl rule__WildcardTypeRefCS__Group_2_1__1 ;
    public final void rule__WildcardTypeRefCS__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1670:1: ( rule__WildcardTypeRefCS__Group_2_1__0__Impl rule__WildcardTypeRefCS__Group_2_1__1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1671:2: rule__WildcardTypeRefCS__Group_2_1__0__Impl rule__WildcardTypeRefCS__Group_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2_1__0__Impl_in_rule__WildcardTypeRefCS__Group_2_1__03339);
            rule__WildcardTypeRefCS__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2_1__1_in_rule__WildcardTypeRefCS__Group_2_1__03342);
            rule__WildcardTypeRefCS__Group_2_1__1();

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
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2_1__0"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2_1__0__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1678:1: rule__WildcardTypeRefCS__Group_2_1__0__Impl : ( 'super' ) ;
    public final void rule__WildcardTypeRefCS__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1682:1: ( ( 'super' ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1683:1: ( 'super' )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1683:1: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1684:1: 'super'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getSuperKeyword_2_1_0()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__WildcardTypeRefCS__Group_2_1__0__Impl3370); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getSuperKeyword_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2_1__0__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2_1__1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1697:1: rule__WildcardTypeRefCS__Group_2_1__1 : rule__WildcardTypeRefCS__Group_2_1__1__Impl ;
    public final void rule__WildcardTypeRefCS__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1701:1: ( rule__WildcardTypeRefCS__Group_2_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1702:2: rule__WildcardTypeRefCS__Group_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2_1__1__Impl_in_rule__WildcardTypeRefCS__Group_2_1__13401);
            rule__WildcardTypeRefCS__Group_2_1__1__Impl();

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
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2_1__1"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2_1__1__Impl"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1708:1: rule__WildcardTypeRefCS__Group_2_1__1__Impl : ( ( rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1 ) ) ;
    public final void rule__WildcardTypeRefCS__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1712:1: ( ( ( rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1713:1: ( ( rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1713:1: ( ( rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1714:1: ( rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedSuperAssignment_2_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1715:1: ( rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1715:2: rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1_in_rule__WildcardTypeRefCS__Group_2_1__1__Impl3428);
            rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getOwnedSuperAssignment_2_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2_1__1__Impl"


    // $ANTLR start "rule__MultiplicityBoundsCS__LowerBoundAssignment_0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1730:1: rule__MultiplicityBoundsCS__LowerBoundAssignment_0 : ( ruleLOWER ) ;
    public final void rule__MultiplicityBoundsCS__LowerBoundAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1734:1: ( ( ruleLOWER ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1735:1: ( ruleLOWER )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1735:1: ( ruleLOWER )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1736:1: ruleLOWER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_rule__MultiplicityBoundsCS__LowerBoundAssignment_03467);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1745:1: rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 : ( ruleUPPER ) ;
    public final void rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1749:1: ( ( ruleUPPER ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1750:1: ( ruleUPPER )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1750:1: ( ruleUPPER )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1751:1: ruleUPPER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_13498);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1760:1: rule__MultiplicityStringCS__StringBoundsAssignment : ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) ) ;
    public final void rule__MultiplicityStringCS__StringBoundsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1764:1: ( ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1765:1: ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1765:1: ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1766:1: ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1767:1: ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1767:2: rule__MultiplicityStringCS__StringBoundsAlternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityStringCS__StringBoundsAlternatives_0_in_rule__MultiplicityStringCS__StringBoundsAssignment3529);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1776:1: rule__PathNameCS__OwnedPathElementsAssignment_0 : ( ruleFirstPathElementCS ) ;
    public final void rule__PathNameCS__OwnedPathElementsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1780:1: ( ( ruleFirstPathElementCS ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1781:1: ( ruleFirstPathElementCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1781:1: ( ruleFirstPathElementCS )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1782:1: ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_03562);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1791:1: rule__PathNameCS__OwnedPathElementsAssignment_1_1 : ( ruleNextPathElementCS ) ;
    public final void rule__PathNameCS__OwnedPathElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1795:1: ( ( ruleNextPathElementCS ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1796:1: ( ruleNextPathElementCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1796:1: ( ruleNextPathElementCS )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1797:1: ruleNextPathElementCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_1_13593);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1806:1: rule__FirstPathElementCS__ReferredElementAssignment : ( ( ruleUnrestrictedName ) ) ;
    public final void rule__FirstPathElementCS__ReferredElementAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1810:1: ( ( ( ruleUnrestrictedName ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1811:1: ( ( ruleUnrestrictedName ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1811:1: ( ( ruleUnrestrictedName ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1812:1: ( ruleUnrestrictedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1813:1: ( ruleUnrestrictedName )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1814:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_rule__FirstPathElementCS__ReferredElementAssignment3628);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1825:1: rule__NextPathElementCS__ReferredElementAssignment : ( ( ruleUnreservedName ) ) ;
    public final void rule__NextPathElementCS__ReferredElementAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1829:1: ( ( ( ruleUnreservedName ) ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1830:1: ( ( ruleUnreservedName ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1830:1: ( ( ruleUnreservedName ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1831:1: ( ruleUnreservedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1832:1: ( ruleUnreservedName )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1833:1: ruleUnreservedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementUnreservedNameParserRuleCall_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_rule__NextPathElementCS__ReferredElementAssignment3667);
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


    // $ANTLR start "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1844:1: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1 : ( ruleTemplateParameterSubstitutionCS ) ;
    public final void rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1848:1: ( ( ruleTemplateParameterSubstitutionCS ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1849:1: ( ruleTemplateParameterSubstitutionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1849:1: ( ruleTemplateParameterSubstitutionCS )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1850:1: ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_13702);
            ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1"


    // $ANTLR start "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1859:1: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1 : ( ruleTemplateParameterSubstitutionCS ) ;
    public final void rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1863:1: ( ( ruleTemplateParameterSubstitutionCS ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1864:1: ( ruleTemplateParameterSubstitutionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1864:1: ( ruleTemplateParameterSubstitutionCS )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1865:1: ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_13733);
            ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1"


    // $ANTLR start "rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1874:1: rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment : ( ruleTypeRefCS ) ;
    public final void rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1878:1: ( ( ruleTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1879:1: ( ruleTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1879:1: ( ruleTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1880:1: ruleTypeRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment3764);
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
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1891:1: rule__TypeParameterCS__NameAssignment_0 : ( ruleUnrestrictedName ) ;
    public final void rule__TypeParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1895:1: ( ( ruleUnrestrictedName ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1896:1: ( ruleUnrestrictedName )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1896:1: ( ruleUnrestrictedName )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1897:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_rule__TypeParameterCS__NameAssignment_03797);
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


    // $ANTLR start "rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1906:1: rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1 : ( ruleTypedRefCS ) ;
    public final void rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1910:1: ( ( ruleTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1911:1: ( ruleTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1911:1: ( ruleTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1912:1: ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_0_13828);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1"


    // $ANTLR start "rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1921:1: rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1 : ( ruleTypedRefCS ) ;
    public final void rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1925:1: ( ( ruleTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1926:1: ( ruleTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1926:1: ( ruleTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1927:1: ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_0_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_13859);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_0_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1"


    // $ANTLR start "rule__TypeParameterCS__OwnedSuperAssignment_1_1_1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1936:1: rule__TypeParameterCS__OwnedSuperAssignment_1_1_1 : ( ruleTypedRefCS ) ;
    public final void rule__TypeParameterCS__OwnedSuperAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1940:1: ( ( ruleTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1941:1: ( ruleTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1941:1: ( ruleTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1942:1: ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedSuperTypedRefCSParserRuleCall_1_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_rule__TypeParameterCS__OwnedSuperAssignment_1_1_13890);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedSuperTypedRefCSParserRuleCall_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__OwnedSuperAssignment_1_1_1"


    // $ANTLR start "rule__TypedTypeRefCS__OwnedPathNameAssignment_0"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1951:1: rule__TypedTypeRefCS__OwnedPathNameAssignment_0 : ( rulePathNameCS ) ;
    public final void rule__TypedTypeRefCS__OwnedPathNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1955:1: ( ( rulePathNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1956:1: ( rulePathNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1956:1: ( rulePathNameCS )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1957:1: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_rule__TypedTypeRefCS__OwnedPathNameAssignment_03921);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__OwnedPathNameAssignment_0"


    // $ANTLR start "rule__TypedTypeRefCS__OwnedBindingAssignment_1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1966:1: rule__TypedTypeRefCS__OwnedBindingAssignment_1 : ( ruleTemplateBindingCS ) ;
    public final void rule__TypedTypeRefCS__OwnedBindingAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1970:1: ( ( ruleTemplateBindingCS ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1971:1: ( ruleTemplateBindingCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1971:1: ( ruleTemplateBindingCS )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1972:1: ruleTemplateBindingCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_rule__TypedTypeRefCS__OwnedBindingAssignment_13952);
            ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__OwnedBindingAssignment_1"


    // $ANTLR start "rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1981:1: rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1 : ( ruleTypedRefCS ) ;
    public final void rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1985:1: ( ( ruleTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1986:1: ( ruleTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1986:1: ( ruleTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1987:1: ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_13983);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1"


    // $ANTLR start "rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1"
    // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1996:1: rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1 : ( ruleTypedRefCS ) ;
    public final void rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:2000:1: ( ( ruleTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:2001:1: ( ruleTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:2001:1: ( ruleTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.base.ui/src-gen/org/eclipse/ocl/examples/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:2002:1: ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedSuperTypedRefCSParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_14014);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getOwnedSuperTypedRefCSParserRuleCall_2_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__0_in_ruleMultiplicityBoundsCS100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS129 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityStringCS__StringBoundsAssignment_in_ruleMultiplicityStringCS162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__0_in_rulePathNameCS222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS249 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstPathElementCS__ReferredElementAssignment_in_ruleFirstPathElementCS282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS309 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextPathElementCS__ReferredElementAssignment_in_ruleNextPathElementCS342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS369 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBindingCS376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__0_in_ruleTemplateBindingCS402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS429 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment_in_ruleTemplateParameterSubstitutionCS462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS491 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameterCS498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__0_in_ruleTypeParameterCS524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS551 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRefCS558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRefCS__Alternatives_in_ruleTypeRefCS584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS611 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedRefCS618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS670 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedTypeRefCS677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group__0_in_ruleTypedTypeRefCS703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName730 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName789 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleUnrestrictedName822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS848 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcardTypeRefCS855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__0_in_ruleWildcardTypeRefCS881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID908 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ID__Alternatives_in_ruleID941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier968 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier1001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER1027 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER1034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER1060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER1090 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER1097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UPPER__Alternatives_in_ruleUPPER1123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_0__0_in_rule__TypeParameterCS__Alternatives_11237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_1__0_in_rule__TypeParameterCS__Alternatives_11255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_rule__TypeRefCS__Alternatives1288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_rule__TypeRefCS__Alternatives1305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2_0__0_in_rule__WildcardTypeRefCS__Alternatives_21337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2_1__0_in_rule__WildcardTypeRefCS__Alternatives_21355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_rule__ID__Alternatives1388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_rule__ID__Alternatives1405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__UPPER__Alternatives1455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__0__Impl_in_rule__MultiplicityBoundsCS__Group__01487 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__1_in_rule__MultiplicityBoundsCS__Group__01490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__LowerBoundAssignment_0_in_rule__MultiplicityBoundsCS__Group__0__Impl1517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__1__Impl_in_rule__MultiplicityBoundsCS__Group__11547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__0_in_rule__MultiplicityBoundsCS__Group__1__Impl1574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__0__Impl_in_rule__MultiplicityBoundsCS__Group_1__01609 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__1_in_rule__MultiplicityBoundsCS__Group_1__01612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__MultiplicityBoundsCS__Group_1__0__Impl1640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__1__Impl_in_rule__MultiplicityBoundsCS__Group_1__11671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1_in_rule__MultiplicityBoundsCS__Group_1__1__Impl1698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__0__Impl_in_rule__PathNameCS__Group__01733 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__1_in_rule__PathNameCS__Group__01736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_0_in_rule__PathNameCS__Group__0__Impl1763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__1__Impl_in_rule__PathNameCS__Group__11793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__0_in_rule__PathNameCS__Group__1__Impl1820 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__0__Impl_in_rule__PathNameCS__Group_1__01855 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__1_in_rule__PathNameCS__Group_1__01858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__PathNameCS__Group_1__0__Impl1886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__1__Impl_in_rule__PathNameCS__Group_1__11917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_1_1_in_rule__PathNameCS__Group_1__1__Impl1944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__0__Impl_in_rule__TemplateBindingCS__Group__01978 = new BitSet(new long[]{0x0000000000040060L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__1_in_rule__TemplateBindingCS__Group__01981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__TemplateBindingCS__Group__0__Impl2009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__1__Impl_in_rule__TemplateBindingCS__Group__12040 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__2_in_rule__TemplateBindingCS__Group__12043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_in_rule__TemplateBindingCS__Group__1__Impl2070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__2__Impl_in_rule__TemplateBindingCS__Group__22100 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__3_in_rule__TemplateBindingCS__Group__22103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_2__0_in_rule__TemplateBindingCS__Group__2__Impl2130 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__3__Impl_in_rule__TemplateBindingCS__Group__32161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__TemplateBindingCS__Group__3__Impl2189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_2__0__Impl_in_rule__TemplateBindingCS__Group_2__02228 = new BitSet(new long[]{0x0000000000040060L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_2__1_in_rule__TemplateBindingCS__Group_2__02231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__TemplateBindingCS__Group_2__0__Impl2259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_2__1__Impl_in_rule__TemplateBindingCS__Group_2__12290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_1_in_rule__TemplateBindingCS__Group_2__1__Impl2317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__0__Impl_in_rule__TypeParameterCS__Group__02353 = new BitSet(new long[]{0x0000000005000000L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__1_in_rule__TypeParameterCS__Group__02356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__NameAssignment_0_in_rule__TypeParameterCS__Group__0__Impl2383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__1__Impl_in_rule__TypeParameterCS__Group__12413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Alternatives_1_in_rule__TypeParameterCS__Group__1__Impl2440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_0__0__Impl_in_rule__TypeParameterCS__Group_1_0__02475 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_0__1_in_rule__TypeParameterCS__Group_1_0__02478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__TypeParameterCS__Group_1_0__0__Impl2506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_0__1__Impl_in_rule__TypeParameterCS__Group_1_0__12537 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_0__2_in_rule__TypeParameterCS__Group_1_0__12540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_0_1_in_rule__TypeParameterCS__Group_1_0__1__Impl2567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_0__2__Impl_in_rule__TypeParameterCS__Group_1_0__22597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_0_2__0_in_rule__TypeParameterCS__Group_1_0__2__Impl2624 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_0_2__0__Impl_in_rule__TypeParameterCS__Group_1_0_2__02661 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_0_2__1_in_rule__TypeParameterCS__Group_1_0_2__02664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__TypeParameterCS__Group_1_0_2__0__Impl2692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_0_2__1__Impl_in_rule__TypeParameterCS__Group_1_0_2__12723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_1_in_rule__TypeParameterCS__Group_1_0_2__1__Impl2750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_1__0__Impl_in_rule__TypeParameterCS__Group_1_1__02784 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_1__1_in_rule__TypeParameterCS__Group_1_1__02787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__TypeParameterCS__Group_1_1__0__Impl2815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_1__1__Impl_in_rule__TypeParameterCS__Group_1_1__12846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__OwnedSuperAssignment_1_1_1_in_rule__TypeParameterCS__Group_1_1__1__Impl2873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group__0__Impl_in_rule__TypedTypeRefCS__Group__02907 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group__1_in_rule__TypedTypeRefCS__Group__02910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__OwnedPathNameAssignment_0_in_rule__TypedTypeRefCS__Group__0__Impl2937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group__1__Impl_in_rule__TypedTypeRefCS__Group__12967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__OwnedBindingAssignment_1_in_rule__TypedTypeRefCS__Group__1__Impl2994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__0__Impl_in_rule__WildcardTypeRefCS__Group__03029 = new BitSet(new long[]{0x0000000000040060L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__1_in_rule__WildcardTypeRefCS__Group__03032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__1__Impl_in_rule__WildcardTypeRefCS__Group__13090 = new BitSet(new long[]{0x0000000005000000L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__2_in_rule__WildcardTypeRefCS__Group__13093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__WildcardTypeRefCS__Group__1__Impl3121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__2__Impl_in_rule__WildcardTypeRefCS__Group__23152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Alternatives_2_in_rule__WildcardTypeRefCS__Group__2__Impl3179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2_0__0__Impl_in_rule__WildcardTypeRefCS__Group_2_0__03216 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2_0__1_in_rule__WildcardTypeRefCS__Group_2_0__03219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__WildcardTypeRefCS__Group_2_0__0__Impl3247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2_0__1__Impl_in_rule__WildcardTypeRefCS__Group_2_0__13278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_1_in_rule__WildcardTypeRefCS__Group_2_0__1__Impl3305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2_1__0__Impl_in_rule__WildcardTypeRefCS__Group_2_1__03339 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2_1__1_in_rule__WildcardTypeRefCS__Group_2_1__03342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__WildcardTypeRefCS__Group_2_1__0__Impl3370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2_1__1__Impl_in_rule__WildcardTypeRefCS__Group_2_1__13401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_1_in_rule__WildcardTypeRefCS__Group_2_1__1__Impl3428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_rule__MultiplicityBoundsCS__LowerBoundAssignment_03467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_13498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityStringCS__StringBoundsAlternatives_0_in_rule__MultiplicityStringCS__StringBoundsAssignment3529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_03562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_1_13593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_rule__FirstPathElementCS__ReferredElementAssignment3628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_rule__NextPathElementCS__ReferredElementAssignment3667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_13702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_2_13733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment3764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_rule__TypeParameterCS__NameAssignment_03797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_0_13828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_0_2_13859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_rule__TypeParameterCS__OwnedSuperAssignment_1_1_13890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_rule__TypedTypeRefCS__OwnedPathNameAssignment_03921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_rule__TypedTypeRefCS__OwnedBindingAssignment_13952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_0_13983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_rule__WildcardTypeRefCS__OwnedSuperAssignment_2_1_14014 = new BitSet(new long[]{0x0000000000000002L});
    }


}