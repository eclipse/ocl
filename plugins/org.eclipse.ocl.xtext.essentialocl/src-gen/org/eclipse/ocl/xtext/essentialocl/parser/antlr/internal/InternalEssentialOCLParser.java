package org.eclipse.ocl.xtext.essentialocl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalEssentialOCLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_SINGLE_QUOTED_STRING", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'-'", "'not'", "'*'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'.'", "'->'", "'?.'", "'?->'", "'Map'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'('", "')'", "','", "':'", "'{'", "'}'", "'..'", "'++'", "'Lambda'", "'<-'", "'true'", "'false'", "'invalid'", "'null'", "'@'", "'pre'", "'['", "']'", "'in'", "'|'", "';'", "'if'", "'then'", "'else'", "'endif'", "'elseif'", "'let'", "'self'", "'?'", "'::'", "'extends'", "'&&'", "'super'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int RULE_ESCAPED_CHARACTER=8;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_ESCAPED_ID=5;
    public static final int RULE_DOUBLE_QUOTED_STRING=10;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__18=18;
    public static final int T__53=53;
    public static final int T__17=17;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int RULE_SIMPLE_ID=4;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int RULE_ML_SINGLE_QUOTED_STRING=11;
    public static final int T__41=41;
    public static final int T__80=80;
    public static final int T__46=46;
    public static final int T__81=81;
    public static final int T__47=47;
    public static final int T__82=82;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SINGLE_QUOTED_STRING=7;
    public static final int RULE_SL_COMMENT=13;
    public static final int RULE_ML_COMMENT=12;
    public static final int RULE_LETTER_CHARACTER=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=14;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;

    // delegates
    // delegators


        public InternalEssentialOCLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEssentialOCLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEssentialOCLParser.tokenNames; }
    public String getGrammarFileName() { return "../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private EssentialOCLGrammarAccess grammarAccess;
     	
        public InternalEssentialOCLParser(TokenStream input, EssentialOCLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected EssentialOCLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:73:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:74:2: (iv_ruleModel= ruleModel EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:75:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel81);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel91); if (state.failed) return current;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:82:1: ruleModel returns [EObject current=null] : ( (lv_ownedExpression_0_0= ruleExpCS ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedExpression_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:85:28: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:86:1: ( (lv_ownedExpression_0_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:86:1: ( (lv_ownedExpression_0_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:87:1: (lv_ownedExpression_0_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:87:1: (lv_ownedExpression_0_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:88:3: lv_ownedExpression_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModelAccess().getOwnedExpressionExpCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleModel136);
            lv_ownedExpression_0_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModelRule());
              	        }
                     		set(
                     			current, 
                     			"ownedExpression",
                      		lv_ownedExpression_0_0, 
                      		"ExpCS");
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleEssentialOCLUnaryOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:114:1: entryRuleEssentialOCLUnaryOperatorName returns [String current=null] : iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF ;
    public final String entryRuleEssentialOCLUnaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnaryOperatorName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:115:2: (iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:116:2: iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnaryOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorName_in_entryRuleEssentialOCLUnaryOperatorName174);
            iv_ruleEssentialOCLUnaryOperatorName=ruleEssentialOCLUnaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnaryOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorName185); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEssentialOCLUnaryOperatorName"


    // $ANTLR start "ruleEssentialOCLUnaryOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:123:1: ruleEssentialOCLUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= 'not' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:126:28: ( (kw= '-' | kw= 'not' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:127:1: (kw= '-' | kw= 'not' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:127:1: (kw= '-' | kw= 'not' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            else if ( (LA1_0==17) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:128:2: kw= '-'
                    {
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleEssentialOCLUnaryOperatorName223); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:135:2: kw= 'not'
                    {
                    kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEssentialOCLUnaryOperatorName242); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNotKeyword_1()); 
                          
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
    // $ANTLR end "ruleEssentialOCLUnaryOperatorName"


    // $ANTLR start "entryRuleEssentialOCLInfixOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:148:1: entryRuleEssentialOCLInfixOperatorName returns [String current=null] : iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF ;
    public final String entryRuleEssentialOCLInfixOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLInfixOperatorName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:149:2: (iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:150:2: iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorName_in_entryRuleEssentialOCLInfixOperatorName283);
            iv_ruleEssentialOCLInfixOperatorName=ruleEssentialOCLInfixOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLInfixOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorName294); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEssentialOCLInfixOperatorName"


    // $ANTLR start "ruleEssentialOCLInfixOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:157:1: ruleEssentialOCLInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLInfixOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:160:28: ( (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:161:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:161:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            int alt2=14;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt2=1;
                }
                break;
            case 19:
                {
                alt2=2;
                }
                break;
            case 20:
                {
                alt2=3;
                }
                break;
            case 16:
                {
                alt2=4;
                }
                break;
            case 21:
                {
                alt2=5;
                }
                break;
            case 22:
                {
                alt2=6;
                }
                break;
            case 23:
                {
                alt2=7;
                }
                break;
            case 24:
                {
                alt2=8;
                }
                break;
            case 25:
                {
                alt2=9;
                }
                break;
            case 26:
                {
                alt2=10;
                }
                break;
            case 27:
                {
                alt2=11;
                }
                break;
            case 28:
                {
                alt2=12;
                }
                break;
            case 29:
                {
                alt2=13;
                }
                break;
            case 30:
                {
                alt2=14;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:162:2: kw= '*'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEssentialOCLInfixOperatorName332); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:169:2: kw= '/'
                    {
                    kw=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleEssentialOCLInfixOperatorName351); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:176:2: kw= '+'
                    {
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleEssentialOCLInfixOperatorName370); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:183:2: kw= '-'
                    {
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleEssentialOCLInfixOperatorName389); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getHyphenMinusKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:190:2: kw= '>'
                    {
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEssentialOCLInfixOperatorName408); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:197:2: kw= '<'
                    {
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleEssentialOCLInfixOperatorName427); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:204:2: kw= '>='
                    {
                    kw=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleEssentialOCLInfixOperatorName446); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignEqualsSignKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:211:2: kw= '<='
                    {
                    kw=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleEssentialOCLInfixOperatorName465); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignEqualsSignKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:218:2: kw= '='
                    {
                    kw=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleEssentialOCLInfixOperatorName484); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getEqualsSignKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:225:2: kw= '<>'
                    {
                    kw=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleEssentialOCLInfixOperatorName503); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignGreaterThanSignKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:232:2: kw= 'and'
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleEssentialOCLInfixOperatorName522); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAndKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:239:2: kw= 'or'
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEssentialOCLInfixOperatorName541); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOrKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:246:2: kw= 'xor'
                    {
                    kw=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEssentialOCLInfixOperatorName560); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXorKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:253:2: kw= 'implies'
                    {
                    kw=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleEssentialOCLInfixOperatorName579); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImpliesKeyword_13()); 
                          
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
    // $ANTLR end "ruleEssentialOCLInfixOperatorName"


    // $ANTLR start "entryRuleEssentialOCLNavigationOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:266:1: entryRuleEssentialOCLNavigationOperatorName returns [String current=null] : iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF ;
    public final String entryRuleEssentialOCLNavigationOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLNavigationOperatorName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:267:2: (iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:268:2: iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorName_in_entryRuleEssentialOCLNavigationOperatorName620);
            iv_ruleEssentialOCLNavigationOperatorName=ruleEssentialOCLNavigationOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLNavigationOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorName631); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEssentialOCLNavigationOperatorName"


    // $ANTLR start "ruleEssentialOCLNavigationOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:275:1: ruleEssentialOCLNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLNavigationOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:278:28: ( (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:279:1: (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:279:1: (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt3=1;
                }
                break;
            case 32:
                {
                alt3=2;
                }
                break;
            case 33:
                {
                alt3=3;
                }
                break;
            case 34:
                {
                alt3=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:280:2: kw= '.'
                    {
                    kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleEssentialOCLNavigationOperatorName669); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getFullStopKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:287:2: kw= '->'
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleEssentialOCLNavigationOperatorName688); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:294:2: kw= '?.'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleEssentialOCLNavigationOperatorName707); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkFullStopKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:301:2: kw= '?->'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEssentialOCLNavigationOperatorName726); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkHyphenMinusGreaterThanSignKeyword_3()); 
                          
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
    // $ANTLR end "ruleEssentialOCLNavigationOperatorName"


    // $ANTLR start "entryRuleBinaryOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:314:1: entryRuleBinaryOperatorName returns [String current=null] : iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF ;
    public final String entryRuleBinaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinaryOperatorName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:315:2: (iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:316:2: iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorName_in_entryRuleBinaryOperatorName767);
            iv_ruleBinaryOperatorName=ruleBinaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperatorName778); if (state.failed) return current;

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
    // $ANTLR end "entryRuleBinaryOperatorName"


    // $ANTLR start "ruleBinaryOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:323:1: ruleBinaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName ) ;
    public final AntlrDatatypeRuleToken ruleBinaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_InfixOperatorName_0 = null;

        AntlrDatatypeRuleToken this_NavigationOperatorName_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:326:28: ( (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:327:1: (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:327:1: (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16||(LA4_0>=18 && LA4_0<=30)) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=31 && LA4_0<=34)) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:328:5: this_InfixOperatorName_0= ruleInfixOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getInfixOperatorNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorName_in_ruleBinaryOperatorName825);
                    this_InfixOperatorName_0=ruleInfixOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_InfixOperatorName_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:340:5: this_NavigationOperatorName_1= ruleNavigationOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getNavigationOperatorNameParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorName_in_ruleBinaryOperatorName858);
                    this_NavigationOperatorName_1=ruleNavigationOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NavigationOperatorName_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
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
    // $ANTLR end "ruleBinaryOperatorName"


    // $ANTLR start "entryRuleInfixOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:358:1: entryRuleInfixOperatorName returns [String current=null] : iv_ruleInfixOperatorName= ruleInfixOperatorName EOF ;
    public final String entryRuleInfixOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInfixOperatorName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:359:2: (iv_ruleInfixOperatorName= ruleInfixOperatorName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:360:2: iv_ruleInfixOperatorName= ruleInfixOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorName_in_entryRuleInfixOperatorName904);
            iv_ruleInfixOperatorName=ruleInfixOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixOperatorName915); if (state.failed) return current;

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
    // $ANTLR end "entryRuleInfixOperatorName"


    // $ANTLR start "ruleInfixOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:367:1: ruleInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName ;
    public final AntlrDatatypeRuleToken ruleInfixOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLInfixOperatorName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:370:28: (this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:372:5: this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInfixOperatorNameAccess().getEssentialOCLInfixOperatorNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorName_in_ruleInfixOperatorName961);
            this_EssentialOCLInfixOperatorName_0=ruleEssentialOCLInfixOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLInfixOperatorName_0);
                  
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
    // $ANTLR end "ruleInfixOperatorName"


    // $ANTLR start "entryRuleNavigationOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:390:1: entryRuleNavigationOperatorName returns [String current=null] : iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF ;
    public final String entryRuleNavigationOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNavigationOperatorName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:391:2: (iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:392:2: iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorName_in_entryRuleNavigationOperatorName1006);
            iv_ruleNavigationOperatorName=ruleNavigationOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigationOperatorName1017); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNavigationOperatorName"


    // $ANTLR start "ruleNavigationOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:399:1: ruleNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName ;
    public final AntlrDatatypeRuleToken ruleNavigationOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLNavigationOperatorName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:402:28: (this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:404:5: this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigationOperatorNameAccess().getEssentialOCLNavigationOperatorNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorName_in_ruleNavigationOperatorName1063);
            this_EssentialOCLNavigationOperatorName_0=ruleEssentialOCLNavigationOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLNavigationOperatorName_0);
                  
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
    // $ANTLR end "ruleNavigationOperatorName"


    // $ANTLR start "entryRuleUnaryOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:422:1: entryRuleUnaryOperatorName returns [String current=null] : iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF ;
    public final String entryRuleUnaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperatorName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:423:2: (iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:424:2: iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorName_in_entryRuleUnaryOperatorName1108);
            iv_ruleUnaryOperatorName=ruleUnaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnaryOperatorName1119); if (state.failed) return current;

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
    // $ANTLR end "entryRuleUnaryOperatorName"


    // $ANTLR start "ruleUnaryOperatorName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:431:1: ruleUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName ;
    public final AntlrDatatypeRuleToken ruleUnaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnaryOperatorName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:434:28: (this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:436:5: this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnaryOperatorNameAccess().getEssentialOCLUnaryOperatorNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorName_in_ruleUnaryOperatorName1165);
            this_EssentialOCLUnaryOperatorName_0=ruleEssentialOCLUnaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLUnaryOperatorName_0);
                  
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
    // $ANTLR end "ruleUnaryOperatorName"


    // $ANTLR start "entryRuleEssentialOCLUnrestrictedName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:454:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:455:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:456:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName1210);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName1221); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEssentialOCLUnrestrictedName"


    // $ANTLR start "ruleEssentialOCLUnrestrictedName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:463:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:466:28: (this_Identifier_0= ruleIdentifier )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:468:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName1267);
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
    // $ANTLR end "ruleEssentialOCLUnrestrictedName"


    // $ANTLR start "entryRuleUnrestrictedName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:486:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:487:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:488:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1312);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName1323); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:495:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:498:28: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:500:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName1369);
            this_EssentialOCLUnrestrictedName_0=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLUnrestrictedName_0);
                  
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


    // $ANTLR start "entryRuleEssentialOCLUnreservedName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:518:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:519:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:520:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName1414);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName1425); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEssentialOCLUnreservedName"


    // $ANTLR start "ruleEssentialOCLUnreservedName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:527:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:530:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:531:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:531:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' )
            int alt5=5;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
                {
                alt5=1;
                }
                break;
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt5=2;
                }
                break;
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                {
                alt5=3;
                }
                break;
            case 35:
                {
                alt5=4;
                }
                break;
            case 36:
                {
                alt5=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:532:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName1472);
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
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:544:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName1505);
                    this_CollectionTypeIdentifier_1=ruleCollectionTypeIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_CollectionTypeIdentifier_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:556:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName1538);
                    this_PrimitiveTypeIdentifier_2=rulePrimitiveTypeIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_PrimitiveTypeIdentifier_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:568:2: kw= 'Map'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleEssentialOCLUnreservedName1562); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getMapKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:575:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleEssentialOCLUnreservedName1581); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_4()); 
                          
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
    // $ANTLR end "ruleEssentialOCLUnreservedName"


    // $ANTLR start "entryRuleUnreservedName"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:588:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:589:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:590:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName1622);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName1633); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:597:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:600:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:602:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName1679);
            this_EssentialOCLUnreservedName_0=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLUnreservedName_0);
                  
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


    // $ANTLR start "entryRuleURIFirstPathElementCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:622:1: entryRuleURIFirstPathElementCS returns [EObject current=null] : iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF ;
    public final EObject entryRuleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:623:2: (iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:624:2: iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS1725);
            iv_ruleURIFirstPathElementCS=ruleURIFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIFirstPathElementCS1735); if (state.failed) return current;

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
    // $ANTLR end "entryRuleURIFirstPathElementCS"


    // $ANTLR start "ruleURIFirstPathElementCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:631:1: ruleURIFirstPathElementCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) ;
    public final EObject ruleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:634:28: ( ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:635:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:635:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_SIMPLE_ID && LA6_0<=RULE_ESCAPED_ID)) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:635:2: ( ( ruleUnrestrictedName ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:635:2: ( ( ruleUnrestrictedName ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:636:1: ( ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:636:1: ( ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:637:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getURIFirstPathElementCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS1787);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:654:6: ( () ( ( ruleURI ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:654:6: ( () ( ( ruleURI ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:654:7: () ( ( ruleURI ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:654:7: ()
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:655:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getURIFirstPathElementCSAccess().getPathElementWithURICSAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:663:2: ( ( ruleURI ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:664:1: ( ruleURI )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:664:1: ( ruleURI )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:665:3: ruleURI
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getURIFirstPathElementCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceCrossReference_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleURI_in_ruleURIFirstPathElementCS1833);
                    ruleURI();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


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
    // $ANTLR end "ruleURIFirstPathElementCS"


    // $ANTLR start "entryRulePrimitiveTypeIdentifier"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:689:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:690:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:691:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier1871);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier1882); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrimitiveTypeIdentifier"


    // $ANTLR start "rulePrimitiveTypeIdentifier"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:698:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:701:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:702:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:702:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt7=8;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt7=1;
                }
                break;
            case 38:
                {
                alt7=2;
                }
                break;
            case 39:
                {
                alt7=3;
                }
                break;
            case 40:
                {
                alt7=4;
                }
                break;
            case 41:
                {
                alt7=5;
                }
                break;
            case 42:
                {
                alt7=6;
                }
                break;
            case 43:
                {
                alt7=7;
                }
                break;
            case 44:
                {
                alt7=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:703:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_rulePrimitiveTypeIdentifier1920); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:710:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_rulePrimitiveTypeIdentifier1939); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:717:2: kw= 'Real'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_rulePrimitiveTypeIdentifier1958); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:724:2: kw= 'String'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_rulePrimitiveTypeIdentifier1977); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:731:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_41_in_rulePrimitiveTypeIdentifier1996); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:738:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_42_in_rulePrimitiveTypeIdentifier2015); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:745:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_43_in_rulePrimitiveTypeIdentifier2034); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:752:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_44_in_rulePrimitiveTypeIdentifier2053); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7()); 
                          
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
    // $ANTLR end "rulePrimitiveTypeIdentifier"


    // $ANTLR start "entryRulePrimitiveTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:765:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:766:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:767:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS2093);
            iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeCS2103); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrimitiveTypeCS"


    // $ANTLR start "rulePrimitiveTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:774:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:777:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:778:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:778:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:779:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:779:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:780:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS2148);
            lv_name_0_0=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"PrimitiveTypeIdentifier");
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
    // $ANTLR end "rulePrimitiveTypeCS"


    // $ANTLR start "entryRuleCollectionTypeIdentifier"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:804:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:805:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:806:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier2184);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier2195); if (state.failed) return current;

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
    // $ANTLR end "entryRuleCollectionTypeIdentifier"


    // $ANTLR start "ruleCollectionTypeIdentifier"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:813:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:816:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:817:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:817:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt8=5;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt8=1;
                }
                break;
            case 46:
                {
                alt8=2;
                }
                break;
            case 47:
                {
                alt8=3;
                }
                break;
            case 48:
                {
                alt8=4;
                }
                break;
            case 49:
                {
                alt8=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:818:2: kw= 'Set'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleCollectionTypeIdentifier2233); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:825:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleCollectionTypeIdentifier2252); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:832:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleCollectionTypeIdentifier2271); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:839:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleCollectionTypeIdentifier2290); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:846:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleCollectionTypeIdentifier2309); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4()); 
                          
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
    // $ANTLR end "ruleCollectionTypeIdentifier"


    // $ANTLR start "entryRuleCollectionTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:859:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:860:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:861:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS2349);
            iv_ruleCollectionTypeCS=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeCS2359); if (state.failed) return current;

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
    // $ANTLR end "entryRuleCollectionTypeCS"


    // $ANTLR start "ruleCollectionTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:868:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:871:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:872:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:872:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:872:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:872:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:873:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:873:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:874:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS2405);
            lv_name_0_0=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"CollectionTypeIdentifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:890:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==50) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:890:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleCollectionTypeCS2418); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:894:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:895:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:895:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:896:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS2439);
                    lv_ownedType_2_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_2_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleCollectionTypeCS2451); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_2());
                          
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
    // $ANTLR end "ruleCollectionTypeCS"


    // $ANTLR start "entryRuleMapTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:924:1: entryRuleMapTypeCS returns [EObject current=null] : iv_ruleMapTypeCS= ruleMapTypeCS EOF ;
    public final EObject entryRuleMapTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:925:2: (iv_ruleMapTypeCS= ruleMapTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:926:2: iv_ruleMapTypeCS= ruleMapTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_entryRuleMapTypeCS2489);
            iv_ruleMapTypeCS=ruleMapTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapTypeCS2499); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMapTypeCS"


    // $ANTLR start "ruleMapTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:933:1: ruleMapTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) ;
    public final EObject ruleMapTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedKeyType_2_0 = null;

        EObject lv_ownedValueType_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:936:28: ( ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:937:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:937:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:937:2: ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:937:2: ( (lv_name_0_0= 'Map' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:938:1: (lv_name_0_0= 'Map' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:938:1: (lv_name_0_0= 'Map' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:939:3: lv_name_0_0= 'Map'
            {
            lv_name_0_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleMapTypeCS2542); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMapTypeCSRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "Map");
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:952:2: (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==50) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:952:4: otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleMapTypeCS2568); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:956:1: ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:957:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:957:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:958:3: lv_ownedKeyType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleMapTypeCS2589);
                    lv_ownedKeyType_2_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedKeyType",
                              		lv_ownedKeyType_2_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleMapTypeCS2601); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:978:1: ( (lv_ownedValueType_4_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:979:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:979:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:980:3: lv_ownedValueType_4_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleMapTypeCS2622);
                    lv_ownedValueType_4_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedValueType",
                              		lv_ownedValueType_4_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleMapTypeCS2634); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getMapTypeCSAccess().getRightParenthesisKeyword_1_4());
                          
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
    // $ANTLR end "ruleMapTypeCS"


    // $ANTLR start "entryRuleTupleTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1008:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1009:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1010:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS2672);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleTypeCS2682); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTupleTypeCS"


    // $ANTLR start "ruleTupleTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1017:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
    public final EObject ruleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1020:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1021:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1021:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1021:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1021:2: ( (lv_name_0_0= 'Tuple' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1022:1: (lv_name_0_0= 'Tuple' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1022:1: (lv_name_0_0= 'Tuple' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1023:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleTupleTypeCS2725); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTupleTypeCSRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "Tuple");
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1036:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==50) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1036:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleTupleTypeCS2751); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1040:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>=RULE_SIMPLE_ID && LA12_0<=RULE_ESCAPED_ID)) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1040:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1040:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1041:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1041:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1042:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS2773);
                            lv_ownedParts_2_0=ruleTuplePartCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedParts",
                                      		lv_ownedParts_2_0, 
                                      		"TuplePartCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1058:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==52) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1058:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleTupleTypeCS2786); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1062:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1063:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1063:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1064:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS2807);
                            	    lv_ownedParts_4_0=ruleTuplePartCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedParts",
                            	              		lv_ownedParts_4_0, 
                            	              		"TuplePartCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleTupleTypeCS2823); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2());
                          
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
    // $ANTLR end "ruleTupleTypeCS"


    // $ANTLR start "entryRuleTuplePartCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1092:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1093:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1094:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS2861);
            iv_ruleTuplePartCS=ruleTuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTuplePartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTuplePartCS2871); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTuplePartCS"


    // $ANTLR start "ruleTuplePartCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1101:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1104:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1105:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1105:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1105:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1105:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1106:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1106:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1107:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS2917);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
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

            otherlv_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTuplePartCS2929); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1127:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1128:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1128:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1129:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS2950);
            lv_ownedType_2_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_2_0, 
                      		"TypeExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

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
    // $ANTLR end "ruleTuplePartCS"


    // $ANTLR start "entryRuleCollectionLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1153:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1154:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1155:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS2986);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS2996); if (state.failed) return current;

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
    // $ANTLR end "entryRuleCollectionLiteralExpCS"


    // $ANTLR start "ruleCollectionLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1162:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedType_0_0 = null;

        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1165:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1166:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1166:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1166:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1166:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1167:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1167:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1168:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS3042);
            lv_ownedType_0_0=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_0_0, 
                      		"CollectionTypeCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleCollectionLiteralExpCS3054); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1188:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_SIMPLE_ID && LA15_0<=RULE_SINGLE_QUOTED_STRING)||(LA15_0>=16 && LA15_0<=18)||(LA15_0>=35 && LA15_0<=50)||LA15_0==53||LA15_0==58||(LA15_0>=60 && LA15_0<=63)||LA15_0==71||(LA15_0>=76 && LA15_0<=77)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1188:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1188:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1189:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1189:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1190:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS3076);
                    lv_ownedParts_2_0=ruleCollectionLiteralPartCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParts",
                              		lv_ownedParts_2_0, 
                              		"CollectionLiteralPartCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1206:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==52) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1206:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleCollectionLiteralExpCS3089); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1210:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1211:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1211:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1212:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS3110);
                    	    lv_ownedParts_4_0=ruleCollectionLiteralPartCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParts",
                    	              		lv_ownedParts_4_0, 
                    	              		"CollectionLiteralPartCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleCollectionLiteralExpCS3126); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
                  
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
    // $ANTLR end "ruleCollectionLiteralExpCS"


    // $ANTLR start "entryRuleCollectionLiteralPartCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1240:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1241:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1242:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS3162);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS3172); if (state.failed) return current;

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
    // $ANTLR end "entryRuleCollectionLiteralPartCS"


    // $ANTLR start "ruleCollectionLiteralPartCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1249:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedExpression_0_0 = null;

        EObject lv_ownedLastExpression_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1252:28: ( ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1253:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1253:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            int alt17=2;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case RULE_SINGLE_QUOTED_STRING:
            case 16:
            case 17:
            case 18:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 58:
            case 60:
            case 61:
            case 62:
            case 63:
            case 71:
            case 76:
            case 77:
                {
                alt17=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA17_2 = input.LA(2);

                if ( (LA17_2==53) ) {
                    alt17=2;
                }
                else if ( (LA17_2==EOF||LA17_2==16||(LA17_2>=18 && LA17_2<=34)||LA17_2==50||LA17_2==52||(LA17_2>=54 && LA17_2<=56)||LA17_2==64||LA17_2==66||LA17_2==79) ) {
                    alt17=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA17_3 = input.LA(2);

                if ( (LA17_3==53) ) {
                    alt17=2;
                }
                else if ( (LA17_3==EOF||LA17_3==16||(LA17_3>=18 && LA17_3<=34)||LA17_3==50||LA17_3==52||(LA17_3>=54 && LA17_3<=56)||LA17_3==64||LA17_3==66||LA17_3==79) ) {
                    alt17=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 3, input);

                    throw nvae;
                }
                }
                break;
            case 53:
                {
                alt17=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1253:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1253:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1253:3: ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1253:3: ( (lv_ownedExpression_0_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1254:1: (lv_ownedExpression_0_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1254:1: (lv_ownedExpression_0_0= ruleExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1255:3: lv_ownedExpression_0_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS3219);
                    lv_ownedExpression_0_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExpression",
                              		lv_ownedExpression_0_0, 
                              		"ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1271:2: (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==56) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1271:4: otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            {
                            otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleCollectionLiteralPartCS3232); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1275:1: ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1276:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1276:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1277:3: lv_ownedLastExpression_2_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS3253);
                            lv_ownedLastExpression_2_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedLastExpression",
                                      		lv_ownedLastExpression_2_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1294:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1294:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1295:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1295:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1296:3: lv_ownedExpression_3_0= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionPatternExpCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleCollectionLiteralPartCS3283);
                    lv_ownedExpression_3_0=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExpression",
                              		lv_ownedExpression_3_0, 
                              		"PatternExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


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
    // $ANTLR end "ruleCollectionLiteralPartCS"


    // $ANTLR start "entryRuleCollectionPatternCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1320:1: entryRuleCollectionPatternCS returns [EObject current=null] : iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF ;
    public final EObject entryRuleCollectionPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionPatternCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1321:2: (iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1322:2: iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionPatternCS_in_entryRuleCollectionPatternCS3319);
            iv_ruleCollectionPatternCS=ruleCollectionPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionPatternCS3329); if (state.failed) return current;

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
    // $ANTLR end "entryRuleCollectionPatternCS"


    // $ANTLR start "ruleCollectionPatternCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1329:1: ruleCollectionPatternCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleCollectionPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedType_0_0 = null;

        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;

        AntlrDatatypeRuleToken lv_restVariableName_6_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1332:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1333:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1333:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1333:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1333:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1334:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1334:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1335:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionPatternCS3375);
            lv_ownedType_0_0=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_0_0, 
                      		"CollectionTypeCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleCollectionPatternCS3387); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1355:1: ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_SIMPLE_ID && LA19_0<=RULE_ESCAPED_ID)||LA19_0==53) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1355:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1355:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1356:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1356:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1357:3: lv_ownedParts_2_0= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS3409);
                    lv_ownedParts_2_0=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParts",
                              		lv_ownedParts_2_0, 
                              		"PatternExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1373:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==52) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1373:4: otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleCollectionPatternCS3422); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1377:1: ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1378:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1378:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1379:3: lv_ownedParts_4_0= rulePatternExpCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS3443);
                    	    lv_ownedParts_4_0=rulePatternExpCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParts",
                    	              		lv_ownedParts_4_0, 
                    	              		"PatternExpCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1395:4: (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1395:6: otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    {
                    otherlv_5=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleCollectionPatternCS3458); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1399:1: ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1400:1: (lv_restVariableName_6_0= ruleIdentifier )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1400:1: (lv_restVariableName_6_0= ruleIdentifier )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1401:3: lv_restVariableName_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleCollectionPatternCS3479);
                    lv_restVariableName_6_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
                      	        }
                             		set(
                             			current, 
                             			"restVariableName",
                              		lv_restVariableName_6_0, 
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleCollectionPatternCS3494); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getCollectionPatternCSAccess().getRightCurlyBracketKeyword_3());
                  
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
    // $ANTLR end "ruleCollectionPatternCS"


    // $ANTLR start "entryRuleShadowPartCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1429:1: entryRuleShadowPartCS returns [EObject current=null] : iv_ruleShadowPartCS= ruleShadowPartCS EOF ;
    public final EObject entryRuleShadowPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShadowPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1430:2: (iv_ruleShadowPartCS= ruleShadowPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1431:2: iv_ruleShadowPartCS= ruleShadowPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShadowPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_entryRuleShadowPartCS3530);
            iv_ruleShadowPartCS=ruleShadowPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShadowPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleShadowPartCS3540); if (state.failed) return current;

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
    // $ANTLR end "entryRuleShadowPartCS"


    // $ANTLR start "ruleShadowPartCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1438:1: ruleShadowPartCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) ;
    public final EObject ruleShadowPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedInitExpression_2_1 = null;

        EObject lv_ownedInitExpression_2_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1441:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1442:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1442:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1442:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1442:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1443:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1443:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1444:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getShadowPartCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleShadowPartCS3592);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleShadowPartCS3604); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1464:1: ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1465:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1465:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1466:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1466:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
            int alt20=2;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case RULE_SINGLE_QUOTED_STRING:
            case 16:
            case 17:
            case 18:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 58:
            case 60:
            case 61:
            case 62:
            case 63:
            case 71:
            case 76:
            case 77:
                {
                alt20=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA20_2 = input.LA(2);

                if ( (LA20_2==EOF||LA20_2==16||(LA20_2>=18 && LA20_2<=34)||LA20_2==50||LA20_2==52||(LA20_2>=54 && LA20_2<=55)||LA20_2==64||LA20_2==66||LA20_2==79) ) {
                    alt20=1;
                }
                else if ( (LA20_2==53) ) {
                    alt20=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA20_3 = input.LA(2);

                if ( (LA20_3==EOF||LA20_3==16||(LA20_3>=18 && LA20_3<=34)||LA20_3==50||LA20_3==52||(LA20_3>=54 && LA20_3<=55)||LA20_3==64||LA20_3==66||LA20_3==79) ) {
                    alt20=1;
                }
                else if ( (LA20_3==53) ) {
                    alt20=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 3, input);

                    throw nvae;
                }
                }
                break;
            case 53:
                {
                alt20=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1467:3: lv_ownedInitExpression_2_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleShadowPartCS3627);
                    lv_ownedInitExpression_2_1=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedInitExpression",
                              		lv_ownedInitExpression_2_1, 
                              		"ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1482:8: lv_ownedInitExpression_2_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_2_0_1()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleShadowPartCS3646);
                    lv_ownedInitExpression_2_2=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedInitExpression",
                              		lv_ownedInitExpression_2_2, 
                              		"PatternExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


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
    // $ANTLR end "ruleShadowPartCS"


    // $ANTLR start "entryRulePatternExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1508:1: entryRulePatternExpCS returns [EObject current=null] : iv_rulePatternExpCS= rulePatternExpCS EOF ;
    public final EObject entryRulePatternExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1509:2: (iv_rulePatternExpCS= rulePatternExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1510:2: iv_rulePatternExpCS= rulePatternExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_entryRulePatternExpCS3685);
            iv_rulePatternExpCS=rulePatternExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePatternExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePatternExpCS3695); if (state.failed) return current;

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
    // $ANTLR end "entryRulePatternExpCS"


    // $ANTLR start "rulePatternExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1517:1: rulePatternExpCS returns [EObject current=null] : ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject rulePatternExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_patternVariableName_0_0 = null;

        EObject lv_ownedPatternType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1520:28: ( ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1521:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1521:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1521:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1521:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_SIMPLE_ID && LA21_0<=RULE_ESCAPED_ID)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1522:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1522:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1523:3: lv_patternVariableName_0_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_rulePatternExpCS3741);
                    lv_patternVariableName_0_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"patternVariableName",
                              		lv_patternVariableName_0_0, 
                              		"UnrestrictedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_rulePatternExpCS3754); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPatternExpCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1543:1: ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1544:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1544:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1545:3: lv_ownedPatternType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_rulePatternExpCS3775);
            lv_ownedPatternType_2_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPatternType",
                      		lv_ownedPatternType_2_0, 
                      		"TypeExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

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
    // $ANTLR end "rulePatternExpCS"


    // $ANTLR start "entryRuleLambdaLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1569:1: entryRuleLambdaLiteralExpCS returns [EObject current=null] : iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF ;
    public final EObject entryRuleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambdaLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1570:2: (iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1571:2: iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLambdaLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLambdaLiteralExpCS_in_entryRuleLambdaLiteralExpCS3811);
            iv_ruleLambdaLiteralExpCS=ruleLambdaLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLambdaLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLambdaLiteralExpCS3821); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLambdaLiteralExpCS"


    // $ANTLR start "ruleLambdaLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1578:1: ruleLambdaLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) ;
    public final EObject ruleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1581:28: ( (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1582:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1582:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1582:3: otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleLambdaLiteralExpCS3858); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleLambdaLiteralExpCS3870); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1590:1: ( (lv_ownedExpressionCS_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1591:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1591:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1592:3: lv_ownedExpressionCS_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLambdaLiteralExpCS3891);
            lv_ownedExpressionCS_2_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLambdaLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedExpressionCS",
                      		lv_ownedExpressionCS_2_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleLambdaLiteralExpCS3903); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLambdaLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
                  
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
    // $ANTLR end "ruleLambdaLiteralExpCS"


    // $ANTLR start "entryRuleMapLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1620:1: entryRuleMapLiteralExpCS returns [EObject current=null] : iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF ;
    public final EObject entryRuleMapLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1621:2: (iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1622:2: iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_entryRuleMapLiteralExpCS3939);
            iv_ruleMapLiteralExpCS=ruleMapLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapLiteralExpCS3949); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMapLiteralExpCS"


    // $ANTLR start "ruleMapLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1629:1: ruleMapLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleMapLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedType_0_0 = null;

        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1632:28: ( ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1633:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1633:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1633:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1633:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1634:1: (lv_ownedType_0_0= ruleMapTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1634:1: (lv_ownedType_0_0= ruleMapTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1635:3: lv_ownedType_0_0= ruleMapTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_ruleMapLiteralExpCS3995);
            lv_ownedType_0_0=ruleMapTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_0_0, 
                      		"MapTypeCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleMapLiteralExpCS4007); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1655:1: ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_SIMPLE_ID && LA23_0<=RULE_SINGLE_QUOTED_STRING)||(LA23_0>=16 && LA23_0<=18)||(LA23_0>=35 && LA23_0<=50)||LA23_0==58||(LA23_0>=60 && LA23_0<=63)||LA23_0==71||(LA23_0>=76 && LA23_0<=77)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1655:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1655:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1656:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1656:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1657:3: lv_ownedParts_2_0= ruleMapLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4029);
                    lv_ownedParts_2_0=ruleMapLiteralPartCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParts",
                              		lv_ownedParts_2_0, 
                              		"MapLiteralPartCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1673:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==52) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1673:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleMapLiteralExpCS4042); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1677:1: ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1678:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1678:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1679:3: lv_ownedParts_4_0= ruleMapLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4063);
                    	    lv_ownedParts_4_0=ruleMapLiteralPartCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParts",
                    	              		lv_ownedParts_4_0, 
                    	              		"MapLiteralPartCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleMapLiteralExpCS4079); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMapLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
                  
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
    // $ANTLR end "ruleMapLiteralExpCS"


    // $ANTLR start "entryRuleMapLiteralPartCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1707:1: entryRuleMapLiteralPartCS returns [EObject current=null] : iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF ;
    public final EObject entryRuleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1708:2: (iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1709:2: iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_entryRuleMapLiteralPartCS4115);
            iv_ruleMapLiteralPartCS=ruleMapLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapLiteralPartCS4125); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMapLiteralPartCS"


    // $ANTLR start "ruleMapLiteralPartCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1716:1: ruleMapLiteralPartCS returns [EObject current=null] : ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedKey_0_0 = null;

        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1719:28: ( ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1720:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1720:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1720:2: ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1720:2: ( (lv_ownedKey_0_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1721:1: (lv_ownedKey_0_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1721:1: (lv_ownedKey_0_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1722:3: lv_ownedKey_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS4171);
            lv_ownedKey_0_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedKey",
                      		lv_ownedKey_0_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleMapLiteralPartCS4183); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1742:1: ( (lv_ownedValue_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1743:1: (lv_ownedValue_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1743:1: (lv_ownedValue_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1744:3: lv_ownedValue_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS4204);
            lv_ownedValue_2_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_2_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

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
    // $ANTLR end "ruleMapLiteralPartCS"


    // $ANTLR start "entryRulePrimitiveLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1768:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1769:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1770:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS4240);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS4250); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrimitiveLiteralExpCS"


    // $ANTLR start "rulePrimitiveLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1777:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
    public final EObject rulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralExpCS_0 = null;

        EObject this_StringLiteralExpCS_1 = null;

        EObject this_BooleanLiteralExpCS_2 = null;

        EObject this_UnlimitedNaturalLiteralExpCS_3 = null;

        EObject this_InvalidLiteralExpCS_4 = null;

        EObject this_NullLiteralExpCS_5 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1780:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1781:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1781:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt24=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt24=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt24=2;
                }
                break;
            case 60:
            case 61:
                {
                alt24=3;
                }
                break;
            case 18:
                {
                alt24=4;
                }
                break;
            case 62:
                {
                alt24=5;
                }
                break;
            case 63:
                {
                alt24=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1782:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS4300);
                    this_NumberLiteralExpCS_0=ruleNumberLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NumberLiteralExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1795:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS4330);
                    this_StringLiteralExpCS_1=ruleStringLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StringLiteralExpCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1808:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS4360);
                    this_BooleanLiteralExpCS_2=ruleBooleanLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BooleanLiteralExpCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1821:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS4390);
                    this_UnlimitedNaturalLiteralExpCS_3=ruleUnlimitedNaturalLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnlimitedNaturalLiteralExpCS_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1834:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS4420);
                    this_InvalidLiteralExpCS_4=ruleInvalidLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_InvalidLiteralExpCS_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1847:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS4450);
                    this_NullLiteralExpCS_5=ruleNullLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NullLiteralExpCS_5; 
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
    // $ANTLR end "rulePrimitiveLiteralExpCS"


    // $ANTLR start "entryRuleTupleLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1866:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1867:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1868:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS4485);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralExpCS4495); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTupleLiteralExpCS"


    // $ANTLR start "ruleTupleLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1875:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1878:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1879:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1879:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1879:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleTupleLiteralExpCS4532); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleTupleLiteralExpCS4544); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1887:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1888:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1888:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1889:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS4565);
            lv_ownedParts_2_0=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedParts",
                      		lv_ownedParts_2_0, 
                      		"TupleLiteralPartCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1905:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==52) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1905:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleTupleLiteralExpCS4578); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1909:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1910:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1910:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1911:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS4599);
            	    lv_ownedParts_4_0=ruleTupleLiteralPartCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedParts",
            	              		lv_ownedParts_4_0, 
            	              		"TupleLiteralPartCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            otherlv_5=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleTupleLiteralExpCS4613); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_4());
                  
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
    // $ANTLR end "ruleTupleLiteralExpCS"


    // $ANTLR start "entryRuleTupleLiteralPartCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1939:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1940:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1941:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS4649);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralPartCS4659); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTupleLiteralPartCS"


    // $ANTLR start "ruleTupleLiteralPartCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1948:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedInitExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1951:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1952:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1952:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1952:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1952:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1953:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1953:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1954:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS4705);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1970:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==53) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1970:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTupleLiteralPartCS4718); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1974:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1975:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1975:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1976:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS4739);
                    lv_ownedType_2_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_2_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTupleLiteralPartCS4753); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1996:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1997:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1997:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1998:3: lv_ownedInitExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS4774);
            lv_ownedInitExpression_4_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedInitExpression",
                      		lv_ownedInitExpression_4_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

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
    // $ANTLR end "ruleTupleLiteralPartCS"


    // $ANTLR start "entryRuleNumberLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2022:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2023:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2024:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS4810);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteralExpCS4820); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNumberLiteralExpCS"


    // $ANTLR start "ruleNumberLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2031:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_symbol_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2034:28: ( ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2035:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2035:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2036:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2036:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2037:3: lv_symbol_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS4865);
            lv_symbol_0_0=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumberLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"symbol",
                      		lv_symbol_0_0, 
                      		"NUMBER_LITERAL");
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
    // $ANTLR end "ruleNumberLiteralExpCS"


    // $ANTLR start "entryRuleStringLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2061:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2062:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2063:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS4900);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteralExpCS4910); if (state.failed) return current;

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
    // $ANTLR end "entryRuleStringLiteralExpCS"


    // $ANTLR start "ruleStringLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2070:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_segments_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_segments_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2073:28: ( ( (lv_segments_0_0= ruleStringLiteral ) )+ )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2074:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2074:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2075:1: (lv_segments_0_0= ruleStringLiteral )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2075:1: (lv_segments_0_0= ruleStringLiteral )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2076:3: lv_segments_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS4955);
            	    lv_segments_0_0=ruleStringLiteral();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStringLiteralExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"segments",
            	              		lv_segments_0_0, 
            	              		"StringLiteral");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);


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
    // $ANTLR end "ruleStringLiteralExpCS"


    // $ANTLR start "entryRuleBooleanLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2100:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2101:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2102:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS4991);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS5001); if (state.failed) return current;

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
    // $ANTLR end "entryRuleBooleanLiteralExpCS"


    // $ANTLR start "ruleBooleanLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2109:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_0_0=null;
        Token lv_symbol_1_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2112:28: ( ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2113:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2113:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==60) ) {
                alt28=1;
            }
            else if ( (LA28_0==61) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2113:2: ( (lv_symbol_0_0= 'true' ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2113:2: ( (lv_symbol_0_0= 'true' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2114:1: (lv_symbol_0_0= 'true' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2114:1: (lv_symbol_0_0= 'true' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2115:3: lv_symbol_0_0= 'true'
                    {
                    lv_symbol_0_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleBooleanLiteralExpCS5044); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_symbol_0_0, grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "symbol", lv_symbol_0_0, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2129:6: ( (lv_symbol_1_0= 'false' ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2129:6: ( (lv_symbol_1_0= 'false' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2130:1: (lv_symbol_1_0= 'false' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2130:1: (lv_symbol_1_0= 'false' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2131:3: lv_symbol_1_0= 'false'
                    {
                    lv_symbol_1_0=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleBooleanLiteralExpCS5081); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_symbol_1_0, grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "symbol", lv_symbol_1_0, "false");
                      	    
                    }

                    }


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
    // $ANTLR end "ruleBooleanLiteralExpCS"


    // $ANTLR start "entryRuleUnlimitedNaturalLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2152:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2153:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2154:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS5130);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS5140); if (state.failed) return current;

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
    // $ANTLR end "entryRuleUnlimitedNaturalLiteralExpCS"


    // $ANTLR start "ruleUnlimitedNaturalLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2161:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2164:28: ( ( () otherlv_1= '*' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2165:1: ( () otherlv_1= '*' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2165:1: ( () otherlv_1= '*' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2165:2: () otherlv_1= '*'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2165:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2166:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUnlimitedNaturalLiteralExpCS5189); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getAsteriskKeyword_1());
                  
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
    // $ANTLR end "ruleUnlimitedNaturalLiteralExpCS"


    // $ANTLR start "entryRuleInvalidLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2186:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2187:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2188:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS5225);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS5235); if (state.failed) return current;

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
    // $ANTLR end "entryRuleInvalidLiteralExpCS"


    // $ANTLR start "ruleInvalidLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2195:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2198:28: ( ( () otherlv_1= 'invalid' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2199:1: ( () otherlv_1= 'invalid' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2199:1: ( () otherlv_1= 'invalid' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2199:2: () otherlv_1= 'invalid'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2199:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2200:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleInvalidLiteralExpCS5284); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getInvalidLiteralExpCSAccess().getInvalidKeyword_1());
                  
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
    // $ANTLR end "ruleInvalidLiteralExpCS"


    // $ANTLR start "entryRuleNullLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2220:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2221:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2222:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS5320);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullLiteralExpCS5330); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNullLiteralExpCS"


    // $ANTLR start "ruleNullLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2229:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2232:28: ( ( () otherlv_1= 'null' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2233:1: ( () otherlv_1= 'null' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2233:1: ( () otherlv_1= 'null' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2233:2: () otherlv_1= 'null'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2233:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2234:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleNullLiteralExpCS5379); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1());
                  
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
    // $ANTLR end "ruleNullLiteralExpCS"


    // $ANTLR start "entryRuleTypeLiteralCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2254:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2255:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2256:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS5415);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralCS5425); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeLiteralCS"


    // $ANTLR start "ruleTypeLiteralCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2263:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_MapTypeCS_2 = null;

        EObject this_TupleTypeCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2266:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2267:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2267:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
            int alt29=4;
            switch ( input.LA(1) ) {
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                {
                alt29=1;
                }
                break;
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt29=2;
                }
                break;
            case 35:
                {
                alt29=3;
                }
                break;
            case 36:
                {
                alt29=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2268:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS5475);
                    this_PrimitiveTypeCS_0=rulePrimitiveTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimitiveTypeCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2281:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS5505);
                    this_CollectionTypeCS_1=ruleCollectionTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionTypeCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2294:2: this_MapTypeCS_2= ruleMapTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getMapTypeCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralCS5535);
                    this_MapTypeCS_2=ruleMapTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MapTypeCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2307:2: this_TupleTypeCS_3= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS5565);
                    this_TupleTypeCS_3=ruleTupleTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TupleTypeCS_3; 
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
    // $ANTLR end "ruleTypeLiteralCS"


    // $ANTLR start "entryRuleTypeLiteralWithMultiplicityCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2326:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2327:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2328:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS5600);
            iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralWithMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS5610); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeLiteralWithMultiplicityCS"


    // $ANTLR start "ruleTypeLiteralWithMultiplicityCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2335:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralCS_0 = null;

        EObject lv_ownedMultiplicity_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2338:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2339:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2339:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2340:2: this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS5660);
            this_TypeLiteralCS_0=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypeLiteralCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2351:1: ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==66) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2352:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2352:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2353:3: lv_ownedMultiplicity_1_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS5680);
                    lv_ownedMultiplicity_1_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeLiteralWithMultiplicityCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedMultiplicity",
                              		lv_ownedMultiplicity_1_0, 
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
    // $ANTLR end "ruleTypeLiteralWithMultiplicityCS"


    // $ANTLR start "entryRuleTypeLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2377:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2378:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2379:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS5717);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralExpCS5727); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeLiteralExpCS"


    // $ANTLR start "ruleTypeLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2386:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2389:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2390:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2390:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2391:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2391:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2392:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS5772);
            lv_ownedType_0_0=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_0_0, 
                      		"TypeLiteralWithMultiplicityCS");
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
    // $ANTLR end "ruleTypeLiteralExpCS"


    // $ANTLR start "entryRuleTypeNameExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2416:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2417:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2418:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS5807);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeNameExpCS5817); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeNameExpCS"


    // $ANTLR start "ruleTypeNameExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2425:1: ruleTypeNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedCurlyBracketedClause_1_0 = null;

        EObject lv_ownedPatternGuard_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2428:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2429:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2429:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2429:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2429:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2430:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2430:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2431:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS5863);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2447:2: ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==54) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2447:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2447:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2448:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2448:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2449:3: lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_ruleTypeNameExpCS5885);
                    lv_ownedCurlyBracketedClause_1_0=ruleCurlyBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedCurlyBracketedClause",
                              		lv_ownedCurlyBracketedClause_1_0, 
                              		"CurlyBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2465:2: (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==54) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2465:4: otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}'
                            {
                            otherlv_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleTypeNameExpCS5898); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2469:1: ( (lv_ownedPatternGuard_3_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2470:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2470:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2471:3: lv_ownedPatternGuard_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTypeNameExpCS5919);
                            lv_ownedPatternGuard_3_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedPatternGuard",
                                      		lv_ownedPatternGuard_3_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_4=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleTypeNameExpCS5931); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getTypeNameExpCSAccess().getRightCurlyBracketKeyword_1_1_2());
                                  
                            }

                            }
                            break;

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
    // $ANTLR end "ruleTypeNameExpCS"


    // $ANTLR start "entryRuleTypeExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2499:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2500:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2501:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS5971);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeExpCS5981); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeExpCS"


    // $ANTLR start "ruleTypeExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2508:1: ruleTypeExpCS returns [EObject current=null] : ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;

        EObject this_CollectionPatternCS_2 = null;

        EObject lv_ownedMultiplicity_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2511:28: ( ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2512:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2512:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2512:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2512:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )
            int alt33=3;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2513:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS6032);
                    this_TypeNameExpCS_0=ruleTypeNameExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeNameExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2526:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS6062);
                    this_TypeLiteralCS_1=ruleTypeLiteralCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeLiteralCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2539:2: this_CollectionPatternCS_2= ruleCollectionPatternCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getCollectionPatternCSParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionPatternCS_in_ruleTypeExpCS6092);
                    this_CollectionPatternCS_2=ruleCollectionPatternCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionPatternCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2550:2: ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==66) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2551:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2551:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2552:3: lv_ownedMultiplicity_3_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS6113);
                    lv_ownedMultiplicity_3_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeExpCSRule());
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
    // $ANTLR end "ruleTypeExpCS"


    // $ANTLR start "entryRuleExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2576:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2577:2: (iv_ruleExpCS= ruleExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2578:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_entryRuleExpCS6150);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpCS6160); if (state.failed) return current;

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
    // $ANTLR end "entryRuleExpCS"


    // $ANTLR start "ruleExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2585:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;

        EObject this_PrefixedLetExpCS_4 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2588:28: ( ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2589:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2589:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            int alt36=2;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2589:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2589:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2590:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_ruleExpCS6211);
                    this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedPrimaryExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2601:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==16||(LA35_0>=18 && LA35_0<=34)) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2601:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2601:2: ()
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2602:2: 
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0(),
                                          current);
                                  
                            }

                            }

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2610:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2611:1: (lv_name_2_0= ruleBinaryOperatorName )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2611:1: (lv_name_2_0= ruleBinaryOperatorName )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2612:3: lv_name_2_0= ruleBinaryOperatorName
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorName_in_ruleExpCS6244);
                            lv_name_2_0=ruleBinaryOperatorName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"name",
                                      		lv_name_2_0, 
                                      		"BinaryOperatorName");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2628:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2629:1: (lv_ownedRight_3_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2629:1: (lv_ownedRight_3_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2630:3: lv_ownedRight_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleExpCS6265);
                            lv_ownedRight_3_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedRight",
                                      		lv_ownedRight_3_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2648:2: this_PrefixedLetExpCS_4= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedLetExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_ruleExpCS6299);
                    this_PrefixedLetExpCS_4=rulePrefixedLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedLetExpCS_4; 
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
    // $ANTLR end "ruleExpCS"


    // $ANTLR start "entryRulePrefixedLetExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2667:1: entryRulePrefixedLetExpCS returns [EObject current=null] : iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF ;
    public final EObject entryRulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2668:2: (iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2669:2: iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_entryRulePrefixedLetExpCS6334);
            iv_rulePrefixedLetExpCS=rulePrefixedLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedLetExpCS6344); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrefixedLetExpCS"


    // $ANTLR start "rulePrefixedLetExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2676:1: rulePrefixedLetExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) ;
    public final EObject rulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_LetExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2679:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2680:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2680:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=16 && LA37_0<=17)) ) {
                alt37=1;
            }
            else if ( (LA37_0==76) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2680:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2680:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2680:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2680:3: ()
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2681:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixedLetExpCSAccess().getPrefixExpCSAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2689:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2690:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2690:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2691:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorName_in_rulePrefixedLetExpCS6403);
                    lv_name_1_0=ruleUnaryOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"UnaryOperatorName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2707:2: ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2708:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2708:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2709:3: lv_ownedRight_2_0= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_rulePrefixedLetExpCS6424);
                    lv_ownedRight_2_0=rulePrefixedLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedRight",
                              		lv_ownedRight_2_0, 
                              		"PrefixedLetExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2727:2: this_LetExpCS_3= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getLetExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_rulePrefixedLetExpCS6456);
                    this_LetExpCS_3=ruleLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LetExpCS_3; 
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
    // $ANTLR end "rulePrefixedLetExpCS"


    // $ANTLR start "entryRulePrefixedPrimaryExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2746:1: entryRulePrefixedPrimaryExpCS returns [EObject current=null] : iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF ;
    public final EObject entryRulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedPrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2747:2: (iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2748:2: iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_entryRulePrefixedPrimaryExpCS6491);
            iv_rulePrefixedPrimaryExpCS=rulePrefixedPrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedPrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedPrimaryExpCS6501); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrefixedPrimaryExpCS"


    // $ANTLR start "rulePrefixedPrimaryExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2755:1: rulePrefixedPrimaryExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2758:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2759:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2759:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=16 && LA38_0<=17)) ) {
                alt38=1;
            }
            else if ( ((LA38_0>=RULE_SIMPLE_ID && LA38_0<=RULE_SINGLE_QUOTED_STRING)||LA38_0==18||(LA38_0>=35 && LA38_0<=50)||LA38_0==58||(LA38_0>=60 && LA38_0<=63)||LA38_0==71||LA38_0==77) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2759:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2759:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2759:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2759:3: ()
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2760:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixedPrimaryExpCSAccess().getPrefixExpCSAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2768:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2769:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2769:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2770:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorName_in_rulePrefixedPrimaryExpCS6560);
                    lv_name_1_0=ruleUnaryOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"UnaryOperatorName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2786:2: ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2787:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2787:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2788:3: lv_ownedRight_2_0= rulePrefixedPrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_rulePrefixedPrimaryExpCS6581);
                    lv_ownedRight_2_0=rulePrefixedPrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedRight",
                              		lv_ownedRight_2_0, 
                              		"PrefixedPrimaryExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2806:2: this_PrimaryExpCS_3= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedPrimaryExpCS6613);
                    this_PrimaryExpCS_3=rulePrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpCS_3; 
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
    // $ANTLR end "rulePrefixedPrimaryExpCS"


    // $ANTLR start "entryRulePrimaryExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2825:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2826:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2827:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS6648);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpCS6658); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrimaryExpCS"


    // $ANTLR start "rulePrimaryExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2834:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) ;
    public final EObject rulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_NestedExpCS_0 = null;

        EObject this_IfExpCS_1 = null;

        EObject this_SelfExpCS_2 = null;

        EObject this_PrimitiveLiteralExpCS_3 = null;

        EObject this_TupleLiteralExpCS_4 = null;

        EObject this_MapLiteralExpCS_5 = null;

        EObject this_CollectionLiteralExpCS_6 = null;

        EObject this_LambdaLiteralExpCS_7 = null;

        EObject this_TypeLiteralExpCS_8 = null;

        EObject this_NameExpCS_9 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2837:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2838:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2838:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            int alt39=10;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2839:2: this_NestedExpCS_0= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS6708);
                    this_NestedExpCS_0=ruleNestedExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NestedExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2852:2: this_IfExpCS_1= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS6738);
                    this_IfExpCS_1=ruleIfExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IfExpCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2865:2: this_SelfExpCS_2= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS6768);
                    this_SelfExpCS_2=ruleSelfExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SelfExpCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2878:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS6798);
                    this_PrimitiveLiteralExpCS_3=rulePrimitiveLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimitiveLiteralExpCS_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2891:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS6828);
                    this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TupleLiteralExpCS_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2904:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getMapLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_rulePrimaryExpCS6858);
                    this_MapLiteralExpCS_5=ruleMapLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MapLiteralExpCS_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2917:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS6888);
                    this_CollectionLiteralExpCS_6=ruleCollectionLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionLiteralExpCS_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2930:2: this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLambdaLiteralExpCSParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLambdaLiteralExpCS_in_rulePrimaryExpCS6918);
                    this_LambdaLiteralExpCS_7=ruleLambdaLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LambdaLiteralExpCS_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2943:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS6948);
                    this_TypeLiteralExpCS_8=ruleTypeLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeLiteralExpCS_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2956:2: this_NameExpCS_9= ruleNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_9()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_rulePrimaryExpCS6978);
                    this_NameExpCS_9=ruleNameExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NameExpCS_9; 
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
    // $ANTLR end "rulePrimaryExpCS"


    // $ANTLR start "entryRuleNameExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2975:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2976:2: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2977:2: iv_ruleNameExpCS= ruleNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS7013);
            iv_ruleNameExpCS=ruleNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNameExpCS7023); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNameExpCS"


    // $ANTLR start "ruleNameExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2984:1: ruleNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) ;
    public final EObject ruleNameExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_isPre_4_0=null;
        Token otherlv_5=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedSquareBracketedClauses_1_0 = null;

        EObject lv_ownedRoundBracketedClause_2_0 = null;

        EObject lv_ownedCurlyBracketedClause_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2987:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2988:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2988:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2988:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2988:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2989:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2989:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2990:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleNameExpCS7069);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3006:2: ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==66) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3007:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3007:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3008:3: lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleSquareBracketedClauseCS_in_ruleNameExpCS7090);
            	    lv_ownedSquareBracketedClauses_1_0=ruleSquareBracketedClauseCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedSquareBracketedClauses",
            	              		lv_ownedSquareBracketedClauses_1_0, 
            	              		"SquareBracketedClauseCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3024:3: ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==50) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3025:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3025:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3026:3: lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_ruleNameExpCS7112);
                    lv_ownedRoundBracketedClause_2_0=ruleRoundBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedRoundBracketedClause",
                              		lv_ownedRoundBracketedClause_2_0, 
                              		"RoundBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3042:3: ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==54) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3043:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3043:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3044:3: lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_ruleNameExpCS7134);
                    lv_ownedCurlyBracketedClause_3_0=ruleCurlyBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedCurlyBracketedClause",
                              		lv_ownedCurlyBracketedClause_3_0, 
                              		"CurlyBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3060:3: ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==64) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3060:4: ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre'
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3060:4: ( (lv_isPre_4_0= '@' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3061:1: (lv_isPre_4_0= '@' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3061:1: (lv_isPre_4_0= '@' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3062:3: lv_isPre_4_0= '@'
                    {
                    lv_isPre_4_0=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleNameExpCS7154); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isPre_4_0, grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNameExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "isPre", true, "@");
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleNameExpCS7179); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getNameExpCSAccess().getPreKeyword_4_1());
                          
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
    // $ANTLR end "ruleNameExpCS"


    // $ANTLR start "entryRuleCurlyBracketedClauseCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3087:1: entryRuleCurlyBracketedClauseCS returns [EObject current=null] : iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF ;
    public final EObject entryRuleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCurlyBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3088:2: (iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3089:2: iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCurlyBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_entryRuleCurlyBracketedClauseCS7217);
            iv_ruleCurlyBracketedClauseCS=ruleCurlyBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCurlyBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCurlyBracketedClauseCS7227); if (state.failed) return current;

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
    // $ANTLR end "entryRuleCurlyBracketedClauseCS"


    // $ANTLR start "ruleCurlyBracketedClauseCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3096:1: ruleCurlyBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' ) ;
    public final EObject ruleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3099:28: ( ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3100:1: ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3100:1: ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3100:2: () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3100:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3101:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getCurlyBracketedClauseCSAccess().getCurlyBracketedClauseCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleCurlyBracketedClauseCS7276); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3113:1: ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_SIMPLE_ID && LA46_0<=RULE_ESCAPED_ID)||LA46_0==55) ) {
                alt46=1;
            }
            else if ( (LA46_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3113:2: ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3113:2: ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( ((LA45_0>=RULE_SIMPLE_ID && LA45_0<=RULE_ESCAPED_ID)) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3113:3: ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3113:3: ( (lv_ownedParts_2_0= ruleShadowPartCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3114:1: (lv_ownedParts_2_0= ruleShadowPartCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3114:1: (lv_ownedParts_2_0= ruleShadowPartCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3115:3: lv_ownedParts_2_0= ruleShadowPartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS7299);
                            lv_ownedParts_2_0=ruleShadowPartCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedParts",
                                      		lv_ownedParts_2_0, 
                                      		"ShadowPartCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3131:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )*
                            loop44:
                            do {
                                int alt44=2;
                                int LA44_0 = input.LA(1);

                                if ( (LA44_0==52) ) {
                                    alt44=1;
                                }


                                switch (alt44) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3131:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleCurlyBracketedClauseCS7312); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_0_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3135:1: ( (lv_ownedParts_4_0= ruleShadowPartCS ) )
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3136:1: (lv_ownedParts_4_0= ruleShadowPartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3136:1: (lv_ownedParts_4_0= ruleShadowPartCS )
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3137:3: lv_ownedParts_4_0= ruleShadowPartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS7333);
                            	    lv_ownedParts_4_0=ruleShadowPartCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedParts",
                            	              		lv_ownedParts_4_0, 
                            	              		"ShadowPartCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop44;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3154:6: ( (lv_value_5_0= ruleStringLiteral ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3154:6: ( (lv_value_5_0= ruleStringLiteral ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3155:1: (lv_value_5_0= ruleStringLiteral )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3155:1: (lv_value_5_0= ruleStringLiteral )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3156:3: lv_value_5_0= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getValueStringLiteralParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleCurlyBracketedClauseCS7364);
                    lv_value_5_0=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_5_0, 
                              		"StringLiteral");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleCurlyBracketedClauseCS7377); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getCurlyBracketedClauseCSAccess().getRightCurlyBracketKeyword_3());
                  
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
    // $ANTLR end "ruleCurlyBracketedClauseCS"


    // $ANTLR start "entryRuleRoundBracketedClauseCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3184:1: entryRuleRoundBracketedClauseCS returns [EObject current=null] : iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF ;
    public final EObject entryRuleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoundBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3185:2: (iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3186:2: iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoundBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_entryRuleRoundBracketedClauseCS7413);
            iv_ruleRoundBracketedClauseCS=ruleRoundBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoundBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoundBracketedClauseCS7423); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRoundBracketedClauseCS"


    // $ANTLR start "ruleRoundBracketedClauseCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3193:1: ruleRoundBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) ;
    public final EObject ruleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_8=null;
        EObject lv_ownedArguments_2_0 = null;

        EObject lv_ownedArguments_3_0 = null;

        EObject lv_ownedArguments_4_0 = null;

        EObject lv_ownedArguments_5_0 = null;

        EObject lv_ownedArguments_6_0 = null;

        EObject lv_ownedArguments_7_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3196:28: ( ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3197:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3197:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3197:2: () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3197:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3198:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRoundBracketedClauseCSAccess().getRoundBracketedClauseCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleRoundBracketedClauseCS7472); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3210:1: ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=RULE_SIMPLE_ID && LA52_0<=RULE_SINGLE_QUOTED_STRING)||(LA52_0>=16 && LA52_0<=18)||(LA52_0>=35 && LA52_0<=50)||LA52_0==53||LA52_0==58||(LA52_0>=60 && LA52_0<=63)||LA52_0==71||(LA52_0>=76 && LA52_0<=77)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3210:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3210:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3211:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3211:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3212:3: lv_ownedArguments_2_0= ruleNavigatingArgCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_ruleRoundBracketedClauseCS7494);
                    lv_ownedArguments_2_0=ruleNavigatingArgCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedArguments",
                              		lv_ownedArguments_2_0, 
                              		"NavigatingArgCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3228:2: ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==52) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3229:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3229:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3230:3: lv_ownedArguments_3_0= ruleNavigatingCommaArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS7515);
                    	    lv_ownedArguments_3_0=ruleNavigatingCommaArgCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedArguments",
                    	              		lv_ownedArguments_3_0, 
                    	              		"NavigatingCommaArgCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3246:3: ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==70) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3246:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3246:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3247:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3247:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3248:3: lv_ownedArguments_4_0= ruleNavigatingSemiArgCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_2_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_ruleRoundBracketedClauseCS7538);
                            lv_ownedArguments_4_0=ruleNavigatingSemiArgCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedArguments",
                                      		lv_ownedArguments_4_0, 
                                      		"NavigatingSemiArgCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3264:2: ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            loop48:
                            do {
                                int alt48=2;
                                int LA48_0 = input.LA(1);

                                if ( (LA48_0==52) ) {
                                    alt48=1;
                                }


                                switch (alt48) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3265:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    {
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3265:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3266:3: lv_ownedArguments_5_0= ruleNavigatingCommaArgCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS7559);
                            	    lv_ownedArguments_5_0=ruleNavigatingCommaArgCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedArguments",
                            	              		lv_ownedArguments_5_0, 
                            	              		"NavigatingCommaArgCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop48;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3282:5: ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==69) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3282:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3282:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3283:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3283:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3284:3: lv_ownedArguments_6_0= ruleNavigatingBarArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_3_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_ruleRoundBracketedClauseCS7584);
                    	    lv_ownedArguments_6_0=ruleNavigatingBarArgCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedArguments",
                    	              		lv_ownedArguments_6_0, 
                    	              		"NavigatingBarArgCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3300:2: ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    loop50:
                    	    do {
                    	        int alt50=2;
                    	        int LA50_0 = input.LA(1);

                    	        if ( (LA50_0==52) ) {
                    	            alt50=1;
                    	        }


                    	        switch (alt50) {
                    	    	case 1 :
                    	    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3301:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    {
                    	    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3301:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3302:3: lv_ownedArguments_7_0= ruleNavigatingCommaArgCS
                    	    	    {
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_3_1_0()); 
                    	    	      	    
                    	    	    }
                    	    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS7605);
                    	    	    lv_ownedArguments_7_0=ruleNavigatingCommaArgCS();

                    	    	    state._fsp--;
                    	    	    if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {

                    	    	      	        if (current==null) {
                    	    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                    	    	      	        }
                    	    	             		add(
                    	    	             			current, 
                    	    	             			"ownedArguments",
                    	    	              		lv_ownedArguments_7_0, 
                    	    	              		"NavigatingCommaArgCS");
                    	    	      	        afterParserOrEnumRuleCall();
                    	    	      	    
                    	    	    }

                    	    	    }


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop50;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleRoundBracketedClauseCS7622); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getRoundBracketedClauseCSAccess().getRightParenthesisKeyword_3());
                  
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
    // $ANTLR end "ruleRoundBracketedClauseCS"


    // $ANTLR start "entryRuleSquareBracketedClauseCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3330:1: entryRuleSquareBracketedClauseCS returns [EObject current=null] : iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF ;
    public final EObject entryRuleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSquareBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3331:2: (iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3332:2: iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSquareBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSquareBracketedClauseCS_in_entryRuleSquareBracketedClauseCS7658);
            iv_ruleSquareBracketedClauseCS=ruleSquareBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSquareBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSquareBracketedClauseCS7668); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSquareBracketedClauseCS"


    // $ANTLR start "ruleSquareBracketedClauseCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3339:1: ruleSquareBracketedClauseCS returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedTerms_1_0 = null;

        EObject lv_ownedTerms_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3342:28: ( (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3343:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3343:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3343:3: otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleSquareBracketedClauseCS7705); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3347:1: ( (lv_ownedTerms_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3348:1: (lv_ownedTerms_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3348:1: (lv_ownedTerms_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3349:3: lv_ownedTerms_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS7726);
            lv_ownedTerms_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedTerms",
                      		lv_ownedTerms_1_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3365:2: (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==52) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3365:4: otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    {
            	    otherlv_2=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleSquareBracketedClauseCS7739); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3369:1: ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3370:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3370:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3371:3: lv_ownedTerms_3_0= ruleExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS7760);
            	    lv_ownedTerms_3_0=ruleExpCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedTerms",
            	              		lv_ownedTerms_3_0, 
            	              		"ExpCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            otherlv_4=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleSquareBracketedClauseCS7774); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getSquareBracketedClauseCSAccess().getRightSquareBracketKeyword_3());
                  
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
    // $ANTLR end "ruleSquareBracketedClauseCS"


    // $ANTLR start "entryRuleNavigatingArgCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3399:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3400:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3401:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS7810);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgCS7820); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNavigatingArgCS"


    // $ANTLR start "ruleNavigatingArgCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3408:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) ;
    public final EObject ruleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedNameExpression_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedInitExpression_4_0 = null;

        EObject lv_ownedInitExpression_6_0 = null;

        EObject lv_ownedType_8_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3411:28: ( ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3412:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3412:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=RULE_SIMPLE_ID && LA56_0<=RULE_SINGLE_QUOTED_STRING)||(LA56_0>=16 && LA56_0<=18)||(LA56_0>=35 && LA56_0<=50)||LA56_0==58||(LA56_0>=60 && LA56_0<=63)||LA56_0==71||(LA56_0>=76 && LA56_0<=77)) ) {
                alt56=1;
            }
            else if ( (LA56_0==53) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3412:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3412:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3412:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3412:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3413:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3413:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3414:3: lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS7867);
                    lv_ownedNameExpression_0_0=ruleNavigatingArgExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedNameExpression",
                              		lv_ownedNameExpression_0_0, 
                              		"NavigatingArgExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3430:2: ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    int alt55=3;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==53) ) {
                        alt55=1;
                    }
                    else if ( (LA55_0==68) ) {
                        alt55=2;
                    }
                    switch (alt55) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3430:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3430:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3430:5: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            {
                            otherlv_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleNavigatingArgCS7881); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_0_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3434:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3435:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3435:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3436:3: lv_ownedType_2_0= ruleTypeExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS7902);
                            lv_ownedType_2_0=ruleTypeExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedType",
                                      		lv_ownedType_2_0, 
                                      		"TypeExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3452:2: (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            int alt54=2;
                            int LA54_0 = input.LA(1);

                            if ( (LA54_0==25) ) {
                                alt54=1;
                            }
                            switch (alt54) {
                                case 1 :
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3452:4: otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    {
                                    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingArgCS7915); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0());
                                          
                                    }
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3456:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3457:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    {
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3457:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3458:3: lv_ownedInitExpression_4_0= ruleExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS7936);
                                    lv_ownedInitExpression_4_0=ruleExpCS();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"ownedInitExpression",
                                              		lv_ownedInitExpression_4_0, 
                                              		"ExpCS");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3475:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3475:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3475:8: otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            {
                            otherlv_5=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleNavigatingArgCS7958); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_1_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3479:1: ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3480:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3480:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3481:3: lv_ownedInitExpression_6_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS7979);
                            lv_ownedInitExpression_6_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_6_0, 
                                      		"ExpCS");
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
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3498:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3498:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3498:8: otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    {
                    otherlv_7=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleNavigatingArgCS8002); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3502:1: ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3503:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3503:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3504:3: lv_ownedType_8_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS8023);
                    lv_ownedType_8_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_8_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


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
    // $ANTLR end "ruleNavigatingArgCS"


    // $ANTLR start "entryRuleNavigatingBarArgCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3528:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3529:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3530:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS8060);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingBarArgCS8070); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNavigatingBarArgCS"


    // $ANTLR start "ruleNavigatingBarArgCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3537:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedNameExpression_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3540:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3541:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3541:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3541:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3541:2: ( (lv_prefix_0_0= '|' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3542:1: (lv_prefix_0_0= '|' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3542:1: (lv_prefix_0_0= '|' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3543:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleNavigatingBarArgCS8113); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNavigatingBarArgCSRule());
              	        }
                     		setWithLastConsumed(current, "prefix", lv_prefix_0_0, "|");
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3556:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3557:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3557:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3558:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS8147);
            lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedNameExpression",
                      		lv_ownedNameExpression_1_0, 
                      		"NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3574:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==53) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3574:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleNavigatingBarArgCS8160); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3578:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3579:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3579:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3580:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS8181);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_3_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3596:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==25) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3596:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingBarArgCS8194); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3600:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3601:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3601:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3602:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS8215);
                            lv_ownedInitExpression_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_5_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleNavigatingBarArgCS"


    // $ANTLR start "entryRuleNavigatingCommaArgCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3626:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3627:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3628:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS8255);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS8265); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNavigatingCommaArgCS"


    // $ANTLR start "ruleNavigatingCommaArgCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3635:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) ;
    public final EObject ruleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_ownedNameExpression_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;

        EObject lv_ownedInitExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3638:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3639:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3639:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3639:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3639:2: ( (lv_prefix_0_0= ',' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3640:1: (lv_prefix_0_0= ',' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3640:1: (lv_prefix_0_0= ',' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3641:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleNavigatingCommaArgCS8308); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNavigatingCommaArgCSRule());
              	        }
                     		setWithLastConsumed(current, "prefix", lv_prefix_0_0, ",");
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3654:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3655:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3655:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3656:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS8342);
            lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedNameExpression",
                      		lv_ownedNameExpression_1_0, 
                      		"NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3672:2: ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            int alt60=3;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==53) ) {
                alt60=1;
            }
            else if ( (LA60_0==68) ) {
                alt60=2;
            }
            switch (alt60) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3672:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3672:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3672:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleNavigatingCommaArgCS8356); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3676:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3677:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3677:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3678:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS8377);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_3_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3694:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==25) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3694:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingCommaArgCS8390); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3698:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3699:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3699:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3700:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS8411);
                            lv_ownedInitExpression_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_5_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3717:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3717:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3717:8: otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    {
                    otherlv_6=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleNavigatingCommaArgCS8433); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3721:1: ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3722:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3722:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3723:3: lv_ownedInitExpression_7_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS8454);
                    lv_ownedInitExpression_7_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedInitExpression",
                              		lv_ownedInitExpression_7_0, 
                              		"ExpCS");
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
    // $ANTLR end "ruleNavigatingCommaArgCS"


    // $ANTLR start "entryRuleNavigatingSemiArgCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3747:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3748:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3749:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS8493);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS8503); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNavigatingSemiArgCS"


    // $ANTLR start "ruleNavigatingSemiArgCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3756:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedNameExpression_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3759:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3760:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3760:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3760:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3760:2: ( (lv_prefix_0_0= ';' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3761:1: (lv_prefix_0_0= ';' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3761:1: (lv_prefix_0_0= ';' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3762:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleNavigatingSemiArgCS8546); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNavigatingSemiArgCSRule());
              	        }
                     		setWithLastConsumed(current, "prefix", lv_prefix_0_0, ";");
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3775:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3776:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3776:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3777:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS8580);
            lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedNameExpression",
                      		lv_ownedNameExpression_1_0, 
                      		"NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3793:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==53) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3793:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleNavigatingSemiArgCS8593); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3797:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3798:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3798:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3799:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS8614);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_3_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3815:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==25) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3815:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingSemiArgCS8627); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3819:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3820:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3820:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3821:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS8648);
                            lv_ownedInitExpression_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_5_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleNavigatingSemiArgCS"


    // $ANTLR start "entryRuleNavigatingArgExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3845:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3846:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3847:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS8688);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgExpCS8698); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNavigatingArgExpCS"


    // $ANTLR start "ruleNavigatingArgExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3854:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3857:28: (this_ExpCS_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3859:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS8747);
            this_ExpCS_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ExpCS_0; 
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
    // $ANTLR end "ruleNavigatingArgExpCS"


    // $ANTLR start "entryRuleIfExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3878:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3879:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3880:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS8781);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfExpCS8791); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIfExpCS"


    // $ANTLR start "ruleIfExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3887:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) ;
    public final EObject ruleIfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedCondition_1_1 = null;

        EObject lv_ownedCondition_1_2 = null;

        EObject lv_ownedThenExpression_3_0 = null;

        EObject lv_ownedIfThenExpressions_4_0 = null;

        EObject lv_ownedElseExpression_6_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3890:28: ( (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3891:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3891:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3891:3: otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif'
            {
            otherlv_0=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleIfExpCS8828); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3895:1: ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3896:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3896:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3897:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3897:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            int alt63=2;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case RULE_SINGLE_QUOTED_STRING:
            case 16:
            case 17:
            case 18:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 58:
            case 60:
            case 61:
            case 62:
            case 63:
            case 71:
            case 76:
            case 77:
                {
                alt63=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA63_2 = input.LA(2);

                if ( (LA63_2==53) ) {
                    alt63=2;
                }
                else if ( (LA63_2==16||(LA63_2>=18 && LA63_2<=34)||LA63_2==50||LA63_2==54||LA63_2==64||LA63_2==66||LA63_2==72||LA63_2==79) ) {
                    alt63=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA63_3 = input.LA(2);

                if ( (LA63_3==16||(LA63_3>=18 && LA63_3<=34)||LA63_3==50||LA63_3==54||LA63_3==64||LA63_3==66||LA63_3==72||LA63_3==79) ) {
                    alt63=1;
                }
                else if ( (LA63_3==53) ) {
                    alt63=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 3, input);

                    throw nvae;
                }
                }
                break;
            case 53:
                {
                alt63=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3898:3: lv_ownedCondition_1_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS8851);
                    lv_ownedCondition_1_1=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedCondition",
                              		lv_ownedCondition_1_1, 
                              		"ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3913:8: lv_ownedCondition_1_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleIfExpCS8870);
                    lv_ownedCondition_1_2=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedCondition",
                              		lv_ownedCondition_1_2, 
                              		"PatternExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }

            otherlv_2=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleIfExpCS8885); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3935:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3936:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3936:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3937:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS8906);
            lv_ownedThenExpression_3_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedThenExpression",
                      		lv_ownedThenExpression_3_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3953:2: ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==75) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3954:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3954:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3955:3: lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleElseIfThenExpCS_in_ruleIfExpCS8927);
            	    lv_ownedIfThenExpressions_4_0=ruleElseIfThenExpCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedIfThenExpressions",
            	              		lv_ownedIfThenExpressions_4_0, 
            	              		"ElseIfThenExpCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            otherlv_5=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleIfExpCS8940); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getIfExpCSAccess().getElseKeyword_5());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3975:1: ( (lv_ownedElseExpression_6_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3976:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3976:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3977:3: lv_ownedElseExpression_6_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS8961);
            lv_ownedElseExpression_6_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedElseExpression",
                      		lv_ownedElseExpression_6_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleIfExpCS8973); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getIfExpCSAccess().getEndifKeyword_7());
                  
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
    // $ANTLR end "ruleIfExpCS"


    // $ANTLR start "entryRuleElseIfThenExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4005:1: entryRuleElseIfThenExpCS returns [EObject current=null] : iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF ;
    public final EObject entryRuleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIfThenExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4006:2: (iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4007:2: iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElseIfThenExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleElseIfThenExpCS_in_entryRuleElseIfThenExpCS9009);
            iv_ruleElseIfThenExpCS=ruleElseIfThenExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElseIfThenExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElseIfThenExpCS9019); if (state.failed) return current;

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
    // $ANTLR end "entryRuleElseIfThenExpCS"


    // $ANTLR start "ruleElseIfThenExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4014:1: ruleElseIfThenExpCS returns [EObject current=null] : (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) ;
    public final EObject ruleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedCondition_1_0 = null;

        EObject lv_ownedThenExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4017:28: ( (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4018:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4018:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4018:3: otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleElseIfThenExpCS9056); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4022:1: ( (lv_ownedCondition_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4023:1: (lv_ownedCondition_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4023:1: (lv_ownedCondition_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4024:3: lv_ownedCondition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS9077);
            lv_ownedCondition_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedCondition",
                      		lv_ownedCondition_1_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleElseIfThenExpCS9089); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4044:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4045:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4045:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4046:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS9110);
            lv_ownedThenExpression_3_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedThenExpression",
                      		lv_ownedThenExpression_3_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

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
    // $ANTLR end "ruleElseIfThenExpCS"


    // $ANTLR start "entryRuleLetExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4070:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4071:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4072:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS9146);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetExpCS9156); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLetExpCS"


    // $ANTLR start "ruleLetExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4079:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedVariables_1_0 = null;

        EObject lv_ownedVariables_3_0 = null;

        EObject lv_ownedInExpression_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4082:28: ( (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4083:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4083:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4083:3: otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleLetExpCS9193); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4087:1: ( (lv_ownedVariables_1_0= ruleLetVariableCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4088:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4088:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4089:3: lv_ownedVariables_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9214);
            lv_ownedVariables_1_0=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedVariables",
                      		lv_ownedVariables_1_0, 
                      		"LetVariableCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4105:2: (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==52) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4105:4: otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleLetExpCS9227); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4109:1: ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4110:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4110:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4111:3: lv_ownedVariables_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9248);
            	    lv_ownedVariables_3_0=ruleLetVariableCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedVariables",
            	              		lv_ownedVariables_3_0, 
            	              		"LetVariableCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

            otherlv_4=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleLetExpCS9262); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4131:1: ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4132:1: (lv_ownedInExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4132:1: (lv_ownedInExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4133:3: lv_ownedInExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetExpCS9283);
            lv_ownedInExpression_5_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedInExpression",
                      		lv_ownedInExpression_5_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

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
    // $ANTLR end "ruleLetExpCS"


    // $ANTLR start "entryRuleLetVariableCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4157:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4158:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4159:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS9319);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetVariableCS9329); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLetVariableCS"


    // $ANTLR start "ruleLetVariableCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4166:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedRoundBracketedClause_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4169:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4170:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4170:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4170:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4170:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4171:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4171:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4172:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS9375);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4188:2: ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==50) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4189:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4189:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4190:3: lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_ruleLetVariableCS9396);
                    lv_ownedRoundBracketedClause_1_0=ruleRoundBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedRoundBracketedClause",
                              		lv_ownedRoundBracketedClause_1_0, 
                              		"RoundBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4206:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==53) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4206:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    {
                    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleLetVariableCS9410); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4210:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4211:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4211:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4212:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS9431);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_3_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLetVariableCS9445); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4232:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4233:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4233:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4234:3: lv_ownedInitExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetVariableCS9466);
            lv_ownedInitExpression_5_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedInitExpression",
                      		lv_ownedInitExpression_5_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

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
    // $ANTLR end "ruleLetVariableCS"


    // $ANTLR start "entryRuleNestedExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4258:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4259:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4260:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS9502);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedExpCS9512); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNestedExpCS"


    // $ANTLR start "ruleNestedExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4267:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4270:28: ( (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4271:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4271:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4271:3: otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleNestedExpCS9549); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4275:1: ( (lv_ownedExpression_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4276:1: (lv_ownedExpression_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4276:1: (lv_ownedExpression_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4277:3: lv_ownedExpression_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNestedExpCS9570);
            lv_ownedExpression_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNestedExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedExpression",
                      		lv_ownedExpression_1_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleNestedExpCS9582); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getNestedExpCSAccess().getRightParenthesisKeyword_2());
                  
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
    // $ANTLR end "ruleNestedExpCS"


    // $ANTLR start "entryRuleSelfExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4305:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4306:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4307:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS9618);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelfExpCS9628); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSelfExpCS"


    // $ANTLR start "ruleSelfExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4314:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4317:28: ( ( () otherlv_1= 'self' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4318:1: ( () otherlv_1= 'self' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4318:1: ( () otherlv_1= 'self' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4318:2: () otherlv_1= 'self'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4318:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4319:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleSelfExpCS9677); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSelfExpCSAccess().getSelfKeyword_1());
                  
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
    // $ANTLR end "ruleSelfExpCS"


    // $ANTLR start "entryRuleMultiplicityBoundsCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4339:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4340:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4341:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS9713);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS9723); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4348:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4351:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4352:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4352:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4352:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4352:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4353:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4353:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4354:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS9769);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4370:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==56) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4370:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleMultiplicityBoundsCS9782); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4374:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4375:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4375:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4376:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS9803);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4400:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4401:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4402:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS9841);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityCS9851); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4409:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_MultiplicityBoundsCS_1 = null;

        EObject this_MultiplicityStringCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4412:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4413:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4413:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4413:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleMultiplicityCS9888); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4417:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_INT) ) {
                alt69=1;
            }
            else if ( (LA69_0==18||LA69_0==20||LA69_0==78) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4418:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS9914);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4431:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS9944);
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

            otherlv_3=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleMultiplicityCS9956); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_2());
                  
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4454:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4455:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4456:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS9992);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS10002); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4463:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4466:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4467:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4467:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4468:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4468:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4469:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4469:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt70=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt70=1;
                }
                break;
            case 20:
                {
                alt70=2;
                }
                break;
            case 78:
                {
                alt70=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4470:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMultiplicityStringCS10046); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4482:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMultiplicityStringCS10075); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4494:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleMultiplicityStringCS10104); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4517:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4518:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4519:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS10155);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS10165); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4526:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4529:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4530:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4530:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4530:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4530:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4531:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4531:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4532:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS10211);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4548:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==79) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4548:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,79,FollowSets000.FOLLOW_79_in_rulePathNameCS10224); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4552:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4553:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4553:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4554:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS10245);
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
            	    break loop71;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4578:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4579:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4580:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS10283);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS10293); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4587:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4590:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4591:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4591:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4592:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4592:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4593:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS10344);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4617:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4618:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4619:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS10379);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS10389); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4626:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4629:28: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4630:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4630:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4631:1: ( ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4631:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4632:3: ruleUnreservedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS10440);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4656:1: entryRuleTemplateBindingCS returns [EObject current=null] : iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF ;
    public final EObject entryRuleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBindingCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4657:2: (iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4658:2: iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateBindingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS10475);
            iv_ruleTemplateBindingCS=ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateBindingCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateBindingCS10485); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4665:1: ruleTemplateBindingCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedSubstitutions_1_0 = null;

        EObject lv_ownedSubstitutions_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4668:28: ( (otherlv_0= '(' ( (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) ) )* otherlv_4= ')' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4669:1: (otherlv_0= '(' ( (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) ) )* otherlv_4= ')' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4669:1: (otherlv_0= '(' ( (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) ) )* otherlv_4= ')' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4669:3: otherlv_0= '(' ( (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleTemplateBindingCS10522); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTemplateBindingCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4673:1: ( (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4674:1: (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4674:1: (lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4675:3: lv_ownedSubstitutions_1_0= ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS10543);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4691:2: (otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==52) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4691:4: otherlv_2= ',' ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) )
            	    {
            	    otherlv_2=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleTemplateBindingCS10556); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4695:1: ( (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4696:1: (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4696:1: (lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4697:3: lv_ownedSubstitutions_3_0= ruleTemplateParameterSubstitutionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS10577);
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
            	    break loop72;
                }
            } while (true);

            otherlv_4=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleTemplateBindingCS10591); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4725:1: entryRuleTemplateParameterSubstitutionCS returns [EObject current=null] : iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF ;
    public final EObject entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateParameterSubstitutionCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4726:2: (iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4727:2: iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS10627);
            iv_ruleTemplateParameterSubstitutionCS=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateParameterSubstitutionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS10637); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4734:1: ruleTemplateParameterSubstitutionCS returns [EObject current=null] : ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) ;
    public final EObject ruleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedActualParameter_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4737:28: ( ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4738:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4738:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4739:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4739:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4740:3: lv_ownedActualParameter_0_0= ruleTypeRefCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS10682);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4766:1: entryRuleTypeParameterCS returns [EObject current=null] : iv_ruleTypeParameterCS= ruleTypeParameterCS EOF ;
    public final EObject entryRuleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameterCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4767:2: (iv_ruleTypeParameterCS= ruleTypeParameterCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4768:2: iv_ruleTypeParameterCS= ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS10719);
            iv_ruleTypeParameterCS=ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeParameterCS10729); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4775:1: ruleTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* ) | (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) ) )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4778:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* ) | (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4779:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* ) | (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4779:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* ) | (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4779:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* ) | (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4779:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4780:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4780:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4781:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS10775);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4797:2: ( (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* ) | (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) ) )?
            int alt74=3;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==80) ) {
                alt74=1;
            }
            else if ( (LA74_0==82) ) {
                alt74=2;
            }
            switch (alt74) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4797:3: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4797:3: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4797:5: otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    {
                    otherlv_1=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleTypeParameterCS10789); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4801:1: ( (lv_ownedExtends_2_0= ruleTypedRefCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4802:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4802:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4803:3: lv_ownedExtends_2_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS10810);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4819:2: (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==81) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4819:4: otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleTypeParameterCS10823); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4823:1: ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4824:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4824:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4825:3: lv_ownedExtends_4_0= ruleTypedRefCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS10844);
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
                    	    break loop73;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4842:6: (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4842:6: (otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4842:8: otherlv_5= 'super' ( (lv_ownedSuper_6_0= ruleTypedRefCS ) )
                    {
                    otherlv_5=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleTypeParameterCS10866); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTypeParameterCSAccess().getSuperKeyword_1_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4846:1: ( (lv_ownedSuper_6_0= ruleTypedRefCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4847:1: (lv_ownedSuper_6_0= ruleTypedRefCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4847:1: (lv_ownedSuper_6_0= ruleTypedRefCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4848:3: lv_ownedSuper_6_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedSuperTypedRefCSParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS10887);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4872:1: entryRuleTypeRefCS returns [EObject current=null] : iv_ruleTypeRefCS= ruleTypeRefCS EOF ;
    public final EObject entryRuleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4873:2: (iv_ruleTypeRefCS= ruleTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4874:2: iv_ruleTypeRefCS= ruleTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS10926);
            iv_ruleTypeRefCS=ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRefCS10936); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4881:1: ruleTypeRefCS returns [EObject current=null] : (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) ;
    public final EObject ruleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedRefCS_0 = null;

        EObject this_WildcardTypeRefCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4884:28: ( (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4885:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4885:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=RULE_SIMPLE_ID && LA75_0<=RULE_ESCAPED_ID)) ) {
                alt75=1;
            }
            else if ( (LA75_0==78) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4886:2: this_TypedRefCS_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeRefCS10986);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4899:2: this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS11016);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4918:1: entryRuleTypedRefCS returns [EObject current=null] : iv_ruleTypedRefCS= ruleTypedRefCS EOF ;
    public final EObject entryRuleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4919:2: (iv_ruleTypedRefCS= ruleTypedRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4920:2: iv_ruleTypedRefCS= ruleTypedRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS11051);
            iv_ruleTypedRefCS=ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedRefCS11061); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4927:1: ruleTypedRefCS returns [EObject current=null] : this_TypedTypeRefCS_0= ruleTypedTypeRefCS ;
    public final EObject ruleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedTypeRefCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4930:28: (this_TypedTypeRefCS_0= ruleTypedTypeRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4932:2: this_TypedTypeRefCS_0= ruleTypedTypeRefCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS11110);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4951:1: entryRuleTypedTypeRefCS returns [EObject current=null] : iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF ;
    public final EObject entryRuleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4952:2: (iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4953:2: iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS11144);
            iv_ruleTypedTypeRefCS=ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedTypeRefCS11154); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4960:1: ruleTypedTypeRefCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedBinding_1_0= ruleTemplateBindingCS ) )? ) ;
    public final EObject ruleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedBinding_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4963:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedBinding_1_0= ruleTemplateBindingCS ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4964:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedBinding_1_0= ruleTemplateBindingCS ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4964:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedBinding_1_0= ruleTemplateBindingCS ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4964:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedBinding_1_0= ruleTemplateBindingCS ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4964:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4965:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4965:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4966:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypedTypeRefCS11200);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4982:2: ( (lv_ownedBinding_1_0= ruleTemplateBindingCS ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==50) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4983:1: (lv_ownedBinding_1_0= ruleTemplateBindingCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4983:1: (lv_ownedBinding_1_0= ruleTemplateBindingCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4984:3: lv_ownedBinding_1_0= ruleTemplateBindingCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_ruleTypedTypeRefCS11221);
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


    // $ANTLR start "entryRuleWildcardTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5008:1: entryRuleWildcardTypeRefCS returns [EObject current=null] : iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF ;
    public final EObject entryRuleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5009:2: (iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5010:2: iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS11258);
            iv_ruleWildcardTypeRefCS=ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcardTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcardTypeRefCS11268); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5017:1: ruleWildcardTypeRefCS returns [EObject current=null] : ( () otherlv_1= '?' ( (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) ) | (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) ) )? ) ;
    public final EObject ruleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedExtends_3_0 = null;

        EObject lv_ownedSuper_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5020:28: ( ( () otherlv_1= '?' ( (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) ) | (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5021:1: ( () otherlv_1= '?' ( (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) ) | (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5021:1: ( () otherlv_1= '?' ( (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) ) | (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5021:2: () otherlv_1= '?' ( (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) ) | (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5021:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5022:2: 
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

            otherlv_1=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleWildcardTypeRefCS11317); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5034:1: ( (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) ) | (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) ) )?
            int alt77=3;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==80) ) {
                alt77=1;
            }
            else if ( (LA77_0==82) ) {
                alt77=2;
            }
            switch (alt77) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5034:2: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5034:2: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5034:4: otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    {
                    otherlv_2=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleWildcardTypeRefCS11331); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5038:1: ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5039:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5039:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5040:3: lv_ownedExtends_3_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS11352);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5057:6: (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5057:6: (otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5057:8: otherlv_4= 'super' ( (lv_ownedSuper_5_0= ruleTypedRefCS ) )
                    {
                    otherlv_4=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleWildcardTypeRefCS11372); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getWildcardTypeRefCSAccess().getSuperKeyword_2_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5061:1: ( (lv_ownedSuper_5_0= ruleTypedRefCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5062:1: (lv_ownedSuper_5_0= ruleTypedRefCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5062:1: (lv_ownedSuper_5_0= ruleTypedRefCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5063:3: lv_ownedSuper_5_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedSuperTypedRefCSParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS11393);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5087:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5088:2: (iv_ruleID= ruleID EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5089:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID11433);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID11444); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5096:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5099:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5100:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5100:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_SIMPLE_ID) ) {
                alt78=1;
            }
            else if ( (LA78_0==RULE_ESCAPED_ID) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5100:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID11484); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5108:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID11510); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5123:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5124:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5125:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier11556);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier11567); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5132:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5135:28: (this_ID_0= ruleID )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5137:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier11613);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5155:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5156:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5157:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER11658);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER11669); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5164:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5167:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5168:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER11708); if (state.failed) return current;
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


    // $ANTLR start "entryRuleNUMBER_LITERAL"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5183:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5184:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5185:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL11753);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNUMBER_LITERAL11764); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNUMBER_LITERAL"


    // $ANTLR start "ruleNUMBER_LITERAL"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5192:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5195:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5196:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL11803); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleNUMBER_LITERAL"


    // $ANTLR start "entryRuleStringLiteral"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5211:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5212:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5213:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral11848);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral11859); if (state.failed) return current;

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
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5220:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5223:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5224:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral11898); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_SINGLE_QUOTED_STRING_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SINGLE_QUOTED_STRING_0, grammarAccess.getStringLiteralAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleUPPER"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5239:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5240:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5241:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER11943);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER11954); if (state.failed) return current;

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5248:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5251:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5252:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5252:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_INT) ) {
                alt79=1;
            }
            else if ( (LA79_0==18) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5252:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER11994); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5261:2: kw= '*'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUPPER12018); if (state.failed) return current;
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


    // $ANTLR start "entryRuleURI"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5274:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5275:2: (iv_ruleURI= ruleURI EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5276:2: iv_ruleURI= ruleURI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_entryRuleURI12059);
            iv_ruleURI=ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURI.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURI12070); if (state.failed) return current;

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
    // $ANTLR end "entryRuleURI"


    // $ANTLR start "ruleURI"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5283:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5286:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5287:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI12109); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_SINGLE_QUOTED_STRING_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SINGLE_QUOTED_STRING_0, grammarAccess.getURIAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleURI"

    // $ANTLR start synpred66_InternalEssentialOCL
    public final void synpred66_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_TypeLiteralCS_1 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2526:2: (this_TypeLiteralCS_1= ruleTypeLiteralCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2526:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_synpred66_InternalEssentialOCL6062);
        this_TypeLiteralCS_1=ruleTypeLiteralCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred66_InternalEssentialOCL

    // $ANTLR start synpred69_InternalEssentialOCL
    public final void synpred69_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2589:2: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2589:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        {
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2589:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2590:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_synpred69_InternalEssentialOCL6211);
        this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

        state._fsp--;
        if (state.failed) return ;
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2601:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        int alt88=2;
        int LA88_0 = input.LA(1);

        if ( (LA88_0==16||(LA88_0>=18 && LA88_0<=34)) ) {
            alt88=1;
        }
        switch (alt88) {
            case 1 :
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2601:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                {
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2601:2: ()
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2602:2: 
                {
                if ( state.backtracking==0 ) {
                   
                  	  /* */ 
                  	
                }

                }

                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2610:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2611:1: (lv_name_2_0= ruleBinaryOperatorName )
                {
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2611:1: (lv_name_2_0= ruleBinaryOperatorName )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2612:3: lv_name_2_0= ruleBinaryOperatorName
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorName_in_synpred69_InternalEssentialOCL6244);
                lv_name_2_0=ruleBinaryOperatorName();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2628:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2629:1: (lv_ownedRight_3_0= ruleExpCS )
                {
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2629:1: (lv_ownedRight_3_0= ruleExpCS )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2630:3: lv_ownedRight_3_0= ruleExpCS
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_synpred69_InternalEssentialOCL6265);
                lv_ownedRight_3_0=ruleExpCS();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred69_InternalEssentialOCL

    // $ANTLR start synpred76_InternalEssentialOCL
    public final void synpred76_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_4 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2891:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2891:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_synpred76_InternalEssentialOCL6828);
        this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred76_InternalEssentialOCL

    // $ANTLR start synpred77_InternalEssentialOCL
    public final void synpred77_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_MapLiteralExpCS_5 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2904:2: (this_MapLiteralExpCS_5= ruleMapLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2904:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_synpred77_InternalEssentialOCL6858);
        this_MapLiteralExpCS_5=ruleMapLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred77_InternalEssentialOCL

    // $ANTLR start synpred78_InternalEssentialOCL
    public final void synpred78_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_6 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2917:2: (this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2917:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_synpred78_InternalEssentialOCL6888);
        this_CollectionLiteralExpCS_6=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred78_InternalEssentialOCL

    // $ANTLR start synpred80_InternalEssentialOCL
    public final void synpred80_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_8 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2943:2: (this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2943:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_synpred80_InternalEssentialOCL6948);
        this_TypeLiteralExpCS_8=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred80_InternalEssentialOCL

    // Delegated rules

    public final boolean synpred80_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred77_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred77_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred78_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred76_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred76_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA33 dfa33 = new DFA33(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA39 dfa39 = new DFA39(this);
    static final String DFA33_eotS =
        "\23\uffff";
    static final String DFA33_eofS =
        "\23\uffff";
    static final String DFA33_minS =
        "\1\4\12\uffff\5\0\3\uffff";
    static final String DFA33_maxS =
        "\1\61\12\uffff\5\0\3\uffff";
    static final String DFA33_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\16\uffff\1\3";
    static final String DFA33_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\3\uffff}>";
    static final String[] DFA33_transitionS = {
            "\2\1\35\uffff\12\3\1\13\1\14\1\15\1\16\1\17",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "2512:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_11 = input.LA(1);

                         
                        int index33_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index33_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA33_12 = input.LA(1);

                         
                        int index33_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index33_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA33_13 = input.LA(1);

                         
                        int index33_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index33_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA33_14 = input.LA(1);

                         
                        int index33_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index33_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA33_15 = input.LA(1);

                         
                        int index33_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index33_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA36_eotS =
        "\40\uffff";
    static final String DFA36_eofS =
        "\40\uffff";
    static final String DFA36_minS =
        "\1\4\2\0\35\uffff";
    static final String DFA36_maxS =
        "\1\115\2\0\35\uffff";
    static final String DFA36_acceptS =
        "\3\uffff\1\1\33\uffff\1\2";
    static final String DFA36_specialS =
        "\1\uffff\1\0\1\1\35\uffff}>";
    static final String[] DFA36_transitionS = {
            "\4\3\10\uffff\1\1\1\2\1\3\20\uffff\20\3\7\uffff\1\3\1\uffff"+
            "\4\3\7\uffff\1\3\4\uffff\1\37\1\3",
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

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "2589:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_1 = input.LA(1);

                         
                        int index36_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred69_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index36_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_2 = input.LA(1);

                         
                        int index36_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred69_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index36_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA39_eotS =
        "\40\uffff";
    static final String DFA39_eofS =
        "\40\uffff";
    static final String DFA39_minS =
        "\1\4\12\uffff\7\0\16\uffff";
    static final String DFA39_maxS =
        "\1\115\12\uffff\7\0\16\uffff";
    static final String DFA39_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\15\uffff\1\10\1\11\7\uffff\1\12\1\uffff"+
        "\1\5\1\6\1\7";
    static final String DFA39_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\16\uffff}>";
    static final String[] DFA39_transitionS = {
            "\2\33\2\4\12\uffff\1\4\20\uffff\1\14\1\13\10\23\1\15\1\16\1"+
            "\17\1\20\1\21\1\1\7\uffff\1\22\1\uffff\4\4\7\uffff\1\2\5\uffff"+
            "\1\3",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            ""
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "2838:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_11 = input.LA(1);

                         
                        int index39_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_InternalEssentialOCL()) ) {s = 29;}

                        else if ( (synpred80_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index39_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA39_12 = input.LA(1);

                         
                        int index39_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred77_InternalEssentialOCL()) ) {s = 30;}

                        else if ( (synpred80_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index39_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA39_13 = input.LA(1);

                         
                        int index39_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred80_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index39_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA39_14 = input.LA(1);

                         
                        int index39_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred80_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index39_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA39_15 = input.LA(1);

                         
                        int index39_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred80_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index39_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA39_16 = input.LA(1);

                         
                        int index39_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred80_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index39_16);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA39_17 = input.LA(1);

                         
                        int index39_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred80_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index39_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 39, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleModel136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorName_in_entryRuleEssentialOCLUnaryOperatorName174 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorName185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleEssentialOCLUnaryOperatorName223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleEssentialOCLUnaryOperatorName242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorName_in_entryRuleEssentialOCLInfixOperatorName283 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorName294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleEssentialOCLInfixOperatorName332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleEssentialOCLInfixOperatorName351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleEssentialOCLInfixOperatorName370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleEssentialOCLInfixOperatorName389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleEssentialOCLInfixOperatorName408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleEssentialOCLInfixOperatorName427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleEssentialOCLInfixOperatorName446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleEssentialOCLInfixOperatorName465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleEssentialOCLInfixOperatorName484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleEssentialOCLInfixOperatorName503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleEssentialOCLInfixOperatorName522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleEssentialOCLInfixOperatorName541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleEssentialOCLInfixOperatorName560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleEssentialOCLInfixOperatorName579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorName_in_entryRuleEssentialOCLNavigationOperatorName620 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorName631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleEssentialOCLNavigationOperatorName669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleEssentialOCLNavigationOperatorName688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleEssentialOCLNavigationOperatorName707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleEssentialOCLNavigationOperatorName726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorName_in_entryRuleBinaryOperatorName767 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperatorName778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorName_in_ruleBinaryOperatorName825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorName_in_ruleBinaryOperatorName858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorName_in_entryRuleInfixOperatorName904 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixOperatorName915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorName_in_ruleInfixOperatorName961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorName_in_entryRuleNavigationOperatorName1006 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperatorName1017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorName_in_ruleNavigationOperatorName1063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorName_in_entryRuleUnaryOperatorName1108 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperatorName1119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorName_in_ruleUnaryOperatorName1165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName1210 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName1221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName1267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1312 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName1323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName1369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName1414 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName1425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName1472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName1505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName1538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleEssentialOCLUnreservedName1562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleEssentialOCLUnreservedName1581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName1622 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName1633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName1679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS1725 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIFirstPathElementCS1735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS1787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_ruleURIFirstPathElementCS1833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier1871 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier1882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rulePrimitiveTypeIdentifier1920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rulePrimitiveTypeIdentifier1939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rulePrimitiveTypeIdentifier1958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rulePrimitiveTypeIdentifier1977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rulePrimitiveTypeIdentifier1996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rulePrimitiveTypeIdentifier2015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_rulePrimitiveTypeIdentifier2034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_rulePrimitiveTypeIdentifier2053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS2093 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeCS2103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS2148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier2184 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier2195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleCollectionTypeIdentifier2233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleCollectionTypeIdentifier2252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleCollectionTypeIdentifier2271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleCollectionTypeIdentifier2290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleCollectionTypeIdentifier2309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS2349 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeCS2359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS2405 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_50_in_ruleCollectionTypeCS2418 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS2439 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleCollectionTypeCS2451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_entryRuleMapTypeCS2489 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapTypeCS2499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleMapTypeCS2542 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_50_in_ruleMapTypeCS2568 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleMapTypeCS2589 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleMapTypeCS2601 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleMapTypeCS2622 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleMapTypeCS2634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS2672 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleTypeCS2682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleTupleTypeCS2725 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_50_in_ruleTupleTypeCS2751 = new BitSet(new long[]{0x0008000000000030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS2773 = new BitSet(new long[]{0x0018000000000000L});
        public static final BitSet FOLLOW_52_in_ruleTupleTypeCS2786 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS2807 = new BitSet(new long[]{0x0018000000000000L});
        public static final BitSet FOLLOW_51_in_ruleTupleTypeCS2823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS2861 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTuplePartCS2871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS2917 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleTuplePartCS2929 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS2950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS2986 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS2996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS3042 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleCollectionLiteralExpCS3054 = new BitSet(new long[]{0xF4A7FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS3076 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_52_in_ruleCollectionLiteralExpCS3089 = new BitSet(new long[]{0xF427FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS3110 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_55_in_ruleCollectionLiteralExpCS3126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS3162 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS3172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS3219 = new BitSet(new long[]{0x0100000000000002L});
        public static final BitSet FOLLOW_56_in_ruleCollectionLiteralPartCS3232 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS3253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleCollectionLiteralPartCS3283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionPatternCS_in_entryRuleCollectionPatternCS3319 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionPatternCS3329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionPatternCS3375 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleCollectionPatternCS3387 = new BitSet(new long[]{0xF4A7FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS3409 = new BitSet(new long[]{0x0210000000000000L});
        public static final BitSet FOLLOW_52_in_ruleCollectionPatternCS3422 = new BitSet(new long[]{0xF427FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS3443 = new BitSet(new long[]{0x0210000000000000L});
        public static final BitSet FOLLOW_57_in_ruleCollectionPatternCS3458 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleCollectionPatternCS3479 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleCollectionPatternCS3494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_entryRuleShadowPartCS3530 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleShadowPartCS3540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleShadowPartCS3592 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleShadowPartCS3604 = new BitSet(new long[]{0xF427FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleShadowPartCS3627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleShadowPartCS3646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_entryRulePatternExpCS3685 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePatternExpCS3695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_rulePatternExpCS3741 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_rulePatternExpCS3754 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_rulePatternExpCS3775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaLiteralExpCS_in_entryRuleLambdaLiteralExpCS3811 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLambdaLiteralExpCS3821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleLambdaLiteralExpCS3858 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleLambdaLiteralExpCS3870 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLambdaLiteralExpCS3891 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleLambdaLiteralExpCS3903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_entryRuleMapLiteralExpCS3939 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapLiteralExpCS3949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_ruleMapLiteralExpCS3995 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleMapLiteralExpCS4007 = new BitSet(new long[]{0xF487FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4029 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_52_in_ruleMapLiteralExpCS4042 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4063 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_55_in_ruleMapLiteralExpCS4079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_entryRuleMapLiteralPartCS4115 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapLiteralPartCS4125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS4171 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_59_in_ruleMapLiteralPartCS4183 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS4204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS4240 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS4250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS4300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS4330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS4360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS4390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS4420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS4450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS4485 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS4495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleTupleLiteralExpCS4532 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleTupleLiteralExpCS4544 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS4565 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_52_in_ruleTupleLiteralExpCS4578 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS4599 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_55_in_ruleTupleLiteralExpCS4613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS4649 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS4659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS4705 = new BitSet(new long[]{0x0020000002000000L});
        public static final BitSet FOLLOW_53_in_ruleTupleLiteralPartCS4718 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS4739 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleTupleLiteralPartCS4753 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS4774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS4810 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS4820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS4865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS4900 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS4910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS4955 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS4991 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS5001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleBooleanLiteralExpCS5044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleBooleanLiteralExpCS5081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS5130 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS5140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleUnlimitedNaturalLiteralExpCS5189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS5225 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS5235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleInvalidLiteralExpCS5284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS5320 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS5330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleNullLiteralExpCS5379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS5415 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS5425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS5475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS5505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralCS5535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS5565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS5600 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS5610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS5660 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS5680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS5717 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS5727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS5772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS5807 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeNameExpCS5817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS5863 = new BitSet(new long[]{0x0040000000000002L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_ruleTypeNameExpCS5885 = new BitSet(new long[]{0x0040000000000002L});
        public static final BitSet FOLLOW_54_in_ruleTypeNameExpCS5898 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTypeNameExpCS5919 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleTypeNameExpCS5931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS5971 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS5981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS6032 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS6062 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleCollectionPatternCS_in_ruleTypeExpCS6092 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS6113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_entryRuleExpCS6150 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpCS6160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_ruleExpCS6211 = new BitSet(new long[]{0x00000007FFFD0002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorName_in_ruleExpCS6244 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleExpCS6265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_ruleExpCS6299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_entryRulePrefixedLetExpCS6334 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedLetExpCS6344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorName_in_rulePrefixedLetExpCS6403 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_rulePrefixedLetExpCS6424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_rulePrefixedLetExpCS6456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_entryRulePrefixedPrimaryExpCS6491 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedPrimaryExpCS6501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorName_in_rulePrefixedPrimaryExpCS6560 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000002080L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_rulePrefixedPrimaryExpCS6581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedPrimaryExpCS6613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS6648 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpCS6658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS6708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS6738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS6768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS6798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS6828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_rulePrimaryExpCS6858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS6888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaLiteralExpCS_in_rulePrimaryExpCS6918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS6948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_rulePrimaryExpCS6978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS7013 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNameExpCS7023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleNameExpCS7069 = new BitSet(new long[]{0x0044000000000002L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleSquareBracketedClauseCS_in_ruleNameExpCS7090 = new BitSet(new long[]{0x0044000000000002L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_ruleNameExpCS7112 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_ruleNameExpCS7134 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_64_in_ruleNameExpCS7154 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleNameExpCS7179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_entryRuleCurlyBracketedClauseCS7217 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCurlyBracketedClauseCS7227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleCurlyBracketedClauseCS7276 = new BitSet(new long[]{0x00800000000000B0L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS7299 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_52_in_ruleCurlyBracketedClauseCS7312 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS7333 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleCurlyBracketedClauseCS7364 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleCurlyBracketedClauseCS7377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_entryRuleRoundBracketedClauseCS7413 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoundBracketedClauseCS7423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleRoundBracketedClauseCS7472 = new BitSet(new long[]{0xF42FFFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_ruleRoundBracketedClauseCS7494 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000060L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS7515 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000060L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_ruleRoundBracketedClauseCS7538 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS7559 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_ruleRoundBracketedClauseCS7584 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS7605 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_51_in_ruleRoundBracketedClauseCS7622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSquareBracketedClauseCS_in_entryRuleSquareBracketedClauseCS7658 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSquareBracketedClauseCS7668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleSquareBracketedClauseCS7705 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS7726 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_52_in_ruleSquareBracketedClauseCS7739 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS7760 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleSquareBracketedClauseCS7774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS7810 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS7820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS7867 = new BitSet(new long[]{0x0020000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_53_in_ruleNavigatingArgCS7881 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS7902 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingArgCS7915 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS7936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleNavigatingArgCS7958 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS7979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleNavigatingArgCS8002 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS8023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS8060 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS8070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleNavigatingBarArgCS8113 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS8147 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_53_in_ruleNavigatingBarArgCS8160 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS8181 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingBarArgCS8194 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS8215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS8255 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS8265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleNavigatingCommaArgCS8308 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS8342 = new BitSet(new long[]{0x0020000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_53_in_ruleNavigatingCommaArgCS8356 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS8377 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingCommaArgCS8390 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS8411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleNavigatingCommaArgCS8433 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS8454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS8493 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS8503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleNavigatingSemiArgCS8546 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS8580 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_53_in_ruleNavigatingSemiArgCS8593 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS8614 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingSemiArgCS8627 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS8648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS8688 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS8698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS8747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS8781 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS8791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleIfExpCS8828 = new BitSet(new long[]{0xF427FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS8851 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleIfExpCS8870 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleIfExpCS8885 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS8906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000A00L});
        public static final BitSet FOLLOW_ruleElseIfThenExpCS_in_ruleIfExpCS8927 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000A00L});
        public static final BitSet FOLLOW_73_in_ruleIfExpCS8940 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS8961 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleIfExpCS8973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElseIfThenExpCS_in_entryRuleElseIfThenExpCS9009 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElseIfThenExpCS9019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleElseIfThenExpCS9056 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS9077 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleElseIfThenExpCS9089 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS9110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS9146 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS9156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleLetExpCS9193 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9214 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_52_in_ruleLetExpCS9227 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9248 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_68_in_ruleLetExpCS9262 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetExpCS9283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS9319 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS9329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS9375 = new BitSet(new long[]{0x0024000002000000L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_ruleLetVariableCS9396 = new BitSet(new long[]{0x0020000002000000L});
        public static final BitSet FOLLOW_53_in_ruleLetVariableCS9410 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS9431 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLetVariableCS9445 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetVariableCS9466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS9502 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS9512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleNestedExpCS9549 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNestedExpCS9570 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleNestedExpCS9582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS9618 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS9628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleSelfExpCS9677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS9713 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS9723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS9769 = new BitSet(new long[]{0x0100000000000002L});
        public static final BitSet FOLLOW_56_in_ruleMultiplicityBoundsCS9782 = new BitSet(new long[]{0x0000000000040040L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS9803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS9841 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityCS9851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleMultiplicityCS9888 = new BitSet(new long[]{0x0000000000140040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS9914 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS9944 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleMultiplicityCS9956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS9992 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS10002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMultiplicityStringCS10046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleMultiplicityStringCS10075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_78_in_ruleMultiplicityStringCS10104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS10155 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS10165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS10211 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
        public static final BitSet FOLLOW_79_in_rulePathNameCS10224 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS10245 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS10283 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS10293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS10344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS10379 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS10389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS10440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS10475 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBindingCS10485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleTemplateBindingCS10522 = new BitSet(new long[]{0x0000000000000030L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS10543 = new BitSet(new long[]{0x0018000000000000L});
        public static final BitSet FOLLOW_52_in_ruleTemplateBindingCS10556 = new BitSet(new long[]{0x0000000000000030L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS10577 = new BitSet(new long[]{0x0018000000000000L});
        public static final BitSet FOLLOW_51_in_ruleTemplateBindingCS10591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS10627 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS10637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS10682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS10719 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameterCS10729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS10775 = new BitSet(new long[]{0x0000000000000002L,0x0000000000050000L});
        public static final BitSet FOLLOW_80_in_ruleTypeParameterCS10789 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS10810 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_ruleTypeParameterCS10823 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS10844 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
        public static final BitSet FOLLOW_82_in_ruleTypeParameterCS10866 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS10887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS10926 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRefCS10936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeRefCS10986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS11016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS11051 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedRefCS11061 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS11110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS11144 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedTypeRefCS11154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypedTypeRefCS11200 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_ruleTypedTypeRefCS11221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS11258 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcardTypeRefCS11268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_78_in_ruleWildcardTypeRefCS11317 = new BitSet(new long[]{0x0000000000000002L,0x0000000000050000L});
        public static final BitSet FOLLOW_80_in_ruleWildcardTypeRefCS11331 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS11352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_82_in_ruleWildcardTypeRefCS11372 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS11393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID11433 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID11444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID11484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID11510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier11556 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier11567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier11613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER11658 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER11669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER11708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL11753 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL11764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL11803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral11848 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral11859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral11898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER11943 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER11954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER11994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleUPPER12018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_entryRuleURI12059 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURI12070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI12109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_synpred66_InternalEssentialOCL6062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_synpred69_InternalEssentialOCL6211 = new BitSet(new long[]{0x00000007FFFD0002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorName_in_synpred69_InternalEssentialOCL6244 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_synpred69_InternalEssentialOCL6265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred76_InternalEssentialOCL6828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_synpred77_InternalEssentialOCL6858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred78_InternalEssentialOCL6888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_synpred80_InternalEssentialOCL6948 = new BitSet(new long[]{0x0000000000000002L});
    }


}