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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_SINGLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'*'", "'+'", "'?'", "'..'", "'::'", "','", "'extends'", "'&&'", "'('", "')'"
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




    // $ANTLR start "entryRuleMultiplicityBoundsCS"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:61:1: entryRuleMultiplicityBoundsCS : ruleMultiplicityBoundsCS EOF ;
    public final void entryRuleMultiplicityBoundsCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:62:1: ( ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:63:1: ruleMultiplicityBoundsCS EOF
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:70:1: ruleMultiplicityBoundsCS : ( ( rule__MultiplicityBoundsCS__Group__0 ) ) ;
    public final void ruleMultiplicityBoundsCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:74:2: ( ( ( rule__MultiplicityBoundsCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:75:1: ( ( rule__MultiplicityBoundsCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:75:1: ( ( rule__MultiplicityBoundsCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:76:1: ( rule__MultiplicityBoundsCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:77:1: ( rule__MultiplicityBoundsCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:77:2: rule__MultiplicityBoundsCS__Group__0
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:93:1: entryRuleMultiplicityStringCS : ruleMultiplicityStringCS EOF ;
    public final void entryRuleMultiplicityStringCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:94:1: ( ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:95:1: ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS131);
            ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityStringCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS138); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:102:1: ruleMultiplicityStringCS : ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) ) ;
    public final void ruleMultiplicityStringCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:106:2: ( ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:107:1: ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:107:1: ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:108:1: ( rule__MultiplicityStringCS__StringBoundsAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAssignment()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:109:1: ( rule__MultiplicityStringCS__StringBoundsAssignment )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:109:2: rule__MultiplicityStringCS__StringBoundsAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityStringCS__StringBoundsAssignment_in_ruleMultiplicityStringCS164);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:121:1: entryRulePathNameCS : rulePathNameCS EOF ;
    public final void entryRulePathNameCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:122:1: ( rulePathNameCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:123:1: rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS191);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS198); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:130:1: rulePathNameCS : ( ( rule__PathNameCS__Group__0 ) ) ;
    public final void rulePathNameCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:134:2: ( ( ( rule__PathNameCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:135:1: ( ( rule__PathNameCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:135:1: ( ( rule__PathNameCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:136:1: ( rule__PathNameCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:137:1: ( rule__PathNameCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:137:2: rule__PathNameCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__0_in_rulePathNameCS224);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:149:1: entryRuleFirstPathElementCS : ruleFirstPathElementCS EOF ;
    public final void entryRuleFirstPathElementCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:150:1: ( ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:151:1: ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS251);
            ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFirstPathElementCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS258); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:158:1: ruleFirstPathElementCS : ( ( rule__FirstPathElementCS__ReferredElementAssignment ) ) ;
    public final void ruleFirstPathElementCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:162:2: ( ( ( rule__FirstPathElementCS__ReferredElementAssignment ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:163:1: ( ( rule__FirstPathElementCS__ReferredElementAssignment ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:163:1: ( ( rule__FirstPathElementCS__ReferredElementAssignment ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:164:1: ( rule__FirstPathElementCS__ReferredElementAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementAssignment()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:165:1: ( rule__FirstPathElementCS__ReferredElementAssignment )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:165:2: rule__FirstPathElementCS__ReferredElementAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__FirstPathElementCS__ReferredElementAssignment_in_ruleFirstPathElementCS284);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:177:1: entryRuleNextPathElementCS : ruleNextPathElementCS EOF ;
    public final void entryRuleNextPathElementCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:178:1: ( ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:179:1: ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS311);
            ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNextPathElementCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS318); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:186:1: ruleNextPathElementCS : ( ( rule__NextPathElementCS__ReferredElementAssignment ) ) ;
    public final void ruleNextPathElementCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:190:2: ( ( ( rule__NextPathElementCS__ReferredElementAssignment ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:191:1: ( ( rule__NextPathElementCS__ReferredElementAssignment ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:191:1: ( ( rule__NextPathElementCS__ReferredElementAssignment ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:192:1: ( rule__NextPathElementCS__ReferredElementAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementAssignment()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:193:1: ( rule__NextPathElementCS__ReferredElementAssignment )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:193:2: rule__NextPathElementCS__ReferredElementAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__NextPathElementCS__ReferredElementAssignment_in_ruleNextPathElementCS344);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:205:1: entryRuleTemplateBindingCS : ruleTemplateBindingCS EOF ;
    public final void entryRuleTemplateBindingCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:206:1: ( ruleTemplateBindingCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:207:1: ruleTemplateBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS371);
            ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateBindingCS378); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:214:1: ruleTemplateBindingCS : ( ( rule__TemplateBindingCS__Group__0 ) ) ;
    public final void ruleTemplateBindingCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:218:2: ( ( ( rule__TemplateBindingCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:219:1: ( ( rule__TemplateBindingCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:219:1: ( ( rule__TemplateBindingCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:220:1: ( rule__TemplateBindingCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:221:1: ( rule__TemplateBindingCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:221:2: rule__TemplateBindingCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__0_in_ruleTemplateBindingCS404);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:233:1: entryRuleTemplateParameterSubstitutionCS : ruleTemplateParameterSubstitutionCS EOF ;
    public final void entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:234:1: ( ruleTemplateParameterSubstitutionCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:235:1: ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS431);
            ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS438); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:242:1: ruleTemplateParameterSubstitutionCS : ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) ) ;
    public final void ruleTemplateParameterSubstitutionCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:246:2: ( ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:247:1: ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:247:1: ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:248:1: ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterAssignment()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:249:1: ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:249:2: rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment_in_ruleTemplateParameterSubstitutionCS464);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:263:1: entryRuleTypeParameterCS : ruleTypeParameterCS EOF ;
    public final void entryRuleTypeParameterCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:264:1: ( ruleTypeParameterCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:265:1: ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS493);
            ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeParameterCS500); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:272:1: ruleTypeParameterCS : ( ( rule__TypeParameterCS__Group__0 ) ) ;
    public final void ruleTypeParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:276:2: ( ( ( rule__TypeParameterCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:277:1: ( ( rule__TypeParameterCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:277:1: ( ( rule__TypeParameterCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:278:1: ( rule__TypeParameterCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:279:1: ( rule__TypeParameterCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:279:2: rule__TypeParameterCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__0_in_ruleTypeParameterCS526);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:291:1: entryRuleTypeRefCS : ruleTypeRefCS EOF ;
    public final void entryRuleTypeRefCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:292:1: ( ruleTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:293:1: ruleTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS553);
            ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRefCS560); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:300:1: ruleTypeRefCS : ( ( rule__TypeRefCS__Alternatives ) ) ;
    public final void ruleTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:304:2: ( ( ( rule__TypeRefCS__Alternatives ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:305:1: ( ( rule__TypeRefCS__Alternatives ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:305:1: ( ( rule__TypeRefCS__Alternatives ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:306:1: ( rule__TypeRefCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefCSAccess().getAlternatives()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:307:1: ( rule__TypeRefCS__Alternatives )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:307:2: rule__TypeRefCS__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRefCS__Alternatives_in_ruleTypeRefCS586);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:319:1: entryRuleTypedRefCS : ruleTypedRefCS EOF ;
    public final void entryRuleTypedRefCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:320:1: ( ruleTypedRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:321:1: ruleTypedRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS613);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedRefCS620); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:328:1: ruleTypedRefCS : ( ruleTypedTypeRefCS ) ;
    public final void ruleTypedRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:332:2: ( ( ruleTypedTypeRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:333:1: ( ruleTypedTypeRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:333:1: ( ruleTypedTypeRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:334:1: ruleTypedTypeRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS646);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:347:1: entryRuleTypedTypeRefCS : ruleTypedTypeRefCS EOF ;
    public final void entryRuleTypedTypeRefCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:348:1: ( ruleTypedTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:349:1: ruleTypedTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS672);
            ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedTypeRefCS679); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:356:1: ruleTypedTypeRefCS : ( ( rule__TypedTypeRefCS__Group__0 ) ) ;
    public final void ruleTypedTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:360:2: ( ( ( rule__TypedTypeRefCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:361:1: ( ( rule__TypedTypeRefCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:361:1: ( ( rule__TypedTypeRefCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:362:1: ( rule__TypedTypeRefCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:363:1: ( rule__TypedTypeRefCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:363:2: rule__TypedTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group__0_in_ruleTypedTypeRefCS705);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:375:1: entryRuleUnreservedName : ruleUnreservedName EOF ;
    public final void entryRuleUnreservedName() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:376:1: ( ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:377:1: ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName732);
            ruleUnreservedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnreservedNameRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName739); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:384:1: ruleUnreservedName : ( ruleUnrestrictedName ) ;
    public final void ruleUnreservedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:388:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:389:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:389:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:390:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnreservedNameAccess().getUnrestrictedNameParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName765);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:403:1: entryRuleUnrestrictedName : ruleUnrestrictedName EOF ;
    public final void entryRuleUnrestrictedName() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:404:1: ( ruleUnrestrictedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:405:1: ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName791);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnrestrictedNameRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName798); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:412:1: ruleUnrestrictedName : ( ruleIdentifier ) ;
    public final void ruleUnrestrictedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:416:2: ( ( ruleIdentifier ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:417:1: ( ruleIdentifier )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:417:1: ( ruleIdentifier )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:418:1: ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleUnrestrictedName824);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:431:1: entryRuleWildcardTypeRefCS : ruleWildcardTypeRefCS EOF ;
    public final void entryRuleWildcardTypeRefCS() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:432:1: ( ruleWildcardTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:433:1: ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS850);
            ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcardTypeRefCS857); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:440:1: ruleWildcardTypeRefCS : ( ( rule__WildcardTypeRefCS__Group__0 ) ) ;
    public final void ruleWildcardTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:444:2: ( ( ( rule__WildcardTypeRefCS__Group__0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:445:1: ( ( rule__WildcardTypeRefCS__Group__0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:445:1: ( ( rule__WildcardTypeRefCS__Group__0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:446:1: ( rule__WildcardTypeRefCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getGroup()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:447:1: ( rule__WildcardTypeRefCS__Group__0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:447:2: rule__WildcardTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__0_in_ruleWildcardTypeRefCS883);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:459:1: entryRuleID : ruleID EOF ;
    public final void entryRuleID() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:460:1: ( ruleID EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:461:1: ruleID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID910);
            ruleID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID917); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:468:1: ruleID : ( ( rule__ID__Alternatives ) ) ;
    public final void ruleID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:472:2: ( ( ( rule__ID__Alternatives ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:473:1: ( ( rule__ID__Alternatives ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:473:1: ( ( rule__ID__Alternatives ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:474:1: ( rule__ID__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDAccess().getAlternatives()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:475:1: ( rule__ID__Alternatives )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:475:2: rule__ID__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ID__Alternatives_in_ruleID943);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:487:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:488:1: ( ruleIdentifier EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:489:1: ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier970);
            ruleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentifierRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier977); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:496:1: ruleIdentifier : ( ruleID ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:500:2: ( ( ruleID ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:501:1: ( ruleID )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:501:1: ( ruleID )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:502:1: ruleID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier1003);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:515:1: entryRuleLOWER : ruleLOWER EOF ;
    public final void entryRuleLOWER() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:516:1: ( ruleLOWER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:517:1: ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER1029);
            ruleLOWER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLOWERRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER1036); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:524:1: ruleLOWER : ( RULE_INT ) ;
    public final void ruleLOWER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:528:2: ( ( RULE_INT ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:529:1: ( RULE_INT )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:529:1: ( RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:530:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER1062); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:547:1: entryRuleUPPER : ruleUPPER EOF ;
    public final void entryRuleUPPER() throws RecognitionException {
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:548:1: ( ruleUPPER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:549:1: ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER1092);
            ruleUPPER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUPPERRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER1099); if (state.failed) return ;

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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:556:1: ruleUPPER : ( ( rule__UPPER__Alternatives ) ) ;
    public final void ruleUPPER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:560:2: ( ( ( rule__UPPER__Alternatives ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:561:1: ( ( rule__UPPER__Alternatives ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:561:1: ( ( rule__UPPER__Alternatives ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:562:1: ( rule__UPPER__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUPPERAccess().getAlternatives()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:563:1: ( rule__UPPER__Alternatives )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:563:2: rule__UPPER__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__UPPER__Alternatives_in_ruleUPPER1125);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:580:1: rule__MultiplicityStringCS__StringBoundsAlternatives_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );
    public final void rule__MultiplicityStringCS__StringBoundsAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:584:1: ( ( '*' ) | ( '+' ) | ( '?' ) )
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
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:585:1: ( '*' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:585:1: ( '*' )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:586:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01167); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:593:6: ( '+' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:593:6: ( '+' )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:594:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); 
                    }
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01187); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:601:6: ( '?' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:601:6: ( '?' )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:602:1: '?'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2()); 
                    }
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01207); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:614:1: rule__TypeRefCS__Alternatives : ( ( ruleTypedRefCS ) | ( ruleWildcardTypeRefCS ) );
    public final void rule__TypeRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:618:1: ( ( ruleTypedRefCS ) | ( ruleWildcardTypeRefCS ) )
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
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:619:1: ( ruleTypedRefCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:619:1: ( ruleTypedRefCS )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:620:1: ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_rule__TypeRefCS__Alternatives1241);
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
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:625:6: ( ruleWildcardTypeRefCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:625:6: ( ruleWildcardTypeRefCS )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:626:1: ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_rule__TypeRefCS__Alternatives1258);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:636:1: rule__ID__Alternatives : ( ( RULE_SIMPLE_ID ) | ( RULE_ESCAPED_ID ) );
    public final void rule__ID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:640:1: ( ( RULE_SIMPLE_ID ) | ( RULE_ESCAPED_ID ) )
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
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:641:1: ( RULE_SIMPLE_ID )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:641:1: ( RULE_SIMPLE_ID )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:642:1: RULE_SIMPLE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                    }
                    match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_rule__ID__Alternatives1290); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:647:6: ( RULE_ESCAPED_ID )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:647:6: ( RULE_ESCAPED_ID )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:648:1: RULE_ESCAPED_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1()); 
                    }
                    match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_rule__ID__Alternatives1307); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:658:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UPPER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:662:1: ( ( RULE_INT ) | ( '*' ) )
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
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:663:1: ( RULE_INT )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:663:1: ( RULE_INT )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:664:1: RULE_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1339); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:669:6: ( '*' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:669:6: ( '*' )
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:670:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__UPPER__Alternatives1357); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:684:1: rule__MultiplicityBoundsCS__Group__0 : rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1 ;
    public final void rule__MultiplicityBoundsCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:688:1: ( rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:689:2: rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__0__Impl_in_rule__MultiplicityBoundsCS__Group__01389);
            rule__MultiplicityBoundsCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__1_in_rule__MultiplicityBoundsCS__Group__01392);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:696:1: rule__MultiplicityBoundsCS__Group__0__Impl : ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) ) ;
    public final void rule__MultiplicityBoundsCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:700:1: ( ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:701:1: ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:701:1: ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:702:1: ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:703:1: ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:703:2: rule__MultiplicityBoundsCS__LowerBoundAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__LowerBoundAssignment_0_in_rule__MultiplicityBoundsCS__Group__0__Impl1419);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:713:1: rule__MultiplicityBoundsCS__Group__1 : rule__MultiplicityBoundsCS__Group__1__Impl ;
    public final void rule__MultiplicityBoundsCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:717:1: ( rule__MultiplicityBoundsCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:718:2: rule__MultiplicityBoundsCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group__1__Impl_in_rule__MultiplicityBoundsCS__Group__11449);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:724:1: rule__MultiplicityBoundsCS__Group__1__Impl : ( ( rule__MultiplicityBoundsCS__Group_1__0 )? ) ;
    public final void rule__MultiplicityBoundsCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:728:1: ( ( ( rule__MultiplicityBoundsCS__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:729:1: ( ( rule__MultiplicityBoundsCS__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:729:1: ( ( rule__MultiplicityBoundsCS__Group_1__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:730:1: ( rule__MultiplicityBoundsCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:731:1: ( rule__MultiplicityBoundsCS__Group_1__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:731:2: rule__MultiplicityBoundsCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__0_in_rule__MultiplicityBoundsCS__Group__1__Impl1476);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:745:1: rule__MultiplicityBoundsCS__Group_1__0 : rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1 ;
    public final void rule__MultiplicityBoundsCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:749:1: ( rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:750:2: rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__0__Impl_in_rule__MultiplicityBoundsCS__Group_1__01511);
            rule__MultiplicityBoundsCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__1_in_rule__MultiplicityBoundsCS__Group_1__01514);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:757:1: rule__MultiplicityBoundsCS__Group_1__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityBoundsCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:761:1: ( ( '..' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:762:1: ( '..' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:762:1: ( '..' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:763:1: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__MultiplicityBoundsCS__Group_1__0__Impl1542); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:776:1: rule__MultiplicityBoundsCS__Group_1__1 : rule__MultiplicityBoundsCS__Group_1__1__Impl ;
    public final void rule__MultiplicityBoundsCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:780:1: ( rule__MultiplicityBoundsCS__Group_1__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:781:2: rule__MultiplicityBoundsCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__Group_1__1__Impl_in_rule__MultiplicityBoundsCS__Group_1__11573);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:787:1: rule__MultiplicityBoundsCS__Group_1__1__Impl : ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) ) ;
    public final void rule__MultiplicityBoundsCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:791:1: ( ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:792:1: ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:792:1: ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:793:1: ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:794:1: ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:794:2: rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1_in_rule__MultiplicityBoundsCS__Group_1__1__Impl1600);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:810:1: rule__PathNameCS__Group__0 : rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 ;
    public final void rule__PathNameCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:814:1: ( rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:815:2: rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__0__Impl_in_rule__PathNameCS__Group__01636);
            rule__PathNameCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__1_in_rule__PathNameCS__Group__01639);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:822:1: rule__PathNameCS__Group__0__Impl : ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) ) ;
    public final void rule__PathNameCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:826:1: ( ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:827:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:827:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:828:1: ( rule__PathNameCS__OwnedPathElementsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:829:1: ( rule__PathNameCS__OwnedPathElementsAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:829:2: rule__PathNameCS__OwnedPathElementsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_0_in_rule__PathNameCS__Group__0__Impl1666);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:839:1: rule__PathNameCS__Group__1 : rule__PathNameCS__Group__1__Impl ;
    public final void rule__PathNameCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:843:1: ( rule__PathNameCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:844:2: rule__PathNameCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group__1__Impl_in_rule__PathNameCS__Group__11696);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:850:1: rule__PathNameCS__Group__1__Impl : ( ( rule__PathNameCS__Group_1__0 )* ) ;
    public final void rule__PathNameCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:854:1: ( ( ( rule__PathNameCS__Group_1__0 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:855:1: ( ( rule__PathNameCS__Group_1__0 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:855:1: ( ( rule__PathNameCS__Group_1__0 )* )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:856:1: ( rule__PathNameCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:857:1: ( rule__PathNameCS__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:857:2: rule__PathNameCS__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__0_in_rule__PathNameCS__Group__1__Impl1723);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:871:1: rule__PathNameCS__Group_1__0 : rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 ;
    public final void rule__PathNameCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:875:1: ( rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:876:2: rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__0__Impl_in_rule__PathNameCS__Group_1__01758);
            rule__PathNameCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__1_in_rule__PathNameCS__Group_1__01761);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:883:1: rule__PathNameCS__Group_1__0__Impl : ( '::' ) ;
    public final void rule__PathNameCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:887:1: ( ( '::' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:888:1: ( '::' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:888:1: ( '::' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:889:1: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__PathNameCS__Group_1__0__Impl1789); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:902:1: rule__PathNameCS__Group_1__1 : rule__PathNameCS__Group_1__1__Impl ;
    public final void rule__PathNameCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:906:1: ( rule__PathNameCS__Group_1__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:907:2: rule__PathNameCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__Group_1__1__Impl_in_rule__PathNameCS__Group_1__11820);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:913:1: rule__PathNameCS__Group_1__1__Impl : ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) ) ;
    public final void rule__PathNameCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:917:1: ( ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:918:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:918:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:919:1: ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:920:1: ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:920:2: rule__PathNameCS__OwnedPathElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_1_1_in_rule__PathNameCS__Group_1__1__Impl1847);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:934:1: rule__TemplateBindingCS__Group__0 : rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1 ;
    public final void rule__TemplateBindingCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:938:1: ( rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:939:2: rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__0__Impl_in_rule__TemplateBindingCS__Group__01881);
            rule__TemplateBindingCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__1_in_rule__TemplateBindingCS__Group__01884);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:946:1: rule__TemplateBindingCS__Group__0__Impl : ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) ) ;
    public final void rule__TemplateBindingCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:950:1: ( ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:951:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:951:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:952:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:953:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:953:2: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0_in_rule__TemplateBindingCS__Group__0__Impl1911);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:963:1: rule__TemplateBindingCS__Group__1 : rule__TemplateBindingCS__Group__1__Impl ;
    public final void rule__TemplateBindingCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:967:1: ( rule__TemplateBindingCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:968:2: rule__TemplateBindingCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group__1__Impl_in_rule__TemplateBindingCS__Group__11941);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:974:1: rule__TemplateBindingCS__Group__1__Impl : ( ( rule__TemplateBindingCS__Group_1__0 )* ) ;
    public final void rule__TemplateBindingCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:978:1: ( ( ( rule__TemplateBindingCS__Group_1__0 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:979:1: ( ( rule__TemplateBindingCS__Group_1__0 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:979:1: ( ( rule__TemplateBindingCS__Group_1__0 )* )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:980:1: ( rule__TemplateBindingCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:981:1: ( rule__TemplateBindingCS__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:981:2: rule__TemplateBindingCS__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_1__0_in_rule__TemplateBindingCS__Group__1__Impl1968);
            	    rule__TemplateBindingCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:995:1: rule__TemplateBindingCS__Group_1__0 : rule__TemplateBindingCS__Group_1__0__Impl rule__TemplateBindingCS__Group_1__1 ;
    public final void rule__TemplateBindingCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:999:1: ( rule__TemplateBindingCS__Group_1__0__Impl rule__TemplateBindingCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1000:2: rule__TemplateBindingCS__Group_1__0__Impl rule__TemplateBindingCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_1__0__Impl_in_rule__TemplateBindingCS__Group_1__02003);
            rule__TemplateBindingCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_1__1_in_rule__TemplateBindingCS__Group_1__02006);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1007:1: rule__TemplateBindingCS__Group_1__0__Impl : ( ',' ) ;
    public final void rule__TemplateBindingCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1011:1: ( ( ',' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1012:1: ( ',' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1012:1: ( ',' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1013:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__TemplateBindingCS__Group_1__0__Impl2034); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1026:1: rule__TemplateBindingCS__Group_1__1 : rule__TemplateBindingCS__Group_1__1__Impl ;
    public final void rule__TemplateBindingCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1030:1: ( rule__TemplateBindingCS__Group_1__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1031:2: rule__TemplateBindingCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__Group_1__1__Impl_in_rule__TemplateBindingCS__Group_1__12065);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1037:1: rule__TemplateBindingCS__Group_1__1__Impl : ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) ) ;
    public final void rule__TemplateBindingCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1041:1: ( ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1042:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1042:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1043:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1044:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1044:2: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1_in_rule__TemplateBindingCS__Group_1__1__Impl2092);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1060:1: rule__TypeParameterCS__Group__0 : rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1 ;
    public final void rule__TypeParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1064:1: ( rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1065:2: rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__0__Impl_in_rule__TypeParameterCS__Group__02128);
            rule__TypeParameterCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__1_in_rule__TypeParameterCS__Group__02131);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1072:1: rule__TypeParameterCS__Group__0__Impl : ( ( rule__TypeParameterCS__NameAssignment_0 ) ) ;
    public final void rule__TypeParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1076:1: ( ( ( rule__TypeParameterCS__NameAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1077:1: ( ( rule__TypeParameterCS__NameAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1077:1: ( ( rule__TypeParameterCS__NameAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1078:1: ( rule__TypeParameterCS__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getNameAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1079:1: ( rule__TypeParameterCS__NameAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1079:2: rule__TypeParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__NameAssignment_0_in_rule__TypeParameterCS__Group__0__Impl2158);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1089:1: rule__TypeParameterCS__Group__1 : rule__TypeParameterCS__Group__1__Impl ;
    public final void rule__TypeParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1093:1: ( rule__TypeParameterCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1094:2: rule__TypeParameterCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group__1__Impl_in_rule__TypeParameterCS__Group__12188);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1100:1: rule__TypeParameterCS__Group__1__Impl : ( ( rule__TypeParameterCS__Group_1__0 )? ) ;
    public final void rule__TypeParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1104:1: ( ( ( rule__TypeParameterCS__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1105:1: ( ( rule__TypeParameterCS__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1105:1: ( ( rule__TypeParameterCS__Group_1__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1106:1: ( rule__TypeParameterCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1107:1: ( rule__TypeParameterCS__Group_1__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1107:2: rule__TypeParameterCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__0_in_rule__TypeParameterCS__Group__1__Impl2215);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1121:1: rule__TypeParameterCS__Group_1__0 : rule__TypeParameterCS__Group_1__0__Impl rule__TypeParameterCS__Group_1__1 ;
    public final void rule__TypeParameterCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1125:1: ( rule__TypeParameterCS__Group_1__0__Impl rule__TypeParameterCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1126:2: rule__TypeParameterCS__Group_1__0__Impl rule__TypeParameterCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__0__Impl_in_rule__TypeParameterCS__Group_1__02250);
            rule__TypeParameterCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__1_in_rule__TypeParameterCS__Group_1__02253);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1133:1: rule__TypeParameterCS__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__TypeParameterCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1137:1: ( ( 'extends' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1138:1: ( 'extends' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1138:1: ( 'extends' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1139:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__TypeParameterCS__Group_1__0__Impl2281); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1152:1: rule__TypeParameterCS__Group_1__1 : rule__TypeParameterCS__Group_1__1__Impl rule__TypeParameterCS__Group_1__2 ;
    public final void rule__TypeParameterCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1156:1: ( rule__TypeParameterCS__Group_1__1__Impl rule__TypeParameterCS__Group_1__2 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1157:2: rule__TypeParameterCS__Group_1__1__Impl rule__TypeParameterCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__1__Impl_in_rule__TypeParameterCS__Group_1__12312);
            rule__TypeParameterCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__2_in_rule__TypeParameterCS__Group_1__12315);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1164:1: rule__TypeParameterCS__Group_1__1__Impl : ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) ) ;
    public final void rule__TypeParameterCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1168:1: ( ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1169:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1169:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1170:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1171:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1171:2: rule__TypeParameterCS__OwnedExtendsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_1_in_rule__TypeParameterCS__Group_1__1__Impl2342);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1181:1: rule__TypeParameterCS__Group_1__2 : rule__TypeParameterCS__Group_1__2__Impl ;
    public final void rule__TypeParameterCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1185:1: ( rule__TypeParameterCS__Group_1__2__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1186:2: rule__TypeParameterCS__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1__2__Impl_in_rule__TypeParameterCS__Group_1__22372);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1192:1: rule__TypeParameterCS__Group_1__2__Impl : ( ( rule__TypeParameterCS__Group_1_2__0 )* ) ;
    public final void rule__TypeParameterCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1196:1: ( ( ( rule__TypeParameterCS__Group_1_2__0 )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1197:1: ( ( rule__TypeParameterCS__Group_1_2__0 )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1197:1: ( ( rule__TypeParameterCS__Group_1_2__0 )* )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1198:1: ( rule__TypeParameterCS__Group_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup_1_2()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1199:1: ( rule__TypeParameterCS__Group_1_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1199:2: rule__TypeParameterCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_2__0_in_rule__TypeParameterCS__Group_1__2__Impl2399);
            	    rule__TypeParameterCS__Group_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1215:1: rule__TypeParameterCS__Group_1_2__0 : rule__TypeParameterCS__Group_1_2__0__Impl rule__TypeParameterCS__Group_1_2__1 ;
    public final void rule__TypeParameterCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1219:1: ( rule__TypeParameterCS__Group_1_2__0__Impl rule__TypeParameterCS__Group_1_2__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1220:2: rule__TypeParameterCS__Group_1_2__0__Impl rule__TypeParameterCS__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_2__0__Impl_in_rule__TypeParameterCS__Group_1_2__02436);
            rule__TypeParameterCS__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_2__1_in_rule__TypeParameterCS__Group_1_2__02439);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1227:1: rule__TypeParameterCS__Group_1_2__0__Impl : ( '&&' ) ;
    public final void rule__TypeParameterCS__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1231:1: ( ( '&&' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1232:1: ( '&&' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1232:1: ( '&&' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1233:1: '&&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0()); 
            }
            match(input,23,FollowSets000.FOLLOW_23_in_rule__TypeParameterCS__Group_1_2__0__Impl2467); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1246:1: rule__TypeParameterCS__Group_1_2__1 : rule__TypeParameterCS__Group_1_2__1__Impl ;
    public final void rule__TypeParameterCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1250:1: ( rule__TypeParameterCS__Group_1_2__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1251:2: rule__TypeParameterCS__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__Group_1_2__1__Impl_in_rule__TypeParameterCS__Group_1_2__12498);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1257:1: rule__TypeParameterCS__Group_1_2__1__Impl : ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) ) ;
    public final void rule__TypeParameterCS__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1261:1: ( ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1262:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1262:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1263:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_2_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1264:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1264:2: rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1_in_rule__TypeParameterCS__Group_1_2__1__Impl2525);
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


    // $ANTLR start "rule__TypedTypeRefCS__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1278:1: rule__TypedTypeRefCS__Group__0 : rule__TypedTypeRefCS__Group__0__Impl rule__TypedTypeRefCS__Group__1 ;
    public final void rule__TypedTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1282:1: ( rule__TypedTypeRefCS__Group__0__Impl rule__TypedTypeRefCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1283:2: rule__TypedTypeRefCS__Group__0__Impl rule__TypedTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group__0__Impl_in_rule__TypedTypeRefCS__Group__02559);
            rule__TypedTypeRefCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group__1_in_rule__TypedTypeRefCS__Group__02562);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1290:1: rule__TypedTypeRefCS__Group__0__Impl : ( ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 ) ) ;
    public final void rule__TypedTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1294:1: ( ( ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1295:1: ( ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1295:1: ( ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1296:1: ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1297:1: ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1297:2: rule__TypedTypeRefCS__OwnedPathNameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__OwnedPathNameAssignment_0_in_rule__TypedTypeRefCS__Group__0__Impl2589);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1307:1: rule__TypedTypeRefCS__Group__1 : rule__TypedTypeRefCS__Group__1__Impl ;
    public final void rule__TypedTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1311:1: ( rule__TypedTypeRefCS__Group__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1312:2: rule__TypedTypeRefCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group__1__Impl_in_rule__TypedTypeRefCS__Group__12619);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1318:1: rule__TypedTypeRefCS__Group__1__Impl : ( ( rule__TypedTypeRefCS__Group_1__0 )? ) ;
    public final void rule__TypedTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1322:1: ( ( ( rule__TypedTypeRefCS__Group_1__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1323:1: ( ( rule__TypedTypeRefCS__Group_1__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1323:1: ( ( rule__TypedTypeRefCS__Group_1__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1324:1: ( rule__TypedTypeRefCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getGroup_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1325:1: ( rule__TypedTypeRefCS__Group_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==24) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1325:2: rule__TypedTypeRefCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group_1__0_in_rule__TypedTypeRefCS__Group__1__Impl2646);
                    rule__TypedTypeRefCS__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getGroup_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__TypedTypeRefCS__Group_1__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1339:1: rule__TypedTypeRefCS__Group_1__0 : rule__TypedTypeRefCS__Group_1__0__Impl rule__TypedTypeRefCS__Group_1__1 ;
    public final void rule__TypedTypeRefCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1343:1: ( rule__TypedTypeRefCS__Group_1__0__Impl rule__TypedTypeRefCS__Group_1__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1344:2: rule__TypedTypeRefCS__Group_1__0__Impl rule__TypedTypeRefCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group_1__0__Impl_in_rule__TypedTypeRefCS__Group_1__02681);
            rule__TypedTypeRefCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group_1__1_in_rule__TypedTypeRefCS__Group_1__02684);
            rule__TypedTypeRefCS__Group_1__1();

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
    // $ANTLR end "rule__TypedTypeRefCS__Group_1__0"


    // $ANTLR start "rule__TypedTypeRefCS__Group_1__0__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1351:1: rule__TypedTypeRefCS__Group_1__0__Impl : ( '(' ) ;
    public final void rule__TypedTypeRefCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1355:1: ( ( '(' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1356:1: ( '(' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1356:1: ( '(' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1357:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__TypedTypeRefCS__Group_1__0__Impl2712); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group_1__0__Impl"


    // $ANTLR start "rule__TypedTypeRefCS__Group_1__1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1370:1: rule__TypedTypeRefCS__Group_1__1 : rule__TypedTypeRefCS__Group_1__1__Impl rule__TypedTypeRefCS__Group_1__2 ;
    public final void rule__TypedTypeRefCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1374:1: ( rule__TypedTypeRefCS__Group_1__1__Impl rule__TypedTypeRefCS__Group_1__2 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1375:2: rule__TypedTypeRefCS__Group_1__1__Impl rule__TypedTypeRefCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group_1__1__Impl_in_rule__TypedTypeRefCS__Group_1__12743);
            rule__TypedTypeRefCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group_1__2_in_rule__TypedTypeRefCS__Group_1__12746);
            rule__TypedTypeRefCS__Group_1__2();

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
    // $ANTLR end "rule__TypedTypeRefCS__Group_1__1"


    // $ANTLR start "rule__TypedTypeRefCS__Group_1__1__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1382:1: rule__TypedTypeRefCS__Group_1__1__Impl : ( ( rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 ) ) ;
    public final void rule__TypedTypeRefCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1386:1: ( ( ( rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1387:1: ( ( rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1387:1: ( ( rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1388:1: ( rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1389:1: ( rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1389:2: rule__TypedTypeRefCS__OwnedBindingAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__OwnedBindingAssignment_1_1_in_rule__TypedTypeRefCS__Group_1__1__Impl2773);
            rule__TypedTypeRefCS__OwnedBindingAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group_1__1__Impl"


    // $ANTLR start "rule__TypedTypeRefCS__Group_1__2"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1399:1: rule__TypedTypeRefCS__Group_1__2 : rule__TypedTypeRefCS__Group_1__2__Impl ;
    public final void rule__TypedTypeRefCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1403:1: ( rule__TypedTypeRefCS__Group_1__2__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1404:2: rule__TypedTypeRefCS__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypedTypeRefCS__Group_1__2__Impl_in_rule__TypedTypeRefCS__Group_1__22803);
            rule__TypedTypeRefCS__Group_1__2__Impl();

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
    // $ANTLR end "rule__TypedTypeRefCS__Group_1__2"


    // $ANTLR start "rule__TypedTypeRefCS__Group_1__2__Impl"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1410:1: rule__TypedTypeRefCS__Group_1__2__Impl : ( ')' ) ;
    public final void rule__TypedTypeRefCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1414:1: ( ( ')' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1415:1: ( ')' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1415:1: ( ')' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1416:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_2()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__TypedTypeRefCS__Group_1__2__Impl2831); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group_1__2__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1435:1: rule__WildcardTypeRefCS__Group__0 : rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1 ;
    public final void rule__WildcardTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1439:1: ( rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1440:2: rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__0__Impl_in_rule__WildcardTypeRefCS__Group__02868);
            rule__WildcardTypeRefCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__1_in_rule__WildcardTypeRefCS__Group__02871);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1447:1: rule__WildcardTypeRefCS__Group__0__Impl : ( () ) ;
    public final void rule__WildcardTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1451:1: ( ( () ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1452:1: ( () )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1452:1: ( () )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1453:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1454:1: ()
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1456:1: 
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1466:1: rule__WildcardTypeRefCS__Group__1 : rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2 ;
    public final void rule__WildcardTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1470:1: ( rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1471:2: rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__1__Impl_in_rule__WildcardTypeRefCS__Group__12929);
            rule__WildcardTypeRefCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__2_in_rule__WildcardTypeRefCS__Group__12932);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1478:1: rule__WildcardTypeRefCS__Group__1__Impl : ( '?' ) ;
    public final void rule__WildcardTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1482:1: ( ( '?' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1483:1: ( '?' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1483:1: ( '?' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1484:1: '?'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__WildcardTypeRefCS__Group__1__Impl2960); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1497:1: rule__WildcardTypeRefCS__Group__2 : rule__WildcardTypeRefCS__Group__2__Impl ;
    public final void rule__WildcardTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1501:1: ( rule__WildcardTypeRefCS__Group__2__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1502:2: rule__WildcardTypeRefCS__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group__2__Impl_in_rule__WildcardTypeRefCS__Group__22991);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1508:1: rule__WildcardTypeRefCS__Group__2__Impl : ( ( rule__WildcardTypeRefCS__Group_2__0 )? ) ;
    public final void rule__WildcardTypeRefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1512:1: ( ( ( rule__WildcardTypeRefCS__Group_2__0 )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1513:1: ( ( rule__WildcardTypeRefCS__Group_2__0 )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1513:1: ( ( rule__WildcardTypeRefCS__Group_2__0 )? )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1514:1: ( rule__WildcardTypeRefCS__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1515:1: ( rule__WildcardTypeRefCS__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1515:2: rule__WildcardTypeRefCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2__0_in_rule__WildcardTypeRefCS__Group__2__Impl3018);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1531:1: rule__WildcardTypeRefCS__Group_2__0 : rule__WildcardTypeRefCS__Group_2__0__Impl rule__WildcardTypeRefCS__Group_2__1 ;
    public final void rule__WildcardTypeRefCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1535:1: ( rule__WildcardTypeRefCS__Group_2__0__Impl rule__WildcardTypeRefCS__Group_2__1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1536:2: rule__WildcardTypeRefCS__Group_2__0__Impl rule__WildcardTypeRefCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2__0__Impl_in_rule__WildcardTypeRefCS__Group_2__03055);
            rule__WildcardTypeRefCS__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2__1_in_rule__WildcardTypeRefCS__Group_2__03058);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1543:1: rule__WildcardTypeRefCS__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__WildcardTypeRefCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1547:1: ( ( 'extends' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1548:1: ( 'extends' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1548:1: ( 'extends' )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1549:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__WildcardTypeRefCS__Group_2__0__Impl3086); if (state.failed) return ;
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1562:1: rule__WildcardTypeRefCS__Group_2__1 : rule__WildcardTypeRefCS__Group_2__1__Impl ;
    public final void rule__WildcardTypeRefCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1566:1: ( rule__WildcardTypeRefCS__Group_2__1__Impl )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1567:2: rule__WildcardTypeRefCS__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__Group_2__1__Impl_in_rule__WildcardTypeRefCS__Group_2__13117);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1573:1: rule__WildcardTypeRefCS__Group_2__1__Impl : ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) ) ;
    public final void rule__WildcardTypeRefCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1577:1: ( ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1578:1: ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1578:1: ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1579:1: ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_1()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1580:1: ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1580:2: rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1_in_rule__WildcardTypeRefCS__Group_2__1__Impl3144);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1595:1: rule__MultiplicityBoundsCS__LowerBoundAssignment_0 : ( ruleLOWER ) ;
    public final void rule__MultiplicityBoundsCS__LowerBoundAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1599:1: ( ( ruleLOWER ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1600:1: ( ruleLOWER )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1600:1: ( ruleLOWER )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1601:1: ruleLOWER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_rule__MultiplicityBoundsCS__LowerBoundAssignment_03183);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1610:1: rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 : ( ruleUPPER ) ;
    public final void rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1614:1: ( ( ruleUPPER ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1615:1: ( ruleUPPER )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1615:1: ( ruleUPPER )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1616:1: ruleUPPER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_13214);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1626:1: rule__MultiplicityStringCS__StringBoundsAssignment : ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) ) ;
    public final void rule__MultiplicityStringCS__StringBoundsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1630:1: ( ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1631:1: ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1631:1: ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1632:1: ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1633:1: ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1633:2: rule__MultiplicityStringCS__StringBoundsAlternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiplicityStringCS__StringBoundsAlternatives_0_in_rule__MultiplicityStringCS__StringBoundsAssignment3246);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1642:1: rule__PathNameCS__OwnedPathElementsAssignment_0 : ( ruleFirstPathElementCS ) ;
    public final void rule__PathNameCS__OwnedPathElementsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1646:1: ( ( ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1647:1: ( ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1647:1: ( ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1648:1: ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_03279);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1657:1: rule__PathNameCS__OwnedPathElementsAssignment_1_1 : ( ruleNextPathElementCS ) ;
    public final void rule__PathNameCS__OwnedPathElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1661:1: ( ( ruleNextPathElementCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1662:1: ( ruleNextPathElementCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1662:1: ( ruleNextPathElementCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1663:1: ruleNextPathElementCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_1_13310);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1672:1: rule__FirstPathElementCS__ReferredElementAssignment : ( ( ruleUnrestrictedName ) ) ;
    public final void rule__FirstPathElementCS__ReferredElementAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1676:1: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1677:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1677:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1678:1: ( ruleUnrestrictedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1679:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1680:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_rule__FirstPathElementCS__ReferredElementAssignment3345);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1691:1: rule__NextPathElementCS__ReferredElementAssignment : ( ( ruleUnreservedName ) ) ;
    public final void rule__NextPathElementCS__ReferredElementAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1695:1: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1696:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1696:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1697:1: ( ruleUnreservedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
            }
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1698:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1699:1: ruleUnreservedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementUnreservedNameParserRuleCall_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_rule__NextPathElementCS__ReferredElementAssignment3384);
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


    // $ANTLR start "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1710:1: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 : ( ruleTemplateParameterSubstitutionCS ) ;
    public final void rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1714:1: ( ( ruleTemplateParameterSubstitutionCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1715:1: ( ruleTemplateParameterSubstitutionCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1715:1: ( ruleTemplateParameterSubstitutionCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1716:1: ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_03419);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1725:1: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 : ( ruleTemplateParameterSubstitutionCS ) ;
    public final void rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1729:1: ( ( ruleTemplateParameterSubstitutionCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1730:1: ( ruleTemplateParameterSubstitutionCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1730:1: ( ruleTemplateParameterSubstitutionCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1731:1: ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_13450);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1740:1: rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment : ( ruleTypeRefCS ) ;
    public final void rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1744:1: ( ( ruleTypeRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1745:1: ( ruleTypeRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1745:1: ( ruleTypeRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1746:1: ruleTypeRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment3481);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1757:1: rule__TypeParameterCS__NameAssignment_0 : ( ruleUnrestrictedName ) ;
    public final void rule__TypeParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1761:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1762:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1762:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1763:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_rule__TypeParameterCS__NameAssignment_03514);
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1772:1: rule__TypeParameterCS__OwnedExtendsAssignment_1_1 : ( ruleTypedRefCS ) ;
    public final void rule__TypeParameterCS__OwnedExtendsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1776:1: ( ( ruleTypedRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1777:1: ( ruleTypedRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1777:1: ( ruleTypedRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1778:1: ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_13545);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0()); 
            }

            }


            }

        }
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
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1787:1: rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 : ( ruleTypedRefCS ) ;
    public final void rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1791:1: ( ( ruleTypedRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1792:1: ( ruleTypedRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1792:1: ( ruleTypedRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1793:1: ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_2_13576);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__TypedTypeRefCS__OwnedPathNameAssignment_0"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1802:1: rule__TypedTypeRefCS__OwnedPathNameAssignment_0 : ( rulePathNameCS ) ;
    public final void rule__TypedTypeRefCS__OwnedPathNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1806:1: ( ( rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1807:1: ( rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1807:1: ( rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1808:1: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_rule__TypedTypeRefCS__OwnedPathNameAssignment_03607);
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


    // $ANTLR start "rule__TypedTypeRefCS__OwnedBindingAssignment_1_1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1817:1: rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 : ( ruleTemplateBindingCS ) ;
    public final void rule__TypedTypeRefCS__OwnedBindingAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1821:1: ( ( ruleTemplateBindingCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1822:1: ( ruleTemplateBindingCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1822:1: ( ruleTemplateBindingCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1823:1: ruleTemplateBindingCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_rule__TypedTypeRefCS__OwnedBindingAssignment_1_13638);
            ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__OwnedBindingAssignment_1_1"


    // $ANTLR start "rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1"
    // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1832:1: rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 : ( ruleTypedRefCS ) ;
    public final void rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1836:1: ( ( ruleTypedRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1837:1: ( ruleTypedRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1837:1: ( ruleTypedRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.base.ui/src-gen/org/eclipse/ocl/xtext/base/ui/contentassist/antlr/internal/InternalBase.g:1838:1: ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_13669);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0()); 
            }

            }


            }

        }
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
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__0_in_ruleMultiplicityBoundsCS100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS131 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityStringCS__StringBoundsAssignment_in_ruleMultiplicityStringCS164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS191 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__0_in_rulePathNameCS224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS251 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FirstPathElementCS__ReferredElementAssignment_in_ruleFirstPathElementCS284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS311 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NextPathElementCS__ReferredElementAssignment_in_ruleNextPathElementCS344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS371 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBindingCS378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__0_in_ruleTemplateBindingCS404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS431 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment_in_ruleTemplateParameterSubstitutionCS464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS493 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameterCS500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__0_in_ruleTypeParameterCS526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS553 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRefCS560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRefCS__Alternatives_in_ruleTypeRefCS586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS613 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedRefCS620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS672 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedTypeRefCS679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group__0_in_ruleTypedTypeRefCS705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName732 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName791 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleUnrestrictedName824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS850 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcardTypeRefCS857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__0_in_ruleWildcardTypeRefCS883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID910 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ID__Alternatives_in_ruleID943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier970 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier1003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER1029 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER1036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER1062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER1092 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER1099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UPPER__Alternatives_in_ruleUPPER1125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01167 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__MultiplicityStringCS__StringBoundsAlternatives_01207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_rule__TypeRefCS__Alternatives1241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_rule__TypeRefCS__Alternatives1258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_rule__ID__Alternatives1290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_rule__ID__Alternatives1307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__UPPER__Alternatives1357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__0__Impl_in_rule__MultiplicityBoundsCS__Group__01389 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__1_in_rule__MultiplicityBoundsCS__Group__01392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__LowerBoundAssignment_0_in_rule__MultiplicityBoundsCS__Group__0__Impl1419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group__1__Impl_in_rule__MultiplicityBoundsCS__Group__11449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__0_in_rule__MultiplicityBoundsCS__Group__1__Impl1476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__0__Impl_in_rule__MultiplicityBoundsCS__Group_1__01511 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__1_in_rule__MultiplicityBoundsCS__Group_1__01514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__MultiplicityBoundsCS__Group_1__0__Impl1542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__Group_1__1__Impl_in_rule__MultiplicityBoundsCS__Group_1__11573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1_in_rule__MultiplicityBoundsCS__Group_1__1__Impl1600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__0__Impl_in_rule__PathNameCS__Group__01636 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__1_in_rule__PathNameCS__Group__01639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_0_in_rule__PathNameCS__Group__0__Impl1666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group__1__Impl_in_rule__PathNameCS__Group__11696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__0_in_rule__PathNameCS__Group__1__Impl1723 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__0__Impl_in_rule__PathNameCS__Group_1__01758 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__1_in_rule__PathNameCS__Group_1__01761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__PathNameCS__Group_1__0__Impl1789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__Group_1__1__Impl_in_rule__PathNameCS__Group_1__11820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PathNameCS__OwnedPathElementsAssignment_1_1_in_rule__PathNameCS__Group_1__1__Impl1847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__0__Impl_in_rule__TemplateBindingCS__Group__01881 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__1_in_rule__TemplateBindingCS__Group__01884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0_in_rule__TemplateBindingCS__Group__0__Impl1911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group__1__Impl_in_rule__TemplateBindingCS__Group__11941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_1__0_in_rule__TemplateBindingCS__Group__1__Impl1968 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_1__0__Impl_in_rule__TemplateBindingCS__Group_1__02003 = new BitSet(new long[]{0x0000000000040060L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_1__1_in_rule__TemplateBindingCS__Group_1__02006 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__TemplateBindingCS__Group_1__0__Impl2034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__Group_1__1__Impl_in_rule__TemplateBindingCS__Group_1__12065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1_in_rule__TemplateBindingCS__Group_1__1__Impl2092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__0__Impl_in_rule__TypeParameterCS__Group__02128 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__1_in_rule__TypeParameterCS__Group__02131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__NameAssignment_0_in_rule__TypeParameterCS__Group__0__Impl2158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group__1__Impl_in_rule__TypeParameterCS__Group__12188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__0_in_rule__TypeParameterCS__Group__1__Impl2215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__0__Impl_in_rule__TypeParameterCS__Group_1__02250 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__1_in_rule__TypeParameterCS__Group_1__02253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__TypeParameterCS__Group_1__0__Impl2281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__1__Impl_in_rule__TypeParameterCS__Group_1__12312 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__2_in_rule__TypeParameterCS__Group_1__12315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_1_in_rule__TypeParameterCS__Group_1__1__Impl2342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1__2__Impl_in_rule__TypeParameterCS__Group_1__22372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_2__0_in_rule__TypeParameterCS__Group_1__2__Impl2399 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_2__0__Impl_in_rule__TypeParameterCS__Group_1_2__02436 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_2__1_in_rule__TypeParameterCS__Group_1_2__02439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__TypeParameterCS__Group_1_2__0__Impl2467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__Group_1_2__1__Impl_in_rule__TypeParameterCS__Group_1_2__12498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1_in_rule__TypeParameterCS__Group_1_2__1__Impl2525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group__0__Impl_in_rule__TypedTypeRefCS__Group__02559 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group__1_in_rule__TypedTypeRefCS__Group__02562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__OwnedPathNameAssignment_0_in_rule__TypedTypeRefCS__Group__0__Impl2589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group__1__Impl_in_rule__TypedTypeRefCS__Group__12619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group_1__0_in_rule__TypedTypeRefCS__Group__1__Impl2646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group_1__0__Impl_in_rule__TypedTypeRefCS__Group_1__02681 = new BitSet(new long[]{0x0000000000040060L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group_1__1_in_rule__TypedTypeRefCS__Group_1__02684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__TypedTypeRefCS__Group_1__0__Impl2712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group_1__1__Impl_in_rule__TypedTypeRefCS__Group_1__12743 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group_1__2_in_rule__TypedTypeRefCS__Group_1__12746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__OwnedBindingAssignment_1_1_in_rule__TypedTypeRefCS__Group_1__1__Impl2773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypedTypeRefCS__Group_1__2__Impl_in_rule__TypedTypeRefCS__Group_1__22803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__TypedTypeRefCS__Group_1__2__Impl2831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__0__Impl_in_rule__WildcardTypeRefCS__Group__02868 = new BitSet(new long[]{0x0000000000040060L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__1_in_rule__WildcardTypeRefCS__Group__02871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__1__Impl_in_rule__WildcardTypeRefCS__Group__12929 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__2_in_rule__WildcardTypeRefCS__Group__12932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__WildcardTypeRefCS__Group__1__Impl2960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group__2__Impl_in_rule__WildcardTypeRefCS__Group__22991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2__0_in_rule__WildcardTypeRefCS__Group__2__Impl3018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2__0__Impl_in_rule__WildcardTypeRefCS__Group_2__03055 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2__1_in_rule__WildcardTypeRefCS__Group_2__03058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__WildcardTypeRefCS__Group_2__0__Impl3086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__Group_2__1__Impl_in_rule__WildcardTypeRefCS__Group_2__13117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1_in_rule__WildcardTypeRefCS__Group_2__1__Impl3144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_rule__MultiplicityBoundsCS__LowerBoundAssignment_03183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_rule__MultiplicityBoundsCS__UpperBoundAssignment_1_13214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiplicityStringCS__StringBoundsAlternatives_0_in_rule__MultiplicityStringCS__StringBoundsAssignment3246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_03279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rule__PathNameCS__OwnedPathElementsAssignment_1_13310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_rule__FirstPathElementCS__ReferredElementAssignment3345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_rule__NextPathElementCS__ReferredElementAssignment3384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_03419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_13450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment3481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_rule__TypeParameterCS__NameAssignment_03514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_13545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_rule__TypeParameterCS__OwnedExtendsAssignment_1_2_13576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_rule__TypedTypeRefCS__OwnedPathNameAssignment_03607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_rule__TypedTypeRefCS__OwnedBindingAssignment_1_13638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_13669 = new BitSet(new long[]{0x0000000000000002L});
    }


}