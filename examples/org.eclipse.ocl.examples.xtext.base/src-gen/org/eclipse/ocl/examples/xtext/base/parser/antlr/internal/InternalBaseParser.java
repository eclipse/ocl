package org.eclipse.ocl.examples.xtext.base.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.ocl.examples.xtext.base.services.BaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBaseParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_SINGLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'..'", "'*'", "'+'", "'?'", "'::'", "'('", "','", "')'", "'extends'", "'&&'", "'super'"
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
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g"; }



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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:73:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:74:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:75:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:82:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:85:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:86:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:86:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:86:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:86:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:87:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:87:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:88:3: lv_lowerBound_0_0= ruleLOWER
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

            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:104:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:104:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiplicityBoundsCS150); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:108:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:109:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:109:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:110:3: lv_upperBound_2_0= ruleUPPER
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


    // $ANTLR start "entryRuleMultiplicityStringCS"
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:136:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:137:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:138:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS211);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS221); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:145:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:148:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:149:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:149:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:150:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:150:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:151:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:151:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt2=1;
                }
                break;
            case 18:
                {
                alt2=2;
                }
                break;
            case 19:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:152:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiplicityStringCS265); if (state.failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:164:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMultiplicityStringCS294); if (state.failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:176:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMultiplicityStringCS323); if (state.failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:199:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:200:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:201:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS374);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS384); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:208:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:211:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:212:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:212:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:212:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:212:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:213:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:213:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:214:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS430);
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

            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:230:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:230:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_rulePathNameCS443); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:234:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:235:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:235:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:236:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS464);
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
            	    break loop3;
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:260:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:261:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:262:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS502);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS512); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:269:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:272:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:273:1: ( ( ruleUnrestrictedName ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:273:1: ( ( ruleUnrestrictedName ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:274:1: ( ruleUnrestrictedName )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:274:1: ( ruleUnrestrictedName )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:275:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS563);
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:299:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:300:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:301:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS598);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS608); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:308:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:311:28: ( ( ( ruleUnreservedName ) ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:312:1: ( ( ruleUnreservedName ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:312:1: ( ( ruleUnreservedName ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:313:1: ( ruleUnreservedName )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:313:1: ( ruleUnreservedName )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:314:3: ruleUnreservedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS659);
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:338:1: entryRuleTemplateBindingCS returns [EObject current=null] : iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF ;
    public final EObject entryRuleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBindingCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:339:2: (iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:340:2: iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateBindingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS694);
            iv_ruleTemplateBindingCS=ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateBindingCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateBindingCS704); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:347:1: ruleTemplateBindingCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedSubstitutions_1_0 = null;

        EObject lv_ownedSubstitutions_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:350:28: ( (otherlv_0= '(' ( (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) ) )* otherlv_4= ')' ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:351:1: (otherlv_0= '(' ( (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) ) )* otherlv_4= ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:351:1: (otherlv_0= '(' ( (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) ) )* otherlv_4= ')' )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:351:3: otherlv_0= '(' ( (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleTemplateBindingCS741); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTemplateBindingCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:355:1: ( (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:356:1: (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:356:1: (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:357:3: lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS762);
            lv_ownedSubstitutions_1_0=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedSubstitutions",
                      		lv_ownedSubstitutions_1_0, 
                      		"TemplateParameterSubstitutionCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:373:2: (otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==22) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:373:4: otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) )
            	    {
            	    otherlv_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTemplateBindingCS775); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:377:1: ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:378:1: (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:378:1: (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS )
            	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:379:3: lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS796);
            	    lv_ownedSubstitutions_3_0=ruleTemplateParameterSubstitutionCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedSubstitutions",
            	              		lv_ownedSubstitutions_3_0, 
            	              		"TemplateParameterSubstitutionCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleTemplateBindingCS810); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getTemplateBindingCSAccess().getRightParenthesisKeyword_3());
                  
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:407:1: entryRuleTemplateParameterSubstitutionCS returns [EObject current=null] : iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF ;
    public final EObject entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateParameterSubstitutionCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:408:2: (iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:409:2: iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS846);
            iv_ruleTemplateParameterSubstitutionCS=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateParameterSubstitutionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS856); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:416:1: ruleTemplateParameterSubstitutionCS returns [EObject current=null] : ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) ;
    public final EObject ruleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedActualParameter_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:419:28: ( ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:420:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:420:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:421:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:421:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:422:3: lv_ownedActualParameter_0_0= ruleTypeRefCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS901);
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:448:1: entryRuleTypeParameterCS returns [EObject current=null] : iv_ruleTypeParameterCS= ruleTypeParameterCS EOF ;
    public final EObject entryRuleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameterCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:449:2: (iv_ruleTypeParameterCS= ruleTypeParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:450:2: iv_ruleTypeParameterCS= ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS938);
            iv_ruleTypeParameterCS=ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeParameterCS948); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:457:1: ruleTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* ) | (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) ) )? ) ;
    public final EObject ruleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedExtends_2_0 = null;

        EObject lv_ownedExtends_4_0 = null;

        EObject lv_ownedSuper_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:460:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* ) | (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:461:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* ) | (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:461:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* ) | (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:461:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* ) | (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:461:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:462:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:462:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:463:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS994);
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

            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:479:2: ( (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* ) | (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) ) )?
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==24) ) {
                alt6=1;
            }
            else if ( (LA6_0==26) ) {
                alt6=2;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:479:3: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:479:3: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:479:5: otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    {
                    otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleTypeParameterCS1008); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0_0());
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:483:1: ( (lv_ownedExtends_2_0= ruleTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:484:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:484:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:485:3: lv_ownedExtends_2_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS1029);
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

                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:501:2: (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==25) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:501:4: otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTypeParameterCS1042); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:505:1: ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:506:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:506:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:507:3: lv_ownedExtends_4_0= ruleTypedRefCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS1063);
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
                    	    break loop5;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:524:6: (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:524:6: (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:524:8: otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) )
                    {
                    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTypeParameterCS1085); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTypeParameterCSAccess().getSuperKeyword_1_1_0());
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:528:1: ( (lv_ownedSuper_6_0= ruleTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:529:1: (lv_ownedSuper_6_0= ruleTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:529:1: (lv_ownedSuper_6_0= ruleTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:530:3: lv_ownedSuper_6_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedSuperTypedRefCSParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS1106);
                    lv_ownedSuper_6_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedSuper",
                              		lv_ownedSuper_6_0, 
                              		"TypedRefCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

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
    // $ANTLR end "ruleTypeParameterCS"


    // $ANTLR start "entryRuleTypeRefCS"
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:554:1: entryRuleTypeRefCS returns [EObject current=null] : iv_ruleTypeRefCS= ruleTypeRefCS EOF ;
    public final EObject entryRuleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:555:2: (iv_ruleTypeRefCS= ruleTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:556:2: iv_ruleTypeRefCS= ruleTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS1145);
            iv_ruleTypeRefCS=ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRefCS1155); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:563:1: ruleTypeRefCS returns [EObject current=null] : (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) ;
    public final EObject ruleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedRefCS_0 = null;

        EObject this_WildcardTypeRefCS_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:566:28: ( (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:567:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:567:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_SIMPLE_ID && LA7_0<=RULE_ESCAPED_ID)) ) {
                alt7=1;
            }
            else if ( (LA7_0==19) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:568:2: this_TypedRefCS_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeRefCS1205);
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
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:581:2: this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS1235);
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:600:1: entryRuleTypedRefCS returns [EObject current=null] : iv_ruleTypedRefCS= ruleTypedRefCS EOF ;
    public final EObject entryRuleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:601:2: (iv_ruleTypedRefCS= ruleTypedRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:602:2: iv_ruleTypedRefCS= ruleTypedRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS1270);
            iv_ruleTypedRefCS=ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedRefCS1280); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:609:1: ruleTypedRefCS returns [EObject current=null] : this_TypedTypeRefCS_0= ruleTypedTypeRefCS ;
    public final EObject ruleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedTypeRefCS_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:612:28: (this_TypedTypeRefCS_0= ruleTypedTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:614:2: this_TypedTypeRefCS_0= ruleTypedTypeRefCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS1329);
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:633:1: entryRuleTypedTypeRefCS returns [EObject current=null] : iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF ;
    public final EObject entryRuleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:634:2: (iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:635:2: iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS1363);
            iv_ruleTypedTypeRefCS=ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedTypeRefCS1373); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:642:1: ruleTypedTypeRefCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedBinding_1_0= ruleTemplateBindingCS ) )? ) ;
    public final EObject ruleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedBinding_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:645:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedBinding_1_0= ruleTemplateBindingCS ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:646:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedBinding_1_0= ruleTemplateBindingCS ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:646:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedBinding_1_0= ruleTemplateBindingCS ) )? )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:646:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedBinding_1_0= ruleTemplateBindingCS ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:646:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:647:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:647:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:648:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypedTypeRefCS1419);
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

            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:664:2: ( (lv_ownedBinding_1_0= ruleTemplateBindingCS ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:665:1: (lv_ownedBinding_1_0= ruleTemplateBindingCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:665:1: (lv_ownedBinding_1_0= ruleTemplateBindingCS )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:666:3: lv_ownedBinding_1_0= ruleTemplateBindingCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_ruleTypedTypeRefCS1440);
                    lv_ownedBinding_1_0=ruleTemplateBindingCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedBinding",
                              		lv_ownedBinding_1_0, 
                              		"TemplateBindingCS");
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
    // $ANTLR end "ruleTypedTypeRefCS"


    // $ANTLR start "entryRuleUnreservedName"
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:690:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:691:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:692:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName1478);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName1489); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:699:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_UnrestrictedName_0= ruleUnrestrictedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:702:28: (this_UnrestrictedName_0= ruleUnrestrictedName )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:704:5: this_UnrestrictedName_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getUnrestrictedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName1535);
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:722:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:723:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:724:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1580);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName1591); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:731:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:734:28: (this_Identifier_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:736:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleUnrestrictedName1637);
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:754:1: entryRuleWildcardTypeRefCS returns [EObject current=null] : iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF ;
    public final EObject entryRuleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:755:2: (iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:756:2: iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS1681);
            iv_ruleWildcardTypeRefCS=ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcardTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcardTypeRefCS1691); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:763:1: ruleWildcardTypeRefCS returns [EObject current=null] : ( () otherlv_1= '?' ( (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) ) | (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) ) )? ) ;
    public final EObject ruleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedExtends_3_0 = null;

        EObject lv_ownedSuper_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:766:28: ( ( () otherlv_1= '?' ( (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) ) | (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:767:1: ( () otherlv_1= '?' ( (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) ) | (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:767:1: ( () otherlv_1= '?' ( (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) ) | (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:767:2: () otherlv_1= '?' ( (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) ) | (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:767:2: ()
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:768:2: 
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

            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleWildcardTypeRefCS1740); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:780:1: ( (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) ) | (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) ) )?
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            else if ( (LA9_0==26) ) {
                alt9=2;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:780:2: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:780:2: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:780:4: otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    {
                    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleWildcardTypeRefCS1754); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0());
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:784:1: ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:785:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:785:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:786:3: lv_ownedExtends_3_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS1775);
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


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:803:6: (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:803:6: (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:803:8: otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) )
                    {
                    otherlv_4=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleWildcardTypeRefCS1795); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getWildcardTypeRefCSAccess().getSuperKeyword_2_1_0());
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:807:1: ( (lv_ownedSuper_5_0= ruleTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:808:1: (lv_ownedSuper_5_0= ruleTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:808:1: (lv_ownedSuper_5_0= ruleTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:809:3: lv_ownedSuper_5_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedSuperTypedRefCSParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS1816);
                    lv_ownedSuper_5_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getWildcardTypeRefCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedSuper",
                              		lv_ownedSuper_5_0, 
                              		"TypedRefCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:833:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:834:2: (iv_ruleID= ruleID EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:835:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID1856);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID1867); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:842:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:845:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:846:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:846:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_SIMPLE_ID) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ESCAPED_ID) ) {
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
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:846:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID1907); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:854:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID1933); if (state.failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:869:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:870:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:871:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier1979);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier1990); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:878:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:881:28: (this_ID_0= ruleID )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:883:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier2036);
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:901:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:902:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:903:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER2081);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER2092); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:910:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:913:28: (this_INT_0= RULE_INT )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:914:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER2131); if (state.failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:933:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:934:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:935:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER2180);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER2191); if (state.failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:942:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:945:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:946:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:946:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_INT) ) {
                alt11=1;
            }
            else if ( (LA11_0==17) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:946:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER2231); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.base/src-gen/org/eclipse/ocl/examples/xtext/base/parser/antlr/internal/InternalBase.g:955:2: kw= '*'
                    {
                    kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleUPPER2255); if (state.failed) return current;
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
        public static final BitSet FOLLOW_16_in_ruleMultiplicityBoundsCS150 = new BitSet(new long[]{0x0000000000020040L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS211 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMultiplicityStringCS265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMultiplicityStringCS294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleMultiplicityStringCS323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS374 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS430 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_rulePathNameCS443 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS464 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS502 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS598 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS694 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBindingCS704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleTemplateBindingCS741 = new BitSet(new long[]{0x0000000000080030L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS762 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_22_in_ruleTemplateBindingCS775 = new BitSet(new long[]{0x0000000000080030L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS796 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_23_in_ruleTemplateBindingCS810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS846 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS938 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameterCS948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS994 = new BitSet(new long[]{0x0000000005000002L});
        public static final BitSet FOLLOW_24_in_ruleTypeParameterCS1008 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS1029 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleTypeParameterCS1042 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS1063 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_26_in_ruleTypeParameterCS1085 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS1106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS1145 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRefCS1155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeRefCS1205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS1235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS1270 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedRefCS1280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS1329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS1363 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedTypeRefCS1373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypedTypeRefCS1419 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_ruleTypedTypeRefCS1440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName1478 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName1489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName1535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1580 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName1591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleUnrestrictedName1637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS1681 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcardTypeRefCS1691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleWildcardTypeRefCS1740 = new BitSet(new long[]{0x0000000005000002L});
        public static final BitSet FOLLOW_24_in_ruleWildcardTypeRefCS1754 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS1775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleWildcardTypeRefCS1795 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS1816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID1856 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID1867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID1907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID1933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier1979 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier1990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier2036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER2081 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER2092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER2131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER2180 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER2191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER2231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleUPPER2255 = new BitSet(new long[]{0x0000000000000002L});
    }


}