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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_SINGLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'..'", "'*'", "'+'", "'?'", "'::'", "'('", "')'", "','", "'extends'", "'&&'"
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
        	return "FullTypeDeclarationCS";	
       	}
       	
       	@Override
       	protected BaseGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleFullTypeDeclarationCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:73:1: entryRuleFullTypeDeclarationCS returns [EObject current=null] : iv_ruleFullTypeDeclarationCS= ruleFullTypeDeclarationCS EOF ;
    public final EObject entryRuleFullTypeDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullTypeDeclarationCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:74:2: (iv_ruleFullTypeDeclarationCS= ruleFullTypeDeclarationCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:75:2: iv_ruleFullTypeDeclarationCS= ruleFullTypeDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullTypeDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFullTypeDeclarationCS_in_entryRuleFullTypeDeclarationCS81);
            iv_ruleFullTypeDeclarationCS=ruleFullTypeDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullTypeDeclarationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFullTypeDeclarationCS91); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFullTypeDeclarationCS"


    // $ANTLR start "ruleFullTypeDeclarationCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:82:1: ruleFullTypeDeclarationCS returns [EObject current=null] : this_PathTypeCS_0= rulePathTypeCS ;
    public final EObject ruleFullTypeDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject this_PathTypeCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:85:28: (this_PathTypeCS_0= rulePathTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:87:2: this_PathTypeCS_0= rulePathTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getFullTypeDeclarationCSAccess().getPathTypeCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_rulePathTypeCS_in_ruleFullTypeDeclarationCS140);
            this_PathTypeCS_0=rulePathTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PathTypeCS_0; 
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
    // $ANTLR end "ruleFullTypeDeclarationCS"


    // $ANTLR start "entryRuleMultiplicityBoundsCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:106:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:107:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:108:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS174);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS184); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:115:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:118:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:119:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:119:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:119:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:119:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:120:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:120:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:121:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS230);
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

            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:137:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:137:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiplicityBoundsCS243); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:141:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:142:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:142:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:143:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS264);
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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:169:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:170:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:171:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS304);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS314); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:178:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:181:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:182:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:182:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:183:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:183:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:184:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:184:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
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
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:185:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiplicityStringCS358); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:197:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMultiplicityStringCS387); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:209:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMultiplicityStringCS416); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:232:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:233:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:234:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS467);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS477); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:241:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:244:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:245:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:245:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:245:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:245:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:246:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:246:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:247:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS523);
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

            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:263:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:263:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_rulePathNameCS536); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:267:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:268:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:268:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:269:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS557);
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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:293:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:294:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:295:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS595);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS605); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:302:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:305:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:306:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:306:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:307:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:307:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:308:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS656);
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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:332:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:333:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:334:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS691);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS701); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:341:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:344:28: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:345:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:345:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:346:1: ( ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:346:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:347:3: ruleUnreservedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS752);
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


    // $ANTLR start "entryRulePathTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:371:1: entryRulePathTypeCS returns [EObject current=null] : iv_rulePathTypeCS= rulePathTypeCS EOF ;
    public final EObject entryRulePathTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:372:2: (iv_rulePathTypeCS= rulePathTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:373:2: iv_rulePathTypeCS= rulePathTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathTypeCS_in_entryRulePathTypeCS787);
            iv_rulePathTypeCS=rulePathTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathTypeCS797); if (state.failed) return current;

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
    // $ANTLR end "entryRulePathTypeCS"


    // $ANTLR start "rulePathTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:380:1: rulePathTypeCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) ;
    public final EObject rulePathTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedBinding_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:383:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:384:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:384:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:384:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:384:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:385:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:385:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:386:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathTypeCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_rulePathTypeCS843);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPathTypeCSRule());
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

            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:402:2: (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:402:4: otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_21_in_rulePathTypeCS856); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPathTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:406:1: ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:407:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:407:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:408:3: lv_ownedBinding_2_0= ruleTemplateBindingCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPathTypeCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_rulePathTypeCS877);
                    lv_ownedBinding_2_0=ruleTemplateBindingCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPathTypeCSRule());
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

                    otherlv_3=(Token)match(input,22,FollowSets000.FOLLOW_22_in_rulePathTypeCS889); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPathTypeCSAccess().getRightParenthesisKeyword_1_2());
                          
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
    // $ANTLR end "rulePathTypeCS"


    // $ANTLR start "entryRuleSimpleTypeDeclarationCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:436:1: entryRuleSimpleTypeDeclarationCS returns [EObject current=null] : iv_ruleSimpleTypeDeclarationCS= ruleSimpleTypeDeclarationCS EOF ;
    public final EObject entryRuleSimpleTypeDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleTypeDeclarationCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:437:2: (iv_ruleSimpleTypeDeclarationCS= ruleSimpleTypeDeclarationCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:438:2: iv_ruleSimpleTypeDeclarationCS= ruleSimpleTypeDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleTypeDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeDeclarationCS_in_entryRuleSimpleTypeDeclarationCS927);
            iv_ruleSimpleTypeDeclarationCS=ruleSimpleTypeDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleTypeDeclarationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleTypeDeclarationCS937); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSimpleTypeDeclarationCS"


    // $ANTLR start "ruleSimpleTypeDeclarationCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:445:1: ruleSimpleTypeDeclarationCS returns [EObject current=null] : this_PathTypeCS_0= rulePathTypeCS ;
    public final EObject ruleSimpleTypeDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject this_PathTypeCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:448:28: (this_PathTypeCS_0= rulePathTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:450:2: this_PathTypeCS_0= rulePathTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSimpleTypeDeclarationCSAccess().getPathTypeCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_rulePathTypeCS_in_ruleSimpleTypeDeclarationCS986);
            this_PathTypeCS_0=rulePathTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PathTypeCS_0; 
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
    // $ANTLR end "ruleSimpleTypeDeclarationCS"


    // $ANTLR start "entryRuleTemplateBindingCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:469:1: entryRuleTemplateBindingCS returns [EObject current=null] : iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF ;
    public final EObject entryRuleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBindingCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:470:2: (iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:471:2: iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateBindingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS1020);
            iv_ruleTemplateBindingCS=ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateBindingCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateBindingCS1030); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:478:1: ruleTemplateBindingCS returns [EObject current=null] : ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ) ;
    public final EObject ruleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedSubstitutions_0_0 = null;

        EObject lv_ownedSubstitutions_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:481:28: ( ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:482:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:482:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:482:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )*
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:482:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:483:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:483:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:484:3: lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS1076);
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

            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:500:2: (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==23) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:500:4: otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleTemplateBindingCS1089); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:504:1: ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:505:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:505:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:506:3: lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS1110);
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
    // $ANTLR end "ruleTemplateBindingCS"


    // $ANTLR start "entryRuleTemplateParameterSubstitutionCS"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:530:1: entryRuleTemplateParameterSubstitutionCS returns [EObject current=null] : iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF ;
    public final EObject entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateParameterSubstitutionCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:531:2: (iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:532:2: iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS1148);
            iv_ruleTemplateParameterSubstitutionCS=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateParameterSubstitutionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS1158); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:539:1: ruleTemplateParameterSubstitutionCS returns [EObject current=null] : ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) ;
    public final EObject ruleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedActualParameter_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:542:28: ( ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:543:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:543:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:544:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:544:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:545:3: lv_ownedActualParameter_0_0= ruleTypeRefCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS1203);
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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:571:1: entryRuleTypeParameterCS returns [EObject current=null] : iv_ruleTypeParameterCS= ruleTypeParameterCS EOF ;
    public final EObject entryRuleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameterCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:572:2: (iv_ruleTypeParameterCS= ruleTypeParameterCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:573:2: iv_ruleTypeParameterCS= ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS1240);
            iv_ruleTypeParameterCS=ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeParameterCS1250); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:580:1: ruleTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )* )? ) ;
    public final EObject ruleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedExtends_2_0 = null;

        EObject lv_ownedExtends_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:583:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )* )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:584:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )* )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:584:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )* )? )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:584:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )* )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:584:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:585:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:585:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:586:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS1296);
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

            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:602:2: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:602:4: otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )*
                    {
                    otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleTypeParameterCS1309); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:606:1: ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:607:1: (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:607:1: (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:608:3: lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsSimpleTypeDeclarationCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleTypeParameterCS1330);
                    lv_ownedExtends_2_0=ruleSimpleTypeDeclarationCS();

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
                              		"SimpleTypeDeclarationCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:624:2: (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==25) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:624:4: otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTypeParameterCS1343); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:628:1: ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:629:1: (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:629:1: (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:630:3: lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsSimpleTypeDeclarationCSParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleTypeParameterCS1364);
                    	    lv_ownedExtends_4_0=ruleSimpleTypeDeclarationCS();

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
                    	              		"SimpleTypeDeclarationCS");
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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:654:1: entryRuleTypeRefCS returns [EObject current=null] : iv_ruleTypeRefCS= ruleTypeRefCS EOF ;
    public final EObject entryRuleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:655:2: (iv_ruleTypeRefCS= ruleTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:656:2: iv_ruleTypeRefCS= ruleTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS1404);
            iv_ruleTypeRefCS=ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRefCS1414); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:663:1: ruleTypeRefCS returns [EObject current=null] : (this_SimpleTypeDeclarationCS_0= ruleSimpleTypeDeclarationCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) ;
    public final EObject ruleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleTypeDeclarationCS_0 = null;

        EObject this_WildcardTypeRefCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:666:28: ( (this_SimpleTypeDeclarationCS_0= ruleSimpleTypeDeclarationCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:667:1: (this_SimpleTypeDeclarationCS_0= ruleSimpleTypeDeclarationCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:667:1: (this_SimpleTypeDeclarationCS_0= ruleSimpleTypeDeclarationCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_SIMPLE_ID && LA8_0<=RULE_ESCAPED_ID)) ) {
                alt8=1;
            }
            else if ( (LA8_0==19) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:668:2: this_SimpleTypeDeclarationCS_0= ruleSimpleTypeDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getSimpleTypeDeclarationCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleTypeRefCS1464);
                    this_SimpleTypeDeclarationCS_0=ruleSimpleTypeDeclarationCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SimpleTypeDeclarationCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:681:2: this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS1494);
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


    // $ANTLR start "entryRuleUnreservedName"
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:700:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:701:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:702:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName1530);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName1541); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:709:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_UnrestrictedName_0= ruleUnrestrictedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:712:28: (this_UnrestrictedName_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:714:5: this_UnrestrictedName_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getUnrestrictedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName1587);
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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:732:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:733:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:734:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1632);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName1643); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:741:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:744:28: (this_Identifier_0= ruleIdentifier )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:746:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleUnrestrictedName1689);
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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:764:1: entryRuleWildcardTypeRefCS returns [EObject current=null] : iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF ;
    public final EObject entryRuleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:765:2: (iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:766:2: iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS1733);
            iv_ruleWildcardTypeRefCS=ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcardTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcardTypeRefCS1743); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:773:1: ruleWildcardTypeRefCS returns [EObject current=null] : ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) ) )? ) ;
    public final EObject ruleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_ownedExtends_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:776:28: ( ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:777:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:777:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:777:2: () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:777:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:778:2: 
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

            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleWildcardTypeRefCS1792); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:790:1: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:790:3: otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) )
                    {
                    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleWildcardTypeRefCS1805); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:794:1: ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:795:1: (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:795:1: (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS )
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:796:3: lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsSimpleTypeDeclarationCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleWildcardTypeRefCS1826);
                    lv_ownedExtends_3_0=ruleSimpleTypeDeclarationCS();

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
                              		"SimpleTypeDeclarationCS");
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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:820:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:821:2: (iv_ruleID= ruleID EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:822:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID1865);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID1876); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:829:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:832:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:833:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:833:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
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
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:833:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID1916); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:841:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID1942); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:856:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:857:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:858:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier1988);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier1999); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:865:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:868:28: (this_ID_0= ruleID )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:870:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier2045);
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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:888:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:889:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:890:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER2090);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER2101); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:897:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:900:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:901:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER2140); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:920:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:921:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:922:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER2189);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER2200); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:929:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:932:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:933:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:933:1: (this_INT_0= RULE_INT | kw= '*' )
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
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:933:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER2240); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.base/src-gen/org/eclipse/ocl/xtext/base/parser/antlr/internal/InternalBase.g:942:2: kw= '*'
                    {
                    kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleUPPER2264); if (state.failed) return current;
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
        public static final BitSet FOLLOW_ruleFullTypeDeclarationCS_in_entryRuleFullTypeDeclarationCS81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFullTypeDeclarationCS91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathTypeCS_in_ruleFullTypeDeclarationCS140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS174 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS230 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleMultiplicityBoundsCS243 = new BitSet(new long[]{0x0000000000020040L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS304 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMultiplicityStringCS358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMultiplicityStringCS387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleMultiplicityStringCS416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS467 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS523 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_rulePathNameCS536 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS557 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS595 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS691 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathTypeCS_in_entryRulePathTypeCS787 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathTypeCS797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_rulePathTypeCS843 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_21_in_rulePathTypeCS856 = new BitSet(new long[]{0x0000000000080030L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_rulePathTypeCS877 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_rulePathTypeCS889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleTypeDeclarationCS_in_entryRuleSimpleTypeDeclarationCS927 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleTypeDeclarationCS937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathTypeCS_in_ruleSimpleTypeDeclarationCS986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS1020 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBindingCS1030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS1076 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_23_in_ruleTemplateBindingCS1089 = new BitSet(new long[]{0x0000000000080030L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS1110 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS1148 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS1158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS1203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS1240 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameterCS1250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS1296 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleTypeParameterCS1309 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleTypeParameterCS1330 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleTypeParameterCS1343 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleTypeParameterCS1364 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS1404 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRefCS1414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleTypeRefCS1464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS1494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName1530 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName1541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleUnreservedName1587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1632 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName1643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleUnrestrictedName1689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS1733 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcardTypeRefCS1743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleWildcardTypeRefCS1792 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleWildcardTypeRefCS1805 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleWildcardTypeRefCS1826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID1865 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID1876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID1916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID1942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier1988 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier1999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier2045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER2090 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER2101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER2140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER2189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER2200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER2240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleUPPER2264 = new BitSet(new long[]{0x0000000000000002L});
    }


}