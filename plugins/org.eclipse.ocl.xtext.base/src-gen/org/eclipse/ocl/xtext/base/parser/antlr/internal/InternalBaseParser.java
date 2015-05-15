package org.eclipse.ocl.xtext.base.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBaseParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_SINGLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'..'", "'['", "'|?'", "'|1'", "']'", "'*'", "'+'", "'?'", "'::'", "','", "'extends'", "'&&'", "'('", "')'"
    };
    public static final int RULE_ML_SINGLE_QUOTED_STRING=11;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int RULE_ESCAPED_CHARACTER=7;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int RULE_SINGLE_QUOTED_STRING=10;
    public static final int T__20=20;
    public static final int RULE_ESCAPED_ID=5;
    public static final int RULE_DOUBLE_QUOTED_STRING=9;
    public static final int RULE_SL_COMMENT=13;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=12;
    public static final int RULE_LETTER_CHARACTER=8;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_SIMPLE_ID=4;
    public static final int RULE_INT=6;
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
    public String getGrammarFileName() { return "../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private BaseGrammarAccess grammarAccess;
     	
        public InternalBaseParser(TokenStream input, BaseGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MultiplicityBoundsCS";	
       	}
       	
       	@Override
       	protected BaseGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMultiplicityBoundsCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:73:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:74:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:75:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS81);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS91); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicityBoundsCS"


    // $ANTLR start "ruleMultiplicityBoundsCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:82:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:85:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:86:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:86:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:86:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:86:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:87:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:87:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:88:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS137);
            lv_lowerBound_0_0=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
              	        }
                     		set(
                     			current, 
                     			"lowerBound",
                      		lv_lowerBound_0_0, 
                      		"LOWER");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:104:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:104:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiplicityBoundsCS150); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:108:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:109:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:109:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:110:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS171);
                    lv_upperBound_2_0=ruleUPPER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
                      	        }
                             		set(
                             			current, 
                             			"upperBound",
                              		lv_upperBound_2_0, 
                              		"UPPER");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicityBoundsCS"


    // $ANTLR start "entryRuleMultiplicityCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:134:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:135:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:136:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS209);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityCS219); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicityCS"


    // $ANTLR start "ruleMultiplicityCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:143:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token lv_isNullFree_4_0=null;
        Token otherlv_5=null;
        EObject this_MultiplicityBoundsCS_1 = null;

        EObject this_MultiplicityStringCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:146:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:147:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:147:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:147:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiplicityCS256); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:151:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_INT) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=21 && LA2_0<=23)) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:152:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS282);
                    this_MultiplicityBoundsCS_1=ruleMultiplicityBoundsCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MultiplicityBoundsCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:165:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS312);
                    this_MultiplicityStringCS_2=ruleMultiplicityStringCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MultiplicityStringCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:176:2: (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )?
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            else if ( (LA3_0==19) ) {
                alt3=2;
            }
            switch (alt3) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:176:4: otherlv_3= '|?'
                    {
                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMultiplicityCS325); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:181:6: ( (lv_isNullFree_4_0= '|1' ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:181:6: ( (lv_isNullFree_4_0= '|1' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:182:1: (lv_isNullFree_4_0= '|1' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:182:1: (lv_isNullFree_4_0= '|1' )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:183:3: lv_isNullFree_4_0= '|1'
                    {
                    lv_isNullFree_4_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMultiplicityCS349); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isNullFree_4_0, grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMultiplicityCSRule());
                      	        }
                             		setWithLastConsumed(current, "isNullFree", true, "|1");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMultiplicityCS376); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicityCS"


    // $ANTLR start "entryRuleMultiplicityStringCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:208:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:209:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:210:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS412);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS422); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicityStringCS"


    // $ANTLR start "ruleMultiplicityStringCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:217:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:220:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:221:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:221:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:222:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:222:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:223:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:223:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt4=1;
                }
                break;
            case 22:
                {
                alt4=2;
                }
                break;
            case 23:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:224:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMultiplicityStringCS466); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_stringBounds_0_1, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
                      	        }
                             		setWithLastConsumed(current, "stringBounds", lv_stringBounds_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:236:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMultiplicityStringCS495); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_stringBounds_0_2, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
                      	        }
                             		setWithLastConsumed(current, "stringBounds", lv_stringBounds_0_2, null);
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:248:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMultiplicityStringCS524); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_stringBounds_0_3, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
                      	        }
                             		setWithLastConsumed(current, "stringBounds", lv_stringBounds_0_3, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicityStringCS"


    // $ANTLR start "entryRulePathNameCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:271:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:272:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:273:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS575);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS585); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathNameCS"


    // $ANTLR start "rulePathNameCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:280:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:283:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:284:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:284:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:284:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:284:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:285:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:285:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:286:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS631);
            lv_ownedPathElements_0_0=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPathNameCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPathElements",
                      		lv_ownedPathElements_0_0, 
                      		"FirstPathElementCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:302:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==24) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:302:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_rulePathNameCS644); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:306:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:307:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:307:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:308:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS665);
            	    lv_ownedPathElements_2_0=ruleNextPathElementCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPathNameCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPathElements",
            	              		lv_ownedPathElements_2_0, 
            	              		"NextPathElementCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathNameCS"


    // $ANTLR start "entryRuleFirstPathElementCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:332:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:333:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:334:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS703);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS713); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFirstPathElementCS"


    // $ANTLR start "ruleFirstPathElementCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:341:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:344:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:345:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:345:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:346:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:346:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:347:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFirstPathElementCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS764);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFirstPathElementCS"


    // $ANTLR start "entryRuleNextPathElementCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:371:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:372:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:373:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS799);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS809); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNextPathElementCS"


    // $ANTLR start "ruleNextPathElementCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:380:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:383:28: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:384:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:384:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:385:1: ( ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:385:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:386:3: ruleUnreservedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getNextPathElementCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS860);
            ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNextPathElementCS"


    // $ANTLR start "entryRuleTemplateBindingCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:410:1: entryRuleTemplateBindingCS returns [EObject current=null] : iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF ;
    public final EObject entryRuleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBindingCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:411:2: (iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:412:2: iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateBindingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS895);
            iv_ruleTemplateBindingCS=ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateBindingCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateBindingCS905); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateBindingCS"


    // $ANTLR start "ruleTemplateBindingCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:419:1: ruleTemplateBindingCS returns [EObject current=null] : ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedSubstitutions_0_0 = null;

        EObject lv_ownedSubstitutions_2_0 = null;

        EObject lv_ownedMultiplicity_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:422:28: ( ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:423:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:423:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:423:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:423:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:424:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:424:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:425:3: lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS951);
            lv_ownedSubstitutions_0_0=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedSubstitutions",
                      		lv_ownedSubstitutions_0_0, 
                      		"TemplateParameterSubstitutionCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:441:2: (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:441:4: otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTemplateBindingCS964); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:445:1: ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:446:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:446:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:447:3: lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS985);
            	    lv_ownedSubstitutions_2_0=ruleTemplateParameterSubstitutionCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedSubstitutions",
            	              		lv_ownedSubstitutions_2_0, 
            	              		"TemplateParameterSubstitutionCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:463:4: ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:464:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:464:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:465:3: lv_ownedMultiplicity_3_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTemplateBindingCS1008);
                    lv_ownedMultiplicity_3_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedMultiplicity",
                              		lv_ownedMultiplicity_3_0, 
                              		"MultiplicityCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemplateBindingCS"


    // $ANTLR start "entryRuleTemplateParameterSubstitutionCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:489:1: entryRuleTemplateParameterSubstitutionCS returns [EObject current=null] : iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF ;
    public final EObject entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateParameterSubstitutionCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:490:2: (iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:491:2: iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS1045);
            iv_ruleTemplateParameterSubstitutionCS=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateParameterSubstitutionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS1055); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateParameterSubstitutionCS"


    // $ANTLR start "ruleTemplateParameterSubstitutionCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:498:1: ruleTemplateParameterSubstitutionCS returns [EObject current=null] : ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) ;
    public final EObject ruleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedActualParameter_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:501:28: ( ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:502:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:502:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:503:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:503:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:504:3: lv_ownedActualParameter_0_0= ruleTypeRefCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS1100);
            lv_ownedActualParameter_0_0=ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTemplateParameterSubstitutionCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedActualParameter",
                      		lv_ownedActualParameter_0_0, 
                      		"TypeRefCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemplateParameterSubstitutionCS"


    // $ANTLR start "entryRuleTypeParameterCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:530:1: entryRuleTypeParameterCS returns [EObject current=null] : iv_ruleTypeParameterCS= ruleTypeParameterCS EOF ;
    public final EObject entryRuleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameterCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:531:2: (iv_ruleTypeParameterCS= ruleTypeParameterCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:532:2: iv_ruleTypeParameterCS= ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS1137);
            iv_ruleTypeParameterCS=ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeParameterCS1147); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeParameterCS"


    // $ANTLR start "ruleTypeParameterCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:539:1: ruleTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) ;
    public final EObject ruleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedExtends_2_0 = null;

        EObject lv_ownedExtends_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:542:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:543:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:543:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:543:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:543:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:544:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:544:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:545:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS1193);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:561:2: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==26) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:561:4: otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    {
                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTypeParameterCS1206); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:565:1: ( (lv_ownedExtends_2_0= ruleTypedRefCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:566:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:566:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:567:3: lv_ownedExtends_2_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS1227);
                    lv_ownedExtends_2_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedExtends",
                              		lv_ownedExtends_2_0, 
                              		"TypedRefCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:583:2: (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==27) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:583:4: otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTypeParameterCS1240); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:587:1: ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:588:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:588:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:589:3: lv_ownedExtends_4_0= ruleTypedRefCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS1261);
                    	    lv_ownedExtends_4_0=ruleTypedRefCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedExtends",
                    	              		lv_ownedExtends_4_0, 
                    	              		"TypedRefCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeParameterCS"


    // $ANTLR start "entryRuleTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:613:1: entryRuleTypeRefCS returns [EObject current=null] : iv_ruleTypeRefCS= ruleTypeRefCS EOF ;
    public final EObject entryRuleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:614:2: (iv_ruleTypeRefCS= ruleTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:615:2: iv_ruleTypeRefCS= ruleTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS1301);
            iv_ruleTypeRefCS=ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRefCS1311); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRefCS"


    // $ANTLR start "ruleTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:622:1: ruleTypeRefCS returns [EObject current=null] : (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) ;
    public final EObject ruleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedRefCS_0 = null;

        EObject this_WildcardTypeRefCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:625:28: ( (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:626:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:626:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=RULE_SIMPLE_ID && LA10_0<=RULE_ESCAPED_ID)) ) {
                alt10=1;
            }
            else if ( (LA10_0==23) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:627:2: this_TypedRefCS_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeRefCS1361);
                    this_TypedRefCS_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypedRefCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:640:2: this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS1391);
                    this_WildcardTypeRefCS_1=ruleWildcardTypeRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_WildcardTypeRefCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeRefCS"


    // $ANTLR start "entryRuleTypedRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:659:1: entryRuleTypedRefCS returns [EObject current=null] : iv_ruleTypedRefCS= ruleTypedRefCS EOF ;
    public final EObject entryRuleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:660:2: (iv_ruleTypedRefCS= ruleTypedRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:661:2: iv_ruleTypedRefCS= ruleTypedRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS1426);
            iv_ruleTypedRefCS=ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedRefCS1436); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedRefCS"


    // $ANTLR start "ruleTypedRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:668:1: ruleTypedRefCS returns [EObject current=null] : this_TypedTypeRefCS_0= ruleTypedTypeRefCS ;
    public final EObject ruleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedTypeRefCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:671:28: (this_TypedTypeRefCS_0= ruleTypedTypeRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:673:2: this_TypedTypeRefCS_0= ruleTypedTypeRefCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS1485);
            this_TypedTypeRefCS_0=ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypedTypeRefCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedRefCS"


    // $ANTLR start "entryRuleTypedTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:692:1: entryRuleTypedTypeRefCS returns [EObject current=null] : iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF ;
    public final EObject entryRuleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:693:2: (iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:694:2: iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS1519);
            iv_ruleTypedTypeRefCS=ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedTypeRefCS1529); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedTypeRefCS"


    // $ANTLR start "ruleTypedTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:701:1: ruleTypedTypeRefCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedBinding_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:704:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:705:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:705:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:705:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:705:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:706:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:706:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:707:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypedTypeRefCS1575);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPathName",
                      		lv_ownedPathName_0_0, 
                      		"PathNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:723:2: (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:723:4: otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTypedTypeRefCS1588); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:727:1: ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:728:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:728:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:729:3: lv_ownedBinding_2_0= ruleTemplateBindingCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_ruleTypedTypeRefCS1609);
                    lv_ownedBinding_2_0=ruleTemplateBindingCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedBinding",
                              		lv_ownedBinding_2_0, 
                              		"TemplateBindingCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTypedTypeRefCS1621); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedTypeRefCS"


    // $ANTLR start "entryRuleUnreservedName"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:757:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:758:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:759:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName1660);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName1671); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnreservedName"


    // $ANTLR start "ruleUnreservedName"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:766:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_UnrestrictedName_0= ruleUnrestrictedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:769:28: (this_UnrestrictedName_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:771:5: this_UnrestrictedName_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getUnrestrictedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName1717);
            this_UnrestrictedName_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_UnrestrictedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnreservedName"


    // $ANTLR start "entryRuleUnrestrictedName"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:789:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:790:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:791:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1762);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName1773); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnrestrictedName"


    // $ANTLR start "ruleUnrestrictedName"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:798:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:801:28: (this_Identifier_0= ruleIdentifier )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:803:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleUnrestrictedName1819);
            this_Identifier_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_Identifier_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnrestrictedName"


    // $ANTLR start "entryRuleWildcardTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:821:1: entryRuleWildcardTypeRefCS returns [EObject current=null] : iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF ;
    public final EObject entryRuleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:822:2: (iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:823:2: iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS1863);
            iv_ruleWildcardTypeRefCS=ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcardTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcardTypeRefCS1873); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWildcardTypeRefCS"


    // $ANTLR start "ruleWildcardTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:830:1: ruleWildcardTypeRefCS returns [EObject current=null] : ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) ;
    public final EObject ruleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_ownedExtends_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:833:28: ( ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:834:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:834:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:834:2: () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:834:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:835:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleWildcardTypeRefCS1922); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:847:1: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==26) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:847:3: otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    {
                    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleWildcardTypeRefCS1935); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:851:1: ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:852:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:852:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:853:3: lv_ownedExtends_3_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS1956);
                    lv_ownedExtends_3_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getWildcardTypeRefCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExtends",
                              		lv_ownedExtends_3_0, 
                              		"TypedRefCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWildcardTypeRefCS"


    // $ANTLR start "entryRuleID"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:877:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:878:2: (iv_ruleID= ruleID EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:879:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID1995);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID2006); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleID"


    // $ANTLR start "ruleID"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:886:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:889:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:890:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:890:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_SIMPLE_ID) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ESCAPED_ID) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:890:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID2046); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:898:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID2072); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ESCAPED_ID_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ESCAPED_ID_1, grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleID"


    // $ANTLR start "entryRuleIdentifier"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:913:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:914:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:915:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier2118);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier2129); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:922:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:925:28: (this_ID_0= ruleID )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:927:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier2175);
            this_ID_0=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleLOWER"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:945:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:946:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:947:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER2220);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER2231); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLOWER"


    // $ANTLR start "ruleLOWER"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:954:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:957:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:958:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER2270); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLOWER"


    // $ANTLR start "entryRuleUPPER"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:977:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:978:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:979:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER2319);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER2330); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUPPER"


    // $ANTLR start "ruleUPPER"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:986:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:989:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:990:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:990:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_INT) ) {
                alt14=1;
            }
            else if ( (LA14_0==21) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:990:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER2370); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:999:2: kw= '*'
                    {
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleUPPER2394); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUPPER"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS137 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleMultiplicityBoundsCS150 = new BitSet(new long[]{0x0000000000200040L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS209 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityCS219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMultiplicityCS256 = new BitSet(new long[]{0x0000000000E00040L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS282 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS312 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_18_in_ruleMultiplicityCS325 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_19_in_ruleMultiplicityCS349 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleMultiplicityCS376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS412 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleMultiplicityStringCS466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleMultiplicityStringCS495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleMultiplicityStringCS524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS575 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS631 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_rulePathNameCS644 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS665 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS703 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS799 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS895 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBindingCS905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS951 = new BitSet(new long[]{0x0000000002020002L});
        public static final BitSet FOLLOW_25_in_ruleTemplateBindingCS964 = new BitSet(new long[]{0x0000000000800030L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS985 = new BitSet(new long[]{0x0000000002020002L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTemplateBindingCS1008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS1045 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS1055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS1100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS1137 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameterCS1147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS1193 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleTypeParameterCS1206 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS1227 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleTypeParameterCS1240 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS1261 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS1301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRefCS1311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeRefCS1361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS1391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS1426 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedRefCS1436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS1485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS1519 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedTypeRefCS1529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypedTypeRefCS1575 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_ruleTypedTypeRefCS1588 = new BitSet(new long[]{0x0000000000800030L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_ruleTypedTypeRefCS1609 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleTypedTypeRefCS1621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName1660 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName1671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName1717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1762 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName1773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleUnrestrictedName1819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS1863 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcardTypeRefCS1873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleWildcardTypeRefCS1922 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleWildcardTypeRefCS1935 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS1956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID1995 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID2006 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID2046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID2072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier2118 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier2129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier2175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER2220 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER2231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER2270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER2319 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER2330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER2370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleUPPER2394 = new BitSet(new long[]{0x0000000000000002L});
    }


}